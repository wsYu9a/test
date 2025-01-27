package com.martian.libsupport.bannerView;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleRes;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.martian.libsupport.R;
import com.martian.libsupport.bannerView.MTBannerView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class MTBannerView<T> extends RelativeLayout {

    /* renamed from: a */
    private static final String f10551a = "MTBannerView";

    /* renamed from: b */
    private CustomViewPager f10552b;

    /* renamed from: c */
    private e f10553c;

    /* renamed from: d */
    private List<T> f10554d;

    /* renamed from: e */
    private boolean f10555e;

    /* renamed from: f */
    private int f10556f;

    /* renamed from: g */
    private final Handler f10557g;

    /* renamed from: h */
    private int f10558h;

    /* renamed from: i */
    private ViewPagerScroller f10559i;

    /* renamed from: j */
    private boolean f10560j;
    private boolean k;
    private LinearLayout l;
    private final ArrayList<ImageView> m;
    private final int[] n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private ViewPager.OnPageChangeListener u;
    private c v;
    private d w;
    private boolean x;
    private final Runnable y;

    public enum IndicatorAlign {
        LEFT,
        CENTER,
        RIGHT
    }

    public static class ViewPagerScroller extends Scroller {

        /* renamed from: a */
        private int f10561a;

        /* renamed from: b */
        private boolean f10562b;

        public ViewPagerScroller(Context context) {
            super(context);
            this.f10561a = 800;
            this.f10562b = false;
        }

        public int a() {
            return this.f10561a;
        }

        public boolean b() {
            return this.f10562b;
        }

        public void c(int duration) {
            this.f10561a = duration;
        }

        public void d(boolean useDefaultDuration) {
            this.f10562b = useDefaultDuration;
        }

        @Override // android.widget.Scroller
        public void startScroll(int startX, int startY, int dx, int dy) {
            super.startScroll(startX, startY, dx, dy, this.f10561a);
        }

        @Override // android.widget.Scroller
        public void startScroll(int startX, int startY, int dx, int dy, int duration) {
            if (!this.f10562b) {
                duration = this.f10561a;
            }
            super.startScroll(startX, startY, dx, dy, duration);
        }

        public ViewPagerScroller(Context context, Interpolator interpolator) {
            super(context, interpolator);
            this.f10561a = 800;
            this.f10562b = false;
        }

        public ViewPagerScroller(Context context, Interpolator interpolator, boolean flywheel) {
            super(context, interpolator, flywheel);
            this.f10561a = 800;
            this.f10562b = false;
        }
    }

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MTBannerView.this.f10555e) {
                MTBannerView mTBannerView = MTBannerView.this;
                mTBannerView.f10556f = mTBannerView.f10552b.getCurrentItem();
                MTBannerView.e(MTBannerView.this);
                if (MTBannerView.this.f10556f == MTBannerView.this.f10553c.getCount() - 1) {
                    MTBannerView.this.f10556f = 0;
                    MTBannerView.this.f10552b.setCurrentItem(MTBannerView.this.f10556f, false);
                } else {
                    MTBannerView.this.f10552b.setCurrentItem(MTBannerView.this.f10556f);
                }
            }
            MTBannerView.this.f10557g.postDelayed(this, MTBannerView.this.f10558h);
        }
    }

    class b implements ViewPager.OnPageChangeListener {
        b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
            if (state == 1) {
                MTBannerView.this.f10555e = false;
            } else if (state == 2) {
                MTBannerView.this.f10555e = true;
            }
            if (MTBannerView.this.u != null) {
                MTBannerView.this.u.onPageScrollStateChanged(state);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            int size = position % MTBannerView.this.m.size();
            if (MTBannerView.this.u != null) {
                MTBannerView.this.u.onPageScrolled(size, positionOffset, positionOffsetPixels);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            MTBannerView.this.f10556f = position;
            int size = MTBannerView.this.f10556f % MTBannerView.this.m.size();
            for (int i2 = 0; i2 < MTBannerView.this.f10554d.size(); i2++) {
                if (i2 == size) {
                    ((ImageView) MTBannerView.this.m.get(i2)).setImageResource(MTBannerView.this.n[1]);
                } else {
                    ((ImageView) MTBannerView.this.m.get(i2)).setImageResource(MTBannerView.this.n[0]);
                }
            }
            if (MTBannerView.this.u != null) {
                MTBannerView.this.u.onPageSelected(size);
            }
        }
    }

    public interface c {
        void a(View view, int position);
    }

    public interface d {
        void a(View view, int position);
    }

    public static class e<T> extends PagerAdapter {

        /* renamed from: a */
        private List<T> f10565a;

        /* renamed from: b */
        private final com.martian.libsupport.bannerView.c<?> f10566b;

        /* renamed from: c */
        private ViewPager f10567c;

        /* renamed from: d */
        private final boolean f10568d;

        /* renamed from: e */
        private c f10569e;

        /* renamed from: f */
        private d f10570f;

        /* renamed from: g */
        private final int f10571g = 500;

        /* renamed from: h */
        private int f10572h;

        public e(List<T> datas, com.martian.libsupport.bannerView.c<?> MZHolderCreator, boolean canLoop) {
            if (this.f10565a == null) {
                this.f10565a = new ArrayList();
            }
            this.f10565a.addAll(datas);
            this.f10566b = MZHolderCreator;
            this.f10568d = canLoop;
        }

        private int a() {
            List<T> list = this.f10565a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        private int b() {
            if (a() == 0) {
                return 0;
            }
            int a2 = (a() * 500) / 2;
            if (a2 % a() == 0) {
                return a2;
            }
            while (a2 % a() != 0) {
                a2++;
            }
            return a2;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [com.martian.libsupport.bannerView.d] */
        private View c(final int realPosition, Context context) {
            ?? a2 = this.f10566b.a();
            if (a2 == 0) {
                throw new RuntimeException("can not return a null holder");
            }
            View b2 = a2.b(context);
            List<T> list = this.f10565a;
            if (list != null && list.size() > 0) {
                a2.a(context, realPosition, this.f10565a.get(realPosition));
            }
            b2.setOnClickListener(new View.OnClickListener() { // from class: com.martian.libsupport.bannerView.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MTBannerView.e.this.e(realPosition, view);
                }
            });
            return b2;
        }

        /* renamed from: d */
        public /* synthetic */ void e(final int realPosition, View v) {
            c cVar = this.f10569e;
            if (cVar != null) {
                cVar.a(v, realPosition);
            }
        }

        private void f(int position) {
            try {
                this.f10567c.setCurrentItem(position, false);
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void finishUpdate(@NonNull ViewGroup container) {
            int currentItem;
            if (!this.f10568d || this.f10572h == (currentItem = this.f10567c.getCurrentItem())) {
                return;
            }
            this.f10572h = currentItem;
            if (currentItem == getCount() - 1) {
                currentItem = 0;
                f(0);
            }
            if (this.f10570f != null) {
                this.f10570f.a(container.findViewWithTag(Integer.valueOf(currentItem)), currentItem % a());
            }
        }

        public void g(List<T> datas) {
            this.f10565a = datas;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f10568d ? a() * 500 : a();
        }

        public void h(c pageClickListener) {
            this.f10569e = pageClickListener;
        }

        public void i(d pageExposeListener) {
            this.f10570f = pageExposeListener;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(ViewGroup container, final int position) {
            int a2 = position % a();
            View findViewWithTag = container.findViewWithTag(Integer.valueOf(position));
            if (findViewWithTag != null) {
                return findViewWithTag;
            }
            View c2 = c(a2, container.getContext());
            c2.setTag(Integer.valueOf(position));
            container.addView(c2);
            return c2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        public void j(ViewPager viewPager) {
            this.f10567c = viewPager;
            viewPager.setAdapter(this);
            if (this.f10567c.getAdapter() != null) {
                this.f10567c.getAdapter().notifyDataSetChanged();
            }
            this.f10567c.setCurrentItem(this.f10568d ? b() : 0);
        }
    }

    public MTBannerView(@NonNull Context context) {
        super(context);
        this.f10555e = true;
        this.f10556f = 0;
        this.f10557g = new Handler();
        this.f10558h = 3000;
        this.f10560j = true;
        this.k = true;
        this.m = new ArrayList<>();
        this.n = new int[]{R.drawable.indicator_normal, R.drawable.indicator_selected};
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.x = false;
        this.y = new a();
        q();
    }

    private void A() {
        int i2 = this.t;
        IndicatorAlign indicatorAlign = IndicatorAlign.LEFT;
        if (i2 == indicatorAlign.ordinal()) {
            setIndicatorAlign(indicatorAlign);
            return;
        }
        int i3 = this.t;
        IndicatorAlign indicatorAlign2 = IndicatorAlign.CENTER;
        if (i3 == indicatorAlign2.ordinal()) {
            setIndicatorAlign(indicatorAlign2);
        } else {
            setIndicatorAlign(IndicatorAlign.RIGHT);
        }
    }

    static /* synthetic */ int e(MTBannerView mTBannerView) {
        int i2 = mTBannerView.f10556f;
        mTBannerView.f10556f = i2 + 1;
        return i2;
    }

    public static int o(int dp) {
        return (int) TypedValue.applyDimension(1, dp, Resources.getSystem().getDisplayMetrics());
    }

    public static int p(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    private void q() {
        View inflate = this.f10560j ? LayoutInflater.from(getContext()).inflate(R.layout.mz_banner_effect_layout, (ViewGroup) this, true) : LayoutInflater.from(getContext()).inflate(R.layout.mz_banner_normal_layout, (ViewGroup) this, true);
        this.l = (LinearLayout) inflate.findViewById(R.id.banner_indicator_container);
        CustomViewPager customViewPager = (CustomViewPager) inflate.findViewById(R.id.mzbanner_vp);
        this.f10552b = customViewPager;
        customViewPager.setOffscreenPageLimit(4);
        this.s = o(10);
        s();
        A();
    }

    private void r() {
        this.l.removeAllViews();
        this.m.clear();
        for (int i2 = 0; i2 < this.f10554d.size(); i2++) {
            ImageView imageView = new ImageView(getContext());
            if (this.t == IndicatorAlign.LEFT.ordinal()) {
                if (i2 == 0) {
                    imageView.setPadding((this.f10560j ? this.o + this.s : this.o) + 6, 0, 6, 0);
                } else {
                    imageView.setPadding(6, 0, 6, 0);
                }
            } else if (this.t != IndicatorAlign.RIGHT.ordinal()) {
                imageView.setPadding(6, 0, 6, 0);
            } else if (i2 == this.f10554d.size() - 1) {
                imageView.setPadding(6, 0, (this.f10560j ? this.s + this.p : this.p) + 6, 0);
            } else {
                imageView.setPadding(6, 0, 6, 0);
            }
            if (i2 == this.f10556f % this.f10554d.size()) {
                imageView.setImageResource(this.n[1]);
            } else {
                imageView.setImageResource(this.n[0]);
            }
            this.m.add(imageView);
            this.l.addView(imageView);
        }
    }

    private void s() {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            ViewPagerScroller viewPagerScroller = new ViewPagerScroller(this.f10552b.getContext());
            this.f10559i = viewPagerScroller;
            declaredField.set(this.f10552b, viewPagerScroller);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
        }
    }

    private void u(Context context, AttributeSet attrs) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.MTBannerView);
        this.f10560j = obtainStyledAttributes.getBoolean(R.styleable.MTBannerView_open_mz_mode, true);
        this.x = obtainStyledAttributes.getBoolean(R.styleable.MTBannerView_middle_page_cover, true);
        this.k = obtainStyledAttributes.getBoolean(R.styleable.MTBannerView_canLoop, true);
        this.t = obtainStyledAttributes.getInt(R.styleable.MTBannerView_indicatorAlign, IndicatorAlign.CENTER.ordinal());
        this.o = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MTBannerView_indicatorPaddingLeft, 0);
        this.p = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MTBannerView_indicatorPaddingRight, 0);
        this.q = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MTBannerView_indicatorPaddingTop, 0);
        this.r = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MTBannerView_indicatorPaddingBottom, 0);
        obtainStyledAttributes.recycle();
    }

    private void x() {
        if (this.f10560j) {
            if (!this.x) {
                this.f10552b.setPageTransformer(false, new com.martian.libsupport.bannerView.e());
            } else {
                CustomViewPager customViewPager = this.f10552b;
                customViewPager.setPageTransformer(true, new com.martian.libsupport.bannerView.b(customViewPager));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0019, code lost:
    
        if (r0 != 4) goto L48;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            boolean r0 = r3.k
            if (r0 != 0) goto L9
            boolean r4 = super.dispatchTouchEvent(r4)
            return r4
        L9:
            int r0 = r4.getAction()
            if (r0 == 0) goto L20
            r1 = 1
            if (r0 == r1) goto L1c
            r1 = 2
            if (r0 == r1) goto L20
            r1 = 3
            if (r0 == r1) goto L20
            r1 = 4
            if (r0 == r1) goto L20
            goto L40
        L1c:
            r3.z()
            goto L40
        L20:
            com.martian.libsupport.bannerView.CustomViewPager r0 = r3.f10552b
            int r0 = r0.getLeft()
            float r1 = r4.getRawX()
            float r2 = (float) r0
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L40
            android.content.Context r2 = r3.getContext()
            int r2 = p(r2)
            int r2 = r2 - r0
            float r0 = (float) r2
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 >= 0) goto L40
            r3.t()
        L40:
            boolean r4 = super.dispatchTouchEvent(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.libsupport.bannerView.MTBannerView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public int getDuration() {
        return this.f10559i.a();
    }

    public LinearLayout getIndicatorContainer() {
        return this.l;
    }

    public ViewPager getViewPager() {
        return this.f10552b;
    }

    public e getmAdapter() {
        return this.f10553c;
    }

    public void n(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.u = onPageChangeListener;
    }

    public void setBannerPageClickListener(c bannerPageClickListener) {
        this.v = bannerPageClickListener;
    }

    public void setBannerPageExposeListener(d bannerPageExposeListener) {
        this.w = bannerPageExposeListener;
    }

    public void setCanLoop(boolean canLoop) {
        this.k = canLoop;
        if (canLoop) {
            return;
        }
        t();
    }

    public void setDelayedTime(int delayedTime) {
        this.f10558h = delayedTime;
    }

    public void setDuration(int duration) {
        this.f10559i.c(duration);
    }

    public void setIndicatorAlign(IndicatorAlign indicatorAlign) {
        this.t = indicatorAlign.ordinal();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.l.getLayoutParams();
        if (indicatorAlign == IndicatorAlign.LEFT) {
            layoutParams.addRule(9);
        } else if (indicatorAlign == IndicatorAlign.RIGHT) {
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(14);
        }
        layoutParams.setMargins(0, this.q, 0, this.r);
        this.l.setLayoutParams(layoutParams);
    }

    public void setIndicatorVisible(boolean visible) {
        if (visible) {
            this.l.setVisibility(0);
        } else {
            this.l.setVisibility(8);
        }
    }

    public void setUseDefaultDuration(boolean useDefaultDuration) {
        this.f10559i.d(useDefaultDuration);
    }

    public void t() {
        this.f10555e = false;
        this.f10557g.removeCallbacks(this.y);
    }

    public void v(int paddingLeft, int paddingTop, int paddingRight, int paddingBottom) {
        this.o = paddingLeft;
        this.q = paddingTop;
        this.p = paddingRight;
        this.r = paddingBottom;
        A();
    }

    public void w(@DrawableRes int unSelectRes, @DrawableRes int selectRes) {
        int[] iArr = this.n;
        iArr[0] = unSelectRes;
        iArr[1] = selectRes;
    }

    public void y(List<T> datas, com.martian.libsupport.bannerView.c<?> mzHolderCreator) {
        if (datas == null || mzHolderCreator == null) {
            return;
        }
        this.f10554d = datas;
        this.f10552b.setOffscreenPageLimit(datas.size());
        t();
        if (datas.size() < 3) {
            this.f10560j = false;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f10552b.getLayoutParams();
            marginLayoutParams.setMargins(0, 0, 0, 0);
            this.f10552b.setLayoutParams(marginLayoutParams);
            setClipChildren(true);
            this.f10552b.setClipChildren(true);
        }
        this.k = this.f10554d.size() > 1;
        setIndicatorVisible(this.f10554d.size() > 1);
        x();
        r();
        e eVar = new e(datas, mzHolderCreator, this.k);
        this.f10553c = eVar;
        eVar.j(this.f10552b);
        this.f10553c.h(this.v);
        this.f10553c.i(this.w);
        this.f10552b.clearOnPageChangeListeners();
        this.f10552b.addOnPageChangeListener(new b());
    }

    public void z() {
        if (this.f10553c != null && this.k) {
            t();
            this.f10555e = true;
            this.f10557g.postDelayed(this.y, this.f10558h);
        }
    }

    public MTBannerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.f10555e = true;
        this.f10556f = 0;
        this.f10557g = new Handler();
        this.f10558h = 3000;
        this.f10560j = true;
        this.k = true;
        this.m = new ArrayList<>();
        this.n = new int[]{R.drawable.indicator_normal, R.drawable.indicator_selected};
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.x = false;
        this.y = new a();
        u(context, attrs);
        q();
    }

    public MTBannerView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f10555e = true;
        this.f10556f = 0;
        this.f10557g = new Handler();
        this.f10558h = 3000;
        this.f10560j = true;
        this.k = true;
        this.m = new ArrayList<>();
        this.n = new int[]{R.drawable.indicator_normal, R.drawable.indicator_selected};
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.x = false;
        this.y = new a();
        u(context, attrs);
        q();
    }

    @RequiresApi(api = 21)
    public MTBannerView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.f10555e = true;
        this.f10556f = 0;
        this.f10557g = new Handler();
        this.f10558h = 3000;
        this.f10560j = true;
        this.k = true;
        this.m = new ArrayList<>();
        this.n = new int[]{R.drawable.indicator_normal, R.drawable.indicator_selected};
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.x = false;
        this.y = new a();
        u(context, attrs);
        q();
    }
}
