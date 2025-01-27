package com.martian.mibook.f.f4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.utils.n0;
import com.martian.libmars.widget.recyclerview.LoadMoreFooterView;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.e.c3;
import com.martian.mibook.e.e2;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.yuewen.request.YWCategoryBookListParams;
import com.martian.mibook.lib.yuewen.response.TYTag;
import com.martian.mibook.lib.yuewen.response.YWCategory;
import com.martian.mibook.lib.yuewen.response.YWCategoryBookList;
import com.martian.mibook.lib.yuewen.response.YWFreeType;
import com.martian.mibook.ui.FlowLayout;
import com.martian.mibook.ui.o.n4;
import com.martian.ttbookhd.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class g0 extends com.martian.libmars.f.h implements com.martian.libmars.widget.recyclerview.f.a {

    /* renamed from: j */
    public static final String f13118j = "INTENT_SUB_CATEGORY_ID";
    public static final String k = "INTENT_expose_type";
    public static String l = "分类";
    public static String m = "书籍详情";
    public static String n = "阅读封面";
    public static String o = "阅读尾页";
    public static String p = "书城";
    public static String q = "搜索推荐";
    public static String r = "搜索推荐-更多";
    public static int s = 1;
    public static int t = 6;
    public static int u = 8;
    public static int v = 10;
    public static int w = 12;
    public static int x = 14;
    public static int y = 15;
    private n4 A;
    private YWCategory C;
    private int H;
    private int I;
    private c3 T;
    private e2 U;
    private int z = 0;
    private Integer B = 1;
    private final List<String> D = new ArrayList();
    private final List<String> E = new ArrayList();
    private final List<String> F = new ArrayList();
    private final List<String> G = new ArrayList();
    private final int J = 0;
    private final int K = 1;
    private final int L = 2;
    private int M = 0;
    private int N = 0;
    private int O = 0;
    private Integer P = null;
    private Integer Q = null;
    private int R = 0;
    private int S = 0;

    class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) g0.this.T.f11791d.getLayoutManager();
            if (linearLayoutManager != null) {
                if (linearLayoutManager.findFirstVisibleItemPosition() < 2) {
                    g0.this.T.f11790c.setVisibility(8);
                    ((com.martian.libmars.f.e) g0.this).f10082a.d2(true);
                } else {
                    g0.this.T.f11790c.setVisibility(0);
                    g0.this.T.f11789b.setText(g0.this.E());
                    ((com.martian.libmars.f.e) g0.this).f10082a.d2(false);
                }
            }
        }
    }

    class b implements MiBookManager.z {
        b() {
        }

        @Override // com.martian.mibook.application.MiBookManager.z
        public void a(YWFreeType ywFreeType) {
            if (n0.c(((com.martian.libmars.f.e) g0.this).f10082a)) {
                return;
            }
            Iterator<YWCategory> it = ywFreeType.getCategoryList().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                YWCategory next = it.next();
                if (g0.this.C.getCategoryId() == next.getCategoryId()) {
                    g0.this.C = next;
                    break;
                }
            }
            g0.this.L();
        }

        @Override // com.martian.mibook.application.MiBookManager.z
        public void b() {
            g0.this.L();
        }
    }

    class c extends com.martian.mibook.lib.yuewen.e.g {
        c() {
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            g0.this.X(errorResult);
        }

        @Override // b.d.c.c.b
        /* renamed from: q */
        public void onDataReceived(YWCategoryBookList ywCategoryBookList) {
            g0.this.W(ywCategoryBookList);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            if (show) {
                g0 g0Var = g0.this;
                g0Var.a0(g0Var.getString(R.string.loading));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void D() {
        if (f()) {
            c cVar = new c();
            if (this.U.f11892c.getSelectPosition() > 0 && this.U.f11892c.getSelectPosition() < this.D.size()) {
                ((YWCategoryBookListParams) cVar.k()).setTags(this.D.get(this.U.f11892c.getSelectPosition()));
            }
            ((YWCategoryBookListParams) cVar.k()).setFreeType(this.B);
            ((YWCategoryBookListParams) cVar.k()).setCategoryId(Integer.valueOf(this.C.getCategoryId()));
            ((YWCategoryBookListParams) cVar.k()).setPage(Integer.valueOf(this.z));
            ((YWCategoryBookListParams) cVar.k()).setWordCountLower(this.P);
            ((YWCategoryBookListParams) cVar.k()).setWordCountUpper(this.Q);
            ((YWCategoryBookListParams) cVar.k()).setStatus(Integer.valueOf(this.R));
            ((YWCategoryBookListParams) cVar.k()).setOrder(Integer.valueOf(this.S));
            ((YWCategoryBookListParams) cVar.k()).setFrom(this.I);
            cVar.j();
        }
    }

    public String E() {
        String str;
        e2 e2Var = this.U;
        if (e2Var == null || e2Var.f11892c.getSelectPosition() == 0) {
            str = "";
        } else {
            str = this.D.get(this.U.f11892c.getSelectPosition()) + "·";
        }
        return str + F() + H() + G();
    }

    private String F() {
        int i2 = this.M;
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
        int i2 = this.O;
        return i2 != 1 ? i2 != 2 ? this.f10082a.getString(R.string.top_search) : this.f10082a.getString(R.string.grade) : this.f10082a.getString(R.string.yw_finished_books_recently);
    }

    private String H() {
        int i2 = this.N;
        if (i2 == 1) {
            return this.f10082a.getString(R.string.bookstores_finish) + "·";
        }
        if (i2 != 2) {
            return "";
        }
        return this.f10082a.getString(R.string.serialise) + "·";
    }

    public static String I(int exposeType) {
        return s == exposeType ? l : t == exposeType ? m : u == exposeType ? n : v == exposeType ? o : w == exposeType ? p : x == exposeType ? q : y == exposeType ? r : "";
    }

    private int J(int type) {
        return type == 0 ? this.M : type == 1 ? this.N : this.O;
    }

    private View K() {
        View inflate = View.inflate(this.f10082a, R.layout.category_list_top, null);
        e2 a2 = e2.a(inflate);
        this.U = a2;
        a2.f11893d.setOnItemTitleClickListener(new FlowLayout.a() { // from class: com.martian.mibook.f.f4.p
            @Override // com.martian.mibook.ui.FlowLayout.a
            public final void a(String str, int i2) {
                g0.this.N(str, i2);
            }
        });
        this.U.f11895f.setOnItemTitleClickListener(new FlowLayout.a() { // from class: com.martian.mibook.f.f4.q
            @Override // com.martian.mibook.ui.FlowLayout.a
            public final void a(String str, int i2) {
                g0.this.P(str, i2);
            }
        });
        this.U.f11894e.setOnItemTitleClickListener(new FlowLayout.a() { // from class: com.martian.mibook.f.f4.s
            @Override // com.martian.mibook.ui.FlowLayout.a
            public final void a(String str, int i2) {
                g0.this.R(str, i2);
            }
        });
        this.U.f11892c.setOnItemTitleClickListener(new FlowLayout.a() { // from class: com.martian.mibook.f.f4.r
            @Override // com.martian.mibook.ui.FlowLayout.a
            public final void a(String str, int i2) {
                g0.this.T(str, i2);
            }
        });
        return inflate;
    }

    public void L() {
        if (n0.C(this.f10082a)) {
            this.E.add(this.f10082a.getString(R.string.withdraw_money_all));
            this.E.add(this.f10082a.getString(R.string.number_word1));
            this.E.add(this.f10082a.getString(R.string.number_word2));
            this.E.add(this.f10082a.getString(R.string.number_word3));
            this.U.f11893d.setData(this.E);
            this.F.add(this.f10082a.getString(R.string.withdraw_money_all));
            this.F.add(this.f10082a.getString(R.string.bookstores_finish));
            this.F.add(this.f10082a.getString(R.string.serialise));
            this.U.f11895f.setData(this.F);
            this.G.add(this.f10082a.getString(R.string.top_search));
            this.G.add(this.f10082a.getString(R.string.yw_finished_books_recently));
            this.G.add(this.f10082a.getString(R.string.grade));
            this.U.f11894e.setData(this.G);
            this.D.add(this.f10082a.getString(R.string.withdraw_money_all));
            Iterator<TYTag> it = this.C.getTagList().iterator();
            while (it.hasNext()) {
                this.D.add(it.next().getTag());
            }
            if (this.D.size() > 2) {
                this.U.f11892c.setData(this.D);
            }
            m();
        }
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
        if (this.A.getSize() <= 100) {
            this.T.f11791d.smoothScrollToPosition(0);
        } else {
            this.T.f11791d.scrollToPosition(0);
        }
    }

    public void W(YWCategoryBookList ywCategoryBookList) {
        if (n0.c(this.f10082a)) {
            return;
        }
        p();
        if (ywCategoryBookList == null || ywCategoryBookList.getBookList() == null || ywCategoryBookList.getBookList().size() <= 0) {
            if (this.A.E().isRefresh()) {
                this.A.clear();
            }
            Z(new b.d.c.b.c(-1, "数据为空"), false);
            return;
        }
        if (this.H > 0) {
            for (TYBookItem tYBookItem : ywCategoryBookList.getBookList()) {
                tYBookItem.setRecommend("详情-" + tYBookItem.getRecommend());
            }
        }
        k();
        if (this.A.E().isRefresh()) {
            this.A.a(ywCategoryBookList.getBookList());
            this.A.Q(this.T.f11791d);
        } else {
            this.A.m(ywCategoryBookList.getBookList());
        }
        this.z++;
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
            this.M = position;
        } else if (type == 1) {
            this.N = position;
        } else {
            this.O = position;
        }
    }

    private void b0(int type) {
        if (type == 0) {
            int i2 = this.M;
            if (i2 == 0) {
                this.P = null;
                this.Q = null;
            } else if (i2 == 1) {
                this.P = null;
                this.Q = 1000000;
            } else if (i2 == 2) {
                this.P = 1000000;
                this.Q = 3000000;
            } else if (i2 == 3) {
                this.P = 3000000;
                this.Q = null;
            }
        } else if (type == 1) {
            int i3 = this.N;
            if (i3 == 0) {
                this.R = 0;
            } else if (i3 == 1) {
                this.R = 50;
            } else if (i3 == 2) {
                this.R = 30;
            }
        } else {
            int i4 = this.O;
            if (i4 == 0) {
                this.S = 0;
            } else if (i4 == 1) {
                this.S = 1;
            } else if (i4 == 2) {
                this.S = 2;
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
        n4 n4Var = this.A;
        if (n4Var == null || n4Var.getSize() <= 0) {
            if (isError) {
                j(errorResult);
            } else {
                i(errorResult.d());
            }
            n(0, this.U.f11896g.getHeight(), 0, 0);
            this.T.f11791d.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
            return;
        }
        k();
        if (this.A.getSize() >= 3) {
            this.T.f11791d.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
        } else {
            this.T.f11791d.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        }
    }

    public void a0(String title) {
        n4 n4Var = this.A;
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
        this.A.E().setRefresh(true);
        this.z = 0;
        s(true);
        D();
    }

    @Override // com.martian.libmars.widget.recyclerview.f.a
    public void onLoadMore(View loadMoreView) {
        this.A.E().setRefresh(this.A.getSize() <= 0);
        this.T.f11791d.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
        D();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(MiConfigSingleton.Q0, this.B.intValue());
        outState.putInt(f13118j, this.H);
        outState.putInt(k, this.I);
        outState.putString(MiConfigSingleton.R0, GsonUtils.b().toJson(this.C));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull final View baseView, Bundle savedInstanceState) {
        String str;
        super.onViewCreated(baseView, savedInstanceState);
        if (savedInstanceState != null) {
            this.B = Integer.valueOf(savedInstanceState.getInt(MiConfigSingleton.Q0));
            this.H = savedInstanceState.getInt(f13118j, 0);
            this.I = savedInstanceState.getInt(k);
            str = savedInstanceState.getString(MiConfigSingleton.R0);
        } else {
            Intent intent = this.f10082a.getIntent();
            if (intent != null) {
                this.B = Integer.valueOf(intent.getIntExtra(MiConfigSingleton.Q0, 1));
                this.H = intent.getIntExtra(f13118j, 0);
                this.I = intent.getIntExtra(k, -1);
                str = intent.getStringExtra(MiConfigSingleton.R0);
            } else {
                str = "";
            }
        }
        if (!com.martian.libsupport.k.p(str)) {
            this.C = (YWCategory) GsonUtils.b().fromJson(str, YWCategory.class);
        }
        if (this.C == null) {
            d("获取信息失败");
            this.f10082a.finish();
            return;
        }
        c3 a2 = c3.a(g());
        this.T = a2;
        a2.f11790c.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.f4.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g0.this.V(view);
            }
        });
        this.A = new n4(this.f10082a);
        this.T.f11791d.setLayoutManager(new LinearLayoutManager(getContext()));
        this.T.f11791d.setAdapter(this.A);
        this.T.f11791d.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        this.T.f11791d.setOnLoadMoreListener(this);
        this.T.f11791d.addOnScrollListener(new a());
        this.T.f11791d.m(K());
        if (this.C.getTagList().isEmpty()) {
            MiConfigSingleton.V3().l3().l3(this.B.intValue(), new b());
        } else {
            L();
        }
    }
}
