package org.codechimp.apprater;

import android.content.Context;
import android.net.Uri;

/* loaded from: classes5.dex */
public class e implements f {

    /* renamed from: a */
    private static String f35383a = "market://details?id=";

    @Override // org.codechimp.apprater.f
    public Uri a(Context context) {
        return Uri.parse(f35383a + context.getPackageName().toString());
    }
}
