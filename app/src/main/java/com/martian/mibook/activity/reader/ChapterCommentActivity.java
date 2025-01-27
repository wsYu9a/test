package com.martian.mibook.activity.reader;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.activity.j1;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.book.ChapterCommentCount;
import com.martian.mibook.data.book.Comment;
import com.martian.mibook.data.book.MiBookGetCommentByScoreItemList;
import com.martian.mibook.data.book.MiBookGetCommentByTimeItemList;
import com.martian.mibook.f.p3;
import com.martian.mibook.j.v2;
import com.martian.mibook.lib.model.data.MiReadingTheme;
import com.martian.mibook.ui.o.g4;
import com.martian.mibook.ui.reader.ReaderLoadMoreFooterView;
import com.martian.mibook.ui.reader.ReaderLoadingTip;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public class ChapterCommentActivity extends j1 implements com.martian.libmars.widget.recyclerview.f.a {
    public static final String B = "COMMENT_SOURCE_NAME";
    public static final String C = "COMMENT_SOURCE_ID";
    public static final String D = "COMMENT_CHAPTER_ID";
    public static final String E = "COMMENT_CHAPTER_NAME";
    public static final String F = "COMMENT_COUNT";
    public static final int G = 1012;
    public static String H = "INTENT_CHAPTER_COMMENT_COUNT";
    public static String I = "INTENT_CHAPTER_ID";
    private com.martian.mibook.e.m J;
    private g4 K;
    private BottomSheetBehavior<View> L;
    private int M;
    private Long N;
    private int O = 0;
    private String P;
    private String Q;
    private String R;
    private String S;
    private String T;
    private ChapterCommentCount U;

    class a extends BottomSheetBehavior.f {
        a() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void a(@NonNull View bottomSheet, float slideOffset) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void b(@NonNull View bottomSheet, int newState) {
            if (newState == 5) {
                ChapterCommentActivity.this.finish();
                ChapterCommentActivity.this.overridePendingTransition(0, 0);
            }
        }
    }

    class b implements v2.b0 {
        b() {
        }

        @Override // com.martian.mibook.j.v2.b0
        public void a(String tag, String comment) {
            ChapterCommentActivity.this.T = comment;
        }

        @Override // com.martian.mibook.j.v2.b0
        public void b(Comment comment) {
            com.martian.mibook.lib.model.g.b.E(ChapterCommentActivity.this, "发表评论");
            if (ChapterCommentActivity.this.K != null) {
                ChapterCommentActivity.this.K.i(0, comment);
            }
            if (ChapterCommentActivity.this.U != null) {
                ChapterCommentActivity.this.U.incrNComments();
                ChapterCommentActivity.this.U.addComment(comment);
                Intent intent = new Intent();
                intent.putExtra(ChapterCommentActivity.H, GsonUtils.b().toJson(ChapterCommentActivity.this.U));
                ChapterCommentActivity.this.setResult(-1, intent);
                ChapterCommentActivity.this.L2();
            }
        }
    }

    class c implements MiBookManager.b0 {
        c() {
        }

        @Override // com.martian.mibook.application.MiBookManager.b0
        public void a(b.d.c.b.c errorResult) {
            ChapterCommentActivity.this.J2(errorResult, true);
        }

        @Override // com.martian.mibook.application.MiBookManager.b0
        public void b(MiBookGetCommentByScoreItemList miBookGetCommentByScoreItemList) {
            ChapterCommentActivity.this.H2(miBookGetCommentByScoreItemList);
        }

        @Override // com.martian.mibook.application.MiBookManager.b0
        public void onLoading(boolean show) {
            if (show && ChapterCommentActivity.this.K == null) {
                ChapterCommentActivity chapterCommentActivity = ChapterCommentActivity.this;
                chapterCommentActivity.F2(chapterCommentActivity.getString(R.string.loading));
            }
        }
    }

    class d implements MiBookManager.c0 {
        d() {
        }

        @Override // com.martian.mibook.application.MiBookManager.c0
        public void a(b.d.c.b.c errorResult) {
            ChapterCommentActivity.this.J2(errorResult, true);
        }

        @Override // com.martian.mibook.application.MiBookManager.c0
        public void b(MiBookGetCommentByTimeItemList miBookGetCommentByTimeItemList) {
            ChapterCommentActivity.this.I2(miBookGetCommentByTimeItemList);
        }

        @Override // com.martian.mibook.application.MiBookManager.c0
        public void onLoading(boolean show) {
            if (show && ChapterCommentActivity.this.K == null) {
                ChapterCommentActivity chapterCommentActivity = ChapterCommentActivity.this;
                chapterCommentActivity.F2(chapterCommentActivity.getString(R.string.loading));
            }
        }
    }

    /* renamed from: A2 */
    public /* synthetic */ void B2(View v) {
        v2.Z0(this, this.R, this.S, this.P, this.Q, this.T, new b());
    }

    public void H2(MiBookGetCommentByScoreItemList miBookGetCommentByScoreItemList) {
        if (com.martian.libmars.utils.n0.c(this)) {
            return;
        }
        if (miBookGetCommentByScoreItemList == null || miBookGetCommentByScoreItemList.getCommentList() == null || miBookGetCommentByScoreItemList.getCommentList().size() <= 0) {
            J2(new b.d.c.b.c(-1, "数据为空"), false);
            return;
        }
        this.M++;
        E2();
        g4 g4Var = this.K;
        if (g4Var == null) {
            g4 g4Var2 = new g4(this, miBookGetCommentByScoreItemList.getCommentList());
            this.K = g4Var2;
            this.J.f12323e.setAdapter(g4Var2);
        } else if (g4Var.E().isRefresh()) {
            this.K.a(miBookGetCommentByScoreItemList.getCommentList());
        } else {
            this.K.m(miBookGetCommentByScoreItemList.getCommentList());
        }
    }

    public void I2(MiBookGetCommentByTimeItemList miBookGetCommentByTimeItemList) {
        if (com.martian.libmars.utils.n0.c(this)) {
            return;
        }
        if (miBookGetCommentByTimeItemList == null || miBookGetCommentByTimeItemList.getCommentList() == null || miBookGetCommentByTimeItemList.getCommentList().size() <= 0) {
            J2(new b.d.c.b.c(-1, "数据为空"), false);
            return;
        }
        E2();
        this.N = miBookGetCommentByTimeItemList.getCommentList().get(miBookGetCommentByTimeItemList.getCommentList().size() - 1).getCreatedOn();
        g4 g4Var = this.K;
        if (g4Var == null) {
            g4 g4Var2 = new g4(this, miBookGetCommentByTimeItemList.getCommentList());
            this.K = g4Var2;
            this.J.f12323e.setAdapter(g4Var2);
        } else if (g4Var.E().isRefresh()) {
            this.K.a(miBookGetCommentByTimeItemList.getCommentList());
        } else {
            this.K.m(miBookGetCommentByTimeItemList.getCommentList());
        }
    }

    public static void K2(j1 activity, String sourceName, String sourceId, String chapterId, String chapterName, ChapterCommentCount chapterCommentCount) {
        Bundle bundle = new Bundle();
        bundle.putString(B, sourceName);
        bundle.putString(C, sourceId);
        bundle.putString(D, chapterId);
        bundle.putString(E, chapterName);
        bundle.putString(F, GsonUtils.b().toJson(chapterCommentCount));
        activity.startActivityForResult(ChapterCommentActivity.class, bundle, 1012);
    }

    @SuppressLint({"SetTextI18n"})
    public void L2() {
        if (this.U != null) {
            this.J.f12326h.setText("(" + this.U.getNComments() + "条)");
        }
    }

    private void M2() {
        this.J.l.setTag(0);
        this.J.f12321c.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.reader.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChapterCommentActivity.this.t2(view);
            }
        });
        final MiReadingTheme r = MiConfigSingleton.V3().J4.r();
        this.J.f12322d.setBackgroundResource(r.getRoundBgRes());
        this.J.f12322d.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.reader.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChapterCommentActivity.this.v2(r, view);
            }
        });
        this.J.k.setBackgroundResource(R.drawable.transparent_res);
        this.J.k.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.reader.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChapterCommentActivity.this.x2(r, view);
            }
        });
        this.J.f12323e.setLayoutManager(new LinearLayoutManager(this));
        this.J.f12323e.setOnLoadMoreListener(this);
        this.J.f12323e.setLoadMoreStatus(ReaderLoadMoreFooterView.Status.GONE);
        this.J.f12325g.setOnReloadListener(new ReaderLoadingTip.b() { // from class: com.martian.mibook.activity.reader.b
            @Override // com.martian.mibook.ui.reader.ReaderLoadingTip.b
            public final void a() {
                ChapterCommentActivity.this.z2();
            }
        });
        this.J.f12328j.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.reader.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChapterCommentActivity.this.B2(view);
            }
        });
        L2();
    }

    /* renamed from: R1 */
    public /* synthetic */ void r2() {
        this.L.T(3);
        new Handler().postDelayed(new Runnable() { // from class: com.martian.mibook.activity.reader.a
            @Override // java.lang.Runnable
            public final void run() {
                ChapterCommentActivity.this.o2();
            }
        }, 200L);
    }

    private void n2() {
        MiConfigSingleton.V3().l3().o2(this.R, this.S, this.N, this.P, new d());
    }

    public void o2() {
        if (p2()) {
            m2();
        } else {
            n2();
        }
    }

    private boolean p2() {
        return this.O == 0;
    }

    /* renamed from: s2 */
    public /* synthetic */ void t2(View v) {
        this.L.T(5);
    }

    /* renamed from: u2 */
    public /* synthetic */ void v2(final MiReadingTheme readingTheme, View v) {
        if (((Integer) this.J.l.getTag()).intValue() == 0) {
            return;
        }
        com.martian.mibook.lib.model.g.b.E(this, "最热");
        this.J.l.setTag(0);
        this.J.f12322d.setBackgroundResource(readingTheme.getRoundBgRes());
        this.J.k.setBackgroundResource(R.drawable.transparent_res);
        this.O = 0;
        G2();
    }

    /* renamed from: w2 */
    public /* synthetic */ void x2(final MiReadingTheme readingTheme, View v) {
        if (((Integer) this.J.l.getTag()).intValue() == p3.k) {
            return;
        }
        com.martian.mibook.lib.model.g.b.E(this, "最新");
        this.J.l.setTag(Integer.valueOf(p3.k));
        this.J.f12322d.setBackgroundResource(R.drawable.transparent_res);
        this.J.k.setBackgroundResource(readingTheme.getRoundBgRes());
        this.O = p3.k;
        G2();
    }

    /* renamed from: y2 */
    public /* synthetic */ void z2() {
        com.martian.mibook.lib.model.g.b.E(this, "重新加载");
        G2();
    }

    public void C2(String title) {
        if (com.martian.libmars.utils.n0.C(this)) {
            this.J.f12325g.setLoadingTip(ReaderLoadingTip.LoadStatus.empty);
            if (com.martian.libsupport.k.p(title)) {
                return;
            }
            this.J.f12325g.setTips(title);
        }
    }

    public void D2(b.d.c.b.c errorResult) {
        if (!com.martian.libmars.utils.n0.C(this) || errorResult == null) {
            return;
        }
        this.J.f12325g.setLoadingTip(errorResult.c() == -1 ? ReaderLoadingTip.LoadStatus.error : ReaderLoadingTip.LoadStatus.serverError);
        if (com.martian.libsupport.k.p(errorResult.d()) || errorResult.d().length() >= 20) {
            return;
        }
        this.J.f12325g.setTips(errorResult.d());
    }

    public void E2() {
        if (com.martian.libmars.utils.n0.C(this)) {
            this.J.f12325g.setLoadingTip(ReaderLoadingTip.LoadStatus.finish);
        }
    }

    public void F2(String tips) {
        if (com.martian.libmars.utils.n0.C(this)) {
            this.J.f12325g.setLoadingTip(ReaderLoadingTip.LoadStatus.loading);
            if (com.martian.libsupport.k.p(tips)) {
                return;
            }
            this.J.f12325g.setTips(tips);
        }
    }

    public void G2() {
        g4 g4Var = this.K;
        if (g4Var != null) {
            g4Var.E().setRefresh(true);
        }
        this.M = 0;
        this.N = null;
        o2();
    }

    public void J2(b.d.c.b.c errorResult, boolean isError) {
        g4 g4Var = this.K;
        if (g4Var != null && g4Var.getSize() > 0) {
            E2();
            this.J.f12323e.setLoadMoreStatus(ReaderLoadMoreFooterView.Status.THE_END);
        } else {
            if (isError) {
                D2(errorResult);
            } else {
                C2(errorResult.d());
            }
            this.J.f12323e.setLoadMoreStatus(ReaderLoadMoreFooterView.Status.GONE);
        }
    }

    public void m2() {
        MiConfigSingleton.V3().l3().n2(this.R, this.S, Integer.valueOf(this.M), this.P, new c());
    }

    @Override // com.martian.libmars.activity.h1, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 777 && resultCode == -1) {
            G2();
        }
    }

    @Override // com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        String G0;
        super.onCreate(savedInstanceState);
        a2(false);
        d(false);
        com.martian.mibook.e.m c2 = com.martian.mibook.e.m.c(getLayoutInflater());
        this.J = c2;
        setContentView(c2.getRoot());
        if (savedInstanceState != null) {
            this.P = savedInstanceState.getString(D);
            this.Q = savedInstanceState.getString(E);
            this.R = savedInstanceState.getString(B);
            this.S = savedInstanceState.getString(C);
            G0 = savedInstanceState.getString(F);
        } else {
            this.P = G0(D);
            this.Q = G0(E);
            this.R = G0(B);
            this.S = G0(C);
            G0 = G0(F);
        }
        if (!com.martian.libsupport.k.p(G0)) {
            this.U = (ChapterCommentCount) GsonUtils.b().fromJson(G0, ChapterCommentCount.class);
        }
        this.J.f12324f.getLayoutParams().height = com.martian.libsupport.l.g(this) - com.martian.libmars.d.h.b(172.0f);
        BottomSheetBehavior<View> s = BottomSheetBehavior.s(this.J.m);
        this.L = s;
        s.O(true);
        this.L.S(true);
        this.L.T(5);
        this.L.i(new a());
        M2();
        com.martian.mibook.lib.model.g.b.E(this, "查看章评");
        new Handler().postDelayed(new Runnable() { // from class: com.martian.mibook.activity.reader.f
            @Override // java.lang.Runnable
            public final void run() {
                ChapterCommentActivity.this.r2();
            }
        }, 200L);
    }

    @Override // com.martian.libmars.widget.recyclerview.f.a
    public void onLoadMore(View loadMoreView) {
        if (this.K == null) {
            return;
        }
        if (p2() && this.M == 0) {
            return;
        }
        if ((p2() || this.N != null) && this.K.getSize() >= 10) {
            this.K.E().setRefresh(this.K.getSize() <= 0);
            this.J.f12323e.setLoadMoreStatus(ReaderLoadMoreFooterView.Status.LOADING);
            o2();
        }
    }

    public void onOutsideTouchClick(View view) {
        this.L.T(5);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(B, this.R);
        outState.putString(C, this.S);
        outState.putString(D, this.P);
        outState.putString(E, this.Q);
        outState.putString(F, GsonUtils.b().toJson(this.U));
        super.onSaveInstanceState(outState);
    }
}
