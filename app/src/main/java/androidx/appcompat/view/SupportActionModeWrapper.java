package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.view.menu.MenuWrapperICS;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenu;
import androidx.core.internal.view.SupportMenuItem;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class SupportActionModeWrapper extends android.view.ActionMode {

    /* renamed from: a */
    final Context f411a;

    /* renamed from: b */
    final ActionMode f412b;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class CallbackWrapper implements ActionMode.Callback {

        /* renamed from: a */
        final ActionMode.Callback f413a;

        /* renamed from: b */
        final Context f414b;

        /* renamed from: c */
        final ArrayList<SupportActionModeWrapper> f415c = new ArrayList<>();

        /* renamed from: d */
        final SimpleArrayMap<Menu, Menu> f416d = new SimpleArrayMap<>();

        public CallbackWrapper(Context context, ActionMode.Callback callback) {
            this.f414b = context;
            this.f413a = callback;
        }

        private Menu a(Menu menu) {
            Menu menu2 = this.f416d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            MenuWrapperICS menuWrapperICS = new MenuWrapperICS(this.f414b, (SupportMenu) menu);
            this.f416d.put(menu, menuWrapperICS);
            return menuWrapperICS;
        }

        public android.view.ActionMode getActionModeWrapper(ActionMode actionMode) {
            int size = this.f415c.size();
            for (int i2 = 0; i2 < size; i2++) {
                SupportActionModeWrapper supportActionModeWrapper = this.f415c.get(i2);
                if (supportActionModeWrapper != null && supportActionModeWrapper.f412b == actionMode) {
                    return supportActionModeWrapper;
                }
            }
            SupportActionModeWrapper supportActionModeWrapper2 = new SupportActionModeWrapper(this.f414b, actionMode);
            this.f415c.add(supportActionModeWrapper2);
            return supportActionModeWrapper2;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f413a.onActionItemClicked(getActionModeWrapper(actionMode), new MenuItemWrapperICS(this.f414b, (SupportMenuItem) menuItem));
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f413a.onCreateActionMode(getActionModeWrapper(actionMode), a(menu));
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            this.f413a.onDestroyActionMode(getActionModeWrapper(actionMode));
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return this.f413a.onPrepareActionMode(getActionModeWrapper(actionMode), a(menu));
        }
    }

    public SupportActionModeWrapper(Context context, ActionMode actionMode) {
        this.f411a = context;
        this.f412b = actionMode;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f412b.finish();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f412b.getCustomView();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new MenuWrapperICS(this.f411a, (SupportMenu) this.f412b.getMenu());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f412b.getMenuInflater();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f412b.getSubtitle();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f412b.getTag();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f412b.getTitle();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f412b.getTitleOptionalHint();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f412b.invalidate();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f412b.isTitleOptional();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f412b.setCustomView(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f412b.setSubtitle(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f412b.setTag(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f412b.setTitle(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        this.f412b.setTitleOptionalHint(z);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i2) {
        this.f412b.setSubtitle(i2);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i2) {
        this.f412b.setTitle(i2);
    }
}
