package main;

import javax.xml.crypto.Data;
import java.util.Calendar;
import java.util.UUID;

public class Animal implements Comparable<Animal> {
    private int age;
    private final String name;
    private int beautyPoint;
    private int behaviorPoint;
    private final int maxAgePoint = 10;
private final int birthYear;
private int allPoint;


    private String uniqueID;


    public Animal( String name, int birthYear) {
        this.name = name;
        this.birthYear=birthYear;
        this.uniqueID= UUID.randomUUID().toString();
        calculateAge();
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setBeautyPoint(int beautyPoint) {
        this.beautyPoint = beautyPoint;
    }

    public void setBehaviorPoint(int behaviorPoint) {
        this.behaviorPoint = behaviorPoint;
    }

    public int getAllPoint() {
        return allPoint;
    }

    public void calculateAllPoint(){
        allPoint = ((maxAgePoint-age)*beautyPoint)+(age*behaviorPoint);
    }
    private void calculateAge(){
        int actualYear = Calendar.getInstance().get(Calendar.YEAR);
        age = actualYear-birthYear;
    }

    @Override
    public int compareTo(Animal o) {
        return o.getAllPoint()-this.allPoint ;
    }
}
