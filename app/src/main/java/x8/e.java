package x8;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.martian.libcomm.utils.GsonUtils;
import java.io.StringReader;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class e<E> extends g<E> {

    /* renamed from: h */
    public static final String f31886h = "JsonParser";

    /* renamed from: a */
    public int f31887a;

    /* renamed from: b */
    public String f31888b;

    /* renamed from: c */
    public String f31889c;

    /* renamed from: d */
    public String f31890d;

    /* renamed from: e */
    public boolean f31891e;

    /* renamed from: f */
    public int f31892f;

    /* renamed from: g */
    public Class<E> f31893g;

    public e() {
        this.f31887a = 1;
        this.f31888b = "code";
        this.f31889c = MediationConstant.KEY_REASON;
        this.f31890d = h3.e.f26408m;
        this.f31891e = true;
        this.f31892f = Integer.MAX_VALUE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // x8.g
    public k c(String str) {
        try {
            Gson a10 = GsonUtils.a();
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            ArrayList arrayList = new ArrayList();
            int i10 = 0;
            if (!this.f31891e) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    int i11 = i10 + 1;
                    if (i10 >= this.f31892f) {
                        return new h(arrayList);
                    }
                    arrayList.add(a10.fromJson(jsonReader, this.f31893g));
                    i10 = i11;
                }
                jsonReader.endArray();
                return new h(arrayList);
            }
            jsonReader.beginObject();
            k kVar = null;
            while (true) {
                if (!jsonReader.hasNext()) {
                    break;
                }
                String nextName = jsonReader.nextName();
                if (nextName.equals(this.f31888b)) {
                    if (jsonReader.nextInt() != this.f31887a) {
                        kVar = new c(-1, "网络异常");
                        break;
                    }
                } else if (nextName.equals(this.f31890d)) {
                    jsonReader.beginArray();
                    int i12 = 0;
                    while (jsonReader.hasNext()) {
                        int i13 = i12 + 1;
                        if (i12 >= this.f31892f) {
                            return new h(arrayList);
                        }
                        arrayList.add(a10.fromJson(jsonReader, this.f31893g));
                        i12 = i13;
                    }
                    jsonReader.endArray();
                    kVar = new h(arrayList);
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            return kVar == null ? new c(0, "数据异常") : kVar;
        } catch (Exception e10) {
            return new c(1000, e10.getClass().getSimpleName() + " -> " + e10.getMessage());
        }
    }

    public e(Class<E> cls, String str) {
        this.f31887a = 1;
        this.f31889c = MediationConstant.KEY_REASON;
        this.f31890d = h3.e.f26408m;
        this.f31891e = true;
        this.f31892f = Integer.MAX_VALUE;
        this.f31888b = str;
        this.f31893g = cls;
    }

    public e(Class<E> cls, String str, String str2, String str3, int i10) {
        this.f31891e = true;
        this.f31892f = Integer.MAX_VALUE;
        this.f31888b = str;
        this.f31889c = str2;
        this.f31890d = str3;
        this.f31887a = i10;
        this.f31893g = cls;
    }

    public e(Class<E> cls, String str, String str2, String str3, int i10, boolean z10) {
        this.f31892f = Integer.MAX_VALUE;
        this.f31888b = str;
        this.f31889c = str2;
        this.f31890d = str3;
        this.f31887a = i10;
        this.f31893g = cls;
        this.f31891e = z10;
    }

    public e(Class<E> cls, String str, String str2, String str3, int i10, boolean z10, int i11) {
        this.f31888b = str;
        this.f31889c = str2;
        this.f31890d = str3;
        this.f31887a = i10;
        this.f31893g = cls;
        this.f31891e = z10;
        this.f31892f = i11;
    }
}
