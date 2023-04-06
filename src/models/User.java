package models;

public class User {
    int id;
    String email;
    String password;
    String fullName;
    String roleId;

    public User() {
    }

    public User(int id, String email, String password, String fullName, String roleId) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.roleId = roleId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}

