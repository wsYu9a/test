package com.kwad.components.core.webview.tachikoma.c;

import android.app.Activity;
import com.kwad.components.core.webview.tachikoma.c.e;
import com.kwad.components.core.webview.tachikoma.k;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.components.l;
import com.kwad.sdk.core.response.model.AdResultData;

/* loaded from: classes3.dex */
public class b extends com.kwad.sdk.mvp.a {
    public com.kwad.components.core.webview.tachikoma.e.c Vf;
    public StyleTemplate Vh;
    public e abM;
    public com.kwad.sdk.widget.e adE;
    public l adF;
    public k adG;
    public boolean adH;
    public e.a adI;
    public Activity mActivity;
    public AdResultData mAdResultData;
    public String yP;
    public long yV;

    public final void a(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.o(adResultData);
    }

    @Override // com.kwad.sdk.mvp.a
    public void release() {
        this.abM = null;
        this.mActivity = null;
        this.adE = null;
    }
}
