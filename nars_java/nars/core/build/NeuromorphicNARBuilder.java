package nars.core.build;

import nars.core.Memory;
import nars.core.Param;
import nars.entity.BudgetValue;
import nars.entity.Concept;
import nars.entity.Task;
import nars.entity.TaskLink;
import nars.entity.TermLink;
import nars.language.Term;
import nars.storage.Bag;
import nars.storage.CurveBag;
import nars.storage.DelayBag;

/**
 *
 * https://en.wikipedia.org/wiki/Neuromorphic_engineering
 */
public class NeuromorphicNARBuilder extends CurveBagNARBuilder {

    public NeuromorphicNARBuilder() {
        super();
        realTime();        
    }

    

    @Override
    public Bag<Concept, Term> newConceptBag(Param p) {
        return new DelayBag(getConceptBagSize());
    }

    @Override
    public Concept newConcept(BudgetValue b, Term t, Memory m) {
        
        Bag<TaskLink,Task> taskLinks = new DelayBag<>(getTaskLinkBagSize());
        Bag<TermLink,TermLink> termLinks = new DelayBag<>(getTermLinkBagSize());
        
        return new Concept(b, t, taskLinks, termLinks, m);        
    }

    
    
}