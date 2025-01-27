package com.bytedance.pangle.res.a;

import java.io.DataInput;

/* loaded from: classes.dex */
public abstract class f implements DataInput {

    /* renamed from: a */
    public final i f6270a;

    public f(i iVar) {
        this.f6270a = iVar;
    }

    @Override // java.io.DataInput
    public boolean readBoolean() {
        return this.f6270a.readBoolean();
    }

    @Override // java.io.DataInput
    public byte readByte() {
        return this.f6270a.readByte();
    }

    @Override // java.io.DataInput
    public char readChar() {
        return this.f6270a.readChar();
    }

    @Override // java.io.DataInput
    public double readDouble() {
        return this.f6270a.readDouble();
    }

    @Override // java.io.DataInput
    public float readFloat() {
        return this.f6270a.readFloat();
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i2, int i3) {
        this.f6270a.readFully(bArr, i2, i3);
    }

    @Override // java.io.DataInput
    public int readInt() {
        return this.f6270a.readInt();
    }

    @Override // java.io.DataInput
    public String readLine() {
        return this.f6270a.readLine();
    }

    @Override // java.io.DataInput
    public long readLong() {
        return this.f6270a.readLong();
    }

    @Override // java.io.DataInput
    public short readShort() {
        return this.f6270a.readShort();
    }

    @Override // java.io.DataInput
    public String readUTF() {
        return this.f6270a.readUTF();
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() {
        return this.f6270a.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() {
        return this.f6270a.readUnsignedShort();
    }

    @Override // java.io.DataInput
    public int skipBytes(int i2) {
        return this.f6270a.skipBytes(i2);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) {
        this.f6270a.readFully(bArr);
    }
}
