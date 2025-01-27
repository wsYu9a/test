package com.kwad.components.core.page.c.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.c.a.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;

/* loaded from: classes3.dex */
public final class b extends com.kwad.sdk.mvp.a {

    @Nullable
    public com.kwad.components.core.page.a.a QM;

    @Nullable
    public KsAdWebView.c QN;

    @Nullable
    public f.a QO;

    @Nullable
    @Deprecated
    public com.kwad.components.core.webview.jshandler.b QP;
    public boolean QQ = false;
    public boolean QR = false;

    @NonNull
    public AdWebViewActivityProxy.a Qw;

    /* renamed from: if */
    @NonNull
    public ViewGroup f8if;

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
    public com.kwad.sdk.core.webview.d.a.b mWebCardCloseListener;

    private void aH(boolean z10) {
        this.QR = true;
    }

    public final void a(KsAdWebView.c cVar) {
        this.QN = cVar;
    }

    public final boolean pX() {
        return this.mShowPermission;
    }

    public final void qc() {
        com.kwad.components.core.webview.jshandler.b bVar = this.QP;
        if (bVar != null) {
            bVar.qw();
        }
    }

    public final boolean qi() {
        return this.QR;
    }

    public final boolean qj() {
        return !pX();
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        this.QN = null;
        this.QO = null;
        this.mWebCardCloseListener = null;
        this.QP = null;
    }

    public final void setWebCardCloseListener(@Nullable com.kwad.sdk.core.webview.d.a.b bVar) {
        this.mWebCardCloseListener = bVar;
    }

    public final void a(f.a aVar) {
        this.QO = aVar;
    }

    public final void a(boolean z10, View view) {
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView != null && ksAdWebView.canGoBack()) {
            this.mAdWebView.goBack();
            if (z10) {
                com.kwad.sdk.core.adlog.c.bU(this.mAdTemplate);
                return;
            }
            return;
        }
        com.kwad.components.core.page.a.a aVar = this.QM;
        if (aVar != null) {
            aVar.pS();
        }
    }

    public final void a(com.kwad.components.core.webview.jshandler.b bVar) {
        this.QP = bVar;
        aH(true);
    }
}
