package com.tencent.bugly.beta.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: a */
    private static Toast f24704a;

    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Toast toast = f24704a;
        if (toast == null) {
            f24704a = Toast.makeText(context, str, 0);
        } else {
            toast.setText(str);
        }
        f24704a.show();
    }
}
