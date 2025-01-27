package com.martian.mibook.fragment.yuewen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import ba.l;
import com.martian.libmars.fragment.StrFragment;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.recyclerview.LoadMoreFooterView;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.FragmentDiscountBookstoresBinding;
import com.martian.mibook.databinding.TitleBinding;
import com.martian.mibook.fragment.yuewen.YWBookDiscountFragment;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.model.data.TYSearchBookList;
import com.martian.mibook.lib.original.request.CPORBooksListParams;
import com.martian.mibook.lib.yuewen.request.YWBookDiscountParams;
import com.martian.mibook.lib.yuewen.response.TYDiscount;
import com.martian.mibook.lib.yuewen.response.TYDiscountList;
import com.martian.mibook.ui.adapter.TYBookItemListAdapter;
import com.martian.rpauth.MartianRPUserManager;
import java.util.Iterator;
import java.util.List;
import je.f1;
import l9.m0;
import l9.o0;
import oe.f;
import x8.c;

/* loaded from: classes3.dex */
public class YWBookDiscountFragment extends StrFragment {

    /* renamed from: k */
    public FragmentDiscountBookstoresBinding f13799k;

    /* renamed from: l */
    public int f13800l;

    /* renamed from: m */
    public int f13801m = 0;

    /* renamed from: n */
    public TYBookItemListAdapter f13802n;

    public class b extends fc.a {
        public b() {
        }

        @Override // y8.a
        public void onResultError(c cVar) {
            if (YWBookDiscountFragment.this.f13799k.bsChannels.getChildCount() <= 0) {
                YWBookDiscountFragment.this.Z(cVar);
            } else {
                YWBookDiscountFragment.this.f0();
            }
        }

        @Override // y8.a
        /* renamed from: r */
        public void onDataReceived(TYSearchBookList tYSearchBookList) {
            YWBookDiscountFragment.this.f13801m++;
            YWBookDiscountFragment.this.Y(tYSearchBookList);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }

    public void Z(c cVar) {
        a0(cVar, true);
    }

    @Override // com.martian.libmars.fragment.StrFragment
    public void A() {
        if (m0.C(this.f12349c)) {
            this.f13801m = 0;
            d0();
            b0();
        }
    }

    public void U(TYDiscount tYDiscount) {
        W(tYDiscount, false);
        Iterator<TYBookItem> it = tYDiscount.getBooks().iterator();
        while (it.hasNext()) {
            f1.i(this.f13799k.bsChannels, this.f12349c, it.next(), Integer.valueOf(tYDiscount.getPrice()));
        }
    }

    @SuppressLint({"SetTextI18n"})
    public void W(TYDiscount tYDiscount, boolean z10) {
        Resources resources;
        int i10;
        if (m0.C(this.f12349c)) {
            View inflate = this.f12349c.getLayoutInflater().inflate(R.layout.title, (ViewGroup) null);
            TitleBinding bind = TitleBinding.bind(inflate);
            bind.discountType.setVisibility(0);
            bind.contentMore.setVisibility(8);
            if (z10) {
                bind.discountType.setText("永久免费");
                ThemeTextView themeTextView = bind.contentTitle;
                StringBuilder sb2 = new StringBuilder();
                if (this.f13800l == 1) {
                    resources = this.f12349c.getResources();
                    i10 = R.string.book_sale_boy_recommend;
                } else {
                    resources = this.f12349c.getResources();
                    i10 = R.string.book_sale_girl_recommend;
                }
                sb2.append(resources.getString(i10));
                sb2.append(this.f12349c.getResources().getString(R.string.vip_choose));
                themeTextView.setText(sb2.toString());
                this.f13799k.originalTitle.removeAllViews();
                this.f13799k.originalTitle.addView(inflate);
                return;
            }
            if (tYDiscount.getPrice() == 0) {
                bind.discountType.setVisibility(0);
                bind.discountType.setText("限免");
            } else if (tYDiscount.getPrice() <= 0 || tYDiscount.getPrice() >= 100) {
                bind.discountType.setVisibility(8);
            } else {
                bind.discountType.setVisibility(0);
                bind.discountType.setText(f.f(tYDiscount.getPrice()));
            }
            bind.discountTime.setVisibility(0);
            if (MartianRPUserManager.a() < tYDiscount.getStartTime()) {
                bind.discountTime.setText(o0.u(tYDiscount.getStartTime(), "%m-%d %H:%M") + " 至 " + o0.u(tYDiscount.getEndTime(), "%m-%d %H:%M"));
            } else if (MartianRPUserManager.a() > tYDiscount.getEndTime()) {
                bind.discountTime.setText("已过期");
            } else {
                bind.discountTime.l(tYDiscount.getEndTime());
            }
            bind.contentTitle.setText(tYDiscount.getName());
            this.f13799k.bsChannels.addView(inflate);
        }
    }

