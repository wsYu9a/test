package com.martian.mibook.f.f4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.martian.libmars.utils.n0;
import com.martian.libmars.widget.recyclerview.LoadMoreFooterView;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.e.c3;
import com.martian.mibook.e.e2;
import com.martian.mibook.lib.yuewen.request.YWCategoryBookListParams;
import com.martian.mibook.lib.yuewen.response.TYTag;
import com.martian.mibook.lib.yuewen.response.YWCategoryBookList;
import com.martian.mibook.lib.yuewen.response.YWFreeType;
import com.martian.mibook.ui.FlowLayout;
import com.martian.mibook.ui.o.n4;
import com.martian.ttbookhd.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class j0 extends com.martian.libmars.f.h implements com.martian.libmars.widget.recyclerview.f.a {
    public static int A = 13;

    /* renamed from: j */
    public static final String f13133j = "intent_expose_type";
    public static final String k = "INTENT_TAG";
    public static String l = "分类";
    public static String m = "搜索推荐";
    public static String n = "搜索推荐-更多";
    public static String o = "搜索-热门标签";
    public static String p = "书籍详情";
    public static String q = "阅读封面";
    public static String r = "阅读尾页";
    public static String s = "书城";
    public static int t = 2;
    public static int u = 3;
    public static int v = 4;
    public static int w = 5;
    public static int x = 7;
    public static int y = 9;
    public static int z = 11;
    private n4 C;
    private String E;
    private int J;
    private c3 U;
    private e2 V;
    private List<TYTag> W;
    private int B = 0;
    private Integer D = 1;
    private final List<String> F = new ArrayList();
    private final List<String> G = new ArrayList();
    private final List<String> H = new ArrayList();
    private final List<String> I = new ArrayList();
    private final int K = 0;
    private final int L = 1;
    private final int M = 2;
    private int N = 0;
    private int O = 0;
    private int P = 0;
    private Integer Q = null;
    private Integer R = null;
    private int S = 0;
    private int T = 0;

    class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) j0.this.U.f11791d.getLayoutManager();
            if (linearLayoutManager != null) {
                if (linearLayoutManager.findFirstVisibleItemPosition() < 2) {
                    j0.this.U.f11790c.setVisibility(8);
                    ((com.martian.libmars.f.e) j0.this).f10082a.d2(true);
                } else {
                    j0.this.U.f11790c.setVisibility(0);
                    j0.this.U.f11789b.setText(j0.this.E());
                    ((com.martian.libmars.f.e) j0.this).f10082a.d2(false);
                }
            }
        }
    }

    class b implements MiBookManager.z {
        b() {
        }

        @Override // com.martian.mibook.application.MiBookManager.z
        public void a(YWFreeType ywFreeType) {
            j0.this.W = MiConfigSingleton.V3().l3().m2(j0.this.E, j0.this.D.intValue());
            j0.this.L();
        }

        @Override // com.martian.mibook.application.MiBookManager.z
        public void b() {
            j0.this.L();
        }
    }

    class c extends com.martian.mibook.lib.yuewen.e.g {
        c() {
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            j0.this.X(errorResult);
        }

        @Override // b.d.c.c.b
        /* renamed from: q */
        public void onDataReceived(YWCategoryBookList ywCategoryBookList) {
            j0.this.W(ywCategoryBookList);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            if (show) {
                j0 j0Var = j0.this;
                j0Var.a0(j0Var.getString(R.string.loading));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void D() {
        if (f()) {
            c cVar = new c();
            ((YWCategoryBookListParams) cVar.k()).setTags(com.martian.libmars.d.h.F().n0(this.E));
            if (this.V.f11892c.getSelectPosition() > 0 && this.V.f11892c.getSelectPosition() <= this.W.size()) {
                ((YWCategoryBookListParams) cVar.k()).setCategoryId(this.W.get(this.V.f11892c.getSelectPosition() - 1).getCategoryId());
            }
            ((YWCategoryBookListParams) cVar.k()).setFreeType(this.D);
            ((YWCategoryBookListParams) cVar.k()).setPage(Integer.valueOf(this.B));
            ((YWCategoryBookListParams) cVar.k()).setWordCountLower(this.Q);
            ((YWCategoryBookListParams) cVar.k()).setWordCountUpper(this.R);
            ((YWCategoryBookListParams) cVar.k()).setStatus(Integer.valueOf(this.S));
            ((YWCategoryBookListParams) cVar.k()).setOrder(Integer.valueOf(this.T));
            ((YWCategoryBookListParams) cVar.k()).setFrom(this.J);
            cVar.j();
        }
    }

    public String E() {
        String str;
        e2 e2Var = this.V;
        if (e2Var == null || e2Var.f11892c.getSelectPosition() == 0) {
            str = "";
        } else {
            str = this.F.get(this.V.f11892c.getSelectPosition()) + "·";
        }
        return str + F() + H() + G();
    }

    private String F() {
        int i2 = this.N;
        if (i2 == 1) {
            return this.f10082a.getString(R.string.number_word1) + "·";
        }
        if (i2 == 2) {
            return this.f10082a.getString(R.string.number_word2) + "·";
        }
        if (i2 != 3) {
            return "";
        }
        return this.f10082a.getString(R.string.number_word3) + "·";
    }

    private String G() {
        if (n0.c(this.f10082a)) {
            return "";
        }
        int i2 = this.P;
        return i2 != 1 ? i2 != 2 ? this.f10082a.getString(R.string.top_search) : this.f10082a.getString(R.string.grade) : this.f10082a.getString(R.string.yw_finished_books_recently);
    }

    private String H() {
        int i2 = this.O;
        if (i2 == 1) {
            return this.f10082a.getString(R.string.bookstores_finish) + "·";
        }
        if (i2 != 2) {
            return "";
        }
        return this.f10082a.getString(R.string.serialise) + "·";
    }

    public static String I(int exposeType) {
        return t == exposeType ? l : u == exposeType ? m : v == exposeType ? n : w == exposeType ? o : x == exposeType ? p : y == exposeType ? q : z == exposeType ? r : A == exposeType ? s : "";
    }

    private int J(int type) {
        return type == 0 ? this.N : type == 1 ? this.O : this.P;
    }

    private View K() {
        View inflate = View.inflate(this.f10082a, R.layout.category_list_top, null);
        e2 a2 = e2.a(inflate);
        this.V = a2;
        a2.f11893d.setOnItemTitleClickListener(new FlowLayout.a() { // from class: com.martian.mibook.f.f4.w
            @Override // com.martian.mibook.ui.FlowLayout.a
            public final void a(String str, int i2) {
                j0.this.N(str, i2);
            }
        });
        this.V.f11895f.setOnItemTitleClickListener(new FlowLayout.a() { // from class: com.martian.mibook.f.f4.x
            @Override // com.martian.mibook.ui.FlowLayout.a
            public final void a(String str, int i2) {
                j0.this.P(str, i2);
            }
        });
        this.V.f11894e.setOnItemTitleClickListener(new FlowLayout.a() { // from class: com.martian.mibook.f.f4.z
            @Override // com.martian.mibook.ui.FlowLayout.a
            public final void a(String str, int i2) {
                j0.this.R(str, i2);
            }
        });
        this.V.f11892c.setOnItemTitleClickListener(new FlowLayout.a() { // from class: com.martian.mibook.f.f4.a0
            @Override // com.martian.mibook.ui.FlowLayout.a
            public final void a(String str, int i2) {
                j0.this.T(str, i2);
            }
        });
        return inflate;
    }

    public void L() {
        if (n0.c(this.f10082a)) {
            return;
        }
        this.G.add(this.f10082a.getString(R.string.withdraw_money_all));
        this.G.add(this.f10082a.getString(R.string.number_word1));
        this.G.add(this.f10082a.getString(R.string.number_word2));
        this.G.add(this.f10082a.getString(R.string.number_word3));
        this.V.f11893d.setData(this.G);
        this.H.add(this.f10082a.getString(R.string.withdraw_money_all));
        this.H.add(this.f10082a.getString(R.string.bookstores_finish));
        this.H.add(this.f10082a.getString(R.string.serialise));
        this.V.f11895f.setData(this.H);
        this.I.add(this.f10082a.getString(R.string.top_search));
        this.I.add(this.f10082a.getString(R.string.yw_finished_books_recently));
        this.I.add(this.f10082a.getString(R.string.grade));
        this.V.f11894e.setData(this.I);
        if (this.W.size() > 1) {
            this.F.add(this.f10082a.getString(R.string.withdraw_money_all));
            Iterator<TYTag> it = this.W.iterator();
            while (it.hasNext()) {
                this.F.add(it.next().getCategoryName());
            }
            this.V.f11892c.setData(this.F);
        }
        this.V.f11891b.setVisibility(0);
        m();
    }

    /* renamed from: M */
    public /* synthetic */ void N(String title, int position) {
        c0(0, position);
    }

    /* renamed from: O */
    public /* synthetic */ void P(String title, int position) {
        c0(1, position);
    }

    /* renamed from: Q */
    public /* synthetic */ void R(String title, int position) {
        c0(2, position);
    }

    /* renamed from: S */
    public /* synthetic */ void T(String titleName, int position) {
        m();
    }

    /* renamed from: U */
    public /* synthetic */ void V(View view) {
        if (this.C.getSize() <= 100) {
            this.U.f11791d.smoothScrollToPosition(0);
        } else {
            this.U.f11791d.scrollToPosition(0);
        }
    }

    public void W(YWCategoryBookList ywCategoryBookList) {
        if (n0.c(this.f10082a)) {
            return;
        }
        p();
        if (ywCategoryBookList == null || ywCategoryBookList.getBookList() == null || ywCategoryBookList.getBookList().size() <= 0) {
            if (this.C.E().isRefresh()) {
                this.C.clear();
            }
            Z(new b.d.c.b.c(-1, "数据为空"), false);
        } else {
            k();
            if (this.C.E().isRefresh()) {
                this.C.a(ywCategoryBookList.getBookList());
                this.C.Q(this.U.f11791d);
            } else {
                this.C.m(ywCategoryBookList.getBookList());
            }
            this.B++;
        }
    }

    public void X(b.d.c.b.c errorResult) {
        if (n0.c(this.f10082a)) {
            return;
        }
        p();
        Z(errorResult, true);
    }

    private void Y(int type, int position) {
        if (type == 0) {
            this.N = position;
        } else if (type == 1) {
            this.O = position;
        } else {
            this.P = position;
        }
    }

    private void b0(int type) {
        if (type == 0) {
            int i2 = this.N;
            if (i2 == 0) {
                this.Q = null;
                this.R = null;
            } else if (i2 == 1) {
                this.Q = null;
                this.R = 1000000;
            } else if (i2 == 2) {
                this.Q = 1000000;
                this.R = 3000000;
            } else if (i2 == 3) {
                this.Q = 3000000;
                this.R = null;
            }
        } else if (type == 1) {
            int i3 = this.O;
            if (i3 == 0) {
                this.S = 0;
            } else if (i3 == 1) {
                this.S = 50;
            } else if (i3 == 2) {
                this.S = 30;
            }
        } else {
            int i4 = this.P;
            if (i4 == 0) {
                this.T = 0;
            } else if (i4 == 1) {
                this.T = 1;
            } else if (i4 == 2) {
                this.T = 2;
            }
        }
        m();
    }

    private void c0(int type, int position) {
        if (J(type) != position) {
            Y(type, position);
            b0(type);
        }
    }

    public void Z(b.d.c.b.c errorResult, boolean isError) {
        n4 n4Var = this.C;
        if (n4Var == null || n4Var.getSize() <= 0) {
            if (isError) {
                j(errorResult);
            } else {
                i(errorResult.d());
            }
            n(0, this.V.f11896g.getHeight(), 0, 0);
            this.U.f11791d.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
            return;
        }
        k();
        if (this.C.getSize() >= 3) {
            this.U.f11791d.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
        } else {
            this.U.f11791d.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        }
    }

    public void a0(String title) {
        n4 n4Var = this.C;
        if (n4Var == null || n4Var.getSize() <= 0) {
            l(title);
        }
    }

    @Override // com.martian.libmars.f.e
    protected void c() {
    }

    @Override // com.martian.libmars.f.h
    public int h() {
        return R.layout.fragment_category_list;
    }

    @Override // com.martian.libmars.f.h
    public void m() {
        this.C.E().setRefresh(true);
        this.B = 0;
        s(true);
        D();
    }

    @Override // com.martian.libmars.widget.recyclerview.f.a
    public void onLoadMore(View loadMoreView) {
        this.C.E().setRefresh(this.C.getSize() <= 0);
        this.U.f11791d.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
        D();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(MiConfigSingleton.Q0, this.D.intValue());
        outState.putInt(f13133j, this.J);
        outState.putString(k, this.E);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull final View baseView, Bundle savedInstanceState) {
        super.onViewCreated(baseView, savedInstanceState);
        if (savedInstanceState != null) {
            this.D = Integer.valueOf(savedInstanceState.getInt(MiConfigSingleton.Q0));
            this.J = savedInstanceState.getInt(f13133j);
            this.E = savedInstanceState.getString(k);
        } else {
            Intent intent = this.f10082a.getIntent();
            if (intent != null) {
                this.D = Integer.valueOf(intent.getIntExtra(MiConfigSingleton.Q0, 1));
                this.J = intent.getIntExtra(f13133j, -1);
                this.E = intent.getStringExtra(k);
            }
        }
        this.W = MiConfigSingleton.V3().l3().m2(this.E, this.D.intValue());
        c3 a2 = c3.a(g());
        this.U = a2;
        a2.f11790c.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.f4.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j0.this.V(view);
            }
        });
        this.C = new n4(this.f10082a);
        String I = I(this.J);
        if (!com.martian.libsupport.k.p(I)) {
            com.martian.mibook.lib.model.g.b.f0(this.f10082a, I + "-" + this.E);
        }
        this.U.f11791d.setLayoutManager(new LinearLayoutManager(getContext()));
        this.U.f11791d.setAdapter(this.C);
        this.U.f11791d.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        this.U.f11791d.setOnLoadMoreListener(this);
        this.U.f11791d.addOnScrollListener(new a());
        this.U.f11791d.m(K());
        if (this.W.isEmpty()) {
            MiConfigSingleton.V3().l3().l3(this.D.intValue(), new b());
        } else {
            L();
        }
    }
}
