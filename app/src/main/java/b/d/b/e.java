package b.d.b;

import android.text.TextUtils;

/* loaded from: classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private String f4403a;

    /* renamed from: b, reason: collision with root package name */
    private String f4404b;

    /* renamed from: c, reason: collision with root package name */
    public String f4405c;

    /* renamed from: d, reason: collision with root package name */
    public String f4406d;

    public e(String rawResult) {
        if (TextUtils.isEmpty(rawResult)) {
            return;
        }
        this.f4406d = rawResult;
        for (String str : rawResult.split(";")) {
            if (str.startsWith("resultStatus")) {
                this.f4403a = a(str, "resultStatus");
            }
            if (str.startsWith("result")) {
                this.f4404b = a(str, "result");
            }
            if (str.startsWith("memo")) {
                this.f4405c = a(str, "memo");
            }
        }
    }

    private String a(String content, String key) {
        String str = key + "={";
        return content.substring(content.indexOf(str) + str.length(), content.lastIndexOf("}"));
    }

    public String b() {
        return this.f4405c;
    }

    public String c() {
        return this.f4404b;
    }

    public String d() {
        return this.f4403a;
    }

    public String toString() {
        return "resultStatus={" + this.f4403a + "};memo={" + this.f4405c + "};result={" + this.f4404b + "}";
    }
}
