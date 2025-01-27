package com.martian.mibook.application;

import android.app.Activity;
import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.collection.ArraySet;
import com.google.gson.JsonSyntaxException;
import com.martian.ads.ad.AdConfig;
import com.martian.apptask.data.AppTask;
import com.martian.free.response.TFBook;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.activity.j1;
import com.martian.libmars.comm.request.MTJsonPostParams;
import com.martian.libmars.utils.k0;
import com.martian.mibook.account.request.book.MiBookGetCommentByScoreParams;
import com.martian.mibook.account.request.book.MiBookGetCommentByTimeParams;
import com.martian.mibook.account.request.book.MiBookPostCommentParams;
import com.martian.mibook.account.request.book.MiBookReplyCommentParams;
import com.martian.mibook.account.request.book.MiBookTopCommentParams;
import com.martian.mibook.account.request.book.MiBookVoteCommentParams;
import com.martian.mibook.data.ReadingHint;
import com.martian.mibook.data.book.Comment;
import com.martian.mibook.data.book.CommentReply;
import com.martian.mibook.data.book.ContentProperty;
import com.martian.mibook.data.book.MiBookCommentItemList;
import com.martian.mibook.data.book.MiBookGetCommentByScoreItemList;
import com.martian.mibook.data.book.MiBookGetCommentByTimeItemList;
import com.martian.mibook.data.book.ReadingInfo;
import com.martian.mibook.data.book.VoteResult;
import com.martian.mibook.j.s2;
import com.martian.mibook.j.v2;
import com.martian.mibook.lib.account.request.BookAdsParams;
import com.martian.mibook.lib.account.request.BookEventRequest;
import com.martian.mibook.lib.account.request.ReaderBookParams;
import com.martian.mibook.lib.account.request.ReadingRecordsParams;
import com.martian.mibook.lib.account.response.BookAdsInfo;
import com.martian.mibook.lib.account.response.BookEvent;
import com.martian.mibook.lib.local.base.data.LocalBook;
import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.lib.model.data.MiBook;
import com.martian.mibook.lib.model.data.MiBookStoreItem;
import com.martian.mibook.lib.model.data.MiChapterList;
import com.martian.mibook.lib.model.data.MiReadingContent;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import com.martian.mibook.lib.model.data.MiReadingRecordList;
import com.martian.mibook.lib.model.data.PageInfo;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.model.data.TYSearchBookList;
import com.martian.mibook.lib.model.data.TextInfo;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import com.martian.mibook.lib.model.manager.BookManager;
import com.martian.mibook.lib.original.data.ORBook;
import com.martian.mibook.lib.yuewen.request.AdRecommendBooksParams;
import com.martian.mibook.lib.yuewen.request.RecommendBooksParams;
import com.martian.mibook.lib.yuewen.request.YWCategoryBookListParams;
import com.martian.mibook.lib.yuewen.response.TYInitialBook;
import com.martian.mibook.lib.yuewen.response.TYInitialBookList;
import com.martian.mibook.lib.yuewen.response.TYTag;
import com.martian.mibook.lib.yuewen.response.TYTagAlias;
import com.martian.mibook.lib.yuewen.response.YWBook;
import com.martian.mibook.lib.yuewen.response.YWBookMall;
import com.martian.mibook.lib.yuewen.response.YWCategory;
import com.martian.mibook.lib.yuewen.response.YWCategoryBookList;
import com.martian.mibook.lib.yuewen.response.YWChannelBookList;
import com.martian.mibook.lib.yuewen.response.YWFreeType;
import com.martian.mibook.lib.yuewen.response.YWFreeTypeList;
import com.martian.mibook.ui.o.u3;
import com.martian.rpauth.MartianRPUserManager;
import com.martian.ttbookhd.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/* loaded from: classes.dex */
public class MiBookManager extends BookManager {
    private static final String A = "male_book_mall_json_file";
    private static final String B = "female_book_mall_json_file";
    public static final String C = "bookEvents.json";
    public static final int D = 0;
    public static final int E = 1;
    public static final int F = 2;
    public static final int G = 3;
    public static final int H = 4;
    public static int I = 5;
    public static final int J = 6;
    public static int K = 7;
    public static final String L = "sourceStrings.json";
    public static final String M = "alertSourceStrings.json";
    public static int n = 0;
    public static int o = 1;
    public static final int p = 2;
    public static final int q = 3;
    public static int r = 4;
    public static int s = 5;
    public static final int t = 6;
    public static final int u = 7;
    public static final int v = 8;
    private static final String w = "initial_book_json_file";
    private static final String x = "unexposed_books_json_file";
    private static final String y = "unpromoted_books_json_file";
    private static final String z = "book_freetypes_json_file";
    private final com.martian.mibook.lib.local.b.a N;
    private final Context O;
    private boolean P;
    private Map<String, TYInitialBook> Q;
    private Map<String, TYInitialBook> R;
    private boolean S;
    private List<TYInitialBook> T;
    private boolean U;
    private boolean V;
    private List<YWFreeType> W;
    private List<TYTagAlias> X;
    private YWBookMall Y;
    private YWBookMall Z;
    private List<BookEvent> a0;
    private Set<String> b0;
    private Set<String> c0;
    private long d0;
    private List<ReadingHint> e0;
    private ReadingHint f0;
    private int g0;
    private final Map<String, BookAdsInfo> h0;
    private final List<AppTask> i0;
    private int j0;
    private boolean k0;
    private Book l0;

    /* loaded from: classes3.dex */
    class a extends com.martian.mibook.account.k.a.f {

