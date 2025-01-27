package com.kwai.filedownloader.d;

import java.io.Closeable;

/* loaded from: classes2.dex */
public interface a extends Closeable {
    void IX();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void seek(long j2);

    void setLength(long j2);

    void write(byte[] bArr, int i2, int i3);
}
