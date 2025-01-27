package b.d.c.b;

import com.google.gson.Gson;
import com.martian.libcomm.utils.GsonUtils;

/* loaded from: classes2.dex */
public class d<Data> extends j {

    /* renamed from: a */
    private final Class<Data> f4437a;

    /* renamed from: b */
    private Gson f4438b;

    public d(Class<Data> dataType, Gson gson) {
        this.f4437a = dataType;
        this.f4438b = gson;
    }

    @Override // b.d.c.b.j
    protected k b(String input) {
        try {
            return new b(this.f4438b.fromJson(input, (Class) this.f4437a));
        } catch (Exception e2) {
            return new c(-1, e2.getMessage());
        }
    }

    public void c(Gson gson) {
        this.f4438b = gson;
    }

    public d(Class<Data> dataType) {
        this.f4437a = dataType;
        this.f4438b = GsonUtils.b();
    }
}