        /* renamed from: j */
        final /* synthetic */ l0 f11253j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(j1 activity, final l0 val$listener) {
            super(activity);
            this.f11253j = val$listener;
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            MiBookManager.this.P = false;
            this.f11253j.a(errorResult);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        /* renamed from: t */
        public void onDataReceived(VoteResult voteResult) {
            MiBookManager.this.P = false;
            if (voteResult != null) {
                this.f11253j.b(voteResult);
            } else {
                this.f11253j.a(new b.d.c.b.c(-1, "通信失败"));
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface a0 {
        void a(String errMsg);

        void b(BookWrapper item);
    }

    /* loaded from: classes3.dex */
    class b extends com.google.gson.b.a<Map<String, TYInitialBook>> {
        b() {
        }
    }

    /* loaded from: classes3.dex */
    public interface b0 {
        void a(b.d.c.b.c errorResult);

        void b(MiBookGetCommentByScoreItemList miBookGetCommentByScoreItemList);

        void onLoading(boolean show);
    }

    /* loaded from: classes3.dex */
    class c extends com.google.gson.b.a<Map<String, TYInitialBook>> {
        c() {
        }
    }

    /* loaded from: classes3.dex */
    public interface c0 {
        void a(b.d.c.b.c errorResult);

        void b(MiBookGetCommentByTimeItemList miBookGetCommentByScoreItemList);

        void onLoading(boolean show);
    }

    /* loaded from: classes3.dex */
    class d extends com.google.gson.b.a<List<TYInitialBook>> {
        d() {
        }
    }

    /* loaded from: classes3.dex */
    public interface d0 {
        void a(b.d.c.b.c errorResult);

        void b(Comment comment);

        void onLoading(boolean show);
    }

    /* loaded from: classes3.dex */
    class e extends com.martian.mibook.lib.yuewen.e.b {

        /* renamed from: h */
        final /* synthetic */ z f11257h;

        /* renamed from: i */
        final /* synthetic */ int f11258i;

        e(final z val$ctype, final int val$listener) {
            this.f11257h = val$ctype;
            this.f11258i = val$listener;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            this.f11257h.b();
        }

        @Override // b.d.c.c.b
        /* renamed from: q */
        public void onDataReceived(YWFreeTypeList freeTypeList) {
            if (freeTypeList == null || freeTypeList.getFreeTypeList() == null || freeTypeList.getFreeTypeList().size() <= 0) {
                this.f11257h.b();
                return;
            }
            MiBookManager.this.W = freeTypeList.getFreeTypeList();
            MiBookManager.this.X = freeTypeList.getTyTagList();
            MiConfigSingleton.V3().l3().h3(MiBookManager.this.W);
            if (this.f11258i == 1) {
                this.f11257h.a(freeTypeList.getFreeTypeList().get(0));
            } else if (freeTypeList.getFreeTypeList().size() > 1) {
                this.f11257h.a(freeTypeList.getFreeTypeList().get(1));
            } else {
                this.f11257h.b();
            }
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    /* loaded from: classes3.dex */
    public interface e0 {
        void a();
    }

    /* loaded from: classes3.dex */
    class f implements z {

        /* renamed from: a */
        final /* synthetic */ String f11260a;

        /* renamed from: b */
        final /* synthetic */ n0 f11261b;

        f(final String val$listener, final n0 val$keyword) {
            this.f11260a = val$listener;
            this.f11261b = val$keyword;
        }

        @Override // com.martian.mibook.application.MiBookManager.z
        public void a(YWFreeType ywFreeType) {
            MiBookManager.this.f2(this.f11260a, this.f11261b);
        }

        @Override // com.martian.mibook.application.MiBookManager.z
        public void b() {
            this.f11261b.b();
        }
    }

    /* loaded from: classes3.dex */
    public interface f0 {
        void a(b.d.c.b.c errorResult);

        void b(Comment comment);

        void onLoading(boolean show);
    }

    /* loaded from: classes3.dex */
    class g extends com.martian.mibook.lib.yuewen.e.g {

        /* renamed from: h */
        final /* synthetic */ n0 f11263h;

        /* renamed from: i */
        final /* synthetic */ YWCategory f11264i;

        /* renamed from: j */
        final /* synthetic */ int f11265j;
        final /* synthetic */ String k;

        g(final n0 val$keyword, final YWCategory val$ywFreeType, final int val$ywCategory, final String val$listener) {
            this.f11263h = val$keyword;
            this.f11264i = val$ywFreeType;
            this.f11265j = val$ywCategory;
            this.k = val$listener;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            this.f11263h.b();
        }

        @Override // b.d.c.c.b
        /* renamed from: q */
        public void onDataReceived(YWCategoryBookList ywCategoryBookList) {
            if (ywCategoryBookList != null) {
                this.f11263h.a(ywCategoryBookList.getBookList(), this.f11264i, this.f11265j, this.k);
            } else {
                this.f11263h.b();
            }
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    /* loaded from: classes3.dex */
    public interface g0 {
        void a(b.d.c.b.c errorResult);

        void b(ReadingInfo readingInfo);

        void onLoading(boolean show);
    }

    /* loaded from: classes3.dex */
    class h extends com.google.gson.b.a<List<YWFreeType>> {
        h() {
        }
    }

    /* loaded from: classes3.dex */
    public interface h0 {
        void a();
    }

    /* loaded from: classes3.dex */
    class i extends com.martian.libmars.c.c<Integer> {
        i(Class x0, Context x1) {
            super(x0, x1);
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            MiBookManager.this.p3();
        }

        @Override // b.d.c.c.i, b.d.c.c.c
        public void onUDDataReceived(List<Integer> times) {
            MiConfigSingleton.V3().t8(true);
            MiBookManager.this.a3();
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    /* loaded from: classes3.dex */
    public interface i0 {
        void a(b.d.c.b.c errorResult);

        void b(CommentReply commentReply);

        void onLoading(boolean show);
    }

    /* loaded from: classes3.dex */
    class j extends com.google.gson.b.a<List<BookEvent>> {
        j() {
        }
    }

    /* loaded from: classes3.dex */
    public interface j0 {
        void a(b.d.c.b.c errorResult);

        void b(MiBookCommentItemList miBookCommentItemList);

        void onLoading(boolean show);
    }

    /* loaded from: classes3.dex */
    class k extends com.martian.mibook.lib.account.d.g<RecommendBooksParams, TYSearchBookList> {

        /* renamed from: g */
        final /* synthetic */ com.martian.mibook.lib.model.d.h f11269g;

        /* renamed from: h */
        final /* synthetic */ m0 f11270h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(Class x0, Class x1, Context x2, final com.martian.mibook.lib.model.d.h val$searchInfo, final m0 val$receiver) {
            super(x0, x1, x2);
            this.f11269g = val$searchInfo;
            this.f11270h = val$receiver;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            this.f11269g.d(errorResult);
        }

        @Override // b.d.c.c.i, b.d.c.c.c
        public void onUDDataReceived(List<TYSearchBookList> tySearchBookLists) {
            if (tySearchBookLists == null || tySearchBookLists.isEmpty()) {
                this.f11269g.d(new b.d.c.b.c(-1, "数据为空"));
            } else {
                this.f11269g.c(tySearchBookLists.get(0).getBookItemList());
            }
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean loading) {
            this.f11270h.k(loading);
            this.f11269g.a(loading);
        }
    }

    /* loaded from: classes3.dex */
    public interface k0 {
        void a(b.d.c.b.c errorResult);

        void b(Comment comment);

        void onLoading(boolean show);
    }

    /* loaded from: classes3.dex */
    class l extends com.martian.mibook.lib.account.d.q.d0<ReadingRecordsParams, YWChannelBookList> {

        /* renamed from: i */
        final /* synthetic */ h0 f11272i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(Class x0, Class x1, Activity x2, final h0 val$listener) {
            super(x0, x1, x2);
            this.f11272i = val$listener;
        }

        @Override // com.martian.mibook.lib.account.d.q.d0, b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            this.f11272i.a();
        }

        @Override // b.d.c.c.i, b.d.c.c.c
        public void onUDDataReceived(List<YWChannelBookList> tyBookItemList) {
            MiConfigSingleton.V3().v1(com.martian.mibook.lib.account.e.c.f13919a, false);
            if (tyBookItemList == null || tyBookItemList.isEmpty()) {
                this.f11272i.a();
            } else {
                MiBookManager.this.T2(tyBookItemList.get(0).getBookList());
                this.f11272i.a();
            }
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    /* loaded from: classes3.dex */
    public interface l0 {
        void a(b.d.c.b.c errorResult);

        void b(VoteResult voteResult);
    }

    /* loaded from: classes3.dex */
    class m extends com.google.gson.b.a<Set<String>> {
        m() {
        }
    }

    /* loaded from: classes3.dex */
    public static class m0 {

        /* renamed from: a */
        private int f11275a;

        /* renamed from: b */
        private int f11276b;

        /* renamed from: c */
        private int f11277c = 10;

        /* renamed from: d */
        private int f11278d;

        /* renamed from: e */
        private String f11279e;

        /* renamed from: f */
        private String f11280f;

        /* renamed from: g */
        private String f11281g;

        /* renamed from: h */
        private boolean f11282h;

        public String a() {
            return this.f11281g;
        }

        public int b() {
            return this.f11276b;
        }

        public int c() {
            return this.f11277c;
        }

        public int d() {
            return this.f11275a;
        }

        public int e() {
            return this.f11278d;
        }

        public String f() {
            return this.f11280f;
        }

        public String g() {
            return this.f11279e;
        }

        public void h() {
            this.f11276b++;
        }

        public boolean i() {
            return this.f11282h;
        }

        public void j(String bookName) {
            this.f11281g = bookName;
        }

        public void k(boolean loading) {
            this.f11282h = loading;
        }

        public void l(int pageIndex) {
            this.f11276b = pageIndex;
        }

        public void m(int pageSize) {
            this.f11277c = pageSize;
        }

        public void n(int searchType) {
            this.f11275a = searchType;
        }

        public void o(int seed) {
            this.f11278d = seed;
        }

        public void p(String sourceId) {
            this.f11280f = sourceId;
        }

        public void q(String sourceName) {
            this.f11279e = sourceName;
        }
    }

    /* loaded from: classes3.dex */
    class n extends com.google.gson.b.a<Set<String>> {
        n() {
        }
    }

    /* loaded from: classes3.dex */
    public interface n0 {
        void a(List<TYBookItem> tyBookItems, YWCategory ywCategory, int freeType, String finalKeyword);

        void b();
    }

    /* loaded from: classes3.dex */
    class o extends com.martian.mibook.lib.account.d.g<BookAdsParams, BookAdsInfo> {

        /* renamed from: g */
        final /* synthetic */ Book f11284g;

        /* renamed from: h */
        final /* synthetic */ y f11285h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o(Class x0, Class x1, Context x2, final Book val$listener, final y val$book) {
            super(x0, x1, x2);
            this.f11284g = val$listener;
            this.f11285h = val$book;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
        }

        @Override // b.d.c.c.i, b.d.c.c.c
        public void onUDDataReceived(List<BookAdsInfo> bookAdsInfos) {
            if (bookAdsInfos == null || bookAdsInfos.isEmpty()) {
                return;
            }
            BookAdsInfo bookAdsInfo = bookAdsInfos.get(0);
            MiBookManager.this.h0.put(this.f11284g.getSourceString(), bookAdsInfo);
            this.f11285h.a(bookAdsInfo);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    /* loaded from: classes3.dex */
    class p extends com.martian.mibook.lib.account.d.g<AdRecommendBooksParams, TYSearchBookList> {
        p(Class x0, Class x1, Context x2) {
            super(x0, x1, x2);
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            MiBookManager.this.k0 = false;
        }

        @Override // b.d.c.c.i, b.d.c.c.c
        public void onUDDataReceived(List<TYSearchBookList> tySearchBookLists) {
            MiBookManager.this.k0 = false;
            if (tySearchBookLists == null || tySearchBookLists.isEmpty()) {
                return;
            }
            for (TYBookItem tYBookItem : tySearchBookLists.get(0).getBookItemList()) {
                AppTask appTask = new AppTask();
                appTask.id = "11";
                appTask.source = AdConfig.UnionType.BOOK;
                appTask.adsPosition = "广告推书";
                appTask.adsType = AdConfig.AdType.NATIVE;
                appTask.origin = tYBookItem;
                appTask.desc = tYBookItem.getAuthor();
                appTask.title = tYBookItem.getBookName();
                appTask.iconUrl = tYBookItem.getCoverUrl();
                appTask.posterUrl = tYBookItem.getUrl();
                appTask.appPromote = "好书推荐";
                appTask.adsPosition = com.martian.mibook.b.b.A;
                appTask.setEcpm(tYBookItem.getEcpm());
                appTask.setCoverView(tYBookItem.getCreative() != null);
                MiBookManager.this.i0.add(appTask);
            }
            MiBookManager.F1(MiBookManager.this);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    /* loaded from: classes3.dex */
    class q extends com.martian.mibook.i.b {

        /* renamed from: h */
        final /* synthetic */ com.martian.mibook.lib.model.d.h f11288h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        q(BookManager bookMgr, int page, final com.martian.mibook.lib.model.d.h val$receiver) {
            super(bookMgr, page);
            this.f11288h = val$receiver;
        }

        @Override // com.martian.mibook.g.a, com.martian.mibook.lib.model.d.h
        public void b(List<TYBookItem> books) {
            super.b(books);
            this.f11288h.b(books);
        }

        @Override // com.martian.mibook.g.a
        public void g(b.d.c.b.c errorResult) {
            this.f11288h.d(errorResult);
        }

        @Override // com.martian.mibook.g.a
        public void h(boolean show) {
            this.f11288h.a(show);
        }

        @Override // com.martian.mibook.g.a
        public void i(List<TYBookItem> books) {
            this.f11288h.c(books);
        }

        @Override // com.martian.mibook.g.a
        public List<TYBookItem> j(List<TYBookItem> books) {
            return books;
        }
    }

    /* loaded from: classes3.dex */
    class r implements com.martian.mibook.lib.model.d.b {

        /* renamed from: a */
        final /* synthetic */ a0 f11290a;

        /* renamed from: b */
        final /* synthetic */ Activity f11291b;

        /* renamed from: c */
        final /* synthetic */ boolean f11292c;

        class a extends com.martian.mibook.lib.model.d.f {

            /* renamed from: a */
            final /* synthetic */ BookWrapper f11294a;

            a(final BookWrapper val$item) {
                this.f11294a = val$item;
            }

            @Override // com.martian.mibook.lib.model.d.f
            public void a(boolean loading) {
            }

            @Override // com.martian.mibook.lib.model.d.f
            public void c(ChapterList chapterList) {
                if (chapterList instanceof MiChapterList) {
                    ((MiChapterList) chapterList).getCursor().close();
                }
                this.f11294a.isCaching = false;
            }

            @Override // com.martian.mibook.lib.model.d.f
            public void d(b.d.c.b.c errorResult) {
            }
        }

        r(final a0 val$parseLargeFileChapters, final Activity val$activity, final boolean val$listener) {
            this.f11290a = val$parseLargeFileChapters;
            this.f11291b = val$activity;
            this.f11292c = val$listener;
        }

        @Override // com.martian.mibook.lib.model.d.b
        public void a(Book book) {
            LocalBook localBook = (LocalBook) book;
            MiBook m = r0.m(localBook);
            if (MiConfigSingleton.V3().l3().v0(m)) {
                a0 a0Var = this.f11290a;
                if (a0Var != null) {
                    a0Var.b(MiConfigSingleton.V3().l3().g0(book));
                    return;
                }
                return;
            }
            MiBookManager.this.T0(m);
            BookWrapper d2 = MiBookManager.this.d(this.f11291b, m, localBook);
            if (d2 == null) {
                a0 a0Var2 = this.f11290a;
                if (a0Var2 != null) {
                    a0Var2.a("添加失败");
                    return;
                }
                return;
            }
            a0 a0Var3 = this.f11290a;
            if (a0Var3 != null) {
                a0Var3.b(d2);
            }
            if (localBook.getFileSize().longValue() <= 2097152 || !this.f11292c) {
                return;
            }
            d2.isCaching = true;
            MiBookManager.this.o(book, false, true, new a(d2));
        }

        @Override // com.martian.mibook.lib.model.d.b
        public void onLoading(boolean loading) {
        }

        @Override // com.martian.mibook.lib.model.d.b
        public void onResultError(b.d.c.b.c errorResult) {
            a0 a0Var = this.f11290a;
            if (a0Var != null) {
                a0Var.a(errorResult.d());
            }
        }
    }

    /* loaded from: classes3.dex */
    class s extends com.martian.mibook.account.k.a.e {

        /* renamed from: h */
        final /* synthetic */ j0 f11296h;

        s(final j0 val$listener) {
            this.f11296h = val$listener;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            this.f11296h.a(errorResult);
        }

        @Override // b.d.c.c.b
        /* renamed from: p */
        public void onDataReceived(MiBookCommentItemList miBookCommentItemList) {
            this.f11296h.b(miBookCommentItemList);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            this.f11296h.onLoading(show);
        }
    }

    /* loaded from: classes3.dex */
    class t extends com.martian.mibook.lib.account.d.g<ReaderBookParams, ReadingInfo> {

        /* renamed from: g */
        final /* synthetic */ g0 f11298g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        t(Class x0, Class x1, Context x2, final g0 val$listener) {
            super(x0, x1, x2);
            this.f11298g = val$listener;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            this.f11298g.a(errorResult);
        }

        @Override // b.d.c.c.i, b.d.c.c.c
        public void onUDDataReceived(final List<ReadingInfo> readingInfos) {
            if (readingInfos == null || readingInfos.isEmpty()) {
                return;
            }
            this.f11298g.b(readingInfos.get(0));
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            this.f11298g.onLoading(show);
        }
    }

    /* loaded from: classes3.dex */
    class u extends com.martian.mibook.account.k.a.a {

        /* renamed from: h */
        final /* synthetic */ b0 f11300h;

        u(final b0 val$listener) {
            this.f11300h = val$listener;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            this.f11300h.a(errorResult);
        }

        @Override // b.d.c.c.b
        /* renamed from: q */
        public void onDataReceived(MiBookGetCommentByScoreItemList miBookGetCommentByScoreItemList) {
            this.f11300h.b(miBookGetCommentByScoreItemList);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            this.f11300h.onLoading(show);
        }
    }

    /* loaded from: classes3.dex */
    class v extends com.martian.mibook.account.k.a.b {

        /* renamed from: h */
        final /* synthetic */ c0 f11302h;

        v(final c0 val$listener) {
            this.f11302h = val$listener;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            this.f11302h.a(errorResult);
        }

        @Override // b.d.c.c.b
        /* renamed from: p */
        public void onDataReceived(MiBookGetCommentByTimeItemList miBookGetCommentByTimeItemList) {
            this.f11302h.b(miBookGetCommentByTimeItemList);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            this.f11302h.onLoading(show);
        }
    }

    /* loaded from: classes3.dex */
    class w extends com.martian.mibook.account.k.a.c {

        /* renamed from: j */
        final /* synthetic */ f0 f11304j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        w(j1 activity, final f0 val$listener) {
            super(activity);
            this.f11304j = val$listener;
        }

        @Override // com.martian.mibook.lib.account.d.n, b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            this.f11304j.a(errorResult);
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            this.f11304j.onLoading(show);
        }

        @Override // b.d.c.c.b
        /* renamed from: t */
        public void onDataReceived(Comment comment) {
            this.f11304j.b(comment);
        }
    }

    /* loaded from: classes3.dex */
    class x extends com.martian.mibook.account.k.a.d {

        /* renamed from: j */
        final /* synthetic */ i0 f11305j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        x(j1 activity, final i0 val$listener) {
            super(activity);
            this.f11305j = val$listener;
        }

        @Override // com.martian.mibook.lib.account.d.n, b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            this.f11305j.a(errorResult);
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            this.f11305j.onLoading(show);
        }

        @Override // b.d.c.c.b
        /* renamed from: t */
        public void onDataReceived(CommentReply commentReply) {
            this.f11305j.b(commentReply);
        }
    }

    /* loaded from: classes3.dex */
    public interface y {
        void a(BookAdsInfo bookAdsInfo);
    }

    /* loaded from: classes3.dex */
    public interface z {
        void a(YWFreeType ywFreeType);

        void b();
    }

    public MiBookManager(Context context) {
        super(context);
        this.P = false;
        this.S = false;
        this.U = false;
        this.V = false;
        this.d0 = -1L;
        this.g0 = 0;
        this.h0 = new HashMap();
        this.i0 = new ArrayList();
        this.j0 = 0;
        this.O = context;
        this.N = new com.martian.mibook.lib.local.b.a(context, this);
        try {
            H2();
        } catch (Exception unused) {
            this.a0 = new ArrayList();
        }
    }

    public static boolean B2(AppTask appTask) {
        return appTask != null && (appTask.origin instanceof TYBookItem);
    }

    static /* synthetic */ int D2(TYTag lhs, TYTag rhs) {
        return rhs.getBookCount() - lhs.getBookCount();
    }

    static /* synthetic */ void E2(final Activity activity, final BookWrapper bookWrapper, final u3 adapter, String newBookName) {
        if (TextUtils.isEmpty(newBookName)) {
            com.martian.libmars.utils.w0.a(activity, "书名不能为空");
            return;
        }
        Book book = bookWrapper.book;
        if (book != null) {
            book.setBookName(newBookName);
            MiConfigSingleton.V3().l3().s1(bookWrapper.book);
        }
        MiBook miBook = bookWrapper.mibook;
        if (miBook != null) {
            miBook.setBookName(newBookName);
        }
        MiBookStoreItem miBookStoreItem = bookWrapper.item;
        if (miBookStoreItem != null) {
            miBookStoreItem.setBookName(newBookName);
            MiConfigSingleton.V3().l3().k1(bookWrapper.item);
        }
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    static /* synthetic */ int F1(MiBookManager miBookManager) {
        int i2 = miBookManager.j0;
        miBookManager.j0 = i2 + 1;
        return i2;
    }

    private Set<String> F2() throws IOException {
        Set<String> set = (Set) GsonUtils.b().fromJson(com.martian.libsupport.e.B(this.O, M), new n().getType());
        this.c0 = set;
        if (set == null) {
            this.c0 = new ArraySet();
        }
        return this.c0;
    }

    private void H2() throws IOException {
        Context context = this.O;
        if (context == null) {
            this.a0 = new ArrayList();
            return;
        }
        List<BookEvent> list = (List) GsonUtils.b().fromJson(com.martian.libsupport.e.B(context, C), new j().getType());
        this.a0 = list;
        if (list == null) {
            this.a0 = new ArrayList();
        }
    }

    private YWBookMall J2() {
        try {
            String B2 = com.martian.libsupport.e.B(this.O, B);
            if (!TextUtils.isEmpty(B2)) {
                YWBookMall yWBookMall = (YWBookMall) GsonUtils.b().fromJson(B2, YWBookMall.class);
                this.Z = yWBookMall;
                return yWBookMall;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        if (this.Z == null) {
            this.Z = new YWBookMall();
        }
        return this.Z;
    }

    private YWBookMall L2() {
        try {
            String B2 = com.martian.libsupport.e.B(this.O, A);
            if (!TextUtils.isEmpty(B2)) {
                YWBookMall yWBookMall = (YWBookMall) GsonUtils.b().fromJson(B2, YWBookMall.class);
                this.Y = yWBookMall;
                return yWBookMall;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        if (this.Y == null) {
            this.Y = new YWBookMall();
        }
        return this.Y;
    }

    private Set<String> M2() throws IOException {
        Set<String> set = (Set) GsonUtils.b().fromJson(com.martian.libsupport.e.B(this.O, L), new m().getType());
        this.b0 = set;
        if (set == null) {
            this.b0 = new ArraySet();
        }
        return this.b0;
    }

    private static void O1(String line, ArrayList<TextInfo> textInfos) {
        textInfos.add(new TextInfo().setLine(MiConfigSingleton.V3().n(line)));
    }

    private boolean O2(@NonNull String keyword, YWFreeType ywFreeType, @NonNull n0 listener) {
        if (ywFreeType == null) {
            return false;
        }
        for (YWCategory yWCategory : ywFreeType.getCategoryList()) {
            if (keyword.equalsIgnoreCase(yWCategory.getCategoryName())) {
                P2(keyword, ywFreeType.getFreeType(), yWCategory, listener);
                return true;
            }
            Iterator<TYTag> it = yWCategory.getTagList().iterator();
            while (it.hasNext()) {
                if (keyword.equalsIgnoreCase(it.next().getTag())) {
                    P2(keyword, ywFreeType.getFreeType(), null, listener);
                    return true;
                }
            }
        }
        return false;
    }

    private void P1(TYInitialBook tyInitialBook) {
        if (this.Q == null) {
            K2();
        }
        this.Q.put(tyInitialBook.getSourceString(), tyInitialBook);
        e3();
        MiConfigSingleton.V3().l3().I1(0, tyInitialBook.getSourceName(), tyInitialBook.getSourceId(), tyInitialBook.getRecommendId(), "", "展示");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void P2(@NonNull String keyword, int ywFreeType, YWCategory ywCategory, @NonNull n0 listener) {
        g gVar = new g(listener, ywCategory, ywFreeType, keyword);
        if (ywCategory == null) {
            ((YWCategoryBookListParams) gVar.k()).setTags(keyword);
        } else {
            ((YWCategoryBookListParams) gVar.k()).setCategoryId(Integer.valueOf(ywCategory.getCategoryId()));
        }
        ((YWCategoryBookListParams) gVar.k()).setFreeType(Integer.valueOf(ywFreeType));
        ((YWCategoryBookListParams) gVar.k()).setPage(0);
        ((YWCategoryBookListParams) gVar.k()).setStatus(0);
        ((YWCategoryBookListParams) gVar.k()).setOrder(0);
        ((YWCategoryBookListParams) gVar.k()).setFrom(com.martian.mibook.f.f4.j0.u);
        gVar.j();
    }

    private void Q1(TYInitialBookList mTyInitialBookList) {
        if (this.Q == null) {
            K2();
        }
        for (TYInitialBook tYInitialBook : mTyInitialBookList.getBookList()) {
            this.Q.put(tYInitialBook.getSourceString(), tYInitialBook);
        }
        e3();
        this.R = new HashMap(this.Q);
        f3();
    }

    private void Q2() {
        try {
            String B2 = com.martian.libsupport.e.B(this.O, x);
            if (!com.martian.libsupport.k.p(B2)) {
                try {
                    this.R = (Map) GsonUtils.b().fromJson(B2, new c().getType());
                } catch (JsonSyntaxException unused) {
                }
            }
            if (this.R == null) {
                this.R = new HashMap();
            }
        } catch (IOException unused2) {
            if (this.R == null) {
                this.R = new HashMap();
            }
        }
    }

    private boolean R1(String sourceString) {
        return i2().contains(sourceString);
    }

    private void R2() {
        try {
            String B2 = com.martian.libsupport.e.B(this.O, y);
            if (!com.martian.libsupport.k.p(B2)) {
                this.T = (List) GsonUtils.b().fromJson(B2, new d().getType());
            }
            if (this.T == null) {
                this.T = new ArrayList();
            }
        } catch (IOException unused) {
            if (this.T == null) {
                this.T = new ArrayList();
            }
        }
    }

    private void W1(final String keyword, int searchType, int page, final com.martian.mibook.lib.model.d.h receiver, String sourceName, String sourceId) {
        new q(this, page, receiver).m(keyword, searchType, sourceName, sourceId);
    }

    private void Y2(com.martian.mibook.lib.model.c.b bookProvider, Map<String, com.martian.mibook.lib.model.c.b> bookProviders) {
        bookProviders.put(bookProvider.F(), bookProvider);
    }

    private static int a2(int contentIndex, int pos, MiReadingContent content, String chapterTitle, PageInfo pageInfo, ContentProperty contentProperty, TextPaint paint) {
        return b2(pos, (pos == 0 && contentIndex == 0 && !com.martian.libsupport.k.p(chapterTitle)) ? v2(chapterTitle, pageInfo, contentProperty) : 0, content.getContent(pos, content.getChapterContent().getContentLength()), pageInfo, contentProperty, paint);
    }

    public void a3() {
        this.a0 = new ArrayList();
        p3();
    }

    private static int b2(int pos, int iLineHeight, String estContent, PageInfo pageInfo, ContentProperty contentProperty, TextPaint paint) {
        String substring;
        int i2;
        int length = estContent.length();
        int i3 = iLineHeight;
        String str = estContent;
        int i4 = 0;
        boolean z2 = true;
        while (i3 < contentProperty.getMeasureHeight() && i4 < length) {
            int indexOf = str.indexOf("\n");
            if (indexOf == -1) {
                boolean z3 = !z2;
                while (str.length() != 0) {
                    int breakText = paint.breakText(str, true, contentProperty.getLineWidth(), null);
                    if (breakText > str.length()) {
                        breakText = str.length();
                    }
                    if (contentProperty.getLineHeight() + i3 + (z3 ? contentProperty.getParagraphExtraHeight() : 0) > contentProperty.getMeasureHeight()) {
                        break;
                    }
                    O1(str.substring(0, breakText), pageInfo.getTextInfos());
                    i3 += contentProperty.getLineHeight();
                    if (z3) {
                        i3 += contentProperty.getParagraphExtraHeight();
                        pageInfo.incrTotalParagraphExtraHeight(contentProperty.getParagraphExtraHeight());
                        z3 = false;
                    }
                    i4 += breakText;
                    if (i4 >= length) {
                        break;
                    }
                    str = str.substring(breakText);
                }
                return pos + i4;
            }
            if (indexOf == 0) {
                i4++;
                str = str.substring(1);
            } else {
                int i5 = indexOf - 1;
                if (str.charAt(i5) == '\r') {
                    substring = str.substring(0, i5);
                    i2 = 2;
                } else {
                    substring = str.substring(0, indexOf);
                    i2 = 1;
                }
                boolean z4 = !z2;
                while (substring.length() != 0) {
                    int breakText2 = paint.breakText(substring, true, contentProperty.getLineWidth(), null);
                    if (breakText2 > substring.length()) {
                        breakText2 = substring.length();
                    }
                    if (contentProperty.getLineHeight() + i3 + (z4 ? contentProperty.getParagraphExtraHeight() : 0) > contentProperty.getMeasureHeight()) {
                        return pos + i4;
                    }
                    O1(substring.substring(0, breakText2), pageInfo.getTextInfos());
                    i3 += contentProperty.getLineHeight();
                    if (z4) {
                        i3 += contentProperty.getParagraphExtraHeight();
                        pageInfo.incrTotalParagraphExtraHeight(contentProperty.getParagraphExtraHeight());
                        z4 = false;
                    }
                    i4 += breakText2;
                    if (i4 + i2 >= length) {
                        return pos + i4 + i2;
                    }
                    substring = substring.substring(breakText2);
                }
                i4 += i2;
                str = str.substring(indexOf + 1);
                z2 = false;
            }
        }
        return pos + i4;
    }

    private void b3() throws IOException {
        com.martian.libsupport.e.E(this.O, M, GsonUtils.b().toJson(this.c0));
    }

    public static void c2(final MiReadingContent content, @NonNull ContentProperty contentProperty) {
        int contentLength = content.getChapterContent().getContentLength();
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(contentProperty.getTextSize());
        int i2 = 0;
        int i3 = 0;
        while (i3 < contentLength) {
            PageInfo pageInfo = new PageInfo();
            int i4 = i2 + 1;
            int a2 = a2(i2, i3, content, content.getTitle(), pageInfo, contentProperty, textPaint);
            if (a2 >= contentLength) {
                content.appendEndPos(contentLength);
                content.appendPageInfo(pageInfo);
                return;
            }
            if (a2 == i3) {
                a2++;
            }
            i3 = a2;
            content.appendEndPos(i3);
            content.appendPageInfo(pageInfo);
            i2 = i4;
        }
    }

    private void c3() throws IOException {
        Context context = this.O;
        if (context != null) {
            com.martian.libsupport.e.E(context, C, GsonUtils.b().toJson(this.a0));
        }
    }

    public static void d2(Context context, Book book, ImageView bookCover) {
        if (book == null || bookCover == null) {
            return;
        }
        String cover = book.getCover();
        if (!com.martian.libsupport.k.p(cover)) {
            if (cover.startsWith("https://tfbook-1251592799.")) {
                cover = cover.replace("https://tfbook-1251592799.", "http://tfbook-1251592799.");
            }
            com.martian.libmars.utils.n0.p(context, cover, bookCover, MiConfigSingleton.V3().i3(), MiConfigSingleton.V3().e2(), 2);
        } else if (book.isLocal()) {
            bookCover.setImageResource(R.drawable.book_cover_txt_duokan);
        } else {
            bookCover.setImageResource(R.drawable.cover_default);
        }
    }

    public void f2(@NonNull String keyword, @NonNull n0 listener) {
        int k2 = MiConfigSingleton.V3().k();
        if (O2(keyword, r2(k2), listener) || O2(keyword, y2(k2), listener)) {
            return;
        }
        List<TYTagAlias> list = this.X;
        if (list != null && !list.isEmpty()) {
            String str = "";
            int i2 = k2;
            for (TYTagAlias tYTagAlias : this.X) {
                if (!com.martian.libsupport.k.p(tYTagAlias.getMaleAlias()) && tYTagAlias.getMaleAlias().contains(keyword)) {
                    str = tYTagAlias.getTag();
                    i2 = 1;
                    if (k2 == 1) {
                        break;
                    }
                }
                if (!com.martian.libsupport.k.p(tYTagAlias.getFemaleAlias()) && tYTagAlias.getFemaleAlias().contains(keyword)) {
                    str = tYTagAlias.getTag();
                    i2 = 2;
                    if (k2 == 2) {
                        break;
                    }
                }
            }
            if (!com.martian.libsupport.k.p(str)) {
                P2(str, i2, null, listener);
                return;
            }
        }
        listener.b();
    }

    private void f3() {
        try {
            com.martian.libsupport.e.E(this.O, x, GsonUtils.b().toJson(this.R));
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private TYTag g2(YWCategory ywCategory, String tag) {
        for (TYTag tYTag : ywCategory.getTagList()) {
            if (tag.equalsIgnoreCase(tYTag.getTag())) {
                return new TYTag().setBookCount(Integer.valueOf(tYTag.getBookCount())).setCategoryId(Integer.valueOf(ywCategory.getCategoryId())).setCategoryName(ywCategory.getCategoryName());
            }
        }
        return null;
    }

    private void g3() {
        try {
            com.martian.libsupport.e.E(this.O, y, GsonUtils.b().toJson(this.T));
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private Set<String> i2() {
        try {
            if (this.c0 == null) {
                this.c0 = F2();
            }
        } catch (Exception unused) {
            this.c0 = new ArraySet();
        }
        return this.c0;
    }

    private void i3() {
        this.d0 = MartianRPUserManager.t();
    }

    private Map<String, TYInitialBook> p2() {
        if (this.Q == null) {
            K2();
        }
        return this.Q;
    }

    public void p3() {
        try {
            c3();
        } catch (Exception unused) {
        }
    }

    private YWFreeType r2(int ctype) {
        if (ctype == 1) {
            return this.W.get(0);
        }
        if (this.W.size() > 1) {
            return this.W.get(1);
        }
        return null;
    }

    private String s3(String str) {
        return com.martian.libsupport.k.p(str) ? "" : str.replaceAll("[，,：:！!\\s]", "").toLowerCase();
    }

    private Set<String> u2() {
        try {
            if (this.b0 == null) {
                this.b0 = M2();
            }
        } catch (Exception unused) {
            this.b0 = new ArraySet();
        }
        return this.b0;
    }

    private static int v2(String title, PageInfo pageInfo, ContentProperty contentProperty) {
        if (com.martian.libsupport.k.p(title)) {
            return 0;
        }
        pageInfo.setTitle(title);
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(contentProperty.getTextSize() * 1.33f);
        int length = title.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int breakText = textPaint.breakText(title, true, contentProperty.getLineWidth(), null);
            if (breakText > title.length()) {
                breakText = title.length();
            }
            O1(title.substring(0, breakText), pageInfo.getTitleInfos());
            i2 += breakText;
            i3++;
            title = title.substring(breakText);
        }
        return (int) ((i3 * contentProperty.getLineHeight() * 1.33f) + (com.martian.libmars.d.h.b(32.0f) * 2));
    }

    private YWFreeType y2(int ctype) {
        if (ctype == 2) {
            return this.W.get(0);
        }
        if (this.W.size() > 1) {
            return this.W.get(1);
        }
        return null;
    }

    public boolean A2(Activity activity, TYInitialBookList initialBookList) {
        Collections.reverse(initialBookList.getBookList());
        for (TYInitialBook tYInitialBook : initialBookList.getBookList()) {
            String sourceString = tYInitialBook.getSourceString();
            String a2 = com.martian.mibook.lib.model.manager.d.a(tYInitialBook);
            if (!com.martian.libsupport.k.p(sourceString) && !k3(sourceString) && !k3(a2) && !w0(a2)) {
                f1();
                P1(tYInitialBook);
                Book Z1 = Z1(tYInitialBook);
                MiBook buildMibook = Z1.buildMibook();
                T0(buildMibook);
                s0(Z1);
                e(activity, buildMibook, Z1, Integer.valueOf(BookManager.f14019a));
                if (tYInitialBook.getPromote() && !com.martian.libsupport.k.p(tYInitialBook.getReason())) {
                    N1(tYInitialBook, false);
                }
                Y();
                return true;
            }
        }
        return false;
    }

    public boolean C2(Book book) {
        return (book instanceof YWBook) || (book instanceof TFBook) || (book instanceof ORBook);
    }

    public void G1(String sourceString) {
        if (com.martian.libsupport.k.p(sourceString)) {
            return;
        }
        i3();
        i2().add(sourceString);
        try {
            b3();
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void G2() {
        if (this.k0 || this.l0 == null) {
            return;
        }
        this.k0 = true;
        p pVar = new p(AdRecommendBooksParams.class, TYSearchBookList.class, this.O);
        ((AdRecommendBooksParams) pVar.k()).setPage(Integer.valueOf(this.j0));
        ((AdRecommendBooksParams) pVar.k()).setPageSize(10);
        ((AdRecommendBooksParams) pVar.k()).setSourceName(this.l0.getSourceName());
        ((AdRecommendBooksParams) pVar.k()).setSourceId(this.l0.getSourceId());
        pVar.j();
    }

    public void H1(AppTask appTask) {
        this.i0.add(appTask);
    }

    public void I1(int eventType, String sourceName, String sourceId, String recommendId, String recommend, String event) {
        J1(eventType, sourceName, sourceId, recommendId, recommend, event, 1, -1, "", false);
    }

    public YWBookMall I2(int cType) {
        return cType == 1 ? L2() : J2();
    }

    public void J1(int eventType, String sourceName, String sourceId, String recommendId, String recommend, String event, int value, int chapterIndex, String ccid, boolean firstRead) {
        if (com.martian.libsupport.k.p(sourceName) || com.martian.libsupport.k.p(sourceId)) {
            return;
        }
        if (!com.martian.libsupport.k.p(recommend)) {
            com.martian.mibook.lib.model.g.b.S(this.O, recommend, event);
        }
        if (eventType == 6 && chapterIndex >= 0) {
            for (BookEvent bookEvent : this.a0) {
                if (bookEvent != null && bookEvent.getEventType().intValue() == 6 && sourceId.equalsIgnoreCase(bookEvent.getSourceId())) {
                    bookEvent.incrValue(value);
                    bookEvent.setChapterIndex(Integer.valueOf(chapterIndex));
                    bookEvent.addChapterId(ccid);
                    bookEvent.setFirstRead(Boolean.valueOf(firstRead));
                    return;
                }
            }
        }
        if (this.a0 == null) {
            this.a0 = new ArrayList();
        }
        this.a0.add(new BookEvent().setEventType(Integer.valueOf(eventType)).setSourceName(sourceName).setSourceId(sourceId).setValue(Integer.valueOf(value)).setRecommendId(recommendId).setChapterIndex(Integer.valueOf(chapterIndex)).addChapterId(ccid).setFirstRead(Boolean.valueOf(firstRead)));
    }

    public void K1(List<TYBookItem> tyBookItems) {
        if (tyBookItems == null || tyBookItems.isEmpty()) {
            return;
        }
        boolean z2 = false;
        for (TYBookItem tYBookItem : tyBookItems) {
            if (!z2 && !com.martian.libsupport.k.p(tYBookItem.getRecommend())) {
                com.martian.mibook.lib.model.g.b.S(this.O, tYBookItem.getRecommend(), "展示");
                z2 = true;
            }
            I1(0, tYBookItem.getSourceName(), tYBookItem.getSourceId(), tYBookItem.getRecommendId(), "", "展示");
        }
    }

    public void K2() {
        try {
            String B2 = com.martian.libsupport.e.B(this.O, w);
            if (!com.martian.libsupport.k.p(B2)) {
                try {
                    this.Q = (Map) GsonUtils.b().fromJson(B2, new b().getType());
                } catch (JsonSyntaxException unused) {
                }
            }
            if (this.Q == null) {
                this.Q = new HashMap();
            }
        } catch (IOException unused2) {
            if (this.Q == null) {
                this.Q = new HashMap();
            }
        }
    }

    @Override // com.martian.mibook.lib.model.manager.BookManager
    protected void L0(Context context, Map<String, com.martian.mibook.lib.model.c.b> bookProviders) {
        Y2(new com.martian.mibook.lib.original.c.a(this), bookProviders);
        Y2(new com.martian.mibook.lib.yuewen.c.a(this), bookProviders);
        Y2(new com.martian.mibook.lib.yuewen.c.a(this), bookProviders);
        Y2(new com.martian.free.b.a(this), bookProviders);
    }

    public void L1(Activity activity, final String filepath, final a0 listener) {
        M1(activity, filepath, true, listener);
    }

    public void M1(Activity activity, final String filepath, final boolean parseLargeFileChapters, final a0 listener) {
        S1(filepath, new r(listener, activity, parseLargeFileChapters));
    }

    public void N1(TYInitialBook tyInitialBook, boolean top) {
        if (this.T == null) {
            R2();
        }
        this.V = true;
        if (top) {
            this.T.add(0, tyInitialBook);
        } else {
            this.T.add(tyInitialBook);
        }
    }

    public void N2(String keyword, @NonNull n0 listener) {
        if (this.W == null) {
            S2();
        }
        if (this.W.isEmpty() || this.X == null) {
            l3(MiConfigSingleton.V3().k(), new f(keyword, listener));
        } else {
            f2(keyword, listener);
        }
    }

    public void S1(String filepath, com.martian.mibook.lib.model.d.b receiver) {
        this.N.a(filepath, receiver);
    }

    public void S2() {
        try {
            String B2 = com.martian.libsupport.e.B(this.O, z);
            if (!TextUtils.isEmpty(B2)) {
                this.W = (List) GsonUtils.b().fromJson(B2, new h().getType());
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        if (this.W == null) {
            this.W = new ArrayList();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void T1(@NonNull m0 searchInfo, @NonNull com.martian.mibook.lib.model.d.h receiver) {
        if (searchInfo.i()) {
            return;
        }
        k kVar = new k(RecommendBooksParams.class, TYSearchBookList.class, this.O, receiver, searchInfo);
        ((RecommendBooksParams) kVar.k()).setPage(Integer.valueOf(searchInfo.b()));
        ((RecommendBooksParams) kVar.k()).setPageSize(Integer.valueOf(searchInfo.c()));
        ((RecommendBooksParams) kVar.k()).setSearchType(Integer.valueOf(searchInfo.d()));
        ((RecommendBooksParams) kVar.k()).setSourceName(searchInfo.g());
        ((RecommendBooksParams) kVar.k()).setSourceId(searchInfo.f());
        ((RecommendBooksParams) kVar.k()).setKeywords(searchInfo.a());
        ((RecommendBooksParams) kVar.k()).setSeed(Integer.valueOf(searchInfo.e()));
        kVar.j();
    }

    protected void T2(List<TYBookItem> tyBookItems) {
        if (tyBookItems == null || tyBookItems.isEmpty()) {
            return;
        }
        boolean z2 = false;
        for (TYBookItem tYBookItem : tyBookItems) {
            if (MiConfigSingleton.V3().l3().V(tYBookItem) == null) {
                if (this.m == null) {
                    this.m = new MiReadingRecordList();
                }
                MiReadingRecord miReadingRecord = new MiReadingRecord();
                miReadingRecord.setSourceString(com.martian.mibook.lib.model.manager.d.j(tYBookItem.getSourceName(), tYBookItem.getSourceId()));
                miReadingRecord.setChapterIndex(tYBookItem.getChapterIndex());
                miReadingRecord.setContentIndex(0);
                miReadingRecord.setLastReadingTime(tYBookItem.getModifiedOn());
                miReadingRecord.setBookName(tYBookItem.getBookName());
                this.m.getMiReadingRecords().add(miReadingRecord);
                Book Z1 = Z1(tYBookItem);
                T0(Z1.buildMibook());
                s0(Z1);
                W0(miReadingRecord, false);
                z2 = true;
            }
        }
        if (z2) {
            Y();
        }
        Z0();
    }

    public void U1(final String author, int page, final com.martian.mibook.lib.model.d.h receiver, String sourceName, String sourceId) {
        W1(author, 2, page, receiver, sourceName, sourceId);
    }

    public void U2(final Activity activity, final BookWrapper bookWrapper, final u3 adapter) {
        if (bookWrapper == null) {
            return;
        }
        com.martian.libmars.utils.k0.T(activity, activity.getString(R.string.bookrack_update_txt_name), bookWrapper.getBookName(), activity.getString(R.string.input_ud_tag_name), false, false, new k0.i() { // from class: com.martian.mibook.application.r
            @Override // com.martian.libmars.utils.k0.i
            public final void a(String str) {
                MiBookManager.E2(activity, bookWrapper, adapter, str);
            }
        });
    }

    public void V1(final String keyword, int page, int search_type, final com.martian.mibook.lib.model.d.h receiver) {
        W1(keyword, search_type, page, receiver, "", "");
    }

    public boolean V2() {
        if (this.R == null) {
            Q2();
        }
        return !this.R.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void W2(j1 activity, String sourceName, String sourceId, String chapterId, String chapterName, String content, int score, final f0 listener) {
        w wVar = new w(activity, listener);
        ((MiBookPostCommentParams) wVar.k()).setSourceName(sourceName);
        ((MiBookPostCommentParams) wVar.k()).setSourceId(sourceId);
        if (!com.martian.libsupport.k.p(chapterId)) {
            ((MiBookPostCommentParams) wVar.k()).setChapterId(chapterId);
        }
        if (!com.martian.libsupport.k.p(chapterName)) {
            ((MiBookPostCommentParams) wVar.k()).setChapterName(chapterName);
        }
        if (!com.martian.libsupport.k.p(content)) {
            ((MiBookPostCommentParams) wVar.k()).setContent(content);
        }
        if (score > 0) {
            ((MiBookPostCommentParams) wVar.k()).setScore(Integer.valueOf(score));
        }
        wVar.execute();
    }

    public void X1(final String bookname, final int searchType, int page, String sourceName, String sourceId, final com.martian.mibook.lib.model.d.h receiver) {
        W1(bookname, searchType, page, receiver, sourceName, sourceId);
    }

    public boolean X2(j1 activity) {
        if (this.U) {
            return false;
        }
        if (this.T == null) {
            R2();
        }
        if (this.T.isEmpty()) {
            return false;
        }
        TYInitialBook remove = this.T.remove(0);
        if (remove.getGoReading()) {
            remove.setGoReading(Boolean.FALSE);
            s2.h0(activity, remove);
        } else {
            v2.P0(activity, remove);
        }
        this.U = true;
        this.V = true;
        return true;
    }

    public boolean Y1(String sourceString) {
        if (this.R == null) {
            Q2();
        }
        return this.R.containsKey(sourceString);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.martian.mibook.lib.model.data.abs.Book] */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.martian.free.response.TFBook] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.martian.mibook.lib.yuewen.response.YWBook] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.martian.mibook.lib.original.data.ORBook] */
    public Book Z1(TYBookItem tyBookItem) {
        ?? r0 = 0;
        if (tyBookItem == null) {
            return null;
        }
        String sourceName = tyBookItem.getSourceName();
        sourceName.hashCode();
        switch (sourceName) {
            case "tf":
                r0 = new TFBook();
                r0.setCpName(tyBookItem.getCpName());
                r0.setCategoryName(tyBookItem.getCategoryName());
                r0.setAllWords(tyBookItem.getAllWords());
                r0.setStatus(tyBookItem.getIntegerStatus());
                r0.setPromote(Boolean.valueOf(tyBookItem.getPromote()));
                break;
            case "yw":
                r0 = new YWBook();
                r0.setCategoryName(tyBookItem.getCategoryName());
                r0.setAllWords(tyBookItem.getAllWords());
                r0.setStatus(tyBookItem.getIntegerStatus());
                r0.setPromote(Boolean.valueOf(tyBookItem.getPromote()));
                break;
            case "txs":
                r0 = new ORBook();
                break;
        }
        if (r0 != 0) {
            r0.setBookName(tyBookItem.getTitle());
            r0.setCover(tyBookItem.getCoverUrl());
            r0.setShortIntro(tyBookItem.getIntro());
            r0.setSourceId(tyBookItem.getSourceId());
            r0.setAuthorName(tyBookItem.getAuthorName());
            if (tyBookItem instanceof TYInitialBook) {
                TYInitialBook tYInitialBook = (TYInitialBook) tyBookItem;
                r0.setLastChapter(tYInitialBook.getLatestChapter());
                r0.setLatestChapterUpdateTime(tYInitialBook.getLatestChapterUpdateTime());
            }
        }
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void Z2(j1 activity, Integer cid, Integer rid, String content, final i0 listener) {
        x xVar = new x(activity, listener);
        if (!com.martian.libsupport.k.p(content)) {
            ((MiBookReplyCommentParams) xVar.k()).setContent(content);
        }
        ((MiBookReplyCommentParams) xVar.k()).setCid(cid);
        ((MiBookReplyCommentParams) xVar.k()).setRid(rid);
        xVar.execute();
    }

    @Override // com.martian.mibook.lib.model.manager.BookManager
    public com.martian.mibook.lib.model.c.b b0(String sourceName) {
        com.martian.mibook.lib.model.c.b b02 = super.b0(sourceName);
        return b02 == null ? this.N.c(sourceName) : b02;
    }

    @Override // com.martian.mibook.lib.model.manager.BookManager
    public void c1(com.martian.mibook.lib.model.c.g source, com.martian.mibook.lib.model.d.b receiver) {
        if (a0(source) != null) {
            a0(source).D(source, receiver, true);
        }
    }

    @Override // com.martian.mibook.lib.model.manager.BookManager
    public synchronized BookWrapper d(Activity activity, MiBook mibook, Book book) {
        if (C2(book)) {
            MiConfigSingleton.V3().x6(true);
        }
        return super.d(activity, mibook, book);
    }

    public void d3(YWBookMall ywBookMall, int cType) {
        if (ywBookMall == null) {
            return;
        }
        try {
            if (cType == 1) {
                com.martian.libsupport.e.E(this.O, A, GsonUtils.b().toJson(ywBookMall));
            } else {
                com.martian.libsupport.e.E(this.O, B, GsonUtils.b().toJson(ywBookMall));
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.martian.mibook.lib.model.manager.BookManager
    public synchronized BookWrapper e(Activity activity, MiBook mibook, Book book, Integer recommendTag) {
        if (C2(book)) {
            MiConfigSingleton.V3().x6(true);
        }
        return super.e(activity, mibook, book, recommendTag);
    }

    @Override // com.martian.mibook.lib.model.manager.BookManager
    public void e1() {
        if (com.martian.libmars.d.h.F().L0("orbook_migrate")) {
            com.martian.mibook.lib.original.d.c cVar = new com.martian.mibook.lib.original.d.c();
            ArrayList<ORBook> arrayList = new ArrayList();
            cVar.i(arrayList);
            if (arrayList.isEmpty()) {
                return;
            }
            com.martian.mibook.lib.original.d.b o2 = com.martian.mibook.lib.original.d.b.o();
            HashSet hashSet = new HashSet();
            for (ORBook oRBook : arrayList) {
                if (!hashSet.contains(oRBook.getSourceId())) {
                    o2.f(oRBook);
                    hashSet.add(oRBook.getSourceId());
                }
            }
        }
    }

    public void e2(Activity activity, String sourceString) {
        TYInitialBook remove;
        if (this.R == null) {
            Q2();
        }
        if (!this.R.containsKey(sourceString) || (remove = this.R.remove(sourceString)) == null) {
            return;
        }
        this.S = true;
        I1(0, remove.getSourceName(), remove.getSourceId(), remove.getRecommendId(), "", "展示");
        if (this.R.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append(MiConfigSingleton.V3().k() == 2 ? "女频书架" : "男频书架");
            sb.append("-最后一本-展示");
            com.martian.mibook.lib.model.g.b.B(activity, sb.toString());
        }
    }

    public void e3() {
        try {
            com.martian.libsupport.e.E(this.O, w, GsonUtils.b().toJson(this.Q));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.martian.mibook.lib.model.manager.BookManager
    public synchronized BookWrapper f(Activity activity, MiBookStoreItem item, MiBook mibook, Book book) {
        return super.f(activity, item, mibook, book);
    }

    public synchronized List<BookWrapper> h2(Set<String> bookIdSet, List<BookWrapper> bookList) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (BookWrapper bookWrapper : bookList) {
            MiBook miBook = bookWrapper.mibook;
            if (miBook != null && !bookIdSet.contains(miBook.getBookId()) && bookWrapper.book != null) {
                arrayList.add(bookWrapper);
            }
        }
        return arrayList;
    }

    public void h3(List<YWFreeType> ywFreeTypeList) {
        if (ywFreeTypeList == null) {
            return;
        }
        try {
            com.martian.libsupport.e.E(this.O, z, GsonUtils.b().toJson(ywFreeTypeList));
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public b.d.a.a j2(Book mBook) {
        if (!C2(mBook)) {
            return null;
        }
        return new b.d.a.a(MiConfigSingleton.V3().k() + "", MiConfigSingleton.V3().e3(), mBook.getBookName(), mBook.getSourceId(), mBook.getCategory(), mBook.getKeyword());
    }

    public boolean j3(Book book) {
        return (book instanceof YWBook) && MartianRPUserManager.t() - this.d0 >= com.alipay.mobilesecuritysdk.constant.a.k && !com.martian.libsupport.k.p(book.getSourceString()) && !R1(book.getSourceString());
    }

    @Override // com.martian.mibook.lib.model.manager.BookManager
    public void k(List<BookWrapper> bookWrappers, com.martian.mibook.lib.model.d.a receiver) {
        Iterator<com.martian.mibook.lib.model.c.b> it = c0().values().iterator();
        while (it.hasNext()) {
            it.next().u(bookWrappers, receiver);
        }
    }

    public AppTask k2(String adsPosition) {
        AppTask appTask;
        if (this.i0.isEmpty()) {
            appTask = null;
        } else {
            appTask = this.i0.remove(0);
            appTask.adsPosition = adsPosition;
        }
        if (this.i0.isEmpty()) {
            G2();
        }
        return appTask;
    }

    public boolean k3(String sourceString) {
        return u2().contains(sourceString) || p2().containsKey(sourceString);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void l2(@NonNull Activity activity, @NonNull Book book, @NonNull y listener) {
        if (book.isLocal()) {
            return;
        }
        BookAdsInfo bookAdsInfo = this.h0.get(book.getSourceString());
        if (bookAdsInfo != null) {
            listener.a(bookAdsInfo);
            return;
        }
        o oVar = new o(BookAdsParams.class, BookAdsInfo.class, activity, book, listener);
        ((BookAdsParams) oVar.k()).setSourceId(book.getSourceId());
        ((BookAdsParams) oVar.k()).setSourceName(book.getSourceName());
        oVar.j();
    }

    public void l3(int ctype, @NonNull z listener) {
        new e(listener, ctype).j();
    }

    @Override // com.martian.mibook.lib.model.manager.BookManager
    public void m(com.martian.mibook.lib.model.c.g source, com.martian.mibook.lib.model.d.b receiver) {
        if (a0(source) != null) {
            a0(source).D(source, receiver, false);
        }
    }

    public List<TYTag> m2(String tag, int ctype) {
        if (this.W == null) {
            S2();
        }
        ArrayList arrayList = new ArrayList();
        if (ctype != 1 || this.W.size() <= 0) {
            if (this.W.size() > 1) {
                Iterator<YWCategory> it = this.W.get(1).getCategoryList().iterator();
                while (it.hasNext()) {
                    TYTag g2 = g2(it.next(), tag);
                    if (g2 != null) {
                        arrayList.add(g2);
                    }
                }
            }
            return arrayList;
        }
        Iterator<YWCategory> it2 = this.W.get(0).getCategoryList().iterator();
        while (it2.hasNext()) {
            TYTag g22 = g2(it2.next(), tag);
            if (g22 != null) {
                arrayList.add(g22);
            }
        }
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList, new Comparator() { // from class: com.martian.mibook.application.s
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return MiBookManager.D2((TYTag) obj, (TYTag) obj2);
                }
            });
        }
        return arrayList;
    }

    public List<BookWrapper> m3(List<BookWrapper> bookWrappers) {
        ArrayList arrayList = new ArrayList();
        Iterator<com.martian.mibook.lib.model.c.b> it = c0().values().iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().b(bookWrappers));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void n2(String sourceName, String sourceId, Integer page, String chapterId, final b0 listener) {
        u uVar = new u(listener);
        if (!com.martian.libsupport.k.p(chapterId)) {
            ((MiBookGetCommentByScoreParams) uVar.k()).setChapterId(chapterId);
        }
        ((MiBookGetCommentByScoreParams) uVar.k()).setSourceName(sourceName);
        ((MiBookGetCommentByScoreParams) uVar.k()).setSourceId(sourceId);
        ((MiBookGetCommentByScoreParams) uVar.k()).setPage(page);
        uVar.execute();
    }

    public boolean n3(BookWrapper bookWrapper) {
        if (bookWrapper.book == null) {
            return false;
        }
        if (bookWrapper.hasUpdate()) {
            return true;
        }
        Iterator<com.martian.mibook.lib.model.c.b> it = c0().values().iterator();
        while (it.hasNext()) {
            if (it.next().c(bookWrapper)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void o2(String sourceName, String sourceId, Long lastCreatedOn, String chapterId, final c0 listener) {
        v vVar = new v(listener);
        if (!com.martian.libsupport.k.p(chapterId)) {
            ((MiBookGetCommentByTimeParams) vVar.k()).setChapterId(chapterId);
        }
        if (lastCreatedOn != null) {
            ((MiBookGetCommentByTimeParams) vVar.k()).setLastCreatedOn(lastCreatedOn);
        }
        ((MiBookGetCommentByTimeParams) vVar.k()).setSourceName(sourceName);
        ((MiBookGetCommentByTimeParams) vVar.k()).setSourceId(sourceId);
        vVar.execute();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void o3(Activity activity, @NonNull final h0 listener) {
        if (!MiConfigSingleton.V3().l6() || !MiConfigSingleton.V3().Y(com.martian.mibook.lib.account.e.c.f13919a, false)) {
            listener.a();
            return;
        }
        l lVar = new l(ReadingRecordsParams.class, YWChannelBookList.class, activity, listener);
        ((ReadingRecordsParams) lVar.k()).setPage(0);
        ((ReadingRecordsParams) lVar.k()).setPageSize(50);
        lVar.j();
    }

    public YWFreeType q2(int ctype) {
        if (this.W == null) {
            S2();
        }
        if (ctype == 1 && this.W.size() > 0) {
            return this.W.get(0);
        }
        if (this.W.size() > 1) {
            return this.W.get(1);
        }
        return null;
    }

    public void q3() {
        if (!this.S || this.R == null) {
            return;
        }
        this.S = false;
        f3();
    }

    public void r3() {
        if (!this.V || this.T == null) {
            return;
        }
        this.V = false;
        g3();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void s2(Activity activity, Book book, @NonNull g0 listener) {
        if (book == null || activity == null || book.isLocal()) {
            listener.a(new b.d.c.b.c(-1, ""));
            return;
        }
        t tVar = new t(ReaderBookParams.class, ReadingInfo.class, activity, listener);
        ((ReaderBookParams) tVar.k()).setSourceId(book.getSourceId());
        ((ReaderBookParams) tVar.k()).setSourceName(book.getSourceName());
        tVar.j();
    }

    public String t2(boolean isFirstIn) {
        if (isFirstIn && this.f0 == null && !MiConfigSingleton.V3().G5()) {
            this.f0 = new ReadingHint().setHint("本软件看书永久免费").setWeight(100).setFetchTime(System.currentTimeMillis());
        }
        ReadingHint readingHint = this.f0;
        if (readingHint != null && readingHint.isValid()) {
            return com.martian.libmars.d.h.F().n(this.f0.getHint());
        }
        if (this.e0 == null) {
            this.e0 = new ArrayList();
            int i2 = MiConfigSingleton.V3().q(ReadingInfo.COUNTER_MENU) >= 3 ? 1 : 1000;
            this.e0.add(new ReadingHint().setHint("点击屏幕中央呼出阅读设置").setWeight(i2));
            this.g0 += i2;
            if (!MiConfigSingleton.V3().G5()) {
                this.e0.add(new ReadingHint().setHint("本软件看书永久免费").setWeight(i2));
                this.g0 += i2;
            }
            this.e0.add(new ReadingHint().setHint("阅读设置里可以切换翻页模式").setWeight(1));
            this.e0.add(new ReadingHint().setHint("阅读设置里可以启动听书").setWeight(1));
            this.e0.add(new ReadingHint().setHint("阅读设置里可以缓存章节").setWeight(1));
            this.e0.add(new ReadingHint().setHint("阅读设置里可以调整字体大小").setWeight(1));
            this.e0.add(new ReadingHint().setHint("阅读设置里可以调整行间距").setWeight(1));
            this.e0.add(new ReadingHint().setHint("阅读设置里可以调整屏幕亮度").setWeight(1));
            this.e0.add(new ReadingHint().setHint("阅读设置里可以调整文字背景").setWeight(1));
            this.e0.add(new ReadingHint().setHint("阅读设置里可以设置图片背景").setWeight(1));
            this.e0.add(new ReadingHint().setHint("阅读设置里可以设置个性化字体").setWeight(1));
            this.e0.add(new ReadingHint().setHint("阅读设置里可以开启自动翻页").setWeight(1));
            this.e0.add(new ReadingHint().setHint("更多阅读设置里可以设置简繁体").setWeight(1));
            this.e0.add(new ReadingHint().setHint("更多阅读设置里可以设置音量键翻页").setWeight(1));
            this.e0.add(new ReadingHint().setHint("更多阅读设置里可以设置屏幕关闭时间").setWeight(1));
            this.e0.add(new ReadingHint().setHint("更多阅读设置里可以设置全屏翻页").setWeight(1));
            this.e0.add(new ReadingHint().setHint("更多阅读设置里可以隐藏右上角金币").setWeight(1));
            this.e0.add(new ReadingHint().setHint("开通VIP可以免广告看书").setWeight(1));
            this.e0.add(new ReadingHint().setHint("开通VIP可以无限听书").setWeight(1));
            this.e0.add(new ReadingHint().setHint("开通VIP可以无限缓存章节").setWeight(1));
            this.e0.add(new ReadingHint().setHint("开通VIP可以无限缓存章节").setWeight(1));
            this.g0 += 18;
        }
        int nextInt = new Random().nextInt(this.g0) + 1;
        for (ReadingHint readingHint2 : this.e0) {
            nextInt -= readingHint2.getWeight();
            if (nextInt <= 0) {
                readingHint2.setFetchTime(System.currentTimeMillis());
                this.f0 = readingHint2;
                return com.martian.libmars.d.h.F().n(this.f0.getHint());
            }
        }
        return "";
    }

    public void t3(Book newBook) {
        if (newBook == null) {
            return;
        }
        Book book = this.l0;
        if (book == null || !book.getSourceString().equalsIgnoreCase(newBook.getSourceString())) {
            this.l0 = newBook;
            this.j0 = 0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void u3(Context context) {
        List<BookEvent> list = this.a0;
        if (list == null || list.isEmpty()) {
            return;
        }
        i iVar = new i(Integer.class, context);
        BookEventRequest bookEventRequest = new BookEventRequest();
        bookEventRequest.setEvents(new ArrayList(this.a0));
        if (MiConfigSingleton.V3().x5()) {
            ((MTJsonPostParams) iVar.k()).setUid(MiConfigSingleton.V3().C4().getUid());
            ((MTJsonPostParams) iVar.k()).setToken(MiConfigSingleton.V3().C4().getToken());
        }
        if (!MiConfigSingleton.V3().g6()) {
            ((MTJsonPostParams) iVar.k()).setImei(MiConfigSingleton.V3().z());
            ((MTJsonPostParams) iVar.k()).setOaid(MiConfigSingleton.V3().V());
        }
        ((MTJsonPostParams) iVar.k()).setRequest(bookEventRequest);
        iVar.execute();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void v3(j1 activity, Integer cid, Integer rid, boolean cancel, final l0 listener) {
        if (MiConfigSingleton.V3().k2(activity)) {
            if (this.P) {
                activity.k1("通信中，请稍候");
                return;
            }
            this.P = true;
            com.martian.mibook.lib.model.g.b.y(activity, cancel ? "取消点赞" : "点赞");
            a aVar = new a(activity, listener);
            ((MiBookVoteCommentParams) aVar.k()).setCid(cid);
            ((MiBookVoteCommentParams) aVar.k()).setRid(rid);
            ((MiBookVoteCommentParams) aVar.k()).setCancel(Boolean.valueOf(cancel));
            aVar.execute();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void w2(String sourceName, String sourceId, final j0 listener) {
        s sVar = new s(listener);
        ((MiBookTopCommentParams) sVar.k()).setSourceName(sourceName);
        ((MiBookTopCommentParams) sVar.k()).setSourceId(sourceId);
        sVar.execute();
    }

    public Book x2(Book book, boolean isRead) {
        if (isRead) {
            return book;
        }
        if (this.Q == null) {
            K2();
        }
        TYInitialBook tYInitialBook = this.Q.get(book.getSourceString());
        if (tYInitialBook != null && MiConfigSingleton.V3().g0() > 1) {
            tYInitialBook.setStartWithCover(true);
        }
        return tYInitialBook == null ? book : tYInitialBook;
    }

    public void z2(Activity activity, TYInitialBookList initialBookList) {
        List<Book> arrayList = new ArrayList<>();
        List<MiBook> arrayList2 = new ArrayList<>();
        for (TYInitialBook tYInitialBook : initialBookList.getBookList()) {
            Book Z1 = Z1(tYInitialBook);
            arrayList.add(Z1);
            arrayList2.add(Z1.buildMibook());
            if (tYInitialBook.getPromote() && !com.martian.libsupport.k.p(tYInitialBook.getReason())) {
                N1(tYInitialBook, true);
            }
        }
        if (U0(arrayList2) == -2) {
            com.martian.libmars.utils.k0.d0(activity);
        }
        t0(arrayList);
        q(activity, arrayList);
        Q1(initialBookList);
        Y();
    }
}
