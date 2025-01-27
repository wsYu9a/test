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
import com.martian.mibook.lib.account.adapter.TXSHistoryBookCoinsRecordAdapter;
import com.martian.mibook.lib.account.request.auth.GetTxsCoinsRecordListParams;
import com.martian.mibook.lib.account.response.MiHistoryBookCoinsList;
import java.util.ArrayList;
import kb.n;
import l9.m0;
import x8.c;

/* loaded from: classes3.dex */
public class TXSCoinsRecordListFragment extends StrFragment implements s9.a {

    /* renamed from: k */
    public FragmentStrBinding f13689k;

    /* renamed from: l */
    public int f13690l = 0;

    /* renamed from: m */
    public TXSHistoryBookCoinsRecordAdapter f13691m;

    public class a extends n {
        public a(Activity activity) {
            super(activity);
        }

        @Override // jb.k
        public void s(c cVar) {
            TXSCoinsRecordListFragment.this.R(cVar);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            if (z10) {
                TXSCoinsRecordListFragment tXSCoinsRecordListFragment = TXSCoinsRecordListFragment.this;
                tXSCoinsRecordListFragment.T(tXSCoinsRecordListFragment.getString(R.string.loading));
            }
        }

        @Override // y8.a
        /* renamed from: v */
        public void onDataReceived(MiHistoryBookCoinsList miHistoryBookCoinsList) {
            TXSCoinsRecordListFragment.this.Q(miHistoryBookCoinsList);
        }
    }

    public void R(c cVar) {
        if (m0.c(this.f12349c)) {
            return;
        }
        H();
        S(cVar, true);
    }

    @Override // com.martian.libmars.fragment.StrFragment
    public void A() {
        if (m0.C(this.f12349c)) {
            this.f13691m.l().setRefresh(true);
            this.f13690l = 0;
            P();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void P() {
        if (r()) {
            a aVar = new a(j());
            ((GetTxsCoinsRecordListParams) aVar.k()).setPage(Integer.valueOf(this.f13690l));
            aVar.j();
        }
    }

    public final void Q(MiHistoryBookCoinsList miHistoryBookCoinsList) {
        if (m0.c(this.f12349c)) {
            return;
        }
        H();
        if (miHistoryBookCoinsList == null || miHistoryBookCoinsList.getHistoryBookCoinsList() == null || miHistoryBookCoinsList.getHistoryBookCoinsList().isEmpty()) {
            S(new c(-1, "数据为空"), false);
            return;
        }
        y();
        if (this.f13691m.l().isRefresh()) {
            this.f13691m.a(miHistoryBookCoinsList.getHistoryBookCoinsList());
        } else {
            this.f13691m.h(miHistoryBookCoinsList.getHistoryBookCoinsList());
        }
        this.f13690l++;
    }

    public void S(c cVar, boolean z10) {
        TXSHistoryBookCoinsRecordAdapter tXSHistoryBookCoinsRecordAdapter = this.f13691m;
        if (tXSHistoryBookCoinsRecordAdapter == null || tXSHistoryBookCoinsRecordAdapter.getSize() <= 0) {
            if (z10) {
                x(cVar);
            } else {
                w(cVar.d());
            }
            this.f13689k.f12195b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
            return;
        }
        y();
        if (this.f13691m.getSize() >= 10) {
            this.f13689k.f12195b.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
        } else {
            this.f13689k.f12195b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        }
    }

    public void T(String str) {
        TXSHistoryBookCoinsRecordAdapter tXSHistoryBookCoinsRecordAdapter = this.f13691m;
        if (tXSHistoryBookCoinsRecordAdapter == null || tXSHistoryBookCoinsRecordAdapter.getSize() <= 0) {
            z(str);
        }
    }

    @Override // com.martian.libmars.fragment.LazyFragment
    public void m() {
    }

    @Override // s9.a
    public void onLoadMore(View view) {
        if (m0.C(this.f12349c)) {
            this.f13691m.l().setRefresh(this.f13691m.getSize() <= 0);
            this.f13689k.f12195b.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
            P();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentStrBinding a10 = FragmentStrBinding.a(t());
        this.f13689k = a10;
        a10.f12195b.setLayoutManager(new LinearLayoutManager(getActivity()));
        TXSHistoryBookCoinsRecordAdapter tXSHistoryBookCoinsRecordAdapter = new TXSHistoryBookCoinsRecordAdapter(this.f12349c, new ArrayList());
        this.f13691m = tXSHistoryBookCoinsRecordAdapter;
        this.f13689k.f12195b.setAdapter(tXSHistoryBookCoinsRecordAdapter);
        this.f13689k.f12195b.setOnLoadMoreListener(this);
        this.f13689k.f12195b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        P();
    }

    @Override // com.martian.libmars.fragment.StrFragment
    public int u() {
        return R.layout.fragment_str;
    }
}
