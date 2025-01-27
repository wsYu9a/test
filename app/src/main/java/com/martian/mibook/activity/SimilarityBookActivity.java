package com.martian.mibook.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ba.l;
import com.martian.libmars.R;
import com.martian.libmars.activity.RetryLoadingActivity;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.widget.recyclerview.LoadMoreFooterView;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.mibook.activity.SimilarityBookActivity;
import com.martian.mibook.activity.base.MiRetryLoadingActivity;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.ActivitySimilarityBookBinding;
import com.martian.mibook.databinding.SimilarityBookHeaderBinding;
import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.ui.adapter.SimilarityBookBannerAdapter;
import com.martian.mibook.ui.adapter.TYBookItemListAdapter;
import com.martian.mibook.ui.recybanner.BannerLayout;
import java.util.List;
import java.util.Random;
import l9.m0;
import x8.c;
import xb.h;

/* loaded from: classes3.dex */
public class SimilarityBookActivity extends MiRetryLoadingActivity implements s9.a {
    public ActivitySimilarityBookBinding L;
    public TYBookItemListAdapter M;
    public SimilarityBookHeaderBinding O;
    public List<BookWrapper> P;
    public RecyclerView S;
    public MiBookManager.j0 T;
    public int N = 0;
    public int Q = 0;
    public boolean R = true;

