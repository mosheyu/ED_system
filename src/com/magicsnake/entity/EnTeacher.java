package com.magicsnake.entity;

import java.util.HashMap;
import java.util.List;

public class EnTeacher {
    private int teacherENumber;                   //教师号
    private int teacherEPassword;                 //教师密码
    private String teacherEName;                  //教师名
    private int teacherAge;                     //教师年龄
    private String teacherESex;                  //教师性别
    private HashMap<Integer, List<String>> teacherSubject;   //教师所教班级与科目


    public EnTeacher() {
    }

    public EnTeacher(int teacherENumber, int teacherEPassword, String teacherEName, int teacherAge, String teacherESex, HashMap<Integer, List<String>> teacherSubject) {
        this.teacherENumber = teacherENumber;
        this.teacherEPassword = teacherEPassword;
        this.teacherEName = teacherEName;
        this.teacherAge = teacherAge;
        this.teacherESex = teacherESex;
        this.teacherSubject = teacherSubject;
    }

    public int getTeacherENumber() {
        return teacherENumber;
    }

    public void setTeacherENumber(int teacherENumber) {
        this.teacherENumber = teacherENumber;
    }

    public int getTeacherEPassword() {
        return teacherEPassword;
    }

    public void setTeacherEPassword(int teacherEPassword) {
        this.teacherEPassword = teacherEPassword;
    }

    public String getTeacherEName() {
        return teacherEName;
    }

    public void setTeacherEName(String teacherEName) {
        this.teacherEName = teacherEName;
    }

    public int getTeacherAge() {
        return teacherAge;
    }

    public void setTeacherAge(int teacherAge) {
        this.teacherAge = teacherAge;
    }

    public String getTeacherESex() {
        return teacherESex;
    }

    public void setTeacherESex(String teacherESex) {
        this.teacherESex = teacherESex;
    }

    public HashMap<Integer, List<String>> getTeacherSubject() {
        return teacherSubject;
    }

    public void setTeacherSubject(HashMap<Integer, List<String>> teacherSubject) {
        this.teacherSubject = teacherSubject;
    }
}
