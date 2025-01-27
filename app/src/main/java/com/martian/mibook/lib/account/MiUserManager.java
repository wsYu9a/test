package com.martian.mibook.lib.account;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;
import b.d.c.b.c;
import com.maritan.libweixin.c;
import com.martian.libmars.activity.j1;
import com.martian.libmars.d.h;
import com.martian.libqq.QQAPIInstance;
import com.martian.libqq.QQAuth;
import com.martian.libqq.QQUserInfo;
import com.martian.libsupport.k;
import com.martian.mibook.lib.account.d.j;
import com.martian.mibook.lib.account.d.p;
import com.martian.mibook.lib.account.request.MiUserRegisterParams;
import com.martian.mibook.lib.account.request.WXRegisterParams;
import com.martian.mibook.lib.account.response.AliRechargeOrder;
import com.martian.mibook.lib.account.response.MiTaskAccount;
import com.martian.mibook.lib.account.response.MiUser;
import com.martian.mibook.lib.account.response.WXRechargeOrder;
import com.martian.rpauth.MartianIUserManager;
import com.martian.rpauth.response.IAccount;
import com.martian.rpauth.response.MartianRPAccount;
import com.tencent.mm.opensdk.modelpay.PayReq;
import java.util.LinkedList;
import java.util.Random;
import org.apache.http.message.BasicNameValuePair;

/* loaded from: classes.dex */
public class MiUserManager extends MartianIUserManager {

    /* renamed from: d */
    public static final int f13712d = 10001;

    /* renamed from: e */
    public static final int f13713e = 10002;

    /* renamed from: f */
    public static final int f13714f = 10003;

    /* renamed from: g */
    public static final int f13715g = 20002;

    /* renamed from: h */
    public static final int f13716h = 20003;

    /* renamed from: i */
    public static final int f13717i = 20004;

