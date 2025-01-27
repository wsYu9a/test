package com.opos.cmn.biz.monitor.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.am;
import com.opos.cmn.biz.monitor.b.a;
import com.opos.cmn.biz.monitor.b.b;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpHeaders;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a */
    private Context f16742a;

    /* renamed from: b */
    private String f16743b;

    /* renamed from: c */
    private int f16744c;

    /* renamed from: d */
    private int f16745d = 0;

    /* renamed from: e */
    private com.opos.cmn.biz.monitor.b.a f16746e;

    /* renamed from: f */
    private a f16747f;

    /* renamed from: com.opos.cmn.biz.monitor.b.e$1 */
    class AnonymousClass1 implements a.InterfaceC0377a {

        /* renamed from: a */
        final /* synthetic */ String f16748a;

        AnonymousClass1(String str) {
            str = str;
        }

        @Override // com.opos.cmn.biz.monitor.b.a.InterfaceC0377a
        public void a() {
            com.opos.cmn.an.f.a.b("NetRequestExecutor", "request fail with url:" + str);
            if (e.this.f16747f != null) {
                e.this.f16747f.a();
            }
        }

        @Override // com.opos.cmn.biz.monitor.b.a.InterfaceC0377a
        public void a(c cVar) {
            com.opos.cmn.an.f.a.b("NetRequestExecutor", "result code:" + cVar.a());
            e.this.a(cVar.a(), cVar.c(), cVar.b());
        }
    }

    public interface a {
        void a();

        void a(byte[] bArr);
    }

    public e(Context context, String str, int i2, com.opos.cmn.biz.monitor.b.a aVar, a aVar2) {
        this.f16742a = context;
        this.f16743b = str;
        this.f16744c = i2;
        this.f16746e = aVar;
        this.f16747f = aVar2;
    }

    public static boolean a(byte[] bArr) {
        String str;
        if (bArr == null || bArr.length <= 0) {
            str = "request success but data empty";
        } else {
            try {
                int i2 = new JSONObject(new String(bArr)).getInt("code");
                if (i2 == 0) {
                    return true;
                }
                str = "request success but ret:" + i2;
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.b("NetRequestExecutor", "request but parse fail", e2);
            }
        }
        com.opos.cmn.an.f.a.b("NetRequestExecutor", str);
        return false;
    }

    public void a() {
        com.opos.cmn.an.f.a.b("NetRequestExecutor", "send request:" + this.f16743b);
        a(this.f16743b);
    }

    protected void a(int i2, byte[] bArr, Map<String, String> map) {
        a aVar;
        if (200 == i2) {
            a aVar2 = this.f16747f;
            if (aVar2 != null) {
                aVar2.a(bArr);
                return;
            }
            return;
        }
        if (302 == i2) {
            String str = map.get("location");
            if (TextUtils.isEmpty(str)) {
                str = map.get(HttpHeaders.LOCATION);
            }
            if (this.f16745d < this.f16744c && !TextUtils.isEmpty(str)) {
                com.opos.cmn.an.f.a.b("NetRequestExecutor", "retry with url:" + str);
                this.f16745d = this.f16745d + 1;
                a(str);
                return;
            }
            aVar = this.f16747f;
            if (aVar == null) {
                return;
            }
        } else {
            aVar = this.f16747f;
            if (aVar == null) {
                return;
            }
        }
        aVar.a();
    }

    protected void a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(HttpHeaders.ACCEPT, am.f5520d);
        this.f16746e.a(this.f16742a, new b.a(str).a(hashMap).a(), new a.InterfaceC0377a() { // from class: com.opos.cmn.biz.monitor.b.e.1

            /* renamed from: a */
            final /* synthetic */ String f16748a;

            AnonymousClass1(String str2) {
                str = str2;
            }

            @Override // com.opos.cmn.biz.monitor.b.a.InterfaceC0377a
            public void a() {
                com.opos.cmn.an.f.a.b("NetRequestExecutor", "request fail with url:" + str);
                if (e.this.f16747f != null) {
                    e.this.f16747f.a();
                }
            }

            @Override // com.opos.cmn.biz.monitor.b.a.InterfaceC0377a
            public void a(c cVar) {
                com.opos.cmn.an.f.a.b("NetRequestExecutor", "result code:" + cVar.a());
                e.this.a(cVar.a(), cVar.c(), cVar.b());
            }
        });
    }
}
