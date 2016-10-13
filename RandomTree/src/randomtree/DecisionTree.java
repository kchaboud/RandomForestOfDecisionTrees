package randomtree;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import tools.Tuple;

public class DecisionTree
{
    private Tree tree;

    public DecisionTree(Tree tree)
    {
        this.tree = tree;
    }

    public Tree getTree()
    {
        return tree;
    }
    
    
    /**
     * Calcule l'entropie résultant d'une séparation des données pour la valeur
     * split de l'attribut testedAttribute.
     * @param trainingList Données à annalyser
     * @param split Valeur discriminante
     * @param testedAttribute attribut testé
     * @return l'entropie pondérée 
     */
    public float entropy(IndividualSet trainingList, float split, int testedAttribute)
    {
        float infEntropy = 0, supEntropy = 0;
        int nbTestPass = 0;
        Map<String, Integer> lowerForAttribute = new HashMap();
        for(String key : trainingList.getInfoList().keySet())
        {
            lowerForAttribute.put(key, 0);
        }
        for(Individual elem : trainingList.getList())
        {
            if(Float.parseFloat(elem.getAttributes().get(testedAttribute)) <= split)
            {
                lowerForAttribute.replace(elem.getClassValue(), lowerForAttribute.get(elem.getClassValue()) + 1);
                nbTestPass +=1;
            }
        }
        for(Map.Entry<String, Integer> entry : lowerForAttribute.entrySet())
        {
            if(entry.getValue() != 0)
            {
                infEntropy += entry.getValue().floatValue() / nbTestPass * (Math.log10(entry.getValue().floatValue()/nbTestPass)/Math.log10(2));
            }
        }
        for(Map.Entry<String, Integer> entry : lowerForAttribute.entrySet())
        {
            float unpassedOfClass=  trainingList.getInfoList().get(entry.getKey())- entry.getValue();
            if(unpassedOfClass != 0)
            {
                supEntropy += (unpassedOfClass / (trainingList.getList().size() - nbTestPass)) * (Math.log10( unpassedOfClass / (trainingList.getList().size() - nbTestPass))/Math.log10(2));
            }
        }
        infEntropy =  - infEntropy;
        supEntropy = - supEntropy;
        return (((float) nbTestPass/trainingList.getList().size()) * infEntropy) + (((float) (trainingList.getList().size() - nbTestPass)/trainingList.getList().size()) * supEntropy); // Moyenne pondérée des entropies
    }
    
    /**
     * Détermine la meilleure valeur du meilleur attribut pour laquelle l'entropie est minimale
     * i.e. les données sont spéarée de la façon la plus certaine.
     * @param trainingData Données à annalyser
     * @return Tuple (valeur, attribut)
     */
    public Tuple<Integer, Float> bestSplitter(IndividualSet trainingData)
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
            
            for(float j = min; j <= max; j += 0.05)
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
        if(bestSplit != null)
            System.out.println("L'entropie est minimale pour la valeur " + bestSplit.getY() + " de l'attribut : " + bestSplit.getX());
        
        return bestSplit;
    }

    @Override
    public String toString()
    {
        return tree.toString();
    }
    
    /**
     * Cette fonction récursive construit l'arbre en séparant le jeu de données 
     * du bud en deux buds fils les plus purs possibles.
     * @param bud noeud(ou feuille) de l'arbre dont on souhaite réaliser le split
     */
    public void build(Tree bud)
    {
        Tuple<Integer, Float> best;
        best = this.bestSplitter(bud.getData());
        if(best != null)
        {
            bud.setEntropy(this.entropy(bud.getData(), best.getY(), best.getX()));
            bud.splitData(best);
            this.build(bud.getLeftTree());
            this.build(bud.getRightTree());
        }
    }
    
}
