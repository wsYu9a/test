package com.kwad.components.core.playable;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.d.b.c;
import com.kwad.components.core.webview.a.kwai.f;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.av;
import com.kwad.components.core.webview.jshandler.e;
import com.kwad.components.core.webview.jshandler.i;
import com.kwad.components.core.webview.jshandler.w;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.b;
import com.kwad.sdk.utils.bi;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public final class a implements i {
    private final KsAdWebView NL;
    private long NM;
    private int NN;
    private PlayableSource NO = PlayableSource.UNKNOWN_TRYPLAY_ENTRY_SOURCE;
    private List<ai.b> NP = new CopyOnWriteArrayList();
    private List<KsAdWebView.d> NQ = new CopyOnWriteArrayList();

    @Nullable
    private com.kwad.components.core.webview.a cU;

    @Nullable
    private AdTemplate mAdTemplate;
    private c mApkDownloadHelper;
    private an mCardLifecycleHandler;
    private Context mContext;
    private AdBaseFrameLayout mRootContainer;

    /* renamed from: com.kwad.components.core.playable.a$1 */
    final class AnonymousClass1 implements View.OnTouchListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            a.this.NM = SystemClock.elapsedRealtime();
            a.this.NL.getClientConfig().bc(true);
            return false;
        }
    }

    /* renamed from: com.kwad.components.core.playable.a$2 */
    final class AnonymousClass2 implements KsAdWebView.d {
        AnonymousClass2() {
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.d
        public final void onPageFinished() {
            Iterator it = a.this.NQ.iterator();
            while (it.hasNext()) {
                ((KsAdWebView.d) it.next()).onPageFinished();
            }
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.d
        public final void onPageStart() {
            Iterator it = a.this.NQ.iterator();
            while (it.hasNext()) {
                ((KsAdWebView.d) it.next()).onPageStart();
            }
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.d
        public final void onReceivedHttpError(int i2, String str, String str2) {
            Iterator it = a.this.NQ.iterator();
            while (it.hasNext()) {
                ((KsAdWebView.d) it.next()).onReceivedHttpError(i2, str, str2);
            }
        }
    }

    /* renamed from: com.kwad.components.core.playable.a$3 */
    final class AnonymousClass3 implements ai.b {
        AnonymousClass3() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ai.b
        public final void a(ai.a aVar) {
            a.this.NN = aVar.status;
            if (aVar.status == 1 && a.this.mAdTemplate != null) {
                com.kwad.sdk.core.report.a.az(a.this.mAdTemplate);
            }
            Iterator it = a.this.NP.iterator();
            while (it.hasNext()) {
                ((ai.b) it.next()).a(aVar);
            }
        }
    }

    /* renamed from: com.kwad.components.core.playable.a$4 */
    final class AnonymousClass4 implements Runnable {
        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        @SuppressLint({"SetTextI18n"})
        public final void run() {
            a.this.NL.getClientConfig().bc(true);
        }
    }

    /* renamed from: com.kwad.components.core.playable.a$a */
    static class C0186a implements av.b {
        private final WeakReference<a> NS;

        public C0186a(a aVar) {
            this.NS = new WeakReference<>(aVar);
        }

        @Override // com.kwad.components.core.webview.jshandler.av.b
        public final void S(int i2) {
            a aVar = this.NS.get();
            if (aVar != null) {
                aVar.aA(i2);
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public a(KsAdWebView ksAdWebView) {
        this.NL = ksAdWebView;
        ksAdWebView.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.core.playable.a.1
            AnonymousClass1() {
            }

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                a.this.NM = SystemClock.elapsedRealtime();
                a.this.NL.getClientConfig().bc(true);
                return false;
            }
        });
        ksAdWebView.setClientConfig(ksAdWebView.getClientConfig().ct(this.mAdTemplate).b(getWebListener()));
        a(ksAdWebView);
    }

    private static void a(KsAdWebView ksAdWebView) {
        if (Build.VERSION.SDK_INT < 17 || !d.uJ()) {
            return;
        }
        ksAdWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
    }

    private void a(b bVar, com.kwad.components.core.webview.a aVar, c cVar) {
        aVar.a(new av(bVar, cVar, new C0186a(this)));
        aVar.a(new ai(new ai.b() { // from class: com.kwad.components.core.playable.a.3
            AnonymousClass3() {
            }

            @Override // com.kwad.components.core.webview.jshandler.ai.b
            public final void a(ai.a aVar2) {
                a.this.NN = aVar2.status;
                if (aVar2.status == 1 && a.this.mAdTemplate != null) {
                    com.kwad.sdk.core.report.a.az(a.this.mAdTemplate);
                }
                Iterator it = a.this.NP.iterator();
                while (it.hasNext()) {
                    ((ai.b) it.next()).a(aVar2);
                }
            }
        }, getUrl()));
        aVar.a(new ac(bVar));
        this.mCardLifecycleHandler = new an();
        aVar.a(new x());
        aVar.a(new w(bVar));
        aVar.a(new f());
        aVar.a(this.mCardLifecycleHandler);
        aVar.a(new e(this));
    }

    public void aA(int i2) {
        if (getAdTemplate() == null) {
            return;
        }
        long uK = d.uK();
        if (uK <= 0 || SystemClock.elapsedRealtime() - this.NM <= uK) {
            y.b bVar = new y.b();
            bVar.jU = i2;
            bVar.jW = this.mRootContainer.getTouchCoords();
            com.kwad.components.core.d.b.a.a(new a.C0172a(this.mContext).I(this.mAdTemplate).b(this.mApkDownloadHelper).ao(false).a(bVar).aq(true));
        }
    }

    private void aI() {
        com.kwad.components.core.webview.a aVar = this.cU;
        if (aVar != null) {
            aVar.destroy();
            this.cU = null;
        }
    }

    @Nullable
    private AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    private String getUrl() {
        AdTemplate adTemplate = this.mAdTemplate;
        return adTemplate == null ? "" : com.kwad.sdk.core.response.a.a.bB(com.kwad.sdk.core.response.a.d.cb(adTemplate));
    }

    private KsAdWebView.d getWebListener() {
        return new KsAdWebView.d() { // from class: com.kwad.components.core.playable.a.2
            AnonymousClass2() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
                Iterator it = a.this.NQ.iterator();
                while (it.hasNext()) {
                    ((KsAdWebView.d) it.next()).onPageFinished();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageStart() {
                Iterator it = a.this.NQ.iterator();
                while (it.hasNext()) {
                    ((KsAdWebView.d) it.next()).onPageStart();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i2, String str, String str2) {
                Iterator it = a.this.NQ.iterator();
                while (it.hasNext()) {
                    ((KsAdWebView.d) it.next()).onReceivedHttpError(i2, str, str2);
                }
            }
        };
    }

    private void ow() {
        if (com.kwad.sdk.core.response.a.a.bx(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate)) > 0) {
            bi.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.core.playable.a.4
                AnonymousClass4() {
                }

                @Override // java.lang.Runnable
                @SuppressLint({"SetTextI18n"})
                public final void run() {
                    a.this.NL.getClientConfig().bc(true);
                }
            }, com.kwad.sdk.core.response.a.a.bx(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate)));
        }
        if (com.kwad.sdk.core.response.a.a.bx(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate)) == 0) {
            this.NL.getClientConfig().bc(true);
        }
    }

    public final void a(@Nullable ai.b bVar) {
        this.NP.add(bVar);
    }

    @Override // com.kwad.components.core.webview.jshandler.i
    public final void a(e eVar, String str) {
        AdTemplate adTemplate;
        if ("playableSrc".equals(str)) {
            eVar.f(this.NO);
        }
        if (!"getAdType".equals(str) || (adTemplate = this.mAdTemplate) == null) {
            return;
        }
        eVar.aO(adTemplate.adStyle);
    }

    @SuppressLint({"AddJavascriptInterface"})
    public final void a(AdTemplate adTemplate, AdBaseFrameLayout adBaseFrameLayout, c cVar) {
        if (this.NL == null) {
            com.kwad.sdk.core.d.b.w("PlayableViewHelper", "registerJsBridge mPlayableView is null");
            return;
        }
        this.mContext = adBaseFrameLayout.getContext();
        this.mRootContainer = adBaseFrameLayout;
        this.mAdTemplate = adTemplate;
        this.mApkDownloadHelper = cVar;
        this.NN = -1;
        b bVar = new b();
        bVar.setAdTemplate(adTemplate);
        bVar.mScreenOrientation = 0;
        AdBaseFrameLayout adBaseFrameLayout2 = this.mRootContainer;
        bVar.app = adBaseFrameLayout2;
        bVar.LD = adBaseFrameLayout2;
        bVar.Lc = this.NL;
        aI();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.NL);
        this.cU = aVar;
        a(bVar, aVar, cVar);
        this.NL.addJavascriptInterface(this.cU, "KwaiAd");
    }

    public final void a(@Nullable KsAdWebView.d dVar) {
        this.NQ.add(dVar);
    }

    public final void b(@Nullable ai.b bVar) {
        this.NP.remove(bVar);
    }

    public final void e(PlayableSource playableSource) {
        if (playableSource != null) {
            this.NO = playableSource;
        }
        if (this.NL == null) {
            return;
        }
        ow();
        com.kwad.sdk.core.d.b.d("PlayableViewHelper", "showPlayable");
        an anVar = this.mCardLifecycleHandler;
        if (anVar != null) {
            anVar.qZ();
        }
        this.NL.setVisibility(0);
        an anVar2 = this.mCardLifecycleHandler;
        if (anVar2 != null) {
            anVar2.ra();
        }
    }

    public final long getLoadTime() {
        KsAdWebView ksAdWebView = this.NL;
        if (ksAdWebView != null) {
            return ksAdWebView.getLoadTime();
        }
        return -1L;
    }

    public final void hA() {
        com.kwad.sdk.core.d.b.d("PlayableViewHelper", "showPlayable");
        if (this.NL == null) {
            return;
        }
        an anVar = this.mCardLifecycleHandler;
        if (anVar != null) {
            anVar.rb();
        }
        this.NL.setVisibility(8);
        an anVar2 = this.mCardLifecycleHandler;
        if (anVar2 != null) {
            anVar2.rc();
        }
        this.NL.reload();
    }

    public final void oW() {
        com.kwad.components.core.webview.a aVar = this.cU;
        if (aVar != null) {
            aVar.destroy();
            this.cU = null;
        }
    }

    public final void oX() {
        KsAdWebView ksAdWebView;
        if (this.mAdTemplate == null || (ksAdWebView = this.NL) == null) {
            return;
        }
        ksAdWebView.getClientConfig().bc(false);
        String url = getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.NL.loadUrl(url);
        }
        com.kwad.sdk.core.report.a.aA(this.mAdTemplate);
    }

    public final boolean oY() {
        return this.NL != null && this.NN == 1;
    }
}
