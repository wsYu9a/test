package com.martian.mibook.lib.account.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.martian.libmars.R;
import com.martian.libmars.databinding.FragmentStrBinding;
import com.martian.libmars.fragment.StrFragment;
import com.martian.libmars.widget.recyclerview.LoadMoreFooterView;
import com.martian.mibook.lib.account.adapter.MartianWithdrawOrderListAdapter;
import com.martian.mibook.lib.account.request.auth.MartianGetWithdrawOrdersParams;
import com.martian.mibook.lib.account.response.MartianWithdrawOrderList;
import com.martian.rpauth.MartianRPUserManager;
import java.util.ArrayList;
import kb.u;
import l9.m0;
import oe.e;
import vi.d;
import x8.c;

/* loaded from: classes3.dex */
public class MartianWithdrawOrderListFragment extends StrFragment implements s9.a {

    /* renamed from: o */
    public static String f13968o = "WITHDRAW_GUIDE_TO_RATE";

    /* renamed from: l */
    public MartianWithdrawOrderListAdapter f13970l;

    /* renamed from: n */
    public FragmentStrBinding f13972n;

    /* renamed from: k */
    public int f13969k = 0;

    /* renamed from: m */
    public boolean f13971m = false;

    public class a extends u {
        public a(Activity activity) {
            super(activity);
        }

        @Override // jb.k
        public void s(c cVar) {
            MartianWithdrawOrderListFragment.this.S(cVar);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            if (z10) {
                MartianWithdrawOrderListFragment martianWithdrawOrderListFragment = MartianWithdrawOrderListFragment.this;
                martianWithdrawOrderListFragment.U(martianWithdrawOrderListFragment.getString(R.string.loading));
            }
        }

        @Override // y8.a
        /* renamed from: v */
        public void onDataReceived(MartianWithdrawOrderList martianWithdrawOrderList) {
            MartianWithdrawOrderListFragment.this.R(martianWithdrawOrderList);
        }
    }

    public class b implements e.a {

        /* renamed from: a */
        public final /* synthetic */ Activity f13974a;

        public b(Activity activity) {
            this.f13974a = activity;
        }

        @Override // oe.e.a
        public void a() {
            org.codechimp.apprater.a.m(new d());
            org.codechimp.apprater.a.g(this.f13974a);
        }

        @Override // oe.e.a
        public void b() {
        }
    }

    public static MartianWithdrawOrderListFragment Q(int i10, boolean z10) {
        MartianWithdrawOrderListFragment martianWithdrawOrderListFragment = new MartianWithdrawOrderListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(MartianRPUserManager.f16198v, i10);
        bundle.putBoolean(f13968o, z10);
        martianWithdrawOrderListFragment.setArguments(bundle);
        return martianWithdrawOrderListFragment;
    }

    public void S(c cVar) {
        o(cVar.d() + "");
        H();
        T(cVar, true);
    }

    @Override // com.martian.libmars.fragment.StrFragment
    public void A() {
        if (m0.C(getActivity())) {
            this.f13970l.l().setRefresh(true);
            this.f13969k = 0;
            P();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void P() {
        if (r()) {
            a aVar = new a(j());
            ((MartianGetWithdrawOrdersParams) aVar.k()).setPage(Integer.valueOf(this.f13969k));
            ((MartianGetWithdrawOrdersParams) aVar.k()).setType(-1);
            aVar.j();
        }
    }

    public final void R(MartianWithdrawOrderList martianWithdrawOrderList) {
        H();
        if (getActivity() == null) {
            return;
        }
        if (martianWithdrawOrderList == null || martianWithdrawOrderList.getWithdrawOrders() == null || martianWithdrawOrderList.getWithdrawOrders().isEmpty()) {
            T(new c(-1, "数据为空"), false);
            return;
        }
        y();
        if (this.f13971m && X(martianWithdrawOrderList)) {
            W(j(), this.f13972n.f12195b, "提现姿势这么帅", "给个好评呗~", "去好评");
            return;
        }
        if (this.f13970l.l().isRefresh()) {
            this.f13970l.a(martianWithdrawOrderList.getWithdrawOrders());
        } else {
            this.f13970l.h(martianWithdrawOrderList.getWithdrawOrders());
        }
        this.f13969k++;
    }

    public void T(c cVar, boolean z10) {
        MartianWithdrawOrderListAdapter martianWithdrawOrderListAdapter = this.f13970l;
        if (martianWithdrawOrderListAdapter == null || martianWithdrawOrderListAdapter.getSize() <= 0) {
            if (z10) {
                x(cVar);
            } else {
                w(cVar.d());
            }
            this.f13972n.f12195b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
            return;
        }
        y();
        if (this.f13970l.getSize() < 10) {
            this.f13972n.f12195b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        } else {
            this.f13972n.f12195b.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
            this.f13972n.f12195b.setLoadMoreEndStatus("已全部加载");
        }
    }

    public void U(String str) {
        MartianWithdrawOrderListAdapter martianWithdrawOrderListAdapter = this.f13970l;
        if (martianWithdrawOrderListAdapter == null || martianWithdrawOrderListAdapter.getSize() <= 0) {
            z(str);
        }
    }

    public void W(Activity activity, View view, String str, String str2, String str3) {
        if (getActivity() == null || view == null) {
            return;
        }
        try {
            e.g(activity, view, str, str2, str3, new b(activity));
        } catch (Exception unused) {
        }
    }

    public boolean X(MartianWithdrawOrderList martianWithdrawOrderList) {
        return (martianWithdrawOrderList == null || martianWithdrawOrderList.getWithdrawOrders() == null || martianWithdrawOrderList.getWithdrawOrders().get(0) == null || martianWithdrawOrderList.getWithdrawOrders().get(0).getWostatus() != 2) ? false : true;
    }

    @Override // com.martian.libmars.fragment.LazyFragment
    public void m() {
    }

    @Override // s9.a
    public void onLoadMore(View view) {
        if (m0.C(getActivity())) {
            this.f13970l.l().setRefresh(this.f13970l.getSize() <= 0);
            this.f13972n.f12195b.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
            P();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentStrBinding a10 = FragmentStrBinding.a(t());
        this.f13972n = a10;
        a10.f12195b.setLayoutManager(new LinearLayoutManager(getActivity()));
        MartianWithdrawOrderListAdapter martianWithdrawOrderListAdapter = new MartianWithdrawOrderListAdapter(getActivity(), new ArrayList());
        this.f13970l = martianWithdrawOrderListAdapter;
        this.f13972n.f12195b.setAdapter(martianWithdrawOrderListAdapter);
        this.f13972n.f12195b.setOnLoadMoreListener(this);
        this.f13972n.f12195b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f13971m = arguments.getBoolean(f13968o);
        }
        P();
    }

    @Override // com.martian.libmars.fragment.StrFragment
    public int u() {
        return R.layout.fragment_str;
    }
}
