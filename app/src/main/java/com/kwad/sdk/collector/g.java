package com.kwad.sdk.collector;

import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class g {
    public static int PERMISSION_DENIED = 2;
    public static int PERMISSION_GRANTED = 1;
    public static int abg;
    private String abf;
    private int state;

    public g(String str, int i2) {
        this.state = abg;
        this.abf = str;
        this.state = i2;
    }

    public static JSONArray k(List<g> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null) {
            return jSONArray;
        }
        Iterator<g> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().toJson());
        }
        return jSONArray;
    }

    private String tH() {
        int lastIndexOf;
        String str = this.abf;
        return ((str.startsWith("com.android.") || this.abf.startsWith("android.permission")) && (lastIndexOf = this.abf.lastIndexOf(".")) < this.abf.length() + (-1)) ? this.abf.substring(lastIndexOf + 1) : str;
    }

    private JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", tH());
            jSONObject.put("state", this.state);
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
        return jSONObject;
    }
}
