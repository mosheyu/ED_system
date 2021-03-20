package com.magicsnake.service;

import com.magicsnake.data.MapClass;
import com.magicsnake.data.SetMajor;
import com.magicsnake.entity.EnClass;
import com.magicsnake.entity.EnMajor;
import com.magicsnake.in.GetInput;
import com.magicsnake.in.VerifyInput;

import java.util.ArrayList;

public class SeClass implements Services {
    public EnMajor seEnMajor = null;
    @Override
    public void add() {
//        check();
        EnClass enClass = new EnClass();
        enClass = enClassMajorUp(enClass);                      //添加专业属性
        enClass = enClassNumberUp(enClass);                     //添加班级号
        enClass.setClassENum(0);                                //设置学生总人数
        enClass.setClassEsubjects(new ArrayList<String>());     //设置科目
        enClass.setClassEstudents(new ArrayList<Integer>());    //设置学生
        MapClass.add(enClass);                                  //添加班级
    }

    @Override
    public void delete() {
        check();
        ArrayList<Integer> list = seEnMajor.getMajorEClassEList();      //获取专业下的班级集合
        if(list == null || list.size() == 0){
            System.out.println("该专业下暂无可以操作的班级。");
            return;
        }
        Integer classNumber = VerifyInput.verifyClassNumber(seEnMajor);     //用户选择一个班级
        MapClass.delete(MapClass.classEs.get(classNumber));                 //调用班级的删除方法，删除班级
        System.out.println("删除班级。");
    }

    @Override
    public void update() {
        check();
        ArrayList<Integer> list = seEnMajor.getMajorEClassEList();      //获取专业下的班级集合
        if(list == null || list.size() == 0){
            System.out.println("该专业下暂无可以操作的班级。");
            return;
        }
        Integer classNumber = VerifyInput.verifyClassNumber(seEnMajor);     //用户选择一个班级
        System.out.println("当前班级信息");
        MapClass.select(classNumber);          //展示班级信息
        EnClass enClass = upClassMenu(classNumber);                     //修改后的班级对象
        MapClass.update(classNumber,enClass);            //调用班级的修改方法，修改班级
        System.out.println("修改成功。");
    }

    @Override
    public void select() {
        check();
        ArrayList<Integer> list = seEnMajor.getMajorEClassEList();      //获取专业下的班级集合
        if(list == null || list.size() == 0){                      //验证该专业下起码有一个班级
            System.out.println("该专业下暂无可以操作的班级。");
            return;
        }
        Integer classNumber = VerifyInput.verifyClassNumber(seEnMajor);     //用户选择一个班级
        MapClass.select(classNumber);                //展示班级信息
        System.out.println("查询结束");
    }

    public void check() {
//        if (seEnMajor == null || seEnMajor.getMajorEMajor() == null || seEnMajor.getMajorEMajor().equals("")){      //判断专业对象未初始化
            System.out.println("请先输入要操作的班级的所在届数、院系、专业！");
            //选择一个届数
            Integer period = VerifyInput.verifyPeriod();
            //选择一个院系
            String department = VerifyInput.verifyDepartment(period);
            //选择一个专业
            String  major = VerifyInput.verifyMajor(period,department);
            //根据已经选好的届数、院系、专业返回具体的专业对象
            seEnMajor = SetMajor.backMajor(period,department,major);
//        }
    }


    /**
     *
     * @param classNumberOld    选定一个班级
     *        传入班级号，修改班级
     */
    public EnClass upClassMenu(Integer classNumberOld){
        EnClass enClass = MapClass.classEs.get(classNumberOld);
//        System.out.println("开始修改班级。");
//        System.out.println("哐当~哐当~哐当~哐当~哐当~哐当~哐当~哐当~哐当~哐当~");
//        System.out.println("我已经狠狠的修理它了，修改结束。");
//        暂时空下。
        boolean flag = true;            //循环判断条件
        while (flag){
            System.out.println("请选择你需要修改的属性：");
            System.out.println("1.班级号。");
            System.out.println("2.班级所在专业。");
            System.out.println("0.退出");
            Integer swi = GetInput.getSwitch(2);
            switch (swi){
                case 1:
                    enClass = enClassNumberUp(enClass);
                    System.out.println("修改结束");
                    continue;
                case 2:
                    enClass = enClassMajorUp(enClass);
                    System.out.println("修改结束");
                    continue;
                case 0:flag = false;break;
            }
        }
        return enClass;
    }

    /**
     *
     * @param enClass   要修改的班级
     * @return  修改后的班级
     *          传入一个班级，添加专业属性
     */
    public EnClass enClassMajorUp(EnClass enClass){
        Integer p = VerifyInput.verifyPeriod();             //获取届数
        String d = VerifyInput.verifyDepartment(p);         //获取院系
        String m = VerifyInput.verifyMajor(p,d);            //获取专业
        enClass.setClassEPeriod(p);                         //设置届数、院系、专业
        enClass.setClassEDepartment(d);
        enClass.setClassEMajor(m);
        return enClass;                                     //返回班级
    }

    /**
     *
     * @param enClass    要修改的班级
     * @return      修改后的班级
     *          传入一个班级，修改班级号
     */
    public EnClass enClassNumberUp(EnClass enClass){
        Integer classNumber= 0;                     //临时存储数据
        System.out.println("请输入一个暂未添加的班级号：");
        classNumber = GetInput.getEnClassNumber();                  //获取用户输入的班级号
        while(!(MapClass.classEs.get(classNumber) == null)){                    //验证用户输入内容是否为已有的班级
            System.out.println("请输入暂未添加的班级号。");
            classNumber = GetInput.getEnClassNumber();          //重新输入
        }
        enClass.setClassENumber(classNumber);               //添加班级号，也可是修改班级号
        return enClass;
    }



















}
