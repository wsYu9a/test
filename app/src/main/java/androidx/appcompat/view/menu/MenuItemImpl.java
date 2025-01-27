package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class MenuItemImpl implements SupportMenuItem {

    /* renamed from: a */
    private static final String f541a = "MenuItemImpl";

    /* renamed from: b */
    private static final int f542b = 3;

    /* renamed from: c */
    private static final int f543c = 1;

    /* renamed from: d */
    private static final int f544d = 2;

    /* renamed from: e */
    private static final int f545e = 4;

    /* renamed from: f */
    private static final int f546f = 8;

    /* renamed from: g */
    private static final int f547g = 16;

    /* renamed from: h */
    private static final int f548h = 32;

    /* renamed from: i */
    static final int f549i = 0;
    private CharSequence A;
    private CharSequence B;
    private int I;
    private View J;
    private ActionProvider K;
    private MenuItem.OnActionExpandListener L;
    private ContextMenu.ContextMenuInfo N;

    /* renamed from: j */
    private final int f550j;
    private final int k;
    private final int l;
    private final int m;
    private CharSequence n;
    private CharSequence o;
    private Intent p;
    private char q;
    private char s;
    private Drawable u;
    MenuBuilder w;
    private SubMenuBuilder x;
    private Runnable y;
    private MenuItem.OnMenuItemClickListener z;
    private int r = 4096;
    private int t = 4096;
    private int v = 0;
    private ColorStateList C = null;
    private PorterDuff.Mode D = null;
    private boolean E = false;
    private boolean F = false;
    private boolean G = false;
    private int H = 16;
    private boolean M = false;

    /* renamed from: androidx.appcompat.view.menu.MenuItemImpl$1 */
    class AnonymousClass1 implements ActionProvider.VisibilityListener {
        AnonymousClass1() {
        }

        @Override // androidx.core.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z) {
            MenuItemImpl menuItemImpl = MenuItemImpl.this;
            menuItemImpl.w.n(menuItemImpl);
        }
    }

    MenuItemImpl(MenuBuilder menuBuilder, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6) {
        this.I = 0;
        this.w = menuBuilder;
        this.f550j = i3;
        this.k = i2;
        this.l = i4;
        this.m = i5;
        this.n = charSequence;
        this.I = i6;
    }

    private static void a(StringBuilder sb, int i2, int i3, String str) {
        if ((i2 & i3) == i3) {
            sb.append(str);
        }
    }

    private Drawable b(Drawable drawable) {
        if (drawable != null && this.G && (this.E || this.F)) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            if (this.E) {
                DrawableCompat.setTintList(drawable, this.C);
            }
            if (this.F) {
                DrawableCompat.setTintMode(drawable, this.D);
            }
            this.G = false;
        }
        return drawable;
    }

    public void actionFormatChanged() {
        this.w.m(this);
    }

    Runnable c() {
        return this.y;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.I & 8) == 0) {
            return false;
        }
        if (this.J == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.L;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.w.collapseItemActionView(this);
        }
        return false;
    }

    char d() {
        return this.w.isQwertyMode() ? this.s : this.q;
    }

    String e() {
        char d2 = d();
        if (d2 == 0) {
            return "";
        }
        Resources resources = this.w.getContext().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.w.getContext()).hasPermanentMenuKey()) {
            sb.append(resources.getString(R.string.abc_prepend_shortcut_label));
        }
        int i2 = this.w.isQwertyMode() ? this.t : this.r;
        a(sb, i2, 65536, resources.getString(R.string.abc_menu_meta_shortcut_label));
        a(sb, i2, 4096, resources.getString(R.string.abc_menu_ctrl_shortcut_label));
        a(sb, i2, 2, resources.getString(R.string.abc_menu_alt_shortcut_label));
        a(sb, i2, 1, resources.getString(R.string.abc_menu_shift_shortcut_label));
        a(sb, i2, 4, resources.getString(R.string.abc_menu_sym_shortcut_label));
        a(sb, i2, 8, resources.getString(R.string.abc_menu_function_shortcut_label));
        if (d2 == '\b') {
            sb.append(resources.getString(R.string.abc_menu_delete_shortcut_label));
        } else if (d2 == '\n') {
            sb.append(resources.getString(R.string.abc_menu_enter_shortcut_label));
        } else if (d2 != ' ') {
            sb.append(d2);
        } else {
            sb.append(resources.getString(R.string.abc_menu_space_shortcut_label));
        }
        return sb.toString();
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean expandActionView() {
        if (!hasCollapsibleActionView()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.L;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.w.expandItemActionView(this);
        }
        return false;
    }

    CharSequence f(MenuView.ItemView itemView) {
        return (itemView == null || !itemView.prefersCondensedTitle()) ? getTitle() : getTitleCondensed();
    }

    void g(boolean z) {
        int i2 = this.H;
        int i3 = (z ? 2 : 0) | (i2 & (-3));
        this.H = i3;
        if (i2 != i3) {
            this.w.onItemsChanged(false);
        }
    }

    @Override // android.view.MenuItem
    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public View getActionView() {
        View view = this.J;
        if (view != null) {
            return view;
        }
        ActionProvider actionProvider = this.K;
        if (actionProvider == null) {
            return null;
        }
        View onCreateActionView = actionProvider.onCreateActionView(this);
        this.J = onCreateActionView;
        return onCreateActionView;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.t;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.s;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.A;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.k;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.u;
        if (drawable != null) {
            return b(drawable);
        }
        if (this.v == 0) {
            return null;
        }
        Drawable drawable2 = AppCompatResources.getDrawable(this.w.getContext(), this.v);
        this.v = 0;
        this.u = drawable2;
        return b(drawable2);
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.C;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.D;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.p;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f550j;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.N;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public int getNumericModifiers() {
        return this.r;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.q;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.l;
    }

    public int getOrdering() {
        return this.m;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.x;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public ActionProvider getSupportActionProvider() {
        return this.K;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.n;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.o;
        if (charSequence == null) {
            charSequence = this.n;
        }
        return (Build.VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.B;
    }

    void h(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.N = contextMenuInfo;
    }

    public boolean hasCollapsibleActionView() {
        ActionProvider actionProvider;
        if ((this.I & 8) == 0) {
            return false;
        }
        if (this.J == null && (actionProvider = this.K) != null) {
            this.J = actionProvider.onCreateActionView(this);
        }
        return this.J != null;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.x != null;
    }

    boolean i(boolean z) {
        int i2 = this.H;
        int i3 = (z ? 0 : 8) | (i2 & (-9));
        this.H = i3;
        return i2 != i3;
    }

    public boolean invoke() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.z;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        MenuBuilder menuBuilder = this.w;
        if (menuBuilder.c(menuBuilder, this)) {
            return true;
        }
        Runnable runnable = this.y;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.p != null) {
            try {
                this.w.getContext().startActivity(this.p);
                return true;
            } catch (ActivityNotFoundException e2) {
                Log.e(f541a, "Can't find activity to handle intent; ignoring", e2);
            }
        }
        ActionProvider actionProvider = this.K;
        return actionProvider != null && actionProvider.onPerformDefaultAction();
    }

    public boolean isActionButton() {
        return (this.H & 32) == 32;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.M;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.H & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.H & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.H & 16) != 0;
    }

    public boolean isExclusiveCheckable() {
        return (this.H & 4) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        ActionProvider actionProvider = this.K;
        return (actionProvider == null || !actionProvider.overridesItemVisibility()) ? (this.H & 8) == 0 : (this.H & 8) == 0 && this.K.isVisible();
    }

    boolean j() {
        return this.w.isShortcutsVisible() && d() != 0;
    }

    public boolean requestsActionButton() {
        return (this.I & 1) == 1;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public boolean requiresActionButton() {
        return (this.I & 2) == 2;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public boolean requiresOverflow() {
        return (requiresActionButton() || requestsActionButton()) ? false : true;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public void setActionViewExpanded(boolean z) {
        this.M = z;
        this.w.onItemsChanged(false);
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        if (this.s == c2) {
            return this;
        }
        this.s = Character.toLowerCase(c2);
        this.w.onItemsChanged(false);
        return this;
    }

    public MenuItem setCallback(Runnable runnable) {
        this.y = runnable;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        int i2 = this.H;
        int i3 = (z ? 1 : 0) | (i2 & (-2));
        this.H = i3;
        if (i2 != i3) {
            this.w.onItemsChanged(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        if ((this.H & 4) != 0) {
            this.w.p(this);
        } else {
            g(z);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.H |= 16;
        } else {
            this.H &= -17;
        }
        this.w.onItemsChanged(false);
        return this;
    }

    public void setExclusiveCheckable(boolean z) {
        this.H = (z ? 4 : 0) | (this.H & (-5));
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.v = 0;
        this.u = drawable;
        this.G = true;
        this.w.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setIconTintList(@Nullable ColorStateList colorStateList) {
        this.C = colorStateList;
        this.E = true;
        this.G = true;
        this.w.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.D = mode;
        this.F = true;
        this.G = true;
        this.w.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.p = intent;
        return this;
    }

    public void setIsActionButton(boolean z) {
        if (z) {
            this.H |= 32;
        } else {
            this.H &= -33;
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        if (this.q == c2) {
            return this;
        }
        this.q = c2;
        this.w.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.L = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.z = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        this.q = c2;
        this.s = Character.toLowerCase(c3);
        this.w.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public void setShowAsAction(int i2) {
        int i3 = i2 & 3;
        if (i3 != 0 && i3 != 1 && i3 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.I = i2;
        this.w.m(this);
    }

    public void setSubMenu(SubMenuBuilder subMenuBuilder) {
        this.x = subMenuBuilder;
        subMenuBuilder.setHeaderTitle(getTitle());
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public SupportMenuItem setSupportActionProvider(ActionProvider actionProvider) {
        ActionProvider actionProvider2 = this.K;
        if (actionProvider2 != null) {
            actionProvider2.reset();
        }
        this.J = null;
        this.K = actionProvider;
        this.w.onItemsChanged(true);
        ActionProvider actionProvider3 = this.K;
        if (actionProvider3 != null) {
            actionProvider3.setVisibilityListener(new ActionProvider.VisibilityListener() { // from class: androidx.appcompat.view.menu.MenuItemImpl.1
                AnonymousClass1() {
                }

                @Override // androidx.core.view.ActionProvider.VisibilityListener
                public void onActionProviderVisibilityChanged(boolean z) {
                    MenuItemImpl menuItemImpl = MenuItemImpl.this;
                    menuItemImpl.w.n(menuItemImpl);
                }
            });
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.n = charSequence;
        this.w.onItemsChanged(false);
        SubMenuBuilder subMenuBuilder = this.x;
        if (subMenuBuilder != null) {
            subMenuBuilder.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.o = charSequence;
        this.w.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        if (i(z)) {
            this.w.n(this);
        }
        return this;
    }

    public boolean shouldShowIcon() {
        return this.w.k();
    }

    public boolean showsTextAsAction() {
        return (this.I & 4) == 4;
    }

    public String toString() {
        CharSequence charSequence = this.n;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Override // android.view.MenuItem
    public SupportMenuItem setContentDescription(CharSequence charSequence) {
        this.A = charSequence;
        this.w.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setShowAsActionFlags(int i2) {
        setShowAsAction(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public SupportMenuItem setTooltipText(CharSequence charSequence) {
        this.B = charSequence;
        this.w.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setActionView(View view) {
        int i2;
        this.J = view;
        this.K = null;
        if (view != null && view.getId() == -1 && (i2 = this.f550j) > 0) {
            view.setId(i2);
        }
        this.w.m(this);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        if (this.s == c2 && this.t == i2) {
            return this;
        }
        this.s = Character.toLowerCase(c2);
        this.t = KeyEvent.normalizeMetaState(i2);
        this.w.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setNumericShortcut(char c2, int i2) {
        if (this.q == c2 && this.r == i2) {
            return this;
        }
        this.q = c2;
        this.r = KeyEvent.normalizeMetaState(i2);
        this.w.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.q = c2;
        this.r = KeyEvent.normalizeMetaState(i2);
        this.s = Character.toLowerCase(c3);
        this.t = KeyEvent.normalizeMetaState(i3);
        this.w.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i2) {
        this.u = null;
        this.v = i2;
        this.G = true;
        this.w.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i2) {
        return setTitle(this.w.getContext().getString(i2));
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setActionView(int i2) {
        Context context = this.w.getContext();
        setActionView(LayoutInflater.from(context).inflate(i2, (ViewGroup) new LinearLayout(context), false));
        return this;
    }
}
