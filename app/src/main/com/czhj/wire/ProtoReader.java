package com.czhj.wire;

import b5.a;
import com.czhj.wire.okio.Buffer;
import com.czhj.wire.okio.BufferedSource;
import com.czhj.wire.okio.ByteString;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;

/* loaded from: classes2.dex */
public final class ProtoReader {

    /* renamed from: i */
    public static final int f8857i = 65;

    /* renamed from: j */
    public static final int f8858j = 7;

    /* renamed from: k */
    public static final int f8859k = 3;

    /* renamed from: l */
    public static final int f8860l = 0;

    /* renamed from: m */
    public static final int f8861m = 1;

    /* renamed from: n */
    public static final int f8862n = 2;

    /* renamed from: o */
    public static final int f8863o = 3;

    /* renamed from: p */
    public static final int f8864p = 4;

    /* renamed from: q */
    public static final int f8865q = 5;

    /* renamed from: r */
    public static final int f8866r = 6;

    /* renamed from: s */
    public static final int f8867s = 7;

    /* renamed from: a */
    public final BufferedSource f8868a;

    /* renamed from: d */
    public int f8871d;

    /* renamed from: h */
    public FieldEncoding f8875h;

    /* renamed from: b */
    public long f8869b = 0;

    /* renamed from: c */
    public long f8870c = Long.MAX_VALUE;

    /* renamed from: e */
    public int f8872e = 2;

    /* renamed from: f */
    public int f8873f = -1;

    /* renamed from: g */
    public long f8874g = -1;

    public ProtoReader(BufferedSource bufferedSource) {
        this.f8868a = bufferedSource;
    }

    public final void a(int i10) throws IOException {
        if (this.f8872e != i10) {
            long j10 = this.f8869b;
            long j11 = this.f8870c;
            if (j10 > j11) {
                throw new IOException("Expected to end at " + this.f8870c + " but was " + this.f8869b);
            }
            if (j10 != j11) {
                this.f8872e = 7;
                return;
            } else {
                this.f8870c = this.f8874g;
                this.f8874g = -1L;
            }
        }
        this.f8872e = 6;
    }

    public final int b() throws IOException {
        int i10;
        this.f8868a.require(1L);
        this.f8869b++;
        byte readByte = this.f8868a.readByte();
        if (readByte >= 0) {
            return readByte;
        }
        int i11 = readByte & Byte.MAX_VALUE;
        this.f8868a.require(1L);
        this.f8869b++;
        byte readByte2 = this.f8868a.readByte();
        if (readByte2 >= 0) {
            i10 = readByte2 << 7;
        } else {
            i11 |= (readByte2 & Byte.MAX_VALUE) << 7;
            this.f8868a.require(1L);
            this.f8869b++;
            byte readByte3 = this.f8868a.readByte();
            if (readByte3 >= 0) {
                i10 = readByte3 << 14;
            } else {
                i11 |= (readByte3 & Byte.MAX_VALUE) << 14;
                this.f8868a.require(1L);
                this.f8869b++;
                byte readByte4 = this.f8868a.readByte();
                if (readByte4 < 0) {
                    int i12 = i11 | ((readByte4 & Byte.MAX_VALUE) << 21);
                    this.f8868a.require(1L);
                    this.f8869b++;
                    byte readByte5 = this.f8868a.readByte();
                    int i13 = i12 | (readByte5 << a.F);
                    if (readByte5 >= 0) {
                        return i13;
                    }
                    for (int i14 = 0; i14 < 5; i14++) {
                        this.f8868a.require(1L);
                        this.f8869b++;
                        if (this.f8868a.readByte() >= 0) {
                            return i13;
                        }
                    }
                    throw new ProtocolException("Malformed VARINT");
                }
                i10 = readByte4 << a.f1198y;
            }
        }
        return i11 | i10;
    }

    public long beginMessage() throws IOException {
        if (this.f8872e != 2) {
            throw new IllegalStateException("Unexpected call to beginMessage()");
        }
        int i10 = this.f8871d + 1;
        this.f8871d = i10;
        if (i10 > 65) {
            throw new IOException("Wire recursion limit exceeded");
        }
        long j10 = this.f8874g;
        this.f8874g = -1L;
        this.f8872e = 6;
        return j10;
    }

    public void endMessage(long j10) throws IOException {
        if (this.f8872e != 6) {
            throw new IllegalStateException("Unexpected call to endMessage()");
        }
        int i10 = this.f8871d - 1;
        this.f8871d = i10;
        if (i10 < 0 || this.f8874g != -1) {
            throw new IllegalStateException("No corresponding call to beginMessage()");
        }
        if (this.f8869b == this.f8870c || i10 == 0) {
            this.f8870c = j10;
            return;
        }
        throw new IOException("Expected to end at " + this.f8870c + " but was " + this.f8869b);
    }

    public ByteString forEachTag(TagHandler tagHandler) throws IOException {
        long beginMessage = beginMessage();
        Buffer buffer = null;
        ProtoWriter protoWriter = null;
        while (true) {
            int nextTag = nextTag();
            if (nextTag == -1) {
                break;
            }
            if (tagHandler.decodeMessage(nextTag) == TagHandler.UNKNOWN_TAG) {
                if (buffer == null) {
                    buffer = new Buffer();
                    protoWriter = new ProtoWriter(buffer);
                }
                a(protoWriter, nextTag);
            }
        }
        endMessage(beginMessage);
        return buffer != null ? buffer.readByteString() : ByteString.EMPTY;
    }

