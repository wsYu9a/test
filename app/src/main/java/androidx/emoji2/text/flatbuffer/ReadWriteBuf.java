package androidx.emoji2.text.flatbuffer;

/* loaded from: classes.dex */
interface ReadWriteBuf extends ReadBuf {
    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    int limit();

    void put(byte b10);

    void put(byte[] bArr, int i10, int i11);

    void putBoolean(boolean z10);

    void putDouble(double d10);

    void putFloat(float f10);

    void putInt(int i10);

    void putLong(long j10);

    void putShort(short s10);

    boolean requestCapacity(int i10);

    void set(int i10, byte b10);

    void set(int i10, byte[] bArr, int i11, int i12);

    void setBoolean(int i10, boolean z10);

    void setDouble(int i10, double d10);

    void setFloat(int i10, float f10);

    void setInt(int i10, int i11);

    void setLong(int i10, long j10);

    void setShort(int i10, short s10);

    int writePosition();
}
