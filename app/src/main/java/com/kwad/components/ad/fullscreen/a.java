package com.kwad.components.ad.fullscreen;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.l;

/* loaded from: classes2.dex */
public final class a extends com.kwad.sdk.components.e implements com.kwad.components.ad.b.e {
    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return com.kwad.components.ad.b.e.class;
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    @Override // com.kwad.components.ad.b.e
    public final void loadFullScreenVideoAd(KsScene ksScene, @NonNull KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener) {
        if (l.At().AS()) {
            f.a(ksScene, new e(ksScene.getPosId(), fullScreenVideoAdListener));
        } else {
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.azJ;
            fullScreenVideoAdListener.onError(eVar.errorCode, eVar.msg);
        }
    }

    @Override // com.kwad.sdk.components.e, com.kwad.sdk.components.b
    public final int priority() {
        com.kwad.sdk.components.b f10 = com.kwad.sdk.components.d.f(com.kwad.components.ad.b.h.class);
        if (f10 != null) {
            return f10.priority() + 1;
        }
        return 1;
    }
}
