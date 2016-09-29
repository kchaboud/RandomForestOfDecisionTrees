package randomtree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DataHandler {
    /**
     * Parses data from a file and creates a list of Individual from this data.
     * The classValue is the last element from the parsed line.
     * @param path
     * @return
     */
    public static IndividualSet parseData(String path) {
        BufferedReader br = null;
        String line;
        List<Individual> individualsList = new ArrayList();
        
        try {
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                List<String> dataRead = Arrays.asList(line.split(","));
                individualsList.add(new Individual(dataRead.get(dataRead.size()-1),
                        dataRead.subList(0, dataRead.size() -1)));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new IndividualSet(individualsList);
    }
    
    /**
     * Initializes two lists of Individual from a global list.
     * One will be use for learning and the other for testing.
     * @param learningList
     * @param testList 
     */
    public static void buildRandomIndividualSets(
            IndividualSet learningList,
            IndividualSet testList) {
        float learningRate = 0.9f;
        
        List<Integer> lol = new ArrayList();       
    }
}
