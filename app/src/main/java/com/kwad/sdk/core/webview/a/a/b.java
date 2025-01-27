package com.kwad.sdk.core.webview.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.q;
import java.io.File;

/* loaded from: classes2.dex */
public final class b {
    public static synchronized boolean a(Context context, com.kwad.sdk.f.kwai.b bVar) {
        synchronized (b.class) {
            String str = bVar.ato;
            File file = new File(str);
            if (!q.G(file)) {
                return false;
            }
            if (!TextUtils.isEmpty(bVar.atq)) {
                String fileMD5 = com.kwad.sdk.utils.a.getFileMD5(file);
                if (fileMD5 != null && fileMD5.length() > 10) {
                    fileMD5 = fileMD5.substring(0, 10);
                }
                if (!bb.isEquals(fileMD5, bVar.atq)) {
                    q.V(file);
                    return false;
                }
            }
            com.kwad.sdk.core.webview.a.b.b.a(bVar, 2);
            try {
                com.kwad.sdk.core.webview.a.b.a.e(context, str, com.kwad.sdk.core.webview.a.b.a.x(context, bVar.atn));
                q.V(file);
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                com.kwad.sdk.core.webview.a.b.b.a(bVar, 0, 2, e2.getMessage());
                return false;
            }
        }
    }
}
