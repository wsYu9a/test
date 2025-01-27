package com.google.common.hash;

import b5.u;
import com.google.errorprone.annotations.Immutable;
import i5.c;
import i5.h;
import i5.m;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@Immutable
@h
/* loaded from: classes2.dex */
final class MessageDigestHashFunction extends c implements Serializable {
    private final int bytes;
    private final MessageDigest prototype;
    private final boolean supportsClone;
    private final String toString;

    public static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final String algorithmName;
        private final int bytes;
        private final String toString;

        public /* synthetic */ SerializedForm(String str, int i10, String str2, a aVar) {
            this(str, i10, str2);
        }

        private Object readResolve() {
            return new MessageDigestHashFunction(this.algorithmName, this.bytes, this.toString);
        }

        private SerializedForm(String str, int i10, String str2) {
            this.algorithmName = str;
            this.bytes = i10;
            this.toString = str2;
        }
    }

    public static final class b extends i5.a {

        /* renamed from: b */
        public final MessageDigest f10060b;

        /* renamed from: c */
        public final int f10061c;

        /* renamed from: d */
        public boolean f10062d;

        public /* synthetic */ b(MessageDigest messageDigest, int i10, a aVar) {
            this(messageDigest, i10);
        }

        private void j() {
            u.h0(!this.f10062d, "Cannot re-use a Hasher after calling hash() on it");
        }

        @Override // i5.m
        public HashCode i() {
            j();
            this.f10062d = true;
            return this.f10061c == this.f10060b.getDigestLength() ? HashCode.fromBytesNoCopy(this.f10060b.digest()) : HashCode.fromBytesNoCopy(Arrays.copyOf(this.f10060b.digest(), this.f10061c));
        }

        @Override // i5.a
        public void update(byte b10) {
            j();
            this.f10060b.update(b10);
        }

        public b(MessageDigest messageDigest, int i10) {
            this.f10060b = messageDigest;
            this.f10061c = i10;
        }

        @Override // i5.a
        public void update(byte[] bArr, int i10, int i11) {
            j();
            this.f10060b.update(bArr, i10, i11);
        }

        @Override // i5.a
        public void update(ByteBuffer byteBuffer) {
            j();
            this.f10060b.update(byteBuffer);
        }
    }

    public MessageDigestHashFunction(String str, String str2) {
        MessageDigest messageDigest = getMessageDigest(str);
        this.prototype = messageDigest;
        this.bytes = messageDigest.getDigestLength();
        this.toString = (String) u.E(str2);
        this.supportsClone = supportsClone(messageDigest);
    }

    private static MessageDigest getMessageDigest(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e10) {
            throw new AssertionError(e10);
        }
    }

    private static boolean supportsClone(MessageDigest messageDigest) {
        try {
            messageDigest.clone();
            return true;
        } catch (CloneNotSupportedException unused) {
            return false;
        }
    }

    @Override // i5.k
    public int bits() {
        return this.bytes * 8;
    }

    @Override // i5.k
    public m newHasher() {
        if (this.supportsClone) {
            try {
                return new b((MessageDigest) this.prototype.clone(), this.bytes);
            } catch (CloneNotSupportedException unused) {
            }
        }
        return new b(getMessageDigest(this.prototype.getAlgorithm()), this.bytes);
    }

    public String toString() {
        return this.toString;
    }

    public Object writeReplace() {
        return new SerializedForm(this.prototype.getAlgorithm(), this.bytes, this.toString);
    }

    public MessageDigestHashFunction(String str, int i10, String str2) {
        this.toString = (String) u.E(str2);
        MessageDigest messageDigest = getMessageDigest(str);
        this.prototype = messageDigest;
        int digestLength = messageDigest.getDigestLength();
        u.m(i10 >= 4 && i10 <= digestLength, "bytes (%s) must be >= 4 and < %s", i10, digestLength);
        this.bytes = i10;
        this.supportsClone = supportsClone(messageDigest);
    }
}
