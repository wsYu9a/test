package com.kwad.components.ad.i.a.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bt;

/* loaded from: classes2.dex */
public final class b implements com.kwad.sdk.core.webview.c.a {
    public static int oO = 1;
    public static int oP = 2;
    private com.kwad.sdk.core.webview.c.c oN;
    private int oQ;
    private int oR;
    private InterfaceC0376b oT;
    private c oS = new c(this, (byte) 0);

    @Nullable
    private Runnable oU = null;

    /* renamed from: com.kwad.components.ad.i.a.a.b$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.this.at();
        }
    }

    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public int oW;
        public int oX;
    }

    /* renamed from: com.kwad.components.ad.i.a.a.b$b */
    public interface InterfaceC0376b {
        void E(int i10);
    }

    private b(int i10, int i11) {
        this.oQ = i10;
        this.oR = i11;
    }

    @Nullable
    public static b D(AdTemplate adTemplate) {
        AdInfo eb2 = e.eb(adTemplate);
        if (!(!com.kwad.sdk.core.response.b.a.bc(eb2))) {
            return null;
        }
        if (com.kwad.sdk.core.response.b.a.bJ(eb2)) {
            return new b(oP, f(eb2));
        }
        int i10 = eb2.adInsertScreenInfo.autoCloseTime;
        if (i10 > 0) {
            return new b(oO, i10);
        }
        return null;
    }

    public void J(int i10) {
        com.kwad.sdk.core.d.c.d("RegisterTimer", "updateTimer: " + i10 + ", mCallBackFunction: " + this.oN);
        if (i10 >= 0 && this.oN != null) {
            InterfaceC0376b interfaceC0376b = this.oT;
            if (interfaceC0376b != null && i10 == 0) {
                interfaceC0376b.E(this.oQ);
            }
            a aVar = new a();
            aVar.oX = i10;
            aVar.oW = this.oQ;
            com.kwad.sdk.core.webview.c.c cVar = this.oN;
            if (cVar != null) {
                cVar.a(aVar);
            }
        }
    }

    private static int f(AdInfo adInfo) {
        int b10 = com.kwad.components.ad.interstitial.b.b.b(adInfo);
        if (b10 <= 0) {
            b10 = 60;
        }
        int i10 = adInfo.adInsertScreenInfo.autoCloseTime;
        return i10 > 0 ? Math.min(b10, i10) : b10;
    }

    public final void at() {
        com.kwad.sdk.core.d.c.d("RegisterTimer", "startTimer: mCallBackFunction: " + this.oN);
        if (this.oN == null) {
            this.oU = new Runnable() { // from class: com.kwad.components.ad.i.a.a.b.1
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    b.this.at();
                }
            };
        } else {
            this.oS.K(this.oR);
            bt.runOnUiThread(this.oS);
        }
    }

    public final void fa() {
        this.oS.z(true);
    }

    public final void fb() {
        this.oS.z(false);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerTimerListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.oN = null;
    }

    public final void a(InterfaceC0376b interfaceC0376b) {
        this.oT = interfaceC0376b;
    }

    public class c implements Runnable {
        private boolean oY;
        private int oZ;

        private c() {
            this.oY = false;
            this.oZ = -1;
        }

        public final void K(int i10) {
            this.oZ = i10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.d.c.d("RegisterTimer", "TimerRunnable run timerPaused:  " + this.oY + ", currentTime: " + this.oZ);
            if (this.oY) {
                bt.a(this, null, 1000L);
                return;
            }
            int i10 = this.oZ;
            if (i10 < 0) {
                return;
            }
            b.this.J(i10);
            this.oZ--;
            bt.a(this, null, 1000L);
        }

        public final void z(boolean z10) {
            this.oY = z10;
        }

        public /* synthetic */ c(b bVar, byte b10) {
            this();
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.oN = cVar;
        Runnable runnable = this.oU;
        if (runnable != null) {
            runnable.run();
            this.oU = null;
        }
    }
}
