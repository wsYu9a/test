package com.opos.exoplayer.core.c;

/* loaded from: classes4.dex */
public interface l {

    public static final class a {

        /* renamed from: a */
        public final m f18324a;

        /* renamed from: b */
        public final m f18325b;

        public a(m mVar) {
            this(mVar, mVar);
        }

        public a(m mVar, m mVar2) {
            this.f18324a = (m) com.opos.exoplayer.core.i.a.a(mVar);
            this.f18325b = (m) com.opos.exoplayer.core.i.a.a(mVar2);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj == null || a.class != obj.getClass()) {
                    return false;
                }
                a aVar = (a) obj;
                if (!this.f18324a.equals(aVar.f18324a) || !this.f18325b.equals(aVar.f18325b)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            return (this.f18324a.hashCode() * 31) + this.f18325b.hashCode();
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(this.f18324a);
            if (this.f18324a.equals(this.f18325b)) {
                str = "";
            } else {
                str = ", " + this.f18325b;
            }
            sb.append(str);
            sb.append("]");
            return sb.toString();
        }
    }

    public static final class b implements l {

        /* renamed from: a */
        private final long f18326a;

        /* renamed from: b */
        private final a f18327b;

        public b(long j2) {
            this(j2, 0L);
        }

        public b(long j2, long j3) {
            this.f18326a = j2;
            this.f18327b = new a(j3 == 0 ? m.f18328a : new m(0L, j3));
        }

        @Override // com.opos.exoplayer.core.c.l
        public boolean a() {
            return false;
        }

        @Override // com.opos.exoplayer.core.c.l
        public long b() {
            return this.f18326a;
        }

        @Override // com.opos.exoplayer.core.c.l
        public a b(long j2) {
            return this.f18327b;
        }
    }

    boolean a();

    long b();

    a b(long j2);
}
