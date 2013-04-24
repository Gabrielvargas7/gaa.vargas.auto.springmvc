/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.services.checked;

import gaa.vargas.autodealer.domain.Spec;
import gaa.vargas.autodealer.domain.SpecChecked;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabriel
 */
public class AutoSpecCheckedImpl implements AutoSpecChecked{

    public AutoSpecCheckedImpl() {
    }

    // return Object with the value checked
    public List<SpecChecked> findSpecChecked(List<Spec> allSpec,List<Spec> selectSpec)
    {
            List<SpecChecked> specChecked = new ArrayList<SpecChecked>();


            for(Spec spec:allSpec)
            {
                SpecChecked specFrontEnd = new SpecChecked();
                specFrontEnd.setName(spec.getName());
                specFrontEnd.setSpec(spec.getSpec());

                specFrontEnd.setSpecid(spec.getSpecid());
                specFrontEnd.setChecked("");

                    for(Spec select: selectSpec)
                    {
                        if (specFrontEnd.getName().equals(select.getName())&&(specFrontEnd.getSpec().equals(select.getSpec())))
                        {

                            specFrontEnd.setChecked("checked");
                            break;
                        }
                    }
                specChecked.add(specFrontEnd);
            }
          return specChecked;

    }

}
