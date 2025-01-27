package com.martian.rpauth;

import android.content.Context;
import ba.j;
import com.martian.libmars.comm.request.MTHttpGetParams;
import com.martian.rpauth.response.IAccount;
import com.martian.rpauth.response.MartianRPAccount;
import java.lang.ref.WeakReference;
import me.b;

/* loaded from: classes3.dex */
public abstract class MartianIUserManager {

    /* renamed from: c */
    public static MartianIUserManager f16179c;

    /* renamed from: a */
    public WeakReference<Context> f16180a;

    /* renamed from: b */
    public MartianRPAccount f16181b = null;

    public MartianIUserManager(Context context) {
        this.f16180a = new WeakReference<>(context);
    }

    public static long a() {
        return System.currentTimeMillis() + MTHttpGetParams.diffServerTime;
    }

    public static MartianIUserManager b() {
        return f16179c;
    }

    private void g() {
        this.f16181b = new MartianRPAccount();
        if (j.l(getContext(), this.f16181b)) {
            return;
        }
        this.f16181b = null;
    }

    private void m() {
        if (this.f16181b != null) {
            j.u(getContext(), this.f16181b);
        }
    }

    public MartianRPAccount c() {
        if (this.f16181b == null) {
            g();
        }
        return this.f16181b;
    }

    public abstract IAccount d();

    public abstract b e();

    public abstract boolean f();

    public Context getContext() {
        return this.f16180a.get();
    }

    public abstract void h();

    public abstract void i();

    public void j(MartianRPAccount martianRPAccount) {
        this.f16181b = martianRPAccount;
        m();
    }

    public abstract void k(IAccount iAccount);

    public abstract void l(b bVar);

    public abstract void n();
}
