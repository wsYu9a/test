package com.kwad.components.ad.splashscreen.presenter.playcard;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.presenter.e;
import com.kwad.components.ad.splashscreen.presenter.j;
import com.kwad.components.core.webview.tachikoma.e.f;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;

/* loaded from: classes2.dex */
public final class a extends e {
    private com.kwad.components.core.n.a.d.b GB;
    private long GC;
    private volatile boolean GD = false;

    /* renamed from: lf */
    private f f11905lf = new f() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.a.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.f
        public final void a(String str, long j10, long j11, long j12) {
            if (TextUtils.isEmpty(str) || !str.equals(com.kwad.sdk.core.response.b.b.dB(a.this.EJ.mAdTemplate))) {
                return;
            }
            com.kwad.components.ad.splashscreen.monitor.b.lm();
            com.kwad.components.ad.splashscreen.monitor.b.a(a.this.EJ.mAdTemplate, a.this.EJ.DU, a.this.EJ.Ed, a.this.EJ.Ef, a.this.EJ.Ee, a.this.EJ.Eg, j10, j11, j12, SystemClock.elapsedRealtime() - a.this.GC);
            a.this.EJ.Eh = j10;
            a.this.EJ.Ei = j11;
            a.this.EJ.Ej = j12;
            bt.c(a.this.GE);
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.b
        public final void s(String str) {
            a.this.EJ.bM = true;
            if ("tk_splash".equals(str)) {
                a.this.aP();
            }
        }
    };
    private final Runnable GE = new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.a.2
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!a.this.GD) {
                a.this.mm();
                return;
            }
            a.this.EJ.bM = true;
            a.this.aP();
            com.kwad.components.ad.splashscreen.monitor.b.lm();
            com.kwad.components.ad.splashscreen.monitor.b.c(a.this.EJ.mAdTemplate, a.this.EJ.DU);
        }
    };
    private com.kwad.components.core.n.a.d.a GF = new com.kwad.components.core.n.a.d.a() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.a.3
        public AnonymousClass3() {
        }

        @Override // com.kwad.components.core.n.a.d.a
        public final void a(int i10, int i11, long j10, long j11) {
            a.this.EJ.Ed = i10;
            a.this.EJ.Ee = i11;
            a.this.EJ.Ef = j10;
            a.this.EJ.Eg = j11;
            com.kwad.components.ad.splashscreen.monitor.b.lm();
            com.kwad.components.ad.splashscreen.monitor.b.e(a.this.EJ.mAdTemplate, SystemClock.elapsedRealtime() - a.this.GC);
            a.this.mm();
        }
    };

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.playcard.a$1 */
    public class AnonymousClass1 extends f {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.f
        public final void a(String str, long j10, long j11, long j12) {
            if (TextUtils.isEmpty(str) || !str.equals(com.kwad.sdk.core.response.b.b.dB(a.this.EJ.mAdTemplate))) {
                return;
            }
            com.kwad.components.ad.splashscreen.monitor.b.lm();
            com.kwad.components.ad.splashscreen.monitor.b.a(a.this.EJ.mAdTemplate, a.this.EJ.DU, a.this.EJ.Ed, a.this.EJ.Ef, a.this.EJ.Ee, a.this.EJ.Eg, j10, j11, j12, SystemClock.elapsedRealtime() - a.this.GC);
            a.this.EJ.Eh = j10;
            a.this.EJ.Ei = j11;
            a.this.EJ.Ej = j12;
            bt.c(a.this.GE);
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.b
        public final void s(String str) {
            a.this.EJ.bM = true;
            if ("tk_splash".equals(str)) {
                a.this.aP();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.playcard.a$2 */
    public class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!a.this.GD) {
                a.this.mm();
                return;
            }
            a.this.EJ.bM = true;
            a.this.aP();
            com.kwad.components.ad.splashscreen.monitor.b.lm();
            com.kwad.components.ad.splashscreen.monitor.b.c(a.this.EJ.mAdTemplate, a.this.EJ.DU);
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.playcard.a$3 */
    public class AnonymousClass3 implements com.kwad.components.core.n.a.d.a {
        public AnonymousClass3() {
        }

        @Override // com.kwad.components.core.n.a.d.a
        public final void a(int i10, int i11, long j10, long j11) {
            a.this.EJ.Ed = i10;
            a.this.EJ.Ee = i11;
            a.this.EJ.Ef = j10;
            a.this.EJ.Eg = j11;
            com.kwad.components.ad.splashscreen.monitor.b.lm();
            com.kwad.components.ad.splashscreen.monitor.b.e(a.this.EJ.mAdTemplate, SystemClock.elapsedRealtime() - a.this.GC);
            a.this.mm();
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.playcard.a$4 */
    public class AnonymousClass4 extends bd {
        public AnonymousClass4() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            a.this.a(new com.kwad.components.ad.splashscreen.presenter.a.a(), true);
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.playcard.a$5 */
    public class AnonymousClass5 extends bd {
        public AnonymousClass5() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            a.this.a(new j(), true);
        }
    }

    public void aP() {
        h hVar = this.EJ;
        if (hVar.Eb) {
            return;
        }
        hVar.Eb = true;
        hVar.Ea = true;
        bt.postOnUiThread(new bd() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.a.5
            public AnonymousClass5() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                a.this.a(new j(), true);
            }
        });
    }

    private void ml() {
        com.kwad.components.core.n.a.d.b bVar = (com.kwad.components.core.n.a.d.b) com.kwad.sdk.components.d.f(com.kwad.components.core.n.a.d.b.class);
        this.GB = bVar;
        if (bVar != null) {
            bVar.a(this.GF);
        }
    }

    public void mm() {
        if (this.GD) {
            return;
        }
        this.GD = true;
        bt.postOnUiThread(new bd() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.a.4
            public AnonymousClass4() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                a.this.a(new com.kwad.components.ad.splashscreen.presenter.a.a(), true);
            }
        });
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.GC = SystemClock.elapsedRealtime();
        com.kwad.components.ad.splashscreen.monitor.b.lm();
        h hVar = this.EJ;
        com.kwad.components.ad.splashscreen.monitor.b.a(hVar.mAdTemplate, hVar.DU);
        h hVar2 = this.EJ;
        hVar2.Ec = this.GC;
        bt.runOnUiThreadDelay(this.GE, com.kwad.sdk.core.response.b.b.dn(hVar2.mAdTemplate));
        com.kwad.components.core.webview.tachikoma.d.b.uj().a(this.f11905lf);
        ml();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.n.a.d.b bVar = this.GB;
        if (bVar != null) {
            bVar.b(this.GF);
        }
        bt.c(this.GE);
        com.kwad.components.core.webview.tachikoma.d.b.uj().b(this.f11905lf);
    }
}
