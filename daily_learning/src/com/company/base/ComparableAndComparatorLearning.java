package com.company.base;

import java.util.*;

/**
 * @title: ComparableAndComparatorLearning
 * @Author Geek_Ling
 * @Date: 2020/8/3 9:42
 * @Version 1.0
 */
public class ComparableAndComparatorLearning {

    /**
     * @description
     * @param args
     * @return void
     * @author Geek_Ling
     * @date 2020/8/4
     *
     * ======排序前=====
     * Student{name='A', age=19, score=99.0}
     * Student{name='B', age=20, score=99.0}
     * Student{name='C', age=19, score=100.0}
     * Student{name='D', age=19, score=98.0}
     * ==========Comparable实现排序===============
     * B  Comparable A
     * C  Comparable B
     * C  Comparable B
     * C  Comparable A
     * D  Comparable A
     * D  Comparable B
     * Student{name='C', age=19, score=100.0}
     * Student{name='A', age=19, score=99.0}
     * Student{name='B', age=20, score=99.0}
     * Student{name='D', age=19, score=98.0}
     * ============Comparator实现排序=============
     * B==Comparator==A
     * C==Comparator==B
     * D==Comparator==C
     * D==Comparator==B
     * D==Comparator==A
     * Student1{name='D', age=17, score=98.0}
     * Student1{name='A', age=18, score=99.0}
     * Student1{name='B', age=20, score=99.0}
     * Student1{name='C', age=21, score=100.0}
     */


    public static void main(String[] args) {
        Student student = new Student("A",19,99);
        Student student1 = new Student("B",20,99);
        Student student2 = new Student("C",19,100);
        Student student3 = new Student("D",19,98);
        Student[] students = {student,student1,student2,student3};
        System.out.println("======排序前=====");
        for (Student s:
                students) {
            System.out.println(s.toString());
        }
        System.out.println("==========Comparable实现排序===============");
        Arrays.sort(students);
        for (Student s:
             students) {
            System.out.println(s.toString());
        }

        System.out.println("============Comparator实现排序=============");
        Student1 student01 = new Student1("A",18,99);
        Student1 student11 = new Student1("B",20,99);
        Student1 student21 = new Student1("C",21,100);
        Student1 student31 = new Student1("D",17,98);
        Student1[] students1 = {student01,student11,student21,student31};
        Arrays.sort(students1, new Comparator<Student1>() {
            //A B 这样的顺序的话，o1是这里的B，o2是这里的A，o1.getAge() - o2.getAge()>0 不交换A B的位置，那么升序
            @Override
            public int compare(Student1 o1, Student1 o2) {
                System.out.println(o1.getName()+"==Comparator=="+o2.getName());
                return o1.getAge() - o2.getAge();
            }
        });
        for (Student1 s1:
             students1) {
            System.out.println(s1.toString());
        }
    }
}
