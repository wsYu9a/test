package com.kwad.components.ad.draw.b.a;

import android.view.View;
import com.kwad.components.core.s.b;
import com.kwad.components.core.video.k;
import com.kwad.components.core.video.l;
import com.kwad.sdk.core.adlog.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.utils.m;
import com.kwad.sdk.widget.j;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class a extends com.kwad.components.ad.draw.a.a {

    /* renamed from: ci */
    private List<Integer> f11423ci;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    /* renamed from: di */
    private boolean f11424di = false;
    private volatile boolean dP = false;
    private j dQ = new j() { // from class: com.kwad.components.ad.draw.b.a.a.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.widget.j
        public final void aN() {
            m.eA(a.this.mAdTemplate);
        }
    };
    private k mVideoPlayStateListener = new l() { // from class: com.kwad.components.ad.draw.b.a.a.2
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            c.bT(a.this.mAdTemplate);
            if (a.this.f11413df.f11414de != null) {
                try {
                    a.this.f11413df.f11414de.onVideoPlayEnd();
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                }
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayError(int i10, int i11) {
            super.onMediaPlayError(i10, i11);
            if (a.this.f11413df.f11414de != null) {
                try {
                    a.this.f11413df.f11414de.onVideoPlayError();
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                }
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            if (a.this.f11413df.f11414de != null) {
                try {
                    a.this.f11413df.f11414de.onVideoPlayPause();
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                }
            }
            a.this.f11424di = true;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            a.this.c(j11);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            a.this.dP = false;
            if (!a.this.mAdTemplate.mPvReported && a.this.f11413df.f11414de != null) {
                a.this.f11413df.f11414de.onAdShow();
            }
            if (a.this.f11413df.f11414de != null) {
                try {
                    a.this.f11413df.f11414de.onVideoPlayStart();
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                }
                a.this.f11424di = false;
            }
            b.sc().a(a.this.mAdTemplate, null, null);
            c.bS(a.this.mAdTemplate);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            if (!a.this.f11424di) {
                if (a.this.dP) {
                    return;
                }
                a.this.dP = true;
                com.kwad.components.core.o.a.ri().b(a.this.mAdTemplate, System.currentTimeMillis(), 1);
                return;
            }
            a.this.f11424di = false;
            if (a.this.f11413df.f11414de != null) {
                try {
                    a.this.f11413df.f11414de.onVideoPlayResume();
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                }
            }
        }
    };

    /* renamed from: com.kwad.components.ad.draw.b.a.a$1 */
    public class AnonymousClass1 implements j {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.widget.j
        public final void aN() {
            m.eA(a.this.mAdTemplate);
        }
    }

    /* renamed from: com.kwad.components.ad.draw.b.a.a$2 */
    public class AnonymousClass2 extends l {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            c.bT(a.this.mAdTemplate);
            if (a.this.f11413df.f11414de != null) {
                try {
                    a.this.f11413df.f11414de.onVideoPlayEnd();
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                }
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayError(int i10, int i11) {
            super.onMediaPlayError(i10, i11);
            if (a.this.f11413df.f11414de != null) {
                try {
                    a.this.f11413df.f11414de.onVideoPlayError();
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                }
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            if (a.this.f11413df.f11414de != null) {
                try {
                    a.this.f11413df.f11414de.onVideoPlayPause();
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                }
            }
            a.this.f11424di = true;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            a.this.c(j11);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            a.this.dP = false;
            if (!a.this.mAdTemplate.mPvReported && a.this.f11413df.f11414de != null) {
                a.this.f11413df.f11414de.onAdShow();
            }
            if (a.this.f11413df.f11414de != null) {
                try {
                    a.this.f11413df.f11414de.onVideoPlayStart();
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                }
                a.this.f11424di = false;
            }
            b.sc().a(a.this.mAdTemplate, null, null);
            c.bS(a.this.mAdTemplate);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            if (!a.this.f11424di) {
                if (a.this.dP) {
                    return;
                }
                a.this.dP = true;
                com.kwad.components.core.o.a.ri().b(a.this.mAdTemplate, System.currentTimeMillis(), 1);
                return;
            }
            a.this.f11424di = false;
            if (a.this.f11413df.f11414de != null) {
                try {
                    a.this.f11413df.f11414de.onVideoPlayResume();
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                }
            }
        }
    }

    @Override // com.kwad.components.ad.draw.a.a, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        AdTemplate adTemplate = this.f11413df.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo eb2 = e.eb(adTemplate);
        this.mAdInfo = eb2;
        this.f11423ci = com.kwad.sdk.core.response.b.a.bo(eb2);
        this.f11413df.f11415dg.b(this.mVideoPlayStateListener);
        a(this.dQ);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f11413df.f11415dg.a(this.mVideoPlayStateListener);
        a((j) null);
    }

    public void c(long j10) {
        int ceil = (int) Math.ceil(j10 / 1000.0f);
        List<Integer> list = this.f11423ci;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.f11423ci) {
            if (ceil >= num.intValue()) {
                c.a(this.mAdTemplate, ceil, (JSONObject) null);
                this.f11423ci.remove(num);
                return;
            }
        }
    }

    private void a(j jVar) {
        View rootView = getRootView();
        if (rootView instanceof AdBasePvFrameLayout) {
            ((AdBasePvFrameLayout) rootView).setVisibleListener(jVar);
        }
    }
}
