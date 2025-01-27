package com.opos.exoplayer.core.e;

import androidx.annotation.Nullable;
import com.opos.exoplayer.core.y;

/* loaded from: classes4.dex */
public interface e {

    public interface a {
        void a(e eVar, y yVar, @Nullable Object obj);
    }

    public static final class b {

        /* renamed from: a */
        public final int f18423a;

        /* renamed from: b */
        public final int f18424b;

        /* renamed from: c */
        public final int f18425c;

        /* renamed from: d */
        public final long f18426d;

        public b(int i2) {
            this(i2, -1L);
        }

        public b(int i2, int i3, int i4, long j2) {
            this.f18423a = i2;
            this.f18424b = i3;
            this.f18425c = i4;
            this.f18426d = j2;
        }

        public b(int i2, long j2) {
            this(i2, -1, -1, j2);
        }

        public b a(int i2) {
            return this.f18423a == i2 ? this : new b(i2, this.f18424b, this.f18425c, this.f18426d);
        }

        public boolean a() {
            return this.f18424b != -1;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj == null || b.class != obj.getClass()) {
                    return false;
                }
                b bVar = (b) obj;
                if (this.f18423a != bVar.f18423a || this.f18424b != bVar.f18424b || this.f18425c != bVar.f18425c || this.f18426d != bVar.f18426d) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            return ((((((this.f18423a + 527) * 31) + this.f18424b) * 31) + this.f18425c) * 31) + ((int) this.f18426d);
        }
    }

    d a(b bVar, com.opos.exoplayer.core.h.b bVar2);

    void a();

    void a(d dVar);

    void a(com.opos.exoplayer.core.i iVar, boolean z, a aVar);

    void b();
}
