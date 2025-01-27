package com.kwad.components.ad.splashscreen.presenter.a;

import android.os.SystemClock;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.components.ad.splashscreen.f;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.m;
import com.kwad.components.core.webview.tachikoma.a.u;
import com.kwad.sdk.R;
import com.kwad.sdk.components.s;
import com.kwad.sdk.utils.bd;

/* loaded from: classes2.dex */
public final class a extends c implements com.kwad.sdk.core.h.c {
    private m GV;
    private boolean GY = false;
    f Gr = new f() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.3

        /* renamed from: com.kwad.components.ad.splashscreen.presenter.a.a$3$1 */
        public class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                a.this.cS.setVisibility(8);
            }
        }

        public AnonymousClass3() {
        }

        @Override // com.kwad.components.ad.splashscreen.f
        public final void kO() {
            a.this.cS.postDelayed(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.3.1
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    a.this.cS.setVisibility(8);
                }
            }, 500L);
            if (a.this.cU != null) {
                a.this.cU.tw();
                a.this.cU.tx();
            }
        }
    };
    private FrameLayout cS;
    private ay cU;

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.a.a$1 */
    public class AnonymousClass1 implements com.kwad.sdk.core.webview.d.a.a {

        /* renamed from: com.kwad.components.ad.splashscreen.presenter.a.a$1$1 */
        public class C04061 extends bd {
            public C04061() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                a.this.EJ.W();
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            if (aVar != null) {
                a.this.EJ.mRootContainer.post(new bd() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.1.1
                    public C04061() {
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        a.this.EJ.W();
                    }
                });
            }
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.a.a$2 */
    public class AnonymousClass2 implements u.a {

        /* renamed from: com.kwad.components.ad.splashscreen.presenter.a.a$2$1 */
        public class AnonymousClass1 extends bd {
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                if (com.kwad.components.core.e.c.b.of()) {
                    a.this.EJ.mRootContainer.postDelayed(this, 1000L);
                } else {
                    a.this.EJ.ld();
                }
            }
        }

        /* renamed from: com.kwad.components.ad.splashscreen.presenter.a.a$2$2 */
        public class C04072 extends bd {
            public C04072() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                com.kwad.components.ad.splashscreen.monitor.a.lk().ac(a.this.EJ.mAdTemplate);
                a.this.EJ.lf();
            }
        }

        /* renamed from: com.kwad.components.ad.splashscreen.presenter.a.a$2$3 */
        public class AnonymousClass3 extends bd {
            public AnonymousClass3() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                a.this.EJ.kU();
            }
        }

        /* renamed from: com.kwad.components.ad.splashscreen.presenter.a.a$2$4 */
        public class AnonymousClass4 extends bd {
            final /* synthetic */ u.b Hc;

            public AnonymousClass4(u.b bVar) {
                bVar = bVar;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                h hVar = a.this.EJ;
                u.b bVar = bVar;
                hVar.c(bVar.errorCode, bVar.errorMsg);
            }
        }

        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.a.u.a
        public final void a(u.b bVar) {
            int i10 = bVar.status;
            if (i10 == 1) {
                a.this.EJ.mRootContainer.post(new bd() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.2.1
                    public AnonymousClass1() {
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        if (com.kwad.components.core.e.c.b.of()) {
                            a.this.EJ.mRootContainer.postDelayed(this, 1000L);
                        } else {
                            a.this.EJ.ld();
                        }
                    }
                });
                return;
            }
            if (i10 == 2) {
                a.this.EJ.mRootContainer.post(new bd() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.2.2
                    public C04072() {
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        com.kwad.components.ad.splashscreen.monitor.a.lk().ac(a.this.EJ.mAdTemplate);
                        a.this.EJ.lf();
                    }
                });
            } else if (i10 == 3) {
                a.this.EJ.mRootContainer.post(new bd() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.2.3
                    public AnonymousClass3() {
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        a.this.EJ.kU();
                    }
                });
            } else if (i10 == 4) {
                a.this.EJ.mRootContainer.post(new bd() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.2.4
                    final /* synthetic */ u.b Hc;

                    public AnonymousClass4(u.b bVar2) {
                        bVar = bVar2;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        h hVar = a.this.EJ;
                        u.b bVar2 = bVar;
                        hVar.c(bVar2.errorCode, bVar2.errorMsg);
                    }
                });
            }
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.a.a$3 */
    public class AnonymousClass3 implements f {

        /* renamed from: com.kwad.components.ad.splashscreen.presenter.a.a$3$1 */
        public class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                a.this.cS.setVisibility(8);
            }
        }

        public AnonymousClass3() {
        }

        @Override // com.kwad.components.ad.splashscreen.f
        public final void kO() {
            a.this.cS.postDelayed(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.3.1
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    a.this.cS.setVisibility(8);
                }
            }, 500L);
            if (a.this.cU != null) {
                a.this.cU.tw();
                a.this.cU.tx();
            }
        }
    }

    @NonNull
    private m mt() {
        m mVar = new m();
        this.GV = mVar;
        return mVar;
    }

    private void mu() {
        com.kwad.components.ad.splashscreen.d.a aVar = this.EJ.DT;
        if (aVar != null) {
            aVar.mx();
        }
    }

    @NonNull
    private u mv() {
        u uVar = new u();
        uVar.a(new u.a() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.2

            /* renamed from: com.kwad.components.ad.splashscreen.presenter.a.a$2$1 */
            public class AnonymousClass1 extends bd {
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    if (com.kwad.components.core.e.c.b.of()) {
                        a.this.EJ.mRootContainer.postDelayed(this, 1000L);
                    } else {
                        a.this.EJ.ld();
                    }
                }
            }

            /* renamed from: com.kwad.components.ad.splashscreen.presenter.a.a$2$2 */
            public class C04072 extends bd {
                public C04072() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    com.kwad.components.ad.splashscreen.monitor.a.lk().ac(a.this.EJ.mAdTemplate);
                    a.this.EJ.lf();
                }
            }

            /* renamed from: com.kwad.components.ad.splashscreen.presenter.a.a$2$3 */
            public class AnonymousClass3 extends bd {
                public AnonymousClass3() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    a.this.EJ.kU();
                }
            }

            /* renamed from: com.kwad.components.ad.splashscreen.presenter.a.a$2$4 */
            public class AnonymousClass4 extends bd {
                final /* synthetic */ u.b Hc;

                public AnonymousClass4(u.b bVar2) {
                    bVar = bVar2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    h hVar = a.this.EJ;
                    u.b bVar2 = bVar;
                    hVar.c(bVar2.errorCode, bVar2.errorMsg);
                }
            }

            public AnonymousClass2() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.a.u.a
            public final void a(u.b bVar2) {
                int i10 = bVar2.status;
                if (i10 == 1) {
                    a.this.EJ.mRootContainer.post(new bd() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.2.1
                        public AnonymousClass1() {
                        }

                        @Override // com.kwad.sdk.utils.bd
                        public final void doTask() {
                            if (com.kwad.components.core.e.c.b.of()) {
                                a.this.EJ.mRootContainer.postDelayed(this, 1000L);
                            } else {
                                a.this.EJ.ld();
                            }
                        }
                    });
                    return;
                }
                if (i10 == 2) {
                    a.this.EJ.mRootContainer.post(new bd() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.2.2
                        public C04072() {
                        }

                        @Override // com.kwad.sdk.utils.bd
                        public final void doTask() {
                            com.kwad.components.ad.splashscreen.monitor.a.lk().ac(a.this.EJ.mAdTemplate);
                            a.this.EJ.lf();
                        }
                    });
                } else if (i10 == 3) {
                    a.this.EJ.mRootContainer.post(new bd() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.2.3
                        public AnonymousClass3() {
                        }

                        @Override // com.kwad.sdk.utils.bd
                        public final void doTask() {
                            a.this.EJ.kU();
                        }
                    });
                } else if (i10 == 4) {
                    a.this.EJ.mRootContainer.post(new bd() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.2.4
                        final /* synthetic */ u.b Hc;

                        public AnonymousClass4(u.b bVar22) {
                            bVar = bVar22;
                        }

                        @Override // com.kwad.sdk.utils.bd
                        public final void doTask() {
                            h hVar = a.this.EJ;
                            u.b bVar22 = bVar;
                            hVar.c(bVar22.errorCode, bVar22.errorMsg);
                        }
                    });
                }
            }
        });
        return uVar;
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        com.kwad.components.ad.splashscreen.monitor.b.lm();
        h hVar = this.EJ;
        com.kwad.components.ad.splashscreen.monitor.b.b(hVar.mAdTemplate, hVar.DU);
        this.EJ.DV.a(this);
        this.EJ.a(this.Gr);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void ay() {
        ay ayVar;
        if (this.EJ.bM) {
            return;
        }
        ay ayVar2 = this.cU;
        if (ayVar2 != null) {
            ayVar2.tu();
            this.cU.tv();
        }
        if (this.GY && (ayVar = this.cU) != null) {
            ayVar.ty();
        }
        this.cS.setVisibility(0);
    }

    @Override // com.kwad.sdk.core.h.c
    public final void bl() {
        if (this.EJ.bM) {
            return;
        }
        ay ayVar = this.cU;
        if (ayVar != null) {
            ayVar.ty();
        } else {
            this.GY = true;
        }
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
        return com.kwad.sdk.core.response.b.b.cm(this.EJ.mAdTemplate).splashPlayCardTKInfo.templateId;
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c
    public final int ms() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        h hVar = this.EJ;
        return (int) (com.kwad.sdk.core.response.b.b.dn(hVar.mAdTemplate) - (elapsedRealtime - hVar.Ec));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.cS = (FrameLayout) findViewById(R.id.splash_full_tk_play_card_view);
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
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        ay ayVar = this.cU;
        if (ayVar != null) {
            ayVar.tw();
            this.cU.tx();
        }
        this.cS.setVisibility(8);
        mu();
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
        sVar.c(mv());
    }

    @NonNull
    private y a(com.kwad.sdk.core.webview.b bVar) {
        return new y(bVar, this.EJ.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.1

            /* renamed from: com.kwad.components.ad.splashscreen.presenter.a.a$1$1 */
            public class C04061 extends bd {
                public C04061() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    a.this.EJ.W();
                }
            }

            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (aVar != null) {
                    a.this.EJ.mRootContainer.post(new bd() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.1.1
                        public C04061() {
                        }

                        @Override // com.kwad.sdk.utils.bd
                        public final void doTask() {
                            a.this.EJ.W();
                        }
                    });
                }
            }
        });
    }
}
