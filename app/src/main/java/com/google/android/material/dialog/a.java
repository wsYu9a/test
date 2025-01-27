package com.google.android.material.dialog;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final Dialog f7125a;

    /* renamed from: b, reason: collision with root package name */
    private final int f7126b;

    /* renamed from: c, reason: collision with root package name */
    private final int f7127c;

    /* renamed from: d, reason: collision with root package name */
    private final int f7128d;

    public a(@NonNull Dialog dialog, @NonNull Rect rect) {
        this.f7125a = dialog;
        this.f7126b = rect.left;
        this.f7127c = rect.top;
        this.f7128d = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@NonNull View view, @NonNull MotionEvent motionEvent) {
        View findViewById = view.findViewById(R.id.content);
        int left = this.f7126b + findViewById.getLeft();
        int width = findViewById.getWidth() + left;
        if (new RectF(left, this.f7127c + findViewById.getTop(), width, findViewById.getHeight() + r3).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            obtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            obtain.setAction(0);
            int i2 = this.f7128d;
            obtain.setLocation((-i2) - 1, (-i2) - 1);
        }
        view.performClick();
        return this.f7125a.onTouchEvent(obtain);
    }
}
