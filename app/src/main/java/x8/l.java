package x8;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.martian.libcomm.utils.GsonUtils;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class l<Data> extends j {

    /* renamed from: a */
    public int f31902a;

    /* renamed from: b */
    public Object f31903b;

    /* renamed from: c */
    public String f31904c;

    /* renamed from: d */
    public String f31905d;

    /* renamed from: e */
    public String f31906e;

    /* renamed from: f */
    public Gson f31907f;

    /* renamed from: g */
    public Class<Data> f31908g;

    public class a implements ParameterizedType {

        /* renamed from: b */
        public Class f31909b;

        public a(Class cls) {
            this.f31909b = cls;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return new Type[]{this.f31909b};
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

    public l(Class<Data> cls) {
        this.f31902a = 0;
        this.f31903b = null;
        this.f31904c = "errcode";
        this.f31905d = "errmsg";
        this.f31906e = h3.e.f26408m;
        this.f31908g = cls;
    }

    @Override // x8.j
    public k a(String str) {
        JsonReader jsonReader;
        m mVar = new m();
        mVar.n(this.f31902a);
        try {
            jsonReader = new JsonReader(new StringReader(str));
            jsonReader.setLenient(true);
        } catch (Exception e10) {
            mVar.l(1000);
            mVar.m(e10.getMessage());
        }
        if (TextUtils.isEmpty(this.f31906e)) {
            mVar.l(this.f31902a);
            mVar.d(d(jsonReader));
            return mVar;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals(this.f31904c)) {
                Object obj = this.f31903b;
                if (obj == null) {
                    mVar.l(jsonReader.nextInt());
                } else {
                    mVar.l(this.f31903b.equals(obj instanceof Boolean ? Boolean.valueOf(jsonReader.nextBoolean()) : jsonReader.nextString()) ? this.f31902a : 100001);
                }
            } else if (nextName.equals(this.f31906e)) {
                mVar.d(d(jsonReader));
            } else if (TextUtils.isEmpty(this.f31905d) || !nextName.equals(this.f31905d)) {
                jsonReader.skipValue();
            } else {
                mVar.m(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return mVar;
    }

    @Override // x8.j
    public k b(w8.a aVar) {
        return aVar.e() ? new m(aVar.a(), aVar.b()) : a(aVar.b());
    }

    public Gson c() {
        return this.f31907f;
    }

    public final List<Data> d(JsonReader jsonReader) throws IOException {
        JsonToken peek = jsonReader.peek();
        if (this.f31907f == null) {
            this.f31907f = GsonUtils.c();
        }
        ArrayList arrayList = new ArrayList();
        if (peek == JsonToken.BEGIN_OBJECT || peek == JsonToken.STRING || peek == JsonToken.NUMBER || peek == JsonToken.BOOLEAN) {
            arrayList.add(this.f31907f.fromJson(jsonReader, this.f31908g));
            return arrayList;
        }
        if (peek == JsonToken.BEGIN_ARRAY) {
            return (List) this.f31907f.fromJson(jsonReader, new a(this.f31908g));
        }
        throw new UnsupportedOperationException("未知的json reader状态: " + peek);
    }

    public void e(Gson gson) {
        this.f31907f = gson;
    }

    public l(String str, String str2, String str3, int i10, Class<Data> cls) {
        this(cls);
        this.f31904c = str;
        this.f31905d = str2;
        this.f31906e = str3;
        this.f31902a = i10;
    }

    public l(String str, String str2, String str3, Object obj, Class<Data> cls) {
        this(cls);
        this.f31904c = str;
        this.f31905d = str2;
        this.f31906e = str3;
        this.f31903b = obj;
    }
}
