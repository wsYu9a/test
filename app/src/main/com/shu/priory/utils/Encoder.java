package com.shu.priory.utils;

import android.util.Base64;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.param.AdParam;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;

/* loaded from: classes3.dex */
public class Encoder {
    static {
        try {
            System.loadLibrary("iflyads");
        } catch (Throwable th2) {
            h.d(SDKConstants.TAG, "loadLibrary error :" + th2.toString());
        }
    }

    private static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e10) {
                e10.printStackTrace();
            }
        }
    }

    public static byte[] decodeData(byte[] bArr) {
        for (int i10 = 0; i10 < bArr.length; i10++) {
            bArr[i10] = (byte) ((bArr[i10] & 255) ^ 7);
        }
        return unZip(bArr);
    }

    public static void encrypt(byte[] bArr) {
        for (int i10 = 0; i10 < bArr.length; i10++) {
            bArr[i10] = (byte) ((bArr[i10] & 255) ^ 5);
        }
    }

    public static byte[] encryptByPublicKey(String str, String str2) {
        try {
            RSAPublicKey loadPublicKey = loadPublicKey(str2);
            if (loadPublicKey != null) {
                return encryptByPublicKey(str.getBytes("utf-8"), loadPublicKey);
            }
            return null;
        } catch (Throwable th2) {
            h.d(SDKConstants.TAG, "encryptByPublicKey:" + th2.toString());
            return null;
        }
    }

    private static RSAPublicKey loadPublicKey(String str) {
        try {
            return (RSAPublicKey) KeyFactory.getInstance(d3.d.f25247a).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (Throwable th2) {
            h.d(SDKConstants.TAG, "loadPublicKey:" + th2.toString());
            return null;
        }
    }

    public static native String packageData(AdParam adParam);

    public static native byte[] packageDeviceData(byte[] bArr, byte[] bArr2);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11, types: [java.io.ByteArrayOutputStream, java.io.Closeable, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v7, types: [java.io.Closeable] */
    private static byte[] unZip(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream;
        Object obj;
        ?? r92;
        byte[] bArr2;
        ?? r22;
        Throwable th2;
        ?? r93;
        byte[] bArr3 = null;
        bArr3 = null;
        r0 = null;
        r0 = null;
        Closeable closeable = null;
        try {
            try {
                byteArrayInputStream = new ByteArrayInputStream(bArr);
            } catch (IOException e10) {
                e = e10;
                r92 = 0;
                byteArrayInputStream = null;
                bArr2 = null;
            } catch (Throwable th3) {
                th = th3;
                byteArrayInputStream = null;
                obj = null;
            }
            try {
                ?? byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                    try {
                        byte[] bArr4 = new byte[1024];
                        while (true) {
                            int read = gZIPInputStream.read(bArr4, 0, 1024);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr4, 0, read);
                        }
                        bArr3 = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.flush();
                        close(gZIPInputStream);
                        close(byteArrayInputStream);
                        close(byteArrayOutputStream);
                        bArr = byteArrayOutputStream;
                    } catch (IOException e11) {
                        e = e11;
                        bArr2 = bArr3;
                        closeable = gZIPInputStream;
                        r92 = byteArrayOutputStream;
                        e.printStackTrace();
                        h.d(SDKConstants.TAG, e.getMessage());
                        close(closeable);
                        close(byteArrayInputStream);
                        close(r92);
                        bArr3 = bArr2;
                        bArr = r92;
                        return bArr3;
                    } catch (Throwable th4) {
                        th2 = th4;
                        r22 = gZIPInputStream;
                        r93 = byteArrayOutputStream;
                        close(r22);
                        close(byteArrayInputStream);
                        close(r93);
                        throw th2;
                    }
                } catch (IOException e12) {
                    e = e12;
                    bArr2 = null;
                    r92 = byteArrayOutputStream;
                }
            } catch (IOException e13) {
                e = e13;
                r92 = 0;
                bArr2 = null;
            } catch (Throwable th5) {
                th = th5;
                obj = null;
                th2 = th;
                r93 = obj;
                r22 = obj;
                close(r22);
                close(byteArrayInputStream);
                close(r93);
                throw th2;
            }
            return bArr3;
        } catch (Throwable th6) {
            r22 = bArr3;
            th2 = th6;
            r93 = bArr;
        }
    }

    public static byte[] zip(byte[] bArr) {
        GZIPOutputStream gZIPOutputStream;
        GZIPOutputStream gZIPOutputStream2 = null;
        byte[] bArr2 = null;
        if (bArr == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        } catch (IOException e10) {
            e = e10;
            gZIPOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            close(gZIPOutputStream2);
            close(byteArrayOutputStream);
            throw th;
        }
        try {
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.finish();
                bArr2 = byteArrayOutputStream.toByteArray();
            } catch (Throwable th3) {
                th = th3;
                gZIPOutputStream2 = gZIPOutputStream;
                close(gZIPOutputStream2);
                close(byteArrayOutputStream);
                throw th;
            }
        } catch (IOException e11) {
            e = e11;
            e.printStackTrace();
            close(gZIPOutputStream);
            close(byteArrayOutputStream);
            return bArr2;
        }
        close(gZIPOutputStream);
        close(byteArrayOutputStream);
        return bArr2;
    }

    private static byte[] encryptByPublicKey(byte[] bArr, RSAPublicKey rSAPublicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, rSAPublicKey);
        return cipher.doFinal(bArr);
    }
}
