package com.bytedance.pangle.res.a;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;

/* loaded from: classes2.dex */
public final class i extends FilterInputStream implements DataInput {
    public i(e eVar) {
        super(eVar);
    }

    private static int a(byte b10, byte b11, byte b12, byte b13) {
        return (b10 << b5.a.B) | ((b11 & 255) << 16) | ((b12 & 255) << 8) | (b13 & 255);
    }

    private byte b() {
        int read = ((FilterInputStream) this).in.read();
        if (-1 != read) {
            return (byte) read;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public final boolean readBoolean() {
        return readUnsignedByte() != 0;
    }

    @Override // java.io.DataInput
    public final byte readByte() {
        return (byte) readUnsignedByte();
    }

    @Override // java.io.DataInput
    public final char readChar() {
        return (char) readUnsignedShort();
    }

    @Override // java.io.DataInput
    public final double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public final float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr, int i10, int i11) {
        d.a(this, bArr, i10, i11);
    }

    @Override // java.io.DataInput
    public final int readInt() {
        byte b10 = b();
        byte b11 = b();
        return a(b(), b(), b11, b10);
    }

    @Override // java.io.DataInput
    public final String readLine() {
        throw new UnsupportedOperationException("readLine is not supported");
    }

    @Override // java.io.DataInput
    public final long readLong() {
        byte b10 = b();
        byte b11 = b();
        byte b12 = b();
        byte b13 = b();
        byte b14 = b();
        return ((b() & 255) << 56) | ((b() & 255) << 48) | ((b() & 255) << 40) | ((b14 & 255) << 32) | ((b13 & 255) << 24) | ((b12 & 255) << 16) | ((b11 & 255) << 8) | (b10 & 255);
    }

    @Override // java.io.DataInput
    public final short readShort() {
        return (short) readUnsignedShort();
    }

    @Override // java.io.DataInput
    public final String readUTF() {
        return new DataInputStream(((FilterInputStream) this).in).readUTF();
    }

    @Override // java.io.DataInput
    public final int readUnsignedByte() {
        int read = ((FilterInputStream) this).in.read();
        if (read >= 0) {
            return read;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public final int readUnsignedShort() {
        return a((byte) 0, (byte) 0, b(), b());
    }

    @Override // java.io.DataInput
    public final int skipBytes(int i10) {
        return (int) ((FilterInputStream) this).in.skip(i10);
    }

    public final e a() {
        return (e) ((FilterInputStream) this).in;
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr) {
        d.a(this, bArr, 0, bArr.length);
    }
}
