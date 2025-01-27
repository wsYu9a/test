package com.kwad.components.core.liveEnd;

import android.text.TextUtils;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.sdk.core.network.b;
import com.kwad.sdk.utils.aw;
import java.util.Map;

/* loaded from: classes3.dex */
public final class a extends b {
    private IAdLiveEndRequest hn;

    public a(IAdLiveEndRequest iAdLiveEndRequest) {
        this.hn = iAdLiveEndRequest;
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final Map<String, String> getBodyMap() {
        return this.hn.getBodyMap();
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final Map<String, String> getHeader() {
        IAdLiveEndRequest iAdLiveEndRequest = this.hn;
        if (iAdLiveEndRequest == null || iAdLiveEndRequest.getHeader() == null || this.hn.getHeader().size() <= 0) {
            return super.getHeader();
        }
        for (String str : this.hn.getHeader().keySet()) {
            if (!TextUtils.isEmpty(this.hn.getHeader().get(str))) {
                addHeader(str, this.hn.getHeader().get(str));
            }
        }
        return super.getHeader();
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return aw.appendUrl(this.hn.getUrl(), this.hn.getUrlParam());
    }
}
