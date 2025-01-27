package com.kwad.components.ad.splashscreen.presenter.playcard;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.presenter.e;
import com.kwad.components.ad.splashscreen.presenter.p;
import com.kwad.components.core.webview.tachikoma.e.f;
import com.kwad.sdk.utils.bt;

/* loaded from: classes2.dex */
public final class b extends e {
    private com.kwad.components.core.n.a.d.b GB;
    private long GC;
    private volatile boolean GD = false;

    /* renamed from: lf */
    private f f11906lf = new f() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.b.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.f
        public final void a(String str, long j10, long j11, long j12) {
            if (TextUtils.isEmpty(str) || !str.equals(com.kwad.sdk.core.response.b.b.dB(b.this.EJ.mAdTemplate))) {
                return;
            }
            com.kwad.components.ad.splashscreen.monitor.b.lm();
            com.kwad.components.ad.splashscreen.monitor.b.a(b.this.EJ.mAdTemplate, b.this.EJ.DU, b.this.EJ.Ed, b.this.EJ.Ef, b.this.EJ.Ee, b.this.EJ.Eg, j10, j11, j12, SystemClock.elapsedRealtime() - b.this.GC);
            b.this.EJ.Eh = j10;
            b.this.EJ.Ei = j11;
            b.this.EJ.Ej = j12;
            bt.c(b.this.GE);
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.b
        public final void s(String str) {
            b.this.EJ.bM = true;
            if ("tk_splash".equals(str)) {
                b.this.mn();
            }
        }
    };
    private final Runnable GE = new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.b.2
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!b.this.GD) {
                b.this.mm();
                return;
            }
            b.this.EJ.bM = true;
            b.this.mn();
            com.kwad.components.ad.splashscreen.monitor.b.lm();
            com.kwad.components.ad.splashscreen.monitor.b.c(b.this.EJ.mAdTemplate, b.this.EJ.DU);
        }
    };
    private com.kwad.components.core.n.a.d.a GF = new com.kwad.components.core.n.a.d.a() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.b.3
        public AnonymousClass3() {
        }

        @Override // com.kwad.components.core.n.a.d.a
        public final void a(int i10, int i11, long j10, long j11) {
            b.this.EJ.Ed = i10;
            b.this.EJ.Ee = i11;
            b.this.EJ.Ef = j10;
            b.this.EJ.Eg = j11;
            com.kwad.components.ad.splashscreen.monitor.b.lm();
            com.kwad.components.ad.splashscreen.monitor.b.e(b.this.EJ.mAdTemplate, SystemClock.elapsedRealtime() - b.this.GC);
            b.this.mm();
        }
    };

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.playcard.b$1 */
    public class AnonymousClass1 extends f {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.f
        public final void a(String str, long j10, long j11, long j12) {
            if (TextUtils.isEmpty(str) || !str.equals(com.kwad.sdk.core.response.b.b.dB(b.this.EJ.mAdTemplate))) {
                return;
            }
            com.kwad.components.ad.splashscreen.monitor.b.lm();
            com.kwad.components.ad.splashscreen.monitor.b.a(b.this.EJ.mAdTemplate, b.this.EJ.DU, b.this.EJ.Ed, b.this.EJ.Ef, b.this.EJ.Ee, b.this.EJ.Eg, j10, j11, j12, SystemClock.elapsedRealtime() - b.this.GC);
            b.this.EJ.Eh = j10;
            b.this.EJ.Ei = j11;
            b.this.EJ.Ej = j12;
            bt.c(b.this.GE);
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.b
        public final void s(String str) {
            b.this.EJ.bM = true;
            if ("tk_splash".equals(str)) {
                b.this.mn();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.playcard.b$2 */
    public class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!b.this.GD) {
                b.this.mm();
                return;
            }
            b.this.EJ.bM = true;
            b.this.mn();
            com.kwad.components.ad.splashscreen.monitor.b.lm();
            com.kwad.components.ad.splashscreen.monitor.b.c(b.this.EJ.mAdTemplate, b.this.EJ.DU);
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.playcard.b$3 */
    public class AnonymousClass3 implements com.kwad.components.core.n.a.d.a {
        public AnonymousClass3() {
        }

        @Override // com.kwad.components.core.n.a.d.a
        public final void a(int i10, int i11, long j10, long j11) {
            b.this.EJ.Ed = i10;
            b.this.EJ.Ee = i11;
            b.this.EJ.Ef = j10;
            b.this.EJ.Eg = j11;
            com.kwad.components.ad.splashscreen.monitor.b.lm();
            com.kwad.components.ad.splashscreen.monitor.b.e(b.this.EJ.mAdTemplate, SystemClock.elapsedRealtime() - b.this.GC);
            b.this.mm();
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.playcard.b$4 */
    public class AnonymousClass4 implements Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.this.a(new d(), true);
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.playcard.b$5 */
    public class AnonymousClass5 implements Runnable {
        public AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.this.a(new p(), true);
        }
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
        if (mo()) {
            bt.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.b.4
                public AnonymousClass4() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    b.this.a(new d(), true);
                }
            });
        }
    }

    public void mn() {
        if (com.kwad.sdk.core.response.b.b.dS(com.kwad.sdk.core.response.b.e.eb(this.EJ.mAdTemplate))) {
            h hVar = this.EJ;
            if (hVar.Ea) {
                return;
            }
            hVar.Ea = true;
            bt.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.b.5
                public AnonymousClass5() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    b.this.a(new p(), true);
                }
            });
        }
    }

    private boolean mo() {
        if (com.kwad.sdk.core.config.d.Du()) {
            return com.kwad.sdk.core.response.b.b.dy(com.kwad.sdk.core.response.b.e.eb(this.EJ.mAdTemplate));
        }
        return false;
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.GC = SystemClock.elapsedRealtime();
        if (mo()) {
            com.kwad.components.ad.splashscreen.monitor.b.lm();
            h hVar = this.EJ;
            com.kwad.components.ad.splashscreen.monitor.b.a(hVar.mAdTemplate, hVar.DU);
            h hVar2 = this.EJ;
            hVar2.Ec = this.GC;
            bt.runOnUiThreadDelay(this.GE, com.kwad.sdk.core.response.b.b.dC(com.kwad.sdk.core.response.b.e.eb(hVar2.mAdTemplate)));
            com.kwad.components.core.webview.tachikoma.d.b.uj().a(this.f11906lf);
        }
        if (com.kwad.sdk.core.config.d.Du()) {
            ml();
        } else {
            mn();
        }
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
        if (mo()) {
            bt.c(this.GE);
            com.kwad.components.core.webview.tachikoma.d.b.uj().b(this.f11906lf);
        }
    }
}
