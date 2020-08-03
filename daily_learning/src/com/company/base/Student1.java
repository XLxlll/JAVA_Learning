package com.company.base;

/**
 * @title: Student1
 * @Author Geek_Ling
 * @Date: 2020/8/3 10:39
 * @Version 1.0
 */
public class Student1 {
    private String name;
    private int age;
    private float score;
    public Student1(String name,int age,float score){
        this.name = name;
        this.age = age;
        this.score = score;
    }
    @Override
    public String toString() {
        return "Student1{" +
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
