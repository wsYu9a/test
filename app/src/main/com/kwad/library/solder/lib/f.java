package com.kwad.library.solder.lib;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.library.solder.lib.a.f;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.u;
import java.io.File;

/* loaded from: classes3.dex */
final class f implements com.kwad.library.solder.lib.a.f {
    private f.a ams;
    private final Context mContext;

    public f(Context context) {
        this.mContext = context.getApplicationContext();
    }

    private static void e(com.kwad.library.solder.lib.a.e eVar) {
        eVar.getState();
        eVar.yt().yk().o(eVar);
    }

    private static void f(com.kwad.library.solder.lib.a.e eVar) {
        eVar.getState();
        eVar.bP(0);
        eVar.yt().yk().n(eVar);
    }

    private static void l(com.kwad.library.solder.lib.a.e eVar) {
        eVar.getState();
        eVar.yt().yk().p(eVar);
    }

    @Override // com.kwad.library.solder.lib.a.f
    public final com.kwad.library.solder.lib.a.f a(f.a aVar) {
        this.ams = aVar;
        return this;
    }

    @Override // com.kwad.library.solder.lib.a.f
    public final boolean k(@NonNull com.kwad.library.solder.lib.a.e eVar) {
        eVar.yx();
        eVar.bQ("Update");
        e(eVar);
        if (eVar.yy()) {
            eVar.yt().yj().bI(eVar.yx());
        }
        if (eVar.isCanceled()) {
            f(eVar);
            return false;
        }
        try {
            eVar.yt().yj().ye();
            if (eVar.yC()) {
                try {
                    File e10 = eVar.yt().yj().e(eVar.yD(), false);
                    if (eVar.isCanceled()) {
                        f(eVar);
                        return false;
                    }
                    try {
                        u.a(this.mContext, eVar.yD(), e10);
                        eVar.bR(e10.getAbsolutePath());
                        eVar.bP(3);
                        l(eVar);
                    } catch (Throwable th2) {
                        a.e("PluginUpdaterImpl", th2);
                        a(eVar, new PluginError.UpdateError(th2, 2004));
                    }
                } catch (Throwable th3) {
                    th3.getLocalizedMessage();
                    a(eVar, new PluginError.UpdateError(th3, 2003));
                    return false;
                }
            } else {
                eVar.yx();
                eVar.getDownloadUrl();
                try {
                    File e11 = eVar.yt().yj().e(eVar.getDownloadUrl(), eVar.yt().yg().yP());
                    if (eVar.yE() != null && e11.exists() && TextUtils.equals(ai.ac(e11), eVar.yE())) {
                        eVar.bR(e11.getAbsolutePath());
                        eVar.bP(4);
                        l(eVar);
                        return true;
                    }
                    try {
                        a(eVar, e11);
                        eVar.bR(e11.getAbsolutePath());
                        eVar.bP(4);
                        l(eVar);
                    } catch (PluginError.CancelError unused) {
                        f(eVar);
                        return false;
                    } catch (PluginError.UpdateError e12) {
                        a.e("PluginUpdaterImpl", "Download plugin fail, error = " + e12.getLocalizedMessage());
                        eVar.j(e12);
                        a(eVar, e12);
                        return false;
                    }
                } catch (Throwable th4) {
                    a.e("PluginUpdaterImpl", "Can not get temp file, error = " + th4.getLocalizedMessage());
                    a(eVar, new PluginError.UpdateError(th4, 2003));
                    return false;
                }
            }
            return true;
        } catch (Throwable th5) {
            a.e("PluginUpdaterImpl", th5);
            a(eVar, new PluginError.UpdateError(th5, 2005));
            return false;
        }
    }

    private static void a(com.kwad.library.solder.lib.a.e eVar, PluginError.UpdateError updateError) {
        eVar.getState();
        eVar.bP(1);
        eVar.j(updateError);
        eVar.yt().yk().c(eVar, updateError);
    }

    private void a(com.kwad.library.solder.lib.a.e eVar, File file) {
        long currentTimeMillis = System.currentTimeMillis();
        Log.d("PluginUpdaterImpl", "start download pluginId: " + eVar.yx());
        f.a aVar = this.ams;
        if (aVar != null) {
            aVar.a(eVar, file);
            Log.i("PluginUpdaterImpl", "finish download pluginId: " + eVar.yx() + " cost:" + (System.currentTimeMillis() - currentTimeMillis));
            return;
        }
        throw new PluginError.UpdateError("update ", 2008);
    }
}
