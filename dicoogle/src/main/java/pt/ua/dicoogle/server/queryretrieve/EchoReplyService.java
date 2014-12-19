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
/*
 * Thread for DICOM Echo Reply service implementation
 */

package pt.ua.dicoogle.server.queryretrieve;


/**
 *
 * @author Joaoffr  <joaoffr@ua.pt>
 * @author DavidP   <davidp@ua.pt>
 *
 * @version $Revision: 002 $ $Date: 2008-11-22 14:25:00  $
 * @since Nov 21, 2008
 *
 */
public class EchoReplyService extends Thread 
{

    private DicomEchoReply echoReply = null;


    public EchoReplyService() {
        this.echoReply = new DicomEchoReply();
    }



    public DicomEchoReply getEchoReply() {
        return echoReply;
    }



    @Override
    public void run() {
        /* 
         * ////
        try {
            this.mw.add2ServerLogln("Starting Verification Service...", MainWindow.LOG_MODES.WARNING);
            
            if (this.echoReply.startListening()) {
                this.mw.add2ServerLogln("Verification Service start listening on port "+ this.echoReply.getLocalPort() + ".",
                                        MainWindow.LOG_MODES.NORMAL);

                this.mw.add2ServerLogln("Verification Service started!",MainWindow.LOG_MODES.WARNING);
            } else {
                this.mw.add2ServerLogln("Error Starting Verification Service on port " + this.echoReply.getLocalPort() + "...",
                                        MainWindow.LOG_MODES.ERROR);
            }
        }
        catch (Exception ex) {
            this.mw.add2ServerLogln(ex.getMessage(), MainWindow.LOG_MODES.ERROR);
        }
        
        */
    }

    public void  stopService() {
        /* ///
        try {
            this.mw.add2ServerLogln("Stopping Verification Service...", MainWindow.LOG_MODES.WARNING);

            if (this.echoReply.stopListening()) {
                super.stop();

                this.mw.add2ServerLogln("Verification Service stoped.", MainWindow.LOG_MODES.WARNING);
            } else {
                this.mw.add2ServerLogln("Error stopping Verification Service on port " + this.echoReply.getLocalPort() + " ...",
                                        MainWindow.LOG_MODES.ERROR);
            }
        }
        catch (Exception ex) {
            this.mw.add2ServerLogln(ex.getMessage(), MainWindow.LOG_MODES.ERROR);
        }
         */
        
    }


}