    /* renamed from: j */
    public static final int f13718j = 20005;
    public static final int k = 0;
    public static final int l = 0;
    public static final int m = 1;
    public static final int n = 2;
    public static final int o = 10;
    public static final int p = 888;
    public static final String q = "INTENT_WITHDRAW_FORCE_SHARE";
    public static final String r = "INTENT_WITHDRAW_SHARE_MONEY";
    public static final String s = "INTENT_LOGIN_TYPE";
    public static final String t = "INTENT_LOGIN_PRIVACY_CHECKED";
    public static final int u = 200;
    public static final int v = 201;
    public static final int w = 202;
    private static final String x = "PREF_USER_INFO";
    public static final String y = "isPurchaseNoHint";
    private com.martian.rpauth.b B;
    public boolean C;
    private IAccount D;
    public static String[] z = {"这里看小说能赚钱，1元起提秒到账 每天都有收益，提现秒到微信钱包，太爽了!", "这里看小说能赚钱，1元起提秒到账 [胜利][胜利]好平台不忽悠[色][跳跳]，来[鼓掌]看小说就送钱！相信我，我一直在玩，扫-码参与很简单，就看看小说[握手]，有兴趣的都可以一起交流", "这里看小说能赚钱，1元起提秒到账 最近在这看小说，[微笑]边[拳头]看还能边赚-钱，连[微笑]话费都赚出来了，错过就没了[偷笑][握手]！免费扫.码的没风险，绝对靠谱[咖啡][得意]，我用[呲牙][调皮]到现在了", "这里看小说能赚钱，1元起提秒到账 这里[拳头][调皮]看小说能赚钱，[啤酒][调皮]放心大[色]胆随便看！而且看了会有意外收获哦～我已扫·[闪电][跳跳]码在玩了，竟然[怄火]可以赚钱的，大家快来", "这里看小说能赚钱，1元起提秒到账 这里看小说会给钱，就是这么任性！我看了[OK]就停不下[抱拳][愉快]来，平时有空就会看。看小说很简单，翻翻[握手][强][握手][拥抱]小说就有钱，赶快扫[西瓜]／码加入", "这里看小说能赚钱，1元起提秒到账 大家有福了～只[得意]要[偷笑]看小说就[拳头][微笑]能赚钱[跳跳][呲牙]！扫-码参[握手][咖啡]加看[西瓜]的时候，不知不觉就会有收益。这个模式非常不错，这个便宜不要错过了", "这里看小说能赚钱，1元起提秒到账 看小说，大家可以来这里。内容很丰富[愉快][微笑]，覆盖面广，看[鼓掌][偷笑]了还有奖励哦！我已经扫·码在看了[愉快][愉快][怄火]，还挺有意思的。[胜利]让你更有阅[礼物]读的动力！", "这里看小说能赚钱，1元起提秒到账 最近喜欢上看小说，原[磕头]因是因为这个[强][磕头]。推荐[得意][调皮]给大家扫·[胜利][鼓掌]码试试，我用到现在了，没毛病！看[调皮]新[西瓜][握手]闻给奖励，别的地方可没这福利", "这里看小说能赚钱，1元起提秒到账 机会[奋斗][奋斗]只给有准备的人，[色]这个很不错，随便看看小说就有钱！海量小说等着你，肯定有你喜欢的！赶[太阳][啤酒]快抓住[转圈]机会扫／码[咖啡][愉快]试试", "这里看小说能赚钱，1元起提秒到账 看[咖啡][拳头]小说就能赚钱，我还是第一[愉快]次听说[亲亲]，不仅[磕头]长知识，[亲亲]还会给奖励！真是[强]天大的福利，赶快来扫／码和我一起玩", "这里看小说能赚钱，1元起提秒到账 看小说真给力，自己都不用出话费[拳头][悠闲]了！扫-码[拳头]加入吧，小说种类多，内容全，我每天都在这里看。肯定也有你们[拥抱]喜欢都，可[怄火]以[得意][抱拳]学到知识", "这里看小说能赚钱，1元起提秒到账 这个真的好，因为讲信用[OK]！我已经提现到账了[怄火][抱拳]，真棒！扫-码免[咖啡][跳绳]费看资讯还给钱，真是天大的好事。[咖啡]一样看新闻，这还[西瓜][胜利]能赚钱", "这里看小说能赚钱，1元起提秒到账 来这里看小说，玩起来很带劲的！我是别[太阳][太阳]人介绍的[奋斗]，免[偷笑]费扫[嘘]·码看资讯的，推荐给大家试试。用下来还不错，[握手]就看看文章就能赚钱", "这里看小说能赚钱，1元起提秒到账 这里看小说有惊喜！[悠闲][抱拳]边看边得奖励，玩起来很带劲！相[闪电][得意]信我就对了，快来试试[偷笑][转圈]看。扫-码[嘘][嘘]免费的，没有吃[跳绳]亏，自己用了就知道好了", "这里看小说能赚钱，1元起提秒到账 免费送福利[奋斗]啦[西瓜][奋斗]！看了小说给奖金，玩法简单，扫·码参加[愉快]就看看文章。完全免费的，不[西瓜][得意]会有啥损失。千载难逢的好[西瓜][礼物]事，这个机会得抓住啊！", "这里看小说能赚钱，1元起提秒到账 现[转圈][鼓掌]在身边的朋友，都在用这个看小说。我也一[憨笑][握手]起了，看看[拥抱][奋斗]文章[鼓掌][转圈]就[抱拳][西瓜]能赚钱，真的不错！我已经提现了，很靠谱，赶快扫／码[啤酒]来一起", "这里看小说能赚钱，1元起提秒到账 有[怄火][色]个好平台推荐给[礼物][调皮]大家，我自[亲亲][调皮]己也在玩，感觉还不错。可以[奋斗]提现的，[色][悠闲]我已经成功了。识别我的截图二维码，很讲[OK][悠闲]诚信的，赶紧一起来！", "这里看小说能赚钱，1元起提秒到账 真的能赚钱，大家可以试试[磕头]～真的[OK]讲信用，在这看小说送钱的！不管给多[悠闲]少，积少成多！[拥抱]心[抱拳]态好，反正免费的，[得意]扫／码试试也不吃亏", "这里看小说能赚钱，1元起提秒到账 重[偷笑]要[胜利][怄火]发现，这里看小说能赚钱！不需要投入，免费[啤酒]看的哦～第[悠闲][憨笑][跳绳]一次听说吧？抓住机会了，资讯内容丰富，推荐给大家扫·码试试看", "这里看小说能赚钱，1元起提秒到账 免费送福利啦！看了小说给奖[西瓜]金，玩法简单，扫·码参加就看看文章。完全免费的[抱拳]，不会有[转圈]啥损失。千[咖啡]载难逢的好[礼物][跳跳]事，这个机会得抓住[亲亲]啊！"};
    public static String[] A = {"引领全民阅读，每天轻松赚零花，学知识，零门槛提现！", "看小说还能赚钱，每天都有收益，每天都能提现,提现秒到微信，太爽了!", "我一直在用这里赚-钱，就看看小说赚-零-花，关键免费,提现秒到微信，太爽了", "这里看小说肯定没错！便宜看还给-钱，强烈推荐给你！提现秒到微信，太爽了", "想赚¥吗？来看-小说吧~能赚-零-花·钱~,提现秒到微信，太爽了", "看小说就能赚-钱，天天有收益！提现速度快，安全可靠,提现秒到微信，太爽了", "看小说能赚·钱，我验证过，就看小说就可以！,提现秒到微信，太爽了", "想赚-零花·钱吗？来这里看-小说，便宜看还能赚-钱,提现秒到微信，太爽了", "看小说还给钱，不忽悠~能每天提-现哦！让你爱上阅读,提现秒到微信，太爽了"};

