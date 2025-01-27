package org.repackage.a.a.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.repackage.a.a.a.a;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    public org.repackage.a.a.a.a f29361a = null;

    /* renamed from: b */
    public String f29362b = null;

    /* renamed from: c */
    public String f29363c = null;

    /* renamed from: d */
    public final Object f29364d = new Object();

    /* renamed from: e */
    public ServiceConnection f29365e = new b(this);

    public static class a {

        /* renamed from: a */
        public static final c f29366a = new c(null);
    }

    public /* synthetic */ c(b bVar) {
    }

    public boolean a(Context context) {
        long longVersionCode;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 0);
            if (Build.VERSION.SDK_INT < 28) {
                return packageInfo != null && packageInfo.versionCode >= 1;
            }
            if (packageInfo == null) {
                return false;
            }
            longVersionCode = packageInfo.getLongVersionCode();
            return longVersionCode >= 1;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public final String b(Context context, String str) {
        Signature[] signatureArr;
        if (TextUtils.isEmpty(this.f29362b)) {
            this.f29362b = context.getPackageName();
        }
        if (TextUtils.isEmpty(this.f29363c)) {
            String str2 = null;
            try {
                signatureArr = context.getPackageManager().getPackageInfo(this.f29362b, 64).signatures;
            } catch (PackageManager.NameNotFoundException e10) {
                e10.printStackTrace();
                signatureArr = null;
            }
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    if (messageDigest != null) {
                        byte[] digest = messageDigest.digest(byteArray);
                        StringBuilder sb2 = new StringBuilder();
                        for (byte b10 : digest) {
                            sb2.append(Integer.toHexString((b10 & 255) | 256).substring(1, 3));
                        }
                        str2 = sb2.toString();
                    }
                } catch (NoSuchAlgorithmException e11) {
                    e11.printStackTrace();
                }
            }
            this.f29363c = str2;
        }
        String a10 = ((a.AbstractBinderC0756a.C0757a) this.f29361a).a(this.f29362b, this.f29363c, str);
        return TextUtils.isEmpty(a10) ? "" : a10;
    }

    public synchronized String a(Context context, String str) {
        try {
        } catch (Throwable th2) {
            throw th2;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            if (this.f29361a == null) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
                if (context.bindService(intent, this.f29365e, 1)) {
                    synchronized (this.f29364d) {
                        try {
                            this.f29364d.wait(3000L);
                        } catch (InterruptedException e10) {
                            e10.printStackTrace();
                        }
                    }
                }
                if (this.f29361a == null) {
                    return "";
                }
                try {
                    return b(context, str);
                } catch (RemoteException e11) {
                    e11.printStackTrace();
                    return "";
                }
            }
            try {
                return b(context, str);
            } catch (RemoteException e12) {
                e12.printStackTrace();
                return "";
            }
            throw th2;
        }
        throw new IllegalStateException("Cannot run on MainThread");
    }
}
