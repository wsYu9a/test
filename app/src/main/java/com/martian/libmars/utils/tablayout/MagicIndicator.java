package com.martian.libmars.utils.tablayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.martian.libmars.R;
import com.martian.libmars.utils.v0;
import java.util.List;

/* loaded from: classes2.dex */
public class MagicIndicator extends FrameLayout implements g.a {

    /* renamed from: a */
    public static final String f10218a = "PAGE_INDEX";

    /* renamed from: b */
    public static final int f10219b = 0;

    /* renamed from: c */
    public static final int f10220c = 1;

    /* renamed from: d */
    public static final int f10221d = 2;

    /* renamed from: e */
    public static final int f10222e = 3;

    /* renamed from: f */
    public static final int f10223f = 4;

    /* renamed from: g */
    private i f10224g;

    /* renamed from: h */
    private int f10225h;

    /* renamed from: i */
    private int f10226i;

    /* renamed from: j */
    private int f10227j;

    class a extends f {

        /* renamed from: b */
        final /* synthetic */ List f10228b;

        /* renamed from: c */
        final /* synthetic */ boolean f10229c;

        /* renamed from: d */
        final /* synthetic */ ViewPager f10230d;

        a(final List val$viewPager, final boolean val$changeFont, final ViewPager val$fragmentSections) {
            this.f10228b = val$viewPager;
            this.f10229c = val$changeFont;
            this.f10230d = val$fragmentSections;
        }

        @Override // com.martian.libmars.utils.tablayout.f
        public int a() {
            return this.f10228b.size();
        }

        @Override // com.martian.libmars.utils.tablayout.f
        public h b(Context context) {
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            linePagerIndicator.g(2).j(com.martian.libmars.d.h.b(5.0f)).e(com.martian.libmars.d.h.b(2.0f)).f(com.martian.libmars.d.h.b(16.0f)).h(com.martian.libmars.d.h.b(2.0f)).i(new AccelerateInterpolator()).d(new DecelerateInterpolator(2.0f)).c(Integer.valueOf(ContextCompat.getColor(context, R.color.theme_default)));
            return linePagerIndicator;
        }

        @Override // com.martian.libmars.utils.tablayout.f
        public j c(Context context, final int index) {
            m mVar = new m(context, this.f10229c);
            mVar.setText(((v0.a) this.f10228b.get(index)).b());
            mVar.setTextSize(16.0f);
            mVar.setMaxScale(1.125f);
            mVar.setNormalColor(com.martian.libmars.d.h.F().p0());
            mVar.setSelectedColor(MagicIndicator.this.f10227j);
            final ViewPager viewPager = this.f10230d;
            mVar.setOnClickListener(new View.OnClickListener() { // from class: com.martian.libmars.utils.tablayout.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ViewPager.this.setCurrentItem(index);
                }
            });
            return mVar;
        }
    }

    class b implements ViewPager.OnPageChangeListener {
        b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
            MagicIndicator.this.b(state);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            MagicIndicator.this.c(position, positionOffset, positionOffsetPixels);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            MagicIndicator.this.d(position);
        }
    }

    public MagicIndicator(Context context) {
        super(context);
        this.f10225h = 0;
        this.f10227j = ContextCompat.getColor(getContext(), R.color.theme_default);
    }

    private void e(Context context, AttributeSet attrs) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.MagicIndicator);
        this.f10226i = obtainStyledAttributes.getInteger(R.styleable.MagicIndicator_textColorType, -1);
        obtainStyledAttributes.recycle();
    }

    public void b(int state) {
        i iVar = this.f10224g;
        if (iVar != null) {
            iVar.onPageScrollStateChanged(state);
        }
    }

    public void c(int position, float positionOffset, int positionOffsetPixels) {
        i iVar = this.f10224g;
        if (iVar != null) {
            iVar.onPageScrolled(position, positionOffset, positionOffsetPixels);
        }
    }

    public void d(int position) {
        this.f10225h = position;
        i iVar = this.f10224g;
        if (iVar != null) {
            iVar.onPageSelected(position);
        }
    }

    public void f(final ViewPager viewPager, final boolean changeFont) {
        if (viewPager == null) {
            return;
        }
        PagerAdapter adapter = viewPager.getAdapter();
        if (adapter instanceof v0) {
            List<v0.a> b2 = ((v0) adapter).b();
            CommonNavigator commonNavigator = new CommonNavigator(getContext());
            commonNavigator.setAdapter(new a(b2, changeFont, viewPager));
            setNavigator(commonNavigator);
            viewPager.addOnPageChangeListener(new b());
        }
    }

    @Override // g.a
    public void g() {
        i iVar;
        if (this.f10226i <= 0 || (iVar = this.f10224g) == null || !(iVar instanceof CommonNavigator)) {
            return;
        }
        ((CommonNavigator) this.f10224g).x(ContextCompat.getColor(getContext(), com.martian.libmars.d.h.F().I0() ? R.color.night_text_color_primary : R.color.day_text_color_primary), this.f10227j);
    }

    public i getNavigator() {
        return this.f10224g;
    }

    public int getSelectPosition() {
        return this.f10225h;
    }

    public void h(int indicatorColor) {
        i iVar = this.f10224g;
        if (iVar == null || !(iVar instanceof CommonNavigator)) {
            return;
        }
        ((CommonNavigator) iVar).w(indicatorColor);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        g();
        com.martian.libmars.d.h.F().a(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.martian.libmars.d.h.F().j1(this);
    }

    public void setNavigator(i navigator) {
        i iVar = this.f10224g;
        if (iVar == navigator) {
            return;
        }
        if (iVar != null) {
            iVar.h();
        }
        this.f10224g = navigator;
        removeAllViews();
        if (this.f10224g instanceof View) {
            addView((View) this.f10224g, new FrameLayout.LayoutParams(-1, -1));
            this.f10224g.f();
        }
    }

    public void setTextColorType(int textColorType) {
        this.f10226i = textColorType;
    }

    public void setTitleSelectedColor(int color) {
        this.f10227j = color;
    }

    public MagicIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f10225h = 0;
        this.f10227j = ContextCompat.getColor(getContext(), R.color.theme_default);
        e(context, attrs);
    }

    public MagicIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f10225h = 0;
        this.f10227j = ContextCompat.getColor(getContext(), R.color.theme_default);
        e(context, attrs);
    }

    public void setNavigator(ViewPager viewPager) {
        f(viewPager, false);
    }
}
