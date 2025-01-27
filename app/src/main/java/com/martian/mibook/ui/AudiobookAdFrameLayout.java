package com.martian.mibook.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
public class AudiobookAdFrameLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    public boolean f15802b;

    /* renamed from: c, reason: collision with root package name */
    public int f15803c;

    public AudiobookAdFrameLayout(@NonNull Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getY() <= this.f15803c) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.f15802b) {
            return false;
        }
        if (motionEvent.getAction() == 1) {
            this.f15802b = true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setAdHeight(int i10) {
        this.f15803c = i10;
    }

    public void setTouched(boolean z10) {
        this.f15802b = z10;
    }

    public AudiobookAdFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AudiobookAdFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
