package com.opos.cmn.biz.requeststatistic;

import android.content.Context;
import com.baidu.mobads.sdk.internal.am;
import com.opos.cmn.func.b.b.d;
import com.opos.cmn.func.b.b.e;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.zip.GZIPOutputStream;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: com.opos.cmn.biz.requeststatistic.a$1 */
    public static final class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f16772a;

        /* renamed from: b */
        final /* synthetic */ String f16773b;

        /* renamed from: c */
        final /* synthetic */ InterfaceC0380a f16774c;

        public AnonymousClass1(Context context, String str2, InterfaceC0380a interfaceC0380a) {
            r1 = context;
            r2 = str2;
            r3 = interfaceC0380a;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.a(r1, r2, r3);
        }
    }

    /* renamed from: com.opos.cmn.biz.requeststatistic.a$a */
    public interface InterfaceC0380a {
        void onFail();

        void onSuccess();
    }

    public static final void a(Context context, String str, InterfaceC0380a interfaceC0380a) {
        e eVar = null;
        try {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("Content-type", am.f5520d);
                hashMap.put(HttpHeaders.ACCEPT_CHARSET, "UTF-8");
                hashMap.put("Connection", HTTP.CONN_KEEP_ALIVE);
                hashMap.put("Route-Data", com.opos.cmn.biz.a.e.a(context));
                hashMap.put("Content-Encoding", "gzip");
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length());
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(str.getBytes());
                gZIPOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                eVar = com.opos.cmn.func.b.b.b.a().a(context, new d.a().a(hashMap).a(byteArray).a("POST").b(b.a(context)).a());
                if (eVar == null || 200 != eVar.f17168a) {
                    if (interfaceC0380a != null) {
                        interfaceC0380a.onFail();
                    }
                } else if (interfaceC0380a != null) {
                    interfaceC0380a.onSuccess();
                }
                if (eVar == null) {
                    return;
                }
            } catch (Exception unused) {
                if (interfaceC0380a != null) {
                    interfaceC0380a.onFail();
                }
                if (0 == 0) {
                    return;
                }
            }
            eVar.a();
        } catch (Throwable th) {
            if (0 != 0) {
                eVar.a();
            }
            throw th;
        }
    }
}
