package com.martian.libmars.utils.x0;

import android.R;
import android.annotation.TargetApi;
import android.view.View;
import android.view.Window;

/* loaded from: classes2.dex */
class i implements c {
    i() {
    }

    @Override // com.martian.libmars.utils.x0.c
    @TargetApi(23)
    public void a(Window window, int color) {
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(color);
        View findViewById = window.findViewById(R.id.content);
        if (findViewById != null) {
            findViewById.setForeground(null);
        }
    }
}
