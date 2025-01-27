package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class ArcMotion extends PathMotion {

    /* renamed from: a */
    private static final float f3677a = 0.0f;

    /* renamed from: b */
    private static final float f3678b = 70.0f;

    /* renamed from: c */
    private static final float f3679c = (float) Math.tan(Math.toRadians(35.0d));

    /* renamed from: d */
    private float f3680d;

    /* renamed from: e */
    private float f3681e;

    /* renamed from: f */
    private float f3682f;

    /* renamed from: g */
    private float f3683g;

    /* renamed from: h */
    private float f3684h;

    /* renamed from: i */
    private float f3685i;

    public ArcMotion() {
        this.f3680d = 0.0f;
        this.f3681e = 0.0f;
        this.f3682f = f3678b;
        this.f3683g = 0.0f;
        this.f3684h = 0.0f;
        this.f3685i = f3679c;
    }

    private static float a(float f2) {
        if (f2 < 0.0f || f2 > 90.0f) {
            throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
        }
        return (float) Math.tan(Math.toRadians(f2 / 2.0f));
    }

    public float getMaximumAngle() {
        return this.f3682f;
    }

    public float getMinimumHorizontalAngle() {
        return this.f3680d;
    }

    public float getMinimumVerticalAngle() {
        return this.f3681e;
    }

    @Override // androidx.transition.PathMotion
    public Path getPath(float f2, float f3, float f4, float f5) {
        float f6;
        float f7;
        float f8;
        Path path = new Path();
        path.moveTo(f2, f3);
        float f9 = f4 - f2;
        float f10 = f5 - f3;
        float f11 = (f9 * f9) + (f10 * f10);
        float f12 = (f2 + f4) / 2.0f;
        float f13 = (f3 + f5) / 2.0f;
        float f14 = 0.25f * f11;
        boolean z = f3 > f5;
        if (Math.abs(f9) < Math.abs(f10)) {
            float abs = Math.abs(f11 / (f10 * 2.0f));
            if (z) {
                f7 = abs + f5;
                f6 = f4;
            } else {
                f7 = abs + f3;
                f6 = f2;
            }
            f8 = this.f3684h;
        } else {
            float f15 = f11 / (f9 * 2.0f);
            if (z) {
                f7 = f3;
                f6 = f15 + f2;
            } else {
                f6 = f4 - f15;
                f7 = f5;
            }
            f8 = this.f3683g;
        }
        float f16 = f14 * f8 * f8;
        float f17 = f12 - f6;
        float f18 = f13 - f7;
        float f19 = (f17 * f17) + (f18 * f18);
        float f20 = this.f3685i;
        float f21 = f14 * f20 * f20;
        if (f19 >= f16) {
            f16 = f19 > f21 ? f21 : 0.0f;
        }
        if (f16 != 0.0f) {
            float sqrt = (float) Math.sqrt(f16 / f19);
            f6 = ((f6 - f12) * sqrt) + f12;
            f7 = f13 + (sqrt * (f7 - f13));
        }
        path.cubicTo((f2 + f6) / 2.0f, (f3 + f7) / 2.0f, (f6 + f4) / 2.0f, (f7 + f5) / 2.0f, f4, f5);
        return path;
    }

    public void setMaximumAngle(float f2) {
        this.f3682f = f2;
        this.f3685i = a(f2);
    }

    public void setMinimumHorizontalAngle(float f2) {
        this.f3680d = f2;
        this.f3683g = a(f2);
    }

    public void setMinimumVerticalAngle(float f2) {
        this.f3681e = f2;
        this.f3684h = a(f2);
    }

    @SuppressLint({"RestrictedApi"})
    public ArcMotion(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3680d = 0.0f;
        this.f3681e = 0.0f;
        this.f3682f = f3678b;
        this.f3683g = 0.0f;
        this.f3684h = 0.0f;
        this.f3685i = f3679c;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f3813j);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        setMinimumVerticalAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "minimumVerticalAngle", 1, 0.0f));
        setMinimumHorizontalAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "minimumHorizontalAngle", 0, 0.0f));
        setMaximumAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "maximumAngle", 2, f3678b));
        obtainStyledAttributes.recycle();
    }
}
