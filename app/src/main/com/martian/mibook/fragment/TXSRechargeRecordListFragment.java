package com.martian.mibook.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.martian.libmars.R;
import com.martian.libmars.databinding.FragmentStrBinding;
import com.martian.libmars.fragment.StrFragment;
import com.martian.libmars.widget.recyclerview.LoadMoreFooterView;
import com.martian.mibook.lib.account.adapter.TXSRechargeRecordAdapter;
import com.martian.mibook.lib.account.request.auth.GetRechargeOrderListParams;
import com.martian.mibook.lib.account.response.MiRechargeOrderList;
import java.util.ArrayList;
import kb.m;
import l9.m0;
import x8.c;

/* loaded from: classes3.dex */
public class TXSRechargeRecordListFragment extends StrFragment implements s9.a {

    /* renamed from: k */
    public int f13693k = 0;

    /* renamed from: l */
    public TXSRechargeRecordAdapter f13694l;

    /* renamed from: m */
    public FragmentStrBinding f13695m;

    public class a extends m {
        public a(Activity activity) {
            super(activity);
        }

        @Override // jb.k
        public void s(c cVar) {
            TXSRechargeRecordListFragment.this.R(cVar);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            if (z10) {
                TXSRechargeRecordListFragment tXSRechargeRecordListFragment = TXSRechargeRecordListFragment.this;
                tXSRechargeRecordListFragment.T(tXSRechargeRecordListFragment.getString(R.string.loading));
            }
        }

        @Override // y8.a
        /* renamed from: u */
        public void onDataReceived(MiRechargeOrderList miRechargeOrderList) {
            TXSRechargeRecordListFragment.this.Q(miRechargeOrderList);
        }
    }

    public void R(c cVar) {
        H();
        S(cVar, true);
    }

    @Override // com.martian.libmars.fragment.StrFragment
    public void A() {
        if (m0.C(this.f12349c)) {
            this.f13694l.l().setRefresh(true);
            this.f13693k = 0;
            P();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void P() {
        if (r()) {
            a aVar = new a(j());
            ((GetRechargeOrderListParams) aVar.k()).setPage(Integer.valueOf(this.f13693k));
            aVar.j();
        }
    }

    public final void Q(MiRechargeOrderList miRechargeOrderList) {
        H();
        if (miRechargeOrderList == null || miRechargeOrderList.getRechargeOrders() == null || miRechargeOrderList.getRechargeOrders().isEmpty()) {
            S(new c(-1, "数据为空"), false);
            return;
        }
        y();
        this.f13695m.f12195b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        if (this.f13694l.l().isRefresh()) {
            this.f13694l.a(miRechargeOrderList.getRechargeOrders());
        } else {
            this.f13694l.h(miRechargeOrderList.getRechargeOrders());
        }
        this.f13693k++;
    }

    public void S(c cVar, boolean z10) {
        TXSRechargeRecordAdapter tXSRechargeRecordAdapter = this.f13694l;
        if (tXSRechargeRecordAdapter == null || tXSRechargeRecordAdapter.getSize() <= 0) {
            if (z10) {
                x(cVar);
            } else {
                w(cVar.d());
            }
            this.f13695m.f12195b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
            return;
        }
        y();
        if (this.f13694l.getSize() >= 10) {
            this.f13695m.f12195b.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
        } else {
            this.f13695m.f12195b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        }
    }

    public void T(String str) {
        TXSRechargeRecordAdapter tXSRechargeRecordAdapter = this.f13694l;
        if (tXSRechargeRecordAdapter == null || tXSRechargeRecordAdapter.getSize() <= 0) {
            z(str);
        }
    }

    @Override // com.martian.libmars.fragment.LazyFragment
    public void m() {
    }

    @Override // s9.a
    public void onLoadMore(View view) {
        if (m0.C(this.f12349c)) {
            this.f13694l.l().setRefresh(this.f13694l.getSize() <= 0);
            this.f13695m.f12195b.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
            P();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentStrBinding a10 = FragmentStrBinding.a(t());
        this.f13695m = a10;
        a10.f12195b.setLayoutManager(new LinearLayoutManager(getActivity()));
        TXSRechargeRecordAdapter tXSRechargeRecordAdapter = new TXSRechargeRecordAdapter(this.f12349c, new ArrayList());
        this.f13694l = tXSRechargeRecordAdapter;
        this.f13695m.f12195b.setAdapter(tXSRechargeRecordAdapter);
        this.f13695m.f12195b.setOnLoadMoreListener(this);
        this.f13695m.f12195b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        P();
    }

    @Override // com.martian.libmars.fragment.StrFragment
    public int u() {
        return R.layout.fragment_str;
    }
}
