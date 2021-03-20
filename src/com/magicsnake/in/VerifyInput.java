package com.magicsnake.in;

import com.magicsnake.data.MapClass;
import com.magicsnake.data.MapStudent;
import com.magicsnake.data.MapTeacher;
import com.magicsnake.data.SetMajor;
import com.magicsnake.entity.EnClass;
import com.magicsnake.entity.EnMajor;
import com.magicsnake.entity.EnTeacher;
import com.magicsnake.tools.DisplayData;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class VerifyInput {

    /**
     *
     * @return  届数
     *      请用户输入，返回一个已有的届数
     */
    public static Integer verifyPeriod(){
        Integer p = 0;          //临时存储届数
        ArrayList<Integer> list = SetMajor.getPeriods();        //获取已有的届数集合
        DisplayData.displayPeriod();                          //展示已有的届数数据
        System.out.println("请输入一个已有的届数：");
        p = GetInput.getInteger();                          //获取用户输入的一个整数
        while (!list.contains(p)){                          //验证输入内容是否为已有的届数
            System.out.println("请输入已存在的届数！");
            p = GetInput.getInteger();                          //重新输入一个届数
        }
        return p;
    }

    /**
     *
     * @param classNumber   班级号
     * @return  科目
     *         根据班级号，获取班级下的一名科目
     */
    public static String verifyClassSubject(Integer classNumber){
        String subject = "";
        EnClass enClass = MapClass.classEs.get(classNumber);        //获取班级对象
        ArrayList<String> list = enClass.getClassEsubjects();       //获取班级下的科目集合
        if (list.size() == 0){
            System.out.println("暂无科目");
            return null;
        }
        System.out.println("请输入一个已有的科目：");
        subject = GetInput.getString();
        while (!list.contains(subject)){                    //验证用户输入内容是否为已有的班级
            System.out.println("请输入已有的科目");
            subject = GetInput.getString();          //重新输入
        }
        return subject;
    }




    /**
     *
     * @param period    届数
     * @return  院系
     *      请用户输入，返回一个已有的院系
     */
    public static String verifyDepartment(Integer period){
        String d = "";          //临时存储院系
        ArrayList<String> list = SetMajor.getDepartments(period);   //获取已有的院系集合
        DisplayData.diaplayDepartment(period);              //展示该届数下已有的院系数据
        System.out.println("请输入一个已有的院系：");
        d = GetInput.getString();                           //获取用户输入的字符串
        while (!list.contains(d)){                          //验证输入内容是否为已有的院系
            System.out.println("请输入已存在的院系！");
            d = GetInput.getString();                       //重新输入
        }
        return d;
    }

    /**
     *
     * @param period    届数
     * @param department 院系
     * @return  专业
     *      请用户输入，返回一个已有的专业
     */
    public static String verifyMajor(Integer period, String department){
        String m = "";          //临时存储专业
        DisplayData.displayMajor(period,department);              //展示该届数、院系下已有的专业数据
        ArrayList<String> list = SetMajor.getMajor(period,department);   //获取已有的专业集合
        System.out.println("请输入一个已有的专业：");
        m = GetInput.getString();                           //获取用户输入的字符串
        while (!list.contains(m)){                          //验证输入内容是否为已有的专业
            System.out.println("请输入已存在的专业！");
            m = GetInput.getString();                       //重新输入
        }
        return m;
    }

    /**
     *
     *
     * @param enMajor   专业对象
     * @return  班级号
     *      根据专业对象，选定下面的一个班级号
     *      因为可能出现专业下为空班级的现象，使用此方法前需要先判空。
     */
    public static Integer verifyClassNumber(EnMajor enMajor){
        Integer classNumber= 0;                     //临时存储数据
        DisplayData.displayClass(enMajor);          //展示该专业下的班级
        ArrayList<Integer> list = enMajor.getMajorEClassEList();    //获取专业下的班级集合
        System.out.println("请输入一个已有的班级：");
        classNumber = GetInput.getEnClassNumber();                  //获取用户输入的班级号
        while (!list.contains(classNumber)){                    //验证用户输入内容是否为已有的班级
            System.out.println("请输入已有的班级");
            classNumber = GetInput.getEnClassNumber();          //重新输入
        }
        return classNumber;
    }

    /**
     *
     * @return 班级号
     *      输入一个已有的班级
     */
    public static Integer verifyClassNumber(){
        Integer classNumber= 0;                     //临时存储数据
        Set<Integer> set = MapClass.classEs.keySet();    //获取班级集合
        System.out.println("请输入一个已有的班级：");
        classNumber = GetInput.getEnClassNumber();                  //获取用户输入的班级号
        while (!set.contains(classNumber)){                    //验证用户输入内容是否为已有的班级
            System.out.println("请输入已有的班级");
            classNumber = GetInput.getEnClassNumber();          //重新输入
        }
        return classNumber;
    }

    /**
     *
     * @param enTeacher 教师
     * @return  班级号
     *          从教师下选定一个班级号
     */
    public static Integer verifyClassNumber(EnTeacher enTeacher){
        Integer classNumber= 0;                     //临时存储数据
        Set<Integer> set = enTeacher.getTeacherSubject().keySet();    //获取班级集合
        System.out.println("请输入一个已有的班级：");
        classNumber = GetInput.getEnClassNumber();                  //获取用户输入的班级号
        while (!set.contains(classNumber)){                    //验证用户输入内容是否为已有的班级
            System.out.println("请输入该教师所授课的班级");
            classNumber = GetInput.getEnClassNumber();          //重新输入
        }
        return classNumber;
    }



    /**
     *
     * @param enTeacher 教师
     * @param classNumber   教师所教班级
     * @return  科目
     *      教师下一个班级中的科目
     */
    public static String verifyTeacherClassSubject(EnTeacher enTeacher,Integer classNumber){
        String subject = "";
        System.out.println("请输入一个已有的科目：");
        List<String> list = enTeacher.getTeacherSubject().get(classNumber);         //获取科目集合
        subject = GetInput.getString();
        while (!list.contains(subject)){                    //验证用户输入内容是否为已有的班级
            System.out.println("请输入已有的科目");
            subject = GetInput.getString();          //重新输入
        }
        return subject;
    }

    /**
     *
     * @param enTeacher 教师
     * @param classNumber   教师下的一个班级
     * @return  新科目
     *      教师下一个班级中新的科目
     */
    public static String verifyTeacherClassSubjectNo(EnTeacher enTeacher,Integer classNumber){
        String subject = "";
        System.out.println("请输入一个新的科目：");
        if(enTeacher.getTeacherSubject().get(classNumber) == null){             //添加科目时，输入班级不确定是否已添加过，进行判定
            subject = GetInput.getString();
            return subject;
        }else {
            List<String> list = enTeacher.getTeacherSubject().get(classNumber);         //获取科目集合
            subject = GetInput.getString();
            while (list.contains(subject)){                    //验证用户输入内容是否为已有的班级
                System.out.println("请输入新的科目");
                subject = GetInput.getString();          //重新输入
            }
            return subject;
        }
    }


    /**
     *
     * @return  已存在的教师工号
     * 获取用户输入一个已有的教师号
     */
    public static Integer verifyTeacherNumber(){
        Integer teacherNumber = 0;                     //临时存储数据
//        DisplayData.displayTeahcer();                   //展示所有教师的工号和姓名
        Set<Integer> set = MapTeacher.teacherEs.keySet();       //获取所有的职工号集合
        teacherNumber = GetInput.getEnTeacherNumber();                 //获取用户输入的教师工号
        while (!set.contains(teacherNumber)){                    //验证用户输入内容是否为已有的教师工号
            System.out.println("请输入已有的教师工号");
            teacherNumber = GetInput.getEnTeacherNumber();           //重新输入
        }
        return teacherNumber;
    }

    /**
     *
     * @return 不存在的教师工号
     * 获取用户输入一个未有的教师号
     */
    public static Integer verifyTeacherNumberNo(){
        Integer teacherNumber = 0;                     //临时存储数据
        DisplayData.displayTeahcer();                   //展示所有教师的工号和姓名
        Set<Integer> set = MapTeacher.teacherEs.keySet();       //获取所有的职工号集合
        teacherNumber = GetInput.getEnTeacherNumber();                 //获取用户输入的教师工号
        while (set.contains(teacherNumber)){                    //验证用户输入内容是否为已有的教师工号
            System.out.println("请输入未有的教师工号");
            teacherNumber = GetInput.getEnTeacherNumber();          //重新输入
        }
        return teacherNumber;
    }

    /**
     *
     * @return 性别
     * 获取用户输入一个性别
     */
    public static String verifySex(){
        String sex = GetInput.getString();                     //获取输入字符串
        while (!(sex.equals("男") || sex.equals("女"))){
            System.out.println("请输入“男”或“女”");
            sex = GetInput.getString();                 //重新输入
        }
        return sex;
    }

    /**
     *
     * @return  年龄
     *  获取用户输入一个年龄，范围区间为15（包含）--65（包含）
     */
    public static Integer verifyAge(){
        Integer age = GetInput.getInteger();        //获取用户输入一个整数
        while (age<=15 || age>=65){
            System.out.println("请输入正确的年龄。");
            age = GetInput.getInteger();
        }
        return  age;
    }

    /**
     *
     * @return  密码
     *  获取用户输入一个密码，密码为数字密码
     */
    public static Integer verifyPassword(){
        return GetInput.getInteger();        //获取用户输入一个整数
    }


    /**
     *
     * @return  姓名
     *  获取用户输入的字符串作为姓名
     */
    public static String verifyName(){
        return GetInput.getString();                //获取用户输入的字符串作为姓名，暂时不加正则验证
    }

    /**
     *
     * @return 学号
     *  获取用户输入的已有的学号
     */
    public static Integer verifyStudentNumber(){
        Integer studentNumber = 0;                     //临时存储数据
        Set<Integer> set = MapStudent.studentEs.keySet();       //获取所有的学号集合
        System.out.println("请输入已有的学号");
        studentNumber = GetInput.getEnStudentNumber();                //获取用户输入的学号
        while (!set.contains(studentNumber)){                    //验证用户输入内容是否为已有的学号
            System.out.println("请输入已有的学号");
            studentNumber = GetInput.getEnStudentNumber();           //重新输入
        }
        return studentNumber;
    }

    /**
     *
     * @return 学号
     *  获取用户输入的新的学号
     */
    public static Integer verifyStudentNumberNo(){
        Integer studentNumber = 0;                     //临时存储数据
        Set<Integer> set = MapStudent.studentEs.keySet();       //获取所有的学号集合
        System.out.println("请输入新的学号");
        studentNumber = GetInput.getEnStudentNumber();                //获取用户输入的学号
        while (set.contains(studentNumber)){                    //验证用户输入内容是否为已有的学号
            System.out.println("请输入新的学号");
            studentNumber = GetInput.getEnStudentNumber();           //重新输入
        }
        return studentNumber;
    }

    /**
     *
     * @return  分数
     *      获取用户输入的一个分数
     */
    public static Integer verifyScore(){
        Integer score = 0;
        System.out.println("请输入一个分数");
        score = GetInput.getInteger();               //获取用户输入的数字
        while (!(0<=score && score<=100)){                    //验证用户输入内容是否为合法数字
            System.out.println("请输入0-100的分数");
            score = GetInput.getInteger();                     //重新输入
        }
        return score;
    }


    /**
     *
     * @param classNumber   班级号
     * @return  学号
     *          根据班级号，获取其下的一个学生，需要提前判空
     */
    public static Integer verifyStudentNumber(Integer classNumber){
        Integer studentNumber = 0;
        System.out.println("请输入学号");
        studentNumber= GetInput.getEnStudentNumber();       //用户输入学号
        ArrayList<Integer> list = MapClass.classEs.get(classNumber).getClassEstudents();        //获取该班级下的学生集合
        while (!(list.contains(studentNumber))){
            System.out.println("请输入该班级下的一个学生。");
            studentNumber= GetInput.getEnStudentNumber();       //重新输入
        }
        return studentNumber;
    }


    /**
     *
     * @return  类型
     *      用户输入登录类型
     */
    public static Integer verifyType(){
        String type = "";
        type = GetInput.getString();
        while(!(type.equals("学生") || type.equals("教师") || type.equals("g"))){
            System.out.println("请输入教师或学生");
            type = GetInput.getString();
        }
        switch (type){
            case "学生":
                return 1;
            case "教师":
                return 2;
            case "g":
                return 3;
            default:
                System.out.println("系统异常。");
                return 1;
        }
    }




}
