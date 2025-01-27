package com.kwad.components.ad.feed;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.feed.b.m;
import com.kwad.components.ad.feed.b.n;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.widget.b;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.core.AbstractKsFeedAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import com.kwad.sdk.utils.l;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class c extends AbstractKsFeedAd implements com.kwad.components.core.internal.api.a {
    private final KsAdVideoPlayConfig bS;

    /* renamed from: fg */
    private KsFeedAd.AdInteractionListener f11502fg;

    /* renamed from: fh */
    private com.kwad.components.core.widget.b f11503fh;

    /* renamed from: fi */
    private n f11504fi;

    /* renamed from: fj */
    private boolean f11505fj;
    private final AdInfo mAdInfo;

    @NonNull
    private final AdResultData mAdResultData;

    @NonNull
    private final AdTemplate mAdTemplate;

    /* renamed from: fk */
    private AtomicBoolean f11506fk = new AtomicBoolean(false);
    private AtomicBoolean fl = new AtomicBoolean(false);
    private AtomicInteger fm = new AtomicInteger(2);
    private com.kwad.components.core.internal.api.c bz = new com.kwad.components.core.internal.api.c();

    /* renamed from: dk */
    private com.kwad.sdk.core.h.b f11501dk = new com.kwad.sdk.core.h.b() { // from class: com.kwad.components.ad.feed.c.1
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

    /* renamed from: com.kwad.components.ad.feed.c$1 */
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

    /* renamed from: com.kwad.components.ad.feed.c$2 */
    public class AnonymousClass2 extends bd {
        final /* synthetic */ KsFeedAd.AdRenderListener fo;

        public AnonymousClass2(KsFeedAd.AdRenderListener adRenderListener) {
            adRenderListener = adRenderListener;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            adRenderListener.onAdRenderSuccess(c.this.f11503fh);
            com.kwad.components.ad.feed.monitor.b.a(2, c.this.mAdTemplate, com.kwad.sdk.core.response.b.a.bb(c.this.mAdInfo), c.this.fm.get());
        }
    }

    /* renamed from: com.kwad.components.ad.feed.c$3 */
    public class AnonymousClass3 implements a {
        final /* synthetic */ KsFeedAd.AdRenderListener fo;
        final /* synthetic */ int fp;
        final /* synthetic */ long fq;

        /* renamed from: com.kwad.components.ad.feed.c$3$1 */
        public class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                adRenderListener.onAdRenderSuccess(c.this.f11503fh);
                com.kwad.components.ad.feed.monitor.b.a(2, c.this.mAdTemplate, com.kwad.sdk.core.response.b.a.bb(c.this.mAdInfo), c.this.fm.get());
            }
        }

        public AnonymousClass3(int i10, long j10, KsFeedAd.AdRenderListener adRenderListener) {
            i10 = i10;
            elapsedRealtime = j10;
            adRenderListener = adRenderListener;
        }

        @Override // com.kwad.components.ad.feed.c.a
        public final void d(int i10, String str) {
            com.kwad.components.ad.feed.monitor.b.a(c.this.getAdTemplate(), i10, i10, SystemClock.elapsedRealtime() - elapsedRealtime, str);
            c.this.fm.set(i10);
            c.this.fl.set(true);
            try {
                if (adRenderListener != null) {
                    if (c.this.f11503fh == null) {
                        KsFeedAd.AdRenderListener adRenderListener = adRenderListener;
                        com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.azF;
                        adRenderListener.onAdRenderFailed(eVar.errorCode, eVar.msg);
                    } else {
                        bt.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.feed.c.3.1
                            public AnonymousClass1() {
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                adRenderListener.onAdRenderSuccess(c.this.f11503fh);
                                com.kwad.components.ad.feed.monitor.b.a(2, c.this.mAdTemplate, com.kwad.sdk.core.response.b.a.bb(c.this.mAdInfo), c.this.fm.get());
                            }
                        });
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.kwad.components.ad.feed.c$4 */
    public class AnonymousClass4 implements m.a {
        final /* synthetic */ a fs;

        public AnonymousClass4(a aVar) {
            aVar = aVar;
        }

        @Override // com.kwad.components.ad.feed.b.m.a
        public final void d(int i10, String str) {
            c cVar = c.this;
            cVar.a(cVar.f11503fh, false);
            c.this.fl.set(true);
            aVar.d(i10, str);
        }
    }

    /* renamed from: com.kwad.components.ad.feed.c$5 */
    public class AnonymousClass5 implements n.a {
        final /* synthetic */ a fs;

        public AnonymousClass5(a aVar) {
            aVar = aVar;
        }

        @Override // com.kwad.components.ad.feed.b.n.a
        public final void d(int i10, String str) {
            c cVar = c.this;
            cVar.a(cVar.f11503fh, false);
            c.this.fl.set(true);
            aVar.d(i10, str);
        }
    }

    /* renamed from: com.kwad.components.ad.feed.c$6 */
    public class AnonymousClass6 implements b.a {
        final /* synthetic */ boolean ft;
        final /* synthetic */ com.kwad.components.core.widget.b fu;

        public AnonymousClass6(boolean z10, com.kwad.components.core.widget.b bVar) {
            z10 = z10;
            bVar = bVar;
        }

        @Override // com.kwad.components.core.widget.b.a
        public final void onAdClicked() {
            if (c.this.f11502fg != null) {
                c.this.f11502fg.onAdClicked();
            }
            com.kwad.components.ad.feed.monitor.b.a(4, c.this.mAdTemplate, com.kwad.sdk.core.response.b.a.bb(c.this.mAdInfo), z10 ? 1 : 2);
        }

        @Override // com.kwad.components.core.widget.b.a
        public final void onAdShow() {
            com.kwad.components.ad.feed.monitor.b.j(c.this.mAdTemplate);
            com.kwad.sdk.commercial.d.c.bG(c.this.mAdTemplate);
            if (c.this.f11502fg != null) {
                c.this.f11502fg.onAdShow();
            }
            com.kwad.components.ad.feed.monitor.b.a(3, c.this.mAdTemplate, com.kwad.sdk.core.response.b.a.bb(c.this.mAdInfo), z10 ? 1 : 2);
            if (z10) {
                com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                a.C0484a c0484a = new a.C0484a();
                FeedType fromInt = FeedType.fromInt(c.this.mAdTemplate.type);
                if (fromInt == FeedType.FEED_TYPE_TEXT_NEW) {
                    fromInt = FeedType.FEED_TYPE_TEXT_BELOW;
                }
                c0484a.templateId = String.valueOf(fromInt.getType());
                bVar.b(c0484a);
                bVar.v(c.this.f11503fh.getHeight(), c.this.f11503fh.getWidth());
                com.kwad.components.core.s.b.sc().a(c.this.mAdTemplate, null, bVar);
            }
        }

        @Override // com.kwad.components.core.widget.b.a
        public final void onDislikeClicked() {
            if (c.this.f11502fg != null) {
                c.this.f11502fg.onDislikeClicked();
                try {
                    if (bVar.getParent() instanceof ViewGroup) {
                        ((ViewGroup) bVar.getParent()).removeView(bVar);
                    }
                } catch (Exception e10) {
                    com.kwad.sdk.core.d.c.printStackTrace(e10);
                }
            }
            com.kwad.components.ad.feed.monitor.b.a(5, c.this.mAdTemplate, com.kwad.sdk.core.response.b.a.bb(c.this.mAdInfo), z10 ? 1 : 2);
        }

        @Override // com.kwad.components.core.widget.b.a
        public final void onDownloadTipsDialogDismiss() {
            if (c.this.f11502fg != null) {
                try {
                    c.this.f11502fg.onDownloadTipsDialogDismiss();
                } catch (Throwable unused) {
                }
            }
        }

        @Override // com.kwad.components.core.widget.b.a
        public final void onDownloadTipsDialogShow() {
            if (c.this.f11502fg != null) {
                try {
                    c.this.f11502fg.onDownloadTipsDialogShow();
                } catch (Throwable unused) {
                }
            }
        }
    }

    public interface a {
        void d(int i10, String str);
    }

    public c(@NonNull AdResultData adResultData, boolean z10) {
        this.mAdResultData = adResultData;
        AdTemplate o10 = com.kwad.sdk.core.response.b.c.o(adResultData);
        this.mAdTemplate = o10;
        o10.mInitVoiceStatus = 1;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eb(o10);
        this.f11505fj = z10;
        this.bS = new KSAdVideoPlayConfigImpl();
        com.kwad.components.ad.j.b.fc().a(this);
    }

    @Nullable
    private com.kwad.components.core.widget.b<?, ?> B(Context context) {
        com.kwad.components.core.widget.b<?, ?> a10;
        int width = this.mAdTemplate.mAdScene.getWidth();
        if (width < com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.awA) * l.getScreenWidth(context)) {
            int be2 = com.kwad.sdk.core.response.b.a.be(this.mAdInfo);
            AdTemplate adTemplate = this.mAdTemplate;
            com.kwad.components.ad.feed.monitor.b.a(width, be2, adTemplate.type, adTemplate);
        }
        if (com.kwad.sdk.core.response.b.b.cW(this.mAdTemplate)) {
            n nVar = new n(com.kwad.sdk.n.m.wrapContextIfNeed(context));
            this.f11504fi = nVar;
            nVar.setWidth(width);
            this.f11504fi.setVideoPlayConfig(this.bS);
            a10 = this.f11504fi;
        } else if (this.f11505fj && com.kwad.sdk.core.response.b.b.cV(this.mAdTemplate)) {
            try {
                context = com.kwad.sdk.n.m.wrapContextIfNeed(context);
                m mVar = new m(context);
                mVar.setWidth(width);
                mVar.setVideoPlayConfig(this.bS);
                a10 = mVar;
            } catch (Throwable th2) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                a10 = null;
            }
        } else {
            a10 = b.a(context, FeedType.fromInt(this.mAdTemplate.type), com.kwad.sdk.core.response.b.a.be(this.mAdInfo));
        }
        if (a10 != null) {
            if (!(a10 instanceof n)) {
                a10.setMargin(com.kwad.sdk.c.a.a.a(context, 16.0f));
            }
            a10.setPageExitListener(this.f11501dk);
        }
        return a10;
    }

    private void br() {
        if (this.mAdTemplate != null) {
            com.kwad.sdk.core.diskcache.b.a.EG().remove("feed_ad_cache_" + this.mAdTemplate.posId);
        }
    }

    private boolean isVideoSoundEnable() {
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.bS;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0) {
                return kSAdVideoPlayConfigImpl.isVideoSoundEnable();
            }
        }
        return com.kwad.sdk.core.response.b.a.bZ(this.mAdInfo);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final int getECPM() {
        return com.kwad.sdk.core.response.b.a.aR(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsFeedAd
    public final View getFeedView2(Context context) {
        if (context == null || !com.kwad.sdk.l.At().zE()) {
            return null;
        }
        try {
            Context wrapContextIfNeed = com.kwad.sdk.n.m.wrapContextIfNeed(context);
            com.kwad.sdk.commercial.d.c.bF(this.mAdTemplate);
            com.kwad.components.core.widget.b bVar = this.f11503fh;
            if (bVar != null) {
                try {
                    if (bVar.getParent() instanceof ViewGroup) {
                        ((ViewGroup) this.f11503fh.getParent()).removeView(this.f11503fh);
                    }
                } catch (NullPointerException unused) {
                }
                return this.f11503fh;
            }
            br();
            this.mAdTemplate.loadType = 1;
            com.kwad.components.core.widget.b<?, ?> B = B(wrapContextIfNeed);
            this.f11503fh = B;
            if (B == null) {
                return null;
            }
            B.c((com.kwad.components.core.widget.b<?, ?>) this.mAdResultData);
            com.kwad.components.core.widget.b bVar2 = this.f11503fh;
            if (bVar2 instanceof com.kwad.components.ad.feed.b.c) {
                ((com.kwad.components.ad.feed.b.c) bVar2).b(this.bS);
            }
            com.kwad.components.core.widget.b bVar3 = this.f11503fh;
            if (bVar3 instanceof m) {
                a(bVar3, false);
            } else {
                a(bVar3, true);
            }
            return this.f11503fh;
        } catch (Throwable th2) {
            if (!com.kwad.sdk.l.At().zB()) {
                throw th2;
            }
            ServiceProvider.reportSdkCaughtException(th2);
            return null;
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final int getInteractionType() {
        return com.kwad.sdk.core.response.b.a.aQ(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final int getMaterialType() {
        return com.kwad.sdk.core.response.b.a.be(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public final Map<String, Object> getMediaExtraInfo() {
        HashMap hashMap = new HashMap();
        if (com.kwad.sdk.core.config.d.Dx()) {
            hashMap.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return hashMap;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void render(KsFeedAd.AdRenderListener adRenderListener) {
        if (this.fl.get()) {
            if (this.f11503fh != null) {
                bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.feed.c.2
                    final /* synthetic */ KsFeedAd.AdRenderListener fo;

                    public AnonymousClass2(KsFeedAd.AdRenderListener adRenderListener2) {
                        adRenderListener = adRenderListener2;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        adRenderListener.onAdRenderSuccess(c.this.f11503fh);
                        com.kwad.components.ad.feed.monitor.b.a(2, c.this.mAdTemplate, com.kwad.sdk.core.response.b.a.bb(c.this.mAdInfo), c.this.fm.get());
                    }
                });
                return;
            }
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.azF;
            adRenderListener2.onAdRenderFailed(eVar.errorCode, eVar.msg);
            this.fl.set(false);
            this.f11506fk.set(false);
            return;
        }
        if (this.f11506fk.get()) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.kwad.components.ad.feed.monitor.b.i(this.mAdTemplate);
        int i10 = com.kwad.sdk.core.response.b.b.cW(this.mAdTemplate) ? 3 : 2;
        this.f11506fk.set(true);
        a(new a() { // from class: com.kwad.components.ad.feed.c.3
            final /* synthetic */ KsFeedAd.AdRenderListener fo;
            final /* synthetic */ int fp;
            final /* synthetic */ long fq;

            /* renamed from: com.kwad.components.ad.feed.c$3$1 */
            public class AnonymousClass1 implements Runnable {
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                    adRenderListener.onAdRenderSuccess(c.this.f11503fh);
                    com.kwad.components.ad.feed.monitor.b.a(2, c.this.mAdTemplate, com.kwad.sdk.core.response.b.a.bb(c.this.mAdInfo), c.this.fm.get());
                }
            }

            public AnonymousClass3(int i102, long elapsedRealtime2, KsFeedAd.AdRenderListener adRenderListener2) {
                i10 = i102;
                elapsedRealtime = elapsedRealtime2;
                adRenderListener = adRenderListener2;
            }

            @Override // com.kwad.components.ad.feed.c.a
            public final void d(int i102, String str) {
                com.kwad.components.ad.feed.monitor.b.a(c.this.getAdTemplate(), i102, i10, SystemClock.elapsedRealtime() - elapsedRealtime, str);
                c.this.fm.set(i102);
                c.this.fl.set(true);
                try {
                    if (adRenderListener != null) {
                        if (c.this.f11503fh == null) {
                            KsFeedAd.AdRenderListener adRenderListener2 = adRenderListener;
                            com.kwad.sdk.core.network.e eVar2 = com.kwad.sdk.core.network.e.azF;
                            adRenderListener2.onAdRenderFailed(eVar2.errorCode, eVar2.msg);
                        } else {
                            bt.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.feed.c.3.1
                                public AnonymousClass1() {
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                    adRenderListener.onAdRenderSuccess(c.this.f11503fh);
                                    com.kwad.components.ad.feed.monitor.b.a(2, c.this.mAdTemplate, com.kwad.sdk.core.response.b.a.bb(c.this.mAdInfo), c.this.fm.get());
                                }
                            });
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void reportAdExposureFailed(int i10, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, i10, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void setAdInteractionListener(KsFeedAd.AdInteractionListener adInteractionListener) {
        this.f11502fg = adInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void setBidEcpm(int i10) {
        setBidEcpm(i10, -1L);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    @SuppressLint({"WrongConstant"})
    public final void setVideoPlayConfig(@Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0) {
                this.bS.setVideoSoundEnable(kSAdVideoPlayConfigImpl.isVideoSoundEnable());
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() != 0) {
                this.bS.setVideoAutoPlayType(kSAdVideoPlayConfigImpl.getVideoAutoPlayType());
            } else if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                this.bS.setDataFlowAutoStart(kSAdVideoPlayConfigImpl.isDataFlowAutoStart());
            } else {
                this.bS.setDataFlowAutoStart(com.kwad.sdk.core.config.d.DE());
                try {
                    this.bS.setVideoAutoPlayType(0);
                } catch (NoSuchMethodError unused) {
                } catch (Throwable th2) {
                    com.kwad.components.core.d.a.reportSdkCaughtException(th2);
                }
            }
            com.kwad.components.core.widget.b bVar = this.f11503fh;
            if (bVar instanceof m) {
                ((m) bVar).setVideoPlayConfig(this.bS);
            }
            com.kwad.components.core.widget.b bVar2 = this.f11503fh;
            if (bVar2 instanceof n) {
                ((n) bVar2).setVideoPlayConfig(this.bS);
            }
            com.kwad.components.core.widget.b bVar3 = this.f11503fh;
            if (bVar3 instanceof com.kwad.components.ad.feed.b.c) {
                ((com.kwad.components.ad.feed.b.c) bVar3).setVideoPlayConfig(this.bS);
            }
        }
        if (isVideoSoundEnable()) {
            this.mAdTemplate.mInitVoiceStatus = 2;
        } else {
            this.mAdTemplate.mInitVoiceStatus = 1;
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void setVideoSoundEnable(boolean z10) {
        this.bS.setVideoSoundEnable(z10);
        if (this.bS.isVideoSoundEnable()) {
            this.mAdTemplate.mInitVoiceStatus = 2;
        } else {
            this.mAdTemplate.mInitVoiceStatus = 1;
        }
    }

    @Override // com.kwad.components.core.internal.api.a
    public final boolean supportPushAd() {
        return true;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void b(com.kwad.components.core.internal.api.b bVar) {
        this.bz.b(bVar);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void setBidEcpm(long j10, long j11) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = j10;
        com.kwad.sdk.core.adlog.c.l(adTemplate, j11);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void a(com.kwad.components.core.internal.api.b bVar) {
        this.bz.a(bVar);
    }

    public final void a(@NonNull a aVar) {
        Context context = ServiceProvider.getContext();
        this.mAdTemplate.loadType = 2;
        this.f11506fk.set(true);
        com.kwad.components.core.widget.b<?, ?> B = B(context);
        this.f11503fh = B;
        if (B != null) {
            if (B instanceof m) {
                m mVar = (m) B;
                mVar.setPreloadListener(new m.a() { // from class: com.kwad.components.ad.feed.c.4
                    final /* synthetic */ a fs;

                    public AnonymousClass4(a aVar2) {
                        aVar = aVar2;
                    }

                    @Override // com.kwad.components.ad.feed.b.m.a
                    public final void d(int i10, String str) {
                        c cVar = c.this;
                        cVar.a(cVar.f11503fh, false);
                        c.this.fl.set(true);
                        aVar.d(i10, str);
                    }
                });
                mVar.c(this.mAdResultData);
                return;
            } else {
                if (B instanceof n) {
                    n nVar = (n) B;
                    nVar.setTKLoadListener(new n.a() { // from class: com.kwad.components.ad.feed.c.5
                        final /* synthetic */ a fs;

                        public AnonymousClass5(a aVar2) {
                            aVar = aVar2;
                        }

                        @Override // com.kwad.components.ad.feed.b.n.a
                        public final void d(int i10, String str) {
                            c cVar = c.this;
                            cVar.a(cVar.f11503fh, false);
                            c.this.fl.set(true);
                            aVar.d(i10, str);
                        }
                    });
                    nVar.c(this.mAdResultData);
                    return;
                }
                B.c((com.kwad.components.core.widget.b<?, ?>) this.mAdResultData);
                com.kwad.components.core.widget.b bVar = this.f11503fh;
                if (bVar instanceof com.kwad.components.ad.feed.b.c) {
                    ((com.kwad.components.ad.feed.b.c) bVar).b(this.bS);
                }
                a(this.f11503fh, true);
                this.fl.set(true);
                aVar2.d(1, "");
                return;
            }
        }
        this.fl.set(false);
        this.f11506fk.set(false);
        aVar2.d(1, "render Failed");
    }

    public void a(com.kwad.components.core.widget.b bVar, boolean z10) {
        if (bVar == null) {
            return;
        }
        bVar.setInnerAdInteractionListener(new b.a() { // from class: com.kwad.components.ad.feed.c.6
            final /* synthetic */ boolean ft;
            final /* synthetic */ com.kwad.components.core.widget.b fu;

            public AnonymousClass6(boolean z102, com.kwad.components.core.widget.b bVar2) {
                z10 = z102;
                bVar = bVar2;
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onAdClicked() {
                if (c.this.f11502fg != null) {
                    c.this.f11502fg.onAdClicked();
                }
                com.kwad.components.ad.feed.monitor.b.a(4, c.this.mAdTemplate, com.kwad.sdk.core.response.b.a.bb(c.this.mAdInfo), z10 ? 1 : 2);
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onAdShow() {
                com.kwad.components.ad.feed.monitor.b.j(c.this.mAdTemplate);
                com.kwad.sdk.commercial.d.c.bG(c.this.mAdTemplate);
                if (c.this.f11502fg != null) {
                    c.this.f11502fg.onAdShow();
                }
                com.kwad.components.ad.feed.monitor.b.a(3, c.this.mAdTemplate, com.kwad.sdk.core.response.b.a.bb(c.this.mAdInfo), z10 ? 1 : 2);
                if (z10) {
                    com.kwad.sdk.core.adlog.c.b bVar2 = new com.kwad.sdk.core.adlog.c.b();
                    a.C0484a c0484a = new a.C0484a();
                    FeedType fromInt = FeedType.fromInt(c.this.mAdTemplate.type);
                    if (fromInt == FeedType.FEED_TYPE_TEXT_NEW) {
                        fromInt = FeedType.FEED_TYPE_TEXT_BELOW;
                    }
                    c0484a.templateId = String.valueOf(fromInt.getType());
                    bVar2.b(c0484a);
                    bVar2.v(c.this.f11503fh.getHeight(), c.this.f11503fh.getWidth());
                    com.kwad.components.core.s.b.sc().a(c.this.mAdTemplate, null, bVar2);
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDislikeClicked() {
                if (c.this.f11502fg != null) {
                    c.this.f11502fg.onDislikeClicked();
                    try {
                        if (bVar.getParent() instanceof ViewGroup) {
                            ((ViewGroup) bVar.getParent()).removeView(bVar);
                        }
                    } catch (Exception e10) {
                        com.kwad.sdk.core.d.c.printStackTrace(e10);
                    }
                }
                com.kwad.components.ad.feed.monitor.b.a(5, c.this.mAdTemplate, com.kwad.sdk.core.response.b.a.bb(c.this.mAdInfo), z10 ? 1 : 2);
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogDismiss() {
                if (c.this.f11502fg != null) {
                    try {
                        c.this.f11502fg.onDownloadTipsDialogDismiss();
                    } catch (Throwable unused) {
                    }
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogShow() {
                if (c.this.f11502fg != null) {
                    try {
                        c.this.f11502fg.onDownloadTipsDialogShow();
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }
}
