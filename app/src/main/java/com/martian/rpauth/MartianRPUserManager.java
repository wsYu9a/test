package com.martian.rpauth;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import b.d.c.b.c;
import com.martian.libmars.activity.j1;
import com.martian.libmars.comm.request.MTHttpGetParams;
import com.martian.libqq.QQAPIInstance;
import com.martian.libsupport.h;
import com.martian.libsupport.k;
import com.martian.rpauth.response.IAccount;
import com.martian.rpauth.response.MartianRPAccount;
import com.martian.rpauth.response.MartianRPUser;
import java.util.Random;

/* loaded from: classes.dex */
public class MartianRPUserManager extends MartianIUserManager {
    public static final int A = 0;
    public static final String A0 = "CHANNEL_URL";
    public static final int B = 1;
    public static final String B0 = "AJAX_URL";
    public static final int C = 2;
    public static final String C0 = "NEWS_CHANNEL_CHANGED";
    public static final int D = 3;
    public static final String D0 = "CHANNEL_MINE";
    public static final int E = 4;
    public static final String E0 = "NEWS_LIST_TO_TOP";
    public static final String F = "INVITE_SHARE_INFO";
    public static final String F0 = "NEWS_UPDATE_HEADER";
    public static final String G = "INVITE_SHARE_TYPE";
    public static final String G0 = "SYNC_ACTIVITIES";
    public static final String H = "INVITE_SHARE_MONEY";
    public static final String H0 = "UPDATE_INIT_MISSION";
    public static final String I = "INVITE_SHARE_IMAGE_URL";
    public static final String I0 = "FRESH_WITHDRAW";
    public static final String J = "INVITE_SHARE_ACTIVITY_URL";
    public static final String J0 = "MISSION_TYPE";
    public static final int K = 0;
    public static final String K0 = "NEWS_CHANNEL_SHOWN";
    public static final int L = 1;
    public static final String L0 = "MENU_SHOW_HIDE";
    public static final int M = 2;
    public static final String M0 = "TRANSITION_ANIMATION_NEWS_PHOTOS";
    public static final int N = 3;
    public static final String N0 = "CONTENT_URL";
    public static final int O = 4;
    public static final String O0 = "CONTENT_TYPE";
    public static final int P = 5;
    public static final String P0 = "NEWS_TITLE";
    public static final int Q = 6;
    public static final String Q0 = "UKEY";
    public static final int R = 0;
    public static final String R0 = "TKEY";
    public static final int S = 1;
    public static final String S0 = "NEWS_ID";
    public static final String T = "INTENT_MTIME";
    public static final String T0 = "NEWS_JSON";
    public static final String U = "INTENT_VRID";
    public static final String U0 = "VIDEO_URL";
    public static final String V = "INTENT_VRTYPE";
    public static final String V0 = "MAIN_ACTIVITY_PAGE";
    public static final String W = "INTENT_VRSTATUS";
    public static final String W0 = "WITHDRAW_GUIDE_TO_RATE";
    public static final String X = "INTENT_BG_IMG_URL";
    public static final String X0 = "WITHDRAW_TYPE";
    public static final String Y = "INTENT_ICON_URL";
    public static final String Y0 = "DEPOSIT";
    public static final String Z = "INTENT_DOWNLOAD_URL";
    public static final String Z0 = "Commission";
    public static final String a0 = "INTENT_TITLE";
    public static final String a1 = "MONEY";
    public static final String b0 = "INTENT_DESC";
    public static final String b1 = "PHONE";
    public static final String c0 = "INTENT_FORCE_INSTALL";
    public static final String c1 = "NEWS_NOTIFICATION";

    /* renamed from: d */
    public static final int f14917d = 10001;
    public static final String d0 = "INTENT_ADS_TITLE";
    private static final String d1 = "PREF_USER_INFO";

    /* renamed from: e */
    public static final int f14918e = 10002;
    public static final String e0 = "INTENT_ADS_URL";

