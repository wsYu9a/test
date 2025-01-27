package com.kwai.sodler.lib.kwai;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import com.kwad.sdk.utils.q;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.h;
import com.kwai.sodler.lib.kwai.kwai.b;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class a extends h {
    private b aKd;
    private Resources aKe;

    public a(String str) {
        super(str);
    }

    private File af(File file) {
        File file2 = new File(file.getParentFile(), this.aJN.JR());
        q.S(file2);
        return file2;
    }

    private b g(File file, File file2) {
        if (Build.VERSION.SDK_INT < 26) {
            if (!file.canRead()) {
                file.setReadable(true);
            }
            if (!file.canWrite()) {
                file.setWritable(true);
            }
            if (!file.canRead() || !file.canWrite()) {
                file = null;
            }
        }
        File file3 = file;
        com.kwai.sodler.lib.kwai.kwai.a aVar = new com.kwai.sodler.lib.kwai.kwai.a((BaseDexClassLoader) a.class.getClassLoader());
        String absolutePath = file2.getAbsolutePath();
        String absolutePath2 = this.aKl.getAbsolutePath();
        com.kwai.sodler.lib.c.b bVar = this.aKr;
        return new b(aVar, absolutePath, file3, absolutePath2, bVar.aLb, bVar.aLa);
    }

    public final b Jv() {
        return this.aKd;
    }

    @Override // com.kwai.sodler.lib.h, com.kwai.sodler.lib.g, com.kwai.sodler.lib.a.a
    public final void as(Context context, String str) {
        super.as(context, str);
        File file = new File(str);
        try {
            this.aKd = g(af(file), file);
            try {
                this.aKe = com.kwai.sodler.lib.kwai.a.a.a(context, context.getResources(), str);
                StringBuilder sb = new StringBuilder("Install plugin mClassLoader: ");
                sb.append(this.aKd);
                sb.append(", mResources: ");
                sb.append(this.aKe);
            } catch (Exception e2) {
                Log.getStackTraceString(e2);
                throw new PluginError.LoadError(e2, 4006);
            }
        } catch (IOException e3) {
            throw new PluginError.LoadError(e3, 4002);
        }
    }

    public final Resources getResources() {
        return this.aKe;
    }
}
