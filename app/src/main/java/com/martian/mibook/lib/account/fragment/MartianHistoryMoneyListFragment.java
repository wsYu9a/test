package com.martian.mibook.lib.account.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.martian.libmars.R;
import com.martian.libmars.databinding.FragmentStrBinding;
import com.martian.libmars.fragment.StrFragment;
import com.martian.libmars.widget.recyclerview.LoadMoreFooterView;
import com.martian.mibook.lib.account.adapter.MartianMoneyIncomeListAdapter;
import com.martian.mibook.lib.account.request.auth.MartianGetHistoryMoneyParams;
import com.martian.mibook.lib.account.response.HistoryMoneyList;
import java.util.ArrayList;
import kb.t;
import l9.m0;
import x8.c;

/* loaded from: classes3.dex */
public class MartianHistoryMoneyListFragment extends StrFragment implements s9.a {

    /* renamed from: k */
    public int f13964k = 0;

    /* renamed from: l */
    public MartianMoneyIncomeListAdapter f13965l;

    /* renamed from: m */
    public FragmentStrBinding f13966m;

    public class a extends t {
        public a(Activity activity) {
            super(activity);
        }

        @Override // jb.k
        public void s(c cVar) {
            MartianHistoryMoneyListFragment.this.R(cVar);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            if (z10) {
                MartianHistoryMoneyListFragment martianHistoryMoneyListFragment = MartianHistoryMoneyListFragment.this;
                martianHistoryMoneyListFragment.T(martianHistoryMoneyListFragment.getString(R.string.loading));
            }
        }

        @Override // y8.a
        /* renamed from: v */
        public void onDataReceived(HistoryMoneyList historyMoneyList) {
            MartianHistoryMoneyListFragment.this.Q(historyMoneyList);
        }
    }

    public void R(c cVar) {
        H();
        S(cVar, true);
    }

    @Override // com.martian.libmars.fragment.StrFragment
    public void A() {
        if (m0.C(getActivity())) {
            this.f13965l.l().setRefresh(true);
            this.f13964k = 0;
            P();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void P() {
        if (r()) {
            a aVar = new a(j());
            ((MartianGetHistoryMoneyParams) aVar.k()).setPage(Integer.valueOf(this.f13964k));
            aVar.j();
        }
    }

    public final void Q(HistoryMoneyList historyMoneyList) {
        H();
        if (getActivity() == null) {
            return;
        }
        if (historyMoneyList == null || historyMoneyList.getHistoryMoneyList() == null || historyMoneyList.getHistoryMoneyList().isEmpty()) {
            S(new c(-1, "数据为空"), false);
            return;
        }
        y();
        if (this.f13965l.l().isRefresh()) {
            this.f13965l.a(historyMoneyList.getHistoryMoneyList());
        } else {
            this.f13965l.h(historyMoneyList.getHistoryMoneyList());
        }
        this.f13964k++;
    }

    public void S(c cVar, boolean z10) {
        MartianMoneyIncomeListAdapter martianMoneyIncomeListAdapter = this.f13965l;
        if (martianMoneyIncomeListAdapter == null || martianMoneyIncomeListAdapter.getSize() <= 0) {
            if (z10) {
                x(cVar);
            } else {
                w(cVar.d());
            }
            this.f13966m.f12195b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
            return;
        }
        y();
        if (this.f13965l.getSize() < 10) {
            this.f13966m.f12195b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        } else {
            this.f13966m.f12195b.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
            this.f13966m.f12195b.setLoadMoreEndStatus("已全部加载");
        }
    }

    public void T(String str) {
        MartianMoneyIncomeListAdapter martianMoneyIncomeListAdapter = this.f13965l;
        if (martianMoneyIncomeListAdapter == null || martianMoneyIncomeListAdapter.getSize() <= 0) {
            z(str);
        }
    }

    @Override // com.martian.libmars.fragment.LazyFragment
    public void m() {
    }

    @Override // s9.a
    public void onLoadMore(View view) {
        if (m0.C(getActivity())) {
            this.f13965l.l().setRefresh(this.f13965l.getSize() <= 0);
            this.f13966m.f12195b.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
            P();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentStrBinding a10 = FragmentStrBinding.a(t());
        this.f13966m = a10;
        a10.f12195b.setLayoutManager(new LinearLayoutManager(getActivity()));
        MartianMoneyIncomeListAdapter martianMoneyIncomeListAdapter = new MartianMoneyIncomeListAdapter(getActivity(), new ArrayList());
        this.f13965l = martianMoneyIncomeListAdapter;
        this.f13966m.f12195b.setAdapter(martianMoneyIncomeListAdapter);
        this.f13966m.f12195b.setOnLoadMoreListener(this);
        this.f13966m.f12195b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        P();
    }

    @Override // com.martian.libmars.fragment.StrFragment
    public int u() {
        return R.layout.fragment_str;
    }
}
