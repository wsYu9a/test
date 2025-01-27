package com.kwad.components.ad;

import androidx.annotation.NonNull;
import com.kwad.components.core.internal.api.c;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class b implements com.kwad.components.core.internal.api.a {
    public c bz = new c();

    @NonNull
    protected final AdResultData mAdResultData;

    @NonNull
    protected final AdTemplate mAdTemplate;

    public b(@NonNull AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.o(adResultData);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void a(com.kwad.components.core.internal.api.b bVar) {
        this.bz.a(bVar);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void b(com.kwad.components.core.internal.api.b bVar) {
        this.bz.b(bVar);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    public int getECPM() {
        return com.kwad.sdk.core.response.b.a.aR(e.eb(this.mAdTemplate));
    }

    public int getInteractionType() {
        return com.kwad.sdk.core.response.b.a.aQ(e.eb(this.mAdTemplate));
    }

    public int getMaterialType() {
        return com.kwad.sdk.core.response.b.a.be(e.eb(this.mAdTemplate));
    }

    public Map<String, Object> getMediaExtraInfo() {
        HashMap hashMap = new HashMap();
        if (d.Dx()) {
            hashMap.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return hashMap;
    }

    public boolean isVideo() {
        return com.kwad.sdk.core.response.b.a.bc(e.eb(this.mAdTemplate));
    }

    public void reportAdExposureFailed(int i10, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, i10, adExposureFailedReason);
    }

    public void setBidEcpm(int i10) {
        setBidEcpm(i10, -1L);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final boolean supportPushAd() {
        return true;
    }

    public void setBidEcpm(long j10, long j11) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = j10;
        com.kwad.sdk.core.adlog.c.l(adTemplate, j10);
    }
}
