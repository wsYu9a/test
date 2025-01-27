package com.google.android.material.a;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a */
    private long f6623a;

    /* renamed from: b */
    private long f6624b;

    /* renamed from: c */
    @Nullable
    private TimeInterpolator f6625c;

    /* renamed from: d */
    private int f6626d;

    /* renamed from: e */
    private int f6627e;

    public i(long j2, long j3) {
        this.f6623a = 0L;
        this.f6624b = 300L;
        this.f6625c = null;
        this.f6626d = 0;
        this.f6627e = 1;
        this.f6623a = j2;
        this.f6624b = j3;
    }

    @NonNull
    static i b(@NonNull ValueAnimator valueAnimator) {
        i iVar = new i(valueAnimator.getStartDelay(), valueAnimator.getDuration(), f(valueAnimator));
        iVar.f6626d = valueAnimator.getRepeatCount();
        iVar.f6627e = valueAnimator.getRepeatMode();
        return iVar;
    }

    private static TimeInterpolator f(@NonNull ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        return ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) ? a.f6608b : interpolator instanceof AccelerateInterpolator ? a.f6609c : interpolator instanceof DecelerateInterpolator ? a.f6610d : interpolator;
    }

    public void a(@NonNull Animator animator) {
        animator.setStartDelay(c());
        animator.setDuration(d());
        animator.setInterpolator(e());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(g());
            valueAnimator.setRepeatMode(h());
        }
    }

    public long c() {
        return this.f6623a;
    }

    public long d() {
        return this.f6624b;
    }

    @Nullable
    public TimeInterpolator e() {
        TimeInterpolator timeInterpolator = this.f6625c;
        return timeInterpolator != null ? timeInterpolator : a.f6608b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (c() == iVar.c() && d() == iVar.d() && g() == iVar.g() && h() == iVar.h()) {
            return e().getClass().equals(iVar.e().getClass());
        }
        return false;
    }

    public int g() {
        return this.f6626d;
    }

    public int h() {
        return this.f6627e;
    }

    public int hashCode() {
        return (((((((((int) (c() ^ (c() >>> 32))) * 31) + ((int) (d() ^ (d() >>> 32)))) * 31) + e().getClass().hashCode()) * 31) + g()) * 31) + h();
    }

    @NonNull
    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + c() + " duration: " + d() + " interpolator: " + e().getClass() + " repeatCount: " + g() + " repeatMode: " + h() + "}\n";
    }

    public i(long j2, long j3, @NonNull TimeInterpolator timeInterpolator) {
        this.f6623a = 0L;
        this.f6624b = 300L;
        this.f6625c = null;
        this.f6626d = 0;
        this.f6627e = 1;
        this.f6623a = j2;
        this.f6624b = j3;
        this.f6625c = timeInterpolator;
    }
}
