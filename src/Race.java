import main.Animal;

import java.util.*;

public class Race {
 private final String DELIMITER = "[|]";
    private void setPoints(Animal[] animals) {
        try (Scanner scanner = new Scanner(System.in)) {


            for (int i = 0; i < animals.length; i++) {
                while (getPointsFromUser(scanner, "Kérem adja meg a szépség pontszámot ", animals, i, "beauty")) {
                }
                while (getPointsFromUser(scanner, "Kérem adja meg a viselkedés pontszámot ", animals, i, "behavior")) {
                }
            }
        } catch (NullPointerException e) {
            System.out.println("nem talált objektum");
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

    private boolean getPointsFromUser(Scanner scanner, String message, Animal[] animals, int i, String t) {
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

    private void createInstance(List regList, Animal[] animals) {
        for (int i = 0; i < animals.length; i++) {
            String all = regList.get(i).toString();
            String[] animalData = all.split(DELIMITER);
            animals[i] = new Animal(animalData[0], Integer.parseInt(animalData[1]));
        }
    }

    public List<Animal> sortListReverseByAllPoint(Animal[] animals) {
        List<Animal> points = new ArrayList<>(Arrays.asList(animals));

        return points;

    }

    private void writeAllAnimalNameAndPoints(Animal[] animals) {

        for (int i = 0; i < animals.length; i++) {
            System.out.println("Név: " + animals[i].getName() + ", kor: " + animals[i].getAge() + ", összes pont: " + animals[i].getAllPoint());
        }
    }

    private void writeWinner(Animal[] animals) {
        Animal winner = searchWinner(animals);
        System.out.println("A győztes: " + winner.getName() + " " + winner.getAllPoint() + " ponttal. ");
    }

    private void writeSortedList(Animal[] animals) {

        List<Animal> dl = sortListReverseByAllPoint(animals);
        Collections.sort(dl);
        for (Animal animal : dl) {
            System.out.println(animal.getName() + " | " + animal.getAllPoint());
        }

    }

    public void runRace(List regList,Animal[] animals){
       createInstance(regList, animals);
       setPoints(animals);
       writeAllAnimalNameAndPoints(animals);
       writeWinner(animals);
       writeSortedList(animals);

    }


}
