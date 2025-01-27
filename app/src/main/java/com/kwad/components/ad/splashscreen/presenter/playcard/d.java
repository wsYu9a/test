package com.kwad.components.ad.splashscreen.presenter.playcard;

import android.os.SystemClock;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.components.ad.splashscreen.f;
import com.kwad.components.ad.splashscreen.g;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.m;
import com.kwad.sdk.R;
import com.kwad.sdk.components.s;
import com.kwad.sdk.core.response.b.e;

/* loaded from: classes2.dex */
public final class d extends com.kwad.components.ad.splashscreen.presenter.a.c implements g, com.kwad.sdk.core.h.c {
    private m GV;
    f Gr = new f() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.d.2
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.splashscreen.f
        public final void kO() {
            d.this.cS.setVisibility(8);
            if (d.this.cU != null) {
                d.this.cU.tw();
                d.this.cU.tx();
            }
        }
    };
    private FrameLayout cS;
    private ay cU;

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.playcard.d$1 */
    public class AnonymousClass1 implements com.kwad.sdk.core.webview.d.a.a {

        /* renamed from: com.kwad.components.ad.splashscreen.presenter.playcard.d$1$1 */
        public class RunnableC04121 implements Runnable {
            public RunnableC04121() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                d.this.EJ.W();
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            if (aVar != null) {
                d.this.EJ.mRootContainer.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.d.1.1
                    public RunnableC04121() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        d.this.EJ.W();
                    }
                });
            }
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.playcard.d$2 */
    public class AnonymousClass2 implements f {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.splashscreen.f
        public final void kO() {
            d.this.cS.setVisibility(8);
            if (d.this.cU != null) {
                d.this.cU.tw();
                d.this.cU.tx();
            }
        }
    }

    @NonNull
    private m mt() {
        m mVar = new m();
        this.GV = mVar;
        return mVar;
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void X(int i10) {
        m mVar = this.GV;
        if (mVar != null) {
            mVar.aU(i10);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        com.kwad.components.ad.splashscreen.monitor.b.lm();
        h hVar = this.EJ;
        com.kwad.components.ad.splashscreen.monitor.b.b(hVar.mAdTemplate, hVar.DU);
        this.EJ.DV.a(this);
        this.EJ.a(this);
        this.EJ.a(this.Gr);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void ay() {
        if (this.EJ.bM) {
            return;
        }
        ay ayVar = this.cU;
        if (ayVar != null) {
            ayVar.tu();
            this.cU.tv();
        }
        this.cS.setVisibility(0);
    }

    @Override // com.kwad.sdk.core.h.c
    public final void bl() {
        ay ayVar;
        if (this.EJ.bM || (ayVar = this.cU) == null) {
            return;
        }
        ayVar.ty();
    }

    @Override // com.kwad.sdk.core.h.c
    public final void bm() {
        ay ayVar;
        if (this.EJ.bM || (ayVar = this.cU) == null) {
            return;
        }
        ayVar.tz();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.cS;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_splash";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.dB(this.EJ.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void kS() {
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c
    public final int ms() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        h hVar = this.EJ;
        return (int) (com.kwad.sdk.core.response.b.b.dC(e.eb(hVar.mAdTemplate)) - (elapsedRealtime - hVar.Ec));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.cS = (FrameLayout) findViewById(R.id.splash_tk_play_card_view);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        ay ayVar = this.cU;
        if (ayVar != null) {
            ayVar.tw();
            this.cU.tx();
        }
        super.onUnbind();
        this.EJ.DV.b(this);
        this.EJ.b(this.Gr);
        this.EJ.b(this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        ay ayVar = this.cU;
        if (ayVar != null) {
            ayVar.tw();
            this.cU.tx();
        }
        this.cS.setVisibility(8);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ad.a aVar) {
        aVar.width = com.kwad.sdk.c.a.a.px2dip(getContext(), this.EJ.mRootContainer.getWidth());
        aVar.height = com.kwad.sdk.c.a.a.px2dip(getContext(), this.EJ.mRootContainer.getHeight());
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(ay ayVar) {
        super.a(ayVar);
        this.cU = ayVar;
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(s sVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(sVar, bVar);
        sVar.c(a(bVar));
        sVar.c(mt());
    }

    @NonNull
    private y a(com.kwad.sdk.core.webview.b bVar) {
        return new y(bVar, this.EJ.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.d.1

            /* renamed from: com.kwad.components.ad.splashscreen.presenter.playcard.d$1$1 */
            public class RunnableC04121 implements Runnable {
                public RunnableC04121() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    d.this.EJ.W();
                }
            }

            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (aVar != null) {
                    d.this.EJ.mRootContainer.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.d.1.1
                        public RunnableC04121() {
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            d.this.EJ.W();
                        }
                    });
                }
            }
        });
    }
}
