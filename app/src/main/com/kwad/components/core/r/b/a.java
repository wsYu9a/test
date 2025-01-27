package com.kwad.components.core.r.b;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.core.proxy.f;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.m;
import com.kwad.sdk.components.s;
import com.kwad.sdk.core.webview.c.g;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bo;
import com.kwad.sdk.widget.e;

/* loaded from: classes3.dex */
public final class a extends Presenter implements j {
    private FrameLayout Vr;
    private ay Vs;
    protected boolean Vt;
    protected com.kwad.components.core.r.a.b Vu;
    private com.kwad.components.core.l.a.a Vv = new com.kwad.components.core.l.a.a() { // from class: com.kwad.components.core.r.b.a.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.l.a.a
        public final void c(f fVar) {
            a.this.rV();
        }

        @Override // com.kwad.components.core.l.a.a
        public final void d(f fVar) {
            a.this.rW();
        }

        @Override // com.kwad.components.core.l.a.a
        public final void gj() {
        }

        @Override // com.kwad.components.core.l.a.a
        public final void gk() {
            a.this.rX();
        }
    };
    private i hw;

    /* renamed from: com.kwad.components.core.r.b.a$1 */
    public class AnonymousClass1 implements com.kwad.components.core.l.a.a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.l.a.a
        public final void c(f fVar) {
            a.this.rV();
        }

        @Override // com.kwad.components.core.l.a.a
        public final void d(f fVar) {
            a.this.rW();
        }

        @Override // com.kwad.components.core.l.a.a
        public final void gj() {
        }

        @Override // com.kwad.components.core.l.a.a
        public final void gk() {
            a.this.rX();
        }
    }

    /* renamed from: com.kwad.components.core.r.b.a$2 */
    public class AnonymousClass2 implements g {
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.core.webview.c.g
        public final void callTKBridge(String str) {
            m mVar = a.this.Vu.Vk;
            if (mVar != null) {
                mVar.callTKBridge(str);
            }
        }
    }

    private void rU() {
        ay ayVar = this.Vs;
        if (ayVar == null) {
            return;
        }
        if (this.Vt) {
            ayVar.ty();
            return;
        }
        ayVar.tu();
        this.Vs.tv();
        this.Vt = true;
    }

    public void rV() {
        rU();
    }

    public void rW() {
        ay ayVar = this.Vs;
        if (ayVar == null || !this.Vt) {
            return;
        }
        ayVar.tz();
    }

    public void rX() {
        ay ayVar = this.Vs;
        if (ayVar == null || !this.Vt) {
            return;
        }
        ayVar.tw();
        this.Vs.tx();
        m mVar = this.Vu.Vk;
        if (mVar != null) {
            mVar.callbackDismiss();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0448a c0448a) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.Vu = (com.kwad.components.core.r.a.b) Lj();
        this.Vr = (FrameLayout) findViewById(R.id.ksad_js_container);
        i iVar = new i(getContext(), 1000, 0);
        this.hw = iVar;
        iVar.a(this.Vu.Vh);
        m mVar = this.Vu.Vk;
        if (mVar != null) {
            mVar.a(this.hw);
            this.hw.a(new g() { // from class: com.kwad.components.core.r.b.a.2
                public AnonymousClass2() {
                }

                @Override // com.kwad.sdk.core.webview.c.g
                public final void callTKBridge(String str) {
                    m mVar2 = a.this.Vu.Vk;
                    if (mVar2 != null) {
                        mVar2.callTKBridge(str);
                    }
                }
            });
            this.hw.a("hasTKBridge", Boolean.TRUE);
        }
        this.hw.a(getActivity(), this.Vu.mAdResultData, this);
        this.Vu.Ov.add(this.Vv);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void ay() {
        rU();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void az() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.Vr;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_activity";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return this.Vu.Vh.templateId;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final e getTouchCoordsView() {
        return this.Vu.mRootContainer;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        rX();
        this.hw.jK();
        this.Vu.Ov.remove(this.Vv);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(com.kwad.components.core.webview.tachikoma.b.m mVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(s sVar, com.kwad.sdk.core.webview.b bVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ad.a aVar) {
        float ba2 = com.kwad.sdk.c.a.a.ba(getContext());
        aVar.width = (int) ((bo.getScreenWidth(getContext()) / ba2) + 0.5f);
        aVar.height = (int) ((bo.getScreenHeight(getContext()) / ba2) + 0.5f);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        getActivity().finish();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ay ayVar) {
        this.Vs = ayVar;
    }
}
