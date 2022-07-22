package com.ats.tests;

import com.ats.api.APIRunnerUtil;
import com.ats.helper.CustomAssertion;
import com.ats.helper.PayloadCreator;
import com.ats.pojos.User;
import com.ats.utils.PropertiesFileUtil;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTests {

    private String baseUrl;
    private String healthEndpoint;
    private String createEndpoint;
    private String deleteUserUrl;
    private String getSpecificUserEndpoint;
    private String getAllUsersEndpoint;
    private String deleteUserEndpoint;
    private String getSpecificUserUrl;
    private String createUrl;
    private String getAllUserUrl;

    private String healthUrl;
    PropertiesFileUtil propertiesFileUtil;
    APIRunnerUtil aPIRunnerUtil;

    PayloadCreator payloadCreator;

    @BeforeClass
    public void init(){
        aPIRunnerUtil = new APIRunnerUtil();
        propertiesFileUtil = new PropertiesFileUtil();
        baseUrl = propertiesFileUtil.getValue("baseurl");
        payloadCreator = new PayloadCreator();
        healthEndpoint = propertiesFileUtil.getValue("health.endpoint");
        createEndpoint = propertiesFileUtil.getValue("createuser.endpoint");
        getAllUsersEndpoint = propertiesFileUtil.getValue("getallusers.endpoint");
        getSpecificUserEndpoint = propertiesFileUtil.getValue("specificuser.endpoint");
        deleteUserEndpoint = propertiesFileUtil.getValue("deleteuser.endpoint");
    }

    @Test(priority = 0)
    public void testApplicationHealth(){
        healthUrl = baseUrl+healthEndpoint;
        Response response = aPIRunnerUtil.getRequest(healthUrl);
        int statusCode = response.getStatusCode();
        CustomAssertion.isEqual(statusCode,200,"health endpoint");
    }

    @Test(priority = 1)
    public void testCreateUser(){
        createUrl = baseUrl+createEndpoint;
        User payload = payloadCreator.createUserPayload(12312,"suhail","323345","BXR4556UH","Hyderabad");
        Response response = aPIRunnerUtil.postRequest(createUrl,payload);
        int statusCode = response.getStatusCode();
        CustomAssertion.isEqual(statusCode,200,"create user endpoint");
    }

    @Test(priority = 2)
    public void testGetAllUsers(){
        getAllUserUrl = baseUrl+getAllUsersEndpoint;
        Response response = aPIRunnerUtil.getRequest(getAllUserUrl);
        int statusCode = response.getStatusCode();
        CustomAssertion.isEqual(statusCode,200,"get all users endpoint");
    }

    @Test(priority = 3)
    public void testGetSpecificUser(){
        getSpecificUserUrl = baseUrl+getSpecificUserEndpoint+"/12312";
        Response response = aPIRunnerUtil.getRequest(getSpecificUserUrl);
        int statusCode = response.getStatusCode();
        CustomAssertion.isEqual(statusCode,200,"get specific user endpoint");
    }

    @Test(priority = 4)
    public void testDeleteUser(){
        deleteUserUrl = baseUrl+deleteUserEndpoint+"/12312";
        Response response = aPIRunnerUtil.deleteRequest(deleteUserUrl);
        int statusCode = response.getStatusCode();
        CustomAssertion.isEqual(statusCode,200,"delete user endpoint");
    }

    @Test(priority = 5)
    public void testGetSpecificUserAgain(){
        getSpecificUserUrl = baseUrl+getSpecificUserEndpoint+"/12312";
        Response response = aPIRunnerUtil.getRequest(getSpecificUserUrl);
        int statusCode = response.getStatusCode();
        CustomAssertion.isEqual(statusCode,500,"get specific user endpoint");
    }

}
