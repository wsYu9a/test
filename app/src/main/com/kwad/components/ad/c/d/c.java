package com.kwad.components.ad.c.d;

import android.app.Activity;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.b.m;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.s;
import com.kwad.sdk.widget.e;

/* loaded from: classes2.dex */
public abstract class c extends com.kwad.components.ad.c.c.a implements j {
    private b cY;

    public void a(ay ayVar) {
    }

    @Override // com.kwad.components.ad.c.c.a, com.kwad.sdk.mvp.Presenter
    public void as() {
        super.as();
        b bVar = new b(getContext(), -1, -1);
        this.cY = bVar;
        bVar.a((Activity) null, this.cA.mAdResultData, this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void az() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public e getTouchCoordsView() {
        return null;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        this.cY.jK();
    }

    public void a(o oVar) {
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
        if (str.equals("adShowCallback")) {
            this.cA.V();
        } else if (str.equals("adShowErrorCallback")) {
            this.cA.c(0, "onMediaPlayError");
        }
    }
}
