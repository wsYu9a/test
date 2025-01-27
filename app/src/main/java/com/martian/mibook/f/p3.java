package com.martian.mibook.f;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.recyclerview.LoadMoreFooterView;
import com.martian.mibook.activity.book.BookInfoActivity;
import com.martian.mibook.activity.book.comment.WholeCommentActivity;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.book.Comment;
import com.martian.mibook.data.book.MiBookCommentItemList;
import com.martian.mibook.data.book.MiBookGetCommentByScoreItemList;
import com.martian.mibook.data.book.MiBookGetCommentByTimeItemList;
import com.martian.mibook.e.y4;
import com.martian.mibook.j.v2;
import com.martian.ttbookhd.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public class p3 extends com.martian.libmars.f.h implements com.martian.libmars.widget.recyclerview.f.a {

    /* renamed from: j */
    public static final int f13230j = 0;
    public static int k = 1;
    private Long l;
    private BookInfoActivity.o n;
    private com.martian.mibook.ui.o.y3 o;
    private com.martian.mibook.e.e3 r;
    private y4 s;
    private String t;
    private int m = 0;
    private final List<Comment> p = new ArrayList();
    private int q = 0;

    class a implements MiBookManager.j0 {
        a() {
        }

        @Override // com.martian.mibook.application.MiBookManager.j0
        public void a(b.d.c.b.c errorResult) {
            if (com.martian.libmars.utils.n0.c(((com.martian.libmars.f.e) p3.this).f10082a)) {
                return;
            }
            p3.this.n0(0.0f, 0, 0);
        }

        @Override // com.martian.mibook.application.MiBookManager.j0
        public void b(MiBookCommentItemList miBookCommentItemList) {
            if (com.martian.libmars.utils.n0.c(((com.martian.libmars.f.e) p3.this).f10082a)) {
                return;
            }
            p3.this.l0(miBookCommentItemList);
        }

        @Override // com.martian.mibook.application.MiBookManager.j0
        public void onLoading(boolean show) {
        }
    }

    class b implements MiBookManager.c0 {
        b() {
        }

        @Override // com.martian.mibook.application.MiBookManager.c0
        public void a(b.d.c.b.c errorResult) {
            p3.this.f0(errorResult);
        }

        @Override // com.martian.mibook.application.MiBookManager.c0
        public void b(MiBookGetCommentByTimeItemList miBookGetCommentByTimeItemList) {
            p3.this.e0(miBookGetCommentByTimeItemList);
        }

        @Override // com.martian.mibook.application.MiBookManager.c0
        public void onLoading(boolean show) {
            if (show) {
                p3 p3Var = p3.this;
                p3Var.i0(p3Var.getString(R.string.loading));
            }
        }
    }

    class c implements MiBookManager.b0 {
        c() {
        }

        @Override // com.martian.mibook.application.MiBookManager.b0
        public void a(b.d.c.b.c errorResult) {
            p3.this.f0(errorResult);
        }

        @Override // com.martian.mibook.application.MiBookManager.b0
        public void b(MiBookGetCommentByScoreItemList miBookGetCommentByScoreItemList) {
            p3.this.d0(miBookGetCommentByScoreItemList);
        }

        @Override // com.martian.mibook.application.MiBookManager.b0
        public void onLoading(boolean show) {
            if (show) {
                p3 p3Var = p3.this;
                p3Var.i0(p3Var.getString(R.string.loading));
            }
        }
    }

    class d implements v2.b0 {
        d() {
        }

        @Override // com.martian.mibook.j.v2.b0
        public void a(String tag, String comment) {
            p3.this.t = comment;
        }

        @Override // com.martian.mibook.j.v2.b0
        public void b(Comment comment) {
            p3.this.o.E().setRefresh(true);
            p3.this.m = 0;
            p3.this.l = null;
            p3.this.k0();
            ((com.martian.libmars.f.e) p3.this).f10082a.setResult(-1);
        }
    }

    private void G() {
        this.r.f11898b.E();
        View inflate = View.inflate(this.f10082a, R.layout.post_comment_header, null);
        this.s = y4.a(inflate);
        this.r.f11898b.m(inflate);
        this.s.f12990h.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p3.this.M(view);
            }
        });
        this.s.f12991i.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p3.this.O(view);
            }
        });
        this.s.f12992j.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p3.this.Q(view);
            }
        });
        this.s.k.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p3.this.S(view);
            }
        });
        this.s.l.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p3.this.U(view);
            }
        });
        this.s.m.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p3.this.W(view);
            }
        });
        this.s.f12984b.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p3.this.Y(view);
            }
        });
        this.s.f12987e.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p3.this.a0(view);
            }
        });
        o0();
        m0();
        p0();
    }

    private void H() {
        MiConfigSingleton.V3().l3().n2(this.n.o(), this.n.n(), Integer.valueOf(this.m), "", new c());
    }

    private void I() {
        MiConfigSingleton.V3().l3().o2(this.n.o(), this.n.n(), this.l, "", new b());
    }

    private void J() {
        if (f()) {
            if (K()) {
                H();
            } else {
                I();
            }
        }
    }

    private boolean K() {
        return this.q == 0;
    }

    /* renamed from: L */
    public /* synthetic */ void M(View view1) {
        c0(100);
    }

    /* renamed from: N */
    public /* synthetic */ void O(View v) {
        c0(20);
    }

    /* renamed from: P */
    public /* synthetic */ void Q(View v) {
        c0(40);
    }

    /* renamed from: R */
    public /* synthetic */ void S(View v) {
        c0(60);
    }

    /* renamed from: T */
    public /* synthetic */ void U(View v) {
        c0(80);
    }

    /* renamed from: V */
    public /* synthetic */ void W(View v) {
        c0(100);
    }

    /* renamed from: X */
    public /* synthetic */ void Y(View v) {
        if (K()) {
            return;
        }
        this.q = 0;
        p0();
        m();
    }

    /* renamed from: Z */
    public /* synthetic */ void a0(View v) {
        if (K()) {
            this.q = k;
            p0();
            m();
        }
    }

    public static p3 b0(BookInfoActivity.o bookInfo) {
        p3 p3Var = new p3();
        Bundle bundle = new Bundle();
        if (bookInfo != null) {
            bundle.putString(WholeCommentActivity.F, GsonUtils.b().toJson(bookInfo));
        }
        p3Var.setArguments(bundle);
        return p3Var;
    }

    private void c0(int score) {
        if (com.martian.libsupport.k.p(this.n.c()) || com.martian.libsupport.k.p(this.n.a())) {
            d("获取书籍信息失败");
        } else {
            com.martian.mibook.j.v2.a1(this.f10082a, this.n, score, this.t, new d());
        }
    }

    public void d0(MiBookGetCommentByScoreItemList miBookGetCommentByScoreItemList) {
        if (com.martian.libmars.utils.n0.c(this.f10082a)) {
            return;
        }
        p();
        if (miBookGetCommentByScoreItemList == null || miBookGetCommentByScoreItemList.getCommentList() == null || miBookGetCommentByScoreItemList.getCommentList().size() <= 0) {
            g0(new b.d.c.b.c(-1, "数据为空"), false);
            return;
        }
        k();
        h0(true);
        Iterator<Comment> it = miBookGetCommentByScoreItemList.getCommentList().iterator();
        if (this.n.e() != null) {
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().getCid().equals(this.n.e().getCid())) {
                    it.remove();
                    break;
                }
            }
        }
        if (this.o.E().isRefresh()) {
            if (this.n.e() != null) {
                miBookGetCommentByScoreItemList.getCommentList().add(0, this.n.e());
            }
            this.o.a(miBookGetCommentByScoreItemList.getCommentList());
        } else {
            this.o.m(miBookGetCommentByScoreItemList.getCommentList());
        }
        this.m++;
    }

    public void e0(MiBookGetCommentByTimeItemList miBookGetCommentByTimeItemList) {
        if (com.martian.libmars.utils.n0.c(this.f10082a)) {
            return;
        }
        p();
        if (miBookGetCommentByTimeItemList == null || miBookGetCommentByTimeItemList.getCommentList() == null || miBookGetCommentByTimeItemList.getCommentList().size() <= 0) {
            g0(new b.d.c.b.c(-1, "数据为空"), false);
            return;
        }
        k();
        h0(true);
        this.l = miBookGetCommentByTimeItemList.getCommentList().get(miBookGetCommentByTimeItemList.getCommentList().size() - 1).getCreatedOn();
        if (this.o.E().isRefresh()) {
            this.o.a(miBookGetCommentByTimeItemList.getCommentList());
        } else {
            this.o.m(miBookGetCommentByTimeItemList.getCommentList());
        }
        this.m++;
    }

    public void f0(b.d.c.b.c errorResult) {
        if (com.martian.libmars.utils.n0.c(this.f10082a)) {
            return;
        }
        p();
        g0(errorResult, true);
    }

    private void h0(boolean show) {
        y4 y4Var = this.s;
        if (y4Var != null) {
            y4Var.f12989g.setVisibility(show ? 0 : 4);
        }
    }

    private void j0() {
        if (this.n.r()) {
            c0(100);
        }
    }

    public void k0() {
        if (com.martian.libsupport.k.p(this.n.c()) || com.martian.libsupport.k.p(this.n.a())) {
            J();
        } else {
            MiConfigSingleton.V3().l3().w2(this.n.o(), this.n.n(), new a());
        }
    }

    public void l0(MiBookCommentItemList miBookCommentItemList) {
        if (miBookCommentItemList == null) {
            n0(0.0f, 0, 0);
            return;
        }
        List<Comment> commentList = miBookCommentItemList.getCommentList();
        if (commentList != null && commentList.size() > 0) {
            Iterator<Comment> it = commentList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Comment next = it.next();
                if (MiConfigSingleton.V3().w3().equalsIgnoreCase(next.getCuid())) {
                    this.n.x(next);
                    q0();
                    break;
                }
            }
        }
        n0(miBookCommentItemList.getScore(), miBookCommentItemList.getNComments().intValue(), miBookCommentItemList.getNStars().intValue());
    }

    private void m0() {
        String str;
        String str2;
        y4 y4Var = this.s;
        if (y4Var == null) {
            return;
        }
        ThemeTextView themeTextView = y4Var.f12985c;
        if (this.n.g() > 0) {
            str = this.n.g() + "人点评";
        } else {
            str = "快来评分吧";
        }
        themeTextView.setText(str);
        ThemeTextView themeTextView2 = this.s.f12988f;
        if (this.n.f() > 0) {
            str2 = "(" + this.n.f() + "条)";
        } else {
            str2 = "";
        }
        themeTextView2.setText(str2);
    }

    public void n0(float bookScore, int nComments, int nStars) {
        this.n.G(bookScore);
        this.n.y(Integer.valueOf(nComments));
        this.n.z(Integer.valueOf(nStars));
        o0();
        m0();
        J();
    }

    private void o0() {
        if (this.s == null) {
            return;
        }
        float m = this.n.m();
        if (m <= 0.0f) {
            this.s.n.setVisibility(0);
            this.s.o.setVisibility(8);
            this.s.p.setVisibility(8);
        } else {
            this.s.n.setVisibility(8);
            this.s.o.setVisibility(0);
            this.s.o.setText(String.format(Locale.getDefault(), "%.1f", Float.valueOf(m)));
            this.s.p.setVisibility(0);
        }
    }

    @SuppressLint({"SetTextI18n"})
    private void q0() {
        if (this.s == null || this.n.e() == null) {
            return;
        }
        int score = this.n.e().getScore();
        ImageView imageView = this.s.f12991i;
        int i2 = R.drawable.vote_star_grey;
        imageView.setImageResource(score < 20 ? R.drawable.vote_star_grey : R.drawable.vote_star_red);
        this.s.f12992j.setImageResource(score < 40 ? R.drawable.vote_star_grey : R.drawable.vote_star_red);
        this.s.k.setImageResource(score < 60 ? R.drawable.vote_star_grey : R.drawable.vote_star_red);
        this.s.l.setImageResource(score < 80 ? R.drawable.vote_star_grey : R.drawable.vote_star_red);
        ImageView imageView2 = this.s.m;
        if (score >= 100) {
            i2 = R.drawable.vote_star_red;
        }
        imageView2.setImageResource(i2);
        this.s.f12986d.setText(getString(R.string.mine) + getString(R.string.grade));
    }

    @Override // com.martian.libmars.f.e
    public com.martian.libmars.activity.j1 a() {
        return (com.martian.libmars.activity.j1) getActivity();
    }

    @Override // com.martian.libmars.f.e
    protected void c() {
    }

    public void g0(b.d.c.b.c errorResult, boolean isError) {
        com.martian.mibook.ui.o.y3 y3Var = this.o;
        if (y3Var != null && y3Var.getSize() > 0) {
            k();
            this.r.f11898b.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
            return;
        }
        if (isError) {
            j(errorResult);
        } else {
            i(errorResult.d());
        }
        h0(false);
        this.r.f11898b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
    }

    @Override // com.martian.libmars.f.h
    public int h() {
        return R.layout.fragment_comments;
    }

    public void i0(String title) {
        com.martian.mibook.ui.o.y3 y3Var = this.o;
        if (y3Var == null || y3Var.getSize() > 0) {
            return;
        }
        l(title);
    }

    @Override // com.martian.libmars.f.h
    public void m() {
        if (com.martian.libmars.utils.n0.C(this.f10082a)) {
            this.o.E().setRefresh(true);
            this.m = 0;
            this.l = null;
            J();
        }
    }

    @Override // com.martian.libmars.widget.recyclerview.f.a
    public void onLoadMore(View loadMoreView) {
        if (!com.martian.libmars.utils.n0.C(this.f10082a) || this.m == 0) {
            return;
        }
        this.o.E().setRefresh(this.o.getSize() <= 0);
        this.r.f11898b.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
        J();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull final View baseView, Bundle savedInstanceState) {
        String string;
        super.onViewCreated(baseView, savedInstanceState);
        if (savedInstanceState != null) {
            string = savedInstanceState.getString(WholeCommentActivity.F);
        } else {
            Bundle arguments = getArguments();
            string = arguments != null ? arguments.getString(WholeCommentActivity.F) : "";
        }
        if (!com.martian.libsupport.k.p(string)) {
            this.n = (BookInfoActivity.o) GsonUtils.b().fromJson(string, BookInfoActivity.o.class);
        }
        BookInfoActivity.o oVar = this.n;
        if (oVar == null || (com.martian.libsupport.k.p(oVar.a()) && com.martian.libsupport.k.p(this.n.c()))) {
            this.f10082a.k1("获取信息失败");
            this.f10082a.finish();
            return;
        }
        com.martian.mibook.e.e3 a2 = com.martian.mibook.e.e3.a(g());
        this.r = a2;
        a2.f11898b.setLayoutManager(new LinearLayoutManager(getContext()));
        this.o = new com.martian.mibook.ui.o.y3(this.f10082a, this.p, false);
        G();
        this.r.f11898b.setAdapter(this.o);
        this.r.f11898b.setOnLoadMoreListener(this);
        this.r.f11898b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        int b2 = com.martian.libmars.d.h.b(145.0f);
        y4 y4Var = this.s;
        if (y4Var != null) {
            y4Var.getRoot().measure(0, 0);
            b2 = this.s.getRoot().getMeasuredHeight();
        }
        n(0, b2, 0, 0);
        q0();
        j0();
        if (this.n.m() <= 0.0f) {
            k0();
        } else {
            J();
        }
    }

    public void p0() {
        if (this.s != null) {
            boolean K = K();
            int i2 = R.drawable.border_account_grey_line_night;
            if (K) {
                ThemeTextView themeTextView = this.s.f12984b;
                if (!com.martian.libmars.d.h.F().I0()) {
                    i2 = R.drawable.border_background_bonus_white;
                }
                themeTextView.setBackgroundResource(i2);
                this.s.f12987e.setBackgroundResource(R.drawable.transparent_res);
                return;
            }
            this.s.f12984b.setBackgroundResource(R.drawable.transparent_res);
            ThemeTextView themeTextView2 = this.s.f12987e;
            if (!com.martian.libmars.d.h.F().I0()) {
                i2 = R.drawable.border_background_bonus_white;
            }
            themeTextView2.setBackgroundResource(i2);
        }
    }
}
