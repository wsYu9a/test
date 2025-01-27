package com.kwad.components.ad.e.a;

import com.kwad.sdk.api.KsNativeAd;

/* loaded from: classes.dex */
public final class e extends com.kwad.components.ad.e.kwai.a {
    private boolean bY = false;
    private KsNativeAd.VideoPlayListener mM;

    /* renamed from: com.kwad.components.ad.e.a.e$1 */
    final class AnonymousClass1 extends com.kwad.components.core.video.j {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            if (e.this.mM != null) {
                e.this.mM.onVideoPlayComplete();
            }
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayError(int i2, int i3) {
            if (e.this.mM != null) {
                e.this.mM.onVideoPlayError(i2, i3);
            }
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayPaused() {
            super.onVideoPlayPaused();
            if (e.this.mM != null) {
                try {
                    e.this.mM.onVideoPlayPause();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                }
            }
            e.this.bY = true;
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayStart() {
            if (e.this.mM != null) {
                e.this.mM.onVideoPlayStart();
            }
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlaying() {
            super.onVideoPlaying();
            if (e.this.bY) {
                e.this.bY = false;
                if (e.this.mM != null) {
                    try {
                        e.this.mM.onVideoPlayResume();
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                    }
                }
            }
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPrepared() {
            super.onVideoPrepared();
            if (e.this.mM != null) {
                try {
                    e.this.mM.onVideoPlayReady();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                }
            }
        }
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.mM = this.ni.mM;
        AnonymousClass1 anonymousClass1 = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.e.a.e.1
            AnonymousClass1() {
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayCompleted() {
                if (e.this.mM != null) {
                    e.this.mM.onVideoPlayComplete();
                }
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayError(int i2, int i3) {
                if (e.this.mM != null) {
                    e.this.mM.onVideoPlayError(i2, i3);
                }
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayPaused() {
                super.onVideoPlayPaused();
                if (e.this.mM != null) {
                    try {
                        e.this.mM.onVideoPlayPause();
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                    }
                }
                e.this.bY = true;
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayStart() {
                if (e.this.mM != null) {
                    e.this.mM.onVideoPlayStart();
                }
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlaying() {
                super.onVideoPlaying();
                if (e.this.bY) {
                    e.this.bY = false;
                    if (e.this.mM != null) {
                        try {
                            e.this.mM.onVideoPlayResume();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                        }
                    }
                }
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPrepared() {
                super.onVideoPrepared();
                if (e.this.mM != null) {
                    try {
                        e.this.mM.onVideoPlayReady();
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                    }
                }
            }
        };
        this.mVideoPlayStateListener = anonymousClass1;
        this.ni.nj.a(anonymousClass1);
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
