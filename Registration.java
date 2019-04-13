package com.company;

public class Registration {
    int ID;
    String task_name;
    String Type;
    String name;
    String username;
    String passwd;
    String DOB;
    String address;
    String department;

    public Registration(int ID, String task_name, String type, String name, String username, String passwd, String DOB, String address, String department) {
        this.ID = ID;
        this.task_name = task_name;
        Type = type;
        this.name = name;
        this.username = username;
        this.passwd = passwd;
        this.DOB = DOB;
        this.address = address;
        this.department = department;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
