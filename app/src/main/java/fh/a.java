package fh;

import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a */
    public static final byte[] f26040a = b.b("x04VOtkJ");

    /* renamed from: fh.a$a */
    public static class C0697a {
        public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr);
        }
    }

    public static class b {
        public static String a(byte[] bArr) {
            if (bArr == null) {
                return null;
            }
            try {
                StringBuffer stringBuffer = new StringBuffer();
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(bArr);
                for (byte b10 : messageDigest.digest()) {
                    int i10 = b10 & 255;
                    stringBuffer.append(i10 < 16 ? "0" + Integer.toHexString(i10) : Integer.toHexString(i10));
                }
                return stringBuffer.toString();
            } catch (NoSuchAlgorithmException unused) {
                return "No";
            }
        }

        public static byte[] b(String str) {
            if (str == null) {
                return null;
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes());
                return messageDigest.digest();
            } catch (NoSuchAlgorithmException unused) {
                return null;
            }
        }
    }

    public static class c {
        public static byte[] a(byte[] bArr) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th2) {
                try {
                    gZIPOutputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }
}
