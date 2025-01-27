package com.martian.mibook.f.f4;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.martian.libmars.utils.n0;
import com.martian.libmars.widget.recyclerview.LoadMoreFooterView;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.mibook.activity.book.BookCategoryActivity;
import com.martian.mibook.e.b3;
import com.martian.mibook.lib.yuewen.request.CategoryTagListParams;
import com.martian.mibook.lib.yuewen.response.TYCategoryTagGroup;
import com.martian.mibook.ui.o.k3;
import com.martian.ttbookhd.R;
import java.util.List;

/* loaded from: classes3.dex */
public class b0 extends com.martian.libmars.f.h {

    /* renamed from: j */
    private b3 f13091j;
    private k3 k;
    private int l = 0;
    private boolean m;

    class a extends com.martian.mibook.lib.account.d.g<CategoryTagListParams, TYCategoryTagGroup> {
        a(Class x0, Class x1, Context x2) {
            super(x0, x1, x2);
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            b0.this.p();
            b0.this.y();
        }

        @Override // b.d.c.c.i, b.d.c.c.c
        public void onUDDataReceived(List<TYCategoryTagGroup> tyCategoryTagGroups) {
            b0.this.p();
            if (tyCategoryTagGroups == null || tyCategoryTagGroups.isEmpty()) {
                b0.this.y();
            } else {
                b0.this.x(tyCategoryTagGroups);
            }
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            if (show) {
                b0.this.f13091j.f11738b.setLoadingTip(LoadingTip.LoadStatus.loading);
            }
        }
    }

    public static b0 v(int ctype, boolean fullscreen) {
        b0 b0Var = new b0();
        Bundle bundle = new Bundle();
        bundle.putInt(BookCategoryActivity.F, ctype);
        bundle.putBoolean(BookCategoryActivity.G, fullscreen);
        b0Var.setArguments(bundle);
        return b0Var;
    }

    public void x(List<TYCategoryTagGroup> tyCategoryTagGroups) {
        if (n0.c(this.f10082a)) {
            return;
        }
        com.martian.mibook.lib.model.g.b.S(this.f10082a, this.l == 2 ? "女频分类" : "男频分类", "展示");
        this.f13091j.f11738b.setLoadingTip(LoadingTip.LoadStatus.finish);
        k3 k3Var = this.k;
        if (k3Var != null) {
            k3Var.T(this.l);
            this.k.a(tyCategoryTagGroups);
            return;
        }
        q(false);
        k3 k3Var2 = new k3(this.f10082a, tyCategoryTagGroups);
        this.k = k3Var2;
        k3Var2.T(this.l);
        this.f13091j.f11739c.setAdapter(this.k);
    }

    @Override // com.martian.libmars.f.e
    protected void c() {
        w();
    }

    @Override // com.martian.libmars.f.h
    public int h() {
        return R.layout.fragment_category;
    }

    @Override // com.martian.libmars.f.h
    public void m() {
        w();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(BookCategoryActivity.F, this.l);
        outState.putBoolean(BookCategoryActivity.G, this.m);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull final View baseView, Bundle savedInstanceState) {
        super.onViewCreated(baseView, savedInstanceState);
        this.f13091j = b3.a(g());
        if (savedInstanceState != null) {
            this.l = savedInstanceState.getInt(BookCategoryActivity.F, 1);
            this.m = savedInstanceState.getBoolean(BookCategoryActivity.G, false);
        } else if (getArguments() != null) {
            this.l = getArguments().getInt(BookCategoryActivity.F, 1);
            this.m = getArguments().getBoolean(BookCategoryActivity.G, false);
        }
        if (this.m) {
            this.f13091j.f11739c.setPadding(0, com.martian.libmars.d.h.b(44.0f) + this.f10082a.F0(), 0, 0);
        }
        this.f13091j.f11739c.setLoadMoreEnabled(false);
        this.f13091j.f11739c.setRefreshEnabled(false);
        this.f13091j.f11739c.setLayoutManager(new LinearLayoutManager(this.f10082a));
        this.f13091j.f11739c.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        this.f13091j.f11738b.setOnReloadListener(new LoadingTip.b() { // from class: com.martian.mibook.f.f4.a
            @Override // com.martian.libmars.widget.recyclerview.LoadingTip.b
            public final void a() {
                b0.this.w();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void w() {
        if (f()) {
            a aVar = new a(CategoryTagListParams.class, TYCategoryTagGroup.class, this.f10082a);
            ((CategoryTagListParams) aVar.k()).setFreeType(Integer.valueOf(this.l));
            aVar.j();
        }
    }

    public void y() {
        if (n0.c(this.f10082a)) {
            return;
        }
        k3 k3Var = this.k;
        if (k3Var == null || k3Var.getItemCount() <= 0) {
            this.f13091j.f11738b.setLoadingTip(LoadingTip.LoadStatus.error);
            q(true);
        } else {
            this.f13091j.f11738b.setLoadingTip(LoadingTip.LoadStatus.finish);
            q(false);
        }
    }

    public void z() {
        this.f13091j.f11738b.setLoadingTip(LoadingTip.LoadStatus.finish);
    }
}
