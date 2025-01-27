package com.kwai.sodler.lib;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.q;
import com.kwai.sodler.lib.ext.PluginError;
import java.io.File;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
final class d implements com.kwai.sodler.lib.a.d {
    private final ConcurrentHashMap<String, com.kwai.sodler.lib.a.a> aJO = new ConcurrentHashMap<>();
    private final Context mContext;

    d(Context context) {
        this.mContext = context.getApplicationContext();
    }

    private static void a(com.kwai.sodler.lib.a.f fVar) {
        new StringBuilder("onCanceled state = ").append(fVar.getState());
        fVar.dl(-7);
        fVar.JA().Js().o(fVar);
    }

    private com.kwai.sodler.lib.a.a b(com.kwai.sodler.lib.a.f fVar, com.kwai.sodler.lib.a.a aVar) {
        String Jx = aVar.Jx();
        File file = new File(Jx);
        new StringBuilder("Loading plugin, path = ").append(Jx);
        com.kwai.sodler.lib.a.e JA = fVar.JA();
        if (!file.exists()) {
            throw new PluginError.LoadError("Apk file not exist.", 3001);
        }
        String id = fVar.getId();
        String version = fVar.getVersion();
        com.kwai.sodler.lib.a.a fM = fM(id);
        if (fM != null) {
            new StringBuilder("The current plugin has been loaded, id = ").append(version);
            return fM;
        }
        aVar.fQ(id);
        aVar.fP(version);
        if (JA.Jq().aw(id, version)) {
            String av = JA.Jq().av(id, version);
            if (q.ev(av)) {
                aVar.fR(av);
                aVar.au(this.mContext, av);
                b(id, aVar);
                return aVar;
            }
        }
        String b2 = JA.Jq().b(aVar);
        aVar.fR(b2);
        new StringBuilder("installed .").append(b2);
        aVar.au(this.mContext, b2);
        b(id, aVar);
        if (Jx.endsWith(JA.Jn().JU())) {
            q.delete(Jx);
        }
        return aVar;
    }

    private void b(com.kwai.sodler.lib.a.f fVar, PluginError pluginError) {
        new StringBuilder("onError state = ").append(fVar.getState());
        fVar.dl(-5);
        fVar.q(pluginError);
        h(fVar);
    }

    private synchronized void b(String str, com.kwai.sodler.lib.a.a aVar) {
        if (aVar != null) {
            if (aVar.isLoaded()) {
                this.aJO.put(str, aVar);
            }
        }
    }

    private static void g(com.kwai.sodler.lib.a.f fVar) {
        new StringBuilder("onPreLoad state = ").append(fVar.getState());
        fVar.JA().Js();
    }

    private static void h(com.kwai.sodler.lib.a.f fVar) {
        PluginError loadError;
        new StringBuilder("onPostLoad state = ").append(fVar.getState());
        if (fVar.getState() == 0) {
            com.kwai.sodler.lib.a.a JH = fVar.JH();
            if (JH != null) {
                fVar.JA().Js().c(fVar, JH);
                return;
            }
            fVar.dl(-1);
        }
        if (fVar.JC() != null) {
            loadError = fVar.JC() instanceof PluginError ? (PluginError) fVar.JC() : new PluginError.LoadError(fVar.JC(), 4011);
        } else {
            loadError = new PluginError.LoadError("Can not get plugin instance " + fVar.getState(), 4011);
        }
        fVar.JA().Js().c(fVar, loadError);
    }

    @Override // com.kwai.sodler.lib.a.d
    public final com.kwai.sodler.lib.a.f f(@NonNull com.kwai.sodler.lib.a.f fVar) {
        new StringBuilder("Loading plugin, id = ").append(fVar.getId());
        fVar.fS("Load");
        g(fVar);
        if (fVar.isCanceled()) {
            a(fVar);
            return fVar;
        }
        fVar.JO();
        com.kwai.sodler.lib.a.a aVar = this.aJO.get(fVar.getId());
        if (aVar != null && aVar.isLoaded()) {
            fVar.c(aVar);
            new StringBuilder("Load plugin success, path = ").append(aVar.Jx());
            fVar.dl(0);
            h(fVar);
            return fVar;
        }
        List<com.kwai.sodler.lib.c.a> JM = fVar.JM();
        com.kwai.sodler.lib.c.b k = f.k(fVar);
        if (k == null) {
            fVar.dl(-1);
            h(fVar);
            return fVar;
        }
        com.kwai.sodler.lib.c.a aVar2 = null;
        if (JM != null && !JM.isEmpty()) {
            for (com.kwai.sodler.lib.c.a aVar3 : JM) {
                if (k.version.equals(aVar3.version)) {
                    aVar2 = aVar3;
                } else {
                    fVar.JA().Jq().at(fVar.getId(), aVar3.version);
                }
            }
        }
        if (aVar2 != null) {
            String av = fVar.JA().Jq().av(aVar2.aKT, aVar2.version);
            new StringBuilder("-------本地已存在--------").append(av);
            fVar.fT(av);
            fVar.fU(av);
            fVar.dl(1);
            fVar.fP(aVar2.version);
        } else {
            if (!ag.isWifiConnected(this.mContext) && (k.aKX || (k.aKY && fVar.JF() > 0))) {
                b(fVar, new PluginError.NotWifiDownloadError("It can be downloaded only on WiFi", PluginError.ERROR_UPD_NOT_WIFI_DOWNLOAD));
                return fVar;
            }
            fVar.JA().Jp().i(fVar);
        }
        if (fVar.getState() != 1) {
            h(fVar);
            return fVar;
        }
        String JG = fVar.JG();
        new StringBuilder("-------更新成功或者获取到本地成功------------").append(JG);
        if (TextUtils.isEmpty(JG)) {
            fVar.dl(-1);
            h(fVar);
            return fVar;
        }
        com.kwai.sodler.lib.a.a a2 = fVar.fX(JG).a(k);
        if (fVar.isCanceled()) {
            a(fVar);
            return fVar;
        }
        try {
            fVar.c(b(fVar, a2));
            new StringBuilder("Load plugin success, path = ").append(JG);
            fVar.dl(0);
            h(fVar);
            return fVar;
        } catch (PluginError.InstallError e2) {
            e = e2;
            b(fVar, e);
            return fVar;
        } catch (PluginError.LoadError e3) {
            e = e3;
            b(fVar, e);
            return fVar;
        } catch (Throwable th) {
            a.e("Sodler.loader", "Load plugin failed, path = " + JG, th);
            b(fVar, new PluginError.InstallError("Load or install plugin failed", 4004));
            return fVar;
        }
    }

    @Override // com.kwai.sodler.lib.a.d
    public final synchronized com.kwai.sodler.lib.a.a fM(String str) {
        com.kwai.sodler.lib.a.a aVar = this.aJO.get(str);
        if (aVar != null) {
            if (!aVar.isLoaded()) {
                return null;
            }
        }
        return aVar;
    }
}
