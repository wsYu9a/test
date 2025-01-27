package com.opos.mobad.r.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.view.PixelCopy;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.opos.exoplayer.core.e.c;
import com.opos.exoplayer.core.e.e;
import com.opos.exoplayer.core.g.a;
import com.opos.exoplayer.core.h;
import com.opos.exoplayer.core.h.g;
import com.opos.exoplayer.core.h.k;
import com.opos.exoplayer.core.h.m;
import com.opos.exoplayer.core.i.u;
import com.opos.exoplayer.core.j;
import com.opos.exoplayer.core.p;
import com.opos.exoplayer.core.q;
import com.opos.exoplayer.core.x;
import com.opos.exoplayer.core.y;

/* loaded from: classes4.dex */
class a implements q.b, com.opos.mobad.c.c.a {

    /* renamed from: a */
    private x f23382a;

    /* renamed from: b */
    private RelativeLayout f23383b;

    /* renamed from: c */
    private ImageView f23384c;

    /* renamed from: d */
    private com.opos.exoplayer.a.a f23385d;

    /* renamed from: e */
    private com.opos.exoplayer.a.c f23386e;

    /* renamed from: f */
    private g.a f23387f;

    /* renamed from: g */
    private e f23388g;

    /* renamed from: h */
    private Context f23389h;

    /* renamed from: i */
    private com.opos.mobad.c.c.b f23390i;

    /* renamed from: j */
    private int f23391j = 0;
    private long k = 0;
    private View.OnAttachStateChangeListener l = new View.OnAttachStateChangeListener() { // from class: com.opos.mobad.r.a.a.3
        AnonymousClass3() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            com.opos.exoplayer.a.c cVar = a.this.f23386e;
            if (cVar == null || cVar.isHardwareAccelerated()) {
                return;
            }
            com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onViewAttachedToWindow switchSurfaceType");
            cVar.a(1);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    };

    /* renamed from: com.opos.mobad.r.a.a$1 */
    class AnonymousClass1 implements com.opos.exoplayer.core.video.e {
        AnonymousClass1() {
        }

        @Override // com.opos.exoplayer.core.video.e
        public void a() {
            com.opos.mobad.c.c.b bVar = a.this.f23390i;
            if (bVar != null) {
                bVar.j();
            }
        }

        @Override // com.opos.exoplayer.core.video.e
        public void a(int i2, int i3, int i4, float f2) {
            float f3 = (i3 == 0 || i2 == 0) ? 1.0f : (i2 * f2) / i3;
            com.opos.exoplayer.a.c cVar = a.this.f23386e;
            if (cVar == null) {
                com.opos.cmn.an.f.a.c("ExoVideoPlayer", "callback but playerView null");
                return;
            }
            View b2 = cVar.b();
            if (b2 != null && (b2 instanceof TextureView) && (i4 == 90 || i4 == 270)) {
                f3 = 1.0f / f3;
            }
            a.this.f23385d.a(f3);
        }
    }

    /* renamed from: com.opos.mobad.r.a.a$2 */
    class AnonymousClass2 implements PixelCopy.OnPixelCopyFinishedListener {

        /* renamed from: a */
        final /* synthetic */ Bitmap f23393a;

        AnonymousClass2(Bitmap bitmap) {
            createBitmap = bitmap;
        }

        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
        public void onPixelCopyFinished(int i2) {
            a.this.f23384c.setImageBitmap(createBitmap);
        }
    }

    /* renamed from: com.opos.mobad.r.a.a$3 */
    class AnonymousClass3 implements View.OnAttachStateChangeListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            com.opos.exoplayer.a.c cVar = a.this.f23386e;
            if (cVar == null || cVar.isHardwareAccelerated()) {
                return;
            }
            com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onViewAttachedToWindow switchSurfaceType");
            cVar.a(1);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public a(Context context, com.opos.mobad.c.c.b bVar) {
        this.f23389h = context;
        this.f23390i = bVar;
        j();
    }

    private void c(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("initMediaSource path=");
        sb.append(str != null ? str : "null");
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", sb.toString());
        try {
            if (com.opos.cmn.an.c.a.a(str)) {
                com.opos.cmn.an.f.a.d("ExoVideoPlayer", "initMediaSource path is null!!!");
            } else {
                this.f23388g = new c.a(this.f23387f).a(Uri.parse(str));
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("ExoVideoPlayer", "", (Throwable) e2);
        }
    }

    private void j() {
        try {
            k();
            l();
            Context context = this.f23389h;
            this.f23387f = new m(context, u.a(context, context.getPackageName()));
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("ExoVideoPlayer", "", (Throwable) e2);
        }
    }

    private void k() {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "initPlayer");
        try {
            x a2 = j.a(this.f23389h, new com.opos.exoplayer.core.g.c(new a.C0415a(new k())));
            this.f23382a = a2;
            a2.a(this);
            this.f23382a.a(true);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("ExoVideoPlayer", "", (Throwable) e2);
        }
    }