    public class a extends RecyclerView.OnScrollListener {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i10, int i11) {
            super.onScrolled(recyclerView, i10, i11);
            SimilarityBookActivity.this.Q += i11;
            boolean z10 = SimilarityBookActivity.this.Q < ConfigSingleton.i(16.0f);
            if (z10 == SimilarityBookActivity.this.R) {
                return;
            }
            SimilarityBookActivity.this.R = z10;
            if (!z10) {
                SimilarityBookActivity.this.f2(!MiConfigSingleton.b2().A0());
                SimilarityBookActivity.this.M2(ConfigSingleton.D().h0());
                SimilarityBookActivity.this.L2(ConfigSingleton.D().n());
            } else {
                SimilarityBookActivity.this.f2(false);
                SimilarityBookActivity similarityBookActivity = SimilarityBookActivity.this;
                similarityBookActivity.M2(ContextCompat.getColor(similarityBookActivity, R.color.white));
                SimilarityBookActivity similarityBookActivity2 = SimilarityBookActivity.this;
                similarityBookActivity2.L2(ContextCompat.getColor(similarityBookActivity2, R.color.transparent));
            }
        }
    }

    public class b extends h {
        public b() {
        }

        @Override // xb.h
        public void a(boolean z10) {
        }

        @Override // xb.h
        public void c(List<TYBookItem> list) {
            SimilarityBookActivity.this.t3(list);
        }

        @Override // xb.h
        public void d(c cVar) {
            SimilarityBookActivity.this.u3(cVar);
        }
    }

    public void u3(c cVar) {
        X2();
        v3(cVar.d());
    }

    @Override // com.martian.libmars.activity.RetryLoadingActivity
    public void J2() {
        if (m0.C(this)) {
            this.M.l().setRefresh(true);
            p3(this.P.get(this.N).book);
        }
    }

    @Override // com.martian.mibook.activity.base.MiRetryLoadingActivity, com.martian.libmars.activity.RetryLoadingActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.martian.mibook.R.layout.activity_similarity_book);
        S2(RetryLoadingActivity.K);
        f2(false);
        MiBookManager.j0 j0Var = new MiBookManager.j0();
        this.T = j0Var;
        j0Var.l(0);
        this.T.n(3);
        this.T.o(new Random().nextInt(10000));
        ActivitySimilarityBookBinding bind = ActivitySimilarityBookBinding.bind(C2());
        this.L = bind;
        bind.similarityBookRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        TYBookItemListAdapter tYBookItemListAdapter = new TYBookItemListAdapter(this);
        this.M = tYBookItemListAdapter;
        this.L.similarityBookRecyclerView.setAdapter(tYBookItemListAdapter);
        this.L.similarityBookRecyclerView.setOnLoadMoreListener(this);
        this.L.similarityBookRecyclerView.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        this.L.similarityLoadingTip.setOnReloadListener(new LoadingTip.b() { // from class: qa.x
            public /* synthetic */ x() {
            }

            @Override // com.martian.libmars.widget.recyclerview.LoadingTip.b
            public final void a() {
                SimilarityBookActivity.this.J2();
            }
        });
        this.L.similarityBookRecyclerView.addOnScrollListener(new a());
        this.P = MiConfigSingleton.b2().M1().C(false);
        s3();
    }

    @Override // s9.a
    public void onLoadMore(View view) {
        if (m0.C(this)) {
            this.M.l().setRefresh(this.M.getSize() <= 0);
            this.L.similarityBookRecyclerView.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
            p3(this.P.get(this.N).book);
        }
    }

    @Override // com.martian.libmars.activity.MartianActivity
    public void p2(boolean z10) {
        super.p2(z10);
        if (this.R) {
            return;
        }
        M2(ConfigSingleton.D().h0());
        L2(ConfigSingleton.D().n());
    }

    @SuppressLint({"SetTextI18n"})
    public final void p3(Book book) {
        if (book == null) {
            v3("");
            return;
        }
        this.T.q(book.getSourceName());
        this.T.p(book.getSourceId());
        this.T.j(book.getSourceName());
        this.O.similarityBookName.setText("《" + book.getBookName() + "》" + getString(com.martian.mibook.R.string.find_similar_book_hint));
        if (y2()) {
            MiConfigSingleton.b2().M1().j1(this.T, new b());
        }
    }

    public final View q3() {
        View inflate = View.inflate(this, com.martian.mibook.R.layout.similarity_book_header, null);
        SimilarityBookHeaderBinding bind = SimilarityBookHeaderBinding.bind(inflate);
        this.O = bind;
        this.S = bind.recyclerViewBanner.getRecyclerView();
        SimilarityBookBannerAdapter similarityBookBannerAdapter = new SimilarityBookBannerAdapter(this, this.P);
        similarityBookBannerAdapter.m(new BannerLayout.c() { // from class: qa.y
            public /* synthetic */ y() {
            }

            @Override // com.martian.mibook.ui.recybanner.BannerLayout.c
            public final void a(int i10) {
                SimilarityBookActivity.this.r3(i10);
            }
        });
        ((RelativeLayout.LayoutParams) this.O.recyclerViewBanner.getLayoutParams()).setMargins(0, ConfigSingleton.i(60.0f) + p1(), 0, 0);
        this.O.recyclerViewBanner.setOnPageChangeListener(new BannerLayout.d() { // from class: qa.z
            public /* synthetic */ z() {
            }

            @Override // com.martian.mibook.ui.recybanner.BannerLayout.d
            public final void onPageSelected(int i10) {
                SimilarityBookActivity.this.x3(i10);
            }
        });
        this.O.recyclerViewBanner.setAdapter(similarityBookBannerAdapter);
        this.O.recyclerViewBanner.setItemSpace(ConfigSingleton.i(24.0f));
        return inflate;
    }

    public final /* synthetic */ void r3(int i10) {
        this.S.smoothScrollToPosition(i10);
        x3(i10);
    }

    public final void s3() {
        View q32 = q3();
        this.L.similarityBookRecyclerView.k(q32);
        q32.measure(0, 0);
        this.L.similarityLoadingTip.setPadding(0, q32.getMeasuredHeight(), 0, 0);
        p3(this.P.get(0).book);
    }

    public final void t3(List<TYBookItem> list) {
        X2();
        if (list == null || list.isEmpty()) {
            v3("");
            return;
        }
        this.L.similarityLoadingTip.setLoadingTip(LoadingTip.LoadStatus.finish);
        if (this.M.l().isRefresh()) {
            this.M.a(list);
            this.M.x(this.L.similarityBookRecyclerView);
        } else {
            this.M.h(list);
        }
        this.T.h();
    }

    public void v3(String str) {
        TYBookItemListAdapter tYBookItemListAdapter = this.M;
        if (tYBookItemListAdapter != null && tYBookItemListAdapter.getSize() > 0) {
            this.L.similarityLoadingTip.setLoadingTip(LoadingTip.LoadStatus.finish);
            if (this.M.getSize() >= 10) {
                this.L.similarityBookRecyclerView.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
                return;
            } else {
                this.L.similarityBookRecyclerView.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
                return;
            }
        }
        if (l.q(str)) {
            this.L.similarityLoadingTip.setLoadingTip(LoadingTip.LoadStatus.empty);
        } else {
            this.L.similarityLoadingTip.setLoadingTip(LoadingTip.LoadStatus.network_error);
            if (!l.q(str) && str.length() < 20) {
                this.L.similarityLoadingTip.setTips(str);
            }
        }
        this.L.similarityBookRecyclerView.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
    }

    public void w3(String str) {
        TYBookItemListAdapter tYBookItemListAdapter = this.M;
        if (tYBookItemListAdapter == null || tYBookItemListAdapter.getSize() <= 0) {
            this.L.similarityLoadingTip.setLoadingTip(LoadingTip.LoadStatus.loading);
            if (l.q(str)) {
                return;
            }
            this.L.similarityLoadingTip.setTips(str);
        }
    }

    public final void x3(int i10) {
        if (this.N == i10) {
            return;
        }
        this.N = i10;
        this.M.l().setRefresh(true);
        this.T.l(0);
        p3(this.P.get(this.N).book);
    }
}
