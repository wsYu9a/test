package com.kwad.sdk.core.videocache.d;

import com.kwad.sdk.core.videocache.n;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class b implements c {
    private HashMap<String, n> aGX = new HashMap<>();

    @Override // com.kwad.sdk.core.videocache.d.c
    public final void a(String str, n nVar) {
        this.aGX.put(str, nVar);
    }

    @Override // com.kwad.sdk.core.videocache.d.c
    public final n eV(String str) {
        if (this.aGX.containsKey(str)) {
            return this.aGX.get(str);
        }
        return null;
    }
}
