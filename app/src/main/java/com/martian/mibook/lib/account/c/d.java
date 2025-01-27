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
import com.martian.mibook.lib.account.adapter.f;
import com.martian.mibook.lib.account.d.q.o;
import com.martian.mibook.lib.account.request.auth.GetHistoryCommissionsParams;
import com.martian.mibook.lib.account.response.TYCommissionList;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class d extends h implements com.martian.libmars.widget.recyclerview.f.a {

    /* renamed from: j */
    private int f13900j = 0;
    private f k;
    private j l;

    class a extends o {
        a(j1 activity) {
            super(activity);
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            d.this.x(errorResult);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            if (show) {
                d dVar = d.this;
                dVar.z(dVar.getString(R.string.loading));
            }
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(TYCommissionList tyCommissionList) {
            d.this.w(tyCommissionList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void v() {
        if (f()) {
            a aVar = new a(this.f10082a);
            ((GetHistoryCommissionsParams) aVar.k()).setPage(Integer.valueOf(this.f13900j));
            aVar.j();
        }
    }

    public void w(TYCommissionList tyCommissionList) {
        p();
        if (n0.C(this.f10082a)) {
            if (tyCommissionList == null || tyCommissionList.getCommissionList() == null || tyCommissionList.getCommissionList().isEmpty()) {
                y(new b.d.c.b.c(-1, "数据为空"), false);
                return;
            }
            k();
            if (this.k.E().isRefresh()) {
                this.k.a(tyCommissionList.getCommissionList());
            } else {
                this.k.m(tyCommissionList.getCommissionList());
            }
            this.f13900j++;
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
            this.f13900j = 0;
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
        f fVar = new f(getContext(), new ArrayList());
        this.k = fVar;
        this.l.f10009b.setAdapter(fVar);
        this.l.f10009b.setOnLoadMoreListener(this);
        this.l.f10009b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        v();
    }

    public void y(b.d.c.b.c errorResult, boolean isError) {
        f fVar = this.k;
        if (fVar == null || fVar.getSize() <= 0) {
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
        f fVar = this.k;
        if (fVar == null || fVar.getSize() <= 0) {
            l(title);
        }
    }
}
