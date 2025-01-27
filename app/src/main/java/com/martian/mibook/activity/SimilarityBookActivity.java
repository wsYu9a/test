package com.martian.mibook.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.martian.libmars.activity.k1;
import com.martian.libmars.widget.recyclerview.LoadMoreFooterView;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.e.b7;
import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.ui.o.l4;
import com.martian.mibook.ui.o.n4;
import com.martian.mibook.ui.recybanner.BannerLayout;
import com.martian.ttbookhd.R;
import java.util.List;
import java.util.Random;

/* loaded from: classes3.dex */
public class SimilarityBookActivity extends com.martian.mibook.activity.base.n implements com.martian.libmars.widget.recyclerview.f.a {
    private com.martian.mibook.e.u Q;
    private n4 R;
    private b7 T;
    private List<BookWrapper> U;
    private RecyclerView X;
    private MiBookManager.m0 Y;
    private int S = 0;
    private int V = 0;
    private boolean W = true;

    class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            SimilarityBookActivity.this.V += dy;
            boolean z = SimilarityBookActivity.this.V < com.martian.libmars.d.h.b(16.0f);
            if (z == SimilarityBookActivity.this.W) {
                return;
            }
            SimilarityBookActivity.this.W = z;
            if (!z) {
                SimilarityBookActivity.this.A1(!MiConfigSingleton.V3().I0());
                SimilarityBookActivity.this.q2(com.martian.libmars.d.h.F().p0());
                SimilarityBookActivity.this.p2(com.martian.libmars.d.h.F().g());
            } else {
                SimilarityBookActivity.this.A1(false);
                SimilarityBookActivity similarityBookActivity = SimilarityBookActivity.this;
                similarityBookActivity.q2(ContextCompat.getColor(similarityBookActivity, R.color.white));
                SimilarityBookActivity similarityBookActivity2 = SimilarityBookActivity.this;
                similarityBookActivity2.p2(ContextCompat.getColor(similarityBookActivity2, R.color.transparent));
            }
        }
    }

    class b extends com.martian.mibook.lib.model.d.h {
        b() {
        }

        @Override // com.martian.mibook.lib.model.d.h
        public void a(boolean loading) {
        }

        @Override // com.martian.mibook.lib.model.d.h
        public void c(List<TYBookItem> books) {
            SimilarityBookActivity.this.Y2(books);
        }

        @Override // com.martian.mibook.lib.model.d.h
        public void d(b.d.c.b.c errorResult) {
            SimilarityBookActivity.this.Z2(errorResult);
        }
    }

    @SuppressLint({"SetTextI18n"})
    private void S2(Book ywBook) {
        if (ywBook == null) {
            a3("");
            return;
        }
        this.Y.q(ywBook.getSourceName());
        this.Y.p(ywBook.getSourceId());
        this.Y.j(ywBook.getSourceName());
        this.T.f11772c.setText("《" + ywBook.getBookName() + "》" + getString(R.string.find_similar_book_hint));
        if (g2()) {
            MiConfigSingleton.V3().l3().T1(this.Y, new b());
        }
    }

    private View T2() {
        View inflate = View.inflate(this, R.layout.similarity_book_header, null);
        b7 a2 = b7.a(inflate);
        this.T = a2;
        this.X = a2.f11771b.getRecyclerView();
        l4 l4Var = new l4(this, this.U);
        l4Var.f(new BannerLayout.d() { // from class: com.martian.mibook.activity.v0
            @Override // com.martian.mibook.ui.recybanner.BannerLayout.d
            public final void a(int i2) {
                SimilarityBookActivity.this.W2(i2);
            }
        });
        ((RelativeLayout.LayoutParams) this.T.f11771b.getLayoutParams()).setMargins(0, com.martian.libmars.d.h.b(60.0f) + F0(), 0, 0);
        this.T.f11771b.setOnPageChangeListener(new BannerLayout.e() { // from class: com.martian.mibook.activity.w0
            @Override // com.martian.mibook.ui.recybanner.BannerLayout.e
            public final void onPageSelected(int i2) {
                SimilarityBookActivity.this.c3(i2);
            }
        });
        this.T.f11771b.setAdapter(l4Var);
        this.T.f11771b.setItemSpace(com.martian.libmars.d.h.b(24.0f));
        return inflate;
    }

    /* renamed from: V2 */
    public /* synthetic */ void W2(int position) {
        this.X.smoothScrollToPosition(position);
        c3(position);
    }

    private void X2() {
        View T2 = T2();
        this.Q.f12757c.m(T2);
        T2.measure(0, 0);
        this.Q.f12758d.setPadding(0, T2.getMeasuredHeight(), 0, 0);
        S2(this.U.get(0).book);
    }

    public void Y2(List<TYBookItem> bookList) {
        B2();
        if (bookList == null || bookList.isEmpty()) {
            a3("");
            return;
        }
        this.Q.f12758d.setLoadingTip(LoadingTip.LoadStatus.finish);
        if (this.R.E().isRefresh()) {
            this.R.a(bookList);
            this.R.Q(this.Q.f12757c);
        } else {
            this.R.m(bookList);
        }
        this.Y.h();
    }

    public void Z2(b.d.c.b.c errorResult) {
        B2();
        a3(errorResult.d());
    }

    public void c3(int position) {
        if (this.S == position) {
            return;
        }
        this.S = position;
        this.R.E().setRefresh(true);
        this.Y.l(0);
        S2(this.U.get(this.S).book);
    }

    @Override // com.martian.libmars.activity.j1
    protected void U1(boolean nightMode) {
        super.U1(nightMode);
        if (this.W) {
            return;
        }
        q2(com.martian.libmars.d.h.F().p0());
        p2(com.martian.libmars.d.h.F().g());
    }

    public void a3(String msg) {
        n4 n4Var = this.R;
        if (n4Var != null && n4Var.getSize() > 0) {
            this.Q.f12758d.setLoadingTip(LoadingTip.LoadStatus.finish);
            if (this.R.getSize() >= 10) {
                this.Q.f12757c.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
                return;
            } else {
                this.Q.f12757c.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
                return;
            }
        }
        if (com.martian.libsupport.k.p(msg)) {
            this.Q.f12758d.setLoadingTip(LoadingTip.LoadStatus.empty);
        } else {
            this.Q.f12758d.setLoadingTip(LoadingTip.LoadStatus.error);
            if (!com.martian.libsupport.k.p(msg) && msg.length() < 20) {
                this.Q.f12758d.setTips(msg);
            }
        }
        this.Q.f12757c.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
    }

    public void b3(String title) {
        n4 n4Var = this.R;
        if (n4Var == null || n4Var.getSize() <= 0) {
            this.Q.f12758d.setLoadingTip(LoadingTip.LoadStatus.loading);
            if (com.martian.libsupport.k.p(title)) {
                return;
            }
            this.Q.f12758d.setTips(title);
        }
    }

    @Override // com.martian.libmars.activity.k1
    public void n2() {
        if (com.martian.libmars.utils.n0.C(this)) {
            this.R.E().setRefresh(true);
            S2(this.U.get(this.S).book);
        }
    }

    @Override // com.martian.mibook.activity.base.n, com.martian.libmars.activity.k1, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_similarity_book);
        w2(k1.E);
        A1(false);
        MiBookManager.m0 m0Var = new MiBookManager.m0();
        this.Y = m0Var;
        m0Var.l(0);
        this.Y.n(3);
        this.Y.o(new Random().nextInt(10000));
        com.martian.mibook.e.u a2 = com.martian.mibook.e.u.a(h2());
        this.Q = a2;
        a2.f12757c.setLayoutManager(new LinearLayoutManager(this));
        n4 n4Var = new n4(this);
        this.R = n4Var;
        this.Q.f12757c.setAdapter(n4Var);
        this.Q.f12757c.setOnLoadMoreListener(this);
        this.Q.f12757c.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        this.Q.f12758d.setOnReloadListener(new LoadingTip.b() { // from class: com.martian.mibook.activity.c1
            @Override // com.martian.libmars.widget.recyclerview.LoadingTip.b
            public final void a() {
                SimilarityBookActivity.this.n2();
            }
        });
        this.Q.f12757c.addOnScrollListener(new a());
        this.U = MiConfigSingleton.V3().l3().L(false, false);
        X2();
    }

    @Override // com.martian.libmars.widget.recyclerview.f.a
    public void onLoadMore(View loadMoreView) {
        if (com.martian.libmars.utils.n0.C(this)) {
            this.R.E().setRefresh(this.R.getSize() <= 0);
            this.Q.f12757c.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
            S2(this.U.get(this.S).book);
        }
    }
}
