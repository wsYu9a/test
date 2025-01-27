package com.czhj.wire.okio;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes2.dex */
public final class HashingSource extends ForwardingSource {

    /* renamed from: b */
    public final MessageDigest f8932b;

    public HashingSource(Source source, String str) {
        super(source);
        try {
            this.f8932b = MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    public static HashingSource md5(Source source) {
        return new HashingSource(source, "MD5");
    }

    public static HashingSource sha1(Source source) {
        return new HashingSource(source, "SHA-1");
    }

    public static HashingSource sha256(Source source) {
        return new HashingSource(source, "SHA-256");
    }

    public ByteString hash() {
        return ByteString.of(this.f8932b.digest());
    }

    @Override // com.czhj.wire.okio.ForwardingSource, com.czhj.wire.okio.Source
    public long read(Buffer buffer, long j10) throws IOException {
        long read = super.read(buffer, j10);
        if (read != -1) {
            long j11 = buffer.f8900b;
            long j12 = j11 - read;
            Segment segment = buffer.f8899a;
            while (j11 > buffer.f8900b - read) {
                segment = segment.f8956g;
                j11 -= segment.f8952c - segment.f8951b;
            }
            while (j11 < buffer.f8900b) {
                int i10 = (int) ((segment.f8951b + j12) - j11);
                this.f8932b.update(segment.f8950a, i10, segment.f8952c - i10);
                j12 = (segment.f8952c - segment.f8951b) + j11;
                j11 = j12;
            }
        }
        return read;
    }
}
