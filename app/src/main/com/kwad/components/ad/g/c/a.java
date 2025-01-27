package com.kwad.components.ad.g.c;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.l.b;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.j.a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.l;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.h.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.b.h;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.m;

/* loaded from: classes2.dex */
public final class a extends b {
    private KsAdVideoPlayConfig bS;

    /* renamed from: cn */
    private boolean f11535cn;
    private OfflineOnAudioConflictListener cy;

    /* renamed from: dh */
    private com.kwad.components.core.widget.a.b f11536dh;
    private final c eu;
    private a.b gr;
    private boolean hasNoCache;
    private final AdInfo mAdInfo;
    private Context mContext;
    private boolean oI;
    private boolean oJ;
    private l oK;

    /* renamed from: com.kwad.components.ad.g.c.a$1 */
    public class AnonymousClass1 extends l {
        final /* synthetic */ AdTemplate cP;

        public AnonymousClass1(AdTemplate adTemplate) {
            adTemplate = adTemplate;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayError(int i10, int i11) {
            super.onMediaPlayError(i10, i11);
            com.kwad.components.core.o.a.ri().d(adTemplate, i10, i11);
        }
    }

    /* renamed from: com.kwad.components.ad.g.c.a$2 */
    public class AnonymousClass2 implements c.e {
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.core.video.a.c.e
        public final void a(com.kwad.sdk.core.video.a.c cVar) {
            try {
                if (a.this.eX() && a.this.f11536dh.ad()) {
                    a.this.Js.a(com.kwad.sdk.contentalliance.a.a.a.bL(a.this.mAdTemplate));
                    com.kwad.components.core.j.a.pv().a(a.this.getCurrentVoiceItem());
                    a.this.Js.start();
                }
            } catch (Throwable th2) {
                ServiceProvider.reportSdkCaughtException(th2);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.g.c.a$3 */
    public class AnonymousClass3 implements com.kwad.sdk.core.h.c {
        public AnonymousClass3() {
        }

        @Override // com.kwad.sdk.core.h.c
        public final void bl() {
            com.kwad.components.core.j.a.pv().a(a.this.getCurrentVoiceItem());
            a.this.resume();
        }

        @Override // com.kwad.sdk.core.h.c
        public final void bm() {
            com.kwad.components.core.j.a.pv().c(a.this.gr);
            a.this.pause();
        }
    }

    /* renamed from: com.kwad.components.ad.g.c.a$4 */
    public class AnonymousClass4 implements a.c {
        public AnonymousClass4() {
        }

        @Override // com.kwad.components.core.j.a.c
        public final void bM() {
            a aVar = a.this;
            aVar.setAudioEnabled(aVar.h(aVar.oI));
        }
    }

    /* renamed from: com.kwad.components.ad.g.c.a$5 */
    public class AnonymousClass5 implements OfflineOnAudioConflictListener {
        public AnonymousClass5() {
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeOccupied() {
            a.c(a.this, false);
            a.this.setAudioEnabled(false);
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeReleased() {
        }
    }

    public a(@NonNull AdTemplate adTemplate, @NonNull com.kwad.components.core.widget.a.b bVar, @NonNull DetailVideoView detailVideoView, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        super(adTemplate, detailVideoView);
        this.hasNoCache = false;
        this.eu = new com.kwad.sdk.core.h.c() { // from class: com.kwad.components.ad.g.c.a.3
            public AnonymousClass3() {
            }

            @Override // com.kwad.sdk.core.h.c
            public final void bl() {
                com.kwad.components.core.j.a.pv().a(a.this.getCurrentVoiceItem());
                a.this.resume();
            }

            @Override // com.kwad.sdk.core.h.c
            public final void bm() {
                com.kwad.components.core.j.a.pv().c(a.this.gr);
                a.this.pause();
            }
        };
        this.cy = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.g.c.a.5
            public AnonymousClass5() {
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                a.c(a.this, false);
                a.this.setAudioEnabled(false);
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }
        };
        this.f11536dh = bVar;
        AdInfo eb2 = e.eb(this.mAdTemplate);
        this.mAdInfo = eb2;
        if (!(ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) || ((KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig).getVideoSoundValue() == 0) {
            this.oI = com.kwad.sdk.core.response.b.a.bZ(eb2);
        } else {
            this.oI = ksAdVideoPlayConfig.isVideoSoundEnable();
        }
        this.bS = ksAdVideoPlayConfig;
        this.mContext = detailVideoView.getContext();
        if (ksAdVideoPlayConfig != null) {
            try {
                this.hasNoCache = ksAdVideoPlayConfig.isNoCache();
            } catch (Throwable th2) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
            }
        }
        AnonymousClass1 anonymousClass1 = new l() { // from class: com.kwad.components.ad.g.c.a.1
            final /* synthetic */ AdTemplate cP;

            public AnonymousClass1(AdTemplate adTemplate2) {
                adTemplate = adTemplate2;
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayError(int i10, int i11) {
                super.onMediaPlayError(i10, i11);
                com.kwad.components.core.o.a.ri().d(adTemplate, i10, i11);
            }
        };
        this.oK = anonymousClass1;
        this.Js.c(anonymousClass1);
        bk();
        this.Js.a(new c.e() { // from class: com.kwad.components.ad.g.c.a.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                try {
                    if (a.this.eX() && a.this.f11536dh.ad()) {
                        a.this.Js.a(com.kwad.sdk.contentalliance.a.a.a.bL(a.this.mAdTemplate));
                        com.kwad.components.core.j.a.pv().a(a.this.getCurrentVoiceItem());
                        a.this.Js.start();
                    }
                } catch (Throwable th22) {
                    ServiceProvider.reportSdkCaughtException(th22);
                }
            }
        });
    }

    private void bk() {
        this.Js.a(new b.a(this.mAdTemplate).dc(e.ed(this.mAdTemplate)).dd(h.b(e.ec(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).bm(this.hasNoCache).b(com.kwad.sdk.contentalliance.a.a.a.bL(this.mAdTemplate)).Cz(), true, true, this.mDetailVideoView);
        setAudioEnabled(h(this.oI));
        if (eX()) {
            this.Js.prepareAsync();
            com.kwad.components.core.s.a.av(this.mContext).a(this.cy);
        }
    }

    public boolean eX() {
        if (this.oJ) {
            return true;
        }
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.bS;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 1) {
                return al.isNetworkConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 2) {
                return al.isWifiConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 3) {
                return false;
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                return al.isWifiConnected(this.mContext) || (kSAdVideoPlayConfigImpl.isDataFlowAutoStart() && al.isMobileConnected(this.mContext));
            }
        }
        if (com.kwad.sdk.core.response.b.a.cb(this.mAdInfo) && al.isNetworkConnected(this.mContext)) {
            return true;
        }
        return com.kwad.sdk.core.response.b.a.cc(this.mAdInfo) && al.isWifiConnected(this.mContext);
    }

    public a.b getCurrentVoiceItem() {
        if (this.gr == null) {
            this.gr = new a.b(new a.c() { // from class: com.kwad.components.ad.g.c.a.4
                public AnonymousClass4() {
                }

                @Override // com.kwad.components.core.j.a.c
                public final void bM() {
                    a aVar = a.this;
                    aVar.setAudioEnabled(aVar.h(aVar.oI));
                }
            });
        }
        return this.gr;
    }

    public void setAudioEnabled(boolean z10) {
        this.Js.setAudioEnabled(z10);
    }

    public final void bi() {
        m.eA(this.mAdTemplate);
        if (this.Js.sv() == null) {
            bk();
        }
        if (eX() && this.f11536dh.ad()) {
            this.Js.a(com.kwad.sdk.contentalliance.a.a.a.bL(this.mAdTemplate));
            com.kwad.components.core.j.a.pv().a(getCurrentVoiceItem());
            this.Js.start();
        }
        this.f11536dh.a(this.eu);
    }

    public final void bj() {
        m.ey(this.mAdTemplate);
        this.f11536dh.b(this.eu);
        this.Js.release();
        com.kwad.components.core.j.a.pv().c(this.gr);
        com.kwad.components.core.s.a.av(this.mContext).b(this.cy);
    }

    public final void eY() {
        this.oJ = true;
        if (this.f11536dh.ad()) {
            m.ez(this.mAdTemplate);
            this.Js.a(com.kwad.sdk.contentalliance.a.a.a.bL(this.mAdTemplate));
            com.kwad.components.core.j.a.pv().a(getCurrentVoiceItem());
            this.Js.start();
        }
    }

    @Override // com.kwad.components.ad.l.b, com.kwad.components.ad.l.a
    public final void resume() {
        com.kwad.components.core.j.a.pv().a(getCurrentVoiceItem());
        setAudioEnabled(h(this.oI));
        if (eX()) {
            super.resume();
        }
    }

    public static /* synthetic */ boolean c(a aVar, boolean z10) {
        aVar.f11535cn = false;
        return false;
    }

    public boolean h(boolean z10) {
        if (!z10) {
            return false;
        }
        if (this.gr != null) {
            com.kwad.components.core.j.a.pv();
            if (!com.kwad.components.core.j.a.b(this.gr)) {
                return false;
            }
        }
        if (!d.gN()) {
            return !com.kwad.components.core.s.a.av(this.mContext).sb() ? com.kwad.components.core.s.a.av(this.mContext).aO(false) : !com.kwad.components.core.s.a.av(this.mContext).sa();
        }
        if (!this.f11535cn) {
            this.f11535cn = com.kwad.components.core.s.a.av(this.mContext).aO(true);
        }
        return this.f11535cn;
    }
}
