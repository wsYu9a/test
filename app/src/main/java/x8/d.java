package x8;

import com.google.gson.Gson;
import com.martian.libcomm.utils.GsonUtils;

/* loaded from: classes3.dex */
public class d<Data> extends j {

    /* renamed from: a */
    public final Class<Data> f31884a;

    /* renamed from: b */
    public Gson f31885b;

    public d(Class<Data> cls, Gson gson) {
        this.f31884a = cls;
        this.f31885b = gson;
    }

    @Override // x8.j
    public k a(String str) {
        try {
            return new b(this.f31885b.fromJson(str, (Class) this.f31884a));
        } catch (Exception e10) {
            return new c(-1, e10.getMessage());
        }
    }

    public void c(Gson gson) {
        this.f31885b = gson;
    }

    public d(Class<Data> cls) {
        this.f31884a = cls;
        this.f31885b = GsonUtils.b();
    }
}
