package com.martian.apptask.data;

import android.view.View;

/* loaded from: classes3.dex */
public class ViewWrapper {
    private boolean isInit = false;
    private boolean recycled = false;
    private View view;

    public ViewWrapper(View view) {
        this.view = view;
    }

    public void destroy() {
        if (this.recycled) {
            return;
        }
        onDestroy();
        this.recycled = true;
    }

    public View getView() {
        return this.view;
    }

    public void init() {
        if (this.isInit) {
            return;
        }
        onInit();
        this.isInit = true;
    }

    public boolean isRecycled() {
        return this.recycled;
    }

    public void onDestroy() {
    }

    public void onInit() {
    }

    public void setView(View view) {
        this.view = view;
    }
}
