package com.kwad.components.ad.reward.i;

import android.content.Context;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.bi;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes2.dex */
public final class b extends bi implements bi.a {
    private PlayableSource tD;

    public b(Context context, AdTemplate adTemplate, PlayableSource playableSource) {
        super(context, adTemplate);
        this.tD = playableSource;
        a(this);
    }

    @Override // com.kwad.components.core.webview.jshandler.bi.a
    public final boolean eg() {
        com.kwad.components.ad.reward.a.fr().c(this.tD, new a(this.mContext));
        return false;
    }
}
