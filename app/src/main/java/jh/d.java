package jh;

/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a */
    public static final char[] f27580a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        for (byte b10 : bArr) {
            char[] cArr = f27580a;
            sb2.append(cArr[(b10 & 240) >> 4]);
            sb2.append(cArr[b10 & 15]);
        }
        return sb2.toString();
    }
}
