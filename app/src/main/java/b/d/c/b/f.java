package b.d.c.b;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.mibook.application.MiConfigSingleton;
import java.io.StringReader;

/* loaded from: classes2.dex */
public class f<Data> extends j {

    /* renamed from: a */
    private static final String f4447a = "JsonParser";

    /* renamed from: b */
    public int f4448b;

    /* renamed from: c */
    public String f4449c;

    /* renamed from: d */
    public String f4450d;

    /* renamed from: e */
    public String f4451e;

    /* renamed from: f */
    public boolean f4452f;

    /* renamed from: g */
    Class<Data> f4453g;

    public f(Class<Data> dataType) {
        this.f4448b = 1;
        this.f4449c = "code";
        this.f4450d = "reason";
        this.f4451e = MiConfigSingleton.t0;
        this.f4452f = true;
        this.f4453g = dataType;
    }

    @Override // b.d.c.b.j
    protected k b(String input) {
        try {
            if (TextUtils.isEmpty(this.f4451e)) {
                return new b(GsonUtils.a().fromJson(input, (Class) this.f4453g));
            }
            com.google.gson.stream.a aVar = new com.google.gson.stream.a(new StringReader(input));
            aVar.g();
            k kVar = null;
            String str = null;
            while (true) {
                if (!aVar.p()) {
                    break;
                }
                String w = aVar.w();
                if (!this.f4452f || !w.equals(this.f4449c) || kVar != null) {
                    if (w.equals(this.f4451e) && kVar == null) {
                        kVar = new b(c().fromJson(aVar, this.f4453g));
                        break;
                    }
                    if (TextUtils.isEmpty(this.f4450d) || !w.equals(this.f4450d)) {
                        aVar.M();
                    } else {
                        str = aVar.A();
                    }
                } else {
                    int u = aVar.u();
                    if (u != this.f4448b) {
                        kVar = new c(u, "网络异常");
                    }
                }
            }
            aVar.l();
            if (str != null && (kVar instanceof c)) {
                ((c) kVar).g(str);
            }
            return kVar == null ? this.f4453g == com.martian.libcomm.utils.g.class ? new b(new com.martian.libcomm.utils.g()) : new c(0, "数据异常") : kVar;
        } catch (Exception unused) {
            return new c(1000, "数据解析错误");
        }
    }

    protected Gson c() {
        return GsonUtils.a();
    }

    public f(String resultCodeKey, Class<Data> dataType) {
        this(dataType);
        this.f4449c = resultCodeKey;
    }

    public f(String resultCodeKey, String dataKey, Class<Data> dataType) {
        this(dataType);
        this.f4449c = resultCodeKey;
        this.f4451e = dataKey;
    }

    public f(String resultCodeKey, String failureReasonKey, String dataKey, int succ_code, Class<Data> dataType) {
        this(dataType);
        this.f4449c = resultCodeKey;
        this.f4450d = failureReasonKey;
        this.f4451e = dataKey;
        this.f4448b = succ_code;
    }

    public f(String resultCodeKey, String failureReasonKey, String dataKey, int succ_code, boolean hasCode, Class<Data> dataType) {
        this(dataType);
        this.f4449c = resultCodeKey;
        this.f4450d = failureReasonKey;
        this.f4451e = dataKey;
        this.f4448b = succ_code;
        this.f4452f = hasCode;
    }
}
