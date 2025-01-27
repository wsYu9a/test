package com.martian.mibook.fragment.yuewen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ba.l;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.R;
import com.martian.libmars.fragment.StrFragment;
import com.martian.libmars.widget.recyclerview.LoadMoreFooterView;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.CategoryListTopBinding;
import com.martian.mibook.databinding.FragmentCategoryListBinding;
import com.martian.mibook.fragment.yuewen.YWCategoriesBookListFragment;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.yuewen.request.YWCategoryBookListParams;
import com.martian.mibook.lib.yuewen.response.TYTag;
import com.martian.mibook.lib.yuewen.response.YWCategory;
import com.martian.mibook.lib.yuewen.response.YWCategoryBookList;
import com.martian.mibook.lib.yuewen.response.YWFreeType;
import com.martian.mibook.ui.FlowLayout;
import com.martian.mibook.ui.adapter.TYBookItemListAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jc.g;
import l9.m0;

/* loaded from: classes3.dex */
public class YWCategoriesBookListFragment extends StrFragment implements s9.a {
    public static final String G = "INTENT_SUB_CATEGORY_ID";
    public static final String H = "INTENT_expose_type";
    public static String I = "分类";
    public static String J = "书籍详情";
    public static String K = "阅读封面";
    public static String L = "阅读尾页";
    public static String M = "书城";
    public static String N = "搜索推荐";
    public static String O = "搜索推荐-更多";
    public static int P = 1;
    public static int Q = 6;
    public static int R = 8;
    public static int S = 10;
    public static int T = 12;
    public static int U = 14;
    public static int V = 15;
    public FragmentCategoryListBinding E;
    public CategoryListTopBinding F;

    /* renamed from: l */
    public TYBookItemListAdapter f13819l;

    /* renamed from: n */
    public YWCategory f13821n;

    /* renamed from: s */
    public int f13826s;

    /* renamed from: t */
    public int f13827t;

    /* renamed from: k */
    public int f13818k = 0;

    /* renamed from: m */
    public Integer f13820m = 1;

    /* renamed from: o */
    public final List<String> f13822o = new ArrayList();

    /* renamed from: p */
    public final List<String> f13823p = new ArrayList();

    /* renamed from: q */
    public final List<String> f13824q = new ArrayList();

    /* renamed from: r */
    public final List<String> f13825r = new ArrayList();

    /* renamed from: u */
    public final int f13828u = 0;

    /* renamed from: v */
    public final int f13829v = 1;

    /* renamed from: w */
    public final int f13830w = 2;

    /* renamed from: x */
    public int f13831x = 0;

    /* renamed from: y */
    public int f13832y = 0;

    /* renamed from: z */
    public int f13833z = 0;
    public Integer A = null;
    public Integer B = null;
    public int C = 0;
    public int D = 0;