    /* renamed from: f */
    public static final int f14919f = 10003;
    public static final String f0 = "INTENT_PACKAGE_NAME";

    /* renamed from: g */
    public static final int f14920g = 10004;
    public static final String g0 = "INTENT_IS_PRE_REDPAPER";

    /* renamed from: h */
    public static final int f14921h = 10005;
    public static final String h0 = "INTENT_WITHDRAW_FORCE_SHARE";

    /* renamed from: i */
    public static final int f14922i = 10006;
    public static final String i0 = "INTENT_WITHDRAW_SHARE_MONEY";

    /* renamed from: j */
    public static final int f14923j = 20001;
    public static final String j0 = "INTENT_WITHDRAW_TYPE";
    public static final int k = 20002;
    public static final String k0 = "INTENT_MISSION_CENTER";
    public static final int l = 20003;
    public static final int l0 = 100;
    public static final int m = 20004;
    public static final int m0 = 101;
    public static final int n = 20005;
    public static final int n0 = 102;
    public static final int o = 0;
    public static final int o0 = 103;
    public static final int p = 1;
    public static final int p0 = 104;
    public static final int q = 2;
    public static final int q0 = 105;
    public static final int r = 10;
    public static final int r0 = 107;
    public static final int s = 50;
    public static final int s0 = 108;
    public static final int t = 888;
    public static final int t0 = 109;
    public static final int u = 0;
    public static final int u0 = 110;
    public static final int v = 1;
    public static final String v0 = "CHANNEL_ID";
    public static final int w = 2;
    public static final String w0 = "CHANNEL_POSITION";
    public static final int x = 3;
    public static final String x0 = "SHOW_ACTIVITIES";
    public static final int y = 0;
    public static final String y0 = "INIT_LOAD_ADS";
    public static final int z = 1;
    public static final String z0 = "CHANNEL_NAME";
    private final Context g1;
    private com.martian.rpauth.b h1;
    public boolean i1;
    private MartianRPAccount j1;
    public static String[] e1 = {"引领全民阅读，每天轻松赚零花，学知识，零门槛提现！", "看新闻还能赚钱，每天都有收益，每天都能提现,满0.1可提现秒到微信支付宝，太爽了!", "我一直在用这里赚-钱，就看看新闻赚-零-花，关键免费,满0.1可提现秒到微信支付宝，太爽了", "这里看新闻肯定没错！免费看还给-钱，强烈推荐给你！,满0.1可提现秒到微信支付宝，太爽了", "想赚¥吗？来看-新闻吧~免费看还能赚-零-花·钱~,满0.1可提现秒到微信支付宝，太爽了", "看新闻就能赚-钱，天天有收益！提现速度快，安全可靠,满0.1可提现秒到微信支付宝，太爽了", "看资-讯能赚·钱，我验证过，就免费看新-闻就可以！,满0.1可提现秒到微信支付宝，太爽了", "想赚-零花·钱吗？来这里看-新-闻，免费看还能赚-钱,满0.1可提现秒到微信支付宝，太爽了", "看新-闻还给钱，不忽悠~能每天提-现哦！让你爱上阅读,满0.1可提现秒到微信支付宝，太爽了"};
    public static String[] f1 = {"看新闻赢红包，0.1元起提秒到账 看新闻还能赚钱，每天都有收益，每天都能提现,满0.1可提现秒到微信支付宝，太爽了!", "看新闻赢红包，0.1元起提秒到账 [胜利][胜利]好平台不忽悠[色][跳跳]，来[鼓掌]看资讯就送钱！相信我，我一直在玩，扫-码参与很简单，就看看资讯[握手]、看看文章，有兴趣的都可以一起交流", "看新闻赢红包，0.1元起提秒到账 最近在这看文章，[微笑]边[拳头]看还能边赚-钱，连[微笑]话费都赚出来了，错过就没了[偷笑][握手]！免费扫.码的没风险，绝对靠谱[咖啡][得意]，我用[呲牙][调皮]到现在了", "看新闻赢红包，0.1元起提秒到账 这里[拳头][调皮]看新闻、看视频，全是免费的，[啤酒][调皮]放心大[色]胆随便看！而且看了会有意外收获哦～我已扫·[闪电][跳跳]码在玩了，竟然[怄火]可以赚钱的，大家快来", "看新闻赢红包，0.1元起提秒到账 这里看资讯会给钱，就是这么任性！我看了[OK]就停不下[抱拳][愉快]来，平时有空就会看。看新[奋斗]闻很简单，翻翻[握手][强]几[握手][拥抱]篇文章就有钱，赶快扫[西瓜]／码加入", "看新闻赢红包，0.1元起提秒到账 大家有福了～只[得意]要[偷笑]看文章、看看视频就[拳头][微笑]能赚钱[跳跳][呲牙]！扫-码参[握手][咖啡]加看[西瓜]的时候，不知不觉就会有收益。这个模式非常不错，这个便宜不要错过了", "看新闻赢红包，0.1元起提秒到账 看新闻资讯，大家可以来这里。内容很丰富[愉快][微笑]，覆盖面广，看[鼓掌][偷笑]了还有奖励哦！我已经扫·码在看了[愉快][愉快][怄火]，还挺有意思的。[胜利]让你更有阅[礼物]读的动力！", "看新闻赢红包，0.1元起提秒到账 最近喜欢上看新闻，原[磕头]因是因为这个[强][磕头]。推荐[得意][调皮]给大家扫·[胜利][鼓掌]码试试，我用到现在了，没毛病！看[调皮]新[西瓜][握手]闻给奖励，别的地方可没这福利", "看新闻赢红包，0.1元起提秒到账 机会[奋斗][奋斗]只给有准备的人，[色]这个很不错，随便看看资讯就有钱！海量资讯等着你，肯定有你喜欢的！赶[太阳][啤酒]快抓住[转圈]机会扫／码[咖啡][愉快]试试", "看新闻赢红包，0.1元起提秒到账 看[咖啡][拳头]资讯就能赚钱，我还是第一[愉快]次听说[亲亲]。免费看资讯，不仅[磕头]长知识，[亲亲]还会给奖励！真是[强]天大的福利，赶快来扫／码和我一起玩", "看新闻赢红包，0.1元起提秒到账 看资讯真给力，自己都不用出话费[拳头][悠闲]了！扫-码[拳头]加入吧，新闻种类多，资讯内容全，我每天都在这里看。肯定也有你们[拥抱]喜欢都，可[怄火]以[得意][抱拳]学到知识", "看新闻赢红包，0.1元起提秒到账 这个真的好，因为讲信用[OK]！我已经提现到账了[怄火][抱拳]，真棒！扫-码免[咖啡][跳绳]费看资讯还给钱，真是天大的好事。[咖啡]一样看新闻，这还[西瓜][胜利]能赚钱", "看新闻赢红包，0.1元起提秒到账 来这里看资讯，玩起来很带劲的！我是别[太阳][太阳]人介绍的[奋斗]，免[偷笑]费扫[嘘]·码看资讯的，推荐给大家试试。用下来还不错，[握手]就看看文章就能赚钱", "看新闻赢红包，0.1元起提秒到账 这里看新闻有惊喜！[悠闲][抱拳]边看边得奖励，玩起来很带劲！相[闪电][得意]信我就对了，快来试试[偷笑][转圈]看。扫-码[嘘][嘘]免费的，没有吃[跳绳]亏，自己用了就知道好了", "看新闻赢红包，0.1元起提秒到账 免费送福利[奋斗]啦[西瓜][奋斗]！看了资讯给奖金，玩法简单，扫·码参加[愉快]就看看文章。完全免费的，不[西瓜][得意]会有啥损失。千载难逢的好[西瓜][礼物]事，这个机会得抓住啊！", "看新闻赢红包，0.1元起提秒到账 现[转圈][鼓掌]在身边的朋友，都在用这个看资讯。我也一[憨笑][握手]起了，看看[拥抱][奋斗]文章[鼓掌][转圈]就[抱拳][西瓜]能赚钱，真的不错！我已经提现了，很靠谱，赶快扫／码[啤酒]来一起", "看新闻赢红包，0.1元起提秒到账 有[怄火][色]个好平台推荐给[礼物][调皮]大家，我自[亲亲][调皮]己也在玩，感觉还不错。可以[奋斗]提现的，[色][悠闲]我已经成功了。识别我的截图二维码，很讲[OK][悠闲]诚信的，赶紧一起来！", "看新闻赢红包，0.1元起提秒到账 真的能赚钱，大家可以试试[磕头]～真的[OK]讲信用，在这看新闻送钱的！不管给多[悠闲]少，积少成多！[拥抱]心[抱拳]态好，反正免费的，[得意]扫／码试试也不吃亏", "看新闻赢红包，0.1元起提秒到账 重[偷笑]要[胜利][怄火]发现，这里看资讯能赚钱！不需要投入，免费[啤酒]看的哦～第[悠闲][憨笑][跳绳]一次听说吧？抓住机会了，资讯内容丰富，推荐给大家扫·码试试看", "看新闻赢红包，0.1元起提秒到账 免费送福利啦！看了资讯给奖[西瓜]金，玩法简单，扫·码参加就看看文章。完全免费的[抱拳]，不会有[转圈]啥损失。千[咖啡]载难逢的好[礼物][跳跳]事，这个机会得抓住[亲亲]啊！"};

