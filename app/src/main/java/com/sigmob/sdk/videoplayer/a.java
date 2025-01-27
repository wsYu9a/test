package com.sigmob.sdk.videoplayer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.czhj.sdk.logger.SigmobLog;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes4.dex */
public class a extends RelativeLayout implements i {

    /* renamed from: v */
    public static final int f20695v = 6000;

    /* renamed from: a */
    public j f20696a;

    /* renamed from: b */
    public Class f20697b;

    /* renamed from: c */
    public m f20698c;

    /* renamed from: d */
    public h f20699d;

    /* renamed from: e */
    public e f20700e;

    /* renamed from: f */
    public ViewGroup f20701f;

    /* renamed from: g */
    public int f20702g;

    /* renamed from: h */
    public Timer f20703h;

    /* renamed from: i */
    public b f20704i;

    /* renamed from: j */
    public boolean f20705j;

    /* renamed from: k */
    public boolean f20706k;

    /* renamed from: l */
    public Handler f20707l;

    /* renamed from: m */
    public boolean f20708m;

    /* renamed from: n */
    public boolean f20709n;

    /* renamed from: o */
    public int f20710o;

    /* renamed from: p */
    public int f20711p;

    /* renamed from: q */
    public float f20712q;

    /* renamed from: r */
    public l f20713r;

    /* renamed from: s */
    public int f20714s;

    /* renamed from: t */
    public String f20715t;

    /* renamed from: u */
    public boolean f20716u;

