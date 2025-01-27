package com.kwad.components.core.n.b.b;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.ILive;
import com.kwad.sdk.components.d;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes3.dex */
public final class a implements ILive {
    @Override // com.kwad.components.offline.api.core.adlive.ILive
    public final IAdLivePlayModule getAdLivePlayModule(IAdLiveOfflineView iAdLiveOfflineView, String str, String str2, String str3, long j10) {
        com.kwad.components.core.n.a.a.a aVar = (com.kwad.components.core.n.a.a.a) d.f(com.kwad.components.core.n.a.a.a.class);
        if (aVar == null || !aVar.pz()) {
            return null;
        }
        return aVar.getAdLivePlayModule(iAdLiveOfflineView, str, str2, str3, j10);
    }

    @Override // com.kwad.components.offline.api.core.adlive.ILive
    public final IAdLiveOfflineView getIAdLiveOfflineView(Context context, int i10) {
        com.kwad.components.core.n.a.a.a aVar = (com.kwad.components.core.n.a.a.a) d.f(com.kwad.components.core.n.a.a.a.class);
        if (aVar != null && aVar.pz()) {
            try {
                return aVar.getView(context, i10);
            } catch (Throwable th2) {
                ServiceProvider.reportSdkCaughtException(th2);
            }
        }
        return null;
    }

    @Override // com.kwad.components.offline.api.core.adlive.ILive
    public final IAdLiveEndRequest mIAdLiveEndRequest(String str) {
        com.kwad.components.core.n.a.a.a aVar;
        if (TextUtils.isEmpty(str) || (aVar = (com.kwad.components.core.n.a.a.a) d.f(com.kwad.components.core.n.a.a.a.class)) == null || !aVar.pz()) {
            return null;
        }
        return aVar.getAdLiveEndRequest(str);
    }
}
