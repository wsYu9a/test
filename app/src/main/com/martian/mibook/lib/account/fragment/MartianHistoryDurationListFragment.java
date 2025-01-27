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
import com.martian.mibook.lib.account.adapter.MartianDurationIncomeListAdapter;
import com.martian.mibook.lib.account.request.auth.MartianGetHistoryDurationParams;
import com.martian.mibook.lib.account.response.HistoryDurationList;
import java.util.ArrayList;
import kb.s;
import l9.m0;
import x8.c;

/* loaded from: classes3.dex */
public class MartianHistoryDurationListFragment extends StrFragment implements s9.a {

    /* renamed from: k */
    public int f13960k = 0;

    /* renamed from: l */
    public MartianDurationIncomeListAdapter f13961l;

    /* renamed from: m */
    public FragmentStrBinding f13962m;

    public class a extends s {
        public a(Activity activity) {
            super(activity);
        }

        @Override // jb.k
        public void s(c cVar) {
            MartianHistoryDurationListFragment.this.R(cVar);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            if (z10) {
                MartianHistoryDurationListFragment martianHistoryDurationListFragment = MartianHistoryDurationListFragment.this;
                martianHistoryDurationListFragment.T(martianHistoryDurationListFragment.getString(R.string.loading));
            }
        }

        @Override // y8.a
        /* renamed from: v */
        public void onDataReceived(HistoryDurationList historyDurationList) {
            MartianHistoryDurationListFragment.this.Q(historyDurationList);
        }
    }

    public void R(c cVar) {
        H();
        S(cVar, true);
    }

    @Override // com.martian.libmars.fragment.StrFragment
    public void A() {
        if (m0.C(getActivity())) {
            this.f13961l.l().setRefresh(true);
            this.f13960k = 0;
            P();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void P() {
        if (r()) {
            a aVar = new a(j());
            ((MartianGetHistoryDurationParams) aVar.k()).setPage(Integer.valueOf(this.f13960k));
            aVar.j();
        }
    }

    public final void Q(HistoryDurationList historyDurationList) {
        H();
        if (getActivity() == null) {
            return;
        }
        if (historyDurationList == null || historyDurationList.getDurationList() == null || historyDurationList.getDurationList().isEmpty()) {
            S(new c(-1, "数据为空"), false);
            return;
        }
        y();
        if (this.f13961l.l().isRefresh()) {
            this.f13961l.a(historyDurationList.getDurationList());
        } else {
            this.f13961l.h(historyDurationList.getDurationList());
        }
        this.f13960k++;
    }

    public void S(c cVar, boolean z10) {
        MartianDurationIncomeListAdapter martianDurationIncomeListAdapter = this.f13961l;
        if (martianDurationIncomeListAdapter == null || martianDurationIncomeListAdapter.getSize() <= 0) {
            if (z10) {
                x(cVar);
            } else {
                w(cVar.d());
            }
            this.f13962m.f12195b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
            return;
        }
        y();
        if (this.f13961l.getSize() < 10) {
            this.f13962m.f12195b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        } else {
            this.f13962m.f12195b.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
            this.f13962m.f12195b.setLoadMoreEndStatus("仅保留7天内明细");
        }
    }

    public void T(String str) {
        MartianDurationIncomeListAdapter martianDurationIncomeListAdapter = this.f13961l;
        if (martianDurationIncomeListAdapter == null || martianDurationIncomeListAdapter.getSize() <= 0) {
            z(str);
        }
    }

    @Override // com.martian.libmars.fragment.LazyFragment
    public void m() {
    }

    @Override // s9.a
    public void onLoadMore(View view) {
        if (m0.C(getActivity())) {
            this.f13961l.l().setRefresh(this.f13961l.getSize() <= 0);
            this.f13962m.f12195b.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
            P();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentStrBinding a10 = FragmentStrBinding.a(t());
        this.f13962m = a10;
        a10.f12195b.setLayoutManager(new LinearLayoutManager(getActivity()));
        MartianDurationIncomeListAdapter martianDurationIncomeListAdapter = new MartianDurationIncomeListAdapter(getActivity(), new ArrayList());
        this.f13961l = martianDurationIncomeListAdapter;
        this.f13962m.f12195b.setAdapter(martianDurationIncomeListAdapter);
        this.f13962m.f12195b.setOnLoadMoreListener(this);
        this.f13962m.f12195b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        P();
    }

    @Override // com.martian.libmars.fragment.StrFragment
    public int u() {
        return R.layout.fragment_str;
    }
}
