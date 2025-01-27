package com.martian.mibook.f.e4;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import b.d.c.b.c;
import com.martian.libmars.e.j;
import com.martian.libmars.f.h;
import com.martian.libmars.utils.n0;
import com.martian.libmars.widget.recyclerview.LoadMoreFooterView;
import com.martian.mibook.lib.model.data.TYSearchBookList;
import com.martian.mibook.lib.original.request.CPORBooksListParams;
import com.martian.mibook.ui.o.n4;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public class a extends h implements com.martian.libmars.widget.recyclerview.f.a {

    /* renamed from: j */
    private int f13079j = 0;
    private n4 k;
    private j l;
    private int m;

    /* renamed from: com.martian.mibook.f.e4.a$a */
    class C0264a extends com.martian.mibook.lib.original.e.a {
        C0264a() {
        }

        @Override // b.d.c.c.b
        public void onResultError(c errorResult) {
            a.this.x(errorResult);
        }

        @Override // b.d.c.c.b
        /* renamed from: q */
        public void onDataReceived(TYSearchBookList cpBooksList) {
            a.this.w(cpBooksList);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            if (show) {
                a aVar = a.this;
                aVar.z(aVar.getString(R.string.loading));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void v() {
        if (f()) {
            C0264a c0264a = new C0264a();
            ((CPORBooksListParams) c0264a.k()).setPage(this.f13079j);
            ((CPORBooksListParams) c0264a.k()).setCtype(this.m);
            c0264a.j();
        }
    }

    public void w(TYSearchBookList cpBooksList) {
        if (n0.c(this.f10082a)) {
            return;
        }
        p();
        if (cpBooksList == null || cpBooksList.getBookItemList() == null || cpBooksList.getBookItemList().size() <= 0) {
            y(new c(-1, "数据为空"), false);
            return;
        }
        k();
        if (this.k.E().isRefresh()) {
            this.k.a(cpBooksList.getBookItemList());
            this.k.Q(this.l.f10009b);
        } else {
            this.k.m(cpBooksList.getBookItemList());
        }
        this.f13079j++;
    }

    public void x(c errorResult) {
        if (n0.c(this.f10082a)) {
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
        if (n0.C(this.f10082a)) {
            this.k.E().setRefresh(true);
            this.f13079j = 0;
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
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("book_rank_ctype", this.m);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull final View baseView, Bundle savedInstanceState) {
        super.onViewCreated(baseView, savedInstanceState);
        if (savedInstanceState != null) {
            this.m = savedInstanceState.getInt("book_rank_ctype");
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.m = arguments.getInt("book_rank_ctype");
            }
        }
        j a2 = j.a(g());
        this.l = a2;
        a2.f10009b.setLayoutManager(new LinearLayoutManager(getContext()));
        n4 n4Var = new n4(this.f10082a);
        this.k = n4Var;
        this.l.f10009b.setAdapter(n4Var);
        this.l.f10009b.setOnLoadMoreListener(this);
        this.l.f10009b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        v();
    }

    public void y(c errorResult, boolean isError) {
        n4 n4Var = this.k;
        if (n4Var == null || n4Var.getSize() <= 0) {
            if (isError) {
                j(errorResult);
            } else {
                i(errorResult.d());
            }
            this.l.f10009b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
            return;
        }
        k();
        if (this.k.getSize() >= 10) {
            this.l.f10009b.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
        } else {
            this.l.f10009b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        }
    }

    public void z(String title) {
        n4 n4Var = this.k;
        if (n4Var == null || n4Var.getSize() <= 0) {
            l(title);
        }
    }
}
