package com.magicsnake.menu;

import com.magicsnake.data.MapClass;
import com.magicsnake.data.MapStudent;
import com.magicsnake.data.MapTeacher;
import com.magicsnake.entity.EnTeacher;
import com.magicsnake.in.GetInput;
import com.magicsnake.in.VerifyInput;
import com.magicsnake.service.*;
import com.magicsnake.tools.FormatPrint;

public class MenuTeacher {


    /**
     *
     *
     */
    public static void ShowSwitch(EnTeacher enTea){
        Boolean flag = true;
        Integer x = 0;

        Boolean flag1 = true;
        Integer classNumber = 0;
        while(flag){
            //菜单显示
            FormatPrint.write(2);
            System.out.println("1.课程管理");
            System.out.println("2.修改成绩");
            System.out.println("3.查询成绩");
            System.out.println("4.个人信息");
            System.out.println("0.退出");
            FormatPrint.write(2);
            //输入选项
            x = GetInput.getSwitch(5);
            //调用相应功能
            switch (x){
                case 1:
                    SeSubject subjectSe = new SeSubject();
                    subjectSe.enTeacher = enTea;            //给定教师，只可以管理这个教师下的课程
                    SeMenu.menu("课程",subjectSe);
                    continue;
                case 2:
                    flag1 = true;
                    classNumber = 0;
                    while (flag1){              //选定班级
                        System.out.println("请选择要修改的班级。");
                        classNumber = VerifyInput.verifyClassNumber(enTea);     //选定班级
                        if (MapClass.classEs.get(classNumber).getClassENum() == 0){
                            System.out.println("该班级下暂无可操作学生，请重新选择。");
                        }
                        flag1 = false;      //跳出循环
                    }
                    System.out.println("请选择要修改的学号");
                    Integer studentNumber = VerifyInput.verifyStudentNumber(classNumber);       //选定学生
                    SeStudent.scoreUpdate(MapStudent.studentEs.get(studentNumber));       //调用方法修改科目
                    continue;
                case 3:
                    flag1 = true;
                    classNumber = 0;
                    while (flag1){              //选定班级
                        System.out.println("请选择要修改的班级。");
                        classNumber = VerifyInput.verifyClassNumber(enTea);     //选定班级
                        if (MapClass.classEs.get(classNumber).getClassENum() == 0){
                            System.out.println("该班级下暂无可操作学生，请重新选择。");
                        }
                        flag1 = false;      //跳出循环
                    }
                    MapClass.showSubject(classNumber);                //展示班级信息
                    continue;
                case 4:
                    MapTeacher.select(enTea.getTeacherENumber());            //比较详细的展示教师信息
                    SeTeacher.upTeacherMenu(enTea.getTeacherENumber());     //调用方法修改个人信息
                    continue;
                case 0:flag = false;break;      //跳出循环
            }
        }
    }

}
