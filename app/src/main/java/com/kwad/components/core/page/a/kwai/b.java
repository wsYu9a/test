package com.kwad.components.core.page.a.kwai;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.page.a.kwai.f;
import com.kwad.components.core.webview.jshandler.al;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;

/* loaded from: classes2.dex */
public final class b extends com.kwad.sdk.mvp.a {

    @Nullable
    public com.kwad.components.core.page.kwai.a LH;

    @Nullable
    public KsAdWebView.c LI;

    @Nullable
    public f.a LJ;

    @Nullable
    public al.b LK;
    public boolean LL = false;
    public boolean LM = false;

    @NonNull
    public ViewGroup gv;

    @NonNull
    public AdTemplate mAdTemplate;

    @NonNull
    public KsAdWebView mAdWebView;
    public boolean mAutoShow;

    @NonNull
    public Context mContext;

    @Nullable
    public String mPageTitle;

    @NonNull
    public String mPageUrl;
    public boolean mShowPermission;

    @Nullable
    public com.kwad.sdk.core.webview.c.kwai.b mWebCardCloseListener;

    private void aD(boolean z) {
        this.LM = true;
    }

    public final void a(f.a aVar) {
        this.LJ = aVar;
    }

    public final void a(al.b bVar) {
        this.LK = bVar;
        aD(true);
    }

    public final void a(KsAdWebView.c cVar) {
        this.LI = cVar;
    }

    public final boolean oa() {
        return this.mShowPermission;
    }

    public final void oe() {
        al.b bVar = this.LK;
        if (bVar != null) {
            bVar.ox();
        }
    }

    public final boolean ok() {
        return this.LM;
    }

    public final boolean ol() {
        return !oa();
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        this.LI = null;
        this.LJ = null;
        this.mWebCardCloseListener = null;
        this.LK = null;
    }

    public final void setWebCardCloseListener(@Nullable com.kwad.sdk.core.webview.c.kwai.b bVar) {
        this.mWebCardCloseListener = bVar;
    }
}
