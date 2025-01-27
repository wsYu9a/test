package com.martian.mibook.j;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.gyf.barlibrary.ImmersionBar;
import com.martian.ads.ad.AdConfig;
import com.martian.apptask.data.AppTask;
import com.martian.appwall.request.WithdrawCommissionParams;
import com.martian.appwall.request.WithdrawMoneyParams;
import com.martian.appwall.response.MartianAppwallTask;
import com.martian.free.response.TFChapter;
import com.martian.libfeedback.request.url.FeedbackReportUrlParams;
import com.martian.libfeedback.request.url.FeedbackUrlParams;
import com.martian.libmars.utils.k0;
import com.martian.mibook.activity.MiQrcodeActivity;
import com.martian.mibook.activity.ReadingRechargeActivity;
import com.martian.mibook.activity.ShareImageUrlActivity;
import com.martian.mibook.activity.account.TXSRechargeActivity;
import com.martian.mibook.activity.appwall.AppwallTaskDetailActivity;
import com.martian.mibook.activity.base.MiWebViewActivity;
import com.martian.mibook.activity.book.BookInfoActivity;
import com.martian.mibook.activity.book.BookRankActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.ShareInfo;
import com.martian.mibook.data.book.Comment;
import com.martian.mibook.lib.account.MiUserManager;
import com.martian.mibook.lib.account.request.BookShareParams;
import com.martian.mibook.lib.account.request.CommentDetailParams;
import com.martian.mibook.lib.account.request.MessageParams;
import com.martian.mibook.lib.account.request.RechargeParams;
import com.martian.mibook.lib.account.request.UserCommentsParams;
import com.martian.mibook.lib.account.request.VipLinkParams;
import com.martian.mibook.lib.model.data.MiBook;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import com.martian.mibook.lib.model.data.Source;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.original.data.ORChapter;
import com.martian.mibook.lib.yuewen.response.TYInitialBook;
import com.martian.mibook.lib.yuewen.response.YWBookBanner;
import com.martian.mibook.lib.yuewen.response.YWChapter;
import com.martian.ttbookhd.R;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class s2 {

    static class a implements com.martian.mibook.lib.model.d.b {

        /* renamed from: a */
        final /* synthetic */ com.martian.libmars.activity.j1 f13550a;

        /* renamed from: b */
        final /* synthetic */ String f13551b;

        /* renamed from: c */
        final /* synthetic */ String f13552c;

        /* renamed from: d */
        final /* synthetic */ String f13553d;

        /* renamed from: e */
        final /* synthetic */ String f13554e;

        a(final com.martian.libmars.activity.j1 val$sourceName, final String val$sourceId, final String val$recommendId, final String val$recommend, final String val$activity) {
            this.f13550a = val$sourceName;
            this.f13551b = val$sourceId;
            this.f13552c = val$recommendId;
            this.f13553d = val$recommend;
            this.f13554e = val$activity;
        }

        @Override // com.martian.mibook.lib.model.d.b
        public void a(Book book) {
            if (!com.martian.libmars.utils.n0.C(this.f13550a) || book == null) {
                return;
            }
            MiBook buildMibook = book.buildMibook();
            if (!MiConfigSingleton.V3().l3().v0(buildMibook)) {
                MiConfigSingleton.V3().l3().T0(buildMibook);
                MiConfigSingleton.V3().l3().d(this.f13550a, buildMibook, book);
            }
            TYInitialBook tYInitialBook = new TYInitialBook();
            tYInitialBook.convertYwBookItem(book);
            tYInitialBook.setRecommend(this.f13551b);
            tYInitialBook.setRecommendId(this.f13552c);
            tYInitialBook.setReason(this.f13550a.getString(R.string.guess_you_like));
            v2.P0(this.f13550a, tYInitialBook);
        }

        @Override // com.martian.mibook.lib.model.d.b
        public void onLoading(boolean loading) {
        }

        @Override // com.martian.mibook.lib.model.d.b
        public void onResultError(b.d.c.b.c errorResult) {
            s2.T(this.f13550a, this.f13553d, this.f13554e, this.f13551b, this.f13552c);
        }
    }

    static class b implements com.martian.mibook.lib.model.d.b {

        /* renamed from: a */
        final /* synthetic */ YWBookBanner f13555a;

        /* renamed from: b */
        final /* synthetic */ com.martian.libmars.activity.j1 f13556b;

        b(final YWBookBanner val$activity, final com.martian.libmars.activity.j1 val$ywBookBanner) {
            this.f13555a = val$activity;
            this.f13556b = val$ywBookBanner;
        }

        @Override // com.martian.mibook.lib.model.d.b
        public void a(Book book) {
            MiBook buildMibook = this.f13555a.buildMibook();
            if (buildMibook == null || com.martian.libsupport.k.p(buildMibook.getBookId())) {
                return;
            }
            MiConfigSingleton.V3().l3().T0(buildMibook);
            s2.f0(this.f13556b, buildMibook, book);
        }

        @Override // com.martian.mibook.lib.model.d.b
        public void onLoading(boolean loading) {
        }

        @Override // com.martian.mibook.lib.model.d.b
        public void onResultError(b.d.c.b.c errorResult) {
            s2.R(this.f13556b, this.f13555a);
        }
    }

    static class c implements com.martian.mibook.lib.model.d.b {

        /* renamed from: a */
        final /* synthetic */ com.martian.libmars.activity.j1 f13557a;

        /* renamed from: b */
        final /* synthetic */ Book f13558b;

        c(final com.martian.libmars.activity.j1 val$mBook, final Book val$activity) {
            this.f13557a = val$mBook;
            this.f13558b = val$activity;
        }

        @Override // com.martian.mibook.lib.model.d.b
        public void a(Book book) {
            if (com.martian.libmars.utils.n0.c(this.f13557a)) {
                return;
            }
            if (book == null) {
                s2.R(this.f13557a, this.f13558b);
                return;
            }
            String sourceString = book.getSourceString();
            if (com.martian.libsupport.k.p(sourceString) || !sourceString.equalsIgnoreCase(this.f13558b.getSourceString())) {
                s2.R(this.f13557a, book);
                return;
            }
            MiBook buildMibook = this.f13558b.buildMibook();
            MiConfigSingleton.V3().l3().T0(buildMibook);
            s2.f0(this.f13557a, buildMibook, this.f13558b);
        }

        @Override // com.martian.mibook.lib.model.d.b
        public void onLoading(boolean loading) {
        }

        @Override // com.martian.mibook.lib.model.d.b
        public void onResultError(b.d.c.b.c errorResult) {
            s2.R(this.f13557a, this.f13558b);
        }
    }

    private static class d extends AsyncTask<String, Void, Bitmap> {

        /* renamed from: a */
        private final Book f13559a;

        /* renamed from: b */
        private final String f13560b;

        public d(Book mBook, String share_Link) {
            this.f13559a = mBook;
            this.f13560b = share_Link;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Bitmap doInBackground(String... params) {
            return t2.a(params[0]);
        }

        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Bitmap bitmap) {
            if (bitmap != null) {
                MiConfigSingleton.V3().Q8(s2.i(this.f13559a, false), s2.i(this.f13559a, true), bitmap, this.f13560b);
            } else {
                MiConfigSingleton.V3().R8(s2.i(this.f13559a, false), s2.i(this.f13559a, true), this.f13560b);
            }
        }
    }

    private static class e extends AsyncTask<String, Void, Bitmap> {

        /* renamed from: a */
        private final Book f13561a;

        /* renamed from: b */
        private final String f13562b;

        public e(Book mBook, String share_Link) {
            this.f13561a = mBook;
            this.f13562b = share_Link;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Bitmap doInBackground(String... params) {
            return t2.a(params[0]);
        }

        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Bitmap bitmap) {
            if (bitmap != null) {
                MiConfigSingleton.V3().M8(s2.j(this.f13561a), s2.i(this.f13561a, false), bitmap, this.f13562b);
            } else {
                MiConfigSingleton.V3().N8(s2.j(this.f13561a), s2.i(this.f13561a, false), this.f13562b);
            }
        }
    }

    public static void A(final com.martian.libmars.activity.j1 activity, final AppTask appTask, final com.martian.apptask.e.c l) {
        if (!AdConfig.UnionType.DEFAULT.equalsIgnoreCase(appTask.source)) {
            MiConfigSingleton.V3().W1(appTask);
            com.martian.apptask.g.g.v(activity, appTask, l);
        } else {
            if (MiConfigSingleton.V3().j5()) {
                return;
            }
            if (MiConfigSingleton.V3().h4() == 2 && com.martian.apptask.g.g.g(activity, "com.martian.qplay")) {
                com.martian.apptask.g.g.s(activity, "com.martian.qplay");
            } else {
                activity.startActivity(AppwallTaskDetailActivity.class);
            }
        }
    }

    public static void B(com.martian.libmars.activity.j1 activity, MartianAppwallTask appwallTask, boolean downloadDirectly, com.martian.apptask.e.c listener) {
        A(activity, t0(appwallTask, downloadDirectly), listener);
    }

    public static void C(com.martian.libmars.activity.j1 activity, String sourceId, String sourceName, String recommendId, String recommend) {
        MiConfigSingleton.V3().l3().m(new Source(sourceName, sourceId), new a(activity, recommend, recommendId, sourceId, sourceName));
    }

    public static void D(final Activity activity) {
        new Handler().postDelayed(new Runnable() { // from class: com.martian.mibook.j.e
            @Override // java.lang.Runnable
            public final void run() {
                s2.q(activity);
            }
        }, 500L);
    }

    public static void E(Activity activity) {
        if (MiConfigSingleton.V3().M5()) {
            activity.setRequestedOrientation(MiConfigSingleton.V3().a2() ? 7 : 1);
        } else {
            activity.setRequestedOrientation(MiConfigSingleton.V3().a2() ? 6 : 0);
        }
    }

    public static void F(com.martian.libmars.activity.j1 activity, String shareLink, Book mBook) {
        com.martian.mibook.lib.model.g.b.b0(activity, "其他方式", mBook.getBookName());
        activity.x1("淘小说分享", i(mBook, true) + (shareLink + "&sfrom=other_share"));
    }

    public static void G(com.martian.libmars.activity.j1 activity, String shareLink, Book mBook) {
        com.martian.mibook.lib.model.g.b.b0(activity, "QQ好友", mBook.getBookName());
        MiConfigSingleton.V3().G8(activity, mBook.getCover(), j(mBook), i(mBook, false), shareLink + "&sfrom=qq_share");
    }

    public static void H(com.martian.libmars.activity.j1 activity, String shareLink, Book mBook) {
        com.martian.mibook.lib.model.g.b.b0(activity, "QQ空间", mBook.getBookName());
        MiConfigSingleton.V3().J8(activity, mBook.getCover(), j(mBook), i(mBook, false), shareLink + "&sfrom=qzone_share");
    }

    public static void I(com.martian.libmars.activity.j1 activity, String shareLink, Book mBook) {
        com.martian.mibook.lib.model.g.b.b0(activity, "微信好友", mBook.getBookName());
        new e(mBook, shareLink + "&sfrom=wx_share").execute(mBook.getCover());
    }

    public static void J(com.martian.libmars.activity.j1 activity, String shareLink, Book mBook) {
        com.martian.mibook.lib.model.g.b.b0(activity, "朋友圈", mBook.getBookName());
        new d(mBook, shareLink + "&sfrom=timeline_share").execute(mBook.getCover());
    }

    public static void K(final com.martian.libmars.activity.j1 activity, final String url) {
        M(activity, url, null);
    }

    public static void L(final com.martian.libmars.activity.j1 activity, final String url, final com.martian.mibook.g.b receiver) {
        N(activity, url, null, receiver);
    }

    public static void M(final com.martian.libmars.activity.j1 activity, final String url, String filename) {
        N(activity, url, filename, null);
    }

    public static void N(final com.martian.libmars.activity.j1 activity, final String url, final String filename, final com.martian.mibook.g.b receiver) {
        if (TextUtils.isEmpty(filename)) {
            filename = k(url, ".apk");
        } else if (!filename.endsWith(".apk")) {
            filename = filename + ".apk";
        }
        com.martian.libmars.utils.k0.P(activity, "文件下载", "是否下载 \"" + filename + "\"？" + (!MiConfigSingleton.V3().U0() ? "\n(wifi未连接, 将使用流量下载)" : ""), new k0.l() { // from class: com.martian.mibook.j.a
            @Override // com.martian.libmars.utils.k0.l
            public final void a() {
                s2.r(com.martian.libmars.activity.j1.this, url, filename, receiver);
            }
        });
    }

    public static void O(final com.martian.libmars.activity.j1 activity, final ShareInfo shareInfo) {
        if (shareInfo == null) {
            return;
        }
        View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.popupwindow_share, (ViewGroup) null);
        final PopupWindow e2 = com.martian.libmars.utils.k0.e(activity, inflate, true, 80);
        inflate.findViewById(R.id.vip_friend_share).setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                s2.s(e2, activity, shareInfo, view);
            }
        });
        inflate.findViewById(R.id.vip_circle_share).setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                s2.t(e2, activity, shareInfo, view);
            }
        });
        inflate.findViewById(R.id.vip_qq_friend_share).setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                s2.u(e2, activity, shareInfo, view);
            }
        });
        inflate.findViewById(R.id.vip_qq_circle_share).setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                s2.v(e2, activity, shareInfo, view);
            }
        });
        inflate.findViewById(R.id.vip_more_share).setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                s2.w(e2, shareInfo, activity, view);
            }
        });
        ((TextView) inflate.findViewById(R.id.share_cancel)).setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e2.dismiss();
            }
        });
    }

    public static void P(Activity activity) {
        ((InputMethodManager) activity.getSystemService("input_method")).toggleSoftInput(2, 0);
    }

    public static void Q(Activity activity, EditText view) {
        InputMethodManager inputMethodManager;
        if (!view.requestFocus() || (inputMethodManager = (InputMethodManager) activity.getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.toggleSoftInput(1, 2);
    }

    public static void R(com.martian.libmars.activity.j1 activity, Book book) {
        S(activity, book, null);
    }

    public static void S(com.martian.libmars.activity.j1 activity, Book book, BookRankActivity.a rankInfo) {
        if (book == null) {
            return;
        }
        if (com.martian.mibook.lib.model.manager.d.f14056h.equalsIgnoreCase(book.getSourceName())) {
            activity.k1("txt不支持书籍详情");
            return;
        }
        TYBookItem tYBookItem = null;
        if (book instanceof TYBookItem) {
            tYBookItem = (TYBookItem) book;
            if (!com.martian.libsupport.k.p(tYBookItem.getDeeplink()) && com.martian.apptask.g.g.b(activity, tYBookItem.getDeeplink())) {
                com.martian.apptask.g.g.t(activity, tYBookItem.getDeeplink());
                return;
            }
        }
        BookInfoActivity.o u = new BookInfoActivity.o().H(book.getSourceId()).I(book.getSourceName()).t(book.getSourceName() + "_" + book.getSourceId()).u(book.getBookName());
        if (rankInfo != null) {
            u.C(rankInfo);
        }
        if (tYBookItem != null) {
            u.w(tYBookItem.getContext()).E(tYBookItem.getRecommend()).F(tYBookItem.getRecommendId()).B(Integer.valueOf(tYBookItem.getPrice()));
            if (tYBookItem.getTagList() != null) {
                u.J(tYBookItem.getTagList());
            }
            MiConfigSingleton.V3().l3().I1(1, tYBookItem.getSourceName(), tYBookItem.getSourceId(), tYBookItem.getRecommendId(), tYBookItem.getRecommend(), "书籍详情");
        }
        BookInfoActivity.i4(activity, u);
    }

    public static void T(com.martian.libmars.activity.j1 activity, String sourceId, String sourceName, String recommend, String recommendId) {
        com.martian.mibook.lib.model.g.b.S(activity, recommend, "书籍详情");
        Bundle bundle = new Bundle();
        bundle.putString(MiConfigSingleton.F0, sourceId);
        bundle.putString(MiConfigSingleton.D0, sourceName);
        bundle.putString(MiConfigSingleton.I0, com.martian.mibook.lib.model.manager.d.j(sourceName, sourceId));
        BookInfoActivity.o F = new BookInfoActivity.o().H(sourceId).I(sourceName).t(sourceName + "_" + sourceId).E(recommend).F(recommendId);
        MiConfigSingleton.V3().l3().I1(1, sourceName, sourceId, recommendId, recommend, "书籍详情");
        BookInfoActivity.i4(activity, F);
    }

    public static void U(com.martian.libmars.activity.j1 activity, Book book) {
        V(activity, book, null);
    }

    public static void V(com.martian.libmars.activity.j1 activity, Book book, BookRankActivity.a rankInfo) {
        if (book == null) {
            return;
        }
        TYBookItem tYBookItem = null;
        if (book instanceof TYBookItem) {
            tYBookItem = (TYBookItem) book;
            if (!com.martian.libsupport.k.p(tYBookItem.getDeeplink()) && com.martian.apptask.g.g.b(activity, tYBookItem.getDeeplink())) {
                com.martian.apptask.g.g.t(activity, tYBookItem.getDeeplink());
                return;
            }
        }
        if (tYBookItem == null || !tYBookItem.getGoReading()) {
            S(activity, book, rankInfo);
        } else {
            h0(activity, book);
        }
    }

    public static void W(com.martian.libmars.activity.j1 activity, boolean open_keyboard, Comment comment) {
        CommentDetailParams commentDetailParams = new CommentDetailParams();
        commentDetailParams.setOpen_keyboard(open_keyboard);
        commentDetailParams.setCid(comment.getCid());
        if (!com.martian.libsupport.k.p(comment.getChapterName())) {
            commentDetailParams.setChapterName(comment.getChapterName());
        }
        MiWebViewActivity.d4(activity, commentDetailParams.toHttpUrl("UTF8"), false, BookInfoActivity.R);
    }

    public static void X(com.martian.libmars.activity.j1 activity) {
        WithdrawCommissionParams withdrawCommissionParams = new WithdrawCommissionParams();
        withdrawCommissionParams.setNight_mode(Boolean.valueOf(MiConfigSingleton.V3().I0()));
        MiWebViewActivity.d4(activity, withdrawCommissionParams.toHttpUrl("UTF8"), false, MiConfigSingleton.J1);
    }

    public static void Y(com.martian.libmars.activity.j1 activity) {
        if (MiConfigSingleton.V3().k2(activity)) {
            FeedbackUrlParams feedbackUrlParams = new FeedbackUrlParams();
            feedbackUrlParams.setUid(MiConfigSingleton.V3().C4().getUid());
            feedbackUrlParams.setToken(MiConfigSingleton.V3().C4().getToken());
            feedbackUrlParams.setEnableNotification(com.martian.libsupport.f.d(activity));
            String httpUrl = feedbackUrlParams.toHttpUrl("UTF8");
            com.martian.libmars.utils.q0.e(httpUrl);
            MiWebViewActivity.f5(activity, httpUrl);
        }
    }

    public static void Z(com.martian.libmars.activity.j1 activity, Book book, Chapter chapter) {
        a0(activity, book, chapter, null);
    }

    public static void a0(com.martian.libmars.activity.j1 activity, Book book, Chapter chapter, Integer cid) {
        FeedbackReportUrlParams feedbackReportUrlParams = new FeedbackReportUrlParams();
        if (MiConfigSingleton.V3().x5()) {
            feedbackReportUrlParams.setUid(MiConfigSingleton.V3().C4().getUid());
            feedbackReportUrlParams.setToken(MiConfigSingleton.V3().C4().getToken());
        }
        if (book != null) {
            feedbackReportUrlParams.setSourceId(book.getSourceId());
            feedbackReportUrlParams.setSourceName(book.getSourceName());
            feedbackReportUrlParams.setTitle(book.getBookName());
        }
        if (chapter instanceof TFChapter) {
            feedbackReportUrlParams.setChapterId(((TFChapter) chapter).getCid());
        } else if (chapter instanceof YWChapter) {
            feedbackReportUrlParams.setChapterId(((YWChapter) chapter).getCcid() + "");
        } else if (chapter instanceof ORChapter) {
            feedbackReportUrlParams.setChapterId(((ORChapter) chapter).getChapterId() + "");
        }
        if (cid != null) {
            feedbackReportUrlParams.setCid(cid);
        }
        feedbackReportUrlParams.setEnableNotification(com.martian.libsupport.f.d(activity));
        MiWebViewActivity.f5(activity, feedbackReportUrlParams.toHttpUrl("UTF8"));
    }

    public static void b0(com.martian.libmars.activity.j1 activity, String url, String filename) {
        c0(activity, url, filename, MiConfigSingleton.y0);
    }

    public static void c(Activity activity, boolean baseFunctionMode) {
        com.martian.libmars.d.h.F().u1(baseFunctionMode);
        D(activity);
    }

    public static void c0(com.martian.libmars.activity.j1 activity, String url, String filename, String path) {
        try {
            com.martian.libsupport.e.i(path);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(1);
        request.setDestinationInExternalPublicDir(path, filename);
        ((DownloadManager) activity.getSystemService("download")).enqueue(request);
    }

    public static void d(Activity activity) {
        com.martian.libmars.d.h.F().v1(com.martian.libmars.d.h.f9882a, false);
        D(activity);
    }

    public static void d0(com.martian.libmars.activity.j1 activity) {
        if (MiConfigSingleton.V3().k2(activity)) {
            MiWebViewActivity.g5(activity, new MessageParams().toHttpUrl("UTF8"), false);
        }
    }

    public static String e(String sourceName, String sourceId) {
        BookShareParams bookShareParams = new BookShareParams();
        bookShareParams.setSourceName(sourceName);
        bookShareParams.setSourceId(sourceId);
        if (!"11".equalsIgnoreCase(MiConfigSingleton.V3().D4())) {
            bookShareParams.setInviter(MiConfigSingleton.V3().D4());
        }
        return bookShareParams.toHttpUrl("UTF8");
    }

    public static void e0(com.martian.libmars.activity.j1 activity, String path, int requestCode) {
        WithdrawMoneyParams withdrawMoneyParams = new WithdrawMoneyParams();
        withdrawMoneyParams.setNight_mode(Boolean.valueOf(MiConfigSingleton.V3().I0()));
        MiWebViewActivity.d4(activity, withdrawMoneyParams.toHttpUrl("UTF8"), false, requestCode);
    }

    public static String f(String bookName, String authorName) {
        return com.martian.libsupport.b.c(u0(bookName) + u0(authorName));
    }

    public static void f0(Activity activity, MiBook mibook, Book book) {
        g0(activity, mibook, book, 0, 0, 0, true);
    }

    public static String g(String mBookId, String uid) {
        try {
            mBookId = URLEncoder.encode(mBookId, "UTF8");
        } catch (UnsupportedEncodingException unused) {
        }
        return "http://ty.taoyuewenhua.net/mibook/book.html?bookId=" + mBookId + "&uid=" + uid;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0103  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void g0(final android.app.Activity r7, com.martian.mibook.lib.model.data.MiBook r8, com.martian.mibook.lib.model.data.abs.Book r9, java.lang.Integer r10, java.lang.Integer r11, java.lang.Integer r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 384
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.j.s2.g0(android.app.Activity, com.martian.mibook.lib.model.data.MiBook, com.martian.mibook.lib.model.data.abs.Book, java.lang.Integer, java.lang.Integer, java.lang.Integer, boolean):void");
    }

    public static String h(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0)).toString();
        } catch (PackageManager.NameNotFoundException unused) {
            return context.getPackageName();
        }
    }

    public static void h0(final com.martian.libmars.activity.j1 activity, final Book mBook) {
        MiConfigSingleton.V3().l3().m(mBook.getSource(), new c(activity, mBook));
    }

    public static String i(Book book, boolean withBookname) {
        String v = com.martian.libsupport.k.v(book.getShortIntro());
        if (com.martian.libsupport.k.p(v)) {
            v = "用淘小说看书还能赚零花，收益高秒提现，快来一起赚钱吧~";
        } else if (v.length() > 30) {
            v = v.substring(0, 30) + "...";
        }
        if (!withBookname) {
            return v;
        }
        return "《" + book.getBookName() + "》 - " + v;
    }

    public static void i0(final com.martian.libmars.activity.j1 activity, final YWBookBanner ywBookBanner) {
        if (com.martian.libsupport.k.p(ywBookBanner.getLink())) {
            MiConfigSingleton.V3().l3().m(ywBookBanner.getSource(), new b(ywBookBanner, activity));
        } else {
            com.martian.mibook.lib.model.g.b.X(activity, ywBookBanner.getLink());
            s0(activity, ywBookBanner.getLink(), ywBookBanner.getLink(), false, null);
        }
    }

    public static String j(Book book) {
        if (book == null) {
            return "好书只分享给懂它的人";
        }
        return "《" + book.getBookName() + "》";
    }

    public static boolean j0(com.martian.libmars.activity.j1 activity, MiReadingRecord readingRecord) {
        if (readingRecord == null) {
            return false;
        }
        Book S = MiConfigSingleton.V3().l3().S(com.martian.mibook.lib.model.manager.d.k(readingRecord.getSourceString()));
        if (S == null) {
            return false;
        }
        f0(activity, S.buildMibook(), S);
        return true;
    }

    private static String k(String url, String suffix) {
        String str = null;
        try {
            String substring = url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf(suffix) + suffix.length());
            int lastIndexOf = substring.lastIndexOf("?");
            if (lastIndexOf != -1) {
                substring = substring.substring(lastIndexOf + 1);
            }
            int lastIndexOf2 = substring.lastIndexOf("=");
            if (lastIndexOf2 != -1) {
                substring = substring.substring(lastIndexOf2 + 1);
            }
            str = URLDecoder.decode(substring, "UTF-8");
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        return com.martian.libsupport.k.r(url) + suffix;
    }

    public static void k0(com.martian.libmars.activity.j1 activity, @NonNull Book book, Chapter chapter) {
        if (MiConfigSingleton.V3().k2(activity)) {
            RechargeParams rechargeParams = new RechargeParams();
            boolean E = MiConfigSingleton.V3().J4.E();
            rechargeParams.setNight_mode(Boolean.valueOf(E));
            rechargeParams.setMethod(Integer.valueOf(MiConfigSingleton.V3().p4()));
            rechargeParams.setBookName(book.getBookName());
            rechargeParams.setSourceId(book.getSourceId());
            rechargeParams.setSourceName(book.getSourceName());
            if (chapter != null) {
                rechargeParams.setPrice(chapter.getPrice());
            }
            ReadingRechargeActivity.n5(activity, rechargeParams.toHttpUrl("UTF8"), E, ReadingRechargeActivity.w0, 100);
        }
    }

    public static List<com.martian.mibook.tts.c> l(Context context) {
        ArrayList arrayList = new ArrayList();
        if (com.martian.libsupport.l.t()) {
            boolean isIgnoringBatteryOptimizations = ((PowerManager) context.getSystemService("power")).isIgnoringBatteryOptimizations(context.getPackageName());
            Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            arrayList.add(new com.martian.mibook.tts.c(intent, "忽略电池优化", "在弹出的『忽略电池优化』对话框中，选择『允许』", isIgnoringBatteryOptimizations));
        }
        String str = com.martian.mibook.application.k0.f11473a;
        if (com.martian.mipush.d.g()) {
            Intent intent2 = new Intent();
            intent2.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity"));
            arrayList.add(new com.martian.mibook.tts.c(intent2, "加入锁屏清理白名单", "在弹出的『锁屏清理』列表中，将" + str + " 对应的开关打开。", false));
        } else if (com.martian.mipush.d.i()) {
            Intent intent3 = new Intent();
            intent3.setAction("miui.intent.action.OP_AUTO_START");
            intent3.addCategory("android.intent.category.DEFAULT");
            arrayList.add(new com.martian.mibook.tts.c(intent3, "允许自启动", "在弹出的『自启动管理』中，将" + str + " 对应的开关打开。", false));
            Intent intent4 = new Intent();
            intent4.setComponent(new ComponentName("com.miui.powerkeeper", "com.miui.powerkeeper.ui.HiddenAppsConfigActivity"));
            intent4.putExtra("package_name", context.getPackageName());
            intent4.putExtra("package_label", h(context));
            arrayList.add(new com.martian.mibook.tts.c(intent4, "关闭神隐模式", "在弹出的" + str + "神隐模式设置中，选择『无限制』，然后选择『允许定位』", false));
        } else if (com.martian.mipush.d.j()) {
            Intent intent5 = new Intent();
            intent5.setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.permission.startup.StartupAppListActivity"));
            arrayList.add(new com.martian.mibook.tts.c(intent5, "允许自启动", "在弹出的『自启动管理』中，将" + str + " 对应的开关打开。", false));
            Intent intent6 = new Intent();
            intent6.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.startup.StartupAppListActivity"));
            arrayList.add(new com.martian.mibook.tts.c(intent6, "允许自启动", "在弹出的『自启动管理』中，将" + str + " 对应的开关打开。", false));
        } else if (com.martian.mipush.d.l()) {
            Intent intent7 = new Intent();
            intent7.setComponent(new ComponentName("com.vivo.abe", "com.vivo.applicationbehaviorengine.ui.ExcessivePowerManagerActivity"));
            arrayList.add(new com.martian.mibook.tts.c(intent7, "允许后台运行", "在弹出的『后台高耗电』中，将" + str + " 对应的开关打开。", false));
        } else if (com.martian.mipush.d.h()) {
            Intent intent8 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            intent8.addCategory("android.intent.category.DEFAULT");
            intent8.putExtra(DBDefinition.PACKAGE_NAME, context.getPackageName());
            arrayList.add(new com.martian.mibook.tts.c(intent8, "允许保持后台运行", "在弹出的应用信息界面中，将『后台管理』选项更改为『保持后台运行』", false));
            Intent intent9 = new Intent();
            intent9.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.powerui.PowerAppPermissionActivity"));
            arrayList.add(new com.martian.mibook.tts.c(intent9, "允许待机时保持运行", "在弹出的『待机耗电管理』中，将" + str + " 对应的开关打开。", false));
        } else if (com.martian.mipush.d.k()) {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.samsung.android.sm");
            if (launchIntentForPackage != null) {
                arrayList.add(new com.martian.mibook.tts.c(launchIntentForPackage, "允许自启动", "在弹出的『智能管理器』中，点击『内存』，选择『自启动应用程序』选项卡，将" + str + " 对应的开关打开。", false));
            }
            Intent intent10 = new Intent();
            intent10.setComponent(new ComponentName("com.samsung.android.sm_cn", "com.samsung.android.sm.ui.battery.BatteryActivity"));
            arrayList.add(new com.martian.mibook.tts.c(intent10, "允许自启动", "在弹出的『电池』页面中，点击『未监视的应用程序』->『添加应用程序』，勾选" + str + "，然后点击『完成』", false));
        } else {
            Intent intent11 = new Intent();
            intent11.setComponent(new ComponentName("com.gionee.softmanager", "com.gionee.softmanager.MainActivity"));
            arrayList.add(new com.martian.mibook.tts.c(intent11, "加入应用自启和绿色后台白名单", "在弹出的『系统管家』中，分别找到『应用管理』->『应用自启』和『绿色后台』->『清理白名单』，将" + str + " 添加到白名单。", false));
            Intent intent12 = new Intent();
            intent12.setComponent(new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.AutobootManageActivity"));
            arrayList.add(new com.martian.mibook.tts.c(intent12, "允许自启动", "弹出的『自启动管理』中，将" + str + " 对应的开关打开。", false));
            Intent intent13 = new Intent();
            intent13.setComponent(new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.BackgroundAppManageActivity"));
            arrayList.add(new com.martian.mibook.tts.c(intent13, "禁止被自动清理", "在弹出的『应用保护』中，将" + str + "对应的开关关闭。", false));
            Intent intent14 = new Intent();
            intent14.setComponent(new ComponentName("com.yulong.android.security", "com.yulong.android.seccenter.tabbarmain"));
            arrayList.add(new com.martian.mibook.tts.c(intent14, "允许自启动", "在弹出的『酷管家』中，找到『软件管理』->『自启动管理』，取消勾选" + str + "，将" + str + " 的状态改为『已允许』", false));
            Intent intent15 = new Intent();
            intent15.setComponent(new ComponentName("com.lenovo.security", "com.lenovo.security.purebackground.PureBackgroundActivity"));
            arrayList.add(new com.martian.mibook.tts.c(intent15, "允许后台运行", "在弹出的『后台管理』中，分别找到『后台自启』、『后台 GPS』和『后台运行』，将" + str + " 对应的开关打开。", false));
            Intent intent16 = new Intent();
            intent16.setComponent(new ComponentName("com.lenovo.powersetting", "com.lenovo.powersetting.ui.Settings$HighPowerApplicationsActivity"));
            arrayList.add(new com.martian.mibook.tts.c(intent16, "关闭后台耗电优化", "在弹出的『后台耗电优化』中，将" + str + " 对应的开关关闭。", false));
            Intent intent17 = new Intent();
            intent17.setComponent(new ComponentName("com.zte.heartyservice", "com.zte.heartyservice.autorun.AppAutoRunManager"));
            arrayList.add(new com.martian.mibook.tts.c(intent17, "允许自启动", "在弹出的『自启动管理』中，将" + str + " 对应的开关打开。", false));
            Intent intent18 = new Intent();
            intent18.setComponent(new ComponentName("com.zte.heartyservice", "com.zte.heartyservice.setting.ClearAppSettingsActivity"));
            arrayList.add(new com.martian.mibook.tts.c(intent18, "加入锁屏清理白名单", "在弹出的『锁屏清理』列表中，将" + str + " 对应的开关打开。", false));
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!com.martian.apptask.g.g.c(context, ((com.martian.mibook.tts.c) it.next()).b())) {
                it.remove();
            }
        }
        return arrayList;
    }

    public static void l0(com.martian.libmars.activity.j1 activity, String openPath, String sourceName, String sourceId) {
        com.martian.mibook.lib.model.g.b.k0(activity, openPath);
        VipLinkParams vipLinkParams = new VipLinkParams();
        boolean E = MiConfigSingleton.V3().J4.E();
        vipLinkParams.setNight_mode(Boolean.valueOf(E));
        vipLinkParams.setNotchHeight(0);
        vipLinkParams.setSource(openPath);
        vipLinkParams.setDialog(Boolean.TRUE);
        vipLinkParams.setSourceName(sourceName);
        vipLinkParams.setSourceId(sourceId);
        vipLinkParams.setMethod(Integer.valueOf(MiConfigSingleton.V3().p4()));
        ReadingRechargeActivity.n5(activity, vipLinkParams.toHttpUrl("UTF8"), E, ReadingRechargeActivity.x0, MiConfigSingleton.I1);
    }

    public static String m() {
        return MiUserManager.v();
    }

    public static void m0(com.martian.libmars.activity.j1 activity) {
        if (MiConfigSingleton.V3().k2(activity)) {
            if (!MiConfigSingleton.V3().W3().getUseWebviewRecharge().booleanValue()) {
                activity.startActivityForResult(TXSRechargeActivity.class, 100);
                return;
            }
            RechargeParams rechargeParams = new RechargeParams();
            rechargeParams.setNight_mode(Boolean.valueOf(MiConfigSingleton.V3().I0()));
            rechargeParams.setMethod(Integer.valueOf(MiConfigSingleton.V3().p4()));
            MiWebViewActivity.d4(activity, rechargeParams.toHttpUrl("UTF8"), false, 100);
        }
    }

    public static void n(Activity activity, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        if (view != null) {
            view.clearFocus();
        }
    }

    public static void n0(com.martian.libmars.activity.j1 activity, ShareInfo shareInfo) {
        if (shareInfo == null) {
        }
        switch (shareInfo.getShareType().intValue()) {
            case 0:
                com.martian.mibook.lib.model.g.b.c0(activity, shareInfo.getStag() + "-分享弹窗");
                com.martian.libmars.utils.q0.e(shareInfo.getStag() + "-分享弹窗");
                O(activity, shareInfo);
                break;
            case 1:
                com.martian.mibook.lib.model.g.b.c0(activity, shareInfo.getStag() + "-微信好友");
                com.martian.libmars.utils.q0.e(shareInfo.getStag() + "-微信好友");
                ShareImageUrlActivity.o(activity, shareInfo);
                break;
            case 2:
                com.martian.mibook.lib.model.g.b.c0(activity, shareInfo.getStag() + "-微信朋友圈");
                com.martian.libmars.utils.q0.e(shareInfo.getStag() + "-微信朋友圈");
                ShareImageUrlActivity.o(activity, shareInfo);
                break;
            case 3:
                com.martian.mibook.lib.model.g.b.c0(activity, shareInfo.getStag() + "-QQ好友");
                ShareImageUrlActivity.o(activity, shareInfo);
                break;
            case 4:
                com.martian.mibook.lib.model.g.b.c0(activity, shareInfo.getStag() + "-QQ空间");
                ShareImageUrlActivity.o(activity, shareInfo);
                break;
            case 5:
                com.martian.mibook.lib.model.g.b.c0(activity, shareInfo.getStag() + "-扫一扫邀请");
                MiQrcodeActivity.g(activity, "扫一扫邀请", shareInfo.getUrl());
                break;
            case 6:
                com.martian.mibook.lib.model.g.b.c0(activity, shareInfo.getStag() + "-系统分享");
                String str = shareInfo.getUrl() + "&sfrom=other_share";
                activity.x1(activity.getString(R.string.app_name) + "分享", shareInfo.getTitle() + str);
                break;
        }
    }

    public static void o(com.martian.libmars.activity.j1 activity) {
        if (MiConfigSingleton.V3().n2(activity)) {
            MiQrcodeActivity.g(activity, "微信扫一扫邀请", MiConfigSingleton.V3().W3().getPhoneInviteShareLink());
        }
    }

    public static void o0(com.martian.libmars.activity.j1 activity, int position, String cuid) {
        if (position > 0 || MiConfigSingleton.V3().k2(activity)) {
            UserCommentsParams userCommentsParams = new UserCommentsParams();
            userCommentsParams.setGoto_position(Integer.valueOf(position));
            userCommentsParams.setCuid(cuid);
            MiWebViewActivity.d4(activity, userCommentsParams.toHttpUrl("UTF8"), false, BookInfoActivity.R);
        }
    }

    public static boolean p(Context context, String packageName) {
        return (com.martian.libsupport.k.p(packageName) || context.getPackageManager().getLaunchIntentForPackage(packageName) == null) ? false : true;
    }

    public static void p0(com.martian.libmars.activity.j1 activity, String openPath) {
        q0(activity, openPath, false, "", "");
    }

    static /* synthetic */ void q(final Activity activity) {
        Intent launchIntentForPackage = activity.getPackageManager().getLaunchIntentForPackage(activity.getPackageName());
        launchIntentForPackage.addFlags(32768);
        activity.startActivity(launchIntentForPackage);
    }

    public static void q0(com.martian.libmars.activity.j1 activity, String openPath, boolean isDialog, String sourceName, String sourceId) {
        if (MiConfigSingleton.V3().j5()) {
            if (MiConfigSingleton.V3().n2(activity)) {
                if (isDialog) {
                    l0(activity, openPath, sourceName, sourceId);
                    return;
                } else {
                    r0(activity, openPath);
                    return;
                }
            }
            return;
        }
        if (MiConfigSingleton.V3().k2(activity)) {
            if (isDialog) {
                l0(activity, openPath, sourceName, sourceId);
            } else {
                r0(activity, openPath);
            }
        }
    }

    static /* synthetic */ void r(final com.martian.libmars.activity.j1 activity, final String url, final String apkFileName, final com.martian.mibook.g.b receiver) {
        c0(activity, url, apkFileName, MiConfigSingleton.y0);
        if (receiver != null) {
            receiver.a(apkFileName, url);
        }
    }

    private static void r0(com.martian.libmars.activity.j1 activity, String openPath) {
        com.martian.mibook.lib.model.g.b.k0(activity, openPath);
        VipLinkParams vipLinkParams = new VipLinkParams();
        if (com.martian.libsupport.l.w(activity)) {
            vipLinkParams.setNotchHeight(com.martian.libmars.d.h.i1(ImmersionBar.getStatusBarHeight(activity)));
        }
        vipLinkParams.setSource(openPath);
        MiWebViewActivity.d4(activity, vipLinkParams.toHttpUrl("UTF8"), false, MiConfigSingleton.I1);
    }

    static /* synthetic */ void s(final PopupWindow window, final com.martian.libmars.activity.j1 activity, final ShareInfo shareInfo, View v) {
        window.dismiss();
        com.martian.mibook.lib.model.g.b.b0(activity, "活动-微信好友", "");
        shareInfo.setShareType(1);
        n0(activity, shareInfo);
    }

    public static void s0(com.martian.libmars.activity.j1 activity, String url, String shareUrl, boolean sharable, String shareImageUrl) {
        MiWebViewActivity.h5(activity, url, false, shareUrl, sharable, shareImageUrl);
    }

    static /* synthetic */ void t(final PopupWindow window, final com.martian.libmars.activity.j1 activity, final ShareInfo shareInfo, View v) {
        window.dismiss();
        com.martian.mibook.lib.model.g.b.b0(activity, "活动-朋友圈", "");
        shareInfo.setShareType(2);
        n0(activity, shareInfo);
    }

    public static AppTask t0(MartianAppwallTask appwallTask, boolean downloadDirectly) {
        AppTask appTask = new AppTask();
        appTask.visibility = 1;
        appTask.downloadDirectly = downloadDirectly;
        appTask.packageName = appwallTask.getApp().getPackageName();
        appTask.desc = appwallTask.getDesc();
        appTask.downloadUrl = appwallTask.getApp().getDownloadUrl();
        appTask.homepageUrl = appwallTask.getWebpageUrl();
        appTask.title = appwallTask.getTitle();
        appTask.name = appwallTask.getApp().getName();
        appTask.posterUrl = appwallTask.getApp().getPosterUrl();
        return appTask;
    }

    static /* synthetic */ void u(final PopupWindow window, final com.martian.libmars.activity.j1 activity, final ShareInfo shareInfo, View v) {
        window.dismiss();
        com.martian.mibook.lib.model.g.b.b0(activity, "活动-QQ好友", "");
        shareInfo.setShareType(3);
        n0(activity, shareInfo);
    }

    private static String u0(String str) {
        return com.martian.libsupport.k.p(str) ? "" : str.replaceAll("[，,：:！!\\s]", "").toLowerCase().trim();
    }

    static /* synthetic */ void v(final PopupWindow window, final com.martian.libmars.activity.j1 activity, final ShareInfo shareInfo, View v) {
        window.dismiss();
        com.martian.mibook.lib.model.g.b.b0(activity, "活动-QQ空间", "");
        shareInfo.setShareType(4);
        n0(activity, shareInfo);
    }

    static /* synthetic */ void w(final PopupWindow window, final ShareInfo shareInfo, final com.martian.libmars.activity.j1 activity, View v) {
        window.dismiss();
        shareInfo.setShareType(6);
        n0(activity, shareInfo);
    }

    public static boolean z(Context context, String packageName) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(packageName);
        if (launchIntentForPackage == null) {
            return false;
        }
        launchIntentForPackage.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        context.startActivity(launchIntentForPackage);
        return true;
    }
}
