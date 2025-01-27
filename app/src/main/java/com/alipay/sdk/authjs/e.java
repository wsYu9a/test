package com.alipay.sdk.authjs;

import android.widget.Toast;
import com.alipay.sdk.authjs.a;
import java.util.Timer;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
final class e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ a f5393a;

    /* renamed from: b */
    final /* synthetic */ d f5394b;

    e(d dVar, a aVar) {
        this.f5394b = dVar;
        this.f5393a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d dVar = this.f5394b;
        a aVar = this.f5393a;
        if (aVar != null && "toast".equals(aVar.k)) {
            JSONObject jSONObject = aVar.m;
            String optString = jSONObject.optString("content");
            int i2 = jSONObject.optInt("duration") < 2500 ? 0 : 1;
            Toast.makeText(dVar.f5392b, optString, i2).show();
            new Timer().schedule(new f(dVar, aVar), i2);
        }
        a.EnumC0062a enumC0062a = a.EnumC0062a.NONE_ERROR;
        if (enumC0062a != enumC0062a) {
            try {
                this.f5394b.g(this.f5393a.f5382i, enumC0062a);
            } catch (JSONException unused) {
            }
        }
    }
}
