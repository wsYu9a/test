package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.ActionMenuItem;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import com.google.android.material.badge.BadgeDrawable;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ToolbarWidgetWrapper implements DecorToolbar {

    /* renamed from: a */
    private static final String f1004a = "ToolbarWidgetWrapper";

    /* renamed from: b */
    private static final int f1005b = 3;

    /* renamed from: c */
    private static final long f1006c = 200;

    /* renamed from: d */
    Toolbar f1007d;

    /* renamed from: e */
    private int f1008e;

    /* renamed from: f */
    private View f1009f;

    /* renamed from: g */
    private Spinner f1010g;

    /* renamed from: h */
    private View f1011h;

    /* renamed from: i */
    private Drawable f1012i;

    /* renamed from: j */
    private Drawable f1013j;
    private Drawable k;
    private boolean l;
    CharSequence m;
    private CharSequence n;
    private CharSequence o;
    Window.Callback p;
    boolean q;
    private ActionMenuPresenter r;
    private int s;
    private int t;
    private Drawable u;

    /* renamed from: androidx.appcompat.widget.ToolbarWidgetWrapper$1 */
    class AnonymousClass1 implements View.OnClickListener {

        /* renamed from: a */
        final ActionMenuItem f1014a;

        AnonymousClass1() {
            this.f1014a = new ActionMenuItem(ToolbarWidgetWrapper.this.f1007d.getContext(), 0, R.id.home, 0, 0, ToolbarWidgetWrapper.this.m);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ToolbarWidgetWrapper toolbarWidgetWrapper = ToolbarWidgetWrapper.this;
            Window.Callback callback = toolbarWidgetWrapper.p;
            if (callback == null || !toolbarWidgetWrapper.q) {
                return;
            }
            callback.onMenuItemSelected(0, this.f1014a);
        }
    }

    /* renamed from: androidx.appcompat.widget.ToolbarWidgetWrapper$2 */
    class AnonymousClass2 extends ViewPropertyAnimatorListenerAdapter {

        /* renamed from: a */
        private boolean f1016a = false;

        /* renamed from: b */
        final /* synthetic */ int f1017b;

        AnonymousClass2(int i2) {
            i2 = i2;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationCancel(View view) {
            this.f1016a = true;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            if (this.f1016a) {
                return;
            }
            ToolbarWidgetWrapper.this.f1007d.setVisibility(i2);
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View view) {
            ToolbarWidgetWrapper.this.f1007d.setVisibility(0);
        }
    }

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z) {
        this(toolbar, z, androidx.appcompat.R.string.abc_action_bar_up_description, androidx.appcompat.R.drawable.abc_ic_ab_back_material);
    }

    private int a() {
        if (this.f1007d.getNavigationIcon() == null) {
            return 11;
        }
        this.u = this.f1007d.getNavigationIcon();
        return 15;
    }

    private void b() {
        if (this.f1010g == null) {
            this.f1010g = new AppCompatSpinner(getContext(), null, androidx.appcompat.R.attr.actionDropDownStyle);
            this.f1010g.setLayoutParams(new Toolbar.LayoutParams(-2, -2, 8388627));
        }
    }

    private void c(CharSequence charSequence) {
        this.m = charSequence;
        if ((this.f1008e & 8) != 0) {
            this.f1007d.setTitle(charSequence);
        }
    }

    private void d() {
        if ((this.f1008e & 4) != 0) {
            if (TextUtils.isEmpty(this.o)) {
                this.f1007d.setNavigationContentDescription(this.t);
            } else {
                this.f1007d.setNavigationContentDescription(this.o);
            }
        }
    }

    private void e() {
        if ((this.f1008e & 4) == 0) {
            this.f1007d.setNavigationIcon((Drawable) null);
            return;
        }
        Toolbar toolbar = this.f1007d;
        Drawable drawable = this.k;
        if (drawable == null) {
            drawable = this.u;
        }
        toolbar.setNavigationIcon(drawable);
    }

    private void f() {
        Drawable drawable;
        int i2 = this.f1008e;
        if ((i2 & 2) == 0) {
            drawable = null;
        } else if ((i2 & 1) != 0) {
            drawable = this.f1013j;
            if (drawable == null) {
                drawable = this.f1012i;
            }
        } else {
            drawable = this.f1012i;
        }
        this.f1007d.setLogo(drawable);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void animateToVisibility(int i2) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = setupAnimatorToVisibility(i2, f1006c);
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.start();
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean canShowOverflowMenu() {
        return this.f1007d.canShowOverflowMenu();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void collapseActionView() {
        this.f1007d.collapseActionView();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void dismissPopupMenus() {
        this.f1007d.dismissPopupMenus();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public Context getContext() {
        return this.f1007d.getContext();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public View getCustomView() {
        return this.f1011h;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getDisplayOptions() {
        return this.f1008e;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getDropdownItemCount() {
        Spinner spinner = this.f1010g;
        if (spinner != null) {
            return spinner.getCount();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getDropdownSelectedPosition() {
        Spinner spinner = this.f1010g;
        if (spinner != null) {
            return spinner.getSelectedItemPosition();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getHeight() {
        return this.f1007d.getHeight();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public Menu getMenu() {
        return this.f1007d.getMenu();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getNavigationMode() {
        return this.s;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public CharSequence getSubtitle() {
        return this.f1007d.getSubtitle();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public CharSequence getTitle() {
        return this.f1007d.getTitle();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public ViewGroup getViewGroup() {
        return this.f1007d;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getVisibility() {
        return this.f1007d.getVisibility();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hasEmbeddedTabs() {
        return this.f1009f != null;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hasExpandedActionView() {
        return this.f1007d.hasExpandedActionView();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hasIcon() {
        return this.f1012i != null;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hasLogo() {
        return this.f1013j != null;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hideOverflowMenu() {
        return this.f1007d.hideOverflowMenu();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void initIndeterminateProgress() {
        Log.i(f1004a, "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void initProgress() {
        Log.i(f1004a, "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean isOverflowMenuShowPending() {
        return this.f1007d.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean isOverflowMenuShowing() {
        return this.f1007d.isOverflowMenuShowing();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean isTitleTruncated() {
        return this.f1007d.isTitleTruncated();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void restoreHierarchyState(SparseArray<Parcelable> sparseArray) {
        this.f1007d.restoreHierarchyState(sparseArray);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void saveHierarchyState(SparseArray<Parcelable> sparseArray) {
        this.f1007d.saveHierarchyState(sparseArray);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setBackgroundDrawable(Drawable drawable) {
        ViewCompat.setBackground(this.f1007d, drawable);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setCollapsible(boolean z) {
        this.f1007d.setCollapsible(z);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setCustomView(View view) {
        View view2 = this.f1011h;
        if (view2 != null && (this.f1008e & 16) != 0) {
            this.f1007d.removeView(view2);
        }
        this.f1011h = view;
        if (view == null || (this.f1008e & 16) == 0) {
            return;
        }
        this.f1007d.addView(view);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDefaultNavigationContentDescription(int i2) {
        if (i2 == this.t) {
            return;
        }
        this.t = i2;
        if (TextUtils.isEmpty(this.f1007d.getNavigationContentDescription())) {
            setNavigationContentDescription(this.t);
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDefaultNavigationIcon(Drawable drawable) {
        if (this.u != drawable) {
            this.u = drawable;
            e();
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDisplayOptions(int i2) {
        View view;
        int i3 = this.f1008e ^ i2;
        this.f1008e = i2;
        if (i3 != 0) {
            if ((i3 & 4) != 0) {
                if ((i2 & 4) != 0) {
                    d();
                }
                e();
            }
            if ((i3 & 3) != 0) {
                f();
            }
            if ((i3 & 8) != 0) {
                if ((i2 & 8) != 0) {
                    this.f1007d.setTitle(this.m);
                    this.f1007d.setSubtitle(this.n);
                } else {
                    this.f1007d.setTitle((CharSequence) null);
                    this.f1007d.setSubtitle((CharSequence) null);
                }
            }
            if ((i3 & 16) == 0 || (view = this.f1011h) == null) {
                return;
            }
            if ((i2 & 16) != 0) {
                this.f1007d.addView(view);
            } else {
                this.f1007d.removeView(view);
            }
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDropdownParams(SpinnerAdapter spinnerAdapter, AdapterView.OnItemSelectedListener onItemSelectedListener) {
        b();
        this.f1010g.setAdapter(spinnerAdapter);
        this.f1010g.setOnItemSelectedListener(onItemSelectedListener);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDropdownSelectedPosition(int i2) {
        Spinner spinner = this.f1010g;
        if (spinner == null) {
            throw new IllegalStateException("Can't set dropdown selected position without an adapter");
        }
        spinner.setSelection(i2);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setEmbeddedTabView(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.f1009f;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f1007d;
            if (parent == toolbar) {
                toolbar.removeView(this.f1009f);
            }
        }
        this.f1009f = scrollingTabContainerView;
        if (scrollingTabContainerView == null || this.s != 2) {
            return;
        }
        this.f1007d.addView(scrollingTabContainerView, 0);
        Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.f1009f.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -2;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = -2;
        layoutParams.gravity = BadgeDrawable.f6715d;
        scrollingTabContainerView.setAllowCollapse(true);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setHomeButtonEnabled(boolean z) {
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setIcon(int i2) {
        setIcon(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setLogo(int i2) {
        setLogo(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setMenu(Menu menu, MenuPresenter.Callback callback) {
        if (this.r == null) {
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(this.f1007d.getContext());
            this.r = actionMenuPresenter;
            actionMenuPresenter.setId(androidx.appcompat.R.id.action_menu_presenter);
        }
        this.r.setCallback(callback);
        this.f1007d.setMenu((MenuBuilder) menu, this.r);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.f1007d.setMenuCallbacks(callback, callback2);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setMenuPrepared() {
        this.q = true;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationContentDescription(CharSequence charSequence) {
        this.o = charSequence;
        d();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationIcon(Drawable drawable) {
        this.k = drawable;
        e();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationMode(int i2) {
        View view;
        int i3 = this.s;
        if (i2 != i3) {
            if (i3 == 1) {
                Spinner spinner = this.f1010g;
                if (spinner != null) {
                    ViewParent parent = spinner.getParent();
                    Toolbar toolbar = this.f1007d;
                    if (parent == toolbar) {
                        toolbar.removeView(this.f1010g);
                    }
                }
            } else if (i3 == 2 && (view = this.f1009f) != null) {
                ViewParent parent2 = view.getParent();
                Toolbar toolbar2 = this.f1007d;
                if (parent2 == toolbar2) {
                    toolbar2.removeView(this.f1009f);
                }
            }
            this.s = i2;
            if (i2 != 0) {
                if (i2 == 1) {
                    b();
                    this.f1007d.addView(this.f1010g, 0);
                    return;
                }
                if (i2 != 2) {
                    throw new IllegalArgumentException("Invalid navigation mode " + i2);
                }
                View view2 = this.f1009f;
                if (view2 != null) {
                    this.f1007d.addView(view2, 0);
                    Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.f1009f.getLayoutParams();
                    ((ViewGroup.MarginLayoutParams) layoutParams).width = -2;
                    ((ViewGroup.MarginLayoutParams) layoutParams).height = -2;
                    layoutParams.gravity = BadgeDrawable.f6715d;
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setSubtitle(CharSequence charSequence) {
        this.n = charSequence;
        if ((this.f1008e & 8) != 0) {
            this.f1007d.setSubtitle(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setTitle(CharSequence charSequence) {
        this.l = true;
        c(charSequence);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setVisibility(int i2) {
        this.f1007d.setVisibility(i2);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setWindowCallback(Window.Callback callback) {
        this.p = callback;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setWindowTitle(CharSequence charSequence) {
        if (this.l) {
            return;
        }
        c(charSequence);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(int i2, long j2) {
        return ViewCompat.animate(this.f1007d).alpha(i2 == 0 ? 1.0f : 0.0f).setDuration(j2).setListener(new ViewPropertyAnimatorListenerAdapter() { // from class: androidx.appcompat.widget.ToolbarWidgetWrapper.2

            /* renamed from: a */
            private boolean f1016a = false;

            /* renamed from: b */
            final /* synthetic */ int f1017b;

            AnonymousClass2(int i22) {
                i2 = i22;
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationCancel(View view) {
                this.f1016a = true;
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                if (this.f1016a) {
                    return;
                }
                ToolbarWidgetWrapper.this.f1007d.setVisibility(i2);
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationStart(View view) {
                ToolbarWidgetWrapper.this.f1007d.setVisibility(0);
            }
        });
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean showOverflowMenu() {
        return this.f1007d.showOverflowMenu();
    }

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z, int i2, int i3) {
        Drawable drawable;
        this.s = 0;
        this.t = 0;
        this.f1007d = toolbar;
        this.m = toolbar.getTitle();
        this.n = toolbar.getSubtitle();
        this.l = this.m != null;
        this.k = toolbar.getNavigationIcon();
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(toolbar.getContext(), null, androidx.appcompat.R.styleable.ActionBar, androidx.appcompat.R.attr.actionBarStyle, 0);
        this.u = obtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence text = obtainStyledAttributes.getText(androidx.appcompat.R.styleable.ActionBar_title);
            if (!TextUtils.isEmpty(text)) {
                setTitle(text);
            }
            CharSequence text2 = obtainStyledAttributes.getText(androidx.appcompat.R.styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(text2)) {
                setSubtitle(text2);
            }
            Drawable drawable2 = obtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.ActionBar_logo);
            if (drawable2 != null) {
                setLogo(drawable2);
            }
            Drawable drawable3 = obtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.ActionBar_icon);
            if (drawable3 != null) {
                setIcon(drawable3);
            }
            if (this.k == null && (drawable = this.u) != null) {
                setNavigationIcon(drawable);
            }
            setDisplayOptions(obtainStyledAttributes.getInt(androidx.appcompat.R.styleable.ActionBar_displayOptions, 0));
            int resourceId = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.ActionBar_customNavigationLayout, 0);
            if (resourceId != 0) {
                setCustomView(LayoutInflater.from(this.f1007d.getContext()).inflate(resourceId, (ViewGroup) this.f1007d, false));
                setDisplayOptions(this.f1008e | 16);
            }
            int layoutDimension = obtainStyledAttributes.getLayoutDimension(androidx.appcompat.R.styleable.ActionBar_height, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = this.f1007d.getLayoutParams();
                layoutParams.height = layoutDimension;
                this.f1007d.setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(androidx.appcompat.R.styleable.ActionBar_contentInsetStart, -1);
            int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(androidx.appcompat.R.styleable.ActionBar_contentInsetEnd, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                this.f1007d.setContentInsetsRelative(Math.max(dimensionPixelOffset, 0), Math.max(dimensionPixelOffset2, 0));
            }
            int resourceId2 = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.ActionBar_titleTextStyle, 0);
            if (resourceId2 != 0) {
                Toolbar toolbar2 = this.f1007d;
                toolbar2.setTitleTextAppearance(toolbar2.getContext(), resourceId2);
            }
            int resourceId3 = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.ActionBar_subtitleTextStyle, 0);
            if (resourceId3 != 0) {
                Toolbar toolbar3 = this.f1007d;
                toolbar3.setSubtitleTextAppearance(toolbar3.getContext(), resourceId3);
            }
            int resourceId4 = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.ActionBar_popupTheme, 0);
            if (resourceId4 != 0) {
                this.f1007d.setPopupTheme(resourceId4);
            }
        } else {
            this.f1008e = a();
        }
        obtainStyledAttributes.recycle();
        setDefaultNavigationContentDescription(i2);
        this.o = this.f1007d.getNavigationContentDescription();
        this.f1007d.setNavigationOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.widget.ToolbarWidgetWrapper.1

            /* renamed from: a */
            final ActionMenuItem f1014a;

            AnonymousClass1() {
                this.f1014a = new ActionMenuItem(ToolbarWidgetWrapper.this.f1007d.getContext(), 0, R.id.home, 0, 0, ToolbarWidgetWrapper.this.m);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ToolbarWidgetWrapper toolbarWidgetWrapper = ToolbarWidgetWrapper.this;
                Window.Callback callback = toolbarWidgetWrapper.p;
                if (callback == null || !toolbarWidgetWrapper.q) {
                    return;
                }
                callback.onMenuItemSelected(0, this.f1014a);
            }
        });
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setIcon(Drawable drawable) {
        this.f1012i = drawable;
        f();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setLogo(Drawable drawable) {
        this.f1013j = drawable;
        f();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationContentDescription(int i2) {
        setNavigationContentDescription(i2 == 0 ? null : getContext().getString(i2));
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationIcon(int i2) {
        setNavigationIcon(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
    }
}
