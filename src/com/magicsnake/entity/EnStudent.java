package com.magicsnake.entity;

import java.util.HashMap;

public class EnStudent {
    private int studentEPreiod;                 //学生届数
    private String studentEDepartment;          //学生院系
    private String studentEMajor;               //学生专业
    private int studentEClassNumber;              //学生班级号
    private int studentENumber;                   //学生号
    private int studentEPassword;                 //学生密码
    private String studentEName;                  //学生名
    private int studentEAge;                     //学生年龄
    private String studentESex;                  //学生性别
    private HashMap<String, Integer> studentESubjectScore;//学生各科成绩


    public EnStudent() {
    }


    public EnStudent(int studentEPreiod, String studentEDepartment, String studentEMajor, int studentEClassNumber, int studentENumber, int studentEPassword, String studentEName, int studentEAge, String studentESex, HashMap<String, Integer> studentESubjectScore) {
        this.studentEPreiod = studentEPreiod;
        this.studentEDepartment = studentEDepartment;
        this.studentEMajor = studentEMajor;
        this.studentEClassNumber = studentEClassNumber;
        this.studentENumber = studentENumber;
        this.studentEPassword = studentEPassword;
        this.studentEName = studentEName;
        this.studentEAge = studentEAge;
        this.studentESex = studentESex;
        this.studentESubjectScore = studentESubjectScore;
    }

    public int getStudentEPreiod() {
        return studentEPreiod;
    }

    public void setStudentEPreiod(int studentEPreiod) {
        this.studentEPreiod = studentEPreiod;
    }

    public String getStudentEDepartment() {
        return studentEDepartment;
    }

    public void setStudentEDepartment(String studentEDepartment) {
        this.studentEDepartment = studentEDepartment;
    }

    public String getStudentEMajor() {
        return studentEMajor;
    }

    public void setStudentEMajor(String studentEMajor) {
        this.studentEMajor = studentEMajor;
    }

    public int getStudentEClassNumber() {
        return studentEClassNumber;
    }

    public void setStudentEClassNumber(int studentEClassNumber) {
        this.studentEClassNumber = studentEClassNumber;
    }

    public int getStudentENumber() {
        return studentENumber;
    }

    public void setStudentENumber(int studentENumber) {
        this.studentENumber = studentENumber;
    }

    public int getStudentEPassword() {
        return studentEPassword;
    }

    public void setStudentEPassword(int studentEPassword) {
        this.studentEPassword = studentEPassword;
    }

    public String getStudentEName() {
        return studentEName;
    }

    public void setStudentEName(String studentEName) {
        this.studentEName = studentEName;
    }

    public int getStudentEAge() {
        return studentEAge;
    }

    public void setStudentEAge(int studentEAge) {
        this.studentEAge = studentEAge;
    }

    public String getStudentESex() {
        return studentESex;
    }

    public void setStudentESex(String studentESex) {
        this.studentESex = studentESex;
    }



    public HashMap<String, Integer> getStudentESubjectScore() {
        return studentESubjectScore;
    }

    public void setStudentESubjectScore(HashMap<String, Integer> studentESubjectScore) {
        this.studentESubjectScore = studentESubjectScore;
    }
}
