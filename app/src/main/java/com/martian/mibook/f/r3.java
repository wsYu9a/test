package com.martian.mibook.f;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.utils.tablayout.MagicIndicator;
import com.martian.libmars.widget.recyclerview.LoadMoreFooterView;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.mibook.activity.book.BookRankActivity;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.yuewen.request.YWRankBooksParams;
import com.martian.mibook.lib.yuewen.response.YWCategory;
import com.martian.mibook.lib.yuewen.response.YWChannelBookList;
import com.martian.mibook.lib.yuewen.response.YWFreeType;
import com.martian.mibook.ui.FlowLayout;
import com.martian.mibook.ui.adapter.yuewen.YWCategoryTitleAdapter;
import com.martian.mibook.ui.o.n4;
import com.martian.ttbookhd.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class r3 extends com.martian.libmars.f.h implements com.martian.libmars.widget.recyclerview.f.a {

    /* renamed from: j */
    private static final String f13246j = "CATEGORY_TYPE";
    public static final int k = 0;
    private static final int l = 50;
    private static final int m = 30;
    public static final int n = 0;
    public static final int o = 1;
    public static final int p = 2;
    public static final int q = 3;
    private com.martian.mibook.e.y0 A;
    private YWFreeType C;
    private BookRankActivity.a s;
    private YWCategoryTitleAdapter w;
    private n4 x;
    private com.martian.mibook.ui.o.o3 y;
    private com.martian.mibook.e.w2 z;
    private int r = 0;
    private int t = 0;
    private int u = 0;
    private final List<String> v = new ArrayList();
    private final Set<String> B = new HashSet();

    class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) r3.this.z.f12878e.getLayoutManager();
            if (linearLayoutManager != null) {
                if (linearLayoutManager.findLastVisibleItemPosition() <= 5) {
                    r3.this.z.f12876c.setVisibility(8);
                } else {
                    r3.this.z.f12876c.setVisibility(0);
                    r3.this.z.f12875b.setText(r3.this.E());
                }
            }
        }
    }

    class b implements MiBookManager.z {
        b() {
        }

        @Override // com.martian.mibook.application.MiBookManager.z
        public void a(YWFreeType freeType) {
            r3.this.b0(freeType);
            r3.this.m();
        }

        @Override // com.martian.mibook.application.MiBookManager.z
        public void b() {
            r3.this.m();
        }
    }

    class c extends com.martian.mibook.lib.yuewen.e.m {
        c() {
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            r3.this.c0();
        }

        @Override // b.d.c.c.b
        /* renamed from: q */
        public void onDataReceived(YWChannelBookList ywChannelBookList) {
            r3.this.a0(ywChannelBookList);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            if (show) {
                r3.this.d0();
            }
        }
    }

    private int A(int type) {
        if (type == 2) {
            return 1;
        }
        if (type == 3) {
            return 2;
        }
        if (type == 4) {
            return 3;
        }
        if (type == 5) {
            return 4;
        }
        if (type != 7) {
            return type != 8 ? 0 : 6;
        }
        return 5;
    }

    public static String B(Activity activity, int brtype) {
        if (com.martian.libmars.utils.n0.c(activity)) {
            return "";
        }
        int i2 = brtype % 10;
        return i2 == 0 ? activity.getString(R.string.category_rank_daily) : i2 == 1 ? activity.getString(R.string.category_rank_weekly) : i2 == 2 ? activity.getString(R.string.category_rank_monthly) : activity.getString(R.string.category_rank_all);
    }

    public static String C(Activity activity, BookRankActivity.a rankInfo) {
        return com.martian.libmars.utils.n0.c(activity) ? "" : rankInfo.f() == 0 ? activity.getString(R.string.category_rank_daily) : rankInfo.f() == 1 ? activity.getString(R.string.category_rank_weekly) : rankInfo.f() == 2 ? activity.getString(R.string.category_rank_monthly) : activity.getString(R.string.category_rank_all);
    }

    private String D() {
        int h2 = this.s.h();
        if (h2 == 30) {
            return this.f10082a.getString(R.string.serialise) + "·";
        }
        if (h2 != 50) {
            return "";
        }
        return this.f10082a.getString(R.string.bookstores_finish) + "·";
    }

    public String E() {
        String str;
        YWCategoryTitleAdapter yWCategoryTitleAdapter = this.w;
        String str2 = "";
        if (yWCategoryTitleAdapter == null || com.martian.libsupport.k.p(yWCategoryTitleAdapter.F())) {
            str = "";
        } else {
            str = this.w.F() + "·";
        }
        if (this.A.f12956e.getSelectPosition() > 0) {
            str2 = this.A.f12956e.getSelectedItem() + "·";
        }
        return str + str2 + D() + C(this.f10082a, this.s);
    }

    private int F(int position) {
        if (position != 1) {
            return position != 2 ? 0 : 30;
        }
        return 50;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private View G() {
        View inflate = View.inflate(this.f10082a, R.layout.book_rank_top, null);
        com.martian.mibook.e.y0 a2 = com.martian.mibook.e.y0.a(inflate);
        this.A = a2;
        a2.k.setOnTouchListener(new View.OnTouchListener() { // from class: com.martian.mibook.f.u
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return r3.this.J(view, motionEvent);
            }
        });
        this.A.f12956e.setOnItemTitleClickListener(new FlowLayout.a() { // from class: com.martian.mibook.f.q
            @Override // com.martian.mibook.ui.FlowLayout.a
            public final void a(String str, int i2) {
                r3.this.L(str, i2);
            }
        });
        this.A.f12955d.setOnItemTitleClickListener(new FlowLayout.a() { // from class: com.martian.mibook.f.o
            @Override // com.martian.mibook.ui.FlowLayout.a
            public final void a(String str, int i2) {
                r3.this.N(str, i2);
            }
        });
        g0();
        return inflate;
    }

    private void H() {
        this.A.k.setLayoutManager(new LinearLayoutManager(this.f10082a, 0, false));
        if (this.w == null) {
            YWCategoryTitleAdapter yWCategoryTitleAdapter = new YWCategoryTitleAdapter(this.f10082a);
            this.w = yWCategoryTitleAdapter;
            yWCategoryTitleAdapter.L(this.s.b());
            this.A.k.setAdapter(this.w);
            if (this.w.E() > 0) {
                this.A.k.smoothScrollToPosition(this.w.E());
            }
            this.w.M(new YWCategoryTitleAdapter.a() { // from class: com.martian.mibook.f.p
                @Override // com.martian.mibook.ui.adapter.yuewen.YWCategoryTitleAdapter.a
                public final void a(int i2) {
                    r3.this.P(i2);
                }
            });
        }
    }

    /* renamed from: I */
    public /* synthetic */ boolean J(View view, MotionEvent motionEvent) {
        q(motionEvent.getAction() == 1);
        return false;
    }

    /* renamed from: K */
    public /* synthetic */ void L(String titleName, int position) {
        BookRankActivity.a aVar = this.s;
        if (position <= 0) {
            titleName = "";
        }
        aVar.l(titleName);
        m();
    }

    /* renamed from: M */
    public /* synthetic */ void N(String titleName, int position) {
        this.s.q(F(position));
        m();
    }

    /* renamed from: O */
    public /* synthetic */ void P(int position) {
        this.s.j(this.w.G() + this.s.f());
        m();
    }

    /* renamed from: Q */
    public /* synthetic */ void R(View view) {
        if (this.x.getSize() <= 100) {
            this.z.f12878e.smoothScrollToPosition(0);
        } else {
            this.z.f12878e.scrollToPosition(0);
        }
    }

    /* renamed from: S */
    public /* synthetic */ void T(final TYBookItem tyBookItem, View v) {
        this.s.p(1);
        com.martian.mibook.j.s2.V(this.f10082a, tyBookItem, this.s);
    }

    /* renamed from: U */
    public /* synthetic */ void V(final TYBookItem tyBookItem, View v) {
        this.s.p(2);
        com.martian.mibook.j.s2.V(this.f10082a, tyBookItem, this.s);
    }

    /* renamed from: W */
    public /* synthetic */ void X(final TYBookItem tyBookItem, View v) {
        this.s.p(3);
        com.martian.mibook.j.s2.V(this.f10082a, tyBookItem, this.s);
    }

    public static r3 Y(int pageIndex, int cType, BookRankActivity.a rankInfo) {
        r3 r3Var = new r3();
        Bundle bundle = new Bundle();
        bundle.putInt(MagicIndicator.f10218a, pageIndex);
        bundle.putInt(f13246j, cType);
        if (rankInfo != null) {
            bundle.putString(BookRankActivity.F, GsonUtils.b().toJson(rankInfo));
        }
        r3Var.setArguments(bundle);
        return r3Var;
    }

    private void Z(TYBookItem tyBookItem) {
        if (this.B.contains(tyBookItem.getSourceId())) {
            return;
        }
        MiConfigSingleton.V3().l3().I1(0, tyBookItem.getSourceName(), tyBookItem.getSourceId(), tyBookItem.getRecommendId(), "", "展示");
        this.B.add(tyBookItem.getSourceId());
    }

    public void a0(YWChannelBookList ywChannelBookList) {
        BookRankActivity.a aVar;
        if (com.martian.libmars.utils.n0.c(this.f10082a)) {
            return;
        }
        com.martian.mibook.e.y0 y0Var = this.A;
        if (y0Var != null && (aVar = this.s) != null) {
            y0Var.f12955d.setVisibility(aVar.b() == 110 ? 8 : 0);
        }
        p();
        this.u++;
        if (ywChannelBookList != null && ywChannelBookList.getBookList() != null && ywChannelBookList.getBookList().size() > 0) {
            if (!com.martian.libsupport.k.p(this.s.i())) {
                for (TYBookItem tYBookItem : ywChannelBookList.getBookList()) {
                    tYBookItem.setRecommend(this.s.i() + tYBookItem.getRecommend());
                }
            }
            if (this.x.E().isRefresh()) {
                if (ywChannelBookList.getBookList().size() >= 3) {
                    x(ywChannelBookList.getBookList());
                    ywChannelBookList.getBookList().remove(0);
                    ywChannelBookList.getBookList().remove(0);
                    ywChannelBookList.getBookList().remove(0);
                    this.x.a0(true);
                } else {
                    e0(false);
                    this.x.a0(false);
                }
                this.x.a(ywChannelBookList.getBookList());
                this.x.Q(this.z.f12878e);
                ((RelativeLayout.LayoutParams) this.z.f12877d.getLayoutParams()).setMargins(0, this.A.f12954c.getHeight(), 0, 0);
            } else if (ywChannelBookList.getBookList().size() > 0) {
                this.z.f12878e.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
                this.x.m(ywChannelBookList.getBookList());
            } else {
                this.z.f12878e.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
            }
        } else if (this.x.getSize() >= 10) {
            this.z.f12878e.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
        } else {
            this.z.f12878e.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        }
        if (this.x.getSize() <= 0) {
            this.z.f12877d.setLoadingTip(LoadingTip.LoadStatus.empty);
            return;
        }
        this.z.f12877d.setLoadingTip(LoadingTip.LoadStatus.finish);
        com.martian.mibook.e.y0 y0Var2 = this.A;
        if (y0Var2 != null) {
            y0Var2.f12954c.setVisibility(0);
        }
    }

    public void b0(YWFreeType freeType) {
        if (freeType == null || com.martian.libmars.utils.n0.c(this.f10082a)) {
            return;
        }
        this.C = freeType;
        this.v.add(this.f10082a.getString(R.string.withdraw_money_all));
        int i2 = 1;
        for (YWCategory yWCategory : this.C.getCategoryList()) {
            if (!com.martian.libsupport.k.p(yWCategory.getCategoryName())) {
                this.v.add(yWCategory.getCategoryName());
                if (this.s.d() != -1 && this.s.d() == yWCategory.getCategoryId()) {
                    this.A.f12956e.setSelectPosition(i2);
                    this.w.L(this.s.b());
                    this.A.k.smoothScrollToPosition(this.w.E());
                } else if (!com.martian.libsupport.k.p(this.s.c()) && this.s.c().equalsIgnoreCase(yWCategory.getCategoryName())) {
                    this.A.f12956e.setSelectPosition(i2);
                    this.w.L(this.s.b());
                    this.A.k.smoothScrollToPosition(this.w.E());
                }
                i2++;
            }
        }
        this.A.f12956e.setData(this.v);
    }

    private void e0(boolean show) {
        this.A.f12953b.setVisibility(show ? 0 : 8);
    }

    private void f0() {
        this.A.f12957f.setText(C(this.f10082a, this.s));
    }

    private void g0() {
        if (this.A.f12955d.getChildCount() <= 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f10082a.getString(R.string.withdraw_money_all));
            arrayList.add(this.f10082a.getString(R.string.bookstores_finish));
            arrayList.add(this.f10082a.getString(R.string.serialise));
            this.A.f12955d.setData(arrayList);
        }
    }

    private void h0(final TYBookItem tyBookItem, boolean showRankDesc) {
        com.martian.libmars.utils.n0.z(this.f10082a, tyBookItem.getCoverUrl(), this.A.l, 2, MiConfigSingleton.V3().i3());
        if (!com.martian.libsupport.k.p(tyBookItem.getBookName())) {
            this.A.r.setText(tyBookItem.getBookName());
        }
        this.A.l.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r3.this.T(tyBookItem, view);
            }
        });
        if (com.martian.libsupport.k.p(tyBookItem.getRankDesc())) {
            this.A.o.setVisibility(showRankDesc ? 4 : 8);
        } else {
            this.A.o.setVisibility(0);
            this.A.o.setText(tyBookItem.getRankDesc());
        }
        Z(tyBookItem);
    }

    private void i0(final TYBookItem tyBookItem, boolean showRankDesc) {
        com.martian.libmars.utils.n0.z(this.f10082a, tyBookItem.getCoverUrl(), this.A.m, 2, MiConfigSingleton.V3().i3());
        if (!com.martian.libsupport.k.p(tyBookItem.getBookName())) {
            this.A.s.setText(tyBookItem.getBookName());
        }
        this.A.m.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r3.this.V(tyBookItem, view);
            }
        });
        if (com.martian.libsupport.k.p(tyBookItem.getRankDesc())) {
            this.A.p.setVisibility(showRankDesc ? 4 : 8);
        } else {
            this.A.p.setVisibility(0);
            this.A.p.setText(tyBookItem.getRankDesc());
        }
        Z(tyBookItem);
    }

    private void j0(final TYBookItem tyBookItem, boolean showRankDesc) {
        com.martian.libmars.utils.n0.z(this.f10082a, tyBookItem.getCoverUrl(), this.A.n, 2, MiConfigSingleton.V3().i3());
        if (!com.martian.libsupport.k.p(tyBookItem.getBookName())) {
            this.A.t.setText(tyBookItem.getBookName());
        }
        this.A.n.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r3.this.X(tyBookItem, view);
            }
        });
        if (com.martian.libsupport.k.p(tyBookItem.getRankDesc())) {
            this.A.q.setVisibility(showRankDesc ? 4 : 8);
        } else {
            this.A.q.setVisibility(0);
            this.A.q.setText(tyBookItem.getRankDesc());
        }
        Z(tyBookItem);
    }

    private void x(List<TYBookItem> tyBookItems) {
        boolean z;
        int i2 = 0;
        while (true) {
            if (i2 >= 3) {
                z = false;
                break;
            } else {
                if (!com.martian.libsupport.k.p(tyBookItems.get(i2).getRankDesc())) {
                    z = true;
                    break;
                }
                i2++;
            }
        }
        e0(true);
        h0(tyBookItems.get(0), z);
        i0(tyBookItems.get(1), z);
        j0(tyBookItems.get(2), z);
    }

    private void y() {
        if (this.C == null) {
            MiConfigSingleton.V3().l3().l3(this.t, new b());
        } else {
            m();
        }
    }

    @Override // com.martian.libmars.f.e
    protected void c() {
        y();
    }

    public void c0() {
        if (com.martian.libmars.utils.n0.C(this.f10082a)) {
            p();
            n4 n4Var = this.x;
            if (n4Var == null || n4Var.getSize() <= 0) {
                this.z.f12877d.setLoadingTip(LoadingTip.LoadStatus.error);
            }
        }
    }

    public void d0() {
        if (com.martian.libmars.utils.n0.C(this.f10082a) && this.x.E().isRefresh() && this.x.getSize() <= 0) {
            this.z.f12877d.setLoadingTip(LoadingTip.LoadStatus.loading);
        }
    }

    @Override // com.martian.libmars.f.h
    public int h() {
        return R.layout.fragment_book_rank;
    }

    @Override // com.martian.libmars.f.h
    public void m() {
        this.u = 0;
        f0();
        this.x.E().setRefresh(true);
        z();
    }

    @Override // com.martian.libmars.widget.recyclerview.f.a
    public void onLoadMore(View loadMoreView) {
        if (com.martian.libmars.utils.n0.C(this.f10082a)) {
            this.x.E().setRefresh(this.x.getSize() <= 0);
            this.z.f12878e.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
            z();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(MagicIndicator.f10218a, this.r);
        outState.putInt(f13246j, this.t);
        outState.putString(BookRankActivity.F, GsonUtils.b().toJson(this.s));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull final View baseView, Bundle savedInstanceState) {
        String str;
        super.onViewCreated(baseView, savedInstanceState);
        if (savedInstanceState != null) {
            this.r = savedInstanceState.getInt(MagicIndicator.f10218a, 0);
            this.t = savedInstanceState.getInt(f13246j);
            str = savedInstanceState.getString(BookRankActivity.F);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.r = arguments.getInt(MagicIndicator.f10218a, 0);
                this.t = arguments.getInt(f13246j);
                str = arguments.getString(BookRankActivity.F);
            } else {
                str = "";
            }
        }
        if (!com.martian.libsupport.k.p(str)) {
            this.s = (BookRankActivity.a) GsonUtils.b().fromJson(str, BookRankActivity.a.class);
        }
        if (this.s == null) {
            this.s = new BookRankActivity.a();
        }
        this.z = com.martian.mibook.e.w2.a(g());
        n4 n4Var = new n4(this.f10082a);
        this.x = n4Var;
        n4Var.Y(this.s);
        this.x.X(true);
        this.z.f12878e.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        this.z.f12878e.setLayoutManager(new LinearLayoutManager(this.f10082a));
        this.z.f12878e.setOnLoadMoreListener(this);
        this.z.f12878e.m(G());
        this.z.f12878e.setAdapter(this.x);
        this.z.f12878e.addOnScrollListener(new a());
        this.z.f12877d.setOnReloadListener(new LoadingTip.b() { // from class: com.martian.mibook.f.k3
            @Override // com.martian.libmars.widget.recyclerview.LoadingTip.b
            public final void a() {
                r3.this.m();
            }
        });
        this.z.f12876c.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r3.this.R(view);
            }
        });
        H();
        YWFreeType q2 = MiConfigSingleton.V3().l3().q2(this.t);
        this.C = q2;
        b0(q2);
    }

    @Override // com.martian.libmars.f.e, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        n4 n4Var = this.x;
        if (n4Var != null) {
            n4Var.Q(this.z.f12878e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void z() {
        if (f()) {
            c cVar = new c();
            ((YWRankBooksParams) cVar.k()).setCtype(Integer.valueOf(this.t));
            ((YWRankBooksParams) cVar.k()).setBrtype(Integer.valueOf(this.s.a()));
            ((YWRankBooksParams) cVar.k()).setStatus(Integer.valueOf(this.s.h()));
            ((YWRankBooksParams) cVar.k()).setPage(Integer.valueOf(this.u));
            if (this.A.f12956e.getSelectPosition() > 0) {
                ((YWRankBooksParams) cVar.k()).setCategory(com.martian.libmars.d.h.F().n0(this.A.f12956e.getSelectedItem()));
            }
            cVar.j();
        }
    }
}
