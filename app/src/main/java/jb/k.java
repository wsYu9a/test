package jb;

import android.app.Activity;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.lib.account.MiUserManager;
import com.martian.mibook.lib.account.request.auth.TYAuthParams;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public abstract class k<Params extends TYAuthParams, Data> extends d<Params, Data> {

    /* renamed from: j */
    public static final int f27315j = 205;

    /* renamed from: i */
    public final WeakReference<Activity> f27316i;

    public class a implements ConfigSingleton.a {
        public a() {
        }

        @Override // com.martian.libmars.common.ConfigSingleton.a
        public void a() {
            k.this.f27313h.i();
        }

        @Override // com.martian.libmars.common.ConfigSingleton.a
        public void b() {
            k.this.f27313h.i();
            lb.d.b((Activity) k.this.f27316i.get(), 200, true);
        }
    }

    public k(Activity activity, Class<Params> cls, Class<Data> cls2) {
        super(cls, cls2);
        this.f27316i = new WeakReference<>(activity);
    }

    @Override // jb.d, y8.d
    public x8.k i() {
        if (r()) {
            return super.i();
        }
        x8.c cVar = new x8.c(205, "Local uid or token info is null.");
        t(true);
        return cVar;
    }

    @Override // jb.d, y8.d
    public void j() {
        if (r()) {
            super.j();
        } else {
            t(true);
        }
    }

    public void onResultError(x8.c cVar) {
        if (cVar.c() == 205) {
            t(false);
        }
        s(cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean r() {
        if (((TYAuthParams) k()).getUid() != null && !ba.l.q(((TYAuthParams) k()).getToken())) {
            return true;
        }
        MiUserManager miUserManager = this.f27313h;
        return miUserManager != null && miUserManager.f();
    }

    public abstract void s(x8.c cVar);

    public void t(boolean z10) {
        if ((z10 || this.f27313h.f()) && this.f27316i.get() != null) {
            ConfigSingleton.D().n1(this.f27316i.get(), new a());
        }
    }
}
