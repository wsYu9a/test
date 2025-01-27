package com.martian.mibook.f.f4;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.martian.libmars.utils.n0;
import com.martian.libmars.widget.recyclerview.LoadMoreFooterView;
import com.martian.mibook.activity.Homepage;
import com.martian.mibook.activity.book.BookRankActivity;
import com.martian.mibook.activity.book.FinishedOrNewBooksActivity;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.v0;
import com.martian.mibook.e.h1;
import com.martian.mibook.e.t3;
import com.martian.mibook.e.x2;
import com.martian.mibook.j.s2;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.yuewen.request.YWBookMallParams;
import com.martian.mibook.lib.yuewen.response.YWBookChannel;
import com.martian.mibook.lib.yuewen.response.YWBookMall;
import com.martian.mibook.ui.o.r3;
import com.martian.ttbookhd.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* loaded from: classes3.dex */
public class e0 extends com.martian.libmars.f.h implements com.martian.libmars.widget.recyclerview.f.a {

    /* renamed from: j */
    public static final String f13106j = "BOOK_MALL_TID";
    public static final String k = "BOOK_MALL_TITLE";
    public static final String l = "book_mall_fullscreen";
    public static final int m = 0;
    public static final int n = 1;
    public static final int o = 2;
    public static final int p = 3;
    public static int q = 5;
    public static int r = 6;
    private r3 A;
    private t3 B;
    private boolean C;
    private com.martian.libmars.b.d s;
    private int x;
    private boolean y;
    private x2 z;
    private int t = 0;
    private int u = new Random().nextInt(10000);
    private int v = 1;
    private int w = 0;
    private boolean D = false;
    private boolean E = false;

    class a implements r3.g {
        a() {
        }

        @Override // com.martian.mibook.ui.o.r3.g
        public void a() {
            MiConfigSingleton.V3().J7(false);
            e0.this.C = true;
        }

        @Override // com.martian.mibook.ui.o.r3.g
        public void b() {
            MiConfigSingleton.V3().J7(false);
            e0.this.s.d(v0.n, 0);
        }
    }

