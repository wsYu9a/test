package com.kwad.sdk.crash.online.monitor.block;

import java.util.Random;

/* loaded from: classes2.dex */
public final class d {
    private static com.kwad.sdk.crash.online.monitor.kwai.a arZ;

    public static void d(com.kwad.sdk.crash.online.monitor.kwai.a aVar) {
        if (aVar == null) {
            return;
        }
        try {
            if (aVar.Ab()) {
                com.kwad.sdk.core.d.b.d("perfMonitor.BlockManager", "allFuncDisable");
                return;
            }
            if (!a.zS()) {
                com.kwad.sdk.core.d.b.d("perfMonitor.BlockManager", "!hasBlockMonitor");
                return;
            }
            a.a(aVar);
            arZ = aVar;
            boolean bi = a.bi(true);
            com.kwad.sdk.core.d.b.d("perfMonitor.BlockManager", "hasTenBlockHook:" + bi);
            if (aVar.aii < new Random().nextFloat()) {
                return;
            }
            b.a(aVar);
            if (aVar.zZ() && bi) {
                BlockInjector.b(aVar);
            }
            if (aVar.Aa()) {
                boolean bj = a.bj(false);
                com.kwad.sdk.core.d.b.d("perfMonitor.BlockManager", "hasOtherBlockMonitor:" + bj);
                if (bj) {
                    BlockInjector.tryProxyOtherOutput(aVar);
                }
            }
        } catch (Throwable th) {
            try {
                com.kwad.sdk.crash.b.g(th);
            } catch (Exception unused) {
            }
        }
    }

    public static com.kwad.sdk.crash.online.monitor.kwai.a zU() {
        return arZ;
    }

    public static boolean zV() {
        com.kwad.sdk.crash.online.monitor.kwai.a aVar = arZ;
        return aVar != null && aVar.zY();
    }
}
