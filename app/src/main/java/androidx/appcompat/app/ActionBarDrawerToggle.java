package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.ActionBarDrawerToggleHoneycomb;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

/* loaded from: classes.dex */
public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {

    /* renamed from: a */
    private final Delegate f161a;

    /* renamed from: b */
    private final DrawerLayout f162b;

    /* renamed from: c */
    private DrawerArrowDrawable f163c;

    /* renamed from: d */
    private boolean f164d;

    /* renamed from: e */
    private Drawable f165e;

    /* renamed from: f */
    boolean f166f;

    /* renamed from: g */
    private boolean f167g;

    /* renamed from: h */
    private final int f168h;

    /* renamed from: i */
    private final int f169i;

    /* renamed from: j */
    View.OnClickListener f170j;
    private boolean k;

    /* renamed from: androidx.appcompat.app.ActionBarDrawerToggle$1 */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActionBarDrawerToggle actionBarDrawerToggle = ActionBarDrawerToggle.this;
            if (actionBarDrawerToggle.f166f) {
                actionBarDrawerToggle.e();
                return;
            }
            View.OnClickListener onClickListener = actionBarDrawerToggle.f170j;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    public interface Delegate {
        Context getActionBarThemedContext();

        Drawable getThemeUpIndicator();

        boolean isNavigationVisible();

        void setActionBarDescription(@StringRes int i2);

        void setActionBarUpIndicator(Drawable drawable, @StringRes int i2);
    }

    public interface DelegateProvider {
        @Nullable
        Delegate getDrawerToggleDelegate();
    }

    private static class FrameworkActionBarDelegate implements Delegate {

        /* renamed from: a */
        private final Activity f172a;

        /* renamed from: b */
        private ActionBarDrawerToggleHoneycomb.SetIndicatorInfo f173b;

        FrameworkActionBarDelegate(Activity activity) {
            this.f172a = activity;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Context getActionBarThemedContext() {
            android.app.ActionBar actionBar = this.f172a.getActionBar();
            return actionBar != null ? actionBar.getThemedContext() : this.f172a;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Drawable getThemeUpIndicator() {
            if (Build.VERSION.SDK_INT < 18) {
                return ActionBarDrawerToggleHoneycomb.getThemeUpIndicator(this.f172a);
            }
            TypedArray obtainStyledAttributes = getActionBarThemedContext().obtainStyledAttributes(null, new int[]{R.attr.homeAsUpIndicator}, R.attr.actionBarStyle, 0);
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return drawable;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public boolean isNavigationVisible() {
            android.app.ActionBar actionBar = this.f172a.getActionBar();
            return (actionBar == null || (actionBar.getDisplayOptions() & 4) == 0) ? false : true;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(int i2) {
            if (Build.VERSION.SDK_INT < 18) {
                this.f173b = ActionBarDrawerToggleHoneycomb.setActionBarDescription(this.f173b, this.f172a, i2);
                return;
            }
            android.app.ActionBar actionBar = this.f172a.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeActionContentDescription(i2);
            }
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(Drawable drawable, int i2) {
            android.app.ActionBar actionBar = this.f172a.getActionBar();
            if (actionBar != null) {
                if (Build.VERSION.SDK_INT >= 18) {
                    actionBar.setHomeAsUpIndicator(drawable);
                    actionBar.setHomeActionContentDescription(i2);
                } else {
                    actionBar.setDisplayShowHomeEnabled(true);
                    this.f173b = ActionBarDrawerToggleHoneycomb.setActionBarUpIndicator(this.f172a, drawable, i2);
                    actionBar.setDisplayShowHomeEnabled(false);
                }
            }
        }
    }

    static class ToolbarCompatDelegate implements Delegate {

        /* renamed from: a */
        final Toolbar f174a;

        /* renamed from: b */
        final Drawable f175b;

        /* renamed from: c */
        final CharSequence f176c;

        ToolbarCompatDelegate(Toolbar toolbar) {
            this.f174a = toolbar;
            this.f175b = toolbar.getNavigationIcon();
            this.f176c = toolbar.getNavigationContentDescription();
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Context getActionBarThemedContext() {
            return this.f174a.getContext();
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Drawable getThemeUpIndicator() {
            return this.f175b;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public boolean isNavigationVisible() {
            return true;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(@StringRes int i2) {
            if (i2 == 0) {
                this.f174a.setNavigationContentDescription(this.f176c);
            } else {
                this.f174a.setNavigationContentDescription(i2);
            }
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(Drawable drawable, @StringRes int i2) {
            this.f174a.setNavigationIcon(drawable);
            setActionBarDescription(i2);
        }
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, @StringRes int i2, @StringRes int i3) {
        this(activity, null, drawerLayout, null, i2, i3);
    }

    private void d(float f2) {
        if (f2 == 1.0f) {
            this.f163c.setVerticalMirror(true);
        } else if (f2 == 0.0f) {
            this.f163c.setVerticalMirror(false);
        }
        this.f163c.setProgress(f2);
    }

    Drawable a() {
        return this.f161a.getThemeUpIndicator();
    }

    void b(int i2) {
        this.f161a.setActionBarDescription(i2);
    }

    void c(Drawable drawable, int i2) {
        if (!this.k && !this.f161a.isNavigationVisible()) {
            Log.w("ActionBarDrawerToggle", "DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);");
            this.k = true;
        }
        this.f161a.setActionBarUpIndicator(drawable, i2);
    }

    void e() {
        int drawerLockMode = this.f162b.getDrawerLockMode(8388611);
        if (this.f162b.isDrawerVisible(8388611) && drawerLockMode != 2) {
            this.f162b.closeDrawer(8388611);
        } else if (drawerLockMode != 1) {
            this.f162b.openDrawer(8388611);
        }
    }

    @NonNull
    public DrawerArrowDrawable getDrawerArrowDrawable() {
        return this.f163c;
    }

    public View.OnClickListener getToolbarNavigationClickListener() {
        return this.f170j;
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.f166f;
    }

    public boolean isDrawerSlideAnimationEnabled() {
        return this.f164d;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!this.f167g) {
            this.f165e = a();
        }
        syncState();
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerClosed(View view) {
        d(0.0f);
        if (this.f166f) {
            b(this.f168h);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerOpened(View view) {
        d(1.0f);
        if (this.f166f) {
            b(this.f169i);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerSlide(View view, float f2) {
        if (this.f164d) {
            d(Math.min(1.0f, Math.max(0.0f, f2)));
        } else {
            d(0.0f);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerStateChanged(int i2) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem == null || menuItem.getItemId() != 16908332 || !this.f166f) {
            return false;
        }
        e();
        return true;
    }

    public void setDrawerArrowDrawable(@NonNull DrawerArrowDrawable drawerArrowDrawable) {
        this.f163c = drawerArrowDrawable;
        syncState();
    }

    public void setDrawerIndicatorEnabled(boolean z) {
        if (z != this.f166f) {
            if (z) {
                c(this.f163c, this.f162b.isDrawerOpen(8388611) ? this.f169i : this.f168h);
            } else {
                c(this.f165e, 0);
            }
            this.f166f = z;
        }
    }

    public void setDrawerSlideAnimationEnabled(boolean z) {
        this.f164d = z;
        if (z) {
            return;
        }
        d(0.0f);
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        if (drawable == null) {
            this.f165e = a();
            this.f167g = false;
        } else {
            this.f165e = drawable;
            this.f167g = true;
        }
        if (this.f166f) {
            return;
        }
        c(this.f165e, 0);
    }

    public void setToolbarNavigationClickListener(View.OnClickListener onClickListener) {
        this.f170j = onClickListener;
    }

    public void syncState() {
        if (this.f162b.isDrawerOpen(8388611)) {
            d(1.0f);
        } else {
            d(0.0f);
        }
        if (this.f166f) {
            c(this.f163c, this.f162b.isDrawerOpen(8388611) ? this.f169i : this.f168h);
        }
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, Toolbar toolbar, @StringRes int i2, @StringRes int i3) {
        this(activity, toolbar, drawerLayout, null, i2, i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    ActionBarDrawerToggle(Activity activity, Toolbar toolbar, DrawerLayout drawerLayout, DrawerArrowDrawable drawerArrowDrawable, @StringRes int i2, @StringRes int i3) {
        this.f164d = true;
        this.f166f = true;
        this.k = false;
        if (toolbar != null) {
            this.f161a = new ToolbarCompatDelegate(toolbar);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.app.ActionBarDrawerToggle.1
                AnonymousClass1() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ActionBarDrawerToggle actionBarDrawerToggle = ActionBarDrawerToggle.this;
                    if (actionBarDrawerToggle.f166f) {
                        actionBarDrawerToggle.e();
                        return;
                    }
                    View.OnClickListener onClickListener = actionBarDrawerToggle.f170j;
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    }
                }
            });
        } else if (activity instanceof DelegateProvider) {
            this.f161a = ((DelegateProvider) activity).getDrawerToggleDelegate();
        } else {
            this.f161a = new FrameworkActionBarDelegate(activity);
        }
        this.f162b = drawerLayout;
        this.f168h = i2;
        this.f169i = i3;
        if (drawerArrowDrawable == null) {
            this.f163c = new DrawerArrowDrawable(this.f161a.getActionBarThemedContext());
        } else {
            this.f163c = drawerArrowDrawable;
        }
        this.f165e = a();
    }

    public void setHomeAsUpIndicator(int i2) {
        setHomeAsUpIndicator(i2 != 0 ? this.f162b.getResources().getDrawable(i2) : null);
    }
}
