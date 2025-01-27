package com.kwad.sdk.utils;

import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes3.dex */
public final class q {
    private static boolean aSX;
    private static boolean aSY;

    public static boolean MV() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ac(2L)) & aSX;
    }

    public static boolean MW() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ac(4L)) & aSX;
    }

    public static boolean MX() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ac(2048L)) & aSX;
    }

    public static boolean MY() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).zN() && aSX;
    }

    public static boolean MZ() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ac(16L)) & aSX;
    }

    public static boolean Na() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ac(4096L)) & aSX;
    }

    public static boolean Nb() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ac(1L)) & aSX;
    }

    public static boolean Nc() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ac(128L)) & aSX;
    }

    public static boolean Nd() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ac(128L)) & aSX;
    }

    public static synchronized void bU(boolean z10) {
        synchronized (q.class) {
            if (aSY) {
                return;
            }
            aSY = true;
            aSX = true;
            ((com.kwad.sdk.service.a.b) ServiceProvider.get(com.kwad.sdk.service.a.b.class)).zx();
        }
    }
}
