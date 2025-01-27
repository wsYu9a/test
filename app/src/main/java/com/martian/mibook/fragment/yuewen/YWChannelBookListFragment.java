package com.martian.mibook.fragment.yuewen;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.martian.libmars.R;
import com.martian.libmars.fragment.StrFragment;
import com.martian.libmars.widget.recyclerview.IRecyclerView;
import com.martian.libmars.widget.recyclerview.LoadMoreFooterView;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.yuewen.request.YWChannelBooksParams;
import com.martian.mibook.lib.yuewen.response.YWChannelBookList;
import com.martian.mibook.ui.adapter.TYBookItemListAdapter;
import jc.h;
import l9.m0;
import x8.c;

/* loaded from: classes3.dex */
public class YWChannelBookListFragment extends StrFragment implements s9.a {

    /* renamed from: l */
    public TYBookItemListAdapter f13843l;

    /* renamed from: m */
    public String f13844m;

    /* renamed from: n */
    public String f13845n;

    /* renamed from: q */
    public IRecyclerView f13848q;

    /* renamed from: k */
    public int f13842k = 0;

    /* renamed from: o */
    public int f13846o = 0;

    /* renamed from: p */
    public int f13847p = 0;

    public class a extends h {
        public a() {
        }

        @Override // y8.a
        public void onResultError(c cVar) {
            YWChannelBookListFragment.this.S(cVar);
        }

        @Override // y8.a
        /* renamed from: r */
        public void onDataReceived(YWChannelBookList yWChannelBookList) {
            YWChannelBookListFragment.this.R(yWChannelBookList);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            if (z10) {
                YWChannelBookListFragment yWChannelBookListFragment = YWChannelBookListFragment.this;
                yWChannelBookListFragment.U(yWChannelBookListFragment.getString(R.string.loading));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void P() {
        a aVar = new a();
        ((YWChannelBooksParams) aVar.k()).setMcid(Integer.valueOf(this.f13846o));
        ((YWChannelBooksParams) aVar.k()).setPage(Integer.valueOf(this.f13842k));
        ((YWChannelBooksParams) aVar.k()).setSeed(Integer.valueOf(this.f13847p));
        ((YWChannelBooksParams) aVar.k()).setExt(this.f13845n);
        aVar.j();
    }

    public static YWChannelBookListFragment Q(String str, int i10, int i11, int i12, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(MiConfigSingleton.f13316b1, str);
        bundle.putString(MiConfigSingleton.f13318d1, str2);
        bundle.putInt(MiConfigSingleton.Z0, i10);
        bundle.putInt(MiConfigSingleton.f13315a1, i11);
        bundle.putInt(MiConfigSingleton.f13317c1, i12);
        YWChannelBookListFragment yWChannelBookListFragment = new YWChannelBookListFragment();
        yWChannelBookListFragment.setArguments(bundle);
        return yWChannelBookListFragment;
    }

    public void R(YWChannelBookList yWChannelBookList) {
        if (m0.c(this.f12349c)) {
            return;
        }
        H();
        if (yWChannelBookList == null || yWChannelBookList.getBookList() == null || yWChannelBookList.getBookList().isEmpty()) {
            T(new c(-1, "数据为空"), false);
            return;
        }
        y();
        if (this.f13843l.l().isRefresh()) {
            this.f13843l.a(yWChannelBookList.getBookList());
            this.f13843l.x(this.f13848q);
        } else {
            this.f13843l.h(yWChannelBookList.getBookList());
        }
        this.f13842k++;
    }

    public void S(c cVar) {
        if (m0.c(this.f12349c)) {
            return;
        }
        H();
        T(cVar, true);
    }

    @Override // com.martian.libmars.fragment.StrFragment
    public void A() {
        if (m0.C(this.f12349c)) {
            this.f13843l.l().setRefresh(true);
            this.f13842k = 0;
            P();
        }
    }

    public void T(c cVar, boolean z10) {
        TYBookItemListAdapter tYBookItemListAdapter = this.f13843l;
        if (tYBookItemListAdapter == null || tYBookItemListAdapter.getSize() <= 0) {
            if (z10) {
                x(cVar);
            } else {
                w(cVar.d());
            }
            this.f13848q.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
            return;
        }
        y();
        if (this.f13843l.getSize() >= 10) {
            this.f13848q.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
        } else {
            this.f13848q.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        }
    }

    public void U(String str) {
        TYBookItemListAdapter tYBookItemListAdapter = this.f13843l;
        if (tYBookItemListAdapter == null || tYBookItemListAdapter.getSize() <= 0) {
            z(str);
        }
    }

    @Override // com.martian.libmars.fragment.LazyFragment
    public void m() {
    }

    @Override // s9.a
    public void onLoadMore(View view) {
        if (m0.C(this.f12349c)) {
            this.f13843l.l().setRefresh(this.f13843l.getSize() <= 0);
            this.f13848q.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
            P();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(MiConfigSingleton.f13316b1, this.f13844m);
        bundle.putString(MiConfigSingleton.f13318d1, this.f13845n);
        bundle.putInt(MiConfigSingleton.Z0, this.f13846o);
        bundle.putInt(MiConfigSingleton.f13315a1, this.f13847p);
        bundle.putInt(MiConfigSingleton.f13317c1, this.f13842k);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (bundle != null) {
            this.f13844m = bundle.getString(MiConfigSingleton.f13316b1);
            this.f13845n = bundle.getString(MiConfigSingleton.f13318d1);
            this.f13846o = bundle.getInt(MiConfigSingleton.Z0);
            this.f13847p = bundle.getInt(MiConfigSingleton.f13315a1);
            this.f13842k = bundle.getInt(MiConfigSingleton.f13317c1);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f13844m = arguments.getString(MiConfigSingleton.f13316b1);
                this.f13845n = arguments.getString(MiConfigSingleton.f13318d1);
                this.f13846o = arguments.getInt(MiConfigSingleton.Z0);
                this.f13847p = arguments.getInt(MiConfigSingleton.f13315a1);
                this.f13842k = arguments.getInt(MiConfigSingleton.f13317c1);
            }
        }
        IRecyclerView iRecyclerView = (IRecyclerView) t().findViewById(R.id.str_irc);
        this.f13848q = iRecyclerView;
        iRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        TYBookItemListAdapter tYBookItemListAdapter = new TYBookItemListAdapter(this.f12349c);
        this.f13843l = tYBookItemListAdapter;
        tYBookItemListAdapter.E("-查看全部");
        this.f13848q.setAdapter(this.f13843l);
        this.f13848q.setOnLoadMoreListener(this);
        this.f13848q.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        P();
    }

    @Override // com.martian.libmars.fragment.StrFragment
    public int u() {
        return R.layout.fragment_str;
    }
}
