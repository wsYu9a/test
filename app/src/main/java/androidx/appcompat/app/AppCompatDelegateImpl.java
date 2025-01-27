package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.view.SupportActionModeWrapper;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.WindowCallbackWrapper;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorContentParent;
import androidx.appcompat.widget.FitWindowsViewGroup;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.appcompat.widget.ViewUtils;
import androidx.collection.ArrayMap;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NavUtils;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.LayoutInflaterCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import java.lang.Thread;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
class AppCompatDelegateImpl extends AppCompatDelegate implements MenuBuilder.Callback, LayoutInflater.Factory2 {

    /* renamed from: e */
    private static final Map<Class<?>, Integer> f227e = new ArrayMap();

    /* renamed from: f */
    private static final boolean f228f = false;

    /* renamed from: g */
    private static final boolean f229g;

    /* renamed from: h */
    private static final int[] f230h;

    /* renamed from: i */
    private static boolean f231i = false;

    /* renamed from: j */
    private static final boolean f232j;
    static final String k = ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.";
    ViewPropertyAnimatorCompat A;
    private boolean B;
    private boolean C;
    private ViewGroup D;
    private TextView E;
    private View F;
    private boolean G;
    private boolean H;
    boolean I;
    boolean J;
    boolean K;
    boolean L;
    boolean M;
    private boolean N;
    private PanelFeatureState[] O;
    private PanelFeatureState P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private boolean T;
    boolean U;
    private int V;
    private int W;
    private boolean X;
    private boolean Y;
    private AutoNightModeManager Z;
    private AutoNightModeManager a0;
    boolean b0;
    int c0;
    private final Runnable d0;
    private boolean e0;
    private Rect f0;
    private Rect g0;
    private AppCompatViewInflater h0;
    final Object l;
    final Context m;
    Window n;
    private AppCompatWindowCallback o;
    final AppCompatCallback p;
    ActionBar q;
    MenuInflater r;
    private CharSequence s;
    private DecorContentParent t;
    private ActionMenuPresenterCallback u;
    private PanelMenuPresenterCallback v;
    ActionMode w;
    ActionBarContextView x;
    PopupWindow y;
    Runnable z;

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$1 */
    static class AnonymousClass1 implements Thread.UncaughtExceptionHandler {

        /* renamed from: a */
        final /* synthetic */ Thread.UncaughtExceptionHandler f233a;

        AnonymousClass1(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            defaultUncaughtExceptionHandler = uncaughtExceptionHandler;
        }

