package com.czhj.wire.okio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
final class RealBufferedSource implements BufferedSource {

    /* renamed from: a */
    public boolean f8946a;
    public final Buffer buffer = new Buffer();
    public final Source source;

    /* renamed from: com.czhj.wire.okio.RealBufferedSource$1 */
    public class AnonymousClass1 extends InputStream {
        public AnonymousClass1() {
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            RealBufferedSource realBufferedSource = RealBufferedSource.this;
            if (realBufferedSource.f8946a) {
                throw new IOException("closed");
            }
            return (int) Math.min(realBufferedSource.buffer.f8900b, 2147483647L);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            RealBufferedSource.this.close();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            RealBufferedSource realBufferedSource = RealBufferedSource.this;
            if (realBufferedSource.f8946a) {
                throw new IOException("closed");
            }
            Buffer buffer = realBufferedSource.buffer;
            if (buffer.f8900b == 0 && realBufferedSource.source.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1;
            }
            return RealBufferedSource.this.buffer.readByte() & 255;
        }

        public String toString() {
            return RealBufferedSource.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) throws IOException {
            if (RealBufferedSource.this.f8946a) {
                throw new IOException("closed");
            }
            Util.checkOffsetAndCount(bArr.length, i10, i11);
            RealBufferedSource realBufferedSource = RealBufferedSource.this;
            Buffer buffer = realBufferedSource.buffer;
            if (buffer.f8900b == 0 && realBufferedSource.source.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1;
            }
            return RealBufferedSource.this.buffer.read(bArr, i10, i11);
        }
    }

    public RealBufferedSource(Source source) {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.source = source;
    }

    @Override // com.czhj.wire.okio.BufferedSource, com.czhj.wire.okio.BufferedSink
    public Buffer buffer() {
        return this.buffer;
    }

