package com.kwad.components.ad.draw;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.core.AbstractKsDrawAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.l;
import com.kwad.sdk.n.m;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class c extends AbstractKsDrawAd implements com.kwad.components.core.internal.api.a {

    /* renamed from: de */
    @Nullable
    private KsDrawAd.AdInteractionListener f11444de;
    private b dp;

    @NonNull
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.internal.api.c bz = new com.kwad.components.core.internal.api.c();

    /* renamed from: dk */
    private final com.kwad.sdk.core.h.b f11445dk = new com.kwad.sdk.core.h.b() { // from class: com.kwad.components.ad.draw.c.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.h.b
        public final void aH() {
            c.this.bz.h(c.this);
        }

        @Override // com.kwad.sdk.core.h.b
        public final void aI() {
            c.this.bz.i(c.this);
        }
    };
    private final KsDrawAd.AdInteractionListener dq = new KsDrawAd.AdInteractionListener() { // from class: com.kwad.components.ad.draw.c.2
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onAdClicked() {
            if (c.this.f11444de != null) {
                c.this.f11444de.onAdClicked();
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onAdShow() {
            if (c.this.f11444de != null) {
                c.this.f11444de.onAdShow();
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayEnd() {
            if (c.this.f11444de != null) {
                try {
                    c.this.f11444de.onVideoPlayEnd();
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayError() {
            if (c.this.f11444de != null) {
                try {
                    c.this.f11444de.onVideoPlayError();
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayPause() {
            if (c.this.f11444de != null) {
                try {
                    c.this.f11444de.onVideoPlayPause();
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayResume() {
            if (c.this.f11444de != null) {
                try {
                    c.this.f11444de.onVideoPlayResume();
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayStart() {
            if (c.this.f11444de != null) {
                try {
                    c.this.f11444de.onVideoPlayStart();
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                }
            }
        }
    };

    /* renamed from: com.kwad.components.ad.draw.c$1 */
    public class AnonymousClass1 extends com.kwad.sdk.core.h.b {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.h.b
        public final void aH() {
            c.this.bz.h(c.this);
        }

        @Override // com.kwad.sdk.core.h.b
        public final void aI() {
            c.this.bz.i(c.this);
        }
    }

    /* renamed from: com.kwad.components.ad.draw.c$2 */
    public class AnonymousClass2 implements KsDrawAd.AdInteractionListener {
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onAdClicked() {
            if (c.this.f11444de != null) {
                c.this.f11444de.onAdClicked();
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onAdShow() {
            if (c.this.f11444de != null) {
                c.this.f11444de.onAdShow();
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayEnd() {
            if (c.this.f11444de != null) {
                try {
                    c.this.f11444de.onVideoPlayEnd();
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayError() {
            if (c.this.f11444de != null) {
                try {
                    c.this.f11444de.onVideoPlayError();
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayPause() {
            if (c.this.f11444de != null) {
                try {
                    c.this.f11444de.onVideoPlayPause();
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayResume() {
            if (c.this.f11444de != null) {
                try {
                    c.this.f11444de.onVideoPlayResume();
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayStart() {
            if (c.this.f11444de != null) {
                try {
                    c.this.f11444de.onVideoPlayStart();
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                }
            }
        }
    }

    public c(@NonNull AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        KSImageLoader.preloadImage(com.kwad.sdk.core.response.b.a.bt(e.eb(adTemplate)).getUrl(), this.mAdTemplate);
        com.kwad.components.ad.j.b.fc().a(this);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsDrawAd
    @Nullable
    public final View getDrawView2(Context context) {
        if (context == null || !l.At().zE()) {
            return null;
        }
        try {
            context = m.wrapContextIfNeed(context);
            if (this.dp == null) {
                b bVar = new b(context);
                this.dp = bVar;
                bVar.setPageExitListener(this.f11445dk);
                this.dp.setAdInteractionListener(this.f11444de);
                this.dp.e(this.mAdTemplate);
            } else {
                com.kwad.sdk.core.d.c.i("KSDrawAdControl", "mDrawVideoView is not null");
            }
        } catch (Throwable th2) {
            if (!l.At().zB()) {
                throw th2;
            }
            RuntimeException runtimeException = new RuntimeException("context:" + context.getClass().getName() + "--classloader:" + context.getClass().getClassLoader());
            runtimeException.addSuppressed(th2);
            com.kwad.components.core.d.a.reportSdkCaughtException(runtimeException);
        }
        return this.dp;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final int getECPM() {
        return com.kwad.sdk.core.response.b.a.aR(e.eb(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final int getInteractionType() {
        return com.kwad.sdk.core.response.b.a.aQ(e.eb(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final int getMaterialType() {
        return com.kwad.sdk.core.response.b.a.be(e.eb(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public final Map<String, Object> getMediaExtraInfo() {
        HashMap hashMap = new HashMap();
        if (com.kwad.sdk.core.config.d.Dx()) {
            hashMap.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return hashMap;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void reportAdExposureFailed(int i10, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, i10, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.f11444de = adInteractionListener;
        b bVar = this.dp;
        if (bVar != null) {
            bVar.setAdInteractionListener(adInteractionListener);
        }
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void setBidEcpm(int i10) {
        setBidEcpm(i10, -1L);
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void setVideoSoundEnable(boolean z10) {
        b bVar = this.dp;
        if (bVar != null) {
            bVar.setVideoSound(z10);
        }
    }

    @Override // com.kwad.components.core.internal.api.a
    public final boolean supportPushAd() {
        return true;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void a(com.kwad.components.core.internal.api.b bVar) {
        this.bz.a(bVar);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void b(com.kwad.components.core.internal.api.b bVar) {
        this.bz.b(bVar);
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void setBidEcpm(long j10, long j11) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = j10;
        com.kwad.sdk.core.adlog.c.l(adTemplate, j11);
    }
}
