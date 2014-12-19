/**
 * Copyright (C) 2014  Universidade de Aveiro, DETI/IEETA, Bioinformatics Group - http://bioinformatics.ua.pt/
 *
 * This file is part of Dicoogle/dicoogle-sdk.
 *
 * Dicoogle/dicoogle-sdk is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Dicoogle/dicoogle-sdk is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Dicoogle.  If not, see <http://www.gnu.org/licenses/>.
 */
package pt.ua.dicoogle.sdk;

import java.util.ArrayList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author Frederico Valente
 * @author Luís A. Bastião Silva <bastiao@ua.pt>
 * <p>
 * This interface exposes the graphical GUI of Dicoogle in a controlled way
 * Plugins implementing this interface should override this methods
 * If some of the functionality is not required (for instance, if there is
 * no need for a top icon), the respective methods overloads should return null
 * </p>
 * 
 */

public interface GraphicalInterface extends DicooglePlugin
{
    
    
    public ArrayList<JMenuItem> getRightButtonItems();
    public ArrayList<JPanel> getTopIcons();
    public ArrayList<JPanel> getTabPanels();
    public ArrayList<JMenuItem> getMenuItems();
}
