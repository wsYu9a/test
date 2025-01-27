package com.kwad.components.ad.f.kwai.kwai;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bi;

/* loaded from: classes.dex */
public final class b implements com.kwad.sdk.core.webview.b.a {
    public static int nO = 1;
    public static int nP = 2;
    private com.kwad.sdk.core.webview.b.c nN;
    private int nQ;
    private int nR;
    private InterfaceC0125b nT;
    private c nS = new c(this, (byte) 0);

    @Nullable
    private Runnable nU = null;

    /* renamed from: com.kwad.components.ad.f.kwai.kwai.b$1 */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.this.fc();
        }
    }

    @KsJson
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public int nW;
        public int nX;
    }

    /* renamed from: com.kwad.components.ad.f.kwai.kwai.b$b */
    public interface InterfaceC0125b {
        void G(int i2);
    }

    class c implements Runnable {
        private boolean nY;
        private int nZ;

        private c() {
            this.nY = false;
            this.nZ = -1;
        }

        /* synthetic */ c(b bVar, byte b2) {
            this();
        }

        public final void M(int i2) {
            this.nZ = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.d.b.d("RegisterTimer", "TimerRunnable run timerPaused:  " + this.nY + ", currentTime: " + this.nZ);
            if (this.nY) {
                bi.a(this, null, 1000L);
                return;
            }
            int i2 = this.nZ;
            if (i2 < 0) {
                return;
            }
            b.this.L(i2);
            this.nZ--;
            bi.a(this, null, 1000L);
        }

        public final void y(boolean z) {
            this.nY = z;
        }
    }

    private b(int i2, int i3) {
        this.nQ = i2;
        this.nR = i3;
    }

    public void L(int i2) {
        com.kwad.sdk.core.d.b.d("RegisterTimer", "updateTimer: " + i2 + ", mCallBackFunction: " + this.nN);
        if (i2 >= 0 && this.nN != null) {
            InterfaceC0125b interfaceC0125b = this.nT;
            if (interfaceC0125b != null && i2 == 0) {
                interfaceC0125b.G(this.nQ);
            }
            a aVar = new a();
            aVar.nX = i2;
            aVar.nW = this.nQ;
            com.kwad.sdk.core.webview.b.c cVar = this.nN;
            if (cVar != null) {
                cVar.a(aVar);
            }
        }
    }

    private static int g(AdInfo adInfo) {
        int b2 = com.kwad.components.ad.interstitial.kwai.b.b(adInfo);
        if (b2 <= 0) {
            b2 = 60;
        }
        int i2 = adInfo.adInsertScreenInfo.autoCloseTime;
        return i2 > 0 ? Math.min(b2, i2) : b2;
    }

    @Nullable
    public static b k(AdTemplate adTemplate) {
        AdInfo cb = d.cb(adTemplate);
        if (!(!com.kwad.sdk.core.response.a.a.aU(cb))) {
            return null;
        }
        if (com.kwad.sdk.core.response.a.a.bv(cb)) {
            return new b(nP, g(cb));
        }
        int i2 = cb.adInsertScreenInfo.autoCloseTime;
        if (i2 > 0) {
            return new b(nO, i2);
        }
        return null;
    }

    public final void a(InterfaceC0125b interfaceC0125b) {
        this.nT = interfaceC0125b;
    }

    public final void fc() {
        com.kwad.sdk.core.d.b.d("RegisterTimer", "startTimer: mCallBackFunction: " + this.nN);
        if (this.nN == null) {
            this.nU = new Runnable() { // from class: com.kwad.components.ad.f.kwai.kwai.b.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    b.this.fc();
                }
            };
        } else {
            this.nS.M(this.nR);
            bi.runOnUiThread(this.nS);
        }
    }

    public final void fd() {
        this.nS.y(true);
    }

    public final void fe() {
        this.nS.y(false);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "registerTimerListener";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        this.nN = cVar;
        Runnable runnable = this.nU;
        if (runnable != null) {
            runnable.run();
            this.nU = null;
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.nN = null;
    }
}