        private boolean a(Throwable th) {
            String message;
            if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                return false;
            }
            return message.contains("drawable") || message.contains("Drawable");
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            if (!a(th)) {
                defaultUncaughtExceptionHandler.uncaughtException(thread, th);
                return;
            }
            Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + AppCompatDelegateImpl.k);
            notFoundException.initCause(th.getCause());
            notFoundException.setStackTrace(th.getStackTrace());
            defaultUncaughtExceptionHandler.uncaughtException(thread, notFoundException);
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$2 */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl.c0 & 1) != 0) {
                appCompatDelegateImpl.q(0);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl2.c0 & 4096) != 0) {
                appCompatDelegateImpl2.q(108);
            }
            AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl3.b0 = false;
            appCompatDelegateImpl3.c0 = 0;
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$3 */
    class AnonymousClass3 implements OnApplyWindowInsetsListener {
        AnonymousClass3() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
            int f0 = AppCompatDelegateImpl.this.f0(systemWindowInsetTop);
            if (systemWindowInsetTop != f0) {
                windowInsetsCompat = windowInsetsCompat.replaceSystemWindowInsets(windowInsetsCompat.getSystemWindowInsetLeft(), f0, windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
            }
            return ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$4 */
    class AnonymousClass4 implements FitWindowsViewGroup.OnFitSystemWindowsListener {
        AnonymousClass4() {
        }

        @Override // androidx.appcompat.widget.FitWindowsViewGroup.OnFitSystemWindowsListener
        public void onFitSystemWindows(Rect rect) {
            rect.top = AppCompatDelegateImpl.this.f0(rect.top);
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$5 */
    class AnonymousClass5 implements ContentFrameLayout.OnAttachListener {
        AnonymousClass5() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.OnAttachListener
        public void onAttachedFromWindow() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.OnAttachListener
        public void onDetachedFromWindow() {
            AppCompatDelegateImpl.this.o();
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$6 */
    class AnonymousClass6 implements Runnable {

        /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$6$1 */
        class AnonymousClass1 extends ViewPropertyAnimatorListenerAdapter {
            AnonymousClass1() {
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                AppCompatDelegateImpl.this.x.setAlpha(1.0f);
                AppCompatDelegateImpl.this.A.setListener(null);
                AppCompatDelegateImpl.this.A = null;
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationStart(View view) {
                AppCompatDelegateImpl.this.x.setVisibility(0);
            }
        }

        AnonymousClass6() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            appCompatDelegateImpl.y.showAtLocation(appCompatDelegateImpl.x, 55, 0, 0);
            AppCompatDelegateImpl.this.r();
            if (!AppCompatDelegateImpl.this.Y()) {
                AppCompatDelegateImpl.this.x.setAlpha(1.0f);
                AppCompatDelegateImpl.this.x.setVisibility(0);
            } else {
                AppCompatDelegateImpl.this.x.setAlpha(0.0f);
                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl2.A = ViewCompat.animate(appCompatDelegateImpl2.x).alpha(1.0f);
                AppCompatDelegateImpl.this.A.setListener(new ViewPropertyAnimatorListenerAdapter() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.6.1
                    AnonymousClass1() {
                    }

                    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                    public void onAnimationEnd(View view) {
                        AppCompatDelegateImpl.this.x.setAlpha(1.0f);
                        AppCompatDelegateImpl.this.A.setListener(null);
                        AppCompatDelegateImpl.this.A = null;
                    }

                    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                    public void onAnimationStart(View view) {
                        AppCompatDelegateImpl.this.x.setVisibility(0);
                    }
                });
            }
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$7 */
    class AnonymousClass7 extends ViewPropertyAnimatorListenerAdapter {
        AnonymousClass7() {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            AppCompatDelegateImpl.this.x.setAlpha(1.0f);
            AppCompatDelegateImpl.this.A.setListener(null);
            AppCompatDelegateImpl.this.A = null;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View view) {
            AppCompatDelegateImpl.this.x.setVisibility(0);
            AppCompatDelegateImpl.this.x.sendAccessibilityEvent(32);
            if (AppCompatDelegateImpl.this.x.getParent() instanceof View) {
                ViewCompat.requestApplyInsets((View) AppCompatDelegateImpl.this.x.getParent());
            }
        }
    }

    private class ActionBarDrawableToggleImpl implements ActionBarDrawerToggle.Delegate {
        ActionBarDrawableToggleImpl() {
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Context getActionBarThemedContext() {
            return AppCompatDelegateImpl.this.v();
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Drawable getThemeUpIndicator() {
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getActionBarThemedContext(), (AttributeSet) null, new int[]{R.attr.homeAsUpIndicator});
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return drawable;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public boolean isNavigationVisible() {
            ActionBar supportActionBar = AppCompatDelegateImpl.this.getSupportActionBar();
            return (supportActionBar == null || (supportActionBar.getDisplayOptions() & 4) == 0) ? false : true;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(int i2) {
            ActionBar supportActionBar = AppCompatDelegateImpl.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setHomeActionContentDescription(i2);
            }
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(Drawable drawable, int i2) {
            ActionBar supportActionBar = AppCompatDelegateImpl.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setHomeAsUpIndicator(drawable);
                supportActionBar.setHomeActionContentDescription(i2);
            }
        }
    }

    private final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        ActionMenuPresenterCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            AppCompatDelegateImpl.this.j(menuBuilder);
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            Window.Callback B = AppCompatDelegateImpl.this.B();
            if (B == null) {
                return true;
            }
            B.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    class ActionModeCallbackWrapperV9 implements ActionMode.Callback {

        /* renamed from: a */
        private ActionMode.Callback f243a;

        /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$ActionModeCallbackWrapperV9$1 */
        class AnonymousClass1 extends ViewPropertyAnimatorListenerAdapter {
            AnonymousClass1() {
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                AppCompatDelegateImpl.this.x.setVisibility(8);
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                PopupWindow popupWindow = appCompatDelegateImpl.y;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (appCompatDelegateImpl.x.getParent() instanceof View) {
                    ViewCompat.requestApplyInsets((View) AppCompatDelegateImpl.this.x.getParent());
                }
                AppCompatDelegateImpl.this.x.removeAllViews();
                AppCompatDelegateImpl.this.A.setListener(null);
                AppCompatDelegateImpl.this.A = null;
            }
        }

        public ActionModeCallbackWrapperV9(ActionMode.Callback callback) {
            this.f243a = callback;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f243a.onActionItemClicked(actionMode, menuItem);
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f243a.onCreateActionMode(actionMode, menu);
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            this.f243a.onDestroyActionMode(actionMode);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl.y != null) {
                appCompatDelegateImpl.n.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.z);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl2.x != null) {
                appCompatDelegateImpl2.r();
                AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl3.A = ViewCompat.animate(appCompatDelegateImpl3.x).alpha(0.0f);
                AppCompatDelegateImpl.this.A.setListener(new ViewPropertyAnimatorListenerAdapter() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.ActionModeCallbackWrapperV9.1
                    AnonymousClass1() {
                    }

                    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                    public void onAnimationEnd(View view) {
                        AppCompatDelegateImpl.this.x.setVisibility(8);
                        AppCompatDelegateImpl appCompatDelegateImpl4 = AppCompatDelegateImpl.this;
                        PopupWindow popupWindow = appCompatDelegateImpl4.y;
                        if (popupWindow != null) {
                            popupWindow.dismiss();
                        } else if (appCompatDelegateImpl4.x.getParent() instanceof View) {
                            ViewCompat.requestApplyInsets((View) AppCompatDelegateImpl.this.x.getParent());
                        }
                        AppCompatDelegateImpl.this.x.removeAllViews();
                        AppCompatDelegateImpl.this.A.setListener(null);
                        AppCompatDelegateImpl.this.A = null;
                    }
                });
            }
            AppCompatDelegateImpl appCompatDelegateImpl4 = AppCompatDelegateImpl.this;
            AppCompatCallback appCompatCallback = appCompatDelegateImpl4.p;
            if (appCompatCallback != null) {
                appCompatCallback.onSupportActionModeFinished(appCompatDelegateImpl4.w);
            }
            AppCompatDelegateImpl.this.w = null;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return this.f243a.onPrepareActionMode(actionMode, menu);
        }
    }

    private class AutoBatteryNightModeManager extends AutoNightModeManager {

        /* renamed from: c */
        private final PowerManager f247c;

        AutoBatteryNightModeManager(@NonNull Context context) {
            super();
            this.f247c = (PowerManager) context.getSystemService("power");
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        IntentFilter b() {
            if (Build.VERSION.SDK_INT < 21) {
                return null;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public int getApplyableNightMode() {
            return (Build.VERSION.SDK_INT < 21 || !this.f247c.isPowerSaveMode()) ? 1 : 2;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public void onChange() {
            AppCompatDelegateImpl.this.applyDayNight();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    abstract class AutoNightModeManager {

        /* renamed from: a */
        private BroadcastReceiver f249a;

        /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$AutoNightModeManager$1 */
        class AnonymousClass1 extends BroadcastReceiver {
            AnonymousClass1() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                AutoNightModeManager.this.onChange();
            }
        }

        AutoNightModeManager() {
        }

        void a() {
            BroadcastReceiver broadcastReceiver = this.f249a;
            if (broadcastReceiver != null) {
                try {
                    AppCompatDelegateImpl.this.m.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f249a = null;
            }
        }

        @Nullable
        abstract IntentFilter b();

        boolean c() {
            return this.f249a != null;
        }

        void d() {
            a();
            IntentFilter b2 = b();
            if (b2 == null || b2.countActions() == 0) {
                return;
            }
            if (this.f249a == null) {
                this.f249a = new BroadcastReceiver() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager.1
                    AnonymousClass1() {
                    }

                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        AutoNightModeManager.this.onChange();
                    }
                };
            }
            AppCompatDelegateImpl.this.m.registerReceiver(this.f249a, b2);
        }

        abstract int getApplyableNightMode();

        abstract void onChange();
    }

    private class AutoTimeNightModeManager extends AutoNightModeManager {

        /* renamed from: c */
        private final TwilightManager f252c;

        AutoTimeNightModeManager(@NonNull TwilightManager twilightManager) {
            super();
            this.f252c = twilightManager;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public int getApplyableNightMode() {
            return this.f252c.d() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public void onChange() {
            AppCompatDelegateImpl.this.applyDayNight();
        }
    }

    private class ListMenuDecorView extends ContentFrameLayout {
        public ListMenuDecorView(Context context) {
            super(context);
        }

        private boolean a(int i2, int i3) {
            return i2 < -5 || i3 < -5 || i2 > getWidth() + 5 || i3 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.p(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            AppCompatDelegateImpl.this.l(0);
            return true;
        }

        @Override // android.view.View
        public void setBackgroundResource(int i2) {
            setBackgroundDrawable(AppCompatResources.getDrawable(getContext(), i2));
        }
    }

    protected static final class PanelFeatureState {

        /* renamed from: a */
        int f255a;

        /* renamed from: b */
        int f256b;

        /* renamed from: c */
        int f257c;

        /* renamed from: d */
        int f258d;

        /* renamed from: e */
        int f259e;

        /* renamed from: f */
        int f260f;

        /* renamed from: g */
        ViewGroup f261g;

        /* renamed from: h */
        View f262h;

        /* renamed from: i */
        View f263i;

        /* renamed from: j */
        MenuBuilder f264j;
        ListMenuPresenter k;
        Context l;
        boolean m;
        boolean n;
        boolean o;
        boolean p = false;
        boolean q;
        public boolean qwertyMode;
        boolean r;
        Bundle s;
        Bundle t;

        @SuppressLint({"BanParcelableUsage"})
        private static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState.SavedState.1
                AnonymousClass1() {
                }

                @Override // android.os.Parcelable.Creator
                public SavedState[] newArray(int i2) {
                    return new SavedState[i2];
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.a(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                public SavedState createFromParcel(Parcel parcel) {
                    return SavedState.a(parcel, null);
                }
            };

            /* renamed from: a */
            int f265a;

            /* renamed from: b */
            boolean f266b;

            /* renamed from: c */
            Bundle f267c;

            /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState$SavedState$1 */
            static class AnonymousClass1 implements Parcelable.ClassLoaderCreator<SavedState> {
                AnonymousClass1() {
                }

                @Override // android.os.Parcelable.Creator
                public SavedState[] newArray(int i2) {
                    return new SavedState[i2];
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.a(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                public SavedState createFromParcel(Parcel parcel) {
                    return SavedState.a(parcel, null);
                }
            }

            SavedState() {
            }

            static SavedState a(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.f265a = parcel.readInt();
                boolean z = parcel.readInt() == 1;
                savedState.f266b = z;
                if (z) {
                    savedState.f267c = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i2) {
                parcel.writeInt(this.f265a);
                parcel.writeInt(this.f266b ? 1 : 0);
                if (this.f266b) {
                    parcel.writeBundle(this.f267c);
                }
            }
        }

        PanelFeatureState(int i2) {
            this.f255a = i2;
        }

        void a() {
            Bundle bundle;
            MenuBuilder menuBuilder = this.f264j;
            if (menuBuilder == null || (bundle = this.s) == null) {
                return;
            }
            menuBuilder.restorePresenterStates(bundle);
            this.s = null;
        }

        MenuView b(MenuPresenter.Callback callback) {
            if (this.f264j == null) {
                return null;
            }
            if (this.k == null) {
                ListMenuPresenter listMenuPresenter = new ListMenuPresenter(this.l, R.layout.abc_list_menu_item_layout);
                this.k = listMenuPresenter;
                listMenuPresenter.setCallback(callback);
                this.f264j.addMenuPresenter(this.k);
            }
            return this.k.getMenuView(this.f261g);
        }

        void c(Parcelable parcelable) {
            SavedState savedState = (SavedState) parcelable;
            this.f255a = savedState.f265a;
            this.r = savedState.f266b;
            this.s = savedState.f267c;
            this.f262h = null;
            this.f261g = null;
        }

        public void clearMenuPresenters() {
            MenuBuilder menuBuilder = this.f264j;
            if (menuBuilder != null) {
                menuBuilder.removeMenuPresenter(this.k);
            }
            this.k = null;
        }

        Parcelable d() {
            SavedState savedState = new SavedState();
            savedState.f265a = this.f255a;
            savedState.f266b = this.o;
            if (this.f264j != null) {
                Bundle bundle = new Bundle();
                savedState.f267c = bundle;
                this.f264j.savePresenterStates(bundle);
            }
            return savedState;
        }

        void e(MenuBuilder menuBuilder) {
            ListMenuPresenter listMenuPresenter;
            MenuBuilder menuBuilder2 = this.f264j;
            if (menuBuilder == menuBuilder2) {
                return;
            }
            if (menuBuilder2 != null) {
                menuBuilder2.removeMenuPresenter(this.k);
            }
            this.f264j = menuBuilder;
            if (menuBuilder == null || (listMenuPresenter = this.k) == null) {
                return;
            }
            menuBuilder.addMenuPresenter(listMenuPresenter);
        }

        void f(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                newTheme.applyStyle(i2, true);
            }
            newTheme.resolveAttribute(R.attr.panelMenuListTheme, typedValue, true);
            int i3 = typedValue.resourceId;
            if (i3 != 0) {
                newTheme.applyStyle(i3, true);
            } else {
                newTheme.applyStyle(R.style.Theme_AppCompat_CompactMenu, true);
            }
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
            contextThemeWrapper.getTheme().setTo(newTheme);
            this.l = contextThemeWrapper;
            TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(R.styleable.AppCompatTheme);
            this.f256b = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTheme_panelBackground, 0);
            this.f260f = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        public boolean hasPanelItems() {
            if (this.f262h == null) {
                return false;
            }
            return this.f263i != null || this.k.getAdapter().getCount() > 0;
        }
    }

    private final class PanelMenuPresenterCallback implements MenuPresenter.Callback {
        PanelMenuPresenterCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            MenuBuilder rootMenu = menuBuilder.getRootMenu();
            boolean z2 = rootMenu != menuBuilder;
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z2) {
                menuBuilder = rootMenu;
            }
            PanelFeatureState u = appCompatDelegateImpl.u(menuBuilder);
            if (u != null) {
                if (!z2) {
                    AppCompatDelegateImpl.this.m(u, z);
                } else {
                    AppCompatDelegateImpl.this.i(u.f255a, u, rootMenu);
                    AppCompatDelegateImpl.this.m(u, true);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            Window.Callback B;
            if (menuBuilder != null) {
                return true;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (!appCompatDelegateImpl.I || (B = appCompatDelegateImpl.B()) == null || AppCompatDelegateImpl.this.U) {
                return true;
            }
            B.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        boolean z = false;
        boolean z2 = i2 < 21;
        f229g = z2;
        f230h = new int[]{android.R.attr.windowBackground};
        if (i2 >= 21 && i2 <= 25) {
            z = true;
        }
        f232j = z;
        if (!z2 || f231i) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.1

            /* renamed from: a */
            final /* synthetic */ Thread.UncaughtExceptionHandler f233a;

            AnonymousClass1(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
                defaultUncaughtExceptionHandler = uncaughtExceptionHandler;
            }

            private boolean a(Throwable th) {
                String message;
                if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                    return false;
                }
                return message.contains("drawable") || message.contains("Drawable");
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                if (!a(th)) {
                    defaultUncaughtExceptionHandler.uncaughtException(thread, th);
                    return;
                }
                Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + AppCompatDelegateImpl.k);
                notFoundException.initCause(th.getCause());
                notFoundException.setStackTrace(th.getStackTrace());
                defaultUncaughtExceptionHandler.uncaughtException(thread, notFoundException);
            }
        });
        f231i = true;
    }

    AppCompatDelegateImpl(Activity activity, AppCompatCallback appCompatCallback) {
        this(activity, null, appCompatCallback, activity);
    }

    private void C() {
        s();
        if (this.I && this.q == null) {
            Object obj = this.l;
            if (obj instanceof Activity) {
                this.q = new WindowDecorActionBar((Activity) this.l, this.J);
            } else if (obj instanceof Dialog) {
                this.q = new WindowDecorActionBar((Dialog) this.l);
            }
            ActionBar actionBar = this.q;
            if (actionBar != null) {
                actionBar.setDefaultDisplayHomeAsUpEnabled(this.e0);
            }
        }
    }

    private boolean D(PanelFeatureState panelFeatureState) {
        View view = panelFeatureState.f263i;
        if (view != null) {
            panelFeatureState.f262h = view;
            return true;
        }
        if (panelFeatureState.f264j == null) {
            return false;
        }
        if (this.v == null) {
            this.v = new PanelMenuPresenterCallback();
        }
        View view2 = (View) panelFeatureState.b(this.v);
        panelFeatureState.f262h = view2;
        return view2 != null;
    }

    private boolean E(PanelFeatureState panelFeatureState) {
        panelFeatureState.f(v());
        panelFeatureState.f261g = new ListMenuDecorView(panelFeatureState.l);
        panelFeatureState.f257c = 81;
        return true;
    }

    private boolean F(PanelFeatureState panelFeatureState) {
        Context context = this.m;
        int i2 = panelFeatureState.f255a;
        if ((i2 == 0 || i2 == 108) && this.t != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(R.attr.actionBarTheme, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
                contextThemeWrapper.getTheme().setTo(theme2);
                context = contextThemeWrapper;
            }
        }
        MenuBuilder menuBuilder = new MenuBuilder(context);
        menuBuilder.setCallback(this);
        panelFeatureState.e(menuBuilder);
        return true;
    }

    private void G(int i2) {
        this.c0 = (1 << i2) | this.c0;
        if (this.b0) {
            return;
        }
        ViewCompat.postOnAnimation(this.n.getDecorView(), this.d0);
        this.b0 = true;
    }

    private boolean H() {
        if (!this.Y && (this.l instanceof Activity)) {
            PackageManager packageManager = this.m.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.m, this.l.getClass()), 0);
                this.X = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException e2) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e2);
                this.X = false;
            }
        }
        this.Y = true;
        return this.X;
    }

    private boolean L(int i2, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        PanelFeatureState y = y(i2, true);
        if (y.o) {
            return false;
        }
        return V(y, keyEvent);
    }

    private boolean O(int i2, KeyEvent keyEvent) {
        boolean z;
        DecorContentParent decorContentParent;
        if (this.w != null) {
            return false;
        }
        boolean z2 = true;
        PanelFeatureState y = y(i2, true);
        if (i2 != 0 || (decorContentParent = this.t) == null || !decorContentParent.canShowOverflowMenu() || ViewConfiguration.get(this.m).hasPermanentMenuKey()) {
            boolean z3 = y.o;
            if (z3 || y.n) {
                m(y, true);
                z2 = z3;
            } else {
                if (y.m) {
                    if (y.q) {
                        y.m = false;
                        z = V(y, keyEvent);
                    } else {
                        z = true;
                    }
                    if (z) {
                        S(y, keyEvent);
                    }
                }
                z2 = false;
            }
        } else if (this.t.isOverflowMenuShowing()) {
            z2 = this.t.hideOverflowMenu();
        } else {
            if (!this.U && V(y, keyEvent)) {
                z2 = this.t.showOverflowMenu();
            }
            z2 = false;
        }
        if (z2) {
            AudioManager audioManager = (AudioManager) this.m.getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return z2;
    }

    private void S(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        int i2;
        ViewGroup.LayoutParams layoutParams;
        if (panelFeatureState.o || this.U) {
            return;
        }
        if (panelFeatureState.f255a == 0) {
            if ((this.m.getResources().getConfiguration().screenLayout & 15) == 4) {
                return;
            }
        }
        Window.Callback B = B();
        if (B != null && !B.onMenuOpened(panelFeatureState.f255a, panelFeatureState.f264j)) {
            m(panelFeatureState, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.m.getSystemService("window");
        if (windowManager != null && V(panelFeatureState, keyEvent)) {
            ViewGroup viewGroup = panelFeatureState.f261g;
            if (viewGroup == null || panelFeatureState.p) {
                if (viewGroup == null) {
                    if (!E(panelFeatureState) || panelFeatureState.f261g == null) {
                        return;
                    }
                } else if (panelFeatureState.p && viewGroup.getChildCount() > 0) {
                    panelFeatureState.f261g.removeAllViews();
                }
                if (!D(panelFeatureState) || !panelFeatureState.hasPanelItems()) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams2 = panelFeatureState.f262h.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                }
                panelFeatureState.f261g.setBackgroundResource(panelFeatureState.f256b);
                ViewParent parent = panelFeatureState.f262h.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(panelFeatureState.f262h);
                }
                panelFeatureState.f261g.addView(panelFeatureState.f262h, layoutParams2);
                if (!panelFeatureState.f262h.hasFocus()) {
                    panelFeatureState.f262h.requestFocus();
                }
            } else {
                View view = panelFeatureState.f263i;
                if (view != null && (layoutParams = view.getLayoutParams()) != null && layoutParams.width == -1) {
                    i2 = -1;
                    panelFeatureState.n = false;
                    WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i2, -2, panelFeatureState.f258d, panelFeatureState.f259e, 1002, 8519680, -3);
                    layoutParams3.gravity = panelFeatureState.f257c;
                    layoutParams3.windowAnimations = panelFeatureState.f260f;
                    windowManager.addView(panelFeatureState.f261g, layoutParams3);
                    panelFeatureState.o = true;
                }
            }
            i2 = -2;
            panelFeatureState.n = false;
            WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i2, -2, panelFeatureState.f258d, panelFeatureState.f259e, 1002, 8519680, -3);
            layoutParams32.gravity = panelFeatureState.f257c;
            layoutParams32.windowAnimations = panelFeatureState.f260f;
            windowManager.addView(panelFeatureState.f261g, layoutParams32);
            panelFeatureState.o = true;
        }
    }

    private boolean U(PanelFeatureState panelFeatureState, int i2, KeyEvent keyEvent, int i3) {
        MenuBuilder menuBuilder;
        boolean z = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.m || V(panelFeatureState, keyEvent)) && (menuBuilder = panelFeatureState.f264j) != null) {
            z = menuBuilder.performShortcut(i2, keyEvent, i3);
        }
        if (z && (i3 & 1) == 0 && this.t == null) {
            m(panelFeatureState, true);
        }
        return z;
    }

    private boolean V(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        DecorContentParent decorContentParent;
        DecorContentParent decorContentParent2;
        DecorContentParent decorContentParent3;
        if (this.U) {
            return false;
        }
        if (panelFeatureState.m) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.P;
        if (panelFeatureState2 != null && panelFeatureState2 != panelFeatureState) {
            m(panelFeatureState2, false);
        }
        Window.Callback B = B();
        if (B != null) {
            panelFeatureState.f263i = B.onCreatePanelView(panelFeatureState.f255a);
        }
        int i2 = panelFeatureState.f255a;
        boolean z = i2 == 0 || i2 == 108;
        if (z && (decorContentParent3 = this.t) != null) {
            decorContentParent3.setMenuPrepared();
        }
        if (panelFeatureState.f263i == null && (!z || !(T() instanceof ToolbarActionBar))) {
            MenuBuilder menuBuilder = panelFeatureState.f264j;
            if (menuBuilder == null || panelFeatureState.q) {
                if (menuBuilder == null && (!F(panelFeatureState) || panelFeatureState.f264j == null)) {
                    return false;
                }
                if (z && this.t != null) {
                    if (this.u == null) {
                        this.u = new ActionMenuPresenterCallback();
                    }
                    this.t.setMenu(panelFeatureState.f264j, this.u);
                }
                panelFeatureState.f264j.stopDispatchingItemsChanged();
                if (!B.onCreatePanelMenu(panelFeatureState.f255a, panelFeatureState.f264j)) {
                    panelFeatureState.e(null);
                    if (z && (decorContentParent = this.t) != null) {
                        decorContentParent.setMenu(null, this.u);
                    }
                    return false;
                }
                panelFeatureState.q = false;
            }
            panelFeatureState.f264j.stopDispatchingItemsChanged();
            Bundle bundle = panelFeatureState.t;
            if (bundle != null) {
                panelFeatureState.f264j.restoreActionViewStates(bundle);
                panelFeatureState.t = null;
            }
            if (!B.onPreparePanel(0, panelFeatureState.f263i, panelFeatureState.f264j)) {
                if (z && (decorContentParent2 = this.t) != null) {
                    decorContentParent2.setMenu(null, this.u);
                }
                panelFeatureState.f264j.startDispatchingItemsChanged();
                return false;
            }
            boolean z2 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.qwertyMode = z2;
            panelFeatureState.f264j.setQwertyMode(z2);
            panelFeatureState.f264j.startDispatchingItemsChanged();
        }
        panelFeatureState.m = true;
        panelFeatureState.n = false;
        this.P = panelFeatureState;
        return true;
    }

    private void W(MenuBuilder menuBuilder, boolean z) {
        DecorContentParent decorContentParent = this.t;
        if (decorContentParent == null || !decorContentParent.canShowOverflowMenu() || (ViewConfiguration.get(this.m).hasPermanentMenuKey() && !this.t.isOverflowMenuShowPending())) {
            PanelFeatureState y = y(0, true);
            y.p = true;
            m(y, false);
            S(y, null);
            return;
        }
        Window.Callback B = B();
        if (this.t.isOverflowMenuShowing() && z) {
            this.t.hideOverflowMenu();
            if (this.U) {
                return;
            }
            B.onPanelClosed(108, y(0, true).f264j);
            return;
        }
        if (B == null || this.U) {
            return;
        }
        if (this.b0 && (this.c0 & 1) != 0) {
            this.n.getDecorView().removeCallbacks(this.d0);
            this.d0.run();
        }
        PanelFeatureState y2 = y(0, true);
        MenuBuilder menuBuilder2 = y2.f264j;
        if (menuBuilder2 == null || y2.q || !B.onPreparePanel(0, y2.f263i, menuBuilder2)) {
            return;
        }
        B.onMenuOpened(108, y2.f264j);
        this.t.showOverflowMenu();
    }

    private int X(int i2) {
        if (i2 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (i2 != 9) {
            return i2;
        }
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return 109;
    }

    private boolean Z(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.n.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || ViewCompat.isAttachedToWindow((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private void b0() {
        if (this.C) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    @Nullable
    private AppCompatActivity c0() {
        for (Context context = this.m; context != null; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof AppCompatActivity) {
                return (AppCompatActivity) context;
            }
            if (!(context instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    private boolean d0(int i2, boolean z) {
        int i3 = this.m.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        boolean z2 = true;
        int i4 = i2 != 1 ? i2 != 2 ? i3 : 32 : 16;
        boolean H = H();
        boolean z3 = false;
        if ((f232j || i4 != i3) && !H && Build.VERSION.SDK_INT >= 17 && !this.R && (this.l instanceof android.view.ContextThemeWrapper)) {
            Configuration configuration = new Configuration();
            configuration.uiMode = (configuration.uiMode & (-49)) | i4;
            try {
                ((android.view.ContextThemeWrapper) this.l).applyOverrideConfiguration(configuration);
                z3 = true;
            } catch (IllegalStateException e2) {
                Log.e("AppCompatDelegate", "updateForNightMode. Calling applyOverrideConfiguration() failed with an exception. Will fall back to using Resources.updateConfiguration()", e2);
            }
        }
        int i5 = this.m.getResources().getConfiguration().uiMode & 48;
        if (!z3 && i5 != i4 && z && !H && this.R && (Build.VERSION.SDK_INT >= 17 || this.S)) {
            Object obj = this.l;
            if (obj instanceof Activity) {
                ActivityCompat.recreate((Activity) obj);
                z3 = true;
            }
        }
        if (z3 || i5 == i4) {
            z2 = z3;
        } else {
            e0(i4, H);
        }
        if (z2) {
            Object obj2 = this.l;
            if (obj2 instanceof AppCompatActivity) {
                ((AppCompatActivity) obj2).onNightModeChanged(i2);
            }
        }
        return z2;
    }

    private boolean e(boolean z) {
        if (this.U) {
            return false;
        }
        int h2 = h();
        boolean d0 = d0(I(h2), z);
        if (h2 == 0) {
            x().d();
        } else {
            AutoNightModeManager autoNightModeManager = this.Z;
            if (autoNightModeManager != null) {
                autoNightModeManager.a();
            }
        }
        if (h2 == 3) {
            w().d();
        } else {
            AutoNightModeManager autoNightModeManager2 = this.a0;
            if (autoNightModeManager2 != null) {
                autoNightModeManager2.a();
            }
        }
        return d0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void e0(int i2, boolean z) {
        Resources resources = this.m.getResources();
        Configuration configuration = new Configuration(resources.getConfiguration());
        configuration.uiMode = i2 | (resources.getConfiguration().uiMode & (-49));
        resources.updateConfiguration(configuration, null);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 26) {
            ResourcesFlusher.a(resources);
        }
        int i4 = this.W;
        if (i4 != 0) {
            this.m.setTheme(i4);
            if (i3 >= 23) {
                this.m.getTheme().applyStyle(this.W, true);
            }
        }
        if (z) {
            Object obj = this.l;
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                if (activity instanceof LifecycleOwner) {
                    if (((LifecycleOwner) activity).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                        activity.onConfigurationChanged(configuration);
                    }
                } else if (this.T) {
                    activity.onConfigurationChanged(configuration);
                }
            }
        }
    }

    private void f() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.D.findViewById(android.R.id.content);
        View decorView = this.n.getDecorView();
        contentFrameLayout.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.m.obtainStyledAttributes(R.styleable.AppCompatTheme);
        obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        int i2 = R.styleable.AppCompatTheme_windowFixedWidthMajor;
        if (obtainStyledAttributes.hasValue(i2)) {
            obtainStyledAttributes.getValue(i2, contentFrameLayout.getFixedWidthMajor());
        }
        int i3 = R.styleable.AppCompatTheme_windowFixedWidthMinor;
        if (obtainStyledAttributes.hasValue(i3)) {
            obtainStyledAttributes.getValue(i3, contentFrameLayout.getFixedWidthMinor());
        }
        int i4 = R.styleable.AppCompatTheme_windowFixedHeightMajor;
        if (obtainStyledAttributes.hasValue(i4)) {
            obtainStyledAttributes.getValue(i4, contentFrameLayout.getFixedHeightMajor());
        }
        int i5 = R.styleable.AppCompatTheme_windowFixedHeightMinor;
        if (obtainStyledAttributes.hasValue(i5)) {
            obtainStyledAttributes.getValue(i5, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private void g(@NonNull Window window) {
        if (this.n != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof AppCompatWindowCallback) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        AppCompatWindowCallback appCompatWindowCallback = new AppCompatWindowCallback(callback);
        this.o = appCompatWindowCallback;
        window.setCallback(appCompatWindowCallback);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.m, (AttributeSet) null, f230h);
        Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(0);
        if (drawableIfKnown != null) {
            window.setBackgroundDrawable(drawableIfKnown);
        }
        obtainStyledAttributes.recycle();
        this.n = window;
    }

    private int h() {
        int i2 = this.V;
        return i2 != -100 ? i2 : AppCompatDelegate.getDefaultNightMode();
    }

    private void k() {
        AutoNightModeManager autoNightModeManager = this.Z;
        if (autoNightModeManager != null) {
            autoNightModeManager.a();
        }
        AutoNightModeManager autoNightModeManager2 = this.a0;
        if (autoNightModeManager2 != null) {
            autoNightModeManager2.a();
        }
    }

    private ViewGroup n() {
        ViewGroup viewGroup;
        TypedArray obtainStyledAttributes = this.m.obtainStyledAttributes(R.styleable.AppCompatTheme);
        int i2 = R.styleable.AppCompatTheme_windowActionBar;
        if (!obtainStyledAttributes.hasValue(i2)) {
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowNoTitle, false)) {
            requestWindowFeature(1);
        } else if (obtainStyledAttributes.getBoolean(i2, false)) {
            requestWindowFeature(108);
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
            requestWindowFeature(109);
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
            requestWindowFeature(10);
        }
        this.L = obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_android_windowIsFloating, false);
        obtainStyledAttributes.recycle();
        t();
        this.n.getDecorView();
        LayoutInflater from = LayoutInflater.from(this.m);
        if (this.M) {
            viewGroup = this.K ? (ViewGroup) from.inflate(R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) from.inflate(R.layout.abc_screen_simple, (ViewGroup) null);
            if (Build.VERSION.SDK_INT >= 21) {
                ViewCompat.setOnApplyWindowInsetsListener(viewGroup, new OnApplyWindowInsetsListener() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.3
                    AnonymousClass3() {
                    }

                    @Override // androidx.core.view.OnApplyWindowInsetsListener
                    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                        int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
                        int f0 = AppCompatDelegateImpl.this.f0(systemWindowInsetTop);
                        if (systemWindowInsetTop != f0) {
                            windowInsetsCompat = windowInsetsCompat.replaceSystemWindowInsets(windowInsetsCompat.getSystemWindowInsetLeft(), f0, windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                        }
                        return ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
                    }
                });
            } else {
                ((FitWindowsViewGroup) viewGroup).setOnFitSystemWindowsListener(new FitWindowsViewGroup.OnFitSystemWindowsListener() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.4
                    AnonymousClass4() {
                    }

                    @Override // androidx.appcompat.widget.FitWindowsViewGroup.OnFitSystemWindowsListener
                    public void onFitSystemWindows(Rect rect) {
                        rect.top = AppCompatDelegateImpl.this.f0(rect.top);
                    }
                });
            }
        } else if (this.L) {
            viewGroup = (ViewGroup) from.inflate(R.layout.abc_dialog_title_material, (ViewGroup) null);
            this.J = false;
            this.I = false;
        } else if (this.I) {
            TypedValue typedValue = new TypedValue();
            this.m.getTheme().resolveAttribute(R.attr.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new ContextThemeWrapper(this.m, typedValue.resourceId) : this.m).inflate(R.layout.abc_screen_toolbar, (ViewGroup) null);
            DecorContentParent decorContentParent = (DecorContentParent) viewGroup.findViewById(R.id.decor_content_parent);
            this.t = decorContentParent;
            decorContentParent.setWindowCallback(B());
            if (this.J) {
                this.t.initFeature(109);
            }
            if (this.G) {
                this.t.initFeature(2);
            }
            if (this.H) {
                this.t.initFeature(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.I + ", windowActionBarOverlay: " + this.J + ", android:windowIsFloating: " + this.L + ", windowActionModeOverlay: " + this.K + ", windowNoTitle: " + this.M + " }");
        }
        if (this.t == null) {
            this.E = (TextView) viewGroup.findViewById(R.id.title);
        }
        ViewUtils.makeOptionalFitsSystemWindows(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R.id.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.n.findViewById(android.R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(android.R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.n.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new ContentFrameLayout.OnAttachListener() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.5
            AnonymousClass5() {
            }

            @Override // androidx.appcompat.widget.ContentFrameLayout.OnAttachListener
            public void onAttachedFromWindow() {
            }

            @Override // androidx.appcompat.widget.ContentFrameLayout.OnAttachListener
            public void onDetachedFromWindow() {
                AppCompatDelegateImpl.this.o();
            }
        });
        return viewGroup;
    }

    private void s() {
        if (this.C) {
            return;
        }
        this.D = n();
        CharSequence A = A();
        if (!TextUtils.isEmpty(A)) {
            DecorContentParent decorContentParent = this.t;
            if (decorContentParent != null) {
                decorContentParent.setWindowTitle(A);
            } else if (T() != null) {
                T().setWindowTitle(A);
            } else {
                TextView textView = this.E;
                if (textView != null) {
                    textView.setText(A);
                }
            }
        }
        f();
        R(this.D);
        this.C = true;
        PanelFeatureState y = y(0, false);
        if (this.U) {
            return;
        }
        if (y == null || y.f264j == null) {
            G(108);
        }
    }

    private void t() {
        if (this.n == null) {
            Object obj = this.l;
            if (obj instanceof Activity) {
                g(((Activity) obj).getWindow());
            }
        }
        if (this.n == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    private AutoNightModeManager w() {
        if (this.a0 == null) {
            this.a0 = new AutoBatteryNightModeManager(this.m);
        }
        return this.a0;
    }

    final CharSequence A() {
        Object obj = this.l;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.s;
    }

    final Window.Callback B() {
        return this.n.getCallback();
    }

    int I(int i2) {
        if (i2 == -100) {
            return -1;
        }
        if (i2 == -1) {
            return i2;
        }
        if (i2 == 0) {
            if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) this.m.getSystemService(UiModeManager.class)).getNightMode() != 0) {
                return x().getApplyableNightMode();
            }
            return -1;
        }
        if (i2 == 1 || i2 == 2) {
            return i2;
        }
        if (i2 == 3) {
            return w().getApplyableNightMode();
        }
        throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
    }

    boolean J() {
        ActionMode actionMode = this.w;
        if (actionMode != null) {
            actionMode.finish();
            return true;
        }
        ActionBar supportActionBar = getSupportActionBar();
        return supportActionBar != null && supportActionBar.collapseActionView();
    }

    boolean K(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            this.Q = (keyEvent.getFlags() & 128) != 0;
        } else if (i2 == 82) {
            L(0, keyEvent);
            return true;
        }
        return false;
    }

    boolean M(int i2, KeyEvent keyEvent) {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null && supportActionBar.onKeyShortcut(i2, keyEvent)) {
            return true;
        }
        PanelFeatureState panelFeatureState = this.P;
        if (panelFeatureState != null && U(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
            PanelFeatureState panelFeatureState2 = this.P;
            if (panelFeatureState2 != null) {
                panelFeatureState2.n = true;
            }
            return true;
        }
        if (this.P == null) {
            PanelFeatureState y = y(0, true);
            V(y, keyEvent);
            boolean U = U(y, keyEvent.getKeyCode(), keyEvent, 1);
            y.m = false;
            if (U) {
                return true;
            }
        }
        return false;
    }

    boolean N(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            boolean z = this.Q;
            this.Q = false;
            PanelFeatureState y = y(0, false);
            if (y != null && y.o) {
                if (!z) {
                    m(y, true);
                }
                return true;
            }
            if (J()) {
                return true;
            }
        } else if (i2 == 82) {
            O(0, keyEvent);
            return true;
        }
        return false;
    }

    void P(int i2) {
        ActionBar supportActionBar;
        if (i2 != 108 || (supportActionBar = getSupportActionBar()) == null) {
            return;
        }
        supportActionBar.dispatchMenuVisibilityChanged(true);
    }

    void Q(int i2) {
        if (i2 == 108) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.dispatchMenuVisibilityChanged(false);
                return;
            }
            return;
        }
        if (i2 == 0) {
            PanelFeatureState y = y(i2, true);
            if (y.o) {
                m(y, false);
            }
        }
    }

    void R(ViewGroup viewGroup) {
    }

    final ActionBar T() {
        return this.q;
    }

    final boolean Y() {
        ViewGroup viewGroup;
        return this.C && (viewGroup = this.D) != null && ViewCompat.isLaidOut(viewGroup);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    androidx.appcompat.view.ActionMode a0(@androidx.annotation.NonNull androidx.appcompat.view.ActionMode.Callback r8) {
        /*
            Method dump skipped, instructions count: 368
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.a0(androidx.appcompat.view.ActionMode$Callback):androidx.appcompat.view.ActionMode");
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        s();
        ((ViewGroup) this.D.findViewById(android.R.id.content)).addView(view, layoutParams);
        this.o.getWrapped().onContentChanged();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean applyDayNight() {
        return e(true);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void attachBaseContext(Context context) {
        e(false);
        this.R = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.app.AppCompatDelegate
    public View createView(View view, String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        boolean z;
        boolean z2 = false;
        if (this.h0 == null) {
            String string = this.m.obtainStyledAttributes(R.styleable.AppCompatTheme).getString(R.styleable.AppCompatTheme_viewInflaterClass);
            if (string == null || AppCompatViewInflater.class.getName().equals(string)) {
                this.h0 = new AppCompatViewInflater();
            } else {
                try {
                    this.h0 = (AppCompatViewInflater) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.h0 = new AppCompatViewInflater();
                }
            }
        }
        boolean z3 = f229g;
        if (z3) {
            if (!(attributeSet instanceof XmlPullParser)) {
                z2 = Z((ViewParent) view);
            } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                z2 = true;
            }
            z = z2;
        } else {
            z = false;
        }
        return this.h0.q(view, str, context, attributeSet, z, z3, true, VectorEnabledTintResources.shouldBeUsed());
    }

    int f0(int i2) {
        boolean z;
        boolean z2;
        ActionBarContextView actionBarContextView = this.x;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.x.getLayoutParams();
            if (this.x.isShown()) {
                if (this.f0 == null) {
                    this.f0 = new Rect();
                    this.g0 = new Rect();
                }
                Rect rect = this.f0;
                Rect rect2 = this.g0;
                rect.set(0, i2, 0, 0);
                ViewUtils.computeFitSystemWindows(this.D, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i2 : 0)) {
                    marginLayoutParams.topMargin = i2;
                    View view = this.F;
                    if (view == null) {
                        View view2 = new View(this.m);
                        this.F = view2;
                        view2.setBackgroundColor(this.m.getResources().getColor(R.color.abc_input_method_navigation_guard));
                        this.D.addView(this.F, -1, new ViewGroup.LayoutParams(-1, i2));
                    } else {
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams.height != i2) {
                            layoutParams.height = i2;
                            this.F.setLayoutParams(layoutParams);
                        }
                    }
                    z2 = true;
                } else {
                    z2 = false;
                }
                r3 = this.F != null;
                if (!this.K && r3) {
                    i2 = 0;
                }
                boolean z3 = r3;
                r3 = z2;
                z = z3;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z = false;
            } else {
                z = false;
                r3 = false;
            }
            if (r3) {
                this.x.setLayoutParams(marginLayoutParams);
            }
        }
        View view3 = this.F;
        if (view3 != null) {
            view3.setVisibility(z ? 0 : 8);
        }
        return i2;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    @Nullable
    public <T extends View> T findViewById(@IdRes int i2) {
        s();
        return (T) this.n.findViewById(i2);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return new ActionBarDrawableToggleImpl();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public int getLocalNightMode() {
        return this.V;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public MenuInflater getMenuInflater() {
        if (this.r == null) {
            C();
            ActionBar actionBar = this.q;
            this.r = new SupportMenuInflater(actionBar != null ? actionBar.getThemedContext() : this.m);
        }
        return this.r;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public ActionBar getSupportActionBar() {
        C();
        return this.q;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean hasWindowFeature(int i2) {
        int X = X(i2);
        return (X != 1 ? X != 2 ? X != 5 ? X != 10 ? X != 108 ? X != 109 ? false : this.J : this.I : this.K : this.H : this.G : this.M) || this.n.hasFeature(i2);
    }

    void i(int i2, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i2 >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.O;
                if (i2 < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i2];
                }
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.f264j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.o) && !this.U) {
            this.o.getWrapped().onPanelClosed(i2, menu);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void installViewFactory() {
        LayoutInflater from = LayoutInflater.from(this.m);
        if (from.getFactory() == null) {
            LayoutInflaterCompat.setFactory2(from, this);
        } else {
            if (from.getFactory2() instanceof AppCompatDelegateImpl) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void invalidateOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null || !supportActionBar.invalidateOptionsMenu()) {
            G(0);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean isHandleNativeActionModesEnabled() {
        return this.B;
    }

    void j(MenuBuilder menuBuilder) {
        if (this.N) {
            return;
        }
        this.N = true;
        this.t.dismissPopups();
        Window.Callback B = B();
        if (B != null && !this.U) {
            B.onPanelClosed(108, menuBuilder);
        }
        this.N = false;
    }

    void l(int i2) {
        m(y(i2, true), true);
    }

    void m(PanelFeatureState panelFeatureState, boolean z) {
        ViewGroup viewGroup;
        DecorContentParent decorContentParent;
        if (z && panelFeatureState.f255a == 0 && (decorContentParent = this.t) != null && decorContentParent.isOverflowMenuShowing()) {
            j(panelFeatureState.f264j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.m.getSystemService("window");
        if (windowManager != null && panelFeatureState.o && (viewGroup = panelFeatureState.f261g) != null) {
            windowManager.removeView(viewGroup);
            if (z) {
                i(panelFeatureState.f255a, panelFeatureState, null);
            }
        }
        panelFeatureState.m = false;
        panelFeatureState.n = false;
        panelFeatureState.o = false;
        panelFeatureState.f262h = null;
        panelFeatureState.p = true;
        if (this.P == panelFeatureState) {
            this.P = null;
        }
    }

    void o() {
        MenuBuilder menuBuilder;
        DecorContentParent decorContentParent = this.t;
        if (decorContentParent != null) {
            decorContentParent.dismissPopups();
        }
        if (this.y != null) {
            this.n.getDecorView().removeCallbacks(this.z);
            if (this.y.isShowing()) {
                try {
                    this.y.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.y = null;
        }
        r();
        PanelFeatureState y = y(0, false);
        if (y == null || (menuBuilder = y.f264j) == null) {
            return;
        }
        menuBuilder.close();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onConfigurationChanged(Configuration configuration) {
        ActionBar supportActionBar;
        if (this.I && this.C && (supportActionBar = getSupportActionBar()) != null) {
            supportActionBar.onConfigurationChanged(configuration);
        }
        AppCompatDrawableManager.get().onConfigurationChanged(this.m);
        e(false);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onCreate(Bundle bundle) {
        this.R = true;
        e(false);
        t();
        Object obj = this.l;
        if (obj instanceof Activity) {
            String str = null;
            try {
                str = NavUtils.getParentActivityName((Activity) obj);
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                ActionBar T = T();
                if (T == null) {
                    this.e0 = true;
                } else {
                    T.setDefaultDisplayHomeAsUpEnabled(true);
                }
            }
        }
        this.S = true;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return createView(view, str, context, attributeSet);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onDestroy() {
        AppCompatDelegate.c(this);
        if (this.b0) {
            this.n.getDecorView().removeCallbacks(this.d0);
        }
        this.T = false;
        this.U = true;
        ActionBar actionBar = this.q;
        if (actionBar != null) {
            actionBar.a();
        }
        k();
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        PanelFeatureState u;
        Window.Callback B = B();
        if (B == null || this.U || (u = u(menuBuilder.getRootMenu())) == null) {
            return false;
        }
        return B.onMenuItemSelected(u.f255a, menuItem);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public void onMenuModeChange(MenuBuilder menuBuilder) {
        W(menuBuilder, true);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onPostCreate(Bundle bundle) {
        s();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onPostResume() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setShowHideAnimationEnabled(true);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onSaveInstanceState(Bundle bundle) {
        if (this.V != -100) {
            f227e.put(this.l.getClass(), Integer.valueOf(this.V));
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onStart() {
        this.T = true;
        applyDayNight();
        AppCompatDelegate.b(this);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onStop() {
        this.T = false;
        AppCompatDelegate.c(this);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setShowHideAnimationEnabled(false);
        }
        if (this.l instanceof Dialog) {
            k();
        }
    }

    boolean p(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.l;
        if (((obj instanceof KeyEventDispatcher.Component) || (obj instanceof AppCompatDialog)) && (decorView = this.n.getDecorView()) != null && KeyEventDispatcher.dispatchBeforeHierarchy(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.o.getWrapped().dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? K(keyCode, keyEvent) : N(keyCode, keyEvent);
    }

    void q(int i2) {
        PanelFeatureState y;
        PanelFeatureState y2 = y(i2, true);
        if (y2.f264j != null) {
            Bundle bundle = new Bundle();
            y2.f264j.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                y2.t = bundle;
            }
            y2.f264j.stopDispatchingItemsChanged();
            y2.f264j.clear();
        }
        y2.q = true;
        y2.p = true;
        if ((i2 != 108 && i2 != 0) || this.t == null || (y = y(0, false)) == null) {
            return;
        }
        y.m = false;
        V(y, null);
    }

    void r() {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.A;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.cancel();
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean requestWindowFeature(int i2) {
        int X = X(i2);
        if (this.M && X == 108) {
            return false;
        }
        if (this.I && X == 1) {
            this.I = false;
        }
        if (X == 1) {
            b0();
            this.M = true;
            return true;
        }
        if (X == 2) {
            b0();
            this.G = true;
            return true;
        }
        if (X == 5) {
            b0();
            this.H = true;
            return true;
        }
        if (X == 10) {
            b0();
            this.K = true;
            return true;
        }
        if (X == 108) {
            b0();
            this.I = true;
            return true;
        }
        if (X != 109) {
            return this.n.requestFeature(X);
        }
        b0();
        this.J = true;
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setContentView(View view) {
        s();
        ViewGroup viewGroup = (ViewGroup) this.D.findViewById(android.R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.o.getWrapped().onContentChanged();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setHandleNativeActionModesEnabled(boolean z) {
        this.B = z;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setLocalNightMode(int i2) {
        if (this.V != i2) {
            this.V = i2;
            applyDayNight();
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setSupportActionBar(Toolbar toolbar) {
        if (this.l instanceof Activity) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar instanceof WindowDecorActionBar) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.r = null;
            if (supportActionBar != null) {
                supportActionBar.a();
            }
            if (toolbar != null) {
                ToolbarActionBar toolbarActionBar = new ToolbarActionBar(toolbar, A(), this.o);
                this.q = toolbarActionBar;
                this.n.setCallback(toolbarActionBar.getWrappedWindowCallback());
            } else {
                this.q = null;
                this.n.setCallback(this.o);
            }
            invalidateOptionsMenu();
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setTheme(@StyleRes int i2) {
        this.W = i2;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setTitle(CharSequence charSequence) {
        this.s = charSequence;
        DecorContentParent decorContentParent = this.t;
        if (decorContentParent != null) {
            decorContentParent.setWindowTitle(charSequence);
            return;
        }
        if (T() != null) {
            T().setWindowTitle(charSequence);
            return;
        }
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public ActionMode startSupportActionMode(@NonNull ActionMode.Callback callback) {
        AppCompatCallback appCompatCallback;
        if (callback == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        ActionMode actionMode = this.w;
        if (actionMode != null) {
            actionMode.finish();
        }
        ActionModeCallbackWrapperV9 actionModeCallbackWrapperV9 = new ActionModeCallbackWrapperV9(callback);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            ActionMode startActionMode = supportActionBar.startActionMode(actionModeCallbackWrapperV9);
            this.w = startActionMode;
            if (startActionMode != null && (appCompatCallback = this.p) != null) {
                appCompatCallback.onSupportActionModeStarted(startActionMode);
            }
        }
        if (this.w == null) {
            this.w = a0(actionModeCallbackWrapperV9);
        }
        return this.w;
    }

    PanelFeatureState u(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.O;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i2];
            if (panelFeatureState != null && panelFeatureState.f264j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    final Context v() {
        ActionBar supportActionBar = getSupportActionBar();
        Context themedContext = supportActionBar != null ? supportActionBar.getThemedContext() : null;
        return themedContext == null ? this.m : themedContext;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    final AutoNightModeManager x() {
        if (this.Z == null) {
            this.Z = new AutoTimeNightModeManager(TwilightManager.a(this.m));
        }
        return this.Z;
    }

    protected PanelFeatureState y(int i2, boolean z) {
        PanelFeatureState[] panelFeatureStateArr = this.O;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i2) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[i2 + 1];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.O = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i2];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i2);
        panelFeatureStateArr[i2] = panelFeatureState2;
        return panelFeatureState2;
    }

    ViewGroup z() {
        return this.D;
    }

    AppCompatDelegateImpl(Dialog dialog, AppCompatCallback appCompatCallback) {
        this(dialog.getContext(), dialog.getWindow(), appCompatCallback, dialog);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    AppCompatDelegateImpl(Context context, Window window, AppCompatCallback appCompatCallback) {
        this(context, window, appCompatCallback, context);
    }

    class AppCompatWindowCallback extends WindowCallbackWrapper {
        AppCompatWindowCallback(Window.Callback callback) {
            super(callback);
        }

        final android.view.ActionMode a(ActionMode.Callback callback) {
            SupportActionModeWrapper.CallbackWrapper callbackWrapper = new SupportActionModeWrapper.CallbackWrapper(AppCompatDelegateImpl.this.m, callback);
            androidx.appcompat.view.ActionMode startSupportActionMode = AppCompatDelegateImpl.this.startSupportActionMode(callbackWrapper);
            if (startSupportActionMode != null) {
                return callbackWrapper.getActionModeWrapper(startSupportActionMode);
            }
            return null;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.p(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImpl.this.M(keyEvent.getKeyCode(), keyEvent);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onContentChanged() {
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i2, Menu menu) {
            if (i2 != 0 || (menu instanceof MenuBuilder)) {
                return super.onCreatePanelMenu(i2, menu);
            }
            return false;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onMenuOpened(int i2, Menu menu) {
            super.onMenuOpened(i2, menu);
            AppCompatDelegateImpl.this.P(i2);
            return true;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onPanelClosed(int i2, Menu menu) {
            super.onPanelClosed(i2, menu);
            AppCompatDelegateImpl.this.Q(i2);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onPreparePanel(int i2, View view, Menu menu) {
            MenuBuilder menuBuilder = menu instanceof MenuBuilder ? (MenuBuilder) menu : null;
            if (i2 == 0 && menuBuilder == null) {
                return false;
            }
            if (menuBuilder != null) {
                menuBuilder.setOverrideVisibleItems(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i2, view, menu);
            if (menuBuilder != null) {
                menuBuilder.setOverrideVisibleItems(false);
            }
            return onPreparePanel;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        @RequiresApi(24)
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i2) {
            MenuBuilder menuBuilder;
            PanelFeatureState y = AppCompatDelegateImpl.this.y(0, true);
            if (y == null || (menuBuilder = y.f264j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i2);
            } else {
                super.onProvideKeyboardShortcuts(list, menuBuilder, i2);
            }
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            return AppCompatDelegateImpl.this.isHandleNativeActionModesEnabled() ? a(callback) : super.onWindowStartingActionMode(callback);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        @RequiresApi(23)
        public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i2) {
            if (AppCompatDelegateImpl.this.isHandleNativeActionModesEnabled() && i2 == 0) {
                return a(callback);
            }
            return super.onWindowStartingActionMode(callback, i2);
        }
    }

    AppCompatDelegateImpl(Context context, Activity activity, AppCompatCallback appCompatCallback) {
        this(context, null, appCompatCallback, activity);
    }

    private AppCompatDelegateImpl(Context context, Window window, AppCompatCallback appCompatCallback, Object obj) {
        Map<Class<?>, Integer> map;
        Integer num;
        AppCompatActivity c0;
        this.A = null;
        this.B = true;
        this.V = -100;
        this.d0 = new Runnable() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.2
            AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                if ((appCompatDelegateImpl.c0 & 1) != 0) {
                    appCompatDelegateImpl.q(0);
                }
                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                if ((appCompatDelegateImpl2.c0 & 4096) != 0) {
                    appCompatDelegateImpl2.q(108);
                }
                AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl3.b0 = false;
                appCompatDelegateImpl3.c0 = 0;
            }
        };
        this.m = context;
        this.p = appCompatCallback;
        this.l = obj;
        if (this.V == -100 && (obj instanceof Dialog) && (c0 = c0()) != null) {
            this.V = c0.getDelegate().getLocalNightMode();
        }
        if (this.V == -100 && (num = (map = f227e).get(obj.getClass())) != null) {
            this.V = num.intValue();
            map.remove(obj.getClass());
        }
        if (window != null) {
            g(window);
        }
        AppCompatDrawableManager.preload();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setContentView(int i2) {
        s();
        ViewGroup viewGroup = (ViewGroup) this.D.findViewById(android.R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.m).inflate(i2, viewGroup);
        this.o.getWrapped().onContentChanged();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        s();
        ViewGroup viewGroup = (ViewGroup) this.D.findViewById(android.R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.o.getWrapped().onContentChanged();
    }
}
