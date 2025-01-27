package com.martian.mibook.lib.account.c;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.martian.libmars.activity.j1;
import com.martian.libmars.e.j;
import com.martian.libmars.f.h;
import com.martian.libmars.utils.n0;
import com.martian.libmars.widget.recyclerview.LoadMoreFooterView;
import com.martian.mibook.lib.account.R;
import com.martian.mibook.lib.account.d.q.c0;
import com.martian.mibook.lib.account.request.auth.MartianGetWithdrawOrdersParams;
import com.martian.mibook.lib.account.response.MartianWithdrawOrderList;
import com.martian.rpauth.MartianRPUserManager;
import com.martian.rpauth.d.h;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class c extends h implements com.martian.libmars.widget.recyclerview.f.a {

    /* renamed from: j */
    public static String f13896j = "WITHDRAW_GUIDE_TO_RATE";
    private com.martian.mibook.lib.account.adapter.d l;
    private j n;
    private int k = 0;
    private boolean m = false;

    class a extends c0 {
        a(j1 activity) {
            super(activity);
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            c.this.y(errorResult);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            if (show) {
                c cVar = c.this;
                cVar.A(cVar.getString(R.string.loading));
            }
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(MartianWithdrawOrderList rpWithdrawOrderList) {
            c.this.x(rpWithdrawOrderList);
        }
    }

    class b implements h.c {

        /* renamed from: a */
        final /* synthetic */ j1 f13898a;

        b(final j1 val$activity) {
            this.f13898a = val$activity;
        }

        @Override // com.martian.rpauth.d.h.c
        public void a() {
            org.codechimp.apprater.b.m(new org.codechimp.apprater.e());
            org.codechimp.apprater.b.g(this.f13898a);
        }

        @Override // com.martian.rpauth.d.h.c
        public void b() {
        }
    }

    public static c w(int type, boolean rate) {
        c cVar = new c();
        Bundle bundle = new Bundle();
        bundle.putInt(MartianRPUserManager.X0, type);
        bundle.putBoolean(f13896j, rate);
        cVar.setArguments(bundle);
        return cVar;
    }

    public void x(MartianWithdrawOrderList rpWithdrawOrderList) {
        p();
        if (n0.C(this.f10082a)) {
            if (rpWithdrawOrderList == null || rpWithdrawOrderList.getWithdrawOrders() == null || rpWithdrawOrderList.getWithdrawOrders().isEmpty()) {
                z(new b.d.c.b.c(-1, "数据为空"), false);
                return;
            }
            k();
            if (this.m && C(rpWithdrawOrderList)) {
                B(a(), this.n.f10009b, "提现姿势这么帅", "给个好评呗~", "去好评");
                return;
            }
            if (this.l.E().isRefresh()) {
                this.l.a(rpWithdrawOrderList.getWithdrawOrders());
            } else {
                this.l.m(rpWithdrawOrderList.getWithdrawOrders());
            }
            this.k++;
        }
    }

    public void y(b.d.c.b.c errorResult) {
        d(errorResult.d() + "");
        p();
        z(errorResult, true);
    }

    public void A(String title) {
        com.martian.mibook.lib.account.adapter.d dVar = this.l;
        if (dVar == null || dVar.getSize() <= 0) {
            l(title);
        }
    }

    public void B(final j1 activity, final View parentview, final String hint1, final String hint2, final String op1) {
        if (!n0.C(this.f10082a) || parentview == null) {
            return;
        }
        try {
            com.martian.rpauth.d.h.g(activity, parentview, hint1, hint2, op1, new b(activity));
        } catch (Exception unused) {
        }
    }

    public boolean C(MartianWithdrawOrderList rpWithdrawOrderList) {
        return (rpWithdrawOrderList == null || rpWithdrawOrderList.getWithdrawOrders() == null || rpWithdrawOrderList.getWithdrawOrders().get(0) == null || rpWithdrawOrderList.getWithdrawOrders().get(0).getWostatus() != 2) ? false : true;
    }

    @Override // com.martian.libmars.f.e
    public j1 a() {
        return (j1) getActivity();
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
        if (n0.C(this.f10082a)) {
            this.l.E().setRefresh(true);
            this.k = 0;
            v();
        }
    }

    @Override // com.martian.libmars.widget.recyclerview.f.a
    public void onLoadMore(View loadMoreView) {
        if (n0.C(this.f10082a)) {
            this.l.E().setRefresh(this.l.getSize() <= 0);
            this.n.f10009b.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
            v();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull final View baseView, Bundle savedInstanceState) {
        super.onViewCreated(baseView, savedInstanceState);
        j a2 = j.a(g());
        this.n = a2;
        a2.f10009b.setLayoutManager(new LinearLayoutManager(getContext()));
        com.martian.mibook.lib.account.adapter.d dVar = new com.martian.mibook.lib.account.adapter.d(getContext(), new ArrayList());
        this.l = dVar;
        this.n.f10009b.setAdapter(dVar);
        this.n.f10009b.setOnLoadMoreListener(this);
        this.n.f10009b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.m = arguments.getBoolean(f13896j);
        }
        v();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void v() {
        if (f()) {
            a aVar = new a(a());
            ((MartianGetWithdrawOrdersParams) aVar.k()).setPage(Integer.valueOf(this.k));
            ((MartianGetWithdrawOrdersParams) aVar.k()).setType(-1);
            aVar.j();
        }
    }

    public void z(b.d.c.b.c errorResult, boolean isError) {
        com.martian.mibook.lib.account.adapter.d dVar = this.l;
        if (dVar == null || dVar.getSize() <= 0) {
            if (isError) {
                j(errorResult);
            } else {
                i(errorResult.d());
            }
            this.n.f10009b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
            return;
        }
        k();
        if (this.l.getSize() < 10) {
            this.n.f10009b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        } else {
            this.n.f10009b.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
            this.n.f10009b.setLoadMoreEndStatus("已全部加载");
        }
    }
}
