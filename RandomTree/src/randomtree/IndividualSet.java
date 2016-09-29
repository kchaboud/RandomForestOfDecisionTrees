package randomtree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndividualSet {
    private Map<String, Integer> infoList;
    private List<Individual> list;
    
    public IndividualSet(List<Individual> list) {
        this.list = list;
        this.infoList = evaluateInfoList(list);
       
    }
    
    private Map<String,Integer> evaluateInfoList(List<Individual> list) {
        Map<String,Integer> infoList = new HashMap();
        for( Individual i : list) {
            if(infoList.containsKey(i.getClassValue())) {
               infoList.replace(i.getClassValue(), infoList.get(i.getClassValue())+1);
            }
            else {
                infoList.put(i.getClassValue(), 1);
            }
        }
        return infoList;
    }

    @Override
    public String toString() {
        return "IndividualSet{\n" + "infoList=" + infoList + ",\nlist=" + list + '}';
    }
    
}
