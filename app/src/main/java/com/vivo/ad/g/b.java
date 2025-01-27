package com.vivo.ad.g;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.vivo.ic.dm.Downloads;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private static ExecutorService f26720a;

    static class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f26721a;

        /* renamed from: b */
        final /* synthetic */ String f26722b;

        /* renamed from: c */
        final /* synthetic */ e f26723c;

        a(Context context, String str, e eVar) {
            this.f26721a = context;
            this.f26722b = str;
            this.f26723c = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.b(this.f26721a, this.f26722b, this.f26723c);
        }
    }

    public static void b(Context context, String str, e eVar) {
        boolean z = false;
        try {
            Uri parse = Uri.parse("content://com.bbk.appstore.provider.appstatus");
            Bundle bundle = new Bundle();
            bundle.putString(Downloads.RequestHeaders.COLUMN_VALUE, str);
            Bundle call = context.getContentResolver().call(parse, "updateSecureValue", (String) null, bundle);
            if (call != null) {
                String string = call.getString("resultJson");
                f.a("HideSecureValueConnect", "resultJson:" + string);
                if (!TextUtils.isEmpty(string)) {
                    z = true;
                    try {
                        JSONObject jSONObject = new JSONObject(string);
                        int optInt = jSONObject.optInt("code");
                        String optString = jSONObject.optString(com.heytap.mcssdk.n.d.l);
                        long optLong = jSONObject.optLong("ttlSecond", -1L);
                        long optLong2 = jSONObject.optLong("updateLimit", -1L);
                        eVar.a(optLong, optLong2);
                        f.a("appInfo", "code:" + optInt + ",message:" + optString + ",ttl:" + optLong + ",updateLimit:" + optLong2);
                    } catch (JSONException e2) {
                        f.a("HideSecureValueConnect", "Fail2", e2);
                    }
                }
            }
        } catch (Exception e3) {
            f.a("HideSecureValueConnect", "Fail1", e3);
        }
        if (z) {
            return;
        }
        f.a("HideSecureValueConnect", "transfer Fail");
    }

    static String a(Context context, e eVar, long j2) {
        String num = Integer.toString(Math.abs(new Random().nextInt()));
        eVar.a(num, j2);
        if (f26720a == null) {
            f26720a = new ThreadPoolExecutor(0, 1, 3L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        }
        f26720a.submit(new a(context, num, eVar));
        return num;
    }
}
