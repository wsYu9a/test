package com.czhj.wire.okio;

import java.io.Closeable;
import java.io.IOException;

/* loaded from: classes2.dex */
public interface Source extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    long read(Buffer buffer, long j10) throws IOException;

    Timeout timeout();
}
