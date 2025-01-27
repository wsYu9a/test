package com.martian.mibook.f;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.martian.libmars.widget.recyclerview.LoadMoreFooterView;
import com.martian.mibook.lib.account.request.auth.GetRechargeOrderListParams;
import com.martian.mibook.lib.account.response.MiRechargeOrderList;
import com.martian.ttbookhd.R;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class d4 extends com.martian.libmars.f.h implements com.martian.libmars.widget.recyclerview.f.a {

    /* renamed from: j */
    private int f13070j = 0;
    private com.martian.mibook.lib.account.adapter.h k;
    private com.martian.libmars.e.j l;

    class a extends com.martian.mibook.lib.account.d.q.r {
        a(com.martian.libmars.activity.j1 x0) {
            super(x0);
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            d4.this.x(errorResult);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            if (show) {
                d4 d4Var = d4.this;
                d4Var.z(d4Var.getString(R.string.loading));
            }
        }

        @Override // b.d.c.c.b
        /* renamed from: t */
        public void onDataReceived(MiRechargeOrderList miRechargeOrderList) {
            d4.this.w(miRechargeOrderList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void v() {
        if (f()) {
            a aVar = new a(a());
            ((GetRechargeOrderListParams) aVar.k()).setPage(Integer.valueOf(this.f13070j));
            aVar.j();
        }
    }

    public void w(MiRechargeOrderList miRechargeOrderList) {
        p();
        if (miRechargeOrderList == null || miRechargeOrderList.getRechargeOrders() == null || miRechargeOrderList.getRechargeOrders().isEmpty()) {
            y(new b.d.c.b.c(-1, "数据为空"), false);
            return;
        }
        k();
        this.l.f10009b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        if (this.k.E().isRefresh()) {
            this.k.a(miRechargeOrderList.getRechargeOrders());
        } else {
            this.k.m(miRechargeOrderList.getRechargeOrders());
        }
        this.f13070j++;
    }

    public void x(b.d.c.b.c errorResult) {
        p();
        y(errorResult, true);
    }

    @Override // com.martian.libmars.f.e
    protected void c() {
    }

    @Override // com.martian.libmars.f.h
    public int h() {
        return R.layout.fragment_str;
    }

    @Override // com.martian.libmars.f.h
    public void m() {
        if (com.martian.libmars.utils.n0.C(this.f10082a)) {
            this.k.E().setRefresh(true);
            this.f13070j = 0;
            v();
        }
    }

    @Override // com.martian.libmars.widget.recyclerview.f.a
    public void onLoadMore(View loadMoreView) {
        if (com.martian.libmars.utils.n0.C(this.f10082a)) {
            this.k.E().setRefresh(this.k.getSize() <= 0);
            this.l.f10009b.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
            v();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull final View baseView, Bundle savedInstanceState) {
        super.onViewCreated(baseView, savedInstanceState);
        com.martian.libmars.e.j a2 = com.martian.libmars.e.j.a(g());
        this.l = a2;
        a2.f10009b.setLayoutManager(new LinearLayoutManager(getContext()));
        com.martian.mibook.lib.account.adapter.h hVar = new com.martian.mibook.lib.account.adapter.h(this.f10082a, new ArrayList());
        this.k = hVar;
        this.l.f10009b.setAdapter(hVar);
        this.l.f10009b.setOnLoadMoreListener(this);
        this.l.f10009b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        v();
    }

    public void y(b.d.c.b.c errorResult, boolean isError) {
        com.martian.mibook.lib.account.adapter.h hVar = this.k;
        if (hVar == null || hVar.getSize() <= 0) {
            if (isError) {
                j(errorResult);
            } else {
                i(errorResult.d());
            }
            this.l.f10009b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
            return;
        }
        k();
        if (this.k.getSize() >= 10) {
            this.l.f10009b.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
        } else {
            this.l.f10009b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        }
    }

    public void z(String title) {
        com.martian.mibook.lib.account.adapter.h hVar = this.k;
        if (hVar == null || hVar.getSize() <= 0) {
            l(title);
        }
    }
}
