package com.qq.e.comm.managers.plugin;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobads.sdk.internal.bu;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* loaded from: classes4.dex */
class c {

    /* renamed from: c */
    private static final byte[] f24032c = {82, 83, 65, 47, 69, 67, 66, 47, 80, 75, 67, 83, 49, 80, 97, 100, 100, 105, 110, 103};

    /* renamed from: a */
    private PublicKey f24033a;

    /* renamed from: b */
    private final boolean f24034b;

    static final class b {

        /* renamed from: a */
        public static final c f24035a = new c();
    }

    private c() {
        boolean z;
        try {
            this.f24033a = a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDKta2b5Vw5YkWHCAj4rJCwS227\r/35FZ29e4I6pS2B8zSq2RgBpXUuMg7oZF1Qt3x0iyg8PeyblyNeCRB6gIMehFThe\r1Y7m1FaQyaZp+CJYOTLM4/THKp9UndrEgJ/5a83vP1375YCV2lMvWARrNlBep4RN\rnESUJhQz58Gr/F39TwIDAQAB");
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        this.f24034b = z;
    }

    /* synthetic */ c(a aVar) {
        this();
    }

    private PublicKey a(String str) throws Exception {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NullPointerException unused) {
            throw new Exception("公钥数据为空");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException unused3) {
            throw new Exception("公钥非法");
        }
    }

    public boolean a(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (!this.f24034b) {
            return true;
        }
        if (this.f24033a != null) {
            byte[] decode = Base64.decode(str, 0);
            try {
                Cipher cipher = Cipher.getInstance(new String(f24032c, "UTF-8"));
                cipher.init(2, this.f24033a);
                str3 = new String(cipher.doFinal(decode), "UTF-8").trim();
            } catch (Throwable unused) {
                GDTLogger.d("ErrorWhileVerifySigNature");
            }
            boolean equals = str2.equals(str3);
            GDTLogger.d("Verify Result" + equals + "src=" + str2 + " & target=" + str3);
            return equals;
        }
        str3 = null;
        boolean equals2 = str2.equals(str3);
        GDTLogger.d("Verify Result" + equals2 + "src=" + str2 + " & target=" + str3);
        return equals2;
    }

    public boolean a(String str, File file) {
        String str2;
        MessageDigest messageDigest;
        FileInputStream fileInputStream;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.exists()) {
            FileInputStream fileInputStream2 = null;
            try {
                messageDigest = MessageDigest.getInstance(bu.f5659a);
                fileInputStream = new FileInputStream(file);
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                str2 = d.a(messageDigest.digest());
                try {
                    fileInputStream.close();
                } catch (Exception unused2) {
                }
            } catch (Exception unused3) {
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception unused4) {
                    }
                }
                str2 = "";
                return a(str, str2);
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception unused5) {
                    }
                }
                throw th;
            }
            return a(str, str2);
        }
        str2 = "";
        return a(str, str2);
    }
}
