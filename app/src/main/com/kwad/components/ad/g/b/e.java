package com.kwad.components.ad.g.b;

import com.kwad.components.core.video.l;
import com.kwad.sdk.api.KsNativeAd;

/* loaded from: classes2.dex */
public final class e extends com.kwad.components.ad.g.a.a {

    /* renamed from: di */
    private boolean f11534di = false;
    private KsNativeAd.VideoPlayListener nG;

    /* renamed from: com.kwad.components.ad.g.b.e$1 */
    public class AnonymousClass1 extends l {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            if (e.this.nG != null) {
                e.this.nG.onVideoPlayComplete();
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayError(int i10, int i11) {
            if (e.this.nG != null) {
                e.this.nG.onVideoPlayError(i10, i11);
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            if (e.this.nG != null) {
                try {
                    e.this.nG.onVideoPlayPause();
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                }
            }
            e.this.f11534di = true;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            if (e.this.nG != null) {
                e.this.nG.onVideoPlayStart();
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            if (e.this.f11534di) {
                e.this.f11534di = false;
                if (e.this.nG != null) {
                    try {
                        e.this.nG.onVideoPlayResume();
                    } catch (Throwable th2) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                    }
                }
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPrepared() {
            super.onMediaPrepared();
            if (e.this.nG != null) {
                try {
                    e.this.nG.onVideoPlayReady();
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                }
            }
        }
    }

    @Override // com.kwad.components.ad.g.a.a, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.nG = this.f11530oe.nG;
        AnonymousClass1 anonymousClass1 = new l() { // from class: com.kwad.components.ad.g.b.e.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                if (e.this.nG != null) {
                    e.this.nG.onVideoPlayComplete();
                }
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayError(int i10, int i11) {
                if (e.this.nG != null) {
                    e.this.nG.onVideoPlayError(i10, i11);
                }
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayPaused() {
                super.onMediaPlayPaused();
                if (e.this.nG != null) {
                    try {
                        e.this.nG.onVideoPlayPause();
                    } catch (Throwable th2) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                    }
                }
                e.this.f11534di = true;
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayStart() {
                if (e.this.nG != null) {
                    e.this.nG.onVideoPlayStart();
                }
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlaying() {
                super.onMediaPlaying();
                if (e.this.f11534di) {
                    e.this.f11534di = false;
                    if (e.this.nG != null) {
                        try {
                            e.this.nG.onVideoPlayResume();
                        } catch (Throwable th2) {
                            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                        }
                    }
                }
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPrepared() {
                super.onMediaPrepared();
                if (e.this.nG != null) {
                    try {
                        e.this.nG.onVideoPlayReady();
                    } catch (Throwable th2) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                    }
                }
            }
        };
        this.mVideoPlayStateListener = anonymousClass1;
        this.f11530oe.f11531of.b((com.kwad.components.core.video.k) anonymousClass1);
    }

    @Override // com.kwad.components.ad.g.a.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
