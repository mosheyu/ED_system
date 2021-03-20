package com.magicsnake.data;

import com.magicsnake.entity.EnClass;
import com.magicsnake.entity.EnTeacher;
import com.magicsnake.tools.FormatPrint;

import java.util.*;

public class MapTeacher {
    public static HashMap<Integer, EnTeacher> teacherEs = new HashMap<>();

    static {
        HashMap<Integer, List<String>> teacherSubject0 = new HashMap<>();
        EnTeacher enTeacher0 = new EnTeacher(111112,
                111112,
                "杨老师",
                23,
                "男",
                teacherSubject0);
        teacherEs.put(111112,enTeacher0);
        subjectAdd(enTeacher0,11112222,"test");
    }


    /**
     *
     * @param enTeacher 新的教师对象
     *        将教师添加到数据中
     */
    public static void add(EnTeacher enTeacher){
        teacherEs.put(enTeacher.getTeacherENumber(),enTeacher);             //添加教师
    }


    /**
     *
     * @param teacherNumber 教师职工号
     *       根据教师职工号删除相应的教师，并且根据教师下的科目，在各个班级删除科目
     */
    public static void delete(Integer teacherNumber){
        EnTeacher enTeacher = teacherEs.get(teacherNumber);             //获取一名教师

        Integer classNumber = 0;                                    //临时存储数据
        List<String> list = null;
        //删除授课班级下的科目
        HashMap<Integer,List<String>> subjects = enTeacher.getTeacherSubject();     //获取科目集合
        if(subjects.size() == 0){                           //如果科目为空
           //科目为空，不需要处理，首次编写在此次写了return，导致没有执行后面代码，造成系统异常。
        }else {
            Set<Integer> classNumbers = subjects.keySet();                           //获取所教的班级的集合
            Iterator<Integer> it = classNumbers.iterator();                          //遍历该教师所教的班级
            while (it.hasNext()){                                                    //遍历该班级所有的科目
                classNumber = it.next();            //获取班级号
                list = subjects.get(classNumber);   //获取科目集合
                MapClass.subjectsDelete(classNumber,list);              //调用方法，删除对应班级下的部分科目
            }
        }
        //删除教师
        teacherEs.remove(teacherNumber);        //移除该教师
    }

    /**
     *
     * @param teacherNumber 旧的教师工号
     * @param enTeacher 修改后的教师对象
     *       根据教师工号删除旧的教师，然后添加新的教师，没有修改科目
     */
    public static void update(Integer teacherNumber,EnTeacher enTeacher){
        teacherEs.remove(teacherNumber);            //移除旧的教师对象
        teacherEs.put(enTeacher.getTeacherENumber(),enTeacher);     //添加新的教师对象
    }
    /**
     *
     * @param teacherNumber 教师工号
     *       比较详细的展示教师信息，需要进行非空校验
     */
    public static void select(Integer teacherNumber){
        EnTeacher enTeacher = teacherEs.get(teacherNumber);             //获取教师对象
        FormatPrint.write(1);
        System.out.println("账号："+enTeacher.getTeacherENumber());
        System.out.println("姓名："+enTeacher.getTeacherEName());
        System.out.println("性别："+enTeacher.getTeacherESex());
        System.out.println("年龄："+enTeacher.getTeacherAge());

        Integer classNumber = 0;                            //临时存储数据
        String s = "";
        List<String> list = null;

        HashMap<Integer,List<String>> subjects = enTeacher.getTeacherSubject();     //获取科目集合
        if(subjects.size() == 0){                           //如果科目为空
            System.out.println("该教师暂无科目。");
        }else {
            System.out.println("该教师授课情况如下：");
            Set<Integer> classNumbers = subjects.keySet();                           //获取所教的班级的集合
            Iterator<Integer> it = classNumbers.iterator();
            while (it.hasNext()){
                s = "";                             //清空数据
                classNumber = it.next();            //获取班级号
                list = subjects.get(classNumber);   //获取科目集合
                for(String n:list ){                //遍历集合
                    s+= n+"\t";                          //将各个科目拼接
                }
                System.out.println("\t"+"班级："+classNumber+"\t科目："+s);           //输出班级以及班级下所授科目
            }
        }

        FormatPrint.write(1);
    }





