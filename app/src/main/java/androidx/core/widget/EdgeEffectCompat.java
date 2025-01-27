package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.widget.EdgeEffect;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class EdgeEffectCompat {

    /* renamed from: a, reason: collision with root package name */
    private EdgeEffect f2198a;

    @Deprecated
    public EdgeEffectCompat(Context context) {
        this.f2198a = new EdgeEffect(context);
    }

    @Deprecated
    public boolean draw(Canvas canvas) {
        return this.f2198a.draw(canvas);
    }

    @Deprecated
    public void finish() {
        this.f2198a.finish();
    }

    @Deprecated
    public boolean isFinished() {
        return this.f2198a.isFinished();
    }

    @Deprecated
    public boolean onAbsorb(int i2) {
        this.f2198a.onAbsorb(i2);
        return true;
    }

    @Deprecated
    public boolean onPull(float f2) {
        this.f2198a.onPull(f2);
        return true;
    }

    @Deprecated
    public boolean onRelease() {
        this.f2198a.onRelease();
        return this.f2198a.isFinished();
    }

    @Deprecated
    public void setSize(int i2, int i3) {
        this.f2198a.setSize(i2, i3);
    }

    @Deprecated
    public boolean onPull(float f2, float f3) {
        onPull(this.f2198a, f2, f3);
        return true;
    }

    public static void onPull(@NonNull EdgeEffect edgeEffect, float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            edgeEffect.onPull(f2, f3);
        } else {
            edgeEffect.onPull(f2);
        }
    }
}
