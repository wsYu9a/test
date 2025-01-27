package com.martian.mibook.f;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.martian.libmars.widget.recyclerview.IRecyclerView;
import com.martian.libmars.widget.recyclerview.LoadMoreFooterView;
import com.martian.mibook.lib.account.request.auth.InviterDurationRankParams;
import com.martian.mibook.lib.account.response.TYInviteeList;
import com.martian.ttbookhd.R;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class w3 extends com.martian.libmars.f.h implements com.martian.libmars.widget.recyclerview.f.a {

    /* renamed from: j */
    private int f13333j = 0;
    private com.martian.mibook.ui.o.c4 k;
    private IRecyclerView l;

    class a extends com.martian.mibook.lib.account.d.q.z {
        a(com.martian.libmars.activity.j1 x0) {
            super(x0);
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            w3.this.x(errorResult);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            if (show) {
                w3 w3Var = w3.this;
                w3Var.z(w3Var.getString(R.string.loading));
            }
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(TYInviteeList tyInviteeList) {
            w3.this.w(tyInviteeList);
        }
    }

    public void w(TYInviteeList tyInviteeList) {
        p();
        if (tyInviteeList == null || tyInviteeList.getInvitees() == null || tyInviteeList.getInvitees().size() <= 0) {
            y(new b.d.c.b.c(-1, "数据为空"));
            return;
        }
        k();
        if (this.k.E().isRefresh()) {
            this.k.a(tyInviteeList.getInvitees());
        } else {
            this.k.m(tyInviteeList.getInvitees());
        }
        this.f13333j++;
    }

    public void x(b.d.c.b.c errorResult) {
        p();
        y(errorResult);
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
            this.k.E().setRefresh(true);
            this.f13333j = 0;
            v();
        }
    }

    @Override // com.martian.libmars.widget.recyclerview.f.a
    public void onLoadMore(View loadMoreView) {
        if (com.martian.libmars.utils.n0.C(this.f10082a)) {
            this.k.E().setRefresh(this.k.getSize() <= 0);
            this.l.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
            v();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull final View baseView, Bundle savedInstanceState) {
        super.onViewCreated(baseView, savedInstanceState);
        IRecyclerView iRecyclerView = (IRecyclerView) g().findViewById(R.id.str_irc);
        this.l = iRecyclerView;
        iRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        com.martian.mibook.ui.o.c4 c4Var = new com.martian.mibook.ui.o.c4(this.f10082a, new ArrayList());
        this.k = c4Var;
        this.l.setAdapter(c4Var);
        this.l.setOnLoadMoreListener(this);
        this.l.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        v();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void v() {
        a aVar = new a(a());
        ((InviterDurationRankParams) aVar.k()).setPage(Integer.valueOf(this.f13333j));
        aVar.j();
    }

    public void y(b.d.c.b.c errorResult) {
        com.martian.mibook.ui.o.c4 c4Var = this.k;
        if (c4Var == null || c4Var.getSize() <= 0) {
            j(errorResult);
            this.l.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
            return;
        }
        k();
        if (this.k.getSize() >= 10) {
            this.l.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
        } else {
            this.l.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        }
    }

    public void z(String title) {
        com.martian.mibook.ui.o.c4 c4Var = this.k;
        if (c4Var == null || c4Var.getSize() <= 0) {
            l(title);
        }
    }
}
