package com.kwad.components.ad.splashscreen.presenter.endcard;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.s;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bs;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class h extends com.kwad.components.ad.splashscreen.presenter.a.c implements com.kwad.sdk.core.h.c {
    private FrameLayout cS;
    private ay cU;

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.endcard.h$1 */
    public class AnonymousClass1 implements com.kwad.sdk.core.webview.d.a.a {

        /* renamed from: com.kwad.components.ad.splashscreen.presenter.endcard.h$1$1 */
        public class C04081 extends bd {
            public C04081() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                h.this.EJ.W();
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            if (aVar != null) {
                h.this.EJ.mRootContainer.post(new bd() { // from class: com.kwad.components.ad.splashscreen.presenter.endcard.h.1.1
                    public C04081() {
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        h.this.EJ.W();
                    }
                });
            }
        }
    }

    private void aa(int i10) {
        a.C0484a c0484a = new a.C0484a();
        bs bsVar = this.EJ.mTimerHelper;
        if (bsVar != null) {
            c0484a.duration = bsVar.getTime();
        }
        com.kwad.sdk.core.adlog.c.b b10 = new com.kwad.sdk.core.adlog.c.b().cU(6).b(c0484a);
        if (i10 == 2) {
            b10.cM(14);
        } else {
            b10.cM(1);
        }
        com.kwad.sdk.core.adlog.c.b(this.EJ.mAdTemplate, b10, (JSONObject) null);
    }

    private void mk() {
        try {
            this.EJ.mRootContainer.findViewById(R.id.splash_play_card_view).setVisibility(8);
        } catch (NullPointerException e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.EJ.DV.a(this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void ay() {
        ay ayVar = this.cU;
        if (ayVar != null) {
            ayVar.tu();
            this.cU.tv();
        }
        mk();
        this.cS.setVisibility(0);
    }

    @Override // com.kwad.sdk.core.h.c
    public final void bl() {
        ay ayVar = this.cU;
        if (ayVar != null) {
            ayVar.ty();
        }
    }

    @Override // com.kwad.sdk.core.h.c
    public final void bm() {
        ay ayVar = this.cU;
        if (ayVar != null) {
            ayVar.tz();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.cS;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_splash_end_card";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.dC(this.EJ.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.cS = (FrameLayout) findViewById(R.id.splash_end_card_view);
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
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        ay ayVar = this.cU;
        if (ayVar != null) {
            ayVar.tw();
            this.cU.tx();
        }
        mk();
        this.cS.setVisibility(8);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        super.a(webCloseStatus);
        aa(webCloseStatus.closeType);
        if (webCloseStatus.closeType == 2) {
            this.EJ.lj();
        } else {
            com.kwad.components.ad.splashscreen.monitor.a.lk().ac(this.EJ.mAdTemplate);
            this.EJ.lf();
        }
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
    }

    @NonNull
    private y a(com.kwad.sdk.core.webview.b bVar) {
        return new y(bVar, this.EJ.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.splashscreen.presenter.endcard.h.1

            /* renamed from: com.kwad.components.ad.splashscreen.presenter.endcard.h$1$1 */
            public class C04081 extends bd {
                public C04081() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    h.this.EJ.W();
                }
            }

            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (aVar != null) {
                    h.this.EJ.mRootContainer.post(new bd() { // from class: com.kwad.components.ad.splashscreen.presenter.endcard.h.1.1
                        public C04081() {
                        }

                        @Override // com.kwad.sdk.utils.bd
                        public final void doTask() {
                            h.this.EJ.W();
                        }
                    });
                }
            }
        });
    }
}
