package com.czhj.wire.okio;

import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class ForwardingSink implements Sink {

    /* renamed from: a */
    public final Sink f8910a;

    public ForwardingSink(Sink sink) {
        if (sink == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f8910a = sink;
    }

    @Override // com.czhj.wire.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f8910a.close();
    }

    public final Sink delegate() {
        return this.f8910a;
    }

    @Override // com.czhj.wire.okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        this.f8910a.flush();
    }

    @Override // com.czhj.wire.okio.Sink
    public Timeout timeout() {
        return this.f8910a.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f8910a.toString() + ")";
    }

    @Override // com.czhj.wire.okio.Sink
    public void write(Buffer buffer, long j10) throws IOException {
        this.f8910a.write(buffer, j10);
    }
}
