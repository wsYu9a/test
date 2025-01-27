package com.shu.priory.a;

/* loaded from: classes3.dex */
public interface b {

    public static final class a implements b {

        /* renamed from: a, reason: collision with root package name */
        private final byte[] f16797a;

        /* renamed from: b, reason: collision with root package name */
        private int f16798b;

        public a(byte[] bArr) {
            this.f16797a = bArr;
        }

        @Override // com.shu.priory.a.b
        public void a(int i10) {
            this.f16798b = i10;
        }

        @Override // com.shu.priory.a.b
        public int b() {
            return this.f16798b;
        }

        @Override // com.shu.priory.a.b
        public byte[] a() {
            return this.f16797a;
        }
    }

    void a(int i10);

    byte[] a();

    int b();
}