    public int nextTag() throws IOException {
        int i10 = this.f8872e;
        if (i10 == 7) {
            this.f8872e = 2;
            return this.f8873f;
        }
        if (i10 != 6) {
            throw new IllegalStateException("Unexpected call to nextTag()");
        }
        while (this.f8869b < this.f8870c && !this.f8868a.exhausted()) {
            int b10 = b();
            if (b10 == 0) {
                throw new ProtocolException("Unexpected tag 0");
            }
            int i11 = b10 >> 3;
            this.f8873f = i11;
            int i12 = b10 & 7;
            if (i12 == 0) {
                this.f8875h = FieldEncoding.VARINT;
                this.f8872e = 0;
                return i11;
            }
            if (i12 == 1) {
                this.f8875h = FieldEncoding.FIXED64;
                this.f8872e = 1;
                return i11;
            }
            if (i12 == 2) {
                this.f8875h = FieldEncoding.LENGTH_DELIMITED;
                this.f8872e = 2;
                int b11 = b();
                if (b11 < 0) {
                    throw new ProtocolException("Negative length: " + b11);
                }
                if (this.f8874g != -1) {
                    throw new IllegalStateException();
                }
                long j10 = this.f8870c;
                this.f8874g = j10;
                long j11 = this.f8869b + b11;
                this.f8870c = j11;
                if (j11 <= j10) {
                    return this.f8873f;
                }
                throw new EOFException();
            }
            if (i12 != 3) {
                if (i12 == 4) {
                    throw new ProtocolException("Unexpected end group");
                }
                if (i12 == 5) {
                    this.f8875h = FieldEncoding.FIXED32;
                    this.f8872e = 5;
                    return i11;
                }
                throw new ProtocolException("Unexpected field encoding: " + i12);
            }
            b(i11);
        }
        return -1;
    }

    public FieldEncoding peekFieldEncoding() {
        return this.f8875h;
    }

    public ByteString readBytes() throws IOException {
        long a10 = a();
        this.f8868a.require(a10);
        return this.f8868a.readByteString(a10);
    }

    public int readFixed32() throws IOException {
        int i10 = this.f8872e;
        if (i10 != 5 && i10 != 2) {
            throw new ProtocolException("Expected FIXED32 or LENGTH_DELIMITED but was " + this.f8872e);
        }
        this.f8868a.require(4L);
        this.f8869b += 4;
        int readIntLe = this.f8868a.readIntLe();
        a(5);
        return readIntLe;
    }

    public long readFixed64() throws IOException {
        int i10 = this.f8872e;
        if (i10 != 1 && i10 != 2) {
            throw new ProtocolException("Expected FIXED64 or LENGTH_DELIMITED but was " + this.f8872e);
        }
        this.f8868a.require(8L);
        this.f8869b += 8;
        long readLongLe = this.f8868a.readLongLe();
        a(1);
        return readLongLe;
    }

    public String readString() throws IOException {
        long a10 = a();
        this.f8868a.require(a10);
        return this.f8868a.readUtf8(a10);
    }

    public int readVarint32() throws IOException {
        int i10 = this.f8872e;
        if (i10 == 0 || i10 == 2) {
            int b10 = b();
            a(0);
            return b10;
        }
        throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.f8872e);
    }

    public long readVarint64() throws IOException {
        int i10 = this.f8872e;
        if (i10 != 0 && i10 != 2) {
            throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.f8872e);
        }
        long j10 = 0;
        for (int i11 = 0; i11 < 64; i11 += 7) {
            this.f8868a.require(1L);
            this.f8869b++;
            j10 |= (r4 & Byte.MAX_VALUE) << i11;
            if ((this.f8868a.readByte() & 128) == 0) {
                a(0);
                return j10;
            }
        }
        throw new ProtocolException("WireInput encountered a malformed varint");
    }

    public void skip() throws IOException {
        int i10 = this.f8872e;
        if (i10 == 0) {
            readVarint64();
            return;
        }
        if (i10 == 1) {
            readFixed64();
            return;
        }
        if (i10 == 2) {
            this.f8868a.skip(a());
        } else {
            if (i10 != 5) {
                throw new IllegalStateException("Unexpected call to skip()");
            }
            readFixed32();
        }
    }

    public final long a() throws IOException {
        if (this.f8872e != 2) {
            throw new ProtocolException("Expected LENGTH_DELIMITED but was " + this.f8872e);
        }
        long j10 = this.f8870c - this.f8869b;
        this.f8868a.require(j10);
        this.f8872e = 6;
        this.f8869b = this.f8870c;
        this.f8870c = this.f8874g;
        this.f8874g = -1L;
        return j10;
    }

    public final void b(int i10) throws IOException {
        while (this.f8869b < this.f8870c && !this.f8868a.exhausted()) {
            int b10 = b();
            if (b10 == 0) {
                throw new ProtocolException("Unexpected tag 0");
            }
            int i11 = b10 >> 3;
            int i12 = b10 & 7;
            if (i12 == 0) {
                this.f8872e = 0;
                readVarint64();
            } else if (i12 == 1) {
                this.f8872e = 1;
                readFixed64();
            } else if (i12 == 2) {
                long b11 = b();
                this.f8869b += b11;
                this.f8868a.skip(b11);
            } else if (i12 == 3) {
                b(i11);
            } else if (i12 == 4) {
                if (i11 != i10) {
                    throw new ProtocolException("Unexpected end group");
                }
                return;
            } else {
                if (i12 != 5) {
                    throw new ProtocolException("Unexpected field encoding: " + i12);
                }
                this.f8872e = 5;
                readFixed32();
            }
        }
        throw new EOFException();
    }

    public final void a(ProtoWriter protoWriter, int i10) throws IOException {
        ProtoAdapter<?> rawProtoAdapter = peekFieldEncoding().rawProtoAdapter();
        try {
            rawProtoAdapter.encodeWithTag(protoWriter, i10, rawProtoAdapter.decode(this));
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }
}
