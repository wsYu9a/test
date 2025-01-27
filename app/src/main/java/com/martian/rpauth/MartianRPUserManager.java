package com.martian.rpauth;

import android.content.Context;
import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import ba.j;
import ba.l;
import com.martian.libmars.comm.request.MTHttpGetParams;
import com.martian.rpauth.response.IAccount;
import com.martian.rpauth.response.MartianRPAccount;
import com.martian.rpauth.response.MartianRPUser;
import me.b;

/* loaded from: classes3.dex */
public class MartianRPUserManager extends MartianIUserManager {

    /* renamed from: f */
    public static final int f16182f = 10001;

    /* renamed from: g */
    public static final int f16183g = 10002;

    /* renamed from: h */
    public static final int f16184h = 20001;

    /* renamed from: i */
    public static final int f16185i = 20003;

    /* renamed from: j */
    public static final int f16186j = 20005;

    /* renamed from: k */
    public static final int f16187k = 10;

    /* renamed from: l */
    public static final String f16188l = "INVITE_SHARE_INFO";

    /* renamed from: m */
    public static final int f16189m = 0;

    /* renamed from: n */
    public static final int f16190n = 1;

    /* renamed from: o */
    public static final int f16191o = 2;

    /* renamed from: p */
    public static final int f16192p = 3;

    /* renamed from: q */
    public static final int f16193q = 4;

    /* renamed from: r */
    public static final int f16194r = 5;

    /* renamed from: s */
    public static final int f16195s = 6;

    /* renamed from: t */
    public static final int f16196t = 1;

    /* renamed from: u */
    public static final String f16197u = "WITHDRAW_GUIDE_TO_RATE";

    /* renamed from: v */
    public static final String f16198v = "WITHDRAW_TYPE";

    /* renamed from: d */
    public b f16199d;

    /* renamed from: e */
    public MartianRPAccount f16200e;

    public MartianRPUserManager(Context context) {
        super(context);
        this.f16199d = null;
        this.f16200e = null;
    }

    public static long a() {
        return System.currentTimeMillis() + MTHttpGetParams.diffServerTime;
    }

    public static MartianRPUserManager o() {
        return (MartianRPUserManager) MartianIUserManager.f16179c;
    }

    public static void p(Context context) {
        MartianRPUserManager martianRPUserManager = new MartianRPUserManager(context);
        MartianIUserManager.f16179c = martianRPUserManager;
        martianRPUserManager.e();
        MartianIUserManager.f16179c.c();
    }

    private void q() {
        this.f16199d = new MartianRPUser();
        if (j.l(getContext(), this.f16199d)) {
            return;
        }
        this.f16199d = null;
    }

    private void r() {
        if (this.f16199d != null) {
            j.u(getContext(), this.f16199d);
        }
    }

    @Override // com.martian.rpauth.MartianIUserManager
    public MartianRPAccount c() {
        if (this.f16200e == null) {
            g();
        }
        return this.f16200e;
    }

    @Override // com.martian.rpauth.MartianIUserManager
    public IAccount d() {
        return null;
    }

    @Override // com.martian.rpauth.MartianIUserManager
    public b e() {
        if (this.f16199d == null) {
            q();
        }
        return this.f16199d;
    }

    @Override // com.martian.rpauth.MartianIUserManager
    public boolean f() {
        b bVar = this.f16199d;
        return (bVar == null || l.q(bVar.getToken()) || this.f16199d.getUid() == null || this.f16199d.getUid().longValue() == -1) ? false : true;
    }

    public final void g() {
        this.f16200e = new MartianRPAccount();
        if (j.l(getContext(), this.f16200e)) {
            return;
        }
        this.f16200e = null;
    }

    @Override // com.martian.rpauth.MartianIUserManager
    public void h() {
    }

    @Override // com.martian.rpauth.MartianIUserManager
    public void i() {
        e();
        b bVar = this.f16199d;
        if (bVar != null) {
            bVar.setUid(-1L);
            this.f16199d.setToken("");
            this.f16199d.setQQ_openid("");
            this.f16199d.setProvince("");
            this.f16199d.setNickname("");
            this.f16199d.setCity("");
            this.f16199d.setCountry("");
            this.f16199d.setHeader("");
            this.f16199d.setGender((char) 0);
            this.f16199d.setEmail("");
            this.f16199d.setMobile("");
            this.f16199d.setUsername("");
            l(this.f16199d);
            this.f16199d = null;
        }
        c();
        MartianRPAccount martianRPAccount = this.f16200e;
        if (martianRPAccount != null) {
            martianRPAccount.setUid(-1L);
            j(this.f16200e);
            this.f16200e = null;
        }
        if (Build.VERSION.SDK_INT >= 22) {
            CookieManager.getInstance().removeAllCookie();
            CookieManager.getInstance().flush();
            return;
        }
        CookieSyncManager.createInstance(getContext());
        CookieManager.getInstance().removeAllCookie();
        CookieManager.getInstance().removeSessionCookie();
        CookieSyncManager.getInstance().sync();
        CookieSyncManager.getInstance().startSync();
    }

    @Override // com.martian.rpauth.MartianIUserManager
    public void j(MartianRPAccount martianRPAccount) {
        this.f16200e = martianRPAccount;
        m();
    }

    @Override // com.martian.rpauth.MartianIUserManager
    public void k(IAccount iAccount) {
    }

    @Override // com.martian.rpauth.MartianIUserManager
    public void l(b bVar) {
        this.f16199d = bVar;
        r();
    }

    public final void m() {
        if (this.f16200e != null) {
            j.u(getContext(), this.f16200e);
        }
    }

    @Override // com.martian.rpauth.MartianIUserManager
    public void n() {
    }
}
