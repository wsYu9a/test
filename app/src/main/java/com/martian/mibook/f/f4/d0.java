package com.martian.mibook.f.f4;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.utils.n0;
import com.martian.libmars.widget.recyclerview.LoadMoreFooterView;
import com.martian.mibook.lib.yuewen.request.YWFinishedBooksParams;
import com.martian.mibook.lib.yuewen.request.YWNewBooksParams;
import com.martian.mibook.lib.yuewen.response.YWChannelBookList;
import com.martian.mibook.ui.o.n4;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public class d0 extends com.martian.libmars.f.h implements com.martian.libmars.widget.recyclerview.f.a {

    /* renamed from: j */
    private static final String f13098j = "YW_BOOKS_LIST_INFO";
    private c k;
    private int l = 0;
    private n4 m;
    private com.martian.libmars.e.j n;

    class a extends com.martian.mibook.lib.yuewen.e.k {
        a() {
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            d0.this.A(errorResult);
        }

        @Override // b.d.c.c.b
        /* renamed from: q */
        public void onDataReceived(YWChannelBookList ywChannelBookList) {
            d0.this.z(ywChannelBookList);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            if (show) {
                d0 d0Var = d0.this;
                d0Var.C(d0Var.getString(R.string.loading));
            }
        }
    }

    class b extends com.martian.mibook.lib.yuewen.e.l {
        b() {
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            d0.this.A(errorResult);
        }

        @Override // b.d.c.c.b
        /* renamed from: q */
        public void onDataReceived(YWChannelBookList ywChannelBookList) {
            d0.this.z(ywChannelBookList);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            if (show) {
                d0 d0Var = d0.this;
                d0Var.C(d0Var.getString(R.string.loading));
            }
        }
    }

    public static class c {

        /* renamed from: a */
        private int f13101a;

        /* renamed from: b */
        private int f13102b;

        /* renamed from: c */
        private int f13103c;

        /* renamed from: d */
        private int f13104d;

        public int a() {
            return this.f13102b;
        }

        public int b() {
            return this.f13101a;
        }

        public int c() {
            return this.f13103c;
        }

        public int d() {
            return this.f13104d;
        }

        public c e(int bookType) {
            this.f13102b = bookType;
            return this;
        }

        public c f(int cType) {
            this.f13101a = cType;
            return this;
        }

        public void g(int ebType) {
            this.f13103c = ebType;
        }

        public void h(int nbType) {
            this.f13104d = nbType;
        }
    }

    public void A(b.d.c.b.c errorResult) {
        if (n0.c(this.f10082a)) {
            return;
        }
        p();
        B(errorResult, true);
    }

    private void v() {
        if (f()) {
            if (this.k.a() == 203) {
                x();
            } else {
                w();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void w() {
        a aVar = new a();
        ((YWFinishedBooksParams) aVar.k()).setCtype(Integer.valueOf(this.k.b()));
        ((YWFinishedBooksParams) aVar.k()).setEbtype(Integer.valueOf(this.k.c()));
        ((YWFinishedBooksParams) aVar.k()).setPage(Integer.valueOf(this.l));
        aVar.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void x() {
        b bVar = new b();
        ((YWNewBooksParams) bVar.k()).setCtype(Integer.valueOf(this.k.b()));
        ((YWNewBooksParams) bVar.k()).setNbtype(Integer.valueOf(this.k.d()));
        ((YWNewBooksParams) bVar.k()).setPage(Integer.valueOf(this.l));
        bVar.j();
    }

    public static d0 y(int ctype, int bookType, Integer type) {
        d0 d0Var = new d0();
        Bundle bundle = new Bundle();
        c f2 = new c().e(bookType).f(ctype);
        if (bookType == 202) {
            f2.g(type.intValue());
        } else if (bookType == 203) {
            f2.h(type.intValue());
        }
        bundle.putString(f13098j, GsonUtils.b().toJson(f2));
        d0Var.setArguments(bundle);
        return d0Var;
    }

    public void z(YWChannelBookList ywChannelBookList) {
        if (n0.c(this.f10082a)) {
            return;
        }
        p();
        if (ywChannelBookList == null || ywChannelBookList.getBookList() == null || ywChannelBookList.getBookList().size() <= 0) {
            B(new b.d.c.b.c(-1, "数据为空"), false);
            return;
        }
        k();
        if (this.m.E().isRefresh()) {
            this.m.a(ywChannelBookList.getBookList());
            this.m.Q(this.n.f10009b);
        } else {
            this.m.m(ywChannelBookList.getBookList());
        }
        this.l++;
    }

    public void B(b.d.c.b.c errorResult, boolean isError) {
        n4 n4Var = this.m;
        if (n4Var == null || n4Var.getSize() <= 0) {
            if (isError) {
                j(errorResult);
            } else {
                i(errorResult.d());
            }
            this.n.f10009b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
            return;
        }
        k();
        if (this.m.getSize() >= 10) {
            this.n.f10009b.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
        } else {
            this.n.f10009b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        }
    }

    public void C(String title) {
        n4 n4Var = this.m;
        if (n4Var == null || n4Var.getSize() <= 0) {
            l(title);
        }
    }

    @Override // com.martian.libmars.f.e
    protected void c() {
        v();
    }

    @Override // com.martian.libmars.f.h
    public int h() {
        return R.layout.fragment_str;
    }

    @Override // com.martian.libmars.f.h
    public void m() {
        if (n0.C(this.f10082a)) {
            this.m.E().setRefresh(true);
            this.l = 0;
            v();
        }
    }

    @Override // com.martian.libmars.widget.recyclerview.f.a
    public void onLoadMore(View loadMoreView) {
        if (n0.C(this.f10082a)) {
            this.m.E().setRefresh(this.m.getSize() <= 0);
            this.n.f10009b.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
            v();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull final View baseView, Bundle savedInstanceState) {
        String string;
        super.onViewCreated(baseView, savedInstanceState);
        if (savedInstanceState != null) {
            string = savedInstanceState.getString(f13098j);
        } else {
            Bundle arguments = getArguments();
            string = arguments != null ? arguments.getString(f13098j) : "";
        }
        if (!com.martian.libsupport.k.p(string)) {
            this.k = (c) GsonUtils.b().fromJson(string, c.class);
        }
        if (this.k == null) {
            this.f10082a.k1("获取信息失败");
            this.f10082a.finish();
            return;
        }
        com.martian.libmars.e.j a2 = com.martian.libmars.e.j.a(g());
        this.n = a2;
        a2.f10009b.setLayoutManager(new LinearLayoutManager(getContext()));
        n4 n4Var = new n4(a());
        this.m = n4Var;
        this.n.f10009b.setAdapter(n4Var);
        this.n.f10009b.setOnLoadMoreListener(this);
        this.n.f10009b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
    }
}
