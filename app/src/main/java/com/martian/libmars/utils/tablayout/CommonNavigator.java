package com.martian.libmars.utils.tablayout;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.utils.tablayout.a;
import java.util.ArrayList;
import java.util.List;
import m9.e;
import m9.f;
import m9.g;
import m9.i;

/* loaded from: classes3.dex */
public class CommonNavigator extends FrameLayout implements f, a.InterfaceC0521a, k9.a {

    /* renamed from: b */
    public HorizontalScrollView f12415b;

    /* renamed from: c */
    public LinearLayout f12416c;

    /* renamed from: d */
    public LinearLayout f12417d;

    /* renamed from: e */
    public e f12418e;

    /* renamed from: f */
    public m9.b f12419f;

    /* renamed from: g */
    public final com.martian.libmars.utils.tablayout.a f12420g;

    /* renamed from: h */
    public int f12421h;

    /* renamed from: i */
    public int f12422i;

    /* renamed from: j */
    public float f12423j;

    /* renamed from: k */
    public int f12424k;

    /* renamed from: l */
    public boolean f12425l;

    /* renamed from: m */
    public final boolean f12426m;

    /* renamed from: n */
    public int f12427n;

    /* renamed from: o */
    public int f12428o;

    /* renamed from: p */
    public final List<i> f12429p;

    /* renamed from: q */
    public final DataSetObserver f12430q;

