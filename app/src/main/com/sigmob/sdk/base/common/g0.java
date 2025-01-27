package com.sigmob.sdk.base.common;

import android.content.Context;
import android.widget.Toast;

/* loaded from: classes4.dex */
public class g0 extends Toast {
    public g0(Context context) {
        super(context);
    }

    public static Toast makeText(Context context, CharSequence charSequence, int i10) {
        Toast makeText = Toast.makeText(context, charSequence, i10);
        makeText.setGravity(17, 0, 0);
        return makeText;
    }
}
