package com.kwad.library.solder.lib;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.u;
import java.io.File;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
final class d implements com.kwad.library.solder.lib.a.c {
    private final ConcurrentHashMap<String, com.kwad.library.solder.lib.a.a> amg = new ConcurrentHashMap<>();
    private final Context mContext;

    public d(Context context) {
        this.mContext = context.getApplicationContext();
    }

    private synchronized void a(String str, com.kwad.library.solder.lib.a.a aVar) {
        if (aVar != null) {
            if (aVar.isLoaded()) {
                this.amg.put(str, aVar);
            }
        }
    }

    private static void b(com.kwad.library.solder.lib.a.e eVar) {
        eVar.getState();
        eVar.bP(7);
        eVar.yt().yk().r(eVar);
    }

    private static void c(com.kwad.library.solder.lib.a.e eVar) {
        eVar.getState();
        eVar.yt().yk().q(eVar);
    }

    private static void f(com.kwad.library.solder.lib.a.e eVar) {
        eVar.getState();
        eVar.bP(0);
        eVar.yt().yk().n(eVar);
    }

    private com.kwad.library.solder.lib.a.a h(com.kwad.library.solder.lib.a.e eVar) {
        b(eVar);
        com.kwad.library.solder.lib.a.a a10 = eVar.bT(eVar.yA()).a(eVar.yF());
        String yr = a10.yr();
        File file = new File(yr);
        eVar.yx();
        com.kwad.library.solder.lib.a.d yt = eVar.yt();
        if (!file.exists()) {
            throw new PluginError.LoadError("Apk file not exist.", 3001);
        }
        String yx = eVar.yx();
        String version = eVar.getVersion();
        com.kwad.library.solder.lib.a.a bK = bK(yx);
        if (bK != null) {
            a(eVar);
            return bK;
        }
        a10.bO(yx);
        a10.bN(version);
        if (yt.yj().a(yx, version, eVar.yE())) {
            String F = yt.yj().F(yx, version);
            if (u.gF(F)) {
                a10.bP(F);
                a10.m(this.mContext, F);
                a(yx, a10);
                a(eVar);
                return a10;
            }
        }
        String b10 = yt.yj().b(a10);
        a10.bP(b10);
        a10.m(this.mContext, b10);
        a(yx, a10);
        if (yr.endsWith(yt.yg().yM())) {
            u.delete(yr);
        }
        a(eVar);
        return a10;
    }

    @Override // com.kwad.library.solder.lib.a.c
    public final synchronized com.kwad.library.solder.lib.a.a bK(String str) {
        com.kwad.library.solder.lib.a.a aVar = this.amg.get(str);
        if (aVar != null) {
            if (!aVar.isLoaded()) {
                return null;
            }
        }
        return aVar;
    }

    @Override // com.kwad.library.solder.lib.a.c
    public final void g(@NonNull com.kwad.library.solder.lib.a.e eVar) {
        eVar.yx();
        eVar.bQ("Load");
        c(eVar);
        if (eVar.isCanceled()) {
            f(eVar);
            return;
        }
        com.kwad.library.solder.lib.a.a aVar = this.amg.get(eVar.yx());
        if (aVar != null && aVar.isLoaded()) {
            eVar.c(aVar);
            eVar.yx();
            aVar.yr();
            a(eVar, aVar);
            return;
        }
        com.kwad.library.solder.lib.c.b yF = eVar.yF();
        if (yF == null) {
            b(eVar, new PluginError.LoadError("not pluginInfo", 2006));
            return;
        }
        List<com.kwad.library.solder.lib.c.a> yG = eVar.yG();
        com.kwad.library.solder.lib.c.a aVar2 = null;
        if (yG != null && !yG.isEmpty()) {
            for (com.kwad.library.solder.lib.c.a aVar3 : yG) {
                if (eVar.getVersion().equals(aVar3.version)) {
                    aVar2 = aVar3;
                } else {
                    eVar.yt().yj().D(eVar.yx(), aVar3.version);
                }
            }
        }
        if (aVar2 != null) {
            String F = eVar.yt().yj().F(aVar2.ann, aVar2.version);
            eVar.bR(F);
            eVar.bS(F);
            eVar.bP(2);
            eVar.bN(aVar2.version);
        } else {
            if (!al.isWifiConnected(this.mContext) && (yF.anr || (yF.ans && eVar.yz() > 0))) {
                b(eVar, new PluginError.NotWifiDownloadError("It can be downloaded only on WiFi", 2007));
                return;
            }
            try {
                if (!eVar.yt().yi().k(eVar)) {
                    return;
                }
            } catch (Throwable th2) {
                b(eVar, new PluginError.UpdateError(th2, 2006));
                return;
            }
        }
        if (eVar.getState() != 2 && eVar.getState() != 3 && eVar.getState() != 4) {
            b(eVar, new PluginError.InstallError("state exception", 2002));
            return;
        }
        String yA = eVar.yA();
        eVar.yx();
        if (TextUtils.isEmpty(yA)) {
            b(eVar, new PluginError.LoadError("path not found", PluginError.ERROR_UPD_FILE_NOT_FOUND));
            return;
        }
        if (eVar.isCanceled()) {
            f(eVar);
            return;
        }
        try {
            com.kwad.library.solder.lib.a.a h10 = h(eVar);
            eVar.c(h10);
            eVar.yx();
            a(eVar, h10);
        } catch (PluginError.InstallError e10) {
            e = e10;
            b(eVar, e);
        } catch (PluginError.LoadError e11) {
            e = e11;
            b(eVar, e);
        } catch (Throwable th3) {
            a.e("PluginLoaderImpl", "load plugin failed, path = " + yA, th3);
            b(eVar, new PluginError.InstallError("load or install plugin failed:" + th3.getMessage(), 4004));
        }
    }

    private static void b(com.kwad.library.solder.lib.a.e eVar, PluginError pluginError) {
        eVar.getState();
        eVar.bP(6);
        eVar.j(pluginError);
        eVar.yt().yk().c(eVar, pluginError);
    }

    private static void a(com.kwad.library.solder.lib.a.e eVar) {
        eVar.getState();
        eVar.bP(8);
        eVar.yt().yk().a(eVar);
    }

    private static void a(com.kwad.library.solder.lib.a.e eVar, com.kwad.library.solder.lib.a.a aVar) {
        eVar.getState();
        eVar.bP(5);
        eVar.yt().yk().b(eVar, aVar);
    }
}
