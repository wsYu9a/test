package com.martian.mibook.ui.o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.KeyEventDispatcher;
import com.gyf.barlibrary.ImmersionBar;
import com.martian.ads.ad.AdConfig;
import com.martian.ads.ad.ApiAd;
import com.martian.ads.ad.DefaultAd;
import com.martian.ads.ad.VivoAd;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.AppTaskList;
import com.martian.free.response.TFBook;
import com.martian.free.response.TFChapter;
import com.martian.libfeedback.request.FeedbackInfoParams;
import com.martian.libmars.utils.k0;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.mibook.account.request.book.MiBookGetChapterCommentCountParams;
import com.martian.mibook.activity.base.MiWebViewActivity;
import com.martian.mibook.activity.book.BookInfoActivity;
import com.martian.mibook.activity.book.YWTagsActivity;
import com.martian.mibook.activity.book.comment.WholeCommentActivity;
import com.martian.mibook.activity.reader.ChapterCommentActivity;
import com.martian.mibook.activity.reader.ReadingActivity;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.o0;
import com.martian.mibook.b.b;
import com.martian.mibook.data.book.ChapterCommentCount;
import com.martian.mibook.data.book.Comment;
import com.martian.mibook.data.book.ReadingInfo;
import com.martian.mibook.e.a6;
import com.martian.mibook.e.f5;
import com.martian.mibook.e.g5;
import com.martian.mibook.e.h5;
import com.martian.mibook.e.u5;
import com.martian.mibook.j.v2;
import com.martian.mibook.lib.account.MiUserManager;
import com.martian.mibook.lib.account.e.c;
import com.martian.mibook.lib.account.request.OfflineLinkParams;
import com.martian.mibook.lib.account.request.auth.VideoBonusCompleteParams;
import com.martian.mibook.lib.account.response.ChapterPrice;
import com.martian.mibook.lib.model.data.BookCreative;
import com.martian.mibook.lib.model.data.MiChapter;
import com.martian.mibook.lib.model.data.MiChapterList;
import com.martian.mibook.lib.model.data.MiReadingContent;
import com.martian.mibook.lib.model.data.MiReadingTheme;
import com.martian.mibook.lib.model.data.PageInfo;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterContent;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import com.martian.mibook.lib.original.data.ORBook;
import com.martian.mibook.lib.original.data.ORChapter;
import com.martian.mibook.lib.yuewen.response.YWBook;
import com.martian.mibook.lib.yuewen.response.YWChapter;
import com.martian.mibook.ui.AutoScrollView;
import com.martian.mibook.ui.MyDrawTextView;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.rpauth.MartianRPUserManager;
import com.martian.rpauth.response.MartianRPAccount;
import com.martian.ttbookhd.R;
import com.wbl.ad.yzz.config.CheckNextChapterCallback;
import com.wbl.ad.yzz.config.RewardCallback;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/* loaded from: classes4.dex */
public class i4 extends com.martian.libsliding.e<MiReadingContent.MiContentCursor> {

    /* renamed from: d */
    private static final int f14422d = -1;

    /* renamed from: e */
    private static final int f14423e = -2;

    /* renamed from: f */
    public static final int f14424f = com.martian.libmars.d.h.b(320.0f);

    /* renamed from: g */
    public static final int f14425g = com.martian.libmars.d.h.b(446.0f);

    /* renamed from: h */
    public static final int f14426h = com.martian.libmars.d.h.b(586.0f);

    /* renamed from: i */
    public static final int f14427i = com.martian.libmars.d.h.b(537.0f);

    /* renamed from: j */
    public static final int f14428j = com.martian.libmars.d.h.b(56.0f);
    public static final int k = com.martian.libmars.d.h.b(266.0f);
    public static int l = 0;
    public static int m = 1;
    public static int n = 2;
    public static int o = 4;
    public static int p = 5;
    public static int q = 6;
    public static int r = 8;
    public static int s = 9;
    private final com.martian.mibook.e.p D;
    private boolean E;
    private final ReadingInfo I;
    private final com.martian.mibook.b.b J;
    private final com.martian.mibook.b.b K;
    private int R;
    private final com.martian.mibook.application.h0 V;
    private final CheckNextChapterCallback W;
    private final RewardCallback X;
    private List<TYBookItem> Z;
    private MiBookManager.m0 a0;
    private u b0;
    private Drawable c0;
    private String d0;
    private long i0;
    private boolean j0;
    private AdConfig.AdInfo s0;
    private final com.martian.libmars.activity.j1 t;
    private ChapterList u;
    private boolean u0;
    private final Book v;
    private int w = 0;
    private int x = 0;
    private int y = -1;
    private int z = -1;
    private final Set<y> F = new HashSet();
    private String G = "";
    private int H = 50;
    private boolean L = false;
    private boolean M = false;
    private final int N = MiConfigSingleton.V3().W3().getAdClickOptimizeInterval();
    private long O = System.currentTimeMillis();
    private int P = -1;
    private String Q = "";
    private final Map<String, AppTaskList> S = new Hashtable();
    private final LinkedList<String> T = new LinkedList<>();
    private final List<AppTaskList> U = new ArrayList();
    private int Y = -100;
    private String e0 = "";
    private long f0 = System.currentTimeMillis();
    private boolean g0 = false;
    private boolean h0 = false;
    private int k0 = 0;
    private final Map<String, AppTask> l0 = new Hashtable();
    private final LinkedList<String> m0 = new LinkedList<>();
    private final List<AppTask> n0 = new ArrayList();
    private final int o0 = MiConfigSingleton.V3().W3().getLinkAdWeight().intValue();
    private final int p0 = MiConfigSingleton.V3().W3().getVipAdWeight().intValue();
    private final int q0 = MiConfigSingleton.V3().I4();
    private final Map<String, String> r0 = new HashMap();
    private final Map<String, ChapterCommentCount> t0 = new HashMap();
    private long v0 = -1;
    private MiReadingContent A = new MiReadingContent();
    private MiReadingContent B = new MiReadingContent();
    private MiReadingContent C = new MiReadingContent();

