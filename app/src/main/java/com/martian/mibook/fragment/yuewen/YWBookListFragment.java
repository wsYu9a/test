package com.martian.mibook.fragment.yuewen;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.databinding.FragmentStrBinding;
import com.martian.libmars.fragment.StrFragment;
import com.martian.libmars.widget.recyclerview.LoadMoreFooterView;
import com.martian.mibook.lib.yuewen.request.YWFinishedBooksParams;
import com.martian.mibook.lib.yuewen.request.YWNewBooksParams;
import com.martian.mibook.lib.yuewen.response.YWChannelBookList;
import com.martian.mibook.ui.adapter.TYBookItemListAdapter;
import jc.k;
import jc.l;
import l9.m0;
import l9.t0;

/* loaded from: classes3.dex */
public class YWBookListFragment extends StrFragment implements s9.a {

    /* renamed from: o */
    public static final String f13805o = "YW_BOOKS_LIST_INFO";

    /* renamed from: p */
    public static final int f13806p = 202;

    /* renamed from: q */
    public static final int f13807q = 203;

    /* renamed from: k */
    public c f13808k;

    /* renamed from: l */
    public int f13809l = 0;

    /* renamed from: m */
    public TYBookItemListAdapter f13810m;

    /* renamed from: n */
    public FragmentStrBinding f13811n;

    public class a extends k {
        public a() {
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            YWBookListFragment.this.U(cVar);
        }

        @Override // y8.a
        /* renamed from: r */
        public void onDataReceived(YWChannelBookList yWChannelBookList) {
            YWBookListFragment.this.T(yWChannelBookList);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            if (z10) {
                YWBookListFragment yWBookListFragment = YWBookListFragment.this;
                yWBookListFragment.X(yWBookListFragment.getString(R.string.loading));
            }
        }
    }

    public class b extends l {
        public b() {
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            YWBookListFragment.this.U(cVar);
        }

        @Override // y8.a
        /* renamed from: r */
        public void onDataReceived(YWChannelBookList yWChannelBookList) {
            YWBookListFragment.this.T(yWChannelBookList);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            if (z10) {
                YWBookListFragment yWBookListFragment = YWBookListFragment.this;
                yWBookListFragment.X(yWBookListFragment.getString(R.string.loading));
            }
        }
    }

    public static class c {

        /* renamed from: a */
        public int f13814a;

        /* renamed from: b */
        public int f13815b;

        /* renamed from: c */
        public int f13816c;

        /* renamed from: d */
        public int f13817d;

        public int a() {
            return this.f13815b;
        }

        public int b() {
            return this.f13814a;
        }

        public int c() {
            return this.f13816c;
        }

        public int d() {
            return this.f13817d;
        }

        public c e(int i10) {
            this.f13815b = i10;
            return this;
        }

        public c f(int i10) {
            this.f13814a = i10;
            return this;
        }

        public void g(int i10) {
            this.f13816c = i10;
        }

        public void h(int i10) {
            this.f13817d = i10;
        }
    }

    private void P() {
        if (r()) {
            if (this.f13808k.a() == 203) {
                R();
            } else {
                Q();
            }
        }
    }

    public static YWBookListFragment S(int i10, int i11, Integer num) {
        YWBookListFragment yWBookListFragment = new YWBookListFragment();
        Bundle bundle = new Bundle();
        c f10 = new c().e(i11).f(i10);
        if (i11 == 202) {
            f10.g(num.intValue());
        } else if (i11 == 203) {
            f10.h(num.intValue());
        }
        bundle.putString(f13805o, GsonUtils.b().toJson(f10));
        yWBookListFragment.setArguments(bundle);
        return yWBookListFragment;
    }

    public void U(x8.c cVar) {
        if (m0.c(this.f12349c)) {
            return;
        }
        H();
        W(cVar, true);
    }

