package pk;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Parcel;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import mk.a;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a */
    public mk.a f29924a = null;

    /* renamed from: b */
    public String f29925b = null;

    /* renamed from: c */
    public String f29926c = null;

    /* renamed from: d */
    public final Object f29927d = new Object();

    /* renamed from: e */
    public c f29928e = new c(this);

    public static class a {

        /* renamed from: a */
        public static final b f29929a = new b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0044, code lost:
    
        if (r4.f29924a == null) goto L107;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.lang.String a(android.content.Context r5, java.lang.String r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            android.os.Looper r0 = android.os.Looper.myLooper()     // Catch: java.lang.Throwable -> L40
            android.os.Looper r1 = android.os.Looper.getMainLooper()     // Catch: java.lang.Throwable -> L40
            if (r0 != r1) goto Lc
            goto L4c
        Lc:
            mk.a r0 = r4.f29924a     // Catch: java.lang.Throwable -> L40
            if (r0 != 0) goto L47
            android.content.Intent r0 = new android.content.Intent     // Catch: java.lang.Throwable -> L40
            r0.<init>()     // Catch: java.lang.Throwable -> L40
            android.content.ComponentName r1 = new android.content.ComponentName     // Catch: java.lang.Throwable -> L40
            java.lang.String r2 = "com.heytap.openid"
            java.lang.String r3 = "com.heytap.openid.IdentifyService"
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L40
            r0.setComponent(r1)     // Catch: java.lang.Throwable -> L40
            java.lang.String r1 = "action.com.heytap.openid.OPEN_ID_SERVICE"
            r0.setAction(r1)     // Catch: java.lang.Throwable -> L40
            pk.c r1 = r4.f29928e     // Catch: java.lang.Throwable -> L40
            r2 = 1
            boolean r0 = r5.bindService(r0, r1, r2)     // Catch: java.lang.Throwable -> L40
            if (r0 == 0) goto L42
            java.lang.Object r0 = r4.f29927d     // Catch: java.lang.Throwable -> L40
            monitor-enter(r0)     // Catch: java.lang.Throwable -> L40
            java.lang.Object r1 = r4.f29927d     // Catch: java.lang.Throwable -> L3a java.lang.InterruptedException -> L3c
            r2 = 3000(0xbb8, double:1.482E-320)
            r1.wait(r2)     // Catch: java.lang.Throwable -> L3a java.lang.InterruptedException -> L3c
            goto L3c
        L3a:
            r5 = move-exception
            goto L3e
        L3c:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3a
            goto L42
        L3e:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3a
            throw r5     // Catch: java.lang.Throwable -> L40
        L40:
            r5 = move-exception
            goto L50
        L42:
            mk.a r0 = r4.f29924a     // Catch: java.lang.Throwable -> L40
            if (r0 != 0) goto L47
            goto L4c
        L47:
            java.lang.String r5 = r4.b(r5, r6)     // Catch: java.lang.Throwable -> L40 android.os.RemoteException -> L4c
            goto L4e
        L4c:
            java.lang.String r5 = ""
        L4e:
            monitor-exit(r4)
            return r5
        L50:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L40
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: pk.b.a(android.content.Context, java.lang.String):java.lang.String");
    }

    public final String b(Context context, String str) {
        Signature[] signatureArr;
        if (TextUtils.isEmpty(this.f29925b)) {
            this.f29925b = context.getPackageName();
        }
        if (TextUtils.isEmpty(this.f29926c)) {
            String str2 = null;
            try {
                signatureArr = context.getPackageManager().getPackageInfo(this.f29925b, 64).signatures;
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
            this.f29926c = str2;
        }
        mk.a aVar = this.f29924a;
        if (aVar == null) {
            context.getPackageName();
            return "";
        }
        a.AbstractBinderC0743a.C0744a c0744a = (a.AbstractBinderC0743a.C0744a) aVar;
        String str3 = this.f29925b;
        String str4 = this.f29926c;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
            obtain.writeString(str3);
            obtain.writeString(str4);
            obtain.writeString(str);
            c0744a.f28717b.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            obtain2.recycle();
            obtain.recycle();
            return TextUtils.isEmpty(readString) ? "" : readString;
        } catch (Throwable th2) {
            obtain2.recycle();
            obtain.recycle();
            throw th2;
        }
    }
}
