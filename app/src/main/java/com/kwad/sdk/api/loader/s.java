package com.kwad.sdk.api.loader;

import com.baidu.mobads.sdk.internal.bu;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
final class s {
    private static final char[] aaD = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.Closeable] */
    static String getFileMD5(File file) {
        Throwable th;
        Exception e2;
        DigestInputStream digestInputStream;
        MessageDigest messageDigest;
        try {
            try {
                messageDigest = MessageDigest.getInstance(bu.f5659a);
                digestInputStream = new DigestInputStream(new FileInputStream((File) file), messageDigest);
            } catch (Exception e3) {
                e2 = e3;
                digestInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                file = 0;
                b(file);
                throw th;
            }
            try {
                while (digestInputStream.read(new byte[1024]) != -1) {
                }
                byte[] digest = messageDigest.digest();
                StringBuilder sb = new StringBuilder(digest.length * 2);
                for (byte b2 : digest) {
                    int i2 = b2 & 255;
                    if (i2 < 16) {
                        sb.append("0");
                    }
                    sb.append(Integer.toHexString(i2));
                }
                String sb2 = sb.toString();
                b(digestInputStream);
                return sb2;
            } catch (Exception e4) {
                e2 = e4;
                e2.printStackTrace();
                b(digestInputStream);
                return "";
            }
        } catch (Throwable th3) {
            th = th3;
            b(file);
            throw th;
        }
    }
}
