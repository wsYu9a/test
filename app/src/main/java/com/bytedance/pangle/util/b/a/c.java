package com.bytedance.pangle.util.b.a;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f6311a = new byte[2];

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f6312b = new byte[4];

    public final int a(RandomAccessFile randomAccessFile) {
        randomAccessFile.readFully(this.f6312b);
        return b(this.f6312b);
    }

    public final int b(RandomAccessFile randomAccessFile) {
        randomAccessFile.readFully(this.f6311a);
        return a(this.f6311a);
    }

    private static int b(byte[] bArr) {
        return ((((bArr[3] & 255) << 8) | (bArr[2] & 255)) << 16) | (bArr[0] & 255) | ((bArr[1] & 255) << 8);
    }

    public final void a(ByteArrayOutputStream byteArrayOutputStream, int i2) {
        a(this.f6311a, i2);
        byteArrayOutputStream.write(this.f6311a);
    }

    private static void b(byte[] bArr, int i2) {
        bArr[3] = (byte) (i2 >>> 24);
        bArr[2] = (byte) (i2 >>> 16);
        bArr[1] = (byte) (i2 >>> 8);
        bArr[0] = (byte) (i2 & 255);
    }

    public final void a(OutputStream outputStream, int i2) {
        b(this.f6312b, i2);
        outputStream.write(this.f6312b);
    }

    private static int a(byte[] bArr) {
        return ((bArr[1] & 255) << 8) | (bArr[0] & 255);
    }

    public static void a(byte[] bArr, int i2) {
        bArr[1] = (byte) (i2 >>> 8);
        bArr[0] = (byte) (i2 & 255);
    }
}
