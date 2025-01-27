package m8;

import android.app.Activity;
import com.martian.appwall.request.auth.MartianAppwallAuthParams;
import com.martian.rpauth.MartianIUserManager;
import java.lang.ref.WeakReference;
import x8.k;

/* loaded from: classes3.dex */
public abstract class a<Params extends MartianAppwallAuthParams, Data> extends ne.a<Params, Data> {

    /* renamed from: j */
    public static final int f28527j = 205;

    /* renamed from: h */
    public final WeakReference<Activity> f28528h;

    /* renamed from: i */
    public final MartianIUserManager f28529i;

    public a(Activity activity, MartianIUserManager martianIUserManager, Class<Params> cls, Class<Data> cls2) {
        super(cls, cls2);
        this.f28528h = new WeakReference<>(activity);
        this.f28529i = martianIUserManager;
    }

    @Override // y8.d
    public k i() {
        if (r(this.f28529i)) {
            return super.i();
        }
        x8.c cVar = new x8.c(205, "Local uid or token info is null.");
        q(cVar);
        return cVar;
    }

    @Override // y8.d
    public void j() {
        if (r(this.f28529i)) {
            super.j();
        } else {
            q(new x8.c(205, "Local uid or token info is null."));
        }
    }

    @Override // y8.a
    public void onResultError(x8.c cVar) {
        if (cVar.c() == 205) {
            q(cVar);
        } else {
            p(cVar);
        }
    }

    public abstract void p(x8.c cVar);

    public final void q(x8.c cVar) {
        MartianIUserManager martianIUserManager;
        WeakReference<Activity> weakReference = this.f28528h;
        if (weakReference == null || weakReference.get() == null || (martianIUserManager = this.f28529i) == null) {
            return;
        }
        martianIUserManager.i();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean r(MartianIUserManager martianIUserManager) {
        if (martianIUserManager == null || !martianIUserManager.f()) {
            return false;
        }
        me.b e10 = martianIUserManager.e();
        if (e10 == null) {
            return true;
        }
        ((MartianAppwallAuthParams) k()).setUid(e10.getUid());
        ((MartianAppwallAuthParams) k()).setToken(e10.getToken());
        return true;
    }
}
