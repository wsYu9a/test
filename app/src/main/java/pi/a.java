package pi;

import android.util.Log;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.shu.priory.config.AdKeys;
import com.sntech.stat.newstat.oaid.Cdo;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: g */
    public static final /* synthetic */ int f29903g = 0;

    /* renamed from: a */
    public String f29904a;

    /* renamed from: b */
    public String f29905b;

    /* renamed from: c */
    public String f29906c;

    /* renamed from: d */
    public long f29907d;

    /* renamed from: e */
    public int f29908e;

    /* renamed from: f */
    public boolean f29909f;

    /* renamed from: pi.a$a */
    public class C0766a implements Cdo {

        /* renamed from: a */
        public final /* synthetic */ long f29910a;

        public C0766a(long j10) {
            this.f29910a = j10;
        }

        public final void a(Cdo.InterfaceC0629do interfaceC0629do) {
            if (interfaceC0629do != null && interfaceC0629do.isSupported()) {
                a.this.f29904a = interfaceC0629do.getOAID();
                a.this.f29905b = interfaceC0629do.getVAID();
                a.this.f29906c = interfaceC0629do.getAAID();
                a.this.f29909f = interfaceC0629do.isSupported();
            }
            a.this.f29907d = System.currentTimeMillis() - this.f29910a;
            if (rh.d.d()) {
                StringBuilder a10 = nh.b.a("Msa Init: oaid = ");
                a10.append(a.this.f29904a);
                a10.append(" vaid = ");
                a10.append(a.this.f29905b);
                a10.append(" aaid = ");
                a10.append(a.this.f29906c);
                Log.d("for", a10.toString());
            }
        }
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(MediationConstant.KEY_ERROR_CODE, this.f29908e);
        jSONObject.put("isSupported", this.f29909f);
        jSONObject.put(AdKeys.OAID, this.f29904a);
        jSONObject.put("vaid", this.f29905b);
        jSONObject.put("aaid", this.f29906c);
        jSONObject.put("takeMs", this.f29907d);
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(android.content.Context r4) {
        /*
            r3 = this;
            long r0 = java.lang.System.currentTimeMillis()
            pi.a$a r2 = new pi.a$a
            r2.<init>(r0)
            boolean r0 = com.sntech.stat.newstat.oaid.OADIDSDKHelper.isSupport()
            if (r0 == 0) goto L16
            int r4 = com.sntech.stat.newstat.oaid.OADIDSDKHelper.getOAId(r4, r2)
        L13:
            r3.f29908e = r4
            goto L21
        L16:
            boolean r0 = com.sntech.stat.newstat.oaid.OADIDSDKHelper25.isSupport()
            if (r0 == 0) goto L21
            int r4 = com.sntech.stat.newstat.oaid.OADIDSDKHelper25.getOAId(r4, r2)
            goto L13
        L21:
            boolean r4 = rh.d.d()
            if (r4 == 0) goto L3b
            java.lang.String r4 = "Msa Init: code = "
            java.lang.StringBuilder r4 = nh.b.a(r4)
            int r0 = r3.f29908e
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            java.lang.String r0 = "for"
            android.util.Log.d(r0, r4)
        L3b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: pi.a.b(android.content.Context):void");
    }
}
