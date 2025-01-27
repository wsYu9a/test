package ck;

/* loaded from: classes5.dex */
public final class p {
    public p() {
        throw new IllegalStateException("No instances!");
    }

    public static boolean a(int i10) {
        return (i10 & (i10 + (-1))) == 0;
    }

    public static int b(int i10) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i10 - 1));
    }
}