    /* loaded from: classes3.dex */
    class a implements QQAPIInstance.OnLoginListener {

        /* renamed from: a */
        final /* synthetic */ Activity f13719a;

        /* renamed from: b */
        final /* synthetic */ MartianIUserManager.b f13720b;

        /* renamed from: com.martian.mibook.lib.account.MiUserManager$a$a */
        class C0265a implements QQAPIInstance.QQUserInfoReceiver {

            /* renamed from: a */
            final /* synthetic */ QQAuth f13722a;

            /* renamed from: com.martian.mibook.lib.account.MiUserManager$a$a$a */
            class C0266a extends j {
                C0266a() {
                }

                @Override // b.d.c.c.b
                public void onResultError(c errorResult) {
                    a.this.f13720b.a(errorResult);
                }

                @Override // b.d.c.c.b
                /* renamed from: p */
                public void onDataReceived(MiUser miUser) {
                    a.this.f13720b.b(miUser);
                }

                @Override // b.d.c.c.g
                protected void showLoading(boolean show) {
                    if (show) {
                        return;
                    }
                    a.this.f13720b.onLoading(false);
                }
            }

            C0265a(final QQAuth val$auth) {
                this.f13722a = val$auth;
            }

            @Override // com.martian.libqq.QQAPIInstance.QQUserInfoReceiver
            public void onCancelled() {
                a.this.f13720b.onLoginCancelled();
                a.this.f13720b.onLoading(false);
            }

