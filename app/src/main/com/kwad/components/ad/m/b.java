package com.kwad.components.ad.m;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.c;
import com.kwad.components.core.webview.b;
import com.kwad.components.core.webview.jshandler.ab;
import com.kwad.components.core.webview.jshandler.aj;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.ar;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.jshandler.be;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.n.m;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import com.kwad.sdk.utils.bw;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class b {
    protected View JK;
    private String JM;
    private a JN;

    @Nullable
    private InterfaceC0390b JO;
    protected KsAdWebView dY;
    private AdBaseFrameLayout eQ;

    /* renamed from: eb */
    protected com.kwad.sdk.core.webview.b f11647eb;

    /* renamed from: ed */
    protected ay f11649ed;

    /* renamed from: ee */
    @Nullable
    private com.kwad.sdk.core.webview.d.a.a f11650ee;
    private FrameLayout en;

    /* renamed from: hk */
    private com.kwad.components.core.webview.b f11652hk;
    protected AdTemplate mAdTemplate;

    @Nullable
    private JSONObject mReportExtData;
    private be zW;
    private List<AdTemplate> JI = new ArrayList();

    @NonNull
    private List<c> JJ = new ArrayList();

    /* renamed from: ec */
    private int f11648ec = -1;
    protected boolean JL = false;
    private com.kwad.components.core.webview.c hl = new com.kwad.components.core.webview.c() { // from class: com.kwad.components.ad.m.b.1

        /* renamed from: com.kwad.components.ad.m.b$1$1 */
        public class C03891 extends bd {
            public C03891() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                if (b.this.JN != null) {
                    b.this.JN.iW();
                }
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.components.core.webview.a aVar, com.kwad.sdk.core.webview.b bVar) {
            b bVar2 = b.this;
            bVar2.f11647eb = bVar;
            bVar2.b(bVar);
            b.this.a(aVar);
        }

        @Override // com.kwad.components.core.webview.c
        public final void h(int i10, String str) {
            b.this.JL = false;
        }

        @Override // com.kwad.components.core.webview.c
        public final void onPageFinished() {
            b bVar = b.this;
            bVar.JL = true;
            bVar.fI();
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(WebCloseStatus webCloseStatus) {
            bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.m.b.1.1
                public C03891() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    if (b.this.JN != null) {
                        b.this.JN.iW();
                    }
                }
            });
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(ar.a aVar) {
            b.this.f11648ec = aVar.status;
            com.kwad.sdk.core.d.c.i("PlayEndWebCard", b.this.getName() + "updatePageStatus mPageState: " + aVar + "，targetUrl: " + b.this.JM);
            if (!aVar.isSuccess() || b.this.JO == null) {
                return;
            }
            b.this.JO.ie();
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(ay ayVar) {
            b.this.f11649ed = ayVar;
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            if (b.this.f11650ee != null) {
                b.this.f11650ee.a(aVar);
            }
        }
    };

    /* renamed from: eg */
    private aj.b f11651eg = new aj.b() { // from class: com.kwad.components.ad.m.b.2
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.webview.jshandler.aj.b
        public final void a(aj.a aVar) {
            b.this.mZ();
        }
    };

    /* renamed from: com.kwad.components.ad.m.b$2 */
    public class AnonymousClass2 implements aj.b {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.webview.jshandler.aj.b
        public final void a(aj.a aVar) {
            b.this.mZ();
        }
    }

    public interface a {
        void iW();
    }

    /* renamed from: com.kwad.components.ad.m.b$b */
    public interface InterfaceC0390b {
        void ie();
    }

    public b() {
    }

    private void bg() {
        int i10 = this.f11648ec;
        com.kwad.sdk.core.d.c.w("PlayEndWebCard", "show webCard fail, reason: " + (i10 == -1 ? "timeout" : i10 != 1 ? "h5error" : "others"));
    }

    private static int getLayoutId() {
        return R.layout.ksad_ad_web_card_layout;
    }

    public String F(AdTemplate adTemplate) {
        String str = this.JM;
        return str == null ? com.kwad.sdk.core.response.b.b.cG(this.mAdTemplate) : str;
    }

    public final boolean aQ() {
        if (!bW()) {
            FrameLayout frameLayout = this.en;
            if (frameLayout != null) {
                frameLayout.setVisibility(4);
            }
            bg();
            return false;
        }
        ay ayVar = this.f11649ed;
        if (ayVar != null) {
            ayVar.tu();
        }
        FrameLayout frameLayout2 = this.en;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(0);
        }
        if (this.f11649ed == null || !fE()) {
            return true;
        }
        this.f11649ed.tv();
        return true;
    }

    public final void ah(boolean z10) {
        this.zW.ah(true);
    }

    public boolean bW() {
        return this.f11648ec == 1;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void fD() {
        this.en.removeAllViews();
        this.en.setVisibility(4);
        this.JK = m.inflate(this.en.getContext(), getLayoutId(), this.en);
        KsAdWebView ksAdWebView = (KsAdWebView) this.en.findViewById(R.id.ksad_web_card_webView);
        this.dY = ksAdWebView;
        if (ksAdWebView != null) {
            boolean z10 = false;
            ksAdWebView.setBackgroundColor(0);
            this.dY.getBackground().setAlpha(0);
            this.f11652hk = new com.kwad.components.core.webview.b();
            b.a f10 = new b.a().aG(this.mAdTemplate).aI(F(this.mAdTemplate)).d(this.dY).e(this.mReportExtData).k(this.eQ).f(this.JJ.get(0));
            if (this.JJ.size() > 1 && this.JI.size() > 1) {
                z10 = true;
            }
            this.f11652hk.a(f10.aT(z10).a(this.hl));
            this.dY.loadUrl(F(this.mAdTemplate));
            fG();
        }
    }

    public boolean fE() {
        return true;
    }

    public void fG() {
    }

    public void fH() {
    }

    public void fI() {
    }

    public final long getLoadTime() {
        KsAdWebView ksAdWebView = this.dY;
        if (ksAdWebView != null) {
            return ksAdWebView.getLoadTime();
        }
        return -1L;
    }

    public String getName() {
        return "PlayEndWebCard";
    }

    public final void mM() {
        com.kwad.components.core.webview.b bVar = this.f11652hk;
        if (bVar != null) {
            bVar.jK();
        }
    }

    public final void mZ() {
        if (bw.a(this.dY, 50, false)) {
            ay ayVar = this.f11649ed;
            if (ayVar != null) {
                ayVar.tw();
            }
            this.en.setVisibility(4);
            ay ayVar2 = this.f11649ed;
            if (ayVar2 != null) {
                ayVar2.tx();
            }
        }
    }

    public final void release() {
        this.JO = null;
    }

    public void b(com.kwad.sdk.core.webview.b bVar) {
        bVar.setAdTemplate(this.mAdTemplate);
    }

    /* renamed from: com.kwad.components.ad.m.b$1 */
    public class AnonymousClass1 extends com.kwad.components.core.webview.c {

        /* renamed from: com.kwad.components.ad.m.b$1$1 */
        public class C03891 extends bd {
            public C03891() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                if (b.this.JN != null) {
                    b.this.JN.iW();
                }
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.components.core.webview.a aVar, com.kwad.sdk.core.webview.b bVar) {
            b bVar2 = b.this;
            bVar2.f11647eb = bVar;
            bVar2.b(bVar);
            b.this.a(aVar);
        }

        @Override // com.kwad.components.core.webview.c
        public final void h(int i10, String str) {
            b.this.JL = false;
        }

        @Override // com.kwad.components.core.webview.c
        public final void onPageFinished() {
            b bVar = b.this;
            bVar.JL = true;
            bVar.fI();
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(WebCloseStatus webCloseStatus) {
            bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.m.b.1.1
                public C03891() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    if (b.this.JN != null) {
                        b.this.JN.iW();
                    }
                }
            });
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(ar.a aVar) {
            b.this.f11648ec = aVar.status;
            com.kwad.sdk.core.d.c.i("PlayEndWebCard", b.this.getName() + "updatePageStatus mPageState: " + aVar + "，targetUrl: " + b.this.JM);
            if (!aVar.isSuccess() || b.this.JO == null) {
                return;
            }
            b.this.JO.ie();
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(ay ayVar) {
            b.this.f11649ed = ayVar;
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            if (b.this.f11650ee != null) {
                b.this.f11650ee.a(aVar);
            }
        }
    }

    public final void a(com.kwad.sdk.core.webview.d.a.a aVar) {
        this.f11650ee = aVar;
    }

    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, @Nullable c cVar) {
        a(frameLayout, adBaseFrameLayout, adTemplate, cVar, 0);
    }

    @Deprecated
    public void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, c cVar, int i10) {
        this.JJ.add(cVar);
        this.eQ = adBaseFrameLayout;
        this.en = frameLayout;
        this.mAdTemplate = adTemplate;
        fD();
    }

    public b(@Nullable JSONObject jSONObject, @Nullable String str) {
        this.mReportExtData = jSONObject;
        this.JM = str;
    }

    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, List<AdTemplate> list, List<c> list2) {
        this.JJ = list2;
        this.eQ = adBaseFrameLayout;
        this.en = frameLayout;
        if (list != null && list.size() > 0) {
            this.JI = list;
            this.mAdTemplate = list.get(0);
        }
        fD();
    }

    public final void a(@Nullable InterfaceC0390b interfaceC0390b) {
        this.JO = interfaceC0390b;
        this.en.setVisibility(4);
        this.f11648ec = -1;
        String F = F(this.mAdTemplate);
        com.kwad.sdk.core.d.c.d("PlayEndWebCard", "startPreloadWebView url : " + F);
        if (TextUtils.isEmpty(F) || this.dY == null) {
            return;
        }
        fH();
        this.dY.loadUrl(F);
    }

    public final void a(a aVar) {
        this.JN = aVar;
    }

    public void a(com.kwad.components.core.webview.a aVar) {
        if (this.JJ.size() > 1 && this.JI.size() > 1) {
            aVar.a(new ab(this.f11647eb, this.JJ.get(0), this.f11650ee, (byte) 0));
            aVar.a(new y(this.f11647eb, this.JJ, this.f11650ee));
            aVar.a(new an(this.JI, this.JJ));
        }
        be beVar = new be();
        this.zW = beVar;
        aVar.a(beVar);
        aVar.a(new aj(this.f11651eg));
    }
}
