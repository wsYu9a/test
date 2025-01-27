package com.kwad.components.core.webview.a.b;

import android.content.DialogInterface;
import android.widget.FrameLayout;
import com.kwad.components.core.video.i;
import com.kwad.components.core.webview.a.a.z;
import com.kwad.components.core.webview.a.b.d;
import com.kwad.components.core.webview.a.j;
import com.kwad.components.core.webview.a.kwai.p;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.webview.b.g;
import com.kwad.sdk.utils.bd;

/* loaded from: classes2.dex */
public class c extends a {
    private FrameLayout PE;
    private String Vt;
    private p Vx;
    private an Vy;
    private com.kwad.components.core.webview.a.d.d Vz = new com.kwad.components.core.webview.a.d.d() { // from class: com.kwad.components.core.webview.a.b.c.2
        AnonymousClass2() {
        }

        @Override // com.kwad.components.core.webview.a.d.d
        public final void fZ() {
            if (c.this.Vy != null) {
                c.this.Vy.qZ();
                c.this.Vy.ra();
            }
        }

        @Override // com.kwad.components.core.webview.a.d.d
        public final void gg() {
            if (c.this.Vy != null) {
                c.this.Vy.rb();
                c.this.Vy.rc();
            }
        }
    };
    private d mTkDialogFragment;

    /* renamed from: com.kwad.components.core.webview.a.b.c$1 */
    final class AnonymousClass1 implements g {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.webview.b.g
        public final void callTKBridge(String str) {
            c.this.Vr.Vu.callTKBridge(str);
        }
    }

    /* renamed from: com.kwad.components.core.webview.a.b.c$2 */
    final class AnonymousClass2 implements com.kwad.components.core.webview.a.d.d {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.core.webview.a.d.d
        public final void fZ() {
            if (c.this.Vy != null) {
                c.this.Vy.qZ();
                c.this.Vy.ra();
            }
        }

        @Override // com.kwad.components.core.webview.a.d.d
        public final void gg() {
            if (c.this.Vy != null) {
                c.this.Vy.rb();
                c.this.Vy.rc();
            }
        }
    }

    /* renamed from: com.kwad.components.core.webview.a.b.c$3 */
    final class AnonymousClass3 implements DialogInterface.OnDismissListener {
        AnonymousClass3() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            c.this.mTkDialogFragment.e(this);
            c.this.rk();
        }
    }

    public void rk() {
        d.a aVar = this.Vr.Vw;
        if (aVar != null) {
            aVar.ga();
        }
        com.kwad.components.core.webview.a.c.a.rn().aS(getTkTemplateId());
        com.kwad.sdk.components.g gVar = this.Vr.Vu;
        if (gVar != null) {
            gVar.callbackPageStatus(false, "render failed");
        }
    }

    @Override // com.kwad.components.core.webview.a.b.a
    protected final void a(b bVar) {
        super.a(bVar);
        b bVar2 = this.Vr;
        this.Vt = bVar2.Vt;
        this.mTkDialogFragment = bVar2.mTkDialogFragment;
    }

    @Override // com.kwad.components.core.webview.a.b.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        d dVar = this.mTkDialogFragment;
        if (dVar != null) {
            dVar.a(this.Vz);
        }
        if (this.Vr.Vu != null) {
            this.mTKLoadController.setTKBridgeHandler(new g() { // from class: com.kwad.components.core.webview.a.b.c.1
                AnonymousClass1() {
                }

                @Override // com.kwad.sdk.core.webview.b.g
                public final void callTKBridge(String str) {
                    c.this.Vr.Vu.callTKBridge(str);
                }
            });
            this.Vr.Vu.a(this.mTKLoadController);
            this.mTKLoadController.addCustomEnv("hasTKBridge", Boolean.TRUE);
        }
    }

    @Override // com.kwad.components.core.webview.a.i
    public FrameLayout getTKContainer() {
        return this.PE;
    }

    @Override // com.kwad.components.core.webview.a.i
    public String getTkTemplateId() {
        b bVar = this.Vr;
        StyleTemplate styleTemplate = bVar.mStyleTemplate;
        return styleTemplate != null ? styleTemplate.templateId : j.b(this.Vt, bVar.mAdTemplate);
    }

    @Override // com.kwad.components.core.webview.a.b.a, com.kwad.components.core.webview.a.i
    public void onCloseTKDialogClick() {
        super.onCloseTKDialogClick();
        b bVar = this.Vr;
        if (bVar.Vv) {
            com.kwad.components.core.webview.a.d.c cVar = bVar.Pv;
            if (cVar != null) {
                cVar.J(true);
                return;
            }
            return;
        }
        d dVar = this.mTkDialogFragment;
        if (dVar != null) {
            dVar.dismiss();
        }
        com.kwad.components.core.webview.a.d.c cVar2 = this.Vr.Pv;
        if (cVar2 != null) {
            cVar2.gh();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.PE = (FrameLayout) findViewById(R.id.ksad_tk_dialog_container);
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onGetContainerLimited(u.a aVar) {
        float ax = com.kwad.sdk.c.kwai.a.ax(getContext());
        aVar.width = (int) ((bd.getScreenWidth(getContext()) / ax) + 0.5f);
        aVar.height = (int) ((bd.getScreenHeight(getContext()) / ax) + 0.5f);
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onRegisterLifecycleLisener(an anVar) {
        this.Vy = anVar;
    }

    @Override // com.kwad.components.core.webview.a.b.a, com.kwad.components.core.webview.a.i
    public void onRegisterVideoProgressListener(p pVar, i iVar) {
        this.Vx = pVar;
        long j2 = this.Vr.mPlayedDuration;
        if (pVar == null || j2 <= 0) {
            return;
        }
        z zVar = new z();
        zVar.nZ = (int) ((j2 / 1000.0f) + 0.5f);
        this.Vx.a(zVar);
    }

    @Override // com.kwad.components.core.webview.a.b.a, com.kwad.components.core.webview.a.i
    public void onSkipClick(com.kwad.components.core.webview.a.a.u uVar) {
        super.onSkipClick(uVar);
        d dVar = this.mTkDialogFragment;
        if (dVar != null) {
            dVar.dismiss();
        }
        com.kwad.components.core.webview.a.d.c cVar = this.Vr.Pv;
        if (cVar != null) {
            cVar.J(true);
        }
    }

    public void onTkLoadFailed() {
        d dVar = this.mTkDialogFragment;
        if (dVar == null) {
            rk();
            return;
        }
        if (dVar.isShowing()) {
            this.mTkDialogFragment.d(new DialogInterface.OnDismissListener() { // from class: com.kwad.components.core.webview.a.b.c.3
                AnonymousClass3() {
                }

                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    c.this.mTkDialogFragment.e(this);
                    c.this.rk();
                }
            });
        } else {
            rk();
        }
        this.mTkDialogFragment.dismiss();
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onTkLoadSuccess() {
        com.kwad.sdk.components.g gVar = this.Vr.Vu;
        if (gVar != null) {
            gVar.callbackPageStatus(true, null);
        }
    }

    @Override // com.kwad.components.core.webview.a.b.a, com.kwad.components.core.webview.a.i
    public void pageClose(WebCloseStatus webCloseStatus) {
        super.pageClose(webCloseStatus);
        com.kwad.sdk.components.g gVar = this.Vr.Vu;
        if (gVar != null) {
            gVar.callbackDialogDismiss();
        }
    }
}
