package b.d.c.b;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.stream.JsonToken;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.mibook.application.MiConfigSingleton;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class l<Data> extends j {

    /* renamed from: a */
    private int f4455a;

    /* renamed from: b */
    private Object f4456b;

    /* renamed from: c */
    private String f4457c;

    /* renamed from: d */
    private String f4458d;

    /* renamed from: e */
    private String f4459e;

    /* renamed from: f */
    private Gson f4460f;

    /* renamed from: g */
    Class<Data> f4461g;

    private class a implements ParameterizedType {

        /* renamed from: a */
        Class f4462a;

        public a(Class clz) {
            this.f4462a = clz;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return new Type[]{this.f4462a};
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return null;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return List.class;
        }
    }

    public l(Class<Data> dataType) {
        this.f4455a = 0;
        this.f4456b = null;
        this.f4457c = "errcode";
        this.f4458d = "errmsg";
        this.f4459e = MiConfigSingleton.t0;
        this.f4461g = dataType;
    }

    private List<Data> d(com.google.gson.stream.a reader) throws IOException {
        JsonToken C = reader.C();
        if (this.f4460f == null) {
            this.f4460f = GsonUtils.c();
        }
        ArrayList arrayList = new ArrayList();
        if (C == JsonToken.BEGIN_OBJECT || C == JsonToken.STRING || C == JsonToken.NUMBER || C == JsonToken.BOOLEAN) {
            arrayList.add(this.f4460f.fromJson(reader, this.f4461g));
            return arrayList;
        }
        if (C == JsonToken.BEGIN_ARRAY) {
            return (List) this.f4460f.fromJson(reader, new a(this.f4461g));
        }
        throw new UnsupportedOperationException("未知的json reader状态: " + C);
    }

    @Override // b.d.c.b.j
    public k a(b.d.c.a.c.a resp) {
        return resp.e() ? new m(resp.a(), resp.b()) : b(resp.b());
    }

    @Override // b.d.c.b.j
    protected k b(String input) {
        com.google.gson.stream.a aVar;
        m mVar = new m();
        mVar.n(this.f4455a);
        try {
            aVar = new com.google.gson.stream.a(new StringReader(input));
            aVar.H(true);
        } catch (Exception e2) {
            mVar.l(1000);
            mVar.m(e2.getMessage());
        }
        if (TextUtils.isEmpty(this.f4459e)) {
            mVar.l(this.f4455a);
            mVar.d(d(aVar));
            return mVar;
        }
        aVar.g();
        while (aVar.p()) {
            String w = aVar.w();
            if (w.equals(this.f4457c)) {
                Object obj = this.f4456b;
                if (obj == null) {
                    mVar.l(aVar.u());
                } else {
                    mVar.l(this.f4456b.equals(obj instanceof Boolean ? Boolean.valueOf(aVar.s()) : aVar.A()) ? this.f4455a : c.f4432c);
                }
            } else if (w.equals(this.f4459e)) {
                mVar.d(d(aVar));
            } else if (TextUtils.isEmpty(this.f4458d) || !w.equals(this.f4458d)) {
                aVar.M();
            } else {
                mVar.m(aVar.A());
            }
        }
        aVar.l();
        return mVar;
    }

    public Gson c() {
        return this.f4460f;
    }

    public void e(Gson gson) {
        this.f4460f = gson;
    }

    public l(String codeKey, String msgKey, String dataKey, int succCode, Class<Data> dataType) {
        this(dataType);
        this.f4457c = codeKey;
        this.f4458d = msgKey;
        this.f4459e = dataKey;
        this.f4455a = succCode;
    }

    public l(String codeKey, String msgKey, String dataKey, Object succRet, Class<Data> dataType) {
        this(dataType);
        this.f4457c = codeKey;
        this.f4458d = msgKey;
        this.f4459e = dataKey;
        this.f4456b = succRet;
    }
}
