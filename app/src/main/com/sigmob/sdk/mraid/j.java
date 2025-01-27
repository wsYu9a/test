package com.sigmob.sdk.mraid;

import android.content.Context;
import android.view.View;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class j {

    /* renamed from: a */
    public String f19592a;

    /* renamed from: b */
    public String f19593b;

    public interface a {
        void a(Context context, JSONObject jSONObject);

        void a(JSONObject jSONObject);

        void b(JSONObject jSONObject);

        void c(JSONObject jSONObject);

        void d(JSONObject jSONObject);

        void e(JSONObject jSONObject);

        void f(JSONObject jSONObject);

        void g(JSONObject jSONObject);

        void h(JSONObject jSONObject);
    }

    public j(String str) {
        this.f19592a = str;
    }

    public abstract void a();

    public void a(String str) {
        this.f19593b = str;
    }

    public String b() {
        return this.f19593b;
    }

    public abstract View c();
}
