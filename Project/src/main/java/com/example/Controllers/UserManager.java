package com.example.Controllers;

import com.example.Models.Student;

public class UserManager {
    private static UserManager instance;
    private Student activeStudent;

    private UserManager() {
        // Private constructor to prevent external instantiation
    }

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public Student getActiveStudent() {
        return activeStudent;
    }

    public void setActiveStudent(Student student) {
        this.activeStudent = student;
    }
}
