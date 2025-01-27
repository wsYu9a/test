package com.kwad.sdk.ranger;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.g;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class e {
    public static final String TAG = "e";

    /* renamed from: com.kwad.sdk.ranger.e$1 */
    static class AnonymousClass1 extends aw {
        final /* synthetic */ String arG;

        AnonymousClass1(String str) {
            str = str;
        }

        @Override // com.kwad.sdk.utils.aw
        public final void doTask() {
            String str = str;
            if (TextUtils.isEmpty(str)) {
                com.kwad.sdk.core.d.b.w(e.TAG, "config is empty");
                return;
            }
            d er = e.er(str);
            if (er != null) {
                com.kwad.sdk.core.d.b.d(e.TAG, "config:" + er.toJson().toString());
            }
            if (er == null || er.Cm()) {
                return;
            }
            e.d(er);
        }
    }

    private static void a(@NonNull d dVar) {
        try {
            a.a(dVar);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.e(TAG, Log.getStackTraceString(th));
        }
    }

    public static void cL(String str) {
        g.schedule(new aw() { // from class: com.kwad.sdk.ranger.e.1
            final /* synthetic */ String arG;

            AnonymousClass1(String str2) {
                str = str2;
            }

            @Override // com.kwad.sdk.utils.aw
            public final void doTask() {
                String str2 = str;
                if (TextUtils.isEmpty(str2)) {
                    com.kwad.sdk.core.d.b.w(e.TAG, "config is empty");
                    return;
                }
                d er = e.er(str2);
                if (er != null) {
                    com.kwad.sdk.core.d.b.d(e.TAG, "config:" + er.toJson().toString());
                }
                if (er == null || er.Cm()) {
                    return;
                }
                e.d(er);
            }
        }, 0L, TimeUnit.SECONDS);
    }

    public static void d(@NonNull d dVar) {
        if (new Random().nextFloat() >= dVar.axW) {
            com.kwad.sdk.core.d.b.d(TAG, "config.sampleRate：" + dVar.axW + " return");
            return;
        }
        if (dVar.Cn()) {
            e(dVar);
        }
        if (dVar.Co()) {
            a(dVar);
        }
        if (dVar.Cp()) {
            f(dVar);
        }
    }

    private static void e(@NonNull d dVar) {
        List<String> list = dVar.axT;
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            RangerHelper.c(dVar);
            RangerHelper.replaceInternal();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.e(TAG, Log.getStackTraceString(th));
        }
    }

    public static d er(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d();
            dVar.parseJson(jSONObject);
            return dVar;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.w(TAG, e2);
            return null;
        }
    }

    private static void f(d dVar) {
        b.Ck().b(dVar);
    }
}
