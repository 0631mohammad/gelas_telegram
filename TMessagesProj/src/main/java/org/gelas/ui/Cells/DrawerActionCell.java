/*
 * This is the source code of Telegram for Android v. 3.x.x.
 * It is licensed under GNU GPL v. 2 or later.
 * You should have received a copy of the license in this archive (see LICENSE).
 *
 * Copyright Nikolai Kudashov, 2013-2016.
 */

package org.gelas.ui.Cells;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import org.gelas.messenger.AndroidUtilities;
import org.gelas.messenger.FileLog;
import org.gelas.ui.Components.LayoutHelper;

public class DrawerActionCell extends FrameLayout {

    private  ImageView img;
    private TextView textView;

    public DrawerActionCell(Context context) {
        super(context);


         img=new ImageView(context);

        img.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        addView(img, LayoutHelper.createFrame(LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL | Gravity.TOP, 14, 0, 16, 10));
        textView = new TextView(context);
        textView.setTextColor(0xff444444);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);
        textView.setTypeface(AndroidUtilities.getTypeface("fonts/byekan.ttf"));
        textView.setLines(1);
        textView.setMaxLines(1);
        textView.setPadding(0, 25, 0, 0);
        textView.setSingleLine(true);
        textView.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM  );
        textView.setTextAlignment(TEXT_ALIGNMENT_GRAVITY);
      //  textView.setCompoundDrawablePadding(AndroidUtilities.dp(34));
        addView(textView, LayoutHelper.createFrame(LayoutHelper.MATCH_PARENT, LayoutHelper.MATCH_PARENT, Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM, 0, 0, 0, 0));
        this.setBackgroundColor(Color.parseColor("#FFFFFF"));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(75), MeasureSpec.EXACTLY));
    }

    public void setTextAndIcon(String text, int resId) {
        try {
            textView.setText(text);
           // textView.setCompoundDrawablesWithIntrinsicBounds(resId, 0, 0, 0);
            img.setImageResource(resId);
        } catch (Throwable e) {
            FileLog.e("tmessages", e);
        }
    }
}
