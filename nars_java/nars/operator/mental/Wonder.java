/*
 * Copyright (C) 2014 peiwang
 *
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

package nars.operator.mental;

import java.util.ArrayList;
import nars.core.Parameters;
import nars.entity.*;
import nars.language.*;
import nars.io.Symbols;
import nars.language.Tense;
import nars.operator.Operator;
import nars.storage.Memory;

/**
 * Operator that creates a question with a given statement
 */
public class Wonder extends Operator {

    public Wonder() {
        super("^wonder");
    }

    /**
     * To create a question with a given statement
     * @param args Arguments, a Statement followed by an optional tense
     * @param memory The memory in which the operation is executed
     * @return Immediate results as Tasks
     */
    @Override
    public ArrayList<Task> execute(Term[] args, Memory memory) {
        Term content = args[0];
        Stamp stamp = new Stamp(memory, Tense.Present);
        
        Sentence sentence = new Sentence(content, Symbols.QUESTION_MARK, null, stamp);
        BudgetValue budget = new BudgetValue(Parameters.DEFAULT_QUESTION_PRIORITY, Parameters.DEFAULT_QUESTION_DURABILITY, 1);
        Task task = new Task(sentence, budget);
        ArrayList<Task> feedback = new ArrayList<>(1);
        feedback.add(task);
        return feedback;
    }
        
}