package com.magicsnake.data;

import com.magicsnake.entity.EnMajor;
import com.magicsnake.tools.FormatPrint;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetMajor {
    public static Set<EnMajor> EnMajors = new HashSet<>();

    //添加测试数据
    static{
        ArrayList<Integer> EnClassNumber0 = new ArrayList<>();
        EnMajor enMajor0 = new EnMajor(17,"信息工程与技术","计算机科学与技术",EnClassNumber0);

        ArrayList<Integer> EnClassNumber1 = new ArrayList<>();
        EnMajor enMajor1 = new EnMajor(18,"土木工程系","工地搬砖",EnClassNumber1);

        ArrayList<Integer> EnClassNumber2 = new ArrayList<>();
        EnMajor enMajor2 = new EnMajor(17,"城市建设系","盖楼的",EnClassNumber2);

        ArrayList<Integer> EnClassNumber3 = new ArrayList<>();
        EnMajor enMajor3 = new EnMajor(17,"信息工程与技术","英语",EnClassNumber3);

        EnMajors.add(enMajor0);
        EnMajors.add(enMajor1);
        EnMajors.add(enMajor2);
        EnMajors.add(enMajor3);

    }


    /**
     *
     * @return  所有届数集合
     *      遍历所有的专业对象，将届数存储到集合中返回。
     */
    public static ArrayList<Integer> getPeriods(){
        ArrayList<Integer> periods = new ArrayList<>();
        Integer period = 0;                             //用来在Iterator中临时存储数据。
        Iterator<EnMajor> it = EnMajors.iterator();     //获取iterator
        while (it.hasNext()){
            period = it.next().getMajorEPeriod();           //获取专业对象中的届数
            if(!periods.contains(period)){           //判断集合中是否已经添加过该届数,通过list集合自带的contains（）方法
                periods.add(period);                //添加到集合中准备返回
            }
        }
        return periods;
    }


    /**
     *
     * @param period    届数
     * @return  该届数下的院系集合
     *       遍历该届数下所有的专业对象，将院系存储到集合中返回。
     */
    public static ArrayList<String> getDepartments(Integer period){
        ArrayList<String> departments = new ArrayList<>();

        Integer per = 0;
        String department = "";
        EnMajor enMajor = new EnMajor();                          //用来在Iterator中临时存储数据。

        Iterator<EnMajor> it = EnMajors.iterator();
        while (it.hasNext()){
            enMajor = it.next();                            //获取专业对象
            per = enMajor.getMajorEPeriod();                //获取届数
            department = enMajor.getMajorEDepartment();      //获取院系

           if((per == period)
                   &&(!departments.contains(department))){         //判断该专业届数是否符合，是否已经添加过
                   departments.add(department);        //添加到集合中
           }
        }
        return departments;
    }


    /**
     *
     * @param period    届数
     * @param department    院系
     * @return  该届数和院系下的专业集合
     *        遍历该届数、院系下所有的专业对象，将专业存储到集合中返回。
     */
    public static ArrayList<String> getMajor(Integer period,String department){
        ArrayList<String> majors = new ArrayList<>();

        Integer per = 0;
        String depar = "";
        String major = "";
        EnMajor enMajor = new EnMajor();           //用来在Iterator中临时存储数据。

        Iterator<EnMajor> it = EnMajors.iterator();
        while (it.hasNext()){
            enMajor = it.next();
            per = enMajor.getMajorEPeriod();
            depar = enMajor.getMajorEDepartment();
            major = enMajor.getMajorEMajor();

            if((per == period)
                &&(depar.equals(department))
                    &&(!majors.contains(major))){        //判断该专业届数、院系是否符合，是否已经添加过
                majors.add(major);          //添加到集合中
            }
        }
        return majors;
    }

    /**
     *
     * @param enMajor 专业
     *        比较详细的展示专业对象
     */
    public static void showMajor(EnMajor enMajor){
        FormatPrint.write(1);
        System.out.println("届数："+enMajor.getMajorEPeriod());
        System.out.println("院系："+enMajor.getMajorEDepartment());
        System.out.println("专业："+enMajor.getMajorEMajor());
        ArrayList<Integer> EnClassNumber = enMajor.getMajorEClassEList();   //获取该专业下已有的班级
        if (EnClassNumber.size() <=0){
            System.out.println("该专业下暂无班级。");
        }else {
            System.out.println("该专业下班级：");
            Iterator<Integer> it = EnClassNumber.iterator();
            while (it.hasNext()){
                System.out.println("\t班级："+it.next().toString());
            }
        }

    }

    /**
     *
     * @param period    届数
     * @param department    院系
     * @param major     专业
     * @return  set中该对象
     *         在set中查找合适的专业对象并返回
     */
    public static EnMajor backMajor(Integer period,String department,String major){
        EnMajor enMajor = new EnMajor(period,department,major); //运用形参创建对象
        EnMajor enMajor1 = new EnMajor();       //临时存储
        Iterator<EnMajor> it = EnMajors.iterator();
        while (it.hasNext()){
            enMajor1 = it.next();
            if (enMajor.equals(enMajor1)){      //重写了equals（）方法，三个变量相同就是相同的
                return enMajor1;
            }
        }
        return null;        //届数、院系、专业部分加了验证，不会没有改专业对象，所有自信返回null
    }
}
