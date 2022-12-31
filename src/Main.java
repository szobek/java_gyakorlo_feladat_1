import main.Animal;
import reg.Registration;

import java.util.*;

public class Main {
    List<Animal> animals = new ArrayList<Animal>();

   List regList = new ArrayList<>();

    public static void main(String[] args) {

new Main().run();
    }

    private void run() {
        Race race =new Race();
        Registration registration = new Registration();
        regList= registration.readFileFromTxt();
        createInstance();
        race.setPoints(animals);

        for (int i = 0; i < animals.size(); i++) {
            System.out.println("Név: " + animals.get(i).getName() + ", kor: " + animals.get(i).getAge() + ", összes pont: " + animals.get(i).getAllPoint());
        }
        Animal winner = race.searchWinner(animals);
        System.out.println("A győztes: "+ winner.getName()+" "+winner.getAllPoint()+" ponttal. ");
    }


    private void createInstance() {
        for(int i = 0;i< regList.size();i++){
            String all = regList.get(i).toString();
            animals.add(new Animal(all.split("[|]")[0],Integer.parseInt(all.split("[|]")[1])));
        }
    }




}