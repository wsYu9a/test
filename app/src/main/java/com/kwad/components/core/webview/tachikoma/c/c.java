package com.kwad.components.core.webview.tachikoma.c;

import android.content.DialogInterface;
import android.widget.FrameLayout;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.webview.tachikoma.b.y;
import com.kwad.components.core.webview.tachikoma.c.e;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.l;
import com.kwad.sdk.core.webview.c.g;
import com.kwad.sdk.utils.bo;

/* loaded from: classes3.dex */
public class c extends a {
    private FrameLayout Vr;
    private e abM;
    private p adJ;
    private ay adK;
    private com.kwad.components.core.webview.tachikoma.e.e adL = new com.kwad.components.core.webview.tachikoma.e.e() { // from class: com.kwad.components.core.webview.tachikoma.c.c.2
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.e
        public final void gl() {
            if (c.this.adK != null) {
                c.this.adK.tu();
                c.this.adK.tv();
            }
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.e
        public final void gt() {
            if (c.this.adK != null) {
                c.this.adK.tw();
                c.this.adK.tx();
            }
        }
    };
    private String yP;

    /* renamed from: com.kwad.components.core.webview.tachikoma.c.c$1 */
    public class AnonymousClass1 implements g {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.webview.c.g
        public final void callTKBridge(String str) {
            c.this.adD.adF.callTKBridge(str);
        }
    }

    /* renamed from: com.kwad.components.core.webview.tachikoma.c.c$2 */
    public class AnonymousClass2 implements com.kwad.components.core.webview.tachikoma.e.e {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.e
        public final void gl() {
            if (c.this.adK != null) {
                c.this.adK.tu();
                c.this.adK.tv();
            }
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.e
        public final void gt() {
            if (c.this.adK != null) {
                c.this.adK.tw();
                c.this.adK.tx();
            }
        }
    }

    /* renamed from: com.kwad.components.core.webview.tachikoma.c.c$3 */
    public class AnonymousClass3 implements DialogInterface.OnDismissListener {
        public AnonymousClass3() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            c.this.abM.e(this);
            c.this.uc();
        }
    }

    public void uc() {
        e.a aVar = this.adD.adI;
        if (aVar != null) {
            aVar.gn();
        }
        com.kwad.components.core.webview.tachikoma.d.b.uj().s(getTkTemplateId(), getTKReaderScene());
        l lVar = this.adD.adF;
        if (lVar != null) {
            lVar.callbackPageStatus(false, "render failed");
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0448a c0448a) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.a, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        e eVar = this.abM;
        if (eVar != null) {
            eVar.a(this.adL);
        }
        if (this.adD.adF != null) {
            this.hw.a(new g() { // from class: com.kwad.components.core.webview.tachikoma.c.c.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.core.webview.c.g
                public final void callTKBridge(String str) {
                    c.this.adD.adF.callTKBridge(str);
                }
            });
            this.adD.adF.a(this.hw);
            this.hw.a("hasTKBridge", Boolean.TRUE);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void ay() {
        l lVar = this.adD.adF;
        if (lVar != null) {
            lVar.callbackPageStatus(true, null);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.a, com.kwad.components.core.webview.tachikoma.j
    public final void az() {
        super.az();
        b bVar = this.adD;
        if (bVar.adH) {
            com.kwad.components.core.webview.tachikoma.e.c cVar = bVar.Vf;
            if (cVar != null) {
                cVar.G(true);
                return;
            }
            return;
        }
        e eVar = this.abM;
        if (eVar != null) {
            eVar.dismiss();
        }
        com.kwad.components.core.webview.tachikoma.e.c cVar2 = this.adD.Vf;
        if (cVar2 != null) {
            cVar2.gu();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public FrameLayout getTKContainer() {
        return this.Vr;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getTKReaderScene() {
        return "tk_dialog";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getTkTemplateId() {
        StyleTemplate styleTemplate = this.adD.Vh;
        return styleTemplate != null ? styleTemplate.templateId : this.yP;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.Vr = (FrameLayout) findViewById(R.id.ksad_tk_dialog_container);
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.a
    public final void a(b bVar) {
        super.a(bVar);
        b bVar2 = this.adD;
        this.yP = bVar2.yP;
        this.abM = bVar2.abM;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ad.a aVar) {
        float ba2 = com.kwad.sdk.c.a.a.ba(getContext());
        aVar.width = (int) ((bo.getScreenWidth(getContext()) / ba2) + 0.5f);
        aVar.height = (int) ((bo.getScreenHeight(getContext()) / ba2) + 0.5f);
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar) {
        this.adJ = pVar;
        long j10 = this.adD.yV;
        if (pVar == null || j10 <= 0) {
            return;
        }
        y yVar = new y();
        yVar.oZ = (int) ((j10 / 1000.0f) + 0.5f);
        this.adJ.a(yVar);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ay ayVar) {
        this.adK = ayVar;
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar) {
        super.a(tVar);
        e eVar = this.abM;
        if (eVar != null) {
            eVar.dismiss();
        }
        com.kwad.components.core.webview.tachikoma.e.c cVar = this.adD.Vf;
        if (cVar != null) {
            cVar.G(true);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.a, com.kwad.components.core.webview.tachikoma.j
    public void a(WebCloseStatus webCloseStatus) {
        super.a(webCloseStatus);
        l lVar = this.adD.adF;
        if (lVar != null) {
            lVar.callbackDialogDismiss();
        }
    }

    public void a(TKRenderFailReason tKRenderFailReason) {
        e eVar = this.abM;
        if (eVar != null) {
            if (eVar.isShowing()) {
                this.abM.d(new DialogInterface.OnDismissListener() { // from class: com.kwad.components.core.webview.tachikoma.c.c.3
                    public AnonymousClass3() {
                    }

                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        c.this.abM.e(this);
                        c.this.uc();
                    }
                });
            } else {
                uc();
            }
            this.abM.dismiss();
            return;
        }
        uc();
    }
}
