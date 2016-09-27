package randomtree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Individual> individualsList = DataHandler.dataParsing("data/iris.data");
        System.out.println(individualsList);
    }
    
}
