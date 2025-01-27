package com.czhj.wire.okio;

import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class ForwardingSource implements Source {

    /* renamed from: a */
    public final Source f8911a;

    public ForwardingSource(Source source) {
        if (source == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f8911a = source;
    }

    @Override // com.czhj.wire.okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f8911a.close();
    }

    public final Source delegate() {
        return this.f8911a;
    }

    @Override // com.czhj.wire.okio.Source
    public long read(Buffer buffer, long j10) throws IOException {
        return this.f8911a.read(buffer, j10);
    }

    @Override // com.czhj.wire.okio.Source
    public Timeout timeout() {
        return this.f8911a.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f8911a.toString() + ")";
    }
}
