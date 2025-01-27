package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.loader.g;
import java.io.File;

/* loaded from: classes3.dex */
final class m {
    private final String aqm;
    private final String aqn;
    private final String aqo;
    private Resources aqp;
    private ClassLoader aqq;
    private IKsAdSDK aqr;

    private m(String str, String str2, String str3) {
        this.aqm = str;
        this.aqn = str2;
        this.aqo = str3;
    }

    private void BC() {
        if (TextUtils.isEmpty(this.aqm)) {
            throw new RuntimeException("mApk is null");
        }
        File file = new File(this.aqm);
        if (!file.isFile() || !file.exists()) {
            throw new RuntimeException("mApk not a file");
        }
    }

    public static synchronized m a(Context context, ClassLoader classLoader, String str) {
        m b10;
        synchronized (m.class) {
            try {
                b10 = b(context, classLoader, j.u(context, str), j.v(context, str), j.w(context, str));
            } catch (Throwable th2) {
                com.kwad.sdk.api.c.m(th2);
                return null;
            }
        }
        return b10;
    }

    public static m b(Context context, ClassLoader classLoader, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("mApk is null");
        }
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            throw new RuntimeException("mApk not a file");
        }
        try {
            if (Build.VERSION.SDK_INT >= 34 && context != null && context.getApplicationInfo().targetSdkVersion >= 34) {
                file.setReadOnly();
            }
        } catch (Throwable unused) {
        }
        m mVar = new m(str, str2, str3);
        mVar.a(context, classLoader);
        return mVar;
    }

    public final Resources BA() {
        return this.aqp;
    }

    public final IKsAdSDK BB() {
        return this.aqr;
    }

    public final ClassLoader getClassLoader() {
        return this.aqq;
    }

    public final String toString() {
        return "ExternalPackage{mApk='" + this.aqm + "', mDexDir='" + this.aqn + "', mNativeLibDir='" + this.aqo + "', mResource=" + this.aqp + ", mClassLoader=" + this.aqq + ", mKsSdk=" + this.aqr + '}';
    }

    private void a(Context context, ClassLoader classLoader) {
        BC();
        Resources a10 = s.a(context, context.getResources(), this.aqm);
        ClassLoader a11 = g.a(context, classLoader, this.aqm, this.aqn, this.aqo);
        IKsAdSDK a12 = Loader.a(a11);
        this.aqp = a10;
        this.aqq = a11;
        this.aqr = a12;
        if (a12.getClass().getClassLoader() instanceof g.a) {
            int sDKType = a12.getSDKType();
            if (sDKType == 1) {
                return;
            }
            throw new RuntimeException("sdkType error apiType: 1 , sdkType:" + sDKType);
        }
        throw new RuntimeException("classLoader is not expect dynamic classloader:");
    }
}
