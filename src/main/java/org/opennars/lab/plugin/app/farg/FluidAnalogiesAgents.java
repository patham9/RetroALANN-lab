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

import org.opennars.main.Nar;
import org.opennars.plugin.Plugin;
import org.opennars.language.Term;
import org.opennars.storage.PriorityMap;

/**
 *
 * @author tc
 */
public class FluidAnalogiesAgents implements Plugin {
    public int max_codelets=100;
    public int codelet_level=100;
    Workspace ws;
    PriorityMap coderack;
    
    @Override
    public boolean setEnabled(Nar n, boolean enabled) {
        if(enabled==true) {
            ws=new Workspace(this,n);
        }
        return true;
    }
    
}
