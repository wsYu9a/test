package b.d.e.a;

import com.martian.ttbook.sdk.client.AdExtras;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class a implements AdExtras {

    /* renamed from: a */
    private final Map<String, Object> f4489a = new HashMap();

    private a() {
    }

    public static a a() {
        return new a();
    }

    public static a c(Map<String, Object> map) {
        a a2 = a();
        if (map != null) {
            a2.f4489a.putAll(map);
        }
        return a2;
    }

    private Object d(String str) {
        if (this.f4489a.size() != 0 && this.f4489a.containsKey(str)) {
            return this.f4489a.get(str);
        }
        return null;
    }

    public a b(String str, Object obj) {
        this.f4489a.put(str, obj);
        return this;
    }

    @Override // com.martian.ttbook.sdk.client.AdExtras
    public int getIntExtra(String str, int i2) {
        Object d2 = d(str);
        return d2 instanceof Integer ? ((Integer) d2).intValue() : i2;
    }

    @Override // com.martian.ttbook.sdk.client.AdExtras
    public Object getObjectExtra(String str) {
        return d(str);
    }

    @Override // com.martian.ttbook.sdk.client.AdExtras
    public String getStringExtra(String str, String str2) {
        Object d2 = d(str);
        return d2 instanceof String ? (String) d2 : d2 != null ? String.valueOf(d2) : str2;
    }
}
