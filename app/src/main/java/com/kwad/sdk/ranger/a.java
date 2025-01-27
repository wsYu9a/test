package com.kwad.sdk.ranger;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.ranger.d;
import com.kwad.sdk.utils.s;
import com.kwad.sdk.utils.y;
import java.util.List;

/* loaded from: classes2.dex */
public final class a {
    public static final String TAG = "Ranger_" + b.class.getSimpleName();

    /* renamed from: com.kwad.sdk.ranger.a$1 */
    static class AnonymousClass1 extends com.kwad.sdk.core.b.d {
        final /* synthetic */ List axM;

        AnonymousClass1(List list) {
            list = list;
        }

        @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            super.onActivityCreated(activity, bundle);
            try {
                a.a(activity, list);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.e(a.TAG, Log.getStackTraceString(th));
            }
        }
    }

    static void a(Activity activity, @NonNull List<d.a> list) {
        try {
            for (d.a aVar : list) {
                if (aVar != null) {
                    String str = "";
                    if (TextUtils.equals(activity.getClass().getName(), aVar.axY)) {
                        str = aVar.axY;
                    } else if (!TextUtils.isEmpty(aVar.axZ) && activity.getClass().getName().startsWith(aVar.axY)) {
                        str = c(activity, aVar.axZ);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        int c2 = y.c("ksadsdk_perf_ranger", str, 0) + 1;
                        y.b("ksadsdk_perf_ranger", str, c2);
                        com.kwad.sdk.core.d.b.d(TAG, "act:" + str + " num:" + c2);
                    }
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.e(TAG, "record:" + Log.getStackTraceString(th));
        }
    }

    static void a(@NonNull d dVar) {
        List<d.a> list = dVar.axU;
        if (list == null || list.isEmpty()) {
            return;
        }
        com.kwad.sdk.core.b.b.vS();
        com.kwad.sdk.core.b.b.a(new com.kwad.sdk.core.b.d() { // from class: com.kwad.sdk.ranger.a.1
            final /* synthetic */ List axM;

            AnonymousClass1(List list2) {
                list = list2;
            }

            @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
            public final void onActivityCreated(Activity activity, Bundle bundle) {
                super.onActivityCreated(activity, bundle);
                try {
                    a.a(activity, list);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.e(a.TAG, Log.getStackTraceString(th));
                }
            }
        });
    }

    private static String c(Object obj, String str) {
        Object d2;
        return (TextUtils.isEmpty(str) || (d2 = s.d(obj, str)) == null) ? "" : d2.getClass().getName();
    }
}
