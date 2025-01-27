package com.tencent.open.b;

import android.os.Bundle;
import java.io.Serializable;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class b implements Serializable {

    /* renamed from: a */
    public final HashMap<String, String> f25445a = new HashMap<>();

    public b(Bundle bundle) {
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                this.f25445a.put(str, bundle.getString(str));
            }
        }
    }
}
