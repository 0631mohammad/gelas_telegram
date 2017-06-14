package org.gelas.Pouya.Setting;
import android.support.design.widget.TabLayout;

import org.gelas.Pouya.Models.TabModel;
import org.gelas.messenger.R;

import java.util.ArrayList;

/**
 * Created by Pouya on 6/13/2016.
 */
public class TabSetting {
    private static   ArrayList<TabModel> l;
    public static ArrayList<TabLayout.Tab> GetTabs(TabLayout tabHost){
        ArrayList<TabLayout.Tab> m=new ArrayList<TabLayout.Tab>();
        ArrayList<TabModel> l=getTabModels();
        for(int i=0;i<l.size();i++){
            TabLayout.Tab t=tabHost.newTab().setIcon(l.get(i).getUnselectedicon());
            m.add(t);
            tabHost.addTab(t);
        }
        return m;
    }
    public static int getNormalIcon(int id){
        return l.get(id).getUnselectedicon();
    }
    public static int getSelectedICon(int id){
        return l.get(id).getSelectedicon();
    }
    public static ArrayList<TabModel> getTabModels(){
        if(l!=null)return l;
      l =new ArrayList<TabModel>();
        l.add(new TabModel(0,R.string.Bot));
        l.add(new TabModel(1,R.string.Channels));
        l.add(new TabModel(2,R.string.Groups));
        l.add(new TabModel(3,R.string.Contacts));
        l.add(new TabModel(4,R.string.Favorites));
        l.add(new TabModel(5,R.string.All));
        l.add(new TabModel(6,R.string.Unread));
        return l;
    }
}
