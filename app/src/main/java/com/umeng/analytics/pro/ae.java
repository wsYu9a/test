package com.umeng.analytics.pro;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class ae extends ab {

    /* renamed from: a */
    private int f23394a;

    /* renamed from: b */
    private int f23395b;

    /* renamed from: c */
    private int f23396c;

    /* renamed from: d */
    private ArrayList<Pair<String, Integer>> f23397d;

    public ae(String str, ArrayList<ac> arrayList) {
        super(str, arrayList);
    }

    public void a(int i10) {
        this.f23394a = i10;
    }

    public void b(int i10) {
        this.f23395b = i10;
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(new String(ax.a(Base64.decode(str, 0), UMUtils.genSin())));
            int length = jSONArray.length();
            if (length > 0) {
                this.f23397d = new ArrayList<>();
            }
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                String optString = jSONObject.has("type") ? jSONObject.optString("type") : "";
                int valueOf = jSONObject.has(com.umeng.ccg.a.B) ? Integer.valueOf(jSONObject.optInt(com.umeng.ccg.a.B)) : 1;
                if (!TextUtils.isEmpty(optString)) {
                    this.f23397d.add(new Pair<>(optString, valueOf));
                }
            }
            this.f23396c = this.f23397d.size();
        } catch (Throwable unused) {
        }
    }

    public int d() {
        return this.f23396c;
    }

    public int e() {
        return this.f23394a;
    }

    public int f() {
        return this.f23395b;
    }

    public ArrayList<Pair<String, Integer>> g() {
        return this.f23397d;
    }

    @Override // com.umeng.analytics.pro.ab
    public String a() {
        return super.a();
    }

    @Override // com.umeng.analytics.pro.ab
    public String b() {
        return super.b();
    }

    @Override // com.umeng.analytics.pro.ab
    public void a(String str) {
        super.a(str);
    }

    @Override // com.umeng.analytics.pro.ab
    public void b(String str) {
        super.b(str);
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                int i10 = this.f23394a;
                int i11 = 0;
                if (i10 != 0) {
                    if (i10 == 1) {
                        int randNumber = DeviceConfig.getRandNumber(0, this.f23396c - 1);
                        String str = (String) this.f23397d.get(randNumber).first;
                        int intValue = ((Integer) this.f23397d.get(randNumber).second).intValue();
                        jSONObject.put("target", str);
                        jSONObject.put(com.umeng.ccg.a.B, intValue);
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "selPoclicy: 1, currIndex: " + randNumber);
                        return;
                    }
                    return;
                }
                SharedPreferences a10 = au.a(UMGlobalContext.getAppContext());
                if (a10 != null) {
                    int i12 = a10.getInt(au.f23467h, 0);
                    if (i12 < this.f23396c) {
                        String str2 = (String) this.f23397d.get(i12).first;
                        int intValue2 = ((Integer) this.f23397d.get(i12).second).intValue();
                        jSONObject.put("target", str2);
                        jSONObject.put(com.umeng.ccg.a.B, intValue2);
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "selPoclicy: 0, currIndex: " + i12);
                        if (i12 < this.f23396c - 1) {
                            i11 = i12 + 1;
                        }
                    } else {
                        String str3 = (String) this.f23397d.get(0).first;
                        int intValue3 = ((Integer) this.f23397d.get(0).second).intValue();
                        jSONObject.put("target", str3);
                        jSONObject.put(com.umeng.ccg.a.B, intValue3);
                    }
                    a10.edit().putInt(au.f23467h, i11).commit();
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.umeng.analytics.pro.ab, com.umeng.analytics.pro.aj
    public void b(String str, JSONObject jSONObject) {
        super.b(str, jSONObject);
        if (jSONObject.has(com.umeng.ccg.a.f24248y)) {
            a(jSONObject.optInt(com.umeng.ccg.a.f24248y));
        }
        if (jSONObject.has(com.umeng.ccg.a.f24249z)) {
            b(jSONObject.optInt(com.umeng.ccg.a.f24249z));
        }
        if (jSONObject.has(com.umeng.ccg.a.f24247x)) {
            c(jSONObject.optString(com.umeng.ccg.a.f24247x));
        }
    }

    @Override // com.umeng.analytics.pro.ab
    public String c() {
        return super.c();
    }

    @Override // com.umeng.analytics.pro.ab, com.umeng.analytics.pro.aj
    public JSONObject a(String str, JSONObject jSONObject) {
        JSONObject a10 = super.a(str, jSONObject);
        if (this.f23396c == 0) {
            return null;
        }
        if (jSONObject != null) {
            try {
                a10.put(com.umeng.ccg.a.f24249z, this.f23395b);
                a10.put(com.umeng.ccg.a.f24248y, this.f23394a);
                int optInt = jSONObject.optInt(com.umeng.ccg.a.f24233j);
                if (this.f23395b == 0 && optInt == 202) {
                    a(a10);
                }
                if (this.f23395b == 1 && optInt == 304) {
                    a(a10);
                }
            } catch (Throwable unused) {
            }
        }
        return a10;
    }
}
