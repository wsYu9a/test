package cn.vlion.ad.inland.base;

import android.view.MotionEvent;
import cn.vlion.ad.inland.base.util.DensityUtil;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class g7 {

    /* renamed from: a */
    public boolean f2831a;

    /* renamed from: b */
    public boolean f2832b;

    /* renamed from: c */
    public int f2833c;

    /* renamed from: d */
    public a f2834d;

    /* renamed from: e */
    public int f2835e = 0;

    /* renamed from: f */
    public int f2836f = 0;

    /* renamed from: g */
    public float f2837g = 0.0f;

    /* renamed from: h */
    public float f2838h = 0.0f;

    public interface a {
    }

    public g7(boolean z10, int i10, l lVar) {
        try {
            this.f2831a = z10;
            this.f2832b = false;
            this.f2833c = DensityUtil.dip2px(VlionSDkManager.getInstance().getApplication(), i10);
            if (i10 <= 0) {
                this.f2833c = 100;
            }
            this.f2834d = lVar;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a(MotionEvent motionEvent) {
        a aVar;
        a aVar2;
        try {
            int x10 = (int) motionEvent.getX();
            int y10 = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f2835e = x10;
                this.f2836f = y10;
                this.f2837g = motionEvent.getRawX();
                this.f2838h = motionEvent.getRawY();
                LogVlion.e("VlionViewTouch ACTION_DOWN lastX=" + this.f2835e + " lastY=" + this.f2836f);
                return;
            }
            if (action != 1) {
                return;
            }
            int i10 = x10 - this.f2835e;
            int i11 = this.f2836f - y10;
            LogVlion.e("VlionViewTouch ACTION_UP x=" + x10 + " lastX=" + this.f2835e + " y=" + y10 + " lastY=" + this.f2836f);
            int abs = Math.abs(i10);
            int abs2 = Math.abs(i11);
            double sqrt = Math.sqrt((double) ((abs2 * abs2) + (abs * abs)));
            int px2dip = DensityUtil.px2dip(VlionSDkManager.getInstance().getApplication(), (float) i10);
            int px2dip2 = DensityUtil.px2dip(VlionSDkManager.getInstance().getApplication(), (float) i11);
            LogVlion.e("VlionViewTouch isSwipeUp=" + this.f2831a + " isSwipeAll=" + this.f2832b + " offsetX=" + i10 + " offsetY=" + i11 + " distance=" + sqrt + " distanceDefault=" + this.f2833c);
            if (this.f2831a) {
                if (i11 <= Math.abs(i10) || abs2 < this.f2833c || (aVar2 = this.f2834d) == null) {
                    return;
                }
                ((l) aVar2).b(px2dip, px2dip2);
                return;
            }
            if (!this.f2832b || sqrt <= this.f2833c || (aVar = this.f2834d) == null) {
                return;
            }
            ((l) aVar).a(px2dip, px2dip2);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final String a() {
        String str = this.f2837g + "," + this.f2838h;
        y.a("ViewOnTouchDataUtils getRawXY=", str);
        return str;
    }
}
