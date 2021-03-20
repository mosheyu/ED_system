package com.magicsnake.entity;

import java.util.ArrayList;

public class EnClass {
    private int classEPeriod;                             //届数
    private String classEDepartment;        //院系
    private String classEMajor;              //专业
    private int classENumber;                           //班级号
    private int classENum;                              //班级总人数
    private ArrayList<String> classEsubjects = new ArrayList<String>();         //班级科目数组
    private ArrayList<Integer> classEstudents = new ArrayList<Integer>();         //班级学生号数组

    public EnClass() {
    }

    public EnClass(int classEPeriod, String classEDepartment, String classEMajor, int classENumber, int classENum, ArrayList<String> classEsubjects, ArrayList<Integer> classEstudents) {
        this.classEPeriod = classEPeriod;
        this.classEDepartment = classEDepartment;
        this.classEMajor = classEMajor;
        this.classENumber = classENumber;
        this.classENum = classENum;
        this.classEsubjects = classEsubjects;
        this.classEstudents = classEstudents;
    }

    public int getClassEPeriod() {
        return classEPeriod;
    }

    public void setClassEPeriod(int classEPeriod) {
        this.classEPeriod = classEPeriod;
    }

    public String getClassEDepartment() {
        return classEDepartment;
    }

    public void setClassEDepartment(String classEDepartment) {
        this.classEDepartment = classEDepartment;
    }

    public String getClassEMajor() {
        return classEMajor;
    }

    public void setClassEMajor(String classEMajor) {
        this.classEMajor = classEMajor;
    }

    public int getClassENumber() {
        return classENumber;
    }

    public void setClassENumber(int classENumber) {
        this.classENumber = classENumber;
    }

    public int getClassENum() {
        return classENum;
    }

    public void setClassENum(int classENum) {
        this.classENum = classENum;
    }

    public ArrayList<String> getClassEsubjects() {
        return classEsubjects;
    }

    public void setClassEsubjects(ArrayList<String> classEsubjects) {
        this.classEsubjects = classEsubjects;
    }

    public ArrayList<Integer> getClassEstudents() {
        return classEstudents;
    }

    public void setClassEstudents(ArrayList<Integer> classEstudents) {
        this.classEstudents = classEstudents;
    }




}
