package com.bytedance.pangle.res.a;

import java.io.DataInput;

/* loaded from: classes2.dex */
public abstract class f implements DataInput {

    /* renamed from: a */
    public final i f7784a;

    public f(i iVar) {
        this.f7784a = iVar;
    }

    @Override // java.io.DataInput
    public boolean readBoolean() {
        return this.f7784a.readBoolean();
    }

    @Override // java.io.DataInput
    public byte readByte() {
        return this.f7784a.readByte();
    }

    @Override // java.io.DataInput
    public char readChar() {
        return this.f7784a.readChar();
    }

    @Override // java.io.DataInput
    public double readDouble() {
        return this.f7784a.readDouble();
    }

    @Override // java.io.DataInput
    public float readFloat() {
        return this.f7784a.readFloat();
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i10, int i11) {
        this.f7784a.readFully(bArr, i10, i11);
    }

    @Override // java.io.DataInput
    public int readInt() {
        return this.f7784a.readInt();
    }

    @Override // java.io.DataInput
    public String readLine() {
        return this.f7784a.readLine();
    }

    @Override // java.io.DataInput
    public long readLong() {
        return this.f7784a.readLong();
    }

    @Override // java.io.DataInput
    public short readShort() {
        return this.f7784a.readShort();
    }

    @Override // java.io.DataInput
    public String readUTF() {
        return this.f7784a.readUTF();
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() {
        return this.f7784a.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() {
        return this.f7784a.readUnsignedShort();
    }

    @Override // java.io.DataInput
    public int skipBytes(int i10) {
        return this.f7784a.skipBytes(i10);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) {
        this.f7784a.readFully(bArr);
    }
}
