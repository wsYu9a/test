package com.martian.mibook.fragment.yuewen;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.fragment.LazyFragment;
import com.martian.libmars.utils.SectionsPagerAdapter;
import com.martian.libmars.utils.tablayout.CommonNavigator;
import com.martian.libmars.utils.tablayout.LinePagerIndicator;
import com.martian.libmars.utils.tablayout.ScaleTransitionPagerTitleView;
import com.martian.libmars.utils.tablayout.SimplePagerTitleView;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.BookMallTab;
import com.martian.mibook.databinding.FragmentBookmallMainBinding;
import com.martian.mibook.fragment.yuewen.YWCategoryMainFragment;
import com.martian.mibook.mvvm.category.fragment.BDCategoryFragment;
import e9.c;
import java.util.ArrayList;
import java.util.List;
import m9.e;
import m9.f;
import m9.g;
import ya.j2;

/* loaded from: classes3.dex */
public class YWCategoryMainFragment extends LazyFragment {

    /* renamed from: f */
    public c f13837f;

    /* renamed from: g */
    public FragmentBookmallMainBinding f13838g;

    /* renamed from: h */
    public List<BookMallTab> f13839h;

    public class a extends m9.b {
        public a() {
        }

        @Override // m9.b
        public int a() {
            return YWCategoryMainFragment.this.f13839h.size();
        }

        @Override // m9.b
        public e b(Context context) {
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            linePagerIndicator.i(2).l(ConfigSingleton.i(5.0f)).f(ConfigSingleton.i(2.0f)).g(ConfigSingleton.i(16.0f)).j(ConfigSingleton.i(2.0f)).k(new AccelerateInterpolator()).e(new DecelerateInterpolator(2.0f)).d(Integer.valueOf(ContextCompat.getColor(YWCategoryMainFragment.this.f12349c, R.color.theme_default)));
            return linePagerIndicator;
        }

        @Override // m9.b
        public g c(Context context, int i10) {
            ScaleTransitionPagerTitleView scaleTransitionPagerTitleView = new ScaleTransitionPagerTitleView(context, false);
            scaleTransitionPagerTitleView.setText(MiConfigSingleton.b2().s(((BookMallTab) YWCategoryMainFragment.this.f13839h.get(i10)).getName()));
            scaleTransitionPagerTitleView.setTextSize(16.0f);
            scaleTransitionPagerTitleView.setMaxScale(1.125f);
            scaleTransitionPagerTitleView.setNormalColor(ConfigSingleton.D().h0());
            scaleTransitionPagerTitleView.setSelectedColor(ContextCompat.getColor(YWCategoryMainFragment.this.f12349c, R.color.theme_default));
            scaleTransitionPagerTitleView.setOnClickListener(new View.OnClickListener() { // from class: fb.h

                /* renamed from: c */
                public final /* synthetic */ int f26020c;

                public /* synthetic */ h(int i102) {
                    i10 = i102;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YWCategoryMainFragment.a.this.j(i10, view);
                }
            });
            return scaleTransitionPagerTitleView;
        }

        public final /* synthetic */ void j(int i10, View view) {
            YWCategoryMainFragment.this.f13838g.bookmallVp.setCurrentItem(i10);
        }
    }

    public class b implements ViewPager.OnPageChangeListener {
        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i10) {
            YWCategoryMainFragment.this.f13838g.bookmallMagicIndicator.a(i10);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i10, float f10, int i11) {
            YWCategoryMainFragment.this.f13838g.bookmallMagicIndicator.b(i10, f10, i11);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i10) {
            YWCategoryMainFragment.this.f13838g.bookmallMagicIndicator.c(i10);
        }
    }

    private void v() {
        c cVar = new c();
        this.f13837f = cVar;
        cVar.c(j2.M, new wj.b() { // from class: fb.g
            public /* synthetic */ g() {
            }

            @Override // wj.b
            public final void call(Object obj) {
                YWCategoryMainFragment.this.z((Integer) obj);
            }
        });
    }

    private List<SectionsPagerAdapter.a> w() {
        ArrayList arrayList = new ArrayList();
        SectionsPagerAdapter.a d10 = new SectionsPagerAdapter.a().d(this.f13839h.get(0).getName());
        BDCategoryFragment.Companion companion = BDCategoryFragment.INSTANCE;
        arrayList.add(d10.c(companion.a(this.f13839h.get(0).getTid(), true)));
        arrayList.add(new SectionsPagerAdapter.a().d(this.f13839h.get(1).getName()).c(companion.a(this.f13839h.get(1).getTid(), true)));
        return arrayList;
    }

    private void x() {
        v();
        y();
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getChildFragmentManager(), w());
        this.f13838g.bookmallVp.setOffscreenPageLimit(this.f13839h.size());
        this.f13838g.bookmallVp.setAdapter(sectionsPagerAdapter);
        ((RelativeLayout.LayoutParams) this.f13838g.bookmallHeaderView.getLayoutParams()).topMargin = k();
        CommonNavigator commonNavigator = new CommonNavigator(this.f12349c);
        commonNavigator.setLeftPadding(ConfigSingleton.i(4.0f));
        commonNavigator.setAdapter(new a());
        this.f13838g.bookmallMagicIndicator.setNavigator(commonNavigator);
        this.f13838g.bookmallVp.addOnPageChangeListener(new b());
        this.f13838g.bookmallVp.setCurrentItem(0);
    }

    public /* synthetic */ void z(Integer num) {
        if (num != null && num.intValue() == j2.N) {
            y();
            f navigator = this.f13838g.bookmallMagicIndicator.getNavigator();
            if (navigator instanceof CommonNavigator) {
                CommonNavigator commonNavigator = (CommonNavigator) navigator;
                if (commonNavigator.getTitleContainer() != null) {
                    for (int i10 = 0; i10 < commonNavigator.getTitleContainer().getChildCount(); i10++) {
                        ((SimplePagerTitleView) commonNavigator.getTitleContainer().getChildAt(i10)).setText(MiConfigSingleton.b2().s(this.f13839h.get(i10).getName()));
                    }
                }
            }
            this.f13838g.bookmallVp.setCurrentItem(0);
        }
    }

    @Override // com.martian.libmars.fragment.LazyFragment
    public void m() {
        x();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(com.martian.mibook.R.layout.fragment_bookmall_main, viewGroup, false);
        this.f13838g = FragmentBookmallMainBinding.bind(inflate);
        return inflate;
    }

    @Override // com.martian.libmars.fragment.LazyFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        c cVar = this.f13837f;
        if (cVar != null) {
            cVar.b();
        }
    }

    public final void y() {
        this.f13839h = new ArrayList();
        BookMallTab bookMallTab = new BookMallTab();
        bookMallTab.setName(getString(MiConfigSingleton.b2().p() == 2 ? com.martian.mibook.R.string.female : com.martian.mibook.R.string.male));
        bookMallTab.setTid(MiConfigSingleton.b2().p());
        this.f13839h.add(bookMallTab);
        BookMallTab bookMallTab2 = new BookMallTab();
        bookMallTab2.setName(getString(MiConfigSingleton.b2().p() == 2 ? com.martian.mibook.R.string.male : com.martian.mibook.R.string.female));
        bookMallTab2.setTid(MiConfigSingleton.b2().k2());
        this.f13839h.add(bookMallTab2);
    }
}
