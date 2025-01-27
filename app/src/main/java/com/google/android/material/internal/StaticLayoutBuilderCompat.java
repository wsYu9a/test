package com.google.android.material.internal;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.lang.reflect.Constructor;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
final class StaticLayoutBuilderCompat {

    /* renamed from: a */
    private static final String f7304a = "android.text.TextDirectionHeuristic";

    /* renamed from: b */
    private static final String f7305b = "android.text.TextDirectionHeuristics";

    /* renamed from: c */
    private static final String f7306c = "LTR";

    /* renamed from: d */
    private static final String f7307d = "RTL";

    /* renamed from: e */
    private static boolean f7308e;

    /* renamed from: f */
    @Nullable
    private static Constructor<StaticLayout> f7309f;

    /* renamed from: g */
    @Nullable
    private static Object f7310g;

    /* renamed from: h */
    private CharSequence f7311h;

    /* renamed from: i */
    private final TextPaint f7312i;

    /* renamed from: j */
    private final int f7313j;
    private int l;
    private boolean p;
    private int k = 0;
    private Layout.Alignment m = Layout.Alignment.ALIGN_NORMAL;
    private int n = Integer.MAX_VALUE;
    private boolean o = true;

    @Nullable
    private TextUtils.TruncateAt q = null;

    static class StaticLayoutBuilderCompatException extends Exception {
        StaticLayoutBuilderCompatException(Throwable th) {
            super("Error thrown initializing StaticLayout " + th.getMessage(), th);
        }
    }

    private StaticLayoutBuilderCompat(CharSequence charSequence, TextPaint textPaint, int i2) {
        this.f7311h = charSequence;
        this.f7312i = textPaint;
        this.f7313j = i2;
        this.l = charSequence.length();
    }

    private void b() throws StaticLayoutBuilderCompatException {
        Class<?> cls;
        if (f7308e) {
            return;
        }
        try {
            boolean z = this.p && Build.VERSION.SDK_INT >= 23;
            if (Build.VERSION.SDK_INT >= 18) {
                cls = TextDirectionHeuristic.class;
                f7310g = z ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
            } else {
                ClassLoader classLoader = StaticLayoutBuilderCompat.class.getClassLoader();
                String str = this.p ? f7307d : f7306c;
                Class<?> loadClass = classLoader.loadClass(f7304a);
                Class<?> loadClass2 = classLoader.loadClass(f7305b);
                f7310g = loadClass2.getField(str).get(loadClass2);
                cls = loadClass;
            }
            Class cls2 = Integer.TYPE;
            Class cls3 = Float.TYPE;
            Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(CharSequence.class, cls2, cls2, TextPaint.class, cls2, Layout.Alignment.class, cls, cls3, cls3, Boolean.TYPE, TextUtils.TruncateAt.class, cls2, cls2);
            f7309f = declaredConstructor;
            declaredConstructor.setAccessible(true);
            f7308e = true;
        } catch (Exception e2) {
            throw new StaticLayoutBuilderCompatException(e2);
        }
    }

    @NonNull
    public static StaticLayoutBuilderCompat c(@NonNull CharSequence charSequence, @NonNull TextPaint textPaint, @IntRange(from = 0) int i2) {
        return new StaticLayoutBuilderCompat(charSequence, textPaint, i2);
    }

    public StaticLayout a() throws StaticLayoutBuilderCompatException {
        if (this.f7311h == null) {
            this.f7311h = "";
        }
        int max = Math.max(0, this.f7313j);
        CharSequence charSequence = this.f7311h;
        if (this.n == 1) {
            charSequence = TextUtils.ellipsize(charSequence, this.f7312i, max, this.q);
        }
        int min = Math.min(charSequence.length(), this.l);
        this.l = min;
        if (Build.VERSION.SDK_INT < 23) {
            b();
            try {
                return (StaticLayout) ((Constructor) Preconditions.checkNotNull(f7309f)).newInstance(charSequence, Integer.valueOf(this.k), Integer.valueOf(this.l), this.f7312i, Integer.valueOf(max), this.m, Preconditions.checkNotNull(f7310g), Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.o), null, Integer.valueOf(max), Integer.valueOf(this.n));
            } catch (Exception e2) {
                throw new StaticLayoutBuilderCompatException(e2);
            }
        }
        if (this.p) {
            this.m = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, this.k, min, this.f7312i, max);
        obtain.setAlignment(this.m);
        obtain.setIncludePad(this.o);
        obtain.setTextDirection(this.p ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.q;
        if (truncateAt != null) {
            obtain.setEllipsize(truncateAt);
        }
        obtain.setMaxLines(this.n);
        return obtain.build();
    }

    @NonNull
    public StaticLayoutBuilderCompat d(@NonNull Layout.Alignment alignment) {
        this.m = alignment;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat e(@Nullable TextUtils.TruncateAt truncateAt) {
        this.q = truncateAt;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat f(@IntRange(from = 0) int i2) {
        this.l = i2;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat g(boolean z) {
        this.o = z;
        return this;
    }

    public StaticLayoutBuilderCompat h(boolean z) {
        this.p = z;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat i(@IntRange(from = 0) int i2) {
        this.n = i2;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat j(@IntRange(from = 0) int i2) {
        this.k = i2;
        return this;
    }
}
