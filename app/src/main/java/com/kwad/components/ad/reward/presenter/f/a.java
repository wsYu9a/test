package com.kwad.components.ad.reward.presenter.f;

import com.kwad.components.ad.reward.j;
import com.kwad.components.core.webview.a.a.y;
import com.kwad.components.core.webview.a.kwai.o;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.sdk.components.l;

/* loaded from: classes2.dex */
public abstract class a extends c {
    private o vG;

    /* renamed from: com.kwad.components.ad.reward.presenter.f.a$1 */
    final class AnonymousClass1 implements o.a {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.a.kwai.o.a
        public final boolean isMuted() {
            return !a.this.qt.mVideoPlayConfig.isVideoSoundEnable() || com.kwad.components.core.r.a.aj(a.this.getContext()).pI();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.a$2 */
    final class AnonymousClass2 extends n {

        /* renamed from: com.kwad.components.ad.reward.presenter.f.a$2$1 */
        final class AnonymousClass1 implements com.kwad.sdk.e.a<com.kwad.components.ad.reward.h.a> {
            AnonymousClass1() {
            }

            @Override // com.kwad.sdk.e.a
            /* renamed from: c */
            public void accept(com.kwad.components.ad.reward.h.a aVar) {
                j unused = a.this.qt;
                aVar.iG();
            }
        }

        AnonymousClass2() {
        }

        @Override // com.kwad.components.core.webview.jshandler.n
        public final void a(y yVar) {
            super.a(yVar);
            a.this.qt.mAdOpenInteractionListener.onVideoPlayStart();
            com.kwad.components.ad.reward.monitor.a.b(a.this.qt.pf, a.this.qt.mAdTemplate, a.this.qt.mPageEnterTime);
        }

        @Override // com.kwad.components.core.webview.jshandler.n
        public final void b(y yVar) {
            super.b(yVar);
            a.this.qt.mAdTemplate.setmCurPlayTime(yVar.nZ);
        }

        @Override // com.kwad.components.core.webview.jshandler.n
        public final void c(y yVar) {
            super.c(yVar);
            a.this.qt.mAdOpenInteractionListener.onVideoPlayEnd();
            a.this.qt.mAdTemplate.setmCurPlayTime(-1L);
            com.kwad.components.ad.reward.presenter.e.u(a.this.qt);
            j unused = a.this.qt;
            j.a(a.this.qt.oW, new com.kwad.sdk.e.a<com.kwad.components.ad.reward.h.a>() { // from class: com.kwad.components.ad.reward.presenter.f.a.2.1
                AnonymousClass1() {
                }

                @Override // com.kwad.sdk.e.a
                /* renamed from: c */
                public void accept(com.kwad.components.ad.reward.h.a aVar) {
                    j unused2 = a.this.qt;
                    aVar.iG();
                }
            });
        }

        @Override // com.kwad.components.core.webview.jshandler.n
        public final void d(y yVar) {
            super.d(yVar);
            long rj = yVar.rj();
            a.this.qt.mAdOpenInteractionListener.onVideoPlayError(yVar.errorCode, (int) rj);
            com.kwad.components.ad.reward.monitor.a.a(a.this.qt.pf, a.this.qt.mAdTemplate, a.this.qt.pB, yVar.errorCode, rj);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c
    protected final boolean ck() {
        return true;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c
    protected final boolean iI() {
        return true;
    }

    public final boolean iJ() {
        e eVar = this.vT;
        if (eVar != null) {
            return eVar.iJ();
        }
        return false;
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onGetContainerLimited(u.a aVar) {
        float ax = com.kwad.sdk.c.kwai.a.ax(getContext());
        float screenHeight = com.kwad.sdk.c.kwai.a.getScreenHeight(getContext());
        aVar.width = (int) ((com.kwad.sdk.c.kwai.a.getScreenWidth(getContext()) / ax) + 0.5f);
        aVar.height = (int) ((screenHeight / ax) + 0.5f);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.components.core.webview.a.i
    public void onRegisterVideoMuteStateListener(o oVar) {
        this.vG = oVar;
        oVar.a(new o.a() { // from class: com.kwad.components.ad.reward.presenter.f.a.1
            AnonymousClass1() {
            }

            @Override // com.kwad.components.core.webview.a.kwai.o.a
            public final boolean isMuted() {
                return !a.this.qt.mVideoPlayConfig.isVideoSoundEnable() || com.kwad.components.core.r.a.aj(a.this.getContext()).pI();
            }
        });
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.components.core.webview.a.i
    public void onRegisterWebCardHandler(l lVar, com.kwad.sdk.core.webview.b bVar) {
        super.onRegisterWebCardHandler(lVar, bVar);
        lVar.c(new n() { // from class: com.kwad.components.ad.reward.presenter.f.a.2

            /* renamed from: com.kwad.components.ad.reward.presenter.f.a$2$1 */
            final class AnonymousClass1 implements com.kwad.sdk.e.a<com.kwad.components.ad.reward.h.a> {
                AnonymousClass1() {
                }

                @Override // com.kwad.sdk.e.a
                /* renamed from: c */
                public void accept(com.kwad.components.ad.reward.h.a aVar) {
                    j unused2 = a.this.qt;
                    aVar.iG();
                }
            }

            AnonymousClass2() {
            }

            @Override // com.kwad.components.core.webview.jshandler.n
            public final void a(y yVar) {
                super.a(yVar);
                a.this.qt.mAdOpenInteractionListener.onVideoPlayStart();
                com.kwad.components.ad.reward.monitor.a.b(a.this.qt.pf, a.this.qt.mAdTemplate, a.this.qt.mPageEnterTime);
            }

            @Override // com.kwad.components.core.webview.jshandler.n
            public final void b(y yVar) {
                super.b(yVar);
                a.this.qt.mAdTemplate.setmCurPlayTime(yVar.nZ);
            }

            @Override // com.kwad.components.core.webview.jshandler.n
            public final void c(y yVar) {
                super.c(yVar);
                a.this.qt.mAdOpenInteractionListener.onVideoPlayEnd();
                a.this.qt.mAdTemplate.setmCurPlayTime(-1L);
                com.kwad.components.ad.reward.presenter.e.u(a.this.qt);
                j unused = a.this.qt;
                j.a(a.this.qt.oW, new com.kwad.sdk.e.a<com.kwad.components.ad.reward.h.a>() { // from class: com.kwad.components.ad.reward.presenter.f.a.2.1
                    AnonymousClass1() {
                    }

                    @Override // com.kwad.sdk.e.a
                    /* renamed from: c */
                    public void accept(com.kwad.components.ad.reward.h.a aVar) {
                        j unused2 = a.this.qt;
                        aVar.iG();
                    }
                });
            }

            @Override // com.kwad.components.core.webview.jshandler.n
            public final void d(y yVar) {
                super.d(yVar);
                long rj = yVar.rj();
                a.this.qt.mAdOpenInteractionListener.onVideoPlayError(yVar.errorCode, (int) rj);
                com.kwad.components.ad.reward.monitor.a.a(a.this.qt.pf, a.this.qt.mAdTemplate, a.this.qt.pB, yVar.errorCode, rj);
            }
        });
    }
}
