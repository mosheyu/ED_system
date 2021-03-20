package com.magicsnake.menu;

import com.magicsnake.data.MapClass;
import com.magicsnake.data.MapStudent;
import com.magicsnake.entity.EnStudent;
import com.magicsnake.in.GetInput;
import com.magicsnake.in.VerifyInput;
import com.magicsnake.tools.FormatPrint;

import java.util.ArrayList;
import java.util.Iterator;

public class MenuStudent {
    public static void ShowSwitch(EnStudent enStu){

        Boolean flag = true;
        Integer x = 0;
        Integer classNumber = 0;
        ArrayList<String> subjects = null;
        while(flag){
            //菜单显示
            FormatPrint.write(2);
            System.out.println("1.课程查询");
            System.out.println("2.成绩查询");
            System.out.println("3.个人信息");
            System.out.println("0.退出");
            FormatPrint.write(2);
            //输入选项
            x = GetInput.getSwitch(3);
            //调用相应功能
            switch (x){
                case 1:
                    classNumber = enStu.getStudentEClassNumber();       //获取班级号
                    subjects = MapClass.classEs.get(classNumber).getClassEsubjects();     //获取科目集合
                    if (subjects.size() == 0){
                        System.out.println("暂无科目");
                        return;
                    }else {
                        Iterator<String> it = subjects.iterator();
                        System.out.println("科目：");
                        while (it.hasNext()){
                            System.out.println("\t"+it.next());         //展示科目
                        }
                    }
                    continue;
                case 2:
                    classNumber = enStu.getStudentEClassNumber();       //获取班级号
                    subjects = MapClass.classEs.get(classNumber).getClassEsubjects();     //获取科目集合
                    if (subjects.size() == 0){
                        System.out.println("暂无科目");
                        return;
                    }else {
                        Iterator<String> it = subjects.iterator();
                        System.out.println("科目及成绩：");
                        while (it.hasNext()){
                            MapStudent.subjectSelect(enStu.getStudentENumber(),it.next());       //展示科目
                        }
                    }
                    continue;
                case 3:
                    MapStudent.select(enStu.getStudentENumber());           //比较详细的展示学生信息
                    upStudentMenu(enStu.getStudentENumber());         //调用方法修改个人信息
                    continue;
                case 0:flag = false;break;      //跳出循环
            }
        }
    }



    public static EnStudent upStudentMenu(Integer studentNumber){
        EnStudent enStudent = MapStudent.studentEs.get(studentNumber);          //获取教师对象
        boolean flag = true;            //循环判断条件
        while (flag){
            System.out.println("请选择你需要修改的属性：");
            System.out.println("1.账号");
            System.out.println("2.密码");
            System.out.println("3.姓名");
            System.out.println("4.性别");
            System.out.println("5.年龄");
            System.out.println("0.退出");
            Integer swi = GetInput.getSwitch(5);
            switch (swi){
                case 1:
                    System.out.println("请输入一个新学号（10位整数组成）：");
                    enStudent.setStudentENumber(VerifyInput.verifyStudentNumberNo());       //获取学号
                    System.out.println("修改结束");
                    continue;
                case 2:
                    System.out.println("请输入账号的密码：");
                    enStudent.setStudentEPassword(VerifyInput.verifyPassword());                  //获取密码
                    System.out.println("修改结束");
                    continue;
                case 3:
                    System.out.println("请输入姓名：");
                    enStudent.setStudentEName(VerifyInput.verifyName());                             //获取姓名
                    System.out.println("修改结束");
                    continue;
                case 4:
                    System.out.println("请输入性别：");
                    enStudent.setStudentESex(VerifyInput.verifySex());                               //获取性别
                    System.out.println("修改结束");
                    continue;
                case 5:
                    System.out.println("请输入年龄");
                    enStudent.setStudentEAge(VerifyInput.verifyAge());                              //获取年龄
                    System.out.println("修改结束");
                    continue;
                case 0:flag = false;break;
            }
        }
        return  enStudent;
    }
}
