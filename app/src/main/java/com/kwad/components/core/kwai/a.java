package com.kwad.components.core.kwai;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.sdk.core.b.d;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.core.report.h;
import com.kwad.sdk.core.report.q;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class a {
    private String Hq;
    private String Hr;
    private long Hs;
    private long Ht;
    private Timer Hu;
    private boolean Hv = false;
    private final long period;

    /* renamed from: com.kwad.components.core.kwai.a$1 */
    final class AnonymousClass1 extends d {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
        public final void onBackToBackground() {
            super.onBackToBackground();
            a.this.lU();
        }

        @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
        public final void onBackToForeground() {
            super.onBackToForeground();
            a.this.fc();
        }
    }

    /* renamed from: com.kwad.components.core.kwai.a$2 */
    final class AnonymousClass2 extends TimerTask {
        AnonymousClass2() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            a.this.am(2);
        }
    }

    /* renamed from: com.kwad.components.core.kwai.a$a */
    static final class C0178a {
        private static final a Hx = new a();
    }

    public a() {
        this.Hs = -1L;
        try {
            this.Hs = SystemClock.elapsedRealtime();
        } catch (Throwable th) {
            this.Hs = System.currentTimeMillis();
            b.printStackTraceOnly(th);
        }
        this.period = TimeUnit.MINUTES.toMillis(com.kwad.sdk.core.config.d.ub());
        AnonymousClass1 anonymousClass1 = new d() { // from class: com.kwad.components.core.kwai.a.1
            AnonymousClass1() {
            }

            @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
            public final void onBackToBackground() {
                super.onBackToBackground();
                a.this.lU();
            }

            @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
            public final void onBackToForeground() {
                super.onBackToForeground();
                a.this.fc();
            }
        };
        com.kwad.sdk.core.b.b.vS();
        com.kwad.sdk.core.b.b.a(anonymousClass1);
    }

    public void am(int i2) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = elapsedRealtime - this.Hs;
        this.Hs = elapsedRealtime;
        if (i2 == 1) {
            this.Ht = 0L;
            this.Hr = UUID.randomUUID().toString();
            if (TextUtils.isEmpty(this.Hq)) {
                this.Hq = this.Hr;
            }
        }
        this.Ht++;
        q qVar = new q(10220L);
        qVar.aeM = this.Ht;
        if (j2 > 0) {
            qVar.ajL = j2;
        }
        qVar.ajM = i2;
        qVar.Hq = this.Hq;
        qVar.Hr = this.Hr;
        h.a2(qVar);
    }

    public static a lT() {
        return C0178a.Hx;
    }

    public void lU() {
        this.Hv = false;
        if (this.period <= 0) {
            return;
        }
        Timer timer = this.Hu;
        if (timer != null) {
            timer.cancel();
        }
        am(3);
    }

    public final void fc() {
        if (this.Hv) {
            return;
        }
        this.Hv = true;
        if (this.period <= 0) {
            return;
        }
        this.Hu = new Timer();
        am(1);
        AnonymousClass2 anonymousClass2 = new TimerTask() { // from class: com.kwad.components.core.kwai.a.2
            AnonymousClass2() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public final void run() {
                a.this.am(2);
            }
        };
        try {
            Timer timer = this.Hu;
            long j2 = this.period;
            timer.schedule(anonymousClass2, j2, j2);
        } catch (Throwable unused) {
        }
    }
}
