package org.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RawNumber2<T extends Number>{
    List<Integer>[] arrayList = new ArrayList[]{new ArrayList()};
    //type erasure cannot overload
//    public void print(Set<String> set){
//
//    }
//    public void print(Set<Integer> intSet){
//
//    }

   public void test(){
       try{

       }catch(Exception e){

       }

       try{

       }catch(Exception e){

       }finally {

       }
       try{

       }finally{

       }

       Comparator comparator=new Comparator() {
           @Override
           public int compare(Object o1, Object o2) {
               return 0;
           }
       };
       comparator.compare("a","b");
   }
}
