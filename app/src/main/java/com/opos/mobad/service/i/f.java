package com.opos.mobad.service.i;

import com.opos.acs.st.STManager;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class f {

    public static class a {

        /* renamed from: a */
        private JSONObject f23709a;

        a(JSONObject jSONObject) {
            this.f23709a = jSONObject == null ? new JSONObject() : jSONObject;
        }

        public void a(int i2, int i3) {
            try {
                JSONObject jSONObject = new JSONObject();
                this.f23709a.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
                jSONObject.put("tTemplateId", i2);
                jSONObject.put("errorState", i3);
                this.f23709a.put("data_event", 13);
                this.f23709a.put("event_info", URLEncoder.encode(jSONObject.toString()));
                d.a().a(this.f23709a);
            } catch (JSONException unused) {
            }
        }

        public void a(int i2, int i3, int i4, int i5) {
            try {
                this.f23709a.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("imgCache", i2);
                jSONObject.put("imgAmount", i3);
                jSONObject.put("videoCache", i4);
                jSONObject.put("videoAmount", i5);
                this.f23709a.put("data_event", 1);
                this.f23709a.put("event_info", URLEncoder.encode(jSONObject.toString()));
                d.a().a(this.f23709a);
            } catch (JSONException unused) {
            }
        }

        public void a(int i2, String str, JSONObject jSONObject) {
            try {
                this.f23709a.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("crAmount", i2);
                jSONObject2.put("crInfo", str);
                if (jSONObject != null) {
                    jSONObject2.put("crEnvInfo", jSONObject);
                }
                this.f23709a.put("data_event", 9);
                this.f23709a.put("event_info", URLEncoder.encode(jSONObject2.toString()));
                d.a().a(this.f23709a);
            } catch (JSONException unused) {
            }
        }

        public void a(String str) {
            try {
                this.f23709a.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("posId", str);
                this.f23709a.put("data_event", 6);
                this.f23709a.put("event_info", URLEncoder.encode(jSONObject.toString()));
                d.a().a(this.f23709a);
            } catch (JSONException unused) {
            }
        }

        public void a(String str, int i2) {
            try {
                this.f23709a.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("posId", str);
                jSONObject.put("errorState", i2);
                this.f23709a.put("data_event", 4);
                this.f23709a.put("event_info", URLEncoder.encode(jSONObject.toString()));
                d.a().a(this.f23709a);
            } catch (JSONException unused) {
            }
        }

        public void a(String str, String str2, long j2, long j3) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                jSONObject.put("traceId", str);
                jSONObject.put("vDuration", j2);
                jSONObject.put("aDuration", j3);
                this.f23709a.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
                this.f23709a.put("data_event", 12);
                this.f23709a.put("event_info", URLEncoder.encode(jSONObject.toString()));
                d.a().a(this.f23709a);
            } catch (JSONException unused) {
            }
        }

        public void b(String str) {
            try {
                this.f23709a.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("posId", str);
                this.f23709a.put("data_event", 7);
                this.f23709a.put("event_info", URLEncoder.encode(jSONObject.toString()));
                d.a().a(this.f23709a);
            } catch (JSONException unused) {
            }
        }

        public void b(String str, int i2) {
            try {
                this.f23709a.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("posId", str);
                jSONObject.put("failNum", i2);
                this.f23709a.put("data_event", 5);
                this.f23709a.put("event_info", URLEncoder.encode(jSONObject.toString()));
                d.a().a(this.f23709a);
            } catch (JSONException unused) {
            }
        }

        public void c(String str) {
            try {
                this.f23709a.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("posId", str);
                this.f23709a.put("data_event", 14);
                this.f23709a.put("event_info", URLEncoder.encode(jSONObject.toString()));
                d.a().a(this.f23709a);
            } catch (JSONException unused) {
            }
        }

        public void c(String str, int i2) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("unSupportType", i2);
                jSONObject.put("traceId", str);
                this.f23709a.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
                this.f23709a.put("data_event", 11);
                this.f23709a.put("event_info", URLEncoder.encode(jSONObject.toString()));
                d.a().a(this.f23709a);
            } catch (JSONException unused) {
            }
        }

        public void d(String str) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("traceId", str);
                this.f23709a.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
                this.f23709a.put("data_event", 10);
                this.f23709a.put("event_info", URLEncoder.encode(jSONObject.toString()));
                d.a().a(this.f23709a);
            } catch (JSONException unused) {
            }
        }
    }
}
