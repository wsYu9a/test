package com.heytap.nearx.a.a;

import com.vivo.advv.virtualview.common.ExprCommon;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.internal.ByteCompanionObject;
import okio.BufferedSource;
import okio.ByteString;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a */
    private final BufferedSource f9035a;

    /* renamed from: d */
    private int f9038d;

    /* renamed from: h */
    private a f9042h;

    /* renamed from: b */
    private long f9036b = 0;

    /* renamed from: c */
    private long f9037c = Long.MAX_VALUE;

    /* renamed from: e */
    private int f9039e = 2;

    /* renamed from: f */
    private int f9040f = -1;

    /* renamed from: g */
    private long f9041g = -1;

    public f(BufferedSource bufferedSource) {
        this.f9035a = bufferedSource;
    }

    private void a(int i2) throws IOException {
        while (this.f9036b < this.f9037c && !this.f9035a.exhausted()) {
            int j2 = j();
            if (j2 == 0) {
                throw new ProtocolException("Unexpected tag 0");
            }
            int i3 = j2 >> 3;
            int i4 = j2 & 7;
            if (i4 == 0) {
                this.f9039e = 0;
                g();
            } else if (i4 == 1) {
                this.f9039e = 1;
                i();
            } else if (i4 == 2) {
                long j3 = j();
                this.f9036b += j3;
                this.f9035a.skip(j3);
            } else if (i4 == 3) {
                a(i3);
            } else if (i4 == 4) {
                if (i3 != i2) {
                    throw new ProtocolException("Unexpected end group");
                }
                return;
            } else {
                if (i4 != 5) {
                    throw new ProtocolException("Unexpected field encoding: " + i4);
                }
                this.f9039e = 5;
                h();
            }
        }
        throw new EOFException();
    }

    private void b(int i2) throws IOException {
        if (this.f9039e != i2) {
            long j2 = this.f9036b;
            long j3 = this.f9037c;
            if (j2 > j3) {
                throw new IOException("Expected to end at " + this.f9037c + " but was " + this.f9036b);
            }
            if (j2 != j3) {
                this.f9039e = 7;
                return;
            } else {
                this.f9037c = this.f9041g;
                this.f9041g = -1L;
            }
        }
        this.f9039e = 6;
    }

    private int j() throws IOException {
        int i2;
        this.f9036b++;
        byte readByte = this.f9035a.readByte();
        if (readByte >= 0) {
            return readByte;
        }
        int i3 = readByte & ByteCompanionObject.MAX_VALUE;
        this.f9036b++;
        byte readByte2 = this.f9035a.readByte();
        if (readByte2 >= 0) {
            i2 = readByte2 << 7;
        } else {
            i3 |= (readByte2 & ByteCompanionObject.MAX_VALUE) << 7;
            this.f9036b++;
            byte readByte3 = this.f9035a.readByte();
            if (readByte3 >= 0) {
                i2 = readByte3 << 14;
            } else {
                i3 |= (readByte3 & ByteCompanionObject.MAX_VALUE) << 14;
                this.f9036b++;
                byte readByte4 = this.f9035a.readByte();
                if (readByte4 < 0) {
                    this.f9036b++;
                    byte readByte5 = this.f9035a.readByte();
                    int i4 = i3 | ((readByte4 & ByteCompanionObject.MAX_VALUE) << 21) | (readByte5 << 28);
                    if (readByte5 >= 0) {
                        return i4;
                    }
                    for (int i5 = 0; i5 < 5; i5++) {
                        this.f9036b++;
                        if (this.f9035a.readByte() >= 0) {
                            return i4;
                        }
                    }
                    throw new ProtocolException("Malformed VARINT");
                }
                i2 = readByte4 << ExprCommon.OPCODE_JMP;
            }
        }
        return i3 | i2;
    }

    private long k() throws IOException {
        if (this.f9039e != 2) {
            throw new ProtocolException("Expected LENGTH_DELIMITED but was " + this.f9039e);
        }
        long j2 = this.f9037c - this.f9036b;
        this.f9035a.require(j2);
        this.f9039e = 6;
        this.f9036b = this.f9037c;
        this.f9037c = this.f9041g;
        this.f9041g = -1L;
        return j2;
    }

    public long a() throws IOException {
        if (this.f9039e != 2) {
            throw new IllegalStateException("Unexpected call to beginMessage()");
        }
        int i2 = this.f9038d + 1;
        this.f9038d = i2;
        if (i2 > 65) {
            throw new IOException("Wire recursion limit exceeded");
        }
        long j2 = this.f9041g;
        this.f9041g = -1L;
        this.f9039e = 6;
        return j2;
    }

    public void a(long j2) throws IOException {
        if (this.f9039e != 6) {
            throw new IllegalStateException("Unexpected call to endMessage()");
        }
        int i2 = this.f9038d - 1;
        this.f9038d = i2;
        if (i2 < 0 || this.f9041g != -1) {
            throw new IllegalStateException("No corresponding call to beginMessage()");
        }
        if (this.f9036b == this.f9037c || i2 == 0) {
            this.f9037c = j2;
            return;
        }
        throw new IOException("Expected to end at " + this.f9037c + " but was " + this.f9036b);
    }

    public int b() throws IOException {
        int i2 = this.f9039e;
        if (i2 != 7) {
            if (i2 != 6) {
                throw new IllegalStateException("Unexpected call to nextTag()");
            }
            while (this.f9036b < this.f9037c && !this.f9035a.exhausted()) {
                int j2 = j();
                if (j2 == 0) {
                    throw new ProtocolException("Unexpected tag 0");
                }
                int i3 = j2 >> 3;
                this.f9040f = i3;
                int i4 = j2 & 7;
                if (i4 == 0) {
                    this.f9042h = a.VARINT;
                    this.f9039e = 0;
                } else if (i4 == 1) {
                    this.f9042h = a.FIXED64;
                    this.f9039e = 1;
                } else if (i4 == 2) {
                    this.f9042h = a.LENGTH_DELIMITED;
                    this.f9039e = 2;
                    int j3 = j();
                    if (j3 < 0) {
                        throw new ProtocolException("Negative length: " + j3);
                    }
                    if (this.f9041g != -1) {
                        throw new IllegalStateException();
                    }
                    long j4 = this.f9037c;
                    this.f9041g = j4;
                    long j5 = j3 + this.f9036b;
                    this.f9037c = j5;
                    if (j5 > j4) {
                        throw new EOFException();
                    }
                } else if (i4 == 3) {
                    a(i3);
                } else {
                    if (i4 == 4) {
                        throw new ProtocolException("Unexpected end group");
                    }
                    if (i4 != 5) {
                        throw new ProtocolException("Unexpected field encoding: " + i4);
                    }
                    this.f9042h = a.FIXED32;
                    this.f9039e = 5;
                }
                return i3;
            }
            return -1;
        }
        this.f9039e = 2;
        return this.f9040f;
    }

    public a c() {
        return this.f9042h;
    }

    public ByteString d() throws IOException {
        return this.f9035a.readByteString(k());
    }

    public String e() throws IOException {
        return this.f9035a.readUtf8(k());
    }

    public int f() throws IOException {
        int i2 = this.f9039e;
        if (i2 == 0 || i2 == 2) {
            int j2 = j();
            b(0);
            return j2;
        }
        throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.f9039e);
    }

    public long g() throws IOException {
        int i2 = this.f9039e;
        if (i2 != 0 && i2 != 2) {
            throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.f9039e);
        }
        long j2 = 0;
        for (int i3 = 0; i3 < 64; i3 += 7) {
            this.f9036b++;
            j2 |= (r4 & ByteCompanionObject.MAX_VALUE) << i3;
            if ((this.f9035a.readByte() & ByteCompanionObject.MIN_VALUE) == 0) {
                b(0);
                return j2;
            }
        }
        throw new ProtocolException("WireInput encountered a malformed varint");
    }

    public int h() throws IOException {
        int i2 = this.f9039e;
        if (i2 != 5 && i2 != 2) {
            throw new ProtocolException("Expected FIXED32 or LENGTH_DELIMITED but was " + this.f9039e);
        }
        this.f9035a.require(4L);
        this.f9036b += 4;
        int readIntLe = this.f9035a.readIntLe();
        b(5);
        return readIntLe;
    }

    public long i() throws IOException {
        int i2 = this.f9039e;
        if (i2 != 1 && i2 != 2) {
            throw new ProtocolException("Expected FIXED64 or LENGTH_DELIMITED but was " + this.f9039e);
        }
        this.f9035a.require(8L);
        this.f9036b += 8;
        long readLongLe = this.f9035a.readLongLe();
        b(1);
        return readLongLe;
    }
}
