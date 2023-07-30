package com.akinnova.bankidentityserviceregistry.response;

import java.util.Random;

public class ResponseUtils {
    public static final String CREATED = "201";
    public static final String CREATED_MESSAGE = "%s has been created.";
    public static final String ACCEPTED = "202";
    public static final String REQUEST_ACCEPTED = "Request has been accepted.";
    public static final String FOUND = "302";
    public static final String FOUND_MESSAGE = "%s was found!";
    public static final String NOT_FOUND  = "404";
    public static final String NOT_FOUND_MESSAGE = "%s requested is not found.";
    public static final String ACTIVE = "Active";
    public static final String NON_ACTIVE = "Inactive";


    //Method to generate a User's account number
    public static String generateAccountNumber(int len) {

        String bookRegNumber = ""; //This will contain the user's account
        char[] numChar = new char[len]; //Array created to hold a maximum number accepted as len
        Random randomNumber = new Random();
        int x = 0; //Number to accept new random number generated

        for(int i = 0; i < len; i++){
            x = randomNumber.nextInt(9);
            numChar[i] = Integer.toString(x).toCharArray()[0]; //number generated is converted to character type
        }

        //This will contain the new account number generated
        bookRegNumber = new String(numChar);

        return bookRegNumber.trim();

    }

    //Method to generate a transaction's invoice number
    public static String generateInvoiceNumber(int len, String transactionType) {

        String bookRegNumber = ""; //This will contain the book's registration number
        char[] numChar = new char[len]; //Array created to hold a maximum number accepted as len
        Random randomNumber = new Random();
        int x = 0; //Number to accept new random number generated

        for(int i = 0; i < len; i++){
            x = randomNumber.nextInt(9);
            numChar[i] = Integer.toString(x).toCharArray()[0]; //number generated is converted to character type
        }

        //The transaction number will contain the first 3 characters of the transaction-type which includes hyphen
        // and numbers generated
        bookRegNumber = transactionType.substring(0, 3).toUpperCase() + "-" + new String(numChar);

        return bookRegNumber.trim();

    }

    //Validates name
    public static String isValidName(String name){
        return null;
    }

    //Validates email passed
    public static String isValidEmail(String email){
        return null;
    }

    //Validates phone number
    public static String isValidPhoneNumber(String phoneNumber){
        return null;
    }
    public static String accountType(String accountType){
        if(accountType == "Savings")
            return "Savings";
        return "Current";
    }
}
