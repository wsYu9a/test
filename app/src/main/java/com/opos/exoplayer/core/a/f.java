package com.opos.exoplayer.core.a;

import androidx.annotation.Nullable;
import com.opos.exoplayer.core.p;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public interface f {

    public static final class a extends Exception {
        public a(String str) {
            super(str);
        }

        public a(Throwable th) {
            super(th);
        }
    }

    public static final class b extends Exception {

        /* renamed from: a */
        public final int f17551a;

        public b(int i2, int i3, int i4, int i5) {
            super("AudioTrack init failed: " + i2 + ", Config(" + i3 + ", " + i4 + ", " + i5 + ")");
            this.f17551a = i2;
        }
    }

    public interface c {
        void a();

        void a(int i2);

        void a(int i2, long j2, long j3);
    }

    public static final class d extends Exception {

        /* renamed from: a */
        public final int f17552a;

        public d(int i2) {
            super("AudioTrack write failed: " + i2);
            this.f17552a = i2;
        }
    }

    long a(boolean z);

    p a(p pVar);

    void a();

    void a(float f2);

    void a(int i2, int i3, int i4, int i5, @Nullable int[] iArr, int i6, int i7);

    void a(com.opos.exoplayer.core.a.b bVar);

    void a(c cVar);

    boolean a(int i2);

    boolean a(ByteBuffer byteBuffer, long j2);

    void b();

    void b(int i2);

    void c();

    boolean d();

    boolean e();

    p f();

    void g();

    void h();

    void i();

    void j();
}
