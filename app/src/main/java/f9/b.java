package f9;

import com.google.gson.Gson;
import com.martian.libcomm.utils.GsonUtils;
import x8.f;

/* loaded from: classes3.dex */
public class b<Data> extends f<Data> {
    public b(Class<Data> cls) {
        super("errcode", "errmsg", h3.e.f26408m, 0, true, cls);
    }

    @Override // x8.f
    public Gson c() {
        return GsonUtils.b();
    }
}
