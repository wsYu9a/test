package com.jd.ad.sdk.jad_er;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.jd.ad.sdk.jad_qd.jad_er;
import com.jd.ad.sdk.jad_xk.jad_fs;

/* loaded from: classes2.dex */
public class jad_an {
    public static boolean jad_an(@NonNull Context context, @NonNull String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        if (jad_er.jad_dq() != 1) {
            return false;
        }
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e10) {
            jad_fs.jad_an("", com.jd.ad.sdk.jad_wj.jad_an.INTERACTION_CLICK_OPEN_JD_ERROR.jad_an, com.jd.ad.sdk.jad_wj.jad_an.INTERACTION_CLICK_OPEN_JD_ERROR.jad_an(e10.getMessage()));
            return false;
        }
    }
}
