package com.kwad.sdk.core.report;

import android.content.Context;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.bo;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public final class u<T extends e, R extends com.kwad.sdk.core.network.f> implements Runnable {
    private static AtomicLong aDk = new AtomicLong(-1);
    protected final l<T> aBw;
    protected final b<T, R> aDl;
    protected final AtomicInteger aDm;
    protected final Context mContext;

    /* renamed from: com.kwad.sdk.core.report.u$1 */
    public class AnonymousClass1 implements a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.report.u.a
        public final void GE() {
            u.this.GD();
        }
    }

    public interface a {
        void GE();
    }

    public u(Context context, l<T> lVar, b<T, R> bVar, AtomicInteger atomicInteger) {
        this.mContext = context;
        this.aBw = lVar;
        this.aDl = bVar;
        this.aDm = atomicInteger;
    }

    public final void GD() {
        long OT = bo.OT();
        if (OT >= aDk.get() * 2) {
            try {
                List<T> dn = this.aBw.dn(200);
                if (dn.isEmpty()) {
                    return;
                }
                this.aDl.a(dn, new AtomicBoolean(false), new a() { // from class: com.kwad.sdk.core.report.u.1
                    public AnonymousClass1() {
                    }

                    @Override // com.kwad.sdk.core.report.u.a
                    public final void GE() {
                        u.this.GD();
                    }
                });
            } catch (OutOfMemoryError e10) {
                aDk.set(OT);
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(e10);
            } catch (Throwable th2) {
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th2);
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.aDm.get() > 0 || !al.isNetworkConnected(this.mContext)) {
            return;
        }
        GD();
    }
}
