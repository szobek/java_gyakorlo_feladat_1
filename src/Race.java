import main.Animal;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Race {

    public void setPoints(Animal[] animals) {

        for (int i = 0; i < animals.length; i++) {
            while (getPointsFromUser("Kérem adja meg a szépség pontszámot ",animals, i,"beauty")){}
            while (getPointsFromUser("Kérem adja meg a viselkedés pontszámot ",animals, i,"behavior")){}
        }

    }

    public Animal searchWinner(Animal[] animals) {
        int point = 0;
        Animal winner = null;
        for (int i = 0; i < animals.length; i++) {
            Animal animal = animals[i];
            int allPoint = animal.getAllPoint();
            if (allPoint > point) {
                point = allPoint;
                winner = animal;
            }
        }
        return winner;
    }

    private boolean getPointsFromUser(String message,Animal[] animals, int i, String t) {
        Scanner scanner = new Scanner(System.in);
        boolean truePoint = true;
        try {

            Animal animal = animals[i];
            System.out.print(message + animal.getName() + " állathoz: ");
            switch (t) {
                case "beauty" -> animal.setBeautyPoint(scanner.nextInt());
                case "behavior" -> animal.setBehaviorPoint(scanner.nextInt());
            }
            truePoint=false;
            animal.calculateAllPoint();
        }catch(InputMismatchException e){
            System.out.println("Hibás pont");
            truePoint=true;
        }
        return truePoint;

    }
    public void createInstance(List regList,Animal[] animals) {
        for (int i=0;i<animals.length;i++) {
            String all = regList.get(i).toString();
            animals[i]=new Animal(all.split("[|]")[0], Integer.parseInt(all.split("[|]")[1]));
        }
    }

}
