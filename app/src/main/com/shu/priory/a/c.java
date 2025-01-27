package com.shu.priory.a;

/* loaded from: classes3.dex */
public interface c {

    public static class a implements c {

        /* renamed from: a, reason: collision with root package name */
        private final int f16799a;

        /* renamed from: b, reason: collision with root package name */
        private final int f16800b;

        /* renamed from: c, reason: collision with root package name */
        private final int f16801c;

        /* renamed from: d, reason: collision with root package name */
        private final int f16802d;

        public a(int i10, int i11, int i12, int i13) {
            this.f16799a = i10;
            this.f16802d = i11;
            this.f16800b = i12;
            this.f16801c = i13;
        }

        @Override // com.shu.priory.a.c
        public int a() {
            return this.f16800b;
        }

        @Override // com.shu.priory.a.c
        public int b() {
            return this.f16799a;
        }

        @Override // com.shu.priory.a.c
        public int c() {
            return this.f16801c;
        }

        @Override // com.shu.priory.a.c
        public int d() {
            return this.f16802d;
        }

        @Override // com.shu.priory.a.c
        public byte e() {
            int i10 = this.f16802d;
            return (i10 != 2 && i10 == 3) ? (byte) 8 : (byte) 16;
        }
    }

    int a();

    int b();

    int c();

    int d();

    byte e();
}
