package a3;

/* loaded from: classes.dex */
public class c {
    public static byte[] a(int i10) {
        return new byte[]{(byte) ((i10 >> 24) % 256), (byte) ((i10 >> 16) % 256), (byte) ((i10 >> 8) % 256), (byte) (i10 % 256)};
    }
}
