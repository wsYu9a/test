package com.kwad.components.ad.interstitial.f;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.interstitial.f.c;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.a;
import com.kwad.components.core.video.f;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.widget.KSFrameLayout;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class f extends b implements com.kwad.sdk.widget.c {

    @NonNull
    private KsAdVideoPlayConfig bS;

    /* renamed from: ci */
    private List<Integer> f11601ci;
    private com.kwad.sdk.core.video.videoview.a co;

    /* renamed from: gh */
    private ImageView f11602gh;
    private c kY;
    private KSFrameLayout lZ;
    protected AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    @NonNull
    protected Context mContext;

    /* renamed from: ma */
    private KSFrameLayout f11603ma;

    /* renamed from: mb */
    private com.kwad.components.core.video.f f11604mb;

    @Nullable
    private boolean mIsAudioEnable = false;
    private final a.InterfaceC0446a gl = new a.InterfaceC0446a() { // from class: com.kwad.components.ad.interstitial.f.f.3

        /* renamed from: com.kwad.components.ad.interstitial.f.f$3$1 */
        public class AnonymousClass1 implements a.b {
            final /* synthetic */ int cO;

            public AnonymousClass1(int i10) {
                r2 = i10;
            }

            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                f.this.h(r2);
            }
        }

        public AnonymousClass3() {
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        @Override // com.kwad.components.core.video.a.InterfaceC0446a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a(int r11, com.kwad.sdk.utils.ag.a r12) {
            /*
                r10 = this;
                r0 = 2
                r1 = 1
                r2 = 0
                if (r11 == r1) goto L16
                if (r11 == r0) goto L13
                r3 = 3
                if (r11 == r3) goto Le
                r11 = 108(0x6c, float:1.51E-43)
            Lc:
                r3 = 2
                goto L19
            Le:
                r11 = 83
                r2 = 1
                r3 = 1
                goto L19
            L13:
                r11 = 82
                goto Lc
            L16:
                r11 = 13
                goto Lc
            L19:
                com.kwad.components.ad.interstitial.f.f r4 = com.kwad.components.ad.interstitial.f.f.this
                com.kwad.components.ad.interstitial.f.f.d(r4)
                boolean r4 = com.kwad.sdk.utils.an.NS()
                if (r4 == 0) goto L25
                goto L26
            L25:
                r0 = 1
            L26:
                com.kwad.components.ad.interstitial.report.a r4 = com.kwad.components.ad.interstitial.report.a.ei()
                com.kwad.components.ad.interstitial.f.f r5 = com.kwad.components.ad.interstitial.f.f.this
                com.kwad.sdk.core.response.model.AdTemplate r5 = com.kwad.components.ad.interstitial.f.f.b(r5)
                r6 = 1
                long r8 = (long) r11
                r4.a(r5, r6, r8)
                com.kwad.components.core.e.d.a$a r4 = new com.kwad.components.core.e.d.a$a
                com.kwad.components.ad.interstitial.f.f r5 = com.kwad.components.ad.interstitial.f.f.this
                android.content.Context r5 = com.kwad.components.ad.interstitial.f.f.f(r5)
                r4.<init>(r5)
                com.kwad.components.ad.interstitial.f.f r5 = com.kwad.components.ad.interstitial.f.f.this
                com.kwad.sdk.core.response.model.AdTemplate r5 = com.kwad.components.ad.interstitial.f.f.b(r5)
                com.kwad.components.core.e.d.a$a r4 = r4.au(r5)
                com.kwad.components.ad.interstitial.f.f r5 = com.kwad.components.ad.interstitial.f.f.this
                com.kwad.components.core.e.d.c r5 = com.kwad.components.ad.interstitial.f.f.e(r5)
                com.kwad.components.core.e.d.a$a r4 = r4.b(r5)
                com.kwad.components.core.e.d.a$a r3 = r4.ao(r3)
                com.kwad.components.core.e.d.a$a r2 = r3.ap(r2)
                com.kwad.components.core.e.d.a$a r1 = r2.ar(r1)
                com.kwad.components.core.e.d.a$a r1 = r1.an(r11)
                com.kwad.components.core.e.d.a$a r12 = r1.d(r12)
                com.kwad.components.core.e.d.a$a r12 = r12.ap(r0)
                com.kwad.components.ad.interstitial.f.f$3$1 r0 = new com.kwad.components.ad.interstitial.f.f$3$1
                r0.<init>()
                com.kwad.components.core.e.d.a$a r11 = r12.a(r0)
                com.kwad.components.core.e.d.a.a(r11)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.interstitial.f.f.AnonymousClass3.a(int, com.kwad.sdk.utils.ag$a):void");
        }
    };

    /* renamed from: com.kwad.components.ad.interstitial.f.f$1 */
    public class AnonymousClass1 implements f.a {
        private boolean dP = false;

        /* renamed from: mc */
        final /* synthetic */ long f11605mc;

        public AnonymousClass1(long j10) {
            r2 = j10;
        }

        @Override // com.kwad.components.core.video.a.c
        public final void ap() {
            if (!this.dP) {
                this.dP = true;
                com.kwad.components.core.o.a.ri().b(f.this.mAdTemplate, System.currentTimeMillis(), 0);
            }
            Iterator<a.c> it = f.this.kY.f11597lj.iterator();
            while (it.hasNext()) {
                it.next().ap();
            }
        }

        @Override // com.kwad.components.core.video.a.c
        public final void aq() {
            com.kwad.sdk.core.adlog.c.bT(f.this.mAdTemplate);
            if (!f.this.kY.f11590lc && f.this.kY.jr != null) {
                f.this.kY.jr.onVideoPlayEnd();
            }
            Iterator<a.c> it = f.this.kY.f11597lj.iterator();
            while (it.hasNext()) {
                it.next().aq();
            }
            f.this.kY.ll = true;
        }

        @Override // com.kwad.components.core.video.a.c
        public final void d(long j10) {
            f.this.c(j10);
            Iterator<a.c> it = f.this.kY.f11597lj.iterator();
            while (it.hasNext()) {
                it.next().d(j10);
            }
        }

        @Override // com.kwad.components.core.video.f.a
        public final void onVideoPlayError(int i10, int i11) {
            com.kwad.components.ad.interstitial.report.d.eo().b(f.this.mAdTemplate, i10, String.valueOf(i11));
            if (f.this.kY.jr != null) {
                f.this.kY.jr.onVideoPlayError(i10, i11);
            }
        }

        @Override // com.kwad.components.core.video.a.c
        public final void onVideoPlayStart() {
            com.kwad.sdk.core.adlog.c.bS(f.this.mAdTemplate);
            com.kwad.components.ad.interstitial.report.d.eo().a(f.this.mAdTemplate, System.currentTimeMillis() - r2);
            com.kwad.components.ad.interstitial.report.b.ek().s(f.this.mAdTemplate);
            if (!f.this.kY.f11590lc && f.this.kY.jr != null) {
                f.this.kY.jr.onVideoPlayStart();
            }
            Iterator<a.c> it = f.this.kY.f11597lj.iterator();
            while (it.hasNext()) {
                it.next().onVideoPlayStart();
            }
            f.this.kY.ll = false;
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.f.f$2 */
    public class AnonymousClass2 implements c.d {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.interstitial.f.c.d
        public final void dw() {
            if (f.this.co != null) {
                f.this.co.restart();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.f.f$3 */
    public class AnonymousClass3 implements a.InterfaceC0446a {

        /* renamed from: com.kwad.components.ad.interstitial.f.f$3$1 */
        public class AnonymousClass1 implements a.b {
            final /* synthetic */ int cO;

            public AnonymousClass1(int i10) {
                r2 = i10;
            }

            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                f.this.h(r2);
            }
        }

        public AnonymousClass3() {
        }

        @Override // com.kwad.components.core.video.a.InterfaceC0446a
        public final void a(int i10, ag.a aVar) {
            /*
                this = this;
                r0 = 2
                r1 = 1
                r2 = 0
                if (r11 == r1) goto L16
                if (r11 == r0) goto L13
                r3 = 3
                if (r11 == r3) goto Le
                r11 = 108(0x6c, float:1.51E-43)
            Lc:
                r3 = 2
                goto L19
            Le:
                r11 = 83
                r2 = 1
                r3 = 1
                goto L19
            L13:
                r11 = 82
                goto Lc
            L16:
                r11 = 13
                goto Lc
            L19:
                com.kwad.components.ad.interstitial.f.f r4 = com.kwad.components.ad.interstitial.f.f.this
                com.kwad.components.ad.interstitial.f.f.d(r4)
                boolean r4 = com.kwad.sdk.utils.an.NS()
                if (r4 == 0) goto L25
                goto L26
            L25:
                r0 = 1
            L26:
                com.kwad.components.ad.interstitial.report.a r4 = com.kwad.components.ad.interstitial.report.a.ei()
                com.kwad.components.ad.interstitial.f.f r5 = com.kwad.components.ad.interstitial.f.f.this
                com.kwad.sdk.core.response.model.AdTemplate r5 = com.kwad.components.ad.interstitial.f.f.b(r5)
                r6 = 1
                long r8 = (long) r11
                r4.a(r5, r6, r8)
                com.kwad.components.core.e.d.a$a r4 = new com.kwad.components.core.e.d.a$a
                com.kwad.components.ad.interstitial.f.f r5 = com.kwad.components.ad.interstitial.f.f.this
                android.content.Context r5 = com.kwad.components.ad.interstitial.f.f.f(r5)
                r4.<init>(r5)
                com.kwad.components.ad.interstitial.f.f r5 = com.kwad.components.ad.interstitial.f.f.this
                com.kwad.sdk.core.response.model.AdTemplate r5 = com.kwad.components.ad.interstitial.f.f.b(r5)
                com.kwad.components.core.e.d.a$a r4 = r4.au(r5)
                com.kwad.components.ad.interstitial.f.f r5 = com.kwad.components.ad.interstitial.f.f.this
                com.kwad.components.core.e.d.c r5 = com.kwad.components.ad.interstitial.f.f.e(r5)
                com.kwad.components.core.e.d.a$a r4 = r4.b(r5)
                com.kwad.components.core.e.d.a$a r3 = r4.ao(r3)
                com.kwad.components.core.e.d.a$a r2 = r3.ap(r2)
                com.kwad.components.core.e.d.a$a r1 = r2.ar(r1)
                com.kwad.components.core.e.d.a$a r1 = r1.an(r11)
                com.kwad.components.core.e.d.a$a r12 = r1.d(r12)
                com.kwad.components.core.e.d.a$a r12 = r12.ap(r0)
                com.kwad.components.ad.interstitial.f.f$3$1 r0 = new com.kwad.components.ad.interstitial.f.f$3$1
                r0.<init>()
                com.kwad.components.core.e.d.a$a r11 = r12.a(r0)
                com.kwad.components.core.e.d.a.a(r11)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.interstitial.f.f.AnonymousClass3.a(int, com.kwad.sdk.utils.ag$a):void");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x009c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void dR() {
        /*
            Method dump skipped, instructions count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.interstitial.f.f.dR():void");
    }

    public void h(long j10) {
        c cVar = this.kY;
        cVar.f11588la = true;
        cVar.b(1L, j10);
    }

    @Override // com.kwad.components.ad.interstitial.f.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        c cVar = (c) Lj();
        this.kY = cVar;
        this.bS = cVar.bS;
        AdTemplate adTemplate = cVar.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        this.mAdInfo = eb2;
        List<Integer> bo = com.kwad.sdk.core.response.b.a.bo(eb2);
        this.f11601ci = bo;
        com.kwad.sdk.core.video.videoview.a aVar = this.kY.co;
        this.co = aVar;
        aVar.setTag(bo);
        com.kwad.components.core.video.f fVar = new com.kwad.components.core.video.f(this.mContext, this.mAdTemplate, this.co);
        this.f11604mb = fVar;
        fVar.setDataFlowAutoStart(this.bS.isDataFlowAutoStart());
        this.f11604mb.setAdClickListener(this.gl);
        this.f11604mb.su();
        this.mApkDownloadHelper = this.kY.mApkDownloadHelper;
        dR();
        float dimension = getContext().getResources().getDimension(R.dimen.ksad_interstitial_card_radius);
        this.f11603ma.setRadius(dimension, dimension, 0.0f, 0.0f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.lZ = (KSFrameLayout) getRootView().findViewById(R.id.ksad_container);
        this.f11603ma = (KSFrameLayout) getRootView().findViewById(R.id.ksad_video_container);
        this.f11602gh = (ImageView) getRootView().findViewById(R.id.ksad_video_first_frame_container);
        this.f11603ma.setVisibility(4);
        this.mContext = getContext();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.kY.f11595lh = null;
    }

    public void c(long j10) {
        int ceil = (int) Math.ceil(j10 / 1000.0f);
        List<Integer> list = this.f11601ci;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.f11601ci.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, ceil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    private c.b a(View view, boolean z10) {
        return new c.b(view.getContext()).l(z10).a(this.lZ.getTouchCoords()).z(3).A(85);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        this.kY.a(a(view, false));
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        this.kY.a(a(view, true));
    }
}
