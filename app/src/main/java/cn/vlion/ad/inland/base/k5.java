package cn.vlion.ad.inland.base;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class k5 extends Drawable {

    /* renamed from: a */
    public final Movie f3043a;

    /* renamed from: b */
    public long f3044b;

    /* renamed from: c */
    public int f3045c;

    /* renamed from: d */
    public int f3046d;

    /* renamed from: e */
    public int f3047e;

    public k5(Movie movie, int i10, int i11) {
        this.f3043a = movie;
        this.f3045c = i10;
        this.f3046d = i11;
        if (i10 < 1) {
            this.f3045c = 200;
            this.f3046d = 200;
        }
        StringBuilder a10 = l1.a("VlionMovieDrawable -- mViewWidth =");
        a10.append(this.f3045c);
        LogVlion.e(a10.toString());
        LogVlion.e("VlionMovieDrawable -- mViewHeight =" + this.f3046d);
    }

    public final void a() {
        this.f3044b = SystemClock.uptimeMillis();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis() - this.f3044b;
            Movie movie = this.f3043a;
            if (movie != null) {
                this.f3047e = movie.width();
                float f10 = this.f3045c / this.f3047e;
                float height = this.f3046d / this.f3043a.height();
                if (f10 > height) {
                    f10 = height;
                }
                canvas.scale(f10, f10);
                int duration = this.f3043a.duration();
                if (duration == 0) {
                    duration = 1000;
                }
                this.f3043a.setTime((int) (uptimeMillis % duration));
                this.f3043a.draw(canvas, getBounds().left, getBounds().top);
                invalidateSelf();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i10) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
