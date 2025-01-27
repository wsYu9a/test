package com.kwad.components.ad.splashscreen;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.d.b.a;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bh;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class h extends com.kwad.sdk.mvp.a {

    @Nullable
    public com.kwad.components.ad.splashscreen.d.a BG;
    public com.kwad.sdk.core.g.a BH;
    private List<g> BI = new CopyOnWriteArrayList();
    private List<f> BJ = new CopyOnWriteArrayList();
    private boolean BK = false;
    public boolean BL = false;
    public boolean BM = false;
    private KsSplashScreenAd.SplashScreenAdInteractionListener Bx;
    public int Bz;

    @NonNull
    public SceneImpl mAdScene;
    public com.kwad.components.core.d.b.c mApkDownloadHelper;

    @NonNull
    public AdBaseFrameLayout mRootContainer;
    public bh mTimerHelper;

    @NonNull
    public KsVideoPlayConfig mVideoPlayConfig;

    /* renamed from: com.kwad.components.ad.splashscreen.h$1 */
    final class AnonymousClass1 implements a.b {
        final /* synthetic */ a BN;
        final /* synthetic */ int eK;

        AnonymousClass1(int i2, a aVar) {
            i3 = i2;
            aVar = aVar;
        }

        @Override // com.kwad.components.core.d.b.a.b
        public final void onAdClicked() {
            if (h.this.Bx != null) {
                h.this.Bx.onAdClicked();
            }
            JSONObject jSONObject = new JSONObject();
            try {
                com.kwad.components.ad.splashscreen.d.a aVar = h.this.BG;
                if (aVar != null) {
                    jSONObject.put("duration", aVar.getCurrentPosition());
                }
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.b.printStackTrace(e2);
            }
            i c2 = new i().bj(i3).c(h.this.mRootContainer.getTouchCoords());
            com.kwad.sdk.core.report.a.a(h.this.mAdTemplate, c2, jSONObject);
            a aVar2 = aVar;
            if (aVar2 != null) {
                aVar2.b(c2);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.h$2 */
    final class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.kwad.components.core.d.a.b.mF()) {
                h.this.mRootContainer.postDelayed(this, 1000L);
            } else {
                h.this.kx();
            }
        }
    }

    public interface a {
        void b(@NonNull i iVar);
    }

    public static boolean a(Context context, long j2, AdInfo adInfo) {
        return com.kwad.sdk.core.response.a.b.cF(adInfo) && com.kwad.sdk.core.response.a.a.aV(adInfo) && !com.kwad.components.ad.splashscreen.local.b.b(context, j2, adInfo);
    }

    private void kA() {
        Iterator<f> it = this.BJ.iterator();
        while (it.hasNext()) {
            it.next().ks();
        }
    }

    private void kz() {
        Iterator<g> it = this.BI.iterator();
        while (it.hasNext()) {
            it.next().kt();
        }
    }

    public final void a(int i2, Context context, int i3, int i4, a aVar) {
        com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        com.kwad.components.core.d.b.a.a(new a.C0172a(context).I(this.mAdTemplate).b(this.mApkDownloadHelper).ap(i4).ao(false).ao(i3).an(i2).a(new a.b() { // from class: com.kwad.components.ad.splashscreen.h.1
            final /* synthetic */ a BN;
            final /* synthetic */ int eK;

            AnonymousClass1(int i32, a aVar2) {
                i3 = i32;
                aVar = aVar2;
            }

            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                if (h.this.Bx != null) {
                    h.this.Bx.onAdClicked();
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    com.kwad.components.ad.splashscreen.d.a aVar2 = h.this.BG;
                    if (aVar2 != null) {
                        jSONObject.put("duration", aVar2.getCurrentPosition());
                    }
                } catch (JSONException e2) {
                    com.kwad.sdk.core.d.b.printStackTrace(e2);
                }
                i c2 = new i().bj(i3).c(h.this.mRootContainer.getTouchCoords());
                com.kwad.sdk.core.report.a.a(h.this.mAdTemplate, c2, jSONObject);
                a aVar22 = aVar;
                if (aVar22 != null) {
                    aVar22.b(c2);
                }
            }
        }));
    }

    public final void a(f fVar) {
        if (fVar == null) {
            return;
        }
        this.BJ.add(fVar);
    }

    public final void a(g gVar) {
        this.BI.add(gVar);
    }

    public final void ab(int i2) {
        Iterator<g> it = this.BI.iterator();
        while (it.hasNext()) {
            it.next().aa(i2);
        }
    }

    public final void b(f fVar) {
        if (fVar == null) {
            return;
        }
        this.BJ.remove(fVar);
    }

    public final void b(g gVar) {
        this.BI.remove(gVar);
    }

    public final void c(int i2, Context context, int i3, int i4) {
        a(i2, context, i3, i4, null);
    }

    @MainThread
    public final void f(int i2, String str) {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Bx;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowError(0, str);
        }
        com.kwad.components.splash.monitor.a.rY();
        com.kwad.components.splash.monitor.a.d(this.mAdTemplate, 0, String.valueOf(str));
        kz();
    }

    public final void kB() {
        this.mRootContainer.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.h.2
            AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (com.kwad.components.core.d.a.b.mF()) {
                    h.this.mRootContainer.postDelayed(this, 1000L);
                } else {
                    h.this.kx();
                }
            }
        });
    }

    @MainThread
    public final void ku() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Bx;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdClicked();
        }
    }

    @MainThread
    public final void kv() {
        com.kwad.components.splash.monitor.a.rY();
        com.kwad.components.splash.monitor.a.g(this.mAdTemplate, SystemClock.elapsedRealtime() - this.mAdTemplate.showStartTime);
        com.kwad.components.ad.splashscreen.monitor.a.kC();
        com.kwad.sdk.kwai.kwai.c.sZ().aU(true);
        bh bhVar = this.mTimerHelper;
        if (bhVar != null) {
            bhVar.startTiming();
        }
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Bx;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowStart();
        }
    }

    @MainThread
    public final void kw() {
        if (this.BK) {
            return;
        }
        this.BK = true;
        if (!a(this.mRootContainer.getContext(), com.kwad.sdk.core.response.a.d.bU(this.mAdTemplate), com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate)) || this.mAdTemplate.converted) {
            y.a aVar = new y.a();
            bh bhVar = this.mTimerHelper;
            if (bhVar != null) {
                aVar.duration = bhVar.getTime();
            }
            com.kwad.sdk.core.report.a.b(this.mAdTemplate, new i().bk(14).bp(22).a(aVar), (JSONObject) null);
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Bx;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowEnd();
            }
        } else {
            kA();
        }
        kz();
    }

    @MainThread
    public final void kx() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Bx;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowEnd();
        }
    }

    @MainThread
    public final void ky() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Bx;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onSkippedAd();
        }
        kz();
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        com.kwad.components.ad.splashscreen.d.a aVar = this.BG;
        if (aVar != null) {
            aVar.release();
        }
        com.kwad.sdk.core.g.a aVar2 = this.BH;
        if (aVar2 != null) {
            aVar2.release();
        }
    }

    public final void setSplashScreenAdListener(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        this.Bx = splashScreenAdInteractionListener;
    }
}
