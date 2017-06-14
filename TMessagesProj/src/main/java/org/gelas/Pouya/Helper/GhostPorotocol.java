package org.gelas.Pouya.Helper;

import org.gelas.Pouya.Setting.Setting;
import org.gelas.messenger.MessagesController;

/**
 * Created by Pouya on 6/16/2016.
 */
public class GhostPorotocol {
    public static void toggleGhostPortocol(){
        boolean m=!Setting.getGhostMode();
        trun(m);
    }
    public static void update(){
        boolean m=Setting.getGhostMode();
        trun(m);
    }
    public static void trun(boolean on){
        Setting.setGhostMode(on);
        if(on){
            NotiFicationMaker.createNotification();
        }else{
            NotiFicationMaker.cancelNotification();

        }
        MessagesController.getInstance().reRunUpdateTimerProc();

    }

}
