package com.bytedance.pangle.util;

import android.text.TextUtils;
import java.io.File;

/* loaded from: classes2.dex */
public final class c {
    public static String[] a(File file) {
        String[] a10 = com.bytedance.pangle.util.a.b.a(file);
        return TextUtils.isEmpty(a10[0]) ? com.bytedance.pangle.util.a.a.a(file) : a10;
    }
}
