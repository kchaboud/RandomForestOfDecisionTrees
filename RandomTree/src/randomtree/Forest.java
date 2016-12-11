package randomtree;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Forest implements Serializable
        
{
    private Set<DecisionTree> forest;
    
    public Forest()
    {
        forest = new HashSet();
    }
    
    public void addTree(DecisionTree t)
    {
        forest.add(t);
    }

    public Set<DecisionTree> getForest()
    {
        return forest;
    }
    
    public String getClassOfIndividual(Individual indiv)
    {
        Map<String, Integer> indivClasses = new HashMap();
        for(DecisionTree tree :forest) 
        {
            String indivClass =tree.browseTree(indiv);
            if(!indivClasses.containsKey(indivClass))
            {
                indivClasses.put(indivClass, 1);
            }
            else
            {
                indivClasses.replace(indivClass, indivClasses.get(indivClass) + 1);
            }
        }
        String averageClass = null;
        Integer max = null;
        for (Map.Entry<String, Integer> entry : indivClasses.entrySet())
        {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if(max == null)
            {
                max = value;
                averageClass = key;
            }
            if(value > max)
            {
                max = value;
                averageClass = key;
            }
        }
        return averageClass;
    }
}
