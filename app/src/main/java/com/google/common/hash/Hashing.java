package com.google.common.hash;

import b5.u;
import com.google.errorprone.annotations.Immutable;
import i5.i;
import i5.j;
import i5.k;
import i5.m;
import i5.p;
import i5.s;
import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.Checksum;
import javax.annotation.CheckForNull;
import javax.crypto.spec.SecretKeySpec;

@i5.h
/* loaded from: classes2.dex */
public final class Hashing {

    /* renamed from: a */
    public static final int f10050a = (int) System.currentTimeMillis();

    @Immutable
    public enum ChecksumType implements p<Checksum> {
        CRC_32("Hashing.crc32()") { // from class: com.google.common.hash.Hashing.ChecksumType.1
            @Override // b5.z
            public Checksum get() {
                return new CRC32();
            }
        },
        ADLER_32("Hashing.adler32()") { // from class: com.google.common.hash.Hashing.ChecksumType.2
            @Override // b5.z
            public Checksum get() {
                return new Adler32();
            }
        };

        public final k hashFunction;

        /* renamed from: com.google.common.hash.Hashing$ChecksumType$1 */
        public enum AnonymousClass1 extends ChecksumType {
            @Override // b5.z
            public Checksum get() {
                return new CRC32();
            }
        }

        /* renamed from: com.google.common.hash.Hashing$ChecksumType$2 */
        public enum AnonymousClass2 extends ChecksumType {
            @Override // b5.z
            public Checksum get() {
                return new Adler32();
            }
        }

        /* synthetic */ ChecksumType(String str, a aVar) {
            this(str);
        }

        ChecksumType(String str) {
            this.hashFunction = new ChecksumHashFunction(this, 32, str);
        }
    }

    public static final class b extends i5.b {
        public /* synthetic */ b(k[] kVarArr, a aVar) {
            this(kVarArr);
        }

        @Override // i5.b
        public HashCode b(m[] mVarArr) {
            byte[] bArr = new byte[bits() / 8];
            int i10 = 0;
            for (m mVar : mVarArr) {
                HashCode i11 = mVar.i();
                i10 += i11.writeBytesTo(bArr, i10, i11.bits() / 8);
            }
            return HashCode.fromBytesNoCopy(bArr);
        }

        @Override // i5.k
        public int bits() {
            int i10 = 0;
            for (k kVar : this.f26879b) {
                i10 += kVar.bits();
            }
            return i10;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof b) {
                return Arrays.equals(this.f26879b, ((b) obj).f26879b);
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(this.f26879b);
        }

        public b(k... kVarArr) {
            super(kVarArr);
            for (k kVar : kVarArr) {
                u.o(kVar.bits() % 8 == 0, "the number of bits (%s) in hashFunction (%s) must be divisible by 8", kVar.bits(), kVar);
            }
        }
    }

    public static final class c {

        /* renamed from: a */
        public long f10051a;

        public c(long j10) {
            this.f10051a = j10;
        }

        public double a() {
            this.f10051a = (this.f10051a * 2862933555777941757L) + 1;
            return (((int) (r2 >>> 33)) + 1) / 2.147483648E9d;
        }
    }

    public static class d {

        /* renamed from: a */
        public static final k f10052a = new MessageDigestHashFunction("MD5", "Hashing.md5()");
    }

    public static class e {

        /* renamed from: a */
        public static final k f10053a = new MessageDigestHashFunction("SHA-1", "Hashing.sha1()");
    }

    public static class f {

        /* renamed from: a */
        public static final k f10054a = new MessageDigestHashFunction("SHA-256", "Hashing.sha256()");
    }

    public static class g {

        /* renamed from: a */
        public static final k f10055a = new MessageDigestHashFunction("SHA-384", "Hashing.sha384()");
    }

    public static class h {

        /* renamed from: a */
        public static final k f10056a = new MessageDigestHashFunction("SHA-512", "Hashing.sha512()");
    }

    @Deprecated
    public static k A(int i10) {
        return new Murmur3_32HashFunction(i10, false);
    }

    public static k B() {
        return Murmur3_32HashFunction.MURMUR3_32_FIXED;
    }

    public static k C(int i10) {
        return new Murmur3_32HashFunction(i10, true);
    }

    @Deprecated
    public static k D() {
        return e.f10053a;
    }

    public static k E() {
        return f.f10054a;
    }

    public static k F() {
        return g.f10055a;
    }

    public static k G() {
        return h.f10056a;
    }

    public static k H() {
        return SipHashFunction.SIP_HASH_24;
    }

    public static k I(long j10, long j11) {
        return new SipHashFunction(2, 4, j10, j11);
    }

    public static k a() {
        return ChecksumType.ADLER_32.hashFunction;
    }

    public static int b(int i10) {
        u.e(i10 > 0, "Number of bits must be positive");
        return (i10 + 31) & (-32);
    }

