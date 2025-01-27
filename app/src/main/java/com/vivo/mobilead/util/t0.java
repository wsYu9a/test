package com.vivo.mobilead.util;

import android.text.TextUtils;
import android.widget.Toast;

/* loaded from: classes4.dex */
public class t0 {
    public static void a(String str) {
        if (com.vivo.mobilead.manager.f.j().c() == null || TextUtils.isEmpty(str)) {
            return;
        }
        Toast.makeText(com.vivo.mobilead.manager.f.j().c(), str, 0).show();
    }
}
