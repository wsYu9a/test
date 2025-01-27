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
import com.martian.mibook.lib.account.d.q.b0;
import com.martian.mibook.lib.account.request.auth.MartianGetHistoryMoneyParams;
import com.martian.mibook.lib.account.response.HistoryMoneyList;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class b extends h implements com.martian.libmars.widget.recyclerview.f.a {

    /* renamed from: j */
    private int f13894j = 0;
    private com.martian.mibook.lib.account.adapter.c k;
    private j l;

    class a extends b0 {
        a(j1 activity) {
            super(activity);
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            b.this.x(errorResult);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            if (show) {
                b bVar = b.this;
                bVar.z(bVar.getString(R.string.loading));
            }
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(HistoryMoneyList historyMoneyList) {
            b.this.w(historyMoneyList);
        }
    }

    public void w(HistoryMoneyList historyMoneyList) {
        p();
        if (n0.C(this.f10082a)) {
            if (historyMoneyList == null || historyMoneyList.getHistoryMoneyList() == null || historyMoneyList.getHistoryMoneyList().isEmpty()) {
                y(new b.d.c.b.c(-1, "数据为空"), false);
                return;
            }
            k();
            if (this.k.E().isRefresh()) {
                this.k.a(historyMoneyList.getHistoryMoneyList());
            } else {
                this.k.m(historyMoneyList.getHistoryMoneyList());
            }
            this.f13894j++;
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
            this.f13894j = 0;
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
        com.martian.mibook.lib.account.adapter.c cVar = new com.martian.mibook.lib.account.adapter.c(getContext(), new ArrayList());
        this.k = cVar;
        this.l.f10009b.setAdapter(cVar);
        this.l.f10009b.setOnLoadMoreListener(this);
        this.l.f10009b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        v();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void v() {
        if (f()) {
            a aVar = new a(a());
            ((MartianGetHistoryMoneyParams) aVar.k()).setPage(Integer.valueOf(this.f13894j));
            aVar.j();
        }
    }

    public void y(b.d.c.b.c errorResult, boolean isError) {
        com.martian.mibook.lib.account.adapter.c cVar = this.k;
        if (cVar == null || cVar.getSize() <= 0) {
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
        com.martian.mibook.lib.account.adapter.c cVar = this.k;
        if (cVar == null || cVar.getSize() <= 0) {
            l(title);
        }
    }
}
