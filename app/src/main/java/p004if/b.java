package p004if;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.SdkConfigData;

/* loaded from: classes3.dex */
public class b extends a implements Animatable, ValueAnimator.AnimatorUpdateListener {

    /* renamed from: f */
    public ValueAnimator f26992f;

    /* renamed from: c */
    public int f26989c = 0;

    /* renamed from: d */
    public int f26990d = 0;

    /* renamed from: e */
    public int f26991e = 0;

    /* renamed from: g */
    public Path f26993g = new Path();

    public b() {
        ValueAnimator ofInt = ValueAnimator.ofInt(30, SdkConfigData.DEFAULT_REQUEST_INTERVAL);
        this.f26992f = ofInt;
        ofInt.setDuration(10000L);
        this.f26992f.setInterpolator(null);
        this.f26992f.setRepeatCount(-1);
        this.f26992f.setRepeatMode(1);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        float f10 = width;
        float max = Math.max(1.0f, f10 / 22.0f);
        if (this.f26989c != width || this.f26990d != height) {
            this.f26993g.reset();
            Path path = this.f26993g;
            float f11 = f10 - max;
            float f12 = height / 2.0f;
            Path.Direction direction = Path.Direction.CW;
            path.addCircle(f11, f12, max, direction);
            float f13 = f10 - (5.0f * max);
            this.f26993g.addRect(f13, f12 - max, f11, f12 + max, direction);
            this.f26993g.addCircle(f13, f12, max, direction);
            this.f26989c = width;
            this.f26990d = height;
        }
        canvas.save();
        float f14 = f10 / 2.0f;
        float f15 = height / 2.0f;
        canvas.rotate(this.f26991e, f14, f15);
        for (int i10 = 0; i10 < 12; i10++) {
            this.f26988b.setAlpha((i10 + 5) * 17);
            canvas.rotate(30.0f, f14, f15);
            canvas.drawPath(this.f26993g, this.f26988b);
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f26992f.isRunning();
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f26991e = (((Integer) valueAnimator.getAnimatedValue()).intValue() / 30) * 30;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.f26992f.isRunning()) {
            return;
        }
        this.f26992f.addUpdateListener(this);
        this.f26992f.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.f26992f.isRunning()) {
            this.f26992f.removeAllListeners();
            this.f26992f.removeAllUpdateListeners();
            this.f26992f.cancel();
        }
    }
}
