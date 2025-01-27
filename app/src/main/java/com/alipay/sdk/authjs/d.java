package com.alipay.sdk.authjs;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.alipay.sdk.authjs.a;
import java.util.Timer;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a */
    c f5391a;

    /* renamed from: b */
    Context f5392b;

    public d(Context context, c cVar) {
        this.f5392b = context;
        this.f5391a = cVar;
    }

    private static /* synthetic */ a.EnumC0062a a(d dVar, a aVar) {
        if (aVar != null && "toast".equals(aVar.k)) {
            JSONObject jSONObject = aVar.m;
            String optString = jSONObject.optString("content");
            int i2 = jSONObject.optInt("duration") < 2500 ? 0 : 1;
            Toast.makeText(dVar.f5392b, optString, i2).show();
            new Timer().schedule(new f(dVar, aVar), i2);
        }
        return a.EnumC0062a.NONE_ERROR;
    }

    private void c(a aVar) throws JSONException {
        if (aVar == null) {
            return;
        }
        if (TextUtils.isEmpty(aVar.k)) {
            g(aVar.f5382i, a.EnumC0062a.INVALID_PARAMETER);
            return;
        }
        e eVar = new e(this, aVar);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            eVar.run();
        } else {
            new Handler(Looper.getMainLooper()).post(eVar);
        }
    }

    private static void e(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    private a.EnumC0062a h(a aVar) {
        if (aVar != null && "toast".equals(aVar.k)) {
            JSONObject jSONObject = aVar.m;
            String optString = jSONObject.optString("content");
            int i2 = jSONObject.optInt("duration") < 2500 ? 0 : 1;
            Toast.makeText(this.f5392b, optString, i2).show();
            new Timer().schedule(new f(this, aVar), i2);
        }
        return a.EnumC0062a.NONE_ERROR;
    }

    private void i(a aVar) {
        JSONObject jSONObject = aVar.m;
        String optString = jSONObject.optString("content");
        int i2 = jSONObject.optInt("duration") < 2500 ? 0 : 1;
        Toast.makeText(this.f5392b, optString, i2).show();
        new Timer().schedule(new f(this, aVar), i2);
    }

    public final void f(String str) {
        String str2 = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString(a.f5378e);
            try {
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                JSONObject jSONObject2 = jSONObject.getJSONObject(a.f5379f);
                JSONObject jSONObject3 = jSONObject2 instanceof JSONObject ? jSONObject2 : null;
                String string2 = jSONObject.getString(a.f5380g);
                String string3 = jSONObject.getString(a.f5377d);
                a aVar = new a("call");
                aVar.f5383j = string3;
                aVar.k = string2;
                aVar.m = jSONObject3;
                aVar.f5382i = string;
                if (TextUtils.isEmpty(string2)) {
                    g(aVar.f5382i, a.EnumC0062a.INVALID_PARAMETER);
                    return;
                }
                e eVar = new e(this, aVar);
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    eVar.run();
                } else {
                    new Handler(Looper.getMainLooper()).post(eVar);
                }
            } catch (Exception unused) {
                str2 = string;
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                try {
                    g(str2, a.EnumC0062a.RUNTIME_ERROR);
                } catch (JSONException unused2) {
                }
            }
        } catch (Exception unused3) {
        }
    }

    public final void g(String str, a.EnumC0062a enumC0062a) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("error", enumC0062a.ordinal());
        a aVar = new a(a.f5376c);
        aVar.m = jSONObject;
        aVar.f5382i = str;
        this.f5391a.a(aVar);
    }
}
