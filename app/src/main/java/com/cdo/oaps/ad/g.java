package com.cdo.oaps.ad;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a */
    private static final char[] f6544a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static int a(char c2, int i2) {
        int digit = Character.digit(c2, 16);
        if (digit != -1) {
            return digit;
        }
        throw new d("Illegal hexadecimal charcter " + c2 + " at index " + i2);
    }

    public static byte[] a(char[] cArr) {
        int length = cArr.length;
        if ((length & 1) != 0) {
            throw new d("Odd number of characters.");
        }
        byte[] bArr = new byte[length >> 1];
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int a2 = a(cArr[i2], i2);
            int i4 = i2 + 1;
            int a3 = a(cArr[i4], i4);
            i2 = i4 + 1;
            bArr[i3] = (byte) (((a2 << 4) | a3) & 255);
            i3++;
        }
        return bArr;
    }

    public static char[] a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length << 1];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i2 + 1;
            char[] cArr2 = f6544a;
            cArr[i2] = cArr2[(bArr[i3] & 240) >>> 4];
            i2 = i4 + 1;
            cArr[i4] = cArr2[bArr[i3] & 15];
        }
        return cArr;
    }

    public Object a(Object obj) {
        try {
            return a(obj instanceof String ? ((String) obj).toCharArray() : (char[]) obj);
        } catch (ClassCastException e2) {
            throw new d(e2.getMessage());
        }
    }

    public Object b(Object obj) {
        try {
            return a(obj instanceof String ? ((String) obj).getBytes() : (byte[]) obj);
        } catch (ClassCastException e2) {
            throw new e(e2.getMessage());
        }
    }

    public byte[] b(byte[] bArr) {
        return a(new String(bArr).toCharArray());
    }

    public byte[] c(byte[] bArr) {
        return new String(a(bArr)).getBytes();
    }
}
