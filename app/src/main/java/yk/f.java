package yk;

import java.util.ArrayList;

/* loaded from: classes5.dex */
public final class f {

    /* renamed from: b */
    public static f f33571b;

    /* renamed from: a */
    public final ArrayList<a> f33572a = new ArrayList<>(2);

    public interface a {
        void j();
    }

    public static f a() {
        if (f33571b == null) {
            synchronized (f.class) {
                try {
                    if (f33571b == null) {
                        f33571b = new f();
                    }
                } finally {
                }
            }
        }
        return f33571b;
    }

    public final void b(a aVar) {
        synchronized (this.f33572a) {
            try {
                if (mj.j.a().getBoolean("privacy_agreed", false)) {
                    aVar.j();
                } else {
                    this.f33572a.add(aVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
