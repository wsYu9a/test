package com.kwad.library.solder.lib;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.u;
import java.io.File;
import java.io.IOException;

/* loaded from: classes3.dex */
final class c implements com.kwad.library.solder.lib.a.b {
    private final File amd;
    private final File ame;
    private final com.kwad.library.solder.lib.ext.c amf;
    private final Context mContext;

    public c(Context context, com.kwad.library.solder.lib.ext.c cVar) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.amf = cVar;
        this.amd = applicationContext.getDir(cVar.yI(), 0);
        this.ame = applicationContext.getCacheDir();
    }

    private String E(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(yf());
        String str3 = File.separator;
        sb2.append(str3);
        sb2.append(str);
        sb2.append(str3);
        sb2.append(str2);
        return sb2.toString();
    }

    @Nullable
    private String a(com.kwad.library.solder.lib.a.a aVar) {
        return F(aVar.getId(), aVar.getVersion());
    }

    private static void delete(String str) {
        u.delete(str);
    }

    private boolean i(String str, String str2, boolean z10) {
        if (!u.gG(str)) {
            return false;
        }
        if (TextUtils.isEmpty(str2) || TextUtils.equals(str2, ai.gM(str))) {
            return true;
        }
        delete(str);
        return false;
    }

    private String yf() {
        return this.amd.getAbsolutePath();
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final void D(String str, String str2) {
        File file = new File(E(str, str2));
        if (file.exists()) {
            u.S(file);
        }
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final String F(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(yf());
        String str3 = File.separator;
        sb2.append(str3);
        sb2.append(str);
        sb2.append(str3);
        sb2.append(str2);
        sb2.append(str3);
        sb2.append(this.amf.yN());
        return sb2.toString();
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final String b(com.kwad.library.solder.lib.a.a aVar) {
        String a10 = a(aVar);
        if (TextUtils.isEmpty(a10)) {
            throw new PluginError.InstallError("Can not get install path.", PluginError.ERROR_INS_INSTALL_PATH);
        }
        aVar.getId();
        File file = new File(a10);
        if (file.exists() && !this.amf.yO() && i(file.getAbsolutePath(), aVar.ys(), true)) {
            return a10;
        }
        String yr = aVar.yr();
        aVar.getId();
        File file2 = new File(yr);
        if (!file2.exists()) {
            throw new PluginError.InstallError("Plugin file not exist.", 3001);
        }
        aVar.getId();
        if (!i(yr, aVar.ys(), true)) {
            aVar.ys();
            throw new PluginError.InstallError("check plugin md5 fail:" + aVar.ys() + " " + yr, 3003);
        }
        if (file2.renameTo(file)) {
            aVar.getId();
            return a10;
        }
        try {
            ye();
            try {
                u.f(file2, file);
                u.S(file2);
                return a10;
            } catch (Throwable th2) {
                a.e("PluginInstallerImpl", th2);
                throw new PluginError.InstallError(th2, 3004);
            }
        } catch (Throwable th3) {
            a.e("PluginInstallerImpl", th3);
            throw new PluginError.InstallError(th3, 3005);
        }
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final void bI(String str) {
        File file = new File(bJ(str));
        if (file.exists()) {
            u.S(file);
        }
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final String bJ(@NonNull String str) {
        return yf() + File.separator + str;
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final File e(String str, boolean z10) {
        String md5;
        if (str == null || (md5 = com.kwad.library.solder.lib.d.b.getMD5(str)) == null) {
            return null;
        }
        if (!z10) {
            return File.createTempFile(md5 + System.currentTimeMillis(), this.amf.yM(), this.ame);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(md5);
        if (this.amf.yM() != null) {
            sb2.append(this.amf.yM());
        }
        File file = new File(this.ame, sb2.toString());
        if (file.exists() || file.createNewFile()) {
            return file;
        }
        return null;
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final void ye() {
        if (this.amd.getFreeSpace() < 10000000) {
            throw new IOException("No enough capacity.");
        }
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final boolean a(String str, String str2, String str3) {
        if (this.amf.yO()) {
            return false;
        }
        return i(F(str, str2), str3, true);
    }
}
