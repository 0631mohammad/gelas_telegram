package org.gelas.Pouya.Models;



import org.gelas.messenger.R;

import java.util.ArrayList;

/**
 * Created by Pouya on 6/14/2016.
 */
public class Theme {
    public static final String NORMAL="normal";
    public static final String BLUE="blue";
    public static final String GREY="grey";
    public static final String SELECTED="selected";
    private int id;
    private String name;
    private int actionbarcolor;
    private int tabLayoutColor;
    private int Floatingbuttondrawble;
    private ArrayList<Integer> TabsIconNormal;
    private ArrayList<Integer> TabsIconSelected;

    public Theme(int id, String name, int actionbarcolor, int tabLayoutColor, int floatingbuttondrawble, ArrayList<Integer> tabsIconNormal, ArrayList<Integer> tabsIconSelected) {
        this.id = id;
        this.name = name;
        this.actionbarcolor = actionbarcolor;
        this.tabLayoutColor = tabLayoutColor;
        Floatingbuttondrawble = floatingbuttondrawble;
        TabsIconNormal = tabsIconNormal;
        TabsIconSelected = tabsIconSelected;
    }

    public Theme(int id, String name, int actionbarcolor, int tabLayoutColor, int floatingbuttondrawble,  String icontheme,String iconthemeselected) {
        this.id = id;
        this.name = name;
        this.actionbarcolor = actionbarcolor;
        this.tabLayoutColor = tabLayoutColor;
        Floatingbuttondrawble = floatingbuttondrawble;
        TabsIconNormal= this.selecticontheme(icontheme);
        TabsIconSelected= this.selecticontheme(iconthemeselected);
    }

    private   ArrayList<Integer> selecticontheme(String themeoftabicon) {
        ArrayList<Integer> icons=new ArrayList<>();
        switch (themeoftabicon){
            case SELECTED:
                icons.add(R.drawable.ic_tab_bot_selected);
                icons.add(R.drawable.ic_tab_channel_selected);
                icons.add(R.drawable.ic_tab_group_selected);
                icons.add(R.drawable.ic_tab_contact_selected);
                icons.add(R.drawable.ic_tab_favorite_selected);
                icons.add(R.drawable.ic_tab_all_selected);
                icons.add(R.drawable.ic_action_clock);
                break;
            case GREY:
                icons.add(R.drawable.ic_tab_bot_gray);
                icons.add(R.drawable.ic_tab_channel_gray);
                icons.add(R.drawable.ic_tab_group_gray);
                icons.add(R.drawable.ic_tab_contact_gray);
                icons.add(R.drawable.ic_tab_favorite_gray);
                icons.add(R.drawable.ic_tab_all_gray);
                icons.add(R.drawable.ic_tab_unread_gray);
                break;
            case BLUE:
                icons.add(R.drawable.ic_tab_bot_blue);
                icons.add(R.drawable.ic_tab_channel_blue);
                icons.add(R.drawable.ic_tab_group_blue);
                icons.add(R.drawable.ic_tab_contact_blue);
                icons.add(R.drawable.ic_tab_favorite_blue);
                icons.add(R.drawable.ic_tab_all_blue);
                icons.add(R.drawable.ic_tab_unread_blue);
                break;
            default:
                icons.add(R.drawable.ic_tab_bot);
                icons.add(R.drawable.ic_tab_channel);
                icons.add(R.drawable.ic_tab_group);
                icons.add(R.drawable.ic_tab_contact);
                icons.add(R.drawable.ic_tab_favorite);
                icons.add(R.drawable.ic_tab_all);
                icons.add(R.drawable.ic_action_clock_unselected);
        }
       return icons;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getActionbarcolor() {
        return actionbarcolor;
    }

    public void setActionbarcolor(int actionbarcolor) {
        this.actionbarcolor = actionbarcolor;
    }

    public int getTabLayoutColor() {
        return tabLayoutColor;
    }

    public void setTabLayoutColor(int tabLayoutColor) {
        this.tabLayoutColor = tabLayoutColor;
    }

    public int getFloatingbuttondrawble() {
        return Floatingbuttondrawble;
    }

    public void setFloatingbuttondrawble(int floatingbuttondrawble) {
        Floatingbuttondrawble = floatingbuttondrawble;
    }

    public ArrayList<Integer> getTabsIconNormal() {
        return TabsIconNormal;
    }

    public void setTabsIconNormal(ArrayList<Integer> tabsIconNormal) {
        TabsIconNormal = tabsIconNormal;
    }

    public ArrayList<Integer> getTabsIconSelected() {
        return TabsIconSelected;
    }

    public void setTabsIconSelected(ArrayList<Integer> tabsIconSelected) {
        TabsIconSelected = tabsIconSelected;
    }
}
