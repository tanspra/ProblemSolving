package org.dsa.custom;

public class Test {
    public static void main(String[] args) {
        CustomHashMap<Integer, String> map = new CustomHashMapImpl<>();
        map.insert(1,"Ram");
        map.insert(2,"suresh");
        map.insert(3,"mahesh");
        map.insert(4,"shyam");
        map.insert(5,"ganesh");

        System.out.println(map.getSize());
        System.out.println(map.get(4));
        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.getSize());
    }
}
