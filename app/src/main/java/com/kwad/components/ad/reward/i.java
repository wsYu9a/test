package com.kwad.components.ad.reward;

import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public final class i {
    private Map<String, List<AdTemplate>> rC;

    public static class a {
        private static final i rD = new i((byte) 0);
    }

    public /* synthetic */ i(byte b10) {
        this();
    }

    public static i gD() {
        return a.rD;
    }

    public final void D(String str) {
        this.rC.remove(str);
    }

    private i() {
        this.rC = new ConcurrentHashMap();
    }
}
