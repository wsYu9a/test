package com.qq.e.comm.managers.plugin;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.qq.e.comm.managers.plugin.c;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;

/* loaded from: classes3.dex */
class g {

    /* renamed from: a */
    private final File f16599a;

    /* renamed from: b */
    private final File f16600b;

    /* renamed from: c */
    private String f16601c;

    /* renamed from: d */
    private int f16602d;

    /* renamed from: e */
    private String f16603e;

    public g(File file, File file2) {
        this.f16599a = file;
        this.f16600b = file2;
    }

    public String a() {
        return this.f16601c;
    }

    public int b() {
        return this.f16602d;
    }

    public String c() {
        return this.f16603e;
    }

    public boolean a(File file, File file2, Context context) {
        if (file.equals(this.f16599a) || h.a(this.f16599a, file, context, true)) {
            return file2.equals(this.f16600b) || h.a(this.f16600b, file2, context, false);
        }
        return false;
    }

    public boolean a(Context context, boolean z10) {
        int i10;
        try {
            if (this.f16600b.exists() && this.f16599a.exists()) {
                String a10 = h.a(this.f16600b);
                this.f16603e = a10;
                if (TextUtils.isEmpty(a10)) {
                    return false;
                }
                String[] split = this.f16603e.split("#####");
                if (split.length == 2) {
                    String str = split[1];
                    try {
                        i10 = Integer.parseInt(split[0]);
                    } catch (Throwable unused) {
                        i10 = 0;
                    }
                    if (c.b.f16597a.a(str, this.f16599a)) {
                        this.f16601c = str;
                        this.f16602d = i10;
                        if (Build.VERSION.SDK_INT < 34 || context == null || context.getApplicationInfo() == null || context.getApplicationInfo().targetSdkVersion < 34 || !z10) {
                            return true;
                        }
                        if (!this.f16599a.canWrite() && !this.f16599a.canExecute()) {
                            return this.f16599a.canRead();
                        }
                        return this.f16599a.setReadOnly();
                    }
                }
            }
            return false;
        } catch (Throwable unused2) {
            GDTLogger.d("Exception while checking plugin");
            return false;
        }
    }
}
