package com.kwad.sdk.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;

/* loaded from: classes3.dex */
public final class bv {
    private View aVL;
    public Point aVK = new Point();
    public Rect aVI = new Rect();
    public Rect aVJ = new Rect();

    public bv(View view) {
        this.aVL = view;
    }

    public final boolean Pq() {
        boolean globalVisibleRect = this.aVL.getGlobalVisibleRect(this.aVI, this.aVK);
        Point point = this.aVK;
        if (point.x == 0 && point.y == 0 && this.aVI.height() == this.aVL.getHeight() && this.aVJ.height() != 0 && Math.abs(this.aVI.top - this.aVJ.top) > this.aVL.getHeight() / 2) {
            this.aVI.set(this.aVJ);
        }
        this.aVJ.set(this.aVI);
        return globalVisibleRect;
    }
}
