package com.kwad.components.ad.splashscreen.presenter.a;

import android.app.Activity;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.presenter.e;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.b.m;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.s;

/* loaded from: classes2.dex */
public abstract class c extends e implements j {
    private b He;

    public void a(ay ayVar) {
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public void as() {
        super.as();
        int ms = ms();
        b bVar = new b(getContext(), ms, ms);
        this.He = bVar;
        bVar.a((Activity) null, this.EJ.mAdResultData, this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void az() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public com.kwad.sdk.widget.e getTouchCoordsView() {
        return this.EJ.mRootContainer;
    }

    public int ms() {
        return 1000;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        this.He.jK();
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
    public void a(WebCloseStatus webCloseStatus) {
    }

    public void a(s sVar, com.kwad.sdk.core.webview.b bVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0448a c0448a) {
        String str = c0448a.YC;
        str.hashCode();
        switch (str) {
            case "adShowCallback":
                this.EJ.kW();
                break;
            case "adDownloadConfirmTipCancel":
                this.EJ.lb();
                break;
            case "adCloseCallback":
                this.EJ.kY();
                break;
            case "adDownloadConfirmTipShow":
                this.EJ.la();
                break;
            case "adDownloadConfirmTipDismiss":
                this.EJ.lc();
                break;
            case "adAutoCloseCallback":
                this.EJ.kX();
                break;
            case "adShowErrorCallback":
                this.EJ.kV();
                break;
            case "adClickCallback":
                this.EJ.kZ();
                break;
        }
    }
}
