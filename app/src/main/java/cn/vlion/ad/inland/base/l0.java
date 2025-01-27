package cn.vlion.ad.inland.base;

import android.text.TextUtils;
import android.util.ArrayMap;
import com.martian.libmars.activity.PermissionActivity;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class l0 {

    /* renamed from: a, reason: collision with root package name */
    public String f3057a;

    /* renamed from: b, reason: collision with root package name */
    public String f3058b;

    /* renamed from: c, reason: collision with root package name */
    public String f3059c;

    /* renamed from: d, reason: collision with root package name */
    public String f3060d;

    /* renamed from: e, reason: collision with root package name */
    public long f3061e;

    public l0(String str, String str2, String str3) {
        this.f3061e = System.currentTimeMillis();
        this.f3057a = this.f3061e + hf.e.f26694a + UUID.randomUUID().toString();
        this.f3058b = str;
        this.f3059c = str2;
        this.f3060d = str3;
    }

    public final String a() {
        return this.f3059c;
    }

    public final String b() {
        return this.f3058b;
    }

    public final ArrayMap<String, String> c() {
        try {
            if (TextUtils.isEmpty(this.f3060d)) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(this.f3060d);
            ArrayMap<String, String> arrayMap = new ArrayMap<>();
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                arrayMap.put(jSONObject.get(PermissionActivity.f12046p).toString(), jSONObject.get("value").toString());
            }
            return arrayMap;
        } catch (Throwable unused) {
            return null;
        }
    }

    public l0(String str, String str2, String str3, String str4, long j10) {
        this.f3057a = str;
        this.f3058b = str2;
        this.f3059c = str3;
        this.f3061e = j10;
        this.f3060d = str4;
    }
}
