package cn.vlion.ad.inland.base;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.TextureView;
import android.view.ViewGroup;
import cn.vlion.ad.inland.base.network.ok.HttpRequestUtil;
import cn.vlion.ad.inland.base.p5;
import cn.vlion.ad.inland.base.t5;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class t5 {

    /* renamed from: a */
    public ViewGroup f3376a;

    /* renamed from: b */
    public TextureView f3377b;

    /* renamed from: c */
    public p5 f3378c;

    /* renamed from: d */
    public boolean f3379d;

    /* renamed from: e */
    public b f3380e;

    /* renamed from: f */
    public volatile boolean f3381f;

    /* renamed from: g */
    public volatile boolean f3382g;

    /* renamed from: h */
    public String f3383h;

    /* renamed from: i */
    public Bitmap f3384i;

    public class a implements b {
        public a() {
        }

        public final void a() {
            StringBuilder a10 = l1.a("mRedPacketViewHelper   endRain ----:");
            a10.append(t5.this.f3381f);
            LogVlion.e(a10.toString());
            if (t5.this.f3381f) {
                return;
            }
            t5.this.f3382g = false;
            t5.this.d();
        }
    }

    public interface b {
    }

    public t5(ViewGroup viewGroup, String str) {
        this.f3376a = viewGroup;
        this.f3383h = str;
    }

    public void c() {
        try {
            a aVar = new a();
            try {
                if (!this.f3379d) {
                    this.f3379d = true;
                    this.f3380e = aVar;
                    LogVlion.e("mRedPacketViewHelper   startLaunch ----:");
                    b();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        } catch (Throwable unused) {
        }
    }

    public final void b() {
        Log.i("xyz", "gift rain create textureView");
        try {
            TextureView textureView = new TextureView(this.f3376a.getContext());
            this.f3377b = textureView;
            textureView.setOpaque(false);
            this.f3376a.addView(this.f3377b);
            p5 p5Var = new p5(this.f3376a.getResources(), this.f3384i);
            this.f3378c = p5Var;
            p5Var.f3282a = new r5(this);
            this.f3377b.setSurfaceTextureListener(p5Var);
            this.f3378c.start();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void d() {
        StringBuilder a10 = l1.a("mRedPacketViewHelper   rain() ---isRain-:");
        a10.append(this.f3382g);
        LogVlion.e(a10.toString());
        try {
            if (this.f3382g) {
                return;
            }
            this.f3381f = false;
            this.f3382g = true;
            this.f3376a.post(new Runnable() { // from class: b1.d
                public /* synthetic */ d() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    t5.this.c();
                }
            });
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a() {
        try {
            LogVlion.e("mRedPacketViewHelper   endRain() ----------mDone-:" + this.f3381f);
            if (this.f3381f) {
                return;
            }
            this.f3381f = true;
            this.f3382g = false;
            p5 p5Var = this.f3378c;
            if (p5Var != null) {
                try {
                    synchronized (p5Var.f3283b) {
                        p5Var.f3285d = true;
                        p5Var.f3283b.notify();
                    }
                    p5.a aVar = p5Var.f3282a;
                    if (aVar != null) {
                        ((r5) aVar).c();
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    public final void a(boolean z10) {
        try {
            LogVlion.e("mRedPacketViewHelper isShow: " + z10);
            if (z10) {
                try {
                    HttpRequestUtil.downloadBitmapNeedCache(null, this.f3383h, new s5(this));
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            } else {
                a();
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }
}
