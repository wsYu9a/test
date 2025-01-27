package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.kwad.sdk.api.core.IKsAdSDK;
import java.io.File;

/* loaded from: classes2.dex */
final class k {
    private final String ZO;
    private final String ZP;
    private final String ZQ;
    private Resources ZR;
    private ClassLoader ZS;
    private IKsAdSDK ZU;

    private k(String str, String str2, String str3) {
        this.ZO = str;
        this.ZP = str2;
        this.ZQ = str3;
    }

    static synchronized k a(Context context, ClassLoader classLoader, String str) {
        k b2;
        synchronized (k.class) {
            try {
                b2 = b(context, classLoader, h.n(context, str), h.o(context, str), h.p(context, str));
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return b2;
    }

    static k b(Context context, ClassLoader classLoader, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("mApk is null");
        }
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            throw new RuntimeException("mApk not a file");
        }
        k kVar = new k(str, str2, str3);
        kVar.c(context, classLoader);
        return kVar;
    }

    private void c(Context context, ClassLoader classLoader) {
        tr();
        Resources a2 = q.a(context, context.getResources(), this.ZO);
        ClassLoader a3 = e.a(context, classLoader, this.ZO, this.ZP, this.ZQ);
        IKsAdSDK a4 = Loader.a(a3);
        this.ZR = a2;
        this.ZS = a3;
        this.ZU = a4;
        int sDKType = a4.getSDKType();
        if (sDKType == 1) {
            return;
        }
        throw new RuntimeException("sdkType error apiType: 1 , sdkType:" + sDKType);
    }

    private void tr() {
        if (TextUtils.isEmpty(this.ZO)) {
            throw new RuntimeException("mApk is null");
        }
        File file = new File(this.ZO);
        if (!file.isFile() || !file.exists()) {
            throw new RuntimeException("mApk not a file");
        }
    }

    final ClassLoader getClassLoader() {
        return this.ZS;
    }

    public final String toString() {
        return "ExternalPackage{mApk='" + this.ZO + "', mDexDir='" + this.ZP + "', mNativeLibDir='" + this.ZQ + "', mResource=" + this.ZR + ", mClassLoader=" + this.ZS + ", mKsSdk=" + this.ZU + '}';
    }

    final Resources tp() {
        return this.ZR;
    }

    final IKsAdSDK tq() {
        return this.ZU;
    }
}
