import java.util.Calendar;
import java.util.Date;

public class Animal {
    private int age;
    private final String name;
    private int beautyPoint;
    private final int maxAgePoint = 10;
private final int birthYear;


    public Animal( String name, int birthYear) {
        this.name = name;
        this.birthYear=birthYear;
        calculateAge();
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    private void calculateAge(){
        int actualYear = Calendar.getInstance().get(Calendar.YEAR);
        age = actualYear-birthYear;
    }


}
