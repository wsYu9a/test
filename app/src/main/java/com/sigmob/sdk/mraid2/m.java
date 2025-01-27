package com.sigmob.sdk.mraid2;

import android.content.Context;
import android.text.TextUtils;
import com.martian.libmars.activity.PermissionActivity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class m {

    /* renamed from: d */
    public static Map<String, String> f19811d = new HashMap();

    /* renamed from: a */
    public Map<String, a> f19812a = new HashMap();

    /* renamed from: b */
    public Map<String, a> f19813b = new HashMap();

    /* renamed from: c */
    public Context f19814c;

    public interface a {
        void a(JSONObject jSONObject);
    }

    public m(Context context) {
        this.f19814c = context;
    }

    public void a(int i10, String str, a aVar) {
        (i10 == 1 ? this.f19812a : this.f19813b).put(str, aVar);
    }

    public int b(int i10) {
        return (i10 == 1 ? k.b(this.f19814c) : f19811d).size();
    }

    public void a(int i10) {
        if (i10 == 1) {
            Map<String, ?> b10 = k.b(this.f19814c);
            if (b10 != null && b10.size() > 0) {
                for (Map.Entry<String, ?> entry : b10.entrySet()) {
                    a aVar = this.f19812a.get(entry.getKey());
                    if (aVar != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put(PermissionActivity.f12046p, entry.getKey());
                            jSONObject.put("newValue", "");
                            jSONObject.put("oldValue", entry.getValue());
                        } catch (JSONException e10) {
                            e10.printStackTrace();
                        }
                        aVar.a(jSONObject);
                    }
                }
            }
            k.a(this.f19814c);
            return;
        }
        Map<String, String> map = f19811d;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry2 : f19811d.entrySet()) {
            a aVar2 = this.f19813b.get(entry2.getKey());
            if (aVar2 != null) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(PermissionActivity.f12046p, entry2.getKey());
                    jSONObject2.put("newValue", "");
                    jSONObject2.put("oldValue", entry2.getValue());
                } catch (JSONException e11) {
                    e11.printStackTrace();
                }
                aVar2.a(jSONObject2);
            }
        }
        f19811d.clear();
    }

    public void b(int i10, String str) {
        a aVar;
        a aVar2;
        if (i10 == 1) {
            String str2 = (String) k.a(this.f19814c, str, "");
            if (!TextUtils.isEmpty(str2) && (aVar2 = this.f19812a.get(str)) != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(PermissionActivity.f12046p, str);
                    jSONObject.put("newValue", "");
                    jSONObject.put("oldValue", str2);
                } catch (JSONException e10) {
                    e10.printStackTrace();
                }
                aVar2.a(jSONObject);
            }
            k.c(this.f19814c, str);
            return;
        }
        String str3 = f19811d.get(str);
        if (!TextUtils.isEmpty(str3) && (aVar = this.f19813b.get(str)) != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(PermissionActivity.f12046p, str);
                jSONObject2.put("newValue", "");
                jSONObject2.put("oldValue", str3);
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
            aVar.a(jSONObject2);
        }
        f19811d.remove(str);
    }

    public String a(int i10, String str) {
        if (i10 == 1) {
            return (String) k.a(this.f19814c, str, "");
        }
        return f19811d.get(str) == null ? "" : f19811d.get(str);
    }

    public void a(int i10, String str, String str2) {
        a aVar;
        a aVar2;
        if (i10 == 1) {
            String str3 = (String) k.a(this.f19814c, str, "");
            if (!str3.equals(str2) && (aVar2 = this.f19812a.get(str)) != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(PermissionActivity.f12046p, str);
                    jSONObject.put("newValue", str2);
                    jSONObject.put("oldValue", str3);
                } catch (JSONException e10) {
                    e10.printStackTrace();
                }
                aVar2.a(jSONObject);
            }
            k.b(this.f19814c, str, str2);
            return;
        }
        String str4 = f19811d.get(str) != null ? f19811d.get(str) : "";
        if (!str4.equals(str2) && (aVar = this.f19813b.get(str)) != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(PermissionActivity.f12046p, str);
                jSONObject2.put("newValue", str2);
                jSONObject2.put("oldValue", str4);
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
            aVar.a(jSONObject2);
        }
        f19811d.put(str, str2);
    }
}
