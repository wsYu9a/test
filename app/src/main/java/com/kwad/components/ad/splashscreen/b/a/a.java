package com.kwad.components.ad.splashscreen.b.a;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.components.ad.splashscreen.f;
import com.kwad.components.ad.splashscreen.g;
import com.kwad.components.core.webview.a.j;
import com.kwad.components.core.webview.a.kwai.m;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.sdk.R;
import com.kwad.sdk.components.l;
import com.kwad.sdk.core.g.c;
import com.kwad.sdk.core.webview.b;

/* loaded from: classes2.dex */
public final class a extends com.kwad.components.ad.splashscreen.b.b.a implements g, c {
    f DV = new f() { // from class: com.kwad.components.ad.splashscreen.b.a.a.2
        AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.splashscreen.f
        public final void ks() {
            a.this.lE.setVisibility(8);
        }
    };
    private m DZ;
    private FrameLayout lE;
    private an wi;

    /* renamed from: com.kwad.components.ad.splashscreen.b.a.a$1 */
    final class AnonymousClass1 implements com.kwad.sdk.core.webview.c.kwai.a {

        /* renamed from: com.kwad.components.ad.splashscreen.b.a.a$1$1 */
        final class RunnableC01541 implements Runnable {
            RunnableC01541() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                a.this.Cg.ku();
            }
        }

        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.webview.c.kwai.a
        public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
            if (aVar != null) {
                a.this.Cg.mRootContainer.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.a.a.1.1
                    RunnableC01541() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.Cg.ku();
                    }
                });
            }
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b.a.a$2 */
    final class AnonymousClass2 implements f {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.splashscreen.f
        public final void ks() {
            a.this.lE.setVisibility(8);
        }
    }

    @NonNull
    private p a(b bVar) {
        return new p(bVar, this.Cg.mApkDownloadHelper, new com.kwad.sdk.core.webview.c.kwai.a() { // from class: com.kwad.components.ad.splashscreen.b.a.a.1

            /* renamed from: com.kwad.components.ad.splashscreen.b.a.a$1$1 */
            final class RunnableC01541 implements Runnable {
                RunnableC01541() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    a.this.Cg.ku();
                }
            }

            AnonymousClass1() {
            }

            @Override // com.kwad.sdk.core.webview.c.kwai.a
            public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
                if (aVar != null) {
                    a.this.Cg.mRootContainer.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.a.a.1.1
                        RunnableC01541() {
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.Cg.ku();
                        }
                    });
                }
            }
        });
    }

    @NonNull
    private m lp() {
        m mVar = new m();
        this.DZ = mVar;
        return mVar;
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void aa(int i2) {
        m mVar = this.DZ;
        if (mVar != null) {
            mVar.aR(i2);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.b.a, com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.Cg.BH.a(this);
        this.Cg.a(this);
        this.Cg.a(this.DV);
    }

    @Override // com.kwad.components.core.webview.a.i
    public final FrameLayout getTKContainer() {
        return this.lE;
    }

    @Override // com.kwad.components.core.webview.a.i
    public final String getTkTemplateId() {
        return j.b("ksad-splash-play-card", this.Cg.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void kt() {
    }

    @Override // com.kwad.components.ad.splashscreen.b.b.a, com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.lE = (FrameLayout) findViewById(R.id.splash_tk_play_card_view);
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onGetContainerLimited(u.a aVar) {
        aVar.width = com.kwad.sdk.c.kwai.a.b(getContext(), this.Cg.mRootContainer.getWidth());
        aVar.height = com.kwad.sdk.c.kwai.a.b(getContext(), this.Cg.mRootContainer.getHeight());
    }

    @Override // com.kwad.sdk.core.g.c
    public final void onPageInvisible() {
        an anVar;
        if (this.Cg.BM || (anVar = this.wi) == null) {
            return;
        }
        anVar.re();
    }

    @Override // com.kwad.sdk.core.g.c
    public final void onPageVisible() {
        an anVar;
        if (this.Cg.BM || (anVar = this.wi) == null) {
            return;
        }
        anVar.rd();
    }

    @Override // com.kwad.components.ad.splashscreen.b.b.a, com.kwad.components.core.webview.a.i
    public final void onRegisterLifecycleLisener(an anVar) {
        super.onRegisterLifecycleLisener(anVar);
        this.wi = anVar;
    }

    @Override // com.kwad.components.ad.splashscreen.b.b.a, com.kwad.components.core.webview.a.i
    public final void onRegisterWebCardHandler(l lVar, b bVar) {
        super.onRegisterWebCardHandler(lVar, bVar);
        lVar.c(a(bVar));
        lVar.c(lp());
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onTkLoadFailed() {
        an anVar = this.wi;
        if (anVar != null) {
            anVar.rb();
            this.wi.rc();
        }
        this.lE.setVisibility(8);
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onTkLoadSuccess() {
        if (this.Cg.BM) {
            return;
        }
        an anVar = this.wi;
        if (anVar != null) {
            anVar.qZ();
            this.wi.ra();
        }
        this.lE.setVisibility(0);
    }

    @Override // com.kwad.components.ad.splashscreen.b.b.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        an anVar = this.wi;
        if (anVar != null) {
            anVar.rb();
            this.wi.rc();
        }
        super.onUnbind();
        this.Cg.BH.b(this);
        this.Cg.b(this.DV);
        this.Cg.b(this);
    }
}
