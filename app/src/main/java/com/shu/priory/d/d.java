package com.shu.priory.d;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a */
    private static byte[] f16907a = {com.sigmob.sdk.archives.tar.e.J, com.sigmob.sdk.archives.tar.e.L, com.sigmob.sdk.archives.tar.e.H, com.sigmob.sdk.archives.tar.e.K, com.sigmob.sdk.archives.tar.e.I, 65, com.sigmob.sdk.archives.tar.e.L, nf.c.f28888t, com.sigmob.sdk.archives.tar.e.H, nf.c.f28888t, com.sigmob.sdk.archives.tar.e.L, com.sigmob.sdk.archives.tar.e.K, com.sigmob.sdk.archives.tar.e.K, nf.c.f28888t, com.sigmob.sdk.archives.tar.e.J, 57};

    /* renamed from: b */
    private static byte[] f16908b = {com.sigmob.sdk.archives.tar.e.J, com.sigmob.sdk.archives.tar.e.H, com.sigmob.sdk.archives.tar.e.J, com.sigmob.sdk.archives.tar.e.G, com.sigmob.sdk.archives.tar.e.I, com.sigmob.sdk.archives.tar.e.F, com.sigmob.sdk.archives.tar.e.K, 70, com.sigmob.sdk.archives.tar.e.L, com.sigmob.sdk.archives.tar.e.J, com.sigmob.sdk.archives.tar.e.H, com.sigmob.sdk.archives.tar.e.E, com.sigmob.sdk.archives.tar.e.I, com.sigmob.sdk.archives.tar.e.G, com.sigmob.sdk.archives.tar.e.K, 67};

    /* renamed from: c */
    private static byte[] f16909c = {com.sigmob.sdk.archives.tar.e.I, nf.c.f28888t, com.sigmob.sdk.archives.tar.e.L, com.sigmob.sdk.archives.tar.e.I, com.sigmob.sdk.archives.tar.e.L, com.sigmob.sdk.archives.tar.e.I, com.sigmob.sdk.archives.tar.e.L, com.sigmob.sdk.archives.tar.e.E, com.sigmob.sdk.archives.tar.e.J, com.sigmob.sdk.archives.tar.e.F, com.sigmob.sdk.archives.tar.e.K, 67, com.sigmob.sdk.archives.tar.e.K, 70, com.sigmob.sdk.archives.tar.e.K, com.sigmob.sdk.archives.tar.e.I};

    /* renamed from: d */
    private static byte[] f16910d = {com.sigmob.sdk.archives.tar.e.I, com.sigmob.sdk.archives.tar.e.H, com.sigmob.sdk.archives.tar.e.K, com.sigmob.sdk.archives.tar.e.H, com.sigmob.sdk.archives.tar.e.I, 65, com.sigmob.sdk.archives.tar.e.K, 57, com.sigmob.sdk.archives.tar.e.K, com.sigmob.sdk.archives.tar.e.F, com.sigmob.sdk.archives.tar.e.I, com.sigmob.sdk.archives.tar.e.J, com.sigmob.sdk.archives.tar.e.I, com.sigmob.sdk.archives.tar.e.I, com.sigmob.sdk.archives.tar.e.H, com.sigmob.sdk.archives.tar.e.I};

    /* renamed from: e */
    private static byte[] f16911e;

    public static String a(String str, String str2) {
        if (b(str) || b(str2)) {
            return null;
        }
        if (f16911e == null) {
            f16911e = a();
        }
        byte[] a10 = a(str);
        int length = a10.length / 16;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i10 = 0; i10 < length; i10++) {
            byte[] bArr = new byte[16];
            for (int i11 = 0; i11 < 16; i11++) {
                bArr[i11] = a10[(i10 * 16) + i11];
            }
            arrayList.add(bArr);
        }
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            arrayList2.add(a(f16911e, (byte[]) arrayList.get(i12)));
        }
        for (int i13 = 0; i13 < ((byte[]) arrayList2.get(arrayList2.size() - 1)).length; i13++) {
            ((byte[]) arrayList2.get(arrayList2.size() - 1))[i13] = (byte) (r9[i13] - 48);
        }
        StringBuilder sb2 = new StringBuilder();
        for (byte b10 : (byte[]) arrayList2.get(arrayList2.size() - 1)) {
            sb2.append(String.valueOf((int) b10));
        }
        int intValue = Integer.valueOf(sb2.toString()).intValue();
        byte[] bArr2 = new byte[arrayList2.size() * 16];
        int i14 = 0;
        for (int i15 = 0; i15 < arrayList2.size(); i15++) {
            for (byte b11 : (byte[]) arrayList2.get(i15)) {
                bArr2[i14] = b11;
                i14++;
            }
        }
        return new String(bArr2, 0, intValue);
    }

    private static boolean b(String str) {
        return str == null || "".equals(str);
    }

    private static byte[] a() {
        return a(new String(f16907a) + new String(f16908b) + new String(f16909c) + new String(f16910d));
    }

    private static byte[] a(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            bArr[i10] = (byte) (((byte) "0123456789ABCDEF".indexOf(charArray[i11 + 1])) | (((byte) "0123456789ABCDEF".indexOf(charArray[i11])) << 4));
        }
        return bArr;
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        b bVar = new b();
        bVar.a(bArr);
        byte[] bArr3 = new byte[16];
        bVar.a(bArr2, bArr3);
        return bArr3;
    }
}
