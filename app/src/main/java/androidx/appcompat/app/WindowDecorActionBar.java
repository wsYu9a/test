package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.SpinnerAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class WindowDecorActionBar extends ActionBar implements ActionBarOverlayLayout.ActionBarVisibilityCallback {

    /* renamed from: a */
    private static final String f328a = "WindowDecorActionBar";

    /* renamed from: b */
    private static final Interpolator f329b = new AccelerateInterpolator();

    /* renamed from: c */
    private static final Interpolator f330c = new DecelerateInterpolator();

    /* renamed from: d */
    private static final int f331d = -1;

    /* renamed from: e */
    private static final long f332e = 100;

    /* renamed from: f */
    private static final long f333f = 200;

    /* renamed from: g */
    static final /* synthetic */ boolean f334g = false;
    private boolean A;
    boolean D;
    boolean E;
    private boolean F;
    ViewPropertyAnimatorCompatSet H;
    private boolean I;
    boolean J;

    /* renamed from: h */
    Context f335h;

    /* renamed from: i */
    private Context f336i;

    /* renamed from: j */
    private Activity f337j;
    private Dialog k;
    ActionBarOverlayLayout l;
    ActionBarContainer m;
    DecorToolbar n;
    ActionBarContextView o;
    View p;
    ScrollingTabContainerView q;
    private TabImpl s;
    private boolean u;
    ActionModeImpl v;
    ActionMode w;
    ActionMode.Callback x;
    private boolean y;
    private ArrayList<TabImpl> r = new ArrayList<>();
    private int t = -1;
    private ArrayList<ActionBar.OnMenuVisibilityListener> z = new ArrayList<>();
    private int B = 0;
    boolean C = true;
    private boolean G = true;
    final ViewPropertyAnimatorListener K = new ViewPropertyAnimatorListenerAdapter() { // from class: androidx.appcompat.app.WindowDecorActionBar.1
        AnonymousClass1() {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            View view2;
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            if (windowDecorActionBar.C && (view2 = windowDecorActionBar.p) != null) {
                view2.setTranslationY(0.0f);
                WindowDecorActionBar.this.m.setTranslationY(0.0f);
            }
            WindowDecorActionBar.this.m.setVisibility(8);
            WindowDecorActionBar.this.m.setTransitioning(false);
            WindowDecorActionBar windowDecorActionBar2 = WindowDecorActionBar.this;
            windowDecorActionBar2.H = null;
            windowDecorActionBar2.d();
            ActionBarOverlayLayout actionBarOverlayLayout = WindowDecorActionBar.this.l;
            if (actionBarOverlayLayout != null) {
                ViewCompat.requestApplyInsets(actionBarOverlayLayout);
            }
        }
    };
    final ViewPropertyAnimatorListener L = new ViewPropertyAnimatorListenerAdapter() { // from class: androidx.appcompat.app.WindowDecorActionBar.2
        AnonymousClass2() {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            windowDecorActionBar.H = null;
            windowDecorActionBar.m.requestLayout();
        }
    };
    final ViewPropertyAnimatorUpdateListener M = new ViewPropertyAnimatorUpdateListener() { // from class: androidx.appcompat.app.WindowDecorActionBar.3
        AnonymousClass3() {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorUpdateListener
        public void onAnimationUpdate(View view) {
            ((View) WindowDecorActionBar.this.m.getParent()).invalidate();
        }
    };

    /* renamed from: androidx.appcompat.app.WindowDecorActionBar$1 */
    class AnonymousClass1 extends ViewPropertyAnimatorListenerAdapter {
        AnonymousClass1() {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            View view2;
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            if (windowDecorActionBar.C && (view2 = windowDecorActionBar.p) != null) {
                view2.setTranslationY(0.0f);
                WindowDecorActionBar.this.m.setTranslationY(0.0f);
            }
            WindowDecorActionBar.this.m.setVisibility(8);
            WindowDecorActionBar.this.m.setTransitioning(false);
            WindowDecorActionBar windowDecorActionBar2 = WindowDecorActionBar.this;
            windowDecorActionBar2.H = null;
            windowDecorActionBar2.d();
            ActionBarOverlayLayout actionBarOverlayLayout = WindowDecorActionBar.this.l;
            if (actionBarOverlayLayout != null) {
                ViewCompat.requestApplyInsets(actionBarOverlayLayout);
            }
        }
    }

    /* renamed from: androidx.appcompat.app.WindowDecorActionBar$2 */
    class AnonymousClass2 extends ViewPropertyAnimatorListenerAdapter {
        AnonymousClass2() {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            windowDecorActionBar.H = null;
            windowDecorActionBar.m.requestLayout();
        }
    }

    /* renamed from: androidx.appcompat.app.WindowDecorActionBar$3 */
    class AnonymousClass3 implements ViewPropertyAnimatorUpdateListener {
        AnonymousClass3() {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorUpdateListener
        public void onAnimationUpdate(View view) {
            ((View) WindowDecorActionBar.this.m.getParent()).invalidate();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {

        /* renamed from: c */
        private final Context f341c;

        /* renamed from: d */
        private final MenuBuilder f342d;

        /* renamed from: e */
        private ActionMode.Callback f343e;

        /* renamed from: f */
        private WeakReference<View> f344f;

        public ActionModeImpl(Context context, ActionMode.Callback callback) {
            this.f341c = context;
            this.f343e = callback;
            MenuBuilder defaultShowAsAction = new MenuBuilder(context).setDefaultShowAsAction(1);
            this.f342d = defaultShowAsAction;
            defaultShowAsAction.setCallback(this);
        }

        public boolean dispatchOnCreate() {
            this.f342d.stopDispatchingItemsChanged();
            try {
                return this.f343e.onCreateActionMode(this, this.f342d);
            } finally {
                this.f342d.startDispatchingItemsChanged();
            }
        }

        @Override // androidx.appcompat.view.ActionMode
        public void finish() {
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            if (windowDecorActionBar.v != this) {
                return;
            }
            if (WindowDecorActionBar.b(windowDecorActionBar.D, windowDecorActionBar.E, false)) {
                this.f343e.onDestroyActionMode(this);
            } else {
                WindowDecorActionBar windowDecorActionBar2 = WindowDecorActionBar.this;
                windowDecorActionBar2.w = this;
                windowDecorActionBar2.x = this.f343e;
            }
            this.f343e = null;
            WindowDecorActionBar.this.animateToMode(false);
            WindowDecorActionBar.this.o.closeMode();
            WindowDecorActionBar.this.n.getViewGroup().sendAccessibilityEvent(32);
            WindowDecorActionBar windowDecorActionBar3 = WindowDecorActionBar.this;
            windowDecorActionBar3.l.setHideOnContentScrollEnabled(windowDecorActionBar3.J);
            WindowDecorActionBar.this.v = null;
        }

        @Override // androidx.appcompat.view.ActionMode
        public View getCustomView() {
            WeakReference<View> weakReference = this.f344f;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // androidx.appcompat.view.ActionMode
        public Menu getMenu() {
            return this.f342d;
        }

        @Override // androidx.appcompat.view.ActionMode
        public MenuInflater getMenuInflater() {
            return new SupportMenuInflater(this.f341c);
        }

        @Override // androidx.appcompat.view.ActionMode
        public CharSequence getSubtitle() {
            return WindowDecorActionBar.this.o.getSubtitle();
        }

        @Override // androidx.appcompat.view.ActionMode
        public CharSequence getTitle() {
            return WindowDecorActionBar.this.o.getTitle();
        }

        @Override // androidx.appcompat.view.ActionMode
        public void invalidate() {
            if (WindowDecorActionBar.this.v != this) {
                return;
            }
            this.f342d.stopDispatchingItemsChanged();
            try {
                this.f343e.onPrepareActionMode(this, this.f342d);
            } finally {
                this.f342d.startDispatchingItemsChanged();
            }
        }

        @Override // androidx.appcompat.view.ActionMode
        public boolean isTitleOptional() {
            return WindowDecorActionBar.this.o.isTitleOptional();
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        }

        public void onCloseSubMenu(SubMenuBuilder subMenuBuilder) {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            ActionMode.Callback callback = this.f343e;
            if (callback != null) {
                return callback.onActionItemClicked(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder menuBuilder) {
            if (this.f343e == null) {
                return;
            }
            invalidate();
            WindowDecorActionBar.this.o.showOverflowMenu();
        }

        public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
            if (this.f343e == null) {
                return false;
            }
            if (!subMenuBuilder.hasVisibleItems()) {
                return true;
            }
            new MenuPopupHelper(WindowDecorActionBar.this.getThemedContext(), subMenuBuilder).show();
            return true;
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setCustomView(View view) {
            WindowDecorActionBar.this.o.setCustomView(view);
            this.f344f = new WeakReference<>(view);
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setSubtitle(CharSequence charSequence) {
            WindowDecorActionBar.this.o.setSubtitle(charSequence);
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setTitle(CharSequence charSequence) {
            WindowDecorActionBar.this.o.setTitle(charSequence);
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setTitleOptionalHint(boolean z) {
            super.setTitleOptionalHint(z);
            WindowDecorActionBar.this.o.setTitleOptional(z);
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setSubtitle(int i2) {
            setSubtitle(WindowDecorActionBar.this.f335h.getResources().getString(i2));
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setTitle(int i2) {
            setTitle(WindowDecorActionBar.this.f335h.getResources().getString(i2));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public class TabImpl extends ActionBar.Tab {

        /* renamed from: a */
        private ActionBar.TabListener f346a;

        /* renamed from: b */
        private Object f347b;

        /* renamed from: c */
        private Drawable f348c;

        /* renamed from: d */
        private CharSequence f349d;

        /* renamed from: e */
        private CharSequence f350e;

        /* renamed from: f */
        private int f351f = -1;

        /* renamed from: g */
        private View f352g;

        public TabImpl() {
        }

        public ActionBar.TabListener getCallback() {
            return this.f346a;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public CharSequence getContentDescription() {
            return this.f350e;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public View getCustomView() {
            return this.f352g;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public Drawable getIcon() {
            return this.f348c;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public int getPosition() {
            return this.f351f;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public Object getTag() {
            return this.f347b;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public CharSequence getText() {
            return this.f349d;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public void select() {
            WindowDecorActionBar.this.selectTab(this);
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setContentDescription(int i2) {
            return setContentDescription(WindowDecorActionBar.this.f335h.getResources().getText(i2));
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setCustomView(View view) {
            this.f352g = view;
            int i2 = this.f351f;
            if (i2 >= 0) {
                WindowDecorActionBar.this.q.updateTab(i2);
            }
            return this;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setIcon(Drawable drawable) {
            this.f348c = drawable;
            int i2 = this.f351f;
            if (i2 >= 0) {
                WindowDecorActionBar.this.q.updateTab(i2);
            }
            return this;
        }

        public void setPosition(int i2) {
            this.f351f = i2;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setTabListener(ActionBar.TabListener tabListener) {
            this.f346a = tabListener;
            return this;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setTag(Object obj) {
            this.f347b = obj;
            return this;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setText(CharSequence charSequence) {
            this.f349d = charSequence;
            int i2 = this.f351f;
            if (i2 >= 0) {
                WindowDecorActionBar.this.q.updateTab(i2);
            }
            return this;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setContentDescription(CharSequence charSequence) {
            this.f350e = charSequence;
            int i2 = this.f351f;
            if (i2 >= 0) {
                WindowDecorActionBar.this.q.updateTab(i2);
            }
            return this;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setCustomView(int i2) {
            return setCustomView(LayoutInflater.from(WindowDecorActionBar.this.getThemedContext()).inflate(i2, (ViewGroup) null));
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setIcon(int i2) {
            return setIcon(AppCompatResources.getDrawable(WindowDecorActionBar.this.f335h, i2));
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setText(int i2) {
            return setText(WindowDecorActionBar.this.f335h.getResources().getText(i2));
        }
    }

    public WindowDecorActionBar(Activity activity, boolean z) {
        this.f337j = activity;
        View decorView = activity.getWindow().getDecorView();
        i(decorView);
        if (z) {
            return;
        }
        this.p = decorView.findViewById(R.id.content);
    }

    static boolean b(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return (z || z2) ? false : true;
    }

    private void c() {
        if (this.s != null) {
            selectTab(null);
        }
        this.r.clear();
        ScrollingTabContainerView scrollingTabContainerView = this.q;
        if (scrollingTabContainerView != null) {
            scrollingTabContainerView.removeAllTabs();
        }
        this.t = -1;
    }

    private void e(ActionBar.Tab tab, int i2) {
        TabImpl tabImpl = (TabImpl) tab;
        if (tabImpl.getCallback() == null) {
            throw new IllegalStateException("Action Bar Tab must have a Callback");
        }
        tabImpl.setPosition(i2);
        this.r.add(i2, tabImpl);
        int size = this.r.size();
        while (true) {
            i2++;
            if (i2 >= size) {
                return;
            } else {
                this.r.get(i2).setPosition(i2);
            }
        }
    }

    private void f() {
        if (this.q != null) {
            return;
        }
        ScrollingTabContainerView scrollingTabContainerView = new ScrollingTabContainerView(this.f335h);
        if (this.A) {
            scrollingTabContainerView.setVisibility(0);
            this.n.setEmbeddedTabView(scrollingTabContainerView);
        } else {
            if (getNavigationMode() == 2) {
                scrollingTabContainerView.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.l;
                if (actionBarOverlayLayout != null) {
                    ViewCompat.requestApplyInsets(actionBarOverlayLayout);
                }
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
            this.m.setTabContainer(scrollingTabContainerView);
        }
        this.q = scrollingTabContainerView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private DecorToolbar g(View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != 0 ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    private void h() {
        if (this.F) {
            this.F = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.l;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            m(false);
        }
    }

    private void i(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(androidx.appcompat.R.id.decor_content_parent);
        this.l = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.n = g(view.findViewById(androidx.appcompat.R.id.action_bar));
        this.o = (ActionBarContextView) view.findViewById(androidx.appcompat.R.id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(androidx.appcompat.R.id.action_bar_container);
        this.m = actionBarContainer;
        DecorToolbar decorToolbar = this.n;
        if (decorToolbar == null || this.o == null || actionBarContainer == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f335h = decorToolbar.getContext();
        boolean z = (this.n.getDisplayOptions() & 4) != 0;
        if (z) {
            this.u = true;
        }
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(this.f335h);
        setHomeButtonEnabled(actionBarPolicy.enableHomeButtonByDefault() || z);
        j(actionBarPolicy.hasEmbeddedTabs());
        TypedArray obtainStyledAttributes = this.f335h.obtainStyledAttributes(null, androidx.appcompat.R.styleable.ActionBar, androidx.appcompat.R.attr.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.ActionBar_hideOnContentScroll, false)) {
            setHideOnContentScrollEnabled(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            setElevation(dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private void j(boolean z) {
        this.A = z;
        if (z) {
            this.m.setTabContainer(null);
            this.n.setEmbeddedTabView(this.q);
        } else {
            this.n.setEmbeddedTabView(null);
            this.m.setTabContainer(this.q);
        }
        boolean z2 = getNavigationMode() == 2;
        ScrollingTabContainerView scrollingTabContainerView = this.q;
        if (scrollingTabContainerView != null) {
            if (z2) {
                scrollingTabContainerView.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.l;
                if (actionBarOverlayLayout != null) {
                    ViewCompat.requestApplyInsets(actionBarOverlayLayout);
                }
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
        }
        this.n.setCollapsible(!this.A && z2);
        this.l.setHasNonEmbeddedTabs(!this.A && z2);
    }

    private boolean k() {
        return ViewCompat.isLaidOut(this.m);
    }

    private void l() {
        if (this.F) {
            return;
        }
        this.F = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.l;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        m(false);
    }

    private void m(boolean z) {
        if (b(this.D, this.E, this.F)) {
            if (this.G) {
                return;
            }
            this.G = true;
            doShow(z);
            return;
        }
        if (this.G) {
            this.G = false;
            doHide(z);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.z.add(onMenuVisibilityListener);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab tab) {
        addTab(tab, this.r.isEmpty());
    }

    public void animateToMode(boolean z) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2;
        if (z) {
            l();
        } else {
            h();
        }
        if (!k()) {
            if (z) {
                this.n.setVisibility(4);
                this.o.setVisibility(0);
                return;
            } else {
                this.n.setVisibility(0);
                this.o.setVisibility(8);
                return;
            }
        }
        if (z) {
            viewPropertyAnimatorCompat2 = this.n.setupAnimatorToVisibility(4, f332e);
            viewPropertyAnimatorCompat = this.o.setupAnimatorToVisibility(0, f333f);
        } else {
            viewPropertyAnimatorCompat = this.n.setupAnimatorToVisibility(0, f333f);
            viewPropertyAnimatorCompat2 = this.o.setupAnimatorToVisibility(8, f332e);
        }
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
        viewPropertyAnimatorCompatSet.playSequentially(viewPropertyAnimatorCompat2, viewPropertyAnimatorCompat);
        viewPropertyAnimatorCompatSet.start();
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean collapseActionView() {
        DecorToolbar decorToolbar = this.n;
        if (decorToolbar == null || !decorToolbar.hasExpandedActionView()) {
            return false;
        }
        this.n.collapseActionView();
        return true;
    }

    void d() {
        ActionMode.Callback callback = this.x;
        if (callback != null) {
            callback.onDestroyActionMode(this.w);
            this.w = null;
            this.x = null;
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void dispatchMenuVisibilityChanged(boolean z) {
        if (z == this.y) {
            return;
        }
        this.y = z;
        int size = this.z.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.z.get(i2).onMenuVisibilityChanged(z);
        }
    }

    public void doHide(boolean z) {
        View view;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.H;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.cancel();
        }
        if (this.B != 0 || (!this.I && !z)) {
            this.K.onAnimationEnd(null);
            return;
        }
        this.m.setAlpha(1.0f);
        this.m.setTransitioning(true);
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
        float f2 = -this.m.getHeight();
        if (z) {
            this.m.getLocationInWindow(new int[]{0, 0});
            f2 -= r5[1];
        }
        ViewPropertyAnimatorCompat translationY = ViewCompat.animate(this.m).translationY(f2);
        translationY.setUpdateListener(this.M);
        viewPropertyAnimatorCompatSet2.play(translationY);
        if (this.C && (view = this.p) != null) {
            viewPropertyAnimatorCompatSet2.play(ViewCompat.animate(view).translationY(f2));
        }
        viewPropertyAnimatorCompatSet2.setInterpolator(f329b);
        viewPropertyAnimatorCompatSet2.setDuration(250L);
        viewPropertyAnimatorCompatSet2.setListener(this.K);
        this.H = viewPropertyAnimatorCompatSet2;
        viewPropertyAnimatorCompatSet2.start();
    }

    public void doShow(boolean z) {
        View view;
        View view2;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.H;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.cancel();
        }
        this.m.setVisibility(0);
        if (this.B == 0 && (this.I || z)) {
            this.m.setTranslationY(0.0f);
            float f2 = -this.m.getHeight();
            if (z) {
                this.m.getLocationInWindow(new int[]{0, 0});
                f2 -= r5[1];
            }
            this.m.setTranslationY(f2);
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
            ViewPropertyAnimatorCompat translationY = ViewCompat.animate(this.m).translationY(0.0f);
            translationY.setUpdateListener(this.M);
            viewPropertyAnimatorCompatSet2.play(translationY);
            if (this.C && (view2 = this.p) != null) {
                view2.setTranslationY(f2);
                viewPropertyAnimatorCompatSet2.play(ViewCompat.animate(this.p).translationY(0.0f));
            }
            viewPropertyAnimatorCompatSet2.setInterpolator(f330c);
            viewPropertyAnimatorCompatSet2.setDuration(250L);
            viewPropertyAnimatorCompatSet2.setListener(this.L);
            this.H = viewPropertyAnimatorCompatSet2;
            viewPropertyAnimatorCompatSet2.start();
        } else {
            this.m.setAlpha(1.0f);
            this.m.setTranslationY(0.0f);
            if (this.C && (view = this.p) != null) {
                view.setTranslationY(0.0f);
            }
            this.L.onAnimationEnd(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.l;
        if (actionBarOverlayLayout != null) {
            ViewCompat.requestApplyInsets(actionBarOverlayLayout);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void enableContentAnimations(boolean z) {
        this.C = z;
    }

    @Override // androidx.appcompat.app.ActionBar
    public View getCustomView() {
        return this.n.getCustomView();
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getDisplayOptions() {
        return this.n.getDisplayOptions();
    }

    @Override // androidx.appcompat.app.ActionBar
    public float getElevation() {
        return ViewCompat.getElevation(this.m);
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getHeight() {
        return this.m.getHeight();
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getHideOffset() {
        return this.l.getActionBarHideOffset();
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getNavigationItemCount() {
        int navigationMode = this.n.getNavigationMode();
        if (navigationMode == 1) {
            return this.n.getDropdownItemCount();
        }
        if (navigationMode != 2) {
            return 0;
        }
        return this.r.size();
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getNavigationMode() {
        return this.n.getNavigationMode();
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getSelectedNavigationIndex() {
        TabImpl tabImpl;
        int navigationMode = this.n.getNavigationMode();
        if (navigationMode == 1) {
            return this.n.getDropdownSelectedPosition();
        }
        if (navigationMode == 2 && (tabImpl = this.s) != null) {
            return tabImpl.getPosition();
        }
        return -1;
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionBar.Tab getSelectedTab() {
        return this.s;
    }

    @Override // androidx.appcompat.app.ActionBar
    public CharSequence getSubtitle() {
        return this.n.getSubtitle();
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionBar.Tab getTabAt(int i2) {
        return this.r.get(i2);
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getTabCount() {
        return this.r.size();
    }

    @Override // androidx.appcompat.app.ActionBar
    public Context getThemedContext() {
        if (this.f336i == null) {
            TypedValue typedValue = new TypedValue();
            this.f335h.getTheme().resolveAttribute(androidx.appcompat.R.attr.actionBarWidgetTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                this.f336i = new ContextThemeWrapper(this.f335h, i2);
            } else {
                this.f336i = this.f335h;
            }
        }
        return this.f336i;
    }

    @Override // androidx.appcompat.app.ActionBar
    public CharSequence getTitle() {
        return this.n.getTitle();
    }

    public boolean hasIcon() {
        return this.n.hasIcon();
    }

    public boolean hasLogo() {
        return this.n.hasLogo();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void hide() {
        if (this.D) {
            return;
        }
        this.D = true;
        m(false);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void hideForSystem() {
        if (this.E) {
            return;
        }
        this.E = true;
        m(true);
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean isHideOnContentScrollEnabled() {
        return this.l.isHideOnContentScrollEnabled();
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean isShowing() {
        int height = getHeight();
        return this.G && (height == 0 || getHideOffset() < height);
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean isTitleTruncated() {
        DecorToolbar decorToolbar = this.n;
        return decorToolbar != null && decorToolbar.isTitleTruncated();
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionBar.Tab newTab() {
        return new TabImpl();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void onConfigurationChanged(Configuration configuration) {
        j(ActionBarPolicy.get(this.f335h).hasEmbeddedTabs());
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onContentScrollStarted() {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.H;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.cancel();
            this.H = null;
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onContentScrollStopped() {
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean onKeyShortcut(int i2, KeyEvent keyEvent) {
        Menu menu;
        ActionModeImpl actionModeImpl = this.v;
        if (actionModeImpl == null || (menu = actionModeImpl.getMenu()) == null) {
            return false;
        }
        menu.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menu.performShortcut(i2, keyEvent, 0);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onWindowVisibilityChanged(int i2) {
        this.B = i2;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeAllTabs() {
        c();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.z.remove(onMenuVisibilityListener);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeTab(ActionBar.Tab tab) {
        removeTabAt(tab.getPosition());
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeTabAt(int i2) {
        if (this.q == null) {
            return;
        }
        TabImpl tabImpl = this.s;
        int position = tabImpl != null ? tabImpl.getPosition() : this.t;
        this.q.removeTabAt(i2);
        TabImpl remove = this.r.remove(i2);
        if (remove != null) {
            remove.setPosition(-1);
        }
        int size = this.r.size();
        for (int i3 = i2; i3 < size; i3++) {
            this.r.get(i3).setPosition(i3);
        }
        if (position == i2) {
            selectTab(this.r.isEmpty() ? null : this.r.get(Math.max(0, i2 - 1)));
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean requestFocus() {
        ViewGroup viewGroup = this.n.getViewGroup();
        if (viewGroup == null || viewGroup.hasFocus()) {
            return false;
        }
        viewGroup.requestFocus();
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void selectTab(ActionBar.Tab tab) {
        if (getNavigationMode() != 2) {
            this.t = tab != null ? tab.getPosition() : -1;
            return;
        }
        FragmentTransaction disallowAddToBackStack = (!(this.f337j instanceof FragmentActivity) || this.n.getViewGroup().isInEditMode()) ? null : ((FragmentActivity) this.f337j).getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
        TabImpl tabImpl = this.s;
        if (tabImpl != tab) {
            this.q.setTabSelected(tab != null ? tab.getPosition() : -1);
            TabImpl tabImpl2 = this.s;
            if (tabImpl2 != null) {
                tabImpl2.getCallback().onTabUnselected(this.s, disallowAddToBackStack);
            }
            TabImpl tabImpl3 = (TabImpl) tab;
            this.s = tabImpl3;
            if (tabImpl3 != null) {
                tabImpl3.getCallback().onTabSelected(this.s, disallowAddToBackStack);
            }
        } else if (tabImpl != null) {
            tabImpl.getCallback().onTabReselected(this.s, disallowAddToBackStack);
            this.q.animateToTab(tab.getPosition());
        }
        if (disallowAddToBackStack == null || disallowAddToBackStack.isEmpty()) {
            return;
        }
        disallowAddToBackStack.commit();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setBackgroundDrawable(Drawable drawable) {
        this.m.setPrimaryBackground(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setCustomView(int i2) {
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(i2, this.n.getViewGroup(), false));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDefaultDisplayHomeAsUpEnabled(boolean z) {
        if (this.u) {
            return;
        }
        setDisplayHomeAsUpEnabled(z);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayHomeAsUpEnabled(boolean z) {
        setDisplayOptions(z ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayOptions(int i2) {
        if ((i2 & 4) != 0) {
            this.u = true;
        }
        this.n.setDisplayOptions(i2);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayShowCustomEnabled(boolean z) {
        setDisplayOptions(z ? 16 : 0, 16);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayShowHomeEnabled(boolean z) {
        setDisplayOptions(z ? 2 : 0, 2);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayShowTitleEnabled(boolean z) {
        setDisplayOptions(z ? 8 : 0, 8);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayUseLogoEnabled(boolean z) {
        setDisplayOptions(z ? 1 : 0, 1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setElevation(float f2) {
        ViewCompat.setElevation(this.m, f2);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHideOffset(int i2) {
        if (i2 != 0 && !this.l.isInOverlayMode()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to set a non-zero hide offset");
        }
        this.l.setActionBarHideOffset(i2);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHideOnContentScrollEnabled(boolean z) {
        if (z && !this.l.isInOverlayMode()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.J = z;
        this.l.setHideOnContentScrollEnabled(z);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeActionContentDescription(CharSequence charSequence) {
        this.n.setNavigationContentDescription(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeAsUpIndicator(Drawable drawable) {
        this.n.setNavigationIcon(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeButtonEnabled(boolean z) {
        this.n.setHomeButtonEnabled(z);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setIcon(int i2) {
        this.n.setIcon(i2);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setListNavigationCallbacks(SpinnerAdapter spinnerAdapter, ActionBar.OnNavigationListener onNavigationListener) {
        this.n.setDropdownParams(spinnerAdapter, new NavItemSelectedListener(onNavigationListener));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setLogo(int i2) {
        this.n.setLogo(i2);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setNavigationMode(int i2) {
        ActionBarOverlayLayout actionBarOverlayLayout;
        int navigationMode = this.n.getNavigationMode();
        if (navigationMode == 2) {
            this.t = getSelectedNavigationIndex();
            selectTab(null);
            this.q.setVisibility(8);
        }
        if (navigationMode != i2 && !this.A && (actionBarOverlayLayout = this.l) != null) {
            ViewCompat.requestApplyInsets(actionBarOverlayLayout);
        }
        this.n.setNavigationMode(i2);
        boolean z = false;
        if (i2 == 2) {
            f();
            this.q.setVisibility(0);
            int i3 = this.t;
            if (i3 != -1) {
                setSelectedNavigationItem(i3);
                this.t = -1;
            }
        }
        this.n.setCollapsible(i2 == 2 && !this.A);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.l;
        if (i2 == 2 && !this.A) {
            z = true;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSelectedNavigationItem(int i2) {
        int navigationMode = this.n.getNavigationMode();
        if (navigationMode == 1) {
            this.n.setDropdownSelectedPosition(i2);
        } else {
            if (navigationMode != 2) {
                throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
            }
            selectTab(this.r.get(i2));
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setShowHideAnimationEnabled(boolean z) {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet;
        this.I = z;
        if (z || (viewPropertyAnimatorCompatSet = this.H) == null) {
            return;
        }
        viewPropertyAnimatorCompatSet.cancel();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSplitBackgroundDrawable(Drawable drawable) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setStackedBackgroundDrawable(Drawable drawable) {
        this.m.setStackedBackground(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSubtitle(int i2) {
        setSubtitle(this.f335h.getString(i2));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setTitle(int i2) {
        setTitle(this.f335h.getString(i2));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setWindowTitle(CharSequence charSequence) {
        this.n.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void show() {
        if (this.D) {
            this.D = false;
            m(false);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void showForSystem() {
        if (this.E) {
            this.E = false;
            m(true);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionMode startActionMode(ActionMode.Callback callback) {
        ActionModeImpl actionModeImpl = this.v;
        if (actionModeImpl != null) {
            actionModeImpl.finish();
        }
        this.l.setHideOnContentScrollEnabled(false);
        this.o.killMode();
        ActionModeImpl actionModeImpl2 = new ActionModeImpl(this.o.getContext(), callback);
        if (!actionModeImpl2.dispatchOnCreate()) {
            return null;
        }
        this.v = actionModeImpl2;
        actionModeImpl2.invalidate();
        this.o.initForMode(actionModeImpl2);
        animateToMode(true);
        this.o.sendAccessibilityEvent(32);
        return actionModeImpl2;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab tab, int i2) {
        addTab(tab, i2, this.r.isEmpty());
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeActionContentDescription(int i2) {
        this.n.setNavigationContentDescription(i2);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeAsUpIndicator(int i2) {
        this.n.setNavigationIcon(i2);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setIcon(Drawable drawable) {
        this.n.setIcon(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setLogo(Drawable drawable) {
        this.n.setLogo(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSubtitle(CharSequence charSequence) {
        this.n.setSubtitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setTitle(CharSequence charSequence) {
        this.n.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab tab, boolean z) {
        f();
        this.q.addTab(tab, z);
        e(tab, this.r.size());
        if (z) {
            selectTab(tab);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayOptions(int i2, int i3) {
        int displayOptions = this.n.getDisplayOptions();
        if ((i3 & 4) != 0) {
            this.u = true;
        }
        this.n.setDisplayOptions((i2 & i3) | ((i3 ^ (-1)) & displayOptions));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setCustomView(View view) {
        this.n.setCustomView(view);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setCustomView(View view, ActionBar.LayoutParams layoutParams) {
        view.setLayoutParams(layoutParams);
        this.n.setCustomView(view);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab tab, int i2, boolean z) {
        f();
        this.q.addTab(tab, i2, z);
        e(tab, i2);
        if (z) {
            selectTab(tab);
        }
    }

    public WindowDecorActionBar(Dialog dialog) {
        this.k = dialog;
        i(dialog.getWindow().getDecorView());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public WindowDecorActionBar(View view) {
        i(view);
    }
}
