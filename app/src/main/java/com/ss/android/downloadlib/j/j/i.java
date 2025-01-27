package com.ss.android.downloadlib.j.j;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

/* loaded from: classes4.dex */
public class i {
    public static byte[] j(CharSequence charSequence, String str) throws Exception {
        return j(charSequence.toString().getBytes(), str);
    }

    public static byte[] j(byte[] bArr, String str) throws Exception {
        return j(new ByteArrayInputStream(bArr), str);
    }

    public static byte[] j(InputStream inputStream, String str) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return messageDigest.digest();
            }
            messageDigest.update(bArr, 0, read);
        }
    }
}
