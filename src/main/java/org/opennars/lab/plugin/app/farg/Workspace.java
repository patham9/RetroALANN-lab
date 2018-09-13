/**
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */

package org.opennars.lab.plugin.app.farg;

import org.opennars.io.events.EventEmitter.EventObserver;
import org.opennars.io.events.Events.CycleEnd;
import org.opennars.main.Nar;
import org.opennars.entity.Concept;
import org.opennars.storage.PriorityMap;

/**
 *
 * @author patrick.hammer
 */
public class Workspace {

    public double temperature=0.0;
    public Nar nar;
    public int n_concepts=0;
    
    public Workspace(FluidAnalogiesAgents farg, Nar nar) {
        this.nar=nar;
        Workspace ws=this;
        farg.coderack=new PriorityMap(nar.narParameters.CONCEPT_BAG_SIZE);
        nar.on(CycleEnd.class, new EventObserver() { 

            @Override
            public void event(Class event, Object[] args) {
                for(int i=0;i<10;i++) { //process 10 codelets in each step
                    Codelet cod=(Codelet) farg.coderack.takeHighestPriorityItem();
                    if(cod!=null) {
                        if(cod.run(ws)) {
                            farg.coderack.putIn(cod);
                        }
                    }
                    temperature=calc_temperature();
                }
                controller();
            }
        });
    }
    
    public void controller() { 
        //when to put in Codelets of different type, and when to remove them
        //different controller for different domains would inherit from FARG
    }
    
    public double calc_temperature() {
        double s=0.0f;
        n_concepts=0;
        for(Concept node : nar.memory) {
            //if(!node.desires.isEmpty()) {
            //    s+=node.getPriority()*node.desires.get(0).sentence.truth.getExpectation();
            //}
            n_concepts++;
        }
        return s/((double) n_concepts);
    }
}
