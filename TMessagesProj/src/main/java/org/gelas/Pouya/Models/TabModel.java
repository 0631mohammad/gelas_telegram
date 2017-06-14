package org.gelas.Pouya.Models;

import org.gelas.Pouya.Helper.ThemeChanger;

/**
 * Created by Pouya on 6/13/2016.
 */
public class TabModel {
    private int id;
    private int title;
    private int selectedicon;
    private int unselectedicon;

    public TabModel() {
    }

    public TabModel(int id, int title, int unselectedicon,int selectedicon) {

        this.selectedicon = selectedicon;
        this.unselectedicon = unselectedicon;
    }

    public TabModel(int id, int title) {
        this.id = id;
        this.title = title;
         this.selectedicon= ThemeChanger.getcurrent().getTabsIconSelected().get(id);
         this.unselectedicon= ThemeChanger.getcurrent().getTabsIconNormal().get(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public int getSelectedicon() {
        return selectedicon;
    }

    public void setSelectedicon(int selectedicon) {
        this.selectedicon = selectedicon;
    }

    public int getUnselectedicon() {
        return unselectedicon;
    }

    public void setUnselectedicon(int unselectedicon) {
        this.unselectedicon = unselectedicon;
    }
}
