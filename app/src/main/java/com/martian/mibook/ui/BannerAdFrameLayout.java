package com.martian.mibook.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.martian.libmars.common.ConfigSingleton;

/* loaded from: classes3.dex */
public class BannerAdFrameLayout extends FrameLayout {

    /* renamed from: b */
    public boolean f15805b;

    /* renamed from: c */
    public final float f15806c;

    public BannerAdFrameLayout(@NonNull Context context) {
        super(context);
        this.f15806c = ConfigSingleton.i(64.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (getHeight() - motionEvent.getY() < this.f15806c) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.f15805b) {
            return false;
        }
        if (motionEvent.getAction() == 1) {
            this.f15805b = true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setTouched(boolean z10) {
        this.f15805b = z10;
    }

    public BannerAdFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15806c = ConfigSingleton.i(64.0f);
    }

    public BannerAdFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f15806c = ConfigSingleton.i(64.0f);
    }
}
