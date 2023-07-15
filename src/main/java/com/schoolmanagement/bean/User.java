package com.schoolmanagement.bean;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;

public class User implements Serializable {

    private int id;
    private String name;
    private String email;
    private String mobile;
    private String profilePicture;
    private String password;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public User() {
        // Default constructor
    }

    public User(int id, String name, String email, String mobile, String profilePicture,
            String password, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.profilePicture = profilePicture;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        // Custom serialization code
        out.writeInt(id);
        out.writeObject(name);
        out.writeObject(email);
        out.writeObject(mobile);
        out.writeObject(profilePicture);
        out.writeObject(password);
        out.writeObject(createdAt);
        out.writeObject(updatedAt);
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        // Custom deserialization code
        id = in.readInt();
        name = (String) in.readObject();
        email = (String) in.readObject();
        mobile = (String) in.readObject();
        profilePicture = (String) in.readObject();
        password = (String) in.readObject();
        createdAt = (Timestamp) in.readObject();
        updatedAt = (Timestamp) in.readObject();
    }
}
