package com.opos.cmn.biz.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.SSLSessionCache;
import android.os.Build;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.Arrays;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes4.dex */
public class g {
    public static SSLSocketFactory a(Context context) {
        if (context != null) {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (Build.VERSION.SDK_INT < 28 || applicationInfo == null || applicationInfo.targetSdkVersion < 28) {
                return a(a(), context);
            }
        }
        return null;
    }

    @TargetApi(19)
    public static SSLSocketFactory a(TrustManager trustManager, Context context) {
        if (context == null) {
            return null;
        }
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28 && applicationInfo != null && applicationInfo.targetSdkVersion >= 28) {
            return null;
        }
        SSLSessionCache sSLSessionCache = new SSLSessionCache(context);
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.init(null, new TrustManager[]{trustManager}, null);
        sSLContext.getClientSessionContext().setSessionCacheSize(0);
        sSLContext.getClientSessionContext().setSessionTimeout(604800);
        if (i2 > 19) {
            try {
                SSLSessionCache.class.getMethod("install", SSLSessionCache.class, SSLContext.class).invoke(null, sSLSessionCache, sSLContext);
            } catch (Exception unused) {
            }
        }
        return sSLContext.getSocketFactory();
    }

    public static X509TrustManager a() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException unused) {
            throw new AssertionError();
        }
    }
}
