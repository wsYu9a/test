package com.kwai.sodler.lib;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.q;
import com.kwai.sodler.lib.a.g;
import com.kwai.sodler.lib.ext.PluginError;
import java.io.File;

/* loaded from: classes2.dex */
final class e implements com.kwai.sodler.lib.a.g {
    private g.a aJP;
    private final Context mContext;

    e(Context context) {
        this.mContext = context.getApplicationContext();
    }

    @TargetApi(11)
    private void a(int i2, @NonNull com.kwai.sodler.lib.a.f fVar) {
        if (i2 == 0) {
            com.kwai.sodler.lib.c.b k = f.k(fVar);
            if (k != null) {
                StringBuilder sb = new StringBuilder("Download new plugin, version = ");
                sb.append(k.version);
                sb.append(", url = ");
                sb.append(k.aKU);
                fVar.dl(3);
                fVar.fW(k.aKU);
                fVar.as(k.aKV);
                fVar.fV(k.aKW);
                fVar.fP(k.version);
                return;
            }
        } else if (i2 != -1) {
            return;
        }
        fVar.dl(-3);
    }

    private static void a(com.kwai.sodler.lib.a.f fVar) {
        new StringBuilder("onCanceled state = ").append(fVar.getState());
        fVar.dl(-7);
        fVar.JA().Js().o(fVar);
    }

    private void a(com.kwai.sodler.lib.a.f fVar, PluginError.UpdateError updateError) {
        new StringBuilder("onError state = ").append(fVar.getState());
        fVar.dl(-4);
        fVar.q(updateError);
        fVar.JP();
        b(fVar);
    }

    private void a(com.kwai.sodler.lib.a.f fVar, File file) {
        long currentTimeMillis = System.currentTimeMillis();
        Log.v("Sodler.update", "start download:" + fVar.getId());
        g.a aVar = this.aJP;
        if (aVar == null) {
            throw new PluginError.UpdateError("update ", 2008);
        }
        aVar.a(fVar, file);
        Log.v("Sodler.update", "finish download:" + fVar.getId() + " cost:" + (System.currentTimeMillis() - currentTimeMillis));
    }

    private static void b(com.kwai.sodler.lib.a.f fVar) {
        new StringBuilder("onPostUpdate state = ").append(fVar.getState());
        fVar.JA().Js().q(fVar);
    }

    private static void c(com.kwai.sodler.lib.a.f fVar) {
        new StringBuilder("onPreUpdate state = ").append(fVar.getState());
        fVar.JA().Js().p(fVar);
    }

    private com.kwai.sodler.lib.a.f j(com.kwai.sodler.lib.a.f fVar) {
        if (fVar.JE()) {
            fVar.JA().Jq().fK(fVar.getId());
        }
        try {
        } catch (Exception e2) {
            a.w("Sodler.update", "Request remote plugin info fail, error = " + e2.toString());
            a.e("Sodler.update", e2);
            fVar.dl(-2);
            fVar.q(new PluginError.UpdateError(e2, PluginError.ERROR_UPD_REQUEST));
        }
        if (fVar.JJ()) {
            com.kwai.sodler.lib.c.b k = f.k(fVar);
            fVar.dl(2);
            fVar.fP(k.version);
            return fVar;
        }
        if (!fVar.JJ() && fVar.JN() == null) {
            fVar.JA().Jr().e(fVar);
        }
        if (TextUtils.isEmpty(fVar.getId())) {
            a(-1, fVar);
            return fVar;
        }
        a(0, fVar);
        return fVar;
    }

    @Override // com.kwai.sodler.lib.a.g
    public final com.kwai.sodler.lib.a.g a(g.a aVar) {
        this.aJP = aVar;
        return this;
    }

    @Override // com.kwai.sodler.lib.a.g
    public final com.kwai.sodler.lib.a.f i(@NonNull com.kwai.sodler.lib.a.f fVar) {
        new StringBuilder("Start update, id = ").append(fVar.getId());
        fVar.fS("Update");
        c(fVar);
        j(fVar);
        if (fVar.isCanceled()) {
            a(fVar);
            return fVar;
        }
        if (fVar.getState() == 2) {
            try {
                fVar.JA().Jq().Jj();
                try {
                    File h2 = fVar.JA().Jq().h(fVar.JK(), false);
                    if (fVar.isCanceled()) {
                        a(fVar);
                        return fVar;
                    }
                    try {
                        q.a(this.mContext, fVar.JK(), h2);
                        fVar.fT(h2.getAbsolutePath());
                        fVar.dl(1);
                        b(fVar);
                        return fVar;
                    } catch (Throwable th) {
                        a.e("Sodler.update", th);
                        a(fVar, new PluginError.UpdateError(th, PluginError.ERROR_UPD_EXTRACT));
                        return fVar;
                    }
                } catch (Throwable th2) {
                    new StringBuilder("Can not get temp file, error = ").append(th2.getLocalizedMessage());
                    a.e("Sodler.update", th2);
                    a(fVar, new PluginError.UpdateError(th2, 2003));
                    return fVar;
                }
            } catch (Throwable th3) {
                a.e("Sodler.update", th3);
                a(fVar, new PluginError.UpdateError(th3, PluginError.ERROR_UPD_CAPACITY));
                return fVar;
            }
        }
        if (fVar.getState() != 3) {
            b(fVar);
            return fVar;
        }
        try {
            fVar.JA().Jq().Jj();
            try {
                File h3 = fVar.JA().Jq().h(fVar.getDownloadUrl(), fVar.JA().Jn().JX());
                if (fVar.JL() != null && h3.exists() && TextUtils.equals(ad.W(h3), fVar.JL())) {
                    fVar.fT(h3.getAbsolutePath());
                    fVar.dl(1);
                    b(fVar);
                    return fVar;
                }
                try {
                    a(fVar, h3);
                    fVar.fT(h3.getAbsolutePath());
                    fVar.dl(1);
                    b(fVar);
                    return fVar;
                } catch (PluginError.CancelError unused) {
                    a(fVar);
                    return fVar;
                } catch (PluginError.UpdateError e2) {
                    new StringBuilder("Download plugin fail, error = ").append(e2.getLocalizedMessage());
                    a.e("Sodler.update", e2);
                    fVar.q(e2);
                    a(fVar, e2);
                    return fVar;
                }
            } catch (Throwable th4) {
                new StringBuilder("Can not get temp file, error = ").append(th4.getLocalizedMessage());
                a.e("Sodler.update", th4);
                a(fVar, new PluginError.UpdateError(th4, 2003));
                return fVar;
            }
        } catch (Throwable th5) {
            a.e("Sodler.update", th5);
            a(fVar, new PluginError.UpdateError(th5, PluginError.ERROR_UPD_CAPACITY));
            return fVar;
        }
    }
}
