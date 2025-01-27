package androidx.constraintlayout.motion.utils;

import android.view.View;

/* loaded from: classes.dex */
public class ViewState {
    public int bottom;
    public int left;
    public int right;
    public float rotation;
    public int top;

    public void getState(View v10) {
        this.left = v10.getLeft();
        this.top = v10.getTop();
        this.right = v10.getRight();
        this.bottom = v10.getBottom();
        this.rotation = v10.getRotation();
    }

    public int height() {
        return this.bottom - this.top;
    }

    public int width() {
        return this.right - this.left;
    }
}
