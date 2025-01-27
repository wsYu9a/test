package com.martian.mibook.lib.account;

import android.content.Context;
import android.content.Intent;
import ba.j;
import ba.l;
import com.martian.libqq.QQAPIInstance;
import com.martian.mibook.lib.account.response.AliRechargeOrder;
import com.martian.mibook.lib.account.response.MiTaskAccount;
import com.martian.mibook.lib.account.response.MiUser;
import com.martian.mibook.lib.account.response.WXRechargeOrder;
import com.martian.rpauth.MartianIUserManager;
import com.martian.rpauth.response.IAccount;
import com.martian.rpauth.response.MartianRPAccount;
import com.tencent.mm.opensdk.modelpay.PayReq;
import e8.a;
import java.util.Random;
import me.b;

/* loaded from: classes3.dex */
public class MiUserManager extends MartianIUserManager {

    /* renamed from: f */
    public static final int f13850f = 10003;

    /* renamed from: g */
    public static final int f13851g = 20003;

    /* renamed from: h */
    public static final int f13852h = 20004;

    /* renamed from: i */
    public static final int f13853i = 10;

    /* renamed from: j */
    public static final String f13854j = "INTENT_LOGIN_TYPE";

    /* renamed from: k */
    public static final String f13855k = "INTENT_LOGIN_PRIVACY_CHECKED";

    /* renamed from: l */
    public static final int f13856l = 200;

    /* renamed from: m */
    public static final int f13857m = 201;

    /* renamed from: n */
    public static final int f13858n = 202;

    /* renamed from: o */
    public static final String f13859o = "isPurchaseNoHint";

    /* renamed from: p */
    public static String[] f13860p = {"引领全民阅读，每天轻松赚零花，学知识，零门槛提现！", "看小说还能赚钱，每天都有收益，每天都能提现,提现秒到微信，太爽了!", "我一直在用这里赚-钱，就看看小说赚-零-花，关键免费,提现秒到微信，太爽了", "这里看小说肯定没错！便宜看还给-钱，强烈推荐给你！提现秒到微信，太爽了", "想赚¥吗？来看-小说吧~能赚-零-花·钱~,提现秒到微信，太爽了", "看小说就能赚-钱，天天有收益！提现速度快，安全可靠,提现秒到微信，太爽了", "看小说能赚·钱，我验证过，就看小说就可以！,提现秒到微信，太爽了", "想赚-零花·钱吗？来这里看-小说，便宜看还能赚-钱,提现秒到微信，太爽了", "看小说还给钱，不忽悠~能每天提-现哦！让你爱上阅读,提现秒到微信，太爽了"};

    /* renamed from: d */
    public b f13861d;

    /* renamed from: e */
    public IAccount f13862e;

    public MiUserManager(Context context) {
        super(context);
        this.f13861d = null;
        this.f13862e = null;
    }

    public static a o(AliRechargeOrder aliRechargeOrder, String str) {
        if (aliRechargeOrder == null) {
            return null;
        }
        a aVar = new a();
        aVar.f25761b = "淘书币充值";
        aVar.f25762c = "淘书币充值";
        aVar.f25760a = aliRechargeOrder.getRechargeOrder().getRoid() + "";
        aVar.f25763d = str;
        aVar.f25765f = aliRechargeOrder.getPrepay().getOrderString();
        return aVar;
    }

    public static PayReq p(WXRechargeOrder wXRechargeOrder) {
        if (wXRechargeOrder == null || wXRechargeOrder.getPrepay() == null) {
            return null;
        }
        PayReq payReq = new PayReq();
        payReq.appId = wXRechargeOrder.getPrepay().appId;
        payReq.partnerId = wXRechargeOrder.getPrepay().getMchid();
        payReq.prepayId = wXRechargeOrder.getPrepay().getPrepayId();
        payReq.packageValue = "Sign=WXPay";
        payReq.nonceStr = wXRechargeOrder.getPrepay().getNonceStr();
        payReq.timeStamp = wXRechargeOrder.getPrepay().getTimestamp();
        payReq.sign = wXRechargeOrder.getPrepay().getPaySign();
        return payReq;
    }

    public static MiUserManager q() {
        MartianIUserManager martianIUserManager = MartianIUserManager.f16179c;
        if (martianIUserManager == null) {
            return null;
        }
        return (MiUserManager) martianIUserManager;
    }

    public static String r() {
        Random random = new Random();
        String[] strArr = f13860p;
        return strArr[random.nextInt(strArr.length)];
    }

    public static String s() {
        return "这里看小说能赚钱，提现秒到微信";
    }

