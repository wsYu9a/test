package org.apache.tools.zip;

/* loaded from: classes5.dex */
public final class ZipShort implements Cloneable {
    private int value;

    public ZipShort(int i2) {
        this.value = i2;
    }

    public static byte[] getBytes(int i2) {
        return new byte[]{(byte) (i2 & 255), (byte) ((i2 & 65280) >> 8)};
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof ZipShort) && this.value == ((ZipShort) obj).getValue();
    }

    public byte[] getBytes() {
        int i2 = this.value;
        return new byte[]{(byte) (i2 & 255), (byte) ((i2 & 65280) >> 8)};
    }

    public int getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value;
    }

    public static int getValue(byte[] bArr, int i2) {
        return ((bArr[i2 + 1] << 8) & 65280) + (bArr[i2] & 255);
    }

    public ZipShort(byte[] bArr) {
        this(bArr, 0);
    }

    public ZipShort(byte[] bArr, int i2) {
        this.value = getValue(bArr, i2);
    }

    public static int getValue(byte[] bArr) {
        return getValue(bArr, 0);
    }
}
