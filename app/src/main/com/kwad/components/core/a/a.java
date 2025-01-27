package com.kwad.components.core.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.sdk.core.c.b;
import com.kwad.sdk.core.c.d;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.report.g;
import com.kwad.sdk.core.report.n;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class a {
    private String KB;
    private String KC;
    private long KD;
    private long KE;
    private Timer KF;
    private boolean KG = false;
    private final long period;

    /* renamed from: com.kwad.components.core.a.a$1 */
    public class AnonymousClass1 extends d {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToBackground() {
            super.onBackToBackground();
            a.this.au();
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToForeground() {
            super.onBackToForeground();
            a.this.at();
        }
    }

    /* renamed from: com.kwad.components.core.a.a$2 */
    public class AnonymousClass2 extends TimerTask {
        public AnonymousClass2() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            a.this.ai(2);
        }
    }

    /* renamed from: com.kwad.components.core.a.a$a */
    public static final class C0415a {
        private static final a KI = new a();
    }

    public a() {
        this.KD = -1L;
        try {
            this.KD = SystemClock.elapsedRealtime();
        } catch (Throwable th2) {
            this.KD = System.currentTimeMillis();
            c.printStackTraceOnly(th2);
        }
        this.period = TimeUnit.MINUTES.toMillis(com.kwad.sdk.core.config.d.De());
        AnonymousClass1 anonymousClass1 = new d() { // from class: com.kwad.components.core.a.a.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToBackground() {
                super.onBackToBackground();
                a.this.au();
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                super.onBackToForeground();
                a.this.at();
            }
        };
        b.Fi();
        b.a(anonymousClass1);
    }

    public void ai(int i10) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j10 = elapsedRealtime - this.KD;
        this.KD = elapsedRealtime;
        if (i10 == 1) {
            this.KE = 0L;
            this.KC = UUID.randomUUID().toString();
            if (TextUtils.isEmpty(this.KB)) {
                this.KB = this.KC;
            }
        }
        this.KE++;
        n nVar = new n(10220L);
        nVar.axZ = this.KE;
        if (j10 > 0) {
            nVar.aCZ = j10;
        }
        nVar.aDa = i10;
        nVar.KB = this.KB;
        nVar.KC = this.KC;
        g.a2(nVar);
    }

    public void au() {
        this.KG = false;
        if (this.period <= 0) {
            return;
        }
        Timer timer = this.KF;
        if (timer != null) {
            timer.cancel();
        }
        ai(3);
    }

    public static a nh() {
        return C0415a.KI;
    }

    public final void at() {
        if (this.KG) {
            return;
        }
        this.KG = true;
        if (this.period <= 0) {
            return;
        }
        this.KF = new Timer();
        ai(1);
        AnonymousClass2 anonymousClass2 = new TimerTask() { // from class: com.kwad.components.core.a.a.2
            public AnonymousClass2() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public final void run() {
                a.this.ai(2);
            }
        };
        try {
            Timer timer = this.KF;
            long j10 = this.period;
            timer.schedule(anonymousClass2, j10, j10);
        } catch (Throwable unused) {
        }
    }
}
