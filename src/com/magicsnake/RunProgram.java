package com.magicsnake;

import com.magicsnake.data.MapClass;
import com.magicsnake.data.MapStudent;
import com.magicsnake.data.MapTeacher;
import com.magicsnake.data.SetMajor;
import com.magicsnake.in.VerifyInput;
import com.magicsnake.menu.MenuAdmin;
import com.magicsnake.menu.MenuStudent;
import com.magicsnake.menu.MenuTeacher;

public class RunProgram {
    public static void main(String[] args){

        /**
         * 测试数据
         * 管理员类型：g
         *  教师类型：教师
         *          账号：111112               5个1加2
         *          密码：111112
         *  学生类型：学生
         *          账号：1111111112           9个1加2
         *          密码：1111111112
         *   班级：11112222
         *   专业：
         *      届数：17
         *      院系：信息工程与技术
         *      专业：计算机科学与技术
         */
       new SetMajor();
       new MapClass();
       new MapTeacher();
       new MapStudent();

        System.out.println("请输入用户类型（学生或教师）");
        Integer number =0;
        Integer password = 0;
        switch (VerifyInput.verifyType()){
            case 1:
                System.out.println("请输入账号");
                number = VerifyInput.verifyStudentNumber();
                System.out.println("请输入密码");
                password = VerifyInput.verifyPassword();
                while (!(MapStudent.studentEs.get(number).getStudentEPassword() == password)){
                    System.out.println("密码错误，请重新输入密码");
                    password = VerifyInput.verifyPassword();
                }
                MenuStudent.ShowSwitch(MapStudent.studentEs.get(number));
                break;
            case 2:
                System.out.println("请输入账号");
                number = VerifyInput.verifyTeacherNumber();
                System.out.println("请输入密码");
                password = VerifyInput.verifyPassword();
                while (!(MapTeacher.teacherEs.get(number).getTeacherEPassword() == password)){
                    System.out.println("密码错误，请重新输入密码");
                    password = VerifyInput.verifyPassword();
                }
                MenuTeacher.ShowSwitch(MapTeacher.teacherEs.get(number));
                break;
            case 3:
                MenuAdmin.ShowSwitch();
                break;
        }




    }
}
