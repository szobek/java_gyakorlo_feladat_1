import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String regFile = "D:\\project\\java\\gyakorlo_feladatok\\gyakorlo_feladatok\\reg.txt" ;
        List regList = readFileFromTxt(regFile);
        List<Animal> animals;
        animals = createInstance(regList);
        Scanner scanner = new Scanner(System.in);
       for(int i = 0;i< animals.size();i++){
           System.out.print("Kérem adja meg a szépség pontszámot "+ animals.get(i).getName()+"-hoz: ");
           animals.get(i).setBeautyPoint(scanner.nextInt());
           System.out.print("Kérem adja meg a viselkedés pontszámot "+ animals.get(i).getName()+"-hoz: ");
           animals.get(i).setBehaviorPoint(scanner.nextInt());
           animals.get(i).calculateAllPoint();
       }
       for(int i = 0;i< animals.size();i++){
           System.out.print("Név: "+animals.get(i).getName()+", kor: "+animals.get(i).getAge()+", összes pont: "+animals.get(i).getAllPoint());
           System.out.println();
       }

    }

    public static List<String> readFileFromTxt(String fileName)
    {

        List<String> lines = Collections.emptyList();
        try{
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        }catch (IOException e){
            System.out.println(e);
        }
        return lines;
    }

    public static List createInstance(List regList){
//        List<Animal> animals = Collections
        List<Animal> animals=new ArrayList<Animal>();

        Iterator<String> itr = regList.iterator();


        while (itr.hasNext()){
String all = itr.next();
            animals.add(new Animal(all.split("[|]")[0],Integer.parseInt(all.split("[|]")[1])));
        }
        return animals;
    }

}