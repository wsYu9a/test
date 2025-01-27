package com.google.common.hash;

import b5.u;
import com.google.errorprone.annotations.Immutable;
import i5.c;
import i5.h;
import i5.m;
import i5.p;
import java.io.Serializable;
import java.util.zip.Checksum;

@Immutable
@h
/* loaded from: classes2.dex */
final class ChecksumHashFunction extends c implements Serializable {
    private static final long serialVersionUID = 0;
    private final int bits;
    private final p<? extends Checksum> checksumSupplier;
    private final String toString;

    public final class b extends i5.a {

        /* renamed from: b */
        public final Checksum f10047b;

        public /* synthetic */ b(ChecksumHashFunction checksumHashFunction, Checksum checksum, a aVar) {
            this(checksum);
        }

        @Override // i5.m
        public HashCode i() {
            long value = this.f10047b.getValue();
            return ChecksumHashFunction.this.bits == 32 ? HashCode.fromInt((int) value) : HashCode.fromLong(value);
        }

        @Override // i5.a
        public void update(byte b10) {
            this.f10047b.update(b10);
        }

        public b(Checksum checksum) {
            this.f10047b = (Checksum) u.E(checksum);
        }

        @Override // i5.a
        public void update(byte[] bArr, int i10, int i11) {
            this.f10047b.update(bArr, i10, i11);
        }
    }

    public ChecksumHashFunction(p<? extends Checksum> pVar, int i10, String str) {
        this.checksumSupplier = (p) u.E(pVar);
        u.k(i10 == 32 || i10 == 64, "bits (%s) must be either 32 or 64", i10);
        this.bits = i10;
        this.toString = (String) u.E(str);
    }

    @Override // i5.k
    public int bits() {
        return this.bits;
    }

    @Override // i5.k
    public m newHasher() {
        return new b(this.checksumSupplier.get());
    }

    public String toString() {
        return this.toString;
    }
}
