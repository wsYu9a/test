package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.ArrayMap;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.internal.view.SupportSubMenu;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
abstract class BaseMenuWrapper {

    /* renamed from: a */
    final Context f477a;

    /* renamed from: b */
    private Map<SupportMenuItem, MenuItem> f478b;

    /* renamed from: c */
    private Map<SupportSubMenu, SubMenu> f479c;

    BaseMenuWrapper(Context context) {
        this.f477a = context;
    }

    final MenuItem a(MenuItem menuItem) {
        if (!(menuItem instanceof SupportMenuItem)) {
            return menuItem;
        }
        SupportMenuItem supportMenuItem = (SupportMenuItem) menuItem;
        if (this.f478b == null) {
            this.f478b = new ArrayMap();
        }
        MenuItem menuItem2 = this.f478b.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItemWrapperICS menuItemWrapperICS = new MenuItemWrapperICS(this.f477a, supportMenuItem);
        this.f478b.put(supportMenuItem, menuItemWrapperICS);
        return menuItemWrapperICS;
    }

    final SubMenu b(SubMenu subMenu) {
        if (!(subMenu instanceof SupportSubMenu)) {
            return subMenu;
        }
        SupportSubMenu supportSubMenu = (SupportSubMenu) subMenu;
        if (this.f479c == null) {
            this.f479c = new ArrayMap();
        }
        SubMenu subMenu2 = this.f479c.get(supportSubMenu);
        if (subMenu2 != null) {
            return subMenu2;
        }
        SubMenuWrapperICS subMenuWrapperICS = new SubMenuWrapperICS(this.f477a, supportSubMenu);
        this.f479c.put(supportSubMenu, subMenuWrapperICS);
        return subMenuWrapperICS;
    }

    final void c() {
        Map<SupportMenuItem, MenuItem> map = this.f478b;
        if (map != null) {
            map.clear();
        }
        Map<SupportSubMenu, SubMenu> map2 = this.f479c;
        if (map2 != null) {
            map2.clear();
        }
    }

    final void d(int i2) {
        Map<SupportMenuItem, MenuItem> map = this.f478b;
        if (map == null) {
            return;
        }
        Iterator<SupportMenuItem> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (i2 == it.next().getGroupId()) {
                it.remove();
            }
        }
    }

    final void e(int i2) {
        Map<SupportMenuItem, MenuItem> map = this.f478b;
        if (map == null) {
            return;
        }
        Iterator<SupportMenuItem> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (i2 == it.next().getItemId()) {
                it.remove();
                return;
            }
        }
    }
}
