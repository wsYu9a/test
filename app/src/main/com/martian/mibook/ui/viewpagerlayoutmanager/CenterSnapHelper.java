package com.martian.mibook.ui.viewpagerlayoutmanager;

import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.martian.mibook.ui.viewpagerlayoutmanager.ViewPagerLayoutManager;
import ie.c;

/* loaded from: classes3.dex */
public class CenterSnapHelper extends RecyclerView.OnFlingListener {

    /* renamed from: i */
    public RecyclerView f16132i;

    /* renamed from: j */
    public Scroller f16133j;

    /* renamed from: k */
    public boolean f16134k = false;

    /* renamed from: l */
    public final RecyclerView.OnScrollListener f16135l = new a();

    public class a extends RecyclerView.OnScrollListener {

        /* renamed from: t */
        public boolean f16136t = false;

        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
            super.onScrollStateChanged(recyclerView, i10);
            ViewPagerLayoutManager viewPagerLayoutManager = (ViewPagerLayoutManager) recyclerView.getLayoutManager();
            ViewPagerLayoutManager.a aVar = viewPagerLayoutManager.f16166p;
            if (aVar != null) {
                aVar.onPageScrollStateChanged(i10);
            }
            if (i10 == 0 && this.f16136t) {
                this.f16136t = false;
                if (CenterSnapHelper.this.f16134k) {
                    CenterSnapHelper.this.f16134k = false;
                } else {
                    CenterSnapHelper.this.f16134k = true;
                    CenterSnapHelper.this.c(viewPagerLayoutManager, aVar);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            if (i10 == 0 && i11 == 0) {
                return;
            }
            this.f16136t = true;
        }
    }

    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.f16132i;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            destroyCallbacks();
        }
        this.f16132i = recyclerView;
        if (recyclerView != null) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof ViewPagerLayoutManager) {
                setupCallbacks();
                this.f16133j = new Scroller(this.f16132i.getContext(), new DecelerateInterpolator());
                ViewPagerLayoutManager viewPagerLayoutManager = (ViewPagerLayoutManager) layoutManager;
                c(viewPagerLayoutManager, viewPagerLayoutManager.f16166p);
            }
        }
    }

    public void c(ViewPagerLayoutManager viewPagerLayoutManager, ViewPagerLayoutManager.a aVar) {
        int C = viewPagerLayoutManager.C();
        if (C == 0) {
            this.f16134k = false;
        } else if (viewPagerLayoutManager.getOrientation() == 1) {
            this.f16132i.smoothScrollBy(0, C);
        } else {
            this.f16132i.smoothScrollBy(C, 0);
        }
        if (aVar != null) {
            aVar.onPageSelected(viewPagerLayoutManager.p());
        }
    }

    public void destroyCallbacks() {
        this.f16132i.removeOnScrollListener(this.f16135l);
        this.f16132i.setOnFlingListener(null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnFlingListener
    public boolean onFling(int i10, int i11) {
        ViewPagerLayoutManager viewPagerLayoutManager = (ViewPagerLayoutManager) this.f16132i.getLayoutManager();
        if (viewPagerLayoutManager == null || this.f16132i.getAdapter() == null) {
            return false;
        }
        if (!viewPagerLayoutManager.u() && (viewPagerLayoutManager.f16158h == viewPagerLayoutManager.w() || viewPagerLayoutManager.f16158h == viewPagerLayoutManager.z())) {
            return false;
        }
        int minFlingVelocity = this.f16132i.getMinFlingVelocity();
        this.f16133j.fling(0, 0, i10, i11, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (viewPagerLayoutManager.f16155e == 1 && Math.abs(i11) > minFlingVelocity) {
            int q10 = viewPagerLayoutManager.q();
            int finalY = (int) ((this.f16133j.getFinalY() / viewPagerLayoutManager.f16165o) / viewPagerLayoutManager.r());
            c.a(this.f16132i, viewPagerLayoutManager, viewPagerLayoutManager.getReverseLayout() ? (-q10) - finalY : q10 + finalY);
            return true;
        }
        if (viewPagerLayoutManager.f16155e == 0 && Math.abs(i10) > minFlingVelocity) {
            int q11 = viewPagerLayoutManager.q();
            int finalX = (int) ((this.f16133j.getFinalX() / viewPagerLayoutManager.f16165o) / viewPagerLayoutManager.r());
            c.a(this.f16132i, viewPagerLayoutManager, viewPagerLayoutManager.getReverseLayout() ? (-q11) - finalX : q11 + finalX);
        }
        return true;
    }

    public void setupCallbacks() throws IllegalStateException {
        if (this.f16132i.getOnFlingListener() != null) {
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.f16132i.addOnScrollListener(this.f16135l);
        this.f16132i.setOnFlingListener(this);
    }
}
