package com.magicsnake.service;

import com.magicsnake.data.MapTeacher;
import com.magicsnake.entity.EnTeacher;
import com.magicsnake.in.VerifyInput;

import java.util.HashMap;
import java.util.List;

public class SeSubject implements Services{
    public EnTeacher enTeacher = null;
    @Override
    public void add() {
        check();
        Integer classNumber = VerifyInput.verifyClassNumber();          //获取班级号,已存在的班级号即可
        String subjectNo = VerifyInput.verifyTeacherClassSubjectNo(enTeacher,classNumber);          //获取新的科目
        MapTeacher.subjectAdd(enTeacher,classNumber,subjectNo);
        System.out.println("添加结束");
    }

    @Override
    public void delete() {
        check();
        HashMap<Integer, List<String>> list = enTeacher.getTeacherSubject();    //获取科目集合
        if (list.size() == 0){
            System.out.println("该教师暂未授课");
            return;
        }else {
            Integer classNumber = VerifyInput.verifyClassNumber(enTeacher);          //获取班级号
            System.out.println("请输入要删除的科目");
            String subject = VerifyInput.verifyTeacherClassSubject(enTeacher,classNumber);            //获取科目
            MapTeacher.subjectDelete(enTeacher,classNumber,subject);            //调用方法删除该科目
        }
        System.out.println("删除结束");
    }

    @Override
    public void update() {
        check();
        HashMap<Integer, List<String>> list = enTeacher.getTeacherSubject();    //获取科目集合
        if (list.size() == 0){
            System.out.println("该教师暂未授课");
            return;
        }else {
            Integer classNumber = VerifyInput.verifyClassNumber(enTeacher);          //获取班级号
            System.out.println("请输入要修改的科目");
            String subject = VerifyInput.verifyTeacherClassSubject(enTeacher,classNumber);            //获取科目
            String subjectNo = VerifyInput.verifyTeacherClassSubjectNo(enTeacher,classNumber);          //获取新的科目
            MapTeacher.subjectUpdate(enTeacher,classNumber,subject,subjectNo);      //调用方法修改科目
        }
        System.out.println("修改结束");
    }

    @Override
    public void select() {
        check();
        if ( enTeacher.getTeacherSubject().size() == 0){            //检查该教师授课班级是否为空
            System.out.println("该教师暂未授课");
            return;
        }else {
            MapTeacher.subjectSelect(enTeacher);                    //调用方法展示教师下的班级信息
        }
        System.out.println("查询结束");
    }

    private void check(){
        if (enTeacher == null){
            Integer teacherNumber = VerifyInput.verifyTeacherNumber();      //获取一个已有的教师用户
            enTeacher = MapTeacher.teacherEs.get(teacherNumber);            //赋值对象
        }
    }


}
