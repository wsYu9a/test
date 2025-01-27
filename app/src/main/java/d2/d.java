package d2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import d2.a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a */
    public d2.a f25230a = null;

    /* renamed from: b */
    public String f25231b = null;

    /* renamed from: c */
    public String f25232c = null;

    /* renamed from: d */
    public final Object f25233d = new Object();

    /* renamed from: e */
    public ServiceConnection f25234e = new a();

    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.f25230a = a.AbstractBinderC0684a.g(iBinder);
            synchronized (d.this.f25233d) {
                d.this.f25233d.notify();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.f25230a = null;
        }
    }

    public static class b {

        /* renamed from: a */
        public static final d f25236a = new d(null);
    }

    public /* synthetic */ d(a aVar) {
    }

    public synchronized String a(Context context, String str) {
        try {
        } catch (Throwable th2) {
            throw th2;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot run on MainThread");
        }
        if (this.f25230a != null) {
            try {
                return c(context, str);
            } catch (RemoteException e10) {
                e10.printStackTrace();
                return "";
            }
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        if (context.bindService(intent, this.f25234e, 1)) {
            synchronized (this.f25233d) {
                try {
                    this.f25233d.wait(3000L);
                } catch (InterruptedException e11) {
                    e11.printStackTrace();
                }
            }
        }
        if (this.f25230a == null) {
            return "";
        }
        try {
            return c(context, str);
        } catch (RemoteException e12) {
            e12.printStackTrace();
            return "";
        }
        throw th2;
    }

    public boolean b(Context context) {
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

    public final String c(Context context, String str) {
        Signature[] signatureArr;
        if (TextUtils.isEmpty(this.f25231b)) {
            this.f25231b = context.getPackageName();
        }
        if (TextUtils.isEmpty(this.f25232c)) {
            String str2 = null;
            try {
                signatureArr = context.getPackageManager().getPackageInfo(this.f25231b, 64).signatures;
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
            this.f25232c = str2;
        }
        String g10 = ((a.AbstractBinderC0684a.C0685a) this.f25230a).g(this.f25231b, this.f25232c, str);
        return TextUtils.isEmpty(g10) ? "" : g10;
    }
}
