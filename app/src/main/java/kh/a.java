package kh;

import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a */
    public static final byte[] f27832a = b.b("x04VOtkJ");

    /* renamed from: kh.a$a */
    public static class C0726a {
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
}
