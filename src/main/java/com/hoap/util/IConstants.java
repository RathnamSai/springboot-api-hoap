package com.hoap.util;

public class IConstants {
    public static String POSTGRES_POOL = "PostgresPool";
    public static String DECRYPT_KEY = "APP_KEY";
    public static String JWT_KEY = "JWT_KEY";
    //Error Code
    public static int ERROR_CODE_ZERO_SUCCESS = 0;
    public static int ERROR_CODE_ONE_DATA_NOT_FOUND = 1;
    public static int ERROR_CODE_TWO_USER_NOT_AUTHORIZED = 2;
    public static int ERROR_CODE_THREE_DATA_ADD_FAILURE = 3;
    public static int ERROR_CODE_FOUR_DATA_UPDATE_FAILURE = 4;
    public static int ERROR_CODE_FIVE_DATA_DELETE_FAILURE = 5;
    public static int ERROR_CODE_SIX_EXCEPTION = 6;
    public static int ERROR_CODE_SEVEN_USER_ID_NOT_DB = 7;
    public static int ERROR_CODE_EIGHT = 8;
    public static int ERROR_CODE_NINE = 9;
    public static int ERROR_CODE_TEN_FIELD_ERROR = 10;
    public static int ERROR_CODE_ELEVEN_DATA_DELETE_FAILURE = 11;
    public static int ERROR_CODE_JWT_CREATE_FAILURE = 12;

    public static String FORGOT_PASSWORD_RESET_USER_NOT_EXISTS = "User doesn't exists for User Id: ";
    public static String USER_NOT_REGISTERED_MSG = " User is not registered successfully! :";
    public static String USER_EXISTS_IN_USER_DB = " User Id is already exists in USER Table for user: ";
}
