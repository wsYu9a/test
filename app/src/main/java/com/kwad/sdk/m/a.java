package com.kwad.sdk.m;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.m.c;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.w;
import java.util.List;

/* loaded from: classes3.dex */
public final class a {
    public static final String TAG = "Ranger_" + b.class.getSimpleName();

    /* renamed from: com.kwad.sdk.m.a$1 */
    public class AnonymousClass1 extends com.kwad.sdk.core.c.d {
        final /* synthetic */ List aRz;

        public AnonymousClass1(List list) {
            list = list;
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityCreated */
        public final void a(Activity activity, Bundle bundle) {
            super.a(activity, bundle);
            try {
                a.a(activity, list);
            } catch (Throwable th2) {
                com.kwad.sdk.core.d.c.e(a.TAG, Log.getStackTraceString(th2));
            }
        }
    }

    public static void a(@NonNull c cVar) {
        List<c.a> list = cVar.aRE;
        if (list == null || list.isEmpty()) {
            return;
        }
        com.kwad.sdk.core.c.b.Fi();
        com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.sdk.m.a.1
            final /* synthetic */ List aRz;

            public AnonymousClass1(List list2) {
                list = list2;
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            /* renamed from: onActivityCreated */
            public final void a(Activity activity, Bundle bundle) {
                super.a(activity, bundle);
                try {
                    a.a(activity, list);
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.e(a.TAG, Log.getStackTraceString(th2));
                }
            }
        });
    }

    private static String e(Object obj, String str) {
        Object field;
        return (TextUtils.isEmpty(str) || (field = w.getField(obj, str)) == null) ? "" : field.getClass().getName();
    }

    public static void a(Activity activity, @NonNull List<c.a> list) {
        try {
            for (c.a aVar : list) {
                if (aVar != null) {
                    String str = "";
                    if (TextUtils.equals(activity.getClass().getName(), aVar.aRG)) {
                        str = aVar.aRG;
                    } else if (!TextUtils.isEmpty(aVar.aRH) && activity.getClass().getName().startsWith(aVar.aRG)) {
                        str = e(activity, aVar.aRH);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        int b10 = ad.b("ksadsdk_perf_ranger_v2", str, 0) + 1;
                        ad.a("ksadsdk_perf_ranger_v2", str, b10);
                        com.kwad.sdk.core.d.c.d(TAG, "act:" + str + " num:" + b10);
                    }
                }
            }
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.e(TAG, "record:" + Log.getStackTraceString(th2));
        }
    }
}
