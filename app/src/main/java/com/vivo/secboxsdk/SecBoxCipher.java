package com.vivo.secboxsdk;

import android.text.TextUtils;
import android.util.Base64;
import com.vivo.secboxsdk.a.a;
import com.vivo.secboxsdk.a.b;
import com.vivo.secboxsdk.a.c;
import com.vivo.secboxsdk.jni.SecBoxNative;
import com.vivo.secboxsdk.protocol.d;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class SecBoxCipher {

    /* renamed from: a */
    private static SecBoxCipher f31130a;

    public static SecBoxCipher b() {
        if (f31130a == null) {
            synchronized (SecBoxCipher.class) {
                if (f31130a == null) {
                    f31130a = new SecBoxCipher();
                }
            }
        }
        return f31130a;
    }

    public static String c() {
        return "secboxsdk-v1.0.0.0-4836a5a";
    }

    public static int d() {
        return 1;
    }

    public String a(String str, byte[] bArr) throws SecBoxCipherException {
        return b(str, bArr);
    }

    public Map<String, String> a(Map<String, String> map, byte[] bArr) throws SecBoxCipherException {
        return b(map, bArr);
    }

    public byte[] a(byte[] bArr, byte[] bArr2) throws SecBoxCipherException {
        if (!c.a(bArr) && !c.a(bArr2)) {
            try {
                return b(bArr, bArr2);
            } catch (SecBoxCipherException e2) {
                b.b(SecBoxNative.TAG, "SecBoxCipherException:" + e2.getMessage());
                throw e2;
            } catch (Throwable th) {
                b.b(SecBoxNative.TAG, "Exception:" + th.getMessage());
                throw new SecBoxCipherException(th.getMessage(), th, -1000);
            }
        }
        throw new SecBoxCipherException("input is null", -1);
    }

    private Map<String, String> b(Map<String, String> map, byte[] bArr) throws SecBoxCipherException {
        if (map != null && map.size() != 0) {
            HashMap hashMap = null;
            try {
                byte[] a2 = a(a.a(map).getBytes("utf-8"), bArr);
                if (a2 != null && a2.length != 0) {
                    hashMap = new HashMap();
                    hashMap.put("jvq_param", Base64.encodeToString(a2, 11));
                }
                return hashMap;
            } catch (SecBoxCipherException e2) {
                b.b(SecBoxNative.TAG, "SecBoxCipherException:" + e2.getMessage());
                throw e2;
            } catch (UnsupportedEncodingException e3) {
                b.b(SecBoxNative.TAG, "UnsupportedEncodingException:" + e3.getMessage());
                throw new SecBoxCipherException(e3.getMessage(), e3, -26);
            } catch (Throwable th) {
                b.b(SecBoxNative.TAG, "Exception:" + th.getMessage());
                throw new SecBoxCipherException(th.getMessage(), th, -1000);
            }
        }
        throw new SecBoxCipherException("invalid input params!", -19);
    }

    public byte[] a() throws SecBoxCipherException {
        return a(16);
    }

    public byte[] a(int i2) throws SecBoxCipherException {
        if (i2 > 0) {
            byte[] bArr = new byte[i2];
            new SecureRandom().nextBytes(bArr);
            return bArr;
        }
        throw new SecBoxCipherException("input length error,length=".concat(String.valueOf(i2)), -2);
    }

    private String b(String str, byte[] bArr) throws SecBoxCipherException {
        if (!TextUtils.isEmpty(str)) {
            String str2 = (TextUtils.isEmpty(str) || !str.contains("?")) ? null : str.split("[?]", 2)[0];
            if (!TextUtils.isEmpty(str2)) {
                Map<String, String> a2 = a.a(str);
                if (a2 != null && a2.size() != 0) {
                    try {
                        byte[] a3 = a(a.a(a2).getBytes("utf-8"), bArr);
                        return (a3 == null || a3.length == 0) ? "" : String.format("%s?jvq_param=%s", str2, Base64.encodeToString(a3, 11));
                    } catch (SecBoxCipherException e2) {
                        b.b(SecBoxNative.TAG, "SecBoxCipherException:" + e2.getMessage());
                        throw e2;
                    } catch (UnsupportedEncodingException e3) {
                        b.b(SecBoxNative.TAG, "UnsupportedEncodingException:" + e3.getMessage());
                        throw new SecBoxCipherException(e3.getMessage(), e3, -26);
                    } catch (Throwable th) {
                        b.b(SecBoxNative.TAG, "Exception:" + th.getMessage());
                        throw new SecBoxCipherException(th.getMessage(), th, -1000);
                    }
                }
                throw new SecBoxCipherException("invalid request params!", -19);
            }
            throw new SecBoxCipherException("input url is invalid! Not include parameters?", -19);
        }
        throw new SecBoxCipherException("invalid input params!", -1);
    }

    private byte[] b(byte[] bArr, byte[] bArr2) throws SecBoxCipherException {
        byte[] a2 = a(16);
        return new d("jnisecbox@secbox", 1, 19, SecBoxNative.aesEncrypt(bArr, bArr2, a2), a2, SecBoxNative.rsaEncrypt(bArr2)).a();
    }
}
