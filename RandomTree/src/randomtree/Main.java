package randomtree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Math.floor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) { 
        IndividualSet learningSet = DataHandler.parseData("data/iris.data");
        IndividualSet testingSet = new IndividualSet();
        DataHandler.buildRandomIndividualSets(learningSet, testingSet);
        System.out.println("\n\n LEARNING");
        System.out.println(learningSet);
        System.out.println("\n\n TEST");
        System.out.println(testingSet);
    }
    
}