    public static void t(Context context) {
        MiUserManager miUserManager = new MiUserManager(context);
        MartianIUserManager.f16179c = miUserManager;
        miUserManager.e();
        MartianIUserManager.f16179c.c();
        MartianIUserManager.f16179c.d();
    }

    public static void x(int i10, int i11, Intent intent) {
        QQAPIInstance.getInstance().onActivityResult(i10, i11, intent);
    }

    @Override // com.martian.rpauth.MartianIUserManager
    public IAccount d() {
        if (this.f13862e == null) {
            h();
        }
        return this.f13862e;
    }

    @Override // com.martian.rpauth.MartianIUserManager
    public b e() {
        if (this.f13861d == null) {
            w();
        }
        return this.f13861d;
    }

    @Override // com.martian.rpauth.MartianIUserManager
    public boolean f() {
        b bVar = this.f13861d;
        return (bVar == null || l.q(bVar.getToken()) || this.f13861d.getUid() == null || this.f13861d.getUid().longValue() == -1) ? false : true;
    }

    @Override // com.martian.rpauth.MartianIUserManager
    public void h() {
        this.f13862e = new MiTaskAccount();
        j.l(getContext(), this.f13862e);
    }

    @Override // com.martian.rpauth.MartianIUserManager
    public void i() {
        e();
        b bVar = this.f13861d;
        if (bVar != null) {
            bVar.setUid(-1L);
            this.f13861d.setToken("");
            this.f13861d.setQQ_openid("");
            this.f13861d.setProvince("");
            this.f13861d.setNickname("");
            this.f13861d.setCity("");
            this.f13861d.setCountry("");
            this.f13861d.setHeader("");
            this.f13861d.setGender((char) 0);
            this.f13861d.setEmail("");
            this.f13861d.setMobile("");
            this.f13861d.setUsername("");
            l(this.f13861d);
            this.f13861d = null;
        }
        MartianRPAccount c10 = c();
        if (c10 != null) {
            c10.setBookCoins(0);
            c10.setCoins(0);
            c10.setCommission(0);
            c10.setDuration(0);
            c10.setIsVip(0);
            c10.setVipEnd(null);
            c10.setWealth(0);
            j(c10);
        }
    }

    @Override // com.martian.rpauth.MartianIUserManager
    public void k(IAccount iAccount) {
        this.f13862e = iAccount;
        n();
    }

    @Override // com.martian.rpauth.MartianIUserManager
    public void l(b bVar) {
        if (bVar == null || (bVar instanceof MiUser)) {
            this.f13861d = bVar;
        } else {
            MiUser miUser = new MiUser();
            this.f13861d = miUser;
            miUser.setHeader(bVar.getHeader());
            this.f13861d.setUid(bVar.getUid());
            this.f13861d.setCity(bVar.getCity());
            this.f13861d.setCountry(bVar.getCountry());
            if (bVar.getCreatedOn() != null) {
                this.f13861d.setCreatedOn(bVar.getCreatedOn());
            }
            this.f13861d.setDeadline(bVar.getDeadline());
            this.f13861d.setDevice_id(bVar.getDevice_id());
            this.f13861d.setEmail(bVar.getEmail());
            this.f13861d.setGender(bVar.getGender().charValue());
            this.f13861d.setMobile(bVar.getMobile());
            this.f13861d.setNickname(bVar.getNickname());
            this.f13861d.setProvince(bVar.getProvince());
            this.f13861d.setPassword(bVar.getPassword());
            this.f13861d.setQQ_openid(bVar.getQQ_openid());
            this.f13861d.setToken(bVar.getToken());
            this.f13861d.setQQGender(bVar.getQQ_openid());
            this.f13861d.setUsername(bVar.getUsername());
            this.f13861d.setVcontributed(bVar.getVcontributed());
            this.f13861d.setWx_openid(bVar.getWx_openid());
            this.f13861d.setVcount(bVar.getVcount());
        }
        z();
    }

    @Override // com.martian.rpauth.MartianIUserManager
    public void n() {
        if (this.f13862e != null) {
            j.u(getContext(), this.f13862e);
        }
    }

    public boolean u() {
        b bVar = this.f13861d;
        if (bVar instanceof MiUser) {
            return ((MiUser) bVar).isGuest();
        }
        return false;
    }

    public boolean v() {
        return j.d(getContext(), f13859o, true);
    }

    public final void w() {
        this.f13861d = new MiUser();
        if (j.l(getContext(), this.f13861d)) {
            return;
        }
        this.f13861d = null;
    }

    public void y(boolean z10) {
        j.p(getContext(), f13859o, z10);
    }

    public final void z() {
        if (this.f13861d != null) {
            j.u(getContext(), this.f13861d);
        }
    }
}
