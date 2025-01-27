package com.martian.mibook.activity.book;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.gyf.barlibrary.ImmersionBar;
import com.martian.free.response.TFBook;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.activity.j1;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.utils.n0;
import com.martian.libmars.widget.recyclerview.LoadMoreFooterView;
import com.martian.mibook.activity.Homepage;
import com.martian.mibook.activity.book.BookRankActivity;
import com.martian.mibook.activity.book.comment.WholeCommentActivity;
import com.martian.mibook.activity.reader.ReadingActivity;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.n0;
import com.martian.mibook.data.book.Comment;
import com.martian.mibook.data.book.MiBookCommentItemList;
import com.martian.mibook.e.w4;
import com.martian.mibook.e.w5;
import com.martian.mibook.f.f4.g0;
import com.martian.mibook.f.f4.j0;
import com.martian.mibook.j.s2;
import com.martian.mibook.j.v2;
import com.martian.mibook.j.y2;
import com.martian.mibook.lib.account.request.TYChapterContentParams;
import com.martian.mibook.lib.account.response.TYChapterContent;
import com.martian.mibook.lib.model.data.MiBook;
import com.martian.mibook.lib.model.data.MiChapterList;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import com.martian.mibook.lib.model.data.Source;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import com.martian.mibook.lib.yuewen.response.YWBook;
import com.martian.mibook.lib.yuewen.response.YWCategory;
import com.martian.mibook.ui.o.h4;
import com.martian.mibook.ui.o.y3;
import com.martian.ttbookhd.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/* loaded from: classes3.dex */
public class BookInfoActivity extends com.martian.mibook.activity.base.n {
    public static final String Q = "INTENT_BOOK_INFO";
    public static final int R = 777;
    private com.martian.mibook.e.h S;
    private View T;
    private ImageView U;
    private o W;
    private Source X;
    private Book Y;
    private MiBook Z;
    private MiBookManager.m0 a0;
    private List<TYBookItem> c0;
    private List<TYBookItem> d0;
    private List<TYBookItem> e0;
    private w4 f0;
    private BottomSheetBehavior<View> g0;
    private BottomSheetDialog h0;
    private h4 i0;
    private y3 k0;
    private String l0;
    private int V = 0;
    private int b0 = 1;
    private final List<Comment> j0 = new ArrayList();
    private boolean m0 = false;
    private boolean n0 = false;
    private boolean o0 = false;
    private boolean p0 = false;

    class a extends BottomSheetBehavior.f {
        a() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void a(@NonNull View bottomSheet, float slideOffset) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void b(@NonNull View bottomSheet, int newState) {
            if (newState == 5) {
                BookInfoActivity.this.h0.dismiss();
            }
        }
    }

    class b implements MiBookManager.j0 {
        b() {
        }

        @Override // com.martian.mibook.application.MiBookManager.j0
        public void a(b.d.c.b.c errorResult) {
        }

        @Override // com.martian.mibook.application.MiBookManager.j0
        public void b(MiBookCommentItemList miBookCommentItemList) {
            BookInfoActivity.this.o4(miBookCommentItemList);
        }

        @Override // com.martian.mibook.application.MiBookManager.j0
        public void onLoading(boolean show) {
        }
    }

