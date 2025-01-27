package h.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import com.baidu.mobads.sdk.internal.bj;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import h.a.a.b;
import java.io.UnsupportedEncodingException;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/* loaded from: classes5.dex */
public interface a extends IInterface {

    /* renamed from: h.a.a.a$a */
    public static abstract class AbstractBinderC0824a extends Binder implements a {

        /* renamed from: a */
        public static final String f35285a = b.d("Y29tLmhleXRhcC5vcGVuaWQuSU9wZW5JRA==");

        /* renamed from: h.a.a.a$a$a */
        public static class C0825a implements a {

            /* renamed from: a */
            public IBinder f35286a;

            public C0825a(IBinder iBinder) {
                this.f35286a = iBinder;
            }

            @Override // h.a.a.a
            public String a(String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0824a.f35285a);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.f35286a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f35286a;
            }
        }

        public static a b(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f35285a);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0825a(iBinder) : (a) queryLocalInterface;
        }
    }

    public class b {
        public static Pair<String, String> a(String str, byte[] bArr) {
            try {
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                SecretKey j2 = j(str);
                if (j2 == null) {
                    return null;
                }
                cipher.init(1, j2);
                return new Pair<>(Base64.encodeToString(cipher.doFinal(bArr), 2), Base64.encodeToString(cipher.getIV(), 2));
            } catch (Exception e2) {
                StringBuilder sb = new StringBuilder();
                sb.append("1018");
                sb.append(e2.getMessage() != null ? e2.getMessage() : e2.getLocalizedMessage());
                Log.e("IDHelper", sb.toString());
                return null;
            }
        }

        public static String b(Context context, String str, String str2) {
            Signature[] signatureArr;
            try {
                signatureArr = context.getPackageManager().getPackageInfo(str, 64).signatures;
            } catch (PackageManager.NameNotFoundException e2) {
                StringBuilder sb = new StringBuilder();
                sb.append("1011 ");
                sb.append(e2.getMessage());
                Log.e("IDHelper", sb.toString() != null ? e2.getMessage() : e2.getLocalizedMessage());
                signatureArr = null;
            }
            if (signatureArr == null) {
                return null;
            }
            for (Signature signature : signatureArr) {
                if ("SHA1".equals(str2)) {
                    byte[] byteArray = signature.toByteArray();
                    try {
                        MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                        if (messageDigest == null) {
                            return null;
                        }
                        byte[] digest = messageDigest.digest(byteArray);
                        StringBuilder sb2 = new StringBuilder();
                        for (byte b2 : digest) {
                            sb2.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                        }
                        return sb2.toString();
                    } catch (NoSuchAlgorithmException e3) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("1012 ");
                        sb3.append(e3.getMessage());
                        Log.e("IDHelper", sb3.toString() != null ? e3.getMessage() : e3.getLocalizedMessage());
                        return null;
                    }
                }
            }
            return null;
        }

        public static String c(Context context, String str, HashMap<String, f> hashMap) {
            if (hashMap.isEmpty() || !hashMap.containsKey(str)) {
                try {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("cache", 0);
                    if (!hashMap.containsKey("GUID")) {
                        String string = sharedPreferences.getString("GUID", null);
                        long j2 = sharedPreferences.getLong("GUID_TIME", 0L);
                        String string2 = sharedPreferences.getString("GUID_IV", null);
                        if (string != null && j2 != 0 && string2 != null) {
                            try {
                                byte[] g2 = g("StdIdAppKey", string, string2);
                                if (g2 != null) {
                                    hashMap.put("GUID", new f(new String(g2, "ISO-8859-1"), j2));
                                }
                            } catch (UnsupportedEncodingException e2) {
                                Log.e("IDHelper", e2.getMessage() != null ? e2.getMessage() : e2.getLocalizedMessage());
                            }
                        }
                    }
                    if (!hashMap.containsKey("APID")) {
                        String string3 = sharedPreferences.getString("APID", null);
                        long j3 = sharedPreferences.getLong("APID_TIME", 0L);
                        String string4 = sharedPreferences.getString("APID_IV", null);
                        if (string3 != null && j3 != 0 && string4 != null) {
                            try {
                                byte[] g3 = g("StdIdAppKey", string3, string4);
                                if (g3 != null) {
                                    hashMap.put("APID", new f(new String(g3, "ISO-8859-1"), j3));
                                }
                            } catch (UnsupportedEncodingException e3) {
                                Log.e("IDHelper", e3.getMessage() != null ? e3.getMessage() : e3.getLocalizedMessage());
                            }
                        }
                    }
                    if (!hashMap.containsKey("DUID")) {
                        String string5 = sharedPreferences.getString("DUID", null);
                        long j4 = sharedPreferences.getLong("DUID_TIME", 0L);
                        if (string5 != null && j4 != 0) {
                            hashMap.put("DUID", new f(string5, j4));
                        }
                    }
                    if (!hashMap.containsKey("AUID")) {
                        String string6 = sharedPreferences.getString("AUID", null);
                        long j5 = sharedPreferences.getLong("AUID_TIME", 0L);
                        if (string6 != null && j5 != 0) {
                            hashMap.put("AUID", new f(string6, j5));
                        }
                    }
                } catch (IllegalStateException e4) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("1020:");
                    sb.append(e4.getMessage());
                    Log.e("IDHelper", sb.toString() != null ? e4.getMessage() : e4.getLocalizedMessage());
                }
            }
            if (!hashMap.containsKey(str)) {
                return "";
            }
            f fVar = hashMap.get(str);
            return fVar.a(str) ? fVar.f35299a : "";
        }

        public static String d(String str) {
            try {
                return new String(Base64.decode(str, 0));
            } catch (Exception e2) {
                g.a("4025: " + e2.toString());
                return null;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:48:0x0064, code lost:
        
            if (r13.equals("APID") != false) goto L99;
         */
        /* JADX WARN: Removed duplicated region for block: B:23:0x006c  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00ae A[Catch: IllegalStateException -> 0x00d3, TryCatch #0 {IllegalStateException -> 0x00d3, blocks: (B:9:0x0018, B:18:0x0048, B:26:0x0073, B:27:0x007c, B:28:0x00cf, B:32:0x0080, B:33:0x008a, B:35:0x0096, B:36:0x00aa, B:37:0x00ae, B:39:0x00ba, B:41:0x0050, B:44:0x0058, B:47:0x0060), top: B:8:0x0018 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static void e(android.content.Context r11, h.a.a.a.f r12, java.lang.String r13) {
            /*
                Method dump skipped, instructions count: 250
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: h.a.a.a.b.e(android.content.Context, h.a.a.a$f, java.lang.String):void");
        }

        public static boolean f(Context context, String str) {
            return Build.VERSION.SDK_INT > 29 || i(context, BaseWrapper.BASE_PKG_SYSTEM).equals(i(context, str));
        }

        public static byte[] g(String str, String str2, String str3) {
            try {
                byte[] decode = Base64.decode(str2, 2);
                byte[] decode2 = Base64.decode(str3, 2);
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, decode2);
                SecretKey j2 = j(str);
                if (j2 == null) {
                    return null;
                }
                cipher.init(2, j2, gCMParameterSpec);
                return cipher.doFinal(decode);
            } catch (Exception e2) {
                StringBuilder sb = new StringBuilder();
                sb.append("1015:");
                sb.append(e2.getMessage() != null ? e2.getMessage() : e2.getLocalizedMessage());
                Log.e("IDHelper", sb.toString());
                return null;
            }
        }

        public static long h(String str) {
            str.hashCode();
            switch (str) {
                case "APID":
                case "GUID":
                    return 259200000L;
                case "AUID":
                    return bj.f5599d;
                case "DUID":
                    return 86400000L;
                case "OUID":
                case "OUID_STATUS":
                    return 7200000L;
                default:
                    return 0L;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0026 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static java.lang.String i(android.content.Context r13, java.lang.String r14) {
            /*
                Method dump skipped, instructions count: 256
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: h.a.a.a.b.i(android.content.Context, java.lang.String):java.lang.String");
        }

        public static SecretKey j(String str) {
            try {
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                keyStore.load(null);
                KeyStore.Entry entry = keyStore.getEntry(str, null);
                SecretKey secretKey = entry != null ? ((KeyStore.SecretKeyEntry) entry).getSecretKey() : null;
                return secretKey == null ? k(str) : secretKey;
            } catch (Exception e2) {
                StringBuilder sb = new StringBuilder();
                sb.append("1016:");
                sb.append(e2.getMessage() != null ? e2.getMessage() : e2.getLocalizedMessage());
                Log.e("IDHelper", sb.toString());
                return null;
            }
        }

        public static SecretKey k(String str) {
            try {
                Log.e("IDHelper", "generateSecretKey, alias:" + str);
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
                keyGenerator.init(new KeyGenParameterSpec.Builder(str, 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").build());
                return keyGenerator.generateKey();
            } catch (Exception e2) {
                StringBuilder sb = new StringBuilder();
                sb.append("1017:");
                sb.append(e2.getMessage() != null ? e2.getMessage() : e2.getLocalizedMessage());
                Log.e("IDHelper", sb.toString());
                return null;
            }
        }
    }

    public class c {

        /* renamed from: a */
        public static c f35287a;

        /* renamed from: b */
        public HashMap<String, f> f35288b;

        /* renamed from: c */
        public boolean f35289c = false;

        public c() {
            this.f35288b = null;
            this.f35288b = new HashMap<>();
        }

        public static c b() {
            if (f35287a == null) {
                synchronized (c.class) {
                    if (f35287a == null) {
                        f35287a = new c();
                    }
                }
            }
            return f35287a;
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:33:0x013f A[Catch: all -> 0x0167, TryCatch #1 {, blocks: (B:3:0x0001, B:10:0x0013, B:12:0x0017, B:13:0x0024, B:18:0x003b, B:20:0x0043, B:21:0x005c, B:22:0x0066, B:31:0x013b, B:33:0x013f, B:34:0x0145, B:35:0x0147, B:41:0x0162, B:45:0x0165, B:46:0x0166, B:47:0x00b3, B:48:0x00c9, B:49:0x00cd, B:50:0x00e4, B:51:0x0100, B:52:0x0112, B:53:0x0124, B:54:0x006a, B:57:0x0074, B:60:0x007e, B:63:0x0088, B:66:0x0092, B:69:0x009c, B:72:0x0050, B:74:0x001e, B:37:0x0148, B:39:0x014c, B:42:0x015b), top: B:2:0x0001, inners: #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0145 A[Catch: all -> 0x0167, TryCatch #1 {, blocks: (B:3:0x0001, B:10:0x0013, B:12:0x0017, B:13:0x0024, B:18:0x003b, B:20:0x0043, B:21:0x005c, B:22:0x0066, B:31:0x013b, B:33:0x013f, B:34:0x0145, B:35:0x0147, B:41:0x0162, B:45:0x0165, B:46:0x0166, B:47:0x00b3, B:48:0x00c9, B:49:0x00cd, B:50:0x00e4, B:51:0x0100, B:52:0x0112, B:53:0x0124, B:54:0x006a, B:57:0x0074, B:60:0x007e, B:63:0x0088, B:66:0x0092, B:69:0x009c, B:72:0x0050, B:74:0x001e, B:37:0x0148, B:39:0x014c, B:42:0x015b), top: B:2:0x0001, inners: #2 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String a(android.content.Context r11, java.lang.String r12) {
            /*
                Method dump skipped, instructions count: 390
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: h.a.a.a.c.a(android.content.Context, java.lang.String):java.lang.String");
        }

        public void c(Context context, String str) {
            if (!this.f35288b.containsKey(str)) {
                if (str.equals("OUID") || str.equals("OUID_STATUS") || str == "OUID" || str == "OUID_STATUS") {
                    String a2 = this.f35289c ? d.b.f35296a.a(context, str) : h.b.f35308a.a(context, str);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (a2.equals("") || a2 == "") {
                        return;
                    }
                    this.f35288b.put(str, new f(a2, currentTimeMillis + 7200000));
                    return;
                }
                return;
            }
            f fVar = this.f35288b.get(str);
            if (fVar.a(str)) {
                return;
            }
            String a3 = this.f35289c ? d.b.f35296a.a(context, str) : h.b.f35308a.a(context, str);
            long currentTimeMillis2 = System.currentTimeMillis();
            long h2 = b.h(str);
            if (a3.equals("") || a3 == "") {
                return;
            }
            fVar.f35299a = a3;
            fVar.f35300b = currentTimeMillis2 + h2;
            b.e(context, fVar, str);
        }
    }

    public class d {

        /* renamed from: a */
        public volatile a f35290a = null;

        /* renamed from: b */
        public String f35291b = null;

        /* renamed from: c */
        public String f35292c = null;

        /* renamed from: d */
        public final Object f35293d = new Object();

        /* renamed from: e */
        public ServiceConnection f35294e = new ServiceConnectionC0826a();

        /* renamed from: h.a.a.a$d$a */
        public class ServiceConnectionC0826a implements ServiceConnection {
            public ServiceConnectionC0826a() {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                g.a("2014");
                d.this.f35290a = AbstractBinderC0824a.b(iBinder);
                synchronized (d.this.f35293d) {
                    g.a("2015");
                    d.this.f35293d.notify();
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                g.a("2016");
                d.this.f35290a = null;
            }
        }

        public static class b {

            /* renamed from: a */
            public static final d f35296a = new d();
        }

        public String a(Context context, String str) {
            String str2;
            String str3;
            try {
            } catch (RemoteException unused) {
                str2 = "IDHelper";
                str3 = "1005";
            }
            if (this.f35290a == null) {
                g.a("2009");
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(b.d("Y29tLmhleXRhcC5vcGVuaWQ="), b.d("Y29tLmhleXRhcC5vcGVuaWQuSWRlbnRpZnlTZXJ2aWNl")));
                intent.setAction(b.d("YWN0aW9uLmNvbS5oZXl0YXAub3BlbmlkLk9QRU5fSURfU0VSVklDRQ=="));
                g.a("2012");
                try {
                    if (context.bindService(intent, this.f35294e, 1)) {
                        g.a("2013");
                        if (this.f35290a == null) {
                            synchronized (this.f35293d) {
                                try {
                                    if (this.f35290a == null) {
                                        this.f35293d.wait(10000L);
                                    }
                                } catch (InterruptedException unused2) {
                                    Log.e("IDHelper", "1006");
                                }
                            }
                        }
                    } else {
                        Log.e("IDHelper", "1007");
                    }
                } catch (Exception e2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("1008 ");
                    sb.append(e2.getMessage() != null ? e2.getMessage() : e2.getLocalizedMessage());
                    Log.e("IDHelper", sb.toString());
                }
                if (this.f35290a == null) {
                    str2 = "IDHelper";
                    str3 = "1004";
                    Log.e(str2, str3);
                    return "";
                }
                g.a("2010");
            } else {
                g.a("2011");
            }
            return c(context, str);
        }

        public void b(Context context) {
            synchronized (this) {
                try {
                    if (this.f35290a != null) {
                        g.a("2019");
                        context.unbindService(this.f35294e);
                        this.f35290a = null;
                    }
                } catch (Exception unused) {
                    Log.e("IDHelper", "1010");
                }
            }
        }

        public final String c(Context context, String str) {
            if (TextUtils.isEmpty(this.f35291b)) {
                this.f35291b = context.getPackageName();
            }
            if (TextUtils.isEmpty(this.f35292c)) {
                this.f35292c = b.b(context, this.f35291b, "SHA1");
            }
            g.a("2017");
            if (this.f35290a != null) {
                String a2 = this.f35290a.a(this.f35291b, this.f35292c, str);
                g.a("2018");
                return TextUtils.isEmpty(a2) ? "" : a2;
            }
            Log.e("IDHelper", context.getPackageName() + " 1009");
            return "";
        }
    }

    public class e {

        /* renamed from: a */
        public static boolean f35297a;

        /* renamed from: b */
        public static boolean f35298b;

        public static Context a(Context context) {
            return (context == null || context.getApplicationContext() == null) ? context : context.getApplicationContext();
        }

        public static boolean b() {
            String str;
            if (!f35297a) {
                str = "1001";
            } else if (!f35298b) {
                str = "1002";
            } else {
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    return true;
                }
                str = "1003";
            }
            Log.e("IDHelper", str);
            return false;
        }
    }

    public class f {

        /* renamed from: a */
        public String f35299a;

        /* renamed from: b */
        public long f35300b;

        public f(String str, long j2) {
            this.f35299a = str;
            this.f35300b = j2;
        }

        public boolean a(String str) {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = this.f35300b;
            if (currentTimeMillis < j2 - TTAdConstant.AD_MAX_EVENT_TIME && Math.abs(j2 - currentTimeMillis) <= b.h(str) + TTAdConstant.AD_MAX_EVENT_TIME) {
                return true;
            }
            g.a("invalid");
            return false;
        }
    }

    public class g {

        /* renamed from: a */
        public static boolean f35301a;

        public static void a(String str) {
            if (f35301a) {
                Log.d("IDHelper", str);
            }
        }
    }

    public class h {

        /* renamed from: a */
        public volatile h.a.a.b f35302a = null;

        /* renamed from: b */
        public String f35303b = null;

        /* renamed from: c */
        public String f35304c = null;

        /* renamed from: d */
        public final Object f35305d = new Object();

        /* renamed from: e */
        public ServiceConnection f35306e = new ServiceConnectionC0827a();

        /* renamed from: h.a.a.a$h$a */
        public class ServiceConnectionC0827a implements ServiceConnection {
            public ServiceConnectionC0827a() {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                g.a("2014");
                h.this.f35302a = b.a.b(iBinder);
                synchronized (h.this.f35305d) {
                    g.a("2015");
                    h.this.f35305d.notify();
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                g.a("2016");
                h.this.f35302a = null;
            }
        }

        public static class b {

            /* renamed from: a */
            public static final h f35308a = new h();
        }

        public String a(Context context, String str) {
            String str2;
            String str3;
            try {
            } catch (RemoteException unused) {
                str2 = "IDHelper";
                str3 = "1005";
            }
            if (this.f35302a == null) {
                g.a("2009");
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(b.d("Y29tLmNvbG9yb3MubWNz"), "com.oplus.stdid.IdentifyService"));
                intent.setAction("action.com.oplus.stdid.ID_SERVICE");
                g.a("2012");
                try {
                    if (context.bindService(intent, this.f35306e, 1)) {
                        g.a("2013");
                        if (this.f35302a == null) {
                            synchronized (this.f35305d) {
                                try {
                                    if (this.f35302a == null) {
                                        this.f35305d.wait(10000L);
                                    }
                                } catch (InterruptedException unused2) {
                                    Log.e("IDHelper", "1006");
                                }
                            }
                        }
                    } else {
                        Log.e("IDHelper", "1007");
                    }
                } catch (Exception e2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("1008 ");
                    sb.append(e2.getMessage() != null ? e2.getMessage() : e2.getLocalizedMessage());
                    Log.e("IDHelper", sb.toString());
                }
                if (this.f35302a == null) {
                    str2 = "IDHelper";
                    str3 = "1004";
                    Log.e(str2, str3);
                    return "";
                }
                g.a("2010");
            } else {
                g.a("2011");
            }
            return b(context, str);
        }

        public final String b(Context context, String str) {
            if (TextUtils.isEmpty(this.f35303b)) {
                this.f35303b = context.getPackageName();
            }
            if (TextUtils.isEmpty(this.f35304c)) {
                this.f35304c = b.b(context, this.f35303b, "SHA1");
            }
            g.a("2017");
            if (this.f35302a != null) {
                String a2 = this.f35302a.a(this.f35303b, this.f35304c, str);
                g.a("2018");
                return TextUtils.isEmpty(a2) ? "" : a2;
            }
            Log.e("IDHelper", context.getPackageName() + " 1009");
            return "";
        }
    }

    String a(String str, String str2, String str3);
}
