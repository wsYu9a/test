package com.czhj.wire.okio;

import java.io.IOException;
import java.util.zip.Deflater;

/* loaded from: classes2.dex */
public final class DeflaterSink implements Sink {

    /* renamed from: a */
    public final BufferedSink f8907a;

    /* renamed from: b */
    public final Deflater f8908b;

    /* renamed from: c */
    public boolean f8909c;

    public DeflaterSink(BufferedSink bufferedSink, Deflater deflater) {
        if (bufferedSink == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (deflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.f8907a = bufferedSink;
        this.f8908b = deflater;
    }

    public final void a(boolean z10) throws IOException {
        Segment a10;
        int i10;
        Buffer buffer = this.f8907a.buffer();
        while (true) {
            a10 = buffer.a(1);
            if (z10) {
                try {
                    Deflater deflater = this.f8908b;
                    byte[] bArr = a10.f8950a;
                    int i11 = a10.f8952c;
                    i10 = deflater.deflate(bArr, i11, 8192 - i11, 2);
                } catch (Throwable unused) {
                    i10 = 0;
                }
            } else {
                Deflater deflater2 = this.f8908b;
                byte[] bArr2 = a10.f8950a;
                int i12 = a10.f8952c;
                i10 = deflater2.deflate(bArr2, i12, 8192 - i12);
            }
            if (i10 > 0) {
                a10.f8952c += i10;
                buffer.f8900b += i10;
                this.f8907a.emitCompleteSegments();
            } else if (this.f8908b.needsInput()) {
                break;
            }
        }
        if (a10.f8951b == a10.f8952c) {
            buffer.f8899a = a10.pop();
            SegmentPool.a(a10);
        }
    }

    @Override // com.czhj.wire.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f8909c) {
            return;
        }
        try {
            a();
            th = null;
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f8908b.end();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        try {
            this.f8907a.close();
        } catch (Throwable th4) {
            if (th == null) {
                th = th4;
            }
        }
        this.f8909c = true;
        if (th != null) {
            Util.sneakyRethrow(th);
        }
    }

    @Override // com.czhj.wire.okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        a(true);
        this.f8907a.flush();
    }

    @Override // com.czhj.wire.okio.Sink
    public Timeout timeout() {
        return this.f8907a.timeout();
    }

    public String toString() {
        return "DeflaterSink(" + this.f8907a + ")";
    }

    @Override // com.czhj.wire.okio.Sink
    public void write(Buffer buffer, long j10) throws IOException {
        Util.checkOffsetAndCount(buffer.f8900b, 0L, j10);
        while (j10 > 0) {
            Segment segment = buffer.f8899a;
            int min = (int) Math.min(j10, segment.f8952c - segment.f8951b);
            this.f8908b.setInput(segment.f8950a, segment.f8951b, min);
            a(false);
            long j11 = min;
            buffer.f8900b -= j11;
            int i10 = segment.f8951b + min;
            segment.f8951b = i10;
            if (i10 == segment.f8952c) {
                buffer.f8899a = segment.pop();
                SegmentPool.a(segment);
            }
            j10 -= j11;
        }
    }

    public DeflaterSink(Sink sink, Deflater deflater) {
        this(Okio.buffer(sink), deflater);
    }

    public void a() throws IOException {
        this.f8908b.finish();
        a(false);
    }
}
