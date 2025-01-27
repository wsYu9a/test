package com.kwad.sdk.utils.a;

/* loaded from: classes3.dex */
final class a {

    /* renamed from: com.kwad.sdk.utils.a.a$a, reason: collision with other inner class name */
    public static class C0515a extends j {
        public C0515a(int i10, int i11, Object obj, int i12, boolean z10) {
            super(i10, i11, obj, i12, z10);
        }

        @Override // com.kwad.sdk.utils.a.a.b
        public final byte Pr() {
            return (byte) 7;
        }
    }

    public static abstract class b {
        int offset;

        public abstract byte Pr();
    }

    public static class c extends b {
        boolean value;

        public c(int i10, boolean z10) {
            this.offset = i10;
            this.value = z10;
        }

        @Override // com.kwad.sdk.utils.a.a.b
        public final byte Pr() {
            return (byte) 1;
        }
    }

    public static class d extends b {
        double value;

        public d(int i10, double d10) {
            this.offset = i10;
            this.value = d10;
        }

        @Override // com.kwad.sdk.utils.a.a.b
        public final byte Pr() {
            return (byte) 5;
        }
    }

    public static class e extends b {
        float value;

        public e(int i10, float f10) {
            this.offset = i10;
            this.value = f10;
        }

        @Override // com.kwad.sdk.utils.a.a.b
        public final byte Pr() {
            return (byte) 3;
        }
    }

    public static class f extends b {
        int value;

        public f(int i10, int i11) {
            this.offset = i10;
            this.value = i11;
        }

        @Override // com.kwad.sdk.utils.a.a.b
        public final byte Pr() {
            return (byte) 2;
        }
    }

    public static class g extends b {
        long value;

        public g(int i10, long j10) {
            this.offset = i10;
            this.value = j10;
        }

        @Override // com.kwad.sdk.utils.a.a.b
        public final byte Pr() {
            return (byte) 4;
        }
    }

    public static class h extends j {
        public h(int i10, int i11, Object obj, int i12, boolean z10) {
            super(i10, i11, obj, i12, z10);
        }

        @Override // com.kwad.sdk.utils.a.a.b
        public final byte Pr() {
            return (byte) 8;
        }
    }

    public static class i extends j {
        public i(int i10, int i11, String str, int i12, boolean z10) {
            super(i10, i11, str, i12, z10);
        }

        @Override // com.kwad.sdk.utils.a.a.b
        public final byte Pr() {
            return (byte) 6;
        }
    }

    public static abstract class j extends b {
        int aVV;
        boolean aVW;
        int start;
        Object value;

        public j(int i10, int i11, Object obj, int i12, boolean z10) {
            this.start = i10;
            this.offset = i11;
            this.value = obj;
            this.aVV = i12;
            this.aVW = z10;
        }
    }
}
