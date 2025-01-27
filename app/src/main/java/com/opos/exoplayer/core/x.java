package com.opos.exoplayer.core;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.opos.exoplayer.core.metadata.Metadata;
import com.opos.exoplayer.core.q;
import com.opos.exoplayer.core.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

@TargetApi(16)
/* loaded from: classes4.dex */
public class x implements i, q.c, q.d {

    /* renamed from: a */
    protected final s[] f19286a;

    /* renamed from: b */
    private final i f19287b;

    /* renamed from: c */
    private final a f19288c;

    /* renamed from: d */
    private final CopyOnWriteArraySet<com.opos.exoplayer.core.video.e> f19289d;

    /* renamed from: e */
    private final CopyOnWriteArraySet<com.opos.exoplayer.core.f.j> f19290e;

    /* renamed from: f */
    private final CopyOnWriteArraySet<com.opos.exoplayer.core.metadata.e> f19291f;

    /* renamed from: g */
    private final CopyOnWriteArraySet<com.opos.exoplayer.core.video.f> f19292g;

    /* renamed from: h */
    private final CopyOnWriteArraySet<com.opos.exoplayer.core.a.e> f19293h;

    /* renamed from: i */
    private Format f19294i;

    /* renamed from: j */
    private Format f19295j;
    private Surface k;
    private boolean l;
    private int m;
    private SurfaceHolder n;
    private TextureView o;
    private com.opos.exoplayer.core.b.d p;
    private com.opos.exoplayer.core.b.d q;
    private int r;
    private com.opos.exoplayer.core.a.b s;
    private float t;

    private final class a implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, com.opos.exoplayer.core.a.e, com.opos.exoplayer.core.f.j, com.opos.exoplayer.core.metadata.e, com.opos.exoplayer.core.video.f {
        private a() {
        }

