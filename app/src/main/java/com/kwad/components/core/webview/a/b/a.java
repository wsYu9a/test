package com.kwad.components.core.webview.a.b;

import androidx.annotation.Nullable;
import com.kwad.components.core.webview.a.a.m;
import com.kwad.components.core.webview.a.a.u;
import com.kwad.components.core.webview.a.h;
import com.kwad.components.core.webview.a.i;
import com.kwad.components.core.webview.a.kwai.o;
import com.kwad.components.core.webview.a.kwai.p;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.l;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.e;

/* loaded from: classes2.dex */
public abstract class a extends Presenter implements i {
    protected b Vr;
    protected h mTKLoadController;

    protected void a(b bVar) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void ar() {
        super.ar();
        b bVar = (b) Bh();
        this.Vr = bVar;
        a(bVar);
        if (this.mTKLoadController == null) {
            this.mTKLoadController = hN();
        }
        StyleTemplate styleTemplate = this.Vr.mStyleTemplate;
        if (styleTemplate != null) {
            this.mTKLoadController.setStyleTemplate(styleTemplate);
        }
        h hVar = this.mTKLoadController;
        b bVar2 = this.Vr;
        hVar.bind(bVar2.mActivity, bVar2.mAdTemplate, this);
    }

    @Override // com.kwad.components.core.webview.a.i
    public e getTouchCoordsView() {
        return this.Vr.Vs;
    }

    protected h hN() {
        return new h(this.Vr.mPlayedDuration, getContext());
    }

    public void onAdClicked(@Nullable com.kwad.sdk.core.webview.c.a.a aVar) {
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onCloseTKDialogClick() {
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onRegisterVideoMuteStateListener(o oVar) {
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onRegisterVideoProgressListener(p pVar, com.kwad.components.core.video.i iVar) {
    }

    public void onRegisterWebCardHandler(l lVar, com.kwad.sdk.core.webview.b bVar) {
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onSkipClick(u uVar) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mTKLoadController.unBind();
        this.mTKLoadController = null;
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onUpdateMuteStatus(m mVar) {
    }

    public void pageClose(WebCloseStatus webCloseStatus) {
        d dVar = this.Vr.mTkDialogFragment;
        if (dVar != null) {
            dVar.dismiss();
        }
    }
}
