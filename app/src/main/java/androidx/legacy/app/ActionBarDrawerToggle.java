package androidx.legacy.app;

import android.R;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import java.lang.reflect.Method;

@Deprecated
/* loaded from: classes.dex */
public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {

    /* renamed from: a */
    private static final String f2535a = "ActionBarDrawerToggle";

    /* renamed from: b */
    private static final int[] f2536b = {R.attr.homeAsUpIndicator};

    /* renamed from: c */
    private static final float f2537c = 0.33333334f;

    /* renamed from: d */
    private static final int f2538d = 16908332;

    /* renamed from: e */
    final Activity f2539e;

    /* renamed from: f */
    private final Delegate f2540f;

    /* renamed from: g */
    private final DrawerLayout f2541g;

    /* renamed from: h */
    private boolean f2542h;

    /* renamed from: i */
    private boolean f2543i;

    /* renamed from: j */
    private Drawable f2544j;
    private Drawable k;
    private SlideDrawable l;
    private final int m;
    private final int n;
    private final int o;
    private SetIndicatorInfo p;

    @Deprecated
    public interface Delegate {
        @Nullable
        Drawable getThemeUpIndicator();

        void setActionBarDescription(@StringRes int i2);

        void setActionBarUpIndicator(Drawable drawable, @StringRes int i2);
    }

    @Deprecated
    public interface DelegateProvider {
        @Nullable
        Delegate getDrawerToggleDelegate();
    }

    private static class SetIndicatorInfo {

        /* renamed from: a */
        Method f2545a;

        /* renamed from: b */
        Method f2546b;

        /* renamed from: c */
        ImageView f2547c;

        SetIndicatorInfo(Activity activity) {
            try {
                this.f2545a = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", Drawable.class);
                this.f2546b = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", Integer.TYPE);
            } catch (NoSuchMethodException unused) {
                View findViewById = activity.findViewById(16908332);
                if (findViewById == null) {
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
                if (viewGroup.getChildCount() != 2) {
                    return;
                }
                View childAt = viewGroup.getChildAt(0);
                childAt = childAt.getId() == 16908332 ? viewGroup.getChildAt(1) : childAt;
                if (childAt instanceof ImageView) {
                    this.f2547c = (ImageView) childAt;
                }
            }
        }
    }

    private class SlideDrawable extends InsetDrawable implements Drawable.Callback {

        /* renamed from: a */
        private final boolean f2548a;

        /* renamed from: b */
        private final Rect f2549b;

        /* renamed from: c */
        private float f2550c;

        /* renamed from: d */
        private float f2551d;

        SlideDrawable(Drawable drawable) {
            super(drawable, 0);
            this.f2548a = Build.VERSION.SDK_INT > 18;
            this.f2549b = new Rect();
        }

        @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void draw(@NonNull Canvas canvas) {
            copyBounds(this.f2549b);
            canvas.save();
            boolean z = ViewCompat.getLayoutDirection(ActionBarDrawerToggle.this.f2539e.getWindow().getDecorView()) == 1;
            int i2 = z ? -1 : 1;
            float width = this.f2549b.width();
            canvas.translate((-this.f2551d) * width * this.f2550c * i2, 0.0f);
            if (z && !this.f2548a) {
                canvas.translate(width, 0.0f);
                canvas.scale(-1.0f, 1.0f);
            }
            super.draw(canvas);
            canvas.restore();
        }

        public float getPosition() {
            return this.f2550c;
        }

        public void setOffset(float f2) {
            this.f2551d = f2;
            invalidateSelf();
        }

        public void setPosition(float f2) {
            this.f2550c = f2;
            invalidateSelf();
        }
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, @DrawableRes int i2, @StringRes int i3, @StringRes int i4) {
        this(activity, drawerLayout, !a(activity), i2, i3, i4);
    }

    private static boolean a(Context context) {
        return context.getApplicationInfo().targetSdkVersion >= 21 && Build.VERSION.SDK_INT >= 21;
    }

    private Drawable b() {
        Delegate delegate = this.f2540f;
        if (delegate != null) {
            return delegate.getThemeUpIndicator();
        }
        if (Build.VERSION.SDK_INT < 18) {
            TypedArray obtainStyledAttributes = this.f2539e.obtainStyledAttributes(f2536b);
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return drawable;
        }
        ActionBar actionBar = this.f2539e.getActionBar();
        TypedArray obtainStyledAttributes2 = (actionBar != null ? actionBar.getThemedContext() : this.f2539e).obtainStyledAttributes(null, f2536b, R.attr.actionBarStyle, 0);
        Drawable drawable2 = obtainStyledAttributes2.getDrawable(0);
        obtainStyledAttributes2.recycle();
        return drawable2;
    }

    private void c(int i2) {
        Delegate delegate = this.f2540f;
        if (delegate != null) {
            delegate.setActionBarDescription(i2);
            return;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            ActionBar actionBar = this.f2539e.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeActionContentDescription(i2);
                return;
            }
            return;
        }
        if (this.p == null) {
            this.p = new SetIndicatorInfo(this.f2539e);
        }
        if (this.p.f2545a != null) {
            try {
                ActionBar actionBar2 = this.f2539e.getActionBar();
                this.p.f2546b.invoke(actionBar2, Integer.valueOf(i2));
                actionBar2.setSubtitle(actionBar2.getSubtitle());
            } catch (Exception e2) {
                Log.w(f2535a, "Couldn't set content description via JB-MR2 API", e2);
            }
        }
    }

    private void d(Drawable drawable, int i2) {
        Delegate delegate = this.f2540f;
        if (delegate != null) {
            delegate.setActionBarUpIndicator(drawable, i2);
            return;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            ActionBar actionBar = this.f2539e.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeAsUpIndicator(drawable);
                actionBar.setHomeActionContentDescription(i2);
                return;
            }
            return;
        }
        if (this.p == null) {
            this.p = new SetIndicatorInfo(this.f2539e);
        }
        SetIndicatorInfo setIndicatorInfo = this.p;
        if (setIndicatorInfo.f2545a == null) {
            ImageView imageView = setIndicatorInfo.f2547c;
            if (imageView != null) {
                imageView.setImageDrawable(drawable);
                return;
            } else {
                Log.w(f2535a, "Couldn't set home-as-up indicator");
                return;
            }
        }
        try {
            ActionBar actionBar2 = this.f2539e.getActionBar();
            this.p.f2545a.invoke(actionBar2, drawable);
            this.p.f2546b.invoke(actionBar2, Integer.valueOf(i2));
        } catch (Exception e2) {
            Log.w(f2535a, "Couldn't set home-as-up indicator via JB-MR2 API", e2);
        }
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.f2542h;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!this.f2543i) {
            this.f2544j = b();
        }
        this.k = ContextCompat.getDrawable(this.f2539e, this.m);
        syncState();
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerClosed(View view) {
        this.l.setPosition(0.0f);
        if (this.f2542h) {
            c(this.n);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerOpened(View view) {
        this.l.setPosition(1.0f);
        if (this.f2542h) {
            c(this.o);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerSlide(View view, float f2) {
        float position = this.l.getPosition();
        this.l.setPosition(f2 > 0.5f ? Math.max(position, Math.max(0.0f, f2 - 0.5f) * 2.0f) : Math.min(position, f2 * 2.0f));
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerStateChanged(int i2) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem == null || menuItem.getItemId() != 16908332 || !this.f2542h) {
            return false;
        }
        if (this.f2541g.isDrawerVisible(8388611)) {
            this.f2541g.closeDrawer(8388611);
            return true;
        }
        this.f2541g.openDrawer(8388611);
        return true;
    }

    public void setDrawerIndicatorEnabled(boolean z) {
        if (z != this.f2542h) {
            if (z) {
                d(this.l, this.f2541g.isDrawerOpen(8388611) ? this.o : this.n);
            } else {
                d(this.f2544j, 0);
            }
            this.f2542h = z;
        }
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        if (drawable == null) {
            this.f2544j = b();
            this.f2543i = false;
        } else {
            this.f2544j = drawable;
            this.f2543i = true;
        }
        if (this.f2542h) {
            return;
        }
        d(this.f2544j, 0);
    }

    public void syncState() {
        if (this.f2541g.isDrawerOpen(8388611)) {
            this.l.setPosition(1.0f);
        } else {
            this.l.setPosition(0.0f);
        }
        if (this.f2542h) {
            d(this.l, this.f2541g.isDrawerOpen(8388611) ? this.o : this.n);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, boolean z, @DrawableRes int i2, @StringRes int i3, @StringRes int i4) {
        this.f2542h = true;
        this.f2539e = activity;
        if (activity instanceof DelegateProvider) {
            this.f2540f = ((DelegateProvider) activity).getDrawerToggleDelegate();
        } else {
            this.f2540f = null;
        }
        this.f2541g = drawerLayout;
        this.m = i2;
        this.n = i3;
        this.o = i4;
        this.f2544j = b();
        this.k = ContextCompat.getDrawable(activity, i2);
        SlideDrawable slideDrawable = new SlideDrawable(this.k);
        this.l = slideDrawable;
        slideDrawable.setOffset(z ? f2537c : 0.0f);
    }

    public void setHomeAsUpIndicator(int i2) {
        setHomeAsUpIndicator(i2 != 0 ? ContextCompat.getDrawable(this.f2539e, i2) : null);
    }
}
