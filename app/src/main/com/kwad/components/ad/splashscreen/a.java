package com.kwad.components.ad.splashscreen;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.ad.b.i;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.l;
import java.util.List;

/* loaded from: classes2.dex */
public final class a extends com.kwad.sdk.components.e implements i {
    @Override // com.kwad.components.ad.b.i
    public final List<String> R() {
        return SplashPreloadManager.kQ().R();
    }

    @Override // com.kwad.sdk.components.b
    public final Class<i> getComponentsType() {
        return i.class;
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    @Override // com.kwad.components.ad.b.i
    public final void loadSplashScreenAd(@NonNull KsScene ksScene, @NonNull KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        if (l.At().AS()) {
            b.loadSplashScreenAd(ksScene, splashScreenAdListener);
        } else {
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.azJ;
            splashScreenAdListener.onError(eVar.errorCode, eVar.msg);
        }
    }
}
