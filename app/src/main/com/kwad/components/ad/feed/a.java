package com.kwad.components.ad.feed;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.l;

/* loaded from: classes2.dex */
public final class a extends com.kwad.sdk.components.e implements com.kwad.components.ad.b.d {
    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return com.kwad.components.ad.b.d.class;
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    @Override // com.kwad.components.ad.b.d
    public final void loadConfigFeedAd(KsScene ksScene, @NonNull KsLoadManager.FeedAdListener feedAdListener) {
        e.a(ksScene, feedAdListener, true);
    }

    @Override // com.kwad.components.ad.b.d
    public final void loadFeedAd(KsScene ksScene, @NonNull KsLoadManager.FeedAdListener feedAdListener) {
        if (l.At().AS()) {
            e.a(ksScene, feedAdListener, !com.kwad.components.ad.feed.a.b.bz());
        } else {
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.azJ;
            feedAdListener.onError(eVar.errorCode, eVar.msg);
        }
    }
}