    public static HashCode c(Iterable<HashCode> iterable) {
        Iterator<HashCode> it = iterable.iterator();
        u.e(it.hasNext(), "Must be at least 1 hash code to combine.");
        int bits = it.next().bits() / 8;
        byte[] bArr = new byte[bits];
        Iterator<HashCode> it2 = iterable.iterator();
        while (it2.hasNext()) {
            byte[] asBytes = it2.next().asBytes();
            u.e(asBytes.length == bits, "All hashcodes must have the same bit length.");
            for (int i10 = 0; i10 < asBytes.length; i10++) {
                bArr[i10] = (byte) ((bArr[i10] * 37) ^ asBytes[i10]);
            }
        }
        return HashCode.fromBytesNoCopy(bArr);
    }

    public static HashCode d(Iterable<HashCode> iterable) {
        Iterator<HashCode> it = iterable.iterator();
        u.e(it.hasNext(), "Must be at least 1 hash code to combine.");
        int bits = it.next().bits() / 8;
        byte[] bArr = new byte[bits];
        Iterator<HashCode> it2 = iterable.iterator();
        while (it2.hasNext()) {
            byte[] asBytes = it2.next().asBytes();
            u.e(asBytes.length == bits, "All hashcodes must have the same bit length.");
            for (int i10 = 0; i10 < asBytes.length; i10++) {
                bArr[i10] = (byte) (bArr[i10] + asBytes[i10]);
            }
        }
        return HashCode.fromBytesNoCopy(bArr);
    }

    public static k e(k kVar, k kVar2, k... kVarArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(kVar);
        arrayList.add(kVar2);
        Collections.addAll(arrayList, kVarArr);
        return new b((k[]) arrayList.toArray(new k[0]));
    }

    public static k f(Iterable<k> iterable) {
        u.E(iterable);
        ArrayList arrayList = new ArrayList();
        Iterator<k> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        u.k(!arrayList.isEmpty(), "number of hash functions (%s) must be > 0", arrayList.size());
        return new b((k[]) arrayList.toArray(new k[0]));
    }

    public static int g(long j10, int i10) {
        int i11 = 0;
        u.k(i10 > 0, "buckets must be positive: %s", i10);
        c cVar = new c(j10);
        while (true) {
            int a10 = (int) ((i11 + 1) / cVar.a());
            if (a10 < 0 || a10 >= i10) {
                break;
            }
            i11 = a10;
        }
        return i11;
    }

    public static int h(HashCode hashCode, int i10) {
        return g(hashCode.padToLong(), i10);
    }

    public static k i() {
        return ChecksumType.CRC_32.hashFunction;
    }

    public static k j() {
        return i5.g.f26887b;
    }

    public static k k() {
        return i.f26897b;
    }

    public static k l() {
        return j.f26901b;
    }

    public static k m(int i10) {
        int b10 = b(i10);
        if (b10 == 32) {
            return Murmur3_32HashFunction.GOOD_FAST_HASH_32;
        }
        if (b10 <= 128) {
            return Murmur3_128HashFunction.GOOD_FAST_HASH_128;
        }
        int i11 = (b10 + 127) / 128;
        k[] kVarArr = new k[i11];
        kVarArr[0] = Murmur3_128HashFunction.GOOD_FAST_HASH_128;
        int i12 = f10050a;
        for (int i13 = 1; i13 < i11; i13++) {
            i12 += 1500450271;
            kVarArr[i13] = y(i12);
        }
        return new b(kVarArr);
    }

    public static k n(Key key) {
        return new s("HmacMD5", key, v("hmacMd5", key));
    }

    public static k o(byte[] bArr) {
        return n(new SecretKeySpec((byte[]) u.E(bArr), "HmacMD5"));
    }

    public static k p(Key key) {
        return new s("HmacSHA1", key, v("hmacSha1", key));
    }

    public static k q(byte[] bArr) {
        return p(new SecretKeySpec((byte[]) u.E(bArr), "HmacSHA1"));
    }

    public static k r(Key key) {
        return new s("HmacSHA256", key, v("hmacSha256", key));
    }

    public static k s(byte[] bArr) {
        return r(new SecretKeySpec((byte[]) u.E(bArr), "HmacSHA256"));
    }

    public static k t(Key key) {
        return new s("HmacSHA512", key, v("hmacSha512", key));
    }

    public static k u(byte[] bArr) {
        return t(new SecretKeySpec((byte[]) u.E(bArr), "HmacSHA512"));
    }

    public static String v(String str, Key key) {
        return String.format("Hashing.%s(Key[algorithm=%s, format=%s])", str, key.getAlgorithm(), key.getFormat());
    }

    @Deprecated
    public static k w() {
        return d.f10052a;
    }

    public static k x() {
        return Murmur3_128HashFunction.MURMUR3_128;
    }

    public static k y(int i10) {
        return new Murmur3_128HashFunction(i10);
    }

    @Deprecated
    public static k z() {
        return Murmur3_32HashFunction.MURMUR3_32;
    }
}
