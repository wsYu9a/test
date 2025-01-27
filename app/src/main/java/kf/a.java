package kf;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import androidx.annotation.NonNull;

/* loaded from: classes3.dex */
public class a extends p004if.a {

    /* renamed from: c */
    public int f27811c = 0;

    /* renamed from: d */
    public int f27812d = 0;

    /* renamed from: e */
    public final Path f27813e = new Path();

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        if (this.f27811c != width || this.f27812d != height) {
            this.f27813e.reset();
            float f10 = (width * 30) / 225;
            float f11 = f10 * 0.70710677f;
            float f12 = f10 / 0.70710677f;
            float f13 = width;
            float f14 = f13 / 2.0f;
            float f15 = height;
            this.f27813e.moveTo(f14, f15);
            float f16 = f15 / 2.0f;
            this.f27813e.lineTo(0.0f, f16);
            float f17 = f16 - f11;
            this.f27813e.lineTo(f11, f17);
            float f18 = f10 / 2.0f;
            float f19 = f14 - f18;
            float f20 = (f15 - f12) - f18;
            this.f27813e.lineTo(f19, f20);
            this.f27813e.lineTo(f19, 0.0f);
            float f21 = f14 + f18;
            this.f27813e.lineTo(f21, 0.0f);
            this.f27813e.lineTo(f21, f20);
            this.f27813e.lineTo(f13 - f11, f17);
            this.f27813e.lineTo(f13, f16);
            this.f27813e.close();
            this.f27811c = width;
            this.f27812d = height;
        }
        canvas.drawPath(this.f27813e, this.f26988b);
    }
}