            @Override // com.martian.libqq.QQAPIInstance.QQUserInfoReceiver
            public void onErrorReceived(int errcode, String errStr) {
                a.this.f13720b.a(new c(errcode, errStr));
                a.this.f13720b.onLoading(false);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.martian.libqq.QQAPIInstance.QQUserInfoReceiver
            public void onUserInfoReceived(QQUserInfo user) {
                C0266a c0266a = new C0266a();
                ((MiUserRegisterParams) c0266a.k()).setCity(user.getCity());
                ((MiUserRegisterParams) c0266a.k()).setCountry(user.getCountry());
                ((MiUserRegisterParams) c0266a.k()).setQQGender(user.getGender());
                ((MiUserRegisterParams) c0266a.k()).setHeader(user.getHeaderUrl());
                ((MiUserRegisterParams) c0266a.k()).setNickname(user.getNickname());
                ((MiUserRegisterParams) c0266a.k()).setProvince(user.getProvince());
                ((MiUserRegisterParams) c0266a.k()).setQq_openid(this.f13722a.openid);
                ((MiUserRegisterParams) c0266a.k()).setQq_access_token(this.f13722a.access_token);
                ((MiUserRegisterParams) c0266a.k()).setQq_pf(this.f13722a.pf);
                c0266a.j();
            }
        }

        a(final Activity val$listener, final MartianIUserManager.b val$activity) {
            this.f13719a = val$listener;
            this.f13720b = val$activity;
        }

        @Override // com.martian.libqq.QQAPIInstance.OnLoginListener
        public void onLoginCancelled() {
            this.f13720b.onLoginCancelled();
            this.f13720b.onLoading(false);
        }

        @Override // com.martian.libqq.QQAPIInstance.OnLoginListener
        public void onLoginError(int errcode, String errStr) {
            this.f13720b.a(new c(errcode, errStr));
            this.f13720b.onLoading(false);
        }

        @Override // com.martian.libqq.QQAPIInstance.OnLoginListener
        public void onLoginSuccess(final QQAuth auth) {
            QQAPIInstance.getInstance().getUserInfo(this.f13719a, new C0265a(auth));
        }
    }

    /* loaded from: classes3.dex */
    class b implements c.InterfaceC0253c {

        /* renamed from: a */
        final /* synthetic */ MartianIUserManager.b f13725a;

        class a extends p {
            a() {
            }

            @Override // b.d.c.c.b
            public void onResultError(b.d.c.b.c errorResult) {
                b.this.f13725a.a(errorResult);
            }

            @Override // b.d.c.c.b
            /* renamed from: p */
            public void onDataReceived(MiUser miUser) {
                b.this.f13725a.b(miUser);
            }

            @Override // b.d.c.c.g
            protected void showLoading(boolean show) {
                if (show) {
                    return;
                }
                b.this.f13725a.onLoading(false);
            }
        }

        b(final MartianIUserManager.b val$listener) {
            this.f13725a = val$listener;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.maritan.libweixin.c.InterfaceC0253c
        public void a(String authorizationCode) {
            a aVar = new a();
            aVar.n();
            ((WXRegisterParams) aVar.k()).setWx_appid(h.F().y0().f9577a);
            ((WXRegisterParams) aVar.k()).setWx_code(authorizationCode);
            aVar.j();
        }

        @Override // com.maritan.libweixin.c.InterfaceC0253c
        public void b(String errStr) {
            this.f13725a.a(new b.d.c.b.c(-1, errStr));
            this.f13725a.onLoading(false);
        }

        @Override // com.maritan.libweixin.c.InterfaceC0253c
        public void onLoginCancelled() {
            this.f13725a.onLoginCancelled();
            this.f13725a.onLoading(false);
        }
    }

    public MiUserManager(Context context) {
        super(context);
        this.B = null;
        this.C = true;
        this.D = null;
        this.f14915b = context;
    }

    private boolean B() {
        MiUser miUser = new MiUser();
        this.B = miUser;
        if (com.martian.libsupport.h.l(this.f14915b, miUser)) {
            return true;
        }
        this.B = null;
        return false;
    }

    private void F() {
        com.martian.rpauth.b bVar = this.B;
        if (bVar != null) {
            com.martian.libsupport.h.u(this.f14915b, bVar);
        }
    }

    public static void j(int requestCode, int resultCode, Intent data) {
        QQAPIInstance.getInstance().onActivityResult(requestCode, resultCode, data);
    }

