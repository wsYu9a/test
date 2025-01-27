package com.kwad.sdk.core.download.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import java.util.List;

/* loaded from: classes3.dex */
public final class b {

    public interface a {
        void onError(Throwable th2);

        void onPreStart();

        void onStart();

        void onSuccess();

        void pd();
    }

    /* renamed from: com.kwad.sdk.core.download.a.b$b */
    public static class C0491b implements a {
        @Override // com.kwad.sdk.core.download.a.b.a
        public void onError(Throwable th2) {
        }

        @Override // com.kwad.sdk.core.download.a.b.a
        public final void onPreStart() {
        }

        @Override // com.kwad.sdk.core.download.a.b.a
        public void onStart() {
        }

        @Override // com.kwad.sdk.core.download.a.b.a
        public void onSuccess() {
        }

        @Override // com.kwad.sdk.core.download.a.b.a
        public final void pd() {
        }
    }

    public static int E(Context context, String str) {
        return a(context, str, new C0491b());
    }

    public static int a(Context context, String str, @NonNull a aVar) {
        if (TextUtils.isEmpty(str) || context == null) {
            return 0;
        }
        try {
            aVar.onPreStart();
            com.kwad.sdk.core.d.c.d("DeepLinkUtil", "handleDeepLink: " + str);
            Uri parse = Uri.parse(str);
            h hVar = (h) ServiceProvider.get(h.class);
            int cc2 = hVar != null ? hVar.cc(parse.getScheme()) : -1;
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(parse);
            com.kwad.sdk.core.d.c.d("DeepLinkUtil", "handleDeepLink: configFlags: " + cc2);
            if (cc2 > 0) {
                intent.setFlags(cc2);
            } else {
                intent.setFlags(268435456);
            }
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
                aVar.pd();
                return 0;
            }
            aVar.onStart();
            context.startActivity(intent);
            aVar.onSuccess();
            return 1;
        } catch (Throwable th2) {
            aVar.onError(th2);
            return -1;
        }
    }
}
