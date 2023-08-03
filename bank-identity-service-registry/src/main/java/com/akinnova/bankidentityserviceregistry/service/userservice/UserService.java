package com.akinnova.bankidentityserviceregistry.service.userservice;

import com.akinnova.bankidentityserviceregistry.dto.userdto.UserCreateDto;
import com.akinnova.bankidentityserviceregistry.dto.userdto.UserDeleteDto;
import com.akinnova.bankidentityserviceregistry.dto.userdto.UserUpdateDto;
import com.akinnova.bankidentityserviceregistry.entity.Account;
import com.akinnova.bankidentityserviceregistry.entity.UserEntity;
import com.akinnova.bankidentityserviceregistry.entity.UserRole;
import com.akinnova.bankidentityserviceregistry.exception.ApiException;
import com.akinnova.bankidentityserviceregistry.repository.AccountRepository;
import com.akinnova.bankidentityserviceregistry.repository.RoleRepository;
import com.akinnova.bankidentityserviceregistry.repository.UserRepository;
import com.akinnova.bankidentityserviceregistry.response.ResponsePojo;
import com.akinnova.bankidentityserviceregistry.response.ResponseUtils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final RestTemplate restTemplate;

    //Class Constructor
    public UserService(UserRepository userRepository, AccountRepository accountRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponsePojo<UserEntity> createUser(UserCreateDto userDto) {
        boolean userExist = userRepository.existsByEmail(userDto.getEmail());

        //Check that user does not exist...else, throw an exception
        if (userExist)
            throw new ApiException(ResponseUtils.FOUND);

        UserEntity user = UserEntity.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .otherName(userDto.getOtherName())
                .gender(userDto.getGender())
                .dateOfBirth(userDto.getDateOfBirth())
                .home_address(userDto.getHome_address())
                .stateOfOrigin(userDto.getStateOfOrigin())
                .uniqueId(ResponseUtils.generateAccountNumber(7))
                .phoneNumber(userDto.getPhoneNumber())
                .alternativeNumber(userDto.getAlternativeNumber())
                .email(userDto.getEmail())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .accountType(userDto.getAccountType())
                .userStatus(ResponseUtils.ACTIVE)
                .createdBy(userDto.getCreatedBy())
                .createdAt(LocalDateTime.now())
                .build();

        UserEntity userToReturn = userRepository.save(user);

        //Also create Account of user
        Account newAccount = Account.builder()
                .uniqueId(userToReturn.getUniqueId())
                .firstName(userToReturn.getFirstName())
                .lastName(userToReturn.getLastName())
                .otherName(userToReturn.getOtherName())
                .accountNumber(ResponseUtils.generateAccountNumber(10))
                .AccountType(ResponseUtils.accountType(userToReturn.getAccountType()))
                .accountBalance(BigDecimal.valueOf(0))
                .accountStatus(ResponseUtils.ACTIVE)
                .createdBy(userDto.getCreatedBy())
                .createdAt(LocalDateTime.now())
                .build();

        //Save account to account repository
        accountRepository.save(newAccount);

        //To save User Role in Role repository
        UserRole userRole = UserRole.builder()
                .role(userDto.getRole())
                .build();
        roleRepository.save(userRole);

        // TODO: 7/29/2023 Email service will be used here (By a call to Notification Service)

        ResponsePojo<UserEntity> responsePojo = new ResponsePojo<>();
        responsePojo.setMessage("User added");
        responsePojo.setData(userToReturn);

        return responsePojo;
    }

    @Override
    public ResponseEntity<?> fetchAllUsers() {
        List<UserEntity> userList = userRepository.findAll();
        //Using lambda expression to filter only users whose status reads ACTIVE
        List<UserEntity> collect = userList.stream().filter(x -> x.getUserStatus().equals(ResponseUtils.ACTIVE))
                .collect(Collectors.toList());
        //if there are no users, respond likewise
        if(collect.isEmpty())
            return new ResponseEntity<>("There are no users yet", HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(collect, HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<?> findUserByUniqueId(String id) {
        Optional<UserEntity> userOptional = userRepository.findByUniqueId(id);
        //if user does not exist, throws an exception
        userOptional.orElseThrow(()-> new ApiException(String.format("User with this id: %s does not exist", id)));
        //User to return
        UserEntity user = userOptional.get();

        //checking that IN-ACTIVE USERS ARE NOT CALLED
        if(user.getUserStatus().equals(ResponseUtils.NON_ACTIVE))
            return new ResponseEntity<>(String.format("Account of this user with id: %s has been deactivated.", id),
                    HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @Override
    public ResponseEntity<?> findUserByEmail(String email) {
        Optional<UserEntity> userOptional = userRepository.findByEmail(email);

        //throw an exception if user does not exist
        userOptional.orElseThrow(()-> new ApiException(String.format("User with this email: %s does not exist.", email)));
        UserEntity user = userOptional.get();
        //User to return
        //checking that IN-ACTIVE USERS ARE NOT CALLED
        if(user.getUserStatus().equals(ResponseUtils.NON_ACTIVE))
            return new ResponseEntity<>(String.format("Account of this user with email: %s has been deactivated.",
                    email), HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Override
    public ResponsePojo<UserEntity> updateUserDetail(UserUpdateDto userDto) {
        //Check for user detail by account number
        Optional<UserEntity> userOptional = userRepository.findByEmail(userDto.getEmail());
        userOptional.orElseThrow(()-> new ApiException(String.format("User with email: %s does not exist",
                userDto.getEmail())));

        //User to update
        UserEntity user = userOptional.get();
        //If user has been deactivated, respond likewise
        if(user.getUserStatus().equals(ResponseUtils.NON_ACTIVE))
            throw new ApiException("User with this account has been deactivated");

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setOtherName(userDto.getOtherName());
        user.setHome_address(userDto.getHome_address());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setAlternativeNumber(userDto.getAlternativeNumber());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setModifiedBy(userDto.getModifiedBy());
        user.setModifiedAt(LocalDateTime.now());
        user.setUserStatus(ResponseUtils.ACTIVE);

        //Save to repository
        UserEntity userToReturn = userRepository.save(user);

        //Also update Account details of user
        Optional<Account> accountOptional = accountRepository.findByUniqueId(user.getUniqueId());
        accountOptional.orElseThrow(()-> new ApiException("Account with this Id does not exist"));

        Account newAccount = accountOptional.get();
        newAccount.setFirstName(userToReturn.getFirstName());
        newAccount.setLastName(userToReturn.getLastName());
        newAccount.setOtherName(userToReturn.getOtherName());
        newAccount.setModifiedBy(userDto.getModifiedBy());
        newAccount.setModifiedAt(LocalDateTime.now());

        //Save changes to account repository
        accountRepository.save(newAccount);

        // TODO: 7/29/2023  Email should be sent to user to notify user of update (by a call to Notification Service)

        ResponsePojo<UserEntity> responsePojo = new ResponsePojo<>();
        responsePojo.setMessage("User has been updated successfully");
        responsePojo.setData(userToReturn);

        return responsePojo;
    }

    @Override
    public ResponseEntity<?> deleteUserDetail(UserDeleteDto userDeleteDto) {

        //Find user by account number
        Optional<UserEntity> userEntityOptional = userRepository.findByUniqueId(userDeleteDto.getUniqueId());

        //If user with unique id does exist, throw an exception
        userEntityOptional.orElseThrow(()-> new ApiException(String.format("User with unique id: %s does not exist",
                userDeleteDto.getUniqueId())));

        UserEntity userToDelete = userEntityOptional.get();
        //Only alter user status of user
        userToDelete.setUserStatus(ResponseUtils.NON_ACTIVE);
        userToDelete.setModifiedBy(userDeleteDto.getDeleteBy());
        userToDelete.setModifiedAt(LocalDateTime.now());

        //Save to repository
        userRepository.save(userToDelete);

        //Retrieve account of user and de-activate user's account
        //Also update Account details of user
        Optional<Account> accountOptional = accountRepository.findByUniqueId(userToDelete.getUniqueId());
        accountOptional.orElseThrow(()-> new ApiException("Account with this Id does not exist"));

        Account accountToDeActivate = accountOptional.get();
        accountToDeActivate.setAccountStatus(ResponseUtils.NON_ACTIVE);

        //Save 'update' to repository
        accountRepository.save(accountToDeActivate);

        return new ResponseEntity<>("User deleted", HttpStatus.ACCEPTED);
    }
}
