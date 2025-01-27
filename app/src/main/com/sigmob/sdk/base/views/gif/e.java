package com.sigmob.sdk.base.views.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.media3.common.C;

/* loaded from: classes4.dex */
public class e extends ImageView implements Runnable {

    /* renamed from: n */
    public static final String f18652n = "GifDecoderView";

    /* renamed from: a */
    public boolean f18653a;

    /* renamed from: b */
    public c f18654b;

    /* renamed from: c */
    public d f18655c;

    /* renamed from: d */
    public Thread f18656d;

    /* renamed from: e */
    public InterfaceC0581e f18657e;

    /* renamed from: f */
    public long f18658f;

    /* renamed from: g */
    public com.sigmob.sdk.base.views.gif.a f18659g;

    /* renamed from: h */
    public final Handler f18660h;

    /* renamed from: i */
    public boolean f18661i;

    /* renamed from: j */
    public boolean f18662j;

    /* renamed from: k */
    public Bitmap f18663k;

    /* renamed from: l */
    public final Runnable f18664l;

    /* renamed from: m */
    public final Runnable f18665m;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f18663k = null;
            e.this.f18659g = null;
            e.this.f18656d = null;
            e.this.f18662j = false;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f18663k == null || e.this.f18663k.isRecycled()) {
                return;
            }
            e eVar = e.this;
            eVar.setImageBitmap(eVar.f18663k);
        }
    }

    public interface c {
        void a();
    }

    public interface d {
        void a();
    }

    /* renamed from: com.sigmob.sdk.base.views.gif.e$e */
    public interface InterfaceC0581e {
        Bitmap a(Bitmap bitmap);
    }

    public e(Context context) {
        super(context);
        this.f18654b = null;
        this.f18655c = null;
        this.f18657e = null;
        this.f18658f = -1L;
        this.f18660h = new Handler(Looper.getMainLooper());
        this.f18664l = new a();
        this.f18665m = new b();
    }

    public void b() {
        this.f18653a = false;
        this.f18661i = false;
        this.f18662j = true;
        g();
        this.f18660h.post(this.f18664l);
    }

    public boolean c() {
        return this.f18653a;
    }

    public void d() {
        this.f18659g.t();
        a(0);
    }

    public void e() {
        this.f18653a = true;
        f();
    }

    public final void f() {
        if (a()) {
            Thread thread = new Thread(this);
            this.f18656d = thread;
            thread.start();
        }
    }

    public void g() {
        this.f18653a = false;
        Thread thread = this.f18656d;
        if (thread != null) {
            thread.interrupt();
            this.f18656d = null;
        }
    }

    public int getFrameCount() {
        return this.f18659g.f();
    }

    public long getFramesDisplayDuration() {
        return this.f18658f;
    }

    public int getGifHeight() {
        return this.f18659g.h();
    }

    public int getGifWidth() {
        return this.f18659g.o();
    }

    public d getOnAnimationStop() {
        return this.f18655c;
    }

    public InterfaceC0581e getOnFrameAvailable() {
        return this.f18657e;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // java.lang.Runnable
    public void run() {
        long j10;
        c cVar = this.f18654b;
        if (cVar != null) {
            cVar.a();
        }
        do {
            if (!this.f18653a && !this.f18661i) {
                break;
            }
            boolean a10 = this.f18659g.a();
            try {
                long nanoTime = System.nanoTime();
                Bitmap m10 = this.f18659g.m();
                this.f18663k = m10;
                InterfaceC0581e interfaceC0581e = this.f18657e;
                if (interfaceC0581e != null) {
                    this.f18663k = interfaceC0581e.a(m10);
                }
                j10 = (System.nanoTime() - nanoTime) / C.MICROS_PER_SECOND;
                try {
                    this.f18660h.post(this.f18665m);
                } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException unused) {
                }
            } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException unused2) {
                j10 = 0;
            }
            this.f18661i = false;
            if (!this.f18653a || !a10) {
                this.f18653a = false;
                break;
            }
            try {
                int l10 = (int) (this.f18659g.l() - j10);
                if (l10 > 0) {
                    long j11 = this.f18658f;
                    if (j11 <= 0) {
                        j11 = l10;
                    }
                    Thread.sleep(j11);
                }
            } catch (InterruptedException unused3) {
            }
        } while (this.f18653a);
        if (this.f18662j) {
            this.f18660h.post(this.f18664l);
        }
        this.f18656d = null;
        d dVar = this.f18655c;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void setBytes(byte[] bArr) {
        com.sigmob.sdk.base.views.gif.a aVar = new com.sigmob.sdk.base.views.gif.a();
        this.f18659g = aVar;
        try {
            aVar.a(bArr);
            if (this.f18653a) {
                f();
            } else {
                a(0);
            }
        } catch (Exception unused) {
            this.f18659g = null;
        }
    }

    public void setFramesDisplayDuration(long j10) {
        this.f18658f = j10;
    }

    public void setOnAnimationStart(c cVar) {
        this.f18654b = cVar;
    }

    public void setOnAnimationStop(d dVar) {
        this.f18655c = dVar;
    }

    public void setOnFrameAvailable(InterfaceC0581e interfaceC0581e) {
        this.f18657e = interfaceC0581e;
    }

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18654b = null;
        this.f18655c = null;
        this.f18657e = null;
        this.f18658f = -1L;
        this.f18660h = new Handler(Looper.getMainLooper());
        this.f18664l = new a();
        this.f18665m = new b();
    }

    public final boolean a() {
        return (this.f18653a || this.f18661i) && this.f18659g != null && this.f18656d == null;
    }

    public void a(int i10) {
        if (this.f18659g.d() == i10 || !this.f18659g.b(i10 - 1) || this.f18653a) {
            return;
        }
        this.f18661i = true;
        f();
    }
}
