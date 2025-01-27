package com.kwad.sdk.m;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.h;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class e {
    public static final String TAG = "e";

    /* renamed from: com.kwad.sdk.m.e$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ String aKQ;

        public AnonymousClass1(String str) {
            str = str;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            String str = str;
            if (TextUtils.isEmpty(str)) {
                com.kwad.sdk.core.d.c.w(e.TAG, "config is empty");
                return;
            }
            c gB = e.gB(str);
            if (gB != null) {
                com.kwad.sdk.core.d.c.d(e.TAG, "config:" + gB.toJson().toString());
            }
            if (gB == null || gB.Mo()) {
                return;
            }
            e.c(gB);
        }
    }

    private static void a(@NonNull c cVar) {
        try {
            a.a(cVar);
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.e(TAG, Log.getStackTraceString(th2));
        }
    }

    public static void c(@NonNull c cVar) {
        if (new Random().nextFloat() >= cVar.sampleRate) {
            com.kwad.sdk.core.d.c.d(TAG, "config.sampleRate：" + cVar.sampleRate + " return");
            return;
        }
        if (cVar.Mp()) {
            a(cVar);
        }
        if (cVar.Mq()) {
            d(cVar);
        }
    }

    public static void cO(String str) {
        h.schedule(new bd() { // from class: com.kwad.sdk.m.e.1
            final /* synthetic */ String aKQ;

            public AnonymousClass1(String str2) {
                str = str2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                String str2 = str;
                if (TextUtils.isEmpty(str2)) {
                    com.kwad.sdk.core.d.c.w(e.TAG, "config is empty");
                    return;
                }
                c gB = e.gB(str2);
                if (gB != null) {
                    com.kwad.sdk.core.d.c.d(e.TAG, "config:" + gB.toJson().toString());
                }
                if (gB == null || gB.Mo()) {
                    return;
                }
                e.c(gB);
            }
        }, 0L, TimeUnit.SECONDS);
    }

    private static void d(c cVar) {
        b.Mm().b(cVar);
    }

    public static c gB(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            c cVar = new c();
            cVar.parseJson(jSONObject);
            return cVar;
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.w(TAG, e10);
            return null;
        }
    }
}
