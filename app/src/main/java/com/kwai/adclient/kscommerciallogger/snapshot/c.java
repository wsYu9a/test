package com.kwai.adclient.kscommerciallogger.snapshot;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class c {
    private final String aEH;
    private final LinkedList<d> aEI;
    private int aEJ;
    private final int aEK;
    private long aEL;

    c(String str) {
        this(str, 10);
    }

    c(String str, int i2) {
        this.aEH = str == null ? "" : str;
        this.aEI = new LinkedList<>();
        this.aEK = Math.min(i2, 30);
        this.aEL = System.currentTimeMillis();
    }

    public final synchronized long Gg() {
        return this.aEL;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.aEH.equals(((c) obj).aEH);
    }

    public synchronized d fh(String str) {
        d dVar;
        if (this.aEI.size() >= this.aEK) {
            this.aEI.removeFirst();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_");
        int i2 = this.aEJ;
        this.aEJ = i2 + 1;
        sb.append(i2);
        dVar = new d(sb.toString());
        this.aEI.addLast(dVar);
        this.aEL = System.currentTimeMillis();
        return dVar;
    }

    synchronized JSONObject fi(String str) {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<d> it = this.aEI.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().Gf());
            }
            jSONObject.put("session_id", str);
            jSONObject.put("segment_name", this.aEH);
            jSONObject.put("spans", jSONArray);
            this.aEL = System.currentTimeMillis();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    final String getName() {
        return this.aEH;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.aEH});
    }
}
