package com.kwad.sdk.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public final class ai {
    static final char[] aqE = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String ac(File file) {
        FileInputStream fileInputStream;
        MessageDigest messageDigest;
        FileInputStream fileInputStream2 = null;
        if (file == null) {
            return null;
        }
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            fileInputStream = new FileInputStream(file);
        } catch (Exception e10) {
            e = e10;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
            throw th;
        }
        try {
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        String m10 = m(messageDigest.digest());
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                        return m10;
                    }
                    messageDigest.update(bArr, 0, read);
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream2 = fileInputStream;
                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
            return null;
        }
    }

    @NonNull
    public static String by(String str) {
        return TextUtils.isEmpty(str) ? "" : l(str.getBytes());
    }

    public static String gL(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            return toHexString(digest, 0, digest.length);
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
            return "";
        }
    }

    public static String gM(String str) {
        return ac(new File(str));
    }

    public static String l(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            StringBuilder sb2 = new StringBuilder();
            int length = digest.length;
            for (int i10 = 0; i10 < length; i10++) {
                int i11 = digest[i10];
                if (i11 < 0) {
                    i11 += 256;
                }
                if (i11 < 16) {
                    sb2.append("0");
                }
                sb2.append(Integer.toHexString(i11));
            }
            return sb2.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String m(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b10 : bArr) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(b10)));
        }
        return stringBuffer.toString();
    }

    public static String toHexString(byte[] bArr, int i10, int i11) {
        au.checkNotNull(bArr);
        if (i11 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i12 = i11 * 2;
        char[] cArr = new char[i12];
        int i13 = 0;
        for (int i14 = 0; i14 < i11; i14++) {
            byte b10 = bArr[i14];
            int i15 = i13 + 1;
            char[] cArr2 = aqE;
            cArr[i13] = cArr2[(b10 & 255) >> 4];
            i13 += 2;
            cArr[i15] = cArr2[b10 & 15];
        }
        return new String(cArr, 0, i12);
    }
}
