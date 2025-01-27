package com.kwad.components.ad.interstitial.c;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.interstitial.c.c;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.video.a;
import com.kwad.components.core.video.f;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.widget.KSFrameLayout;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class j extends b implements com.kwad.sdk.widget.c {
    private List<Integer> cI;

    @NonNull
    private KsAdVideoPlayConfig dZ;
    private ImageView eM;
    private com.kwad.sdk.core.video.videoview.a eN;
    private c jt;
    private KSFrameLayout ke;
    private KSFrameLayout kf;
    private com.kwad.components.core.video.f lp;
    protected AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;

    @NonNull
    protected Context mContext;

    @Nullable
    private boolean mIsAudioEnable = false;
    private h ko = new h() { // from class: com.kwad.components.ad.interstitial.c.j.1
        AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.interstitial.c.h
        public final void dA() {
            try {
                j.this.lp.pZ();
            } catch (Throwable unused) {
            }
        }

        @Override // com.kwad.components.ad.interstitial.c.h
        public final void dB() {
            try {
                j.this.lp.qb();
            } catch (Throwable unused) {
            }
        }
    };
    private final a.InterfaceC0187a eS = new a.InterfaceC0187a() { // from class: com.kwad.components.ad.interstitial.c.j.4

        /* renamed from: com.kwad.components.ad.interstitial.c.j$4$1 */
        final class AnonymousClass1 implements a.b {
            AnonymousClass1() {
            }

            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                j.this.eh();
            }
        }

        AnonymousClass4() {
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
        @Override // com.kwad.components.core.video.a.InterfaceC0187a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a(int r6, com.kwad.sdk.utils.ac.a r7) {
            /*
                r5 = this;
                r0 = 2
                r1 = 1
                r2 = 0
                if (r6 == r1) goto L15
                if (r6 == r0) goto L12
                r3 = 3
                if (r6 == r3) goto Ld
                r6 = 108(0x6c, float:1.51E-43)
                goto L17
            Ld:
                r6 = 83
                r2 = 1
                r3 = 1
                goto L18
            L12:
                r6 = 82
                goto L17
            L15:
                r6 = 13
            L17:
                r3 = 2
            L18:
                com.kwad.sdk.core.report.y$b r4 = new com.kwad.sdk.core.report.y$b
                r4.<init>()
                r4.jW = r7
                r4.jU = r6
                com.kwad.components.ad.interstitial.c.j r6 = com.kwad.components.ad.interstitial.c.j.this
                com.kwad.components.ad.interstitial.c.j.e(r6)
                boolean r6 = com.kwad.sdk.utils.ai.DL()
                if (r6 == 0) goto L2d
                goto L2e
            L2d:
                r0 = 1
            L2e:
                r4.ako = r0
                com.kwad.components.core.d.b.a$a r6 = new com.kwad.components.core.d.b.a$a
                com.kwad.components.ad.interstitial.c.j r7 = com.kwad.components.ad.interstitial.c.j.this
                android.content.Context r7 = com.kwad.components.ad.interstitial.c.j.h(r7)
                r6.<init>(r7)
                com.kwad.components.ad.interstitial.c.j r7 = com.kwad.components.ad.interstitial.c.j.this
                com.kwad.sdk.core.response.model.AdTemplate r7 = com.kwad.components.ad.interstitial.c.j.c(r7)
                com.kwad.components.core.d.b.a$a r6 = r6.I(r7)
                com.kwad.components.ad.interstitial.c.j r7 = com.kwad.components.ad.interstitial.c.j.this
                com.kwad.components.core.d.b.c r7 = com.kwad.components.ad.interstitial.c.j.g(r7)
                com.kwad.components.core.d.b.a$a r6 = r6.b(r7)
                com.kwad.components.core.d.b.a$a r6 = r6.ap(r3)
                com.kwad.components.core.d.b.a$a r6 = r6.ao(r2)
                com.kwad.components.core.d.b.a$a r6 = r6.aq(r1)
                com.kwad.components.core.d.b.a$a r6 = r6.a(r4)
                com.kwad.components.ad.interstitial.c.j$4$1 r7 = new com.kwad.components.ad.interstitial.c.j$4$1
                r7.<init>()
                com.kwad.components.core.d.b.a$a r6 = r6.a(r7)
                com.kwad.components.core.d.b.a.a(r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.interstitial.c.j.AnonymousClass4.a(int, com.kwad.sdk.utils.ac$a):void");
        }
    };

    /* renamed from: com.kwad.components.ad.interstitial.c.j$1 */
    final class AnonymousClass1 implements h {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.interstitial.c.h
        public final void dA() {
            try {
                j.this.lp.pZ();
            } catch (Throwable unused) {
            }
        }

        @Override // com.kwad.components.ad.interstitial.c.h
        public final void dB() {
            try {
                j.this.lp.qb();
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.j$2 */
    final class AnonymousClass2 implements f.a {
        private boolean cJ = false;

        AnonymousClass2() {
        }

        @Override // com.kwad.components.core.video.a.c
        public final void bt() {
            com.kwad.sdk.core.report.a.av(j.this.mAdTemplate);
            if (!j.this.jt.jy && j.this.jt.hN != null) {
                j.this.jt.hN.onVideoPlayEnd();
            }
            Iterator<a.c> it = j.this.jt.jF.iterator();
            while (it.hasNext()) {
                it.next().bt();
            }
            j.this.jt.jH = true;
        }

        @Override // com.kwad.components.core.video.a.c
        public final void d(long j2) {
            j.this.c(j2);
            Iterator<a.c> it = j.this.jt.jF.iterator();
            while (it.hasNext()) {
                it.next().d(j2);
            }
        }

        @Override // com.kwad.components.core.video.f.a
        public final void onVideoPlayError(int i2, int i3) {
            com.kwad.components.ad.interstitial.monitor.b.cR();
            com.kwad.components.ad.interstitial.monitor.b.a(j.this.mAdTemplate, i2, String.valueOf(i3));
            if (j.this.jt.hN != null) {
                j.this.jt.hN.onVideoPlayError(i2, i3);
            }
        }

        @Override // com.kwad.components.core.video.a.c
        public final void onVideoPlayStart() {
            com.kwad.sdk.core.report.a.h(j.this.mAdTemplate);
            com.kwad.components.ad.interstitial.monitor.b.cR();
            com.kwad.components.ad.interstitial.monitor.b.h(j.this.mAdTemplate);
            if (!j.this.jt.jy && j.this.jt.hN != null) {
                j.this.jt.hN.onVideoPlayStart();
            }
            Iterator<a.c> it = j.this.jt.jF.iterator();
            while (it.hasNext()) {
                it.next().onVideoPlayStart();
            }
            j.this.jt.jH = false;
        }

        @Override // com.kwad.components.core.video.a.c
        public final void onVideoPlaying() {
            if (!this.cJ) {
                this.cJ = true;
                com.kwad.components.core.m.a.pb().a(j.this.mAdTemplate, System.currentTimeMillis(), 0);
            }
            Iterator<a.c> it = j.this.jt.jF.iterator();
            while (it.hasNext()) {
                it.next().onVideoPlaying();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.j$3 */
    final class AnonymousClass3 implements c.d {
        AnonymousClass3() {
        }

        @Override // com.kwad.components.ad.interstitial.c.c.d
        public final void dh() {
            if (j.this.eN != null) {
                j.this.eN.restart();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.j$4 */
    final class AnonymousClass4 implements a.InterfaceC0187a {

        /* renamed from: com.kwad.components.ad.interstitial.c.j$4$1 */
        final class AnonymousClass1 implements a.b {
            AnonymousClass1() {
            }

            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                j.this.eh();
            }
        }

        AnonymousClass4() {
        }

        @Override // com.kwad.components.core.video.a.InterfaceC0187a
        public final void a(int i2, ac.a aVar) {
            /*
                this = this;
                r0 = 2
                r1 = 1
                r2 = 0
                if (r6 == r1) goto L15
                if (r6 == r0) goto L12
                r3 = 3
                if (r6 == r3) goto Ld
                r6 = 108(0x6c, float:1.51E-43)
                goto L17
            Ld:
                r6 = 83
                r2 = 1
                r3 = 1
                goto L18
            L12:
                r6 = 82
                goto L17
            L15:
                r6 = 13
            L17:
                r3 = 2
            L18:
                com.kwad.sdk.core.report.y$b r4 = new com.kwad.sdk.core.report.y$b
                r4.<init>()
                r4.jW = r7
                r4.jU = r6
                com.kwad.components.ad.interstitial.c.j r6 = com.kwad.components.ad.interstitial.c.j.this
                com.kwad.components.ad.interstitial.c.j.e(r6)
                boolean r6 = com.kwad.sdk.utils.ai.DL()
                if (r6 == 0) goto L2d
                goto L2e
            L2d:
                r0 = 1
            L2e:
                r4.ako = r0
                com.kwad.components.core.d.b.a$a r6 = new com.kwad.components.core.d.b.a$a
                com.kwad.components.ad.interstitial.c.j r7 = com.kwad.components.ad.interstitial.c.j.this
                android.content.Context r7 = com.kwad.components.ad.interstitial.c.j.h(r7)
                r6.<init>(r7)
                com.kwad.components.ad.interstitial.c.j r7 = com.kwad.components.ad.interstitial.c.j.this
                com.kwad.sdk.core.response.model.AdTemplate r7 = com.kwad.components.ad.interstitial.c.j.c(r7)
                com.kwad.components.core.d.b.a$a r6 = r6.I(r7)
                com.kwad.components.ad.interstitial.c.j r7 = com.kwad.components.ad.interstitial.c.j.this
                com.kwad.components.core.d.b.c r7 = com.kwad.components.ad.interstitial.c.j.g(r7)
                com.kwad.components.core.d.b.a$a r6 = r6.b(r7)
                com.kwad.components.core.d.b.a$a r6 = r6.ap(r3)
                com.kwad.components.core.d.b.a$a r6 = r6.ao(r2)
                com.kwad.components.core.d.b.a$a r6 = r6.aq(r1)
                com.kwad.components.core.d.b.a$a r6 = r6.a(r4)
                com.kwad.components.ad.interstitial.c.j$4$1 r7 = new com.kwad.components.ad.interstitial.c.j$4$1
                r7.<init>()
                com.kwad.components.core.d.b.a$a r6 = r6.a(r7)
                com.kwad.components.core.d.b.a.a(r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.interstitial.c.j.AnonymousClass4.a(int, com.kwad.sdk.utils.ac$a):void");
        }
    }

    private c.b a(View view, boolean z) {
        return new c.b(view.getContext()).k(z).a(this.ke.getTouchCoords()).C(3).D(85);
    }

    public void c(long j2) {
        int ceil = (int) Math.ceil(j2 / 1000.0f);
        List<Integer> list = this.cI;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.cI.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.report.a.a(this.mAdTemplate, ceil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    private void eg() {
        ImageView imageView;
        int i2;
        this.mIsAudioEnable = this.dZ.isVideoSoundEnable();
        String url = com.kwad.sdk.core.response.a.a.bi(this.mAdInfo).getUrl();
        if (TextUtils.isEmpty(url)) {
            imageView = this.eM;
            i2 = 8;
        } else {
            this.eM.setImageDrawable(null);
            KSImageLoader.loadImage(this.eM, url, this.mAdTemplate);
            imageView = this.eM;
            i2 = 0;
        }
        imageView.setVisibility(i2);
        int ux = com.kwad.sdk.core.config.d.ux();
        String E = com.kwad.sdk.core.response.a.a.E(this.mAdInfo);
        if (TextUtils.isEmpty(E)) {
            return;
        }
        if (ux < 0) {
            File aX = com.kwad.sdk.core.diskcache.a.a.vs().aX(E);
            E = (aX == null || !aX.exists()) ? null : aX.getAbsolutePath();
        } else if (ux != 0) {
            E = com.kwad.sdk.core.videocache.b.a.ba(this.mContext).cS(E);
        }
        if (TextUtils.isEmpty(E)) {
            return;
        }
        this.eN.a(new b.a(this.mAdTemplate).bs(E).bt(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.cc(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(new com.kwad.sdk.contentalliance.kwai.kwai.a(this.mAdTemplate, System.currentTimeMillis())).tR(), null);
        this.eN.setVideoSoundEnable(this.mIsAudioEnable);
        this.lp.setVideoPlayCallback(new f.a() { // from class: com.kwad.components.ad.interstitial.c.j.2
            private boolean cJ = false;

            AnonymousClass2() {
            }

            @Override // com.kwad.components.core.video.a.c
            public final void bt() {
                com.kwad.sdk.core.report.a.av(j.this.mAdTemplate);
                if (!j.this.jt.jy && j.this.jt.hN != null) {
                    j.this.jt.hN.onVideoPlayEnd();
                }
                Iterator<a.c> it = j.this.jt.jF.iterator();
                while (it.hasNext()) {
                    it.next().bt();
                }
                j.this.jt.jH = true;
            }

            @Override // com.kwad.components.core.video.a.c
            public final void d(long j2) {
                j.this.c(j2);
                Iterator<a.c> it = j.this.jt.jF.iterator();
                while (it.hasNext()) {
                    it.next().d(j2);
                }
            }

            @Override // com.kwad.components.core.video.f.a
            public final void onVideoPlayError(int i22, int i3) {
                com.kwad.components.ad.interstitial.monitor.b.cR();
                com.kwad.components.ad.interstitial.monitor.b.a(j.this.mAdTemplate, i22, String.valueOf(i3));
                if (j.this.jt.hN != null) {
                    j.this.jt.hN.onVideoPlayError(i22, i3);
                }
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                com.kwad.sdk.core.report.a.h(j.this.mAdTemplate);
                com.kwad.components.ad.interstitial.monitor.b.cR();
                com.kwad.components.ad.interstitial.monitor.b.h(j.this.mAdTemplate);
                if (!j.this.jt.jy && j.this.jt.hN != null) {
                    j.this.jt.hN.onVideoPlayStart();
                }
                Iterator<a.c> it = j.this.jt.jF.iterator();
                while (it.hasNext()) {
                    it.next().onVideoPlayStart();
                }
                j.this.jt.jH = false;
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlaying() {
                if (!this.cJ) {
                    this.cJ = true;
                    com.kwad.components.core.m.a.pb().a(j.this.mAdTemplate, System.currentTimeMillis(), 0);
                }
                Iterator<a.c> it = j.this.jt.jF.iterator();
                while (it.hasNext()) {
                    it.next().onVideoPlaying();
                }
            }
        });
        this.eN.setController(this.lp);
        this.kf.setClickable(true);
        new com.kwad.sdk.widget.f(this.kf.getContext(), this.kf, this);
        this.kf.addView(this.eN);
        this.jt.jD = new c.d() { // from class: com.kwad.components.ad.interstitial.c.j.3
            AnonymousClass3() {
            }

            @Override // com.kwad.components.ad.interstitial.c.c.d
            public final void dh() {
                if (j.this.eN != null) {
                    j.this.eN.restart();
                }
            }
        };
    }

    public void eh() {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        c cVar = this.jt;
        if (!cVar.jy && (adInteractionListener = cVar.hN) != null) {
            adInteractionListener.onAdClicked();
        }
        c cVar2 = this.jt;
        cVar2.jw = true;
        if (cVar2.jy) {
            return;
        }
        cVar2.cr();
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        this.jt.a(a(view, true));
    }

    @Override // com.kwad.components.ad.interstitial.c.b, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        c cVar = (c) Bh();
        this.jt = cVar;
        this.dZ = cVar.dZ;
        AdTemplate adTemplate = cVar.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        this.mAdInfo = cb;
        List<Integer> bd = com.kwad.sdk.core.response.a.a.bd(cb);
        this.cI = bd;
        com.kwad.sdk.core.video.videoview.a aVar = this.jt.eN;
        this.eN = aVar;
        aVar.setTag(bd);
        com.kwad.components.core.video.f fVar = new com.kwad.components.core.video.f(this.mContext, this.mAdTemplate, this.eN);
        this.lp = fVar;
        fVar.setDataFlowAutoStart(this.dZ.isDataFlowAutoStart());
        this.lp.setAdClickListener(this.eS);
        this.lp.qd();
        this.mApkDownloadHelper = this.jt.mApkDownloadHelper;
        eg();
        float dimension = getContext().getResources().getDimension(R.dimen.ksad_interstitial_card_radius);
        this.kf.setRadius(dimension, dimension, 0.0f, 0.0f);
        this.jt.a(this.ko);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        this.jt.a(a(view, false));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ke = (KSFrameLayout) getRootView().findViewById(R.id.ksad_container);
        this.kf = (KSFrameLayout) getRootView().findViewById(R.id.ksad_video_container);
        this.eM = (ImageView) getRootView().findViewById(R.id.ksad_video_first_frame_container);
        this.kf.setVisibility(4);
        this.mContext = getContext();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        c cVar = this.jt;
        cVar.jD = null;
        cVar.b(this.ko);
    }
}
