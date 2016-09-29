package randomtree;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class DecisionTree
{

    public float entropy(List<Individual> trainingList, float split, int testedAttribute)
    {
        float entropy = 0;
        Map<String, Integer> greaterForAttribute = new HashMap() ;
        for(Individual elem : trainingList)
        {
            if(Float.parseFloat(elem.getAttributes().get(testedAttribute)) > split)
            {
                if(greaterForAttribute.containsKey(elem.getClassValue()))
                {
                    greaterForAttribute.replace(elem.getClassValue(), greaterForAttribute.get(elem.getClassValue()) + 1);
                }
                else
                {
                    greaterForAttribute.put(elem.getClassValue(), 1);
                }
            }
        }
        for(Map.Entry<String, Integer> entry : greaterForAttribute.entrySet())
        {
            entropy += entry.getValue().floatValue() / trainingList.size() * (Math.log10(entry.getValue().floatValue()/trainingList.size())/Math.log10(2));
        }
        return -entropy;
    }
}
