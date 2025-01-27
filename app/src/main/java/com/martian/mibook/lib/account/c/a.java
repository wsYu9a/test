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
import com.martian.mibook.lib.account.d.q.a0;
import com.martian.mibook.lib.account.request.auth.MartianGetHistoryDurationParams;
import com.martian.mibook.lib.account.response.HistoryDurationList;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class a extends h implements com.martian.libmars.widget.recyclerview.f.a {

    /* renamed from: j */
    private int f13892j = 0;
    private com.martian.mibook.lib.account.adapter.b k;
    private j l;

    /* renamed from: com.martian.mibook.lib.account.c.a$a */
    class C0271a extends a0 {
        C0271a(j1 activity) {
            super(activity);
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            a.this.x(errorResult);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            if (show) {
                a aVar = a.this;
                aVar.z(aVar.getString(R.string.loading));
            }
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(HistoryDurationList historyDepositList) {
            a.this.w(historyDepositList);
        }
    }

    public void w(HistoryDurationList historyDurationList) {
        p();
        if (n0.C(this.f10082a)) {
            if (historyDurationList == null || historyDurationList.getDurationList() == null || historyDurationList.getDurationList().isEmpty()) {
                y(new b.d.c.b.c(-1, "数据为空"), false);
                return;
            }
            k();
            if (this.k.E().isRefresh()) {
                this.k.a(historyDurationList.getDurationList());
            } else {
                this.k.m(historyDurationList.getDurationList());
            }
            this.f13892j++;
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
            this.f13892j = 0;
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
        com.martian.mibook.lib.account.adapter.b bVar = new com.martian.mibook.lib.account.adapter.b(getContext(), new ArrayList());
        this.k = bVar;
        this.l.f10009b.setAdapter(bVar);
        this.l.f10009b.setOnLoadMoreListener(this);
        this.l.f10009b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        v();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void v() {
        if (f()) {
            C0271a c0271a = new C0271a(a());
            ((MartianGetHistoryDurationParams) c0271a.k()).setPage(Integer.valueOf(this.f13892j));
            c0271a.j();
        }
    }

    public void y(b.d.c.b.c errorResult, boolean isError) {
        com.martian.mibook.lib.account.adapter.b bVar = this.k;
        if (bVar == null || bVar.getSize() <= 0) {
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
            this.l.f10009b.setLoadMoreEndStatus("仅保留7天内明细");
        }
    }

    public void z(String title) {
        com.martian.mibook.lib.account.adapter.b bVar = this.k;
        if (bVar == null || bVar.getSize() <= 0) {
            l(title);
        }
    }
}
