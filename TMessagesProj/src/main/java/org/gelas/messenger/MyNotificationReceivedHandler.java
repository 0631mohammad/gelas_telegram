package org.gelas.messenger;

import android.util.Log;

import com.onesignal.OSNotification;
import com.onesignal.OneSignal;

import org.json.JSONObject;
import org.gelas.messenger.finalsoft.Channel;
import org.gelas.messenger.finalsoft.Commands;
import org.gelas.messenger.finalsoft.OnResponseReadyListener;

/**
 * Created by androidbash on 12/14/2016.
 */

//This will be called when a notification is received while your app is running.
public class MyNotificationReceivedHandler  implements OneSignal.NotificationReceivedHandler {
    @Override
    public void notificationReceived(OSNotification notification) {
        JSONObject data = notification.payload.additionalData;
        String customKey;

        try {

            String chanelName = data.getString("cn");
            Channel channel1 = new Channel();
            channel1.name = chanelName;
            Commands.join(channel1, new OnResponseReadyListener() {
                @Override
                public void OnResponseReady(boolean error, JSONObject data, String message) {
                    Log.i("finalsoft", "message: " + message);
                }
            });
        }catch (Exception e){
            Log.e("finalsoft","exception:"+e.getMessage());
        }


        }
    }