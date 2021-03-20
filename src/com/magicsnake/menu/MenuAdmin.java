package com.magicsnake.menu;

import com.magicsnake.in.GetInput;
import com.magicsnake.service.*;
import com.magicsnake.tools.FormatPrint;

public class MenuAdmin {


    public static void ShowSwitch(){
        Boolean flag = true;
        Integer x = 0;
        while(flag){
            //菜单显示
            FormatPrint.write(2);
            System.out.println("1.专业管理");
            System.out.println("2.班级管理");
            System.out.println("3.老师管理");
            System.out.println("4.学生管理");
            System.out.println("5.科目管理");
            System.out.println("0.退出");
            FormatPrint.write(2);
            //输入选项
            x = GetInput.getSwitch(5);
            //调用相应功能
            switch (x){
                case 1:
                    SeMenu.menu("专业",new SeMajor());
                    continue;           //switch没有continue,但是有break，所以continue可以用，break只能跳出break
                case 2:
                    SeMenu.menu("班级",new SeClass());
                    continue;
                case 3:
                    SeMenu.menu("教师",new SeTeacher());
                    continue;
                case 4:
                    SeMenu.menu("学生",new SeStudent());
                    continue;
                case 5:
                    SeMenu.menu("科目",new SeSubject());
                    continue;
                case 0:flag = false;break;      //跳出循环
            }
        }
    }
}
