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
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.utils.SectionsPagerAdapter;
import java.util.List;
import m9.e;
import m9.f;
import m9.g;

/* loaded from: classes3.dex */
public class MagicIndicator extends FrameLayout implements k9.a {

    /* renamed from: e */
    public static final String f12461e = "PAGE_INDEX";

    /* renamed from: f */
    public static final int f12462f = 0;

    /* renamed from: g */
    public static final int f12463g = 1;

    /* renamed from: b */
    public f f12464b;

    /* renamed from: c */
    public int f12465c;

    /* renamed from: d */
    public int f12466d;

    public class a extends m9.b {

        /* renamed from: b */
        public final /* synthetic */ List f12467b;

        /* renamed from: c */
        public final /* synthetic */ boolean f12468c;

        /* renamed from: d */
        public final /* synthetic */ ViewPager f12469d;

        public a(List list, boolean z10, ViewPager viewPager) {
            this.f12467b = list;
            this.f12468c = z10;
            this.f12469d = viewPager;
        }

        @Override // m9.b
        public int a() {
            return this.f12467b.size();
        }

        @Override // m9.b
        public e b(Context context) {
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            linePagerIndicator.i(2).l(ConfigSingleton.i(5.0f)).f(ConfigSingleton.i(2.0f)).g(ConfigSingleton.i(16.0f)).j(ConfigSingleton.i(2.0f)).k(new AccelerateInterpolator()).e(new DecelerateInterpolator(2.0f)).d(Integer.valueOf(ContextCompat.getColor(context, R.color.theme_default)));
            return linePagerIndicator;
        }

        @Override // m9.b
        public g c(Context context, int i10) {
            ScaleTransitionPagerTitleView scaleTransitionPagerTitleView = new ScaleTransitionPagerTitleView(context, this.f12468c);
            scaleTransitionPagerTitleView.setText(((SectionsPagerAdapter.a) this.f12467b.get(i10)).b());
            scaleTransitionPagerTitleView.setTextSize(16.0f);
            scaleTransitionPagerTitleView.setMaxScale(1.125f);
            scaleTransitionPagerTitleView.setNormalColor(ConfigSingleton.D().h0());
            scaleTransitionPagerTitleView.setSelectedColor(ContextCompat.getColor(MagicIndicator.this.getContext(), R.color.theme_default));
            scaleTransitionPagerTitleView.setOnClickListener(new View.OnClickListener() { // from class: m9.h

                /* renamed from: c */
                public final /* synthetic */ int f28542c;

                public /* synthetic */ h(int i102) {
                    i10 = i102;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ViewPager.this.setCurrentItem(i10);
                }
            });
            return scaleTransitionPagerTitleView;
        }
    }

    public class b implements ViewPager.OnPageChangeListener {
        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i10) {
            MagicIndicator.this.a(i10);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i10, float f10, int i11) {
            MagicIndicator.this.b(i10, f10, i11);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i10) {
            MagicIndicator.this.c(i10);
        }
    }

    public MagicIndicator(Context context) {
        super(context);
        this.f12465c = 0;
    }

    private void d(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MagicIndicator);
        this.f12466d = obtainStyledAttributes.getInteger(R.styleable.MagicIndicator_indicatorTextColorType, -1);
        obtainStyledAttributes.recycle();
    }

    public void a(int i10) {
        f fVar = this.f12464b;
        if (fVar != null) {
            fVar.onPageScrollStateChanged(i10);
        }
    }

    public void b(int i10, float f10, int i11) {
        f fVar = this.f12464b;
        if (fVar != null) {
            fVar.onPageScrolled(i10, f10, i11);
        }
    }

    public void c(int i10) {
        this.f12465c = i10;
        f fVar = this.f12464b;
        if (fVar != null) {
            fVar.onPageSelected(i10);
        }
    }

    public void e(ViewPager viewPager, boolean z10) {
        if (viewPager == null) {
            return;
        }
        PagerAdapter adapter = viewPager.getAdapter();
        if (adapter instanceof SectionsPagerAdapter) {
            List<SectionsPagerAdapter.a> a10 = ((SectionsPagerAdapter) adapter).a();
            CommonNavigator commonNavigator = new CommonNavigator(getContext());
            commonNavigator.setAdapter(new a(a10, z10, viewPager));
            setNavigator(commonNavigator);
            viewPager.addOnPageChangeListener(new b());
        }
    }

    public f getNavigator() {
        return this.f12464b;
    }

    public int getSelectPosition() {
        return this.f12465c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        p();
        ConfigSingleton.D().h(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ConfigSingleton.D().X0(this);
    }

    @Override // k9.a
    public void p() {
        f fVar;
        if (this.f12466d <= 0 || (fVar = this.f12464b) == null || !(fVar instanceof CommonNavigator)) {
            return;
        }
        ((CommonNavigator) this.f12464b).o(ContextCompat.getColor(getContext(), ConfigSingleton.D().A0() ? R.color.night_text_color_primary : R.color.day_text_color_primary), ContextCompat.getColor(getContext(), R.color.theme_default));
    }

    public void setNavigator(f fVar) {
        f fVar2 = this.f12464b;
        if (fVar2 == fVar) {
            return;
        }
        if (fVar2 != null) {
            fVar2.g();
        }
        this.f12464b = fVar;
        removeAllViews();
        if (this.f12464b instanceof View) {
            addView((View) this.f12464b, new FrameLayout.LayoutParams(-1, -1));
            this.f12464b.f();
        }
    }

    public void setTextColorType(int i10) {
        this.f12466d = i10;
    }

    public MagicIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12465c = 0;
        d(context, attributeSet);
    }

    public MagicIndicator(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f12465c = 0;
        d(context, attributeSet);
    }

    public void setNavigator(ViewPager viewPager) {
        e(viewPager, false);
    }
}