    @Override // com.czhj.wire.okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f8946a) {
            return;
        }
        this.f8946a = true;
        this.source.close();
        this.buffer.clear();
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public boolean exhausted() throws IOException {
        if (this.f8946a) {
            throw new IllegalStateException("closed");
        }
        return this.buffer.exhausted() && this.source.read(this.buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long indexOf(byte b10) throws IOException {
        return indexOf(b10, 0L);
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long indexOfElement(ByteString byteString) throws IOException {
        return indexOfElement(byteString, 0L);
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public InputStream inputStream() {
        return new InputStream() { // from class: com.czhj.wire.okio.RealBufferedSource.1
            public AnonymousClass1() {
            }

            @Override // java.io.InputStream
            public int available() throws IOException {
                RealBufferedSource realBufferedSource = RealBufferedSource.this;
                if (realBufferedSource.f8946a) {
                    throw new IOException("closed");
                }
                return (int) Math.min(realBufferedSource.buffer.f8900b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                RealBufferedSource.this.close();
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                RealBufferedSource realBufferedSource = RealBufferedSource.this;
                if (realBufferedSource.f8946a) {
                    throw new IOException("closed");
                }
                Buffer buffer = realBufferedSource.buffer;
                if (buffer.f8900b == 0 && realBufferedSource.source.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
                return RealBufferedSource.this.buffer.readByte() & 255;
            }

            public String toString() {
                return RealBufferedSource.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i10, int i11) throws IOException {
                if (RealBufferedSource.this.f8946a) {
                    throw new IOException("closed");
                }
                Util.checkOffsetAndCount(bArr.length, i10, i11);
                RealBufferedSource realBufferedSource = RealBufferedSource.this;
                Buffer buffer = realBufferedSource.buffer;
                if (buffer.f8900b == 0 && realBufferedSource.source.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
                return RealBufferedSource.this.buffer.read(bArr, i10, i11);
            }
        };
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long readAll(Sink sink) throws IOException {
        Buffer buffer;
        if (sink == null) {
            throw new IllegalArgumentException("sink == null");
        }
        long j10 = 0;
        while (true) {
            long read = this.source.read(this.buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            buffer = this.buffer;
            if (read == -1) {
                break;
            }
            long completeSegmentByteCount = buffer.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                j10 += completeSegmentByteCount;
                sink.write(this.buffer, completeSegmentByteCount);
            }
        }
        if (buffer.size() <= 0) {
            return j10;
        }
        long size = j10 + this.buffer.size();
        Buffer buffer2 = this.buffer;
        sink.write(buffer2, buffer2.size());
        return size;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public byte readByte() throws IOException {
        require(1L);
        return this.buffer.readByte();
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public byte[] readByteArray() throws IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readByteArray();
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public ByteString readByteString() throws IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readByteString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        if (r2 == 0) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003f, code lost:
    
        throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9] or '-' character but was %#x", java.lang.Byte.valueOf(r4)));
     */
    @Override // com.czhj.wire.okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long readDecimalLong() throws java.io.IOException {
        /*
            r7 = this;
            r0 = 1
            r1 = 1
            r7.require(r1)
            r1 = 0
            r2 = 0
        L8:
            int r3 = r2 + 1
            long r4 = (long) r3
            boolean r4 = r7.request(r4)
            if (r4 == 0) goto L40
            com.czhj.wire.okio.Buffer r4 = r7.buffer
            long r5 = (long) r2
            byte r4 = r4.getByte(r5)
            r5 = 48
            if (r4 < r5) goto L20
            r5 = 57
            if (r4 <= r5) goto L27
        L20:
            if (r2 != 0) goto L29
            r5 = 45
            if (r4 == r5) goto L27
            goto L29
        L27:
            r2 = r3
            goto L8
        L29:
            if (r2 == 0) goto L2c
            goto L40
        L2c:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.Byte r3 = java.lang.Byte.valueOf(r4)
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r1] = r3
            java.lang.String r1 = "Expected leading [0-9] or '-' character but was %#x"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            r2.<init>(r0)
            throw r2
        L40:
            com.czhj.wire.okio.Buffer r0 = r7.buffer
            long r0 = r0.readDecimalLong()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.czhj.wire.okio.RealBufferedSource.readDecimalLong():long");
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public void readFully(Buffer buffer, long j10) throws IOException {
        try {
            require(j10);
            this.buffer.readFully(buffer, j10);
        } catch (EOFException e10) {
            buffer.writeAll(this.buffer);
            throw e10;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0033, code lost:
    
        if (r2 == 0) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
    
        throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9a-fA-F] character but was %#x", java.lang.Byte.valueOf(r4)));
     */
    @Override // com.czhj.wire.okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long readHexadecimalUnsignedLong() throws java.io.IOException {
        /*
            r7 = this;
            r0 = 1
            r1 = 1
            r7.require(r1)
            r1 = 0
            r2 = 0
        L8:
            int r3 = r2 + 1
            long r4 = (long) r3
            boolean r4 = r7.request(r4)
            if (r4 == 0) goto L4a
            com.czhj.wire.okio.Buffer r4 = r7.buffer
            long r5 = (long) r2
            byte r4 = r4.getByte(r5)
            r5 = 48
            if (r4 < r5) goto L20
            r5 = 57
            if (r4 <= r5) goto L31
        L20:
            r5 = 97
            if (r4 < r5) goto L28
            r5 = 102(0x66, float:1.43E-43)
            if (r4 <= r5) goto L31
        L28:
            r5 = 65
            if (r4 < r5) goto L33
            r5 = 70
            if (r4 <= r5) goto L31
            goto L33
        L31:
            r2 = r3
            goto L8
        L33:
            if (r2 == 0) goto L36
            goto L4a
        L36:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.Byte r3 = java.lang.Byte.valueOf(r4)
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r1] = r3
            java.lang.String r1 = "Expected leading [0-9a-fA-F] character but was %#x"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            r2.<init>(r0)
            throw r2
        L4a:
            com.czhj.wire.okio.Buffer r0 = r7.buffer
            long r0 = r0.readHexadecimalUnsignedLong()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.czhj.wire.okio.RealBufferedSource.readHexadecimalUnsignedLong():long");
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public int readInt() throws IOException {
        require(4L);
        return this.buffer.readInt();
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public int readIntLe() throws IOException {
        require(4L);
        return this.buffer.readIntLe();
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long readLong() throws IOException {
        require(8L);
        return this.buffer.readLong();
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long readLongLe() throws IOException {
        require(8L);
        return this.buffer.readLongLe();
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public short readShort() throws IOException {
        require(2L);
        return this.buffer.readShort();
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public short readShortLe() throws IOException {
        require(2L);
        return this.buffer.readShortLe();
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public String readString(long j10, Charset charset) throws IOException {
        require(j10);
        if (charset != null) {
            return this.buffer.readString(j10, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public String readUtf8() throws IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readUtf8();
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public int readUtf8CodePoint() throws IOException {
        long j10;
        require(1L);
        byte b10 = this.buffer.getByte(0L);
        if ((b10 & 224) == 192) {
            j10 = 2;
        } else {
            if ((b10 & 240) != 224) {
                if ((b10 & 248) == 240) {
                    j10 = 4;
                }
                return this.buffer.readUtf8CodePoint();
            }
            j10 = 3;
        }
        require(j10);
        return this.buffer.readUtf8CodePoint();
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public String readUtf8Line() throws IOException {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return this.buffer.a(indexOf);
        }
        long j10 = this.buffer.f8900b;
        if (j10 != 0) {
            return readUtf8(j10);
        }
        return null;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public String readUtf8LineStrict() throws IOException {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return this.buffer.a(indexOf);
        }
        Buffer buffer = new Buffer();
        Buffer buffer2 = this.buffer;
        buffer2.copyTo(buffer, 0L, Math.min(32L, buffer2.size()));
        throw new EOFException("\\n not found: size=" + this.buffer.size() + " content=" + buffer.readByteString().hex() + "…");
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public boolean request(long j10) throws IOException {
        Buffer buffer;
        if (j10 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        }
        if (this.f8946a) {
            throw new IllegalStateException("closed");
        }
        do {
            buffer = this.buffer;
            if (buffer.f8900b >= j10) {
                return true;
            }
        } while (this.source.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
        return false;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public void require(long j10) throws IOException {
        if (!request(j10)) {
            throw new EOFException();
        }
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public int select(Options options) throws IOException {
        Buffer buffer;
        if (this.f8946a) {
            throw new IllegalStateException("closed");
        }
        do {
            int a10 = this.buffer.a(options);
            if (a10 == -1) {
                return -1;
            }
            long size = options.f8943a[a10].size();
            buffer = this.buffer;
            if (size <= buffer.f8900b) {
                buffer.skip(size);
                return a10;
            }
        } while (this.source.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
        return -1;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public void skip(long j10) throws IOException {
        if (this.f8946a) {
            throw new IllegalStateException("closed");
        }
        while (j10 > 0) {
            Buffer buffer = this.buffer;
            if (buffer.f8900b == 0 && this.source.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j10, this.buffer.size());
            this.buffer.skip(min);
            j10 -= min;
        }
    }

    @Override // com.czhj.wire.okio.Source
    public Timeout timeout() {
        return this.source.timeout();
    }

    public String toString() {
        return "buffer(" + this.source + ")";
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long indexOf(byte b10, long j10) throws IOException {
        if (this.f8946a) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long indexOf = this.buffer.indexOf(b10, j10);
            if (indexOf != -1) {
                return indexOf;
            }
            Buffer buffer = this.buffer;
            long j11 = buffer.f8900b;
            if (this.source.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1L;
            }
            j10 = Math.max(j10, j11);
        }
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long indexOfElement(ByteString byteString, long j10) throws IOException {
        if (this.f8946a) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long indexOfElement = this.buffer.indexOfElement(byteString, j10);
            if (indexOfElement != -1) {
                return indexOfElement;
            }
            Buffer buffer = this.buffer;
            long j11 = buffer.f8900b;
            if (this.source.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1L;
            }
            j10 = Math.max(j10, j11);
        }
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        long j10 = i11;
        Util.checkOffsetAndCount(bArr.length, i10, j10);
        Buffer buffer = this.buffer;
        if (buffer.f8900b == 0 && this.source.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.buffer.read(bArr, i10, (int) Math.min(j10, this.buffer.f8900b));
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public byte[] readByteArray(long j10) throws IOException {
        require(j10);
        return this.buffer.readByteArray(j10);
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public ByteString readByteString(long j10) throws IOException {
        require(j10);
        return this.buffer.readByteString(j10);
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public void readFully(byte[] bArr) throws IOException {
        try {
            require(bArr.length);
            this.buffer.readFully(bArr);
        } catch (Throwable th2) {
            int i10 = 0;
            while (true) {
                Buffer buffer = this.buffer;
                long j10 = buffer.f8900b;
                if (j10 <= 0) {
                    throw th2;
                }
                int read = buffer.read(bArr, i10, (int) j10);
                if (read == -1) {
                    throw new AssertionError();
                }
                i10 += read;
            }
        }
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public String readString(Charset charset) throws IOException {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        this.buffer.writeAll(this.source);
        return this.buffer.readString(charset);
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public String readUtf8(long j10) throws IOException {
        require(j10);
        return this.buffer.readUtf8(j10);
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long indexOf(ByteString byteString) throws IOException {
        return indexOf(byteString, 0L);
    }

    @Override // com.czhj.wire.okio.Source
    public long read(Buffer buffer, long j10) throws IOException {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j10 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        }
        if (this.f8946a) {
            throw new IllegalStateException("closed");
        }
        Buffer buffer2 = this.buffer;
        if (buffer2.f8900b == 0 && this.source.read(buffer2, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1L;
        }
        return this.buffer.read(buffer, Math.min(j10, this.buffer.f8900b));
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long indexOf(ByteString byteString, long j10) throws IOException {
        if (this.f8946a) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long indexOf = this.buffer.indexOf(byteString, j10);
            if (indexOf != -1) {
                return indexOf;
            }
            Buffer buffer = this.buffer;
            long j11 = buffer.f8900b;
            if (this.source.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1L;
            }
            j10 = Math.max(j10, (j11 - byteString.size()) + 1);
        }
    }
}