    @Override // com.martian.libmars.fragment.StrFragment
    public void A() {
        if (m0.C(this.f12349c)) {
            this.f13810m.l().setRefresh(true);
            this.f13809l = 0;
            P();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Q() {
        a aVar = new a();
        ((YWFinishedBooksParams) aVar.k()).setCtype(Integer.valueOf(this.f13808k.b()));
        ((YWFinishedBooksParams) aVar.k()).setEbtype(Integer.valueOf(this.f13808k.c()));
        ((YWFinishedBooksParams) aVar.k()).setPage(Integer.valueOf(this.f13809l));
        aVar.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R() {
        b bVar = new b();
        ((YWNewBooksParams) bVar.k()).setCtype(Integer.valueOf(this.f13808k.b()));
        ((YWNewBooksParams) bVar.k()).setNbtype(Integer.valueOf(this.f13808k.d()));
        ((YWNewBooksParams) bVar.k()).setPage(Integer.valueOf(this.f13809l));
        bVar.j();
    }

    public final void T(YWChannelBookList yWChannelBookList) {
        if (m0.c(this.f12349c)) {
            return;
        }
        H();
        if (yWChannelBookList == null || yWChannelBookList.getBookList() == null || yWChannelBookList.getBookList().isEmpty()) {
            W(new x8.c(-1, "数据为空"), false);
            return;
        }
        y();
        if (this.f13810m.l().isRefresh()) {
            this.f13810m.a(yWChannelBookList.getBookList());
            this.f13810m.x(this.f13811n.f12195b);
        } else {
            this.f13810m.h(yWChannelBookList.getBookList());
        }
        this.f13809l++;
    }

    public void W(x8.c cVar, boolean z10) {
        TYBookItemListAdapter tYBookItemListAdapter = this.f13810m;
        if (tYBookItemListAdapter == null || tYBookItemListAdapter.getSize() <= 0) {
            if (z10) {
                x(cVar);
            } else {
                w(cVar.d());
            }
            this.f13811n.f12195b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
            return;
        }
        y();
        if (this.f13810m.getSize() >= 10) {
            this.f13811n.f12195b.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
        } else {
            this.f13811n.f12195b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        }
    }

    public void X(String str) {
        TYBookItemListAdapter tYBookItemListAdapter = this.f13810m;
        if (tYBookItemListAdapter == null || tYBookItemListAdapter.getSize() <= 0) {
            z(str);
        }
    }

    @Override // com.martian.libmars.fragment.LazyFragment
    public void m() {
        P();
    }

    @Override // s9.a
    public void onLoadMore(View view) {
        if (m0.C(this.f12349c)) {
            this.f13810m.l().setRefresh(this.f13810m.getSize() <= 0);
            this.f13811n.f12195b.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
            P();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, Bundle bundle) {
        String string;
        super.onViewCreated(view, bundle);
        if (bundle != null) {
            string = bundle.getString(f13805o);
        } else {
            Bundle arguments = getArguments();
            string = arguments != null ? arguments.getString(f13805o) : "";
        }
        if (!ba.l.q(string)) {
            this.f13808k = (c) GsonUtils.b().fromJson(string, c.class);
        }
        if (this.f13808k == null) {
            t0.b(this.f12349c, ConfigSingleton.D().s("获取信息失败"));
            this.f12349c.finish();
            return;
        }
        FragmentStrBinding a10 = FragmentStrBinding.a(t());
        this.f13811n = a10;
        a10.f12195b.setLayoutManager(new LinearLayoutManager(getActivity()));
        TYBookItemListAdapter tYBookItemListAdapter = new TYBookItemListAdapter(j());
        this.f13810m = tYBookItemListAdapter;
        this.f13811n.f12195b.setAdapter(tYBookItemListAdapter);
        this.f13811n.f12195b.setOnLoadMoreListener(this);
        this.f13811n.f12195b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
    }

    @Override // com.martian.libmars.fragment.StrFragment
    public int u() {
        return R.layout.fragment_str;
    }
}
