package com.vivo.ic;

import android.content.Context;

/* loaded from: classes4.dex */
public class Res {
    public static int getIdByName(Context context, String str, String str2) {
        try {
            return context.getResources().getIdentifier(str2, str, context.getPackageName());
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }
}
