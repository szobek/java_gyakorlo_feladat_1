import main.Animal;
import readme.Rules;
import reg.Registration;

import java.util.*;

public class Main {
    Animal[] animals;

   List regList = new ArrayList<>();

    public static void main(String[] args) {

new Main().run();
    }

    private void run() {
        Race race =new Race();
        Registration registration = new Registration();
        new Rules();
        regList= registration.readFileFromTxt();
        animals=new Animal[regList.size()];
        race.createInstance(regList,animals);
        race.setPoints(animals);

        for (int i = 0; i < animals.length; i++) {
            System.out.println("Név: " + animals[i].getName() + ", kor: " + animals[i].getAge() + ", összes pont: " + animals[i].getAllPoint());
        }
        Animal winner = race.searchWinner(animals);
        System.out.println("A győztes: "+ winner.getName()+" "+winner.getAllPoint()+" ponttal. ");
        race.writeReverseByAllPoint(animals);
    }






}