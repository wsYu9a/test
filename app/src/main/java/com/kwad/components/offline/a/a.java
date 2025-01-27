package com.kwad.components.offline.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.adLive.IAdLiveOfflineCompo;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;

/* loaded from: classes3.dex */
public class a implements com.kwad.components.core.n.a.a.a {
    private final IAdLiveOfflineCompo afE;

    public a(@NonNull IAdLiveOfflineCompo iAdLiveOfflineCompo) {
        this.afE = iAdLiveOfflineCompo;
    }

    @Override // com.kwad.components.core.n.a.a.a
    public final IAdLiveEndRequest getAdLiveEndRequest(String str) {
        return this.afE.getAdLiveEndRequest(str);
    }

    @Override // com.kwad.components.core.n.a.a.a
    public final IAdLivePlayModule getAdLivePlayModule(IAdLiveOfflineView iAdLiveOfflineView, String str, String str2, String str3, long j10) {
        return this.afE.getAdLivePlayModule(iAdLiveOfflineView, str, str2, str3, j10);
    }

    @Override // com.kwad.sdk.components.b
    public final Class<a> getComponentsType() {
        return a.class;
    }

    @Override // com.kwad.components.core.n.a.a.a
    public final IAdLiveOfflineView getView(Context context, int i10) {
        return this.afE.getView(context, i10);
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    @Override // com.kwad.sdk.components.b
    public final int priority() {
        return this.afE.priority();
    }

    @Override // com.kwad.components.core.n.a.a.a
    public final boolean pz() {
        return this.afE.getState() == IAdLiveOfflineCompo.AdLiveState.READY;
    }
}
