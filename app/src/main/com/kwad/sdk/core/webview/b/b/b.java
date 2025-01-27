package com.kwad.sdk.core.webview.b.b;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.utils.bm;
import com.kwad.sdk.utils.u;
import java.io.File;

/* loaded from: classes3.dex */
public final class b {
    public static synchronized boolean a(Context context, com.kwad.sdk.g.a.b bVar) {
        synchronized (b.class) {
            try {
                String str = bVar.aMA;
                File file = new File(str);
                if (!u.M(file)) {
                    return false;
                }
                if (!TextUtils.isEmpty(bVar.amT)) {
                    String fileMD5 = com.kwad.sdk.utils.a.getFileMD5(file);
                    if (fileMD5 != null && fileMD5.length() > 10) {
                        fileMD5 = fileMD5.substring(0, 10);
                    }
                    if (!bm.isEquals(fileMD5, bVar.amT)) {
                        u.ab(file);
                        return false;
                    }
                }
                com.kwad.sdk.core.webview.b.c.b.a(bVar, 2);
                try {
                    com.kwad.sdk.core.webview.b.c.a.f(context, str, com.kwad.sdk.core.webview.b.c.a.G(context, bVar.aMz));
                    u.ab(file);
                    return true;
                } catch (Exception e10) {
                    e10.printStackTrace();
                    com.kwad.sdk.core.webview.b.c.b.a(bVar, 0, 2, e10.getMessage());
                    return false;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