    public final /* synthetic */ void X(NestedScrollView nestedScrollView, int i10, int i11, int i12, int i13) {
        if (i11 == nestedScrollView.getChildAt(0).getMeasuredHeight() - nestedScrollView.getMeasuredHeight()) {
            this.f13799k.originalIrc.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
            b0();
        }
    }

    public final void Y(TYSearchBookList tYSearchBookList) {
        if (m0.c(this.f12349c)) {
            return;
        }
        if (tYSearchBookList == null || tYSearchBookList.getBookItemList() == null || tYSearchBookList.getBookItemList().isEmpty()) {
            if (this.f13799k.bsChannels.getChildCount() <= 0) {
                a0(new c(-1, "数据为空"), false);
                return;
            } else {
                f0();
                return;
            }
        }
        y();
        if (this.f13799k.originalTitle.getChildCount() > 0) {
            this.f13802n.h(tYSearchBookList.getBookItemList());
            return;
        }
        W(null, true);
        this.f13802n.a(tYSearchBookList.getBookItemList());
        this.f13802n.x(this.f13799k.originalIrc);
    }

    public void a0(c cVar, boolean z10) {
        if (m0.c(this.f12349c)) {
            return;
        }
        TYBookItemListAdapter tYBookItemListAdapter = this.f13802n;
        if (tYBookItemListAdapter != null && tYBookItemListAdapter.getSize() > 0) {
            f0();
            return;
        }
        if (z10) {
            x(cVar);
        } else {
            w(cVar.d());
        }
        this.f13799k.originalIrc.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b0() {
        b bVar = new b();
        ((CPORBooksListParams) bVar.k()).setPage(this.f13801m);
        ((CPORBooksListParams) bVar.k()).setCtype(this.f13800l);
        bVar.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void d0() {
        a aVar = new a();
        ((YWBookDiscountParams) aVar.k()).setPage(0);
        aVar.j();
    }

    public void e0(List<TYDiscount> list) {
        if (list == null || list.isEmpty() || m0.c(this.f12349c)) {
            return;
        }
        y();
        for (TYDiscount tYDiscount : list) {
            if (tYDiscount != null && !l.q(tYDiscount.getName())) {
                if (tYDiscount.getName().contains(this.f13800l == 1 ? "男" : "女")) {
                    U(tYDiscount);
                }
            }
        }
    }

    public final void f0() {
        if (this.f13802n.getSize() >= 10) {
            this.f13799k.originalIrc.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
        } else {
            this.f13799k.originalIrc.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public Context getContext() {
        return getActivity();
    }

    @Override // com.martian.libmars.fragment.LazyFragment
    public void m() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        I(false);
        this.f13799k = FragmentDiscountBookstoresBinding.bind(t());
        this.f13800l = MiConfigSingleton.b2().p();
        this.f13799k.originalIrc.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f13799k.originalIrc.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        this.f13799k.originalIrc.setNestedScrollingEnabled(false);
        TYBookItemListAdapter tYBookItemListAdapter = new TYBookItemListAdapter(this.f12349c);
        this.f13802n = tYBookItemListAdapter;
        this.f13799k.originalIrc.setAdapter(tYBookItemListAdapter);
        this.f13799k.svContainer.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: fb.a
            public /* synthetic */ a() {
            }

            @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
            public final void onScrollChange(NestedScrollView nestedScrollView, int i10, int i11, int i12, int i13) {
                YWBookDiscountFragment.this.X(nestedScrollView, i10, i11, i12, i13);
            }
        });
        d0();
        b0();
    }

    @Override // com.martian.libmars.fragment.StrFragment
    public int u() {
        return R.layout.fragment_discount_bookstores;
    }

    public class a extends jc.c {
        public a() {
        }

        @Override // y8.a
        /* renamed from: r */
        public void onDataReceived(TYDiscountList tYDiscountList) {
            YWBookDiscountFragment.this.e0(tYDiscountList.getDiscountList());
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            if (z10) {
                YWBookDiscountFragment yWBookDiscountFragment = YWBookDiscountFragment.this;
                yWBookDiscountFragment.z(yWBookDiscountFragment.getString(com.martian.libmars.R.string.loading));
            }
        }

        @Override // y8.a
        public void onResultError(c cVar) {
        }
    }
}
