package cn.vlion.ad.inland.base;

import android.util.Log;
import android.view.TextureView;
import android.view.ViewGroup;
import cn.vlion.ad.inland.base.p5;
import cn.vlion.ad.inland.base.r5;
import cn.vlion.ad.inland.base.t5;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class r5 implements p5.a {

    /* renamed from: a */
    public final /* synthetic */ t5 f3357a;

    public r5(t5 t5Var) {
        this.f3357a = t5Var;
    }

    public final void c() {
        try {
            ViewGroup viewGroup = this.f3357a.f3376a;
            if (viewGroup == null) {
                return;
            }
            viewGroup.post(new Runnable() { // from class: b1.c
                public /* synthetic */ c() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    r5.this.a();
                }
            });
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void d() {
        ViewGroup viewGroup;
        try {
            t5 t5Var = this.f3357a;
            if (t5Var.f3377b != null && (viewGroup = t5Var.f3376a) != null) {
                viewGroup.post(new Runnable() { // from class: b1.b
                    public /* synthetic */ b() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        r5.this.b();
                    }
                });
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public /* synthetic */ void a() {
        try {
            t5.b bVar = this.f3357a.f3380e;
            if (bVar != null) {
                ((t5.a) bVar).a();
            }
            TextureView textureView = this.f3357a.f3377b;
            if (textureView != null) {
                textureView.setVisibility(8);
                this.f3357a.f3377b.setSurfaceTextureListener(null);
                t5 t5Var = this.f3357a;
                t5Var.f3376a.removeView(t5Var.f3377b);
                t5 t5Var2 = this.f3357a;
                t5Var2.f3377b = null;
                t5Var2.f3378c = null;
                t5Var2.f3379d = false;
                Log.i("xyz", "gift rain remove textureView");
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void b() {
        try {
            t5 t5Var = this.f3357a;
            TextureView textureView = t5Var.f3377b;
            if (textureView == null || t5Var.f3380e == null) {
                return;
            }
            textureView.setVisibility(0);
            ((t5.a) this.f3357a.f3380e).getClass();
            LogVlion.e("mRedPacketViewHelper   startRain ----:");
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
