package com.kwad.components.core.e.a;

import android.app.Activity;
import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.b.m;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.s;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;

/* loaded from: classes3.dex */
public final class f extends Presenter implements j, com.kwad.sdk.core.h.c {
    private com.kwad.components.core.widget.a.b LJ;
    private a LT;

    /* renamed from: ed */
    private ay f11914ed;
    private i hw;
    private AdTemplate mAdTemplate;

    /* renamed from: com.kwad.components.core.e.a.f$1 */
    public class AnonymousClass1 extends i {
        public AnonymousClass1(Context context) {
            super(context);
        }

        @Override // com.kwad.components.core.webview.tachikoma.i
        public final boolean nY() {
            return true;
        }
    }

    /* renamed from: com.kwad.components.core.e.a.f$2 */
    public class AnonymousClass2 extends bd {
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            f.this.LT.LK.nS();
        }
    }

    private void aj(boolean z10) {
        if (!z10) {
            this.LT.X();
        }
        bt.runOnUiThread(new bd() { // from class: com.kwad.components.core.e.a.f.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                f.this.LT.LK.nS();
            }
        });
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0448a c0448a) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        a aVar = (a) Lj();
        this.LT = aVar;
        this.mAdTemplate = aVar.mAdTemplate;
        this.LJ = aVar.LJ;
        this.hw = new i(getContext()) { // from class: com.kwad.components.core.e.a.f.1
            public AnonymousClass1(Context context) {
                super(context);
            }

            @Override // com.kwad.components.core.webview.tachikoma.i
            public final boolean nY() {
                return true;
            }
        };
        this.hw.a((Activity) null, com.kwad.sdk.core.response.b.c.dM(this.mAdTemplate), this);
        this.LJ.a(this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void ay() {
        com.kwad.sdk.core.d.c.d("InstalledActivatePresenter", "onTkLoadSuccess");
        this.LT.V();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void az() {
    }

    @Override // com.kwad.sdk.core.h.c
    public final void bl() {
        com.kwad.sdk.core.d.c.d("InstalledActivatePresenter", "onPageVisible");
        ay ayVar = this.f11914ed;
        if (ayVar != null) {
            ayVar.ty();
        }
    }

    @Override // com.kwad.sdk.core.h.c
    public final void bm() {
        com.kwad.sdk.core.d.c.d("InstalledActivatePresenter", "onPageInvisible");
        ay ayVar = this.f11914ed;
        if (ayVar != null) {
            ayVar.tz();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.LT.LI;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_installed_activate";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.cm(this.mAdTemplate).installedActivateInfo.templateId;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final com.kwad.sdk.widget.e getTouchCoordsView() {
        return this.LT.LI;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.hw.jK();
        this.LJ.b(this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(m mVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(s sVar, com.kwad.sdk.core.webview.b bVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        com.kwad.sdk.core.d.c.d("InstalledActivatePresenter", "onTkLoadFailed");
        aj(true);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        com.kwad.sdk.core.d.c.d("InstalledActivatePresenter", "onAdClicked");
        aj(false);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ad.a aVar) {
        float ba2 = com.kwad.sdk.c.a.a.ba(getContext());
        float screenHeight = com.kwad.sdk.c.a.a.getScreenHeight(getContext());
        aVar.width = (int) ((com.kwad.sdk.c.a.a.getScreenWidth(getContext()) / ba2) + 0.5f);
        aVar.height = (int) ((screenHeight / ba2) + 0.5f);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        aj(false);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ay ayVar) {
        this.f11914ed = ayVar;
        this.LT.f11913ed = ayVar;
    }
}
