package com.kwad.components.ad.k;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes2.dex */
public final class b {
    @Nullable
    public static IAdLiveOfflineView a(com.kwad.components.core.n.a.a.a aVar, Context context, int i10) {
        try {
            return aVar.getView(context, i10);
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTrace(th2);
            ServiceProvider.reportSdkCaughtException(th2);
            return null;
        }
    }
}
