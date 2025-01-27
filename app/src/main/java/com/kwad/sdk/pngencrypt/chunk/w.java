package com.kwad.sdk.pngencrypt.chunk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class w {
    private final e axv;
    private final boolean axw;

    public w(e eVar) {
        this.axv = eVar;
        this.axw = !(eVar instanceof f);
    }

    private List<? extends t> ep(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.axv.W("tEXt", str));
        arrayList.addAll(this.axv.W("zTXt", str));
        arrayList.addAll(this.axv.W("iTXt", str));
        return arrayList;
    }

    public final String eq(String str) {
        List<? extends t> ep = ep(str);
        if (ep.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<? extends t> it = ep.iterator();
        while (it.hasNext()) {
            sb.append(it.next().Ch());
            sb.append("\n");
        }
        return sb.toString().trim();
    }
}
