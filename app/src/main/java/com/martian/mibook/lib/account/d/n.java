package com.martian.mibook.lib.account.d;

import android.app.Activity;
import com.martian.libmars.d.h;
import com.martian.mibook.lib.account.MiUserManager;
import com.martian.mibook.lib.account.request.auth.TYAuthParams;

/* loaded from: classes3.dex */
public abstract class n<Params extends TYAuthParams, Data> extends f<Params, Data> {

    /* renamed from: h */
    public static final int f13906h = 205;

    /* renamed from: i */
    private final Activity f13907i;

    class a implements h.a {
        a() {
        }

        @Override // com.martian.libmars.d.h.a
        public void a() {
            n.this.f13904g.i();
        }

        @Override // com.martian.libmars.d.h.a
        public void b() {
            n.this.f13904g.i();
            com.martian.mibook.lib.account.e.d.b(n.this.f13907i, 200, true);
        }
    }

    public n(Activity activity, Class<Params> paramsClass, Class<Data> dataType) {
        super(paramsClass, dataType);
        this.f13907i = activity;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean q() {
        if (((TYAuthParams) k()).getUid() != null && !com.martian.libsupport.k.p(((TYAuthParams) k()).getToken())) {
            return true;
        }
        MiUserManager miUserManager = this.f13904g;
        return miUserManager != null && miUserManager.f();
    }

    @Override // com.martian.mibook.lib.account.d.f, b.d.c.c.d
    public b.d.c.b.k i() {
        if (q()) {
            return super.i();
        }
        b.d.c.b.c cVar = new b.d.c.b.c(205, "Local uid or token info is null.");
        s(true);
        return cVar;
    }

    @Override // com.martian.mibook.lib.account.d.f, b.d.c.c.d
    public void j() {
        if (q()) {
            super.j();
        } else {
            s(true);
        }
    }

    public void onResultError(b.d.c.b.c errorResult) {
        if (errorResult.c() == 205) {
            s(false);
        }
        r(errorResult);
    }

    protected abstract void r(b.d.c.b.c errorResult);

    protected void s(boolean forceShowLogin) {
        if ((forceShowLogin || this.f13904g.f()) && this.f13907i != null) {
            com.martian.libmars.d.h.F().C1(this.f13907i, new a());
        }
    }
}
