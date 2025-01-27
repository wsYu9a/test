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
import com.martian.mibook.lib.account.adapter.TXSHistoryCommissionRecordAdapter;
import com.martian.mibook.lib.account.request.auth.GetHistoryCommissionsParams;
import com.martian.mibook.lib.account.response.TYCommissionList;
import java.util.ArrayList;
import kb.j;
import l9.m0;
import x8.c;

/* loaded from: classes3.dex */
public class TXSCommissionRecordListFragment extends StrFragment implements s9.a {

    /* renamed from: k */
    public int f13976k = 0;

    /* renamed from: l */
    public TXSHistoryCommissionRecordAdapter f13977l;

    /* renamed from: m */
    public FragmentStrBinding f13978m;

    public class a extends j {
        public a(Activity activity) {
            super(activity);
        }

        @Override // jb.k
        public void s(c cVar) {
            TXSCommissionRecordListFragment.this.R(cVar);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            if (z10) {
                TXSCommissionRecordListFragment tXSCommissionRecordListFragment = TXSCommissionRecordListFragment.this;
                tXSCommissionRecordListFragment.T(tXSCommissionRecordListFragment.getString(R.string.loading));
            }
        }

        @Override // y8.a
        /* renamed from: v */
        public void onDataReceived(TYCommissionList tYCommissionList) {
            TXSCommissionRecordListFragment.this.Q(tYCommissionList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void P() {
        if (r()) {
            a aVar = new a(j());
            ((GetHistoryCommissionsParams) aVar.k()).setPage(Integer.valueOf(this.f13976k));
            aVar.j();
        }
    }

    public void R(c cVar) {
        H();
        S(cVar, true);
    }

    @Override // com.martian.libmars.fragment.StrFragment
    public void A() {
        if (m0.C(getActivity())) {
            this.f13977l.l().setRefresh(true);
            this.f13976k = 0;
            P();
        }
    }

    public final void Q(TYCommissionList tYCommissionList) {
        H();
        if (getActivity() == null) {
            return;
        }
        if (tYCommissionList == null || tYCommissionList.getCommissionList() == null || tYCommissionList.getCommissionList().isEmpty()) {
            S(new c(-1, "数据为空"), false);
            return;
        }
        y();
        if (this.f13977l.l().isRefresh()) {
            this.f13977l.a(tYCommissionList.getCommissionList());
        } else {
            this.f13977l.h(tYCommissionList.getCommissionList());
        }
        this.f13976k++;
    }

    public void S(c cVar, boolean z10) {
        TXSHistoryCommissionRecordAdapter tXSHistoryCommissionRecordAdapter = this.f13977l;
        if (tXSHistoryCommissionRecordAdapter == null || tXSHistoryCommissionRecordAdapter.getSize() <= 0) {
            if (z10) {
                x(cVar);
            } else {
                w(cVar.d());
            }
            this.f13978m.f12195b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
            return;
        }
        y();
        if (this.f13977l.getSize() < 10) {
            this.f13978m.f12195b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        } else {
            this.f13978m.f12195b.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
            this.f13978m.f12195b.setLoadMoreEndStatus("已全部加载");
        }
    }

    public void T(String str) {
        TXSHistoryCommissionRecordAdapter tXSHistoryCommissionRecordAdapter = this.f13977l;
        if (tXSHistoryCommissionRecordAdapter == null || tXSHistoryCommissionRecordAdapter.getSize() <= 0) {
            z(str);
        }
    }

    @Override // com.martian.libmars.fragment.LazyFragment
    public void m() {
    }

    @Override // s9.a
    public void onLoadMore(View view) {
        if (m0.C(getActivity())) {
            this.f13977l.l().setRefresh(this.f13977l.getSize() <= 0);
            this.f13978m.f12195b.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
            P();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentStrBinding a10 = FragmentStrBinding.a(t());
        this.f13978m = a10;
        a10.f12195b.setLayoutManager(new LinearLayoutManager(getActivity()));
        TXSHistoryCommissionRecordAdapter tXSHistoryCommissionRecordAdapter = new TXSHistoryCommissionRecordAdapter(getActivity(), new ArrayList());
        this.f13977l = tXSHistoryCommissionRecordAdapter;
        this.f13978m.f12195b.setAdapter(tXSHistoryCommissionRecordAdapter);
        this.f13978m.f12195b.setOnLoadMoreListener(this);
        this.f13978m.f12195b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        P();
    }

    @Override // com.martian.libmars.fragment.StrFragment
    public int u() {
        return R.layout.fragment_str;
    }
}
