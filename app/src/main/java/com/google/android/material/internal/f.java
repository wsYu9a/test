package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Dimension;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import com.google.android.material.R;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class f implements MenuPresenter {

    /* renamed from: a */
    private static final String f7332a = "android:menu:list";

    /* renamed from: b */
    private static final String f7333b = "android:menu:adapter";

    /* renamed from: c */
    private static final String f7334c = "android:menu:header";

    /* renamed from: d */
    private NavigationMenuView f7335d;

    /* renamed from: e */
    LinearLayout f7336e;

    /* renamed from: f */
    private MenuPresenter.Callback f7337f;

    /* renamed from: g */
    MenuBuilder f7338g;

    /* renamed from: h */
    private int f7339h;

    /* renamed from: i */
    c f7340i;

    /* renamed from: j */
    LayoutInflater f7341j;
    int k;
    boolean l;
    ColorStateList m;
    ColorStateList n;
    Drawable o;
    int p;
    int q;
    int r;
    boolean s;
    private int u;
    private int v;
    int w;
    boolean t = true;
    private int x = -1;
    final View.OnClickListener y = new a();

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = true;
            f.this.B(true);
            MenuItemImpl itemData = ((NavigationMenuItemView) view).getItemData();
            f fVar = f.this;
            boolean performItemAction = fVar.f7338g.performItemAction(itemData, fVar, 0);
            if (itemData != null && itemData.isCheckable() && performItemAction) {
                f.this.f7340i.M(itemData);
            } else {
                z = false;
            }
            f.this.B(false);
            if (z) {
                f.this.updateMenuView(false);
            }
        }
    }

    private static class b extends l {
        public b(View view) {
            super(view);
        }
    }

    private class c extends RecyclerView.Adapter<l> {

        /* renamed from: a */
        private static final String f7343a = "android:menu:checked";

        /* renamed from: b */
        private static final String f7344b = "android:menu:action_views";

        /* renamed from: c */
        private static final int f7345c = 0;

        /* renamed from: d */
        private static final int f7346d = 1;

        /* renamed from: e */
        private static final int f7347e = 2;

        /* renamed from: f */
        private static final int f7348f = 3;

        /* renamed from: g */
        private final ArrayList<e> f7349g = new ArrayList<>();

        /* renamed from: h */
        private MenuItemImpl f7350h;

        /* renamed from: i */
        private boolean f7351i;

        c() {
            K();
        }

        private void K() {
            if (this.f7351i) {
                return;
            }
            this.f7351i = true;
            this.f7349g.clear();
            this.f7349g.add(new d());
            int i2 = -1;
            int size = f.this.f7338g.getVisibleItems().size();
            boolean z = false;
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                MenuItemImpl menuItemImpl = f.this.f7338g.getVisibleItems().get(i4);
                if (menuItemImpl.isChecked()) {
                    M(menuItemImpl);
                }
                if (menuItemImpl.isCheckable()) {
                    menuItemImpl.setExclusiveCheckable(false);
                }
                if (menuItemImpl.hasSubMenu()) {
                    SubMenu subMenu = menuItemImpl.getSubMenu();
                    if (subMenu.hasVisibleItems()) {
                        if (i4 != 0) {
                            this.f7349g.add(new C0094f(f.this.w, 0));
                        }
                        this.f7349g.add(new g(menuItemImpl));
                        int size2 = this.f7349g.size();
                        int size3 = subMenu.size();
                        boolean z2 = false;
                        for (int i5 = 0; i5 < size3; i5++) {
                            MenuItemImpl menuItemImpl2 = (MenuItemImpl) subMenu.getItem(i5);
                            if (menuItemImpl2.isVisible()) {
                                if (!z2 && menuItemImpl2.getIcon() != null) {
                                    z2 = true;
                                }
                                if (menuItemImpl2.isCheckable()) {
                                    menuItemImpl2.setExclusiveCheckable(false);
                                }
                                if (menuItemImpl.isChecked()) {
                                    M(menuItemImpl);
                                }
                                this.f7349g.add(new g(menuItemImpl2));
                            }
                        }
                        if (z2) {
                            b(size2, this.f7349g.size());
                        }
                    }
                } else {
                    int groupId = menuItemImpl.getGroupId();
                    if (groupId != i2) {
                        i3 = this.f7349g.size();
                        z = menuItemImpl.getIcon() != null;
                        if (i4 != 0) {
                            i3++;
                            ArrayList<e> arrayList = this.f7349g;
                            int i6 = f.this.w;
                            arrayList.add(new C0094f(i6, i6));
                        }
                    } else if (!z && menuItemImpl.getIcon() != null) {
                        b(i3, this.f7349g.size());
                        z = true;
                    }
                    g gVar = new g(menuItemImpl);
                    gVar.f7356b = z;
                    this.f7349g.add(gVar);
                    i2 = groupId;
                }
            }
            this.f7351i = false;
        }

        private void b(int i2, int i3) {
            while (i2 < i3) {
                ((g) this.f7349g.get(i2)).f7356b = true;
                i2++;
            }
        }

        @NonNull
        public Bundle E() {
            Bundle bundle = new Bundle();
            MenuItemImpl menuItemImpl = this.f7350h;
            if (menuItemImpl != null) {
                bundle.putInt(f7343a, menuItemImpl.getItemId());
            }
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            int size = this.f7349g.size();
            for (int i2 = 0; i2 < size; i2++) {
                e eVar = this.f7349g.get(i2);
                if (eVar instanceof g) {
                    MenuItemImpl a2 = ((g) eVar).a();
                    View actionView = a2 != null ? a2.getActionView() : null;
                    if (actionView != null) {
                        com.google.android.material.internal.h hVar = new com.google.android.material.internal.h();
                        actionView.saveHierarchyState(hVar);
                        sparseArray.put(a2.getItemId(), hVar);
                    }
                }
            }
            bundle.putSparseParcelableArray(f7344b, sparseArray);
            return bundle;
        }

        public MenuItemImpl F() {
            return this.f7350h;
        }

        int G() {
            int i2 = f.this.f7336e.getChildCount() == 0 ? 0 : 1;
            for (int i3 = 0; i3 < f.this.f7340i.getItemCount(); i3++) {
                if (f.this.f7340i.getItemViewType(i3) == 0) {
                    i2++;
                }
            }
            return i2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: H */
        public void onBindViewHolder(@NonNull l lVar, int i2) {
            int itemViewType = getItemViewType(i2);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    ((TextView) lVar.itemView).setText(((g) this.f7349g.get(i2)).a().getTitle());
                    return;
                } else {
                    if (itemViewType != 2) {
                        return;
                    }
                    C0094f c0094f = (C0094f) this.f7349g.get(i2);
                    lVar.itemView.setPadding(0, c0094f.b(), 0, c0094f.a());
                    return;
                }
            }
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) lVar.itemView;
            navigationMenuItemView.setIconTintList(f.this.n);
            f fVar = f.this;
            if (fVar.l) {
                navigationMenuItemView.setTextAppearance(fVar.k);
            }
            ColorStateList colorStateList = f.this.m;
            if (colorStateList != null) {
                navigationMenuItemView.setTextColor(colorStateList);
            }
            Drawable drawable = f.this.o;
            ViewCompat.setBackground(navigationMenuItemView, drawable != null ? drawable.getConstantState().newDrawable() : null);
            g gVar = (g) this.f7349g.get(i2);
            navigationMenuItemView.setNeedsEmptyIcon(gVar.f7356b);
            navigationMenuItemView.setHorizontalPadding(f.this.p);
            navigationMenuItemView.setIconPadding(f.this.q);
            f fVar2 = f.this;
            if (fVar2.s) {
                navigationMenuItemView.setIconSize(fVar2.r);
            }
            navigationMenuItemView.setMaxLines(f.this.u);
            navigationMenuItemView.initialize(gVar.a(), 0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @Nullable
        /* renamed from: I */
        public l onCreateViewHolder(ViewGroup viewGroup, int i2) {
            if (i2 == 0) {
                f fVar = f.this;
                return new i(fVar.f7341j, viewGroup, fVar.y);
            }
            if (i2 == 1) {
                return new k(f.this.f7341j, viewGroup);
            }
            if (i2 == 2) {
                return new j(f.this.f7341j, viewGroup);
            }
            if (i2 != 3) {
                return null;
            }
            return new b(f.this.f7336e);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: J */
        public void onViewRecycled(l lVar) {
            if (lVar instanceof i) {
                ((NavigationMenuItemView) lVar.itemView).w();
            }
        }

        public void L(@NonNull Bundle bundle) {
            MenuItemImpl a2;
            View actionView;
            com.google.android.material.internal.h hVar;
            MenuItemImpl a3;
            int i2 = bundle.getInt(f7343a, 0);
            if (i2 != 0) {
                this.f7351i = true;
                int size = this.f7349g.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        break;
                    }
                    e eVar = this.f7349g.get(i3);
                    if ((eVar instanceof g) && (a3 = ((g) eVar).a()) != null && a3.getItemId() == i2) {
                        M(a3);
                        break;
                    }
                    i3++;
                }
                this.f7351i = false;
                K();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(f7344b);
            if (sparseParcelableArray != null) {
                int size2 = this.f7349g.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    e eVar2 = this.f7349g.get(i4);
                    if ((eVar2 instanceof g) && (a2 = ((g) eVar2).a()) != null && (actionView = a2.getActionView()) != null && (hVar = (com.google.android.material.internal.h) sparseParcelableArray.get(a2.getItemId())) != null) {
                        actionView.restoreHierarchyState(hVar);
                    }
                }
            }
        }

        public void M(@NonNull MenuItemImpl menuItemImpl) {
            if (this.f7350h == menuItemImpl || !menuItemImpl.isCheckable()) {
                return;
            }
            MenuItemImpl menuItemImpl2 = this.f7350h;
            if (menuItemImpl2 != null) {
                menuItemImpl2.setChecked(false);
            }
            this.f7350h = menuItemImpl;
            menuItemImpl.setChecked(true);
        }

        public void N(boolean z) {
            this.f7351i = z;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f7349g.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i2) {
            e eVar = this.f7349g.get(i2);
            if (eVar instanceof C0094f) {
                return 2;
            }
            if (eVar instanceof d) {
                return 3;
            }
            if (eVar instanceof g) {
                return ((g) eVar).a().hasSubMenu() ? 1 : 0;
            }
            throw new RuntimeException("Unknown item type.");
        }

        public void update() {
            K();
            notifyDataSetChanged();
        }
    }

    private static class d implements e {
        d() {
        }
    }

    private interface e {
    }

    /* renamed from: com.google.android.material.internal.f$f */
    private static class C0094f implements e {

        /* renamed from: a */
        private final int f7353a;

        /* renamed from: b */
        private final int f7354b;

        public C0094f(int i2, int i3) {
            this.f7353a = i2;
            this.f7354b = i3;
        }

        public int a() {
            return this.f7354b;
        }

        public int b() {
            return this.f7353a;
        }
    }

    private static class g implements e {

        /* renamed from: a */
        private final MenuItemImpl f7355a;

        /* renamed from: b */
        boolean f7356b;

        g(MenuItemImpl menuItemImpl) {
            this.f7355a = menuItemImpl;
        }

        public MenuItemImpl a() {
            return this.f7355a;
        }
    }

    private class h extends RecyclerViewAccessibilityDelegate {
        h(@NonNull RecyclerView recyclerView) {
            super(recyclerView);
        }

        @Override // androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(f.this.f7340i.G(), 0, false));
        }
    }

    private static class i extends l {
        public i(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(R.layout.design_navigation_item, viewGroup, false));
            this.itemView.setOnClickListener(onClickListener);
        }
    }

    private static class j extends l {
        public j(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.design_navigation_item_separator, viewGroup, false));
        }
    }

    private static class k extends l {
        public k(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.design_navigation_item_subheader, viewGroup, false));
        }
    }

    private static abstract class l extends RecyclerView.ViewHolder {
        public l(View view) {
            super(view);
        }
    }

    private void C() {
        int i2 = (this.f7336e.getChildCount() == 0 && this.t) ? this.v : 0;
        NavigationMenuView navigationMenuView = this.f7335d;
        navigationMenuView.setPadding(0, i2, 0, navigationMenuView.getPaddingBottom());
    }

    public void A(int i2) {
        this.x = i2;
        NavigationMenuView navigationMenuView = this.f7335d;
        if (navigationMenuView != null) {
            navigationMenuView.setOverScrollMode(i2);
        }
    }

    public void B(boolean z) {
        c cVar = this.f7340i;
        if (cVar != null) {
            cVar.N(z);
        }
    }

    public void b(@NonNull View view) {
        this.f7336e.addView(view);
        NavigationMenuView navigationMenuView = this.f7335d;
        navigationMenuView.setPadding(0, 0, 0, navigationMenuView.getPaddingBottom());
    }

    public void c(@NonNull WindowInsetsCompat windowInsetsCompat) {
        int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
        if (this.v != systemWindowInsetTop) {
            this.v = systemWindowInsetTop;
            C();
        }
        NavigationMenuView navigationMenuView = this.f7335d;
        navigationMenuView.setPadding(0, navigationMenuView.getPaddingTop(), 0, windowInsetsCompat.getSystemWindowInsetBottom());
        ViewCompat.dispatchApplyWindowInsets(this.f7336e, windowInsetsCompat);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Nullable
    public MenuItemImpl d() {
        return this.f7340i.F();
    }

    public int e() {
        return this.f7336e.getChildCount();
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public View f(int i2) {
        return this.f7336e.getChildAt(i2);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Nullable
    public Drawable g() {
        return this.o;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.f7339h;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup viewGroup) {
        if (this.f7335d == null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) this.f7341j.inflate(R.layout.design_navigation_menu, viewGroup, false);
            this.f7335d = navigationMenuView;
            navigationMenuView.setAccessibilityDelegateCompat(new h(this.f7335d));
            if (this.f7340i == null) {
                this.f7340i = new c();
            }
            int i2 = this.x;
            if (i2 != -1) {
                this.f7335d.setOverScrollMode(i2);
            }
            this.f7336e = (LinearLayout) this.f7341j.inflate(R.layout.design_navigation_item_header, (ViewGroup) this.f7335d, false);
            this.f7335d.setAdapter(this.f7340i);
        }
        return this.f7335d;
    }

    public int h() {
        return this.p;
    }

    public int i() {
        return this.q;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(@NonNull Context context, @NonNull MenuBuilder menuBuilder) {
        this.f7341j = LayoutInflater.from(context);
        this.f7338g = menuBuilder;
        this.w = context.getResources().getDimensionPixelOffset(R.dimen.design_navigation_separator_vertical_padding);
    }

    public int j() {
        return this.u;
    }

    @Nullable
    public ColorStateList k() {
        return this.m;
    }

    @Nullable
    public ColorStateList l() {
        return this.n;
    }

    public View m(@LayoutRes int i2) {
        View inflate = this.f7341j.inflate(i2, (ViewGroup) this.f7336e, false);
        b(inflate);
        return inflate;
    }

    public boolean n() {
        return this.t;
    }

    public void o(@NonNull View view) {
        this.f7336e.removeView(view);
        if (this.f7336e.getChildCount() == 0) {
            NavigationMenuView navigationMenuView = this.f7335d;
            navigationMenuView.setPadding(0, this.v, 0, navigationMenuView.getPaddingBottom());
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        MenuPresenter.Callback callback = this.f7337f;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, z);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.f7335d.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle(f7333b);
            if (bundle2 != null) {
                this.f7340i.L(bundle2);
            }
            SparseArray sparseParcelableArray2 = bundle.getSparseParcelableArray(f7334c);
            if (sparseParcelableArray2 != null) {
                this.f7336e.restoreHierarchyState(sparseParcelableArray2);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    @NonNull
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        if (this.f7335d != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f7335d.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        c cVar = this.f7340i;
        if (cVar != null) {
            bundle.putBundle(f7333b, cVar.E());
        }
        if (this.f7336e != null) {
            SparseArray<? extends Parcelable> sparseArray2 = new SparseArray<>();
            this.f7336e.saveHierarchyState(sparseArray2);
            bundle.putSparseParcelableArray(f7334c, sparseArray2);
        }
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    public void p(boolean z) {
        if (this.t != z) {
            this.t = z;
            C();
        }
    }

    public void q(@NonNull MenuItemImpl menuItemImpl) {
        this.f7340i.M(menuItemImpl);
    }

    public void r(int i2) {
        this.f7339h = i2;
    }

    public void s(@Nullable Drawable drawable) {
        this.o = drawable;
        updateMenuView(false);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback callback) {
        this.f7337f = callback;
    }

    public void t(int i2) {
        this.p = i2;
        updateMenuView(false);
    }

    public void u(int i2) {
        this.q = i2;
        updateMenuView(false);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        c cVar = this.f7340i;
        if (cVar != null) {
            cVar.update();
        }
    }

    public void v(@Dimension int i2) {
        if (this.r != i2) {
            this.r = i2;
            this.s = true;
            updateMenuView(false);
        }
    }

    public void w(@Nullable ColorStateList colorStateList) {
        this.n = colorStateList;
        updateMenuView(false);
    }

    public void x(int i2) {
        this.u = i2;
        updateMenuView(false);
    }

    public void y(@StyleRes int i2) {
        this.k = i2;
        this.l = true;
        updateMenuView(false);
    }

    public void z(@Nullable ColorStateList colorStateList) {
        this.m = colorStateList;
        updateMenuView(false);
    }
}
