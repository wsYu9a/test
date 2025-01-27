package com.kwad.components.ad.draw;

import android.content.Context;
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kuaishou.pushad.KsAdGlobalWatcher;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.core.AbstractKsDrawAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.j.k;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class c extends AbstractKsDrawAd implements com.kwad.components.core.internal.api.a {

    @Nullable
    private KsDrawAd.AdInteractionListener bV;
    private b cf;

    @NonNull
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.internal.api.c cg = new com.kwad.components.core.internal.api.c();
    private final com.kwad.sdk.core.g.b ca = new com.kwad.sdk.core.g.b() { // from class: com.kwad.components.ad.draw.c.1
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.g.b
        public final void ap() {
            c.this.cg.a(c.this);
        }

        @Override // com.kwad.sdk.core.g.b
        public final void aq() {
            c.this.cg.b(c.this);
        }
    };
    private final KsDrawAd.AdInteractionListener ch = new KsDrawAd.AdInteractionListener() { // from class: com.kwad.components.ad.draw.c.2
        AnonymousClass2() {
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onAdClicked() {
            if (c.this.bV != null) {
                c.this.bV.onAdClicked();
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onAdShow() {
            if (c.this.bV != null) {
                c.this.bV.onAdShow();
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayEnd() {
            if (c.this.bV != null) {
                try {
                    c.this.bV.onVideoPlayEnd();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayError() {
            if (c.this.bV != null) {
                try {
                    c.this.bV.onVideoPlayError();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayPause() {
            if (c.this.bV != null) {
                try {
                    c.this.bV.onVideoPlayPause();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayResume() {
            if (c.this.bV != null) {
                try {
                    c.this.bV.onVideoPlayResume();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayStart() {
            if (c.this.bV != null) {
                try {
                    c.this.bV.onVideoPlayStart();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                }
            }
        }
    };

    /* renamed from: com.kwad.components.ad.draw.c$1 */
    final class AnonymousClass1 extends com.kwad.sdk.core.g.b {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.g.b
        public final void ap() {
            c.this.cg.a(c.this);
        }

        @Override // com.kwad.sdk.core.g.b
        public final void aq() {
            c.this.cg.b(c.this);
        }
    }

    /* renamed from: com.kwad.components.ad.draw.c$2 */
    final class AnonymousClass2 implements KsDrawAd.AdInteractionListener {
        AnonymousClass2() {
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onAdClicked() {
            if (c.this.bV != null) {
                c.this.bV.onAdClicked();
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onAdShow() {
            if (c.this.bV != null) {
                c.this.bV.onAdShow();
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayEnd() {
            if (c.this.bV != null) {
                try {
                    c.this.bV.onVideoPlayEnd();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayError() {
            if (c.this.bV != null) {
                try {
                    c.this.bV.onVideoPlayError();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayPause() {
            if (c.this.bV != null) {
                try {
                    c.this.bV.onVideoPlayPause();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayResume() {
            if (c.this.bV != null) {
                try {
                    c.this.bV.onVideoPlayResume();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayStart() {
            if (c.this.bV != null) {
                try {
                    c.this.bV.onVideoPlayStart();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                }
            }
        }
    }

    public c(@NonNull AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        KSImageLoader.preloadImage(com.kwad.sdk.core.response.a.a.bi(com.kwad.sdk.core.response.a.d.cb(adTemplate)).getUrl(), this.mAdTemplate);
        KsAdGlobalWatcher.getInstance().watch(this);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void a(com.kwad.components.core.internal.api.b bVar) {
        this.cg.a(bVar);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final boolean ao() {
        return true;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void b(com.kwad.components.core.internal.api.b bVar) {
        this.cg.b(bVar);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsDrawAd
    @Nullable
    public final View getDrawView2(Context context) {
        if (context == null || !KsAdSDKImpl.get().hasInitFinish()) {
            return null;
        }
        try {
            context = k.wrapContextIfNeed(context);
            com.kwad.sdk.g.a.U("draw", "show");
            if (this.cf == null) {
                b bVar = new b(context);
                this.cf = bVar;
                bVar.setPageExitListener(this.ca);
                this.cf.setAdInteractionListener(this.bV);
                this.cf.a(this.mAdTemplate);
            } else {
                com.kwad.sdk.core.d.b.i("KSDrawAdControl", "mDrawVideoView is not null");
            }
            com.kwad.sdk.g.a.V("draw", "show");
        } catch (Throwable th) {
            if (!KsAdSDKImpl.get().getIsExternal()) {
                throw th;
            }
            RuntimeException runtimeException = new RuntimeException("context:" + context.getClass().getName() + "--classloader:" + context.getClass().getClassLoader());
            int i2 = Build.VERSION.SDK_INT;
            com.kwad.components.core.c.a.b(runtimeException);
        }
        return this.cf;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final int getECPM() {
        return com.kwad.sdk.core.response.a.a.aJ(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final int getInteractionType() {
        return com.kwad.sdk.core.response.a.a.aI(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final int getMaterialType() {
        return com.kwad.sdk.core.response.a.a.aW(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public final Map<String, Object> getMediaExtraInfo() {
        HashMap hashMap = new HashMap();
        if (com.kwad.sdk.core.config.d.ur()) {
            hashMap.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return hashMap;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void reportAdExposureFailed(int i2, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, i2, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.bV = adInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void setBidEcpm(int i2) {
        setBidEcpm(i2, -1L);
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void setBidEcpm(long j2, long j3) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = j2;
        com.kwad.sdk.core.report.a.i(adTemplate, j3);
    }
}