    class a extends b.d.a.k.b {
        a() {
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void e(AdConfig config, boolean verify) {
            i4.this.I2(true);
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void h() {
            i4.this.I2(false);
        }
    }

    class b extends b.d.a.k.b {
        b() {
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void e(AdConfig config, boolean verify) {
            i4.this.I2(verify);
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void h() {
            i4.this.I2(false);
        }
    }

    class c extends b.d.a.k.b {
        c() {
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void e(AdConfig config, boolean verify) {
            i4.this.I2(verify);
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void h() {
            i4.this.I2(false);
        }
    }

    class d extends com.martian.mibook.lib.account.d.q.p0 {
        d(com.martian.libmars.activity.j1 x0) {
            super(x0);
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            if (com.martian.libmars.utils.n0.c(i4.this.t)) {
                return;
            }
            i4.this.t.k1("解锁失败：" + errorResult.d());
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(ChapterPrice chapterPrice) {
            if (com.martian.libmars.utils.n0.c(i4.this.t)) {
                return;
            }
            i4.this.t.k1("解锁成功！");
            i4.this.B.setStartFromFirstPage(true);
            i4 i4Var = i4.this;
            i4Var.q3(i4Var.B);
        }
    }

    class e extends com.martian.mibook.lib.model.d.f {

        /* renamed from: a */
        final /* synthetic */ MiReadingContent f14433a;

        e(final MiReadingContent val$content) {
            this.f14433a = val$content;
        }

        @Override // com.martian.mibook.lib.model.d.f
        public void a(boolean loading) {
        }

        @Override // com.martian.mibook.lib.model.d.f
        public void c(ChapterList chapterList) {
            if ((i4.this.u instanceof MiChapterList) && (chapterList instanceof MiChapterList)) {
                ((MiChapterList) i4.this.u).swapCursor(((MiChapterList) chapterList).getCursor());
            }
            i4.this.q3(this.f14433a);
            i4.this.u();
        }

        @Override // com.martian.mibook.lib.model.d.f
        public void d(b.d.c.b.c errorResult) {
            i4.this.Q2(this.f14433a);
        }
    }

    class f implements com.martian.mibook.lib.model.d.b {

        /* renamed from: a */
        final /* synthetic */ TYBookItem f14435a;

        f(final TYBookItem val$tyBookItem) {
            this.f14435a = val$tyBookItem;
        }

        @Override // com.martian.mibook.lib.model.d.b
        public void a(Book book) {
            if (book == null) {
                i4.this.t.k1("加入失败，请重试");
                return;
            }
            MiConfigSingleton.V3().l3().d(i4.this.t, book.buildMibook(), book);
            i4.this.t.k1("已加入书架");
            MiConfigSingleton.V3().l3().I1(3, book.getSourceName(), book.getSourceId(), this.f14435a.getRecommendId(), this.f14435a.getRecommend(), "广告加书架");
        }

        @Override // com.martian.mibook.lib.model.d.b
        public void onLoading(boolean loading) {
        }

        @Override // com.martian.mibook.lib.model.d.b
        public void onResultError(b.d.c.b.c errorResult) {
            i4.this.t.k1("加入失败，请重试");
        }
    }

    class g extends b.d.a.k.b {
        g() {
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void d(AdConfig config, AppTaskList appTaskList) {
            i4.this.n0.add(appTaskList.getApps().get(0));
        }
    }

    class h implements v2.b0 {

        /* renamed from: a */
        final /* synthetic */ String f14438a;

        h(final String val$chapterId) {
            this.f14438a = val$chapterId;
        }

        @Override // com.martian.mibook.j.v2.b0
        public void a(String tag, String comment) {
            i4.this.r0.put(tag, comment);
        }

        @Override // com.martian.mibook.j.v2.b0
        public void b(Comment comment) {
            com.martian.mibook.lib.model.g.b.E(i4.this.t, "发表章评-阅读页");
            ChapterCommentCount chapterCommentCount = (ChapterCommentCount) i4.this.t0.get(this.f14438a);
            if (chapterCommentCount == null) {
                chapterCommentCount = new ChapterCommentCount();
                chapterCommentCount.setChapterId(this.f14438a);
                chapterCommentCount.setNComments(1);
                chapterCommentCount.addComment(comment);
            } else {
                chapterCommentCount.incrNComments();
                chapterCommentCount.addComment(comment);
            }
            i4.this.V(chapterCommentCount);
        }
    }

    class i extends com.martian.mibook.lib.account.d.g<MiBookGetChapterCommentCountParams, ChapterCommentCount> {

        /* renamed from: g */
        final /* synthetic */ String f14440g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(Class x0, Class x1, Context x2, final String val$chapterId) {
            super(x0, x1, x2);
            this.f14440g = val$chapterId;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            i4.this.u0 = false;
        }

        @Override // b.d.c.c.i, b.d.c.c.c
        public void onUDDataReceived(final List<ChapterCommentCount> chapterCommentCounts) {
            i4.this.u0 = false;
            if (chapterCommentCounts == null) {
                return;
            }
            if (i4.this.t0.size() > 20) {
                i4.this.t0.clear();
            }
            for (ChapterCommentCount chapterCommentCount : chapterCommentCounts) {
                i4.this.t0.put(chapterCommentCount.getChapterId(), chapterCommentCount);
                if (this.f14440g.equalsIgnoreCase(chapterCommentCount.getChapterId())) {
                    i4.this.u();
                }
            }
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    class j implements CheckNextChapterCallback {
        j() {
        }

        @Override // com.wbl.ad.yzz.config.CheckNextChapterCallback
        public void checkFailed(int i2, String s) {
            i4.this.P2();
        }

        @Override // com.wbl.ad.yzz.config.CheckNextChapterCallback
        public void checkResult(boolean show) {
            if (!show) {
                i4.this.P2();
            } else {
                i4 i4Var = i4.this;
                i4Var.Y = i4Var.v0() + 1;
            }
        }
    }

    class k implements RewardCallback {

        /* renamed from: a */
        final /* synthetic */ ReadingActivity f14443a;

        k(final ReadingActivity val$activity) {
            this.f14443a = val$activity;
        }

        @Override // com.wbl.ad.yzz.config.RewardCallback
        public void onRewardResult(long l) {
            com.martian.mibook.lib.model.g.b.l0(this.f14443a, "阅读页-免广告-" + l + "分钟");
            i4.this.I0((int) l);
        }

        @Override // com.wbl.ad.yzz.config.RewardCallback
        public void openPageFail(int i2, String s) {
            com.martian.mibook.lib.model.g.b.l0(this.f14443a, "阅读页-启动失败");
        }

        @Override // com.wbl.ad.yzz.config.RewardCallback
        public void openPageSuccess() {
            com.martian.mibook.lib.model.g.b.l0(this.f14443a, "阅读页-启动成功");
        }

        @Override // com.wbl.ad.yzz.config.RewardCallback
        public void pageExit() {
        }
    }

    class l extends b.d.a.k.b {
        l() {
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void j(AdConfig config) {
            i4.this.C2(config.getAdTag());
        }
    }

    class m extends com.martian.mibook.lib.model.d.h {

        /* renamed from: a */
        final /* synthetic */ View f14446a;

        /* renamed from: b */
        final /* synthetic */ boolean f14447b;

        m(final View val$fromSlide, final boolean val$lastPageView) {
            this.f14446a = val$fromSlide;
            this.f14447b = val$lastPageView;
        }

        @Override // com.martian.mibook.lib.model.d.h
        public void a(boolean loading) {
        }

        @Override // com.martian.mibook.lib.model.d.h
        public void c(List<TYBookItem> books) {
            i4.this.G2(books, this.f14446a, this.f14447b);
        }

        @Override // com.martian.mibook.lib.model.d.h
        public void d(b.d.c.b.c errorResult) {
            i4.this.G2(null, this.f14446a, this.f14447b);
        }
    }

    class n implements v2.b0 {
        n() {
        }

        @Override // com.martian.mibook.j.v2.b0
        public void a(String tag, String comment) {
            i4.this.e0 = comment;
        }

        @Override // com.martian.mibook.j.v2.b0
        public void b(Comment comment) {
            com.martian.mibook.lib.model.g.b.V(i4.this.t, "写评论-最后一页-成功");
            i4.this.r3(true);
        }
    }

    class o implements View.OnTouchListener {

        /* renamed from: a */
        int f14450a;

        /* renamed from: b */
        int f14451b;

        o() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v, MotionEvent event) {
            int y = (int) event.getY();
            int x = (int) event.getX();
            int action = event.getAction();
            if (action == 0) {
                this.f14451b = y;
                this.f14450a = x;
                return false;
            }
            if (action != 1 || Math.abs(y - this.f14451b) >= 5 || Math.abs(x - this.f14450a) >= 5) {
                return false;
            }
            ((ReadingActivity) i4.this.t).C7();
            return false;
        }
    }

    class p implements MiBookManager.g0 {
        p() {
        }

        @Override // com.martian.mibook.application.MiBookManager.g0
        public void a(b.d.c.b.c errorResult) {
            i4.this.g0 = false;
        }

        @Override // com.martian.mibook.application.MiBookManager.g0
        public void b(ReadingInfo info) {
            i4.this.g0 = false;
            if (com.martian.libmars.utils.n0.c(i4.this.t)) {
                return;
            }
            i4.this.I.setNComments(info.getNComments());
            i4.this.I.setReadingCount(info.getReadingCount());
            i4.this.I.setClickCount(info.getClickCount());
            i4.this.I.setScore(info.getScore());
            i4.this.I.setIntro(info.getIntro());
            i4.this.I.setTagList(info.getTagList());
            i4.this.u();
        }

        @Override // com.martian.mibook.application.MiBookManager.g0
        public void onLoading(boolean show) {
        }
    }

    class q extends com.martian.libfeedback.b.b {

        /* renamed from: h */
        final /* synthetic */ boolean f14454h;

        q(final boolean val$manual) {
            this.f14454h = val$manual;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            if (this.f14454h) {
                i4.this.t.k1(errorResult.d());
            }
        }

        @Override // b.d.c.c.b
        /* renamed from: q */
        public void onDataReceived(Integer id) {
            if (this.f14454h) {
                i4.this.t.k1("上报成功");
            }
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    class r implements com.martian.mibook.lib.model.d.c {

        /* renamed from: a */
        final /* synthetic */ MiReadingContent f14456a;

        class a implements c.e {
            a() {
            }

            @Override // com.martian.mibook.lib.account.e.c.e
            public void a(b.d.c.b.c errorResult) {
                i4.this.u();
            }

            @Override // com.martian.mibook.lib.account.e.c.e
            public void b(MartianRPAccount rpAccount) {
                i4.this.u();
            }
        }

        r(final MiReadingContent val$content) {
            this.f14456a = val$content;
        }

        @Override // com.martian.mibook.lib.model.d.c
        public void a() {
            i4.this.Q2(this.f14456a);
            i4.this.u();
            com.martian.mibook.lib.model.g.b.V(i4.this.t, "充值书币");
            com.martian.mibook.j.s2.m0(i4.this.t);
        }

        @Override // com.martian.mibook.lib.model.d.c
        public void b(int nChapters, int totalCoins) {
            com.martian.mibook.lib.account.e.c.j(-totalCoins);
            this.f14456a.setStartFromFirstPage(true);
            i4.this.x2(this.f14456a);
            if (nChapters > 1 && i4.this.C != null) {
                i4 i4Var = i4.this;
                i4Var.q3(i4Var.C);
            }
            MiConfigSingleton.V3().l3().J1(MiBookManager.K, i4.this.v.getSourceName(), i4.this.v.getSourceId(), i4.this.I.getRecommendId(), i4.this.I.getRecommend(), "章节购买", totalCoins, i4.this.v0(), "", false);
        }

        @Override // com.martian.mibook.lib.model.d.c
        public void c() {
        }

        @Override // com.martian.mibook.lib.model.d.c
        public void d(String errMsg) {
            if (this.f14456a == i4.this.B && !com.martian.libsupport.k.p(errMsg)) {
                i4.this.t.k1(errMsg);
            }
            i4.this.Q2(this.f14456a);
            i4.this.u();
        }

        @Override // com.martian.mibook.lib.model.d.c
        public void e(int missionType) {
            if (missionType == 0) {
                i4.this.t.k1("视频加载中...");
                i4.this.v2(i4.q);
            }
        }

        @Override // com.martian.mibook.lib.model.d.c
        public void f() {
            i4.this.Q2(this.f14456a);
            com.martian.mibook.lib.account.e.c.k(i4.this.t, new a());
        }
    }

    static class s {

        /* renamed from: a */
        ImageView f14459a;

        /* renamed from: b */
        ImageView f14460b;

        /* renamed from: c */
        TextView f14461c;

        /* renamed from: d */
        TextView f14462d;

        /* renamed from: e */
        TextView f14463e;

        /* renamed from: f */
        ScrollView f14464f;

        /* renamed from: g */
        ImageView f14465g;

        /* renamed from: h */
        LinearLayout f14466h;

        /* renamed from: i */
        LinearLayout f14467i;

        /* renamed from: j */
        LinearLayout f14468j;
        LinearLayout k;
        TextView l;
        TextView m;
        TextView n;
        ImageView o;
        TextView p;
        TextView q;
        TextView r;
        TextView s;
        TextView t;
        RelativeLayout u;
        TextView v;
        TextView w;
        TextView x;
        TextView y;

        s() {
        }
    }

    static class t {

        /* renamed from: a */
        TextView f14469a;

        /* renamed from: b */
        TextView f14470b;

        /* renamed from: c */
        View f14471c;

        /* renamed from: d */
        ProgressBar f14472d;

        /* renamed from: e */
        ImageView f14473e;

        /* renamed from: f */
        LinearLayout f14474f;

        /* renamed from: g */
        LinearLayout f14475g;

        /* renamed from: h */
        LinearLayout f14476h;

        /* renamed from: i */
        RelativeLayout f14477i;

        /* renamed from: j */
        LinearLayout f14478j;
        TextView k;
        TextView l;
        View m;
        ImageView n;
        ImageView o;
        ImageView p;
        TextView q;
        TextView r;
        LinearLayout s;

        t() {
        }
    }

    public interface u {
        void a(boolean hide);

        void b(boolean hide);
    }

    class v implements com.martian.mibook.lib.model.d.e {

        /* renamed from: a */
        private final MiReadingContent f14479a;

        public v(MiReadingContent content) {
            this.f14479a = content;
        }

        @Override // com.martian.mibook.lib.model.d.e
        public void a(Chapter chapter, String shortContent) {
            if (com.martian.libmars.utils.n0.c(i4.this.t)) {
                return;
            }
            this.f14479a.setChapter(chapter);
            if (!com.martian.libsupport.k.p(shortContent)) {
                this.f14479a.setShortContent(shortContent);
            }
            this.f14479a.setUnBounght();
            if (this.f14479a == i4.this.B || this.f14479a == i4.this.C) {
                i4.this.s3(this.f14479a);
            }
            i4.this.u();
        }

        @Override // com.martian.mibook.lib.model.d.e
        public void b(ChapterContent chapterContent) {
        }

        @Override // com.martian.mibook.lib.model.d.e
        public void c(ChapterContent chapterContent) {
            if (com.martian.libmars.utils.n0.c(i4.this.t)) {
                return;
            }
            if (chapterContent != null) {
                this.f14479a.setTitle(chapterContent.getTitle());
            }
            this.f14479a.setChapterContent(chapterContent);
            i4.this.u2(this.f14479a);
        }

        @Override // com.martian.mibook.lib.model.d.e
        public void onLoading(boolean loading) {
            if (loading) {
                this.f14479a.setLoading();
            }
        }

        @Override // com.martian.mibook.lib.model.d.e
        public void onResultError(b.d.c.b.c errorResult) {
            if (com.martian.libmars.utils.n0.c(i4.this.t)) {
                return;
            }
            this.f14479a.setError();
            this.f14479a.setErrCode(Integer.valueOf(errorResult.c()));
            this.f14479a.setErrMsg(errorResult.d());
            this.f14479a.setStackTrace(errorResult.e());
            i4.this.u();
        }
    }

    /* loaded from: classes.dex */
    public interface w {
        void a0();

        void dismissDialog();

        void f0();

        void h0();

        void l0();

        void m0();
    }

    public interface x {

        /* renamed from: a */
        public static final int f14481a = 0;

        /* renamed from: b */
        public static final int f14482b = 1;

        /* renamed from: c */
        public static final int f14483c = 2;
    }

    static class y {
        CircleImageView A;
        TextView B;
        TextView C;

        /* renamed from: a */
        View f14484a;

        /* renamed from: b */
        View f14485b;

        /* renamed from: c */
        View f14486c;

        /* renamed from: d */
        View f14487d;

        /* renamed from: e */
        View f14488e;

        /* renamed from: f */
        MyDrawTextView f14489f;

        /* renamed from: g */
        TextView f14490g;

        /* renamed from: h */
        LinearLayout f14491h;

        /* renamed from: i */
        View f14492i;

        /* renamed from: j */
        View f14493j;
        View k;
        ImageView l;
        ProgressBar m;
        TextView n;
        TextView o;
        TextView p;
        ViewGroup q;
        LinearLayout r;
        LinearLayout s;
        TextView t;
        View u;
        View v;
        RoundedLayout w;
        LinearLayout x;
        LinearLayout y;
        TextView z;

        y() {
        }
    }

    public i4(Book book, ChapterList chapterList, ReadingActivity activity, com.martian.mibook.e.p readingBinding, ReadingInfo readingInfo) {
        this.v = book;
        this.u = chapterList;
        this.t = activity;
        this.I = readingInfo;
        com.martian.mibook.application.h0 h0Var = new com.martian.mibook.application.h0(activity);
        this.V = h0Var;
        h0Var.u(MiConfigSingleton.V3().l3().j2(book));
        this.W = new j();
        this.X = new k(activity);
        com.martian.mibook.b.b bVar = new com.martian.mibook.b.b(activity, com.martian.mibook.b.b.y, b.d.a.j.b.f4370c);
        this.J = bVar;
        bVar.T0(new l());
        this.K = new com.martian.mibook.b.b(activity, com.martian.mibook.b.b.z, b.d.a.j.b.l);
        this.D = readingBinding;
    }

    /* renamed from: A1 */
    public /* synthetic */ void B1(final t lastViewHolder, final View lastPageView, View v2) {
        lastViewHolder.f14472d.setVisibility(0);
        lastViewHolder.f14473e.setVisibility(8);
        y2(false, lastPageView);
    }

    private int B0() {
        Book book = this.v;
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

    private AppTask C0(String tag) {
        if (this.l0.containsKey(tag)) {
            return this.l0.get(tag);
        }
        if (this.m0.size() >= 2) {
            com.martian.mibook.application.g0.p(this.l0.remove(this.m0.removeFirst()));
        }
        AppTask appTask = null;
        if (this.n0.isEmpty()) {
            w2();
        }
        if (!this.n0.isEmpty()) {
            appTask = this.n0.remove(0);
            appTask.setAdTag(tag);
            this.l0.put(tag, appTask);
            this.m0.add(tag);
        }
        if (this.n0.isEmpty()) {
            w2();
        }
        return appTask;
    }

    /* renamed from: C1 */
    public /* synthetic */ void D1(View v2) {
        com.martian.mibook.j.v2.Y0(this.t);
    }

    public void C2(String adTag) {
        if (com.martian.libsupport.k.p(this.Q) || !this.Q.equalsIgnoreCase(adTag)) {
            return;
        }
        this.Q = "";
        com.martian.mibook.lib.model.g.b.J(this.t, "点击引导-信息流-点击-新");
        I0(5);
    }

    private String D0() {
        if (this.I.getNComments().intValue() < 10000) {
            return this.I.getNComments() + "";
        }
        return (this.I.getNComments().intValue() / 10000) + "万+";
    }

    private void D2(ChapterCommentCount commentCount, String chapterId, String chapterName) {
        if (commentCount == null || commentCount.getNComments() <= 0) {
            com.martian.mibook.j.v2.Z0(this.t, this.v.getSourceName(), this.v.getSourceId(), chapterId, chapterName, this.r0.get(chapterId), new h(chapterId));
        } else {
            ChapterCommentActivity.K2(this.t, this.v.getSourceName(), this.v.getSourceId(), chapterId, chapterName, commentCount);
        }
    }

    /* renamed from: E1 */
    public /* synthetic */ void F1(final t lastViewHolder, final View lastPageView, View v2) {
        lastViewHolder.f14472d.setVisibility(0);
        lastViewHolder.f14473e.setVisibility(8);
        y2(false, lastPageView);
    }

    private synchronized void E2(MiReadingContent content) {
        if (com.martian.libmars.utils.n0.c(this.t)) {
            return;
        }
        ChapterList chapterList = this.u;
        if (chapterList != null && chapterList.getCount() > 0) {
            if (content.isLoading()) {
                content.setReady();
                if (content == this.B) {
                    int i2 = this.y;
                    if (i2 >= 0) {
                        if (this.z > 0) {
                            this.x = content.findContentIndex((i2 * content.getChapterContent().getContentLength()) / this.z);
                        } else {
                            this.x = content.findContentIndex(i2);
                        }
                        this.y = -1;
                    }
                    if (this.x >= content.getEndPosSize()) {
                        this.x = content.getEndPosSize() - 1;
                    }
                    int i3 = this.x;
                    if (i3 == -2) {
                        this.x = 0;
                    } else if (i3 == -1) {
                        if (!content.isStartFromFirstPage() && !O0()) {
                            this.x = content.getEndPosSize() - 1;
                        }
                        this.x = 0;
                        content.setStartFromFirstPage(false);
                    }
                    u();
                }
            }
        }
    }

    /* renamed from: G1 */
    public /* synthetic */ void H1(final t lastViewHolder, final View lastPageView, View v2) {
        lastViewHolder.f14472d.setVisibility(0);
        lastViewHolder.f14473e.setVisibility(8);
        y2(false, lastPageView);
    }

    /* renamed from: I1 */
    public /* synthetic */ void J1(View v2) {
        if (this.I.getNComments() == null || this.I.getNComments().intValue() > 0) {
            o3();
            return;
        }
        com.martian.mibook.lib.model.g.b.V(this.t, "写评论-最后一页");
        BookInfoActivity.o A = this.I.toBookInfo().A(false);
        Book book = this.v;
        if (book != null) {
            A.H(book.getSourceId()).I(this.v.getSourceName()).u(this.v.getBookName()).s(this.v.getAuthor());
        }
        com.martian.mibook.j.v2.a1(this.t, A, 100, this.e0, new n());
    }

    private void J0(boolean hide) {
        u uVar;
        if (this.M == hide || (uVar = this.b0) == null) {
            return;
        }
        this.M = hide;
        uVar.b(hide);
    }

    private void J2(b.d readingAdConfig, AppTaskList appTaskList) {
        if (MiConfigSingleton.V3().E5()) {
            return;
        }
        if (appTaskList.getApps().size() == 2) {
            int e2 = readingAdConfig.e();
            int i2 = f14426h;
            if (e2 > i2) {
                readingAdConfig.i(i2);
                readingAdConfig.k(R.layout.reading_ads_item_large);
                return;
            }
        }
        if (appTaskList.getApps().size() > 2) {
            int e3 = readingAdConfig.e();
            int i3 = f14427i;
            if (e3 > i3) {
                readingAdConfig.i(i3);
                readingAdConfig.k(R.layout.reading_ads_item_large);
                return;
            }
        }
        int i4 = 0;
        AppTask appTask = appTaskList.getApps().get(0);
        if (appTaskList.getApps().size() > 1) {
            Iterator<AppTask> it = appTaskList.getApps().iterator();
            while (it.hasNext()) {
                AppTask next = it.next();
                if (i4 > 0) {
                    com.martian.mibook.application.g0.I(appTask.getEcpm(), next);
                    it.remove();
                }
                i4++;
            }
        }
        if (appTask.isPortraitAd()) {
            if (appTask.isReadingVideoAd()) {
                readingAdConfig.i(Math.min(readingAdConfig.d() + k, readingAdConfig.e()));
                return;
            }
            readingAdConfig.p(true);
            readingAdConfig.k(R.layout.reading_ads_item_fullscreen_portrait);
            int d2 = (readingAdConfig.d() * appTask.getPicHeight()) / appTask.getPicWidth();
            int i5 = f14428j;
            int i6 = d2 + i5;
            if (i6 <= readingAdConfig.e()) {
                readingAdConfig.i(i6);
                return;
            } else {
                readingAdConfig.i(readingAdConfig.e());
                readingAdConfig.l(((readingAdConfig.a() - i5) * appTask.getPicWidth()) / appTask.getPicHeight());
                return;
            }
        }
        if (!MiBookManager.B2(appTask)) {
            if (appTask.isHorizontalAd()) {
                readingAdConfig.i(Math.min(((readingAdConfig.d() * appTask.getPicHeight()) / appTask.getPicWidth()) + k, readingAdConfig.e()));
            }
        } else {
            if (!appTask.isCoverView()) {
                readingAdConfig.i(readingAdConfig.e() - f14428j);
                return;
            }
            int d3 = (readingAdConfig.d() * 16) / 9;
            int i7 = f14428j;
            int i8 = d3 + i7;
            if (i8 <= readingAdConfig.e()) {
                readingAdConfig.i(i8);
            } else {
                readingAdConfig.i(readingAdConfig.e());
                readingAdConfig.l(((readingAdConfig.a() - i7) * 9) / 16);
            }
        }
    }

    private void K0(boolean hide) {
        u uVar;
        if (this.L == hide || (uVar = this.b0) == null) {
            return;
        }
        this.L = hide;
        uVar.a(hide);
    }

    /* renamed from: K1 */
    public /* synthetic */ void L1(final String reportMsg) {
        o0(reportMsg, true);
    }

    private void K2() {
        if (!this.C.isEmpty() || this.w + 1 >= w0()) {
            return;
        }
        this.C.setChapterIndex(this.w + 1);
        this.C.setChapter(t0(this.w + 1));
        q3(this.C);
    }

    private void L0(final View lastPageView, final t lastViewHolder) {
        if (this.t != null && MiConfigSingleton.V3().M5() && lastViewHolder.f14477i != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, this.t.F1() - com.martian.libmars.d.h.b(14.0f), 0, 0);
            lastViewHolder.f14477i.setLayoutParams(layoutParams);
        }
        if (O0()) {
            lastViewHolder.o.setVisibility(8);
        }
        lastViewHolder.f14475g.setVisibility(8);
        lastViewHolder.f14469a.setVisibility(0);
        lastViewHolder.m.setVisibility(8);
        boolean G5 = MiConfigSingleton.V3().G5();
        com.martian.libmars.activity.j1 j1Var = this.t;
        if (j1Var != null) {
            lastViewHolder.l.setText(j1Var.getString(G5 ? R.string.book_offline_payment : R.string.book_offline_free));
            lastViewHolder.k.setText(this.t.getString(R.string.book_offline));
            lastViewHolder.f14469a.setText(this.t.getString(R.string.book_offline_button));
        }
        lastViewHolder.f14469a.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.x1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i4.this.x1(view);
            }
        });
        lastViewHolder.f14470b.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.k2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i4.this.z1(lastViewHolder, lastPageView, view);
            }
        });
        lastViewHolder.f14473e.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.z1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i4.this.B1(lastViewHolder, lastPageView, view);
            }
        });
    }

    private void M0(final View lastPageView, final t lastViewHolder) {
        if (this.t != null && MiConfigSingleton.V3().M5() && lastViewHolder.f14477i != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, this.t.F1() - com.martian.libmars.d.h.b(8.0f), 0, 0);
            lastViewHolder.f14477i.setLayoutParams(layoutParams);
        }
        if (O0()) {
            lastViewHolder.o.setVisibility(8);
        }
        lastViewHolder.m.setVisibility(8);
        lastViewHolder.f14474f.setVisibility(0);
        if (lastViewHolder.k != null && lastViewHolder.l != null) {
            Book book = this.v;
            if (book == null || !(Book.STATUS_FINISHED.equalsIgnoreCase(book.getStatus()) || this.v.isLocal())) {
                TextView textView = lastViewHolder.k;
                com.martian.libmars.activity.j1 j1Var = this.t;
                textView.setText(j1Var == null ? "作者努力更新中" : j1Var.getString(R.string.reading_update));
                TextView textView2 = lastViewHolder.l;
                com.martian.libmars.activity.j1 j1Var2 = this.t;
                textView2.setText(j1Var2 == null ? "后续更精彩，明天再来看看吧" : j1Var2.getString(R.string.reading_update_desc));
                if (!com.martian.libsupport.f.d(this.t)) {
                    if (!o()) {
                        com.martian.mibook.lib.model.g.b.P(this.t, "未完待续:曝光");
                    }
                    lastViewHolder.m.setVisibility(0);
                    lastViewHolder.m.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.t2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            i4.this.D1(view);
                        }
                    });
                }
            } else {
                TextView textView3 = lastViewHolder.k;
                com.martian.libmars.activity.j1 j1Var3 = this.t;
                textView3.setText(j1Var3 == null ? "全本完" : j1Var3.getString(R.string.reading_finish));
                TextView textView4 = lastViewHolder.l;
                com.martian.libmars.activity.j1 j1Var4 = this.t;
                textView4.setText(j1Var4 == null ? "快去和书友分享阅读乐趣吧" : j1Var4.getString(R.string.reading_finish_desc));
                if (this.v.isLocal()) {
                    lastViewHolder.f14474f.setVisibility(8);
                }
            }
        }
        lastViewHolder.f14470b.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.j1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i4.this.F1(lastViewHolder, lastPageView, view);
            }
        });
        lastViewHolder.f14473e.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.i1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i4.this.H1(lastViewHolder, lastPageView, view);
            }
        });
        lastViewHolder.p.setImageResource(R.drawable.read_icon_book_comment);
        lastViewHolder.q.setVisibility(8);
        TextView textView5 = lastViewHolder.r;
        com.martian.libmars.activity.j1 j1Var5 = this.t;
        textView5.setText(j1Var5 == null ? "" : j1Var5.getString(R.string.reader_comment_empty_desc));
        ReadingInfo readingInfo = this.I;
        if (readingInfo == null) {
            return;
        }
        if (readingInfo.getNComments() == null) {
            r3(false);
            return;
        }
        if (!MiConfigSingleton.V3().D8()) {
            lastViewHolder.f14474f.setVisibility(8);
            return;
        }
        if (this.I.getNComments().intValue() > 0) {
            lastViewHolder.p.setImageResource(R.drawable.read_icon_book_comment_num);
            lastViewHolder.q.setVisibility(0);
            lastViewHolder.q.setText(D0());
            TextView textView6 = lastViewHolder.r;
            com.martian.libmars.activity.j1 j1Var6 = this.t;
            textView6.setText(j1Var6 != null ? j1Var6.getString(R.string.all_comments) : "");
        }
        lastViewHolder.s.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.m1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i4.this.J1(view);
            }
        });
    }

    /* renamed from: M1 */
    public /* synthetic */ void N1(final TYBookItem tyBookItem, View v2) {
        com.martian.mibook.j.s2.h0(this.t, tyBookItem);
    }

    private boolean O0() {
        return this.E;
    }

    /* renamed from: O1 */
    public /* synthetic */ void P1(final TYBookItem tyBookItem, View v2) {
        com.martian.mibook.j.s2.h0(this.t, tyBookItem);
    }

    /* renamed from: Q1 */
    public /* synthetic */ void R1(final boolean success) {
        if (!success) {
            this.t.k1("视频观看失败");
            if (this.I.isVideoAdWatched()) {
                this.I.setVideoAdWatched(false);
                return;
            }
            return;
        }
        this.t.k1("观看成功！");
        int i2 = this.k0;
        if (i2 == m) {
            ((w) this.t).a0();
            return;
        }
        if (i2 == n) {
            ((w) this.t).m0();
            return;
        }
        if (i2 == q) {
            B3();
            return;
        }
        if (i2 == r) {
            U();
        } else if (i2 == s) {
            ((w) this.t).h0();
        } else {
            ((w) this.t).f0();
        }
    }

    public void Q2(MiReadingContent content) {
        if (this.B == content) {
            content.setBuyingError();
        } else {
            content.setPrebuyError();
        }
    }

    /* renamed from: R0 */
    public /* synthetic */ void S0(final TYBookItem tyBookItem, final f5 readingAdsItemBookBinding, View v2) {
        String deeplink = tyBookItem.getDeeplink();
        if (!com.martian.libsupport.k.p(deeplink) && com.martian.apptask.g.g.b(this.t, deeplink)) {
            com.martian.mibook.lib.model.g.b.w(this.t, "书籍-deeplink");
            com.martian.apptask.g.g.u(this.t, deeplink, "", "其他应用", false);
            return;
        }
        com.martian.mibook.lib.model.g.b.w(this.t, "书籍-加入书架");
        W(tyBookItem);
        readingAdsItemBookBinding.f11953b.setText("已在书架");
        readingAdsItemBookBinding.f11953b.setEnabled(false);
        readingAdsItemBookBinding.f11953b.setBackgroundResource(R.drawable.border_button_bonus_mission_item_checked);
    }

    /* renamed from: S1 */
    public /* synthetic */ void T1(View v2) {
        if (MiConfigSingleton.V3().l2(this.t, 1019)) {
            this.t.k1("视频加载中...");
            v2(r);
        }
    }

    /* renamed from: T0 */
    public /* synthetic */ void U0(final TYBookItem tyBookItem, View v2) {
        String deeplink = tyBookItem.getDeeplink();
        if (com.martian.libsupport.k.p(deeplink) || !com.martian.apptask.g.g.b(this.t, deeplink)) {
            com.martian.mibook.lib.model.g.b.w(this.t, "书籍-阅读");
            com.martian.mibook.j.s2.h0(this.t, tyBookItem);
        } else {
            com.martian.mibook.lib.model.g.b.w(this.t, "书籍-deeplink");
            com.martian.apptask.g.g.u(this.t, deeplink, "", "其他应用", false);
        }
    }

    private void U() {
        if (MiConfigSingleton.V3().W3().getAdChapterMinutes().intValue() <= 0) {
            MiConfigSingleton.V3().D0(this.v.getSourceString());
        } else {
            MiConfigSingleton.V3().d7(MartianRPUserManager.t());
        }
        u();
    }

    /* renamed from: U1 */
    public /* synthetic */ void V1(View v2) {
        com.martian.libmars.activity.j1 j1Var = this.t;
        Book book = this.v;
        String sourceName = book == null ? "" : book.getSourceName();
        Book book2 = this.v;
        com.martian.mibook.j.s2.q0(j1Var, "解锁章节", true, sourceName, book2 != null ? book2.getSourceId() : "");
    }

    /* renamed from: V0 */
    public /* synthetic */ void W0(final TYBookItem tyBookItem, View view) {
        String deeplink = tyBookItem.getDeeplink();
        if (com.martian.libsupport.k.p(deeplink) || !com.martian.apptask.g.g.b(this.t, deeplink)) {
            com.martian.mibook.lib.model.g.b.w(this.t, "书籍-阅读");
            com.martian.mibook.j.s2.h0(this.t, tyBookItem);
        } else {
            com.martian.mibook.lib.model.g.b.w(this.t, "书籍-deeplink");
            com.martian.apptask.g.g.u(this.t, deeplink, "", "其他应用", false);
        }
    }

    /* renamed from: W1 */
    public /* synthetic */ void X1(final String tag1, View v2) {
        com.martian.mibook.lib.model.g.b.V(this.t, "标签-点击");
        YWTagsActivity.r2(this.t, tag1, B0(), com.martian.mibook.f.f4.j0.x);
    }

    private void X(MiReadingContent content, int position) {
        MiConfigSingleton.V3().l3().n(this.v, this.u, position, new v(content));
    }

    /* renamed from: X0 */
    public /* synthetic */ void Y0(final TYBookItem tyBookItem, final g5 readingAdsItemBookBinding, View v2) {
        String deeplink = tyBookItem.getDeeplink();
        if (!com.martian.libsupport.k.p(deeplink) && com.martian.apptask.g.g.b(this.t, deeplink)) {
            com.martian.mibook.lib.model.g.b.w(this.t, "信息流大图-deeplink");
            com.martian.apptask.g.g.u(this.t, deeplink, "", "其他应用", false);
            return;
        }
        com.martian.mibook.lib.model.g.b.w(this.t, "信息流大图-加入书架");
        W(tyBookItem);
        readingAdsItemBookBinding.f12010b.setText("已在书架");
        readingAdsItemBookBinding.f12010b.setEnabled(false);
        readingAdsItemBookBinding.f12010b.setBackgroundResource(R.drawable.border_button_bonus_mission_item_checked);
    }

    @SuppressLint({"SetTextI18n"})
    private void Y(View adView, final TYBookItem tyBookItem) {
        final f5 a2 = f5.a(adView);
        a2.f11959h.setText(tyBookItem.getBookName());
        a2.f11954c.setText(tyBookItem.getAuthor());
        a2.f11958g.setText(tyBookItem.getTagInfo());
        if (tyBookItem.getScore() > 0) {
            a2.l.setVisibility(0);
            a2.k.setText(String.format(Locale.CHINA, "%.1f", Float.valueOf(tyBookItem.getScore() / 10.0f)));
        } else {
            a2.l.setVisibility(8);
        }
        if (com.martian.libsupport.k.p(tyBookItem.getRankDesc())) {
            a2.f11960i.setVisibility(4);
        } else {
            a2.f11960i.setVisibility(0);
            a2.f11960i.setText(tyBookItem.getRankDesc());
        }
        a2.f11955d.setText(tyBookItem.getIntro());
        a2.f11961j.setText("“" + tyBookItem.getRecTitle() + "”");
        MiBookManager.d2(this.t, tyBookItem, a2.f11957f);
        if (com.martian.libsupport.k.p(tyBookItem.getDeeplink())) {
            a2.f11953b.setText(this.t.getString(R.string.add_to_book_store));
        } else {
            a2.f11953b.setText(this.t.getString(R.string.free_read));
        }
        a2.f11953b.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.c2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i4.this.S0(tyBookItem, a2, view);
            }
        });
        a2.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.g1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i4.this.U0(tyBookItem, view);
            }
        });
        a2.f11955d.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.p2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i4.this.W0(tyBookItem, view);
            }
        });
    }

    /* renamed from: Y1 */
    public /* synthetic */ void Z1(final String tag2, View v2) {
        com.martian.mibook.lib.model.g.b.V(this.t, "标签-点击");
        YWTagsActivity.r2(this.t, tag2, B0(), com.martian.mibook.f.f4.j0.x);
    }

    private void Y2(TextView scrollTextView, TextView overlapTextView, String content) {
        if (!O0()) {
            scrollTextView.setText(content);
        } else if (overlapTextView != null) {
            overlapTextView.setText(content);
        }
    }

    @SuppressLint({"SetTextI18n"})
    private void Z(View adView, final TYBookItem tyBookItem) {
        final g5 a2 = g5.a(adView);
        a2.f12014f.setText(tyBookItem.getBookName());
        a2.f12011c.setText(tyBookItem.getAuthor());
        a2.f12013e.setText(tyBookItem.getTagInfo());
        if (tyBookItem.getScore() > 0) {
            a2.f12018j.setVisibility(0);
            a2.f12017i.setText(String.format(Locale.CHINA, "%.1f", Float.valueOf(tyBookItem.getScore() / 10.0f)));
        } else {
            a2.f12018j.setVisibility(8);
        }
        if (com.martian.libsupport.k.p(tyBookItem.getRankDesc())) {
            a2.f12015g.setVisibility(4);
        } else {
            a2.f12015g.setVisibility(0);
            a2.f12015g.setText(tyBookItem.getRankDesc());
        }
        a2.f12016h.setText("“" + tyBookItem.getRecTitle() + "”");
        MiBookManager.d2(this.t, tyBookItem, a2.f12012d);
        if (com.martian.libsupport.k.p(tyBookItem.getDeeplink())) {
            a2.f12010b.setText(this.t.getString(R.string.add_to_book_store));
        } else {
            a2.f12010b.setText(this.t.getString(R.string.free_read));
        }
        a2.f12010b.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.t1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i4.this.Y0(tyBookItem, a2, view);
            }
        });
        a2.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.g2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i4.this.a1(tyBookItem, view);
            }
        });
    }

    /* renamed from: Z0 */
    public /* synthetic */ void a1(final TYBookItem tyBookItem, View v2) {
        String deeplink = tyBookItem.getDeeplink();
        if (com.martian.libsupport.k.p(deeplink) || !com.martian.apptask.g.g.b(this.t, deeplink)) {
            com.martian.mibook.lib.model.g.b.w(this.t, "信息流大图-阅读");
            com.martian.mibook.j.s2.h0(this.t, tyBookItem);
        } else {
            com.martian.mibook.lib.model.g.b.w(this.t, "信息流大图-deeplink");
            com.martian.apptask.g.g.u(this.t, deeplink, "", "其他应用", false);
        }
    }

    private boolean Z2() {
        int i2 = this.R;
        if (i2 == 0 || i2 >= this.I.getAdFlowClickGuideInterval()) {
            this.R = 1;
            this.P = new Random().nextInt(this.I.getAdFlowClickGuideInterval()) + 1;
        } else {
            this.R++;
        }
        return this.R == this.P;
    }

    private void a0(View adView, final TYBookItem tyBookItem, float heightRatio) {
        final h5 a2 = h5.a(adView);
        BookCreative creative = tyBookItem.getCreative();
        int textRectBottom = (int) (creative.getTextRectBottom() * heightRatio);
        com.martian.libmars.utils.n0.k(this.t, creative.getBgImg(), a2.f12074b);
        if (com.martian.libsupport.k.p(creative.getTitle())) {
            a2.f12082j.setVisibility(8);
        } else {
            a2.f12082j.setText(creative.getTitle());
        }
        a2.f12081i.setText(creative.getContent());
        a2.f12081i.setPadding(0, 0, 0, com.martian.libmars.d.h.b(134.0f) - textRectBottom);
        a2.k.setPadding(0, (int) (creative.getTextRectTop() * heightRatio), 0, textRectBottom);
        com.martian.libmars.utils.n0.k(this.t, tyBookItem.getCoverUrl(), a2.f12077e);
        a2.f12076d.setText(tyBookItem.getTitle());
        a2.f12078f.setText(tyBookItem.getTagInfo());
        try {
            a2.f12082j.setTextColor(Color.parseColor(creative.getTitleColor()));
            a2.f12081i.setTextColor(Color.parseColor(creative.getFontColor()));
        } catch (Exception unused) {
        }
        if (com.martian.libsupport.k.p(tyBookItem.getDeeplink())) {
            a2.f12079g.setVisibility(0);
            a2.f12075c.setText(this.t.getString(R.string.add_to_book_store));
        } else {
            a2.f12079g.setVisibility(8);
            a2.f12075c.setText(this.t.getString(R.string.free_read));
        }
        a2.f12075c.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.a2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i4.this.c1(tyBookItem, a2, view);
            }
        });
        a2.f12079g.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.p1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i4.this.e1(tyBookItem, view);
            }
        });
        a2.f12081i.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.e2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h5.this.k.a();
            }
        });
        a2.f12080h.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.h2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i4.this.h1(tyBookItem, view);
            }
        });
    }

    /* renamed from: a2 */
    public /* synthetic */ void b2(final String tag3, View v2) {
        com.martian.mibook.lib.model.g.b.V(this.t, "标签-点击");
        YWTagsActivity.r2(this.t, tag3, B0(), com.martian.mibook.f.f4.j0.x);
    }

    @SuppressLint({"SetTextI18n"})
    private void b0(View adView, final AppTask appTask, boolean isLargeAd) {
        ViewGroup viewGroup;
        ReadingInfo readingInfo;
        View findViewById;
        adView.setMinimumWidth(this.t.B0());
        TextView textView = (TextView) adView.findViewById(R.id.tv_ads_title);
        TextView textView2 = (TextView) adView.findViewById(R.id.tv_ads_desc);
        TextView textView3 = (TextView) adView.findViewById(R.id.tv_ads_logo_desc);
        ImageView imageView = (ImageView) adView.findViewById(R.id.tv_ads_logo);
        TextView textView4 = (TextView) adView.findViewById(R.id.btn_native_creative);
        TextView textView5 = (TextView) adView.findViewById(R.id.tv_ads_promote);
        TextView textView6 = (TextView) adView.findViewById(R.id.iv_ads_hint);
        ImageView imageView2 = (ImageView) adView.findViewById(R.id.iv_ads_image);
        ImageView imageView3 = (ImageView) adView.findViewById(R.id.tv_ads_icon);
        FrameLayout frameLayout = (FrameLayout) adView.findViewById(R.id.iv_ads_video);
        ImageView imageView4 = (ImageView) adView.findViewById(R.id.iv_ads_tag);
        if (appTask.isShakeStyle()) {
            if ((AdConfig.UnionType.CSJ.equalsIgnoreCase(appTask.source) || AdConfig.UnionType.GDT.equalsIgnoreCase(appTask.source)) && (findViewById = adView.findViewById(R.id.tv_ads_shake_view)) != null) {
                findViewById.setVisibility(0);
            }
            if (AdConfig.UnionType.BQT.equalsIgnoreCase(appTask.source) && appTask.getEcpm() < MiConfigSingleton.V3().W3().getShakeStyleEcpm()) {
                appTask.setShakeStyle(false);
            }
        }
        if (isLargeAd && appTask.isPortraitAd()) {
            imageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
            View findViewById2 = adView.findViewById(R.id.iv_ads_image_shake);
            if (findViewById2 != null) {
                findViewById2.setVisibility(0);
            }
        }
        textView.setText(appTask.getTitle());
        textView2.setText(appTask.getDesc());
        if (textView6 != null && appTask.isRechargeAd() && (readingInfo = this.I) != null && readingInfo.isEnableAdBlock()) {
            textView6.setVisibility(0);
            com.martian.mibook.lib.model.g.b.p(this.t, appTask.getTitle() + "-" + appTask.getDesc());
        }
        imageView.setImageResource(appTask.adsIconRes());
        if (textView3 != null) {
            if (VivoAd.isVivoAd(appTask)) {
                View findViewById3 = adView.findViewById(R.id.tv_ads_icon_view);
                if (findViewById3 != null) {
                    findViewById3.setVisibility(8);
                }
            } else if (DefaultAd.isDefaultAd(appTask) || MiBookManager.B2(appTask)) {
                textView3.setText(this.t.getString(R.string.recommend));
            } else if (MiConfigSingleton.V3().J0()) {
                textView3.setText("" + appTask.getEcpm());
            }
        }
        textView4.setText(appTask.buttonText);
        com.martian.libmars.utils.n0.k(this.t, appTask.getPosterUrl(), imageView2);
        com.martian.libmars.utils.n0.d(this.t, appTask.getIconUrl(), imageView3, 4);
        if (frameLayout != null) {
            if (appTask.isReadingVideoAd()) {
                frameLayout.setVisibility(0);
                if (frameLayout.getTag() == appTask) {
                    return;
                }
                if (appTask.videoView.getView().getParent() != null && (viewGroup = (ViewGroup) appTask.videoView.getView().getParent()) != null) {
                    viewGroup.removeAllViews();
                }
                frameLayout.removeAllViews();
                frameLayout.addView(appTask.videoView.getView());
                frameLayout.setTag(appTask);
                appTask.videoView.init();
            } else {
                frameLayout.setVisibility(8);
            }
        }
        if (textView5 != null && !com.martian.libsupport.k.p(appTask.appPromote)) {
            textView5.setText(appTask.appPromote);
        }
        if (imageView4 != null && !com.martian.libsupport.k.p(appTask.marketUrl)) {
            imageView4.setVisibility(0);
            com.martian.libmars.utils.n0.k(this.t, appTask.marketUrl, imageView4);
        }
        if (ApiAd.isApiFlowAd(appTask) || DefaultAd.isDefaultAd(appTask) || MiBookManager.B2(appTask)) {
            adView.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.y1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    i4.this.j1(appTask, view);
                }
            });
        }
    }

    /* renamed from: b1 */
    public /* synthetic */ void c1(final TYBookItem tyBookItem, final h5 readingAdsItemBookWebBinding, View view) {
        String deeplink = tyBookItem.getDeeplink();
        if (!com.martian.libsupport.k.p(deeplink) && com.martian.apptask.g.g.b(this.t, deeplink)) {
            com.martian.mibook.lib.model.g.b.w(this.t, "投放素材-deeplink");
            com.martian.apptask.g.g.u(this.t, deeplink, "", "其他应用", false);
            return;
        }
        com.martian.mibook.lib.model.g.b.w(this.t, "投放素材-加入书架");
        W(tyBookItem);
        readingAdsItemBookWebBinding.f12075c.setText("已在书架");
        readingAdsItemBookWebBinding.f12075c.setEnabled(false);
        readingAdsItemBookWebBinding.f12075c.setAlpha(0.5f);
    }

    private void b3(y holder, final MiReadingContent content, int contentIndex) {
        String str;
        String string;
        holder.f14487d.setVisibility(0);
        LinearLayout linearLayout = (LinearLayout) holder.f14487d.findViewById(R.id.tv_active_reading_title_view);
        TextView textView = (TextView) holder.f14487d.findViewById(R.id.tv_active_reading_bookname);
        TextView textView2 = (TextView) holder.f14487d.findViewById(R.id.tv_active_reading_title);
        TextView textView3 = (TextView) holder.f14487d.findViewById(R.id.tv_active_reading_content);
        TextView textView4 = (TextView) holder.f14487d.findViewById(R.id.tv_active_reading_purchase_video);
        TextView textView5 = (TextView) holder.f14487d.findViewById(R.id.tv_active_reading_vip);
        linearLayout.setPadding(0, this.t.F1(), 0, 0);
        linearLayout.setVisibility(O0() ? 4 : 0);
        x3(textView3, textView2);
        Book book = this.v;
        if (book != null) {
            Y2(textView, this.D.q.l, book.getBookName());
        }
        if (content != null) {
            str = content.getContent(contentIndex);
            Chapter chapter = content.getChapter();
            if (chapter != null) {
                textView2.setText(chapter.getTitle());
            }
        } else {
            str = "";
        }
        if (com.martian.libsupport.k.p(str)) {
            textView3.setVisibility(4);
        } else {
            textView3.setVisibility(0);
            textView3.setText(str);
            textView3.setMaxLines(textView3.getLineHeight() > 0 ? textView3.getMeasuredHeight() / textView3.getLineHeight() : 2);
        }
        Chapter chapter2 = content.getChapter();
        if (chapter2 != null) {
            textView2.setText(chapter2.getTitle());
        }
        int intValue = MiConfigSingleton.V3().W3().getAdChapterMinutes().intValue();
        if (intValue > 0) {
            string = this.t.getString(R.string.active_by_video_duration) + intValue + "分钟";
        } else {
            string = this.t.getString(R.string.active_by_video);
        }
        textView4.setText(string);
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.k1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i4.this.T1(view);
            }
        });
        textView5.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.h1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i4.this.V1(view);
            }
        });
    }

    private b.d c0(int measureWidth, int leftHeight, String adTag, boolean chapterEndAd) {
        b.d dVar = new b.d();
        if (!MiConfigSingleton.V3().M5()) {
            measureWidth /= 2;
        }
        dVar.l(measureWidth);
        dVar.n(leftHeight);
        dVar.j(adTag);
        dVar.m(chapterEndAd);
        dVar.i(f14425g);
        dVar.k(R.layout.reading_ads_item_fullscreen);
        return dVar;
    }

    /* renamed from: c2 */
    public /* synthetic */ void d2(View view) {
        o3();
    }

    @SuppressLint({"ClickableViewAccessibility", "SetTextI18n"})
    private void c3(final y holder) {
        r3(false);
        holder.f14493j.setPadding(0, 0, 0, 0);
        holder.k.setVisibility(8);
        holder.v.setVisibility(0);
        if (!O0()) {
            X2(holder.v);
        }
        int F1 = this.t.F1();
        View view = holder.v;
        s sVar = (s) view.getTag();
        if (sVar == null) {
            sVar = new s();
            sVar.f14459a = (ImageView) view.findViewById(R.id.open_book_icon);
            sVar.f14460b = (ImageView) view.findViewById(R.id.open_book_cover_shadow);
            sVar.f14461c = (TextView) view.findViewById(R.id.open_book_name);
            sVar.f14462d = (TextView) view.findViewById(R.id.open_book_author);
            sVar.f14463e = (TextView) view.findViewById(R.id.open_book_copyright);
            sVar.f14464f = (ScrollView) view.findViewById(R.id.open_book_copyright_view);
            sVar.f14465g = (ImageView) view.findViewById(R.id.bg_book_cover);
            sVar.f14466h = (LinearLayout) view.findViewById(R.id.cover_header_view);
            sVar.l = (TextView) view.findViewById(R.id.open_book_score);
            sVar.m = (TextView) view.findViewById(R.id.open_book_score_unit);
            sVar.p = (TextView) view.findViewById(R.id.open_book_click_count);
            sVar.q = (TextView) view.findViewById(R.id.open_book_click_count_unit);
            sVar.r = (TextView) view.findViewById(R.id.open_book_reading_count);
            sVar.s = (TextView) view.findViewById(R.id.open_book_reading_count_unit);
            sVar.t = (TextView) view.findViewById(R.id.open_book_reading_count_hint);
            sVar.u = (RelativeLayout) view.findViewById(R.id.open_book_reading_count_view);
            sVar.n = (TextView) view.findViewById(R.id.open_book_ncomments);
            sVar.o = (ImageView) view.findViewById(R.id.open_book_ncomments_more);
            sVar.f14467i = (LinearLayout) view.findViewById(R.id.open_book_ncomments_view);
            sVar.f14468j = (LinearLayout) view.findViewById(R.id.open_book_intro_view);
            sVar.v = (TextView) view.findViewById(R.id.open_book_warn);
            sVar.w = (TextView) view.findViewById(R.id.open_book_tag1);
            sVar.x = (TextView) view.findViewById(R.id.open_book_tag2);
            sVar.y = (TextView) view.findViewById(R.id.open_book_tag3);
            sVar.k = (LinearLayout) view.findViewById(R.id.open_book_score_view);
            view.setTag(sVar);
        }
        MiBookManager.d2(this.t, this.v, sVar.f14459a);
        sVar.f14461c.setText(this.v.getBookName());
        sVar.f14462d.setText(this.v.getReadingInfo());
        if (MiConfigSingleton.V3().J4.E()) {
            sVar.f14465g.setAlpha(0.7f);
        } else {
            sVar.f14465g.setAlpha(0.5f);
        }
        ScrollView scrollView = sVar.f14464f;
        if (scrollView != null) {
            scrollView.setOnTouchListener(new o());
        }
        if (!MiConfigSingleton.V3().M5() || sVar.f14466h == null) {
            sVar.f14462d.setText(this.v.getReadingInfo());
            sVar.v.setVisibility(8);
            sVar.v.setVisibility(8);
            return;
        }
        if (com.martian.libsupport.k.p(this.I.getIntro())) {
            sVar.f14468j.setVisibility(4);
            sVar.f14463e.setVisibility(4);
            sVar.v.setVisibility(0);
            sVar.v.setText(y0());
        } else {
            sVar.f14468j.setVisibility(0);
            sVar.f14463e.setVisibility(0);
            sVar.f14463e.setText(com.martian.libsupport.k.v(this.I.getIntro()));
            sVar.v.setVisibility(8);
        }
        MiBookManager.d2(this.t, this.v, sVar.f14460b);
        int b2 = com.martian.libmars.d.h.b(16.0f);
        int b3 = com.martian.libmars.d.h.b(24.0f);
        int max = Math.max(F1, b3);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) sVar.f14466h.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) sVar.f14460b.getLayoutParams();
        int b4 = com.martian.libmars.d.h.b(279.0f) + F1;
        layoutParams.height = b4;
        layoutParams2.height = b4;
        sVar.f14466h.setPadding(0, max, 0, 0);
        sVar.f14465g.setPadding(b2, max, b2, b3);
        if (MiConfigSingleton.V3().J4.E()) {
            sVar.f14466h.setAlpha(0.95f);
        } else {
            sVar.f14466h.setAlpha(1.0f);
        }
        if (this.I.getScore() == null || this.I.getScore().intValue() <= 0) {
            sVar.l.setText("--");
            sVar.m.setVisibility(4);
        } else {
            sVar.l.setText(String.format(Locale.CHINA, "%.1f", Float.valueOf(this.I.getScore().intValue() / 10.0f)));
            sVar.m.setVisibility(0);
        }
        if (this.I.getReadingCount() != null) {
            sVar.p.setText(BookInfoActivity.w4(this.I.getReadingCount().intValue(), sVar.q, "人"));
            sVar.q.setVisibility(0);
        } else {
            sVar.p.setText("--");
            sVar.q.setVisibility(4);
        }
        if (this.I.getNComments() == null || this.I.getNComments().intValue() <= 0) {
            sVar.n.setText(this.t.getString(R.string.grade));
            sVar.o.setVisibility(4);
        } else if (MiConfigSingleton.V3().D8()) {
            sVar.n.setText(this.I.getNComments() + "人" + this.t.getString(R.string.reader_comment));
            sVar.o.setVisibility(0);
            sVar.f14467i.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.s2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    i4.this.d2(view2);
                }
            });
        } else {
            sVar.n.setText(this.t.getString(R.string.grade));
            sVar.o.setVisibility(4);
        }
        if (this.v.getAllWords() == null || this.v.getAllWords().intValue() <= 0) {
            sVar.u.setVisibility(4);
            sVar.f14462d.setText(this.v.getReadingInfo());
        } else {
            sVar.u.setVisibility(0);
            sVar.f14462d.setText(this.v.getAuthor() + "·著");
            if (this.v.getAllWords().intValue() >= 10000) {
                sVar.r.setText("" + (this.v.getAllWords().intValue() / 10000));
                sVar.s.setVisibility(0);
            } else {
                sVar.r.setText("" + this.v.getAllWords());
                sVar.s.setVisibility(8);
            }
            sVar.t.setText(this.v.getStatus());
        }
        if (this.I.getTagList() == null || this.I.getTagList().isEmpty()) {
            return;
        }
        final String str = this.I.getTagList().get(0);
        sVar.w.setVisibility(0);
        sVar.w.setText(str);
        sVar.w.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.n2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                i4.this.X1(str, view2);
            }
        });
        if (this.I.getTagList().size() > 1) {
            final String str2 = this.I.getTagList().get(1);
            sVar.x.setVisibility(0);
            sVar.x.setText(str2);
            sVar.x.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.q2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    i4.this.Z1(str2, view2);
                }
            });
        }
        if (this.I.getTagList().size() > 2) {
            final String str3 = this.I.getTagList().get(2);
            sVar.y.setVisibility(0);
            sVar.y.setText(str3);
            sVar.y.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.s1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    i4.this.b2(str3, view2);
                }
            });
        }
    }

    private void d0(final MiReadingContent content, final Chapter chapter, boolean preBuy) {
        content.setBuying();
        MiConfigSingleton.V3().l3().j(this.t, this.v, chapter, content.getChapterContent(), preBuy, new r(content));
    }

    /* renamed from: d1 */
    public /* synthetic */ void e1(final TYBookItem tyBookItem, View view) {
        String deeplink = tyBookItem.getDeeplink();
        if (com.martian.libsupport.k.p(deeplink) || !com.martian.apptask.g.g.b(this.t, deeplink)) {
            com.martian.mibook.lib.model.g.b.w(this.t, "投放素材-阅读");
            com.martian.mibook.j.s2.h0(this.t, tyBookItem);
        } else {
            com.martian.mibook.lib.model.g.b.w(this.t, "投放素材-deeplink");
            com.martian.apptask.g.g.u(this.t, deeplink, "", "其他应用", false);
        }
    }

    @SuppressLint({"SetTextI18n"})
    private void d3(y holder, final MiReadingContent content) {
        holder.f14486c.setVisibility(0);
        View findViewById = holder.f14486c.findViewById(R.id.price_view);
        View findViewById2 = holder.f14486c.findViewById(R.id.account_view);
        LinearLayout linearLayout = (LinearLayout) holder.f14486c.findViewById(R.id.tv_buy_reading_title_view);
        TextView textView = (TextView) holder.f14486c.findViewById(R.id.tv_buy_reading_bookname);
        TextView textView2 = (TextView) holder.f14486c.findViewById(R.id.tv_buy_reading_title);
        TextView textView3 = (TextView) holder.f14486c.findViewById(R.id.tv_buy_reading_content);
        TextView textView4 = (TextView) holder.f14486c.findViewById(R.id.tv_buy_reading_purchase_video);
        TextView textView5 = (TextView) holder.f14486c.findViewById(R.id.tv_buy_reading_price);
        TextView textView6 = (TextView) holder.f14486c.findViewById(R.id.tv_buy_account_book_coins);
        TextView textView7 = (TextView) holder.f14486c.findViewById(R.id.tv_buy_reading_purchase);
        TextView textView8 = (TextView) holder.f14486c.findViewById(R.id.tv_buy_reading_hint);
        LinearLayout linearLayout2 = (LinearLayout) holder.f14486c.findViewById(R.id.tv_buy_auto_view);
        final ImageView imageView = (ImageView) holder.f14486c.findViewById(R.id.tv_buy_auto);
        if (MiUserManager.s().A()) {
            imageView.setImageResource(R.drawable.btn_check_on_default_holo);
        } else {
            imageView.setImageResource(R.drawable.btn_check_off_default);
        }
        textView4.setVisibility(8);
        x3(textView3, textView2);
        linearLayout.setPadding(0, this.t.F1(), 0, 0);
        int i2 = 4;
        linearLayout.setVisibility(O0() ? 4 : 0);
        Book book = this.v;
        if (book != null) {
            Y2(textView, this.D.q.l, book.getBookName());
        }
        if (com.martian.libsupport.k.p(content.getShortContent())) {
            textView3.setVisibility(8);
        } else {
            textView3.setVisibility(0);
            textView3.setText(content.getShortContent());
            int lineHeight = textView3.getLineHeight();
            int measuredHeight = textView3.getMeasuredHeight();
            if (lineHeight > 0 && measuredHeight > lineHeight) {
                i2 = measuredHeight / lineHeight;
            }
            textView3.setMaxLines(i2);
        }
        final Chapter chapter = content.getChapter();
        if (chapter != null) {
            textView2.setText(chapter.getTitle());
        }
        Book book2 = this.v;
        final boolean z = (book2 instanceof YWBook) && ((YWBook) book2).getChargeType() != null && ((YWBook) this.v).getChargeType().intValue() == 2;
        final MartianRPAccount s4 = MiConfigSingleton.V3().s4();
        if (MiConfigSingleton.V3().x5()) {
            findViewById.setVisibility(0);
            findViewById2.setVisibility(0);
            linearLayout2.setVisibility(0);
            if (chapter != null) {
                if (chapter.getChargeType() != null && chapter.getChargeType().intValue() == 1000) {
                    textView4.setVisibility(0);
                    textView4.setText(this.t.getString(R.string.purchase_by_video));
                }
                if (z) {
                    textView8.setText(this.t.getString(R.string.whole_purchase_hint));
                    textView5.setText(((YWBook) this.v).getTotalPrice() + "" + this.t.getResources().getString(R.string.txs_coin));
                } else {
                    textView5.setText("获取失败");
                }
            }
            if (s4 != null) {
                textView6.setText(s4.getBookCoins() + "" + this.t.getResources().getString(R.string.txs_coin));
                if (z) {
                    if (((YWBook) this.v).getTotalPrice().intValue() > s4.getBookCoins()) {
                        textView7.setText(this.t.getResources().getString(R.string.purchase_coins_no_enough));
                        n3(chapter, content.getChapterIndex());
                    } else {
                        textView7.setText(this.t.getResources().getString(R.string.whole_purchase));
                    }
                } else if (chapter == null || chapter.getPrice().intValue() <= s4.getBookCoins()) {
                    textView7.setText(this.t.getResources().getString(R.string.chapter_purchase));
                } else {
                    textView7.setText(this.t.getResources().getString(R.string.purchase_coins_no_enough));
                    n3(chapter, content.getChapterIndex());
                }
            } else {
                textView6.setText("获取失败");
                textView7.setText(this.t.getResources().getString(R.string.chapter_purchase));
            }
        } else {
            findViewById.setVisibility(8);
            findViewById2.setVisibility(8);
            linearLayout2.setVisibility(8);
            textView7.setText(this.t.getResources().getString(R.string.login_continue_read));
        }
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.u2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i4.this.f2(chapter, view);
            }
        });
        textView7.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.l2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i4.this.h2(content, s4, z, chapter, view);
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.w1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i4.i2(imageView, view);
            }
        });
        if (content == this.B && content.isPrebuyError()) {
            s3(content);
        } else if (content == this.C && this.B.isReady() && e0()) {
            s3(content);
        }
    }

    private boolean e0() {
        return MiUserManager.s().A();
    }

    /* renamed from: e2 */
    public /* synthetic */ void f2(final Chapter chapter, View v2) {
        if (MiConfigSingleton.V3().l2(this.t, 1019)) {
            this.t.k1("视频加载中...");
            if (chapter == null || chapter.getChargeType() == null || chapter.getChargeType().intValue() != 1000) {
                MiConfigSingleton.V3().L4.B0(this.t, new o0.t() { // from class: com.martian.mibook.ui.o.e0
                    @Override // com.martian.mibook.application.o0.t
                    public final void a() {
                        i4.this.u();
                    }
                });
            } else {
                v2(q);
            }
        }
    }

    private void e3(y holder, final MiReadingContent content) {
        final String str;
        if (content == null) {
            return;
        }
        if (content.getErrCode().intValue() == MiReadingContent.ERRCODE_BOOK_OFFLINE) {
            g3(holder, true);
            return;
        }
        holder.f14485b.setVisibility(0);
        ((TextView) holder.f14485b.findViewById(R.id.tv_feedback)).setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.r1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i4.this.k2(view);
            }
        });
        ((TextView) holder.f14485b.findViewById(R.id.tv_refresh)).setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.q1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i4.this.m2(content, view);
            }
        });
        LinearLayout linearLayout = (LinearLayout) holder.f14485b.findViewById(R.id.tv_fail_title_view);
        TextView textView = (TextView) holder.f14485b.findViewById(R.id.tv_fail_bookname);
        Book book = this.v;
        if (book != null && !com.martian.libsupport.k.p(book.getBookName())) {
            Y2(textView, this.D.q.l, this.v.getBookName());
        }
        linearLayout.setPadding(com.martian.libmars.d.h.b(24.0f), this.t.F1(), com.martian.libmars.d.h.b(120.0f), 0);
        linearLayout.setVisibility(O0() ? 4 : 0);
        TextView textView2 = (TextView) holder.f14485b.findViewById(R.id.tv_failing_reading_title);
        if (content.getChapter() != null) {
            textView2.setText(content.getChapter().getTitle());
        }
        com.martian.mibook.j.x2.c(textView2);
        textView2.setTextSize(MiConfigSingleton.V3().H3() + 6);
        TextView textView3 = (TextView) holder.f14485b.findViewById(R.id.tv_chapter_feedback);
        String errMsg = content.getErrMsg();
        if ("章节未购买".equalsIgnoreCase(errMsg)) {
            textView3.setVisibility(8);
        }
        if (com.martian.libsupport.k.p(content.getStackTrace())) {
            str = errMsg;
        } else {
            str = errMsg + "\n" + content.getStackTrace();
        }
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.b2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i4.this.o2(str, view);
            }
        });
        TextView textView4 = (TextView) holder.f14485b.findViewById(R.id.tv_error_msg);
        if (!com.martian.libsupport.k.p(errMsg)) {
            textView4.setText(errMsg);
        }
        TextView textView5 = holder.p;
        if (textView5 != null) {
            textView5.setText("");
        }
        if (this.j0 || com.martian.libsupport.k.p(str)) {
            return;
        }
        this.j0 = true;
        o0(str, false);
    }

    @SuppressLint({"InflateParams"})
    private void f3(final y holder, MyDrawTextView myDrawTextView, final AppTaskList appTaskList, b.d readingAdConfig, final int contentIndex) {
        AutoScrollView autoScrollView;
        String str = (String) holder.q.getTag();
        holder.q.setTag(readingAdConfig.b());
        holder.q.setVisibility(0);
        if (!O0()) {
            holder.f14490g.setText(this.t.getString(R.string.ad_for_novel));
        }
        boolean equalsIgnoreCase = readingAdConfig.b().equalsIgnoreCase(str);
        AppTask appTask = appTaskList.getApps().get(0);
        if (appTask == null) {
            return;
        }
        if (equalsIgnoreCase && appTask.exposed) {
            if (appTask.isCoverView() && (autoScrollView = (AutoScrollView) holder.q.findViewById(R.id.book_ad_text_view)) != null) {
                autoScrollView.b();
            }
            holder.q.findViewById(R.id.fl_ads_container).setVisibility(0);
            if (appTaskList.getApps().size() == 2) {
                holder.q.findViewById(R.id.fl_ads_container_2).setVisibility(0);
            }
            if (appTaskList.getApps().size() > 2) {
                holder.q.findViewById(R.id.fl_ads_container_3).setVisibility(0);
                holder.q.findViewById(R.id.fl_ads_container_joint_2).setVisibility(0);
                holder.q.findViewById(R.id.fl_ads_container_joint_3).setVisibility(0);
                return;
            }
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) holder.q.getLayoutParams();
        marginLayoutParams.height = readingAdConfig.a();
        marginLayoutParams.width = readingAdConfig.d();
        marginLayoutParams.setMargins(0, myDrawTextView.m(readingAdConfig.a()), 0, 0);
        holder.q.setLayoutParams(marginLayoutParams);
        ViewGroup viewGroup = (ViewGroup) holder.q.findViewById(R.id.fl_ads_container);
        ViewGroup viewGroup2 = (ViewGroup) holder.q.findViewById(R.id.fl_ads_container_2);
        ViewGroup viewGroup3 = (ViewGroup) holder.q.findViewById(R.id.fl_ads_container_3);
        if (appTaskList.getApps().size() == 1) {
            viewGroup.setVisibility(0);
            viewGroup2.setVisibility(8);
            viewGroup3.setVisibility(8);
            k3(holder, myDrawTextView, viewGroup, appTask, readingAdConfig, equalsIgnoreCase, contentIndex, true);
            return;
        }
        if (appTaskList.getApps().size() == 2) {
            viewGroup.setVisibility(0);
            viewGroup2.setVisibility(0);
            viewGroup3.setVisibility(8);
            k3(holder, myDrawTextView, viewGroup, appTask, readingAdConfig, equalsIgnoreCase, contentIndex, true);
            k3(holder, myDrawTextView, viewGroup2, appTaskList.getApps().get(1), readingAdConfig, equalsIgnoreCase, contentIndex, false);
            return;
        }
        viewGroup.setVisibility(0);
        viewGroup2.setVisibility(8);
        viewGroup3.setVisibility(0);
        k3(holder, myDrawTextView, viewGroup, appTask, readingAdConfig, equalsIgnoreCase, contentIndex, true);
        ViewGroup viewGroup4 = (ViewGroup) holder.q.findViewById(R.id.fl_ads_container_joint_2);
        ViewGroup viewGroup5 = (ViewGroup) holder.q.findViewById(R.id.fl_ads_container_joint_3);
        viewGroup4.setVisibility(0);
        viewGroup5.setVisibility(0);
        k3(holder, myDrawTextView, viewGroup4, appTaskList.getApps().get(1), readingAdConfig, equalsIgnoreCase, contentIndex, false);
        k3(holder, myDrawTextView, viewGroup5, appTaskList.getApps().get(2), readingAdConfig, equalsIgnoreCase, contentIndex, false);
    }

    /* renamed from: g1 */
    public /* synthetic */ void h1(final TYBookItem tyBookItem, View view) {
        String deeplink = tyBookItem.getDeeplink();
        if (com.martian.libsupport.k.p(deeplink) || !com.martian.apptask.g.g.b(this.t, deeplink)) {
            com.martian.mibook.lib.model.g.b.w(this.t, "投放素材-书籍详情");
            com.martian.mibook.j.s2.R(this.t, tyBookItem);
        } else {
            com.martian.mibook.lib.model.g.b.w(this.t, "投放素材-deeplink");
            com.martian.apptask.g.g.u(this.t, deeplink, "", "其他应用", false);
        }
    }

    /* renamed from: g2 */
    public /* synthetic */ void h2(final MiReadingContent content, final MartianRPAccount rpAccount, final boolean isWholePurchase, final Chapter chapter, View v2) {
        if (MiConfigSingleton.V3().l2(this.t, 1020)) {
            content.setStartFromFirstPage(true);
            if (rpAccount == null) {
                this.t.k1("获取信息失败");
                return;
            }
            if (content.isBuying()) {
                this.t.k1("购买中，请稍候");
                return;
            }
            if ((!isWholePurchase || ((YWBook) this.v).getTotalPrice().intValue() <= rpAccount.getBookCoins()) && (chapter == null || chapter.getPrice().intValue() <= rpAccount.getBookCoins())) {
                d0(content, chapter, false);
            } else if (this.v != null) {
                com.martian.mibook.lib.model.g.b.V(this.t, "充值书币");
                com.martian.mibook.j.s2.k0(this.t, this.v, chapter);
            }
        }
    }

    private void g3(final y holder, boolean isBookOffline) {
        holder.f14488e.setVisibility(0);
        holder.k.setVisibility(8);
        View view = holder.f14488e;
        t tVar = (t) view.getTag();
        if (tVar == null) {
            tVar = new t();
            tVar.f14469a = (TextView) view.findViewById(R.id.tv_post_comment);
            tVar.f14471c = view.findViewById(R.id.recommend_view);
            tVar.f14472d = (ProgressBar) view.findViewById(R.id.tv_switch_more_progressbar);
            tVar.f14473e = (ImageView) view.findViewById(R.id.tv_switch_more_loan);
            tVar.f14477i = (RelativeLayout) view.findViewById(R.id.reading_end_header_view);
            tVar.f14475g = (LinearLayout) view.findViewById(R.id.reading_end_function_view);
            tVar.f14474f = (LinearLayout) view.findViewById(R.id.reading_end_comment);
            tVar.f14476h = (LinearLayout) view.findViewById(R.id.ll_last_page_ads_container);
            tVar.f14478j = (LinearLayout) view.findViewById(R.id.ll_last_page_books_container);
            tVar.s = (LinearLayout) view.findViewById(R.id.reading_end_comment_view);
            tVar.f14470b = (TextView) view.findViewById(R.id.tv_switch_more);
            tVar.k = (TextView) view.findViewById(R.id.reading_end_title);
            tVar.l = (TextView) view.findViewById(R.id.reading_end_desc);
            tVar.m = view.findViewById(R.id.rules_view);
            tVar.n = (ImageView) view.findViewById(R.id.rules_icon);
            tVar.o = (ImageView) view.findViewById(R.id.reading_end_close);
            tVar.p = (ImageView) view.findViewById(R.id.reading_end_comment_icon);
            tVar.q = (TextView) view.findViewById(R.id.reading_end_comment_number);
            tVar.r = (TextView) view.findViewById(R.id.reading_end_comment_desc);
            view.setTag(tVar);
        }
        if (isBookOffline) {
            L0(view, tVar);
        } else {
            M0(view, tVar);
        }
        y2(true, view);
        TextView textView = holder.p;
        if (textView != null) {
            textView.setText("");
        }
    }

    private Drawable h0(String path) {
        if (com.martian.libsupport.k.p(path)) {
            return null;
        }
        if (!path.startsWith("/")) {
            return com.martian.libmars.utils.p0.G(this.t, path);
        }
        Bitmap n2 = com.martian.libmars.utils.i0.n(path, this.t.B0(), this.t.z0());
        if (n2 == null) {
            return null;
        }
        return new BitmapDrawable(this.t.getResources(), n2);
    }

    @SuppressLint({"SetTextI18n"})
    private void h3(final y holder, b.d readingAdConfig) {
        LinearLayout linearLayout = (LinearLayout) holder.q.findViewById(R.id.reading_ads_close_title_layout);
        final AppTask C0 = C0(readingAdConfig.b());
        if (C0 == null) {
            linearLayout.setVisibility(4);
            return;
        }
        linearLayout.setVisibility(0);
        String str = (String) linearLayout.getTag();
        linearLayout.setTag(readingAdConfig.b());
        if (readingAdConfig.b().equalsIgnoreCase(str)) {
            n0(C0, linearLayout);
            return;
        }
        TextView textView = (TextView) linearLayout.findViewById(R.id.reading_ads_close_title);
        ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) linearLayout.findViewById(R.id.reading_ads_close_icon);
        readerThemeImageView.setEnableColorFilter(true);
        if (com.martian.mibook.application.k0.P1.equals(C0.id)) {
            com.martian.mibook.lib.model.g.b.J(this.t, "激励信息流-曝光");
            textView.setText(this.t.getString(R.string.wbl_ad_hint));
            readerThemeImageView.clearColorFilter();
            readerThemeImageView.setImageResource(R.drawable.icon_bonus_flow);
        } else if (com.martian.mibook.application.k0.N1.equalsIgnoreCase(C0.id)) {
            com.martian.mibook.lib.model.g.b.J(this.t, "视频免广告-曝光");
            textView.setText(this.t.getString(R.string.watch_video_for) + MiConfigSingleton.V3().W2(this.I.isVideoAdWatched()) + this.t.getString(R.string.minute_ad));
            readerThemeImageView.setImageResource(R.drawable.reader_icon_video_ad);
        } else if (com.martian.mibook.application.k0.O1.equalsIgnoreCase(C0.id)) {
            com.martian.mibook.lib.model.g.b.J(this.t, "vip-曝光");
            if (MiConfigSingleton.V3().j6()) {
                textView.setText(this.t.getString(R.string.vip_for_one_yuan));
            } else {
                textView.setText(this.t.getString(R.string.open_vip_for_ad_free));
            }
            readerThemeImageView.setImageResource(R.drawable.reader_icon_vip_member);
        } else {
            String desc = C0.getDesc();
            if (desc.length() > 16) {
                desc = desc.substring(0, 15);
            }
            textView.setText(desc);
            readerThemeImageView.setImageResource(R.drawable.vote_upcount);
        }
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.r2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i4.this.q2(C0, view);
            }
        });
        n0(C0, linearLayout);
    }

    /* renamed from: i1 */
    public /* synthetic */ void j1(final AppTask appTask, View v2) {
        this.J.d(appTask);
        C2(appTask.getAdTag());
    }

    static /* synthetic */ void i2(final ImageView tv_buy_auto, View v2) {
        if (MiUserManager.s().A()) {
            MiUserManager.s().C(false);
            tv_buy_auto.setImageResource(R.drawable.btn_check_off_default);
        } else {
            MiUserManager.s().C(true);
            tv_buy_auto.setImageResource(R.drawable.btn_check_on_default_holo);
        }
    }

    @SuppressLint({"SetTextI18n"})
    private void j0(final y holder, MiReadingContent content) {
        final String s0 = s0(content.getChapter());
        final String title = content.getChapter() == null ? "" : content.getChapter().getTitle();
        final ChapterCommentCount u0 = u0(s0, content.getChapterIndex());
        if (u0 == null || u0.getNComments() <= 0) {
            holder.o.setText(this.t.getString(R.string.click_to_post_chapter_comment));
        } else {
            holder.o.setText(this.t.getString(R.string.chapter_comments) + "（" + u0.getNComments() + "条）");
        }
        holder.o.setClickable(true);
        holder.o.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.f1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i4.this.l1(u0, s0, title, view);
            }
        });
    }

    /* renamed from: j2 */
    public /* synthetic */ void k2(View v2) {
        com.martian.mibook.lib.model.g.b.V(this.t, "举报");
        com.martian.mibook.j.s2.Y(this.t);
    }

    @SuppressLint({"SetTextI18n"})
    private void k0(final y holder, @NonNull MyDrawTextView myDrawTextView, final MiReadingContent content) {
        holder.r.setVisibility(0);
        ((RelativeLayout.LayoutParams) holder.r.getLayoutParams()).topMargin = myDrawTextView.getTextEndHeight();
        final String s0 = s0(content.getChapter());
        final ChapterCommentCount u0 = u0(s0, content.getChapterIndex());
        MiReadingTheme r2 = MiConfigSingleton.V3().J4.r();
        if (myDrawTextView.getLeftHeight() > com.martian.libmars.d.h.b(210.0f) && u0 != null && u0.getNComments() > 0 && !u0.getList().isEmpty()) {
            holder.w.setVisibility(0);
            holder.s.setVisibility(8);
            TextView textView = holder.z;
            StringBuilder sb = new StringBuilder();
            sb.append(u0.getNComments());
            com.martian.libmars.activity.j1 j1Var = this.t;
            sb.append(j1Var == null ? "条" : j1Var.getString(R.string.tiao));
            textView.setText(sb.toString());
            Comment comment = u0.getList().get(0);
            if (comment != null) {
                com.martian.libmars.utils.n0.o(this.t, comment.getHeader(), holder.A, R.drawable.day_img_heads, MiConfigSingleton.V3().e2());
                holder.B.setText(comment.getNickname());
                holder.C.setText(com.martian.libsupport.k.v(comment.getContent()));
            }
            holder.y.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.v1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    i4.this.n1(content, u0, s0, view);
                }
            });
            holder.x.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.m2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    i4.this.p1(content, s0, view);
                }
            });
            return;
        }
        holder.w.setVisibility(8);
        holder.s.setVisibility(0);
        if (u0 == null || u0.getNComments() <= 0) {
            holder.t.setText(this.t.getString(R.string.chapter_comment_sofa));
            holder.t.setTextColor(r2.getTextColorThirdly(this.t));
            holder.t.setAlpha(0.8f);
        } else {
            holder.t.setText(this.t.getString(R.string.chapter_comments) + "（" + u0.getNComments() + "条）");
            holder.t.setTextColor(r2.getTextColorPrimary(this.t));
            holder.t.setAlpha(1.0f);
        }
        holder.t.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.u1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i4.this.r1(content, u0, s0, view);
            }
        });
    }

    /* renamed from: k1 */
    public /* synthetic */ void l1(final ChapterCommentCount commentCount, final String chapterId, final String chapterName, View v2) {
        D2(commentCount, chapterId, chapterName);
    }

    private void k3(final y holder, final MyDrawTextView myDrawTextView, final ViewGroup parentView, final AppTask appTask, final b.d readingAdConfig, boolean adRendered, int contentIndex, final boolean firstAd) {
        View inflate;
        final View view;
        if (appTask == null) {
            return;
        }
        View findViewWithTag = parentView.findViewWithTag(Integer.valueOf(contentIndex));
        if (!adRendered || (findViewWithTag == null && appTask.customView == null)) {
            appTask.exposed = false;
            View findViewById = holder.q.findViewById(R.id.fl_close_ads_icon);
            View findViewById2 = holder.q.findViewById(R.id.fl_close_ads_video);
            parentView.removeAllViews();
            if (appTask.customView == null) {
                if (MiBookManager.B2(appTask)) {
                    findViewById.setVisibility(8);
                    findViewById2.setVisibility(8);
                    TYBookItem tYBookItem = (TYBookItem) appTask.origin;
                    if (readingAdConfig.c() == R.layout.reading_ads_item_large) {
                        appTask.adsPosition = "信息流大图";
                        inflate = this.t.getLayoutInflater().inflate(R.layout.reading_ads_item_book_large, (ViewGroup) null);
                        Z(inflate, tYBookItem);
                    } else if (appTask.isCoverView()) {
                        appTask.adsPosition = "投放素材";
                        inflate = this.t.getLayoutInflater().inflate(R.layout.reading_ads_item_book_poster, (ViewGroup) null);
                        a0(inflate, tYBookItem, (readingAdConfig.a() - f14428j) / 1280.0f);
                    } else {
                        appTask.adsPosition = "书籍";
                        inflate = this.t.getLayoutInflater().inflate(R.layout.reading_ads_item_book, (ViewGroup) null);
                        Y(inflate, tYBookItem);
                    }
                    inflate.setTag(Integer.valueOf(contentIndex));
                    parentView.addView(inflate);
                    view = inflate;
                    holder.q.post(new Runnable() { // from class: com.martian.mibook.ui.o.o2
                        @Override // java.lang.Runnable
                        public final void run() {
                            i4.this.s2(holder, appTask, view, parentView, firstAd, myDrawTextView, readingAdConfig);
                        }
                    });
                }
                if (MiConfigSingleton.V3().u5()) {
                    findViewById.setVisibility(0);
                    findViewById2.setVisibility(8);
                } else {
                    findViewById.setVisibility(0);
                    findViewById2.setVisibility(0);
                }
                findViewWithTag = this.t.getLayoutInflater().inflate(readingAdConfig.c(), (ViewGroup) null);
                b0(findViewWithTag, appTask, R.layout.reading_ads_item_large == readingAdConfig.c());
                findViewWithTag.setTag(Integer.valueOf(contentIndex));
                parentView.addView(findViewWithTag);
            }
        }
        view = findViewWithTag;
        holder.q.post(new Runnable() { // from class: com.martian.mibook.ui.o.o2
            @Override // java.lang.Runnable
            public final void run() {
                i4.this.s2(holder, appTask, view, parentView, firstAd, myDrawTextView, readingAdConfig);
            }
        });
    }

    private void l0(final y holder, final MyDrawTextView myDrawTextView, final MiReadingContent content, final int contentIndex) {
        boolean z = contentIndex == x0();
        if (myDrawTextView.r()) {
            if (myDrawTextView.getMeasuredWidth() <= 0) {
                return;
            }
            if (this.I.isShowChapterComment()) {
                if (myDrawTextView.getLeftHeight() >= f14428j) {
                    k0(holder, myDrawTextView, content);
                    if (v0() + 1 == this.Y) {
                        holder.o.setText(this.t.getString(R.string.wbl_ad_slide_hint));
                    }
                } else {
                    j0(holder, content);
                    if (v0() + 1 == this.Y) {
                        P2();
                    }
                }
            }
        }
        if (!myDrawTextView.q()) {
            if (z) {
                holder.q.findViewById(R.id.fl_ads_container).setVisibility(4);
                holder.q.findViewById(R.id.fl_ads_container_2).setVisibility(8);
                holder.q.findViewById(R.id.fl_ads_container_3).setVisibility(8);
                holder.q.findViewById(R.id.fl_ads_container_joint_2).setVisibility(4);
                holder.q.findViewById(R.id.fl_ads_container_joint_3).setVisibility(4);
                J0(false);
                return;
            }
            return;
        }
        if (P0() || a3()) {
            return;
        }
        if (O0() || (content.getChapterIndex() >= v0() && contentIndex >= x0())) {
            b.d c0 = c0(myDrawTextView.getMeasuredWidth() + com.martian.libmars.d.h.b(16.0f), myDrawTextView.getLeftHeight(), content.getChapterIndex() + "_" + contentIndex, myDrawTextView.s());
            if (!O0()) {
                holder.k.setVisibility(4);
            }
            holder.f14493j.setPadding(0, 0, 0, 0);
            AppTaskList r0 = r0(c0, contentIndex == x0());
            if (r0 == null || r0.getApps() == null || r0.getApps().isEmpty()) {
                holder.f14490g.setText(this.t.getString(R.string.ad_for_empty));
                return;
            }
            J2(c0, r0);
            if (z) {
                J0(true);
                if (myDrawTextView.s()) {
                    P2();
                }
            }
            if (c0.d() <= 0) {
                return;
            }
            f3(holder, myDrawTextView, r0, c0, contentIndex);
            h3(holder, c0);
        }
    }

    /* renamed from: l2 */
    public /* synthetic */ void m2(final MiReadingContent content, View v2) {
        if (System.currentTimeMillis() - this.i0 <= 3000) {
            this.t.k1("太快啦，稍后重试...");
            return;
        }
        this.i0 = System.currentTimeMillis();
        this.t.k1("加载中...");
        if (content.isError()) {
            if (content == this.B || content == this.C) {
                content.setStartFromFirstPage(true);
            } else if (content == this.A) {
                content.setStartFromFirstPage(false);
            }
            q3(content);
        }
    }

    /* renamed from: m1 */
    public /* synthetic */ void n1(final MiReadingContent content, final ChapterCommentCount commentCount, final String chapterId, View v2) {
        D2(commentCount, chapterId, content.getChapter() == null ? "" : content.getChapter().getTitle());
    }

    private void n0(final AppTask linkAppTask, final ViewGroup adView) {
        if (DefaultAd.isDefaultAd(linkAppTask) || linkAppTask.exposed) {
            return;
        }
        adView.post(new Runnable() { // from class: com.martian.mibook.ui.o.l1
            @Override // java.lang.Runnable
            public final void run() {
                i4.this.t1(adView, linkAppTask);
            }
        });
    }

    /* renamed from: n2 */
    public /* synthetic */ void o2(final String reportMsg, View v2) {
        com.martian.libmars.activity.j1 j1Var = this.t;
        com.martian.libmars.utils.k0.P(j1Var, j1Var.getString(R.string.prompt), "是否上报该章节存在错误信息？", new k0.l() { // from class: com.martian.mibook.ui.o.d2
            @Override // com.martian.libmars.utils.k0.l
            public final void a() {
                i4.this.L1(reportMsg);
            }
        });
    }

    private void n3(Chapter chapter, int chapterIndex) {
        if (this.h0 || v0() != chapterIndex) {
            return;
        }
        this.h0 = true;
        com.martian.mibook.j.s2.k0(this.t, this.v, chapter);
        KeyEventDispatcher.Component component = this.t;
        if (component instanceof w) {
            ((w) component).dismissDialog();
        }
    }

    /* renamed from: o1 */
    public /* synthetic */ void p1(final MiReadingContent content, final String chapterId, View v2) {
        D2(null, chapterId, content.getChapter() == null ? "" : content.getChapter().getTitle());
    }

    private void o3() {
        com.martian.mibook.lib.model.g.b.V(this.t, "查看评论");
        BookInfoActivity.o A = this.I.toBookInfo().A(false);
        Book book = this.v;
        if (book != null) {
            A.H(book.getSourceId()).I(this.v.getSourceName()).u(this.v.getBookName()).s(this.v.getAuthor());
        }
        WholeCommentActivity.r2(this.t, A);
    }

    /* renamed from: p2 */
    public /* synthetic */ void q2(final AppTask linkAppTask, View v2) {
        if (com.martian.mibook.application.k0.P1.equals(linkAppTask.id)) {
            com.martian.mibook.lib.model.g.b.J(this.t, "激励信息流-点击");
            l3(1, "文字链");
            return;
        }
        if (com.martian.mibook.application.k0.N1.equalsIgnoreCase(linkAppTask.id)) {
            com.martian.mibook.lib.model.g.b.J(this.t, "视频免广告-点击");
            com.martian.mibook.lib.model.g.b.J(this.t, "视频免广告-点击");
            j3();
        } else {
            if (!com.martian.mibook.application.k0.O1.equalsIgnoreCase(linkAppTask.id)) {
                com.martian.mibook.lib.model.g.b.J(this.t, "广告-点击");
                this.K.d(linkAppTask);
                return;
            }
            com.martian.mibook.lib.model.g.b.J(this.t, "vip-点击");
            com.martian.libmars.activity.j1 j1Var = this.t;
            Book book = this.v;
            String sourceName = book == null ? "" : book.getSourceName();
            Book book2 = this.v;
            com.martian.mibook.j.s2.q0(j1Var, "阅读页-文字链", true, sourceName, book2 != null ? book2.getSourceId() : "");
        }
    }

    /* renamed from: p3, reason: merged with bridge method [inline-methods] */
    public synchronized void u2(final MiReadingContent content) {
        if (this.D.q.f12200c.w.getHeight() == 0) {
            this.D.q.f12200c.w.postDelayed(new Runnable() { // from class: com.martian.mibook.ui.o.i2
                @Override // java.lang.Runnable
                public final void run() {
                    i4.this.u2(content);
                }
            }, 10L);
            return;
        }
        content.clearEndPos();
        this.D.q.f12200c.w.j(content, w0(), m0(), this.I.getAdInterval(), content.getTitle(), O0());
        E2(content);
    }

    private void q0(int contentSize) {
        if (this.I.needRecordRead()) {
            String s0 = s0(null);
            Long l2 = this.I.getChapterIdInfos().get(s0);
            if (l2 != null) {
                if (l2.longValue() < 0 || System.currentTimeMillis() - l2.longValue() > contentSize * 3000) {
                    MiConfigSingleton.V3().l3().J1(6, this.v.getSourceName(), this.v.getSourceId(), this.I.getRecommendId(), "", "", 0, v0(), s0, this.I.getFirstRead());
                }
                this.I.getChapterIdInfos().remove(s0);
            }
            if (this.I.getRecordRead() == 2) {
                this.I.setRecordRead(1);
            }
        }
    }

    /* renamed from: q1 */
    public /* synthetic */ void r1(final MiReadingContent content, final ChapterCommentCount commentCount, final String chapterId, View v2) {
        D2(commentCount, chapterId, content.getChapter() == null ? "" : content.getChapter().getTitle());
    }

    private AppTaskList r0(b.d adConfig, boolean currentIsAdPage) {
        AppTaskList appTaskList = this.S.get(adConfig.b());
        if (appTaskList != null) {
            return appTaskList;
        }
        if (!this.U.isEmpty()) {
            appTaskList = this.U.remove(0);
        } else if (currentIsAdPage && !this.T.isEmpty()) {
            com.martian.mibook.lib.model.g.b.o(this.t, "插页复用");
            appTaskList = this.S.remove(this.T.removeFirst());
        }
        if (appTaskList != null && appTaskList.getApps() != null && !appTaskList.getApps().isEmpty()) {
            Iterator<AppTask> it = appTaskList.getApps().iterator();
            while (it.hasNext()) {
                it.next().setAdTag(adConfig.b());
            }
            this.S.put(adConfig.b(), appTaskList);
            this.T.add(adConfig.b());
        }
        if (this.T.size() >= 3) {
            com.martian.mibook.application.g0.q(this.S.remove(this.T.removeFirst()));
        }
        if (this.U.isEmpty()) {
            new Handler().postDelayed(new Runnable() { // from class: com.martian.mibook.ui.o.j2
                @Override // java.lang.Runnable
                public final void run() {
                    i4.this.v1();
                }
            }, appTaskList == null ? 100L : 5000L);
        }
        return appTaskList;
    }

    /* renamed from: r2 */
    public /* synthetic */ void s2(final y holder, final AppTask appTask, final View adFinalView, final ViewGroup parentView, final boolean firstAd, final MyDrawTextView myDrawTextView, final b.d readingAdConfig) {
        if (holder.q.getGlobalVisibleRect(new Rect()) || appTask.customView != null) {
            View findViewById = adFinalView == null ? null : adFinalView.findViewById(R.id.btn_native_creative_view);
            this.J.g(this.t, appTask, parentView, appTask.customView == null ? adFinalView : parentView, adFinalView != null ? adFinalView.findViewById(R.id.iv_ads_video) : null, findViewById, true);
            if (firstAd) {
                ReadingInfo readingInfo = this.I;
                if (readingInfo != null) {
                    if (readingInfo.isEnableBaeAdInfo() && appTask.getEcpm() > 30) {
                        if (this.s0 == null) {
                            this.s0 = new AdConfig.AdInfo();
                        }
                        this.s0.setSource(appTask.source);
                        this.s0.setEcpm(appTask.getEcpm());
                    }
                    if (appTask.getEcpm() >= this.I.getAdFlowOptimizeEcpm()) {
                        com.martian.libmars.utils.h0.d(findViewById);
                    }
                }
                u3(adFinalView, appTask);
                if (MiBookManager.B2(appTask)) {
                    if (appTask.isCoverView()) {
                        final AutoScrollView autoScrollView = (AutoScrollView) holder.q.findViewById(R.id.book_ad_text_view);
                        if (autoScrollView != null) {
                            autoScrollView.postDelayed(new Runnable() { // from class: com.martian.mibook.ui.o.e3
                                @Override // java.lang.Runnable
                                public final void run() {
                                    AutoScrollView.this.b();
                                }
                            }, 1500L);
                        }
                    } else {
                        final AutoScrollView autoScrollView2 = (AutoScrollView) holder.q.findViewById(R.id.book_ad_content_view);
                        if (autoScrollView2 != null) {
                            autoScrollView2.postDelayed(new Runnable() { // from class: com.martian.mibook.ui.o.e3
                                @Override // java.lang.Runnable
                                public final void run() {
                                    AutoScrollView.this.b();
                                }
                            }, 1500L);
                        }
                    }
                }
                if (MiConfigSingleton.V3().j5() || O0() || this.N <= 0 || System.currentTimeMillis() - this.O < this.N) {
                    return;
                }
                this.O = System.currentTimeMillis();
                this.D.q.f12206i.setTouchable(false);
                this.D.q.f12206i.w(myDrawTextView.m(readingAdConfig.a()), (r1 + readingAdConfig.a()) - f14428j);
            }
        }
    }

    /* renamed from: s1 */
    public /* synthetic */ void t1(final ViewGroup adView, final AppTask linkAppTask) {
        if (adView.getGlobalVisibleRect(new Rect())) {
            com.martian.mibook.lib.model.g.b.J(this.t, "广告-曝光");
            this.K.g(this.t, linkAppTask, adView, adView, null, null, true);
        }
    }

    private Chapter t0(int index) {
        ChapterList chapterList = this.u;
        if (chapterList == null || index >= chapterList.getCount()) {
            return null;
        }
        Chapter item = this.u.getItem(index);
        if (item != null) {
            return item;
        }
        this.t.k1("加载出错，请重试");
        MiChapter miChapter = new MiChapter();
        miChapter.setTitle("未知");
        miChapter.setLink("未知");
        return miChapter;
    }

    private void t3() {
        ReadingInfo readingInfo;
        if (System.currentTimeMillis() - this.f0 <= 120000 || (readingInfo = this.I) == null || readingInfo.getRecord() == null) {
            return;
        }
        this.f0 = System.currentTimeMillis();
        MiConfigSingleton.V3().l3().W0(this.I.getRecord(), true);
    }

    /* renamed from: u1 */
    public /* synthetic */ void v1() {
        com.martian.mibook.application.h0 h0Var = this.V;
        Book book = this.v;
        h0Var.k(book == null ? "" : book.getSourceString(), this.s0);
    }

    private void u3(View adFinalView, AppTask appTask) {
        TextView textView;
        if (!this.I.enableFlowAdClickGuide() || appTask.getEcpm() < this.I.getAdFlowOptimizeEcpm() || AdConfig.AdType.EXPRESS.equalsIgnoreCase(appTask.adsType) || AdConfig.UnionType.HW.equalsIgnoreCase(appTask.source) || VivoAd.isVivoAd(appTask) || adFinalView == null || (textView = (TextView) adFinalView.findViewById(R.id.ad_click_guide)) == null || !Z2()) {
            return;
        }
        textView.setVisibility(0);
        this.Q = appTask.getAdTag();
        com.martian.mibook.lib.model.g.b.J(this.t, "点击引导-信息流-曝光-新");
    }

    /* renamed from: w1 */
    public /* synthetic */ void x1(View v2) {
        OfflineLinkParams offlineLinkParams = new OfflineLinkParams();
        if (com.martian.libsupport.l.w(this.t)) {
            offlineLinkParams.setNotchHeight(com.martian.libmars.d.h.i1(ImmersionBar.getStatusBarHeight(this.t)));
        }
        offlineLinkParams.setCtype(MiConfigSingleton.V3().k());
        MiWebViewActivity.g5(this.t, offlineLinkParams.toHttpUrl("UTF8"), false);
    }

    private void w2() {
        int nextInt = new Random().nextInt(100) + 1;
        if (nextInt <= this.o0 || MiConfigSingleton.V3().u5()) {
            com.martian.libmars.activity.j1 j1Var = this.t;
            Book book = this.v;
            com.martian.mibook.b.b i0 = com.martian.mibook.b.b.i0(j1Var, book == null ? "" : book.getSourceString());
            i0.T0(new g());
            i0.F();
            return;
        }
        int i2 = this.o0;
        int i3 = this.p0;
        if (nextInt <= i2 + i3) {
            AppTask appTask = new AppTask();
            appTask.id = com.martian.mibook.application.k0.O1;
            appTask.source = AdConfig.UnionType.DEFAULT;
            this.n0.add(appTask);
            return;
        }
        if (nextInt <= i2 + i3 + this.q0) {
            AppTask appTask2 = new AppTask();
            appTask2.id = com.martian.mibook.application.k0.P1;
            appTask2.source = AdConfig.UnionType.DEFAULT;
            this.n0.add(appTask2);
            return;
        }
        AppTask appTask3 = new AppTask();
        appTask3.id = com.martian.mibook.application.k0.N1;
        appTask3.source = AdConfig.UnionType.DEFAULT;
        this.n0.add(appTask3);
    }

    public void x2(final MiReadingContent content) {
        MiConfigSingleton.V3().l3().p(this.v, new e(content));
    }

    private void x3(TextView contentView, TextView titleView) {
        contentView.setTextSize(MiConfigSingleton.V3().H3());
        contentView.setLineSpacing(0.0f, MiConfigSingleton.V3().S3());
        com.martian.mibook.j.x2.c(contentView);
        if (titleView != null) {
            com.martian.mibook.j.x2.c(titleView);
            titleView.setTextSize(r0 + 6);
        }
    }

    private String y0() {
        Book book = this.v;
        if (book instanceof YWBook) {
            return this.t.getString(R.string.book_copyright_yw);
        }
        if (!(book instanceof TFBook)) {
            return book instanceof ORBook ? this.t.getString(R.string.book_copyright_txs) : "";
        }
        String cpName = ((TFBook) book).getCpName();
        if (com.martian.libsupport.k.p(cpName)) {
            return "";
        }
        return this.t.getString(R.string.book_copyright_hint1) + cpName + this.t.getString(R.string.book_copyright_hint);
    }

    /* renamed from: y1 */
    public /* synthetic */ void z1(final t lastViewHolder, final View lastPageView, View v2) {
        lastViewHolder.f14472d.setVisibility(0);
        lastViewHolder.f14473e.setVisibility(8);
        y2(false, lastPageView);
    }

    private void y2(boolean fromSlide, final View lastPageView) {
        List<TYBookItem> list;
        if (fromSlide && (list = this.Z) != null) {
            G2(list, lastPageView, true);
            return;
        }
        if (this.a0 == null) {
            MiBookManager.m0 m0Var = new MiBookManager.m0();
            this.a0 = m0Var;
            m0Var.l(0);
            this.a0.n(6);
            this.a0.o(new Random().nextInt(10000));
            this.a0.q(this.v.getSourceName());
            this.a0.p(this.v.getSourceId());
            this.a0.j(this.v.getBookName());
        }
        MiConfigSingleton.V3().l3().T1(this.a0, new m(lastPageView, fromSlide));
    }

    private void y3(MyDrawTextView contentView) {
        contentView.setTextSize(MiConfigSingleton.V3().H3());
        contentView.t();
        contentView.v();
    }

    private boolean z2() {
        if (this.I.getVideoUnlock() <= 0 || this.I.isDisableAd() || v0() < this.I.getVideoUnlock() || MiConfigSingleton.V3().H(this.v.getSourceString())) {
            return false;
        }
        return MiConfigSingleton.V3().z6();
    }

    private void z3(MyDrawTextView contentView, View background) {
        contentView.setTextColor(MiConfigSingleton.V3().J4.r().getTextColorPrimary());
        if (background == null || O0()) {
            return;
        }
        X2(background);
    }

    public MiReadingContent A0() {
        MiReadingContent.MiContentCursor c2 = c();
        if (c2 == null) {
            return null;
        }
        return c2.getContent();
    }

    public void A2(int options) {
        if (options == 0) {
            this.D.q.f12200c.w.setTextSize(MiConfigSingleton.V3().H3());
            this.D.q.f12200c.w.t();
        } else if (options == 1) {
            this.D.q.f12200c.w.v();
        } else if (options == 2) {
            this.D.q.f12200c.w.t();
        }
        Iterator<y> it = this.F.iterator();
        while (it.hasNext()) {
            y3(it.next().f14489f);
        }
        L2();
    }

    public void A3(String timeInStr) {
        this.G = timeInStr;
        Iterator<y> it = this.F.iterator();
        while (it.hasNext()) {
            it.next().n.setText(timeInStr);
        }
    }

    public void B2() {
        for (y yVar : this.F) {
            z3(yVar.f14489f, yVar.f14493j);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void B3() {
        d dVar = new d(this.t);
        ((VideoBonusCompleteParams) dVar.k()).setSourceId(this.v.getSourceId());
        ((VideoBonusCompleteParams) dVar.k()).setSourceName(this.v.getSourceName());
        ((VideoBonusCompleteParams) dVar.k()).setChapterId(s0(null));
        ((VideoBonusCompleteParams) dVar.k()).setBookName(this.v.getBookName());
        if (this.B.getChapter() != null) {
            ((VideoBonusCompleteParams) dVar.k()).setChapterName(this.B.getChapter().getTitle());
        }
        dVar.j();
    }

    @Override // com.martian.libsliding.e
    /* renamed from: E0 */
    public MiReadingContent.MiContentCursor e() {
        if (this.B.isReady() && this.x < this.B.getEndPosSize() - 1) {
            return this.B.getContentCursor(this.x + 1);
        }
        if (this.w + 1 == w0()) {
            return null;
        }
        if (this.C.isEmpty()) {
            this.C.setChapterIndex(this.w + 1);
            this.C.setChapter(t0(this.w + 1));
            q3(this.C);
        }
        return this.C.getContentCursor(-2);
    }

    @Override // com.martian.libsliding.e
    /* renamed from: F0 */
    public MiReadingContent.MiContentCursor g() {
        int i2;
        if (this.B.isReady() && (i2 = this.x) > 0) {
            return this.B.getContentCursor(i2 - 1);
        }
        if (this.w <= 0) {
            return null;
        }
        if (this.A.isEmpty()) {
            this.A.setChapterIndex(this.w - 1);
            this.A.setChapter(t0(this.w - 1));
            q3(this.A);
        }
        return this.A.getContentCursor(-1);
    }

    public void F2(AppTaskList appTaskList) {
        this.U.add(appTaskList);
        j();
        k();
    }

    public MiReadingContent G0() {
        return this.A;
    }

    @SuppressLint({"SetTextI18n"})
    public void G2(List<TYBookItem> books, View lastPageView, boolean fromSlide) {
        if (com.martian.libmars.utils.n0.c(this.t)) {
            return;
        }
        boolean z = this.Z != books;
        if (z) {
            this.Z = books;
            MiBookManager.m0 m0Var = this.a0;
            if (m0Var != null) {
                m0Var.h();
            }
        }
        t tVar = (t) lastPageView.getTag();
        if (tVar == null || tVar.f14476h == null) {
            return;
        }
        ProgressBar progressBar = tVar.f14472d;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        ImageView imageView = tVar.f14473e;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        if (books == null) {
            tVar.f14471c.setVisibility(8);
            return;
        }
        tVar.f14471c.setVisibility(0);
        if (z || tVar.f14476h.getChildCount() <= 0) {
            if (tVar.f14476h.getChildCount() > 0) {
                tVar.f14476h.removeAllViews();
            }
            if (tVar.f14478j.getChildCount() > 0) {
                tVar.f14478j.removeAllViews();
            }
            Iterator<TYBookItem> it = this.Z.iterator();
            int i2 = 0;
            for (int i3 = 8; it.hasNext() && i2 < i3; i3 = 8) {
                i2++;
                final TYBookItem next = it.next();
                View inflate = this.t.getLayoutInflater().inflate(R.layout.last_page_book_item, (ViewGroup) null);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.grid_item_view);
                ImageView imageView2 = (ImageView) inflate.findViewById(R.id.author_book_cover);
                TextView textView = (TextView) inflate.findViewById(R.id.author_book_name);
                TextView textView2 = (TextView) inflate.findViewById(R.id.author_book_category);
                TextView textView3 = (TextView) inflate.findViewById(R.id.author_book_score);
                com.martian.libmars.utils.n0.p(this.t, next.getCover(), imageView2, MiConfigSingleton.V3().i3(), MiConfigSingleton.V3().e2(), 2);
                textView.setText(next.getBookName());
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.n1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        i4.this.N1(next, view);
                    }
                });
                linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.o1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        i4.this.P1(next, view);
                    }
                });
                textView2.setVisibility(8);
                textView3.setVisibility(8);
                MiConfigSingleton.V3().l3().I1(0, next.getSourceName(), next.getSourceId(), next.getRecommendId(), "", "展示");
                if (i2 == 1) {
                    if (fromSlide) {
                        com.martian.mibook.lib.model.g.b.S(this.t, next.getRecommend(), "展示");
                    } else {
                        com.martian.mibook.lib.model.g.b.S(this.t, next.getRecommend(), "换一批");
                    }
                }
                if (next.getScore() > 0) {
                    textView2.setVisibility(8);
                    textView3.setVisibility(0);
                    StringBuilder sb = new StringBuilder();
                    Locale locale = Locale.getDefault();
                    double score = next.getScore();
                    Double.isNaN(score);
                    sb.append(String.format(locale, "%.1f", Double.valueOf(score / 10.0d)));
                    sb.append("分");
                    textView3.setText(sb.toString());
                } else {
                    textView2.setVisibility(0);
                    textView3.setVisibility(8);
                    textView2.setText(next.getBookInfo());
                }
                if (i2 <= 4) {
                    tVar.f14476h.addView(inflate);
                } else {
                    tVar.f14478j.addView(inflate);
                }
            }
            u();
        }
    }

    @Override // com.martian.libsliding.e
    @SuppressLint({"InflateParams"})
    /* renamed from: H0 */
    public View n(View contentView, final MiReadingContent.MiContentCursor cursor) {
        y yVar;
        if (contentView == null) {
            contentView = LayoutInflater.from(this.t).inflate(R.layout.reading_layout, (ViewGroup) null);
            a6 a2 = a6.a(contentView);
            a2.getRoot().setVisibility(0);
            yVar = new y();
            yVar.f14484a = a2.t;
            yVar.f14485b = a2.o.getRoot();
            yVar.f14486c = a2.p.getRoot();
            yVar.f14487d = a2.n.getRoot();
            yVar.f14488e = a2.s.getRoot();
            yVar.v = a2.f11703b.getRoot();
            yVar.f14489f = a2.w;
            yVar.f14490g = a2.x;
            LinearLayout linearLayout = a2.y;
            yVar.f14491h = linearLayout;
            ((ReadingActivity) this.t).k7(linearLayout, 12);
            yVar.f14492i = a2.m;
            yVar.f14493j = a2.q;
            yVar.k = a2.r.getRoot();
            u5 u5Var = a2.r;
            yVar.l = u5Var.f12793c;
            yVar.m = u5Var.f12794d;
            yVar.n = u5Var.f12797g;
            yVar.o = u5Var.f12795e;
            yVar.p = u5Var.f12796f;
            yVar.q = a2.u.getRoot();
            yVar.r = a2.f11705d;
            yVar.w = a2.k;
            yVar.y = a2.f11706e;
            yVar.x = a2.f11711j;
            yVar.z = a2.f11710i;
            yVar.A = a2.f11708g;
            yVar.B = a2.f11709h;
            yVar.C = a2.f11707f;
            yVar.s = a2.l;
            yVar.t = a2.f11704c;
            yVar.u = a2.v;
            if (O0()) {
                yVar.f14491h.setVisibility(8);
                yVar.k.setVisibility(8);
            } else {
                yVar.f14491h.setVisibility(0);
                yVar.k.setVisibility(0);
            }
            this.F.add(yVar);
            y3(yVar.f14489f);
            z3(yVar.f14489f, yVar.f14493j);
            contentView.setTag(yVar);
        } else {
            yVar = (y) contentView.getTag();
        }
        yVar.f14493j.setPadding(0, 0, 0, a3() ? 0 : com.martian.libmars.d.h.b(64.0f));
        yVar.f14484a.setVisibility(8);
        yVar.f14485b.setVisibility(8);
        yVar.q.setVisibility(8);
        yVar.r.setVisibility(8);
        yVar.w.setVisibility(8);
        this.D.q.f12206i.setTouchable(true);
        yVar.v.setVisibility(8);
        yVar.f14488e.setVisibility(8);
        yVar.f14486c.setVisibility(8);
        yVar.f14492i.setVisibility(4);
        yVar.f14487d.setVisibility(8);
        yVar.k.setVisibility(O0() ? 8 : 0);
        yVar.o.setClickable(false);
        if (cursor == null) {
            K0(this.x < 0);
            if (this.w > 0) {
                g3(yVar, false);
            } else if (this.x < 0) {
                c3(yVar);
            }
            return contentView;
        }
        yVar.m.setProgress(this.H);
        yVar.n.setText(this.G);
        MiReadingContent content = cursor.getContent();
        if (content.isLoading()) {
            yVar.f14484a.setVisibility(0);
            yVar.p.setText("");
        } else if (content.isBuyingStatus()) {
            d3(yVar, content);
        } else if (content.isContentError()) {
            e3(yVar, content);
        } else {
            if (z2()) {
                b3(yVar, content, cursor.getContentIndex());
                return contentView;
            }
            yVar.f14492i.setVisibility(0);
            int endPosSize = cursor.getContent().getEndPosSize();
            if (cursor.getContentIndex() == -1) {
                cursor.setContentIndex(endPosSize - 1);
            } else if (cursor.getContentIndex() == -2) {
                cursor.setContentIndex(0);
            }
            PageInfo pageInfo = cursor.getPageInfo();
            yVar.f14489f.setPageInfo(pageInfo);
            String title = cursor.getContent().getTitle();
            yVar.o.setText(this.I.getReadingHint());
            Y2(yVar.f14490g, this.D.q.l, title);
            Y2(yVar.p, this.D.q.f12207j, pageInfo.getProgressStatus());
            int contentIndex = cursor.getContentIndex();
            if (contentIndex == 0) {
                Book book = this.v;
                if (book != null && !com.martian.libsupport.k.p(book.getBookName())) {
                    Y2(yVar.f14490g, this.D.q.l, "《" + this.v.getBookName() + "》");
                }
                if (x0() == 0) {
                    K0(false);
                    m3(true);
                    J0(false);
                    t3();
                    if (!P0()) {
                        if (v0() == this.Y) {
                            l3(0, "章首");
                        } else {
                            KeyEventDispatcher.Component component = this.t;
                            if (component instanceof w) {
                                ((w) component).l0();
                            }
                        }
                    }
                }
            } else {
                if (contentIndex == x0()) {
                    if (contentIndex + 1 == endPosSize) {
                        K0(false);
                        q0(endPosSize);
                    } else if (this.I.getRecordRead() == 2) {
                        m3(false);
                    }
                    if (contentIndex == 1 || contentIndex + 2 == endPosSize) {
                        g0(v0());
                    }
                }
                l0(yVar, yVar.f14489f, cursor.getContent(), contentIndex);
            }
        }
        return contentView;
    }

    public void H2(int type, String action) {
        String str = action + "-";
        int W2 = MiConfigSingleton.V3().W2(this.I.isVideoAdWatched());
        if (type == l) {
            str = str + "信息流-" + W2;
        } else if (type == m) {
            str = str + "缓存章节";
        } else if (type == n) {
            str = str + "听书";
        } else if (type == s) {
            str = str + "自动阅读";
        } else if (type == o) {
            if (this.I.isVideoAdWatched()) {
                str = str + "二次弹窗-" + W2;
            } else {
                str = str + "弹窗-" + W2;
            }
        } else if (type == p) {
            str = str + "Banner-" + W2;
        }
        com.martian.mibook.lib.model.g.b.i0(this.t, str);
    }

    public void I0(int minutes) {
        if (minutes <= 0) {
            return;
        }
        boolean m0 = m0();
        MiConfigSingleton.V3().T6(minutes);
        ReadingInfo readingInfo = this.I;
        if (readingInfo != null) {
            readingInfo.setVideoAdWatched(true);
        }
        com.martian.libmars.activity.j1 j1Var = this.t;
        if (j1Var instanceof ReadingActivity) {
            ReadingActivity readingActivity = (ReadingActivity) j1Var;
            readingActivity.X7();
            readingActivity.E7(true, true);
            readingActivity.Q7();
        }
        N2(m0);
    }

    public void I2(final boolean success) {
        com.martian.libmars.activity.j1 j1Var = this.t;
        if (j1Var instanceof w) {
            j1Var.runOnUiThread(new Runnable() { // from class: com.martian.mibook.ui.o.f2
                @Override // java.lang.Runnable
                public final void run() {
                    i4.this.R1(success);
                }
            });
        }
    }

    public synchronized void L2() {
        if (this.B.isReady()) {
            this.B.setLoading();
            u2(this.B);
        }
        if (this.A.isReady()) {
            this.A.setLoading();
            u2(this.A);
        }
        if (this.C.isReady()) {
            this.C.setLoading();
            u2(this.C);
        }
    }

    public void M2() {
        Bitmap bitmap;
        Drawable drawable = this.c0;
        if (drawable == null || !(drawable instanceof BitmapDrawable) || (bitmap = ((BitmapDrawable) drawable).getBitmap()) == null || bitmap.isRecycled()) {
            return;
        }
        bitmap.recycle();
        System.gc();
    }

    public boolean N0() {
        return this.B.isContentError() || this.B.isBuying() || this.B.isUnBounght() || this.B.isPrebuyError() || this.B.isBuyingError();
    }

    public void N2(boolean z) {
        ReadingInfo readingInfo;
        if (m0() == z || (readingInfo = this.I) == null) {
            return;
        }
        if (readingInfo.getAdInterval() > 0 && x0() >= this.I.getAdInterval()) {
            if (z) {
                this.x = Math.max(0, (x0() - (x0() / (this.I.getAdInterval() + 1))) - (a3() ? 1 : 0));
            } else {
                this.x = x0() + (x0() / this.I.getAdInterval());
            }
        }
        L2();
    }

    public synchronized void O2() {
        this.A.reset();
        this.B.reset();
        this.C.reset();
        u();
    }

    public boolean P0() {
        ReadingInfo readingInfo = this.I;
        return readingInfo != null && readingInfo.isTtsMode();
    }

    public void P2() {
        this.Y = -100;
    }

    public boolean Q0() {
        Chapter chapter;
        MiReadingContent miReadingContent = this.B;
        return (miReadingContent == null || (chapter = miReadingContent.getChapter()) == null || !chapter.isVipChapter()) ? false : true;
    }

    public boolean R2(int chapterIndex) {
        if (chapterIndex > 0 || this.x > 0 || !this.I.isStartWithCover()) {
            this.w = chapterIndex;
            return false;
        }
        this.I.setStartWithCover(false);
        this.w = -1;
        this.x = -1;
        return true;
    }

    public void S2(ChapterList chapterList) {
        this.u = chapterList;
    }

    public void T2(int index) {
        if (this.x == index) {
            return;
        }
        this.x = index;
        u();
    }

    public void U2(int contentIndex, int contentSize) {
        if (contentSize == 0) {
            this.y = -1;
            this.x = contentIndex;
            this.z = 0;
            return;
        }
        this.y = contentIndex;
        this.z = contentSize;
        MiReadingContent miReadingContent = this.B;
        if (miReadingContent == null || !miReadingContent.isReady()) {
            return;
        }
        this.x = this.B.findContentIndex((this.y * this.B.getChapterContent().getContentLength()) / contentSize);
        this.y = -1;
    }

    public void V(ChapterCommentCount commentCount) {
        this.t0.put(commentCount.getChapterId(), commentCount);
        u();
    }

    public void V2(boolean isScrollMode) {
        this.E = isScrollMode;
    }

    public void W(TYBookItem tyBookItem) {
        if (MiConfigSingleton.V3().l3().v0(tyBookItem.buildMibook())) {
            return;
        }
        MiConfigSingleton.V3().l3().m(tyBookItem.getSource(), new f(tyBookItem));
    }

    public void W2(u l2) {
        this.b0 = l2;
    }

    public void X2(View view) {
        MiReadingTheme r2 = MiConfigSingleton.V3().J4.r();
        if (r2.isColorBackground()) {
            view.setBackgroundColor(r2.getBackgroundPrimary());
            return;
        }
        if (this.c0 == null || !r2.getBackgroundImagePath().equalsIgnoreCase(this.d0)) {
            String backgroundImagePath = r2.getBackgroundImagePath();
            this.d0 = backgroundImagePath;
            this.c0 = h0(backgroundImagePath);
        }
        Drawable drawable = this.c0;
        if (drawable == null) {
            view.setBackgroundColor(r2.getBackgroundPrimary());
            return;
        }
        try {
            view.setBackground(drawable);
        } catch (Exception unused) {
            view.setBackgroundColor(r2.getBackgroundPrimary());
        }
    }

    @Override // com.martian.libsliding.e
    public void a() {
        if (this.B.isReady() && this.x < this.B.getEndPosSize() - 1) {
            this.x++;
            return;
        }
        this.w++;
        this.x = -2;
        this.A.reset();
        MiReadingContent miReadingContent = this.B;
        MiReadingContent miReadingContent2 = this.C;
        this.B = miReadingContent2;
        this.C = this.A;
        this.A = miReadingContent;
        if (miReadingContent2 == null || !miReadingContent2.isReady()) {
            return;
        }
        this.x = 0;
    }

    public boolean a3() {
        MiReadingContent A0;
        if (this.I.shouldHideAd()) {
            return true;
        }
        return (this.I.isAdBook() || (A0 = A0()) == null || A0.getChapter() == null || !A0.getChapter().isVipChapter()) ? false : true;
    }

    @Override // com.martian.libsliding.e
    public void b() {
        int i2;
        if (this.B.isReady() && (i2 = this.x) > 0) {
            this.x = i2 - 1;
            return;
        }
        this.w--;
        this.x = -1;
        this.C.reset();
        MiReadingContent miReadingContent = this.B;
        MiReadingContent miReadingContent2 = this.A;
        this.B = miReadingContent2;
        this.A = this.C;
        this.C = miReadingContent;
        if (miReadingContent2 == null || !miReadingContent2.isReady()) {
            return;
        }
        this.x = this.B.getEndPosSize() - 1;
    }

    public boolean f0() {
        return this.I.getInterstitial() > 0 && v0() > 20 && v0() % this.I.getInterstitial() == 0;
    }

    public void g0(int chapterIndex) {
        ReadingInfo readingInfo = this.I;
        if (readingInfo == null || !readingInfo.isEnableWblAd() || chapterIndex < 0 || this.v == null || P0() || System.currentTimeMillis() - this.v0 < 2000) {
            return;
        }
        this.v0 = System.currentTimeMillis();
        MiConfigSingleton.V3().H4().a(this.t, this.v.getSourceString(), chapterIndex + 1, this.W);
    }

    public void i0() {
        Iterator<AppTaskList> it = this.S.values().iterator();
        while (it.hasNext()) {
            com.martian.mibook.application.g0.q(it.next());
        }
        this.S.clear();
        this.T.clear();
        if (!this.U.isEmpty()) {
            Iterator<AppTaskList> it2 = this.U.iterator();
            while (it2.hasNext()) {
                com.martian.mibook.application.g0.q(it2.next());
            }
            this.U.clear();
        }
        Iterator<AppTask> it3 = this.l0.values().iterator();
        while (it3.hasNext()) {
            com.martian.mibook.application.g0.p(it3.next());
        }
        this.l0.clear();
        this.m0.clear();
    }

    public void i3(boolean secondTime, boolean countdownVideo) {
        MiConfigSingleton.V3().M7(MiConfigSingleton.V3().W2(secondTime));
        int i2 = o;
        this.k0 = i2;
        H2(i2, AdConfig.ActionString.CLICK);
        MiConfigSingleton.V3().N4.t(this.t, b.d.a.j.b.k, new c());
        MiConfigSingleton.V3().U6(1);
    }

    public void j3() {
        this.k0 = l;
        MiConfigSingleton.V3().N4.t(this.t, b.d.a.j.b.f4377j, new b());
    }

    public void l3(int activeCall, String from) {
        if (P0() || MiConfigSingleton.V3().h6()) {
            return;
        }
        com.martian.mibook.application.w0 H4 = MiConfigSingleton.V3().H4();
        com.martian.libmars.activity.j1 j1Var = this.t;
        Book book = this.v;
        String sourceString = book == null ? "11" : book.getSourceString();
        int i2 = this.Y;
        if (i2 <= 0) {
            i2 = v0() + 1;
        }
        H4.b(j1Var, sourceString, i2, activeCall, from, this.X);
        MiConfigSingleton.V3().L4.y0();
        P2();
    }

    public boolean m0() {
        ReadingInfo readingInfo = this.I;
        return ((readingInfo != null && readingInfo.getAdInterval() <= 0) || P0() || a3()) ? false : true;
    }

    public void m3(boolean firstPage) {
        if (this.I.needRecordRead()) {
            String s0 = s0(null);
            if (!com.martian.libsupport.k.p(s0) && !this.I.getChapterIdInfos().containsKey(s0)) {
                this.I.getChapterIdInfos().put(s0, Long.valueOf(firstPage ? System.currentTimeMillis() : -1L));
            }
            if (this.I.getRecordRead() == 2) {
                this.I.setRecordRead(1);
            }
        }
    }

    @Override // com.martian.libsliding.e
    public boolean o() {
        if (this.B.isLoading()) {
            return false;
        }
        if (this.B.isReady()) {
            int i2 = this.x;
            if (i2 == -2) {
                return false;
            }
            if (i2 < this.B.getEndPosSize() - 1) {
                return true;
            }
        }
        ChapterList chapterList = this.u;
        return chapterList != null && this.w < chapterList.getCount();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void o0(String errMsg, boolean manual) {
        q qVar = new q(manual);
        String str = "";
        if (!com.martian.libsupport.k.p(this.v.getBookName())) {
            str = "" + this.v.getBookName();
        }
        if (!com.martian.libsupport.k.p(this.v.getSourceId())) {
            str = str + "-" + this.v.getSourceId();
        }
        String s0 = s0(null);
        if (!com.martian.libsupport.k.p(s0)) {
            str = str + "-" + s0;
        }
        if (!com.martian.libsupport.k.p(errMsg)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("-");
            sb.append(errMsg);
            sb.append(manual ? "_manual" : "_silent");
            str = sb.toString();
        }
        ((FeedbackInfoParams) qVar.k()).setSubject(str);
        ((FeedbackInfoParams) qVar.k()).setCategoryId(1);
        ((FeedbackInfoParams) qVar.k()).setSubCategoryId(10003);
        qVar.j();
    }

    @Override // com.martian.libsliding.e
    public boolean p() {
        int i2 = this.w;
        if (i2 == -1) {
            return false;
        }
        if (i2 == 0 && !O0()) {
            return true;
        }
        if (this.B.isLoading()) {
            return false;
        }
        if (this.B.isReady()) {
            int i3 = this.x;
            if (i3 == -1) {
                return false;
            }
            if (i3 > 0) {
                return true;
            }
        }
        return this.w > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void p0(String chapterId, String chapterIds) {
        i iVar = new i(MiBookGetChapterCommentCountParams.class, ChapterCommentCount.class, this.t, chapterId);
        if (!com.martian.libsupport.k.p(chapterIds)) {
            ((MiBookGetChapterCommentCountParams) iVar.k()).setChapterIds(chapterIds);
        }
        ((MiBookGetChapterCommentCountParams) iVar.k()).setSourceName(this.v.getSourceName());
        ((MiBookGetChapterCommentCountParams) iVar.k()).setSourceId(this.v.getSourceId());
        iVar.j();
    }

    public void q3(final MiReadingContent content) {
        if (content == null) {
            return;
        }
        X(content, content.getChapterIndex());
    }

    public void r3(boolean force) {
        if (this.g0) {
            return;
        }
        if (force || this.I.getTagList() == null) {
            this.g0 = true;
            MiConfigSingleton.V3().l3().s2(this.t, this.v, new p());
        }
    }

    public String s0(Chapter chapter) {
        Integer chapterId;
        if (chapter == null) {
            if (v0() < 0) {
                return "";
            }
            chapter = t0(v0());
        }
        if (chapter instanceof YWChapter) {
            Long ccid = ((YWChapter) chapter).getCcid();
            if (ccid != null) {
                return ccid + "";
            }
        } else {
            if (chapter instanceof TFChapter) {
                return ((TFChapter) chapter).getCid();
            }
            if ((chapter instanceof ORChapter) && (chapterId = ((ORChapter) chapter).getChapterId()) != null) {
                return chapterId + "";
            }
        }
        return chapter instanceof TFChapter ? ((TFChapter) chapter).getCid() : "";
    }

    public void s3(final MiReadingContent content) {
        Chapter chapter = content.getChapter();
        if (chapter == null || chapter.isFree() || content.isBuying()) {
            return;
        }
        boolean z = this.B != content;
        if (z && content.isPrebuyError()) {
            return;
        }
        if (MiConfigSingleton.V3().M4.k()) {
            if (MiUserManager.s().A()) {
                d0(content, chapter, z);
                return;
            } else {
                Q2(content);
                return;
            }
        }
        if (!z) {
            this.t.k1("请先登录");
            com.martian.mibook.lib.account.e.d.b(this.t, 10003, false);
        }
        Q2(content);
    }

    public ChapterCommentCount u0(String chapterId, int startIndex) {
        Integer chapterId2;
        if (this.t0.containsKey(chapterId)) {
            return this.t0.get(chapterId);
        }
        if (this.u0) {
            return null;
        }
        this.u0 = true;
        if (startIndex < 0 || startIndex >= this.u.getCount()) {
            this.u0 = false;
            return null;
        }
        int min = Math.min(this.u.getCount(), startIndex + 5);
        String str = "";
        while (startIndex < min) {
            Chapter item = this.u.getItem(startIndex);
            String s0 = s0(item);
            if (item instanceof YWChapter) {
                Long ccid = ((YWChapter) item).getCcid();
                if (ccid != null) {
                    s0 = ccid + "";
                }
            } else if (item instanceof TFChapter) {
                s0 = ((TFChapter) item).getCid();
            } else if ((item instanceof ORChapter) && (chapterId2 = ((ORChapter) item).getChapterId()) != null) {
                s0 = chapterId2 + "";
            }
            if (!com.martian.libsupport.k.p(s0)) {
                ChapterCommentCount chapterCommentCount = new ChapterCommentCount();
                chapterCommentCount.setNComments(0);
                chapterCommentCount.setChapterId(s0);
                this.t0.put(s0, chapterCommentCount);
                if (com.martian.libsupport.k.p(str)) {
                    str = s0;
                } else {
                    str = str + "," + s0;
                }
            }
            startIndex++;
        }
        p0(chapterId, str);
        return null;
    }

    @Override // com.martian.libsliding.e
    public void v() {
        super.v();
        i0();
    }

    public int v0() {
        return this.w;
    }

    public void v2(final int type) {
        H2(type, AdConfig.ActionString.CLICK);
        this.k0 = type;
        MiConfigSingleton.V3().N4.t(this.t, b.d.a.j.b.f4373f, new a());
    }

    public void v3(int progress) {
        this.H = progress;
        Iterator<y> it = this.F.iterator();
        while (it.hasNext()) {
            it.next().m.setProgress(progress);
        }
    }

    public int w0() {
        ChapterList chapterList = this.u;
        if (chapterList == null) {
            return 0;
        }
        return chapterList.getCount();
    }

    public void w3(ChapterCommentCount commentCount) {
        this.t0.put(commentCount.getChapterId(), commentCount);
        u();
    }

    public int x0() {
        return this.x;
    }

    @Override // com.martian.libsliding.e
    /* renamed from: z0 */
    public MiReadingContent.MiContentCursor c() {
        int i2 = this.w;
        if (i2 < 0 || i2 == w0()) {
            return null;
        }
        if (this.B.isEmpty()) {
            this.B.setChapterIndex(this.w);
            this.B.setChapter(t0(this.w));
            q3(this.B);
        }
        if (this.B.isReady()) {
            int i3 = this.x;
            if (i3 == -1) {
                this.x = this.B.getEndPosSize() - 1;
            } else if (i3 == -2) {
                this.x = 0;
            }
            K2();
        }
        return this.B.getContentCursor(this.x);
    }
}
