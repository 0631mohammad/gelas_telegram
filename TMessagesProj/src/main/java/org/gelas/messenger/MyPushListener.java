package org.gelas.messenger;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;
import org.gelas.messenger.finalsoft.Channel;
import org.gelas.messenger.finalsoft.Commands;
import org.gelas.messenger.finalsoft.OnResponseReadyListener;

import co.ronash.pushe.PusheListenerService;

public class MyPushListener extends PusheListenerService {
    @Override
    public void onMessageReceived(JSONObject message, JSONObject content) {
        if (message.length() == 0)
            return; //json is empty
        Log.i("Pushe", "Custom json Message: " + message.toString()); //print json to logCat

        //your code
        try {
            int code = Integer.parseInt(message.getString("code"));
            switch (code){
                case 1:
            String image_baner = message.getString("baner");
            String image_logo = message.getString("logo");
            String text_title = message.getString("title");
            String text_desc = message.getString("desc");
            String text_btn = message.getString("textbtn");
            String link_btn = message.getString("link");

            Intent intent = new Intent(getApplicationContext(),Dialog.class)
                    .putExtra("image_logo",image_logo)
                    .putExtra("image_baner",image_baner)
                    .putExtra("text_title",text_title)
                    .putExtra("text_desc",text_desc)
                    .putExtra("text_btn",text_btn)
                    .putExtra("link_btn",link_btn);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
                    break;

                case 2:
                    //pop_up
                    //************************ اگه خواستید پاپ اپ باشه بجای کد های بالا کافیه کد زیر رو بذارید
                    String link_pop_up = message.getString("link");//op_up.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(link_pop_up));
                    browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(browserIntent);
                    //startActivity(pop_up);
                    break;


                case 3:
                    //pop_up
                    //************************ اگه خواستید پاپ اپ باشه بجای کد های بالا کافیه کد زیر رو بذارید
                    try {

                        String chanelName = message.getString("cn");
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

                    break;
            }




            //android.util.Log.e("Pushe", "Json Message\n Titr: " + s1 + "\n Matn: " + s2);
        } catch (JSONException e) {
            Log.e("", "Exception in parsing json", e);
        }

    }
}