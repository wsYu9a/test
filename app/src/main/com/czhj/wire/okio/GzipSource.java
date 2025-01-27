package com.czhj.wire.okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* loaded from: classes2.dex */
public final class GzipSource implements Source {

    /* renamed from: f */
    public static final byte f8918f = 1;

    /* renamed from: g */
    public static final byte f8919g = 2;

    /* renamed from: h */
    public static final byte f8920h = 3;

    /* renamed from: i */
    public static final byte f8921i = 4;

    /* renamed from: j */
    public static final byte f8922j = 0;

    /* renamed from: k */
    public static final byte f8923k = 1;

    /* renamed from: l */
    public static final byte f8924l = 2;

    /* renamed from: m */
    public static final byte f8925m = 3;

    /* renamed from: b */
    public final BufferedSource f8927b;

    /* renamed from: c */
    public final Inflater f8928c;

    /* renamed from: d */
    public final InflaterSource f8929d;

    /* renamed from: a */
    public int f8926a = 0;

    /* renamed from: e */
    public final CRC32 f8930e = new CRC32();

    public GzipSource(Source source) {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        Inflater inflater = new Inflater(true);
        this.f8928c = inflater;
        BufferedSource buffer = Okio.buffer(source);
        this.f8927b = buffer;
        this.f8929d = new InflaterSource(buffer, inflater);
    }

    public final void a(String str, int i10, int i11) throws IOException {
        if (i11 != i10) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i11), Integer.valueOf(i10)));
        }
    }

    public final void b() throws IOException {
        a("CRC", this.f8927b.readIntLe(), (int) this.f8930e.getValue());
        a("ISIZE", this.f8927b.readIntLe(), this.f8928c.getTotalOut());
    }

    @Override // com.czhj.wire.okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f8929d.close();
    }

    @Override // com.czhj.wire.okio.Source
    public long read(Buffer buffer, long j10) throws IOException {
        if (j10 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        }
        if (j10 == 0) {
            return 0L;
        }
        if (this.f8926a == 0) {
            a();
            this.f8926a = 1;
        }
        if (this.f8926a == 1) {
            long j11 = buffer.f8900b;
            long read = this.f8929d.read(buffer, j10);
            if (read != -1) {
                a(buffer, j11, read);
                return read;
            }
            this.f8926a = 2;
        }
        if (this.f8926a == 2) {
            b();
            this.f8926a = 3;
            if (!this.f8927b.exhausted()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // com.czhj.wire.okio.Source
    public Timeout timeout() {
        return this.f8927b.timeout();
    }

    public final void a() throws IOException {
        this.f8927b.require(10L);
        byte b10 = this.f8927b.buffer().getByte(3L);
        boolean z10 = ((b10 >> 1) & 1) == 1;
        if (z10) {
            a(this.f8927b.buffer(), 0L, 10L);
        }
        a("ID1ID2", 8075, this.f8927b.readShort());
        this.f8927b.skip(8L);
        if (((b10 >> 2) & 1) == 1) {
            this.f8927b.require(2L);
            if (z10) {
                a(this.f8927b.buffer(), 0L, 2L);
            }
            long readShortLe = this.f8927b.buffer().readShortLe();
            this.f8927b.require(readShortLe);
            if (z10) {
                a(this.f8927b.buffer(), 0L, readShortLe);
            }
            this.f8927b.skip(readShortLe);
        }
        if (((b10 >> 3) & 1) == 1) {
            long indexOf = this.f8927b.indexOf((byte) 0);
            if (indexOf == -1) {
                throw new EOFException();
            }
            if (z10) {
                a(this.f8927b.buffer(), 0L, indexOf + 1);
            }
            this.f8927b.skip(indexOf + 1);
        }
        if (((b10 >> 4) & 1) == 1) {
            long indexOf2 = this.f8927b.indexOf((byte) 0);
            if (indexOf2 == -1) {
                throw new EOFException();
            }
            if (z10) {
                a(this.f8927b.buffer(), 0L, indexOf2 + 1);
            }
            this.f8927b.skip(indexOf2 + 1);
        }
        if (z10) {
            a("FHCRC", this.f8927b.readShortLe(), (short) this.f8930e.getValue());
            this.f8930e.reset();
        }
    }

    public final void a(Buffer buffer, long j10, long j11) {
        Segment segment = buffer.f8899a;
        while (true) {
            long j12 = segment.f8952c - segment.f8951b;
            if (j10 < j12) {
                break;
            }
            j10 -= j12;
            segment = segment.f8955f;
        }
        while (j11 > 0) {
            int min = (int) Math.min(segment.f8952c - r6, j11);
            this.f8930e.update(segment.f8950a, (int) (segment.f8951b + j10), min);
            j11 -= min;
            segment = segment.f8955f;
            j10 = 0;
        }
    }
}
