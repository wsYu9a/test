package kb;

import android.app.Activity;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.lib.account.MiUserManager;
import com.martian.mibook.lib.account.request.auth.TYAuthPostParams;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public abstract class w<Params extends TYAuthPostParams, Data> extends jb.e<Params, Data> {

    /* renamed from: i */
    public static final int f27742i = 205;

    /* renamed from: h */
    public final WeakReference<Activity> f27743h;

    public class a implements ConfigSingleton.a {
        public a() {
        }

        @Override // com.martian.libmars.common.ConfigSingleton.a
        public void a() {
            w.this.f27314g.i();
        }

        @Override // com.martian.libmars.common.ConfigSingleton.a
        public void b() {
            w.this.f27314g.i();
            lb.d.b((Activity) w.this.f27743h.get(), 200, true);
        }
    }

    public w(Class cls, Class cls2, Activity activity) {
        super(cls, cls2, activity);
        this.f27743h = new WeakReference<>(activity);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean t() {
        if (((TYAuthPostParams) k()).getUid() != null && !ba.l.q(((TYAuthPostParams) k()).getToken())) {
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
            u(new x8.c(205, "Local uid or token info is null."), true);
        }
    }

    public void onResultError(x8.c cVar) {
        if (cVar.c() == 205) {
            u(cVar, false);
        }
    }

    public void u(x8.c cVar, boolean z10) {
        WeakReference<Activity> weakReference;
        if ((!z10 && !this.f27314g.f()) || (weakReference = this.f27743h) == null || weakReference.get() == null) {
            return;
        }
        ConfigSingleton.D().n1(this.f27743h.get(), new a());
    }
}
