package com.kwad.components.ad.reward.presenter.f;

import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.w;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.b.x;
import com.kwad.sdk.components.s;

/* loaded from: classes2.dex */
public abstract class a extends d {
    private o xG;

    /* renamed from: com.kwad.components.ad.reward.presenter.f.a$1 */
    public class AnonymousClass1 implements o.a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.a.o.a
        public final boolean isMuted() {
            return !a.this.rO.mVideoPlayConfig.isVideoSoundEnable() || (!com.kwad.sdk.core.config.d.gN() && com.kwad.components.core.s.a.av(a.this.getContext()).sa());
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.a$2 */
    public class AnonymousClass2 extends w {

        /* renamed from: com.kwad.components.ad.reward.presenter.f.a$2$1 */
        public class AnonymousClass1 implements com.kwad.sdk.f.a<com.kwad.components.ad.reward.k.a> {
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.f.a
            /* renamed from: c */
            public void accept(com.kwad.components.ad.reward.k.a aVar) {
                com.kwad.components.ad.reward.g unused = a.this.rO;
                aVar.jf();
            }
        }

        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.webview.jshandler.w
        public final void a(x xVar) {
            super.a(xVar);
            a.this.rO.f11688qe.onVideoPlayStart();
            com.kwad.components.ad.reward.monitor.c.b(a.this.rO.qu, a.this.rO.mAdTemplate, a.this.rO.mPageEnterTime);
        }

        @Override // com.kwad.components.core.webview.jshandler.w
        public final void b(x xVar) {
            super.b(xVar);
            long ub2 = xVar.ub();
            a.this.rO.f11688qe.onVideoPlayError(xVar.errorCode, (int) ub2);
            com.kwad.components.ad.reward.monitor.c.a(a.this.rO.qu, a.this.rO.mAdTemplate, a.this.rO.qT, xVar.errorCode, ub2);
            com.kwad.components.ad.reward.monitor.b.c(a.this.rO.qu, a.this.mAdTemplate);
        }

        @Override // com.kwad.components.core.webview.jshandler.w
        public final void c(x xVar) {
            super.c(xVar);
            a.this.rO.f11688qe.onVideoPlayEnd();
            a.this.rO.mAdTemplate.setmCurPlayTime(-1L);
            com.kwad.components.ad.reward.presenter.f.u(a.this.rO);
            if (xVar.tZ()) {
                com.kwad.components.ad.reward.g unused = a.this.rO;
                com.kwad.components.ad.reward.g.a(a.this.rO.qn, new com.kwad.sdk.f.a<com.kwad.components.ad.reward.k.a>() { // from class: com.kwad.components.ad.reward.presenter.f.a.2.1
                    public AnonymousClass1() {
                    }

                    @Override // com.kwad.sdk.f.a
                    /* renamed from: c */
                    public void accept(com.kwad.components.ad.reward.k.a aVar) {
                        com.kwad.components.ad.reward.g unused2 = a.this.rO;
                        aVar.jf();
                    }
                });
            }
        }

        @Override // com.kwad.components.core.webview.jshandler.w
        public final void d(x xVar) {
            super.d(xVar);
            a.this.rO.mAdTemplate.setmCurPlayTime(xVar.oZ);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d
    public final boolean jh() {
        return true;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
        this.xG = oVar;
        oVar.a(new o.a() { // from class: com.kwad.components.ad.reward.presenter.f.a.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.a.o.a
            public final boolean isMuted() {
                return !a.this.rO.mVideoPlayConfig.isVideoSoundEnable() || (!com.kwad.sdk.core.config.d.gN() && com.kwad.components.core.s.a.av(a.this.getContext()).sa());
            }
        });
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public void a(s sVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(sVar, bVar);
        sVar.c(new w() { // from class: com.kwad.components.ad.reward.presenter.f.a.2

            /* renamed from: com.kwad.components.ad.reward.presenter.f.a$2$1 */
            public class AnonymousClass1 implements com.kwad.sdk.f.a<com.kwad.components.ad.reward.k.a> {
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.f.a
                /* renamed from: c */
                public void accept(com.kwad.components.ad.reward.k.a aVar) {
                    com.kwad.components.ad.reward.g unused2 = a.this.rO;
                    aVar.jf();
                }
            }

            public AnonymousClass2() {
            }

            @Override // com.kwad.components.core.webview.jshandler.w
            public final void a(x xVar) {
                super.a(xVar);
                a.this.rO.f11688qe.onVideoPlayStart();
                com.kwad.components.ad.reward.monitor.c.b(a.this.rO.qu, a.this.rO.mAdTemplate, a.this.rO.mPageEnterTime);
            }

            @Override // com.kwad.components.core.webview.jshandler.w
            public final void b(x xVar) {
                super.b(xVar);
                long ub2 = xVar.ub();
                a.this.rO.f11688qe.onVideoPlayError(xVar.errorCode, (int) ub2);
                com.kwad.components.ad.reward.monitor.c.a(a.this.rO.qu, a.this.rO.mAdTemplate, a.this.rO.qT, xVar.errorCode, ub2);
                com.kwad.components.ad.reward.monitor.b.c(a.this.rO.qu, a.this.mAdTemplate);
            }

            @Override // com.kwad.components.core.webview.jshandler.w
            public final void c(x xVar) {
                super.c(xVar);
                a.this.rO.f11688qe.onVideoPlayEnd();
                a.this.rO.mAdTemplate.setmCurPlayTime(-1L);
                com.kwad.components.ad.reward.presenter.f.u(a.this.rO);
                if (xVar.tZ()) {
                    com.kwad.components.ad.reward.g unused = a.this.rO;
                    com.kwad.components.ad.reward.g.a(a.this.rO.qn, new com.kwad.sdk.f.a<com.kwad.components.ad.reward.k.a>() { // from class: com.kwad.components.ad.reward.presenter.f.a.2.1
                        public AnonymousClass1() {
                        }

                        @Override // com.kwad.sdk.f.a
                        /* renamed from: c */
                        public void accept(com.kwad.components.ad.reward.k.a aVar) {
                            com.kwad.components.ad.reward.g unused2 = a.this.rO;
                            aVar.jf();
                        }
                    });
                }
            }

            @Override // com.kwad.components.core.webview.jshandler.w
            public final void d(x xVar) {
                super.d(xVar);
                a.this.rO.mAdTemplate.setmCurPlayTime(xVar.oZ);
            }
        });
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ad.a aVar) {
        float ba2 = com.kwad.sdk.c.a.a.ba(getContext());
        float screenHeight = com.kwad.sdk.c.a.a.getScreenHeight(getContext());
        aVar.width = (int) ((com.kwad.sdk.c.a.a.getScreenWidth(getContext()) / ba2) + 0.5f);
        aVar.height = (int) ((screenHeight / ba2) + 0.5f);
    }
}
