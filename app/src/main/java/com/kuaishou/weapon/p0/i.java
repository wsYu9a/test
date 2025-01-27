package com.kuaishou.weapon.p0;

/* loaded from: classes.dex */
public class i {
    private static byte a(byte b2, byte b3) {
        return (byte) (((char) (((char) Byte.decode("0x" + new String(new byte[]{b2})).byteValue()) << 4)) ^ ((char) Byte.decode("0x" + new String(new byte[]{b3})).byteValue()));
    }

    public static String a(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        return new String(c(c(str), str2));
    }

    private static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length);
        for (byte b2 : bArr) {
            stringBuffer.append((char) b2);
        }
        return stringBuffer.toString();
    }

    private static byte[] a(String str) {
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[256];
        for (int i2 = 0; i2 < 256; i2++) {
            bArr[i2] = (byte) i2;
        }
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < 256; i5++) {
            i4 = ((bytes[i3] & 255) + (bArr[i5] & 255) + i4) & 255;
            byte b2 = bArr[i5];
            bArr[i5] = bArr[i4];
            bArr[i4] = b2;
            i3 = (i3 + 1) % bytes.length;
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr, String str) {
        if (bArr == null || str == null) {
            return null;
        }
        return c(bArr, str);
    }

    private static String b(String str) {
        String str2 = "";
        for (int i2 = 0; i2 < str.length(); i2++) {
            String hexString = Integer.toHexString(str.charAt(i2) & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            str2 = str2 + hexString;
        }
        return str2;
    }

    private static byte[] b(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        return c(str.getBytes(), str2);
    }

    public static byte[] b(byte[] bArr, String str) {
        if (bArr == null || str == null) {
            return null;
        }
        return c(bArr, str);
    }

    private static byte[] c(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        byte[] bytes = str.getBytes();
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = a(bytes[i3], bytes[i3 + 1]);
        }
        return bArr;
    }

    private static byte[] c(byte[] bArr, String str) {
        byte[] a2 = a(str);
        byte[] bArr2 = new byte[bArr.length];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < bArr.length; i4++) {
            i2 = (i2 + 1) & 255;
            i3 = ((a2[i2] & 255) + i3) & 255;
            byte b2 = a2[i2];
            a2[i2] = a2[i3];
            a2[i3] = b2;
            int i5 = ((a2[i2] & 255) + (a2[i3] & 255)) & 255;
            bArr2[i4] = (byte) (a2[i5] ^ bArr[i4]);
        }
        return bArr2;
    }
}
