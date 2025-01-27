package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class MenuAdapter extends BaseAdapter {

    /* renamed from: a */
    MenuBuilder f521a;

    /* renamed from: b */
    private int f522b = -1;

    /* renamed from: c */
    private boolean f523c;

    /* renamed from: d */
    private final boolean f524d;

    /* renamed from: e */
    private final LayoutInflater f525e;

    /* renamed from: f */
    private final int f526f;

    public MenuAdapter(MenuBuilder menuBuilder, LayoutInflater layoutInflater, boolean z, int i2) {
        this.f524d = z;
        this.f525e = layoutInflater;
        this.f521a = menuBuilder;
        this.f526f = i2;
        a();
    }

    void a() {
        MenuItemImpl expandedItem = this.f521a.getExpandedItem();
        if (expandedItem != null) {
            ArrayList<MenuItemImpl> nonActionItems = this.f521a.getNonActionItems();
            int size = nonActionItems.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (nonActionItems.get(i2) == expandedItem) {
                    this.f522b = i2;
                    return;
                }
            }
        }
        this.f522b = -1;
    }

    public MenuBuilder getAdapterMenu() {
        return this.f521a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f522b < 0 ? (this.f524d ? this.f521a.getNonActionItems() : this.f521a.getVisibleItems()).size() : r0.size() - 1;
    }

    public boolean getForceShowIcon() {
        return this.f523c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f525e.inflate(this.f526f, viewGroup, false);
        }
        int groupId = getItem(i2).getGroupId();
        int i3 = i2 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f521a.isGroupDividerEnabled() && groupId != (i3 >= 0 ? getItem(i3).getGroupId() : groupId));
        MenuView.ItemView itemView = (MenuView.ItemView) view;
        if (this.f523c) {
            listMenuItemView.setForceShowIcon(true);
        }
        itemView.initialize(getItem(i2), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }

    public void setForceShowIcon(boolean z) {
        this.f523c = z;
    }

    @Override // android.widget.Adapter
    public MenuItemImpl getItem(int i2) {
        ArrayList<MenuItemImpl> nonActionItems = this.f524d ? this.f521a.getNonActionItems() : this.f521a.getVisibleItems();
        int i3 = this.f522b;
        if (i3 >= 0 && i2 >= i3) {
            i2++;
        }
        return nonActionItems.get(i2);
    }
}
