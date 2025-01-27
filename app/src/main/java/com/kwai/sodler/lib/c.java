package com.kwai.sodler.lib;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.q;
import com.kwai.sodler.lib.ext.PluginError;
import java.io.File;
import java.io.IOException;

/* loaded from: classes2.dex */
final class c implements com.kwai.sodler.lib.a.c {
    private final File aJL;
    private final File aJM;
    private final com.kwai.sodler.lib.ext.c aJN;
    private final Context mContext;

    c(Context context, com.kwai.sodler.lib.ext.c cVar) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.aJN = cVar;
        this.aJL = applicationContext.getDir(cVar.JQ(), 0);
        this.aJM = applicationContext.getCacheDir();
    }

    private String Jk() {
        return this.aJL.getAbsolutePath();
    }

    @Nullable
    private String a(com.kwai.sodler.lib.a.a aVar) {
        return av(aVar.getId(), aVar.getVersion());
    }

    private static boolean a(String str, com.kwai.sodler.lib.a.a aVar) {
        if (!q.ew(str)) {
            a.w("Sodler.installer", "Plugin not found, path = " + str);
            return false;
        }
        if (aVar != null && !TextUtils.isEmpty(aVar.Jy()) && !TextUtils.equals(ad.W(new File(str)), aVar.Jy())) {
            return false;
        }
        new StringBuilder("Check plugin's signatures success, path = ").append(str);
        return true;
    }

    private boolean a(String str, com.kwai.sodler.lib.a.a aVar, boolean z) {
        if (a(str, aVar)) {
            return true;
        }
        delete(str);
        return false;
    }

    private void as(String str, String str2) {
        q.delete(av(str, str2));
    }

    private String au(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(Jk());
        String str3 = File.separator;
        sb.append(str3);
        sb.append(str);
        sb.append(str3);
        sb.append(str2);
        return sb.toString();
    }

    private static void delete(String str) {
        q.delete(str);
    }

    private boolean m(String str, String str2, boolean z) {
        if (a(av(str, str2), null)) {
            return true;
        }
        as(str, str2);
        return false;
    }

    @Override // com.kwai.sodler.lib.a.c
    public final void Jj() {
        if (this.aJL.getFreeSpace() < 10000000) {
            throw new IOException("No enough capacity.");
        }
    }

    @Override // com.kwai.sodler.lib.a.c
    public final void at(String str, String str2) {
        File file = new File(au(str, str2));
        if (file.exists()) {
            q.M(file);
        }
    }

    @Override // com.kwai.sodler.lib.a.c
    public final String av(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(Jk());
        String str3 = File.separator;
        sb.append(str3);
        sb.append(str);
        sb.append(str3);
        sb.append(str2);
        sb.append(str3);
        sb.append(this.aJN.JV());
        return sb.toString();
    }

    @Override // com.kwai.sodler.lib.a.c
    public final boolean aw(String str, String str2) {
        if (this.aJN.JW()) {
            return false;
        }
        return m(str, str2, true);
    }

    @Override // com.kwai.sodler.lib.a.c
    public final String b(com.kwai.sodler.lib.a.a aVar) {
        String a2 = a(aVar);
        if (TextUtils.isEmpty(a2)) {
            throw new PluginError.InstallError("Can not get install path.", PluginError.ERROR_INS_INSTALL_PATH);
        }
        new StringBuilder("Install path = ").append(a2);
        File file = new File(a2);
        if (file.exists() && !this.aJN.JW() && a(file.getAbsolutePath(), aVar, true)) {
            return a2;
        }
        String Jx = aVar.Jx();
        new StringBuilder("Install plugin, path = ").append(Jx);
        File file2 = new File(Jx);
        if (!file2.exists()) {
            a.w("Sodler.installer", "Plugin path not exist");
            throw new PluginError.InstallError("Plugin file not exist.", 3001);
        }
        if (!a(Jx, aVar, true)) {
            a.w("Sodler.installer", "Check plugin's signatures fail.");
            throw new PluginError.InstallError("Check plugin's signatures fail.", 3003);
        }
        StringBuilder sb = new StringBuilder("Install plugin, from = ");
        sb.append(Jx);
        sb.append(", to = ");
        sb.append(a2);
        if (file2.renameTo(file)) {
            return a2;
        }
        try {
            Jj();
            try {
                q.d(file2, file);
                q.M(file2);
                return a2;
            } catch (Throwable th) {
                a.e("Sodler.installer", th);
                throw new PluginError.InstallError(th, 3004);
            }
        } catch (Throwable th2) {
            a.e("Sodler.installer", th2);
            throw new PluginError.InstallError(th2, 3005);
        }
    }

    @Override // com.kwai.sodler.lib.a.c
    public final void fK(String str) {
        File file = new File(fL(str));
        if (file.exists()) {
            q.M(file);
        }
    }

    @Override // com.kwai.sodler.lib.a.c
    public final String fL(@NonNull String str) {
        return Jk() + File.separator + str;
    }

    @Override // com.kwai.sodler.lib.a.c
    public final File h(String str, boolean z) {
        String md5;
        if (str == null || (md5 = com.kwai.sodler.lib.d.b.getMD5(str)) == null) {
            return null;
        }
        if (!z) {
            return File.createTempFile(md5 + System.currentTimeMillis(), this.aJN.JU(), this.aJM);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(md5);
        if (this.aJN.JU() != null) {
            sb.append(this.aJN.JU());
        }
        File file = new File(this.aJM, sb.toString());
        if (file.exists() || file.createNewFile()) {
            return file;
        }
        return null;
    }
}