    private void l() {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "initPlayerView");
        try {
            this.f23383b = new RelativeLayout(this.f23389h);
            com.opos.exoplayer.a.c cVar = new com.opos.exoplayer.a.c(this.f23389h);
            this.f23386e = cVar;
            cVar.addOnAttachStateChangeListener(this.l);
            this.f23386e.b(0);
            this.f23386e.a(false);
            this.f23386e.a(this.f23382a);
            this.f23383b.addView(this.f23386e, new RelativeLayout.LayoutParams(-1, -1));
            com.opos.exoplayer.a.a aVar = new com.opos.exoplayer.a.a(this.f23389h);
            this.f23385d = aVar;
            aVar.a(0);
            ImageView imageView = new ImageView(this.f23389h);
            this.f23384c = imageView;
            imageView.setVisibility(8);
            this.f23385d.addView(this.f23384c, new FrameLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.f23383b.addView(this.f23385d, layoutParams);
            this.f23382a.a().a(new com.opos.exoplayer.core.video.e() { // from class: com.opos.mobad.r.a.a.1
                AnonymousClass1() {
                }

                @Override // com.opos.exoplayer.core.video.e
                public void a() {
                    com.opos.mobad.c.c.b bVar = a.this.f23390i;
                    if (bVar != null) {
                        bVar.j();
                    }
                }

                @Override // com.opos.exoplayer.core.video.e
                public void a(int i2, int i3, int i4, float f2) {
                    float f3 = (i3 == 0 || i2 == 0) ? 1.0f : (i2 * f2) / i3;
                    com.opos.exoplayer.a.c cVar2 = a.this.f23386e;
                    if (cVar2 == null) {
                        com.opos.cmn.an.f.a.c("ExoVideoPlayer", "callback but playerView null");
                        return;
                    }
                    View b2 = cVar2.b();
                    if (b2 != null && (b2 instanceof TextureView) && (i4 == 90 || i4 == 270)) {
                        f3 = 1.0f / f3;
                    }
                    a.this.f23385d.a(f3);
                }
            });
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("ExoVideoPlayer", "", (Throwable) e2);
        }
    }

    private void m() {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "playVideo mCurrentState=" + this.f23391j);
        try {
            e eVar = this.f23388g;
            if (eVar != null) {
                this.f23391j = 1;
                this.f23382a.a(eVar);
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("ExoVideoPlayer", "", (Throwable) e2);
        }
    }

    private void n() {
        this.f23384c.setVisibility(8);
    }

