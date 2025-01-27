package com.martian.mibook.f.f4;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.martian.libmars.utils.n0;
import com.martian.libmars.widget.recyclerview.IRecyclerView;
import com.martian.libmars.widget.recyclerview.LoadMoreFooterView;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.yuewen.request.YWChannelBooksParams;
import com.martian.mibook.lib.yuewen.response.YWChannelBookList;
import com.martian.mibook.ui.o.n4;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public class i0 extends com.martian.libmars.f.h implements com.martian.libmars.widget.recyclerview.f.a {
    private n4 k;
    private String l;
    private String m;
    private IRecyclerView p;

    /* renamed from: j */
    private int f13130j = 0;
    private int n = 0;
    private int o = 0;

    class a extends com.martian.mibook.lib.yuewen.e.h {
        a() {
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            i0.this.y(errorResult);
        }

        @Override // b.d.c.c.b
        /* renamed from: q */
        public void onDataReceived(YWChannelBookList ywChannelBookList) {
            i0.this.x(ywChannelBookList);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            if (show) {
                i0 i0Var = i0.this;
                i0Var.A(i0Var.getString(R.string.loading));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void v() {
        a aVar = new a();
        ((YWChannelBooksParams) aVar.k()).setMcid(Integer.valueOf(this.n));
        ((YWChannelBooksParams) aVar.k()).setPage(Integer.valueOf(this.f13130j));
        ((YWChannelBooksParams) aVar.k()).setSeed(Integer.valueOf(this.o));
        ((YWChannelBooksParams) aVar.k()).setExt(this.m);
        aVar.j();
    }

    public static i0 w(String title, int mcid, int seed, int pageIndex, String ext) {
        Bundle bundle = new Bundle();
        bundle.putString(MiConfigSingleton.W0, title);
        bundle.putString(MiConfigSingleton.Y0, ext);
        bundle.putInt(MiConfigSingleton.U0, mcid);
        bundle.putInt(MiConfigSingleton.V0, seed);
        bundle.putInt(MiConfigSingleton.X0, pageIndex);
        i0 i0Var = new i0();
        i0Var.setArguments(bundle);
        return i0Var;
    }

    public void x(YWChannelBookList ywChannelBookList) {
        if (n0.c(this.f10082a)) {
            return;
        }
        p();
        if (ywChannelBookList == null || ywChannelBookList.getBookList() == null || ywChannelBookList.getBookList().size() <= 0) {
            z(new b.d.c.b.c(-1, "数据为空"), false);
            return;
        }
        k();
        if (this.k.E().isRefresh()) {
            this.k.a(ywChannelBookList.getBookList());
            this.k.Q(this.p);
        } else {
            this.k.m(ywChannelBookList.getBookList());
        }
        this.f13130j++;
    }

    public void y(b.d.c.b.c errorResult) {
        if (n0.c(this.f10082a)) {
            return;
        }
        p();
        z(errorResult, true);
    }

    public void A(String title) {
        n4 n4Var = this.k;
        if (n4Var == null || n4Var.getSize() <= 0) {
            l(title);
        }
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
            this.f13130j = 0;
            v();
        }
    }

    @Override // com.martian.libmars.widget.recyclerview.f.a
    public void onLoadMore(View loadMoreView) {
        if (n0.C(this.f10082a)) {
            this.k.E().setRefresh(this.k.getSize() <= 0);
            this.p.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
            v();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(MiConfigSingleton.W0, this.l);
        outState.putString(MiConfigSingleton.Y0, this.m);
        outState.putInt(MiConfigSingleton.U0, this.n);
        outState.putInt(MiConfigSingleton.V0, this.o);
        outState.putInt(MiConfigSingleton.X0, this.f13130j);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull final View baseView, Bundle savedInstanceState) {
        super.onViewCreated(baseView, savedInstanceState);
        if (savedInstanceState != null) {
            this.l = savedInstanceState.getString(MiConfigSingleton.W0);
            this.m = savedInstanceState.getString(MiConfigSingleton.Y0);
            this.n = savedInstanceState.getInt(MiConfigSingleton.U0);
            this.o = savedInstanceState.getInt(MiConfigSingleton.V0);
            this.f13130j = savedInstanceState.getInt(MiConfigSingleton.X0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.l = arguments.getString(MiConfigSingleton.W0);
                this.m = arguments.getString(MiConfigSingleton.Y0);
                this.n = arguments.getInt(MiConfigSingleton.U0);
                this.o = arguments.getInt(MiConfigSingleton.V0);
                this.f13130j = arguments.getInt(MiConfigSingleton.X0);
            }
        }
        IRecyclerView iRecyclerView = (IRecyclerView) g().findViewById(R.id.str_irc);
        this.p = iRecyclerView;
        iRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        n4 n4Var = new n4(this.f10082a);
        this.k = n4Var;
        n4Var.Z("-查看全部");
        this.p.setAdapter(this.k);
        this.p.setOnLoadMoreListener(this);
        this.p.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        v();
    }

    public void z(b.d.c.b.c errorResult, boolean isError) {
        n4 n4Var = this.k;
        if (n4Var == null || n4Var.getSize() <= 0) {
            if (isError) {
                j(errorResult);
            } else {
                i(errorResult.d());
            }
            this.p.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
            return;
        }
        k();
        if (this.k.getSize() >= 10) {
            this.p.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
        } else {
            this.p.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        }
    }
}