    public static b.d.b.b q(AliRechargeOrder aliRechargeOrder, String fee_value) {
        if (aliRechargeOrder == null) {
            return null;
        }
        b.d.b.b bVar = new b.d.b.b();
        bVar.f4380b = "淘书币充值";
        bVar.f4381c = "淘书币充值";
        bVar.f4379a = aliRechargeOrder.getRechargeOrder().getRoid() + "";
        bVar.f4382d = fee_value;
        bVar.f4384f = aliRechargeOrder.getPrepay().getOrderString();
        return bVar;
    }

    public static PayReq r(WXRechargeOrder tyRechargeWeixinOrder) {
        if (tyRechargeWeixinOrder == null || tyRechargeWeixinOrder.getPrepay() == null) {
            return null;
        }
        PayReq payReq = new PayReq();
        payReq.appId = tyRechargeWeixinOrder.getPrepay().appId;
        payReq.partnerId = tyRechargeWeixinOrder.getPrepay().getMchid();
        payReq.prepayId = tyRechargeWeixinOrder.getPrepay().getPrepayId();
        payReq.packageValue = "Sign=WXPay";
        payReq.nonceStr = tyRechargeWeixinOrder.getPrepay().getNonceStr();
        payReq.timeStamp = tyRechargeWeixinOrder.getPrepay().getTimestamp();
        payReq.sign = tyRechargeWeixinOrder.getPrepay().getPaySign();
        LinkedList linkedList = new LinkedList();
        linkedList.add(new BasicNameValuePair("appid", payReq.appId));
        linkedList.add(new BasicNameValuePair("noncestr", payReq.nonceStr));
        linkedList.add(new BasicNameValuePair("package", payReq.packageValue));
        linkedList.add(new BasicNameValuePair("partnerid", payReq.partnerId));
        linkedList.add(new BasicNameValuePair("prepayid", payReq.prepayId));
        linkedList.add(new BasicNameValuePair("timestamp", payReq.timeStamp));
        linkedList.add(new BasicNameValuePair("sign", payReq.sign));
        Log.e("orion", linkedList.toString());
        return payReq;
    }

    public static MiUserManager s() {
        return (MiUserManager) MartianIUserManager.f14914a;
    }

    public static String u() {
        Random random = new Random();
        String[] strArr = A;
        return strArr[random.nextInt(strArr.length)];
    }

    public static String v() {
        return "这里看小说能赚钱，提现秒到微信";
    }

    public static String w() {
        return u();
    }

