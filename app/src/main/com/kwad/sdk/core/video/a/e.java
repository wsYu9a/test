package com.kwad.sdk.core.video.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.report.g;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.as;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class e {
    private static boolean Wx = false;
    private static AtomicBoolean aFJ = null;
    private static int aFK = -1;
    private static final AtomicBoolean aFL = new AtomicBoolean(false);
    private static final AtomicBoolean aFM = new AtomicBoolean(false);
    private static int aFN;

    private static boolean BU() {
        return aFM.get() || com.kwad.framework.a.a.Kv.booleanValue();
    }

    public static int HU() {
        return aFN;
    }

    private static boolean HV() {
        AtomicBoolean atomicBoolean = aFJ;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(true);
        aFJ = atomicBoolean2;
        return atomicBoolean2.get();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static c a(@NonNull Context context, boolean z10, boolean z11, boolean z12, int i10) {
        boolean z13;
        b bVar;
        b bVar2;
        try {
            if (BU() && z11 && HV()) {
                com.kwad.sdk.core.d.c.i("MediaPlayerImpl", "constructPlayer KwaiMediaPlayer");
                d dVar = new d(i10);
                aFN = 2;
                dVar.bq(z10);
                bVar2 = dVar;
            } else {
                com.kwad.sdk.core.d.c.i("MediaPlayerImpl", "constructPlayer AndroidMediaPlayer");
                b bVar3 = new b();
                aFN = 1;
                bVar2 = bVar3;
            }
            z13 = false;
            bVar = bVar2;
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.e("MediaPlayerImpl", "constructPlayer exception, using AndroidMediaPlayer", th2);
            if (!Wx) {
                Wx = true;
                com.kwad.sdk.service.c.gatherException(th2);
            }
            b bVar4 = new b();
            aFN = 1;
            z13 = true;
            bVar = bVar4;
        }
        int a10 = as.a(BU(), ServiceProvider.get(com.kwad.sdk.service.a.f.class) != null && ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).zB(), z11, HV(), z13, z12, bVar.getMediaPlayerType());
        com.kwad.sdk.core.d.c.T("KwaiPlayHelper", "player v=" + Integer.toBinaryString(a10));
        if (aFK != a10) {
            aFK = a10;
            du(a10);
        }
        return bVar;
    }

    private static void du(int i10) {
        n nVar = new n(10212L);
        nVar.aCA = i10;
        g.a2(nVar);
    }
}
