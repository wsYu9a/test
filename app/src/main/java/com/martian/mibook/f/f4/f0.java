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
import com.martian.mibook.data.BookMallTab;
import com.martian.mibook.e.y2;
import com.martian.mibook.f.f4.f0;
import com.martian.ttbookhd.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class f0 extends com.martian.libmars.f.e {

    /* renamed from: e */
    private v0 f13111e;

    /* renamed from: f */
    private com.martian.libmars.b.d f13112f;

    /* renamed from: g */
    private y2 f13113g;

    /* renamed from: h */
    private List<BookMallTab> f13114h;

    class a extends com.martian.libmars.utils.tablayout.f {
        a() {
        }

        /* renamed from: i */
        public /* synthetic */ void j(final int index, View v) {
            f0.this.f13113g.f12971e.setCurrentItem(index);
        }

        @Override // com.martian.libmars.utils.tablayout.f
        public int a() {
            return f0.this.f13114h.size();
        }

        @Override // com.martian.libmars.utils.tablayout.f
        public com.martian.libmars.utils.tablayout.h b(Context context) {
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            linePagerIndicator.g(2).j(com.martian.libmars.d.h.b(5.0f)).e(com.martian.libmars.d.h.b(2.0f)).f(com.martian.libmars.d.h.b(16.0f)).h(com.martian.libmars.d.h.b(2.0f)).i(new AccelerateInterpolator()).d(new DecelerateInterpolator(2.0f)).c(Integer.valueOf(ContextCompat.getColor(((com.martian.libmars.f.e) f0.this).f10082a, R.color.theme_default)));
            return linePagerIndicator;
        }

        @Override // com.martian.libmars.utils.tablayout.f
        public com.martian.libmars.utils.tablayout.j c(Context context, final int index) {
            com.martian.libmars.utils.tablayout.m mVar = new com.martian.libmars.utils.tablayout.m(context, false);
            mVar.setText(MiConfigSingleton.V3().n(((BookMallTab) f0.this.f13114h.get(index)).getName()));
            mVar.setTextSize(16.0f);
            mVar.setMaxScale(1.125f);
            mVar.setNormalColor(com.martian.libmars.d.h.F().p0());
            mVar.setSelectedColor(ContextCompat.getColor(((com.martian.libmars.f.e) f0.this).f10082a, R.color.theme_default));
            mVar.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.f4.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    f0.a.this.j(index, view);
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
            f0.this.f13113g.f12969c.b(state);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            f0.this.f13113g.f12969c.c(position, positionOffset, positionOffsetPixels);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            f0.this.f13113g.f12969c.d(position);
        }
    }

    private void j() {
        com.martian.libmars.b.d dVar = new com.martian.libmars.b.d();
        this.f13112f = dVar;
        dVar.c(com.martian.mibook.application.v0.n, new rx.k.b() { // from class: com.martian.mibook.f.f4.n
            @Override // rx.k.b
            public final void call(Object obj) {
                f0.this.q((Integer) obj);
            }
        });
        this.f13112f.c(com.martian.mibook.application.v0.q, new rx.k.b() { // from class: com.martian.mibook.f.f4.m
            @Override // rx.k.b
            public final void call(Object obj) {
                f0.this.s((Integer) obj);
            }
        });
    }

    private int k(BookMallTab bookMallTab) {
        int tid = bookMallTab.getTid();
        if (tid == 1) {
            return 1;
        }
        if (tid == 2) {
            return 2;
        }
        return MiConfigSingleton.V3().k();
    }

    private List<v0.a> l() {
        ArrayList arrayList = new ArrayList();
        for (BookMallTab bookMallTab : this.f13114h) {
            arrayList.add(new v0.a().d(bookMallTab.getName()).c(e0.f0(bookMallTab.getTid(), k(bookMallTab), true)));
        }
        return arrayList;
    }

    private void n() {
        o();
        this.f13111e = new v0(getChildFragmentManager(), l());
        this.f13113g.f12971e.setOffscreenPageLimit(this.f13114h.size());
        this.f13113g.f12971e.setAdapter(this.f13111e);
        ((RelativeLayout.LayoutParams) this.f13113g.f12968b.getLayoutParams()).topMargin = this.f10082a.F0();
        CommonNavigator commonNavigator = new CommonNavigator(this.f10082a);
        commonNavigator.setLeftPadding(com.martian.libmars.d.h.b(4.0f));
        commonNavigator.setAdapter(new a());
        this.f13113g.f12969c.setNavigator(commonNavigator);
        this.f13113g.f12971e.addOnPageChangeListener(new b());
        this.f13113g.f12971e.setCurrentItem(1);
    }

    private void o() {
        this.f13114h = MiConfigSingleton.V3().e4().d();
    }

    /* renamed from: p */
    public /* synthetic */ void q(Integer position) {
        o();
        com.martian.libmars.utils.tablayout.i navigator = this.f13113g.f12969c.getNavigator();
        if (navigator instanceof CommonNavigator) {
            CommonNavigator commonNavigator = (CommonNavigator) navigator;
            if (commonNavigator.getTitleContainer() != null) {
                for (int i2 = 0; i2 < commonNavigator.getTitleContainer().getChildCount(); i2++) {
                    ((com.martian.libmars.utils.tablayout.o) commonNavigator.getTitleContainer().getChildAt(i2)).setText(MiConfigSingleton.V3().n(this.f13114h.get(i2).getName()));
                }
            }
        }
        this.f13113g.f12971e.setCurrentItem(1);
    }

    /* renamed from: r */
    public /* synthetic */ void s(Integer tid) {
        if (tid != null) {
            if (this.f13111e == null) {
                n();
            }
            int i2 = 0;
            Iterator<BookMallTab> it = this.f13114h.iterator();
            while (it.hasNext()) {
                if (tid.intValue() == it.next().getTid()) {
                    this.f13113g.f12971e.setCurrentItem(i2);
                }
                i2++;
            }
        }
    }

    @Override // com.martian.libmars.f.e
    protected void c() {
        n();
    }

    public int m() {
        return this.f13113g.f12971e.getCurrentItem();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_bookmall_main, container, false);
        y2 a2 = y2.a(inflate);
        this.f13113g = a2;
        a2.f12970d.setVisibility(MiConfigSingleton.V3().W3().getEnableSearch() ? 0 : 8);
        j();
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        com.martian.libmars.b.d dVar = this.f13112f;
        if (dVar != null) {
            dVar.b();
        }
    }
}
