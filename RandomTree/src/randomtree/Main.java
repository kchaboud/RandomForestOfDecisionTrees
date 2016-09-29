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
        IndividualSet globalSet = DataHandler.parseData("data/iris.data");
        System.out.println(globalSet);
        System.out.println(floor(Math.random()*50));
    }
    
}
