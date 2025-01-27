package com.bytedance.pangle.util;

import android.text.TextUtils;
import java.io.File;

/* loaded from: classes.dex */
public final class c {
    public static String[] a(File file) {
        String[] a2 = com.bytedance.pangle.util.a.b.a(file);
        return TextUtils.isEmpty(a2[0]) ? com.bytedance.pangle.util.a.a.a(file) : a2;
    }
}
