package com.czhj.wire.okio;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes2.dex */
public final class HashingSink extends ForwardingSink {

    /* renamed from: b */
    public final MessageDigest f8931b;

    public HashingSink(Sink sink, String str) {
        super(sink);
        try {
            this.f8931b = MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    public static HashingSink md5(Sink sink) {
        return new HashingSink(sink, "MD5");
    }

    public static HashingSink sha1(Sink sink) {
        return new HashingSink(sink, "SHA-1");
    }

    public static HashingSink sha256(Sink sink) {
        return new HashingSink(sink, "SHA-256");
    }

    public ByteString hash() {
        return ByteString.of(this.f8931b.digest());
    }

    @Override // com.czhj.wire.okio.ForwardingSink, com.czhj.wire.okio.Sink
    public void write(Buffer buffer, long j10) throws IOException {
        Util.checkOffsetAndCount(buffer.f8900b, 0L, j10);
        Segment segment = buffer.f8899a;
        long j11 = 0;
        while (j11 < j10) {
            int min = (int) Math.min(j10 - j11, segment.f8952c - segment.f8951b);
            this.f8931b.update(segment.f8950a, segment.f8951b, min);
            j11 += min;
            segment = segment.f8955f;
        }
        super.write(buffer, j10);
    }
}
