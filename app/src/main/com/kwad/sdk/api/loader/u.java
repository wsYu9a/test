package com.kwad.sdk.api.loader;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
final class u {
    private static final char[] aqE = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r7v8 */
    public static String getFileMD5(File file) {
        Throwable th2;
        ?? r72;
        Exception e10;
        DigestInputStream digestInputStream;
        MessageDigest messageDigest;
        try {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
                digestInputStream = new DigestInputStream(new FileInputStream(file), messageDigest);
            } catch (Exception e11) {
                e10 = e11;
                digestInputStream = null;
            } catch (Throwable th3) {
                th2 = th3;
                r72 = 0;
                b(r72);
                throw th2;
            }
            try {
                byte[] bArr = new byte[1024];
                for (int read = digestInputStream.read(bArr); read != -1; read = digestInputStream.read(bArr)) {
                }
                byte[] digest = messageDigest.digest();
                StringBuilder sb2 = new StringBuilder(digest.length * 2);
                for (byte b10 : digest) {
                    int i10 = b10 & 255;
                    if (i10 < 16) {
                        sb2.append("0");
                    }
                    sb2.append(Integer.toHexString(i10));
                }
                String sb3 = sb2.toString();
                b(digestInputStream);
                return sb3;
            } catch (Exception e12) {
                e10 = e12;
                e10.printStackTrace();
                b(digestInputStream);
                return "";
            }
        } catch (Throwable th4) {
            th2 = th4;
            r72 = file;
            b(r72);
            throw th2;
        }
    }
}
