package w6;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.gyf.immersionbar.NotchUtils;

/* loaded from: classes2.dex */
public class k implements Runnable {

    /* renamed from: b */
    public com.gyf.immersionbar.d f31654b;

    /* renamed from: c */
    public b f31655c;

    /* renamed from: d */
    public p f31656d;

    /* renamed from: e */
    public int f31657e;

    public k(Object obj) {
        if (obj instanceof Activity) {
            if (this.f31654b == null) {
                this.f31654b = new com.gyf.immersionbar.d((Activity) obj);
                return;
            }
            return;
        }
        if (obj instanceof Fragment) {
            if (this.f31654b == null) {
                if (obj instanceof DialogFragment) {
                    this.f31654b = new com.gyf.immersionbar.d((DialogFragment) obj);
                    return;
                } else {
                    this.f31654b = new com.gyf.immersionbar.d((Fragment) obj);
                    return;
                }
            }
            return;
        }
        if ((obj instanceof android.app.Fragment) && this.f31654b == null) {
            if (obj instanceof android.app.DialogFragment) {
                this.f31654b = new com.gyf.immersionbar.d((android.app.DialogFragment) obj);
            } else {
                this.f31654b = new com.gyf.immersionbar.d((android.app.Fragment) obj);
            }
        }
    }

    public final void a(Configuration configuration) {
        com.gyf.immersionbar.d dVar = this.f31654b;
        if (dVar == null || !dVar.e1()) {
            return;
        }
        p pVar = this.f31654b.m0().O;
        this.f31656d = pVar;
        if (pVar != null) {
            Activity activity = this.f31654b.getActivity();
            if (this.f31655c == null) {
                this.f31655c = new b();
            }
            this.f31655c.s(configuration.orientation == 1);
            int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
            if (rotation == 1) {
                this.f31655c.l(true);
                this.f31655c.m(false);
            } else if (rotation == 3) {
                this.f31655c.l(false);
                this.f31655c.m(true);
            } else {
                this.f31655c.l(false);
                this.f31655c.m(false);
            }
            activity.getWindow().getDecorView().post(this);
        }
    }

    public com.gyf.immersionbar.d b() {
        return this.f31654b;
    }

    public void c(Configuration configuration) {
        a(configuration);
    }

    public void d(Configuration configuration) {
        com.gyf.immersionbar.d dVar = this.f31654b;
        if (dVar != null) {
            dVar.L1(configuration);
            a(configuration);
        }
    }

    public void e() {
        this.f31655c = null;
        this.f31656d = null;
        com.gyf.immersionbar.d dVar = this.f31654b;
        if (dVar != null) {
            dVar.M1();
            this.f31654b = null;
        }
    }

    public void f() {
        com.gyf.immersionbar.d dVar = this.f31654b;
        if (dVar != null) {
            dVar.N1();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        com.gyf.immersionbar.d dVar = this.f31654b;
        if (dVar == null || dVar.getActivity() == null) {
            return;
        }
        Activity activity = this.f31654b.getActivity();
        com.gyf.immersionbar.a aVar = new com.gyf.immersionbar.a(activity);
        this.f31655c.t(aVar.k());
        this.f31655c.n(aVar.m());
        this.f31655c.o(aVar.d());
        this.f31655c.p(aVar.g());
        this.f31655c.k(aVar.a());
        boolean hasNotchScreen = NotchUtils.hasNotchScreen(activity);
        this.f31655c.r(hasNotchScreen);
        if (hasNotchScreen && this.f31657e == 0) {
            int notchHeight = NotchUtils.getNotchHeight(activity);
            this.f31657e = notchHeight;
            this.f31655c.q(notchHeight);
        }
        this.f31656d.a(this.f31655c);
    }

    public k(Activity activity, Dialog dialog) {
        if (this.f31654b == null) {
            this.f31654b = new com.gyf.immersionbar.d(activity, dialog);
        }
    }
}
