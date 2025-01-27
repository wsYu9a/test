package com.martian.rpauth;

import android.content.Context;
import android.content.Intent;
import b.d.c.b.c;
import com.martian.libmars.activity.j1;
import com.martian.libqq.QQAPIInstance;
import com.martian.libsupport.h;
import com.martian.rpauth.response.IAccount;
import com.martian.rpauth.response.MartianRPAccount;

/* loaded from: classes.dex */
public abstract class MartianIUserManager {

    /* renamed from: a */
    protected static MartianIUserManager f14914a;

    /* renamed from: b */
    protected Context f14915b;

    /* renamed from: c */
    private MartianRPAccount f14916c = null;

    /* loaded from: classes4.dex */
    public interface a {
        void a();

        void b(c errorResult);

        void c(MartianRPAccount rpAccount);

        void onLoading(boolean loading);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(c errorResult);

        void b(com.martian.rpauth.b user);

        void onLoading(boolean loading);

        void onLoginCancelled();
    }

    public MartianIUserManager(Context context) {
        this.f14915b = context;
    }

    public static MartianIUserManager b() {
        return f14914a;
    }

    private boolean g() {
        MartianRPAccount martianRPAccount = new MartianRPAccount();
        this.f14916c = martianRPAccount;
        if (h.l(this.f14915b, martianRPAccount)) {
            return true;
        }
        this.f14916c = null;
        return false;
    }

    public static void j(int requestCode, int resultCode, Intent data) {
        QQAPIInstance.getInstance().onActivityResult(requestCode, resultCode, data);
    }

    private void n() {
        MartianRPAccount martianRPAccount = this.f14916c;
        if (martianRPAccount != null) {
            h.u(this.f14915b, martianRPAccount);
        }
    }

    public abstract boolean a();

    public MartianRPAccount c() {
        if (this.f14916c == null) {
            g();
        }
        return this.f14916c;
    }

    public abstract IAccount d();

    public abstract com.martian.rpauth.b e();

    public abstract boolean f();

    public abstract boolean h();

    public abstract void i();

    public void k(MartianRPAccount rpAccount) {
        this.f14916c = rpAccount;
        n();
    }

    public abstract void l(IAccount taskAccount);

    public abstract void m(com.martian.rpauth.b user);

    public abstract void o();

    public abstract void p(j1 activity, String nickname, Character gender, final b.d.c.c.b<com.martian.rpauth.b> listener);
}
