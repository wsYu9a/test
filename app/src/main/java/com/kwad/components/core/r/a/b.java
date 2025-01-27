package com.kwad.components.core.r.a;

import com.kwad.components.core.webview.tachikoma.k;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.components.m;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.view.AdBaseFrameLayout;

/* loaded from: classes3.dex */
public final class b extends com.kwad.components.core.l.a {
    public StyleTemplate Vh;
    public m Vk;
    public k Vl;
    public AdResultData mAdResultData;
    public AdBaseFrameLayout mRootContainer;

    public b(a aVar) {
        super(aVar);
    }

    public final void a(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = c.o(adResultData);
    }
}
