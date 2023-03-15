package com.csi.constant;

public class EndPointConstant {

    public static final String SIGN_UP = "/signup";

    public static final String SIGN_IN = "/signin/{empEmailId}/{empPassword}";

    public static final String GET_DATA_BY_ID = "/getdatabyid/{empId}";

    public static final String GET_ALL_DATA = "/getalldata";

    public static final String GET_DATA_BY_NAME = "/getdatabyname/{empFirstName}";

    public static final String GET_DATA_BY_CONTACT_NUMBER = "/getdatabycontactnumber/{empContactNumber}";

    public static final String GET_DATA_BY_EMAIL_Id = "/getdatabyemailid/{empEmailId}";

    public static final String GET_DATA_BY_FIRST_NAME_AND_LAST_NAME = "/getdatabyfirstnameandlastname/{empFirstName}/{empLastName}";

    public static final String GET_DATA_BY_ANY_INPUT = "/getdatabyanyinput/{input}";

    public static final String GET_DATA_BY_DOB = "/getdatabydob/{empDOB}";

    public static final String SORT_BY_AGE = "/sortbyage";

    public static final String SORT_BY_SALARY = "/sortbysalary";

    public static final String SORT_BY_NAME = "/sortbyname";

    public static final String FILTER_BY_SALARY ="/filterbysalary/{empSalary}";

    public static final String CHECK_LOAN_ELIGIBILITY = "/checkloaneligibility/{empId}";

    public static final String SAVE_BULK_OF_DATA = "/savebulkofdata";

    public static final String UPDATE_DATA = "/updatedata/{empId}";

    public static final String DELETE_BY_ID = "/deletebyid/{empId}";

    public static final String DELETE_ALL = "/deleteall";
}
