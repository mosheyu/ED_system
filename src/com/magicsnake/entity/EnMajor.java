package com.magicsnake.entity;

import java.util.ArrayList;
import java.util.Objects;

public class EnMajor {

    private int majorEPeriod;                //届数
    private String majorEDepartment;        //院系
    private String majorEMajor;              //专业
    private ArrayList<Integer> majorEClassEList;            //班级号集合

    public EnMajor() {
    }

    public EnMajor(int majorEPeriod, String majorEDepartment, String majorEMajor) {
        this.majorEPeriod = majorEPeriod;
        this.majorEDepartment = majorEDepartment;
        this.majorEMajor = majorEMajor;
    }

    public EnMajor(int majorEPeriod, String majorEDepartment, String majorEMajor, ArrayList<Integer> majorEClassEList) {
        this.majorEPeriod = majorEPeriod;
        this.majorEDepartment = majorEDepartment;
        this.majorEMajor = majorEMajor;
        this.majorEClassEList = majorEClassEList;
    }

    public int getMajorEPeriod() {
        return majorEPeriod;
    }

    public void setMajorEPeriod(int majorEPeriod) {
        this.majorEPeriod = majorEPeriod;
    }

    public String getMajorEDepartment() {
        return majorEDepartment;
    }

    public void setMajorEDepartment(String majorEDepartment) {
        this.majorEDepartment = majorEDepartment;
    }

    public String getMajorEMajor() {
        return majorEMajor;
    }

    public void setMajorEMajor(String majorEMajor) {
        this.majorEMajor = majorEMajor;
    }

    public ArrayList<Integer> getMajorEClassEList() {
        return majorEClassEList;
    }

    public void setMajorEClassEList(ArrayList<Integer> majorEClassEList) {
        this.majorEClassEList = majorEClassEList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EnMajor)) return false;
        EnMajor enMajor = (EnMajor) o;
        return majorEPeriod == enMajor.majorEPeriod && majorEDepartment.equals(enMajor.majorEDepartment) && majorEMajor.equals(enMajor.majorEMajor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(majorEPeriod, majorEDepartment, majorEMajor, majorEClassEList);
    }
}
