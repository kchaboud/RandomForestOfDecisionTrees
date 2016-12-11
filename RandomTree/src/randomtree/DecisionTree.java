package randomtree;
import java.io.Serializable;
import static java.lang.Math.floor;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import tools.ComparatorStringFloat;
import tools.Tuple;

public class DecisionTree implements Serializable
{
    private Tree tree;
    private static float minimumSucessRate = 0.60f;
    public static float step = 0.20f;
    private int depth = 4;
    
    public DecisionTree(Tree tree)
    {
        this.tree = tree;
    }

    void setStep(float f)
    {
        step = f;
    }

    public void setDepth(int depth)
    {
        this.depth = depth;
    }

    
    public Tree getTree()
    {
        return tree;
    }
    
    
    /**
     * Calcule l'entropie résultant d'une séparation des données pour la valeur
     * split de l'attribut testedAttribute.
     * @param trainingList Données à annalyser
     * @param splitMin
     * @param splitMax
     * @param testedAttribute attribut testé
     * @return l'entropie pondérée 
     */
    public float entropy(IndividualSet trainingList, float splitMin, float splitMax , int testedAttribute)
    {
        float infEntropy = 0, supEntropy = 0;
        int nbTestPass = 0;
        Map<String, Integer> lowerForAttribute = new HashMap();
        for(String key : trainingList.getMetadata().keySet())
        {
            lowerForAttribute.put(key, 0);
        }
        for(Individual elem : trainingList.getList())
        {
            float value = Float.parseFloat(elem.getAttributes().get(testedAttribute));
            if(value <= splitMax && value >= splitMin )
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
            float unpassedOfClass=  trainingList.getMetadata().get(entry.getKey())- entry.getValue();
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
    public Tuple<Integer,Tuple<String, String>> bestSplitter(IndividualSet trainingData)
    {   
        if(trainingData.getMetadata().size() <= 1)
            return null;
        Map<Tuple<Integer,Tuple<String, String>>, Float> entropies = new HashMap<>();
        float min, max;
        Set<Integer> attributesSet;
        attributesSet = selectRandomAttributes(trainingData);
        
        
        
        for(int i : attributesSet)
        {
            //On determine le minimum et le maximum d'un attribut
           /* min = max = Float.parseFloat(trainingData.getList().get(0).getAttributes().get(i));
            for(Individual indiv : trainingData.getList())
            {
                float tmp = Float.parseFloat(indiv.getAttributes().get(i));
                min = tmp < min ? tmp : min;
                max = tmp > max ? tmp : max;
            }
            
            //On calcule des entropies pour des valeurs différentes
            for(float j = min; j <= max; j += 0.05)
            {
                entropies.put(new Tuple(i,j), this.entropy(trainingData, j, i));
            }
        }*/
           List<String> sortedAttribute = new ArrayList();
           for(Individual indiv : trainingData.getList())
           {
               sortedAttribute.add(indiv.getAttributes().get(i));
           }
           sortedAttribute.sort(new ComparatorStringFloat());
           
           for(float f = 0 ; f + step < 1 ; f = f + step)
           {
               int beginPosition = Math.round(f *( sortedAttribute.size() - 1 ));
               int endPosition = Math.round((f + step) *( sortedAttribute.size() - 1 ));
               entropies.put(new Tuple(i, 
                                new Tuple(
                                    sortedAttribute.get(beginPosition),
                                    sortedAttribute.get(endPosition))),
                                this.entropy(trainingData, 
                                    Float.parseFloat(sortedAttribute.get(beginPosition)), 
                                    Float.parseFloat(sortedAttribute.get(endPosition)),
                                    i));
           }
        }
        Float finalmin = entropies.values().iterator().next();
        Tuple<Integer,Tuple<String, String>> bestSplit = null;
        
        //On compare les entropies et on retourne celle qui est la meilleure
        for (Map.Entry<Tuple<Integer,Tuple<String, String>>, Float> entry : entropies.entrySet())
        {
            Tuple<Integer,Tuple<String, String>> key = entry.getKey();
            Float value = entry.getValue();
            if(value <= finalmin && value >= 0)
            {
                finalmin = value;
                bestSplit = key;
            }
        }
        
        //if(bestSplit != null)
          //  System.out.println("L'entropie est minimale pour la valeur " + bestSplit.getY() + " de l'attribut : " + bestSplit.getX());
        
        return bestSplit;
    }

    /**
     * Select a part of the list of attributes.
     * @param trainingData
     * @return 
     */
    private Set<Integer> selectRandomAttributes(IndividualSet trainingData)
    {
        Set<Integer> attributes = new HashSet();
        int size = trainingData.getList().get(0).getAttributes().size();
        int nbAttr = (int) floor(Math.sqrt(size));
        if(nbAttr < 3)
        {
            nbAttr = size < 3? size : 3;
        }
        for(int i = 0; i < nbAttr; i++)
        {
            int pos;
            do
            {
                pos = (int)floor(Math.random() * (size));
            }
            while(attributes.contains(pos));
            attributes.add(pos);
        }
        return attributes; 
    }

    @Override
    public String toString()
    {
        return tree.toString();
    }
    
    public void build()
    {
        build(tree, 0);
    }
    
    /**
     * Cette fonction récursive construit l'arbre en séparant le jeu de données 
     * du bud en deux buds fils les plus purs possibles.
     * @param bud noeud(ou feuille) de l'arbre dont on souhaite réaliser le split
     * @param currentDepth
     */
    private void build(Tree bud, int currentDepth)
    {
        if(currentDepth < depth)
        {
            Tuple<Integer,Tuple<String, String>> best;
            best = this.bestSplitter(bud.getData());
            if(best != null)
            {
                bud.setEntropy(this.entropy(bud.getData(), Float.parseFloat(best.getY().getX()),
                                            Float.parseFloat(best.getY().getY()), best.getX()));
                bud.splitData(best);
                this.build(bud.getLeftTree(), currentDepth + 1);
                this.build(bud.getRightTree(), currentDepth + 1);
            }
            else
            {
                bud.setData(null);
            }
        }
        else
        {
            bud.setData(null);
        }
    }
    /**
     * Pass throught the tree to determine the class of  individuals, then compares it with with the given individuals class. 
     * @param testSet
     * @return true if the minimum success rate is achieved.
     */
    public boolean testTree(IndividualSet testSet)
    {
        int nbTestPassed = 0, nbTestFailed = 0;
        for(Individual i : testSet.getList())
        {
            if(i.getClassValue().equals(browseTree(i)))
                nbTestPassed ++;
            else
                nbTestFailed++;
        }
        
        return ((float) nbTestPassed / (nbTestFailed + nbTestPassed) >= minimumSucessRate);
    }
    /**
     *Pass throught the tree to determine the class of  individuals, and return the class found
     * @param i
     * @return 
     */
    public String browseTree(Individual i)
    {
        Tree xylem = this.tree;
        do
        {
            if(xylem.getLeftTree() == null && xylem.getRightTree() == null)
            {
                return getMajorityClass(xylem.getValue());
            }
            float value = Float.parseFloat(i.getAttributes().get(xylem.getCriteraData()));
            if( value <= xylem.getCriteraTestMax() && value >= xylem.getCriteraTestMin())
                xylem = xylem.getLeftTree();
            else
                xylem = xylem.getRightTree();
        }
        while(xylem.getEntropy() != 0 || xylem.getEntropy() == 1);
        
        return getMajorityClass(xylem.getValue());
    }
    /**
     * Return the majoritary class of a set of values.
     * @param values
     * @return 
     */
    private String getMajorityClass(Map<String,Integer> values)
    {
        String className="";
        int quantity = 0;
        for( Entry<String,Integer> entry: values.entrySet())
        {
            if (entry.getValue() > quantity)
            {
                quantity = entry.getValue();
                className = entry.getKey();
            }
        }
        return className;
    }
}
