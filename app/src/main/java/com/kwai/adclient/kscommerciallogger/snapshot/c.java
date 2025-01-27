package com.kwai.adclient.kscommerciallogger.snapshot;

import hf.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class c {
    private final String aYX;
    private final LinkedList<d> aYY;
    private int aYZ;
    private final int aZa;
    private long aZb;

    public c(String str) {
        this(str, 10);
    }

    public final synchronized long Qq() {
        return this.aZb;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.aYX.equals(((c) obj).aYX);
    }

    public final String getName() {
        return this.aYX;
    }

    public synchronized d hA(String str) {
        d dVar;
        try {
            if (this.aYY.size() >= this.aZa) {
                this.aYY.removeFirst();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(e.f26694a);
            int i10 = this.aYZ;
            this.aYZ = i10 + 1;
            sb2.append(i10);
            dVar = new d(sb2.toString());
            this.aYY.addLast(dVar);
            this.aZb = System.currentTimeMillis();
        } catch (Throwable th2) {
            throw th2;
        }
        return dVar;
    }

    public synchronized JSONObject hB(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            try {
                JSONArray jSONArray = new JSONArray();
                Iterator<d> it = this.aYY.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().Qp());
                }
                jSONObject.put("session_id", str);
                jSONObject.put("segment_name", this.aYX);
                jSONObject.put("spans", jSONArray);
                this.aZb = System.currentTimeMillis();
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return jSONObject;
    }

    public int hashCode() {
        return Objects.hash(this.aYX);
    }

    public c(String str, int i10) {
        this.aYX = str == null ? "" : str;
        this.aYY = new LinkedList<>();
        this.aZa = Math.min(i10, 30);
        this.aZb = System.currentTimeMillis();
    }
}