    public class a extends RecyclerView.OnScrollListener {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i10, int i11) {
            super.onScrolled(recyclerView, i10, i11);
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) YWCategoriesBookListFragment.this.E.categoryIrc.getLayoutManager();
            if (linearLayoutManager != null) {
                if (linearLayoutManager.findFirstVisibleItemPosition() < 2) {
                    YWCategoriesBookListFragment.this.E.bookOrderView.setVisibility(8);
                    YWCategoriesBookListFragment.this.n(true);
                } else {
                    YWCategoriesBookListFragment.this.E.bookOrderView.setVisibility(0);
                    YWCategoriesBookListFragment.this.E.bookOrder.setText(YWCategoriesBookListFragment.this.d0());
                    YWCategoriesBookListFragment.this.n(false);
                }
            }
        }
    }

    public class b implements MiBookManager.y {
        public b() {
        }

        @Override // com.martian.mibook.application.MiBookManager.y
        public void a(YWFreeType yWFreeType) {
            if (m0.c(YWCategoriesBookListFragment.this.f12349c)) {
                return;
            }
            Iterator<YWCategory> it = yWFreeType.getCategoryList().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                YWCategory next = it.next();
                if (YWCategoriesBookListFragment.this.f13821n.getCategoryId() == next.getCategoryId()) {
                    YWCategoriesBookListFragment.this.f13821n = next;
                    break;
                }
            }
            YWCategoriesBookListFragment.this.k0();
        }

        @Override // com.martian.mibook.application.MiBookManager.y
        public void b() {
            YWCategoriesBookListFragment.this.k0();
        }
    }

    public class c extends g {
        public c() {
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            YWCategoriesBookListFragment.this.r0(cVar);
        }

        @Override // y8.a
        /* renamed from: r */
        public void onDataReceived(YWCategoryBookList yWCategoryBookList) {
            YWCategoriesBookListFragment.this.q0(yWCategoryBookList);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            if (z10) {
                YWCategoriesBookListFragment yWCategoriesBookListFragment = YWCategoriesBookListFragment.this;
                yWCategoriesBookListFragment.u0(yWCategoriesBookListFragment.getString(R.string.loading));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b0() {
        if (r()) {
            c cVar = new c();
            if (this.F.categoryFlowLayout.getSelectPosition() > 0 && this.F.categoryFlowLayout.getSelectPosition() < this.f13822o.size()) {
                ((YWCategoryBookListParams) cVar.k()).setTags(this.f13822o.get(this.F.categoryFlowLayout.getSelectPosition()));
            }
            ((YWCategoryBookListParams) cVar.k()).setFreeType(this.f13820m);
            ((YWCategoryBookListParams) cVar.k()).setCategoryId(Integer.valueOf(this.f13821n.getCategoryId()));
            ((YWCategoryBookListParams) cVar.k()).setPage(Integer.valueOf(this.f13818k));
            ((YWCategoryBookListParams) cVar.k()).setWordCountLower(this.A);
            ((YWCategoryBookListParams) cVar.k()).setWordCountUpper(this.B);
            ((YWCategoryBookListParams) cVar.k()).setStatus(Integer.valueOf(this.C));
            ((YWCategoryBookListParams) cVar.k()).setOrder(Integer.valueOf(this.D));
            ((YWCategoryBookListParams) cVar.k()).setFrom(this.f13827t);
            cVar.j();
        }
    }

    public String d0() {
        String str;
        CategoryListTopBinding categoryListTopBinding = this.F;
        if (categoryListTopBinding == null || categoryListTopBinding.categoryFlowLayout.getSelectPosition() == 0) {
            str = "";
        } else {
            str = this.f13822o.get(this.F.categoryFlowLayout.getSelectPosition()) + "·";
        }
        return str + e0() + g0() + f0();
    }

    public static String h0(int i10) {
        return P == i10 ? I : Q == i10 ? J : R == i10 ? K : S == i10 ? L : T == i10 ? M : U == i10 ? N : V == i10 ? O : "";
    }

    private View j0() {
        View inflate = View.inflate(this.f12349c, com.martian.mibook.R.layout.category_list_top, null);
        CategoryListTopBinding bind = CategoryListTopBinding.bind(inflate);
        this.F = bind;
        bind.categoryNumberWord.setOnItemTitleClickListener(new FlowLayout.a() { // from class: fb.c
            public /* synthetic */ c() {
            }

            @Override // com.martian.mibook.ui.FlowLayout.a
            public final void a(String str, int i10) {
                YWCategoriesBookListFragment.this.l0(str, i10);
            }
        });
        this.F.categoryStatus.setOnItemTitleClickListener(new FlowLayout.a() { // from class: fb.d
            public /* synthetic */ d() {
            }

            @Override // com.martian.mibook.ui.FlowLayout.a
            public final void a(String str, int i10) {
                YWCategoriesBookListFragment.this.m0(str, i10);
            }
        });
        this.F.categoryOrder.setOnItemTitleClickListener(new FlowLayout.a() { // from class: fb.e
            public /* synthetic */ e() {
            }

            @Override // com.martian.mibook.ui.FlowLayout.a
            public final void a(String str, int i10) {
                YWCategoriesBookListFragment.this.n0(str, i10);
            }
        });
        this.F.categoryFlowLayout.setOnItemTitleClickListener(new FlowLayout.a() { // from class: fb.f
            public /* synthetic */ f() {
            }

            @Override // com.martian.mibook.ui.FlowLayout.a
            public final void a(String str, int i10) {
                YWCategoriesBookListFragment.this.o0(str, i10);
            }
        });
        return inflate;
    }

    public /* synthetic */ void m0(String str, int i10) {
        w0(1, i10);
    }

    public /* synthetic */ void n0(String str, int i10) {
        w0(2, i10);
    }

    public /* synthetic */ void p0(View view) {
        if (this.f13819l.getSize() <= 100) {
            this.E.categoryIrc.smoothScrollToPosition(0);
        } else {
            this.E.categoryIrc.scrollToPosition(0);
        }
    }

    public void r0(x8.c cVar) {
        if (m0.c(this.f12349c)) {
            return;
        }
        H();
        t0(cVar, true);
    }

    @Override // com.martian.libmars.fragment.StrFragment
    public void A() {
        this.f13819l.l().setRefresh(true);
        this.f13818k = 0;
        K(true);
        b0();
    }

    public final String e0() {
        int i10 = this.f13831x;
        if (i10 == 1) {
            return this.f12349c.getString(com.martian.mibook.R.string.number_word1) + "·";
        }
        if (i10 == 2) {
            return this.f12349c.getString(com.martian.mibook.R.string.number_word2) + "·";
        }
        if (i10 != 3) {
            return "";
        }
        return this.f12349c.getString(com.martian.mibook.R.string.number_word3) + "·";
    }

    public final String f0() {
        int i10 = this.f13833z;
        return i10 != 1 ? i10 != 2 ? this.f12349c.getString(com.martian.mibook.R.string.top_search) : this.f12349c.getString(com.martian.mibook.R.string.grade) : this.f12349c.getString(com.martian.mibook.R.string.yw_finished_books_recently);
    }

    public final String g0() {
        int i10 = this.f13832y;
        if (i10 == 1) {
            return this.f12349c.getString(com.martian.mibook.R.string.bookstores_finish) + "·";
        }
        if (i10 != 2) {
            return "";
        }
        return this.f12349c.getString(com.martian.mibook.R.string.serialise) + "·";
    }

    public final int i0(int i10) {
        return i10 == 0 ? this.f13831x : i10 == 1 ? this.f13832y : this.f13833z;
    }

    public final void k0() {
        if (m0.C(this.f12349c)) {
            this.f13823p.add(this.f12349c.getString(com.martian.mibook.R.string.withdraw_money_all));
            this.f13823p.add(this.f12349c.getString(com.martian.mibook.R.string.number_word1));
            this.f13823p.add(this.f12349c.getString(com.martian.mibook.R.string.number_word2));
            this.f13823p.add(this.f12349c.getString(com.martian.mibook.R.string.number_word3));
            this.F.categoryNumberWord.setData(this.f13823p);
            this.f13824q.add(this.f12349c.getString(com.martian.mibook.R.string.withdraw_money_all));
            this.f13824q.add(this.f12349c.getString(com.martian.mibook.R.string.bookstores_finish));
            this.f13824q.add(this.f12349c.getString(com.martian.mibook.R.string.serialise));
            this.F.categoryStatus.setData(this.f13824q);
            this.f13825r.add(this.f12349c.getString(com.martian.mibook.R.string.top_search));
            this.f13825r.add(this.f12349c.getString(com.martian.mibook.R.string.yw_finished_books_recently));
            this.f13825r.add(this.f12349c.getString(com.martian.mibook.R.string.grade));
            this.F.categoryOrder.setData(this.f13825r);
            this.f13822o.add(this.f12349c.getString(com.martian.mibook.R.string.withdraw_money_all));
            Iterator<TYTag> it = this.f13821n.getTagList().iterator();
            while (it.hasNext()) {
                this.f13822o.add(it.next().getTag());
            }
            if (this.f13822o.size() > 2) {
                this.F.categoryFlowLayout.setData(this.f13822o);
            }
            A();
        }
    }

    public final /* synthetic */ void l0(String str, int i10) {
        w0(0, i10);
    }

    @Override // com.martian.libmars.fragment.LazyFragment
    public void m() {
    }

    public final /* synthetic */ void o0(String str, int i10) {
        A();
    }

    @Override // s9.a
    public void onLoadMore(View view) {
        this.f13819l.l().setRefresh(this.f13819l.getSize() <= 0);
        this.E.categoryIrc.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
        b0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("intent_ctype", this.f13820m.intValue());
        bundle.putInt(G, this.f13826s);
        bundle.putInt(H, this.f13827t);
        bundle.putString(MiConfigSingleton.X0, GsonUtils.b().toJson(this.f13821n));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, Bundle bundle) {
        String str;
        super.onViewCreated(view, bundle);
        if (bundle != null) {
            this.f13820m = Integer.valueOf(bundle.getInt("intent_ctype", 1));
            this.f13826s = bundle.getInt(G, 0);
            this.f13827t = bundle.getInt(H);
            str = bundle.getString(MiConfigSingleton.X0);
        } else {
            Intent intent = this.f12349c.getIntent();
            if (intent != null) {
                this.f13820m = Integer.valueOf(intent.getIntExtra("intent_ctype", 1));
                this.f13826s = intent.getIntExtra(G, 0);
                this.f13827t = intent.getIntExtra(H, -1);
                str = intent.getStringExtra(MiConfigSingleton.X0);
            } else {
                str = "";
            }
        }
        if (!l.q(str)) {
            this.f13821n = (YWCategory) GsonUtils.b().fromJson(str, YWCategory.class);
        }
        if (this.f13821n == null) {
            o("获取信息失败");
            this.f12349c.finish();
            return;
        }
        FragmentCategoryListBinding bind = FragmentCategoryListBinding.bind(t());
        this.E = bind;
        bind.bookOrderView.setOnClickListener(new View.OnClickListener() { // from class: fb.b
            public /* synthetic */ b() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YWCategoriesBookListFragment.this.p0(view2);
            }
        });
        this.f13819l = new TYBookItemListAdapter(this.f12349c);
        this.E.categoryIrc.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.E.categoryIrc.setAdapter(this.f13819l);
        this.E.categoryIrc.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        this.E.categoryIrc.setOnLoadMoreListener(this);
        this.E.categoryIrc.addOnScrollListener(new a());
        this.E.categoryIrc.k(j0());
        if (this.f13821n.getTagList().isEmpty()) {
            MiConfigSingleton.b2().M1().M2(this.f13820m.intValue(), new b());
        } else {
            k0();
        }
    }

    public final void q0(YWCategoryBookList yWCategoryBookList) {
        if (m0.c(this.f12349c)) {
            return;
        }
        H();
        if (yWCategoryBookList == null || yWCategoryBookList.getBookList() == null || yWCategoryBookList.getBookList().isEmpty()) {
            if (this.f13819l.l().isRefresh()) {
                this.f13819l.clear();
            }
            t0(new x8.c(-1, "数据为空"), false);
            return;
        }
        if (this.f13826s > 0) {
            for (TYBookItem tYBookItem : yWCategoryBookList.getBookList()) {
                tYBookItem.setRecommend("详情-" + tYBookItem.getRecommend());
            }
        }
        y();
        if (this.f13819l.l().isRefresh()) {
            this.f13819l.a(yWCategoryBookList.getBookList());
            this.f13819l.x(this.E.categoryIrc);
        } else {
            this.f13819l.h(yWCategoryBookList.getBookList());
        }
        this.f13818k++;
    }

    public final void s0(int i10, int i11) {
        if (i10 == 0) {
            this.f13831x = i11;
        } else if (i10 == 1) {
            this.f13832y = i11;
        } else {
            this.f13833z = i11;
        }
    }

    public void t0(x8.c cVar, boolean z10) {
        TYBookItemListAdapter tYBookItemListAdapter = this.f13819l;
        if (tYBookItemListAdapter == null || tYBookItemListAdapter.getSize() <= 0) {
            if (z10) {
                x(cVar);
            } else {
                w(cVar.d());
            }
            C(0, this.F.categoryTopView.getHeight(), 0, 0);
            this.E.categoryIrc.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
            return;
        }
        y();
        if (this.f13819l.getSize() >= 3) {
            this.E.categoryIrc.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
        } else {
            this.E.categoryIrc.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        }
    }

    @Override // com.martian.libmars.fragment.StrFragment
    public int u() {
        return com.martian.mibook.R.layout.fragment_category_list;
    }

    public void u0(String str) {
        TYBookItemListAdapter tYBookItemListAdapter = this.f13819l;
        if (tYBookItemListAdapter == null || tYBookItemListAdapter.getSize() <= 0) {
            z(str);
        }
    }

    public final void v0(int i10) {
        if (i10 == 0) {
            int i11 = this.f13831x;
            if (i11 == 0) {
                this.A = null;
                this.B = null;
            } else if (i11 == 1) {
                this.A = null;
                this.B = 1000000;
            } else if (i11 == 2) {
                this.A = 1000000;
                this.B = 3000000;
            } else if (i11 == 3) {
                this.A = 3000000;
                this.B = null;
            }
        } else if (i10 == 1) {
            int i12 = this.f13832y;
            if (i12 == 0) {
                this.C = 0;
            } else if (i12 == 1) {
                this.C = 50;
            } else if (i12 == 2) {
                this.C = 30;
            }
        } else {
            int i13 = this.f13833z;
            if (i13 == 0) {
                this.D = 0;
            } else if (i13 == 1) {
                this.D = 1;
            } else if (i13 == 2) {
                this.D = 2;
            }
        }
        A();
    }

    public final void w0(int i10, int i11) {
        if (i0(i10) != i11) {
            s0(i10, i11);
            v0(i10);
        }
    }
}
