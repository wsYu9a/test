package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ActionProvider;
import androidx.core.view.ViewConfigurationCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class MenuBuilder implements SupportMenu {

    /* renamed from: a */
    private static final String f527a = "MenuBuilder";

    /* renamed from: b */
    private static final String f528b = "android:menu:presenters";

    /* renamed from: c */
    private static final String f529c = "android:menu:actionviewstates";

    /* renamed from: d */
    private static final String f530d = "android:menu:expandedactionview";

    /* renamed from: e */
    private static final int[] f531e = {1, 4, 5, 3, 2, 0};
    private MenuItemImpl D;
    private boolean F;

    /* renamed from: f */
    private final Context f532f;

    /* renamed from: g */
    private final Resources f533g;

    /* renamed from: h */
    private boolean f534h;

    /* renamed from: i */
    private boolean f535i;

    /* renamed from: j */
    private Callback f536j;
    private ContextMenu.ContextMenuInfo r;
    CharSequence s;
    Drawable t;
    View u;
    private SparseArray<Parcelable> v;
    private int q = 0;
    private boolean w = false;
    private boolean x = false;
    private boolean y = false;
    private boolean z = false;
    private boolean A = false;
    private ArrayList<MenuItemImpl> B = new ArrayList<>();
    private CopyOnWriteArrayList<WeakReference<MenuPresenter>> C = new CopyOnWriteArrayList<>();
    private boolean E = false;
    private ArrayList<MenuItemImpl> k = new ArrayList<>();
    private ArrayList<MenuItemImpl> l = new ArrayList<>();
    private boolean m = true;
    private ArrayList<MenuItemImpl> n = new ArrayList<>();
    private ArrayList<MenuItemImpl> o = new ArrayList<>();
    private boolean p = true;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface Callback {
        boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem);

        void onMenuModeChange(MenuBuilder menuBuilder);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface ItemInvoker {
        boolean invokeItem(MenuItemImpl menuItemImpl);
    }

    public MenuBuilder(Context context) {
        this.f532f = context;
        this.f533g = context.getResources();
        w(true);
    }

    private MenuItemImpl b(int i2, int i3, int i4, int i5, CharSequence charSequence, int i6) {
        return new MenuItemImpl(this, i2, i3, i4, i5, charSequence, i6);
    }

    private void d(boolean z) {
        if (this.C.isEmpty()) {
            return;
        }
        stopDispatchingItemsChanged();
        Iterator<WeakReference<MenuPresenter>> it = this.C.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter = next.get();
            if (menuPresenter == null) {
                this.C.remove(next);
            } else {
                menuPresenter.updateMenuView(z);
            }
        }
        startDispatchingItemsChanged();
    }

    private void e(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(f528b);
        if (sparseParcelableArray == null || this.C.isEmpty()) {
            return;
        }
        Iterator<WeakReference<MenuPresenter>> it = this.C.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter = next.get();
            if (menuPresenter == null) {
                this.C.remove(next);
            } else {
                int id = menuPresenter.getId();
                if (id > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(id)) != null) {
                    menuPresenter.onRestoreInstanceState(parcelable);
                }
            }
        }
    }

    private void f(Bundle bundle) {
        Parcelable onSaveInstanceState;
        if (this.C.isEmpty()) {
            return;
        }
        SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
        Iterator<WeakReference<MenuPresenter>> it = this.C.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter = next.get();
            if (menuPresenter == null) {
                this.C.remove(next);
            } else {
                int id = menuPresenter.getId();
                if (id > 0 && (onSaveInstanceState = menuPresenter.onSaveInstanceState()) != null) {
                    sparseArray.put(id, onSaveInstanceState);
                }
            }
        }
        bundle.putSparseParcelableArray(f528b, sparseArray);
    }

    private boolean g(SubMenuBuilder subMenuBuilder, MenuPresenter menuPresenter) {
        if (this.C.isEmpty()) {
            return false;
        }
        boolean onSubMenuSelected = menuPresenter != null ? menuPresenter.onSubMenuSelected(subMenuBuilder) : false;
        Iterator<WeakReference<MenuPresenter>> it = this.C.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter2 = next.get();
            if (menuPresenter2 == null) {
                this.C.remove(next);
            } else if (!onSubMenuSelected) {
                onSubMenuSelected = menuPresenter2.onSubMenuSelected(subMenuBuilder);
            }
        }
        return onSubMenuSelected;
    }

    private static int h(ArrayList<MenuItemImpl> arrayList, int i2) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).getOrdering() <= i2) {
                return size + 1;
            }
        }
        return 0;
    }

    private static int l(int i2) {
        int i3 = ((-65536) & i2) >> 16;
        if (i3 >= 0) {
            int[] iArr = f531e;
            if (i3 < iArr.length) {
                return (i2 & 65535) | (iArr[i3] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void o(int i2, boolean z) {
        if (i2 < 0 || i2 >= this.k.size()) {
            return;
        }
        this.k.remove(i2);
        if (z) {
            onItemsChanged(true);
        }
    }

    private void s(int i2, CharSequence charSequence, int i3, Drawable drawable, View view) {
        Resources resources = getResources();
        if (view != null) {
            this.u = view;
            this.s = null;
            this.t = null;
        } else {
            if (i2 > 0) {
                this.s = resources.getText(i2);
            } else if (charSequence != null) {
                this.s = charSequence;
            }
            if (i3 > 0) {
                this.t = ContextCompat.getDrawable(getContext(), i3);
            } else if (drawable != null) {
                this.t = drawable;
            }
            this.u = null;
        }
        onItemsChanged(false);
    }

    private void w(boolean z) {
        this.f535i = z && this.f533g.getConfiguration().keyboard != 1 && ViewConfigurationCompat.shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration.get(this.f532f), this.f532f);
    }

    protected MenuItem a(int i2, int i3, int i4, CharSequence charSequence) {
        int l = l(i4);
        MenuItemImpl b2 = b(i2, i3, i4, l, charSequence, this.q);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.r;
        if (contextMenuInfo != null) {
            b2.h(contextMenuInfo);
        }
        ArrayList<MenuItemImpl> arrayList = this.k;
        arrayList.add(h(arrayList, l), b2);
        onItemsChanged(true);
        return b2;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i2, int i3, int i4, ComponentName componentName, Intent[] intentArr, Intent intent, int i5, MenuItem[] menuItemArr) {
        int i6;
        PackageManager packageManager = this.f532f.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i5 & 1) == 0) {
            removeGroup(i2);
        }
        for (int i7 = 0; i7 < size; i7++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i7);
            int i8 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i8 < 0 ? intent : intentArr[i8]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i2, i3, i4, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i6 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i6] = intent3;
            }
        }
        return size;
    }

    public void addMenuPresenter(MenuPresenter menuPresenter) {
        addMenuPresenter(menuPresenter, this.f532f);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    boolean c(MenuBuilder menuBuilder, MenuItem menuItem) {
        Callback callback = this.f536j;
        return callback != null && callback.onMenuItemSelected(menuBuilder, menuItem);
    }

    public void changeMenuMode() {
        Callback callback = this.f536j;
        if (callback != null) {
            callback.onMenuModeChange(this);
        }
    }

    @Override // android.view.Menu
    public void clear() {
        MenuItemImpl menuItemImpl = this.D;
        if (menuItemImpl != null) {
            collapseItemActionView(menuItemImpl);
        }
        this.k.clear();
        onItemsChanged(true);
    }

    public void clearAll() {
        this.w = true;
        clear();
        clearHeader();
        this.C.clear();
        this.w = false;
        this.x = false;
        this.y = false;
        onItemsChanged(true);
    }

    public void clearHeader() {
        this.t = null;
        this.s = null;
        this.u = null;
        onItemsChanged(false);
    }

    public final void close(boolean z) {
        if (this.A) {
            return;
        }
        this.A = true;
        Iterator<WeakReference<MenuPresenter>> it = this.C.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter = next.get();
            if (menuPresenter == null) {
                this.C.remove(next);
            } else {
                menuPresenter.onCloseMenu(this, z);
            }
        }
        this.A = false;
    }

    public boolean collapseItemActionView(MenuItemImpl menuItemImpl) {
        boolean z = false;
        if (!this.C.isEmpty() && this.D == menuItemImpl) {
            stopDispatchingItemsChanged();
            Iterator<WeakReference<MenuPresenter>> it = this.C.iterator();
            while (it.hasNext()) {
                WeakReference<MenuPresenter> next = it.next();
                MenuPresenter menuPresenter = next.get();
                if (menuPresenter == null) {
                    this.C.remove(next);
                } else {
                    z = menuPresenter.collapseItemActionView(this, menuItemImpl);
                    if (z) {
                        break;
                    }
                }
            }
            startDispatchingItemsChanged();
            if (z) {
                this.D = null;
            }
        }
        return z;
    }

    public boolean expandItemActionView(MenuItemImpl menuItemImpl) {
        boolean z = false;
        if (this.C.isEmpty()) {
            return false;
        }
        stopDispatchingItemsChanged();
        Iterator<WeakReference<MenuPresenter>> it = this.C.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter = next.get();
            if (menuPresenter == null) {
                this.C.remove(next);
            } else {
                z = menuPresenter.expandItemActionView(this, menuItemImpl);
                if (z) {
                    break;
                }
            }
        }
        startDispatchingItemsChanged();
        if (z) {
            this.D = menuItemImpl;
        }
        return z;
    }

    public int findGroupIndex(int i2) {
        return findGroupIndex(i2, 0);
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i2) {
        MenuItem findItem;
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItemImpl menuItemImpl = this.k.get(i3);
            if (menuItemImpl.getItemId() == i2) {
                return menuItemImpl;
            }
            if (menuItemImpl.hasSubMenu() && (findItem = menuItemImpl.getSubMenu().findItem(i2)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public int findItemIndex(int i2) {
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.k.get(i3).getItemId() == i2) {
                return i3;
            }
        }
        return -1;
    }

    public void flagActionItems() {
        ArrayList<MenuItemImpl> visibleItems = getVisibleItems();
        if (this.p) {
            Iterator<WeakReference<MenuPresenter>> it = this.C.iterator();
            boolean z = false;
            while (it.hasNext()) {
                WeakReference<MenuPresenter> next = it.next();
                MenuPresenter menuPresenter = next.get();
                if (menuPresenter == null) {
                    this.C.remove(next);
                } else {
                    z |= menuPresenter.flagActionItems();
                }
            }
            if (z) {
                this.n.clear();
                this.o.clear();
                int size = visibleItems.size();
                for (int i2 = 0; i2 < size; i2++) {
                    MenuItemImpl menuItemImpl = visibleItems.get(i2);
                    if (menuItemImpl.isActionButton()) {
                        this.n.add(menuItemImpl);
                    } else {
                        this.o.add(menuItemImpl);
                    }
                }
            } else {
                this.n.clear();
                this.o.clear();
                this.o.addAll(getVisibleItems());
            }
            this.p = false;
        }
    }

    public ArrayList<MenuItemImpl> getActionItems() {
        flagActionItems();
        return this.n;
    }

    protected String getActionViewStatesKey() {
        return f529c;
    }

    public Context getContext() {
        return this.f532f;
    }

    public MenuItemImpl getExpandedItem() {
        return this.D;
    }

    public Drawable getHeaderIcon() {
        return this.t;
    }

    public CharSequence getHeaderTitle() {
        return this.s;
    }

    public View getHeaderView() {
        return this.u;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i2) {
        return this.k.get(i2);
    }

    public ArrayList<MenuItemImpl> getNonActionItems() {
        flagActionItems();
        return this.o;
    }

    Resources getResources() {
        return this.f533g;
    }

    public MenuBuilder getRootMenu() {
        return this;
    }

    @NonNull
    public ArrayList<MenuItemImpl> getVisibleItems() {
        if (!this.m) {
            return this.l;
        }
        this.l.clear();
        int size = this.k.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = this.k.get(i2);
            if (menuItemImpl.isVisible()) {
                this.l.add(menuItemImpl);
            }
        }
        this.m = false;
        this.p = true;
        return this.l;
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.F) {
            return true;
        }
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.k.get(i2).isVisible()) {
                return true;
            }
        }
        return false;
    }

    MenuItemImpl i(int i2, KeyEvent keyEvent) {
        ArrayList<MenuItemImpl> arrayList = this.B;
        arrayList.clear();
        j(arrayList, i2, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean isQwertyMode = isQwertyMode();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItemImpl menuItemImpl = arrayList.get(i3);
            char alphabeticShortcut = isQwertyMode ? menuItemImpl.getAlphabeticShortcut() : menuItemImpl.getNumericShortcut();
            char[] cArr = keyData.meta;
            if ((alphabeticShortcut == cArr[0] && (metaState & 2) == 0) || ((alphabeticShortcut == cArr[2] && (metaState & 2) != 0) || (isQwertyMode && alphabeticShortcut == '\b' && i2 == 67))) {
                return menuItemImpl;
            }
        }
        return null;
    }

    public boolean isGroupDividerEnabled() {
        return this.E;
    }

    boolean isQwertyMode() {
        return this.f534h;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i2, KeyEvent keyEvent) {
        return i(i2, keyEvent) != null;
    }

    public boolean isShortcutsVisible() {
        return this.f535i;
    }

    void j(List<MenuItemImpl> list, int i2, KeyEvent keyEvent) {
        boolean isQwertyMode = isQwertyMode();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i2 == 67) {
            int size = this.k.size();
            for (int i3 = 0; i3 < size; i3++) {
                MenuItemImpl menuItemImpl = this.k.get(i3);
                if (menuItemImpl.hasSubMenu()) {
                    ((MenuBuilder) menuItemImpl.getSubMenu()).j(list, i2, keyEvent);
                }
                char alphabeticShortcut = isQwertyMode ? menuItemImpl.getAlphabeticShortcut() : menuItemImpl.getNumericShortcut();
                if (((modifiers & SupportMenu.SUPPORTED_MODIFIERS_MASK) == ((isQwertyMode ? menuItemImpl.getAlphabeticModifiers() : menuItemImpl.getNumericModifiers()) & SupportMenu.SUPPORTED_MODIFIERS_MASK)) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (isQwertyMode && alphabeticShortcut == '\b' && i2 == 67)) && menuItemImpl.isEnabled()) {
                        list.add(menuItemImpl);
                    }
                }
            }
        }
    }

    boolean k() {
        return this.z;
    }

    void m(MenuItemImpl menuItemImpl) {
        this.p = true;
        onItemsChanged(true);
    }

    void n(MenuItemImpl menuItemImpl) {
        this.m = true;
        onItemsChanged(true);
    }

    public void onItemsChanged(boolean z) {
        if (this.w) {
            this.x = true;
            if (z) {
                this.y = true;
                return;
            }
            return;
        }
        if (z) {
            this.m = true;
            this.p = true;
        }
        d(z);
    }

    void p(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.k.size();
        stopDispatchingItemsChanged();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = this.k.get(i2);
            if (menuItemImpl.getGroupId() == groupId && menuItemImpl.isExclusiveCheckable() && menuItemImpl.isCheckable()) {
                menuItemImpl.g(menuItemImpl == menuItem);
            }
        }
        startDispatchingItemsChanged();
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i2, int i3) {
        return performItemAction(findItem(i2), i3);
    }

    public boolean performItemAction(MenuItem menuItem, int i2) {
        return performItemAction(menuItem, null, i2);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i2, KeyEvent keyEvent, int i3) {
        MenuItemImpl i4 = i(i2, keyEvent);
        boolean performItemAction = i4 != null ? performItemAction(i4, i3) : false;
        if ((i3 & 2) != 0) {
            close(true);
        }
        return performItemAction;
    }

    protected MenuBuilder q(int i2) {
        s(0, null, i2, null, null);
        return this;
    }

    protected MenuBuilder r(Drawable drawable) {
        s(0, null, 0, drawable, null);
        return this;
    }

    @Override // android.view.Menu
    public void removeGroup(int i2) {
        int findGroupIndex = findGroupIndex(i2);
        if (findGroupIndex >= 0) {
            int size = this.k.size() - findGroupIndex;
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (i3 >= size || this.k.get(findGroupIndex).getGroupId() != i2) {
                    break;
                }
                o(findGroupIndex, false);
                i3 = i4;
            }
            onItemsChanged(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i2) {
        o(findItemIndex(i2), true);
    }

    public void removeItemAt(int i2) {
        o(i2, true);
    }

    public void removeMenuPresenter(MenuPresenter menuPresenter) {
        Iterator<WeakReference<MenuPresenter>> it = this.C.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter2 = next.get();
            if (menuPresenter2 == null || menuPresenter2 == menuPresenter) {
                this.C.remove(next);
            }
        }
    }

    public void restoreActionViewStates(Bundle bundle) {
        MenuItem findItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(getActionViewStatesKey());
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = getItem(i2);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((SubMenuBuilder) item.getSubMenu()).restoreActionViewStates(bundle);
            }
        }
        int i3 = bundle.getInt(f530d);
        if (i3 <= 0 || (findItem = findItem(i3)) == null) {
            return;
        }
        findItem.expandActionView();
    }

    public void restorePresenterStates(Bundle bundle) {
        e(bundle);
    }

    public void saveActionViewStates(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = getItem(i2);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt(f530d, item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((SubMenuBuilder) item.getSubMenu()).saveActionViewStates(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(getActionViewStatesKey(), sparseArray);
        }
    }

    public void savePresenterStates(Bundle bundle) {
        f(bundle);
    }

    public void setCallback(Callback callback) {
        this.f536j = callback;
    }

    public void setCurrentMenuInfo(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.r = contextMenuInfo;
    }

    public MenuBuilder setDefaultShowAsAction(int i2) {
        this.q = i2;
        return this;
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i2, boolean z, boolean z2) {
        int size = this.k.size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItemImpl menuItemImpl = this.k.get(i3);
            if (menuItemImpl.getGroupId() == i2) {
                menuItemImpl.setExclusiveCheckable(z2);
                menuItemImpl.setCheckable(z);
            }
        }
    }

    @Override // androidx.core.internal.view.SupportMenu, android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.E = z;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i2, boolean z) {
        int size = this.k.size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItemImpl menuItemImpl = this.k.get(i3);
            if (menuItemImpl.getGroupId() == i2) {
                menuItemImpl.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i2, boolean z) {
        int size = this.k.size();
        boolean z2 = false;
        for (int i3 = 0; i3 < size; i3++) {
            MenuItemImpl menuItemImpl = this.k.get(i3);
            if (menuItemImpl.getGroupId() == i2 && menuItemImpl.i(z)) {
                z2 = true;
            }
        }
        if (z2) {
            onItemsChanged(true);
        }
    }

    public void setOptionalIconsVisible(boolean z) {
        this.z = z;
    }

    public void setOverrideVisibleItems(boolean z) {
        this.F = z;
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.f534h = z;
        onItemsChanged(false);
    }

    public void setShortcutsVisible(boolean z) {
        if (this.f535i == z) {
            return;
        }
        w(z);
        onItemsChanged(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.k.size();
    }

    public void startDispatchingItemsChanged() {
        this.w = false;
        if (this.x) {
            this.x = false;
            onItemsChanged(this.y);
        }
    }

    public void stopDispatchingItemsChanged() {
        if (this.w) {
            return;
        }
        this.w = true;
        this.x = false;
        this.y = false;
    }

    protected MenuBuilder t(int i2) {
        s(i2, null, 0, null, null);
        return this;
    }

    protected MenuBuilder u(CharSequence charSequence) {
        s(0, charSequence, 0, null, null);
        return this;
    }

    protected MenuBuilder v(View view) {
        s(0, null, 0, null, view);
        return this;
    }

    @Override // android.view.Menu
    public MenuItem add(int i2) {
        return a(0, 0, 0, this.f533g.getString(i2));
    }

    public void addMenuPresenter(MenuPresenter menuPresenter, Context context) {
        this.C.add(new WeakReference<>(menuPresenter));
        menuPresenter.initForMenu(context, this);
        this.p = true;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2) {
        return addSubMenu(0, 0, 0, this.f533g.getString(i2));
    }

    public int findGroupIndex(int i2, int i3) {
        int size = size();
        if (i3 < 0) {
            i3 = 0;
        }
        while (i3 < size) {
            if (this.k.get(i3).getGroupId() == i2) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public boolean performItemAction(MenuItem menuItem, MenuPresenter menuPresenter, int i2) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) menuItem;
        if (menuItemImpl == null || !menuItemImpl.isEnabled()) {
            return false;
        }
        boolean invoke = menuItemImpl.invoke();
        ActionProvider supportActionProvider = menuItemImpl.getSupportActionProvider();
        boolean z = supportActionProvider != null && supportActionProvider.hasSubMenu();
        if (menuItemImpl.hasCollapsibleActionView()) {
            invoke |= menuItemImpl.expandActionView();
            if (invoke) {
                close(true);
            }
        } else if (menuItemImpl.hasSubMenu() || z) {
            if ((i2 & 4) == 0) {
                close(false);
            }
            if (!menuItemImpl.hasSubMenu()) {
                menuItemImpl.setSubMenu(new SubMenuBuilder(getContext(), this, menuItemImpl));
            }
            SubMenuBuilder subMenuBuilder = (SubMenuBuilder) menuItemImpl.getSubMenu();
            if (z) {
                supportActionProvider.onPrepareSubMenu(subMenuBuilder);
            }
            invoke |= g(subMenuBuilder, menuPresenter);
            if (!invoke) {
                close(true);
            }
        } else if ((i2 & 1) == 0) {
            close(true);
        }
        return invoke;
    }

    @Override // android.view.Menu
    public MenuItem add(int i2, int i3, int i4, CharSequence charSequence) {
        return a(i2, i3, i4, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) a(i2, i3, i4, charSequence);
        SubMenuBuilder subMenuBuilder = new SubMenuBuilder(this.f532f, this, menuItemImpl);
        menuItemImpl.setSubMenu(subMenuBuilder);
        return subMenuBuilder;
    }

    @Override // android.view.Menu
    public MenuItem add(int i2, int i3, int i4, int i5) {
        return a(i2, i3, i4, this.f533g.getString(i5));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2, int i3, int i4, int i5) {
        return addSubMenu(i2, i3, i4, this.f533g.getString(i5));
    }

    @Override // android.view.Menu
    public void close() {
        close(true);
    }
}
