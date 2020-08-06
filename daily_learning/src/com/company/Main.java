package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static class Course implements Comparable<Course>{
        int strat;
        int end;

        @Override
        public int compareTo(Course o) {
            return this.strat>o.strat?1:-1;
        }
        public Course(int strat,int end){
            this.strat = strat;
            this.end = end;
        }
    }

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);
        while(true){
            int num=in.nextInt();
            if(num==0)
                break;
            else{
                ArrayList<Course> list=new ArrayList<Course>();

                for(int i=0;i<num;i++){
                    int x=in.nextInt();
                    int y=in.nextInt();
                    list.add(new Course(x,y));
                }
                Collections.sort(list);

                int ans=0;
                //上一个的end
                int lastx=list.get(0).end;
                for(int i=1;i<num;i++){
                    //下一个的strat
                    int b=list.get(i).strat;

                    if(b<lastx){
                        ans++;
                        lastx=list.get(i).end;
                    }
                }
                System.out.println(ans);
            }

        }

    }


}
