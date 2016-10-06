package randomtree;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import tools.Tuple;

public class DecisionTree
{

    /**
     * Calcule l'entropie résultant d'une séparation des données pour la valeur
     * split de l'attribut testedAttribute.
     * @param trainingList Données à annalyser
     * @param split Valeur discriminante
     * @param testedAttribute attribut testé
     * @return l'entropie ou -1 si la population discriminée n'est pas représentative de l'échantillon (50%)
     */
    public float entropy(IndividualSet trainingList, float split, int testedAttribute)
    {
        float entropy = 0;
        int nbTestPass = 0;
        Map<String, Integer> greaterForAttribute = new HashMap();
        for(String key : trainingList.getInfoList().keySet())
        {
            greaterForAttribute.put(key, 0);
        }
        for(Individual elem : trainingList.getList())
        {
            if(Float.parseFloat(elem.getAttributes().get(testedAttribute)) <= split)
            {
                greaterForAttribute.replace(elem.getClassValue(), greaterForAttribute.get(elem.getClassValue()) + 1);
                nbTestPass +=1;
            }
        }
        for(Map.Entry<String, Integer> entry : greaterForAttribute.entrySet())
        {
            if(entry.getValue() != 0)
            {
                entropy += entry.getValue().floatValue() / nbTestPass * (Math.log10(entry.getValue().floatValue()/nbTestPass)/Math.log10(2));
            }
        }
            for(Map.Entry<String,Integer> entry : greaterForAttribute.entrySet())
            {
                if(entry.getValue()*100/trainingList.getInfoList().get(entry.getKey()) >= 50) // On ne prends que les entropies qui discriminent au moins 20% d'une classe;
                {
                    return -entropy;
                }
            }
            return -1; // Valeur d'entropie ignorée
    }
    
    /**
     * Détermine la meilleure valeur du meilleur attribut pour laquelle l'entropie est minimale
     * i.e. les données sont spéarée de la façon la plus certaine.
     * @param trainingData Données à annalyser
     * @return Tuple<valeur, attribut>
     */
    public Tuple<Integer, Float> bestSpliter(IndividualSet trainingData)
    {   
        Map<Tuple<Integer,Float>, Float> entropies = new HashMap<>();
        float min, max;
                
        for(int i = 0; i < trainingData.getList().get(0).getAttributes().size(); i++)
        {
            min = max = Float.parseFloat(trainingData.getList().get(0).getAttributes().get(i));
            for(Individual indiv : trainingData.getList())
            {
                float tmp = Float.parseFloat(indiv.getAttributes().get(i));
                min = tmp < min ? tmp : min;
                max = tmp > max ? tmp : max;
            }
            
            for(float j = min; j < max; j += 0.05)
            {
                entropies.put(new Tuple(i,j), this.entropy(trainingData, j, i));
            }
        }
        
        Float finalmin = entropies.values().iterator().next();
        Tuple<Integer,Float> bestSplit = null;
        
        for (Map.Entry<Tuple<Integer, Float>, Float> entry : entropies.entrySet())
        {
            Tuple<Integer, Float> key = entry.getKey();
            Float value = entry.getValue();
            if(value < finalmin && value >= 0)
            {
                finalmin = value;
                bestSplit = key;
            }
        }
        
        System.out.println("L'entropie est minimale pour la valeur " + bestSplit.getY()+ " de l'attribut : " + bestSplit.getX());
        
        return bestSplit;
    }
}
