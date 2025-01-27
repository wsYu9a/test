package androidx.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* loaded from: classes.dex */
class PathProperty<T> extends Property<T, Float> {

    /* renamed from: a, reason: collision with root package name */
    private final Property<T, PointF> f3786a;

    /* renamed from: b, reason: collision with root package name */
    private final PathMeasure f3787b;

    /* renamed from: c, reason: collision with root package name */
    private final float f3788c;

    /* renamed from: d, reason: collision with root package name */
    private final float[] f3789d;

    /* renamed from: e, reason: collision with root package name */
    private final PointF f3790e;

    /* renamed from: f, reason: collision with root package name */
    private float f3791f;

    PathProperty(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.f3789d = new float[2];
        this.f3790e = new PointF();
        this.f3786a = property;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        this.f3787b = pathMeasure;
        this.f3788c = pathMeasure.getLength();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.Property
    public /* bridge */ /* synthetic */ Float get(Object obj) {
        return get((PathProperty<T>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(Object obj, Float f2) {
        set2((PathProperty<T>) obj, f2);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.util.Property
    public Float get(T t) {
        return Float.valueOf(this.f3791f);
    }

    /* renamed from: set, reason: avoid collision after fix types in other method */
    public void set2(T t, Float f2) {
        this.f3791f = f2.floatValue();
        this.f3787b.getPosTan(this.f3788c * f2.floatValue(), this.f3789d, null);
        PointF pointF = this.f3790e;
        float[] fArr = this.f3789d;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.f3786a.set(t, pointF);
    }
}
