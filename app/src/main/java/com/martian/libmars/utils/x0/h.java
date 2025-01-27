package com.martian.libmars.utils.x0;

import android.annotation.TargetApi;
import android.view.Window;

/* loaded from: classes2.dex */
class h implements c {
    h() {
    }

    @Override // com.martian.libmars.utils.x0.c
    @TargetApi(21)
    public void a(Window window, int color) {
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(color);
    }
}
