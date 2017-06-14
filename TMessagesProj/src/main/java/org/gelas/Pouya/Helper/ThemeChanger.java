package org.gelas.Pouya.Helper;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.ImageView;

import org.gelas.Pouya.Models.Theme;
import org.gelas.Pouya.Setting.Setting;
import org.gelas.messenger.R;
import org.gelas.ui.ActionBar.ActionBar;

import java.util.ArrayList;

/**
 * Created by Pouya on 6/14/2016.
 */
public class ThemeChanger {
    private static ArrayList<View> views=new ArrayList<>();
    private static ArrayList<Theme> themes=new ArrayList<>();
    private static Theme currenttheme;
    private static ImageView floatingbutton;
    private static View TabHost;
    public static void setcurrent(Theme t){
        currenttheme=t;
        Setting.setTheme(t.getId());
    }
    public static Theme getcurrent(){
        if(currenttheme==null||themes.size()==0) {
            LoadThemes();
            currenttheme = themes.get(Setting.getTheme());

        }
        return currenttheme;
    }
    public static void addView(View view){
        views.add(view);
    }
    public static ArrayList<Theme> LoadThemes(){
        if(themes!=null&&themes.size()>0)return themes;
        ArrayList<Integer> d=new ArrayList<>();
        themes.add(new Theme(0,"Blue",org.gelas.ui.ActionBar.Theme.ACTION_BAR_COLOR,org.gelas.ui.ActionBar.Theme.ACTION_BAR_COLOR,R.drawable.floating_states,Theme.NORMAL,Theme.SELECTED));
        themes.add(new Theme(1,"HotBlue",Color.parseColor("#0065ff"),Color.parseColor("#0065ff"),R.drawable.floating_pressed_hotblue,Theme.NORMAL,Theme.SELECTED));
        themes.add(new Theme(2,"cyan",Color.parseColor("#00BCD4"),Color.parseColor("#00BCD4"),R.drawable.floating_cyan,Theme.NORMAL,Theme.SELECTED));
        themes.add(new Theme(3,"Hotgreen",Color.parseColor("#0C867B"),Color.parseColor("#0C867B"),R.drawable.floating_pressed_green,Theme.NORMAL,Theme.SELECTED));
        themes.add(new Theme(4,"green",Color.parseColor("#9CCC65"),Color.parseColor("#9CCC65"),R.drawable.floating_lightgreen,Theme.NORMAL,Theme.SELECTED));
        themes.add(new Theme(5,"lightgreen",Color.parseColor("#8BC34A"),Color.parseColor("#8BC34A"),R.drawable.floating_m_lightgreen,Theme.NORMAL,Theme.SELECTED));
        themes.add(new Theme(6,"bluegreen",Color.parseColor("#10AA9C"),Color.parseColor("#10AA9C"),R.drawable.floating_green,Theme.NORMAL,Theme.SELECTED));
        themes.add(new Theme(7,"lemun",Color.parseColor("#FFF568"),Color.parseColor("#FFF568"),R.drawable.floating_pressed_lemun,Theme.GREY,Theme.BLUE));
        themes.add(new Theme(8,"ping",Color.parseColor("#EC407A"),Color.parseColor("#EC407A"),R.drawable.floating_pink,Theme.NORMAL,Theme.SELECTED));
        themes.add(new Theme(9, "Red", Color.parseColor("#F44336"), Color.parseColor("#F44336"), R.drawable.floating_red, Theme.NORMAL, Theme.SELECTED));
        themes.add(new Theme(10, "LightRed", Color.parseColor("#E57373"), Color.parseColor("#E57373"), R.drawable.floating_pressed_red, Theme.NORMAL, Theme.SELECTED));
        themes.add(new Theme(11, "purple", Color.parseColor("#AB47BC"), Color.parseColor("#AB47BC"), R.drawable.floating_m_purple, Theme.NORMAL, Theme.SELECTED));
        themes.add(new Theme(12, "Brown", Color.parseColor("#795548"), Color.parseColor("#795548"), R.drawable.floating_brown, Theme.NORMAL, Theme.SELECTED));
        themes.add(new Theme(13, "Dark", Color.parseColor("#3C3F41"), Color.parseColor("#3C3F41"), R.drawable.floating_bluegrey, Theme.NORMAL, Theme.SELECTED));
        themes.add(new Theme(14, "black", Color.parseColor("#000000"), Color.parseColor("#000000"), R.drawable.floating_pressed_black, Theme.NORMAL, Theme.SELECTED));
        themes.add(new Theme(15, "bluegreen", Color.parseColor("#005926"), Color.parseColor("#005B7E"), R.drawable.floating_blue_green, Theme.NORMAL, Theme.SELECTED));
        themes.add(new Theme(16, "pinkred", Color.parseColor("#ED145B"), Color.parseColor("#EE1C25"), R.drawable.floating_pink_red, Theme.NORMAL, Theme.SELECTED));
        themes.add(new Theme(17, "orangered", Color.parseColor("#F8941D"), Color.parseColor("#EE1C25"), R.drawable.floating_orange_red, Theme.NORMAL, Theme.SELECTED));
        themes.add(new Theme(18, "bluegreen", Color.parseColor("#00BCD4"), Color.parseColor("#9CCC65"), R.drawable.floating_blue_green, Theme.NORMAL, Theme.SELECTED));
        themes.add(new Theme(19, "hotbluegreen", Color.parseColor("#517DA2"), Color.parseColor("#517DA2"), R.drawable.floating_pressed_hotblue_green, Theme.NORMAL, Theme.SELECTED));
       return themes;
    }
    public static void ChangeTheme(Theme theme){
        setcurrent(theme);
        ActionBar.ChangeColor();

        for(int i=0;i<views.size();i++){
            if(views==null){
                views.remove(i);
                i--;

            }else{
                views.get(i).setBackgroundColor(theme.getActionbarcolor());
            }

        }
        TabHost.setBackgroundColor(theme.getTabLayoutColor());
        ThemeChanger.floatingbutton.setBackgroundResource(theme.getFloatingbuttondrawble());
    }
    public static void EditActionbar(View actionbar){
        actionbar.setBackgroundColor(ThemeChanger.getcurrent().getActionbarcolor());
    }

    public static void setFloatingbutton(ImageView floatingbutton) {
        ThemeChanger.floatingbutton = floatingbutton;
    }

    public static void settabhost(TabLayout tabhost) {
        ThemeChanger.TabHost = tabhost;
    }
}
