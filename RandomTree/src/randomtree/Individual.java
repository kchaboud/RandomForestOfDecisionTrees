package randomtree;

import java.util.List;

public class Individual {
    private String classValue;
    private List<String> attributes;

    public Individual(String classValue, List<String> attributes) {
        this.classValue = classValue;
        this.attributes = attributes;
    }
    
    /*
        Getters
    */
    public String getClassValue() {
        return classValue;
    }
    public List<String> getAttributes() {
        return attributes;
    }
    
    /*
        Setters
    */
    public void setClassValue(String classValue) {
        this.classValue = classValue;
    }
    public void setAttributes(List<String> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "Individual{" + "classValue=" + classValue + ", attributes=" + attributes + "}\n";
    }

}
