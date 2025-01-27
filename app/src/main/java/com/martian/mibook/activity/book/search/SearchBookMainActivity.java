package com.martian.mibook.activity.book.search;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.utils.k0;
import com.martian.libmars.utils.n0;
import com.martian.libmars.widget.recyclerview.LoadMoreFooterView;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.mibook.activity.base.MiWebViewActivity;
import com.martian.mibook.activity.book.AuthorBooksActivity;
import com.martian.mibook.activity.book.BookRankActivity;
import com.martian.mibook.activity.book.YWCategoriesActivity;
import com.martian.mibook.activity.book.YWTagsActivity;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.e.a7;
import com.martian.mibook.e.r;
import com.martian.mibook.e.v6;
import com.martian.mibook.e.w6;
import com.martian.mibook.f.f4.g0;
import com.martian.mibook.f.f4.j0;
import com.martian.mibook.j.s2;
import com.martian.mibook.j.y2;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.yuewen.request.TYSearchRecommendParams;
import com.martian.mibook.lib.yuewen.response.TYSearchRecommedInfo;
import com.martian.mibook.lib.yuewen.response.TYSearchTag;
import com.martian.mibook.lib.yuewen.response.YWCategory;
import com.martian.mibook.ui.FlowLayout;
import com.martian.mibook.ui.o.a4;
import com.martian.mibook.ui.o.n4;
import com.martian.mibook.ui.o.z3;
import com.martian.ttbookhd.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpHost;

/* loaded from: classes3.dex */
public class SearchBookMainActivity extends com.martian.mibook.lib.model.b.a implements AdapterView.OnItemClickListener, com.martian.libmars.widget.recyclerview.f.a {
    private z3 G;
    private a4 H;
    private n4 I;
    private r J;
    private v6 K;
    private w6 L;
    private String N;
    private String O;
    private SearchStatus P;
    private a7 Q;
    private YWCategory U;
    private int V;
    private final List<String> F = new ArrayList();
    private int M = 0;
    private boolean R = false;
    private boolean S = false;
    private String T = "";
    private final Runnable W = new e();

