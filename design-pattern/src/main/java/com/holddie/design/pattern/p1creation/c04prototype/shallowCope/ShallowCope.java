package com.holddie.design.pattern.p1creation.c04prototype.shallowCope;

import lombok.SneakyThrows;

/**
 * 浅拷贝
 *
 * @author Thomas Yang
 * @version 1.0
 * @date 2020/8/30 4:18 PM
 */
public class ShallowCope {

    @SneakyThrows
    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = (Person) person1.clone();
        System.out.println(person2.age + " " + person2.score);
        System.out.println(person2.location);

        System.out.println(person1.location == person2.location);
        person1.location.street = "hz";
        System.out.println(person2.location);
    }
}

class Person implements Cloneable {
    int age = 9;
    int score = 100;
    Location location = new Location("bj", 22);

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Location {
    String street;
    int roomNo;

    public Location(String street, int roomNo) {
        this.street = street;
        this.roomNo = roomNo;
    }

    @Override
    public String toString() {
        return "Location{" + "street='" + street + '\'' + ", roomNo=" + roomNo + '}';
    }
}
