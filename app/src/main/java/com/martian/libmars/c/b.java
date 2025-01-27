package com.martian.libmars.c;

import b.d.c.b.f;
import com.google.gson.Gson;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.mibook.application.MiConfigSingleton;

/* loaded from: classes2.dex */
public class b<Data> extends f<Data> {
    public b(Class<Data> dataType) {
        super("errcode", "errmsg", MiConfigSingleton.t0, 0, true, dataType);
    }

    @Override // b.d.c.b.f
    protected Gson c() {
        return GsonUtils.b();
    }
}
