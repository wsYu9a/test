package com.kwad.library.b;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import com.kwad.library.b.a.b;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.h;
import com.kwad.sdk.utils.u;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class a extends h {
    private b alI;
    private Resources alJ;

    public a(String str) {
        super(str);
    }

    private b a(File file, File file2) {
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
        com.kwad.library.b.a.a aVar = new com.kwad.library.b.a.a((BaseDexClassLoader) a.class.getClassLoader());
        String absolutePath = file2.getAbsolutePath();
        String absolutePath2 = this.amA.getAbsolutePath();
        com.kwad.library.solder.lib.c.b bVar = this.amG;
        return new b(aVar, absolutePath, file3, absolutePath2, bVar.anv, bVar.anu);
    }

    private File d(File file) {
        File file2 = new File(file.getParentFile(), this.amf.yJ());
        u.Y(file2);
        return file2;
    }

    public final Resources getResources() {
        return this.alJ;
    }

    @Override // com.kwad.library.solder.lib.h, com.kwad.library.solder.lib.g, com.kwad.library.solder.lib.a.a
    public final void h(Context context, String str) {
        super.h(context, str);
        File file = new File(str);
        try {
            File d10 = d(file);
            try {
                if (Build.VERSION.SDK_INT >= 34 && context != null && context.getApplicationInfo().targetSdkVersion >= 34) {
                    file.setReadOnly();
                    d10.setReadOnly();
                }
            } catch (Throwable unused) {
            }
            this.alI = a(d10, file);
            try {
                this.alJ = com.kwad.library.b.b.a.a(context, context.getResources(), str);
                Objects.toString(this.alI);
                Objects.toString(this.alJ);
            } catch (Exception e10) {
                Log.getStackTraceString(e10);
                throw new PluginError.LoadError(e10, 4006);
            }
        } catch (IOException e11) {
            throw new PluginError.LoadError(e11, 4002);
        }
    }

    public final b yc() {
        return this.alI;
    }
}
