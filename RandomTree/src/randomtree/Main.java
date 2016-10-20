package randomtree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import tools.Tuple;
import static java.lang.Math.floor;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) { 
        IndividualSet globalSet = DataHandler.parseData("data/iris.data");
        System.out.println(globalSet);
        System.out.println(floor(Math.random()*50));
        DecisionTree tree = new DecisionTree(new Tree(globalSet));
        System.out.println(tree.entropy(globalSet, 2.45f, 2));
        System.out.println(tree.entropy(globalSet, 0.8f, 3));
        

        
        tree.build(tree.getTree());
        System.out.println(tree);
    }
    
}
