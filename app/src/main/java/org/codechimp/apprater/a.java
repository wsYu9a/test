package org.codechimp.apprater;

import android.content.Context;
import android.net.Uri;

/* loaded from: classes5.dex */
public class a implements f {

    /* renamed from: a */
    private static String f35358a = "http://www.amazon.com/gp/mas/dl/android?p=";

    @Override // org.codechimp.apprater.f
    public Uri a(Context context) {
        return Uri.parse(f35358a + context.getPackageName().toString());
    }
}
