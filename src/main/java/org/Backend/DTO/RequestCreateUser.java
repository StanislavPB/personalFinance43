package org.Backend.DTO;

public class RequestCreateUser {
    private String name;
    private String password;

    public RequestCreateUser(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "RequestCreateUser{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
