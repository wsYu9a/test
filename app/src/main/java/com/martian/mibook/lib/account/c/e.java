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
import com.martian.mibook.lib.account.adapter.i;
import com.martian.mibook.lib.account.request.MartianGetWithdrawOrdersRankParams;
import com.martian.mibook.lib.account.response.WithdrawRankList;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class e extends h implements com.martian.libmars.widget.recyclerview.f.a {

    /* renamed from: j */
    private int f13902j = 0;
    private i k;
    private j l;

    class a extends com.martian.mibook.lib.account.d.e {
        a() {
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            e.this.x(errorResult);
        }

        @Override // b.d.c.c.b
        /* renamed from: q */
        public void onDataReceived(WithdrawRankList withdrawRankList) {
            e.this.w(withdrawRankList);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            if (show) {
                e eVar = e.this;
                eVar.z(eVar.getString(R.string.loading));
            }
        }
    }

    public void w(WithdrawRankList withdrawRankList) {
        p();
        if (n0.C(this.f10082a)) {
            if (withdrawRankList == null || withdrawRankList.getWithdrawRanks() == null || withdrawRankList.getWithdrawRanks().isEmpty()) {
                y(new b.d.c.b.c(-1, "数据为空"), false);
                return;
            }
            k();
            if (this.k.E().isRefresh()) {
                this.k.a(withdrawRankList.getWithdrawRanks());
            } else {
                this.k.m(withdrawRankList.getWithdrawRanks());
            }
            this.f13902j++;
        }
    }

    public void x(b.d.c.b.c errorResult) {
        p();
        y(errorResult, true);
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
            this.k.E().setRefresh(true);
            this.f13902j = 0;
            v();
        }
    }

    @Override // com.martian.libmars.widget.recyclerview.f.a
    public void onLoadMore(View loadMoreView) {
        if (n0.C(this.f10082a)) {
            this.k.E().setRefresh(this.k.getSize() <= 0);
            this.l.f10009b.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
            v();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull final View baseView, Bundle savedInstanceState) {
        super.onViewCreated(baseView, savedInstanceState);
        j a2 = j.a(g());
        this.l = a2;
        a2.f10009b.setLayoutManager(new LinearLayoutManager(getContext()));
        i iVar = new i(getContext(), new ArrayList());
        this.k = iVar;
        this.l.f10009b.setAdapter(iVar);
        this.l.f10009b.setOnLoadMoreListener(this);
        this.l.f10009b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        this.l.f10009b.setPadding(0, com.martian.libmars.d.h.b(6.0f), 0, 0);
        v();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void v() {
        if (f()) {
            a aVar = new a();
            ((MartianGetWithdrawOrdersRankParams) aVar.k()).setPage(Integer.valueOf(this.f13902j));
            ((MartianGetWithdrawOrdersRankParams) aVar.k()).setWithHeader(true);
            aVar.j();
        }
    }

    public void y(b.d.c.b.c errorResult, boolean isError) {
        i iVar = this.k;
        if (iVar == null || iVar.getSize() <= 0) {
            if (isError) {
                j(errorResult);
            } else {
                i(errorResult.d());
            }
            this.l.f10009b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
            return;
        }
        k();
        if (this.k.getSize() < 10) {
            this.l.f10009b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        } else {
            this.l.f10009b.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
            this.l.f10009b.setLoadMoreEndStatus("已全部加载");
        }
    }

    public void z(String title) {
        i iVar = this.k;
        if (iVar == null || iVar.getSize() <= 0) {
            l(title);
        }
    }
}
