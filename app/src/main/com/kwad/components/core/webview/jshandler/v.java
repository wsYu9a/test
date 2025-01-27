package com.kwad.components.core.webview.jshandler;

import android.os.Vibrator;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bt;

/* loaded from: classes3.dex */
public final class v implements com.kwad.sdk.core.webview.c.a {
    private Vibrator fx;

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.fx = (Vibrator) ServiceProvider.getContext().getSystemService("vibrator");
        bt.a(ServiceProvider.getContext(), this.fx);
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "startVibrate";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
