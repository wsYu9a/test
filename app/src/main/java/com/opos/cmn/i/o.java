package com.opos.cmn.i;

import android.content.Context;
import android.view.View;

/* loaded from: classes4.dex */
public class o {
    public static boolean a(Context context, View view) {
        if (view != null) {
            return a(view);
        }
        if (context == null) {
            return false;
        }
        return com.opos.cmn.an.h.a.a.d(context);
    }

    public static boolean a(View view) {
        return view != null && view.getWindowVisibility() == 0;
    }
}
