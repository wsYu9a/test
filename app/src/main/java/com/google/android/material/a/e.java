package com.google.android.material.a;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class e extends Property<Drawable, Integer> {

    /* renamed from: a, reason: collision with root package name */
    public static final Property<Drawable, Integer> f6614a = new e();

    /* renamed from: b, reason: collision with root package name */
    private final WeakHashMap<Drawable, Integer> f6615b;

    private e() {
        super(Integer.class, "drawableAlphaCompat");
        this.f6615b = new WeakHashMap<>();
    }

    @Override // android.util.Property
    @Nullable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer get(@NonNull Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Integer.valueOf(drawable.getAlpha());
        }
        if (this.f6615b.containsKey(drawable)) {
            return this.f6615b.get(drawable);
        }
        return 255;
    }

    @Override // android.util.Property
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(@NonNull Drawable drawable, @NonNull Integer num) {
        if (Build.VERSION.SDK_INT < 19) {
            this.f6615b.put(drawable, num);
        }
        drawable.setAlpha(num.intValue());
    }
}