    /* loaded from: classes4.dex */
    public interface a {
        void a();

        void b(c errorResult);

        void c(MartianRPAccount rpAccount);

        void onLoading(boolean loading);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a();

        void b(c errorResult);

        void c(MartianRPUser user);

        void onLoading(boolean loading);
    }

    public MartianRPUserManager(Context context) {
        super(context);
        this.h1 = null;
        this.i1 = true;
        this.j1 = null;
        this.g1 = context;
    }

    public static String A(Context ctx) {
        if (ctx == null) {
            return "";
        }
        try {
            return ctx.getPackageManager().getPackageInfo(ctx.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static void B(Context context) {
        MartianRPUserManager martianRPUserManager = new MartianRPUserManager(context);
        MartianIUserManager.f14914a = martianRPUserManager;
        martianRPUserManager.e();
        MartianIUserManager.f14914a.c();
    }

    private boolean C() {
        MartianRPUser martianRPUser = new MartianRPUser();
        this.h1 = martianRPUser;
        if (h.l(this.g1, martianRPUser)) {
            return true;
        }
        this.h1 = null;
        return false;
    }

    private void D() {
        com.martian.rpauth.b bVar = this.h1;
        if (bVar != null) {
            h.u(this.g1, bVar);
        }
    }

    public static boolean E(long grabTime) {
        return grabTime - t() <= 0;
    }

    private boolean g() {
        MartianRPAccount martianRPAccount = new MartianRPAccount();
        this.j1 = martianRPAccount;
        if (h.l(this.g1, martianRPAccount)) {
            return true;
        }
        this.j1 = null;
        return false;
    }

    public static void j(int requestCode, int resultCode, Intent data) {
        QQAPIInstance.getInstance().onActivityResult(requestCode, resultCode, data);
    }

    private void n() {
        MartianRPAccount martianRPAccount = this.j1;
        if (martianRPAccount != null) {
            h.u(this.g1, martianRPAccount);
        }
    }

    public static String q() {
        return "每日上千红包大放送！";
    }

    public static String r() {
        return "[现金红包]每日上千红包大放送,抢红包抢到手软,每天都像过大年";
    }

    public static String s() {
        return "[现金红包]每日上千红包大放送,抢红包抢到手软,天天都像过大年,太爽了!";
    }

    public static long t() {
        return System.currentTimeMillis() + MTHttpGetParams.diffServerTime;
    }

    public static MartianRPUserManager u() {
        return (MartianRPUserManager) MartianIUserManager.f14914a;
    }

    public static String v() {
        Random random = new Random();
        String[] strArr = e1;
        return strArr[random.nextInt(strArr.length)];
    }

    public static String w() {
        return "看新闻赢红包，0.1元起提秒到账";
    }

    public static String x() {
        Random random = new Random();
        String[] strArr = f1;
        return strArr[random.nextInt(strArr.length)];
    }

    public static String y(String nickname) {
        return TextUtils.isEmpty(nickname) ? "" : nickname.length() > 6 ? nickname.substring(0, 5) : nickname;
    }

    public static long z(long targetTime) {
        return targetTime - MTHttpGetParams.diffServerTime;
    }

    @Override // com.martian.rpauth.MartianIUserManager
    public boolean a() {
        return this.i1;
    }

    @Override // com.martian.rpauth.MartianIUserManager
    public MartianRPAccount c() {
        if (this.j1 == null) {
            g();
        }
        return this.j1;
    }

    @Override // com.martian.rpauth.MartianIUserManager
    public IAccount d() {
        return null;
    }

    @Override // com.martian.rpauth.MartianIUserManager
    public com.martian.rpauth.b e() {
        if (this.h1 == null) {
            C();
        }
        return this.h1;
    }

    @Override // com.martian.rpauth.MartianIUserManager
    public boolean f() {
        return (e() == null || k.p(this.h1.getToken()) || this.h1.getUid() == null || this.h1.getUid().longValue() == -1) ? false : true;
    }

    @Override // com.martian.rpauth.MartianIUserManager
    public boolean h() {
        return false;
    }

    @Override // com.martian.rpauth.MartianIUserManager
    public void i() {
        e();
        com.martian.rpauth.b bVar = this.h1;
        if (bVar != null) {
            bVar.setUid(-1L);
            this.h1.setToken("");
            this.h1.setQQ_openid("");
            this.h1.setProvince("");
            this.h1.setNickname("");
            this.h1.setCity("");
            this.h1.setCountry("");
            this.h1.setHeader("");
            this.h1.setGender((char) 0);
            this.h1.setEmail("");
            this.h1.setMobile("");
            this.h1.setUsername("");
            m(this.h1);
            this.h1 = null;
        }
        c();
        MartianRPAccount martianRPAccount = this.j1;
        if (martianRPAccount != null) {
            martianRPAccount.setUid(-1L);
            k(this.j1);
            this.j1 = null;
        }
        if (Build.VERSION.SDK_INT >= 22) {
            CookieManager.getInstance().removeAllCookie();
            CookieManager.getInstance().flush();
            return;
        }
        CookieSyncManager.createInstance(this.g1);
        CookieManager.getInstance().removeAllCookie();
        CookieManager.getInstance().removeSessionCookie();
        CookieSyncManager.getInstance().sync();
        CookieSyncManager.getInstance().startSync();
    }

    @Override // com.martian.rpauth.MartianIUserManager
    public void k(MartianRPAccount rpAccount) {
        this.j1 = rpAccount;
        n();
    }

    @Override // com.martian.rpauth.MartianIUserManager
    public void l(IAccount taskAccount) {
    }

    @Override // com.martian.rpauth.MartianIUserManager
    public void m(com.martian.rpauth.b user) {
        this.h1 = user;
        D();
    }

    @Override // com.martian.rpauth.MartianIUserManager
    public void o() {
    }

    @Override // com.martian.rpauth.MartianIUserManager
    public void p(j1 activity, String nickname, Character gender, final b.d.c.c.b<com.martian.rpauth.b> listener) {
        listener.onLoading(true);
    }
}
