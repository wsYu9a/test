package org.apache.tools.zip;

import com.vivo.advv.virtualview.common.ExprCommon;

/* loaded from: classes5.dex */
public final class ZipLong implements Cloneable {
    private long value;

    public ZipLong(long j2) {
        this.value = j2;
    }

    public static byte[] getBytes(long j2) {
        return new byte[]{(byte) (255 & j2), (byte) ((65280 & j2) >> 8), (byte) ((16711680 & j2) >> 16), (byte) ((j2 & 4278190080L) >> 24)};
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof ZipLong) && this.value == ((ZipLong) obj).getValue();
    }

    public byte[] getBytes() {
        return getBytes(this.value);
    }

    public long getValue() {
        return this.value;
    }

    public int hashCode() {
        return (int) this.value;
    }

    public static long getValue(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] << ExprCommon.OPCODE_OR) & 4278190080L) + ((bArr[i2 + 2] << 16) & 16711680) + ((bArr[i2 + 1] << 8) & 65280) + (bArr[i2] & 255);
    }

    public ZipLong(byte[] bArr) {
        this(bArr, 0);
    }

    public ZipLong(byte[] bArr, int i2) {
        this.value = getValue(bArr, i2);
    }

    public static long getValue(byte[] bArr) {
        return getValue(bArr, 0);
    }
}
