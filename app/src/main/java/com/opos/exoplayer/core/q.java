package com.opos.exoplayer.core;

import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.Nullable;

/* loaded from: classes4.dex */
public interface q {

    public static abstract class a implements b {
        @Override // com.opos.exoplayer.core.q.b
        public void a(int i2) {
        }

        @Override // com.opos.exoplayer.core.q.b
        public void a(com.opos.exoplayer.core.e.m mVar, com.opos.exoplayer.core.g.g gVar) {
        }

        @Override // com.opos.exoplayer.core.q.b
        public void a(h hVar) {
        }

        @Override // com.opos.exoplayer.core.q.b
        public void a(p pVar) {
        }

        @Deprecated
        public void a(y yVar, Object obj) {
        }

        @Override // com.opos.exoplayer.core.q.b
        public void a(y yVar, Object obj, int i2) {
            a(yVar, obj);
        }

        @Override // com.opos.exoplayer.core.q.b
        public void a(boolean z) {
        }

        @Override // com.opos.exoplayer.core.q.b
        public void a(boolean z, int i2) {
        }

        @Override // com.opos.exoplayer.core.q.b
        public void b(int i2) {
        }

        @Override // com.opos.exoplayer.core.q.b
        public void e_() {
        }
    }

    public interface b {
        void a(int i2);

        void a(com.opos.exoplayer.core.e.m mVar, com.opos.exoplayer.core.g.g gVar);

        void a(h hVar);

        void a(p pVar);

        void a(y yVar, Object obj, int i2);

        void a(boolean z);

        void a(boolean z, int i2);

        void b(int i2);

        void e_();
    }

    public interface c {
        void a(com.opos.exoplayer.core.f.j jVar);

        void b(com.opos.exoplayer.core.f.j jVar);
    }

    public interface d {
        void a(SurfaceView surfaceView);

        void a(TextureView textureView);

        void a(com.opos.exoplayer.core.video.e eVar);

        void b(SurfaceView surfaceView);

        void b(TextureView textureView);

        void b(com.opos.exoplayer.core.video.e eVar);
    }

    @Nullable
    d a();

    void a(int i2);

    void a(int i2, long j2);

    void a(long j2);

    void a(b bVar);

    void a(boolean z);

    int b(int i2);

    @Nullable
    c b();

    void b(b bVar);

    int c();

    boolean d();

    p e();

    void f();

    com.opos.exoplayer.core.g.g g();

    y h();

    int i();

    int j();

    int k();

    long l();

    long m();

    long n();

    boolean o();

    long p();
}
