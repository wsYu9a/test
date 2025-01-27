package je;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.PopupWindow;
import androidx.fragment.app.FragmentActivity;
import com.baidu.mobads.sdk.internal.am;
import com.martian.ads.ad.AdConfig;
import com.martian.apptask.data.AppTask;
import com.martian.appwall.request.WithdrawCommissionParams;
import com.martian.appwall.request.WithdrawMoneyParams;
import com.martian.appwall.response.MartianAppwallTask;
import com.martian.free.response.TFChapter;
import com.martian.libfeedback.request.url.FeedbackReportUrlParams;
import com.martian.libfeedback.request.url.FeedbackUrlParams;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.R;
import com.martian.mibook.activity.MiQrcodeActivity;
import com.martian.mibook.activity.ReadingRechargeActivity;
import com.martian.mibook.activity.ShareImageUrlActivity;
import com.martian.mibook.activity.account.TXSRechargeActivity;
import com.martian.mibook.activity.appwall.AppwallTaskDetailActivity;
import com.martian.mibook.activity.base.MiWebViewActivity;
import com.martian.mibook.activity.book.BookRankActivity;
import com.martian.mibook.application.EventManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.ReadingInstance;
import com.martian.mibook.data.ShareInfo;
import com.martian.mibook.lib.account.MiUserManager;
import com.martian.mibook.lib.account.request.CommentDetailParams;
import com.martian.mibook.lib.account.request.MessageParams;
import com.martian.mibook.lib.account.request.RechargeParams;
import com.martian.mibook.lib.account.request.UserCommentsParams;
import com.martian.mibook.lib.account.request.VipLinkParams;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import com.martian.mibook.lib.model.data.Source;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.original.data.ORChapter;
import com.martian.mibook.lib.yuewen.response.TYInitialBook;
import com.martian.mibook.lib.yuewen.response.YWBookBanner;
import com.martian.mibook.lib.yuewen.response.YWChapter;
import com.martian.mibook.mvvm.book.activity.BookDetailActivity;
import com.martian.mibook.mvvm.book.viewmodel.BookInfo;
import com.martian.mibook.mvvm.payment.fragment.VipPayDialogFragment;
import com.martian.mibook.mvvm.read.comment.Comment;
import com.martian.mibook.mvvm.ui.dilaog.ActivateVipDialogFragment;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class i {

    public interface c {
        void a();
    }

    public static void A(Context context) {
        new Handler().postDelayed(new Runnable() { // from class: je.h

            /* renamed from: b */
            public final /* synthetic */ Context f27421b;

            public /* synthetic */ h(Context context2) {
                context = context2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                i.q(context);
            }
        }, 500L);
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void B(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (ReadingInstance.z().O(activity)) {
            activity.setRequestedOrientation(1);
        } else {
            activity.setRequestedOrientation(0);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: je.b.<init>(android.widget.PopupWindow, android.app.Activity, com.martian.mibook.data.ShareInfo):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    public static void C(android.app.Activity r4, com.martian.mibook.data.ShareInfo r5) {
        /*
            if (r4 == 0) goto L78
            boolean r0 = r4.isFinishing()
            if (r0 == 0) goto L9
            goto L78
        L9:
            if (r5 != 0) goto Lc
            return
        Lc:
            java.lang.String r0 = "layout_inflater"
            java.lang.Object r0 = r4.getSystemService(r0)
            android.view.LayoutInflater r0 = (android.view.LayoutInflater) r0
            int r1 = com.martian.apptask.R.layout.popupwindow_share
            r2 = 0
            android.view.View r0 = r0.inflate(r1, r2)
            r1 = 1
            r2 = 80
            android.widget.PopupWindow r1 = l9.i0.J(r4, r0, r1, r2)
            int r2 = com.martian.apptask.R.id.vip_friend_share
            android.view.View r2 = r0.findViewById(r2)
            je.b r3 = new je.b
            r3.<init>()
            r2.setOnClickListener(r3)
            int r2 = com.martian.apptask.R.id.vip_circle_share
            android.view.View r2 = r0.findViewById(r2)
            je.c r3 = new je.c
            r3.<init>()
            r2.setOnClickListener(r3)
            int r2 = com.martian.apptask.R.id.vip_qq_friend_share
            android.view.View r2 = r0.findViewById(r2)
            je.d r3 = new je.d
            r3.<init>()
            r2.setOnClickListener(r3)
            int r2 = com.martian.apptask.R.id.vip_qq_circle_share
            android.view.View r2 = r0.findViewById(r2)
            je.e r3 = new je.e
            r3.<init>()
            r2.setOnClickListener(r3)
            int r2 = com.martian.apptask.R.id.vip_more_share
            android.view.View r2 = r0.findViewById(r2)
            je.f r3 = new je.f
            r3.<init>()
            r2.setOnClickListener(r3)
            int r4 = com.martian.apptask.R.id.share_cancel
            android.view.View r4 = r0.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            je.g r5 = new je.g
            r5.<init>()
            r4.setOnClickListener(r5)
        L78:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: je.i.C(android.app.Activity, com.martian.mibook.data.ShareInfo):void");
    }

    public static void D(Activity activity, EditText editText) {
        InputMethodManager inputMethodManager;
        if (activity == null || activity.isFinishing() || !editText.requestFocus() || (inputMethodManager = (InputMethodManager) activity.getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.toggleSoftInput(1, 2);
    }

    public static void E(Activity activity, Book book) {
        F(activity, book, null);
    }

    public static void F(Activity activity, Book book, BookRankActivity.RankInfo rankInfo) {
        TYBookItem tYBookItem;
        if (book == null || activity == null || activity.isFinishing()) {
            return;
        }
        if (vb.e.f31296c.equalsIgnoreCase(book.getSourceName())) {
            l9.t0.b(activity, "txt不支持书籍详情");
            return;
        }
        if (book instanceof TYBookItem) {
            tYBookItem = (TYBookItem) book;
            if (!ba.l.q(tYBookItem.getDeeplink()) && i8.g.h(activity, tYBookItem.getDeeplink())) {
                i8.g.z(activity, tYBookItem.getDeeplink());
                return;
            }
        } else {
            tYBookItem = null;
        }
        BookInfo bookInfo = new BookInfo();
        bookInfo.setSourceId(book.getSourceId());
        bookInfo.setSourceName(book.getSourceName());
        bookInfo.setBookName(book.getBookName());
        if (rankInfo != null) {
            bookInfo.setRankInfo(rankInfo);
        }
        if (tYBookItem != null) {
            bookInfo.setContext(tYBookItem.getContext());
            bookInfo.setRecommend(tYBookItem.getRecommend());
            bookInfo.setRecommendId(tYBookItem.getRecommendId());
            bookInfo.setPrice(Integer.valueOf(tYBookItem.getPrice()));
            if (tYBookItem.getTagList() != null) {
                bookInfo.setTagList(tYBookItem.getTagList());
            }
            MiConfigSingleton.b2().V1().g(1, tYBookItem.getSourceName(), tYBookItem.getSourceId(), tYBookItem.getRecommendId(), tYBookItem.getRecommend(), wd.a.f31697f);
        }
        kc.b.h(bookInfo);
    }

    public static void G(Activity activity, String str, String str2, String str3, String str4) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        ac.a.K(activity, str3, wd.a.f31697f);
        Bundle bundle = new Bundle();
        bundle.putString(ya.e0.f33175s0, str);
        bundle.putString(ya.e0.f33173r0, str2);
        bundle.putString(MiConfigSingleton.T0, vb.e.j(str2, str));
        BookInfo bookInfo = new BookInfo();
        bookInfo.setSourceId(str);
        bookInfo.setSourceName(str2);
        bookInfo.setRecommend(str3);
        bookInfo.setRecommendId(str4);
        MiConfigSingleton.b2().V1().g(1, str2, str, str4, str3, wd.a.f31697f);
        kc.b.h(bookInfo);
    }

    public static void H(Activity activity, Book book) {
        I(activity, book, null);
    }

    public static void I(Activity activity, Book book, BookRankActivity.RankInfo rankInfo) {
        TYBookItem tYBookItem;
        if (book == null || activity == null || activity.isFinishing()) {
            return;
        }
        if (book instanceof TYBookItem) {
            tYBookItem = (TYBookItem) book;
            if (!ba.l.q(tYBookItem.getDeeplink()) && i8.g.h(activity, tYBookItem.getDeeplink())) {
                i8.g.z(activity, tYBookItem.getDeeplink());
                return;
            }
        } else {
            tYBookItem = null;
        }
        if (tYBookItem == null || !tYBookItem.getGoReading() || MiConfigSingleton.b2().y0()) {
            F(activity, book, rankInfo);
        } else {
            R(activity, book);
        }
    }

    public static void J(Activity activity, boolean z10, Comment comment) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        CommentDetailParams commentDetailParams = new CommentDetailParams();
        commentDetailParams.setOpen_keyboard(z10);
        commentDetailParams.setCid(comment.getCid());
        if (!ba.l.q(comment.getChapterName())) {
            commentDetailParams.setChapterName(comment.getChapterName());
        }
        MiWebViewActivity.K5(activity, commentDetailParams.toHttpUrl(z5.k.f33694e), false, BookDetailActivity.f14048s);
    }

    public static void K(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        WithdrawCommissionParams withdrawCommissionParams = new WithdrawCommissionParams();
        withdrawCommissionParams.setNight_mode(Boolean.valueOf(MiConfigSingleton.b2().A0()));
        MiWebViewActivity.K5(activity, withdrawCommissionParams.toHttpUrl(z5.k.f33694e), false, 10025);
    }

    public static void L(Activity activity) {
        if (activity == null || activity.isFinishing() || !MiConfigSingleton.b2().G1().f(activity)) {
            return;
        }
        FeedbackUrlParams feedbackUrlParams = new FeedbackUrlParams();
        feedbackUrlParams.setUid(MiConfigSingleton.b2().G1().p().getUid());
        feedbackUrlParams.setToken(MiConfigSingleton.b2().G1().p().getToken());
        feedbackUrlParams.setEnableNotification(ba.h.e(activity));
        MiWebViewActivity.startWebViewActivity(activity, feedbackUrlParams.toHttpUrl(z5.k.f33694e));
    }

    public static void M(Activity activity, Book book, Chapter chapter) {
        N(activity, book, chapter, null);
    }

    public static void N(Activity activity, Book book, Chapter chapter, Integer num) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        FeedbackReportUrlParams feedbackReportUrlParams = new FeedbackReportUrlParams();
        if (MiConfigSingleton.b2().F2()) {
            feedbackReportUrlParams.setUid(MiConfigSingleton.b2().G1().p().getUid());
            feedbackReportUrlParams.setToken(MiConfigSingleton.b2().G1().p().getToken());
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
        if (num != null) {
            feedbackReportUrlParams.setCid(num);
        }
        feedbackReportUrlParams.setEnableNotification(ba.h.e(activity));
        MiWebViewActivity.startWebViewActivity(activity, feedbackReportUrlParams.toHttpUrl(z5.k.f33694e));
    }

    public static void O(Activity activity, Integer num) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        FeedbackReportUrlParams feedbackReportUrlParams = new FeedbackReportUrlParams();
        if (MiConfigSingleton.b2().F2()) {
            feedbackReportUrlParams.setUid(MiConfigSingleton.b2().G1().p().getUid());
            feedbackReportUrlParams.setToken(MiConfigSingleton.b2().G1().p().getToken());
        }
        if (num != null) {
            feedbackReportUrlParams.setCid(num);
        }
        feedbackReportUrlParams.setEnableNotification(ba.h.e(activity));
        MiWebViewActivity.startWebViewActivity(activity, feedbackReportUrlParams.toHttpUrl(z5.k.f33694e));
    }

    public static void P(Activity activity) {
        if (activity == null || activity.isFinishing() || !MiConfigSingleton.b2().G1().f(activity)) {
            return;
        }
        MiWebViewActivity.A4(activity, new MessageParams().toHttpUrl(z5.k.f33694e), false);
    }

    public static void Q(Activity activity, String str, int i10) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        WithdrawMoneyParams withdrawMoneyParams = new WithdrawMoneyParams();
        withdrawMoneyParams.setNight_mode(Boolean.valueOf(MiConfigSingleton.b2().A0()));
        MiWebViewActivity.K5(activity, withdrawMoneyParams.toHttpUrl(z5.k.f33694e), false, i10);
    }

    public static void R(Activity activity, Book book) {
        if (MiConfigSingleton.b2().y0()) {
            l9.t0.b(activity, "请切换到完整版使用完整功能");
        } else {
            kc.b.r(activity, book);
        }
    }

    public static void S(Activity activity, Book book, Integer num, Integer num2, Integer num3, boolean z10) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        kc.b.s(activity, book, num, num2, num3, z10);
    }

    public static void T(Activity activity, YWBookBanner yWBookBanner) {
        if (ba.l.q(yWBookBanner.getLink())) {
            MiConfigSingleton.b2().M1().k(yWBookBanner.getSource(), new b(activity, yWBookBanner));
        } else {
            ac.a.N(activity, yWBookBanner.getLink());
            g0(activity, yWBookBanner.getLink(), yWBookBanner.getLink(), false, null);
        }
    }

    public static boolean U(Activity activity, MiReadingRecord miReadingRecord) {
        if (miReadingRecord == null) {
            return false;
        }
        kc.b.q(activity, miReadingRecord);
        return true;
    }

    public static void V(Activity activity, Book book) {
        kc.b.s(activity, book, null, 0, 0, true);
    }

    public static void W(Activity activity, Book book, Chapter chapter) {
        if (activity == null || activity.isFinishing() || book == null || !MiConfigSingleton.b2().G1().f(activity)) {
            return;
        }
        RechargeParams rechargeParams = new RechargeParams();
        boolean s10 = MiConfigSingleton.b2().h2().s();
        rechargeParams.setNight_mode(Boolean.valueOf(s10));
        rechargeParams.setMethod(Integer.valueOf(MiConfigSingleton.b2().j2()));
        rechargeParams.setBookName(book.getBookName());
        rechargeParams.setSourceId(book.getSourceId());
        rechargeParams.setSourceName(book.getSourceName());
        if (chapter != null) {
            rechargeParams.setPrice(chapter.getPrice());
        }
        ReadingRechargeActivity.P5(activity, rechargeParams.toHttpUrl(z5.k.f33694e), s10, ReadingRechargeActivity.f13117p0, 100);
    }

    public static void X(Activity activity) {
        if (activity == null || activity.isFinishing() || !MiConfigSingleton.b2().G1().f(activity)) {
            return;
        }
        if (!MiConfigSingleton.b2().c2().getUseWebviewRecharge().booleanValue()) {
            activity.startActivityForResult(new Intent(activity, (Class<?>) TXSRechargeActivity.class), 100);
            return;
        }
        RechargeParams rechargeParams = new RechargeParams();
        rechargeParams.setNight_mode(Boolean.valueOf(MiConfigSingleton.b2().A0()));
        rechargeParams.setMethod(Integer.valueOf(MiConfigSingleton.b2().j2()));
        MiWebViewActivity.K5(activity, rechargeParams.toHttpUrl(z5.k.f33694e), false, 100);
    }

    public static void Y(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        FeedbackReportUrlParams feedbackReportUrlParams = new FeedbackReportUrlParams();
        if (MiConfigSingleton.b2().F2()) {
            feedbackReportUrlParams.setUid(MiConfigSingleton.b2().G1().p().getUid());
            feedbackReportUrlParams.setToken(MiConfigSingleton.b2().G1().p().getToken());
        }
        feedbackReportUrlParams.setCategoryId(4);
        feedbackReportUrlParams.setSubCategoryId(40002);
        MiWebViewActivity.startWebViewActivity(activity, feedbackReportUrlParams.toHttpUrl(z5.k.f33694e));
    }

    public static void Z(Activity activity, ShareInfo shareInfo) {
        if (activity == null || activity.isFinishing() || shareInfo == null) {
        }
        switch (shareInfo.getShareType().intValue()) {
            case 0:
                ac.a.S(activity, shareInfo.getStag() + "-分享弹窗");
                C(activity, shareInfo);
                break;
            case 1:
                ac.a.S(activity, shareInfo.getStag() + "-微信好友");
                ShareImageUrlActivity.o(activity, shareInfo);
                break;
            case 2:
                ac.a.S(activity, shareInfo.getStag() + "-微信朋友圈");
                ShareImageUrlActivity.o(activity, shareInfo);
                break;
            case 3:
                ac.a.S(activity, shareInfo.getStag() + "-QQ好友");
                ShareImageUrlActivity.o(activity, shareInfo);
                break;
            case 4:
                ac.a.S(activity, shareInfo.getStag() + "-QQ空间");
                ShareImageUrlActivity.o(activity, shareInfo);
                break;
            case 5:
                ac.a.S(activity, shareInfo.getStag() + "-扫一扫邀请");
                MiQrcodeActivity.g(activity, "扫一扫邀请", shareInfo.getUrl());
                break;
            case 6:
                ac.a.S(activity, shareInfo.getStag() + "-系统分享");
                String str = shareInfo.getUrl() + "&sfrom=other_share";
                a0(activity, activity.getString(R.string.app_name) + "分享", shareInfo.getTitle() + str);
                break;
        }
    }

    public static void a0(Activity activity, String str, String str2) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(am.f6739e);
        intent.putExtra("android.intent.extra.SUBJECT", str);
        intent.putExtra("android.intent.extra.TEXT", str2);
        intent.setFlags(268435456);
        activity.startActivity(Intent.createChooser(intent, str));
    }

    public static void b0(int i10, String str, int i11) {
        kc.b.B(str, i10, i11);
    }

    public static void c0(Activity activity, int i10, String str) {
        if (activity == null || activity.isFinishing() || TextUtils.isEmpty(str)) {
            return;
        }
        if (i10 > 0 || MiConfigSingleton.b2().G1().f(activity)) {
            UserCommentsParams userCommentsParams = new UserCommentsParams();
            userCommentsParams.setGoto_position(Integer.valueOf(i10));
            userCommentsParams.setCuid(str);
            MiWebViewActivity.K5(activity, userCommentsParams.toHttpUrl(z5.k.f33694e), false, BookDetailActivity.f14048s);
        }
    }

    public static void d0(Activity activity, String str) {
        if (MiConfigSingleton.b2().G1().f(activity)) {
            if (MiConfigSingleton.b2().c2().getNativePay()) {
                kc.b.A(str);
            } else {
                f0(activity, str);
            }
        }
    }

    public static void e0(Activity activity, String str, String str2, String str3) {
        if (MiConfigSingleton.b2().G1().f(activity)) {
            if (MiConfigSingleton.b2().c2().getNativePay()) {
                VipPayDialogFragment.O0((FragmentActivity) activity, str, str2, str3);
            } else {
                ActivateVipDialogFragment.O((FragmentActivity) activity, str, str2, str3);
            }
        }
    }

    public static void f0(Activity activity, String str) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        ac.a.Y(activity, str);
        VipLinkParams vipLinkParams = new VipLinkParams();
        if (ba.m.q(activity)) {
            vipLinkParams.setNotchHeight(ConfigSingleton.W0(com.gyf.immersionbar.d.H0(activity)));
        }
        vipLinkParams.setSource(str);
        vipLinkParams.setEnableGuest(Boolean.valueOf(!MiConfigSingleton.b2().C2()));
        MiWebViewActivity.K5(activity, vipLinkParams.toHttpUrl(z5.k.f33694e), false, 10024);
    }

    public static void g0(Activity activity, String str, String str2, boolean z10, String str3) {
        MiWebViewActivity.H5(activity, str, false, str2, z10, str3);
    }

    public static void h(Context context, boolean z10) {
        ConfigSingleton.D().f1(z10);
        A(context);
    }

    public static AppTask h0(MartianAppwallTask martianAppwallTask, boolean z10) {
        AppTask appTask = new AppTask();
        appTask.visibility = 1;
        appTask.downloadDirectly = z10;
        appTask.packageName = martianAppwallTask.getApp().getPackageName();
        appTask.desc = martianAppwallTask.getDesc();
        appTask.downloadUrl = martianAppwallTask.getApp().getDownloadUrl();
        appTask.homepageUrl = martianAppwallTask.getWebpageUrl();
        appTask.title = martianAppwallTask.getTitle();
        appTask.name = martianAppwallTask.getApp().getName();
        appTask.posterUrl = martianAppwallTask.getApp().getPosterUrl();
        return appTask;
    }

    public static void i(Context context) {
        ConfigSingleton.D().g1(ConfigSingleton.f12096z, false);
        A(context);
    }

    public static String j(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0)).toString();
        } catch (PackageManager.NameNotFoundException unused) {
            return context.getPackageName();
        }
    }

    public static List<ae.b> k(Context context) {
        boolean isIgnoringBatteryOptimizations;
        ArrayList arrayList = new ArrayList();
        if (context == null) {
            return arrayList;
        }
        if (ba.m.n()) {
            isIgnoringBatteryOptimizations = ((PowerManager) context.getSystemService("power")).isIgnoringBatteryOptimizations(context.getPackageName());
            Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            arrayList.add(new ae.b(intent, "忽略电池优化", "在弹出的『忽略电池优化』对话框中，选择『允许』", isIgnoringBatteryOptimizations));
        }
        String str = ya.e0.f33138a;
        if (ke.e.c()) {
            Intent intent2 = new Intent();
            intent2.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity"));
            arrayList.add(new ae.b(intent2, "加入锁屏清理白名单", "在弹出的『锁屏清理』列表中，将" + str + " 对应的开关打开。", false));
            Intent intent3 = new Intent();
            intent3.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity"));
            arrayList.add(new ae.b(intent3, "加入后台运行白名单", "在弹出的设置中，搜索\"应用启动管理\"，将" + str + " 对应的\"允许自启动\"和\"允许后台活动\"开关打开。", false));
        } else if (ke.e.e()) {
            Intent intent4 = new Intent();
            intent4.setAction("miui.intent.action.OP_AUTO_START");
            intent4.addCategory("android.intent.category.DEFAULT");
            arrayList.add(new ae.b(intent4, "允许自启动", "在弹出的『自启动管理』中，将" + str + " 对应的开关打开。", false));
            Intent intent5 = new Intent();
            intent5.setComponent(new ComponentName("com.miui.powerkeeper", "com.miui.powerkeeper.ui.HiddenAppsConfigActivity"));
            intent5.putExtra("package_name", context.getPackageName());
            intent5.putExtra("package_label", j(context));
            arrayList.add(new ae.b(intent5, "关闭神隐模式", "在弹出的" + str + "神隐模式设置中，选择『无限制』，然后选择『允许定位』", false));
        } else if (ke.e.g()) {
            Intent intent6 = new Intent();
            intent6.setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.permission.startup.StartupAppListActivity"));
            arrayList.add(new ae.b(intent6, "允许自启动", "在弹出的『自启动管理』中，将" + str + " 对应的开关打开。", false));
            Intent intent7 = new Intent();
            intent7.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.startup.StartupAppListActivity"));
            arrayList.add(new ae.b(intent7, "允许自启动", "在弹出的『自启动管理』中，将" + str + " 对应的开关打开。", false));
        } else if (ke.e.j()) {
            Intent intent8 = new Intent();
            intent8.setComponent(new ComponentName("com.vivo.abe", "com.vivo.applicationbehaviorengine.ui.ExcessivePowerManagerActivity"));
            arrayList.add(new ae.b(intent8, "允许后台运行", "在弹出的设置中搜索『后台耗电管理』，将" + str + " 对应的选项设置为\"允许后台高耗电\"。", false));
        } else {
            Intent intent9 = new Intent();
            intent9.setComponent(new ComponentName("com.gionee.softmanager", "com.gionee.softmanager.MainActivity"));
            arrayList.add(new ae.b(intent9, "加入应用自启和绿色后台白名单", "在弹出的『系统管家』中，分别找到『应用管理』->『应用自启』和『绿色后台』->『清理白名单』，将" + str + " 添加到白名单。", false));
            Intent intent10 = new Intent();
            intent10.setComponent(new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.AutobootManageActivity"));
            arrayList.add(new ae.b(intent10, "允许自启动", "弹出的『自启动管理』中，将" + str + " 对应的开关打开。", false));
            Intent intent11 = new Intent();
            intent11.setComponent(new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.BackgroundAppManageActivity"));
            arrayList.add(new ae.b(intent11, "禁止被自动清理", "在弹出的『应用保护』中，将" + str + "对应的开关关闭。", false));
            Intent intent12 = new Intent();
            intent12.setComponent(new ComponentName("com.yulong.android.security", "com.yulong.android.seccenter.tabbarmain"));
            arrayList.add(new ae.b(intent12, "允许自启动", "在弹出的『酷管家』中，找到『软件管理』->『自启动管理』，取消勾选" + str + "，将" + str + " 的状态改为『已允许』", false));
            Intent intent13 = new Intent();
            intent13.setComponent(new ComponentName("com.lenovo.security", "com.lenovo.security.purebackground.PureBackgroundActivity"));
            arrayList.add(new ae.b(intent13, "允许后台运行", "在弹出的『后台管理』中，分别找到『后台自启』、『后台 GPS』和『后台运行』，将" + str + " 对应的开关打开。", false));
            Intent intent14 = new Intent();
            intent14.setComponent(new ComponentName("com.lenovo.powersetting", "com.lenovo.powersetting.ui.Settings$HighPowerApplicationsActivity"));
            arrayList.add(new ae.b(intent14, "关闭后台耗电优化", "在弹出的『后台耗电优化』中，将" + str + " 对应的开关关闭。", false));
            Intent intent15 = new Intent();
            intent15.setComponent(new ComponentName("com.zte.heartyservice", "com.zte.heartyservice.autorun.AppAutoRunManager"));
            arrayList.add(new ae.b(intent15, "允许自启动", "在弹出的『自启动管理』中，将" + str + " 对应的开关打开。", false));
            Intent intent16 = new Intent();
            intent16.setComponent(new ComponentName("com.zte.heartyservice", "com.zte.heartyservice.setting.ClearAppSettingsActivity"));
            arrayList.add(new ae.b(intent16, "加入锁屏清理白名单", "在弹出的『锁屏清理』列表中，将" + str + " 对应的开关打开。", false));
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!i8.g.i(context, ((ae.b) it.next()).b())) {
                it.remove();
            }
        }
        return arrayList;
    }

    public static String l() {
        return MiUserManager.s();
    }

    public static Intent m(Context context) {
        Intent intent;
        if (ke.e.c()) {
            intent = new Intent();
            intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity"));
        } else if (ke.e.e()) {
            intent = new Intent();
            intent.setComponent(new ComponentName("com.miui.powerkeeper", "com.miui.powerkeeper.ui.HiddenAppsConfigActivity"));
            intent.putExtra("package_name", context.getPackageName());
            intent.putExtra("package_label", j(context));
        } else if (ke.e.g()) {
            Intent intent2 = new Intent();
            intent2.setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.permission.startup.StartupAppListActivity"));
            if (i8.g.i(context, intent2)) {
                return intent2;
            }
            intent = new Intent();
            intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.startup.StartupAppListActivity"));
        } else if (ke.e.j()) {
            intent = new Intent();
            intent.setComponent(new ComponentName("com.vivo.abe", "com.vivo.applicationbehaviorengine.ui.ExcessivePowerManagerActivity"));
        } else {
            intent = null;
        }
        return i8.g.i(context, intent) ? intent : new Intent("android.settings.SETTINGS");
    }

    public static void n(Activity activity, View view) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        if (view != null) {
            view.clearFocus();
        }
    }

    public static void o(Activity activity) {
        if (activity == null || activity.isFinishing() || !MiConfigSingleton.b2().G1().i(activity)) {
            return;
        }
        MiQrcodeActivity.g(activity, "微信扫一扫邀请", MiConfigSingleton.b2().c2().getPhoneInviteShareLink());
    }

    public static boolean p(Context context, String str) {
        return (context == null || ba.l.q(str) || context.getPackageManager().getLaunchIntentForPackage(str) == null) ? false : true;
    }

    public static /* synthetic */ void q(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage == null) {
            return;
        }
        launchIntentForPackage.addFlags(32768);
        context.startActivity(launchIntentForPackage);
    }

    public static /* synthetic */ void r(PopupWindow popupWindow, Activity activity, ShareInfo shareInfo, View view) {
        popupWindow.dismiss();
        ac.a.R(activity, "活动-微信好友", "");
        shareInfo.setShareType(1);
        Z(activity, shareInfo);
    }

    public static /* synthetic */ void s(PopupWindow popupWindow, Activity activity, ShareInfo shareInfo, View view) {
        popupWindow.dismiss();
        ac.a.R(activity, "活动-朋友圈", "");
        shareInfo.setShareType(2);
        Z(activity, shareInfo);
    }

    public static /* synthetic */ void t(PopupWindow popupWindow, Activity activity, ShareInfo shareInfo, View view) {
        popupWindow.dismiss();
        ac.a.R(activity, "活动-QQ好友", "");
        shareInfo.setShareType(3);
        Z(activity, shareInfo);
    }

    public static /* synthetic */ void u(PopupWindow popupWindow, Activity activity, ShareInfo shareInfo, View view) {
        popupWindow.dismiss();
        ac.a.R(activity, "活动-QQ空间", "");
        shareInfo.setShareType(4);
        Z(activity, shareInfo);
    }

    public static /* synthetic */ void v(PopupWindow popupWindow, ShareInfo shareInfo, Activity activity, View view) {
        popupWindow.dismiss();
        shareInfo.setShareType(6);
        Z(activity, shareInfo);
    }

    public static void x(Activity activity, AppTask appTask, g8.a aVar) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (!AdConfig.UnionType.DEFAULT.equalsIgnoreCase(appTask.source)) {
            MiConfigSingleton.b2().e2().k(appTask);
            i8.g.B(activity, appTask, aVar);
        } else {
            if (MiConfigSingleton.b2().C2()) {
                return;
            }
            if (MiConfigSingleton.b2().e2().K() == 2 && i8.g.m(activity, "com.martian.qplay")) {
                i8.g.y(activity, "com.martian.qplay");
            } else {
                activity.startActivity(new Intent(activity, (Class<?>) AppwallTaskDetailActivity.class));
            }
        }
    }

    public static void y(Activity activity, MartianAppwallTask martianAppwallTask, boolean z10, g8.a aVar) {
        x(activity, h0(martianAppwallTask, z10), aVar);
    }

    public static void z(Activity activity, String str, String str2, String str3, String str4, boolean z10, c cVar) {
        MiConfigSingleton.b2().M1().k(new Source(str2, str), new a(activity, str4, str3, z10, str2, str, cVar));
    }

    public class a implements xb.b {

        /* renamed from: a */
        public final /* synthetic */ Activity f27426a;

        /* renamed from: b */
        public final /* synthetic */ String f27427b;

        /* renamed from: c */
        public final /* synthetic */ String f27428c;

        /* renamed from: d */
        public final /* synthetic */ boolean f27429d;

        /* renamed from: e */
        public final /* synthetic */ String f27430e;

        /* renamed from: f */
        public final /* synthetic */ String f27431f;

        /* renamed from: g */
        public final /* synthetic */ c f27432g;

        public a(Activity activity, String str, String str2, boolean z10, String str3, String str4, c cVar) {
            this.f27426a = activity;
            this.f27427b = str;
            this.f27428c = str2;
            this.f27429d = z10;
            this.f27430e = str3;
            this.f27431f = str4;
            this.f27432g = cVar;
        }

        @Override // xb.b
        public void a(Book book) {
            if (!l9.m0.C(this.f27426a) || book == null) {
                return;
            }
            if (!MiConfigSingleton.b2().M1().i0(book.getSourceString())) {
                MiConfigSingleton.b2().M1().g(this.f27426a, book);
            }
            TYInitialBook tYInitialBook = new TYInitialBook();
            tYInitialBook.convertYwBookItem(book);
            tYInitialBook.setRecommend(this.f27427b);
            tYInitialBook.setRecommendId(this.f27428c);
            tYInitialBook.setReason(this.f27426a.getString(R.string.guess_you_like));
            tYInitialBook.setGoReading(Boolean.valueOf(this.f27429d));
            if (!TextUtils.isEmpty(this.f27428c)) {
                MiConfigSingleton.b2().G1().z(true);
                MiConfigSingleton.b2().G1().w();
                MiConfigSingleton.b2().V1().k(EventManager.f13206i, this.f27428c);
                MiConfigSingleton.b2().V1().k(EventManager.f13205h, vb.e.j(this.f27430e, this.f27431f));
            }
            AppViewModel a10 = lc.b.a(this.f27426a);
            if (a10 != null) {
                a10.H0(tYInitialBook);
            }
            c cVar = this.f27432g;
            if (cVar != null) {
                cVar.a();
            }
        }

        @Override // xb.b
        public void onResultError(x8.c cVar) {
            if (l9.m0.C(this.f27426a)) {
                i.G(this.f27426a, this.f27431f, this.f27430e, this.f27427b, this.f27428c);
            }
        }

        @Override // xb.b
        public void onLoading(boolean z10) {
        }
    }

    public class b implements xb.b {

        /* renamed from: a */
        public final /* synthetic */ Activity f27433a;

        /* renamed from: b */
        public final /* synthetic */ YWBookBanner f27434b;

        public b(Activity activity, YWBookBanner yWBookBanner) {
            this.f27433a = activity;
            this.f27434b = yWBookBanner;
        }

        @Override // xb.b
        public void a(Book book) {
            Activity activity = this.f27433a;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            i.R(this.f27433a, book);
        }

        @Override // xb.b
        public void onResultError(x8.c cVar) {
            Activity activity = this.f27433a;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            i.E(this.f27433a, this.f27434b);
        }

        @Override // xb.b
        public void onLoading(boolean z10) {
        }
    }
}
