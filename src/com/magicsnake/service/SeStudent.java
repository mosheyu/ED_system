package com.magicsnake.service;

import com.magicsnake.data.MapStudent;
import com.magicsnake.data.SetMajor;
import com.magicsnake.entity.EnMajor;
import com.magicsnake.entity.EnStudent;
import com.magicsnake.in.GetInput;
import com.magicsnake.in.VerifyInput;

public class SeStudent implements Services{
    @Override
    public void add() {
        EnStudent enStudent = new EnStudent();
        Integer period = VerifyInput.verifyPeriod();             //获取届数
        String department = VerifyInput.verifyDepartment(period);   //获取院系
        String m =VerifyInput.verifyMajor(period,department);   //获取专业
        EnMajor enMajor = SetMajor.backMajor(period,department,m);  //调用相关方法取出相对应的对象

        enStudent.setStudentEPreiod(period);                                //设置届数
        enStudent.setStudentEDepartment(department);                        //设置院系
        enStudent.setStudentEMajor(m);                                          //设置专业
        enStudent.setStudentEClassNumber(VerifyInput.verifyClassNumber(enMajor));       //设置班级号
        enStudent.setStudentENumber(VerifyInput.verifyStudentNumberNo());               //设置学号
        System.out.println("请输入密码：");
        enStudent.setStudentEPassword(VerifyInput.verifyPassword());                    //设置密码
        System.out.println("请输入姓名：");
        enStudent.setStudentEName(VerifyInput.verifyName());                             //设置姓名
        System.out.println("请输入性别：");
        enStudent.setStudentESex(VerifyInput.verifySex());                               //设置性别
        System.out.println("请输入年龄：");
        enStudent.setStudentEAge(VerifyInput.verifyAge());                              //设置年龄

        MapStudent.add(enStudent);              //调用相关方法添加学生
        System.out.println("添加完成");
    }

    @Override
    public void delete() {
        System.out.println("请输入学号：");
        Integer studentNumber = VerifyInput.verifyStudentNumber();      //获取学生学号
        MapStudent.delete(MapStudent.studentEs.get(studentNumber));                   //调用方法删除学生
        System.out.println("删除完成。");
    }

    @Override
    public void update() {
        System.out.println("请输入学号：");
        Integer studentNumber = VerifyInput.verifyStudentNumber();      //获取学生学号
        EnStudent enStudent =upStudentMenu(studentNumber);          //调用修改方法修改学生信息，返回修改后的学生对象
        MapStudent.update(studentNumber,enStudent);             //调用方法修改学生
        System.out.println("修改完成");
    }

    @Override
    public void select() {
        System.out.println("请输入学号：");
        Integer studentNumber = VerifyInput.verifyStudentNumber();      //获取学生学号
        MapStudent.select(studentNumber);                   //展示学生信息
        System.out.println("查询完成。");
    }


    /**
     *
     * @param studentNumber 学号
     * @return  修改后的学生
     *      传入学号，根据菜单对学号进行修改，返回修改后的学生
     */
    public EnStudent upStudentMenu(Integer studentNumber){
        EnStudent enStudent = MapStudent.studentEs.get(studentNumber);          //获取教师对象
        boolean flag = true;            //循环判断条件
        while (flag){
            System.out.println("请选择你需要修改的属性：");
            System.out.println("1.账号");
            System.out.println("2.密码");
            System.out.println("3.姓名");
            System.out.println("4.性别");
            System.out.println("5.年龄");
            System.out.println("6.成绩");
            System.out.println("0.退出");
            Integer swi = GetInput.getSwitch(6);
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
                    System.out.println("请输入该教师的姓名：");
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
                case 6:
                    scoreUpdate(enStudent);
                    System.out.println("修改结束");
                    continue;
                case 0:flag = false;break;
            }
        }
        return  enStudent;
    }


    public static void scoreUpdate(EnStudent enStudent){
        if (enStudent.getStudentESubjectScore().size() == 0){
            System.out.println("该班级暂无科目");
            return;
        }else {
            System.out.println("请输入科目");
            String subject = VerifyInput.verifyClassSubject(enStudent.getStudentEClassNumber());        //调用方法获取学生所属班级下的一个科目
            System.out.println("请输入分数");
            Integer score = VerifyInput.verifyScore();              //调用方法获取一个分数
            MapStudent.scoreUpdate(enStudent.getStudentENumber(),subject,score);                //调用方法修改分数
        }
    }


}
