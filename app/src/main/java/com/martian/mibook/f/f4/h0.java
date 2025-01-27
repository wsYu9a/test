package com.martian.mibook.f.f4;

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
import com.martian.libmars.utils.tablayout.CommonNavigator;
import com.martian.libmars.utils.tablayout.LinePagerIndicator;
import com.martian.libmars.utils.v0;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.v0;
import com.martian.mibook.data.BookMallTab;
import com.martian.mibook.e.y2;
import com.martian.mibook.f.f4.h0;
import com.martian.ttbookhd.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class h0 extends com.martian.libmars.f.e {

    /* renamed from: e */
    private com.martian.libmars.b.d f13124e;

    /* renamed from: f */
    private y2 f13125f;

    /* renamed from: g */
    private List<BookMallTab> f13126g;

    class a extends com.martian.libmars.utils.tablayout.f {
        a() {
        }

        /* renamed from: i */
        public /* synthetic */ void j(final int index, View v) {
            h0.this.f13125f.f12971e.setCurrentItem(index);
        }

        @Override // com.martian.libmars.utils.tablayout.f
        public int a() {
            return h0.this.f13126g.size();
        }

        @Override // com.martian.libmars.utils.tablayout.f
        public com.martian.libmars.utils.tablayout.h b(Context context) {
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            linePagerIndicator.g(2).j(com.martian.libmars.d.h.b(5.0f)).e(com.martian.libmars.d.h.b(2.0f)).f(com.martian.libmars.d.h.b(16.0f)).h(com.martian.libmars.d.h.b(2.0f)).i(new AccelerateInterpolator()).d(new DecelerateInterpolator(2.0f)).c(Integer.valueOf(ContextCompat.getColor(((com.martian.libmars.f.e) h0.this).f10082a, R.color.theme_default)));
            return linePagerIndicator;
        }

        @Override // com.martian.libmars.utils.tablayout.f
        public com.martian.libmars.utils.tablayout.j c(Context context, final int index) {
            com.martian.libmars.utils.tablayout.m mVar = new com.martian.libmars.utils.tablayout.m(context, false);
            mVar.setText(MiConfigSingleton.V3().n(((BookMallTab) h0.this.f13126g.get(index)).getName()));
            mVar.setTextSize(16.0f);
            mVar.setMaxScale(1.125f);
            mVar.setNormalColor(com.martian.libmars.d.h.F().p0());
            mVar.setSelectedColor(ContextCompat.getColor(((com.martian.libmars.f.e) h0.this).f10082a, R.color.theme_default));
            mVar.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.f4.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    h0.a.this.j(index, view);
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
            h0.this.f13125f.f12969c.b(state);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            h0.this.f13125f.f12969c.c(position, positionOffset, positionOffsetPixels);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            h0.this.f13125f.f12969c.d(position);
        }
    }

    private void j() {
        com.martian.libmars.b.d dVar = new com.martian.libmars.b.d();
        this.f13124e = dVar;
        dVar.c(v0.n, new rx.k.b() { // from class: com.martian.mibook.f.f4.v
            @Override // rx.k.b
            public final void call(Object obj) {
                h0.this.p((Integer) obj);
            }
        });
        this.f13124e.c(v0.o, new rx.k.b() { // from class: com.martian.mibook.f.f4.u
            @Override // rx.k.b
            public final void call(Object obj) {
                h0.this.r((Integer) obj);
            }
        });
    }

    private List<v0.a> k() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v0.a().d(this.f13126g.get(0).getName()).c(b0.v(this.f13126g.get(0).getTid(), true)));
        arrayList.add(new v0.a().d(this.f13126g.get(1).getName()).c(b0.v(this.f13126g.get(1).getTid(), true)));
        return arrayList;
    }

    private void m() {
        n();
        com.martian.libmars.utils.v0 v0Var = new com.martian.libmars.utils.v0(getChildFragmentManager(), k());
        this.f13125f.f12971e.setOffscreenPageLimit(this.f13126g.size());
        this.f13125f.f12971e.setAdapter(v0Var);
        ((RelativeLayout.LayoutParams) this.f13125f.f12968b.getLayoutParams()).topMargin = this.f10082a.F0();
        CommonNavigator commonNavigator = new CommonNavigator(this.f10082a);
        commonNavigator.setLeftPadding(com.martian.libmars.d.h.b(4.0f));
        commonNavigator.setAdapter(new a());
        this.f13125f.f12969c.setNavigator(commonNavigator);
        this.f13125f.f12971e.addOnPageChangeListener(new b());
        this.f13125f.f12971e.setCurrentItem(0);
    }

    private void n() {
        this.f13126g = new ArrayList();
        BookMallTab bookMallTab = new BookMallTab();
        bookMallTab.setName(MiConfigSingleton.V3().k() == 2 ? getString(R.string.female) : getString(R.string.male));
        bookMallTab.setTid(MiConfigSingleton.V3().k());
        this.f13126g.add(bookMallTab);
        BookMallTab bookMallTab2 = new BookMallTab();
        bookMallTab2.setName(MiConfigSingleton.V3().k() == 2 ? getString(R.string.male) : getString(R.string.female));
        bookMallTab2.setTid(MiConfigSingleton.V3().q4());
        this.f13126g.add(bookMallTab2);
    }

    /* renamed from: o */
    public /* synthetic */ void p(Integer position) {
        n();
        com.martian.libmars.utils.tablayout.i navigator = this.f13125f.f12969c.getNavigator();
        if (navigator instanceof CommonNavigator) {
            CommonNavigator commonNavigator = (CommonNavigator) navigator;
            if (commonNavigator.getTitleContainer() != null) {
                for (int i2 = 0; i2 < commonNavigator.getTitleContainer().getChildCount(); i2++) {
                    ((com.martian.libmars.utils.tablayout.o) commonNavigator.getTitleContainer().getChildAt(i2)).setText(MiConfigSingleton.V3().n(this.f13126g.get(i2).getName()));
                }
            }
        }
        this.f13125f.f12971e.setCurrentItem(0);
    }

    /* renamed from: q */
    public /* synthetic */ void r(Integer position) {
        this.f13125f.f12971e.setCurrentItem(position.intValue());
    }

    @Override // com.martian.libmars.f.e
    protected void c() {
        m();
    }

    public int l() {
        return this.f13125f.f12971e.getCurrentItem();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_category_main, container, false);
        this.f13125f = y2.a(inflate);
        j();
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        com.martian.libmars.b.d dVar = this.f13124e;
        if (dVar != null) {
            dVar.b();
        }
    }
}
