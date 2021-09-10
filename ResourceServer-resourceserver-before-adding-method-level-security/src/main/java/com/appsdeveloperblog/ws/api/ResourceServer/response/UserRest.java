package com.appsdeveloperblog.ws.api.ResourceServer.response;

public class UserRest {
    private String firstName;
    private String lastName;
    private String userId;

    public UserRest(String firstName, String lastName, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserId() {
        return userId;
    }
}
