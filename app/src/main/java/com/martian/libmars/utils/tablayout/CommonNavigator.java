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
import com.martian.libmars.utils.tablayout.k;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class CommonNavigator extends FrameLayout implements i, k.a, g.a {

    /* renamed from: a */
    private HorizontalScrollView f10197a;

    /* renamed from: b */
    private LinearLayout f10198b;

    /* renamed from: c */
    private LinearLayout f10199c;

    /* renamed from: d */
    private h f10200d;

    /* renamed from: e */
    private f f10201e;

    /* renamed from: f */
    private final k f10202f;

    /* renamed from: g */
    private int f10203g;

    /* renamed from: h */
    private int f10204h;

    /* renamed from: i */
    private float f10205i;

    /* renamed from: j */
    private int f10206j;
    private boolean k;
    private boolean l;
    private float m;
    private boolean n;
    private boolean o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private boolean t;
    private int u;
    private final List<l> v;
    private final DataSetObserver w;

    class a extends DataSetObserver {
        a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            CommonNavigator.this.f10202f.m(CommonNavigator.this.f10201e.a());
            CommonNavigator.this.m();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
        }
    }

    public interface b extends j {
        int getContentBottom();

        int getContentLeft();

        int getContentRight();

        int getContentTop();
    }

    public CommonNavigator(Context context) {
        super(context);
        this.f10203g = 0;
        this.m = 0.5f;
        this.n = true;
        this.o = true;
        this.t = true;
        this.u = com.martian.libmars.d.h.b(12.0f);
        this.v = new ArrayList();
        this.w = new a();
        k kVar = new k();
        this.f10202f = kVar;
        kVar.k(this);
    }

    public void m() {
        removeAllViews();
        View inflate = this.k ? LayoutInflater.from(getContext()).inflate(R.layout.pager_navigator_layout_no_scroll, this) : LayoutInflater.from(getContext()).inflate(R.layout.pager_navigator_layout, this);
        this.f10197a = (HorizontalScrollView) inflate.findViewById(R.id.scroll_view);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.title_container);
        this.f10198b = linearLayout;
        linearLayout.setPadding(this.q, 0, this.p, 0);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.indicator_container);
        this.f10199c = linearLayout2;
        if (this.r) {
            linearLayout2.getParent().bringChildToFront(this.f10199c);
        }
        n();
    }

    private void n() {
        LinearLayout.LayoutParams layoutParams;
        int g2 = this.f10202f.g();
        for (int i2 = 0; i2 < g2; i2++) {
            Object c2 = this.f10201e.c(getContext(), i2);
            if (c2 instanceof View) {
                View view = (View) c2;
                if (this.k) {
                    layoutParams = new LinearLayout.LayoutParams(0, -1);
                    layoutParams.weight = this.f10201e.d(getContext(), i2);
                } else {
                    layoutParams = new LinearLayout.LayoutParams(-2, -1);
                    int i3 = this.u;
                    layoutParams.setMargins(i3, 0, i3, 0);
                }
                this.f10198b.addView(view, layoutParams);
            }
        }
        f fVar = this.f10201e;
        if (fVar != null) {
            h b2 = fVar.b(getContext());
            this.f10200d = b2;
            if (b2 instanceof View) {
                this.f10199c.addView((View) this.f10200d, new FrameLayout.LayoutParams(-1, -1));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void v() {
        this.v.clear();
        int g2 = this.f10202f.g();
        for (int i2 = 0; i2 < g2; i2++) {
            l lVar = new l();
            View childAt = this.f10198b.getChildAt(i2);
            if (childAt != 0) {
                lVar.f10255a = childAt.getLeft();
                lVar.f10256b = childAt.getTop();
                lVar.f10257c = childAt.getRight();
                int bottom = childAt.getBottom();
                lVar.f10258d = bottom;
                if (childAt instanceof b) {
                    b bVar = (b) childAt;
                    lVar.f10259e = bVar.getContentLeft();
                    lVar.f10260f = bVar.getContentTop();
                    lVar.f10261g = bVar.getContentRight();
                    lVar.f10262h = bVar.getContentBottom();
                } else {
                    lVar.f10259e = lVar.f10255a;
                    lVar.f10260f = lVar.f10256b;
                    lVar.f10261g = lVar.f10257c;
                    lVar.f10262h = bottom;
                }
            }
            this.v.add(lVar);
        }
    }

    @Override // com.martian.libmars.utils.tablayout.k.a
    public void a(int index, int totalCount) {
        LinearLayout linearLayout = this.f10198b;
        if (linearLayout == null) {
            return;
        }
        KeyEvent.Callback childAt = linearLayout.getChildAt(index);
        if (childAt instanceof j) {
            ((j) childAt).a(index, totalCount);
        }
    }

    @Override // com.martian.libmars.utils.tablayout.k.a
    public void b(int index, int totalCount, float enterPercent, boolean leftToRight) {
        LinearLayout linearLayout = this.f10198b;
        if (linearLayout == null) {
            return;
        }
        KeyEvent.Callback childAt = linearLayout.getChildAt(index);
        if (childAt instanceof j) {
            ((j) childAt).b(index, totalCount, enterPercent, leftToRight);
        }
    }

    @Override // com.martian.libmars.utils.tablayout.k.a
    public void c(int index, int totalCount) {
        LinearLayout linearLayout = this.f10198b;
        if (linearLayout == null) {
            return;
        }
        KeyEvent.Callback childAt = linearLayout.getChildAt(index);
        if (childAt instanceof j) {
            this.f10203g = index;
            ((j) childAt).c(index, totalCount);
        }
        if (this.k || this.o || this.f10197a == null || this.v.size() <= 0) {
            return;
        }
        l lVar = this.v.get(Math.min(this.v.size() - 1, index));
        if (this.l) {
            float d2 = lVar.d() - (this.f10197a.getWidth() * this.m);
            if (this.n) {
                this.f10197a.smoothScrollTo((int) d2, 0);
                return;
            } else {
                this.f10197a.scrollTo((int) d2, 0);
                return;
            }
        }
        int scrollX = this.f10197a.getScrollX();
        int i2 = lVar.f10255a;
        if (scrollX > i2) {
            if (this.n) {
                this.f10197a.smoothScrollTo(i2, 0);
                return;
            } else {
                this.f10197a.scrollTo(i2, 0);
                return;
            }
        }
        int scrollX2 = this.f10197a.getScrollX() + getWidth();
        int i3 = lVar.f10257c;
        if (scrollX2 < i3) {
            if (this.n) {
                this.f10197a.smoothScrollTo(i3 - getWidth(), 0);
            } else {
                this.f10197a.scrollTo(i3 - getWidth(), 0);
            }
        }
    }

    @Override // com.martian.libmars.utils.tablayout.k.a
    public void d(int index, int totalCount, float leavePercent, boolean leftToRight) {
        LinearLayout linearLayout = this.f10198b;
        if (linearLayout == null) {
            return;
        }
        KeyEvent.Callback childAt = linearLayout.getChildAt(index);
        if (childAt instanceof j) {
            ((j) childAt).d(index, totalCount, leavePercent, leftToRight);
        }
    }

    @Override // com.martian.libmars.utils.tablayout.i
    public void e() {
        f fVar = this.f10201e;
        if (fVar != null) {
            fVar.e();
        }
    }

    @Override // com.martian.libmars.utils.tablayout.i
    public void f() {
        m();
    }

    @Override // g.a
    public void g() {
        e();
    }

    public f getAdapter() {
        return this.f10201e;
    }

    public int getLeftPadding() {
        return this.q;
    }

    public int getMarginHorizontal() {
        return this.u;
    }

    public h getPagerIndicator() {
        return this.f10200d;
    }

    public int getRightPadding() {
        return this.p;
    }

    public float getScrollPivotX() {
        return this.m;
    }

    public LinearLayout getTitleContainer() {
        return this.f10198b;
    }

    public int getTitleCount() {
        LinearLayout linearLayout = this.f10198b;
        if (linearLayout == null) {
            return 0;
        }
        return linearLayout.getChildCount();
    }

    @Override // com.martian.libmars.utils.tablayout.i
    public void h() {
    }

    public j l(int index) {
        LinearLayout linearLayout = this.f10198b;
        if (linearLayout == null) {
            return null;
        }
        return (j) linearLayout.getChildAt(index);
    }

    public boolean o() {
        return this.k;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.martian.libmars.d.h.F().a(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.martian.libmars.d.h.F().j1(this);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (this.f10201e != null) {
            v();
            h hVar = this.f10200d;
            if (hVar != null) {
                hVar.a(this.v);
            }
            if (this.t && this.f10202f.f() == 0) {
                onPageSelected(this.f10202f.e());
                onPageScrolled(this.f10202f.e(), 0.0f, 0);
            }
        }
    }

    @Override // com.martian.libmars.utils.tablayout.i
    public void onPageScrollStateChanged(int state) {
        if (this.f10201e != null) {
            this.f10202f.h(state);
            h hVar = this.f10200d;
            if (hVar != null) {
                hVar.onPageScrollStateChanged(state);
            }
        }
    }

    @Override // com.martian.libmars.utils.tablayout.i
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (this.f10201e != null) {
            this.f10202f.i(position, positionOffset, positionOffsetPixels);
            h hVar = this.f10200d;
            if (hVar != null) {
                this.f10204h = position;
                this.f10205i = positionOffset;
                this.f10206j = positionOffsetPixels;
                hVar.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }
            if (this.f10197a == null || this.v.size() <= 0 || position < 0 || position >= this.v.size() || !this.o) {
                return;
            }
            int min = Math.min(this.v.size() - 1, position);
            int min2 = Math.min(this.v.size() - 1, position + 1);
            l lVar = this.v.get(min);
            l lVar2 = this.v.get(min2);
            float d2 = lVar.d() - (this.f10197a.getWidth() * this.m);
            this.f10197a.scrollTo((int) (d2 + (((lVar2.d() - (this.f10197a.getWidth() * this.m)) - d2) * positionOffset)), 0);
        }
    }

    @Override // com.martian.libmars.utils.tablayout.i
    public void onPageSelected(int position) {
        if (this.f10201e != null) {
            this.f10202f.j(position);
            h hVar = this.f10200d;
            if (hVar != null) {
                hVar.onPageSelected(position);
            }
        }
    }

    public boolean p() {
        return this.l;
    }

    public boolean q() {
        return this.o;
    }

    public boolean r() {
        return this.r;
    }

    public boolean s() {
        return this.t;
    }

    public void setAdapter(f adapter) {
        f fVar = this.f10201e;
        if (fVar == adapter) {
            return;
        }
        if (fVar != null) {
            fVar.h(this.w);
        }
        this.f10201e = adapter;
        if (adapter == null) {
            this.f10202f.m(0);
            m();
            return;
        }
        adapter.g(this.w);
        this.f10202f.m(this.f10201e.a());
        if (this.f10198b != null) {
            this.f10201e.e();
        }
    }

    public void setAdjustMode(boolean is) {
        this.k = is;
    }

    public void setEnablePivotScroll(boolean is) {
        this.l = is;
    }

    public void setFollowTouch(boolean followTouch) {
        this.o = followTouch;
    }

    public void setIndicatorOnTop(boolean indicatorOnTop) {
        this.r = indicatorOnTop;
    }

    public void setLeftPadding(int leftPadding) {
        this.q = leftPadding;
    }

    public void setMarginHorizontal(int marginHorizontal) {
        this.u = marginHorizontal;
    }

    public void setReselectWhenLayout(boolean reselectWhenLayout) {
        this.t = reselectWhenLayout;
    }

    public void setRightPadding(int rightPadding) {
        this.p = rightPadding;
    }

    public void setScrollPivotX(float scrollPivotX) {
        this.m = scrollPivotX;
    }

    public void setSkimOver(boolean skimOver) {
        this.s = skimOver;
        this.f10202f.l(skimOver);
    }

    public void setSmoothScroll(boolean smoothScroll) {
        this.n = smoothScroll;
    }

    public boolean t() {
        return this.s;
    }

    public boolean u() {
        return this.n;
    }

    public void w(int Color) {
        LinearLayout linearLayout = this.f10199c;
        if (linearLayout == null || linearLayout.getChildCount() <= 0) {
            return;
        }
        View childAt = this.f10199c.getChildAt(0);
        if (childAt instanceof LinePagerIndicator) {
            LinePagerIndicator linePagerIndicator = (LinePagerIndicator) childAt;
            linePagerIndicator.c(Integer.valueOf(Color));
            linePagerIndicator.onPageScrolled(this.f10204h, this.f10205i, this.f10206j);
        }
    }

    public void x(int normalColor, int selectedColor) {
        if (this.f10198b == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f10198b.getChildCount(); i2++) {
            if (this.f10198b.getChildAt(i2) instanceof o) {
                o oVar = (o) this.f10198b.getChildAt(i2);
                oVar.setNormalColor(normalColor);
                oVar.setSelectedColor(selectedColor);
                if (this.f10203g == i2) {
                    oVar.setTextColor(selectedColor);
                } else {
                    oVar.setTextColor(normalColor);
                }
            }
        }
    }
}
