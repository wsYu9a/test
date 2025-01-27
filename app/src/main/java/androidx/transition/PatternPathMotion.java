package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class PatternPathMotion extends PathMotion {

    /* renamed from: a */
    private Path f3792a;

    /* renamed from: b */
    private final Path f3793b;

    /* renamed from: c */
    private final Matrix f3794c;

    public PatternPathMotion() {
        Path path = new Path();
        this.f3793b = path;
        this.f3794c = new Matrix();
        path.lineTo(1.0f, 0.0f);
        this.f3792a = path;
    }

    private static float a(float f2, float f3) {
        return (float) Math.sqrt((f2 * f2) + (f3 * f3));
    }

    @Override // androidx.transition.PathMotion
    public Path getPath(float f2, float f3, float f4, float f5) {
        float f6 = f4 - f2;
        float f7 = f5 - f3;
        float a2 = a(f6, f7);
        double atan2 = Math.atan2(f7, f6);
        this.f3794c.setScale(a2, a2);
        this.f3794c.postRotate((float) Math.toDegrees(atan2));
        this.f3794c.postTranslate(f2, f3);
        Path path = new Path();
        this.f3793b.transform(this.f3794c, path);
        return path;
    }

    public Path getPatternPath() {
        return this.f3792a;
    }

    public void setPatternPath(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float[] fArr = new float[2];
        pathMeasure.getPosTan(pathMeasure.getLength(), fArr, null);
        float f2 = fArr[0];
        float f3 = fArr[1];
        pathMeasure.getPosTan(0.0f, fArr, null);
        float f4 = fArr[0];
        float f5 = fArr[1];
        if (f4 == f2 && f5 == f3) {
            throw new IllegalArgumentException("pattern must not end at the starting point");
        }
        this.f3794c.setTranslate(-f4, -f5);
        float f6 = f2 - f4;
        float f7 = f3 - f5;
        float a2 = 1.0f / a(f6, f7);
        this.f3794c.postScale(a2, a2);
        this.f3794c.postRotate((float) Math.toDegrees(-Math.atan2(f7, f6)));
        path.transform(this.f3794c, this.f3793b);
        this.f3792a = path;
    }

    @SuppressLint({"RestrictedApi"})
    public PatternPathMotion(Context context, AttributeSet attributeSet) {
        this.f3793b = new Path();
        this.f3794c = new Matrix();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.k);
        try {
            String namedString = TypedArrayUtils.getNamedString(obtainStyledAttributes, (XmlPullParser) attributeSet, "patternPathData", 0);
            if (namedString != null) {
                setPatternPath(PathParser.createPathFromPathData(namedString));
                return;
            }
            throw new RuntimeException("pathData must be supplied for patternPathMotion");
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public PatternPathMotion(Path path) {
        this.f3793b = new Path();
        this.f3794c = new Matrix();
        setPatternPath(path);
    }
}
