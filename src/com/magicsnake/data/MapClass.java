package com.magicsnake.data;

import com.magicsnake.entity.EnClass;
import com.magicsnake.entity.EnMajor;
import com.magicsnake.tools.FormatPrint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MapClass {
    public static HashMap<Integer, EnClass> classEs = new HashMap<>();

    static {

//        ArrayList<Integer> EnClassNumber0 = new ArrayList<>();
//        EnMajor enMajor0 = new EnMajor(17,"信息工程与技术","计算机科学与技术",EnClassNumber0);

        EnClass enClass = new EnClass(17,
                "信息工程与技术",
                "计算机科学与技术",
                11112222,
                0,
                new ArrayList<String>(),
                new ArrayList<Integer>());
        add(enClass);
        EnClass enClass1 = new EnClass(17,
                "信息工程与技术",
                "计算机科学与技术",
                11113333,
                0,
                new ArrayList<String>(),
                new ArrayList<Integer>());
        add(enClass1);
        EnClass enClass2 = new EnClass(17,
                "信息工程与技术",
                "英语",
                11114444,
                0,
                new ArrayList<String>(),
                new ArrayList<Integer>());
        add(enClass2);
    }


    /**
     *
     * @param enClass   班级
     *        添加一个班级,并且添加到专业对象中
     */
    public static void add(EnClass enClass){
        Integer cN = enClass.getClassENumber();     //班级号
        Integer p = enClass.getClassEPeriod();      //届数
        String d = enClass.getClassEDepartment();   //院系
        String m =enClass.getClassEMajor();         //专业
        EnMajor enMajor = SetMajor.backMajor(p,d,m);      //获取该班级所在的专业对象
//        SetMajor.EnMajors.remove(enMajor);      //移除相应的专业对象
        ArrayList<Integer> list = enMajor.getMajorEClassEList();        //获取专业对象存储班级的集合
        list.add(cN);            //添加该班级
        enMajor.setMajorEClassEList(list);  //重新添加回去，感觉可以省略，目前先加上
//        SetMajor.EnMajors.add(enMajor);     //将修改后的数据添加进去
        classEs.put(cN,enClass);        //添加班级

    }

    /**
     *
     * @param enClassNumber 旧班级号
     * @param enClass   新添加的班级
     *        移除旧的班级，添加新的班级到数据中
     */
    public static void update(Integer enClassNumber,EnClass enClass){
        Integer cN = enClass.getClassENumber();     //班级号
        Integer p = enClass.getClassEPeriod();      //届数
        String d = enClass.getClassEDepartment();   //院系
        String m =enClass.getClassEMajor();         //专业
        EnMajor enMajor = SetMajor.backMajor(p,d,m);      //获取该班级所在的专业对象，通过Iterator遍历判断是这一专业后，返回此对象
//        SetMajor.EnMajors.remove(enMajor);      //移除相应的专业对象
        ArrayList<Integer> list = enMajor.getMajorEClassEList();        //获取专业对象存储班级的集合
        list.remove(enClassNumber);            //在专业中移除以前的班级
        list.add(cN);                          //在专业中将新班级添加
        enMajor.setMajorEClassEList(list);  //重新添加回去，感觉可以省略，目前先加上
//        SetMajor.EnMajors.add(enMajor);     //将修改后的数据添加进去
        classEs.remove(enClassNumber);  //移除班级
        classEs.put(cN,enClass);        //添加班级

    }

    /**
     *
     * @param enClass   班级
     *         移除一个班级，并且在专业对象中移除
     */
    public static void delete(EnClass enClass){
        Integer cN = enClass.getClassENumber();     //班级号
        Integer p = enClass.getClassEPeriod();      //届数
        String d = enClass.getClassEDepartment();   //院系
        String m =enClass.getClassEMajor();         //专业
        EnMajor enMajor = SetMajor.backMajor(p,d,m);      //获取该班级所在的专业对象
//        SetMajor.EnMajors.remove(enMajor);      //移除相应的专业对象
        ArrayList<Integer> list = enMajor.getMajorEClassEList();        //获取专业对象存储班级的集合
        list.remove(cN);            //移除该班级
        enMajor.setMajorEClassEList(list);  //重新添加回去
//        SetMajor.EnMajors.add(enMajor);     //将修改后的数据添加进去
        classEs.remove(cN);  //移除班级
    }

    /**
     *
     * @param classNumber   班级号
     *         根据班级号，比较详细的展示班级信息
     */
    public static void select(Integer classNumber){
        EnClass enClass = classEs.get(classNumber);
        FormatPrint.write(1);
        System.out.println("届数："+enClass.getClassEPeriod());
        System.out.println("院系："+enClass.getClassEDepartment());
        System.out.println("专业："+enClass.getClassEMajor());
        System.out.println("班级号："+enClass.getClassENumber());
        System.out.println("班级总人数："+enClass.getClassENum());
        ArrayList<String> subjects =  enClass.getClassEsubjects();
        if(subjects.size() == 0){                           //如果科目为空
            System.out.println("该班级暂无科目。");
        }else {
            System.out.println("该班级科目如下：");
            Iterator<String> it =subjects.iterator();
            while (it.hasNext()){
                System.out.println("\t"+"科目："+it.next().toString());
            }
        }
        ArrayList<Integer> list = enClass.getClassEstudents();
        if(list.size() == 0){                               //如果学生为空
            System.out.println("该班级下暂无学生。");
        }else {
            System.out.println("该班级有以下学生：");
            Iterator<Integer> it =list.iterator();
            while (it.hasNext()){

                System.out.println("\t"+"学号："+it.next().toString());            //添加学生功能后，此处显示学生的学号，姓名，性别等
            }
        }
        FormatPrint.write(1);
    }

    public static void showSubject(Integer classNumber){
        EnClass enClass = classEs.get(classNumber);
        FormatPrint.write(1);
        ArrayList<String> subjects =  enClass.getClassEsubjects();      //获取科目集合
        ArrayList<Integer> students = enClass.getClassEstudents();      //获取学生集合
        if(subjects.size() == 0){                           //如果科目为空
            System.out.println("该班级暂无科目。");
        }else {
            System.out.println("该班级科目及成绩如下：");
            Iterator<String> it =subjects.iterator();
            Integer studentNumber = 0;
            Iterator<Integer> stu = null;
            while (it.hasNext()){
                stu = students.iterator();
                while (stu.hasNext()){
                    studentNumber = stu.next();                         //获取学号
                    System.out.println("学号："+studentNumber);
                    MapStudent.subjectSelect(studentNumber,it.next());      //根据学号和科目展示成绩
                }
            }
        }
        FormatPrint.write(1);
    }





    /**
     *  @param classNumber   班级号
     * @param list  科目集合
     */
    public static void subjectsDelete(Integer classNumber, List<String> list){
        EnClass enClass = classEs.get(classNumber);             //获取班级
        ArrayList<String> subjects = enClass.getClassEsubjects();       //获取班级已有的科目集合
        Iterator<String> it = list.iterator();                      //准备遍历
        while (it.hasNext()){
            subjects.remove(it.next());                             //移除这门科目
        }
        enClass.setClassEsubjects(subjects);                        //修改后的科目添加进去
        //是否需要把班级重新添加一遍？-----留空
    }

    /**
     *
     * @param classNumber   班级号
     * @param subject   旧的科目
     * @param subjectNo 新的科目
     *      根据班级号，修改该班级下的指定科目
     */
    public static void subjectUpdate(Integer classNumber,String subject,String subjectNo){
        EnClass enClass = classEs.get(classNumber);             //获取该班级
        ArrayList<String> list = enClass.getClassEsubjects();           //获取该班级下的科目集合
        list.remove(subject);               //移除该科目
        list.add(subjectNo);                //添加新科目
        enClass.setClassEsubjects(list);     //更新科目集合
    }


    /**
     *
     * @param classNumber   班级号
     * @param subject   科目
     *       根据班级号，删除该班级下指定科目
     */
    public static void subjectDelete(Integer classNumber,String subject){
        EnClass enClass = classEs.get(classNumber);             //获取该班级
        ArrayList<String> list = enClass.getClassEsubjects();           //获取该班级下的科目集合
        list.remove(subject);               //移除该科目
        enClass.setClassEsubjects(list);     //更新科目集合
    }

    /**
     *
     * @param classNumber   班级号
     * @param subject   科目
     *       根据班级号，添加指定科目
     */
    public static void subjectAdd(Integer classNumber,String subject){
        EnClass enClass = classEs.get(classNumber);             //获取该班级
        ArrayList<String> list = enClass.getClassEsubjects();   //获取该班级的科目集合
        list.add(subject);      //给集合添加科目
        enClass.setClassEsubjects(list);    //更新该班级的科目集合
    }





}
