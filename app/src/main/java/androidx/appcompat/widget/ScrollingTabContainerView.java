package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.widget.LinearLayoutCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    private static final String f894a = "ScrollingTabContainerView";

    /* renamed from: b */
    private static final Interpolator f895b = new DecelerateInterpolator();

    /* renamed from: c */
    private static final int f896c = 200;

    /* renamed from: d */
    Runnable f897d;

    /* renamed from: e */
    private TabClickListener f898e;

    /* renamed from: f */
    LinearLayoutCompat f899f;

    /* renamed from: g */
    private Spinner f900g;

    /* renamed from: h */
    private boolean f901h;

    /* renamed from: i */
    int f902i;

    /* renamed from: j */
    int f903j;
    private int k;
    private int l;
    protected ViewPropertyAnimator m;
    protected final VisibilityAnimListener n;

    /* renamed from: androidx.appcompat.widget.ScrollingTabContainerView$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ View f904a;

        AnonymousClass1(View view) {
            childAt = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ScrollingTabContainerView.this.smoothScrollTo(childAt.getLeft() - ((ScrollingTabContainerView.this.getWidth() - childAt.getWidth()) / 2), 0);
            ScrollingTabContainerView.this.f897d = null;
        }
    }

    private class TabAdapter extends BaseAdapter {
        TabAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ScrollingTabContainerView.this.f899f.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            return ((TabView) ScrollingTabContainerView.this.f899f.getChildAt(i2)).getTab();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                return ScrollingTabContainerView.this.c((ActionBar.Tab) getItem(i2), true);
            }
            ((TabView) view).bindTab((ActionBar.Tab) getItem(i2));
            return view;
        }
    }

    private class TabClickListener implements View.OnClickListener {
        TabClickListener() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((TabView) view).getTab().select();
            int childCount = ScrollingTabContainerView.this.f899f.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = ScrollingTabContainerView.this.f899f.getChildAt(i2);
                childAt.setSelected(childAt == view);
            }
        }
    }

    private class TabView extends LinearLayout {

        /* renamed from: a */
        private static final String f908a = "androidx.appcompat.app.ActionBar$Tab";

        /* renamed from: b */
        private final int[] f909b;

        /* renamed from: c */
        private ActionBar.Tab f910c;

        /* renamed from: d */
        private TextView f911d;

        /* renamed from: e */
        private ImageView f912e;

        /* renamed from: f */
        private View f913f;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public TabView(android.content.Context r6, androidx.appcompat.app.ActionBar.Tab r7, boolean r8) {
            /*
                r4 = this;
                androidx.appcompat.widget.ScrollingTabContainerView.this = r5
                int r5 = androidx.appcompat.R.attr.actionBarTabStyle
                r0 = 0
                r4.<init>(r6, r0, r5)
                r1 = 1
                int[] r1 = new int[r1]
                r2 = 16842964(0x10100d4, float:2.3694152E-38)
                r3 = 0
                r1[r3] = r2
                r4.f909b = r1
                r4.f910c = r7
                androidx.appcompat.widget.TintTypedArray r5 = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(r6, r0, r1, r5, r3)
                boolean r6 = r5.hasValue(r3)
                if (r6 == 0) goto L26
                android.graphics.drawable.Drawable r6 = r5.getDrawable(r3)
                r4.setBackgroundDrawable(r6)
            L26:
                r5.recycle()
                if (r8 == 0) goto L31
                r5 = 8388627(0x800013, float:1.175497E-38)
                r4.setGravity(r5)
            L31:
                r4.update()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ScrollingTabContainerView.TabView.<init>(androidx.appcompat.widget.ScrollingTabContainerView, android.content.Context, androidx.appcompat.app.ActionBar$Tab, boolean):void");
        }

        public void bindTab(ActionBar.Tab tab) {
            this.f910c = tab;
            update();
        }

        public ActionBar.Tab getTab() {
            return this.f910c;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(f908a);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(f908a);
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            if (ScrollingTabContainerView.this.f902i > 0) {
                int measuredWidth = getMeasuredWidth();
                int i4 = ScrollingTabContainerView.this.f902i;
                if (measuredWidth > i4) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), i3);
                }
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }

        public void update() {
            ActionBar.Tab tab = this.f910c;
            View customView = tab.getCustomView();
            if (customView != null) {
                ViewParent parent = customView.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(customView);
                    }
                    addView(customView);
                }
                this.f913f = customView;
                TextView textView = this.f911d;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f912e;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f912e.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.f913f;
            if (view != null) {
                removeView(view);
                this.f913f = null;
            }
            Drawable icon = tab.getIcon();
            CharSequence text = tab.getText();
            if (icon != null) {
                if (this.f912e == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.f912e = appCompatImageView;
                }
                this.f912e.setImageDrawable(icon);
                this.f912e.setVisibility(0);
            } else {
                ImageView imageView2 = this.f912e;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f912e.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(text);
            if (z) {
                if (this.f911d == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null, R.attr.actionBarTabTextStyle);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.f911d = appCompatTextView;
                }
                this.f911d.setText(text);
                this.f911d.setVisibility(0);
            } else {
                TextView textView2 = this.f911d;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f911d.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.f912e;
            if (imageView3 != null) {
                imageView3.setContentDescription(tab.getContentDescription());
            }
            TooltipCompat.setTooltipText(this, z ? null : tab.getContentDescription());
        }
    }

    protected class VisibilityAnimListener extends AnimatorListenerAdapter {

        /* renamed from: a */
        private boolean f915a = false;

        /* renamed from: b */
        private int f916b;

        protected VisibilityAnimListener() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f915a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f915a) {
                return;
            }
            ScrollingTabContainerView scrollingTabContainerView = ScrollingTabContainerView.this;
            scrollingTabContainerView.m = null;
            scrollingTabContainerView.setVisibility(this.f916b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ScrollingTabContainerView.this.setVisibility(0);
            this.f915a = false;
        }

        public VisibilityAnimListener withFinalVisibility(ViewPropertyAnimator viewPropertyAnimator, int i2) {
            this.f916b = i2;
            ScrollingTabContainerView.this.m = viewPropertyAnimator;
            return this;
        }
    }

    public ScrollingTabContainerView(Context context) {
        super(context);
        this.n = new VisibilityAnimListener();
        setHorizontalScrollBarEnabled(false);
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(context);
        setContentHeight(actionBarPolicy.getTabContainerHeight());
        this.f903j = actionBarPolicy.getStackedTabMaxWidth();
        LinearLayoutCompat b2 = b();
        this.f899f = b2;
        addView(b2, new ViewGroup.LayoutParams(-2, -1));
    }

    private Spinner a() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), null, R.attr.actionDropDownStyle);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    private LinearLayoutCompat b() {
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(getContext(), null, R.attr.actionBarTabBarStyle);
        linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        return linearLayoutCompat;
    }

    private boolean d() {
        Spinner spinner = this.f900g;
        return spinner != null && spinner.getParent() == this;
    }

    private void e() {
        if (d()) {
            return;
        }
        if (this.f900g == null) {
            this.f900g = a();
        }
        removeView(this.f899f);
        addView(this.f900g, new ViewGroup.LayoutParams(-2, -1));
        if (this.f900g.getAdapter() == null) {
            this.f900g.setAdapter((SpinnerAdapter) new TabAdapter());
        }
        Runnable runnable = this.f897d;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.f897d = null;
        }
        this.f900g.setSelection(this.l);
    }

    private boolean f() {
        if (!d()) {
            return false;
        }
        removeView(this.f900g);
        addView(this.f899f, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f900g.getSelectedItemPosition());
        return false;
    }

    public void addTab(ActionBar.Tab tab, boolean z) {
        TabView c2 = c(tab, false);
        this.f899f.addView(c2, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        Spinner spinner = this.f900g;
        if (spinner != null) {
            ((TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (z) {
            c2.setSelected(true);
        }
        if (this.f901h) {
            requestLayout();
        }
    }

    public void animateToTab(int i2) {
        View childAt = this.f899f.getChildAt(i2);
        Runnable runnable = this.f897d;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        AnonymousClass1 anonymousClass1 = new Runnable() { // from class: androidx.appcompat.widget.ScrollingTabContainerView.1

            /* renamed from: a */
            final /* synthetic */ View f904a;

            AnonymousClass1(View childAt2) {
                childAt = childAt2;
            }

            @Override // java.lang.Runnable
            public void run() {
                ScrollingTabContainerView.this.smoothScrollTo(childAt.getLeft() - ((ScrollingTabContainerView.this.getWidth() - childAt.getWidth()) / 2), 0);
                ScrollingTabContainerView.this.f897d = null;
            }
        };
        this.f897d = anonymousClass1;
        post(anonymousClass1);
    }

    public void animateToVisibility(int i2) {
        ViewPropertyAnimator viewPropertyAnimator = this.m;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
        if (i2 != 0) {
            ViewPropertyAnimator alpha = animate().alpha(0.0f);
            alpha.setDuration(200L);
            alpha.setInterpolator(f895b);
            alpha.setListener(this.n.withFinalVisibility(alpha, i2));
            alpha.start();
            return;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        ViewPropertyAnimator alpha2 = animate().alpha(1.0f);
        alpha2.setDuration(200L);
        alpha2.setInterpolator(f895b);
        alpha2.setListener(this.n.withFinalVisibility(alpha2, i2));
        alpha2.start();
    }

    TabView c(ActionBar.Tab tab, boolean z) {
        TabView tabView = new TabView(this, getContext(), tab, z);
        if (z) {
            tabView.setBackgroundDrawable(null);
            tabView.setLayoutParams(new AbsListView.LayoutParams(-1, this.k));
        } else {
            tabView.setFocusable(true);
            if (this.f898e == null) {
                this.f898e = new TabClickListener();
            }
            tabView.setOnClickListener(this.f898e);
        }
        return tabView;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f897d;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(getContext());
        setContentHeight(actionBarPolicy.getTabContainerHeight());
        this.f903j = actionBarPolicy.getStackedTabMaxWidth();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f897d;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
        ((TabView) view).getTab().select();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.f899f.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f902i = -1;
        } else {
            if (childCount > 2) {
                this.f902i = (int) (View.MeasureSpec.getSize(i2) * 0.4f);
            } else {
                this.f902i = View.MeasureSpec.getSize(i2) / 2;
            }
            this.f902i = Math.min(this.f902i, this.f903j);
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.k, 1073741824);
        if (!z && this.f901h) {
            this.f899f.measure(0, makeMeasureSpec);
            if (this.f899f.getMeasuredWidth() > View.MeasureSpec.getSize(i2)) {
                e();
            } else {
                f();
            }
        } else {
            f();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i2, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (!z || measuredWidth == measuredWidth2) {
            return;
        }
        setTabSelected(this.l);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void removeAllTabs() {
        this.f899f.removeAllViews();
        Spinner spinner = this.f900g;
        if (spinner != null) {
            ((TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.f901h) {
            requestLayout();
        }
    }

    public void removeTabAt(int i2) {
        this.f899f.removeViewAt(i2);
        Spinner spinner = this.f900g;
        if (spinner != null) {
            ((TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.f901h) {
            requestLayout();
        }
    }

    public void setAllowCollapse(boolean z) {
        this.f901h = z;
    }

    public void setContentHeight(int i2) {
        this.k = i2;
        requestLayout();
    }

    public void setTabSelected(int i2) {
        this.l = i2;
        int childCount = this.f899f.getChildCount();
        int i3 = 0;
        while (i3 < childCount) {
            View childAt = this.f899f.getChildAt(i3);
            boolean z = i3 == i2;
            childAt.setSelected(z);
            if (z) {
                animateToTab(i2);
            }
            i3++;
        }
        Spinner spinner = this.f900g;
        if (spinner == null || i2 < 0) {
            return;
        }
        spinner.setSelection(i2);
    }

    public void updateTab(int i2) {
        ((TabView) this.f899f.getChildAt(i2)).update();
        Spinner spinner = this.f900g;
        if (spinner != null) {
            ((TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.f901h) {
            requestLayout();
        }
    }

    public void addTab(ActionBar.Tab tab, int i2, boolean z) {
        TabView c2 = c(tab, false);
        this.f899f.addView(c2, i2, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        Spinner spinner = this.f900g;
        if (spinner != null) {
            ((TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (z) {
            c2.setSelected(true);
        }
        if (this.f901h) {
            requestLayout();
        }
    }
}
