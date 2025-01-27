package com.vivo.mobilead.lottie.a.a;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private List<s> f28968a = new ArrayList();

    public void a(Path path) {
        for (int size = this.f28968a.size() - 1; size >= 0; size--) {
            com.vivo.mobilead.lottie.f.h.a(path, this.f28968a.get(size));
        }
    }

    void a(s sVar) {
        this.f28968a.add(sVar);
    }
}
