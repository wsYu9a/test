package com.jd.ad.sdk.jad_dq;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import m5.h;

/* loaded from: classes2.dex */
public final class jad_bo {

    public static class jad_an {
        public int jad_an;
        public int jad_bo;

        public final String toString() {
            return this.jad_bo + h.f28447r + this.jad_an;
        }
    }

    public static jad_an jad_an(Context context) {
        int i10;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Display defaultDisplay = windowManager != null ? windowManager.getDefaultDisplay() : null;
        int i11 = -1;
        if (defaultDisplay != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            int i12 = displayMetrics.widthPixels;
            int i13 = displayMetrics.heightPixels;
            if (i12 == -1 || i13 == -1) {
                DisplayMetrics displayMetrics2 = new DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics2);
                i10 = displayMetrics2.widthPixels;
                i11 = displayMetrics2.heightPixels;
            } else {
                i11 = i13;
                i10 = i12;
            }
        } else {
            i10 = -1;
        }
        jad_an jad_anVar = new jad_an();
        jad_anVar.jad_bo = i11;
        jad_anVar.jad_an = i10;
        return jad_anVar;
    }
}
