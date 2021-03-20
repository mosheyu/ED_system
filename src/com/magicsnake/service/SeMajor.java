package com.magicsnake.service;

import com.magicsnake.data.SetMajor;
import com.magicsnake.entity.EnMajor;
import com.magicsnake.in.GetInput;
import com.magicsnake.in.VerifyInput;
import com.magicsnake.tools.DisplayData;
import com.magicsnake.tools.FormatPrint;

import java.util.ArrayList;

public class SeMajor implements Services {

    private Integer period = 0;         //届数
    private String department ="";      //院系

    @Override
    public void add() {
        FormatPrint.write(2);
        System.out.println("开始添加专业对象。");
        Integer p = VerifyPeriodNo();       //获取一个未存在的届数
        String d = VerifyDepartmentNo(p);      //获取一个未存在的院系
        String m = VerifyMajorNo(p,d);          //获取一个未存在的专业
        SetMajor.EnMajors.add(new EnMajor(p,d,m,new ArrayList<>()));    //添加专业
        System.out.println("添加成功");
    }

    @Override
    public void delete() {
        check();
        String mOld =VerifyInput.verifyMajor(period,department);   //获取一个已存在的专业
        EnMajor enMajor = SetMajor.backMajor(period,department,mOld);  //调用相关方法取出相对应的对象
        SetMajor.EnMajors.remove(enMajor);      //移除相应的专业对象
        System.out.println("删除成功");
    }

    @Override
    public void update() {
        check();
        String mOld =VerifyInput.verifyMajor(period,department);   //获取一个已存在的专业
        String mNew = VerifyMajorNo(period,department);          //获取一个未存在的专业
        EnMajor enMajor = SetMajor.backMajor(period,department,mOld);  //调用相关方法取出相对应的对象
        SetMajor.EnMajors.remove(enMajor);      //移除相应的专业对象
        enMajor.setMajorEMajor(mNew);       //修改相对应的专业
        SetMajor.EnMajors.add(enMajor);     //将修改后的数据添加进去
        System.out.println("修改成功");
    }

    @Override
    public void select() {
        check();
        String m =VerifyInput.verifyMajor(period,department);   //获取一个已存在的专业
        EnMajor enMajor = SetMajor.backMajor(period,department,m);  //调用相关方法取出相对应的对象
        SetMajor.showMajor(enMajor);  //展示专业信息
        System.out.println("查询结束");
    }


    public void check() {
//       if(department == null || department.equals("")){
           System.out.println("请先输入要操作的专业的所在届数以及院系！");
           //选择一个届数
           period = VerifyInput.verifyPeriod();
           //选择一个院系
           department = VerifyInput.verifyDepartment(period);
//       }
    }

    /**
     *
     * @return  任意一个届数
     */
    public Integer VerifyPeriodNo(){
        Integer p = 0;          //临时存储届数
        ArrayList<Integer> list = SetMajor.getPeriods();        //获取已有的届数集合
        DisplayData.displayPeriod();                          //展示已有的届数数据
        System.out.println("请输入届数：");
        p = GetInput.getInteger();                          //获取用户输入的一个整数
        return p;
    }

    /**
     *
     * @param period    届数
     * @return     任意一个院系
     */
    public  String VerifyDepartmentNo(Integer period){
        String d = "";          //临时存储院系
        ArrayList<String> list = SetMajor.getDepartments(period);   //获取已有的院系集合
        DisplayData.diaplayDepartment(period);              //展示该届数下已有的院系数据
        System.out.println("请输入院系：");
        d = GetInput.getString();                           //获取用户输入的字符串
        return d;
    }

    /**
     *
     * @param period    届数
     * @param department    院系
     * @return      未存在的专业
     */
    public static String VerifyMajorNo(Integer period,String department){
        String m = "";          //临时存储专业
        ArrayList<String> list = SetMajor.getDepartments(period);   //获取已有的专业集合
        DisplayData.displayMajor(period,department);              //展示该届数、院系下已有的专业数据
        System.out.println("请输入一个未存在的专业：");
        m = GetInput.getString();                           //获取用户输入的字符串
        while (list.contains(m)){                          //验证输入内容是否为已有的专业
            System.out.println("请输入未存在的专业！");
            m = GetInput.getString();                       //重新输入
        }
        return m;
    }






}
