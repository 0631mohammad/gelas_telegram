package org.gelas.Pouya.Helper;

import android.os.Handler;
import android.util.Log;

import org.gelas.Pouya.Setting.Setting;
import org.gelas.messenger.MessageObject;
import org.gelas.messenger.MessagesController;
import org.gelas.messenger.SendMessagesHelper;
import org.gelas.tgnet.TLRPC;

import java.util.ArrayList;

/**
 * Created by Pouya on 6/24/2016.
 */
public class AnsweringMachine {
public static ArrayList<MessageObject> ListOfMsgs=new ArrayList<>();
    public static boolean ProcessMsg(MessageObject messageObject) {
    Log.e("answm","part1");
        if(Setting.getAnsweringMachine()){
            Log.e("answm","part2");
            if(Setting.getAnsweringmachineText().length()>0){
                Log.e("answm","part3");
                long userid=messageObject.getDialogId();
                Log.e("answm","part4 userid:"+userid);
                TLRPC.User user = MessagesController.getInstance().getUser(Integer.valueOf((int) userid));

                if (userid > 0 && user != null && !user.bot) {
                    Log.e("answm","part5");
                    String msg = Setting.getAnsweringmachineText();
                    if(UserHistorysend.isok(userid)) {
                        Log.e("answm","part6");
                        SendText(msg, userid, messageObject);
                        UserHistorysend.add(userid);
                        return false;
                    }else{

                    }
                }else{
                    return false;
                }
            }
            return false;
        }
        return false;
    }
    public static void SendText(String msg,long userid,MessageObject msgforreplay){
        Log.e("answm","part7");
        SendMessagesHelper.getInstance().sendMessage(msg, userid, null, null, true, true, null, null, null);
        MessagesController.getInstance().markMessageContentAsRead(msgforreplay);
    }

    public static void ProcessMsgs(final ArrayList<MessageObject> listofdialogs) {
        for(int i=0;i<listofdialogs.size();i++){
            final int finalI = i;
            final MessageObject m=listofdialogs.get(finalI);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Log.e("ProcessMsgs", "proccess");
                    ProcessMsg(m);
                }
            },i*1000);

        }
    }
}
