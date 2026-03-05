package org.test;

public class Lion implements Forest.WildAnimal{
    public String name;
    public void roar(){
        System.out.println(name + ": roar");
    }
}
