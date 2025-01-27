package com.opos.cmn.d;

import android.content.Context;
import android.text.TextUtils;
import com.opos.videocache.c;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a */
    private static final byte[] f16913a = new byte[0];

    /* renamed from: b */
    private static volatile com.opos.videocache.c f16914b;

    /* renamed from: com.opos.cmn.d.e$1 */
    static final class AnonymousClass1 implements com.opos.videocache.a.c {

        /* renamed from: a */
        final /* synthetic */ Context f16915a;

        AnonymousClass1(Context context) {
            context = context;
        }

        @Override // com.opos.videocache.a.c
        public String a(String str) {
            return e.c(context, str);
        }
    }

    /* renamed from: com.opos.cmn.d.e$2 */
    static final class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f16916a;

        /* renamed from: b */
        final /* synthetic */ String f16917b;

        /* renamed from: c */
        final /* synthetic */ a f16918c;

        AnonymousClass2(Context context, String str, a aVar) {
            context = context;
            str = str;
            aVar = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String a2 = e.a(context, str);
            a aVar = aVar;
            if (aVar != null) {
                aVar.a(a2);
            }
        }
    }

    public interface a {
        void a(String str);
    }

    private static final class b implements com.opos.videocache.b.b {

        /* renamed from: a */
        private Map<String, String> f16919a;

        public b() {
            HashMap hashMap = new HashMap(1);
            this.f16919a = hashMap;
            hashMap.put(HttpHeaders.ACCEPT_ENCODING, HTTP.IDENTITY_CODING);
        }

        @Override // com.opos.videocache.b.b
        public Map<String, String> a(String str) {
            return this.f16919a;
        }
    }

    public static com.opos.videocache.c a(Context context) {
        com.opos.videocache.c cVar = f16914b;
        if (cVar == null) {
            synchronized (f16913a) {
                cVar = f16914b;
                if (cVar == null) {
                    com.opos.videocache.c a2 = new c.a(context.getApplicationContext()).a(new com.opos.videocache.a.c() { // from class: com.opos.cmn.d.e.1

                        /* renamed from: a */
                        final /* synthetic */ Context f16915a;

                        AnonymousClass1(Context context2) {
                            context = context2;
                        }

                        @Override // com.opos.videocache.a.c
                        public String a(String str) {
                            return e.c(context, str);
                        }
                    }).a(DownloadConstants.GB).a(50).a(new b()).a();
                    f16914b = a2;
                    cVar = a2;
                }
            }
        }
        return cVar;
    }

    public static String a(Context context, String str) {
        String a2 = (context == null || com.opos.cmn.an.c.a.a(str)) ? "" : a(context).a(str);
        com.opos.cmn.an.f.a.b("VideoProxyUtils", "getProxyUrl=" + a2);
        return a2;
    }

    public static void a(Context context, String str, a aVar) {
        com.opos.cmn.an.j.b.b(new Runnable() { // from class: com.opos.cmn.d.e.2

            /* renamed from: a */
            final /* synthetic */ Context f16916a;

            /* renamed from: b */
            final /* synthetic */ String f16917b;

            /* renamed from: c */
            final /* synthetic */ a f16918c;

            AnonymousClass2(Context context2, String str2, a aVar2) {
                context = context2;
                str = str2;
                aVar = aVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String a2 = e.a(context, str);
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(a2);
                }
            }
        });
    }

    public static String c(Context context, String str) {
        String a2 = d.a(context.getApplicationContext(), str);
        return TextUtils.isEmpty(a2) ? d.b(context.getApplicationContext(), str) : a2;
    }
}