        /* synthetic */ a(x xVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.opos.exoplayer.core.a.e
        public void a(int i2) {
            x.this.r = i2;
            Iterator it = x.this.f19293h.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.a.e) it.next()).a(i2);
            }
        }

        @Override // com.opos.exoplayer.core.video.f
        public void a(int i2, int i3, int i4, float f2) {
            Iterator it = x.this.f19289d.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.video.e) it.next()).a(i2, i3, i4, f2);
            }
            Iterator it2 = x.this.f19292g.iterator();
            while (it2.hasNext()) {
                ((com.opos.exoplayer.core.video.f) it2.next()).a(i2, i3, i4, f2);
            }
        }

        @Override // com.opos.exoplayer.core.video.f
        public void a(int i2, long j2) {
            Iterator it = x.this.f19292g.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.video.f) it.next()).a(i2, j2);
            }
        }

        @Override // com.opos.exoplayer.core.a.e
        public void a(int i2, long j2, long j3) {
            Iterator it = x.this.f19293h.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.a.e) it.next()).a(i2, j2, j3);
            }
        }

        @Override // com.opos.exoplayer.core.video.f
        public void a(Surface surface) {
            if (x.this.k == surface) {
                Iterator it = x.this.f19289d.iterator();
                while (it.hasNext()) {
                    ((com.opos.exoplayer.core.video.e) it.next()).a();
                }
            }
            Iterator it2 = x.this.f19292g.iterator();
            while (it2.hasNext()) {
                ((com.opos.exoplayer.core.video.f) it2.next()).a(surface);
            }
        }

        @Override // com.opos.exoplayer.core.video.f
        public void a(Format format) {
            x.this.f19294i = format;
            Iterator it = x.this.f19292g.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.video.f) it.next()).a(format);
            }
        }

        @Override // com.opos.exoplayer.core.video.f
        public void a(com.opos.exoplayer.core.b.d dVar) {
            x.this.p = dVar;
            Iterator it = x.this.f19292g.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.video.f) it.next()).a(dVar);
            }
        }

        @Override // com.opos.exoplayer.core.metadata.e
        public void a(Metadata metadata) {
            Iterator it = x.this.f19291f.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.metadata.e) it.next()).a(metadata);
            }
        }

        @Override // com.opos.exoplayer.core.video.f
        public void a(String str, long j2, long j3) {
            Iterator it = x.this.f19292g.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.video.f) it.next()).a(str, j2, j3);
            }
        }

        @Override // com.opos.exoplayer.core.f.j
        public void a(List<com.opos.exoplayer.core.f.b> list) {
            Iterator it = x.this.f19290e.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.f.j) it.next()).a(list);
            }
        }

        @Override // com.opos.exoplayer.core.a.e
        public void b(Format format) {
            x.this.f19295j = format;
            Iterator it = x.this.f19293h.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.a.e) it.next()).b(format);
            }
        }

        @Override // com.opos.exoplayer.core.video.f
        public void b(com.opos.exoplayer.core.b.d dVar) {
            Iterator it = x.this.f19292g.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.video.f) it.next()).b(dVar);
            }
            x.this.f19294i = null;
            x.this.p = null;
        }

        @Override // com.opos.exoplayer.core.a.e
        public void b(String str, long j2, long j3) {
            Iterator it = x.this.f19293h.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.a.e) it.next()).b(str, j2, j3);
            }
        }

        @Override // com.opos.exoplayer.core.a.e
        public void c(com.opos.exoplayer.core.b.d dVar) {
            x.this.q = dVar;
            Iterator it = x.this.f19293h.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.a.e) it.next()).c(dVar);
            }
        }

        @Override // com.opos.exoplayer.core.a.e
        public void d(com.opos.exoplayer.core.b.d dVar) {
            Iterator it = x.this.f19293h.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.a.e) it.next()).d(dVar);
            }
            x.this.f19295j = null;
            x.this.q = null;
            x.this.r = 0;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            x.this.a(new Surface(surfaceTexture), true);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            x.this.a((Surface) null, true);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            x.this.a(surfaceHolder.getSurface(), false);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            x.this.a((Surface) null, false);
        }
    }

    protected x(v vVar, com.opos.exoplayer.core.g.h hVar, n nVar) {
        this(vVar, hVar, nVar, com.opos.exoplayer.core.i.b.f19008a);
    }

    protected x(v vVar, com.opos.exoplayer.core.g.h hVar, n nVar, com.opos.exoplayer.core.i.b bVar) {
        a aVar = new a();
        this.f19288c = aVar;
        this.f19289d = new CopyOnWriteArraySet<>();
        this.f19290e = new CopyOnWriteArraySet<>();
        this.f19291f = new CopyOnWriteArraySet<>();
        this.f19292g = new CopyOnWriteArraySet<>();
        this.f19293h = new CopyOnWriteArraySet<>();
        s[] a2 = vVar.a(new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()), aVar, aVar, aVar, aVar);
        this.f19286a = a2;
        this.t = 1.0f;
        this.r = 0;
        this.s = com.opos.exoplayer.core.a.b.f17521a;
        this.m = 1;
        this.f19287b = a(a2, hVar, nVar, bVar);
    }

    public void a(Surface surface, boolean z) {
        Surface surface2;
        ArrayList arrayList = new ArrayList();
        for (s sVar : this.f19286a) {
            if (sVar.a() == 2) {
                arrayList.add(this.f19287b.a(sVar).a(1).a(surface).i());
            }
        }
        Surface surface3 = this.k;
        if (surface3 != null && surface3 != surface) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((r) it.next()).j();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            try {
                if (this.l && (surface2 = this.k) != null) {
                    surface2.release();
                }
            } catch (Exception unused2) {
            }
        }
        this.k = surface;
        this.l = z;
    }

    private void q() {
        TextureView textureView = this.o;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.f19288c) {
                com.opos.cmn.an.f.a.c("SimpleExoPlayer", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.o.setSurfaceTextureListener(null);
            }
            this.o = null;
        }
        SurfaceHolder surfaceHolder = this.n;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.f19288c);
            this.n = null;
        }
    }

    protected i a(s[] sVarArr, com.opos.exoplayer.core.g.h hVar, n nVar, com.opos.exoplayer.core.i.b bVar) {
        return new z(sVarArr, hVar, nVar, bVar);
    }

    @Override // com.opos.exoplayer.core.q
    public q.d a() {
        return this;
    }

    @Override // com.opos.exoplayer.core.i
    public r a(r.b bVar) {
        return this.f19287b.a(bVar);
    }

    public void a(float f2) {
        this.t = f2;
        for (s sVar : this.f19286a) {
            if (sVar.a() == 1) {
                this.f19287b.a(sVar).a(2).a(Float.valueOf(f2)).i();
            }
        }
    }

    @Override // com.opos.exoplayer.core.q
    public void a(int i2) {
        this.f19287b.a(i2);
    }

    @Override // com.opos.exoplayer.core.q
    public void a(int i2, long j2) {
        this.f19287b.a(i2, j2);
    }

    @Override // com.opos.exoplayer.core.q
    public void a(long j2) {
        this.f19287b.a(j2);
    }

    public void a(SurfaceHolder surfaceHolder) {
        q();
        this.n = surfaceHolder;
        Surface surface = null;
        if (surfaceHolder != null) {
            surfaceHolder.addCallback(this.f19288c);
            Surface surface2 = surfaceHolder.getSurface();
            if (surface2 != null && surface2.isValid()) {
                surface = surface2;
            }
        }
        a(surface, false);
    }

    @Override // com.opos.exoplayer.core.q.d
    public void a(SurfaceView surfaceView) {
        a(surfaceView == null ? null : surfaceView.getHolder());
    }

    @Override // com.opos.exoplayer.core.q.d
    public void a(TextureView textureView) {
        q();
        this.o = textureView;
        Surface surface = null;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != null) {
                com.opos.cmn.an.f.a.c("SimpleExoPlayer", "Replacing existing SurfaceTextureListener.");
            }
            textureView.setSurfaceTextureListener(this.f19288c);
            SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
            if (surfaceTexture != null) {
                surface = new Surface(surfaceTexture);
            }
        }
        a(surface, true);
    }

    @Override // com.opos.exoplayer.core.i
    public void a(com.opos.exoplayer.core.e.e eVar) {
        this.f19287b.a(eVar);
    }

    @Override // com.opos.exoplayer.core.q.c
    public void a(com.opos.exoplayer.core.f.j jVar) {
        this.f19290e.add(jVar);
    }

    @Override // com.opos.exoplayer.core.q
    public void a(q.b bVar) {
        this.f19287b.a(bVar);
    }

    @Override // com.opos.exoplayer.core.q.d
    public void a(com.opos.exoplayer.core.video.e eVar) {
        this.f19289d.add(eVar);
    }

    @Override // com.opos.exoplayer.core.q
    public void a(boolean z) {
        this.f19287b.a(z);
    }

    @Override // com.opos.exoplayer.core.q
    public int b(int i2) {
        return this.f19287b.b(i2);
    }

    @Override // com.opos.exoplayer.core.q
    public q.c b() {
        return this;
    }

    public void b(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null || surfaceHolder != this.n) {
            return;
        }
        a((SurfaceHolder) null);
    }

    @Override // com.opos.exoplayer.core.q.d
    public void b(SurfaceView surfaceView) {
        b(surfaceView == null ? null : surfaceView.getHolder());
    }

    @Override // com.opos.exoplayer.core.q.d
    public void b(TextureView textureView) {
        if (textureView == null || textureView != this.o) {
            return;
        }
        a((TextureView) null);
    }

    @Override // com.opos.exoplayer.core.q.c
    public void b(com.opos.exoplayer.core.f.j jVar) {
        this.f19290e.remove(jVar);
    }

    @Override // com.opos.exoplayer.core.q
    public void b(q.b bVar) {
        this.f19287b.b(bVar);
    }

    @Override // com.opos.exoplayer.core.q.d
    public void b(com.opos.exoplayer.core.video.e eVar) {
        this.f19289d.remove(eVar);
    }

    @Override // com.opos.exoplayer.core.q
    public int c() {
        return this.f19287b.c();
    }

    @Override // com.opos.exoplayer.core.q
    public boolean d() {
        return this.f19287b.d();
    }

    @Override // com.opos.exoplayer.core.q
    public p e() {
        return this.f19287b.e();
    }

    @Override // com.opos.exoplayer.core.q
    public void f() {
        this.f19287b.f();
        q();
        Surface surface = this.k;
        if (surface != null) {
            if (this.l) {
                surface.release();
            }
            this.k = null;
        }
        CopyOnWriteArraySet<com.opos.exoplayer.core.video.e> copyOnWriteArraySet = this.f19289d;
        if (copyOnWriteArraySet != null) {
            copyOnWriteArraySet.clear();
        }
    }

    @Override // com.opos.exoplayer.core.q
    public com.opos.exoplayer.core.g.g g() {
        return this.f19287b.g();
    }

    @Override // com.opos.exoplayer.core.q
    public y h() {
        return this.f19287b.h();
    }

    @Override // com.opos.exoplayer.core.q
    public int i() {
        return this.f19287b.i();
    }

    @Override // com.opos.exoplayer.core.q
    public int j() {
        return this.f19287b.j();
    }

    @Override // com.opos.exoplayer.core.q
    public int k() {
        return this.f19287b.k();
    }

    @Override // com.opos.exoplayer.core.q
    public long l() {
        return this.f19287b.l();
    }

    @Override // com.opos.exoplayer.core.q
    public long m() {
        return this.f19287b.m();
    }

    @Override // com.opos.exoplayer.core.q
    public long n() {
        return this.f19287b.n();
    }

    @Override // com.opos.exoplayer.core.q
    public boolean o() {
        return this.f19287b.o();
    }

    @Override // com.opos.exoplayer.core.q
    public long p() {
        return this.f19287b.p();
    }
}
