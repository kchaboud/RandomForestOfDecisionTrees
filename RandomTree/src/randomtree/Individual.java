package randomtree;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

public class Individual implements Serializable{
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
    
    public static Comparator<Individual> ClassNameComparator
            = new Comparator<Individual>() {
        @Override
        public int compare(Individual i1, Individual i2) {
            String className1 = i1.getClassValue().toUpperCase();
            String className2 = i2.getClassValue().toUpperCase();

            return className1.compareTo(className2);
        }
    };

}
