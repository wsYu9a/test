package com.kwad.components.core.playable;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.e.d.c;
import com.kwad.components.core.webview.jshandler.af;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.al;
import com.kwad.components.core.webview.jshandler.ar;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.jshandler.bh;
import com.kwad.components.core.webview.jshandler.i;
import com.kwad.components.core.webview.jshandler.m;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.tachikoma.a.f;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.b;
import com.kwad.sdk.utils.bt;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public final class a implements o {
    private final KsAdWebView SV;
    private long SW;
    private int SX;
    private PlayableSource SY = PlayableSource.UNKNOWN_TRYPLAY_ENTRY_SOURCE;
    private List<ar.b> SZ = new CopyOnWriteArrayList();
    private List<KsAdWebView.e> Ta = new CopyOnWriteArrayList();

    /* renamed from: ea */
    @Nullable
    private com.kwad.components.core.webview.a f11938ea;

    /* renamed from: ed */
    private ay f11939ed;

    @Nullable
    private AdTemplate mAdTemplate;
    private c mApkDownloadHelper;
    private Context mContext;
    private AdBaseFrameLayout mRootContainer;

    /* renamed from: com.kwad.components.core.playable.a$1 */
    public class AnonymousClass1 implements View.OnTouchListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            a.this.SW = SystemClock.elapsedRealtime();
            a.this.SV.getClientConfig().bx(true);
            return false;
        }
    }

    /* renamed from: com.kwad.components.core.playable.a$2 */
    public class AnonymousClass2 implements KsAdWebView.e {
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.e
        public final void onPageFinished() {
            Iterator it = a.this.Ta.iterator();
            while (it.hasNext()) {
                ((KsAdWebView.e) it.next()).onPageFinished();
            }
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.e
        public final void onPageStart() {
            Iterator it = a.this.Ta.iterator();
            while (it.hasNext()) {
                ((KsAdWebView.e) it.next()).onPageStart();
            }
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.e
        public final void onReceivedHttpError(int i10, String str, String str2) {
            Iterator it = a.this.Ta.iterator();
            while (it.hasNext()) {
                ((KsAdWebView.e) it.next()).onReceivedHttpError(i10, str, str2);
            }
        }
    }

    /* renamed from: com.kwad.components.core.playable.a$3 */
    public class AnonymousClass3 implements ar.b {
        public AnonymousClass3() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ar.b
        public final void a(ar.a aVar) {
            a.this.SX = aVar.status;
            if (aVar.status == 1 && a.this.mAdTemplate != null) {
                com.kwad.sdk.core.adlog.c.bX(a.this.mAdTemplate);
            }
            Iterator it = a.this.SZ.iterator();
            while (it.hasNext()) {
                ((ar.b) it.next()).a(aVar);
            }
        }
    }

    /* renamed from: com.kwad.components.core.playable.a$4 */
    public class AnonymousClass4 implements Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        @SuppressLint({"SetTextI18n"})
        public final void run() {
            a.this.SV.getClientConfig().bx(true);
        }
    }

    /* renamed from: com.kwad.components.core.playable.a$a */
    public static class C0443a implements bh.b {
        private final WeakReference<a> Tc;

        public C0443a(a aVar) {
            this.Tc = new WeakReference<>(aVar);
        }

        @Override // com.kwad.components.core.webview.jshandler.bh.b
        public final void R(int i10) {
            a aVar = this.Tc.get();
            if (aVar != null) {
                aVar.aD(i10);
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public a(KsAdWebView ksAdWebView) {
        this.SV = ksAdWebView;
        ksAdWebView.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.core.playable.a.1
            public AnonymousClass1() {
            }

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                a.this.SW = SystemClock.elapsedRealtime();
                a.this.SV.getClientConfig().bx(true);
                return false;
            }
        });
        ksAdWebView.setClientConfig(ksAdWebView.getClientConfig().ex(this.mAdTemplate).b(iF()));
        a(ksAdWebView);
    }

    public void aD(int i10) {
        if (getAdTemplate() == null) {
            return;
        }
        long DR = d.DR();
        if (DR <= 0 || SystemClock.elapsedRealtime() - this.SW <= DR) {
            com.kwad.components.core.e.d.a.a(new a.C0427a(this.mContext).au(this.mAdTemplate).b(this.mApkDownloadHelper).ap(false).an(i10).d(this.mRootContainer.getTouchCoords()).ar(true));
        }
    }

    private void aZ() {
        com.kwad.components.core.webview.a aVar = this.f11938ea;
        if (aVar != null) {
            aVar.destroy();
            this.f11938ea = null;
        }
    }

    @Nullable
    private AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    private String getUrl() {
        AdTemplate adTemplate = this.mAdTemplate;
        return adTemplate == null ? "" : com.kwad.sdk.core.response.b.a.bP(e.eb(adTemplate));
    }

    private KsAdWebView.e iF() {
        return new KsAdWebView.e() { // from class: com.kwad.components.core.playable.a.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
                Iterator it = a.this.Ta.iterator();
                while (it.hasNext()) {
                    ((KsAdWebView.e) it.next()).onPageFinished();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageStart() {
                Iterator it = a.this.Ta.iterator();
                while (it.hasNext()) {
                    ((KsAdWebView.e) it.next()).onPageStart();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i10, String str, String str2) {
                Iterator it = a.this.Ta.iterator();
                while (it.hasNext()) {
                    ((KsAdWebView.e) it.next()).onReceivedHttpError(i10, str, str2);
                }
            }
        };
    }

    private void qt() {
        if (com.kwad.sdk.core.response.b.a.bL(e.eb(this.mAdTemplate)) > 0) {
            bt.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.core.playable.a.4
                public AnonymousClass4() {
                }

                @Override // java.lang.Runnable
                @SuppressLint({"SetTextI18n"})
                public final void run() {
                    a.this.SV.getClientConfig().bx(true);
                }
            }, com.kwad.sdk.core.response.b.a.bL(e.eb(this.mAdTemplate)));
        }
        if (com.kwad.sdk.core.response.b.a.bL(e.eb(this.mAdTemplate)) == 0) {
            this.SV.getClientConfig().bx(true);
        }
    }

    public final void e(PlayableSource playableSource) {
        if (playableSource != null) {
            this.SY = playableSource;
        }
        if (this.SV == null) {
            return;
        }
        qt();
        com.kwad.sdk.core.d.c.d("PlayableViewHelper", "showPlayable");
        ay ayVar = this.f11939ed;
        if (ayVar != null) {
            ayVar.tu();
        }
        this.SV.setVisibility(0);
        ay ayVar2 = this.f11939ed;
        if (ayVar2 != null) {
            ayVar2.tv();
        }
    }

    public final long getLoadTime() {
        KsAdWebView ksAdWebView = this.SV;
        if (ksAdWebView != null) {
            return ksAdWebView.getLoadTime();
        }
        return -1L;
    }

    public final void hU() {
        com.kwad.sdk.core.d.c.d("PlayableViewHelper", "showPlayable");
        if (this.SV == null) {
            return;
        }
        ay ayVar = this.f11939ed;
        if (ayVar != null) {
            ayVar.tw();
        }
        this.SV.setVisibility(8);
        ay ayVar2 = this.f11939ed;
        if (ayVar2 != null) {
            ayVar2.tx();
        }
        this.SV.reload();
    }

    public final void qU() {
        com.kwad.components.core.webview.a aVar = this.f11938ea;
        if (aVar != null) {
            aVar.destroy();
            this.f11938ea = null;
        }
    }

    public final void qV() {
        KsAdWebView ksAdWebView;
        if (this.mAdTemplate == null || (ksAdWebView = this.SV) == null) {
            return;
        }
        ksAdWebView.getClientConfig().bx(false);
        String url = getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.SV.loadUrl(url);
        }
        com.kwad.sdk.core.adlog.c.bY(this.mAdTemplate);
    }

    public final boolean qW() {
        return this.SV != null && this.SX == 1;
    }

    public final void b(@Nullable ar.b bVar) {
        this.SZ.remove(bVar);
    }

    private static void a(KsAdWebView ksAdWebView) {
        if (d.DQ()) {
            ksAdWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
    }

    @SuppressLint({"AddJavascriptInterface"})
    public final void a(AdTemplate adTemplate, AdBaseFrameLayout adBaseFrameLayout, c cVar) {
        if (this.SV == null) {
            com.kwad.sdk.core.d.c.w("PlayableViewHelper", "registerJsBridge mPlayableView is null");
            return;
        }
        this.mContext = adBaseFrameLayout.getContext();
        this.mRootContainer = adBaseFrameLayout;
        this.mAdTemplate = adTemplate;
        this.mApkDownloadHelper = cVar;
        this.SX = -1;
        b bVar = new b();
        bVar.setAdTemplate(adTemplate);
        bVar.mScreenOrientation = 0;
        AdBaseFrameLayout adBaseFrameLayout2 = this.mRootContainer;
        bVar.aIc = adBaseFrameLayout2;
        bVar.QI = adBaseFrameLayout2;
        bVar.Qc = this.SV;
        aZ();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.SV);
        this.f11938ea = aVar;
        a(bVar, aVar, cVar);
        this.SV.addJavascriptInterface(this.f11938ea, "KwaiAd");
    }

    public final void a(@Nullable ar.b bVar) {
        this.SZ.add(bVar);
    }

    public final void a(@Nullable KsAdWebView.e eVar) {
        this.Ta.add(eVar);
    }

    private void a(b bVar, com.kwad.components.core.webview.a aVar, c cVar) {
        aVar.a(new bh(bVar, cVar, new C0443a(this)));
        aVar.a(new ar(new ar.b() { // from class: com.kwad.components.core.playable.a.3
            public AnonymousClass3() {
            }

            @Override // com.kwad.components.core.webview.jshandler.ar.b
            public final void a(ar.a aVar2) {
                a.this.SX = aVar2.status;
                if (aVar2.status == 1 && a.this.mAdTemplate != null) {
                    com.kwad.sdk.core.adlog.c.bX(a.this.mAdTemplate);
                }
                Iterator it = a.this.SZ.iterator();
                while (it.hasNext()) {
                    ((ar.b) it.next()).a(aVar2);
                }
            }
        }, getUrl()));
        aVar.a(new al(bVar));
        aVar.b(new n(bVar));
        aVar.b(new m(bVar));
        this.f11939ed = new ay();
        aVar.a(new ag());
        aVar.a(new af(bVar));
        aVar.a(new f());
        aVar.a(this.f11939ed);
        aVar.a(new i(this));
    }

    @Override // com.kwad.components.core.webview.jshandler.o
    public final void a(i iVar, String str) {
        AdTemplate adTemplate;
        if ("playableSrc".equals(str)) {
            iVar.f(this.SY);
        }
        if (!"getAdType".equals(str) || (adTemplate = this.mAdTemplate) == null) {
            return;
        }
        iVar.aP(adTemplate.adStyle);
    }
}
