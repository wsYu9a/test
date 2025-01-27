package com.kwad.sdk.pngencrypt.chunk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class w {
    private final e aRi;
    private final boolean aRj;

    public w(e eVar) {
        this.aRi = eVar;
        if (eVar instanceof f) {
            this.aRj = false;
        } else {
            this.aRj = true;
        }
    }

    private List<? extends t> gz(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.aRi.al("tEXt", str));
        arrayList.addAll(this.aRi.al("zTXt", str));
        arrayList.addAll(this.aRi.al("iTXt", str));
        return arrayList;
    }

    public final String gA(String str) {
        List<? extends t> gz = gz(str);
        if (gz.isEmpty()) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator<? extends t> it = gz.iterator();
        while (it.hasNext()) {
            sb2.append(it.next().Mj());
            sb2.append("\n");
        }
        return sb2.toString().trim();
    }
}
