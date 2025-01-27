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

    /* renamed from: z */
    public static final String f12971z = "MTBannerView";

    /* renamed from: b */
    public CustomViewPager f12972b;

    /* renamed from: c */
    public MZPagerAdapter f12973c;

    /* renamed from: d */
    public List<T> f12974d;

    /* renamed from: e */
    public boolean f12975e;

    /* renamed from: f */
    public int f12976f;

    /* renamed from: g */
    public final Handler f12977g;

    /* renamed from: h */
    public int f12978h;

    /* renamed from: i */
    public ViewPagerScroller f12979i;

    /* renamed from: j */
    public boolean f12980j;

    /* renamed from: k */
    public boolean f12981k;

    /* renamed from: l */
    public LinearLayout f12982l;

    /* renamed from: m */
    public final ArrayList<ImageView> f12983m;

    /* renamed from: n */
    public final int[] f12984n;

    /* renamed from: o */
    public int f12985o;

    /* renamed from: p */
    public int f12986p;

    /* renamed from: q */
    public int f12987q;

    /* renamed from: r */
    public int f12988r;

    /* renamed from: s */
    public int f12989s;

    /* renamed from: t */
    public int f12990t;

    /* renamed from: u */
    public ViewPager.OnPageChangeListener f12991u;

    /* renamed from: v */
    public c f12992v;

    /* renamed from: w */
    public d f12993w;

    /* renamed from: x */
    public boolean f12994x;

    /* renamed from: y */
    public final Runnable f12995y;

    public enum IndicatorAlign {
        LEFT,
        CENTER,
        RIGHT
    }

    public static class MZPagerAdapter<T> extends PagerAdapter {

        /* renamed from: a */
        public List<T> f12996a;

        /* renamed from: b */
        public final ca.b<?> f12997b;

        /* renamed from: c */
        public ViewPager f12998c;

        /* renamed from: d */
        public final boolean f12999d;

        /* renamed from: e */
        public c f13000e;

        /* renamed from: f */
        public d f13001f;

        /* renamed from: g */
        public final int f13002g = 500;

        /* renamed from: h */
        public int f13003h;

        public MZPagerAdapter(List<T> list, ca.b<?> bVar, boolean z10) {
            if (this.f12996a == null) {
                this.f12996a = new ArrayList();
            }
            this.f12996a.addAll(list);
            this.f12997b = bVar;
            this.f12999d = z10;
        }

        public final int b() {
            List<T> list = this.f12996a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public final int c() {
            if (b() == 0) {
                return 0;
            }
            int b10 = (b() * 500) / 2;
            if (b10 % b() == 0) {
                return b10;
            }
            while (b10 % b() != 0) {
                b10++;
            }
            return b10;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [ca.c] */
        public final View d(int i10, Context context) {
            ?? a10 = this.f12997b.a();
            if (a10 == 0) {
                throw new RuntimeException("can not return a null holder");
            }
            View b10 = a10.b(context);
            List<T> list = this.f12996a;
            if (list != null && list.size() > 0) {
                a10.a(context, i10, this.f12996a.get(i10));
            }
            b10.setOnClickListener(new View.OnClickListener() { // from class: ca.a

                /* renamed from: c */
                public final /* synthetic */ int f1761c;

                public /* synthetic */ a(int i102) {
                    i10 = i102;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MTBannerView.MZPagerAdapter.this.e(i10, view);
                }
            });
            return b10;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i10, @NonNull Object obj) {
            viewGroup.removeView((View) obj);
        }

        public final /* synthetic */ void e(int i10, View view) {
            c cVar = this.f13000e;
            if (cVar != null) {
                cVar.a(view, i10);
            }
        }

        public final void f(int i10) {
            try {
                this.f12998c.setCurrentItem(i10, false);
            } catch (IllegalStateException e10) {
                e10.printStackTrace();
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void finishUpdate(@NonNull ViewGroup viewGroup) {
            int currentItem;
            if (!this.f12999d || this.f13003h == (currentItem = this.f12998c.getCurrentItem())) {
                return;
            }
            this.f13003h = currentItem;
            if (currentItem == getCount() - 1) {
                currentItem = 0;
                f(0);
            }
            if (this.f13001f != null) {
                this.f13001f.a(viewGroup.findViewWithTag(Integer.valueOf(currentItem)), currentItem % b());
            }
        }

        public void g(List<T> list) {
            this.f12996a = list;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f12999d ? b() * 500 : b();
        }

        public void h(c cVar) {
            this.f13000e = cVar;
        }

        public void i(d dVar) {
            this.f13001f = dVar;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(ViewGroup viewGroup, int i10) {
            int b10 = i10 % b();
            View findViewWithTag = viewGroup.findViewWithTag(Integer.valueOf(i10));
            if (findViewWithTag != null) {
                return findViewWithTag;
            }
            View d10 = d(b10, viewGroup.getContext());
            d10.setTag(Integer.valueOf(i10));
            viewGroup.addView(d10);
            return d10;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
            return view == obj;
        }

        public void j(ViewPager viewPager) {
            this.f12998c = viewPager;
            viewPager.setAdapter(this);
            if (this.f12998c.getAdapter() != null) {
                this.f12998c.getAdapter().notifyDataSetChanged();
            }
            this.f12998c.setCurrentItem(this.f12999d ? c() : 0);
        }
    }

    public static class ViewPagerScroller extends Scroller {

        /* renamed from: a */
        public int f13004a;

        /* renamed from: b */
        public boolean f13005b;

        public ViewPagerScroller(Context context) {
            super(context);
            this.f13004a = 800;
            this.f13005b = false;
        }

        public int a() {
            return this.f13004a;
        }

        public boolean b() {
            return this.f13005b;
        }

        public void c(int i10) {
            this.f13004a = i10;
        }

        public void d(boolean z10) {
            this.f13005b = z10;
        }

        @Override // android.widget.Scroller
        public void startScroll(int i10, int i11, int i12, int i13) {
            super.startScroll(i10, i11, i12, i13, this.f13004a);
        }

        @Override // android.widget.Scroller
        public void startScroll(int i10, int i11, int i12, int i13, int i14) {
            if (!this.f13005b) {
                i14 = this.f13004a;
            }
            super.startScroll(i10, i11, i12, i13, i14);
        }

        public ViewPagerScroller(Context context, Interpolator interpolator) {
            super(context, interpolator);
            this.f13004a = 800;
            this.f13005b = false;
        }

        public ViewPagerScroller(Context context, Interpolator interpolator, boolean z10) {
            super(context, interpolator, z10);
            this.f13004a = 800;
            this.f13005b = false;
        }
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MTBannerView.this.f12975e) {
                MTBannerView mTBannerView = MTBannerView.this;
                mTBannerView.f12976f = mTBannerView.f12972b.getCurrentItem();
                MTBannerView.this.f12976f++;
                if (MTBannerView.this.f12976f == MTBannerView.this.f12973c.getCount() - 1) {
                    MTBannerView.this.f12976f = 0;
                    MTBannerView.this.f12972b.setCurrentItem(MTBannerView.this.f12976f, false);
                } else {
                    MTBannerView.this.f12972b.setCurrentItem(MTBannerView.this.f12976f);
                }
            }
            MTBannerView.this.f12977g.postDelayed(this, MTBannerView.this.f12978h);
        }
    }

    public class b implements ViewPager.OnPageChangeListener {
        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i10) {
            if (i10 == 1) {
                MTBannerView.this.f12975e = false;
            } else if (i10 == 2) {
                MTBannerView.this.f12975e = true;
            }
            if (MTBannerView.this.f12991u != null) {
                MTBannerView.this.f12991u.onPageScrollStateChanged(i10);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i10, float f10, int i11) {
            int size = i10 % MTBannerView.this.f12983m.size();
            if (MTBannerView.this.f12991u != null) {
                MTBannerView.this.f12991u.onPageScrolled(size, f10, i11);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i10) {
            MTBannerView.this.f12976f = i10;
            int size = MTBannerView.this.f12976f % MTBannerView.this.f12983m.size();
            for (int i11 = 0; i11 < MTBannerView.this.f12974d.size(); i11++) {
                if (i11 == size) {
                    ((ImageView) MTBannerView.this.f12983m.get(i11)).setImageResource(MTBannerView.this.f12984n[1]);
                } else {
                    ((ImageView) MTBannerView.this.f12983m.get(i11)).setImageResource(MTBannerView.this.f12984n[0]);
                }
            }
            if (MTBannerView.this.f12991u != null) {
                MTBannerView.this.f12991u.onPageSelected(size);
            }
        }
    }

    public interface c {
        void a(View view, int i10);
    }

    public interface d {
        void a(View view, int i10);
    }

    public MTBannerView(@NonNull Context context) {
        super(context);
        this.f12975e = true;
        this.f12976f = 0;
        this.f12977g = new Handler();
        this.f12978h = 3000;
        this.f12980j = true;
        this.f12981k = true;
        this.f12983m = new ArrayList<>();
        this.f12984n = new int[]{R.drawable.indicator_normal, R.drawable.indicator_selected};
        this.f12985o = 0;
        this.f12986p = 0;
        this.f12987q = 0;
        this.f12988r = 0;
        this.f12989s = 0;
        this.f12990t = 0;
        this.f12994x = false;
        this.f12995y = new a();
        p();
    }

    public static int n(int i10) {
        return (int) TypedValue.applyDimension(1, i10, Resources.getSystem().getDisplayMetrics());
    }

    public static int o(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
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
            boolean r0 = r3.f12981k
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
            r3.y()
            goto L40
        L20:
            com.martian.libsupport.bannerView.CustomViewPager r0 = r3.f12972b
            int r0 = r0.getLeft()
            float r1 = r4.getRawX()
            float r2 = (float) r0
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L40
            android.content.Context r2 = r3.getContext()
            int r2 = o(r2)
            int r2 = r2 - r0
            float r0 = (float) r2
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 >= 0) goto L40
            r3.s()
        L40:
            boolean r4 = super.dispatchTouchEvent(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.libsupport.bannerView.MTBannerView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public int getDuration() {
        return this.f12979i.a();
    }

    public LinearLayout getIndicatorContainer() {
        return this.f12982l;
    }

    public ViewPager getViewPager() {
        return this.f12972b;
    }

    public MZPagerAdapter getmAdapter() {
        return this.f12973c;
    }

    public void m(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f12991u = onPageChangeListener;
    }

    public final void p() {
        View inflate = this.f12980j ? LayoutInflater.from(getContext()).inflate(R.layout.mz_banner_effect_layout, (ViewGroup) this, true) : LayoutInflater.from(getContext()).inflate(R.layout.mz_banner_normal_layout, (ViewGroup) this, true);
        this.f12982l = (LinearLayout) inflate.findViewById(R.id.banner_indicator_container);
        CustomViewPager customViewPager = (CustomViewPager) inflate.findViewById(R.id.mzbanner_vp);
        this.f12972b = customViewPager;
        customViewPager.setOffscreenPageLimit(4);
        this.f12989s = n(10);
        r();
        z();
    }

    public final void q() {
        this.f12982l.removeAllViews();
        this.f12983m.clear();
        for (int i10 = 0; i10 < this.f12974d.size(); i10++) {
            ImageView imageView = new ImageView(getContext());
            if (this.f12990t == IndicatorAlign.LEFT.ordinal()) {
                if (i10 == 0) {
                    imageView.setPadding((this.f12980j ? this.f12985o + this.f12989s : this.f12985o) + 6, 0, 6, 0);
                } else {
                    imageView.setPadding(6, 0, 6, 0);
                }
            } else if (this.f12990t != IndicatorAlign.RIGHT.ordinal()) {
                imageView.setPadding(6, 0, 6, 0);
            } else if (i10 == this.f12974d.size() - 1) {
                imageView.setPadding(6, 0, (this.f12980j ? this.f12989s + this.f12986p : this.f12986p) + 6, 0);
            } else {
                imageView.setPadding(6, 0, 6, 0);
            }
            if (i10 == this.f12976f % this.f12974d.size()) {
                imageView.setImageResource(this.f12984n[1]);
            } else {
                imageView.setImageResource(this.f12984n[0]);
            }
            this.f12983m.add(imageView);
            this.f12982l.addView(imageView);
        }
    }

    public final void r() {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            ViewPagerScroller viewPagerScroller = new ViewPagerScroller(this.f12972b.getContext());
            this.f12979i = viewPagerScroller;
            declaredField.set(this.f12972b, viewPagerScroller);
        } catch (IllegalAccessException e10) {
            e10.printStackTrace();
        } catch (IllegalArgumentException e11) {
            e11.printStackTrace();
        } catch (NoSuchFieldException e12) {
            e12.printStackTrace();
        }
    }

    public void s() {
        this.f12975e = false;
        this.f12977g.removeCallbacks(this.f12995y);
    }

    public void setBannerPageClickListener(c cVar) {
        this.f12992v = cVar;
    }

    public void setBannerPageExposeListener(d dVar) {
        this.f12993w = dVar;
    }

    public void setCanLoop(boolean z10) {
        this.f12981k = z10;
        if (z10) {
            return;
        }
        s();
    }

    public void setDelayedTime(int i10) {
        this.f12978h = i10;
    }

    public void setDuration(int i10) {
        this.f12979i.c(i10);
    }

    public void setIndicatorAlign(IndicatorAlign indicatorAlign) {
        this.f12990t = indicatorAlign.ordinal();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f12982l.getLayoutParams();
        if (indicatorAlign == IndicatorAlign.LEFT) {
            layoutParams.addRule(9);
        } else if (indicatorAlign == IndicatorAlign.RIGHT) {
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(14);
        }
        layoutParams.setMargins(0, this.f12987q, 0, this.f12988r);
        this.f12982l.setLayoutParams(layoutParams);
    }

    public void setIndicatorVisible(boolean z10) {
        if (z10) {
            this.f12982l.setVisibility(0);
        } else {
            this.f12982l.setVisibility(8);
        }
    }

    public void setUseDefaultDuration(boolean z10) {
        this.f12979i.d(z10);
    }

    public final void t(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MTBannerView);
        this.f12980j = obtainStyledAttributes.getBoolean(R.styleable.MTBannerView_open_mz_mode, true);
        this.f12994x = obtainStyledAttributes.getBoolean(R.styleable.MTBannerView_middle_page_cover, true);
        this.f12981k = obtainStyledAttributes.getBoolean(R.styleable.MTBannerView_canLoop, true);
        this.f12990t = obtainStyledAttributes.getInt(R.styleable.MTBannerView_indicatorAlign, IndicatorAlign.CENTER.ordinal());
        this.f12985o = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MTBannerView_indicatorPaddingLeft, 0);
        this.f12986p = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MTBannerView_indicatorPaddingRight, 0);
        this.f12987q = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MTBannerView_indicatorPaddingTop, 0);
        this.f12988r = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MTBannerView_indicatorPaddingBottom, 0);
        obtainStyledAttributes.recycle();
    }

    public void u(int i10, int i11, int i12, int i13) {
        this.f12985o = i10;
        this.f12987q = i11;
        this.f12986p = i12;
        this.f12988r = i13;
        z();
    }

    public void v(@DrawableRes int i10, @DrawableRes int i11) {
        int[] iArr = this.f12984n;
        iArr[0] = i10;
        iArr[1] = i11;
    }

    public final void w() {
        if (this.f12980j) {
            if (!this.f12994x) {
                this.f12972b.setPageTransformer(false, new ScaleYTransformer());
            } else {
                CustomViewPager customViewPager = this.f12972b;
                customViewPager.setPageTransformer(true, new CoverModeTransformer(customViewPager));
            }
        }
    }

    public void x(List<T> list, ca.b<?> bVar) {
        if (list == null || bVar == null) {
            return;
        }
        this.f12974d = list;
        this.f12972b.setOffscreenPageLimit(list.size());
        s();
        if (list.size() < 3) {
            this.f12980j = false;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f12972b.getLayoutParams();
            marginLayoutParams.setMargins(0, 0, 0, 0);
            this.f12972b.setLayoutParams(marginLayoutParams);
            setClipChildren(true);
            this.f12972b.setClipChildren(true);
        }
        this.f12981k = this.f12974d.size() > 1;
        setIndicatorVisible(this.f12974d.size() > 1);
        w();
        q();
        MZPagerAdapter mZPagerAdapter = new MZPagerAdapter(list, bVar, this.f12981k);
        this.f12973c = mZPagerAdapter;
        mZPagerAdapter.j(this.f12972b);
        this.f12973c.h(this.f12992v);
        this.f12973c.i(this.f12993w);
        this.f12972b.clearOnPageChangeListeners();
        this.f12972b.addOnPageChangeListener(new b());
    }

    public void y() {
        if (this.f12973c != null && this.f12981k) {
            s();
            this.f12975e = true;
            this.f12977g.postDelayed(this.f12995y, this.f12978h);
        }
    }

    public final void z() {
        int i10 = this.f12990t;
        IndicatorAlign indicatorAlign = IndicatorAlign.LEFT;
        if (i10 == indicatorAlign.ordinal()) {
            setIndicatorAlign(indicatorAlign);
            return;
        }
        int i11 = this.f12990t;
        IndicatorAlign indicatorAlign2 = IndicatorAlign.CENTER;
        if (i11 == indicatorAlign2.ordinal()) {
            setIndicatorAlign(indicatorAlign2);
        } else {
            setIndicatorAlign(IndicatorAlign.RIGHT);
        }
    }

    public MTBannerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12975e = true;
        this.f12976f = 0;
        this.f12977g = new Handler();
        this.f12978h = 3000;
        this.f12980j = true;
        this.f12981k = true;
        this.f12983m = new ArrayList<>();
        this.f12984n = new int[]{R.drawable.indicator_normal, R.drawable.indicator_selected};
        this.f12985o = 0;
        this.f12986p = 0;
        this.f12987q = 0;
        this.f12988r = 0;
        this.f12989s = 0;
        this.f12990t = 0;
        this.f12994x = false;
        this.f12995y = new a();
        t(context, attributeSet);
        p();
    }

    public MTBannerView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i10) {
        super(context, attributeSet, i10);
        this.f12975e = true;
        this.f12976f = 0;
        this.f12977g = new Handler();
        this.f12978h = 3000;
        this.f12980j = true;
        this.f12981k = true;
        this.f12983m = new ArrayList<>();
        this.f12984n = new int[]{R.drawable.indicator_normal, R.drawable.indicator_selected};
        this.f12985o = 0;
        this.f12986p = 0;
        this.f12987q = 0;
        this.f12988r = 0;
        this.f12989s = 0;
        this.f12990t = 0;
        this.f12994x = false;
        this.f12995y = new a();
        t(context, attributeSet);
        p();
    }

    @RequiresApi(api = 21)
    public MTBannerView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i10, @StyleRes int i11) {
        super(context, attributeSet, i10, i11);
        this.f12975e = true;
        this.f12976f = 0;
        this.f12977g = new Handler();
        this.f12978h = 3000;
        this.f12980j = true;
        this.f12981k = true;
        this.f12983m = new ArrayList<>();
        this.f12984n = new int[]{R.drawable.indicator_normal, R.drawable.indicator_selected};
        this.f12985o = 0;
        this.f12986p = 0;
        this.f12987q = 0;
        this.f12988r = 0;
        this.f12989s = 0;
        this.f12990t = 0;
        this.f12994x = false;
        this.f12995y = new a();
        t(context, attributeSet);
        p();
    }
}
