package randomtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tools.Tuple;

public class Tree {

    private Map<String, Integer> value;
    private Tree leftTree;
    private Tree rightTree;
    private IndividualSet data;
    private float entropy; 
    private int criteraData; //Index of data which will be tested
    private float criteraTest; // Value of the test that separate data.
    
    public Tree(IndividualSet data)
    {
        this.value = data.getMetadata();
        this.leftTree = null;
        this.rightTree = null;
        this.data = data;
        this.entropy = 0f;
        this.criteraData = 0;
        this.criteraTest = 0f;
    }
    public Tree(Tree leftTree, Tree rightTree, IndividualSet data, float entropy, int criteraData, float criteraTest)
    {
        this.value = data.getMetadata();
        this.leftTree = leftTree;
        this.rightTree = rightTree;
        this.data = data;
        this.entropy = entropy;
        this.criteraData = criteraData;
        this.criteraTest = criteraTest;
    }
    
    /**
     * Cette fonction sépare data en deux selon split, et crée avec chaque 
     * partie un arbre fils.
     * @param split le tuple contenant l'index de l'attribut sur lequel on 
     * sépare les données en deux et la valeur de séparation
     */
    public void splitData(Tuple<Integer,Float> split)
    {
        this.criteraData = split.getX();
        this.criteraTest = split.getY();
        List<Individual> notPassedList = new ArrayList();
        List<Individual> PassedList = new ArrayList();
        for(Individual i : data.getList())
        {
            if(Float.parseFloat(i.getAttributes().get(split.getX())) <= split.getY())
            {
                PassedList.add(i);
            }
            else
            {
                notPassedList.add(i);
            }
        }
        addLeftChild(new IndividualSet(PassedList));
        addRightChild(new IndividualSet(notPassedList));
        this.data = null;
    }
    
    public void addLeftChild(IndividualSet data)
    {
        this.leftTree = new Tree(data);
    }
    public void addRightChild(IndividualSet data)
    {
        this.rightTree = new Tree(data);
    }
    
    
    public Map<String, Integer> getValue() {
        return value;
    }

    public Tree getLeftTree() {
        return leftTree;
    }

    public Tree getRightTree() {
        return rightTree;
    }

    public void setEntropy(float entropy)
    {
        this.entropy = entropy;
    }

    public void setCriteraData(int criteraData)
    {
        this.criteraData = criteraData;
    }

    public void setCriteraTest(float criteraTest)
    {
        this.criteraTest = criteraTest;
    }

    public IndividualSet getData()
    {
        return data;
    }

    public float getEntropy()
    {
        return entropy;
    }
    
    @Override
    public String toString()
    {
        return "Tree{" + "entropie= "+ entropy + "value=" + value  + ", criteraData=" + criteraData + ", criteraTest=" + criteraTest+ ", \n\tleftTree=" + (leftTree != null?leftTree.toString():' ') + ", \r\trightTree=" + (rightTree != null?rightTree.toString():' ') + '}';
    }
    

}
