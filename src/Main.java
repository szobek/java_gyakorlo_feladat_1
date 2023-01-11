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
        Race race = new Race();
        Registration registration = new Registration();
        new Rules();
        regList = registration.readFileFromTxt();
        animals = new Animal[regList.size()];
        race.runRace(regList,animals);

    }


}