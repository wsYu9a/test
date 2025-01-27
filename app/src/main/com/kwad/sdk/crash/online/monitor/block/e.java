package com.kwad.sdk.crash.online.monitor.block;

import com.kwad.sdk.service.ServiceProvider;
import java.util.Random;

/* loaded from: classes3.dex */
public final class e {
    private static com.kwad.sdk.crash.online.monitor.a.a aLi;

    public static com.kwad.sdk.crash.online.monitor.a.a JF() {
        return aLi;
    }

    public static boolean JG() {
        com.kwad.sdk.crash.online.monitor.a.a aVar = aLi;
        return aVar != null && aVar.JJ();
    }

    public static void d(com.kwad.sdk.crash.online.monitor.a.a aVar) {
        if (aVar == null) {
            return;
        }
        try {
            if (aVar.JM()) {
                com.kwad.sdk.core.d.c.d("perfMonitor.BlockManager", "allFuncDisable");
                return;
            }
            if (!a.JD()) {
                com.kwad.sdk.core.d.c.d("perfMonitor.BlockManager", "!hasBlockMonitor");
                return;
            }
            a.a(aVar);
            aLi = aVar;
            boolean bD = a.bD(true);
            com.kwad.sdk.core.d.c.d("perfMonitor.BlockManager", "hasTenBlockHook:" + bD);
            if (aVar.arO < new Random().nextFloat()) {
                return;
            }
            b.a(aVar);
            if (aVar.JK() && bD) {
                c.b(aVar);
            }
            if (aVar.JL()) {
                com.kwad.sdk.core.d.c.d("perfMonitor.BlockManager", "hasOtherBlockMonitor:" + a.bE(false));
            }
        } catch (Throwable th2) {
            try {
                ServiceProvider.reportSdkCaughtException(th2);
            } catch (Exception unused) {
            }
        }
    }
}
