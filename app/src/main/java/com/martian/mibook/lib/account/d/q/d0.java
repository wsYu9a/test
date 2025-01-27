package com.martian.mibook.lib.account.d.q;

import android.app.Activity;
import com.martian.libmars.d.h;
import com.martian.mibook.lib.account.MiUserManager;
import com.martian.mibook.lib.account.request.auth.TYAuthParams;

/* loaded from: classes3.dex */
public abstract class d0<Params extends TYAuthParams, Data> extends com.martian.mibook.lib.account.d.g<Params, Data> {

    /* renamed from: g */
    public static final int f13909g = 205;

    /* renamed from: h */
    private final Activity f13910h;

    class a implements h.a {
        a() {
        }

        @Override // com.martian.libmars.d.h.a
        public void a() {
            ((com.martian.mibook.lib.account.d.g) d0.this).f13905f.i();
        }

        @Override // com.martian.libmars.d.h.a
        public void b() {
            ((com.martian.mibook.lib.account.d.g) d0.this).f13905f.i();
            com.martian.mibook.lib.account.e.d.b(d0.this.f13910h, 200, true);
        }
    }

    public d0(Class aClass, Class dataType, Activity activity) {
        super(aClass, dataType, activity);
        this.f13910h = activity;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean r() {
        if (((TYAuthParams) k()).getUid() != null && !com.martian.libsupport.k.p(((TYAuthParams) k()).getToken())) {
            return true;
        }
        MiUserManager miUserManager = this.f13905f;
        return miUserManager != null && miUserManager.f();
    }

    @Override // com.martian.mibook.lib.account.d.g, b.d.c.c.d
    public void j() {
        if (r()) {
            super.j();
        } else {
            s(new b.d.c.b.c(205, "Local uid or token info is null."), true);
        }
    }

    public void onResultError(b.d.c.b.c errorResult) {
        if (errorResult.c() == 205) {
            s(errorResult, false);
        }
    }

    protected void s(b.d.c.b.c result, boolean forceShowLogin) {
        if ((forceShowLogin || this.f13905f.f()) && this.f13910h != null) {
            com.martian.libmars.d.h.F().C1(this.f13910h, new a());
        }
    }
}
