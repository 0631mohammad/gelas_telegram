package org.gelas.Pouya.Helper;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by Pouya on 6/24/2016.
 */
public class UserHistorysend {
    private static HashMap<Long,Long> list=new HashMap<>();
    public static boolean isok(Long userid) {
        if(list.size()==0)return true;
        if(list.containsKey(userid)){
            if(list.get(userid).longValue()< new Date().getTime()){
                list.remove(userid);
                return true;

            }else{
                return false;
            }
        }else{
            return true;
        }
    }

    public static void add(long userid) {
        list.remove(userid);
        list.put(userid, new Date().getTime()+(20*1000));
    }
}
