package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.umeng.commonsdk.debug.UMRTLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class bb {

    /* renamed from: a */
    public static final String[] f23501a = {"um_plus_game_level", "um_plus_game_pay", "um_plus_game_buy", "um_plus_game_use", "um_plus_game_bonus"};

    /* renamed from: b */
    public static final String[] f23502b = {"id", "ts", f.f23885ac, "__ct__", "pn", "ds"};

    /* renamed from: c */
    public static final String f23503c = "^(?!\\d)[a-zA-Z0-9_\\-\\+\\.]{1,}$";

    /* renamed from: d */
    public static final int f23504d = 128;

    /* renamed from: e */
    public static final int f23505e = 256;

    /* renamed from: f */
    public static final int f23506f = 100;

    /* renamed from: h */
    private a f23508h;

    /* renamed from: i */
    private String f23509i;

    /* renamed from: j */
    private String f23510j;

    /* renamed from: k */
    private boolean f23511k;

    /* renamed from: l */
    private Map<String, String> f23512l = null;

    /* renamed from: m */
    private Map<String, Object> f23513m = null;

    /* renamed from: g */
    JSONObject f23507g = null;

    /* renamed from: com.umeng.analytics.pro.bb$1 */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f23514a;

        static {
            int[] iArr = new int[a.values().length];
            f23514a = iArr;
            try {
                iArr[a.ID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23514a[a.LABEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23514a[a.STRING_MAP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f23514a[a.OBJECT_MAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum a {
        ID,
        LABEL,
        STRING_MAP,
        OBJECT_MAP
    }

    private void h() {
        String str;
        try {
            JSONArray jSONArray = new JSONArray();
            String str2 = this.f23509i;
            String str3 = "";
            if (str2 == null) {
                jSONArray.put("100001");
            } else if (TextUtils.isEmpty(str2.trim())) {
                jSONArray.put("100002");
            } else {
                boolean z10 = this.f23509i.trim().getBytes().length > 128;
                if (Arrays.asList(f23501a).contains(this.f23509i)) {
                    jSONArray.put("100003");
                    str = this.f23509i;
                } else {
                    str = null;
                }
                if (!Pattern.matches(f23503c, this.f23509i)) {
                    jSONArray.put(ay.f23477e);
                    str = this.f23509i;
                }
                if (z10) {
                    jSONArray.put(ay.f23476d);
                    str3 = this.f23509i.length() > 128 ? this.f23509i.substring(0, 128) : this.f23509i;
                } else {
                    str3 = str;
                }
            }
            if (str3 != null) {
                this.f23507g.put("eID", str3);
                if (jSONArray.length() > 0) {
                    this.f23507g.put("code", jSONArray);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void i() {
        try {
            h();
            JSONObject a10 = a(this.f23509i, this.f23510j, true);
            if (a10.length() > 0) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(a10);
                if (this.f23507g == null) {
                    this.f23507g = new JSONObject();
                }
                if (!this.f23507g.has("eID")) {
                    this.f23507g.put("eID", this.f23509i);
                }
                this.f23507g.put("epps", jSONArray);
            }
        } catch (Throwable unused) {
        }
    }

    private void j() {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            h();
            if (this.f23512l == null) {
                this.f23513m = null;
            } else {
                this.f23513m = new HashMap(this.f23512l);
            }
            a(this.f23513m, jSONObject, jSONArray);
            a(jSONObject, jSONArray);
        } catch (Throwable unused) {
        }
    }

    private void k() {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            h();
            a(this.f23513m, jSONObject, jSONArray);
            a(jSONObject, jSONArray);
        } catch (Throwable unused) {
        }
    }

    public a a() {
        return this.f23508h;
    }

    public String b() {
        return this.f23509i;
    }

    public String c() {
        return this.f23510j;
    }

    public boolean d() {
        return this.f23511k;
    }

    public Map<String, String> e() {
        return this.f23512l;
    }

    public Map<String, Object> f() {
        return this.f23513m;
    }

    public JSONObject g() {
        this.f23507g = new JSONObject();
        int i10 = AnonymousClass1.f23514a[this.f23508h.ordinal()];
        if (i10 == 1) {
            h();
            JSONObject jSONObject = this.f23507g;
            if (jSONObject == null || jSONObject.length() <= 0) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "未检查到错误。 ");
            } else {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "result: " + this.f23507g);
            }
        } else if (i10 == 2) {
            i();
            JSONObject jSONObject2 = this.f23507g;
            if (jSONObject2 == null || jSONObject2.length() <= 0) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "未检查到错误。 ");
            } else {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "result: " + this.f23507g);
            }
        } else if (i10 == 3) {
            j();
            JSONObject jSONObject3 = this.f23507g;
            if (jSONObject3 == null || jSONObject3.length() <= 0) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "未检查到错误。 ");
            } else {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "result: " + this.f23507g);
            }
        } else if (i10 != 4) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "unknown CkItem type!");
        } else {
            k();
            JSONObject jSONObject4 = this.f23507g;
            if (jSONObject4 == null || jSONObject4.length() <= 0) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "未检查到错误。 ");
            } else {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "result: " + this.f23507g);
            }
        }
        return this.f23507g;
    }

    private JSONObject c(String str, Object obj) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (obj instanceof String) {
                jSONObject = a(str, (String) obj, false);
            } else if (!(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Short) && !(obj instanceof Float) && !(obj instanceof Double)) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(ay.f23489q);
                jSONObject.put("code", jSONArray);
                jSONObject.put(ExposeManager.UtArgsNames.pid, obj.getClass().getName());
                jSONObject.put("msg", str);
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public bb a(a aVar) {
        this.f23508h = aVar;
        return this;
    }

    public bb b(String str) {
        this.f23510j = str;
        return this;
    }

    public bb a(String str) {
        this.f23509i = str;
        return this;
    }

    public bb b(Map<String, Object> map) {
        this.f23513m = map;
        return this;
    }

    private void b(Map<String, Object> map, JSONObject jSONObject, JSONArray jSONArray) {
        try {
            for (String str : map.keySet()) {
                Object obj = map.get(str);
                JSONArray a10 = a(str, obj);
                if (a10 != null && a10.length() > 0) {
                    for (int i10 = 0; i10 < a10.length(); i10++) {
                        jSONArray.put(a10.get(i10));
                    }
                } else {
                    jSONObject.put(str, obj);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public bb a(boolean z10) {
        this.f23511k = z10;
        return this;
    }

    public bb a(Map<String, String> map) {
        this.f23512l = map;
        return this;
    }

    private void a(JSONObject jSONObject, JSONArray jSONArray) throws JSONException {
        if (this.f23507g == null) {
            this.f23507g = new JSONObject();
        }
        if (jSONArray.length() > 0) {
            this.f23507g.put("epps", jSONArray);
            if (jSONObject.length() > 0) {
                this.f23507g.put("pps", jSONObject);
            }
        }
        if (!this.f23507g.has("epps") || this.f23507g.has("code")) {
            return;
        }
        this.f23507g.put("eID", this.f23509i);
    }

    private JSONObject b(String str, Object obj) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            if (str == null) {
                jSONArray.put(ay.f23487o);
                jSONObject.put(ExposeManager.UtArgsNames.pid, "");
            } else if (TextUtils.isEmpty(str.trim())) {
                jSONArray.put("100016");
                jSONObject.put(ExposeManager.UtArgsNames.pid, "");
            } else {
                boolean z10 = str.trim().getBytes().length > 128;
                if (Arrays.asList(f23502b).contains(str)) {
                    jSONArray.put(ay.f23479g);
                    jSONObject.put(ExposeManager.UtArgsNames.pid, str);
                }
                if (!Pattern.matches(f23503c, str)) {
                    jSONArray.put(ay.f23488p);
                    jSONObject.put(ExposeManager.UtArgsNames.pid, str);
                }
                if (z10) {
                    jSONArray.put(ay.f23480h);
                    if (str.length() > 128) {
                        str = str.substring(0, 128);
                    }
                    jSONObject.put(ExposeManager.UtArgsNames.pid, str);
                }
            }
            if (jSONArray.length() > 0) {
                jSONObject.put("code", jSONArray);
                jSONObject.put("msg", obj);
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private void a(Map<String, Object> map, JSONObject jSONObject, JSONArray jSONArray) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray2 = new JSONArray();
            if (map == null) {
                jSONArray2.put("100023");
            } else if (map.isEmpty()) {
                jSONArray2.put("100015");
            } else if (map.size() > 100) {
                jSONArray2.put(ay.f23478f);
            }
            if (jSONArray2.length() > 0) {
                jSONObject2.put("code", jSONArray2);
                jSONArray.put(jSONObject2);
            } else {
                b(map, jSONObject, jSONArray);
            }
        } catch (Throwable unused) {
        }
    }

    private JSONArray a(String str, Object obj) {
        JSONArray jSONArray = null;
        try {
            JSONObject b10 = b(str, obj);
            if (b10.length() > 0) {
                JSONArray jSONArray2 = new JSONArray();
                try {
                    jSONArray2.put(b10);
                    jSONArray = jSONArray2;
                } catch (Throwable unused) {
                    return jSONArray2;
                }
            }
            JSONObject c10 = c(str, obj);
            if (c10.length() <= 0) {
                return jSONArray;
            }
            if (jSONArray == null) {
                jSONArray = new JSONArray();
            }
            jSONArray.put(c10);
            return jSONArray;
        } catch (Throwable unused2) {
            return jSONArray;
        }
    }

    private JSONObject a(String str, String str2, boolean z10) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (str2 == null) {
                jSONArray.put(ay.f23481i);
                jSONObject.put("code", jSONArray);
                jSONObject.put(ExposeManager.UtArgsNames.pid, "");
                jSONObject.put("msg", str);
            } else if (str2.getBytes().length > 256) {
                if (z10) {
                    jSONArray.put("100022");
                } else {
                    jSONArray.put(ay.f23482j);
                }
                jSONObject.put("code", jSONArray);
                if (str2.length() > 256) {
                    str2 = str2.substring(0, 256);
                }
                jSONObject.put(ExposeManager.UtArgsNames.pid, str2);
                jSONObject.put("msg", str);
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
