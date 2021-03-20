package com.magicsnake.service;

import com.magicsnake.in.GetInput;
import com.magicsnake.tools.FormatPrint;

public class SeMenu {

    /**
     *
     * @param s 服务名称
     * @param service   服务接口
     *                  服务名称展示菜单项，服务接口调用相应的服务方法
     */
    public static void menu(String s,Services service){
        boolean flag = true;    //while永真循环判断条件，用来跳出循环
        Integer inputInt = 0;   //存储输入输入内容，不方便定义在循环中

        while (flag){
            show(s);            //展示菜单项，供用户选择
            inputInt = GetInput.getSwitch(4);       //调用方法，获取用户输入选项
            switch (inputInt){
                case 1:service.add();continue;         //调用服务的add()方法
                case 2:service.delete();continue;      //调用服务的delete()方法
                case 3:service.update();continue;      //调用服务的update()方法
                case 4:service.select();continue;      //调用服务的select方法
                case 0:flag = false;break;              //修改判断条件，跳出循环
            }
        }
    }

    /**
     *
     * @param s 服务名
     *          根据服务名称，展示相应的菜单项
     */
    public static void show(String s){
        FormatPrint.write(1);
        System.out.println("1.添加"+s);
        System.out.println("2.删除"+s);
        System.out.println("3.修改"+s);
        System.out.println("4.查询"+s);
        System.out.println("0.退出");
        FormatPrint.write(1);
    }





}
