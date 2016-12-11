package randomtree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tools.Tuple;

public class Tree implements Serializable{

    private Map<String, Integer> value;
    private Tree leftTree;
    private Tree rightTree;
    private IndividualSet data;
    private float entropy; 
    private int criteraData; //Index of data which will be tested
    private float criteraTestMin;
    private float criteraTestMax;// Value of the test that separate data.
    
    public Tree(IndividualSet data)
    {
        this.value = data.getMetadata();
        this.leftTree = null;
        this.rightTree = null;
        this.data = data;
        this.entropy = 0f;
        this.criteraData = 0;
        this.criteraTestMin = 0f;
        this.criteraTestMax = 0f;
    }
    public Tree(Tree leftTree, Tree rightTree, IndividualSet data, float entropy, int criteraData, float criteraTestMin, float criteraTestMax)
    {
        this.value = data.getMetadata();
        this.leftTree = leftTree;
        this.rightTree = rightTree;
        this.data = data;
        this.entropy = entropy;
        this.criteraData = criteraData;
        this.criteraTestMin = criteraTestMin;
        this.criteraTestMax = criteraTestMax;
    }
    
    /**
     * Cette fonction sépare data en deux selon split, et crée avec chaque 
     * partie un arbre fils.
     * @param split le tuple contenant l'index de l'attribut sur lequel on 
     * sépare les données en deux et la valeur de séparation
     */
    public void splitData(Tuple<Integer,Tuple<String, String>> split)
    {
        this.criteraData = split.getX();
        this.criteraTestMin = Float.parseFloat(split.getY().getX());
        this.criteraTestMax = Float.parseFloat(split.getY().getY());        
        List<Individual> notPassedList = new ArrayList();
        List<Individual> PassedList = new ArrayList();
        for(Individual i : data.getList())
        {
            float individualValue = Float.parseFloat(i.getAttributes().get(criteraData));
            if( individualValue <= criteraTestMax && individualValue >= criteraTestMin)
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

    public int getCriteraData()
    {
        return criteraData;
    }

    public float getCriteraTestMin()
    {
        return criteraTestMin;
    }

    public float getCriteraTestMax()
    {
        return criteraTestMax;
    }

    public Tree getRightTree() {
        return rightTree;
    }

    public void setEntropy(float entropy)
    {
        this.entropy = entropy;
    }

    public void setData(IndividualSet data)
    {
        this.data = data;
    }
    
    public void setCriteraData(int criteraData)
    {
        this.criteraData = criteraData;
    }

    public void setCriteraTestMin(float criteraTestMin)
    {
        this.criteraTestMin = criteraTestMin;
    }

    public void setCriteraTestMax(float criteraTestMax)
    {
        this.criteraTestMax = criteraTestMax;
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
        return printTree(1,this);
        //return "Tree{" + "entropie= "+ entropy + "value=" + value  + ", criteraData=" + criteraData + ", criteraClass=[" + criteraTestMin+ ", " + criteraTestMax + "], \n\tleftTree=" + (leftTree != null?leftTree.toString():' ') + ", \r\trightTree=" + (rightTree != null?rightTree.toString():' ') + '}';
    }
    
    private String printTree(int depth, Tree branch)
    {
        String lString="", rString="", tabs="";
        for(int i =0; i < depth; i++)
            tabs = tabs + "\t";
        if(branch.leftTree != null)
            lString = printTree(depth + 1,branch.leftTree);
        if(branch.rightTree != null)
            rString = printTree(depth + 1, branch.rightTree);
        return "Tree{" + "entropie= "+ branch.entropy + "value=" + branch.value  + ", criteraData=" + branch.criteraData + ", criteraClass=[" + branch.criteraTestMin+ ", " + branch.criteraTestMax + "], \n" + tabs + "leftTree=" + lString + ", \r" + tabs + "rightTree=" + rString + '}';
    }
}