    /* renamed from: com.sigmob.sdk.videoplayer.a$a */
    public class HandlerC0624a extends Handler {
        public HandlerC0624a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 6000 && !a.this.f20705j) {
                a.this.f20705j = true;
                a.this.setState(e.STATE_BUFFERING_START);
            }
        }
    }

    public class b extends TimerTask {

        /* renamed from: com.sigmob.sdk.videoplayer.a$b$a */
        public class RunnableC0625a implements Runnable {
            public RunnableC0625a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                long currentPositionWhenPlaying = a.this.getCurrentPositionWhenPlaying();
                long duration = a.this.getDuration();
                if (a.this.f20713r != null) {
                    a.this.f20713r.a(currentPositionWhenPlaying, duration);
                }
            }
        }

        public b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            a aVar = a.this;
            e eVar = aVar.f20700e;
            if (eVar == e.STATE_PLAYING || eVar == e.STATE_PAUSE) {
                aVar.post(new RunnableC0625a());
            }
        }
    }

    public a(Context context) {
        super(context);
        this.f20700e = e.STATE_IDLE;
        this.f20707l = new HandlerC0624a(Looper.getMainLooper());
        FrameLayout frameLayout = new FrameLayout(context);
        this.f20701f = frameLayout;
        frameLayout.setBackgroundColor(-16777216);
        addView(this.f20701f, new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public void b() {
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public void c() {
        SigmobLog.d("onPrepared  [" + hashCode() + "] ");
        setState(e.STATE_PREPARED);
        setMute(this.f20708m);
        if (this.f20709n) {
            return;
        }
        SigmobLog.d("mediaInterface start");
        m();
        this.f20696a.j();
        this.f20709n = false;
    }

    public void d() {
        SigmobLog.d("addTextureView [" + hashCode() + "] ");
        m mVar = this.f20698c;
        if (mVar != null) {
            this.f20701f.removeView(mVar);
        }
        m mVar2 = new m(getContext().getApplicationContext());
        this.f20698c = mVar2;
        mVar2.setSurfaceTextureListener(this.f20696a);
        this.f20701f.addView(this.f20698c, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    public void e() {
        Timer timer = this.f20703h;
        if (timer != null) {
            timer.cancel();
        }
        b bVar = this.f20704i;
        if (bVar != null) {
            bVar.cancel();
        }
    }

    public void f() {
        this.f20713r = null;
        o();
    }

    public void g() {
        e eVar = this.f20700e;
        if (eVar == e.STATE_NORMAL || eVar == e.STATE_PREPARING || eVar == e.STATE_ERROR) {
            o();
        } else {
            if (eVar == e.STATE_PAUSE || this.f20696a == null) {
                return;
            }
            l();
            this.f20696a.f();
        }
    }

    public long getCurrentPositionWhenPlaying() {
        e eVar = this.f20700e;
        if (eVar != e.STATE_PLAYING && eVar != e.STATE_PAUSE) {
            return 0L;
        }
        try {
            return this.f20696a.a();
        } catch (IllegalStateException e10) {
            e10.printStackTrace();
            return 0L;
        }
    }

    public long getDuration() {
        try {
            j jVar = this.f20696a;
            if (jVar != null) {
                return jVar.b();
            }
            return 0L;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0L;
        }
    }

    public int getErrorCode() {
        return this.f20714s;
    }

    public String getErrorMessage() {
        return this.f20715t;
    }

    public int getVideoHeight() {
        return this.f20710o;
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public h getVideoPlayerDataSource() {
        return this.f20699d;
    }

    public int getVideoWidth() {
        return this.f20711p;
    }

    public void h() {
        j jVar;
        this.f20709n = false;
        e eVar = this.f20700e;
        if (eVar == e.STATE_NORMAL || (jVar = this.f20696a) == null) {
            r();
            return;
        }
        if (eVar == e.STATE_PAUSE || eVar == e.STATE_BUFFERING_END || eVar == e.STATE_AUTO_COMPLETE || eVar == e.STATE_PREPARED) {
            jVar.j();
            m();
        }
    }

    public final void i() {
        try {
            j jVar = this.f20696a;
            if (jVar != null) {
                jVar.i();
            }
            Class cls = this.f20697b;
            this.f20696a = cls == null ? new k(this) : (j) cls.getConstructor(a.class).newInstance(this);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public boolean j() {
        return this.f20716u;
    }

    public void k() {
        SigmobLog.d("onStateNormal stat" + this.f20700e + " [" + hashCode() + "] ");
        setState(e.STATE_NORMAL);
        j jVar = this.f20696a;
        if (jVar != null) {
            jVar.i();
        }
    }

    public void l() {
        SigmobLog.i("onStatePause  [" + hashCode() + "] ");
        setState(e.STATE_PAUSE);
        q();
    }

    public void m() {
        SigmobLog.d("onStatePlaying  [" + hashCode() + "] ");
        if (this.f20700e == e.STATE_PREPARED) {
            int i10 = this.f20702g;
            if (i10 != 0) {
                this.f20696a.a(i10);
                this.f20702g = 0;
            }
            if (!this.f20706k) {
                this.f20707l.sendEmptyMessageDelayed(6000, qe.a.f30009d);
            }
        }
        setState(e.STATE_PLAYING);
        q();
    }

    public void n() {
        SigmobLog.d("onStatePreparing  [" + hashCode() + "] ");
        setState(e.STATE_PREPARING);
    }

    public void o() {
        SigmobLog.d("reset  [" + hashCode() + "] ");
        e();
        k();
        this.f20701f.removeAllViews();
        Window b10 = d.b(getContext());
        if (b10 != null) {
            b10.clearFlags(128);
        }
        j jVar = this.f20696a;
        if (jVar != null) {
            jVar.i();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        SigmobLog.d("onAttachedToWindow");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void p() {
        this.f20709n = true;
        r();
    }

    public void q() {
        SigmobLog.d("startProgressTimer:  [" + hashCode() + "] ");
        e();
        this.f20703h = new Timer();
        b bVar = new b();
        this.f20704i = bVar;
        this.f20703h.schedule(bVar, 0L, 300L);
    }

    public void r() {
        SigmobLog.d("startVideo [" + hashCode() + "] ");
        try {
            i();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        Window b10 = d.b(getContext());
        if (b10 != null) {
            b10.setFlags(16777216, 16777216);
            b10.addFlags(128);
        }
        d();
        n();
    }

    public void s() {
        setState(e.STATE_STOP);
        o();
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public void setBufferProgress(int i10) {
    }

    public void setLooping(boolean z10) {
        try {
            j jVar = this.f20696a;
            if (jVar != null) {
                jVar.a(z10);
                this.f20716u = z10;
            }
        } catch (IllegalStateException e10) {
            e10.printStackTrace();
        }
    }

    public void setMute(boolean z10) {
        j jVar;
        float f10;
        this.f20708m = z10;
        if (z10) {
            jVar = this.f20696a;
            if (jVar == null) {
                return;
            } else {
                f10 = 0.0f;
            }
        } else {
            jVar = this.f20696a;
            if (jVar == null) {
                return;
            } else {
                f10 = 1.0f;
            }
        }
        jVar.b(f10);
    }

    public void setState(e eVar) {
        this.f20700e = eVar;
        l lVar = this.f20713r;
        if (lVar != null) {
            lVar.a(eVar);
        }
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        m mVar = this.f20698c;
        if (mVar != null) {
            mVar.setSurfaceTexture(surfaceTexture);
        }
    }

    public void setTextureViewContainer(ViewGroup viewGroup) {
        this.f20701f = viewGroup;
    }

    public void setUp(String str) {
        a(new h(str, (String) null), 0);
    }

    public void setVideoPlayerStatusListener(l lVar) {
        this.f20713r = lVar;
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public void c(int i10, int i11) {
        this.f20710o = i11;
        this.f20711p = i10;
        SigmobLog.d("onVideoSizeChanged  [" + hashCode() + "] ");
        m mVar = this.f20698c;
        if (mVar != null) {
            float f10 = this.f20712q;
            if (f10 != 0.0f) {
                mVar.setRotation(f10);
            }
            this.f20698c.a(i10, i11);
        }
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public void a() {
        setState(e.STATE_AUTO_COMPLETE);
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public void b(int i10, int i11) {
        e eVar;
        SigmobLog.d("onInfo() called with: what = [" + i10 + "], extra = [" + i11 + "]");
        if (i10 == 3) {
            if (!this.f20706k) {
                this.f20706k = true;
                this.f20707l.removeMessages(6000);
            }
            if (!this.f20705j) {
                return;
            } else {
                this.f20705j = false;
            }
        } else if (i10 == 701) {
            eVar = e.STATE_BUFFERING_START;
            setState(eVar);
        } else if (i10 != 702) {
            return;
        }
        eVar = e.STATE_BUFFERING_END;
        setState(eVar);
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public void a(int i10, int i11) {
        this.f20714s = i10;
        this.f20715t = "" + i11;
        setState(e.STATE_ERROR);
    }

    public void a(int i10) {
        e eVar = this.f20700e;
        if (eVar != e.STATE_PAUSE && eVar != e.STATE_PREPARED && eVar != e.STATE_AUTO_COMPLETE && eVar != e.STATE_PLAYING) {
            this.f20702g = i10;
            return;
        }
        j jVar = this.f20696a;
        if (jVar != null) {
            jVar.a(i10);
        }
    }

    public void a(h hVar, int i10) {
        this.f20699d = hVar;
        k();
    }
}
