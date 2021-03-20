package com.magicsnake.tools;

import com.magicsnake.data.MapTeacher;
import com.magicsnake.data.SetMajor;
import com.magicsnake.entity.EnMajor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class DisplayData {


    /**
     * 展示已有的届数
     */
    public static void displayPeriod(){
        String s = "\t";              //临时存储数据
        ArrayList<Integer> list = SetMajor.getPeriods();        //获取已有的届数集合
        Iterator<Integer> it = list.iterator();                 //准备遍历提取届数
        while (it.hasNext()){
            s = s+it.next()+"\t";
        }
        System.out.println("现有以下届数：");
        System.out.println(s);
    }

    /**
     *
     * @param period   届数
     * 展示该届数下已有的院系
     */
    public static void diaplayDepartment(Integer period){
        ArrayList<String> list = SetMajor.getDepartments(period);       //获取该届数下已有的院系集合

        if(list.size()>0){
            Iterator<String> it = list.iterator();                  //准备遍历
            System.out.println("该届现有以下院系");
            while (it.hasNext()){
                System.out.println("\t"+it.next());
            }
        }else {
            System.out.println("该届数下暂无院系。");
        }
    }

    /**
     *
     * @param period    届数
     * @param department    院系
     * 展示该届数、院系下已有的专业
     */
    public static void displayMajor(Integer period,String department){
        ArrayList<String> list = SetMajor.getMajor(period,department);     //获取该届数、院系下已有的专业集合

        if(list.size()>0){
            Iterator<String> it = list.iterator();                  //准备遍历
            System.out.println("该学院有以下专业");
            while (it.hasNext()){
                System.out.println("\t"+it.next());
            }
        }else {
            System.out.println("该学院下暂无专业。");
        }
    }

    /**
     *
     * @param major 专业
     *      展示该专业下已有的班级
     */
    public static void displayClass(EnMajor major){
        ArrayList<Integer> list = major.getMajorEClassEList();     //获取该届数、院系下已有的专业集合

        if(list.size()>0){
            Iterator<Integer> it = list.iterator();                  //准备遍历
            System.out.println("该专业有以下班级：");
            while (it.hasNext()){
                System.out.println("\t"+it.next());
            }
        }else {
            System.out.println("该专业下暂无班级。");
        }
    }

    /**
     * 展示所有的教师号
     */
    public static  void displayTeahcer(){
        Set<Integer> set = MapTeacher.teacherEs.keySet();       //获取已有的教师集合的key集合
        Integer number = 0;                                        //临时存储数据
        String name = "";
        if (set.size() == 0){
            System.out.println("暂时还无教师");
        }else {
            System.out.println("现有以下教师。");
            Iterator<Integer> it = set.iterator();          //准备遍历
            while (it.hasNext()){
                number = it.next();                             //获取职工号
                name = MapTeacher.teacherEs.get(number).getTeacherEName().toString();       //根据职工号获取教师的姓名
                System.out.println("\t工号："+number+"\t姓名："+name);
            }
        }

    }





}
