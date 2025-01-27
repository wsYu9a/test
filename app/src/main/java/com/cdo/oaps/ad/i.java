package com.cdo.oaps.ad;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public class i {
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        return a(f.d(new c().b(b(str), h.a(h.a("7U727ALEWH8".getBytes())))));
    }

    private static String a(byte[] bArr) {
        return bArr == null ? "" : a(bArr, 0, bArr.length);
    }

    private static String a(byte[] bArr, int i2, int i3) {
        if (bArr == null) {
            return "";
        }
        try {
            return new String(bArr, i2, i3, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    private static byte[] b(String str) {
        if (str != null) {
            try {
                try {
                    return str.getBytes("UTF-8");
                } catch (UnsupportedEncodingException unused) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeUTF(str);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    dataOutputStream.close();
                    int length = byteArray.length - 2;
                    byte[] bArr = new byte[length];
                    System.arraycopy(byteArray, 2, bArr, 0, length);
                    return bArr;
                }
            } catch (IOException unused2) {
            }
        }
        return new byte[0];
    }
}