    private enum SearchStatus {
        IDLE,
        TIPS,
        RESULT
    }

    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            SearchBookMainActivity.this.r3(SearchStatus.TIPS);
            SearchBookMainActivity.this.o3(((Object) s) + "");
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            ThemeImageView themeImageView = SearchBookMainActivity.this.K.f12848b;
            StringBuilder sb = new StringBuilder();
            sb.append((Object) s);
            sb.append("");
            themeImageView.setVisibility(!com.martian.libsupport.k.p(sb.toString()) ? 0 : 8);
        }
    }

    class b extends com.martian.mibook.lib.account.d.g<TYSearchRecommendParams, TYSearchRecommedInfo> {
        b(Class x0, Class x1, Context x2) {
            super(x0, x1, x2);
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
        }

        @Override // b.d.c.c.i, b.d.c.c.c
        public void onUDDataReceived(List<TYSearchRecommedInfo> tySearchRecommendInfos) {
            if (tySearchRecommendInfos == null || tySearchRecommendInfos.isEmpty()) {
                SearchBookMainActivity.this.m3("数据为空");
            } else {
                SearchBookMainActivity.this.q3(tySearchRecommendInfos.get(0));
            }
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    class c extends com.martian.mibook.lib.model.d.h {

        /* renamed from: a */
        final /* synthetic */ String f11023a;

        c(final String val$searchKeyword) {
            this.f11023a = val$searchKeyword;
        }

        @Override // com.martian.mibook.lib.model.d.h
        public void a(boolean loading) {
        }

        @Override // com.martian.mibook.lib.model.d.h
        public void b(List<TYBookItem> books) {
        }

        @Override // com.martian.mibook.lib.model.d.h
        public void c(List<TYBookItem> books) {
            SearchBookMainActivity.this.i3(books, this.f11023a, "数据为空");
        }

        @Override // com.martian.mibook.lib.model.d.h
        public void d(b.d.c.b.c errorResult) {
            SearchBookMainActivity.this.i3(null, this.f11023a, errorResult.d());
        }
    }

    class d implements MiBookManager.n0 {
        d() {
        }

        @Override // com.martian.mibook.application.MiBookManager.n0
        public void a(List<TYBookItem> tyBookItems, YWCategory ywCategory, int freeType, String finalKeyword) {
            SearchBookMainActivity.this.T = finalKeyword;
            SearchBookMainActivity.this.V = freeType;
            SearchBookMainActivity.this.U = ywCategory;
            SearchBookMainActivity.this.k3(tyBookItems, ywCategory == null);
        }

        @Override // com.martian.mibook.application.MiBookManager.n0
        public void b() {
            SearchBookMainActivity.this.h3();
        }
    }

    class e implements Runnable {

        class a extends com.martian.mibook.lib.model.d.h {
            a() {
            }

            @Override // com.martian.mibook.lib.model.d.h
            public void a(boolean loading) {
            }

            @Override // com.martian.mibook.lib.model.d.h
            public void b(List<TYBookItem> books) {
            }

            @Override // com.martian.mibook.lib.model.d.h
            public void c(List<TYBookItem> books) {
                SearchBookMainActivity searchBookMainActivity = SearchBookMainActivity.this;
                searchBookMainActivity.j3(books, searchBookMainActivity.N);
            }

            @Override // com.martian.mibook.lib.model.d.h
            public void d(b.d.c.b.c errorResult) {
            }
        }

        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SearchBookMainActivity.this.P.equals(SearchStatus.TIPS)) {
                MiConfigSingleton.V3().l3().V1(SearchBookMainActivity.this.N, 0, MiBookManager.r, new a());
            }
        }
    }

    private void C2() {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.K.f12849c.getWindowToken(), 0);
    }

    public void D2() {
        Cursor f2 = MiConfigSingleton.V3().u4().f(((SearchManager) getSystemService("search")).getSearchableInfo(new ComponentName(this, (Class<?>) SearchBookMainActivity.class)), null);
        if (f2 == null) {
            return;
        }
        this.F.clear();
        this.L.f12902b.removeAllViews();
        while (f2.moveToNext()) {
            this.F.add(f2.getString(f2.getColumnIndex(MiConfigSingleton.V3().u4().b(f2))));
        }
        if (this.F.isEmpty()) {
            this.L.f12903c.setVisibility(8);
            return;
        }
        this.L.f12903c.setVisibility(0);
        if (this.F.size() > 20) {
            for (int size = this.F.size() - 20; size > 0; size--) {
                this.F.remove(r1.size() - 1);
            }
        }
        this.L.f12902b.setData(this.F);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void E2() {
        this.L.f12907g.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.book.search.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchBookMainActivity.this.L2(view);
            }
        });
        this.K.f12848b.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.book.search.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchBookMainActivity.this.N2(view);
            }
        });
        this.K.f12849c.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.martian.mibook.activity.book.search.l
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return SearchBookMainActivity.this.P2(textView, i2, keyEvent);
            }
        });
        this.K.f12849c.addTextChangedListener(new a());
        this.J.f12589f.setOnItemClickListener(this);
        this.J.f12589f.setOnTouchListener(new View.OnTouchListener() { // from class: com.martian.mibook.activity.book.search.d
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return SearchBookMainActivity.this.R2(view, motionEvent);
            }
        });
        this.L.f12902b.setOnItemTitleClickListener(new FlowLayout.a() { // from class: com.martian.mibook.activity.book.search.i
            @Override // com.martian.mibook.ui.FlowLayout.a
            public final void a(String str, int i2) {
                SearchBookMainActivity.this.T2(str, i2);
            }
        });
        this.J.f12587d.setOnReloadListener(new LoadingTip.b() { // from class: com.martian.mibook.activity.book.search.k
            @Override // com.martian.libmars.widget.recyclerview.LoadingTip.b
            public final void a() {
                SearchBookMainActivity.this.V2();
            }
        });
    }

    /* renamed from: G2 */
    public /* synthetic */ boolean H2(View v, MotionEvent event) {
        C2();
        return false;
    }

    /* renamed from: I2 */
    public /* synthetic */ boolean J2(View v, MotionEvent event) {
        C2();
        return false;
    }

    /* renamed from: K2 */
    public /* synthetic */ void L2(View view) {
        k0.P(this, getResources().getString(R.string.delete_history), getResources().getString(R.string.delete_history_hint), new k0.l() { // from class: com.martian.mibook.activity.book.search.g
            @Override // com.martian.libmars.utils.k0.l
            public final void a() {
                SearchBookMainActivity.this.Y2();
            }
        });
    }

    /* renamed from: M2 */
    public /* synthetic */ void N2(View v) {
        this.K.f12849c.setText("");
        r3(SearchStatus.IDLE);
    }

    /* renamed from: O2 */
    public /* synthetic */ boolean P2(TextView textView, int actionId, KeyEvent keyEvent) {
        if (actionId != 4 && (keyEvent == null || keyEvent.getKeyCode() != 66)) {
            return false;
        }
        C2();
        n3(this.K.f12849c.getText().toString());
        return true;
    }

    /* renamed from: Q2 */
    public /* synthetic */ boolean R2(View v, MotionEvent event) {
        C2();
        return false;
    }

    /* renamed from: S2 */
    public /* synthetic */ void T2(String title, int position) {
        this.K.f12849c.setText(title);
        this.K.f12849c.setSelection(title.length());
        n3(title);
    }

    /* renamed from: U2 */
    public /* synthetic */ void V2() {
        n3(this.K.f12849c.getText().toString());
    }

    /* renamed from: X2 */
    public /* synthetic */ void Y2() {
        MiConfigSingleton.V3().u4().a();
        this.L.f12902b.j();
        this.L.f12903c.setVisibility(8);
    }

    /* renamed from: Z2 */
    public /* synthetic */ void a3() {
        this.R = false;
    }

    /* renamed from: b3 */
    public /* synthetic */ void c3(final TYSearchRecommedInfo tySearchRecommedInfo, String title, int position) {
        for (TYSearchTag tYSearchTag : tySearchRecommedInfo.getTags()) {
            if (title.equalsIgnoreCase(tYSearchTag.getName())) {
                if (com.martian.apptask.g.g.b(this, tYSearchTag.getDplink())) {
                    com.martian.apptask.g.g.u(this, tYSearchTag.getDplink(), "", "", true);
                } else if (com.martian.libsupport.k.p(tYSearchTag.getUrl())) {
                    YWTagsActivity.r2(this, title, tYSearchTag.getCtype(), j0.w);
                } else {
                    MiWebViewActivity.f5(this, tYSearchTag.getUrl());
                }
            }
        }
    }

    /* renamed from: d3 */
    public /* synthetic */ void e3(AdapterView adapterView, View view, int i2, long l) {
        s2.U(this, this.G.a(i2));
    }

    public void i3(List<TYBookItem> books, String searchKeyword, String errMsg) {
        this.R = false;
        if (books == null || books.isEmpty()) {
            m3(errMsg);
            return;
        }
        this.J.f12587d.setLoadingTip(LoadingTip.LoadStatus.finish);
        if (this.I.E().isRefresh()) {
            this.I.a(books);
            this.I.Q(this.J.f12586c);
            this.I.W(searchKeyword);
        } else {
            this.I.m(books);
        }
        this.M++;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void initView() {
        this.J = r.a(g2());
        TextView textView = (TextView) findViewById(R.id.actionbar_action_custom);
        textView.setVisibility(0);
        textView.setText(getString(R.string.cd_search));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.book.search.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchBookMainActivity.this.F2(view);
            }
        });
        ViewStub viewStub = (ViewStub) findViewById(R.id.actionbar_container);
        viewStub.setLayoutResource(R.layout.search_custom_view);
        this.K = v6.a(viewStub.inflate());
        viewStub.setVisibility(0);
        this.J.f12585b.setLayoutManager(new LinearLayoutManager(this));
        View inflate = getLayoutInflater().inflate(R.layout.search_header, (ViewGroup) null);
        this.L = w6.a(inflate);
        this.J.f12585b.m(inflate);
        this.J.f12585b.setOnTouchListener(new View.OnTouchListener() { // from class: com.martian.mibook.activity.book.search.j
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return SearchBookMainActivity.this.H2(view, motionEvent);
            }
        });
        this.J.f12585b.setAdapter(new n4(this));
        n4 n4Var = new n4(this);
        this.I = n4Var;
        this.J.f12586c.setAdapter(n4Var);
        this.J.f12586c.setLayoutManager(new LinearLayoutManager(this));
        this.J.f12586c.setOnLoadMoreListener(this);
        this.J.f12586c.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        this.J.f12586c.setOnTouchListener(new View.OnTouchListener() { // from class: com.martian.mibook.activity.book.search.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return SearchBookMainActivity.this.J2(view, motionEvent);
            }
        });
        View inflate2 = getLayoutInflater().inflate(R.layout.search_tag_books, (ViewGroup) null);
        this.Q = a7.a(inflate2);
        this.J.f12586c.m(inflate2);
    }

    public void j3(List<TYBookItem> books, String content) {
        if (books == null || books.isEmpty()) {
            if (this.P.equals(SearchStatus.TIPS)) {
                r3(SearchStatus.IDLE);
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TYBookItem> it = books.iterator();
        while (it.hasNext()) {
            TYBookItem next = it.next();
            if (!next.getBookName().contains(content)) {
                if (com.martian.libsupport.k.p(next.getAuthor()) || !next.getAuthor().contains(content)) {
                    it.remove();
                } else if (sb.toString().contains(next.getAuthor())) {
                    it.remove();
                } else {
                    sb.append("__&__");
                    sb.append(next.getAuthor());
                }
            }
        }
        if (books.isEmpty()) {
            if (this.P.equals(SearchStatus.TIPS)) {
                r3(SearchStatus.IDLE);
                return;
            }
            return;
        }
        a4 a4Var = this.H;
        if (a4Var != null) {
            a4Var.c(books, content);
            return;
        }
        a4 a4Var2 = new a4(this, books, content);
        this.H = a4Var2;
        this.J.f12589f.setAdapter((ListAdapter) a4Var2);
    }

    public void k3(List<TYBookItem> tyBookItems, boolean isTagResult) {
        this.S = false;
        if (tyBookItems == null || tyBookItems.isEmpty() || !n0.C(this)) {
            return;
        }
        this.Q.f11714c.setText(this.T);
        this.Q.f11715d.setText(getString(isTagResult ? R.string.tag : R.string.classification));
        y2.f(this, tyBookItems, this.Q.f11713b, false, 0, false);
        this.Q.getRoot().setVisibility(0);
    }

    private void l3(String keyword) {
        MiConfigSingleton.V3().u4().h(keyword, null);
        new Handler().postDelayed(new Runnable() { // from class: com.martian.mibook.activity.book.search.h
            @Override // java.lang.Runnable
            public final void run() {
                SearchBookMainActivity.this.D2();
            }
        }, 1000L);
    }

    /* renamed from: lambda$initView$0 */
    public /* synthetic */ void F2(View v) {
        n3(this.K.f12849c.getText().toString());
    }

    private void n3(String keyword) {
        if (com.martian.libsupport.k.p(keyword)) {
            if (com.martian.libsupport.k.p(this.O)) {
                k1("请输入搜索关键字");
                return;
            } else {
                keyword = this.O;
                this.K.f12849c.setText(keyword);
                this.K.f12849c.setSelection(keyword.length());
            }
        }
        if (this.R) {
            return;
        }
        l3(keyword);
        if (keyword.startsWith(HttpHost.DEFAULT_SCHEME_NAME) || keyword.startsWith("www")) {
            this.R = true;
            MiWebViewActivity.f5(this, keyword);
            new Handler().postDelayed(new Runnable() { // from class: com.martian.mibook.activity.book.search.f
                @Override // java.lang.Runnable
                public final void run() {
                    SearchBookMainActivity.this.a3();
                }
            }, 2000L);
            return;
        }
        r3(SearchStatus.RESULT);
        this.M = 0;
        this.I.clear();
        this.I.E().setRefresh(true);
        com.martian.mibook.lib.model.g.b.Y(this, keyword);
        C2();
        String n0 = com.martian.libmars.d.h.F().n0(keyword);
        f3(n0);
        g3(n0);
    }

    public void o3(final String content) {
        if (com.martian.libsupport.k.p(content)) {
            this.K.f12849c.removeCallbacks(this.W);
            r3(SearchStatus.IDLE);
        } else {
            this.N = content;
            this.K.f12849c.removeCallbacks(this.W);
            this.K.f12849c.postDelayed(this.W, 800L);
        }
    }

    public void r3(SearchStatus status) {
        this.P = status;
        this.J.f12585b.setVisibility(status.equals(SearchStatus.IDLE) ? 0 : 8);
        this.J.f12589f.setVisibility(this.P.equals(SearchStatus.TIPS) ? 0 : 8);
        this.J.f12588e.setVisibility(this.P.equals(SearchStatus.RESULT) ? 0 : 8);
    }

    public void f3(final String searchKeyword) {
        this.R = true;
        MiConfigSingleton.V3().l3().V1(searchKeyword, this.M, MiBookManager.o, new c(searchKeyword));
    }

    public void g3(String keyword) {
        if (this.S) {
            return;
        }
        this.S = true;
        this.Q.getRoot().setVisibility(8);
        MiConfigSingleton.V3().l3().N2(keyword, new d());
    }

    public void h3() {
        this.S = false;
        a7 a7Var = this.Q;
        if (a7Var != null) {
            a7Var.getRoot().setVisibility(8);
        }
    }

    public void m3(String errMsg) {
        n4 n4Var = this.I;
        if (n4Var == null || n4Var.getSize() <= 0) {
            this.J.f12586c.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
            this.J.f12587d.setLoadingTip(LoadingTip.LoadStatus.error);
            this.J.f12587d.setTips(errMsg);
        } else {
            this.J.f12587d.setLoadingTip(LoadingTip.LoadStatus.finish);
            if (this.I.getSize() >= 10) {
                this.J.f12586c.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
            } else {
                this.J.f12586c.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
            }
        }
    }

    @Override // com.martian.mibook.lib.model.b.a, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_book_main);
        c2(true);
        Z1("");
        d2(false);
        initView();
        E2();
        p3();
        com.martian.mibook.lib.model.g.b.Y(this, "搜索-展示");
        r3(SearchStatus.IDLE);
    }

    @Override // com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        v6 v6Var = this.K;
        if (v6Var != null) {
            v6Var.f12849c.removeCallbacks(this.W);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        a4 a4Var = this.H;
        if (a4Var == null || a4Var.getCount() == 0) {
            return;
        }
        Book book = (Book) this.H.getItem(position);
        if (book.getBookName().contains(this.H.a())) {
            s2.U(this, book);
        } else if (book.getAuthor().contains(this.H.a())) {
            AuthorBooksActivity.s2(this, book, AuthorBooksActivity.H, 0);
        }
        l3(this.H.a());
    }

    @Override // com.martian.libmars.widget.recyclerview.f.a
    public void onLoadMore(View loadMoreView) {
        this.I.E().setRefresh(this.I.getSize() <= 0);
        this.J.f12586c.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
        f3(this.K.f12849c.getText().toString());
    }

    @Override // com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        C2();
        super.onPause();
    }

    public void onSearchRankClick(View view) {
        com.martian.mibook.lib.model.g.b.Y(this, "热搜榜-查看全部");
        BookRankActivity.w2(this, MiConfigSingleton.V3().k(), new BookRankActivity.a().j(80).r("搜索-"));
    }

    public void onSearchTagClick(View view) {
        YWCategory yWCategory = this.U;
        if (yWCategory != null) {
            YWCategoriesActivity.r2(this, yWCategory, this.V, -1, g0.y);
        } else {
            YWTagsActivity.r2(this, this.T, this.V, j0.v);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        D2();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void p3() {
        b bVar = new b(TYSearchRecommendParams.class, TYSearchRecommedInfo.class, this);
        ((TYSearchRecommendParams) bVar.k()).setCtype(Integer.valueOf(MiConfigSingleton.V3().k()));
        bVar.j();
    }

    public void q3(final TYSearchRecommedInfo tySearchRecommedInfo) {
        if (tySearchRecommedInfo == null) {
            return;
        }
        if (!com.martian.libsupport.k.p(tySearchRecommedInfo.getTip()) && com.martian.libsupport.k.p(this.K.f12849c.getText().toString())) {
            String tip = tySearchRecommedInfo.getTip();
            this.O = tip;
            this.K.f12849c.setHint(tip);
        }
        if (!tySearchRecommedInfo.getTags().isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator<TYSearchTag> it = tySearchRecommedInfo.getTags().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getName());
            }
            this.L.f12906f.setVisibility(0);
            this.L.f12905e.setData(arrayList);
            this.L.f12905e.setOnItemTitleClickListener(new FlowLayout.a() { // from class: com.martian.mibook.activity.book.search.m
                @Override // com.martian.mibook.ui.FlowLayout.a
                public final void a(String str, int i2) {
                    SearchBookMainActivity.this.c3(tySearchRecommedInfo, str, i2);
                }
            });
        }
        if (tySearchRecommedInfo.getBooks().isEmpty()) {
            return;
        }
        this.L.f12904d.setVisibility(0);
        if (this.G == null) {
            z3 z3Var = new z3(this, tySearchRecommedInfo.getBooks());
            this.G = z3Var;
            this.L.f12908h.setAdapter((ListAdapter) z3Var);
            this.L.f12908h.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.martian.mibook.activity.book.search.b
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
                    SearchBookMainActivity.this.e3(adapterView, view, i2, j2);
                }
            });
        }
    }
}
