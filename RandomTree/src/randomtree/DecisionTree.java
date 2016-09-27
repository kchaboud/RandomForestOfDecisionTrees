package randomtree;

import java.util.ArrayList;
import java.util.List;


public class DecisionTree {

    private String[] data;
    int critere;
    
    public DecisionTree()
    {
        this.data = null;
        this.critere = 0;
    }
    
    public DecisionTree(String[] data, int critere)
    {
        this.data = data;
        this.critere = critere;
    }
    public Float entropy(int property)
    {
        SeparateData(data, property, average(data, property));
    }
    
    private float average(String[] data, int property)
    {
        int i;
        float avg = 0;
        for(i = 0 ; i < data.length ; i++)
        {
            avg += Float.parseFloat(data[i]);
        }
        avg = avg / i;
        return avg;
    }
    
    private List SeparateData(String[] data, int property, float condition)
    {
        
    }
}