    class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager != null && e0.this.D && linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0) {
                e0.this.D = false;
                e0.this.w = 0;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            e0.this.w += dy;
            if (e0.this.A != null && e0.this.A.K0()) {
                e0.this.z.f12924b.setAlpha(e0.this.w / com.martian.libmars.d.h.b(80.0f));
            }
            e0 e0Var = e0.this;
            e0Var.o0(e0Var.w > com.martian.libmars.d.h.b(180.0f));
        }
    }

    class c extends com.martian.mibook.lib.account.d.g<YWBookMallParams, YWBookMall> {
        c(Class x0, Class x1, Context x2) {
            super(x0, x1, x2);
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            e0.this.m0(errorResult);
        }

        @Override // b.d.c.c.i, b.d.c.c.c
        public void onUDDataReceived(List<YWBookMall> ywBookMalls) {
            if (ywBookMalls == null || ywBookMalls.isEmpty()) {
                e0.this.m0(new b.d.c.b.c(-1, "数据为空"));
            } else {
                e0.this.g0(ywBookMalls.get(0));
            }
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            if (show) {
                e0 e0Var = e0.this;
                e0Var.k0(e0Var.getString(R.string.loading));
            }
        }
    }

    private void F() {
        if (L()) {
            this.z.f12925c.E();
            View inflate = this.f10082a.getLayoutInflater().inflate(R.layout.bookmall_icons, (ViewGroup) null);
            h1 a2 = h1.a(inflate);
            a2.f12046e.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.f4.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e0.this.O(view);
                }
            });
            a2.f12043b.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.f4.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e0.this.Q(view);
                }
            });
            a2.f12044c.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.f4.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e0.this.S(view);
                }
            });
            a2.f12045d.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.f4.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e0.this.U(view);
                }
            });
            this.z.f12925c.m(inflate);
        }
    }

    private void G() {
        com.martian.libmars.b.d dVar = new com.martian.libmars.b.d();
        this.s = dVar;
        dVar.c(v0.l, new rx.k.b() { // from class: com.martian.mibook.f.f4.j
            @Override // rx.k.b
            public final void call(Object obj) {
                e0.this.W((Integer) obj);
            }
        });
        this.s.c(v0.n, new rx.k.b() { // from class: com.martian.mibook.f.f4.g
            @Override // rx.k.b
            public final void call(Object obj) {
                e0.this.Y((Integer) obj);
            }
        });
    }

    private int H() {
        return this.x;
    }

    private String I() {
        if (L()) {
            return "MIBOOK_BOOKMALL_NORMAL";
        }
        if (M()) {
            return "MIBOOK_BOOKMALL_RECOMMEND";
        }
        if (K()) {
            return "MIBOOK_BOOKMALL_LITERATURE";
        }
        return "MIBOOK_BOOKMALL_" + this.v;
    }

    private void J() {
        final MiReadingRecord Q3;
        if (this.B != null || (Q3 = MiConfigSingleton.V3().Q3()) == null) {
            return;
        }
        this.z.f12926d.setLayoutResource(R.layout.layout_reading_record);
        this.B = t3.a(this.z.f12926d.inflate());
        Book S = MiConfigSingleton.V3().l3().S(com.martian.mibook.lib.model.manager.d.k(Q3.getSourceString()));
        if (S != null) {
            MiBookManager.d2(this.f10082a, S, this.B.f12731c);
        }
        this.B.f12730b.setText(Q3.getBookName());
        this.B.f12734f.setText(Q3.getChapterTitle());
        this.B.f12733e.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.f4.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e0.this.a0(Q3, view);
            }
        });
        this.B.f12732d.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.f4.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e0.this.c0(view);
            }
        });
        new Handler().postDelayed(new Runnable() { // from class: com.martian.mibook.f.f4.c
            @Override // java.lang.Runnable
            public final void run() {
                e0.this.e0();
            }
        }, 10000L);
    }

    private boolean K() {
        return this.v == 3;
    }

    private boolean L() {
        int i2 = this.v;
        return i2 == 1 || i2 == 2;
    }

    private boolean M() {
        return this.v == 0;
    }

    /* renamed from: N */
    public /* synthetic */ void O(View v) {
        com.martian.mibook.lib.model.g.b.A(this.f10082a, "榜单");
        BookRankActivity.v2(this.f10082a, H());
    }

    /* renamed from: P */
    public /* synthetic */ void Q(View v) {
        com.martian.mibook.lib.model.g.b.A(this.f10082a, "分类");
        this.s.d(v0.o, Integer.valueOf(H() == 1 ? 0 : 1));
    }

    /* renamed from: R */
    public /* synthetic */ void S(View v) {
        com.martian.mibook.lib.model.g.b.A(this.f10082a, Book.STATUS_FINISHED);
        if (MiConfigSingleton.V3().k() != H()) {
            FinishedOrNewBooksActivity.startActivity(this.f10082a, q, H(), Book.STATUS_FINISHED);
            return;
        }
        com.martian.apptask.g.g.t(this.f10082a, getString(R.string.scheme) + "://m.taoyuewenhua.com/homepage?tab=1&tid=" + q);
    }

    /* renamed from: T */
    public /* synthetic */ void U(View v) {
        com.martian.mibook.lib.model.g.b.A(this.f10082a, "新书");
        if (MiConfigSingleton.V3().k() != H()) {
            FinishedOrNewBooksActivity.startActivity(this.f10082a, r, H(), "新书");
            return;
        }
        com.martian.apptask.g.g.t(this.f10082a, getString(R.string.scheme) + "://m.taoyuewenhua.com/homepage?tab=1&tid=" + r);
    }

    /* renamed from: V */
    public /* synthetic */ void W(Integer position) {
        r3 r3Var;
        if (position != null) {
            if (position.intValue() == v0.B) {
                if (b()) {
                    i0();
                    s(true);
                    m();
                    return;
                }
                return;
            }
            if (position.intValue() != v0.C || (r3Var = this.A) == null) {
                return;
            }
            r3Var.y0();
            this.A.notifyDataSetChanged();
        }
    }

    /* renamed from: X */
    public /* synthetic */ void Y(Integer position) {
        h0();
        m();
    }

    /* renamed from: Z */
    public /* synthetic */ void a0(final MiReadingRecord readingRecord, View v) {
        if (s2.j0(this.f10082a, readingRecord)) {
            return;
        }
        this.f10082a.k1("无效的书籍记录");
        this.B.getRoot().setVisibility(8);
    }

    /* renamed from: b0 */
    public /* synthetic */ void c0(View v) {
        this.B.getRoot().setVisibility(8);
    }

    /* renamed from: d0 */
    public /* synthetic */ void e0() {
        this.B.getRoot().setVisibility(8);
    }

    public static e0 f0(int tid, int ctype, boolean fullscreen) {
        e0 e0Var = new e0();
        Bundle bundle = new Bundle();
        bundle.putInt(f13106j, tid);
        bundle.putInt(MiConfigSingleton.Q0, ctype);
        bundle.putBoolean(l, fullscreen);
        e0Var.setArguments(bundle);
        return e0Var;
    }

    public void g0(YWBookMall ywBookMall) {
        if (n0.c(this.f10082a)) {
            return;
        }
        this.t++;
        if (L()) {
            MiConfigSingleton.V3().l3().d3(ywBookMall, H());
        }
        if (ywBookMall.getShowHeaderIcon()) {
            F();
        }
        E(ywBookMall, false);
    }

    private void h0() {
        if (L()) {
            int i2 = this.v == 1 ? 2 : 1;
            this.v = i2;
            this.x = i2;
        }
    }

    private void i0() {
        if (this.t <= 2) {
            this.z.f12925c.smoothScrollToPosition(0);
            this.D = true;
        } else {
            this.z.f12925c.scrollToPosition(0);
            this.w = 0;
        }
    }

    public void m0(b.d.c.b.c errorResult) {
        if (this.t > 0 || !L()) {
            j0(errorResult, true);
        } else {
            E(MiConfigSingleton.V3().l3().I2(H()), true);
        }
    }

    private void n0(boolean withTopPadding) {
        this.z.f12925c.setPadding(0, withTopPadding ? com.martian.libmars.d.h.b(44.0f) + this.f10082a.F0() : 0, 0, 0);
    }

    public void o0(boolean tabStatus) {
        if (this.E == tabStatus) {
            return;
        }
        this.E = tabStatus;
        if (getActivity() instanceof Homepage) {
            ((Homepage) getActivity()).d3(this.E);
        }
    }

    private boolean p0() {
        return MiConfigSingleton.V3().A6() && this.v == MiConfigSingleton.V3().k() && !this.C;
    }

    public void E(YWBookMall ywBookMall, boolean fromError) {
        if (n0.C(this.f10082a)) {
            p();
            k();
            if (ywBookMall == null || ywBookMall.getChannelList() == null || ywBookMall.getChannelList().size() <= 0) {
                if (fromError) {
                    j0(new b.d.c.b.c(-1, "网络异常"), true);
                    return;
                } else {
                    j0(new b.d.c.b.c(-1, "数据为空"), false);
                    return;
                }
            }
            List<YWBookChannel> channelList = ywBookMall.getChannelList();
            this.z.f12925c.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
            if (!this.A.E().isRefresh()) {
                if (channelList.size() == 1 && com.martian.libsupport.k.p(channelList.get(0).getTitle())) {
                    this.A.S(channelList.get(0));
                    return;
                } else {
                    this.A.m(channelList);
                    return;
                }
            }
            if (M()) {
                YWBookChannel yWBookChannel = channelList.get(0);
                n0(yWBookChannel == null || yWBookChannel.getLayoutType() != 2);
            } else if (p0() && channelList.size() > 1 && !channelList.get(1).getMcid().equals(Integer.valueOf(r3.t))) {
                channelList.add(1, new YWBookChannel().setMcid(Integer.valueOf(r3.t)).setTitle(getString(R.string.choose_gender)));
            }
            if (!MiConfigSingleton.V3().Q6()) {
                Iterator<YWBookChannel> it = channelList.iterator();
                while (it.hasNext()) {
                    YWBookChannel next = it.next();
                    if ("猜你喜欢".equalsIgnoreCase(next.getTitle()) || "为你推荐".equalsIgnoreCase(next.getTitle())) {
                        it.remove();
                    }
                }
            }
            this.A.a(channelList);
            this.A.y0();
            this.A.X(this.z.f12925c);
        }
    }

    @Override // com.martian.libmars.f.e
    protected void c() {
        if (this.v == 0) {
            return;
        }
        this.t = 0;
        l0();
    }

    @Override // com.martian.libmars.f.h
    public int h() {
        return R.layout.fragment_bookmall;
    }

    public void j0(b.d.c.b.c errorResult, boolean isError) {
        p();
        r3 r3Var = this.A;
        if (r3Var != null && r3Var.getSize() > 0) {
            k();
            this.z.f12925c.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
        } else {
            if (isError) {
                j(errorResult);
            } else {
                i(errorResult.d());
            }
            this.z.f12925c.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        }
    }

    public void k0(String title) {
        r3 r3Var = this.A;
        if (r3Var == null || r3Var.getSize() > 0) {
            return;
        }
        l(title);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void l0() {
        if (f()) {
            if (!MiConfigSingleton.V3().Q6() && this.t > 0) {
                j0(new b.d.c.b.c(-1, "到底了"), false);
                return;
            }
            c cVar = new c(YWBookMallParams.class, YWBookMall.class, this.f10082a);
            ((YWBookMallParams) cVar.k()).setSeed(Integer.valueOf(this.u));
            ((YWBookMallParams) cVar.k()).setPage(Integer.valueOf(this.t));
            ((YWBookMallParams) cVar.k()).setCtype(Integer.valueOf(H()));
            ((YWBookMallParams) cVar.k()).setTid(Integer.valueOf(this.v));
            ((YWBookMallParams) cVar.k()).setCount(Integer.valueOf(com.martian.libmars.d.h.F().B0(I())));
            cVar.j();
        }
    }

    @Override // com.martian.libmars.f.h
    public void m() {
        if (n0.C(this.f10082a)) {
            this.u = new Random().nextInt(10000);
            this.A.E().setRefresh(true);
            this.A.J0(this.u);
            this.t = 0;
            l0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        com.martian.libmars.b.d dVar = this.s;
        if (dVar != null) {
            dVar.b();
        }
    }

    @Override // com.martian.libmars.widget.recyclerview.f.a
    public void onLoadMore(View loadMoreView) {
        if (!n0.C(this.f10082a) || this.t == 0) {
            return;
        }
        this.A.E().setRefresh(this.A.getSize() <= 0);
        this.z.f12925c.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
        l0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(f13106j, this.v);
        outState.putInt(MiConfigSingleton.Q0, this.x);
        outState.putBoolean(l, this.y);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull final View baseView, Bundle savedInstanceState) {
        super.onViewCreated(baseView, savedInstanceState);
        this.z = x2.a(g());
        if (savedInstanceState != null) {
            this.v = savedInstanceState.getInt(f13106j, 0);
            this.x = savedInstanceState.getInt(MiConfigSingleton.Q0, 1);
            this.y = savedInstanceState.getBoolean(l, true);
        } else if (getArguments() != null) {
            this.v = getArguments().getInt(f13106j, 0);
            this.x = getArguments().getInt(MiConfigSingleton.Q0, 1);
            this.y = getArguments().getBoolean(l, true);
        }
        G();
        this.z.f12925c.setLayoutManager(new LinearLayoutManager(getContext()));
        r3 r3Var = new r3(this.f10082a, new ArrayList(), this.u, H());
        this.A = r3Var;
        r3Var.A0(new a());
        this.z.f12925c.setAdapter(this.A);
        this.z.f12925c.setOnLoadMoreListener(this);
        this.z.f12925c.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        this.z.f12925c.addOnScrollListener(new b());
        if (!this.y) {
            n0(false);
            m();
            return;
        }
        ((RelativeLayout.LayoutParams) this.z.f12924b.getLayoutParams()).height = com.martian.libmars.d.h.b(44.0f) + this.f10082a.F0();
        n0(!M());
        if (this.v == 1 && MiConfigSingleton.V3().S2()) {
            J();
        }
    }

    @Override // com.martian.libmars.f.e, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (!isVisibleToUser || this.z == null) {
            return;
        }
        o0(this.w > com.martian.libmars.d.h.b(180.0f));
        r3 r3Var = this.A;
        if (r3Var != null) {
            if (r3Var.getSize() > 0) {
                this.A.X(this.z.f12925c);
            } else if (this.v == 0) {
                this.t = 0;
                l0();
            }
        }
    }
}
