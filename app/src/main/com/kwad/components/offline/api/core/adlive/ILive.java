package com.kwad.components.offline.api.core.adlive;

import android.content.Context;

/* loaded from: classes3.dex */
public interface ILive {
    IAdLivePlayModule getAdLivePlayModule(IAdLiveOfflineView iAdLiveOfflineView, String str, String str2, String str3, long j10);

    IAdLiveOfflineView getIAdLiveOfflineView(Context context, int i10);

    IAdLiveEndRequest mIAdLiveEndRequest(String str);
}
