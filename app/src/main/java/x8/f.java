package x8;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.martian.libcomm.utils.GsonUtils;
import java.io.StringReader;

/* loaded from: classes3.dex */
public class f<Data> extends j {

    /* renamed from: g */
    public static final String f31894g = "JsonParser";

    /* renamed from: a */
    public int f31895a;

    /* renamed from: b */
    public String f31896b;

    /* renamed from: c */
    public String f31897c;

    /* renamed from: d */
    public String f31898d;

    /* renamed from: e */
    public boolean f31899e;

    /* renamed from: f */
    public Class<Data> f31900f;

    public f(Class<Data> cls) {
        this.f31895a = 1;
        this.f31896b = "code";
        this.f31897c = MediationConstant.KEY_REASON;
        this.f31898d = h3.e.f26408m;
        this.f31899e = true;
        this.f31900f = cls;
    }

    @Override // x8.j
    public k a(String str) {
        try {
            if (TextUtils.isEmpty(this.f31898d)) {
                return new b(GsonUtils.a().fromJson(str, (Class) this.f31900f));
            }
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            jsonReader.beginObject();
            k kVar = null;
            String str2 = null;
            while (true) {
                if (!jsonReader.hasNext()) {
                    break;
                }
                String nextName = jsonReader.nextName();
                if (!this.f31899e || !nextName.equals(this.f31896b) || kVar != null) {
                    if (nextName.equals(this.f31898d) && kVar == null) {
                        kVar = new b(c().fromJson(jsonReader, this.f31900f));
                        break;
                    }
                    if (TextUtils.isEmpty(this.f31897c) || !nextName.equals(this.f31897c)) {
                        jsonReader.skipValue();
                    } else {
                        str2 = jsonReader.nextString();
                    }
                } else {
                    int nextInt = jsonReader.nextInt();
                    if (nextInt != this.f31895a) {
                        kVar = new c(nextInt, "网络异常");
                    }
                }
            }
            jsonReader.endObject();
            if (str2 != null && (kVar instanceof c)) {
                ((c) kVar).g(str2);
            }
            return kVar == null ? this.f31900f == z8.g.class ? new b(new z8.g()) : new c(0, "数据异常") : kVar;
        } catch (Exception unused) {
            return new c(1000, "数据解析错误");
        }
    }

    public Gson c() {
        return GsonUtils.a();
    }

    public f(String str, Class<Data> cls) {
        this(cls);
        this.f31896b = str;
    }

    public f(String str, String str2, Class<Data> cls) {
        this(cls);
        this.f31896b = str;
        this.f31898d = str2;
    }

    public f(String str, String str2, String str3, int i10, Class<Data> cls) {
        this(cls);
        this.f31896b = str;
        this.f31897c = str2;
        this.f31898d = str3;
        this.f31895a = i10;
    }

    public f(String str, String str2, String str3, int i10, boolean z10, Class<Data> cls) {
        this(cls);
        this.f31896b = str;
        this.f31897c = str2;
        this.f31898d = str3;
        this.f31895a = i10;
        this.f31899e = z10;
    }
}
