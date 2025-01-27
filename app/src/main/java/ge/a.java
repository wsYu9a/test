package ge;

import android.graphics.Paint;
import android.text.TextPaint;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a */
    public final float f26210a;

    /* renamed from: b */
    public final float f26211b;

    /* renamed from: c */
    public final TextPaint f26212c;

    public a(float f10, float f11, TextPaint textPaint) {
        this.f26210a = f10;
        this.f26211b = f11;
        this.f26212c = textPaint;
    }

    public float a() {
        return this.f26212c.getFontMetrics().descent;
    }

    public float b() {
        return ((this.f26210a - 1.0f) * e()) + this.f26211b + this.f26212c.getFontMetrics().descent;
    }

    public float c() {
        float e10 = e();
        return e10 + ((this.f26210a - 1.0f) * e10) + this.f26211b;
    }

    public float d() {
        return ((this.f26210a - 1.0f) * e()) + this.f26211b;
    }

    public float e() {
        Paint.FontMetrics fontMetrics = this.f26212c.getFontMetrics();
        return Math.abs(fontMetrics.ascent - fontMetrics.descent);
    }
}