    public static void subjectAdd(EnTeacher enTeacher,Integer classNumber,String subject){
        HashMap<Integer,List<String>> subjects = enTeacher.getTeacherSubject();     //获取该教师下的科目集合
        if (subjects.get(classNumber) == null){
            List<String> list = new ArrayList<String>();
            list.add(subject);
            subjects.put(classNumber,list );                    //给该集合添加科目
            enTeacher.setTeacherSubject(subjects);              //更新该教师下的授课集合
        }else {
            List<String> list = subjects.get(classNumber);
            list.add(subject);                  //添加科目
            subjects.remove(classNumber);       //移除旧的
            subjects.put(classNumber,list);     //添加新的
            enTeacher.setTeacherSubject(subjects);              //更新该教师下的授课集合
        }
        //给该班级添加科目
        MapClass.subjectAdd(classNumber,subject);       //调用方法添加科目
        //给学生添加科目
        EnClass enClass = MapClass.classEs.get(classNumber);        //获取该班级
        ArrayList<Integer> students = enClass.getClassEstudents();      //获取该班级下的学生集合
        if(!(students.size() == 0)){                                //刨除该班级学生数为空的现象
            Iterator<Integer> it = students.iterator();
            while (it.hasNext()){
                MapStudent.subjectAdd(it.next(),subject);      //调用方法添加该学生下的科目
            }
        }
    }


    /**
     *
     * @param enTeacher 教师对象
     * @param classNumber 班级号
     * @param subject   科目
     *    分别删除教师、班级、学生下的该科目
     */
    public static void subjectDelete(EnTeacher enTeacher,Integer classNumber,String subject){
        HashMap<Integer, List<String>> teacherSubject = enTeacher.getTeacherSubject();      //获取授课班级集合
        List<String> list = teacherSubject.get(classNumber);                //获取该班级下的科目集合
        if (list.size() ==1){
            teacherSubject.remove(classNumber);
        }else {
            list.remove(subject);               //移除已有的一个科目
            teacherSubject.remove(classNumber);             //移除旧的班级科目
            teacherSubject.put(classNumber,list);           //设置新的班级科目
            enTeacher.setTeacherSubject(teacherSubject);    //更新教师下的授课班级集合
        }

        //更新每个学生的该科目
        EnClass enClass = MapClass.classEs.get(classNumber);        //获取该班级
        ArrayList<Integer> students = enClass.getClassEstudents();      //获取该班级下的学生集合
        if(!(students.size() == 0)){                                //刨除该班级学生数为空的现象
            Iterator<Integer> it = students.iterator();
            while (it.hasNext()){
                MapStudent.subjectDelete(it.next(),subject);      //调用方法修改该学生下的科目
            }
        }

        //更新班级的该科目
        MapClass.subjectDelete(classNumber,subject);              //调用方法修改该学生下的科目
    }
    /**
     *
     * @param enTeacher 教师工号
     * @param classNumber   班级号
     * @param subject   旧的科目
     * @param subjectNo 新的科目
     *    分别修改教师、班级、学生下的该科目为新的科目
     */
    public static void subjectUpdate(EnTeacher enTeacher,Integer classNumber,String subject,String subjectNo){
        HashMap<Integer, List<String>> teacherSubject = enTeacher.getTeacherSubject();      //获取授课班级集合
        List<String> list = teacherSubject.get(classNumber);                //获取该班级下的科目集合
        list.remove(subject);               //移除已有的一个科目
        list.add(subjectNo);            //添加新科目
        teacherSubject.remove(classNumber);             //移除旧的班级科目
        teacherSubject.put(classNumber,list);           //设置新的班级科目
        enTeacher.setTeacherSubject(teacherSubject);    //更新教师下的授课班级集合

        //更新每个学生的该科目
        EnClass enClass = MapClass.classEs.get(classNumber);        //获取该班级
        ArrayList<Integer> students = enClass.getClassEstudents();      //获取该班级下的学生集合
        if(!(students.size() == 0)){                                //刨除该班级学生数为空的现象
            Iterator<Integer> it = students.iterator();
            while (it.hasNext()){
                MapStudent.subjectUpdate(it.next(),subject,subjectNo);      //调用方法修改该学生下的科目
            }
        }

        //更新班级的该科目
        MapClass.subjectUpdate(classNumber,subject,subjectNo);              //调用方法修改该学生下的科目
    }

    /**
     *
     * @param enTeacher 教师
     */
    public static void subjectSelect(EnTeacher enTeacher){
        HashMap<Integer, List<String>> list = enTeacher.getTeacherSubject();    //获取科目集合
        Integer classNumber = 0;    //临时存储班级号
        List<String> sub = null;    //临时存储科目集合
        String s = "";              //临时存储科目集合组成的字符串
        Iterator<Integer> it = list.keySet().iterator();
        while (it.hasNext()){
            classNumber = it.next();                //获取班号
            sub = list.get(classNumber);            //获取科目集合
            for(String s1 : sub){
                s +="\t"+s1;
            }
            System.out.println("\t班级号："+classNumber+"\t科目："+s);
            s = "";                     //清空数据
        }
    }



}
