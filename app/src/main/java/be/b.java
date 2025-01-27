package be;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.martian.libmars.common.ConfigSingleton;

/* loaded from: classes3.dex */
public class b extends ReplacementSpan {

    /* renamed from: a */
    public final int f1570a;

    /* renamed from: b */
    public final int f1571b;

    public b(int i10, int i11) {
        this.f1570a = i10;
        this.f1571b = i11;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i10, int i11, float f10, int i12, int i13, int i14, Paint paint) {
        int color = paint.getColor();
        paint.setColor(this.f1570a);
        canvas.drawRoundRect(new RectF(f10 + ConfigSingleton.i(2.0f), i12, f10 + ((int) paint.measureText(charSequence, i10, i11)) + ConfigSingleton.i(6.0f), i14), ConfigSingleton.i(2.0f), ConfigSingleton.i(2.0f), paint);
        paint.setColor(this.f1571b);
        canvas.drawText(charSequence, i10, i11, f10 + ConfigSingleton.i(4.0f), i13, paint);
        paint.setColor(color);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i10, int i11, Paint.FontMetricsInt fontMetricsInt) {
        return ((int) paint.measureText(charSequence, i10, i11)) + ConfigSingleton.i(7.0f);
    }
}
