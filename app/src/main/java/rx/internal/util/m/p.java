package rx.internal.util.m;

/* loaded from: classes5.dex */
public final class p {
    private p() {
        throw new IllegalStateException("No instances!");
    }

    public static boolean a(int i2) {
        return (i2 & (i2 + (-1))) == 0;
    }

    public static int b(int i2) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i2 - 1));
    }
}
