package kb;

import android.app.Activity;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.lib.account.MiUserManager;
import com.martian.mibook.lib.account.request.auth.TYAuthParams;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public abstract class v<Params extends TYAuthParams, Data> extends jb.e<Params, Data> {

    /* renamed from: i */
    public static final int f27739i = 205;

    /* renamed from: h */
    public final WeakReference<Activity> f27740h;

    public class a implements ConfigSingleton.a {
        public a() {
        }

        @Override // com.martian.libmars.common.ConfigSingleton.a
        public void a() {
            v.this.f27314g.i();
        }

        @Override // com.martian.libmars.common.ConfigSingleton.a
        public void b() {
            v.this.f27314g.i();
            lb.d.b((Activity) v.this.f27740h.get(), 200, true);
        }
    }

    public v(Class cls, Class cls2, Activity activity) {
        super(cls, cls2, activity);
        this.f27740h = new WeakReference<>(activity);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean t() {
        if (((TYAuthParams) k()).getUid() != null && !ba.l.q(((TYAuthParams) k()).getToken())) {
            return true;
        }
        MiUserManager miUserManager = this.f27314g;
        return miUserManager != null && miUserManager.f();
    }

    @Override // jb.e, y8.d
    public void j() {
        if (t()) {
            super.j();
        } else {
            u(true);
        }
    }

    public void onResultError(x8.c cVar) {
        if (cVar.c() == 205) {
            u(false);
        }
    }

    public void u(boolean z10) {
        if ((z10 || this.f27314g.f()) && this.f27740h.get() != null) {
            ConfigSingleton.D().n1(this.f27740h.get(), new a());
        }
    }
}
