package m8;

import android.app.Activity;
import ba.l;
import com.martian.appwall.request.auth.MartianAppwallAuthParams;
import com.martian.rpauth.MartianIUserManager;

/* loaded from: classes3.dex */
public abstract class b<Params extends MartianAppwallAuthParams, Data> extends l8.b<Params, Data> {

    /* renamed from: h */
    public static final int f28530h = 205;

    public b(Class cls, Class cls2, Activity activity) {
        super(cls, cls2, activity);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean r() {
        if (((MartianAppwallAuthParams) k()).getUid() != null && !l.q(((MartianAppwallAuthParams) k()).getToken())) {
            return true;
        }
        MartianIUserManager martianIUserManager = this.f27954g;
        return martianIUserManager != null && martianIUserManager.f();
    }

    @Override // l8.b, y8.d
    public void j() {
        if (r()) {
            super.j();
        } else {
            s(new x8.c(205, "Local uid or token info is null."), true);
        }
    }

    public void onResultError(x8.c cVar) {
        if (cVar.c() == 205) {
            s(cVar, false);
        }
    }

    public void s(x8.c cVar, boolean z10) {
        MartianIUserManager martianIUserManager = this.f27954g;
        if (martianIUserManager != null) {
            martianIUserManager.i();
        }
    }
}
