package com.magicsnake.service;

import com.magicsnake.data.MapTeacher;
import com.magicsnake.entity.EnTeacher;
import com.magicsnake.in.GetInput;
import com.magicsnake.in.VerifyInput;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class SeTeacher implements Services{
    @Override
    public void add() {
        System.out.println("请输入一个新工号（6位整数组成）：");
        Integer userName = VerifyInput.verifyTeacherNumberNo();           //获取职工号
        System.out.println("请输入账号的密码：");
        Integer password = VerifyInput.verifyPassword();                  //获取密码
        System.out.println("请输入该教师的姓名：");
        String name = VerifyInput.verifyName();                             //获取姓名
        System.out.println("请输入性别：");
        String sex = VerifyInput.verifySex();                               //获取性别
        System.out.println("请输入年龄");
        Integer age = VerifyInput.verifyAge();                              //获取年龄
        EnTeacher enTeacher = new EnTeacher(userName,password,name,age,sex,new HashMap<Integer, List<String>>());   //创建一个新的教师
        MapTeacher.add(enTeacher);                                          //添加教师到数据中
        System.out.println("添加成功。");
    }

    @Override
    public void delete() {
        Set<Integer> set = MapTeacher.teacherEs.keySet();       //获取所有的职工号集合
        if(set == null || set.size() == 0){                      //验证该专业下起码有一个班级
            System.out.println("暂无教师。");
            return;
        }
        Integer teacherNumber = VerifyInput.verifyTeacherNumber();      //用户选择一个职工号
        //开始删除
        MapTeacher.delete(teacherNumber);                   //调用方法删除教师，以及授课
        System.out.println("删除结束");
    }

    @Override
    public void update() {
        Set<Integer> set = MapTeacher.teacherEs.keySet();       //获取所有的职工号集合
        if(set == null || set.size() == 0){                      //验证该专业下起码有一个班级
            System.out.println("暂无教师。");
            return;
        }
        System.out.println("请选择一位教师。");
        Integer teacherNumber = VerifyInput.verifyTeacherNumber();      //用户选择一个职工号
        EnTeacher enTeacher = upTeacherMenu(teacherNumber);             //调用修改的菜单对教师进行修改
        MapTeacher.update(teacherNumber,enTeacher);                     //调用方法进行修改
        System.out.println("修改成功。");
    }

    @Override
    public void select() {
        Set<Integer> set = MapTeacher.teacherEs.keySet();       //获取所有的职工号集合
        if(set == null || set.size() == 0){                      //验证该专业下起码有一个班级
            System.out.println("暂无教师。");
            return;
        }
        System.out.println("请选择一位教师。");
        Integer teacherNumber = VerifyInput.verifyTeacherNumber();      //用户选择一个职工号
        MapTeacher.select(teacherNumber);                          //比较详细的展示教师信息
        System.out.println("查询结束");
    }



    /**
     *
     * @param teacherNumber 教师工号
     * @return  修改后的教师对象
     *      根据教师工号获取对象，然后选择对应功能，对教师进行修改
     */
    public static EnTeacher upTeacherMenu(Integer teacherNumber){
        EnTeacher enTeacher = MapTeacher.teacherEs.get(teacherNumber);          //获取教师对象
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
                    System.out.println("请输入一个新工号（6位整数组成）：");
                    enTeacher.setTeacherENumber( VerifyInput.verifyTeacherNumberNo());           //获取职工号
                    System.out.println("修改结束");
                    continue;
                case 2:
                    System.out.println("请输入账号的密码：");
                    enTeacher.setTeacherEPassword( VerifyInput.verifyPassword());                  //获取密码
                    System.out.println("修改结束");
                    continue;
                case 3:
                    System.out.println("请输入该教师的姓名：");
                    enTeacher.setTeacherEName( VerifyInput.verifyName());                             //获取姓名
                    System.out.println("修改结束");
                    continue;
                case 4:
                    System.out.println("请输入性别：");
                    enTeacher.setTeacherESex( VerifyInput.verifySex());                               //获取性别
                    System.out.println("修改结束");
                    continue;
                case 5:
                    System.out.println("请输入年龄");
                    enTeacher.setTeacherAge(VerifyInput.verifyAge());                              //获取年龄
                    System.out.println("修改结束");
                    continue;
                case 0:flag = false;break;
            }
        }
        return enTeacher;
    }






}
