package com.kwad.components.offline.c.a;

import com.kwad.components.offline.api.tk.IOfflineApkLoader;
import com.kwad.components.offline.api.tk.IOfflineApkLoaderHolder;
import com.kwad.sdk.components.k;

/* loaded from: classes3.dex */
public final class e implements IOfflineApkLoaderHolder {
    private k acr;

    public e(k kVar) {
        this.acr = kVar;
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoaderHolder
    public final IOfflineApkLoader getApkLoader(int i10) {
        return new d(this.acr.aT(i10));
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoaderHolder
    public final IOfflineApkLoader getApkLoader(String str) {
        return new d(this.acr.aY(str));
    }
}
