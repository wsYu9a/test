package com.czhj.wire.okio;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

/* loaded from: classes2.dex */
public final class GzipSink implements Sink {

    /* renamed from: a */
    public final BufferedSink f8913a;

    /* renamed from: b */
    public final Deflater f8914b;

    /* renamed from: c */
    public final DeflaterSink f8915c;

    /* renamed from: d */
    public boolean f8916d;

    /* renamed from: e */
    public final CRC32 f8917e = new CRC32();

    public GzipSink(Sink sink) {
        if (sink == null) {
            throw new IllegalArgumentException("sink == null");
        }
        Deflater deflater = new Deflater(-1, true);
        this.f8914b = deflater;
        BufferedSink buffer = Okio.buffer(sink);
        this.f8913a = buffer;
        this.f8915c = new DeflaterSink(buffer, deflater);
        b();
    }

    public final void a(Buffer buffer, long j10) {
        Segment segment = buffer.f8899a;
        while (j10 > 0) {
            int min = (int) Math.min(j10, segment.f8952c - segment.f8951b);
            this.f8917e.update(segment.f8950a, segment.f8951b, min);
            j10 -= min;
            segment = segment.f8955f;
        }
    }

    public final void b() {
        Buffer buffer = this.f8913a.buffer();
        buffer.writeShort(8075);
        buffer.writeByte(8);
        buffer.writeByte(0);
        buffer.writeInt(0);
        buffer.writeByte(0);
        buffer.writeByte(0);
    }

    @Override // com.czhj.wire.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f8916d) {
            return;
        }
        try {
            this.f8915c.a();
            a();
            th = null;
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f8914b.end();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        try {
            this.f8913a.close();
        } catch (Throwable th4) {
            if (th == null) {
                th = th4;
            }
        }
        this.f8916d = true;
        if (th != null) {
            Util.sneakyRethrow(th);
        }
    }

    @Override // com.czhj.wire.okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        this.f8915c.flush();
    }

    @Override // com.czhj.wire.okio.Sink
    public Timeout timeout() {
        return this.f8913a.timeout();
    }

    @Override // com.czhj.wire.okio.Sink
    public void write(Buffer buffer, long j10) throws IOException {
        if (j10 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        }
        if (j10 == 0) {
            return;
        }
        a(buffer, j10);
        this.f8915c.write(buffer, j10);
    }

    public final void a() throws IOException {
        this.f8913a.writeIntLe((int) this.f8917e.getValue());
        this.f8913a.writeIntLe(this.f8914b.getTotalIn());
    }
}
