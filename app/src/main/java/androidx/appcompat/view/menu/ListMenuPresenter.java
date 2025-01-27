package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ListMenuPresenter implements MenuPresenter, AdapterView.OnItemClickListener {
    public static final String VIEWS_TAG = "android:menu:list";

    /* renamed from: a */
    private static final String f509a = "ListMenuPresenter";

    /* renamed from: b */
    Context f510b;

    /* renamed from: c */
    LayoutInflater f511c;

    /* renamed from: d */
    MenuBuilder f512d;

    /* renamed from: e */
    ExpandedMenuView f513e;

    /* renamed from: f */
    int f514f;

    /* renamed from: g */
    int f515g;

    /* renamed from: h */
    int f516h;

    /* renamed from: i */
    private MenuPresenter.Callback f517i;

    /* renamed from: j */
    MenuAdapter f518j;
    private int k;

    private class MenuAdapter extends BaseAdapter {

        /* renamed from: a */
        private int f519a = -1;

        public MenuAdapter() {
            a();
        }

        void a() {
            MenuItemImpl expandedItem = ListMenuPresenter.this.f512d.getExpandedItem();
            if (expandedItem != null) {
                ArrayList<MenuItemImpl> nonActionItems = ListMenuPresenter.this.f512d.getNonActionItems();
                int size = nonActionItems.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (nonActionItems.get(i2) == expandedItem) {
                        this.f519a = i2;
                        return;
                    }
                }
            }
            this.f519a = -1;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = ListMenuPresenter.this.f512d.getNonActionItems().size() - ListMenuPresenter.this.f514f;
            return this.f519a < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                ListMenuPresenter listMenuPresenter = ListMenuPresenter.this;
                view = listMenuPresenter.f511c.inflate(listMenuPresenter.f516h, viewGroup, false);
            }
            ((MenuView.ItemView) view).initialize(getItem(i2), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public MenuItemImpl getItem(int i2) {
            ArrayList<MenuItemImpl> nonActionItems = ListMenuPresenter.this.f512d.getNonActionItems();
            int i3 = i2 + ListMenuPresenter.this.f514f;
            int i4 = this.f519a;
            if (i4 >= 0 && i3 >= i4) {
                i3++;
            }
            return nonActionItems.get(i3);
        }
    }

    public ListMenuPresenter(Context context, int i2) {
        this(i2, 0);
        this.f510b = context;
        this.f511c = LayoutInflater.from(context);
    }

    int a() {
        return this.f514f;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    public ListAdapter getAdapter() {
        if (this.f518j == null) {
            this.f518j = new MenuAdapter();
        }
        return this.f518j;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.k;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup viewGroup) {
        if (this.f513e == null) {
            this.f513e = (ExpandedMenuView) this.f511c.inflate(R.layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.f518j == null) {
                this.f518j = new MenuAdapter();
            }
            this.f513e.setAdapter((ListAdapter) this.f518j);
            this.f513e.setOnItemClickListener(this);
        }
        return this.f513e;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        if (this.f515g != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.f515g);
            this.f510b = contextThemeWrapper;
            this.f511c = LayoutInflater.from(contextThemeWrapper);
        } else if (this.f510b != null) {
            this.f510b = context;
            if (this.f511c == null) {
                this.f511c = LayoutInflater.from(context);
            }
        }
        this.f512d = menuBuilder;
        MenuAdapter menuAdapter = this.f518j;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        MenuPresenter.Callback callback = this.f517i;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, z);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        this.f512d.performItemAction(this.f518j.getItem(i2), this, 0);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
        restoreHierarchyState((Bundle) parcelable);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        if (this.f513e == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        saveHierarchyState(bundle);
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        new MenuDialogHelper(subMenuBuilder).show(null);
        MenuPresenter.Callback callback = this.f517i;
        if (callback == null) {
            return true;
        }
        callback.onOpenSubMenu(subMenuBuilder);
        return true;
    }

    public void restoreHierarchyState(Bundle bundle) {
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(VIEWS_TAG);
        if (sparseParcelableArray != null) {
            this.f513e.restoreHierarchyState(sparseParcelableArray);
        }
    }

    public void saveHierarchyState(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        ExpandedMenuView expandedMenuView = this.f513e;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray(VIEWS_TAG, sparseArray);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback callback) {
        this.f517i = callback;
    }

    public void setId(int i2) {
        this.k = i2;
    }

    public void setItemIndexOffset(int i2) {
        this.f514f = i2;
        if (this.f513e != null) {
            updateMenuView(false);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        MenuAdapter menuAdapter = this.f518j;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }

    public ListMenuPresenter(int i2, int i3) {
        this.f516h = i2;
        this.f515g = i3;
    }
}
