package reg;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class
Registration {

     private final String regFile = "D:\\project\\java\\gyakorlo_feladatok\\gyakorlo_feladatok\\reg.txt";


    public List<String> readFileFromTxt() {

        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(Paths.get(regFile), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println(e);
        }
        return lines;
    }

}
