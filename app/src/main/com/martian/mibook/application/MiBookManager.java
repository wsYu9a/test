package com.martian.mibook.application;

import android.app.Activity;
import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.collection.ArraySet;
import androidx.fragment.app.FragmentActivity;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.martian.ads.ad.AdConfig;
import com.martian.apptask.data.AppTask;
import com.martian.free.response.TFBook;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.R;
import com.martian.mibook.account.request.auth.BookShelfSyncInfoParams;
import com.martian.mibook.account.request.auth.UploadBookShelfOpsParams;
import com.martian.mibook.account.request.book.MiBookGetCommentByScoreParams;
import com.martian.mibook.account.request.book.MiBookGetCommentByTimeParams;
import com.martian.mibook.account.request.book.MiBookPostCommentParams;
import com.martian.mibook.account.request.book.MiBookReplyCommentParams;
import com.martian.mibook.account.request.book.MiBookTopCommentParams;
import com.martian.mibook.account.request.book.MiBookVoteCommentParams;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.data.book.MiBookCommentItemList;
import com.martian.mibook.data.book.MiBookGetCommentByScoreItemList;
import com.martian.mibook.data.book.MiBookGetCommentByTimeItemList;
import com.martian.mibook.data.book.VoteResult;
import com.martian.mibook.lib.account.activity.PhoneLoginActivity;
import com.martian.mibook.lib.account.request.BookUpdateInfoParams;
import com.martian.mibook.lib.account.request.ReadingRecordsParams;
import com.martian.mibook.lib.account.request.TYBooksParams;
import com.martian.mibook.lib.account.response.BooksUpdateInfo;
import com.martian.mibook.lib.local.base.data.LocalBook;
import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.lib.model.data.MiBookShelfItemList;
import com.martian.mibook.lib.model.data.MiBookStoreItem;
import com.martian.mibook.lib.model.data.MiChapterList;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import com.martian.mibook.lib.model.data.MiReadingRecordList;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.model.data.TYSearchBookList;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import com.martian.mibook.lib.model.manager.BookManager;
import com.martian.mibook.lib.original.data.ORBook;
import com.martian.mibook.lib.yuewen.request.AdRecommendBooksParams;
import com.martian.mibook.lib.yuewen.request.RecommendBooksParams;
import com.martian.mibook.lib.yuewen.request.YWCategoryBookListParams;
import com.martian.mibook.lib.yuewen.response.TYInitialBook;
import com.martian.mibook.lib.yuewen.response.TYTag;
import com.martian.mibook.lib.yuewen.response.TYTagAlias;
import com.martian.mibook.lib.yuewen.response.YWBook;
import com.martian.mibook.lib.yuewen.response.YWBookMall;
import com.martian.mibook.lib.yuewen.response.YWCategory;
import com.martian.mibook.lib.yuewen.response.YWCategoryBookList;
import com.martian.mibook.lib.yuewen.response.YWChannelBookList;
import com.martian.mibook.lib.yuewen.response.YWFreeType;
import com.martian.mibook.lib.yuewen.response.YWFreeTypeList;
import com.martian.mibook.mvvm.read.comment.Comment;
import com.martian.mibook.mvvm.read.comment.CommentReply;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import com.tencent.connect.common.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import l9.i0;
import l9.m0;
import l9.t0;
import ya.u0;

/* loaded from: classes3.dex */
public class MiBookManager extends BookManager {
    public static int L = 0;
    public static int M = 1;
    public static final int N = 2;
    public static final int O = 3;
    public static int P = 4;
    public static final int Q = 6;
    public static final int R = 7;
    public static final int S = 8;
    public static final int T = 1;
    public static final int U = 2;
    public static final int V = 3;
    public static final String W = "initial_book_json_file";
    public static final String X = "unexposed_books_json_file";
    public static final String Y = "unpromoted_books_json_file";
    public static final String Z = "book_freetypes_json_file";

    /* renamed from: a0 */
    public static final String f13233a0 = "male_book_mall_json_file";

    /* renamed from: b0 */
    public static final String f13234b0 = "female_book_mall_json_file";

    /* renamed from: c0 */
    public static final String f13235c0 = "sourceStrings.json";

    /* renamed from: d0 */
    public static final String f13236d0 = "BOOKRACK_INITIALED";

    /* renamed from: e0 */
    public static final String f13237e0 = "PROMOTE_BOOKS_STATUS";

    /* renamed from: f0 */
    public static final String f13238f0 = "BOOKRACK_INITIALED_TIME";

    /* renamed from: g0 */
    public static final String f13239g0 = "BOOKRACK_BOODS_RECOMMEND";
    public YWBookMall A;
    public Set<String> B;
    public final List<AppTask> C;
    public int D;
    public int E;
    public long F;
    public String G;
    public Integer H;
    public long I;
    public final String J;
    public final String K;

    /* renamed from: o */
    public final nb.a f13240o;

    /* renamed from: p */
    public final Context f13241p;

    /* renamed from: q */
    public boolean f13242q;

    /* renamed from: r */
    public Map<String, TYInitialBook> f13243r;

    /* renamed from: s */
    public Map<String, TYInitialBook> f13244s;

    /* renamed from: t */
    public boolean f13245t;

    /* renamed from: u */
    public List<TYInitialBook> f13246u;

    /* renamed from: v */
    public boolean f13247v;

    /* renamed from: w */
    public boolean f13248w;

    /* renamed from: x */
    public List<YWFreeType> f13249x;

    /* renamed from: y */
    public List<TYTagAlias> f13250y;

    /* renamed from: z */
    public YWBookMall f13251z;

    public class a extends pa.a {

        /* renamed from: i */
        public final /* synthetic */ c0 f13252i;

        public a(c0 c0Var) {
            this.f13252i = c0Var;
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            this.f13252i.a(cVar);
        }

        @Override // y8.a
        /* renamed from: r */
        public void onDataReceived(MiBookGetCommentByScoreItemList miBookGetCommentByScoreItemList) {
            this.f13252i.b(miBookGetCommentByScoreItemList);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            this.f13252i.onLoading(z10);
        }
    }

    public interface a0 {
        void a(String str);

        void b(BookWrapper bookWrapper);
    }

    public class b extends pa.b {

        /* renamed from: i */
        public final /* synthetic */ d0 f13254i;

        public b(d0 d0Var) {
            this.f13254i = d0Var;
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            this.f13254i.a(cVar);
        }

        @Override // y8.a
        /* renamed from: q */
        public void onDataReceived(MiBookGetCommentByTimeItemList miBookGetCommentByTimeItemList) {
            this.f13254i.b(miBookGetCommentByTimeItemList);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            this.f13254i.onLoading(z10);
        }
    }

    public interface b0 {
        void a(x8.c cVar);

        void b();

        void onLoading(boolean z10);
    }

    public interface c0 {
        void a(x8.c cVar);

        void b(MiBookGetCommentByScoreItemList miBookGetCommentByScoreItemList);

        void onLoading(boolean z10);
    }

    public interface d0 {
        void a(x8.c cVar);

        void b(MiBookGetCommentByTimeItemList miBookGetCommentByTimeItemList);

        void onLoading(boolean z10);
    }

    public class e extends pa.f {

        /* renamed from: k */
        public final /* synthetic */ i0 f13262k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Activity activity, i0 i0Var) {
            super(activity);
            this.f13262k = i0Var;
        }

        @Override // jb.k
        public void s(x8.c cVar) {
            MiBookManager.this.f13242q = false;
            this.f13262k.a(cVar);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }

