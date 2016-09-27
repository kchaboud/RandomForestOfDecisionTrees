package randomtree;

import java.util.ArrayList;

public class Individual {
    private String classValue;
    private ArrayList<String> attributes;

    public Individual(String classValue, ArrayList<String> attributes) {
        this.classValue = classValue;
        this.attributes = attributes;
    }
    
    /*
        Getters
    */
    public String getClassValue() {
        return classValue;
    }
    public ArrayList<String> getAttributes() {
        return attributes;
    }
    
    /*
        Setters
    */
    public void setClassValue(String classValue) {
        this.classValue = classValue;
    }
    public void setAttributes(ArrayList<String> attributes) {
        this.attributes = attributes;
    }

}
