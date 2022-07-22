package com.ats.helper;

import com.ats.pojos.User;

public class PayloadCreator {

    public User createUserPayload(int userId, String userName, String aadharId, String panNumber, String city){
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setAadharId(aadharId);
        user.setPanNumber(panNumber);
        user.setCity(city);
        return user;
    }
}
