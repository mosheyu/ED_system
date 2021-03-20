package com.magicsnake.in;

import com.magicsnake.tools.FormatPrint;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetInput {

    /**
     *
     * @param x 菜单长度
     * @return  用户选择的菜单项的序号
     *          根据菜单长度，自动生成集合，用来验证用户输入合理性，返回用户输入的序号
     */
    public static Integer getSwitch(Integer x){
        ArrayList<Integer> list = new ArrayList<>();
        while (!(x <0)){       //将0-x的所有整数添加到集合中
            list.add(x);    //将x添加到集合中
            x--;
        }
        System.out.println("请选择一个选项，输入选项序号进行选择");       //提示信息
        x= getInteger();                                           //调用方法getInteger（）获取用户输入一个整数
        while (!list.contains(x)){                                  //判断是否是集合中已存在的整数
            System.out.println("请选择已有的选项。");
            x = getInteger();                                       //如果不是已存在的整数，就循环重新输入，直到输入正确为之
        }
        return x;
    }

    /**
     *
     * @return 整数
     *          单纯返回一个整数，加了校验，防止输入错误的数据类型，如：字符串，浮点数
     */
    public static Integer getInteger(){
        Integer x = 0;
        Scanner scanner = null;
        while (true){
            scanner = new Scanner(System.in);           //循环后重置，不然会报错
            try{
                x = scanner.nextInt();
            }catch (Exception e){
                System.out.println("请输入一个整数。");
                continue;
            }
            break;
        }
        return x;
    }

    /**
     *
     * @return 字符串
     *      返回一个字符串
     */
    public static String getString(){
        String s = "";
        Scanner scanner = null;
        while (true){
            scanner = new Scanner(System.in);           //循环后重置，不然会报错
            try{
                s = scanner.nextLine();
            }catch (Exception e){
                System.out.println("请输入正确的格式。");
                continue;
            }
            break;
        }
        return s;
    }

    /**
     *
     * @return 班级号
     *      返回一个班级号，进行正则校验长度为8位的班级号
     */
    public static Integer getEnClassNumber(){

        Integer classENumber = 0;   //临时存储班级号
        String regEx = "[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]";
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regEx);
        // 忽略大小写的写法
        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(classENumber.toString());
        // 字符串是否与正则表达式相匹配
        boolean rs = matcher.matches();

        Scanner sc = null;
        while (true){
            sc = new Scanner(System.in);
            System.out.println("请输入八位数的班级号。");
            try{
                classENumber = sc.nextInt();
            }catch (Exception e){
                System.out.println("请输入正确格式的班级号。");
                continue;
            }
            matcher = pattern.matcher(classENumber.toString());
            rs  = matcher.matches();

            if (rs!=true){
                System.out.println("请输入八位数字的班级号。");
                FormatPrint.write(1);
                continue;
            }
            break;
        }
        return classENumber;
    }

    /**
     *
     * @return  教师工号
     *      返回一个教师工号，进行正则校验长度为6位的教师工号
     */
    public static Integer getEnTeacherNumber(){
        Integer teacherENumber = 0;   //临时存储班级号
        String regEx = "[0-9][0-9][0-9][0-9][0-9][0-9]";            //6位数字长度的正则表达式
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regEx);
        // 忽略大小写的写法
        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(teacherENumber.toString());
        // 字符串是否与正则表达式相匹配
        boolean rs = matcher.matches();

        Scanner sc = null;
        while (true){
            sc = new Scanner(System.in);
            try{
                teacherENumber = sc.nextInt();
            }catch (Exception e){
                System.out.println("请输入正确格式的班级号。");
                continue;
            }
            matcher = pattern.matcher(teacherENumber.toString());
            rs  = matcher.matches();

            if (rs!=true){
                System.out.println("请输入八位数字的班级号。");
                FormatPrint.write(1);
                continue;
            }
            break;
        }
        return teacherENumber;
    }

    /**
     *
     * @return 学号
     *      返回一个学生学号，进行正则校验长度为10的学生学号
     */
    public static Integer getEnStudentNumber(){
        Integer studentNumber = 0;   //临时存储班级号
        String regEx = "[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]";            //6位数字长度的正则表达式
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regEx);
        // 忽略大小写的写法
        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(studentNumber.toString());
        // 字符串是否与正则表达式相匹配
        boolean rs = matcher.matches();

        Scanner sc = null;
        while (true){
            sc = new Scanner(System.in);
            try{
                studentNumber = sc.nextInt();
            }catch (Exception e){
                System.out.println("请输入正确格式的学号。");
                continue;
            }
            matcher = pattern.matcher(studentNumber.toString());
            rs  = matcher.matches();

            if (rs!=true){
                System.out.println("请输入十位数字的学号。");
                FormatPrint.write(1);
                continue;
            }
            break;
        }
        return studentNumber;
    }

}
