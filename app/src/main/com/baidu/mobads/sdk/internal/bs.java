package com.baidu.mobads.sdk.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.Base64;
import com.baidu.mobads.sdk.internal.bz;
import java.io.File;
import java.io.FilenameFilter;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* loaded from: classes2.dex */
public class bs extends File {

    /* renamed from: a */
    public static final String f6942a = "LocalApkFile";

    /* renamed from: b */
    private static final long f6943b = 6916965592955692235L;

    /* renamed from: h */
    private static ClassLoader f6944h;

    /* renamed from: c */
    private bx f6945c;

    /* renamed from: d */
    private Class<?> f6946d;

    /* renamed from: e */
    private Context f6947e;

    /* renamed from: f */
    private PublicKey f6948f;

    /* renamed from: g */
    private bt f6949g;

    public class a implements FilenameFilter {
        public a() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return true;
        }
    }

    public bs(String str, Context context) {
        this(str, context, null);
    }

    private void d() {
        File[] listFiles = this.f6947e.getFilesDir().listFiles(new a());
        for (int i10 = 0; listFiles != null && i10 < listFiles.length; i10++) {
            if (listFiles[i10].getAbsolutePath().contains("__xadsdk__remote__final__")) {
                this.f6949g.a(f6942a, "clearDexCacheFiles-->" + i10 + "--" + listFiles[i10].getAbsolutePath());
                listFiles[i10].delete();
            }
        }
    }

    public void a() {
        if (this.f6945c == null) {
            this.f6949g.a(f6942a, "built-in apk, no need to check");
            return;
        }
        String a10 = a(new File(getAbsolutePath()));
        String b10 = b(this.f6945c.d());
        if (a10.equalsIgnoreCase(b10)) {
            return;
        }
        throw new bz.a("doCheckApkIntegrity failed, md5sum: " + a10 + ", checksum in json info: " + b10);
    }

    public Class<?> b() {
        if (this.f6946d == null) {
            File file = new File(getAbsolutePath());
            try {
                this.f6946d = b(file);
            } catch (Exception unused) {
                file.delete();
            }
        }
        return this.f6946d;
    }

    public double c() {
        bx bxVar = this.f6945c;
        return bxVar == null ? l5.c.f27899e : bxVar.b();
    }

    public bs(String str, Context context, bx bxVar) {
        super(str);
        this.f6946d = null;
        this.f6947e = null;
        this.f6949g = bt.a();
        this.f6947e = context;
        this.f6945c = bxVar;
        if (bxVar != null) {
            try {
                this.f6948f = c("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDBcp8gg3O7bjdnz+pSxg+JH/mbcKfm7dEjcRqVNAFwG7bTpLwDQh40bZJzrcBKQWbD6kArR6TPuQUCMQ09/y55Vk1P2Kq7vJGGisFpjlqv2qlg8drLdhXkLQUt/SeZVJgT+CNxVbuzxAF61EEf8M0MHi1I2dm6n6lOA6fomiCD9wIDAQAB");
            } catch (Exception unused) {
                this.f6948f = null;
            }
        }
    }

    private static PublicKey c(String str) {
        try {
            return KeyFactory.getInstance(d3.d.f25247a).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NullPointerException unused) {
            throw new Exception("NullPointerException");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("NoSuchAlgorithmException");
        } catch (InvalidKeySpecException unused3) {
            throw new Exception("InvalidKeySpecException");
        }
    }

    private String b(String str) {
        if (this.f6948f == null) {
            return null;
        }
        byte[] decode = Base64.decode(str, 0);
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, this.f6948f);
            return new String(cipher.doFinal(decode), "UTF-8").trim();
        } catch (Exception e10) {
            this.f6949g.c("ErrorWhileVerifySigNature", e10);
            return null;
        }
    }

    public void a(String str) {
        renameTo(new File(str));
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x009d A[Catch: Exception -> 0x0099, TRY_LEAVE, TryCatch #6 {Exception -> 0x0099, blocks: (B:55:0x0095, B:48:0x009d), top: B:54:0x0095 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(java.io.File r9) {
        /*
            r8 = this;
            java.lang.String r0 = "LocalApkFile"
            java.lang.String r1 = ""
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6f
            r3.<init>(r9)     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6f
            java.lang.String r9 = "MD5"
            java.security.MessageDigest r9 = java.security.MessageDigest.getInstance(r9)     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L69
            java.security.DigestInputStream r4 = new java.security.DigestInputStream     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L69
            r4.<init>(r3, r9)     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L69
            r2 = 4096(0x1000, float:5.74E-42)
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
        L19:
            int r5 = r4.read(r2)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            r6 = -1
            if (r5 == r6) goto L21
            goto L19
        L21:
            byte[] r9 = r9.digest()     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            r2 = 0
            r5 = r1
        L27:
            int r6 = r9.length     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            if (r2 >= r6) goto L53
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            r6.<init>()     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            r6.append(r5)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            r5 = r9[r2]     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r5 = r5 + 256
            r7 = 16
            java.lang.String r5 = java.lang.Integer.toString(r5, r7)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            r7 = 1
            java.lang.String r5 = r5.substring(r7)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            r6.append(r5)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            java.lang.String r5 = r6.toString()     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            int r2 = r2 + 1
            goto L27
        L4d:
            r9 = move-exception
        L4e:
            r2 = r3
            goto L93
        L50:
            r9 = move-exception
        L51:
            r2 = r3
            goto L71
        L53:
            r3.close()     // Catch: java.lang.Exception -> L5a
            r4.close()     // Catch: java.lang.Exception -> L5a
            goto L64
        L5a:
            r9 = move-exception
            com.baidu.mobads.sdk.internal.bt r1 = r8.f6949g
            java.lang.String r9 = r9.getMessage()
            r1.a(r0, r9)
        L64:
            r1 = r5
            goto L91
        L66:
            r9 = move-exception
            r4 = r2
            goto L4e
        L69:
            r9 = move-exception
            r4 = r2
            goto L51
        L6c:
            r9 = move-exception
            r4 = r2
            goto L93
        L6f:
            r9 = move-exception
            r4 = r2
        L71:
            com.baidu.mobads.sdk.internal.bt r3 = r8.f6949g     // Catch: java.lang.Throwable -> L92
            java.lang.String r9 = r9.getMessage()     // Catch: java.lang.Throwable -> L92
            r3.a(r0, r9)     // Catch: java.lang.Throwable -> L92
            if (r2 == 0) goto L82
            r2.close()     // Catch: java.lang.Exception -> L80
            goto L82
        L80:
            r9 = move-exception
            goto L88
        L82:
            if (r4 == 0) goto L91
            r4.close()     // Catch: java.lang.Exception -> L80
            goto L91
        L88:
            com.baidu.mobads.sdk.internal.bt r2 = r8.f6949g
            java.lang.String r9 = r9.getMessage()
            r2.a(r0, r9)
        L91:
            return r1
        L92:
            r9 = move-exception
        L93:
            if (r2 == 0) goto L9b
            r2.close()     // Catch: java.lang.Exception -> L99
            goto L9b
        L99:
            r1 = move-exception
            goto La1
        L9b:
            if (r4 == 0) goto Laa
            r4.close()     // Catch: java.lang.Exception -> L99
            goto Laa
        La1:
            com.baidu.mobads.sdk.internal.bt r2 = r8.f6949g
            java.lang.String r1 = r1.getMessage()
            r2.a(r0, r1)
        Laa:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.bs.a(java.io.File):java.lang.String");
    }

    @TargetApi(14)
    private Class<?> b(File file) {
        Class<?> cls;
        this.f6949g.a(f6942a, "Android version:" + bm.a(this.f6947e).c());
        Class<?> cls2 = null;
        try {
            synchronized (bz.class) {
                String absolutePath = file.getAbsolutePath();
                ClassLoader classLoader = getClass().getClassLoader();
                String absolutePath2 = this.f6947e.getFilesDir().getAbsolutePath();
                String str = z.aN;
                f6944h = an.a(absolutePath, absolutePath2, (String) null, classLoader);
                this.f6949g.a(f6942a, "dexPath=" + absolutePath + ", cl=" + classLoader + ", dir=" + absolutePath2 + ", len=" + file.length() + ", list=" + file.list());
                cls = Class.forName(str, true, f6944h);
            }
            cls2 = cls;
        } catch (Exception e10) {
            this.f6949g.a(f6942a, e10.getMessage());
        }
        this.f6949g.a(f6942a, "jar.path=" + file.getAbsolutePath() + ", clz=" + cls2);
        return cls2;
    }

    public static ClassLoader a(Context context) {
        ClassLoader classLoader = f6944h;
        return classLoader != null ? classLoader : au.a(context.getApplicationContext());
    }
}
