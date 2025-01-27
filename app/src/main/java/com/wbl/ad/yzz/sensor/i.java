package com.wbl.ad.yzz.sensor;

import android.content.SharedPreferences;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.sensor.g;
import java.util.concurrent.Future;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class i extends g<JSONObject> {

    public class a implements g.a<JSONObject> {
        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, org.json.JSONObject] */
        @Override // com.wbl.ad.yzz.sensor.g.a
        public /* bridge */ /* synthetic */ JSONObject a() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10718, this, null);
        }

        /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object, org.json.JSONObject] */
        @Override // com.wbl.ad.yzz.sensor.g.a
        public /* bridge */ /* synthetic */ JSONObject a(String str) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10717, this, str);
        }

        @Override // com.wbl.ad.yzz.sensor.g.a
        public /* bridge */ /* synthetic */ String a(JSONObject jSONObject) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10720, this, jSONObject);
        }

        /* renamed from: a */
        public String a2(JSONObject jSONObject) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10719, this, jSONObject);
        }

        public JSONObject b() {
            return (JSONObject) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10714, this, null);
        }

        public JSONObject b(String str) {
            return (JSONObject) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10713, this, str);
        }
    }

    public i(Future<SharedPreferences> future) {
        super(future, "super_properties", new a());
    }
}
