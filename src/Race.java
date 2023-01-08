import main.Animal;

import java.util.*;

public class Race {

    public void setPoints(Animal[] animals) {

        for (int i = 0; i < animals.length; i++) {
            while (getPointsFromUser("Kérem adja meg a szépség pontszámot ", animals, i, "beauty")) {
            }
            while (getPointsFromUser("Kérem adja meg a viselkedés pontszámot ", animals, i, "behavior")) {
            }
        }

    }

    public Animal searchWinner(Animal[] animals) {
        int point = 0;
        Animal winner = animals[0];
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

    private boolean getPointsFromUser(String message, Animal[] animals, int i, String t) {
        Scanner scanner = new Scanner(System.in);
        boolean truePoint = true;
        try {

            Animal animal = animals[i];
            System.out.print(message + animal.getName() + " állathoz: ");
            switch (t) {
                case "beauty" -> animal.setBeautyPoint(scanner.nextInt());
                case "behavior" -> animal.setBehaviorPoint(scanner.nextInt());
            }
            truePoint = false;
            animal.calculateAllPoint();
        } catch (InputMismatchException e) {
            System.out.println("Hibás pont");
            truePoint = true;
        }
        return truePoint;

    }

    public void createInstance(List regList, Animal[] animals) {
        for (int i = 0; i < animals.length; i++) {
            String all = regList.get(i).toString();
            animals[i] = new Animal(all.split("[|]")[0], Integer.parseInt(all.split("[|]")[1]));
        }
    }

    public void writeReverseByAllPoint(Animal[] animals) {
        List<Animal> points = new ArrayList<>();
        Animal[] rev = new Animal[animals.length];
        int max = 0;
        for (int i = 0; i < animals.length; i++) {
            points.add(animals[i]);
        }
        int i = 0;
        System.out.println(points.size());
        while (points.size() == 0) {
            System.out.println("A max: " + max);
            points.remove(i++);

        }


    }


}