    public class a extends DataSetObserver {
        public a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            CommonNavigator.this.f12420g.m(CommonNavigator.this.f12419f.a());
            CommonNavigator.this.k();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
        }
    }

    public interface b extends g {
        int getContentBottom();

        int getContentLeft();

        int getContentRight();

        int getContentTop();
    }

    public CommonNavigator(Context context) {
        super(context);
        this.f12421h = 0;
        this.f12426m = true;
        this.f12428o = ConfigSingleton.i(12.0f);
        this.f12429p = new ArrayList();
        this.f12430q = new a();
        com.martian.libmars.utils.tablayout.a aVar = new com.martian.libmars.utils.tablayout.a();
        this.f12420g = aVar;
        aVar.k(this);
    }

    public void k() {
        removeAllViews();
        View inflate = this.f12425l ? LayoutInflater.from(getContext()).inflate(R.layout.pager_navigator_layout_no_scroll, this) : LayoutInflater.from(getContext()).inflate(R.layout.pager_navigator_layout, this);
        this.f12415b = (HorizontalScrollView) inflate.findViewById(R.id.scroll_view);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.title_container);
        this.f12416c = linearLayout;
        linearLayout.setPadding(this.f12427n, 0, 0, 0);
        this.f12417d = (LinearLayout) inflate.findViewById(R.id.indicator_container);
        l();
    }

    @Override // m9.f
    public void a() {
        m9.b bVar = this.f12419f;
        if (bVar != null) {
            bVar.e();
        }
    }

    @Override // com.martian.libmars.utils.tablayout.a.InterfaceC0521a
    public void b(int i10, int i11) {
        LinearLayout linearLayout = this.f12416c;
        if (linearLayout == null) {
            return;
        }
        KeyEvent.Callback childAt = linearLayout.getChildAt(i10);
        if (childAt instanceof g) {
            ((g) childAt).b(i10, i11);
        }
    }

    @Override // com.martian.libmars.utils.tablayout.a.InterfaceC0521a
    public void c(int i10, int i11, float f10, boolean z10) {
        LinearLayout linearLayout = this.f12416c;
        if (linearLayout == null) {
            return;
        }
        KeyEvent.Callback childAt = linearLayout.getChildAt(i10);
        if (childAt instanceof g) {
            ((g) childAt).c(i10, i11, f10, z10);
        }
    }

    @Override // com.martian.libmars.utils.tablayout.a.InterfaceC0521a
    public void d(int i10, int i11) {
        LinearLayout linearLayout = this.f12416c;
        if (linearLayout == null) {
            return;
        }
        KeyEvent.Callback childAt = linearLayout.getChildAt(i10);
        if (childAt instanceof g) {
            this.f12421h = i10;
            ((g) childAt).d(i10, i11);
        }
    }

    @Override // com.martian.libmars.utils.tablayout.a.InterfaceC0521a
    public void e(int i10, int i11, float f10, boolean z10) {
        LinearLayout linearLayout = this.f12416c;
        if (linearLayout == null) {
            return;
        }
        KeyEvent.Callback childAt = linearLayout.getChildAt(i10);
        if (childAt instanceof g) {
            ((g) childAt).e(i10, i11, f10, z10);
        }
    }

    @Override // m9.f
    public void f() {
        k();
    }

    @Override // m9.f
    public void g() {
    }

    public m9.b getAdapter() {
        return this.f12419f;
    }

    public int getSelectedPosition() {
        return this.f12421h;
    }

    public LinearLayout getTitleContainer() {
        return this.f12416c;
    }

    public int getTitleCount() {
        LinearLayout linearLayout = this.f12416c;
        if (linearLayout == null) {
            return 0;
        }
        return linearLayout.getChildCount();
    }

    public final void l() {
        LinearLayout.LayoutParams layoutParams;
        int g10 = this.f12420g.g();
        for (int i10 = 0; i10 < g10; i10++) {
            Object c10 = this.f12419f.c(getContext(), i10);
            if (c10 instanceof View) {
                View view = (View) c10;
                if (this.f12425l) {
                    layoutParams = new LinearLayout.LayoutParams(0, -1);
                    layoutParams.weight = this.f12419f.d(getContext(), i10);
                } else {
                    layoutParams = new LinearLayout.LayoutParams(-2, -1);
                    int i11 = this.f12428o;
                    layoutParams.setMargins(i11, 0, i11, 0);
                }
                this.f12416c.addView(view, layoutParams);
            }
        }
        m9.b bVar = this.f12419f;
        if (bVar != null) {
            e b10 = bVar.b(getContext());
            this.f12418e = b10;
            if (b10 instanceof View) {
                this.f12417d.addView((View) this.f12418e, new FrameLayout.LayoutParams(-1, -1));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void m() {
        this.f12429p.clear();
        int g10 = this.f12420g.g();
        for (int i10 = 0; i10 < g10; i10++) {
            i iVar = new i();
            View childAt = this.f12416c.getChildAt(i10);
            if (childAt != 0) {
                iVar.f28543a = childAt.getLeft();
                iVar.f28544b = childAt.getTop();
                iVar.f28545c = childAt.getRight();
                int bottom = childAt.getBottom();
                iVar.f28546d = bottom;
                if (childAt instanceof b) {
                    b bVar = (b) childAt;
                    iVar.f28547e = bVar.getContentLeft();
                    iVar.f28548f = bVar.getContentTop();
                    iVar.f28549g = bVar.getContentRight();
                    iVar.f28550h = bVar.getContentBottom();
                } else {
                    iVar.f28547e = iVar.f28543a;
                    iVar.f28548f = iVar.f28544b;
                    iVar.f28549g = iVar.f28545c;
                    iVar.f28550h = bottom;
                }
            }
            this.f12429p.add(iVar);
        }
    }

    public void n(int i10) {
        LinearLayout linearLayout = this.f12417d;
        if (linearLayout == null || linearLayout.getChildCount() <= 0) {
            return;
        }
        View childAt = this.f12417d.getChildAt(0);
        if (childAt instanceof LinePagerIndicator) {
            LinePagerIndicator linePagerIndicator = (LinePagerIndicator) childAt;
            linePagerIndicator.d(Integer.valueOf(i10));
            linePagerIndicator.onPageScrolled(this.f12422i, this.f12423j, this.f12424k);
        }
    }

    public void o(int i10, int i11) {
        if (this.f12416c == null) {
            return;
        }
        for (int i12 = 0; i12 < this.f12416c.getChildCount(); i12++) {
            if (this.f12416c.getChildAt(i12) instanceof SimplePagerTitleView) {
                SimplePagerTitleView simplePagerTitleView = (SimplePagerTitleView) this.f12416c.getChildAt(i12);
                simplePagerTitleView.setNormalColor(i10);
                simplePagerTitleView.setSelectedColor(i11);
                if (this.f12421h == i12) {
                    simplePagerTitleView.setTextColor(i11);
                } else {
                    simplePagerTitleView.setTextColor(i10);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ConfigSingleton.D().h(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ConfigSingleton.D().X0(this);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (this.f12419f != null) {
            m();
            e eVar = this.f12418e;
            if (eVar != null) {
                eVar.a(this.f12429p);
            }
            if (this.f12420g.f() == 0) {
                onPageSelected(this.f12420g.e());
                onPageScrolled(this.f12420g.e(), 0.0f, 0);
            }
        }
    }

    @Override // m9.f
    public void onPageScrollStateChanged(int i10) {
        if (this.f12419f != null) {
            this.f12420g.h(i10);
            e eVar = this.f12418e;
            if (eVar != null) {
                eVar.onPageScrollStateChanged(i10);
            }
        }
    }

    @Override // m9.f
    public void onPageScrolled(int i10, float f10, int i11) {
        if (this.f12419f != null) {
            this.f12420g.i(i10, f10, i11);
            e eVar = this.f12418e;
            if (eVar != null) {
                this.f12422i = i10;
                this.f12423j = f10;
                this.f12424k = i11;
                eVar.onPageScrolled(i10, f10, i11);
            }
            if (this.f12415b == null || this.f12429p.size() <= 0 || i10 < 0 || i10 >= this.f12429p.size()) {
                return;
            }
            int min = Math.min(this.f12429p.size() - 1, i10);
            int min2 = Math.min(this.f12429p.size() - 1, i10 + 1);
            i iVar = this.f12429p.get(min);
            i iVar2 = this.f12429p.get(min2);
            float d10 = iVar.d() - (this.f12415b.getWidth() * 0.5f);
            this.f12415b.scrollTo((int) (d10 + (((iVar2.d() - (this.f12415b.getWidth() * 0.5f)) - d10) * f10)), 0);
        }
    }

    @Override // m9.f
    public void onPageSelected(int i10) {
        if (this.f12419f != null) {
            this.f12420g.j(i10);
            e eVar = this.f12418e;
            if (eVar != null) {
                eVar.onPageSelected(i10);
            }
        }
    }

    @Override // k9.a
    public void p() {
        a();
    }

    public void setAdapter(m9.b bVar) {
        m9.b bVar2 = this.f12419f;
        if (bVar2 == bVar) {
            return;
        }
        if (bVar2 != null) {
            bVar2.h(this.f12430q);
        }
        this.f12419f = bVar;
        if (bVar == null) {
            this.f12420g.m(0);
            k();
            return;
        }
        bVar.g(this.f12430q);
        this.f12420g.m(this.f12419f.a());
        if (this.f12416c != null) {
            this.f12419f.e();
        }
    }

    public void setAdjustMode(boolean z10) {
        this.f12425l = z10;
    }

    public void setLeftPadding(int i10) {
        this.f12427n = i10;
    }

    public void setMarginHorizontal(int i10) {
        this.f12428o = i10;
    }
}
