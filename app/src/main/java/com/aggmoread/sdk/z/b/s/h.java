package com.aggmoread.sdk.z.b.s;

import android.util.Log;
import com.aggmoread.sdk.z.b.m.n;
import com.aggmoread.sdk.z.b.p.a;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class h {

    public static class a implements a.g {

        /* renamed from: a */
        final /* synthetic */ c f4897a;

        /* renamed from: com.aggmoread.sdk.z.b.s.h$a$a */
        public class RunnableC0097a implements Runnable {

            /* renamed from: b */
            final /* synthetic */ b f4898b;

            public RunnableC0097a(b bVar) {
                this.f4898b = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f4897a.a(this.f4898b);
            }
        }

        public a(c cVar) {
            this.f4897a = cVar;
        }

        @Override // com.aggmoread.sdk.z.b.p.a.g
        public void a(int i10, byte[] bArr, com.aggmoread.sdk.z.b.g.e eVar) {
            com.aggmoread.sdk.z.b.d.c("CLKRJTAG", "onResponse enter , err = " + eVar);
            if (eVar == null) {
                if (bArr != null) {
                    try {
                        b bVar = new b();
                        String str = new String(bArr);
                        com.aggmoread.sdk.z.b.d.d(str, "request response");
                        JSONObject jSONObject = new JSONObject(str);
                        if (jSONObject.has(h3.e.f26408m)) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject(h3.e.f26408m);
                            if (jSONObject2.has("clickid")) {
                                bVar.f4901a = jSONObject2.getString("clickid");
                            }
                            if (jSONObject2.has("dstlink")) {
                                bVar.f4902b = jSONObject2.getString("dstlink");
                            }
                            n.b(new RunnableC0097a(bVar));
                            return;
                        }
                        return;
                    } catch (Exception e10) {
                        e10.printStackTrace();
                        Log.i("CLKRJTAG", "get clk err ," + e10.getMessage());
                        return;
                    }
                }
                com.aggmoread.sdk.z.b.d.c("CLKRJTAG", "onResponse enter , response = " + ((Object) null));
            }
            this.f4897a.a(b.f4900c);
        }
    }

    public static class b {

        /* renamed from: c */
        public static final b f4900c = new b();

        /* renamed from: a */
        public String f4901a;

        /* renamed from: b */
        public String f4902b;

        public boolean a() {
            return this == f4900c;
        }

        public String toString() {
            return "ClickUrlResponseData{clickId='" + this.f4901a + "', clickUrl='" + this.f4902b + "'}";
        }
    }

    public static abstract class c {
        public abstract void a(b bVar);
    }

    public static void a(String str, c cVar) {
        com.aggmoread.sdk.z.b.p.a.a(str, null, new a(cVar));
    }
}