    private void o() {
        this.f23384c.setVisibility(0);
        this.f23384c.setImageBitmap(null);
        try {
            long currentTimeMillis = System.currentTimeMillis();
            com.opos.exoplayer.a.c cVar = this.f23386e;
            if (cVar == null) {
                return;
            }
            View b2 = cVar.b();
            com.opos.cmn.an.f.a.b("ExoVideoPlayer", "show cover");
            if (b2 != null) {
                if (b2 instanceof TextureView) {
                    this.f23384c.setImageBitmap(((TextureView) b2).getBitmap());
                } else if ((b2 instanceof SurfaceView) && Build.VERSION.SDK_INT >= 25) {
                    Bitmap createBitmap = Bitmap.createBitmap(((SurfaceView) b2).getWidth(), ((SurfaceView) b2).getHeight(), Bitmap.Config.ARGB_8888);
                    PixelCopy.request((SurfaceView) b2, createBitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: com.opos.mobad.r.a.a.2

                        /* renamed from: a */
                        final /* synthetic */ Bitmap f23393a;

                        AnonymousClass2(Bitmap createBitmap2) {
                            createBitmap = createBitmap2;
                        }

                        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                        public void onPixelCopyFinished(int i2) {
                            a.this.f23384c.setImageBitmap(createBitmap);
                        }
                    }, ((SurfaceView) b2).getHandler());
                }
            }
            com.opos.cmn.an.f.a.b("ExoVideoPlayer", "show cover end:" + (System.currentTimeMillis() - currentTimeMillis));
        } catch (Exception unused) {
            com.opos.cmn.an.f.a.b("ExoVideoPlayer", "show cover fail");
        }
    }

    @Override // com.opos.mobad.c.c.a
    public void a(float f2) {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "setVolume =" + f2);
        this.f23382a.a(f2);
    }

    @Override // com.opos.exoplayer.core.q.b
    public void a(int i2) {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onRepeatModeChanged repeatMode=" + i2);
    }

    @Override // com.opos.mobad.c.c.a
    public void a(long j2) {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "seekTo position=" + j2);
        if (j2 >= 0) {
            try {
                this.f23382a.a(j2);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("ExoVideoPlayer", "", (Throwable) e2);
            }
        }
    }

    @Override // com.opos.exoplayer.core.q.b
    public void a(com.opos.exoplayer.core.e.m mVar, com.opos.exoplayer.core.g.g gVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("onTracksChanged trackGroups=");
        sb.append(mVar != null ? mVar.toString() : "null");
        sb.append(",trackSelections=");
        sb.append(gVar != null ? gVar.toString() : "null");
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", sb.toString());
    }

    @Override // com.opos.exoplayer.core.q.b
    public void a(h hVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("onPlayerError error=");
        sb.append(hVar != null ? hVar.toString() : "null");
        com.opos.cmn.an.f.a.d("ExoVideoPlayer", sb.toString(), hVar);
        try {
            this.f23391j = -1;
            if (hVar == null) {
                com.opos.mobad.c.c.b bVar = this.f23390i;
                if (bVar != null) {
                    bVar.a(-1, "unknown error.");
                    return;
                }
                return;
            }
            com.opos.mobad.c.c.b bVar2 = this.f23390i;
            if (bVar2 != null) {
                int i2 = hVar.f18897a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("cause:");
                sb2.append(hVar.getCause() != null ? hVar.getCause() : "null");
                sb2.append(",message:");
                sb2.append(hVar.getMessage() != null ? hVar.getMessage() : "null");
                bVar2.a(i2, sb2.toString());
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("ExoVideoPlayer", "", (Throwable) e2);
        }
    }

    @Override // com.opos.exoplayer.core.q.b
    public void a(p pVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("onPlaybackParametersChanged playbackParameters=");
        sb.append(pVar != null ? pVar.toString() : "null");
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", sb.toString());
    }

    @Override // com.opos.exoplayer.core.q.b
    public void a(y yVar, Object obj, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("onTimelineChanged timeline=");
        sb.append(yVar != null ? yVar.toString() : "null");
        sb.append(",manifest=");
        sb.append(obj != null ? obj.toString() : "null");
        sb.append(",reason=");
        sb.append(i2);
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", sb.toString());
    }

    @Override // com.opos.mobad.c.c.a
    public void a(com.opos.mobad.c.c.b bVar) {
        this.f23390i = bVar;
    }

    @Override // com.opos.mobad.c.c.a
    public void a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("setVideoPath path=");
        sb.append(str != null ? str : "null");
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", sb.toString());
        try {
            c(str);
            m();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("ExoVideoPlayer", "", (Throwable) e2);
        }
    }

    @Override // com.opos.mobad.c.c.a
    public void a(String str, boolean z) {
        x xVar;
        int i2;
        if (z) {
            xVar = this.f23382a;
            i2 = 2;
        } else {
            xVar = this.f23382a;
            i2 = 0;
        }
        xVar.a(i2);
        a(str);
    }

    @Override // com.opos.exoplayer.core.q.b
    public void a(boolean z) {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onLoadingChanged=" + z);
    }

    @Override // com.opos.exoplayer.core.q.b
    public void a(boolean z, int i2) {
        com.opos.mobad.c.c.b bVar;
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onPlayerStateChanged playWhenReady=" + z + ",playbackState=" + i2);
        StringBuilder sb = new StringBuilder();
        sb.append("mCurrentState=");
        sb.append(this.f23391j);
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", sb.toString());
        try {
            if (i2 == 2) {
                if (z && 2 == this.f23391j) {
                    this.k = d();
                    com.opos.mobad.c.c.b bVar2 = this.f23390i;
                    if (bVar2 != null) {
                        bVar2.h();
                    }
                    this.f23391j = 4;
                    return;
                }
                return;
            }
            if (i2 != 3) {
                if (i2 != 4) {
                    return;
                }
                this.f23391j = 5;
                o();
                com.opos.mobad.c.c.b bVar3 = this.f23390i;
                if (bVar3 != null) {
                    bVar3.e();
                    return;
                }
                return;
            }
            if (z) {
                int i3 = this.f23391j;
                if (1 == i3) {
                    com.opos.mobad.c.c.b bVar4 = this.f23390i;
                    if (bVar4 != null) {
                        bVar4.c();
                        this.f23390i.d();
                    }
                } else if (4 == i3 && (bVar = this.f23390i) != null) {
                    bVar.i();
                }
                this.f23391j = 2;
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("ExoVideoPlayer", "", (Throwable) e2);
        }
    }

    @Override // com.opos.mobad.c.c.a
    public Bitmap b(String str) {
        com.opos.exoplayer.a.c cVar = this.f23386e;
        if (cVar == null) {
            return null;
        }
        return c.a(cVar.b(), str);
    }

    @Override // com.opos.mobad.c.c.a
    public View b() {
        return this.f23383b;
    }

    @Override // com.opos.exoplayer.core.q.b
    public void b(int i2) {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onPositionDiscontinuity reason=" + i2);
    }

    @Override // com.opos.mobad.c.c.a
    public long c() {
        long j2 = 0;
        try {
            j2 = this.f23382a.l();
            com.opos.cmn.an.f.a.b("ExoVideoPlayer", "getDuration=" + j2);
            return j2;
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("ExoVideoPlayer", "", (Throwable) e2);
            return j2;
        }
    }

    @Override // com.opos.mobad.c.c.a
    public void c(int i2) {
        try {
            com.opos.cmn.an.f.a.b("ExoVideoPlayer", "setResizeMode=" + i2);
            com.opos.exoplayer.a.a aVar = this.f23385d;
            if (aVar != null) {
                aVar.a(i2);
            }
            com.opos.exoplayer.a.c cVar = this.f23386e;
            if (cVar != null) {
                cVar.b(i2);
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("ExoVideoPlayer", "", (Throwable) e2);
        }
    }

    @Override // com.opos.mobad.c.c.a
    public long d() {
        long j2 = 0;
        try {
            j2 = this.f23382a.m();
            com.opos.cmn.an.f.a.b("ExoVideoPlayer", "getCurrentPosition=" + j2);
            return j2;
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("ExoVideoPlayer", "", (Throwable) e2);
            return j2;
        }
    }

    @Override // com.opos.mobad.c.c.a
    public void d(int i2) {
        com.opos.exoplayer.a.c cVar = this.f23386e;
        if (cVar != null) {
            cVar.c(i2);
        }
    }

    @Override // com.opos.mobad.c.c.a
    public void e() {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "start mCurrentState=" + this.f23391j);
    }

    @Override // com.opos.exoplayer.core.q.b
    public void e_() {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onSeekProcessed");
    }

    @Override // com.opos.mobad.c.c.a
    public void f() {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "pauseVideo mCurrentState=" + this.f23391j);
        try {
            int i2 = this.f23391j;
            if (1 == i2 || 2 == i2 || 4 == i2) {
                o();
                this.f23382a.a(false);
                this.k = d();
                if (2 == this.f23391j) {
                    this.f23391j = 3;
                }
                com.opos.mobad.c.c.b bVar = this.f23390i;
                if (bVar != null) {
                    bVar.g();
                }
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("ExoVideoPlayer", "", (Throwable) e2);
        }
    }

    @Override // com.opos.mobad.c.c.a
    public void g() {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "resume mCurrentState=" + this.f23391j);
        try {
            com.opos.cmn.an.f.a.b("ExoVideoPlayer", "mCurrentState=" + this.f23391j);
            int i2 = this.f23391j;
            if (1 == i2 || 3 == i2 || 4 == i2) {
                n();
                a(this.k);
                this.f23382a.a(true);
                com.opos.cmn.an.f.a.b("ExoVideoPlayer", "good");
                if (3 == this.f23391j) {
                    this.f23391j = 2;
                }
                com.opos.mobad.c.c.b bVar = this.f23390i;
                if (bVar != null) {
                    bVar.f();
                }
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("ExoVideoPlayer", "", (Throwable) e2);
        }
    }

    @Override // com.opos.mobad.c.c.a
    public void h() {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "releaseExoVideoPlayer mCurrentState=" + this.f23391j);
        try {
            x xVar = this.f23382a;
            if (xVar != null) {
                xVar.f();
            }
            com.opos.exoplayer.a.c cVar = this.f23386e;
            if (cVar != null) {
                cVar.removeOnAttachStateChangeListener(this.l);
                this.f23386e = null;
            }
            this.f23383b = null;
            if (this.f23388g != null) {
                this.f23388g = null;
            }
            if (this.f23387f != null) {
                this.f23387f = null;
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("ExoVideoPlayer", "", (Throwable) e2);
        }
    }

    @Override // com.opos.mobad.c.c.a
    public int i() {
        return this.f23391j;
    }
}
