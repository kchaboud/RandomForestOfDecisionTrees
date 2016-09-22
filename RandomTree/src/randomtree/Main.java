package randomtree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String dataFile = "src/iris.data";
        BufferedReader br = null;
        String line;
        int i = 0;
        
        try {
            br = new BufferedReader(new FileReader(dataFile));
            while ((line = br.readLine()) != null) {
                String[] dataRead = new String[5];
                dataRead = line.split(",");
                i++;
                System.out.println(i + " Sepal length: " + dataRead[0]
                        + " Sepal width: " + dataRead[1]
                        + " Petal length: " + dataRead[2]
                        + " Petal width: " + dataRead[3]);
            }
        } catch (Exception e) {
            System.out.println("TAMER");
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
}
