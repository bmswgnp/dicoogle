/**
 * Copyright (C) 2014  Universidade de Aveiro, DETI/IEETA, Bioinformatics Group - http://bioinformatics.ua.pt/
 *
 * This file is part of Dicoogle/dicoogle.
 *
 * Dicoogle/dicoogle is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Dicoogle/dicoogle is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Dicoogle.  If not, see <http://www.gnu.org/licenses/>.
 */
package pt.ua.dicoogle.core;

/**
 *
 * @author Samuel da Costa Campos <samuelcampos@ua.pt>
 * @see XMLClientSupport
 *
 */
public class DicoogleSettings {

    private String temporaryFileDirectory;
    private String externalViewer;
    private int httpServerPort;
    private int restServicesPort;
    
    private DicoogleSettings(){
        temporaryFileDirectory = "";
        externalViewer = "";
        httpServerPort = 0;
    }


    /**
     * @return the configured port for the HTTP server
     */
    public int getHttpServerPort() {
        return httpServerPort;
    }

    /**
     * @return a string containing the path of the temporary files directory
     */
    public String getTemporaryFilesDirectory() {
        return temporaryFileDirectory;
    }

    
}
