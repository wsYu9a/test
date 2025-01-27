package b.d.e.a;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.martian.ttbook.b.c.a.a.c.f;
import com.martian.ttbook.b.c.a.a.d.b.h;
import com.martian.ttbook.sdk.client.AdClientContext;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    private static d f4494a;

    /* renamed from: b */
    private com.martian.ttbook.b.c.a.a.d.b.g f4495b = new com.martian.ttbook.b.c.a.a.d.b.g(AdClientContext.getClientContext());

    class a implements Handler.Callback {

        /* renamed from: a */
        final /* synthetic */ c f4496a;

        a(d dVar, c cVar) {
            this.f4496a = cVar;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            c cVar = this.f4496a;
            if (cVar == null) {
                return false;
            }
            cVar.onInited();
            return false;
        }
    }

    class b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ com.martian.ttbook.b.c.a.a.c.f f4497a;

        b(com.martian.ttbook.b.c.a.a.c.f fVar) {
            this.f4497a = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f4495b.d(this.f4497a);
        }
    }

    public interface c {
        void onInited();
    }

    private d() {
    }

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (f4494a == null) {
                synchronized (d.class) {
                    if (f4494a == null) {
                        f4494a = new d();
                    }
                }
            }
            dVar = f4494a;
        }
        return dVar;
    }

    public f.a b(Context context) {
        return this.f4495b.a(context);
    }

    public Object d(c cVar) {
        com.martian.ttbook.b.c.a.a.d.b.h hVar;
        if (AdClientContext.getSdkConfiguration() != null) {
            h.b b2 = new h.b().c(AdClientContext.getSdkConfiguration().isUseTextureView()).b(AdClientContext.getSdkConfiguration().getOaid());
            if (AdClientContext.getSdkConfiguration().getPrivacyController() != null) {
                b2.a(new f(AdClientContext.getSdkConfiguration().getPrivacyController()));
            }
            hVar = b2.d();
        } else {
            hVar = null;
        }
        this.f4495b.c(new a(this, cVar), hVar);
        return null;
    }

    public void e(com.martian.ttbook.b.c.a.a.c.f fVar) {
        b.d.e.a.j.g.b(new b(fVar));
    }

    public void f(String str) {
        this.f4495b.g(str);
    }
}
