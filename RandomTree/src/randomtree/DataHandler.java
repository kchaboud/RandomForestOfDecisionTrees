package randomtree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class DataHandler {
    public static List<Individual> dataParsing(String path) {
        BufferedReader br = null;
        String line;
        ArrayList<Individual> individualsList = new ArrayList();
        
        try {
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                List<String> dataRead = Arrays.asList(line.split(","));
                individualsList.add(new Individual(dataRead.get(dataRead.size()-1),
                        dataRead.subList(0, dataRead.size() -1)));
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
        return individualsList;
    }

}
