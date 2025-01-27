package com.martian.mibook.f;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.martian.libmars.widget.recyclerview.LoadMoreFooterView;
import com.martian.mibook.lib.account.request.auth.GetTxsCoinsRecordListParams;
import com.martian.mibook.lib.account.response.MiHistoryBookCoinsList;
import com.martian.ttbookhd.R;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class c4 extends com.martian.libmars.f.h implements com.martian.libmars.widget.recyclerview.f.a {

    /* renamed from: j */
    private com.martian.libmars.e.j f13063j;
    private int k = 0;
    private com.martian.mibook.lib.account.adapter.e l;

    class a extends com.martian.mibook.lib.account.d.q.s {
        a(com.martian.libmars.activity.j1 x0) {
            super(x0);
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            c4.this.x(errorResult);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            if (show) {
                c4 c4Var = c4.this;
                c4Var.z(c4Var.getString(R.string.loading));
            }
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(MiHistoryBookCoinsList miHistoryBookCoinsList) {
            c4.this.w(miHistoryBookCoinsList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void v() {
        if (f()) {
            a aVar = new a(a());
            ((GetTxsCoinsRecordListParams) aVar.k()).setPage(Integer.valueOf(this.k));
            aVar.j();
        }
    }

    public void w(MiHistoryBookCoinsList miHistoryBookCoinsList) {
        if (com.martian.libmars.utils.n0.c(this.f10082a)) {
            return;
        }
        p();
        if (miHistoryBookCoinsList == null || miHistoryBookCoinsList.getHistoryBookCoinsList() == null || miHistoryBookCoinsList.getHistoryBookCoinsList().isEmpty()) {
            y(new b.d.c.b.c(-1, "数据为空"), false);
            return;
        }
        k();
        if (this.l.E().isRefresh()) {
            this.l.a(miHistoryBookCoinsList.getHistoryBookCoinsList());
        } else {
            this.l.m(miHistoryBookCoinsList.getHistoryBookCoinsList());
        }
        this.k++;
    }

    public void x(b.d.c.b.c errorResult) {
        if (com.martian.libmars.utils.n0.c(this.f10082a)) {
            return;
        }
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
            this.l.E().setRefresh(true);
            this.k = 0;
            v();
        }
    }

    @Override // com.martian.libmars.widget.recyclerview.f.a
    public void onLoadMore(View loadMoreView) {
        if (com.martian.libmars.utils.n0.C(this.f10082a)) {
            this.l.E().setRefresh(this.l.getSize() <= 0);
            this.f13063j.f10009b.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
            v();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull final View baseView, Bundle savedInstanceState) {
        super.onViewCreated(baseView, savedInstanceState);
        com.martian.libmars.e.j a2 = com.martian.libmars.e.j.a(g());
        this.f13063j = a2;
        a2.f10009b.setLayoutManager(new LinearLayoutManager(getContext()));
        com.martian.mibook.lib.account.adapter.e eVar = new com.martian.mibook.lib.account.adapter.e(this.f10082a, new ArrayList());
        this.l = eVar;
        this.f13063j.f10009b.setAdapter(eVar);
        this.f13063j.f10009b.setOnLoadMoreListener(this);
        this.f13063j.f10009b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        v();
    }

    public void y(b.d.c.b.c errorResult, boolean isError) {
        com.martian.mibook.lib.account.adapter.e eVar = this.l;
        if (eVar == null || eVar.getSize() <= 0) {
            if (isError) {
                j(errorResult);
            } else {
                i(errorResult.d());
            }
            this.f13063j.f10009b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
            return;
        }
        k();
        if (this.l.getSize() >= 10) {
            this.f13063j.f10009b.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
        } else {
            this.f13063j.f10009b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        }
    }

    public void z(String title) {
        com.martian.mibook.lib.account.adapter.e eVar = this.l;
        if (eVar == null || eVar.getSize() <= 0) {
            l(title);
        }
    }
}
