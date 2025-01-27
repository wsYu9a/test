package com.czhj.sdk.common.utils;

import android.view.MotionEvent;
import android.view.View;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class TouchLocation implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final int f8692a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8693b;

    public TouchLocation(int i10, int i11) {
        this.f8692a = i10;
        this.f8693b = i11;
    }

    public static TouchLocation getTouchLocation(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null) {
            return null;
        }
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new TouchLocation(rawX - iArr[0], rawY - iArr[1]);
    }

    public int getX() {
        return this.f8692a;
    }

    public int getY() {
        return this.f8693b;
    }
}
