package com.opos.mobad.n.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;

/* loaded from: classes4.dex */
public class g extends View {

    /* renamed from: a */
    private Paint f21775a;

    /* renamed from: b */
    private Paint f21776b;

    public g(Context context) {
        this(context, null);
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.f21775a = paint;
        paint.setAntiAlias(true);
        this.f21775a.setStyle(Paint.Style.STROKE);
        this.f21775a.setColor(486539264);
        Paint paint2 = new Paint();
        this.f21776b = paint2;
        paint2.setAntiAlias(true);
        this.f21776b.setStyle(Paint.Style.STROKE);
        this.f21776b.setColor(486539264);
    }

    private void a(Canvas canvas, int i2, int i3) {
        float b2 = i2 / com.opos.cmn.an.h.f.a.b(getContext());
        int i4 = (i2 * 1157) / DownloadErrorCode.ERROR_TTNET_NOT_MODIFIED;
        canvas.save();
        float f2 = i4;
        float f3 = (i3 * 86) / 1920;
        canvas.drawCircle(f2, f3, 239.0f * b2, this.f21775a);
        canvas.drawCircle(f2, f3, 277.0f * b2, this.f21775a);
        canvas.drawCircle(f2, f3, 316.0f * b2, this.f21775a);
        canvas.drawCircle(f2, f3, 353.0f * b2, this.f21775a);
        canvas.drawCircle(f2, f3, 391.0f * b2, this.f21775a);
        canvas.drawCircle(f2, f3, 429.0f * b2, this.f21775a);
        canvas.drawCircle(f2, f3, 467.0f * b2, this.f21775a);
        canvas.drawCircle(f2, f3, b2 * 505.0f, this.f21775a);
        canvas.restore();
    }

    private void b(Canvas canvas, int i2, int i3) {
        float b2 = i2 / com.opos.cmn.an.h.f.a.b(getContext());
        int b3 = (com.opos.cmn.an.h.f.a.b(getContext()) * (-296)) / DownloadErrorCode.ERROR_TTNET_NOT_MODIFIED;
        canvas.save();
        float f2 = b3;
        float f3 = (i3 * 1379) / 1920;
        canvas.rotate(45.0f, f2, f3);
        float f4 = 241.0f * b2;
        canvas.drawRect(f2 - f4, f3 - f4, f4 + f2, f4 + f3, this.f21776b);
        float f5 = 279.0f * b2;
        canvas.drawRect(f2 - f5, f3 - f5, f5 + f2, f5 + f3, this.f21776b);
        float f6 = 317.0f * b2;
        canvas.drawRect(f2 - f6, f3 - f6, f6 + f2, f6 + f3, this.f21776b);
        float f7 = 355.0f * b2;
        canvas.drawRect(f2 - f7, f3 - f7, f7 + f2, f7 + f3, this.f21776b);
        float f8 = 393.0f * b2;
        canvas.drawRect(f2 - f8, f3 - f8, f8 + f2, f8 + f3, this.f21776b);
        float f9 = b2 * 431.0f;
        canvas.drawRect(f2 - f9, f3 - f9, f9 + f2, f9 + f3, this.f21776b);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        a(canvas, width, height);
        b(canvas, width, height);
        super.onDraw(canvas);
    }
}
