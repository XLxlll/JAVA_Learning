package com.company.base;

/**
 * @title: Student
 * @Author Geek_Ling
 * @Date: 2020/8/3 9:46
 * @Version 1.0
 */
public class Student implements Comparable<Student>{
    private String name;
    private int age;
    private float score;
    public Student(String name,int age,float score){
        this.name = name;
        this.age = age;
        this.score = score;
    }
    /**
     * @description 实现了Comparable接口的类要重写compareTo(T o)方法
     * 排序由-1,0,1及 被比较的两个参数的顺序有关系
     * -1 的话，交换位置
     * 0 1 不变
     * @param o
     * @return int
     * @author Geek_Ling
     * @date 2020/8/3
     */

    @Override
    public int compareTo(Student o) {
        System.out.println(this.name+" == "+o.name);
        //A B比较的话 this指的是B，o指的是A，B的score>A的score的话，返回-1交换位置，也就是说降序
       if (this.score > o.score){
           return -1;
       }else if (this.score < o.score){
           return 1;
       }else {
           //如果A B分数相等，那么如果B的age > A的age的话，0/1的话不交换位置，那么就是说升序
           if (this.age > o.age){
               return 1;
           }else if (this.age < o.age){
               return -1;
           }else {
               return 0;
           }
       }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
