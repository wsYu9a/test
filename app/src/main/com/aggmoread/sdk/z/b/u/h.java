package com.aggmoread.sdk.z.b.u;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;

/* loaded from: classes.dex */
public class h extends View {

    /* renamed from: a, reason: collision with root package name */
    private Paint f5055a;

    /* renamed from: b, reason: collision with root package name */
    private int f5056b;

    /* renamed from: c, reason: collision with root package name */
    private int f5057c;

    /* renamed from: d, reason: collision with root package name */
    private int f5058d;

    public h(Context context) {
        this(context, null);
    }

    private void a() {
        Paint paint = new Paint();
        this.f5055a = paint;
        paint.setDither(true);
        this.f5055a.setAntiAlias(true);
        this.f5055a.setStrokeWidth(10.0f);
        this.f5055a.setColor(SupportMenu.CATEGORY_MASK);
    }

    public void b(int i10) {
        this.f5058d = i10;
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawRect(0.0f, 0.0f, (this.f5056b * this.f5058d) / 100, this.f5057c, this.f5055a);
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        this.f5056b = i10;
        this.f5057c = i11;
        super.onSizeChanged(i10, i11, i12, i13);
    }

    public h(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void a(int i10) {
        this.f5055a.setColor(i10);
    }

    public h(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a();
    }
}
