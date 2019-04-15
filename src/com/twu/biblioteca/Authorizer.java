package com.twu.biblioteca;

public class Authorizer {

    public User validateCredentials(String id, String password) {
        User user = getUserWithId(id);
        if (user != null && user.validPassword(password)) {
            return user;
        }
        return null;
    }

    private User getUserWithId(String id) {
        if (id.equals("123-1234")) {
            return new User("123-1234", "password123", "John Doe", "john@tw.com", "012345");
        }
        return null;
    }
}
