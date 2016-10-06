package randomtree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Math.floor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        individualsList.sort(Individual.ClassNameComparator);
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
        float learningRatio = 0.9f;
        int count = 0;
        for(int i : learningList.getMetadata().values()) {    
            int upperBound = i - (int)Math.floor(i * learningRatio);
            for(int j = 0; j < upperBound; j++) {
                int pos = (int)floor(Math.random() * (upperBound))
                        + count;
                testList.addIndividual(learningList.getIndividual(pos));
                learningList.removeIndividual(pos);
            }
            count += (i-upperBound);
        }
        learningList.updateMetaData();
        testList.updateMetaData();
    }
}
