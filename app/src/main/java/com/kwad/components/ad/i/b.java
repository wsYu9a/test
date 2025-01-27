package com.kwad.components.ad.i;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.d.b.c;
import com.kwad.components.core.webview.a.kwai.f;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.components.core.webview.jshandler.j;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.jshandler.q;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.components.core.webview.jshandler.v;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.j.k;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.bl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {
    protected View GA;
    private String GC;
    private j.a GD;
    private a GE;

    @Nullable
    private InterfaceC0132b GF;
    protected KsAdWebView cS;
    private com.kwad.components.core.webview.a cU;
    protected com.kwad.sdk.core.webview.b cV;
    private AdBaseFrameLayout dG;
    private FrameLayout df;
    protected AdTemplate mAdTemplate;
    protected an mCardLifecycleHandler;

    @Nullable
    private JSONObject mReportExtData;
    private int mScreenOrientation;

    @Nullable
    private com.kwad.sdk.core.webview.c.kwai.a mWebCardClickListener;
    private as xY;
    private List<AdTemplate> Gy = new ArrayList();

    @NonNull
    private List<c> Gz = new ArrayList();
    private int cW = -1;
    protected boolean GB = false;
    private aa.b cY = new aa.b() { // from class: com.kwad.components.ad.i.b.4
        AnonymousClass4() {
        }

        @Override // com.kwad.components.core.webview.jshandler.aa.b
        public final void a(aa.a aVar) {
            b.this.lK();
        }
    };
    private ai.b cZ = new ai.b() { // from class: com.kwad.components.ad.i.b.5
        AnonymousClass5() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ai.b
        public final void a(ai.a aVar) {
            b.this.cW = aVar.status;
            com.kwad.sdk.core.d.b.i("PlayEndWebCard", b.this.getName() + "updatePageStatus mPageState: " + aVar + "，targetUrl: " + b.this.GC);
            if (aVar.isSuccess() && b.this.GF != null) {
                b.this.GF.hK();
            }
        }
    };

    /* renamed from: com.kwad.components.ad.i.b$1 */
    final class AnonymousClass1 implements KsAdWebView.d {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.d
        public final void onPageFinished() {
            b bVar = b.this;
            bVar.GB = true;
            bVar.fv();
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.d
        public final void onPageStart() {
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.d
        public final void onReceivedHttpError(int i2, String str, String str2) {
            b.this.GB = false;
        }
    }

    /* renamed from: com.kwad.components.ad.i.b$2 */
    final class AnonymousClass2 implements j.a {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.core.webview.jshandler.j.a
        public final void onPlayAgainClick(boolean z) {
            if (b.this.GD != null) {
                b.this.GD.onPlayAgainClick(z);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.i.b$3 */
    final class AnonymousClass3 implements com.kwad.sdk.core.webview.c.kwai.b {

        /* renamed from: com.kwad.components.ad.i.b$3$1 */
        final class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (b.this.GE != null) {
                    b.this.GE.iw();
                }
            }
        }

        AnonymousClass3() {
        }

        @Override // com.kwad.sdk.core.webview.c.kwai.b
        public final void a(WebCloseStatus webCloseStatus) {
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.i.b.3.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (b.this.GE != null) {
                        b.this.GE.iw();
                    }
                }
            });
        }
    }

    /* renamed from: com.kwad.components.ad.i.b$4 */
    final class AnonymousClass4 implements aa.b {
        AnonymousClass4() {
        }

        @Override // com.kwad.components.core.webview.jshandler.aa.b
        public final void a(aa.a aVar) {
            b.this.lK();
        }
    }

    /* renamed from: com.kwad.components.ad.i.b$5 */
    final class AnonymousClass5 implements ai.b {
        AnonymousClass5() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ai.b
        public final void a(ai.a aVar) {
            b.this.cW = aVar.status;
            com.kwad.sdk.core.d.b.i("PlayEndWebCard", b.this.getName() + "updatePageStatus mPageState: " + aVar + "，targetUrl: " + b.this.GC);
            if (aVar.isSuccess() && b.this.GF != null) {
                b.this.GF.hK();
            }
        }
    }

    public interface a {
        void a(b bVar);

        void iw();
    }

    /* renamed from: com.kwad.components.ad.i.b$b */
    public interface InterfaceC0132b {
        void hK();
    }

    public b() {
    }

    public b(@Nullable JSONObject jSONObject, @Nullable String str) {
        this.mReportExtData = jSONObject;
        this.GC = str;
    }

    private void aF() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.cV = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.cV;
        bVar2.mScreenOrientation = this.mScreenOrientation;
        bVar2.app = this.dG;
        bVar2.LD = this.df;
        bVar2.Lc = this.cS;
        bVar2.mReportExtData = this.mReportExtData;
        b(bVar2);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void aH() {
        aI();
        this.cS.getSettings().setAllowFileAccess(true);
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.cS);
        this.cU = aVar;
        a(aVar);
        this.cS.addJavascriptInterface(this.cU, "KwaiAd");
    }

    private void aI() {
        com.kwad.components.core.webview.a aVar = this.cU;
        if (aVar != null) {
            aVar.destroy();
            this.cU = null;
        }
    }

    private void aP() {
        int i2 = this.cW;
        com.kwad.sdk.core.d.b.w("PlayEndWebCard", "show webCard fail, reason: " + (i2 == -1 ? "timeout" : i2 != 1 ? "h5error" : "others"));
    }

    private static int getLayoutId() {
        return R.layout.ksad_ad_web_card_layout;
    }

    private KsAdWebView.d getWebListener() {
        return new KsAdWebView.d() { // from class: com.kwad.components.ad.i.b.1
            AnonymousClass1() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
                b bVar = b.this;
                bVar.GB = true;
                bVar.fv();
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i2, String str, String str2) {
                b.this.GB = false;
            }
        };
    }

    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, @Nullable c cVar) {
        a(frameLayout, adBaseFrameLayout, adTemplate, cVar, 0);
    }

    @Deprecated
    public void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, c cVar, int i2) {
        this.Gz.add(cVar);
        this.dG = adBaseFrameLayout;
        this.df = frameLayout;
        this.mScreenOrientation = i2;
        this.mAdTemplate = adTemplate;
        fq();
        aF();
    }

    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, List<AdTemplate> list, List<c> list2, int i2) {
        this.Gz = list2;
        this.dG = adBaseFrameLayout;
        this.df = frameLayout;
        this.mScreenOrientation = i2;
        if (list != null && list.size() > 0) {
            this.Gy = list;
            this.mAdTemplate = list.get(0);
        }
        fq();
        aF();
    }

    public final void a(a aVar) {
        this.GE = aVar;
    }

    public final void a(@Nullable InterfaceC0132b interfaceC0132b) {
        this.GF = interfaceC0132b;
        this.df.setVisibility(4);
        this.cW = -1;
        String l = l(this.mAdTemplate);
        com.kwad.sdk.core.d.b.d("PlayEndWebCard", "startPreloadWebView url : " + l);
        if (TextUtils.isEmpty(l) || this.cS == null) {
            return;
        }
        aH();
        fu();
        this.cS.loadUrl(l);
    }

    protected void a(com.kwad.components.core.webview.a aVar) {
        if (this.Gz.size() <= 1 || this.Gy.size() <= 1) {
            c cVar = this.Gz.get(0);
            aVar.a(new s(this.cV, cVar, this.mWebCardClickListener));
            aVar.a(new p(this.cV, cVar, this.mWebCardClickListener));
            aVar.a(new aq(this.cV, cVar));
        } else {
            aVar.a(new s(this.cV, this.Gz.get(0), this.mWebCardClickListener));
            aVar.a(new p(this.cV, this.Gz, this.mWebCardClickListener));
            aVar.a(new ae(this.Gy, this.Gz));
        }
        as asVar = new as();
        this.xY = asVar;
        aVar.a(asVar);
        aVar.a(new v(this.cV));
        aVar.a(new f());
        aVar.a(new y(this.cV));
        aVar.a(new u(this.cV));
        aVar.a(new ai(this.cZ, l(this.mAdTemplate)));
        an anVar = new an();
        this.mCardLifecycleHandler = anVar;
        aVar.a(anVar);
        aVar.a(new aa(this.cY));
        aVar.a(new ac(this.cV));
        j jVar = new j();
        jVar.b(new j.a() { // from class: com.kwad.components.ad.i.b.2
            AnonymousClass2() {
            }

            @Override // com.kwad.components.core.webview.jshandler.j.a
            public final void onPlayAgainClick(boolean z) {
                if (b.this.GD != null) {
                    b.this.GD.onPlayAgainClick(z);
                }
            }
        });
        aVar.a(jVar);
        aVar.a(new q(new com.kwad.sdk.core.webview.c.kwai.b() { // from class: com.kwad.components.ad.i.b.3

            /* renamed from: com.kwad.components.ad.i.b$3$1 */
            final class AnonymousClass1 implements Runnable {
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (b.this.GE != null) {
                        b.this.GE.iw();
                    }
                }
            }

            AnonymousClass3() {
            }

            @Override // com.kwad.sdk.core.webview.c.kwai.b
            public final void a(WebCloseStatus webCloseStatus) {
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.i.b.3.1
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        if (b.this.GE != null) {
                            b.this.GE.iw();
                        }
                    }
                });
            }
        }));
    }

    public final void a(j.a aVar) {
        this.GD = aVar;
    }

    public final void a(com.kwad.sdk.core.webview.c.kwai.a aVar) {
        this.mWebCardClickListener = aVar;
    }

    public final void al(boolean z) {
        this.xY.al(true);
    }

    public final boolean az() {
        if (!bE()) {
            FrameLayout frameLayout = this.df;
            if (frameLayout != null) {
                frameLayout.setVisibility(4);
            }
            aP();
            return false;
        }
        an anVar = this.mCardLifecycleHandler;
        if (anVar != null) {
            anVar.qZ();
        }
        FrameLayout frameLayout2 = this.df;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(0);
        }
        if (this.mCardLifecycleHandler != null && fr()) {
            this.mCardLifecycleHandler.ra();
        }
        a aVar = this.GE;
        if (aVar == null) {
            return true;
        }
        aVar.a(this);
        return true;
    }

    protected void b(com.kwad.sdk.core.webview.b bVar) {
        bVar.setAdTemplate(this.mAdTemplate);
    }

    protected boolean bE() {
        return this.cW == 1;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    protected void fq() {
        this.df.removeAllViews();
        this.df.setVisibility(4);
        this.GA = k.inflate(this.df.getContext(), getLayoutId(), this.df);
        KsAdWebView ksAdWebView = (KsAdWebView) this.df.findViewById(R.id.ksad_web_card_webView);
        this.cS = ksAdWebView;
        if (ksAdWebView != null) {
            ksAdWebView.setBackgroundColor(0);
            this.cS.getBackground().setAlpha(0);
            this.cS.setClientConfig(this.cS.getClientConfig().ct(this.mAdTemplate).b(getWebListener()));
            ft();
        }
    }

    protected boolean fr() {
        return true;
    }

    protected void ft() {
    }

    protected void fu() {
    }

    protected void fv() {
    }

    public final long getLoadTime() {
        KsAdWebView ksAdWebView = this.cS;
        if (ksAdWebView != null) {
            return ksAdWebView.getLoadTime();
        }
        return -1L;
    }

    protected String getName() {
        return "PlayEndWebCard";
    }

    public final void jW() {
        aI();
    }

    protected String l(AdTemplate adTemplate) {
        String str = this.GC;
        return str == null ? com.kwad.sdk.core.response.a.b.bd(this.mAdTemplate) : str;
    }

    public final void lK() {
        if (bl.a(this.cS, 50, false)) {
            an anVar = this.mCardLifecycleHandler;
            if (anVar != null) {
                anVar.rb();
            }
            this.df.setVisibility(4);
            an anVar2 = this.mCardLifecycleHandler;
            if (anVar2 != null) {
                anVar2.rc();
            }
        }
    }

    public final FrameLayout lL() {
        return this.df;
    }

    public final void release() {
        aI();
        this.GF = null;
    }
}
