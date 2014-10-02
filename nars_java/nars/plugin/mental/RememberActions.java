package nars.plugin.mental;

import nars.core.EventEmitter.Observer;
import nars.core.Events;
import nars.core.Memory;
import nars.core.NAR;
import nars.core.Parameters;
import nars.core.Plugin;
import nars.entity.BudgetValue;
import nars.entity.Sentence;
import nars.entity.Stamp;
import nars.entity.Task;
import nars.entity.TruthValue;
import nars.io.Symbols;
import nars.language.Term;
import nars.operator.Operation;

/**
 * To rememberAction an internal action as an operation
 * <p>
 * called from Concept
 * @param task The task processed
 */
public class RememberActions implements Plugin {

    @Override public boolean setEnabled(NAR n, boolean enabled) {
        Memory memory = n.memory;
        memory.event.set(new Observer() {

            @Override public void event(Class event, Object[] a) {
                
                if (event!=Events.ConceptDirectProcessedTask.class)
                    return;
                
                Task task = (Task)a[0];                

                Term content = task.getContent();
                
                // to prevent infinite recursions
                if (content instanceof Operation)
                    return;
                                
                Sentence sentence = task.sentence;
                TruthValue truth = new TruthValue(1.0f, Parameters.DEFAULT_JUDGMENT_CONFIDENCE);
                
                Stamp stamp = task.sentence.stamp.clone();
                stamp.setOccurrenceTime(memory.getTime());

                Sentence j = new Sentence(sentence.toTerm(memory), Symbols.JUDGMENT_MARK, truth, stamp);
                BudgetValue newbudget=new BudgetValue(
                        task.budget.getPriority()*Parameters.INTERNAL_EXPERIENCE_PRIORITY_MUL,
                        task.budget.getDurability()*Parameters.INTERNAL_EXPERIENCE_DURABILITY_MUL, 
                        task.budget.getQuality()*Parameters.INTERNAL_EXPERIENCE_QUALITY_MUL);
                
                Task newTask = new Task(j, (BudgetValue) newbudget, 
                        Parameters.INTERNAL_EXPERIENCE_FULL ? null : task);
                
                if (memory.getRecorder().isActive()) {
                    memory.getRecorder().append("Action Remembered", j.toString());
                }
                
                memory.addNewTask(newTask, "Remembered Action");
                
            }
            
        }, enabled, Events.ConceptDirectProcessedTask.class);
        return true;
    }
    
}