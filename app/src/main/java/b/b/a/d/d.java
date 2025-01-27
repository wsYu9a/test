package b.b.a.d;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a */
    private static final String f4262a = "RSA";

    /* renamed from: b */
    public static final String f4263b = "SHA1WithRSA";

    public static String a(String str, String str2) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            PublicKey generatePublic = KeyFactory.getInstance(f4262a).generatePublic(new X509EncodedKeySpec(a.d(str2)));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, generatePublic);
            byte[] bytes = str.getBytes("UTF-8");
            int blockSize = cipher.getBlockSize();
            byteArrayOutputStream = new ByteArrayOutputStream();
            for (int i2 = 0; i2 < bytes.length; i2 += blockSize) {
                try {
                    byteArrayOutputStream.write(cipher.doFinal(bytes, i2, bytes.length - i2 < blockSize ? bytes.length - i2 : blockSize));
                } catch (Exception unused) {
                    if (byteArrayOutputStream == null) {
                        return null;
                    }
                    try {
                        byteArrayOutputStream.close();
                        return null;
                    } catch (IOException unused2) {
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            }
            String str3 = new String(a.b(byteArrayOutputStream.toByteArray()));
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused4) {
            }
            return str3;
        } catch (Exception unused5) {
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean b(String str, String str2, String str3) {
        try {
            PublicKey generatePublic = KeyFactory.getInstance(f4262a).generatePublic(new X509EncodedKeySpec(a.d(str3)));
            Signature signature = Signature.getInstance(f4263b);
            signature.initVerify(generatePublic);
            signature.update(str.getBytes("utf-8"));
            return signature.verify(a.d(str2));
        } catch (Exception unused) {
            return false;
        }
    }

    private static PublicKey c(String str, String str2) throws NoSuchAlgorithmException, Exception {
        return KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(a.d(str2)));
    }

    private static String d(String str, String str2) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            PrivateKey generatePrivate = KeyFactory.getInstance(f4262a).generatePrivate(new PKCS8EncodedKeySpec(a.d(str2)));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, generatePrivate);
            byte[] d2 = a.d(str);
            int blockSize = cipher.getBlockSize();
            byteArrayOutputStream = new ByteArrayOutputStream();
            for (int i2 = 0; i2 < d2.length; i2 += blockSize) {
                try {
                    byteArrayOutputStream.write(cipher.doFinal(d2, i2, d2.length - i2 < blockSize ? d2.length - i2 : blockSize));
                } catch (Exception unused) {
                    if (byteArrayOutputStream == null) {
                        return null;
                    }
                    try {
                        byteArrayOutputStream.close();
                        return null;
                    } catch (IOException unused2) {
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            }
            String str3 = new String(byteArrayOutputStream.toByteArray());
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused4) {
            }
            return str3;
        } catch (Exception unused5) {
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static String e(String str, String str2) {
        try {
            PrivateKey generatePrivate = KeyFactory.getInstance(f4262a).generatePrivate(new PKCS8EncodedKeySpec(a.d(str2)));
            Signature signature = Signature.getInstance(f4263b);
            signature.initSign(generatePrivate);
            signature.update(str.getBytes("utf-8"));
            return a.b(signature.sign());
        } catch (Exception unused) {
            return null;
        }
    }
}