    public static String x(Context ctx) {
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

    public static void y(Context context) {
        MiUserManager miUserManager = new MiUserManager(context);
        MartianIUserManager.f14914a = miUserManager;
        miUserManager.e();
        MartianIUserManager.f14914a.c();
        MartianIUserManager.f14914a.d();
    }

    public boolean A() {
        return com.martian.libsupport.h.d(this.f14915b, y, true);
    }

    public void C(boolean isPurchaseNoHint) {
        com.martian.libsupport.h.p(this.f14915b, y, isPurchaseNoHint);
    }

    public void D(final Activity activity, final MartianIUserManager.b listener) {
        listener.onLoading(true);
        QQAPIInstance.getInstance().startLogin(activity, new a(activity, listener));
    }

    public void E(final MartianIUserManager.b listener) {
        listener.onLoading(true);
        com.maritan.libweixin.c.g().B(new b(listener));
    }

    @Override // com.martian.rpauth.MartianIUserManager
    public boolean a() {
        return this.C;
    }

    @Override // com.martian.rpauth.MartianIUserManager
    public IAccount d() {
        if (this.D == null) {
            h();
        }
        return this.D;
    }

    @Override // com.martian.rpauth.MartianIUserManager
    public com.martian.rpauth.b e() {
        if (this.B == null) {
            B();
        }
        return this.B;
    }

    @Override // com.martian.rpauth.MartianIUserManager
    public boolean f() {
        com.martian.rpauth.b bVar = this.B;
        return (bVar == null || k.p(bVar.getToken()) || this.B.getUid() == null || this.B.getUid().longValue() == -1) ? false : true;
    }

    public Context getContext() {
        return this.f14915b;
    }

    @Override // com.martian.rpauth.MartianIUserManager
    public boolean h() {
        MiTaskAccount miTaskAccount = new MiTaskAccount();
        this.D = miTaskAccount;
        return com.martian.libsupport.h.l(this.f14915b, miTaskAccount);
    }

    @Override // com.martian.rpauth.MartianIUserManager
    public void i() {
        e();
        com.martian.rpauth.b bVar = this.B;
        if (bVar != null) {
            bVar.setUid(-1L);
            this.B.setToken("");
            this.B.setQQ_openid("");
            this.B.setProvince("");
            this.B.setNickname("");
            this.B.setCity("");
            this.B.setCountry("");
            this.B.setHeader("");
            this.B.setGender((char) 0);
            this.B.setEmail("");
            this.B.setMobile("");
            this.B.setUsername("");
            m(this.B);
            this.B = null;
        }
        MartianRPAccount c2 = c();
        if (c2 != null) {
            c2.setBookCoins(0);
            c2.setCoins(0);
            c2.setCommission(0);
            c2.setDuration(0);
            c2.setIsVip(0);
            c2.setVipEnd(null);
            c2.setWealth(0);
            k(c2);
        }
    }

    @Override // com.martian.rpauth.MartianIUserManager
    public void l(IAccount taskAccount) {
        this.D = taskAccount;
        o();
    }

    @Override // com.martian.rpauth.MartianIUserManager
    public void m(com.martian.rpauth.b user) {
        if (user instanceof MiUser) {
            this.B = user;
        } else {
            MiUser miUser = new MiUser();
            this.B = miUser;
            miUser.setHeader(user.getHeader());
            this.B.setUid(user.getUid());
            this.B.setCity(user.getCity());
            this.B.setCountry(user.getCountry());
            if (user.getCreatedOn() != null) {
                this.B.setCreatedOn(user.getCreatedOn());
            }
            this.B.setDeadline(user.getDeadline());
            this.B.setDevice_id(user.getDevice_id());
            this.B.setEmail(user.getEmail());
            this.B.setGender(user.getGender().charValue());
            this.B.setMobile(user.getMobile());
            this.B.setNickname(user.getNickname());
            this.B.setProvince(user.getProvince());
            this.B.setPassword(user.getPassword());
            this.B.setQQ_openid(user.getQQ_openid());
            this.B.setToken(user.getToken());
            this.B.setQQGender(user.getQQ_openid());
            this.B.setUsername(user.getUsername());
            this.B.setVcontributed(user.getVcontributed());
            this.B.setWx_openid(user.getWx_openid());
            this.B.setVcount(user.getVcount());
        }
        F();
    }

    @Override // com.martian.rpauth.MartianIUserManager
    public void o() {
        IAccount iAccount = this.D;
        if (iAccount != null) {
            com.martian.libsupport.h.u(this.f14915b, iAccount);
        }
    }

    @Override // com.martian.rpauth.MartianIUserManager
    public void p(j1 activity, String nickname, Character gender, b.d.c.c.b<com.martian.rpauth.b> listener) {
    }

    public long t() {
        long j2 = 0;
        if (e() != null) {
            long longValue = e().getUid().longValue() + 9382;
            for (int i2 = 0; i2 < 8; i2++) {
                long j3 = (longValue >>> (((8 - i2) - 1) << 3)) & 255;
                j2 = (j2 << 8) + ((15 & j3) << 4) + ((j3 & 240) >> 4);
            }
        }
        return j2;
    }

    public boolean z() {
        com.martian.rpauth.b bVar = this.B;
        if (bVar instanceof MiUser) {
            return ((MiUser) bVar).isGuest();
        }
        return false;
    }
}
