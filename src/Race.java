import main.Animal;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Race {

    public void setPoints(List animals) {

        for (int i = 0; i < animals.size(); i++) {
            while (getPointsFromUser("Kérem adja meg a szépség pontszámot ",animals, i,"beauty")){}
            while (getPointsFromUser("Kérem adja meg a viselkedés pontszámot ",animals, i,"behavior")){}
        }

    }

    public Animal searchWinner(List animals) {
        int point = 0;
        Animal winner = null;
        for (int i = 0; i < animals.size(); i++) {
            Animal animal = (Animal) animals.get(i);
            int allPoint = animal.getAllPoint();
            if (allPoint > point) {
                point = allPoint;
                winner = animal;
            }
        }
        return winner;
    }

    private boolean getPointsFromUser(String message,List animals, int i, String t) {
        Scanner scanner = new Scanner(System.in);
        boolean truePoint = true;
        try {

            Animal animal = (Animal) animals.get(i);
            System.out.print(message + animal.getName() + " állathoz: ");
            switch (t){
                case "beauty":
                    animal.setBeautyPoint(scanner.nextInt());
                    break;
                case "behavior":
                    animal.setBehaviorPoint(scanner.nextInt());
                    break;

            }
            truePoint=false;
            animal.calculateAllPoint();
        }catch(InputMismatchException e){
            System.out.println("Hibás pont");
            truePoint=true;
        }
        return truePoint;

    }
    public void createInstance(List regList, List animals) {
        for(int i = 0;i< regList.size();i++){
            String all = regList.get(i).toString();
            animals.add(new Animal(all.split("[|]")[0],Integer.parseInt(all.split("[|]")[1])));
        }
    }

}