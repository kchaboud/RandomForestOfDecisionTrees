/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.Comparator;

/**
 *
 * @author Robin
 */
public class ComparatorStringFloat implements Comparator<String>
{

    @Override
    public int compare(String o1, String o2)
    {
        Float f1,f2;
        f1 = Float.parseFloat(o1);
        f2 = Float.parseFloat(o2);
        if((f1 - f2) == 0)
            return 0;
        else
            if((f1 - f2) < 0)
                return -1;
            else
                return 1;
    }
    
}
