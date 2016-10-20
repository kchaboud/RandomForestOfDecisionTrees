package randomtree;

import java.util.List;

public class Tree {

    private int value;
    private Tree leftTree;
    private Tree rightTree;
    private List data;
    private Double entropy; 
    private int criteraData; //Index of data which will be tested
    private Double criteraTest; // Value of the test that separate data.
    
    public Tree()
    {
        this.value = 0;
        this.leftTree = null;
        this.rightTree = null;
        this.data = null;
        this.entropy = 0.;
        this.criteraData = 0;
        this.criteraTest = 0.;
    }
    public Tree(int value, Tree leftTree, Tree rightTree, List data, double entropy, int criteraData, double criteraTest)
    {
        this.value = value;
        this.leftTree = leftTree;
        this.rightTree = rightTree;
        this.data = data;
        this.entropy = entropy;
        this.criteraData = criteraData;
        this.criteraTest = criteraTest;
    }
    
    public void addChildren(int leftValue, int rightValue)
    {
        addLeftTree(leftValue);
        addRightTree(rightValue);
    }
    public void addLeftTree(int leftValue)
    {
        this.leftTree = new Tree(leftValue, null, null, null, 0, 0, 0);
    }
    public void addRightTree(int rightValue)
    {
        this.rightTree = new Tree(rightValue, null, null, null, 0, 0, 0);
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Tree getLeftTree() {
        return leftTree;
    }

    public Tree getRightTree() {
        return rightTree;
    }
}
