package randomtree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndividualSet {
    private Map<String, Integer> metadata;
    private List<Individual> list;
    
   public IndividualSet() {
       this.list = new ArrayList<>();
       this.metadata = new HashMap<>();
   }

    public IndividualSet(List<Individual> list) {
        this.list = list;
        this.metadata = evaluateMetaData(list);
    }

    public Map<String, Integer> getMetadata() {
        return metadata;
    }
    public List<Individual> getList() {
        return list;
    }

    public void setMetadata(Map<String, Integer> metadata) {
        this.metadata = metadata;
    }
    public void setList(List<Individual> list) {
        this.list = list;
    }
    
    public void addIndividual(Individual i) {
        this.list.add(i);
    }
    public Individual getIndividual(int pos) {
        return this.list.get(pos);
    }
    public void removeIndividual(int pos) {
        this.list.remove(pos);
    }
    
    public void updateMetaData(){
        this.metadata = evaluateMetaData(this.list);
    }
    
    private Map<String,Integer> evaluateMetaData(List<Individual> list) {
        Map<String,Integer> metadata = new HashMap();
        for( Individual i : list) {
            if(metadata.containsKey(i.getClassValue())) {
               metadata.replace(i.getClassValue(), metadata.get(i.getClassValue())+1);
            }
            else {
                metadata.put(i.getClassValue(), 1);
            }
        }
        return metadata;
    }

    @Override
    public String toString() {
        return "IndividualSet{\n" + "metadata=" + metadata + ",\nlist=" + list + '}';
    }
    
}
