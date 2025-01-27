package h3;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a */
    public final String f26392a;

    /* renamed from: b */
    public final String f26393b;

    public b(String str, String str2) {
        this.f26392a = str;
        this.f26393b = str2;
    }

    public String a() {
        return this.f26393b;
    }

    public String b() {
        return this.f26392a;
    }

    public JSONObject c() {
        if (TextUtils.isEmpty(this.f26393b)) {
            return null;
        }
        try {
            return new JSONObject(this.f26393b);
        } catch (Exception e10) {
            p3.d.e(e10);
            return null;
        }
    }

    public String toString() {
        return String.format("<Letter envelop=%s body=%s>", this.f26392a, this.f26393b);
    }
}
