package org.gelas.Pouya.Adapter;

/**
 * Created by Pouya on 6/13/2016.
 */
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import org.gelas.Pouya.Helper.ThemeChanger;
import org.gelas.Pouya.Models.Theme;
import org.gelas.messenger.AndroidUtilities;

import java.util.ArrayList;

public class SelectColorAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Theme> themes;

    // Constructor
    public SelectColorAdapter(Context c){
        mContext = c;
        themes=ThemeChanger.LoadThemes();
    }

    @Override
    public int getCount() {
        return themes.size();
    }

    @Override
    public Theme getItem(int position) {
        return themes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout viv=new LinearLayout(mContext);
        viv.setOrientation(LinearLayout.VERTICAL);
        ImageView imageView = new ImageView(mContext);
        imageView.setBackgroundColor(themes.get(position).getActionbarcolor());
        imageView.setLayoutParams(new GridView.LayoutParams(GridView.LayoutParams.MATCH_PARENT, AndroidUtilities.dp(25)));
        viv.addView(imageView);
        ImageView imageView2 = new ImageView(mContext);
        imageView2.setBackgroundColor(themes.get(position).getTabLayoutColor());
        imageView2.setLayoutParams(new GridView.LayoutParams(GridView.LayoutParams.MATCH_PARENT, AndroidUtilities.dp(25)));
        viv.addView(imageView2);
        return viv;
    }

}