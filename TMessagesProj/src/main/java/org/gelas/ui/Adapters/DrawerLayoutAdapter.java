/*
 * This is the source code of Telegram for Android v. 3.x.x.
 * It is licensed under GNU GPL v. 2 or later.
 * You should have received a copy of the license in this archive (see LICENSE).
 *
 * Copyright Nikolai Kudashov, 2013-2016.
 */

package org.gelas.ui.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.gelas.messenger.AndroidUtilities;
import org.gelas.messenger.LocaleController;
import org.gelas.messenger.MessagesController;
import org.gelas.messenger.R;
import org.gelas.messenger.UserConfig;
import org.gelas.ui.Cells.DrawerActionCell;
import org.gelas.ui.Cells.DividerCell;
import org.gelas.ui.Cells.EmptyCell;
import org.gelas.ui.Cells.DrawerProfileCell;

public class DrawerLayoutAdapter extends BaseAdapter {

    private Context mContext;

    public DrawerLayoutAdapter(Context context) {
        mContext = context;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int i) {
        return true;
    }

    @Override
    public int getCount() {
        return UserConfig.isClientActivated() ? 12 : 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        int type =3;// getItemViewType(i);
        if (type == 0) {
            if (view == null) {
                view = new DrawerProfileCell(mContext);
            }
            ((DrawerProfileCell) view).setUser(MessagesController.getInstance().getUser(UserConfig.getClientUserId()));
        } else if (type == 1) {
            if (view == null) {
                view = new EmptyCell(mContext, AndroidUtilities.dp(8));
            }
        } else if (type == 2) {
            if (view == null) {
                view = new DividerCell(mContext);
            }
        } else if (type == 3) {
            if (view == null) {
                view = new DrawerActionCell(mContext);
            }
            DrawerActionCell actionCell = (DrawerActionCell) view;
            if (i == 0) {
                actionCell.setTextAndIcon(LocaleController.getString("NewGroup", R.string.NewGroup), R.mipmap.ic_group);
            } else if (i == 1) {
                actionCell.setTextAndIcon(LocaleController.getString("NewSecretChat", R.string.NewSecretChat), R.mipmap.ic_secretchat);
            } else if (i == 2) {
                actionCell.setTextAndIcon(LocaleController.getString("NewChannel", R.string.NewChannel), R.mipmap.ic_channal);
            } else if (i == 3) {
                actionCell.setTextAndIcon(LocaleController.getString("Contacts", R.string.Contacts), R.mipmap.ic_contacts);
            } else if (i == 4) {
                actionCell.setTextAndIcon(LocaleController.getString("GhostMode", R.string.GhostMode), R.mipmap.ic_firewall);
            }else if (i == 5) {
                actionCell.setTextAndIcon(LocaleController.getString("answeringmachine", R.string.answeringmachine), R.mipmap.ic_answeringmachine);
            } else if (i == 6) {
                actionCell.setTextAndIcon(LocaleController.getString("Themes", R.string.Themes), R.mipmap.ic_theme);
            }  else if (i == 7) {
                actionCell.setTextAndIcon(LocaleController.getString("PouyaSoft", R.string.telegramgelas), R.mipmap.ic_pouyasoft);
            } else if (i == 8) {
                actionCell.setTextAndIcon(LocaleController.getString("PouyaSoftChannal", R.string.telegramgelasChannal), R.mipmap.gelas);
            } else if (i == 9) {
                actionCell.setTextAndIcon(LocaleController.getString("Settings", R.string.Settings), R.mipmap.ic_settings);
            }else if (i == 10) {
                actionCell.setTextAndIcon(LocaleController.getString("AboutApp", R.string.aboutapp), R.mipmap.gelas);

            }else if (i ==11) {
                actionCell.setTextAndIcon(LocaleController.getString("TelegramFaq", R.string.TelegramFaq), R.mipmap.ic_web);
             }
        }


        return view;
    }

    @Override
    public int getItemViewType(int i) {
        if (i == 0) {
            return 0;
        } else if (i == 1) {
            return 1;
        } else if (i == 5) {
            return 2;
        }
        return 3;
    }

    @Override
    public int getViewTypeCount() {
        return 4;
    }

    @Override
    public boolean isEmpty() {
        return !UserConfig.isClientActivated();
    }
}
