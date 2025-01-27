package com.qq.e.comm.managers.plugin;

/* loaded from: classes3.dex */
class d {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f16598a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", com.kwad.sdk.m.e.TAG, "f"};

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 : bArr) {
            if (i10 < 0) {
                i10 += 256;
            }
            StringBuilder sb2 = new StringBuilder();
            String[] strArr = f16598a;
            sb2.append(strArr[i10 / 16]);
            sb2.append(strArr[i10 % 16]);
            stringBuffer.append(sb2.toString());
        }
        return stringBuffer.toString();
    }
}