        @Override // y8.a
        /* renamed from: u */
        public void onDataReceived(VoteResult voteResult) {
            MiBookManager.this.f13242q = false;
            if (voteResult != null) {
                this.f13262k.b(voteResult);
            } else {
                this.f13262k.a(new x8.c(-1, "通信失败"));
            }
        }
    }

    public interface e0 {
        void a(x8.c cVar);

        void b(Comment comment);

        void onLoading(boolean z10);
    }

    public class f extends TypeToken<Map<String, TYInitialBook>> {
        public f() {
        }
    }

    public interface f0 {
        void a();
    }

    public class g extends TypeToken<Map<String, TYInitialBook>> {
        public g() {
        }
    }

    public interface g0 {
        void a(x8.c cVar);

        void b(CommentReply commentReply);

        void onLoading(boolean z10);
    }

    public class h extends TypeToken<List<TYInitialBook>> {
        public h() {
        }
    }

    public interface h0 {
        void a(x8.c cVar);

        void b(MiBookCommentItemList miBookCommentItemList);

        void onLoading(boolean z10);
    }

    public class i extends jc.b {

        /* renamed from: i */
        public final /* synthetic */ y f13267i;

        /* renamed from: j */
        public final /* synthetic */ int f13268j;

        public i(y yVar, int i10) {
            this.f13267i = yVar;
            this.f13268j = i10;
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            y yVar = this.f13267i;
            if (yVar != null) {
                yVar.b();
            }
        }

        @Override // y8.a
        /* renamed from: r */
        public void onDataReceived(YWFreeTypeList yWFreeTypeList) {
            if (yWFreeTypeList == null || yWFreeTypeList.getFreeTypeList() == null || yWFreeTypeList.getFreeTypeList().isEmpty()) {
                y yVar = this.f13267i;
                if (yVar != null) {
                    yVar.b();
                    return;
                }
                return;
            }
            MiBookManager.this.f13249x = yWFreeTypeList.getFreeTypeList();
            MiBookManager.this.f13250y = yWFreeTypeList.getTyTagList();
            MiConfigSingleton.b2().M1().z2(MiBookManager.this.f13249x);
            y yVar2 = this.f13267i;
            if (yVar2 != null) {
                if (this.f13268j == 1) {
                    yVar2.a(yWFreeTypeList.getFreeTypeList().get(0));
                } else if (yWFreeTypeList.getFreeTypeList().size() > 1) {
                    this.f13267i.a(yWFreeTypeList.getFreeTypeList().get(1));
                } else {
                    this.f13267i.b();
                }
            }
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }

    public interface i0 {
        void a(x8.c cVar);

        void b(VoteResult voteResult);
    }

    public class j implements y {

        /* renamed from: a */
        public final /* synthetic */ String f13270a;

        /* renamed from: b */
        public final /* synthetic */ l0 f13271b;

        public j(String str, l0 l0Var) {
            this.f13270a = str;
            this.f13271b = l0Var;
        }

        @Override // com.martian.mibook.application.MiBookManager.y
        public void a(YWFreeType yWFreeType) {
            MiBookManager.this.x1(this.f13270a, this.f13271b);
        }

        @Override // com.martian.mibook.application.MiBookManager.y
        public void b() {
            this.f13271b.b();
        }
    }

    public static class j0 {

        /* renamed from: a */
        public int f13273a;

        /* renamed from: b */
        public int f13274b;

        /* renamed from: c */
        public int f13275c = 10;

        /* renamed from: d */
        public int f13276d;

        /* renamed from: e */
        public String f13277e;

        /* renamed from: f */
        public String f13278f;

        /* renamed from: g */
        public String f13279g;

        /* renamed from: h */
        public boolean f13280h;

        public String a() {
            return this.f13279g;
        }

        public int b() {
            return this.f13274b;
        }

        public int c() {
            return this.f13275c;
        }

        public int d() {
            return this.f13273a;
        }

        public int e() {
            return this.f13276d;
        }

        public String f() {
            return this.f13278f;
        }

        public String g() {
            return this.f13277e;
        }

        public void h() {
            this.f13274b++;
        }

        public boolean i() {
            return this.f13280h;
        }

        public void j(String str) {
            this.f13279g = str;
        }

        public void k(boolean z10) {
            this.f13280h = z10;
        }

        public void l(int i10) {
            this.f13274b = i10;
        }

        public void m(int i10) {
            this.f13275c = i10;
        }

        public void n(int i10) {
            this.f13273a = i10;
        }

        public void o(int i10) {
            this.f13276d = i10;
        }

        public void p(String str) {
            this.f13278f = str;
        }

        public void q(String str) {
            this.f13277e = str;
        }
    }

    public class k extends jb.e<BookUpdateInfoParams, BooksUpdateInfo> {

        /* renamed from: h */
        public final /* synthetic */ z f13281h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(Class cls, Class cls2, Context context, z zVar) {
            super(cls, cls2, context);
            this.f13281h = zVar;
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            this.f13281h.a(0);
        }

        @Override // y8.h, y8.b
        public void onUDDataReceived(List<BooksUpdateInfo> list) {
            this.f13281h.a(MiBookManager.this.S2(list));
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }

    public interface k0 {
        void a();
    }

    public class l extends jc.g {

        /* renamed from: i */
        public final /* synthetic */ l0 f13283i;

        /* renamed from: j */
        public final /* synthetic */ YWCategory f13284j;

        /* renamed from: k */
        public final /* synthetic */ int f13285k;

        /* renamed from: l */
        public final /* synthetic */ String f13286l;

        public l(l0 l0Var, YWCategory yWCategory, int i10, String str) {
            this.f13283i = l0Var;
            this.f13284j = yWCategory;
            this.f13285k = i10;
            this.f13286l = str;
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            this.f13283i.b();
        }

        @Override // y8.a
        /* renamed from: r */
        public void onDataReceived(YWCategoryBookList yWCategoryBookList) {
            if (yWCategoryBookList != null) {
                this.f13283i.a(yWCategoryBookList.getBookList(), this.f13284j, this.f13285k, this.f13286l);
            } else {
                this.f13283i.b();
            }
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }

    public interface l0 {
        void a(List<TYBookItem> list, YWCategory yWCategory, int i10, String str);

        void b();
    }

    public class m extends TypeToken<List<YWFreeType>> {
        public m() {
        }
    }

    public class n extends kb.v<ReadingRecordsParams, YWChannelBookList> {

        /* renamed from: j */
        public final /* synthetic */ f0 f13289j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(Class cls, Class cls2, Activity activity, f0 f0Var) {
            super(cls, cls2, activity);
            this.f13289j = f0Var;
        }

        @Override // kb.v, y8.a
        public void onResultError(x8.c cVar) {
            this.f13289j.a();
        }

        @Override // y8.h, y8.b
        public void onUDDataReceived(List<YWChannelBookList> list) {
            MiConfigSingleton.b2().g1(lb.c.f28067a, false);
            if (list == null || list.isEmpty()) {
                this.f13289j.a();
            } else {
                MiBookManager.this.o2(list.get(0).getBookList());
                this.f13289j.a();
            }
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }

    public class o extends TypeToken<Set<String>> {
        public o() {
        }
    }

    public class p extends jb.e<AdRecommendBooksParams, TYSearchBookList> {
        public p(Class cls, Class cls2, Context context) {
            super(cls, cls2, context);
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            MiBookManager.this.F = System.currentTimeMillis() + 600000;
            MiBookManager.this.D = 0;
        }

        @Override // y8.h, y8.b
        public void onUDDataReceived(List<TYSearchBookList> list) {
            if (list == null || list.isEmpty() || list.get(0).getBookItemList().isEmpty()) {
                MiBookManager.this.F = System.currentTimeMillis() + 600000;
                return;
            }
            Iterator<TYBookItem> it = list.get(0).getBookItemList().iterator();
            while (true) {
                boolean z10 = true;
                if (!it.hasNext()) {
                    MiBookManager.this.D++;
                    return;
                }
                TYBookItem next = it.next();
                AppTask appTask = new AppTask();
                appTask.f12000id = Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE;
                appTask.source = AdConfig.UnionType.BOOK;
                appTask.pid = "book";
                appTask.adsType = AdConfig.AdType.NATIVE;
                appTask.origin = next;
                appTask.desc = next.getAuthor();
                appTask.title = next.getBookName();
                appTask.iconUrl = next.getCoverUrl();
                appTask.posterUrl = next.getUrl();
                appTask.appPromote = "好书推荐";
                appTask.setEcpm(next.getEcpm());
                if (next.getCreative() == null) {
                    z10 = false;
                }
                appTask.setCoverView(z10);
                MiBookManager.this.C.add(appTask);
            }
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }

    public class q extends kb.w<UploadBookShelfOpsParams, Boolean> {
        public q(Class cls, Class cls2, Activity activity) {
            super(cls, cls2, activity);
        }

        @Override // kb.w, y8.a
        public void onResultError(x8.c cVar) {
            MiBookManager.this.M0();
        }

        @Override // y8.h, y8.b
        public void onUDDataReceived(List<Boolean> list) {
            MiBookManager.this.M0();
            if (list.get(0).booleanValue()) {
                MiBookManager.this.r();
            }
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }

    public class r extends kb.w<BookShelfSyncInfoParams, MiBookShelfItemList> {

        /* renamed from: j */
        public final /* synthetic */ b0 f13294j;

        /* renamed from: k */
        public final /* synthetic */ Activity f13295k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(Class cls, Class cls2, Activity activity, b0 b0Var, Activity activity2) {
            super(cls, cls2, activity);
            this.f13294j = b0Var;
            this.f13295k = activity2;
        }

        @Override // kb.w, y8.a
        public void onResultError(x8.c cVar) {
            this.f13294j.a(cVar);
        }

        @Override // y8.h, y8.b
        public void onUDDataReceived(List<MiBookShelfItemList> list) {
            MiBookManager.this.M0();
            this.f13294j.b();
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            this.f13294j.onLoading(z10);
        }

        @Override // y8.b, y8.a
        /* renamed from: v */
        public boolean onPreDataReceived(MiBookShelfItemList miBookShelfItemList) {
            return MiBookManager.this.J0(this.f13295k, miBookShelfItemList);
        }
    }

    public class s implements ea.b {

        /* renamed from: a */
        public final /* synthetic */ Activity f13297a;

        /* renamed from: b */
        public final /* synthetic */ Book f13298b;

        /* renamed from: c */
        public final /* synthetic */ BookWrapper f13299c;

        public s(Activity activity, Book book, BookWrapper bookWrapper) {
            this.f13297a = activity;
            this.f13298b = book;
            this.f13299c = bookWrapper;
        }

        @Override // ea.b
        public void permissionDenied() {
        }

        @Override // ea.b
        public void permissionGranted() {
            je.i.S(this.f13297a, MiBookManager.this.P1(this.f13298b, this.f13299c.item.isReaded()), this.f13299c.item.getReadingChapterIndex(), this.f13299c.item.getReadingContentPos(), this.f13299c.item.getReadingContentLength(), true);
        }
    }

    public class t extends jb.e<RecommendBooksParams, TYSearchBookList> {

        /* renamed from: h */
        public final /* synthetic */ xb.h f13301h;

        /* renamed from: i */
        public final /* synthetic */ j0 f13302i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(Class cls, Class cls2, Context context, xb.h hVar, j0 j0Var) {
            super(cls, cls2, context);
            this.f13301h = hVar;
            this.f13302i = j0Var;
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            this.f13301h.d(cVar);
        }

        @Override // y8.h, y8.b
        public void onUDDataReceived(List<TYSearchBookList> list) {
            if (list == null || list.isEmpty()) {
                this.f13301h.d(new x8.c(-1, "数据为空"));
            } else {
                this.f13301h.c(list.get(0).getBookItemList());
            }
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            this.f13302i.k(z10);
            this.f13301h.a(z10);
        }
    }

    public class u extends zd.b {

        /* renamed from: h */
        public final /* synthetic */ xb.h f13304h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(BookManager bookManager, int i10, xb.h hVar) {
            super(bookManager, i10);
            this.f13304h = hVar;
        }

        @Override // gb.a, xb.h
        public void b(List<TYBookItem> list) {
            super.b(list);
            this.f13304h.b(list);
        }

        @Override // gb.a
        public void g(x8.c cVar) {
            this.f13304h.d(cVar);
        }

        @Override // gb.a
        public void h(boolean z10) {
            this.f13304h.a(z10);
        }

        @Override // gb.a
        public void i(List<TYBookItem> list) {
            this.f13304h.c(list);
        }

        @Override // gb.a
        public List<TYBookItem> j(List<TYBookItem> list) {
            return list;
        }
    }

    public class x extends pa.e {

        /* renamed from: i */
        public final /* synthetic */ h0 f13313i;

        public x(h0 h0Var) {
            this.f13313i = h0Var;
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            this.f13313i.a(cVar);
        }

        @Override // y8.a
        /* renamed from: q */
        public void onDataReceived(MiBookCommentItemList miBookCommentItemList) {
            this.f13313i.b(miBookCommentItemList);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            this.f13313i.onLoading(z10);
        }
    }

    public interface y {
        void a(YWFreeType yWFreeType);

        void b();
    }

    public interface z {
        void a(int i10);
    }

    public MiBookManager(Context context) {
        super(context);
        this.f13242q = false;
        this.f13245t = false;
        this.f13247v = false;
        this.f13248w = false;
        this.C = new ArrayList();
        this.D = 0;
        this.E = 0;
        this.I = -1L;
        this.J = "PREF_SECRETE_CATEGORY_PWD";
        this.K = "pref_use_category";
        this.f13241p = context;
        this.f13240o = new nb.a(context, this);
    }

    public static boolean V1(AppTask appTask) {
        return appTask != null && (appTask.origin instanceof TYBookItem);
    }

    public static /* synthetic */ int a2(TYTag tYTag, TYTag tYTag2) {
        return tYTag2.getBookCount() - tYTag.getBookCount();
    }

    public static /* synthetic */ void b2(BookWrapper bookWrapper, Activity activity, k0 k0Var) {
        boolean x10 = MiConfigSingleton.b2().M1().x(bookWrapper);
        t0.b(activity, x10 ? "删除成功" : "删除失败");
        if (!x10 || k0Var == null) {
            return;
        }
        k0Var.a();
    }

    public static void s1(Context context, Book book, ImageView imageView) {
        if (book == null || imageView == null) {
            return;
        }
        t1(context, book.getCover(), book.isLocal(), imageView);
    }

    public static void t1(Context context, String str, boolean z10, ImageView imageView) {
        if (!ba.l.q(str)) {
            if (str.startsWith("https://tfbook-1251592799.")) {
                str = str.replace("https://tfbook-1251592799.", "http://tfbook-1251592799.");
            }
            m0.p(context, str, imageView, MiConfigSingleton.b2().L1(), MiConfigSingleton.b2().x1(), 2);
        } else if (z10) {
            m0.b(context, imageView);
            imageView.setImageResource(R.drawable.book_cover_txt);
        } else {
            m0.b(context, imageView);
            imageView.setImageResource(R.drawable.cover_default);
        }
    }

    public static void u1(Context context, Book book, ImageView imageView) {
        if (book == null || imageView == null) {
            return;
        }
        String cover = book.getCover();
        if (!ba.l.q(cover)) {
            if (cover.startsWith("https://tfbook-1251592799.")) {
                cover = cover.replace("https://tfbook-1251592799.", "http://tfbook-1251592799.");
            }
            m0.o(context, cover, imageView, MiConfigSingleton.b2().L1(), MiConfigSingleton.b2().x1());
        } else if (!book.isLocal()) {
            imageView.setImageResource(R.drawable.cover_default);
        } else {
            m0.b(context, imageView);
            imageView.setImageResource(R.drawable.book_cover_txt);
        }
    }

    public static void v1(Context context, String str, boolean z10, ImageView imageView) {
        if (!ba.l.q(str)) {
            if (str.startsWith("https://tfbook-1251592799.")) {
                str = str.replace("https://tfbook-1251592799.", "http://tfbook-1251592799.");
            }
            m0.o(context, str, imageView, MiConfigSingleton.b2().L1(), MiConfigSingleton.b2().x1());
        } else if (z10) {
            m0.b(context, imageView);
            imageView.setImageResource(R.drawable.book_cover_txt);
        } else {
            m0.b(context, imageView);
            imageView.setImageResource(R.drawable.cover_default);
        }
    }

    public AppTask A1(String str) {
        if (this.C.isEmpty()) {
            P2();
            return null;
        }
        AppTask remove = this.C.remove(0);
        remove.pid = str;
        return remove;
    }

    public void A2() {
        this.f13247v = true;
    }

    public List<TYTag> B1(String str, int i10) {
        if (this.f13249x == null) {
            n2();
        }
        ArrayList arrayList = new ArrayList();
        if (i10 != 1 || this.f13249x.size() <= 0) {
            if (this.f13249x.size() > 1) {
                Iterator<YWCategory> it = this.f13249x.get(1).getCategoryList().iterator();
                while (it.hasNext()) {
                    TYTag y12 = y1(it.next(), str);
                    if (y12 != null) {
                        arrayList.add(y12);
                    }
                }
            }
            return arrayList;
        }
        Iterator<YWCategory> it2 = this.f13249x.get(0).getCategoryList().iterator();
        while (it2.hasNext()) {
            TYTag y13 = y1(it2.next(), str);
            if (y13 != null) {
                arrayList.add(y13);
            }
        }
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList, new Comparator() { // from class: ya.w0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int a22;
                    a22 = MiBookManager.a2((TYTag) obj, (TYTag) obj2);
                    return a22;
                }
            });
        }
        return arrayList;
    }

    public void B2(Context context, boolean z10) {
        ba.j.p(context, f13236d0, z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void C1(int i10, String str, String str2, Integer num, String str3, Integer num2, c0 c0Var) {
        a aVar = new a(c0Var);
        ((MiBookGetCommentByScoreParams) aVar.k()).setType(Integer.valueOf(i10));
        if (!ba.l.q(str3)) {
            ((MiBookGetCommentByScoreParams) aVar.k()).setChapterId(str3);
        }
        if (num2 != null) {
            ((MiBookGetCommentByScoreParams) aVar.k()).setParagraphIdx(num2);
        }
        ((MiBookGetCommentByScoreParams) aVar.k()).setSourceName(str);
        ((MiBookGetCommentByScoreParams) aVar.k()).setSourceId(str2);
        ((MiBookGetCommentByScoreParams) aVar.k()).setPage(num);
        aVar.execute();
    }

    public void C2(Context context) {
        this.I = System.currentTimeMillis();
        ba.j.n(context, f13238f0, System.currentTimeMillis());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void D1(int i10, String str, String str2, Long l10, String str3, Integer num, d0 d0Var) {
        b bVar = new b(d0Var);
        ((MiBookGetCommentByTimeParams) bVar.k()).setType(Integer.valueOf(i10));
        if (!ba.l.q(str3)) {
            ((MiBookGetCommentByTimeParams) bVar.k()).setChapterId(str3);
        }
        if (num != null) {
            ((MiBookGetCommentByTimeParams) bVar.k()).setParagraphIdx(num);
        }
        if (l10 != null) {
            ((MiBookGetCommentByTimeParams) bVar.k()).setLastCreatedOn(l10);
        }
        ((MiBookGetCommentByTimeParams) bVar.k()).setSourceName(str);
        ((MiBookGetCommentByTimeParams) bVar.k()).setSourceId(str2);
        bVar.execute();
    }

    public void D2(Context context, boolean z10) {
        ba.j.p(context, f13239g0, z10);
    }

    public final Map<String, TYInitialBook> E1() {
        if (this.f13243r == null) {
            f2();
        }
        return this.f13243r;
    }

    public void E2(Context context) {
        ba.j.p(context, "pref_use_category", true);
    }

    public YWFreeType F1(int i10) {
        if (this.f13249x == null) {
            n2();
        }
        if (i10 == 1 && !this.f13249x.isEmpty()) {
            return this.f13249x.get(0);
        }
        if (this.f13249x.size() > 1) {
            return this.f13249x.get(1);
        }
        return null;
    }

    public void F2(int i10) {
        this.H = Integer.valueOf(i10);
        ba.j.m(this.f13241p, f13237e0, i10);
    }

    public List<YWFreeType> G1() {
        if (this.f13249x == null) {
            n2();
        }
        return this.f13249x;
    }

    public void G2(Context context, String str) {
        ba.j.o(context, "PREF_SECRETE_CATEGORY_PWD", str);
    }

    public final YWFreeType H1(int i10) {
        if (i10 == 1) {
            return this.f13249x.get(0);
        }
        if (this.f13249x.size() > 1) {
            return this.f13249x.get(1);
        }
        return null;
    }

    public void H2(List<YWFreeType> list) {
        this.f13249x = list;
        z2(list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.lib.model.manager.BookManager
    public x8.m<TYBookItem> I0(List<String> list) {
        v vVar = new v(TYBooksParams.class, TYBookItem.class, this.f13241p);
        ((TYBooksParams) vVar.k()).setSourceStrings(u0.a(",", list));
        return vVar.i();
    }

    public boolean I1(Context context) {
        return ba.j.d(context, "pref_use_category", false);
    }

    public void I2(List<TYTagAlias> list) {
        this.f13250y = list;
    }

    public int J1() {
        if (this.H == null) {
            this.H = Integer.valueOf(ba.j.f(this.f13241p, f13237e0, W1(this.f13241p) ? 1 : 0));
        }
        return this.H.intValue();
    }

    public final void J2(Activity activity, BookWrapper bookWrapper, k0 k0Var) {
        l9.i0.z0(activity, activity.getString(R.string.delete_hint), "本地文件不存在，是否删除《" + bookWrapper.getBookName() + "》?\n(该书的所有缓存内容将被清空)", new i0.l() { // from class: ya.v0

            /* renamed from: b */
            public final /* synthetic */ Activity f33406b;

            /* renamed from: c */
            public final /* synthetic */ MiBookManager.k0 f33407c;

            public /* synthetic */ v0(Activity activity2, MiBookManager.k0 k0Var2) {
                activity = activity2;
                k0Var = k0Var2;
            }

            @Override // l9.i0.l
            public final void a() {
                MiBookManager.b2(BookWrapper.this, activity, k0Var);
            }
        });
    }

    public String K1() {
        return this.G;
    }

    public boolean K2(String str) {
        return M1().contains(str) || E1().containsKey(str);
    }

    public final String L1(Context context) {
        String j10 = ba.j.j(context, "PREF_SECRETE_CATEGORY_PWD");
        return ba.l.q(j10) ? "" : j10;
    }

    public void L2(Activity activity, BookWrapper bookWrapper, k0 k0Var) {
        if (bookWrapper == null) {
            return;
        }
        Book book = bookWrapper.book;
        if (book == null) {
            t0.b(activity, "无法识别的书籍");
            return;
        }
        if (I(book) == null) {
            f0(book);
        }
        if (!book.isLocal()) {
            je.i.S(activity, P1(book, bookWrapper.item.isReaded()), bookWrapper.item.getReadingChapterIndex(), bookWrapper.item.getReadingContentPos(), bookWrapper.item.getReadingContentLength(), true);
            return;
        }
        if (!((LocalBook) book).exists()) {
            J2(activity, bookWrapper, k0Var);
        } else if (bookWrapper.txtChapterLoading) {
            t0.b(activity, "智能分章中...");
        } else {
            ea.c.i(activity, MiConfigSingleton.b2().I0(), new s(activity, book, bookWrapper));
        }
    }

    public final Set<String> M1() {
        try {
            if (this.B == null) {
                this.B = h2();
            }
        } catch (Exception unused) {
            this.B = new ArraySet();
        }
        return this.B;
    }

    public void M2(int i10, y yVar) {
        new i(yVar, i10).j();
    }

    @Override // com.martian.mibook.lib.model.manager.BookManager
    public wb.b N(String str) {
        nb.a aVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        wb.b N2 = super.N(str);
        return (N2 != null || (aVar = this.f13240o) == null) ? N2 : aVar.b(str);
    }

    public List<TYTagAlias> N1() {
        return this.f13250y;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void N2(Activity activity, b0 b0Var) {
        r rVar = new r(BookShelfSyncInfoParams.class, MiBookShelfItemList.class, activity, b0Var, activity);
        ((BookShelfSyncInfoParams) rVar.k()).setBook_shelf_ops(R());
        rVar.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void O1(String str, String str2, h0 h0Var) {
        x xVar = new x(h0Var);
        ((MiBookTopCommentParams) xVar.k()).setSourceName(str);
        ((MiBookTopCommentParams) xVar.k()).setSourceId(str2);
        xVar.execute();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void O2(Activity activity, @NonNull f0 f0Var) {
        if (!MiConfigSingleton.b2().N2() || !MiConfigSingleton.b2().Q(lb.c.f28067a, false)) {
            f0Var.a();
            return;
        }
        n nVar = new n(ReadingRecordsParams.class, YWChannelBookList.class, activity, f0Var);
        ((ReadingRecordsParams) nVar.k()).setPage(0);
        ((ReadingRecordsParams) nVar.k()).setPageSize(50);
        nVar.j();
    }

    public Book P1(Book book, boolean z10) {
        if (z10) {
            return book;
        }
        if (this.f13243r == null) {
            f2();
        }
        TYInitialBook tYInitialBook = this.f13243r.get(book.getSourceString());
        return tYInitialBook == null ? book : tYInitialBook;
    }

    public void P2() {
        if (this.C.isEmpty()) {
            c2();
        }
    }

    public final YWFreeType Q1(int i10) {
        if (i10 == 2) {
            return this.f13249x.get(0);
        }
        if (this.f13249x.size() > 1) {
            return this.f13249x.get(1);
        }
        return null;
    }

    public void Q2() {
        if (!this.f13245t || this.f13244s == null) {
            return;
        }
        this.f13245t = false;
        x2();
    }

    public TYInitialBook R1(FragmentActivity fragmentActivity, List<TYInitialBook> list) {
        TYInitialBook tYInitialBook = null;
        if (list.isEmpty()) {
            return null;
        }
        List<Book> arrayList = new ArrayList<>();
        Collections.reverse(list);
        for (TYInitialBook tYInitialBook2 : list) {
            arrayList.add(p1(tYInitialBook2));
            if (tYInitialBook == null && tYInitialBook2.getPromote() && !ba.l.q(tYInitialBook2.getReason())) {
                tYInitialBook = tYInitialBook2;
            }
        }
        Collections.reverse(arrayList);
        g0(arrayList);
        T().e(fragmentActivity, arrayList);
        h1(list);
        return tYInitialBook;
    }

    public void R2() {
        if (!this.f13248w || this.f13246u == null) {
            return;
        }
        this.f13248w = false;
        y2();
    }

    public void S1(Activity activity, List<TYInitialBook> list, boolean z10) {
        if (list.isEmpty()) {
            return;
        }
        Collections.reverse(list);
        T().I();
        for (TYInitialBook tYInitialBook : list) {
            String sourceString = tYInitialBook.getSourceString();
            if (!ba.l.q(sourceString) && !K2(sourceString) && !i0(sourceString)) {
                g1(tYInitialBook);
                Book p12 = p1(tYInitialBook);
                f0(p12);
                h(activity, p12, Integer.valueOf(BookManager.f13984i));
                if (!tYInitialBook.getPromote() || ba.l.q(tYInitialBook.getReason())) {
                    return;
                }
                f1(tYInitialBook, z10);
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00fb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x003d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int S2(java.util.List<com.martian.mibook.lib.account.response.BooksUpdateInfo> r11) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.application.MiBookManager.S2(java.util.List):int");
    }

    public TYInitialBook T1(Activity activity, List<TYInitialBook> list) {
        if (list.isEmpty()) {
            return null;
        }
        for (TYInitialBook tYInitialBook : list) {
            if (tYInitialBook != null) {
                if (i0(tYInitialBook.getSourceString())) {
                    return tYInitialBook;
                }
                g1(tYInitialBook);
                Book p12 = p1(tYInitialBook);
                f0(p12);
                h(activity, p12, Integer.valueOf(BookManager.f13984i));
                return tYInitialBook;
            }
        }
        return null;
    }

    public void T2(String str) {
        if (TextUtils.isEmpty(str) || str.equalsIgnoreCase(this.G)) {
            return;
        }
        this.G = str;
        this.D = 0;
        this.E = new Random().nextInt(10000);
    }

    public boolean U1(Context context) {
        return !ba.l.q(L1(context));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void U2(Activity activity) {
        if (Q().isEmpty()) {
            return;
        }
        if (Q().size() >= 5 || System.currentTimeMillis() - X() >= 86400000) {
            q qVar = new q(UploadBookShelfOpsParams.class, Boolean.class, activity);
            ((UploadBookShelfOpsParams) qVar.k()).setBook_shelf_ops(R());
            qVar.j();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void V2(Activity activity, Integer num, Integer num2, boolean z10, i0 i0Var) {
        if (MiConfigSingleton.b2().G1().f(activity)) {
            if (this.f13242q) {
                t0.b(activity, "通信中，请稍候");
                return;
            }
            this.f13242q = true;
            ac.a.u(activity, z10 ? "取消点赞" : "点赞");
            e eVar = new e(activity, i0Var);
            ((MiBookVoteCommentParams) eVar.k()).setCid(num);
            ((MiBookVoteCommentParams) eVar.k()).setRid(num2);
            ((MiBookVoteCommentParams) eVar.k()).setCancel(Boolean.valueOf(z10));
            eVar.execute();
        }
    }

    public boolean W1(Context context) {
        return context != null && ba.j.d(context, f13236d0, false);
    }

    public boolean X1(Context context) {
        if (r1(context)) {
            return true;
        }
        if (this.I == -1) {
            this.I = ba.j.h(context, f13238f0, 0L);
        }
        return ConfigSingleton.D().K0(this.I);
    }

    public boolean Y1(Book book) {
        return (book instanceof YWBook) || (book instanceof TFBook) || (book instanceof ORBook);
    }

    public boolean Z1(Context context, String str) {
        return ba.l.o(str, L1(context));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void c2() {
        if (System.currentTimeMillis() - this.F < 60000 || TextUtils.isEmpty(this.G)) {
            return;
        }
        this.F = System.currentTimeMillis();
        p pVar = new p(AdRecommendBooksParams.class, TYSearchBookList.class, this.f13241p);
        ((AdRecommendBooksParams) pVar.k()).setPage(Integer.valueOf(this.D));
        ((AdRecommendBooksParams) pVar.k()).setPageSize(1);
        ((AdRecommendBooksParams) pVar.k()).setSeed(Integer.valueOf(this.E));
        ((AdRecommendBooksParams) pVar.k()).setSourceName(vb.e.e(this.G));
        ((AdRecommendBooksParams) pVar.k()).setSourceId(vb.e.d(this.G));
        pVar.j();
    }

    public void d1(Activity activity, String str, a0 a0Var) {
        e1(activity, str, true, a0Var);
    }

    public YWBookMall d2(int i10) {
        if (i10 == 1) {
            return g2();
        }
        if (i10 == 2) {
            return e2();
        }
        return null;
    }

    public void e1(Activity activity, String str, boolean z10, a0 a0Var) {
        i1(str, new w(a0Var, activity, z10));
    }

    public final YWBookMall e2() {
        try {
            String B = ba.g.B(this.f13241p, f13234b0);
            if (!TextUtils.isEmpty(B)) {
                YWBookMall yWBookMall = (YWBookMall) GsonUtils.b().fromJson(B, YWBookMall.class);
                this.A = yWBookMall;
                return yWBookMall;
            }
        } catch (JsonSyntaxException e10) {
            e10.printStackTrace();
        } catch (IOException e11) {
            e11.printStackTrace();
        }
        if (this.A == null) {
            this.A = new YWBookMall();
        }
        return this.A;
    }

    @Override // com.martian.mibook.lib.model.manager.BookManager
    public synchronized BookWrapper f(Activity activity, MiBookStoreItem miBookStoreItem, Book book) {
        return super.f(activity, miBookStoreItem, book);
    }

    public void f1(TYInitialBook tYInitialBook, boolean z10) {
        if (this.f13246u == null) {
            m2();
        }
        this.f13248w = true;
        if (z10) {
            this.f13246u.add(0, tYInitialBook);
        } else {
            this.f13246u.add(tYInitialBook);
        }
    }

    public void f2() {
        try {
            try {
                String B = ba.g.B(this.f13241p, W);
                if (!ba.l.q(B)) {
                    try {
                        this.f13243r = (Map) GsonUtils.b().fromJson(B, new f().getType());
                    } catch (JsonSyntaxException unused) {
                    }
                }
                if (this.f13243r == null) {
                    this.f13243r = new HashMap();
                }
            } catch (IOException unused2) {
                if (this.f13243r == null) {
                    this.f13243r = new HashMap();
                }
            }
        } catch (JsonSyntaxException e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.martian.mibook.lib.model.manager.BookManager
    public synchronized BookWrapper g(Activity activity, Book book) {
        return super.g(activity, book);
    }

    public final void g1(TYInitialBook tYInitialBook) {
        if (this.f13243r == null) {
            f2();
        }
        this.f13243r.put(tYInitialBook.getSourceString(), tYInitialBook);
        w2();
        MiConfigSingleton.b2().V1().g(0, tYInitialBook.getSourceName(), tYInitialBook.getSourceId(), tYInitialBook.getRecommendId(), "", "展示");
    }

    public final YWBookMall g2() {
        try {
            String B = ba.g.B(this.f13241p, f13233a0);
            if (!TextUtils.isEmpty(B)) {
                YWBookMall yWBookMall = (YWBookMall) GsonUtils.b().fromJson(B, YWBookMall.class);
                this.f13251z = yWBookMall;
                return yWBookMall;
            }
        } catch (JsonSyntaxException e10) {
            e10.printStackTrace();
        } catch (IOException e11) {
            e11.printStackTrace();
        }
        if (this.f13251z == null) {
            this.f13251z = new YWBookMall();
        }
        return this.f13251z;
    }

    @Override // com.martian.mibook.lib.model.manager.BookManager
    public synchronized BookWrapper h(Activity activity, Book book, Integer num) {
        return super.h(activity, book, num);
    }

    public final void h1(List<TYInitialBook> list) {
        if (this.f13243r == null) {
            f2();
        }
        for (TYInitialBook tYInitialBook : list) {
            this.f13243r.put(tYInitialBook.getSourceString(), tYInitialBook);
        }
        w2();
        this.f13244s = new HashMap(this.f13243r);
        x2();
    }

    public final Set<String> h2() throws IOException {
        Set<String> set = (Set) GsonUtils.b().fromJson(ba.g.B(this.f13241p, f13235c0), new o().getType());
        this.B = set;
        if (set == null) {
            this.B = new ArraySet();
        }
        return this.B;
    }

    public void i1(String str, xb.b bVar) {
        this.f13240o.a(str, bVar);
    }

    public void i2(String str, @NonNull l0 l0Var) {
        if (this.f13249x == null) {
            n2();
        }
        if (this.f13249x.isEmpty() || this.f13250y == null) {
            M2(MiConfigSingleton.b2().p(), new j(str, l0Var));
        } else {
            x1(str, l0Var);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void j1(@NonNull j0 j0Var, @NonNull xb.h hVar) {
        if (j0Var.i()) {
            return;
        }
        t tVar = new t(RecommendBooksParams.class, TYSearchBookList.class, this.f13241p, hVar, j0Var);
        ((RecommendBooksParams) tVar.k()).setPage(Integer.valueOf(j0Var.b()));
        ((RecommendBooksParams) tVar.k()).setPageSize(Integer.valueOf(j0Var.c()));
        ((RecommendBooksParams) tVar.k()).setSearchType(Integer.valueOf(j0Var.d()));
        ((RecommendBooksParams) tVar.k()).setSourceName(j0Var.g());
        ((RecommendBooksParams) tVar.k()).setSourceId(j0Var.f());
        ((RecommendBooksParams) tVar.k()).setKeywords(j0Var.a());
        ((RecommendBooksParams) tVar.k()).setSeed(Integer.valueOf(j0Var.e()));
        tVar.j();
    }

    public final boolean j2(@NonNull String str, YWFreeType yWFreeType, @NonNull l0 l0Var) {
        if (yWFreeType == null) {
            return false;
        }
        for (YWCategory yWCategory : yWFreeType.getCategoryList()) {
            if (str.equalsIgnoreCase(yWCategory.getCategoryName())) {
                k2(str, yWFreeType.getFreeType(), yWCategory, l0Var);
                return true;
            }
            Iterator<TYTag> it = yWCategory.getTagList().iterator();
            while (it.hasNext()) {
                if (str.equalsIgnoreCase(it.next().getTag())) {
                    k2(str, yWFreeType.getFreeType(), null, l0Var);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.martian.mibook.lib.model.manager.BookManager
    public void k(wb.f fVar, xb.b bVar) {
        if (O(fVar) != null) {
            O(fVar).D(fVar, bVar, false);
        }
    }

    public void k1(String str, int i10, xb.h hVar, String str2, String str3) {
        m1(str, 2, i10, hVar, str2, str3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void k2(@NonNull String str, int i10, YWCategory yWCategory, @NonNull l0 l0Var) {
        l lVar = new l(l0Var, yWCategory, i10, str);
        if (yWCategory == null) {
            ((YWCategoryBookListParams) lVar.k()).setTags(str);
        } else {
            ((YWCategoryBookListParams) lVar.k()).setCategoryId(Integer.valueOf(yWCategory.getCategoryId()));
        }
        ((YWCategoryBookListParams) lVar.k()).setFreeType(Integer.valueOf(i10));
        ((YWCategoryBookListParams) lVar.k()).setPage(0);
        ((YWCategoryBookListParams) lVar.k()).setStatus(0);
        ((YWCategoryBookListParams) lVar.k()).setOrder(0);
        ((YWCategoryBookListParams) lVar.k()).setFrom(3);
        lVar.j();
    }

    public void l1(String str, int i10, int i11, xb.h hVar) {
        m1(str, i11, i10, hVar, "", "");
    }

    public final void l2() {
        try {
            try {
                String B = ba.g.B(this.f13241p, X);
                if (!ba.l.q(B)) {
                    try {
                        this.f13244s = (Map) GsonUtils.b().fromJson(B, new g().getType());
                    } catch (JsonSyntaxException unused) {
                    }
                }
                if (this.f13244s == null) {
                    this.f13244s = new HashMap();
                }
            } catch (IOException unused2) {
                if (this.f13244s == null) {
                    this.f13244s = new HashMap();
                }
            }
        } catch (JsonSyntaxException e10) {
            e10.printStackTrace();
        }
    }

    public final void m1(String str, int i10, int i11, xb.h hVar, String str2, String str3) {
        new u(this, i11, hVar).m(str, i10, str2, str3);
    }

    public final void m2() {
        try {
            String B = ba.g.B(this.f13241p, Y);
            if (!ba.l.q(B)) {
                this.f13246u = (List) GsonUtils.b().fromJson(B, new h().getType());
            }
        } catch (JsonSyntaxException e10) {
            e10.printStackTrace();
        } catch (IOException e11) {
            e11.printStackTrace();
        }
        if (this.f13246u == null) {
            this.f13246u = new ArrayList();
        }
    }

    public void n1(String str, int i10, int i11, String str2, String str3, xb.h hVar) {
        m1(str, i10, i11, hVar, str2, str3);
    }

    public void n2() {
        try {
            String B = ba.g.B(this.f13241p, Z);
            if (!TextUtils.isEmpty(B)) {
                this.f13249x = (List) GsonUtils.b().fromJson(B, new m().getType());
            }
        } catch (JsonSyntaxException e10) {
            e10.printStackTrace();
        } catch (IOException e11) {
            e11.printStackTrace();
        }
        if (this.f13249x == null) {
            this.f13249x = new ArrayList();
        }
    }

    public boolean o1() {
        return J1() == 0;
    }

    public void o2(List<TYBookItem> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        boolean z10 = false;
        for (TYBookItem tYBookItem : list) {
            if (MiConfigSingleton.b2().M1().K(tYBookItem) == null) {
                if (this.f13997h == null) {
                    this.f13997h = new MiReadingRecordList();
                }
                MiReadingRecord miReadingRecord = new MiReadingRecord();
                miReadingRecord.setSourceString(vb.e.j(tYBookItem.getSourceName(), tYBookItem.getSourceId()));
                miReadingRecord.setChapterIndex(tYBookItem.getChapterIndex());
                miReadingRecord.setContentPos(0);
                miReadingRecord.setLastReadingTime(tYBookItem.getModifiedOn());
                miReadingRecord.setBookName(tYBookItem.getBookName());
                this.f13997h.getMiReadingRecords().add(miReadingRecord);
                f0(p1(tYBookItem));
                D0(miReadingRecord, false);
                z10 = true;
            }
        }
        if (z10) {
            L();
        }
        G0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.martian.mibook.lib.model.data.abs.Book] */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.martian.free.response.TFBook] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.martian.mibook.lib.yuewen.response.YWBook] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.martian.mibook.lib.original.data.ORBook] */
    public Book p1(TYBookItem tYBookItem) {
        ?? r02 = 0;
        if (tYBookItem == null) {
            return null;
        }
        String sourceName = tYBookItem.getSourceName();
        sourceName.hashCode();
        switch (sourceName) {
            case "tf":
                r02 = new TFBook();
                r02.setCpName(tYBookItem.getCpName());
                r02.setCategoryName(tYBookItem.getCategoryName());
                r02.setAllWords(tYBookItem.getAllWords());
                r02.setStatus(tYBookItem.getIntegerStatus());
                r02.setPromote(Boolean.valueOf(tYBookItem.getPromote()));
                break;
            case "yw":
                r02 = new YWBook();
                r02.setCategoryName(tYBookItem.getCategoryName());
                r02.setAllWords(tYBookItem.getAllWords());
                r02.setStatus(tYBookItem.getIntegerStatus());
                r02.setPromote(Boolean.valueOf(tYBookItem.getPromote()));
                break;
            case "txs":
                r02 = new ORBook();
                break;
        }
        if (r02 != 0) {
            r02.setBookName(tYBookItem.getTitle());
            r02.setCover(tYBookItem.getCoverUrl());
            r02.setShortIntro(tYBookItem.getIntro());
            r02.setSourceId(tYBookItem.getSourceId());
            r02.setAuthorName(tYBookItem.getAuthorName());
            if (tYBookItem instanceof TYInitialBook) {
                TYInitialBook tYInitialBook = (TYInitialBook) tYBookItem;
                r02.setLastChapter(tYInitialBook.getLatestChapter());
                r02.setLatestChapterUpdateTime(tYInitialBook.getLatestChapterUpdateTime());
            }
        }
        return r02;
    }

    public boolean p2() {
        if (this.f13244s == null) {
            l2();
        }
        return !this.f13244s.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void q1(Activity activity, String str, z zVar) {
        if (ba.l.q(str)) {
            zVar.a(0);
            return;
        }
        k kVar = new k(BookUpdateInfoParams.class, BooksUpdateInfo.class, activity, zVar);
        ((BookUpdateInfoParams) kVar.k()).setSourceStrings(str);
        kVar.j();
    }

    public boolean q2() {
        return J1() == 2;
    }

    public boolean r1(Context context) {
        return ba.j.d(context, f13239g0, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void r2(Activity activity, String str, String str2, String str3, String str4, String str5, int i10, int i11, Integer num, String str6, e0 e0Var) {
        if (!MiConfigSingleton.b2().G1().i(activity)) {
            t0.b(activity, ConfigSingleton.D().s("请先登录"));
            return;
        }
        c cVar = new c(activity, e0Var, activity);
        ((MiBookPostCommentParams) cVar.k()).setSourceName(str);
        ((MiBookPostCommentParams) cVar.k()).setSourceId(str2);
        if (!ba.l.q(str3)) {
            ((MiBookPostCommentParams) cVar.k()).setChapterId(str3);
        }
        if (!ba.l.q(str4)) {
            ((MiBookPostCommentParams) cVar.k()).setChapterName(str4);
        }
        if (!ba.l.q(str5)) {
            ((MiBookPostCommentParams) cVar.k()).setContent(ConfigSingleton.D().f0(str5));
        }
        if (i10 > 0) {
            ((MiBookPostCommentParams) cVar.k()).setScore(Integer.valueOf(i10));
        }
        ((MiBookPostCommentParams) cVar.k()).setType(Integer.valueOf(i11));
        if (num != null) {
            ((MiBookPostCommentParams) cVar.k()).setParagraphIdx(num);
        }
        if (!ba.l.q(str6)) {
            if (str6.length() > 10) {
                str6 = str6.substring(0, 10);
            }
            ((MiBookPostCommentParams) cVar.k()).setParagraphDesc(str6);
        }
        cVar.execute();
    }

    public boolean s2(FragmentActivity fragmentActivity) {
        if (this.f13247v) {
            return false;
        }
        if (this.f13246u == null) {
            m2();
        }
        if (!this.f13246u.isEmpty()) {
            TYInitialBook remove = this.f13246u.remove(0);
            AppViewModel a10 = lc.b.a(fragmentActivity);
            if (a10 != null) {
                a10.H0(remove);
                this.f13248w = true;
                return true;
            }
        }
        return false;
    }

    public final void t2(wb.b bVar, Map<String, wb.b> map) {
        map.put(bVar.H(), bVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void u2(Activity activity, Integer num, Integer num2, String str, g0 g0Var) {
        if (!MiConfigSingleton.b2().G1().i(activity)) {
            t0.b(activity, ConfigSingleton.D().s("请先登录"));
            return;
        }
        d dVar = new d(activity, g0Var, activity);
        if (!ba.l.q(str)) {
            ((MiBookReplyCommentParams) dVar.k()).setContent(ConfigSingleton.D().f0(str));
        }
        ((MiBookReplyCommentParams) dVar.k()).setCid(num);
        ((MiBookReplyCommentParams) dVar.k()).setRid(num2);
        dVar.execute();
    }

    @Override // com.martian.mibook.lib.model.manager.BookManager
    public void v0(Context context, Map<String, wb.b> map) {
        t2(new dc.a(this), map);
        t2(new hc.a(this), map);
        t2(new o8.a(this), map);
    }

    public void v2(YWBookMall yWBookMall, int i10) {
        if (yWBookMall == null) {
            return;
        }
        try {
            if (i10 == 1) {
                ba.g.F(this.f13241p, f13233a0, GsonUtils.b().toJson(yWBookMall));
            } else if (i10 != 2) {
            } else {
                ba.g.F(this.f13241p, f13234b0, GsonUtils.b().toJson(yWBookMall));
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    public void w1(Context context, String str) {
        TYInitialBook remove;
        if (this.f13244s == null) {
            l2();
        }
        if (!this.f13244s.containsKey(str) || (remove = this.f13244s.remove(str)) == null) {
            return;
        }
        this.f13245t = true;
        MiConfigSingleton.b2().V1().g(0, remove.getSourceName(), remove.getSourceId(), remove.getRecommendId(), "", "展示");
        if (this.f13244s.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(MiConfigSingleton.b2().p() == 2 ? "女频书架" : "男频书架");
            sb2.append("-最后一本-展示");
            ac.a.x(context, sb2.toString());
        }
    }

    public void w2() {
        try {
            ba.g.F(this.f13241p, W, GsonUtils.b().toJson(this.f13243r));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void x1(@NonNull String str, @NonNull l0 l0Var) {
        int p10 = MiConfigSingleton.b2().p();
        if (j2(str, H1(p10), l0Var) || j2(str, Q1(p10), l0Var)) {
            return;
        }
        List<TYTagAlias> list = this.f13250y;
        if (list != null && !list.isEmpty()) {
            String str2 = "";
            int i10 = p10;
            for (TYTagAlias tYTagAlias : this.f13250y) {
                if (!ba.l.q(tYTagAlias.getMaleAlias()) && tYTagAlias.getMaleAlias().contains(str)) {
                    str2 = tYTagAlias.getTag();
                    i10 = 1;
                    if (p10 == 1) {
                        break;
                    }
                }
                if (!ba.l.q(tYTagAlias.getFemaleAlias()) && tYTagAlias.getFemaleAlias().contains(str)) {
                    str2 = tYTagAlias.getTag();
                    i10 = 2;
                    if (p10 == 2) {
                        break;
                    }
                }
            }
            if (!ba.l.q(str2)) {
                k2(str2, i10, null, l0Var);
                return;
            }
        }
        l0Var.b();
    }

    public final void x2() {
        try {
            ba.g.F(this.f13241p, X, GsonUtils.b().toJson(this.f13244s));
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    public final TYTag y1(YWCategory yWCategory, String str) {
        for (TYTag tYTag : yWCategory.getTagList()) {
            if (TextUtils.isEmpty(str) || str.equalsIgnoreCase(tYTag.getTag())) {
                return new TYTag().setBookCount(Integer.valueOf(tYTag.getBookCount())).setCategoryId(Integer.valueOf(yWCategory.getCategoryId())).setCategoryName(yWCategory.getCategoryName());
            }
        }
        return null;
    }

    public final void y2() {
        try {
            ba.g.F(this.f13241p, Y, GsonUtils.b().toJson(this.f13246u));
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    public b8.j z1(Context context, Book book) {
        if (!Y1(book)) {
            return null;
        }
        return new b8.j(MiConfigSingleton.b2().p() + "", MiConfigSingleton.b2().H1().R(context), book.getBookName(), book.getSourceId(), book.getCategory(), book.getKeyword());
    }

    public void z2(List<YWFreeType> list) {
        if (list == null) {
            return;
        }
        try {
            ba.g.F(this.f13241p, Z, GsonUtils.b().toJson(list));
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    public class w implements xb.b {

        /* renamed from: a */
        public final /* synthetic */ a0 f13307a;

        /* renamed from: b */
        public final /* synthetic */ Activity f13308b;

        /* renamed from: c */
        public final /* synthetic */ boolean f13309c;

        public w(a0 a0Var, Activity activity, boolean z10) {
            this.f13307a = a0Var;
            this.f13308b = activity;
            this.f13309c = z10;
        }

        @Override // xb.b
        public void a(Book book) {
            LocalBook localBook = (LocalBook) book;
            if (MiConfigSingleton.b2().M1().i0(book.getSourceString())) {
                a0 a0Var = this.f13307a;
                if (a0Var != null) {
                    a0Var.b(MiConfigSingleton.b2().M1().T().n(book));
                    return;
                }
                return;
            }
            BookWrapper g10 = MiBookManager.this.g(this.f13308b, localBook);
            if (g10 == null) {
                a0 a0Var2 = this.f13307a;
                if (a0Var2 != null) {
                    a0Var2.a("添加失败");
                    return;
                }
                return;
            }
            a0 a0Var3 = this.f13307a;
            if (a0Var3 != null) {
                a0Var3.b(g10);
            }
            if (localBook.getFileSize().longValue() <= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE || !this.f13309c) {
                return;
            }
            g10.txtChapterLoading = true;
            MiBookManager.this.m(book, 0, false, true, new a(g10));
        }

        @Override // xb.b
        public void onLoading(boolean z10) {
        }

        @Override // xb.b
        public void onResultError(x8.c cVar) {
            a0 a0Var = this.f13307a;
            if (a0Var != null) {
                a0Var.a(cVar.d());
            }
        }

        public class a extends xb.f {

            /* renamed from: a */
            public final /* synthetic */ BookWrapper f13311a;

            public a(BookWrapper bookWrapper) {
                this.f13311a = bookWrapper;
            }

            @Override // xb.f
            public void a(boolean z10) {
            }

            @Override // xb.f
            public void c(ChapterList chapterList) {
                if (chapterList instanceof MiChapterList) {
                    ((MiChapterList) chapterList).getCursor().close();
                }
                this.f13311a.txtChapterLoading = false;
            }

            @Override // xb.f
            public void d(x8.c cVar) {
            }
        }
    }

    public class c extends pa.c {

        /* renamed from: k */
        public final /* synthetic */ e0 f13256k;

        /* renamed from: l */
        public final /* synthetic */ Activity f13257l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Activity activity, e0 e0Var, Activity activity2) {
            super(activity);
            this.f13256k = e0Var;
            this.f13257l = activity2;
        }

        public static /* synthetic */ void x(Activity activity, x8.c cVar, e0 e0Var) {
            t0.b(activity, cVar.d());
            e0Var.a(cVar);
        }

        @Override // jb.k, y8.a
        public void onResultError(x8.c cVar) {
            Activity activity = this.f13257l;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            if (cVar != null && cVar.c() == 20009) {
                Activity activity2 = this.f13257l;
                l9.i0.x0(activity2, "绑定手机号", "根据相关法律法规，发言评论互动需要先绑定手机号", "暂不绑定", "立即绑定", true, new i0.l() { // from class: ya.x0

                    /* renamed from: a */
                    public final /* synthetic */ Activity f33416a;

                    public /* synthetic */ x0(Activity activity22) {
                        activity2 = activity22;
                    }

                    @Override // l9.i0.l
                    public final void a() {
                        PhoneLoginActivity.y3(activity2, 1, "", 20003);
                    }
                }, new i0.k() { // from class: ya.y0

                    /* renamed from: a */
                    public final /* synthetic */ Activity f33426a;

                    /* renamed from: b */
                    public final /* synthetic */ x8.c f33427b;

                    /* renamed from: c */
                    public final /* synthetic */ MiBookManager.e0 f33428c;

                    public /* synthetic */ y0(Activity activity3, x8.c cVar2, MiBookManager.e0 e0Var) {
                        activity3 = activity3;
                        cVar = cVar2;
                        e0Var = e0Var;
                    }

                    @Override // l9.i0.k
                    public final void a() {
                        MiBookManager.c.x(activity3, cVar, e0Var);
                    }
                });
            } else {
                if (cVar2 != null) {
                    t0.b(this.f13257l, cVar2.d());
                }
                this.f13256k.a(cVar2);
            }
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            this.f13256k.onLoading(z10);
        }

        @Override // y8.a
        /* renamed from: y */
        public void onDataReceived(Comment comment) {
            t0.b(this.f13257l, "评论成功！");
            this.f13256k.b(comment);
        }

        @Override // jb.k
        public void s(x8.c cVar) {
        }
    }

    public class d extends pa.d {

        /* renamed from: k */
        public final /* synthetic */ g0 f13259k;

        /* renamed from: l */
        public final /* synthetic */ Activity f13260l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Activity activity, g0 g0Var, Activity activity2) {
            super(activity);
            this.f13259k = g0Var;
            this.f13260l = activity2;
        }

        public static /* synthetic */ void x(Activity activity, x8.c cVar, g0 g0Var) {
            t0.b(activity, cVar.d());
            g0Var.a(cVar);
        }

        @Override // jb.k, y8.a
        public void onResultError(x8.c cVar) {
            Activity activity = this.f13260l;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            if (cVar != null && cVar.c() == 20009) {
                Activity activity2 = this.f13260l;
                l9.i0.x0(activity2, "绑定手机号", "根据相关法律法规，发言评论互动需要先绑定手机号", "暂不绑定", "立即绑定", true, new i0.l() { // from class: ya.z0

                    /* renamed from: a */
                    public final /* synthetic */ Activity f33435a;

                    public /* synthetic */ z0(Activity activity22) {
                        activity2 = activity22;
                    }

                    @Override // l9.i0.l
                    public final void a() {
                        PhoneLoginActivity.y3(activity2, 1, "", 20003);
                    }
                }, new i0.k() { // from class: ya.a1

                    /* renamed from: a */
                    public final /* synthetic */ Activity f33114a;

                    /* renamed from: b */
                    public final /* synthetic */ x8.c f33115b;

                    /* renamed from: c */
                    public final /* synthetic */ MiBookManager.g0 f33116c;

                    public /* synthetic */ a1(Activity activity3, x8.c cVar2, MiBookManager.g0 g0Var) {
                        activity3 = activity3;
                        cVar = cVar2;
                        g0Var = g0Var;
                    }

                    @Override // l9.i0.k
                    public final void a() {
                        MiBookManager.d.x(activity3, cVar, g0Var);
                    }
                });
            } else {
                if (cVar2 != null) {
                    t0.b(this.f13260l, cVar2.d());
                }
                this.f13259k.a(cVar2);
            }
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            this.f13259k.onLoading(z10);
        }

        @Override // y8.a
        /* renamed from: y */
        public void onDataReceived(CommentReply commentReply) {
            this.f13259k.b(commentReply);
        }

        @Override // jb.k
        public void s(x8.c cVar) {
        }
    }

    public class v extends jb.e<TYBooksParams, TYBookItem> {
        public v(Class cls, Class cls2, Context context) {
            super(cls, cls2, context);
        }

        @Override // y8.h, y8.b
        public void onUDDataReceived(List<TYBookItem> list) {
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
        }
    }
}
