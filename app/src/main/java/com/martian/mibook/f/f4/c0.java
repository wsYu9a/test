package com.martian.mibook.f.f4;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.martian.libmars.activity.j1;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.utils.n0;
import com.martian.libmars.utils.p0;
import com.martian.libmars.widget.recyclerview.LoadMoreFooterView;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.e.e7;
import com.martian.mibook.e.g3;
import com.martian.mibook.j.y2;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.model.data.TYSearchBookList;
import com.martian.mibook.lib.original.request.CPORBooksListParams;
import com.martian.mibook.lib.yuewen.request.YWBookDiscountParams;
import com.martian.mibook.lib.yuewen.response.TYDiscount;
import com.martian.mibook.lib.yuewen.response.TYDiscountList;
import com.martian.mibook.ui.o.n4;
import com.martian.rpauth.MartianRPUserManager;
import com.martian.ttbookhd.R;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class c0 extends com.martian.libmars.f.h {

    /* renamed from: j */
    private j1 f13094j;
    private g3 k;
    private int l;
    private int m = 0;
    private n4 n;

    class a extends com.martian.mibook.lib.yuewen.e.c {
        a() {
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
        }

        @Override // b.d.c.c.b
        /* renamed from: q */
        public void onDataReceived(TYDiscountList tyDiscountList) {
            c0.this.H(tyDiscountList.getDiscountList());
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            if (show) {
                c0 c0Var = c0.this;
                c0Var.l(c0Var.getString(R.string.loading));
            }
        }
    }

    class b extends com.martian.mibook.lib.original.e.a {
        b() {
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            if (c0.this.k.f12001b.getChildCount() <= 0) {
                c0.this.D(errorResult);
            } else {
                c0.this.I();
            }
        }

        @Override // b.d.c.c.b
        /* renamed from: q */
        public void onDataReceived(TYSearchBookList cpBooksList) {
            c0.t(c0.this);
            c0.this.C(cpBooksList);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    /* renamed from: A */
    public /* synthetic */ void B(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        if (scrollY == v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight()) {
            this.k.f12002c.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
            F();
        }
    }

    public void C(TYSearchBookList cpBooksList) {
        if (n0.c(this.f13094j)) {
            return;
        }
        if (cpBooksList == null || cpBooksList.getBookItemList() == null || cpBooksList.getBookItemList().size() <= 0) {
            if (this.k.f12001b.getChildCount() <= 0) {
                E(new b.d.c.b.c(-1, "数据为空"), false);
                return;
            } else {
                I();
                return;
            }
        }
        k();
        if (this.k.f12003d.getChildCount() > 0) {
            this.n.m(cpBooksList.getBookItemList());
            return;
        }
        z(null, true);
        this.n.a(cpBooksList.getBookItemList());
        this.n.Q(this.k.f12002c);
    }

    public void D(b.d.c.b.c errorResult) {
        E(errorResult, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void F() {
        b bVar = new b();
        ((CPORBooksListParams) bVar.k()).setPage(this.m);
        ((CPORBooksListParams) bVar.k()).setCtype(this.l);
        bVar.j();
    }

    public void I() {
        if (this.n.getSize() >= 10) {
            this.k.f12002c.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
        } else {
            this.k.f12002c.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        }
    }

    static /* synthetic */ int t(c0 c0Var) {
        int i2 = c0Var.m;
        c0Var.m = i2 + 1;
        return i2;
    }

    public void E(b.d.c.b.c errorResult, boolean isError) {
        if (n0.c(this.f13094j)) {
            return;
        }
        n4 n4Var = this.n;
        if (n4Var != null && n4Var.getSize() > 0) {
            I();
            return;
        }
        if (isError) {
            j(errorResult);
        } else {
            i(errorResult.d());
        }
        this.k.f12002c.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void G() {
        a aVar = new a();
        ((YWBookDiscountParams) aVar.k()).setPage(0);
        aVar.j();
    }

    public void H(List<TYDiscount> tyDiscounts) {
        if (tyDiscounts == null || tyDiscounts.size() <= 0 || n0.c(this.f13094j)) {
            return;
        }
        k();
        for (TYDiscount tYDiscount : tyDiscounts) {
            if (tYDiscount != null && !com.martian.libsupport.k.p(tYDiscount.getName())) {
                if (tYDiscount.getName().contains(this.l == 1 ? "男" : "女")) {
                    y(tYDiscount);
                }
            }
        }
    }

    @Override // com.martian.libmars.f.e
    public j1 a() {
        return this.f13094j;
    }

    @Override // com.martian.libmars.f.e
    protected void c() {
    }

    @Override // com.martian.libmars.f.e, androidx.fragment.app.Fragment
    public Context getContext() {
        return getActivity();
    }

    @Override // com.martian.libmars.f.h
    public int h() {
        return R.layout.fragment_discount_bookstores;
    }

    @Override // com.martian.libmars.f.h
    public void m() {
        if (n0.C(this.f13094j)) {
            this.m = 0;
            G();
            F();
        }
    }

    @Override // com.martian.libmars.f.e, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.f13094j = (j1) context;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull final View baseView, Bundle savedInstanceState) {
        super.onViewCreated(baseView, savedInstanceState);
        q(false);
        this.k = g3.a(g());
        this.l = MiConfigSingleton.V3().k3();
        this.k.f12002c.setLayoutManager(new LinearLayoutManager(getContext()));
        this.k.f12002c.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        this.k.f12002c.setNestedScrollingEnabled(false);
        n4 n4Var = new n4(this.f13094j);
        this.n = n4Var;
        this.k.f12002c.setAdapter(n4Var);
        this.k.f12004e.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: com.martian.mibook.f.f4.b
            @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
            public final void onScrollChange(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
                c0.this.B(nestedScrollView, i2, i3, i4, i5);
            }
        });
        G();
        F();
    }

    public void y(final TYDiscount tyDiscount) {
        z(tyDiscount, false);
        Iterator<TYBookItem> it = tyDiscount.getBooks().iterator();
        while (it.hasNext()) {
            y2.k(this.k.f12001b, this.f13094j, it.next(), Integer.valueOf(tyDiscount.getPrice()));
        }
    }

    @SuppressLint({"SetTextI18n"})
    public void z(final TYDiscount tyDiscount, boolean isOriginal) {
        Resources resources;
        int i2;
        if (n0.C(this.f13094j)) {
            View inflate = this.f13094j.getLayoutInflater().inflate(R.layout.title, (ViewGroup) null);
            e7 a2 = e7.a(inflate);
            a2.f11923f.setVisibility(0);
            a2.f11919b.setVisibility(8);
            if (isOriginal) {
                a2.f11923f.setText("永久免费");
                ThemeTextView themeTextView = a2.f11920c;
                StringBuilder sb = new StringBuilder();
                if (this.l == 1) {
                    resources = this.f13094j.getResources();
                    i2 = R.string.book_sale_boy_recommend;
                } else {
                    resources = this.f13094j.getResources();
                    i2 = R.string.book_sale_girl_recommend;
                }
                sb.append(resources.getString(i2));
                sb.append(this.f13094j.getResources().getString(R.string.vip_choose));
                themeTextView.setText(sb.toString());
                this.k.f12003d.removeAllViews();
                this.k.f12003d.addView(inflate);
                return;
            }
            if (tyDiscount.getPrice() == 0) {
                a2.f11923f.setVisibility(0);
                a2.f11923f.setText("限免");
            } else if (tyDiscount.getPrice() <= 0 || tyDiscount.getPrice() >= 100) {
                a2.f11923f.setVisibility(8);
            } else {
                a2.f11923f.setVisibility(0);
                a2.f11923f.setText(com.martian.rpauth.d.i.e(tyDiscount.getPrice()));
            }
            a2.f11922e.setVisibility(0);
            if (MartianRPUserManager.t() < tyDiscount.getStartTime()) {
                a2.f11922e.setText(p0.s(tyDiscount.getStartTime(), "%m-%d %H:%M") + " 至 " + p0.s(tyDiscount.getEndTime(), "%m-%d %H:%M"));
            } else if (MartianRPUserManager.t() > tyDiscount.getEndTime()) {
                a2.f11922e.setText("已过期");
            } else {
                a2.f11922e.n(tyDiscount.getEndTime());
            }
            a2.f11920c.setText(tyDiscount.getName());
            this.k.f12001b.addView(inflate);
        }
    }
}