    class c extends ClickableSpan {
        c() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            BookInfoActivity.this.onMyCommentClick(null);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
            ds.setColor(ContextCompat.getColor(BookInfoActivity.this, R.color.theme_default));
        }
    }

    class d implements v2.b0 {
        d() {
        }

        @Override // com.martian.mibook.j.v2.b0
        public void a(String tag, String comment) {
            BookInfoActivity.this.l0 = comment;
        }

        @Override // com.martian.mibook.j.v2.b0
        public void b(Comment comment) {
            BookInfoActivity.this.m4();
        }
    }

    class e implements com.martian.mibook.lib.model.c.g {
        e() {
        }

        @Override // com.martian.mibook.lib.model.c.g
        public String getSourceId() {
            return BookInfoActivity.this.W.n();
        }

        @Override // com.martian.mibook.lib.model.c.g
        public String getSourceName() {
            return BookInfoActivity.this.W.o();
        }
    }

    class f extends com.martian.mibook.lib.model.d.h {
        f() {
        }

        @Override // com.martian.mibook.lib.model.d.h
        public void a(boolean loading) {
        }

        @Override // com.martian.mibook.lib.model.d.h
        public void b(List<TYBookItem> books) {
            super.b(books);
            if (BookInfoActivity.this.Y != null || books.isEmpty()) {
                return;
            }
            TYBookItem tYBookItem = books.get(0);
            if (tYBookItem.getBookName() == null || !tYBookItem.getBookName().equals(BookInfoActivity.this.Z.getBookName())) {
                return;
            }
            BookInfoActivity.this.o3(tYBookItem);
        }

        @Override // com.martian.mibook.lib.model.d.h
        public void c(List<TYBookItem> books) {
            if (BookInfoActivity.this.Y == null && !books.isEmpty()) {
                BookInfoActivity.this.o3(books.get(0));
            } else if (books.isEmpty()) {
                BookInfoActivity.this.u3();
            }
        }

        @Override // com.martian.mibook.lib.model.d.h
        public void d(b.d.c.b.c errorResult) {
            BookInfoActivity.this.g4(errorResult);
        }
    }

    class g implements com.martian.mibook.lib.model.d.b {
        g() {
        }

        @Override // com.martian.mibook.lib.model.d.b
        public void a(Book book) {
            BookInfoActivity.this.e4(book);
        }

        @Override // com.martian.mibook.lib.model.d.b
        public void onLoading(boolean loading) {
            BookInfoActivity.this.K2(loading);
        }

        @Override // com.martian.mibook.lib.model.d.b
        public void onResultError(b.d.c.b.c errorResult) {
            BookInfoActivity.this.g4(errorResult);
        }
    }

    class h extends com.martian.mibook.lib.account.d.g<TYChapterContentParams, TYChapterContent> {
        h(Class x0, Class x1, Context x2) {
            super(x0, x1, x2);
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            if (n0.c(BookInfoActivity.this)) {
                return;
            }
            BookInfoActivity.this.S.l0.setVisibility(8);
        }

        @Override // b.d.c.c.i, b.d.c.c.c
        public void onUDDataReceived(List<TYChapterContent> tyChapterContents) {
            if (tyChapterContents == null || tyChapterContents.isEmpty()) {
                BookInfoActivity.this.S.l0.setVisibility(8);
            } else {
                BookInfoActivity.this.t3(tyChapterContents.get(0));
            }
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    class i extends com.martian.mibook.lib.model.d.f {
        i() {
        }

        @Override // com.martian.mibook.lib.model.d.f
        public void a(boolean loading) {
        }

        @Override // com.martian.mibook.lib.model.d.f
        public void c(ChapterList chapterList) {
            BookInfoActivity.this.S.n0.setVisibility(8);
            if (BookInfoActivity.this.K0()) {
                BookInfoActivity.this.j4();
            }
        }

        @Override // com.martian.mibook.lib.model.d.f
        public void d(b.d.c.b.c errorResult) {
            BookInfoActivity.this.S.n0.setVisibility(8);
            BookInfoActivity.this.k1(errorResult.d());
        }
    }

    class j implements View.OnClickListener {

        /* renamed from: a */
        private boolean f10967a = false;

        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f10967a = !this.f10967a;
            BookInfoActivity.this.S.z.setMaxLines(this.f10967a ? Integer.MAX_VALUE : 4);
            BookInfoActivity.this.S.u0.setImageResource(this.f10967a ? R.drawable.icon_more_top : R.drawable.icon_more);
        }
    }

    class k extends com.martian.mibook.lib.model.d.h {
        k() {
        }

        @Override // com.martian.mibook.lib.model.d.h
        public void a(boolean loading) {
        }

        @Override // com.martian.mibook.lib.model.d.h
        public void c(List<TYBookItem> books) {
            if (books == null || books.isEmpty()) {
                BookInfoActivity bookInfoActivity = BookInfoActivity.this;
                bookInfoActivity.l3(bookInfoActivity.S.U, BookInfoActivity.this.S.R, books);
                return;
            }
            Iterator<TYBookItem> it = books.iterator();
            while (it.hasNext()) {
                TYBookItem next = it.next();
                if (BookInfoActivity.this.Y != null && next.getSourceString().equals(BookInfoActivity.this.Y.getSourceString())) {
                    it.remove();
                }
            }
            if (books.size() >= 8) {
                BookInfoActivity.this.S.x0.setVisibility(0);
                BookInfoActivity.this.S.y0.setVisibility(0);
            } else {
                BookInfoActivity.this.S.x0.setVisibility(8);
                BookInfoActivity.this.S.y0.setVisibility(8);
            }
            BookInfoActivity.this.c0 = books;
            BookInfoActivity bookInfoActivity2 = BookInfoActivity.this;
            bookInfoActivity2.l3(bookInfoActivity2.S.U, BookInfoActivity.this.S.R, BookInfoActivity.this.c0);
        }

        @Override // com.martian.mibook.lib.model.d.h
        public void d(b.d.c.b.c errorResult) {
            BookInfoActivity bookInfoActivity = BookInfoActivity.this;
            bookInfoActivity.l3(bookInfoActivity.S.U, BookInfoActivity.this.S.R, null);
        }
    }

    class l extends com.martian.mibook.lib.model.d.h {

        /* renamed from: a */
        final /* synthetic */ boolean f10970a;

        l(final boolean val$manual) {
            this.f10970a = val$manual;
        }

        @Override // com.martian.mibook.lib.model.d.h
        public void a(boolean loading) {
        }

        @Override // com.martian.mibook.lib.model.d.h
        public void b(List<TYBookItem> books) {
            super.b(books);
        }

        @Override // com.martian.mibook.lib.model.d.h
        public void c(List<TYBookItem> books) {
            BookInfoActivity.R2(BookInfoActivity.this);
            BookInfoActivity.this.S.J.setVisibility(8);
            BookInfoActivity.this.S.C.setVisibility(0);
            BookInfoActivity.this.d0 = books;
            if (this.f10970a) {
                BookInfoActivity.this.v3(true);
            }
            BookInfoActivity bookInfoActivity = BookInfoActivity.this;
            bookInfoActivity.l3(bookInfoActivity.S.T, BookInfoActivity.this.S.S, BookInfoActivity.this.d0);
        }

        @Override // com.martian.mibook.lib.model.d.h
        public void d(b.d.c.b.c errorResult) {
            BookInfoActivity.this.S.J.setVisibility(8);
            BookInfoActivity.this.S.C.setVisibility(0);
        }
    }

    class m extends com.martian.mibook.lib.model.d.h {

        /* renamed from: a */
        final /* synthetic */ String f10972a;

        m(final String val$excludeBookName) {
            this.f10972a = val$excludeBookName;
        }

        @Override // com.martian.mibook.lib.model.d.h
        public void a(boolean loading) {
        }

        @Override // com.martian.mibook.lib.model.d.h
        public void b(List<TYBookItem> books) {
            super.b(books);
        }

        @Override // com.martian.mibook.lib.model.d.h
        public void c(List<TYBookItem> books) {
            if (books == null || books.isEmpty()) {
                BookInfoActivity bookInfoActivity = BookInfoActivity.this;
                bookInfoActivity.l3(bookInfoActivity.S.f12031g, BookInfoActivity.this.S.f12032h, books);
                return;
            }
            BookInfoActivity.this.n4(books, this.f10972a);
            if (books.size() > 8) {
                BookInfoActivity.this.S.f12026b.setVisibility(0);
                BookInfoActivity.this.S.f12027c.setVisibility(0);
            } else {
                BookInfoActivity.this.S.f12026b.setVisibility(8);
                BookInfoActivity.this.S.f12027c.setVisibility(8);
            }
            BookInfoActivity.this.e0 = books;
            BookInfoActivity bookInfoActivity2 = BookInfoActivity.this;
            bookInfoActivity2.l3(bookInfoActivity2.S.f12031g, BookInfoActivity.this.S.f12032h, BookInfoActivity.this.e0);
        }

        @Override // com.martian.mibook.lib.model.d.h
        public void d(b.d.c.b.c errorResult) {
            BookInfoActivity bookInfoActivity = BookInfoActivity.this;
            bookInfoActivity.l3(bookInfoActivity.S.f12031g, BookInfoActivity.this.S.f12032h, null);
        }
    }

    class n implements n0.b {

        /* renamed from: a */
        private final Book f10974a;

        n(Book bw) {
            this.f10974a = bw;
        }

        @Override // com.martian.mibook.application.n0.b
        public void b(Book book, b.d.c.b.c errorResult) {
        }

        @Override // com.martian.mibook.application.n0.b
        public void e(Book book) {
        }

        @Override // com.martian.mibook.application.n0.b
        public void f(Book book) {
        }

        public int hashCode() {
            return this.f10974a.hashCode();
        }

        @Override // com.martian.mibook.application.n0.b
        public void j(Book book) {
        }

        @Override // com.martian.mibook.application.n0.b
        public void m(Book book) {
            BookInfoActivity.this.k1("缓存已加入队列");
        }

        @Override // com.martian.mibook.application.n0.b
        public void n(Book book, int failedSize) {
            BookInfoActivity.this.k1("部分章节缓存失败");
        }

        @Override // com.martian.mibook.application.n0.b
        public void o(Book book, int index, int size, boolean cachedBefore) {
        }

        @Override // com.martian.mibook.application.n0.b
        public void s(Book book) {
        }
    }

    public static class o {

        /* renamed from: a */
        private String f10976a;

        /* renamed from: b */
        private String f10977b;

        /* renamed from: c */
        private String f10978c;

        /* renamed from: d */
        private String f10979d;

        /* renamed from: e */
        private Integer f10980e;

        /* renamed from: f */
        private String f10981f;

        /* renamed from: g */
        private String f10982g;

        /* renamed from: h */
        private String f10983h;

        /* renamed from: j */
        private Integer f10985j;
        private Integer k;
        private String m;
        private Integer n;
        private Integer o;
        private Comment p;
        private List<String> q;
        private BookRankActivity.a r;

        /* renamed from: i */
        private float f10984i = -1.0f;
        private boolean l = false;

        public o A(boolean postComment) {
            this.l = postComment;
            return this;
        }

        public void B(Integer price) {
            this.f10980e = price;
        }

        public void C(BookRankActivity.a rankInfo) {
            this.r = rankInfo;
        }

        public void D(Integer readingCount) {
            this.o = readingCount;
        }

        public o E(String recommend) {
            this.f10982g = recommend;
            return this;
        }

        public o F(String recommendId) {
            this.f10983h = recommendId;
            return this;
        }

        public o G(float score) {
            this.f10984i = score;
            return this;
        }

        public o H(String sourceId) {
            this.f10976a = sourceId;
            return this;
        }

        public o I(String sourceName) {
            this.f10977b = sourceName;
            return this;
        }

        public void J(List<String> tagList) {
            this.q = tagList;
        }

        public String a() {
            return this.m;
        }

        public String b() {
            return this.f10978c;
        }

        public String c() {
            return this.f10979d;
        }

        public Integer d() {
            return this.n;
        }

        public Comment e() {
            return this.p;
        }

        public int f() {
            Integer num = this.f10985j;
            if (num == null) {
                return -1;
            }
            return num.intValue();
        }

        public int g() {
            Integer num = this.k;
            if (num == null) {
                return -1;
            }
            return num.intValue();
        }

        public String getContext() {
            return this.f10981f;
        }

        public Integer h() {
            Integer num = this.f10980e;
            return Integer.valueOf(num == null ? -1 : num.intValue());
        }

        public BookRankActivity.a i() {
            return this.r;
        }

        public Integer j() {
            return this.o;
        }

        public String k() {
            return this.f10982g;
        }

        public String l() {
            return this.f10983h;
        }

        public float m() {
            return this.f10984i;
        }

        public String n() {
            return this.f10976a;
        }

        public String o() {
            return this.f10977b;
        }

        public String p() {
            return this.f10977b + "|" + this.f10976a;
        }

        public List<String> q() {
            return this.q;
        }

        public boolean r() {
            return this.l;
        }

        public void s(String authorName) {
            this.m = authorName;
        }

        public o t(String bid) {
            this.f10978c = bid;
            return this;
        }

        public o u(String bookName) {
            this.f10979d = bookName;
            return this;
        }

        public void v(Integer clickCount) {
            this.n = clickCount;
        }

        public o w(String context) {
            this.f10981f = context;
            return this;
        }

        public void x(Comment myComment) {
            this.p = myComment;
        }

        public o y(Integer nComments) {
            this.f10985j = nComments;
            return this;
        }

        public void z(Integer nStars) {
            this.k = nStars;
        }
    }

    /* renamed from: B3 */
    public /* synthetic */ void C3(View view) {
        if (this.S.g0.getLayout().getEllipsisCount(this.S.g0.getLineCount() - 1) <= 0) {
            s2.g0(this, this.Z, this.Y, 1, 0, 0, true);
            com.martian.mibook.lib.model.g.b.y(this, "继续阅读下一章");
            return;
        }
        com.martian.mibook.lib.model.g.b.y(this, "抢先阅读第一章-" + this.b0 + "次");
        this.S.g0.setMaxLines((this.b0 * 41) + 11);
        this.b0 = this.b0 + 1;
        this.S.g0.post(new Runnable() { // from class: com.martian.mibook.activity.book.i
            @Override // java.lang.Runnable
            public final void run() {
                BookInfoActivity.this.K3();
            }
        });
    }

    /* renamed from: D3 */
    public /* synthetic */ void E3() {
        super.finish();
    }

    /* renamed from: F3 */
    public /* synthetic */ void G3(NestedScrollView nestedScrollView, int x, int y, int oldX, int oldY) {
        if (this.Y != null) {
            if (y <= 100) {
                float f2 = y / 100.0f;
                o2(f2);
                this.T.setAlpha(f2);
                this.U.setVisibility(4);
            } else if (this.U.getVisibility() == 4) {
                o2(1.0f);
                this.T.setAlpha(1.0f);
                this.U.setVisibility(0);
            }
            y3();
        }
    }

    /* renamed from: H3 */
    public /* synthetic */ void I3() {
        this.g0.T(5);
    }

    /* renamed from: J3 */
    public /* synthetic */ void K3() {
        if (this.S.g0.getLayout().getEllipsisCount(this.S.g0.getLineCount() - 1) <= 0) {
            this.S.j0.setText(getString(R.string.book_read_chapter_next));
            this.S.h0.setImageResource(R.drawable.loan_more);
        }
    }

    /* renamed from: L3 */
    public /* synthetic */ void M3(final Intent data) {
        int intExtra;
        if (data == null || (intExtra = data.getIntExtra(ReadingActivity.E, 0)) <= 0) {
            return;
        }
        MiConfigSingleton.V3().M4.G(this, "本次阅读奖励", 0, intExtra);
    }

    /* renamed from: N3 */
    public /* synthetic */ void O3() {
        if (com.martian.libsupport.f.d(this)) {
            com.martian.mibook.lib.model.g.b.P(this, "通知引导-设置成功");
            k1("开启成功");
        } else {
            k1("开启失败");
        }
        MiConfigSingleton.V3().L4.N0(this);
    }

    /* renamed from: P3 */
    public /* synthetic */ void Q3(View view) {
        com.martian.mibook.lib.model.g.b.y(this, "本书读者还喜欢-查看全部");
        AuthorBooksActivity.r2(this, this.W);
    }

    static /* synthetic */ int R2(BookInfoActivity bookInfoActivity) {
        int i2 = bookInfoActivity.V;
        bookInfoActivity.V = i2 + 1;
        return i2;
    }

    static /* synthetic */ void R3(View view) {
    }

    /* renamed from: S3 */
    public /* synthetic */ void T3(String titleName, int position) {
        com.martian.mibook.lib.model.g.b.y(this, "标签-点击");
        YWTagsActivity.r2(this, titleName, w3(), j0.x);
    }

    /* renamed from: U3 */
    public /* synthetic */ void V3() {
        com.martian.mibook.e.h hVar = this.S;
        hVar.y.setVisibility(hVar.z.getLineCount() > 4 ? 0 : 8);
    }

    /* renamed from: W3 */
    public /* synthetic */ void X3(View view) {
        if (this.Y == null) {
            k1("书籍加载中，请稍后");
            return;
        }
        com.martian.mibook.lib.model.g.b.y(this, "本书读者还喜欢-查看全部");
        Book book = this.Y;
        MiBookManager.m0 m0Var = this.a0;
        AuthorBooksActivity.s2(this, book, AuthorBooksActivity.I, m0Var == null ? 0 : m0Var.e());
    }

    static /* synthetic */ void Y3(View view) {
    }

    /* renamed from: Z3 */
    public /* synthetic */ boolean a4(View v, MotionEvent event) {
        this.f0.m.getParent().requestDisallowInterceptTouchEvent(this.f0.m.canScrollVertically(-1));
        return false;
    }

    /* renamed from: b4 */
    public /* synthetic */ void c4(AdapterView adapterView, View view, int position, long l2) {
        s2.g0(this, this.Z, this.Y, Integer.valueOf(this.i0.i(position)), 0, 0, false);
        new Handler().postDelayed(new Runnable() { // from class: com.martian.mibook.activity.book.m
            @Override // java.lang.Runnable
            public final void run() {
                BookInfoActivity.this.I3();
            }
        }, 500L);
    }

    public void e4(Book book) {
        if (com.martian.libmars.utils.n0.c(this)) {
            return;
        }
        B2();
        if (book == null) {
            j2();
            return;
        }
        l2();
        this.Y = book;
        if (com.martian.libsupport.k.p(this.W.c())) {
            this.W.u(book.getBookName());
            MiBook miBook = this.Z;
            if (miBook != null) {
                miBook.setBookName(book.getBookName());
            }
            r3();
        }
        if (!com.martian.libsupport.k.p(this.W.c())) {
            Z1(this.W.c());
        }
        this.W.s(book.getAuthor());
        h4(book);
        m4();
    }

    @SuppressLint({"SetTextI18n"})
    private void f4(String errorMsg) {
        l2();
        F2();
        o2(1.0f);
        this.S.p0.setVisibility(8);
        this.S.r0.setVisibility(8);
        this.S.o0.setVisibility(8);
        this.S.f12031g.setVisibility(8);
        this.S.q0.setVisibility(0);
        this.S.q0.setText("- " + errorMsg + " -");
        r3();
        this.S.D.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.book.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookInfoActivity.this.Q3(view);
            }
        });
        this.S.E.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.book.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookInfoActivity.R3(view);
            }
        });
    }

    public void g4(b.d.c.b.c errorResult) {
        if (com.martian.libmars.utils.n0.c(this)) {
            return;
        }
        B2();
        if (errorResult.c() == 60001) {
            f4(errorResult.d());
        } else {
            k2(errorResult.d());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x046b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x047a  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x044a  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0260  */
    @android.annotation.SuppressLint({"SetTextI18n"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void h4(final com.martian.mibook.lib.model.data.abs.Book r12) {
        /*
            Method dump skipped, instructions count: 1185
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.activity.book.BookInfoActivity.h4(com.martian.mibook.lib.model.data.abs.Book):void");
    }

    public static void i4(j1 activity, o bookInfo) {
        Bundle bundle = new Bundle();
        bundle.putString(Q, GsonUtils.b().toJson(bookInfo));
        activity.startActivity(BookInfoActivity.class, bundle);
    }

    private void initView() {
        this.T = findViewById(R.id.actionbar_top_view);
        ImageView imageView = (ImageView) findViewById(R.id.actionbar_divider);
        this.U = imageView;
        imageView.setVisibility(4);
        this.S.A0.setPadding(com.martian.libmars.d.h.b(14.0f), com.martian.libmars.d.h.b(56.0f) + ImmersionBar.getStatusBarHeight(this), com.martian.libmars.d.h.b(16.0f), com.martian.libmars.d.h.b(4.0f));
        this.S.q.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: com.martian.mibook.activity.book.f
            @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
            public final void onScrollChange(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
                BookInfoActivity.this.G3(nestedScrollView, i2, i3, i4, i5);
            }
        });
    }

    @SuppressLint({"ClickableViewAccessibility", "SetTextI18n"})
    public void j4() {
        String str;
        int b2;
        MiChapterList p = MiConfigSingleton.V3().l3().b0(this.W.o()).p(this.X);
        if (p == null) {
            k1("获取信息失败");
            return;
        }
        View inflate = View.inflate(this, R.layout.popupwindow_reader_dir, null);
        this.f0 = w4.a(inflate);
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        this.h0 = bottomSheetDialog;
        bottomSheetDialog.setContentView(inflate);
        setBottomSheetCallback((View) this.f0.getRoot().getParent());
        this.h0.show();
        this.f0.f12895j.setVisibility(MiConfigSingleton.V3().I0() ? 0 : 8);
        this.f0.l.setText("目录加载中...");
        w4 w4Var = this.f0;
        w4Var.m.setEmptyView(w4Var.l);
        this.f0.m.setDividerHeight(0);
        this.f0.m.setChoiceMode(1);
        this.f0.m.setFastScrollEnabled(true);
        h4 h4Var = new h4(this, p.getCursor(), 0, this.X, this.f0.m, false);
        this.i0 = h4Var;
        h4Var.q(p);
        this.f0.m.setAdapter((ListAdapter) this.i0);
        s4();
        this.f0.m.setOnTouchListener(new View.OnTouchListener() { // from class: com.martian.mibook.activity.book.p
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return BookInfoActivity.this.a4(view, motionEvent);
            }
        });
        this.f0.m.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.martian.mibook.activity.book.r
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
                BookInfoActivity.this.c4(adapterView, view, i2, j2);
            }
        });
        int count = p.getCount();
        FrameLayout frameLayout = (FrameLayout) this.h0.getDelegate().findViewById(R.id.design_bottom_sheet);
        if (frameLayout != null) {
            frameLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) frameLayout.getLayoutParams();
            if (count > 8) {
                b2 = (com.martian.libsupport.l.g(this) - this.S.A0.getHeight()) + ImmersionBar.getStatusBarHeight(this);
            } else {
                w5 a2 = w5.a(View.inflate(this, R.layout.reading_dir_item, null));
                a2.f12900e.measure(0, 0);
                this.f0.f12890e.measure(0, 0);
                int measuredHeight = a2.f12900e.getMeasuredHeight() * count;
                this.f0.m.getLayoutParams().height = measuredHeight;
                b2 = com.martian.libmars.d.h.b(1.0f) + measuredHeight + this.f0.f12890e.getMeasuredHeight();
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).height = b2;
        }
        ThemeTextView themeTextView = this.f0.f12887b;
        StringBuilder sb = new StringBuilder();
        sb.append(getString(R.string.open_dir));
        if (p.getCount() > 0) {
            str = " · " + p.getCount() + "章";
        } else {
            str = "";
        }
        sb.append(str);
        themeTextView.setText(sb.toString());
        v4();
    }

    private void k4() {
        com.martian.mibook.lib.model.g.b.y(this, "全部评论");
        WholeCommentActivity.r2(this, this.W);
    }

    public void l3(LinearLayout moduleView, LinearLayout bookLinearLayout, List<TYBookItem> tyBookItems) {
        if (com.martian.libmars.utils.n0.c(this)) {
            return;
        }
        int i2 = 8;
        if (bookLinearLayout == null || tyBookItems == null || tyBookItems.isEmpty()) {
            if (bookLinearLayout != null && bookLinearLayout.getChildCount() > 0) {
                i2 = 0;
            }
            moduleView.setVisibility(i2);
            return;
        }
        moduleView.setVisibility(0);
        bookLinearLayout.removeAllViews();
        View inflate = View.inflate(this, R.layout.bs_book_store_item_grid, null);
        inflate.findViewById(R.id.title_view).setVisibility(8);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.grid_item_top_view);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.grid_item_bottom_view);
        linearLayout2.setPadding(0, 0, 0, 0);
        if (tyBookItems.size() > 0) {
            y2.f(this, tyBookItems, linearLayout, false, 0, false);
        }
        if (tyBookItems.size() > 4) {
            y2.f(this, tyBookItems, linearLayout2, false, 4, false);
        }
        bookLinearLayout.addView(inflate);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void m3() {
        h hVar = new h(TYChapterContentParams.class, TYChapterContent.class, this);
        ((TYChapterContentParams) hVar.k()).setSourceName(this.W.o());
        ((TYChapterContentParams) hVar.k()).setSourceId(this.W.n());
        hVar.j();
    }

    public void m4() {
        o oVar = this.W;
        if (oVar == null || com.martian.libsupport.k.p(oVar.c()) || com.martian.libsupport.k.p(this.W.a())) {
            return;
        }
        MiConfigSingleton.V3().l3().w2(this.W.o(), this.W.n(), new b());
    }

    public void n4(List<TYBookItem> books, String excludeBookName) {
        Iterator<TYBookItem> it = books.iterator();
        while (it.hasNext()) {
            if (it.next().getBookName() == null) {
                it.remove();
            }
        }
        Collections.sort(books, new Comparator() { // from class: com.martian.mibook.activity.book.e
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int compareTo;
                compareTo = ((TYBookItem) obj).getBookName().compareTo(((TYBookItem) obj2).getBookName());
                return compareTo;
            }
        });
        Iterator<TYBookItem> it2 = books.iterator();
        String str = "";
        while (it2.hasNext()) {
            String bookName = it2.next().getBookName();
            if (bookName.equals(excludeBookName)) {
                it2.remove();
            } else if (bookName.equals(str)) {
                it2.remove();
            } else {
                str = bookName;
            }
        }
    }

    public void o3(com.martian.mibook.lib.model.c.g source) {
        MiConfigSingleton.V3().l3().m(source, new g());
    }

    public void o4(MiBookCommentItemList miBookCommentItemList) {
        if (com.martian.libmars.utils.n0.c(this)) {
            return;
        }
        if (miBookCommentItemList == null) {
            t4();
            return;
        }
        this.W.G(miBookCommentItemList.getScore());
        this.W.y(miBookCommentItemList.getNComments());
        this.W.z(miBookCommentItemList.getNStars());
        this.W.v(Integer.valueOf(miBookCommentItemList.getClickCount()));
        this.W.D(miBookCommentItemList.getReadingCount());
        if (this.W.m() > 0.0f) {
            this.S.d0.setText(String.format(Locale.CHINA, "%.1f", Float.valueOf(this.W.m())));
            this.S.d0.setPadding(0, 0, com.martian.libmars.d.h.b(4.0f), 0);
            this.S.c0.setText(getString(R.string.grade));
        } else {
            this.S.d0.setText("");
            this.S.d0.setPadding(0, 0, 0, 0);
            this.S.c0.setText(getString(R.string.empty_grade));
        }
        l4(this.W.m());
        this.S.v.setText(w4(this.W.d().intValue(), this.S.w, ""));
        this.S.t.setText(w4(this.W.j().intValue(), this.S.u, "人"));
        List<Comment> commentList = miBookCommentItemList.getCommentList();
        if (commentList != null && commentList.size() > 0) {
            this.j0.clear();
            this.j0.addAll(commentList);
            Iterator<Comment> it = commentList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Comment next = it.next();
                if (MiConfigSingleton.V3().w3().equalsIgnoreCase(next.getCuid())) {
                    this.W.x(next);
                    break;
                }
            }
        }
        t4();
    }

    private void q3() {
        MiConfigSingleton.V3().l3().X1(this.Z.getBookName(), MiBookManager.n, 0, this.W.o(), this.W.n(), new f());
    }

    @SuppressLint({"SetTextI18n"})
    private void q4(int bookRankNumber, String bookRankName) {
        if (MiConfigSingleton.V3().F0()) {
            this.S.K.setVisibility(8);
            return;
        }
        this.S.K.setVisibility(0);
        if (bookRankNumber >= 100) {
            this.S.P.setVisibility(8);
            this.S.M.setImageResource(R.drawable.icon_book_rank_2);
            this.S.N.setColorFilter(ContextCompat.getColor(this, R.color.white));
            this.S.O.setTextColor(ContextCompat.getColor(this, R.color.white));
            this.S.L.setBackgroundResource(R.drawable.bg_book_rank_default);
        } else {
            this.S.P.setVisibility(0);
            this.S.P.setText(String.valueOf(bookRankNumber));
            this.S.M.setImageResource(R.drawable.icon_book_rank);
            this.S.N.setColorFilter(Color.parseColor("#D40100"));
            this.S.O.setTextColor(Color.parseColor("#D40100"));
            this.S.L.setBackgroundResource(R.drawable.bg_book_rank);
        }
        this.S.O.setText(bookRankName + "第" + bookRankNumber + "名");
    }

    private void r3() {
        if (com.martian.libsupport.k.p(this.W.c()) || com.martian.libmars.d.h.F().F0() || MiConfigSingleton.V3().T5()) {
            com.martian.mibook.e.h hVar = this.S;
            l3(hVar.U, hVar.R, null);
            return;
        }
        if (this.a0 == null) {
            MiBookManager.m0 m0Var = new MiBookManager.m0();
            this.a0 = m0Var;
            m0Var.l(0);
            this.a0.n(3);
            this.a0.o(new Random().nextInt(10000));
            this.a0.q(this.W.o());
            this.a0.p(this.W.n());
            this.a0.j(this.W.c());
        }
        MiConfigSingleton.V3().l3().T1(this.a0, new k());
    }

    private void r4(ImageView imageView, float score, float gradeOne, float gradeTwo) {
        if (score < 0.0f) {
            imageView.setImageResource(R.drawable.vote_star_grey);
            return;
        }
        if (score <= gradeOne) {
            imageView.setImageResource(R.drawable.vote_star_grey);
        } else if (score <= gradeTwo) {
            imageView.setImageResource(R.drawable.vote_star_half);
        } else {
            imageView.setImageResource(R.drawable.vote_star_red);
        }
    }

    private void s3(Bundle savedInstanceState) {
        String string = savedInstanceState != null ? savedInstanceState.getString(Q) : G0(Q);
        if (!com.martian.libsupport.k.p(string)) {
            this.W = (o) GsonUtils.b().fromJson(string, o.class);
        }
        if (this.W == null) {
            this.W = new o();
        }
        z3(getIntent());
        if (com.martian.libsupport.k.p(this.W.b())) {
            u3();
            return;
        }
        s2();
        o2(0.0f);
        this.Z = MiConfigSingleton.V3().l3().Q(this.W.b());
        if (!com.martian.libsupport.k.p(this.W.o()) && !com.martian.libsupport.k.p(this.W.n())) {
            this.X = new Source(this.W.o(), this.W.n());
        }
        if (this.Z == null) {
            MiBook miBook = new MiBook();
            this.Z = miBook;
            miBook.setBookName(this.W.c());
            this.Z.setBookId(this.W.b());
            MiConfigSingleton.V3().l3().T0(this.Z);
        }
        initView();
    }

    private void s4() {
        MiReadingRecord V;
        if (this.i0 == null || (V = MiConfigSingleton.V3().l3().V(this.Y)) == null || V.getChapterIndex() == this.i0.h()) {
            return;
        }
        this.i0.p(V.getChapterIndex());
        this.f0.m.setSelection(this.i0.i(V.getChapterIndex()));
    }

    public void t3(final TYChapterContent tyChapterContent) {
        if (com.martian.libsupport.k.p(tyChapterContent.getContent()) || com.martian.libmars.utils.n0.c(this)) {
            return;
        }
        this.S.l0.setVisibility(0);
        String chapterTitle = tyChapterContent.getChapterTitle();
        ThemeTextView themeTextView = this.S.k0;
        if (com.martian.libsupport.k.p(chapterTitle)) {
            chapterTitle = "快速阅读";
        }
        themeTextView.setText(chapterTitle);
        this.S.g0.setText(tyChapterContent.getContent());
        this.S.j0.setText(getString(R.string.book_read_chapter_first));
        this.S.i0.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.book.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookInfoActivity.this.C3(view);
            }
        });
    }

    @SuppressLint({"SetTextI18n"})
    private void t4() {
        if (!MiConfigSingleton.V3().D8()) {
            this.S.I.setVisibility(8);
            this.S.H.setVisibility(8);
            return;
        }
        if (this.j0.size() <= 0) {
            this.S.n.setVisibility(8);
            this.S.o.setVisibility(8);
            this.S.I.setVisibility(0);
            this.S.H.setVisibility(0);
            SpannableString spannableString = new SpannableString(getString(R.string.reader_comment_empty));
            spannableString.setSpan(new c(), 11, 14, 17);
            this.S.p.setMovementMethod(LinkMovementMethod.getInstance());
            this.S.p.setText(spannableString);
            return;
        }
        this.S.n.setVisibility(0);
        this.S.o.setVisibility(0);
        this.S.I.setVisibility(8);
        this.S.H.setVisibility(8);
        this.S.s0.setText(" " + this.W.f() + "条评论");
        ArrayList arrayList = new ArrayList();
        if (this.j0.size() > 3) {
            for (int i2 = 0; i2 < 3; i2 = i2 + 1 + 1) {
                arrayList.add(this.j0.get(i2));
            }
        } else {
            arrayList.addAll(this.j0);
        }
        y3 y3Var = this.k0;
        if (y3Var != null) {
            y3Var.a(arrayList);
            return;
        }
        this.k0 = new y3(this, arrayList, true);
        this.S.m0.setLayoutManager(new LinearLayoutManager(this));
        this.S.m0.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        this.S.m0.setAdapter(this.k0);
    }

    public void u3() {
        k1("获取书籍信息失败");
        finish();
    }

    private void u4() {
        this.S.x.setBackgroundResource(MiConfigSingleton.V3().I0() ? R.drawable.book_intro_shade_night : R.drawable.book_intro_shade_day);
    }

    public void v3(boolean manual) {
        List<TYBookItem> list = this.d0;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.o0 = true;
        int i2 = 0;
        for (TYBookItem tYBookItem : this.d0) {
            if (i2 >= 8) {
                return;
            }
            i2++;
            if (i2 == 1) {
                if (manual) {
                    com.martian.mibook.lib.model.g.b.y(this, tYBookItem.getRecommend() + "-换一批");
                } else {
                    com.martian.mibook.lib.model.g.b.y(this, tYBookItem.getRecommend() + "-展示");
                }
            }
            MiConfigSingleton.V3().l3().I1(0, tYBookItem.getSourceName(), tYBookItem.getSourceId(), tYBookItem.getRecommendId(), "", "展示");
        }
    }

    private void v4() {
        h4 h4Var = this.i0;
        if (h4Var != null) {
            if (h4Var.n()) {
                this.f0.f12893h.setText(getString(R.string.sequence_positive));
                this.f0.f12891f.setImageResource(R.drawable.reader_icon_order_up);
            } else {
                this.f0.f12893h.setText(getString(R.string.sequence_negative));
                this.f0.f12891f.setImageResource(R.drawable.reader_icon_order_down);
            }
        }
    }

    private int w3() {
        Book book = this.Y;
        if (book instanceof YWBook) {
            return ((YWBook) book).getFreeType();
        }
        if (!(book instanceof TFBook)) {
            return MiConfigSingleton.V3().k();
        }
        try {
            return Integer.parseInt(((TFBook) book).getFreeType());
        } catch (Exception unused) {
            return MiConfigSingleton.V3().k();
        }
    }

    public static String w4(int numbers, TextView view, String unit) {
        String str = "";
        if (numbers <= 0) {
            view.setText("");
            return "--";
        }
        if (numbers < 10000) {
            view.setText(unit);
            return numbers + "";
        }
        view.setText("万" + unit);
        int i2 = numbers / 10000;
        int i3 = (numbers - (i2 * 10000)) / 1000;
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        if (i3 > 0) {
            str = "." + i3;
        }
        sb.append(str);
        return sb.toString();
    }

    private List<String> x3() {
        Book book = this.Y;
        if (book instanceof TFBook) {
            TFBook tFBook = (TFBook) book;
            if (tFBook.getTagList() != null && !tFBook.getTagList().isEmpty()) {
                return tFBook.getTagList();
            }
        } else if (book instanceof YWBook) {
            YWBook yWBook = (YWBook) book;
            if (yWBook.getTagList() != null && !yWBook.getTagList().isEmpty()) {
                return yWBook.getTagList();
            }
        }
        return (this.W.q() == null || this.W.q().isEmpty()) ? new ArrayList() : this.W.q();
    }

    private void y3() {
        List<TYBookItem> list;
        List<TYBookItem> list2;
        int i2 = 0;
        if (!this.n0 && this.S.U.getGlobalVisibleRect(new Rect()) && (list2 = this.c0) != null && !list2.isEmpty()) {
            this.n0 = true;
            int i3 = 0;
            for (TYBookItem tYBookItem : this.c0) {
                if (i3 >= 8) {
                    break;
                }
                i3++;
                if (i3 == 1) {
                    com.martian.mibook.lib.model.g.b.y(this, tYBookItem.getRecommend() + "-展示");
                }
                MiConfigSingleton.V3().l3().I1(0, tYBookItem.getSourceName(), tYBookItem.getSourceId(), tYBookItem.getRecommendId(), "", "展示");
            }
        }
        if (!this.o0 && this.S.T.getGlobalVisibleRect(new Rect())) {
            v3(false);
        }
        if (this.p0 || !this.S.f12031g.getGlobalVisibleRect(new Rect()) || (list = this.e0) == null || list.isEmpty()) {
            return;
        }
        this.p0 = true;
        for (TYBookItem tYBookItem2 : this.e0) {
            if (i2 >= 8) {
                return;
            }
            i2++;
            if (i2 == 1) {
                com.martian.mibook.lib.model.g.b.y(this, tYBookItem2.getRecommend() + "-展示");
            }
            MiConfigSingleton.V3().l3().I1(0, tYBookItem2.getSourceName(), tYBookItem2.getSourceId(), tYBookItem2.getRecommendId(), "", "展示");
        }
    }

    private void z3(Intent intent) {
        Uri data;
        if (intent == null || (data = intent.getData()) == null) {
            return;
        }
        String scheme = data.getScheme();
        if (!com.martian.libsupport.k.p(scheme) && getString(R.string.scheme).equalsIgnoreCase(scheme)) {
            this.m0 = true;
            this.W.H(data.getQueryParameter("sourceId")).I(data.getQueryParameter("sourceName")).E(data.getQueryParameter("recommend")).F(data.getQueryParameter("recommendId"));
            if (com.martian.libsupport.k.p(this.W.n()) || com.martian.libsupport.k.p(this.W.o())) {
                return;
            }
            this.W.t(com.martian.mibook.lib.model.manager.d.a(new e()));
        }
    }

    public void A3() {
        if (g2()) {
            if (this.Z == null) {
                u3();
                return;
            }
            Source source = this.X;
            if (source == null) {
                q3();
            } else {
                o3(source);
            }
        }
    }

    @Override // com.martian.libmars.activity.j1
    protected void U1(boolean nightMode) {
        super.U1(nightMode);
        if (this.S.A.getVisibility() == 0) {
            u4();
        }
    }

    @Override // com.martian.libmars.activity.h1, android.app.Activity
    public void finish() {
        if (this.m0) {
            String className = ((ActivityManager) getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningTasks(1).get(0).baseActivity.getClassName();
            if (!com.martian.libsupport.k.p(className) && !className.contains("Homepage")) {
                startActivity(Homepage.class);
                new Handler().postDelayed(new Runnable() { // from class: com.martian.mibook.activity.book.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        BookInfoActivity.this.E3();
                    }
                }, 500L);
                return;
            }
        }
        super.finish();
    }

    public void l4(float score) {
        r4(this.S.X, score, 0.0f, 1.4f);
        r4(this.S.Y, score, 2.4f, 3.4f);
        r4(this.S.Z, score, 4.4f, 5.4f);
        r4(this.S.a0, score, 6.4f, 7.4f);
        r4(this.S.b0, score, 8.4f, 9.4f);
    }

    @Override // com.martian.libmars.activity.k1
    public void n2() {
        A3();
    }

    public void n3(boolean manual) {
        if (com.martian.libsupport.k.p(this.W.c())) {
            com.martian.mibook.e.h hVar = this.S;
            l3(hVar.T, hVar.S, null);
        } else {
            this.S.J.setVisibility(0);
            this.S.C.setVisibility(8);
            MiConfigSingleton.V3().l3().X1(this.W.c(), 7, this.V, this.W.o(), this.W.n(), new l(manual));
        }
    }

    public void onActionMenuClick(View view) {
        h4 h4Var = this.i0;
        if (h4Var != null) {
            h4Var.o();
            v4();
        }
    }

    @Override // com.martian.libmars.activity.h1, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, final Intent data) {
        Book book;
        MiBook miBook;
        if (requestCode == 203) {
            if (data == null || (book = this.Y) == null || (miBook = this.Z) == null) {
                return;
            } else {
                s2.g0(this, miBook, book, Integer.valueOf(data.getIntExtra(MiConfigSingleton.M0, 0)), 0, 0, false);
            }
        } else if (requestCode == 200) {
            new Handler().post(new Runnable() { // from class: com.martian.mibook.activity.book.k
                @Override // java.lang.Runnable
                public final void run() {
                    BookInfoActivity.this.M3(data);
                }
            });
            if (resultCode == 205) {
                m4();
            }
        } else if (requestCode == 1001) {
            new Handler().post(new Runnable() { // from class: com.martian.mibook.activity.book.q
                @Override // java.lang.Runnable
                public final void run() {
                    BookInfoActivity.this.O3();
                }
            });
        } else if (requestCode == 777 && resultCode == -1) {
            m4();
        } else if (requestCode == 1004 && resultCode == -1) {
            com.martian.mibook.lib.model.g.b.K(this, MiConfigSingleton.V3().T3("登录成功", 1004));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void onAddBookRackClick(View view) {
        if (this.Z == null || this.Y == null) {
            k1("书籍加载中，请稍后");
            return;
        }
        com.martian.mibook.lib.model.g.b.y(this, "加入书架");
        if (MiConfigSingleton.V3().l3().v0(this.Z)) {
            k1("已在书架中！");
        } else {
            MiConfigSingleton.V3().l3().d(this, this.Z, this.Y);
            k1("已添加到书架！");
            MiConfigSingleton.V3().l3().I1(3, this.Y.getSourceName(), this.Y.getSourceId(), this.W.l(), this.W.k(), "详情加书架");
        }
        p4();
    }

    public void onAuthorBooksClick(View view) {
        if (this.Y == null) {
            k1("书籍加载中，请稍后");
            return;
        }
        com.martian.mibook.lib.model.g.b.y(this, "同作者作品-查看全部");
        Book book = this.Y;
        MiBookManager.m0 m0Var = this.a0;
        AuthorBooksActivity.s2(this, book, AuthorBooksActivity.G, m0Var == null ? 0 : m0Var.e());
    }

    public void onCategoryClick(View view) {
        if (com.martian.libmars.d.h.F().F0()) {
            return;
        }
        Book book = this.Y;
        if (book == null) {
            k1("书籍加载中，请稍后");
            return;
        }
        if (book instanceof YWBook) {
            YWBook yWBook = (YWBook) book;
            YWCategory yWCategory = new YWCategory();
            yWCategory.setCategoryId(Integer.valueOf(yWBook.getCategoryId()));
            yWCategory.setCategoryName(yWBook.getCategoryName());
            com.martian.mibook.lib.model.g.b.y(this, "分类-" + yWBook.getSubCategoryName());
            YWCategoriesActivity.r2(this, yWCategory, yWBook.getFreeType(), yWBook.getSubCategoryId(), g0.t);
            return;
        }
        if (book instanceof TFBook) {
            TFBook tFBook = (TFBook) book;
            YWCategory yWCategory2 = new YWCategory();
            yWCategory2.setCategoryId(tFBook.getCategoryId());
            yWCategory2.setCategoryName(tFBook.getCategoryName());
            com.martian.mibook.lib.model.g.b.y(this, "分类-" + tFBook.getSubCategoryName());
            int i2 = 1;
            if (!com.martian.libsupport.k.p(tFBook.getFreeType())) {
                try {
                    i2 = Integer.parseInt(tFBook.getFreeType());
                } catch (Exception unused) {
                }
            }
            YWCategoriesActivity.r2(this, yWCategory2, i2, tFBook.getSubCategoryId() == null ? 0 : tFBook.getSubCategoryId().intValue(), g0.t);
        }
    }

    public void onChapterListClick(View view) {
        com.martian.mibook.lib.model.g.b.y(this, "目录");
        if (this.h0 != null) {
            s4();
            this.g0.T(3);
            this.h0.show();
        } else if (this.Y == null) {
            k1("书籍加载中，请稍候");
        } else {
            if (this.S.n0.getVisibility() == 0) {
                return;
            }
            this.S.n0.setVisibility(0);
            MiConfigSingleton.V3().l3().o(this.Y, false, true, new i());
        }
    }

    @Override // com.martian.mibook.activity.base.n, com.martian.libmars.activity.k1, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_info);
        this.S = com.martian.mibook.e.h.a(h2());
        z2();
        overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
        if (com.martian.libmars.d.h.F().F0() || MiConfigSingleton.V3().T5()) {
            this.S.f12029e.setVisibility(8);
        } else {
            v2(R.drawable.menu_icon_more);
        }
        s3(savedInstanceState);
        com.martian.mibook.lib.model.g.b.y(this, "书籍详情-展示");
    }

    public void onDirCloseClick(View view) {
        BottomSheetDialog bottomSheetDialog = this.h0;
        if (bottomSheetDialog != null) {
            bottomSheetDialog.dismiss();
        }
    }

    public void onMenuIconClick(View view) {
        v2.X0(this, findViewById(R.id.actionbar_action_icon), this.Y, null, null);
    }

    public void onMyCommentClick(View view) {
        com.martian.mibook.lib.model.g.b.y(this, "发表评论");
        v2.a1(this, this.W, 100, this.l0, new d());
    }

    public void onNewBookClick(View view) {
        com.martian.mibook.lib.model.g.b.y(this, "最近上新");
        YWBookListActivity.u2(this, MiConfigSingleton.V3().k(), 203, 0);
    }

    public void onRankClick(View view) {
        if (this.Y == null) {
            k1("书籍加载中，请稍后");
            return;
        }
        com.martian.mibook.lib.model.g.b.y(this, "榜单");
        if (this.W.i() != null) {
            i0();
            return;
        }
        Book book = this.Y;
        if (book instanceof YWBook) {
            YWBook yWBook = (YWBook) book;
            BookRankActivity.w2(this, yWBook.getFreeType(), new BookRankActivity.a().j(yWBook.getBrType()).m(yWBook.getCategoryId()).r("书籍详情-"));
        } else if (book instanceof TFBook) {
            TFBook tFBook = (TFBook) book;
            BookRankActivity.w2(this, Integer.parseInt(tFBook.getFreeType()), new BookRankActivity.a().j(tFBook.getBrType()).m(tFBook.getCategoryId().intValue()).r("书籍详情-"));
        }
    }

    public void onReadingClick(View view) {
        com.martian.mibook.lib.model.g.b.y(this, "点击阅读");
        TYBookItem tYBookItem = new TYBookItem();
        tYBookItem.convertYwBookItem(this.Y);
        tYBookItem.setContext(this.W.getContext());
        tYBookItem.setRecommend(this.W.k());
        tYBookItem.setRecommendId(this.W.l());
        tYBookItem.setScore(Integer.valueOf((int) (this.W.m() * 10.0f)));
        tYBookItem.setClickCount(this.W.d());
        tYBookItem.setReadingCount(this.W.j());
        tYBookItem.setnComments(Integer.valueOf(this.W.f()));
        s2.f0(this, this.Z, tYBookItem);
    }

    @Override // com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        p4();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (this.W != null) {
            outState.putString(Q, GsonUtils.b().toJson(this.W));
        }
    }

    public void onWholeCommentClick(View view) {
        k4();
    }

    public void p3(final String author, final String excludeBookName) {
        if (!MiConfigSingleton.V3().F0()) {
            MiConfigSingleton.V3().l3().U1(author, 0, new m(excludeBookName), this.W.o(), this.W.n());
        } else {
            com.martian.mibook.e.h hVar = this.S;
            l3(hVar.f12031g, hVar.f12032h, null);
        }
    }

    public void p4() {
        if (MiConfigSingleton.V3().l3().v0(this.Z)) {
            this.S.f12028d.setText(getString(R.string.already_in_bookrack));
            this.S.f12028d.setTextColor(MiConfigSingleton.V3().s0());
        } else {
            this.S.f12028d.setText(getString(R.string.add_bookstore));
            this.S.f12028d.setTextColor(ContextCompat.getColor(this, R.color.theme_default));
        }
    }

    public void setBottomSheetCallback(View sheetView) {
        BottomSheetBehavior<View> s = BottomSheetBehavior.s(sheetView);
        this.g0 = s;
        s.T(3);
        this.g0.i(new a());
    }
}
