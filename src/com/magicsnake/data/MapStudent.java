package com.magicsnake.data;

import com.magicsnake.entity.EnClass;
import com.magicsnake.entity.EnStudent;
import com.magicsnake.tools.FormatPrint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MapStudent {
    public static HashMap<Integer, EnStudent> studentEs = new HashMap<>();

    static {
        EnStudent enStudent = new EnStudent(17,
                "信息工程与技术",
                "计算机科学与技术",
                11112222,
                1111111112,
                1111111112,
                "巴啦啦小魔仙",
                23,
                "女",
                new HashMap<String,Integer>()
        );
        add(enStudent);
    }


    public static void add(EnStudent enStudent){
        Integer classNumber = enStudent.getStudentEClassNumber();           //获取该学生的班级号
        EnClass enClass = MapClass.classEs.get(classNumber);                //从数据中获取班级对象
        ArrayList<Integer> list = enClass.getClassEstudents();              //从班级中获取学生集合
        //班级中添加学生
        list.add(enStudent.getStudentENumber());                            //将新加入的学生的学号加入到集合中
        //此处list是否需要重新赋值？list取出来的是指针引用还是复制品？            ————因为list是使用get方法获取的，所有需要重新赋值，不然还要set方法干啥？
        enClass.setClassEstudents(list);                                    //将操作后的集合添加到班级对象中
        enClass.setClassENum(enClass.getClassENum()+1);         //班级总人数加一
        //从班级中获取科目，赋值给学生
        ArrayList<String> subjects = enClass.getClassEsubjects();           //取出班级的科目集合
        HashMap<String,Integer> subjectMsp = new HashMap<>();               //临时数据
        if(!(subjects.size() == 0)){                                        //排除班级中科目集合为空
            Iterator<String> it = subjects.iterator();                          //准备遍历
            while (it.hasNext()){
                subjectMsp.put(it.next(),0);                                    //添加科目，成绩，默认成绩为0
            }
        }
        enStudent.setStudentESubjectScore(subjectMsp);                      //给学生添加进去科目集合
        studentEs.put(enStudent.getStudentENumber(),enStudent);             //将学生添加到数据中
    }


    public static void delete(EnStudent enStudent){
        Integer classNumber = enStudent.getStudentEClassNumber();           //获取班级号
        EnClass enClass = MapClass.classEs.get(classNumber);        //获取班级
        ArrayList<Integer> list = enClass.getClassEstudents();      //获取班级下学生的集合
        list.remove(enStudent.getStudentENumber());                     //移除学生
        enClass.setClassEstudents(list);                         //重新赋值给班级
        enClass.setClassENum(enClass.getClassENum()-1);         //班级总人数减一
        studentEs.remove(enStudent.getStudentENumber());    //数据中移除此学生
    }

    public static void update(Integer studentNumber,EnStudent enStudent){
        Integer classNumber = enStudent.getStudentEClassNumber();           //获取班级号
        EnClass enClass = MapClass.classEs.get(classNumber);        //获取班级
        ArrayList<Integer> list = enClass.getClassEstudents();      //获取班级下学生的集合
        list.remove(studentNumber);                     //移除学生
        list.add(enStudent.getStudentENumber());                    //重新加入学生
        //关闭学生的修改科目功能，只可以修改成绩，使用原来的科目成绩集合即可
        studentEs.remove(studentNumber);                //数据中移除旧的学生
        studentEs.put(enStudent.getStudentENumber(),enStudent);             //将学生添加到数据中
    }

    public static void select(Integer studentNumber){
        EnStudent enStudent = studentEs.get(studentNumber);                         //获取学生对象
        FormatPrint.write(1);
        System.out.println("届数："+enStudent.getStudentEPreiod());
        System.out.println("院系："+enStudent.getStudentEDepartment());
        System.out.println("专业："+enStudent.getStudentEMajor());
        System.out.println("班级："+enStudent.getStudentEClassNumber());
        System.out.println("账号："+enStudent.getStudentENumber());
        System.out.println("姓名："+enStudent.getStudentEName());
        System.out.println("性别："+enStudent.getStudentESex());
        System.out.println("年龄："+enStudent.getStudentEAge());
        System.out.println("科目成绩：");

        Integer classNumber = 0;                            //临时存储数据
        String s = "";
        List<String> list = null;

        ArrayList<String> subjects = MapClass.classEs.get(enStudent.getStudentEClassNumber()).getClassEsubjects();      //从班级中获取科目集合
        HashMap<String,Integer> subjectsScores = enStudent.getStudentESubjectScore();                                   //获取学生下存储的成绩
        if(subjects.size() == 0){                           //如果科目为空
            System.out.println("该学生暂无学习科目。");
        }else {
            Iterator<String> it = subjects.iterator();      //准备遍历
            while (it.hasNext()){
                s = it.next();
                System.out.println(s+":"+enStudent.getStudentESubjectScore().get(s));               //根据科目展示科目及成绩。
            }
        }
        FormatPrint.write(1);
    }


    /**
     *
     * @param student   学生学号
     * @param subject   旧科目
     * @param subjectNo 新科目
     *      将指定学号下的旧科目修改为新科目
     */
    public static void subjectUpdate(Integer student,String subject,String subjectNo){
        EnStudent enStudent = MapStudent.studentEs.get(student);            //获取学生对象
        HashMap<String,Integer> subjects = enStudent.getStudentESubjectScore();     //获取科目和分数集合
        Integer score = 0;      //临时存储分数
        score = subjects.get(subject);          //获取分数
        subjects.remove(subject);               //移除旧的科目
        subjects.put(subjectNo,score);          //添加新的科目和旧的分数
        enStudent.setStudentESubjectScore(subjects);        //更新科目和分数集合
    }


    /**
     *
     * @param student   学生学号
     * @param subject   科目
     *     将指定学号下的科目删除
     */
    public static void subjectDelete(Integer student,String subject){
        EnStudent enStudent = MapStudent.studentEs.get(student);            //获取学生对象
        HashMap<String,Integer> subjects = enStudent.getStudentESubjectScore();     //获取科目和分数集合
        subjects.remove(subject);               //移除科目
        enStudent.setStudentESubjectScore(subjects);        //更新科目和分数集合
    }

    /**
     *
     * @param student   学生学号
     * @param subject   科目
     *     给指定学号下添加新的科目
     */
    public static void subjectAdd(Integer student,String subject){
        EnStudent enStudent = studentEs.get(student);           //获取学生
        HashMap<String,Integer> subjects = enStudent.getStudentESubjectScore();         //获取学生下科目和成绩的集合
        subjects.put(subject,0);            //添加新科目，成绩为0
        enStudent.setStudentESubjectScore(subjects);            //更新学生下的科目与成绩的集合
    }

    /**
     *
     * @param student   学号
     * @param subject   科目
     *     控制台打印该学生的该科目及成绩
     */
    public static void subjectSelect(Integer student,String subject){
        EnStudent enStudent = studentEs.get(student);           //获取学生
        HashMap<String,Integer> subjects = enStudent.getStudentESubjectScore();         //获取学生下科目和成绩的集合
        System.out.println("\t科目："+subject+"\t成绩："+subjects.get(subject));
    }



    /**
     *
     * @param studentNumber 学生学号
     * @param subject       科目
     * @param score     分数
     *          根据学号修改该学生下的该科目的成绩
     */
    public static void scoreUpdate(Integer studentNumber,String subject,Integer score){
        EnStudent enStudent = studentEs.get(studentNumber);         //获取学生对象
        HashMap<String,Integer> list = enStudent.getStudentESubjectScore();            //获取学生的科目与分数集合
        list.remove(subject);
        list.put(subject,score);            //修改成绩
        enStudent.setStudentESubjectScore(list);            //更新学生中的成绩
    }



}
