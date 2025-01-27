package com.kwad.components.core.l.kwai;

import android.os.SystemClock;
import com.kwad.sdk.utils.bi;

/* loaded from: classes2.dex */
public final class a {
    private String NY;
    private long NZ;
    private long Oa;
    private long Ob;
    private boolean Oc;

    /* renamed from: com.kwad.components.core.l.kwai.a$1 */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.this.Ob = SystemClock.uptimeMillis();
            a.this.report();
        }
    }

    public final void ax(String str) {
        this.NY = str;
    }

    public final void pa() {
        if (this.Oc) {
            return;
        }
        this.Oc = true;
        bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.l.kwai.a.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                a.this.Ob = SystemClock.uptimeMillis();
                a.this.report();
            }
        });
    }

    public final void report() {
        b bVar = new b();
        bVar.NY = this.NY;
        long j2 = this.NZ;
        bVar.Of = j2 != 0 ? this.Oa - j2 : 0L;
        long j3 = this.Oa;
        bVar.Og = j3 != 0 ? this.Ob - j3 : 0L;
        bVar.Oe = j2 != 0 ? this.Ob - j2 : 0L;
        com.kwad.components.core.m.a.pb().a(bVar);
        com.kwad.sdk.core.d.b.d("PageMonitor", bVar.toString());
    }

    public final void u(long j2) {
        this.NZ = j2;
        this.Oa = SystemClock.uptimeMillis();
    }
}
