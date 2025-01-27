package com.alipay.mobilesecuritysdk.model;

import android.util.Log;
import com.alipay.mobilesecuritysdk.a.d;
import com.alipay.mobilesecuritysdk.a.f;
import com.alipay.mobilesecuritysdk.constant.ConfigNameEnum;
import com.alipay.mobilesecuritysdk.constant.LocationNameEnum;
import com.baidu.mobads.sdk.internal.bj;
import java.io.File;
import java.io.StringReader;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a */
    private List<String> f5272a;

    private d b() {
        d c2 = d.c();
        c2.p(0L);
        c2.q(com.alipay.mobilesecuritysdk.constant.a.f5218i);
        c2.o(1);
        c2.m(0L);
        c2.l(30);
        c2.n(24);
        c2.k(0L);
        c2.j(7);
        return c2;
    }

    private JSONArray e(List<f> list) {
        JSONArray jSONArray = new JSONArray();
        for (f fVar : list) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (fVar.a() == null) {
                    jSONObject.put(LocationNameEnum.BSSID.getValue(), "");
                } else {
                    jSONObject.put(LocationNameEnum.BSSID.getValue(), fVar.a());
                }
                if (fVar.c() == null) {
                    jSONObject.put(LocationNameEnum.SSID.getValue(), "");
                } else {
                    jSONObject.put(LocationNameEnum.SSID.getValue(), fVar.c());
                }
                jSONObject.put(LocationNameEnum.CURRENT.getValue(), fVar.e());
                jSONObject.put(LocationNameEnum.LEVEL.getValue(), fVar.b());
                jSONArray.put(jSONObject);
            } catch (JSONException e2) {
                Log.d("location", e2.getLocalizedMessage());
            }
        }
        return jSONArray;
    }

    public String a(String str, List<com.alipay.mobilesecuritysdk.a.a> list) {
        File file = new File(str);
        if (file.length() > com.alipay.mobilesecuritysdk.constant.a.L) {
            file.delete();
            Log.i("delete file", "app file size > 50k, file path is" + str);
        }
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray2 = new JSONArray();
        for (com.alipay.mobilesecuritysdk.a.a aVar : list) {
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(ConfigNameEnum.PKG_NAME.getValue(), aVar.b());
                jSONObject3.put(ConfigNameEnum.PUB_KEY_HASH.getValue(), aVar.a());
                jSONArray2.put(jSONObject3);
            } catch (JSONException e2) {
                Log.d("appinfo", e2.getLocalizedMessage());
            }
        }
        try {
            if (d() == null) {
                jSONObject2.put(b.b.a.b.b.f4200c, "");
            } else {
                jSONObject2.put(b.b.a.b.b.f4200c, d());
            }
            jSONObject2.put("appList", jSONArray2);
            jSONObject2.put("timestamp", com.alipay.mobilesecuritysdk.c.a.g(new Date()));
            jSONObject.put("type", ConfigNameEnum.START_TAG.getValue());
            jSONObject.put(bj.f5604i, jSONObject2);
        } catch (JSONException e3) {
            Log.i("apptojason", e3.getLocalizedMessage());
        }
        jSONArray.put(jSONObject);
        return jSONArray.toString();
    }

    public JSONArray c(String str) {
        if (str.length() <= 0) {
            return null;
        }
        String e2 = com.alipay.mobilesecuritysdk.c.a.e(str);
        if (e2.length() <= 0) {
            return null;
        }
        try {
            return new JSONArray(e2);
        } catch (JSONException e3) {
            Log.d("getjsonfromfile", e3.getLocalizedMessage());
            return null;
        }
    }

    public JSONArray d() {
        List<String> list = this.f5272a;
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.f5272a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        return jSONArray;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String f(java.lang.String r8, java.util.List<com.alipay.mobilesecuritysdk.a.c> r9) {
        /*
            r7 = this;
            java.lang.String r0 = "LocationToString path is "
            android.util.Log.i(r0, r8)
            java.io.File r0 = new java.io.File
            r0.<init>(r8)
            long r1 = r0.length()
            r3 = 0
            r4 = 51200(0xc800, double:2.5296E-319)
            int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r6 <= 0) goto L21
            r0.delete()
            java.lang.String r8 = "delete file"
            java.lang.String r0 = "lc file size > 50k"
            android.util.Log.i(r8, r0)
            goto L38
        L21:
            int r1 = r8.length()
            if (r1 <= 0) goto L38
            boolean r1 = r0.isDirectory()
            if (r1 != 0) goto L38
            boolean r0 = r0.exists()
            if (r0 == 0) goto L38
            org.json.JSONArray r8 = r7.c(r8)
            goto L39
        L38:
            r8 = r3
        L39:
            if (r8 != 0) goto L40
            org.json.JSONArray r8 = new org.json.JSONArray
            r8.<init>()
        L40:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.util.Iterator r9 = r9.iterator()
        L49:
            boolean r1 = r9.hasNext()
            if (r1 != 0) goto L57
            r8.put(r0)
            java.lang.String r8 = r8.toString()
            return r8
        L57:
            java.lang.Object r1 = r9.next()
            com.alipay.mobilesecuritysdk.a.c r1 = (com.alipay.mobilesecuritysdk.a.c) r1
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: org.json.JSONException -> L100
            r2.<init>()     // Catch: org.json.JSONException -> L100
            com.alipay.mobilesecuritysdk.constant.LocationNameEnum r4 = com.alipay.mobilesecuritysdk.constant.LocationNameEnum.LOCATE_LATITUDE     // Catch: org.json.JSONException -> L100
            java.lang.String r4 = r4.getValue()     // Catch: org.json.JSONException -> L100
            java.lang.String r5 = r1.c()     // Catch: org.json.JSONException -> L100
            r2.put(r4, r5)     // Catch: org.json.JSONException -> L100
            com.alipay.mobilesecuritysdk.constant.LocationNameEnum r4 = com.alipay.mobilesecuritysdk.constant.LocationNameEnum.LOCATE_LONGITUDE     // Catch: org.json.JSONException -> L100
            java.lang.String r4 = r4.getValue()     // Catch: org.json.JSONException -> L100
            java.lang.String r5 = r1.d()     // Catch: org.json.JSONException -> L100
            r2.put(r4, r5)     // Catch: org.json.JSONException -> L100
            com.alipay.mobilesecuritysdk.constant.LocationNameEnum r4 = com.alipay.mobilesecuritysdk.constant.LocationNameEnum.LOCATE_CELL_ID     // Catch: org.json.JSONException -> L100
            java.lang.String r4 = r4.getValue()     // Catch: org.json.JSONException -> L100
            java.lang.String r5 = r1.a()     // Catch: org.json.JSONException -> L100
            r2.put(r4, r5)     // Catch: org.json.JSONException -> L100
            com.alipay.mobilesecuritysdk.constant.LocationNameEnum r4 = com.alipay.mobilesecuritysdk.constant.LocationNameEnum.LOCATE_LAC     // Catch: org.json.JSONException -> L100
            java.lang.String r4 = r4.getValue()     // Catch: org.json.JSONException -> L100
            java.lang.String r5 = r1.b()     // Catch: org.json.JSONException -> L100
            r2.put(r4, r5)     // Catch: org.json.JSONException -> L100
            com.alipay.mobilesecuritysdk.constant.LocationNameEnum r4 = com.alipay.mobilesecuritysdk.constant.LocationNameEnum.TIME_STAMP     // Catch: org.json.JSONException -> L100
            java.lang.String r4 = r4.getValue()     // Catch: org.json.JSONException -> L100
            java.lang.String r5 = r1.i()     // Catch: org.json.JSONException -> L100
            r2.put(r4, r5)     // Catch: org.json.JSONException -> L100
            java.lang.String r4 = "tid"
            org.json.JSONArray r5 = r7.d()     // Catch: org.json.JSONException -> L100
            r2.put(r4, r5)     // Catch: org.json.JSONException -> L100
            com.alipay.mobilesecuritysdk.constant.LocationNameEnum r4 = com.alipay.mobilesecuritysdk.constant.LocationNameEnum.MCC     // Catch: org.json.JSONException -> L100
            java.lang.String r4 = r4.getValue()     // Catch: org.json.JSONException -> L100
            java.lang.String r5 = r1.e()     // Catch: org.json.JSONException -> L100
            r2.put(r4, r5)     // Catch: org.json.JSONException -> L100
            com.alipay.mobilesecuritysdk.constant.LocationNameEnum r4 = com.alipay.mobilesecuritysdk.constant.LocationNameEnum.MNC     // Catch: org.json.JSONException -> L100
            java.lang.String r4 = r4.getValue()     // Catch: org.json.JSONException -> L100
            java.lang.String r5 = r1.f()     // Catch: org.json.JSONException -> L100
            r2.put(r4, r5)     // Catch: org.json.JSONException -> L100
            com.alipay.mobilesecuritysdk.constant.LocationNameEnum r4 = com.alipay.mobilesecuritysdk.constant.LocationNameEnum.PHONETYPE     // Catch: org.json.JSONException -> L100
            java.lang.String r4 = r4.getValue()     // Catch: org.json.JSONException -> L100
            java.lang.String r5 = r1.g()     // Catch: org.json.JSONException -> L100
            r2.put(r4, r5)     // Catch: org.json.JSONException -> L100
            java.util.List r4 = r1.j()     // Catch: org.json.JSONException -> L100
            if (r4 == 0) goto Le2
            java.util.List r1 = r1.j()     // Catch: org.json.JSONException -> L100
            org.json.JSONArray r1 = r7.e(r1)     // Catch: org.json.JSONException -> L100
            goto Le3
        Le2:
            r1 = r3
        Le3:
            if (r1 == 0) goto Lee
            com.alipay.mobilesecuritysdk.constant.LocationNameEnum r4 = com.alipay.mobilesecuritysdk.constant.LocationNameEnum.LOCATE_WIFI     // Catch: org.json.JSONException -> L100
            java.lang.String r4 = r4.getValue()     // Catch: org.json.JSONException -> L100
            r2.put(r4, r1)     // Catch: org.json.JSONException -> L100
        Lee:
            java.lang.String r1 = "type"
            com.alipay.mobilesecuritysdk.constant.LocationNameEnum r4 = com.alipay.mobilesecuritysdk.constant.LocationNameEnum.START_TAG     // Catch: org.json.JSONException -> L100
            java.lang.String r4 = r4.getValue()     // Catch: org.json.JSONException -> L100
            r0.put(r1, r4)     // Catch: org.json.JSONException -> L100
            java.lang.String r1 = "model"
            r0.put(r1, r2)     // Catch: org.json.JSONException -> L100
            goto L49
        L100:
            r1 = move-exception
            java.lang.String r1 = r1.getLocalizedMessage()
            java.lang.String r2 = "location"
            android.util.Log.d(r2, r1)
            goto L49
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobilesecuritysdk.model.b.f(java.lang.String, java.util.List):java.lang.String");
    }

    public com.alipay.mobilesecuritysdk.a.b g(String str) {
        com.alipay.mobilesecuritysdk.a.b bVar = new com.alipay.mobilesecuritysdk.a.b();
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            newPullParser.setInput(new StringReader(str));
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                try {
                    String name = newPullParser.getName();
                    if (eventType == 2) {
                        if (com.alipay.mobilesecuritysdk.c.a.h(name, ConfigNameEnum.MAIN_SWITCH_STATE.getValue())) {
                            bVar.k(newPullParser.nextText());
                        } else if (com.alipay.mobilesecuritysdk.c.a.h(name, ConfigNameEnum.MAIN_SWITCH_INTERVAL.getValue())) {
                            bVar.j(com.alipay.mobilesecuritysdk.c.a.m(newPullParser.nextText()));
                        } else if (com.alipay.mobilesecuritysdk.c.a.h(name, ConfigNameEnum.LOCATE_INTERVAL.getValue())) {
                            bVar.h(com.alipay.mobilesecuritysdk.c.a.m(newPullParser.nextText()));
                        } else if (com.alipay.mobilesecuritysdk.c.a.h(name, ConfigNameEnum.LOCATION_MAX_LINES.getValue())) {
                            bVar.i(com.alipay.mobilesecuritysdk.c.a.m(newPullParser.nextText()));
                        } else if (com.alipay.mobilesecuritysdk.c.a.h(name, ConfigNameEnum.APP_INTERVAL.getValue())) {
                            bVar.g(com.alipay.mobilesecuritysdk.c.a.m(newPullParser.nextText()));
                        }
                    }
                } catch (Exception unused) {
                }
            }
        } catch (Exception e2) {
            Log.i(com.alipay.mobilesecuritysdk.constant.a.t, e2.getMessage());
        }
        bVar.l(true);
        return bVar;
    }

    public void h(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e2) {
            Log.i(com.alipay.mobilesecuritysdk.constant.a.t, e2.getMessage());
        }
    }

    public d i(String str) {
        if (str.length() == 0) {
            return null;
        }
        try {
            File file = new File(str + File.separator + com.alipay.mobilesecuritysdk.constant.a.l);
            if (!file.exists()) {
                return b();
            }
            String e2 = com.alipay.mobilesecuritysdk.c.a.e(file.getPath());
            if (e2.length() <= 0) {
                Log.d("read json", "file size o");
                return b();
            }
            d c2 = d.c();
            try {
                JSONObject jSONObject = new JSONObject(e2).getJSONObject("configs");
                if (jSONObject == null) {
                    return b();
                }
                c2.j(jSONObject.getInt(ConfigNameEnum.APP_INTERVAL.getValue()));
                c2.k(jSONObject.getLong(ConfigNameEnum.APP_LUT.getValue()));
                c2.l(jSONObject.getInt(ConfigNameEnum.LOCATE_INTERVAL.getValue()));
                c2.m(jSONObject.getLong(ConfigNameEnum.LOCATE_LUT.getValue()));
                c2.n(jSONObject.getInt(ConfigNameEnum.LOCATION_MAX_LINES.getValue()));
                c2.o(jSONObject.getInt(ConfigNameEnum.MAIN_SWITCH_INTERVAL.getValue()));
                c2.p(jSONObject.getLong(ConfigNameEnum.MAIN_SWITCH_LUT.getValue()));
                c2.q(jSONObject.getString(ConfigNameEnum.MAIN_SWITCH_STATE.getValue()));
                return c2;
            } catch (Exception unused) {
                return b();
            }
        } catch (Exception unused2) {
            com.alipay.mobilesecuritysdk.b.a.e(true);
            return b();
        }
    }

    public List<String> j() {
        return this.f5272a;
    }

    public void k(d dVar, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ConfigNameEnum.MAIN_SWITCH_LUT.getValue(), dVar.h());
            jSONObject.put(ConfigNameEnum.MAIN_SWITCH_STATE.getValue(), dVar.i());
            jSONObject.put(ConfigNameEnum.MAIN_SWITCH_INTERVAL.getValue(), dVar.g());
            jSONObject.put(ConfigNameEnum.LOCATE_LUT.getValue(), dVar.e());
            jSONObject.put(ConfigNameEnum.LOCATE_INTERVAL.getValue(), dVar.d());
            jSONObject.put(ConfigNameEnum.LOCATION_MAX_LINES.getValue(), dVar.f());
            jSONObject.put(ConfigNameEnum.APP_LUT.getValue(), dVar.b());
            jSONObject.put(ConfigNameEnum.APP_INTERVAL.getValue(), dVar.a());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(ConfigNameEnum.CONFIGS.getValue(), jSONObject);
            if (com.alipay.mobilesecuritysdk.b.a.c()) {
                Log.i(com.alipay.mobilesecuritysdk.constant.a.t, "loadConfig" + jSONObject2.toString());
            }
            com.alipay.mobilesecuritysdk.c.a.f(str, jSONObject2.toString());
        } catch (Exception unused) {
            com.alipay.mobilesecuritysdk.b.a.e(true);
        }
    }

    public void l(List<String> list) {
        this.f5272a = list;
    }
}
