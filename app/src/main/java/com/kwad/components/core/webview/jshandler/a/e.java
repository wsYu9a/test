package com.kwad.components.core.webview.jshandler.a;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.local.LocalWriteResult;
import com.kwad.sdk.utils.bt;
import com.kwad.sdk.utils.h;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class e implements com.kwad.sdk.core.webview.c.a {
    private static SimpleDateFormat abp = new SimpleDateFormat("yyyyMMddHHmmss");
    private final WeakReference<Context> abo;

    /* renamed from: com.kwad.components.core.webview.jshandler.a.e$1 */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ com.kwad.sdk.core.webview.c.c YV;
        final /* synthetic */ Context hB;
        final /* synthetic */ String yI;

        public AnonymousClass1(String str, Context context, com.kwad.sdk.core.webview.c.c cVar) {
            str = str;
            context = context;
            cVar = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                a aVar = new a();
                aVar.parseJson(new JSONObject(str));
                com.kwad.sdk.core.d.c.d("SaveImageHandler", "saveImageData mime type: " + aVar.tD());
                LocalWriteResult a10 = com.kwad.sdk.core.local.b.a(context, aVar.tD(), aVar.tC(), "ksad_image_" + e.abp.format(new Date()));
                if (LocalWriteResult.SUCCESS.equals(a10)) {
                    e.this.b(cVar);
                } else if (LocalWriteResult.FAIL.equals(a10)) {
                    e.this.a(cVar, "write error", -1);
                } else {
                    e.this.a(cVar, "permission denied", -2);
                }
            } catch (Throwable th2) {
                e.this.a(cVar, "error_" + th2.getMessage(), -3);
            }
        }
    }

    /* renamed from: com.kwad.components.core.webview.jshandler.a.e$2 */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ com.kwad.sdk.core.webview.c.c YV;

        public AnonymousClass2(com.kwad.sdk.core.webview.c.c cVar) {
            cVar = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.webview.c.c cVar = cVar;
            if (cVar != null) {
                cVar.a(null);
            }
        }
    }

    /* renamed from: com.kwad.components.core.webview.jshandler.a.e$3 */
    public class AnonymousClass3 implements Runnable {
        final /* synthetic */ int Lw;
        final /* synthetic */ com.kwad.sdk.core.webview.c.c YV;
        final /* synthetic */ String bX;

        public AnonymousClass3(com.kwad.sdk.core.webview.c.c cVar, int i10, String str) {
            cVar = cVar;
            i10 = i10;
            str = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.webview.c.c cVar = cVar;
            if (cVar != null) {
                cVar.onError(i10, str);
            }
        }
    }

    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public String abr;
        private byte[] abs;
        private String abt;

        @Override // com.kwad.sdk.core.response.a.a
        public void afterParseJson(@Nullable JSONObject jSONObject) {
            super.afterParseJson(jSONObject);
            String[] split = this.abr.split(";base64,");
            if (split.length >= 2) {
                String str = split[0];
                if (str.startsWith("data:")) {
                    this.abt = str.substring(5);
                }
                this.abs = com.kwad.sdk.core.a.c.EZ().decode(split[1]);
            }
        }

        public final byte[] tC() {
            return this.abs;
        }

        public final String tD() {
            return this.abt;
        }
    }

    public e(Context context) {
        this.abo = new WeakReference<>(context);
    }

    public void b(com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.sdk.core.d.c.d("SaveImageHandler", "notifySuccess function callback: " + cVar);
        bt.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.a.e.2
            final /* synthetic */ com.kwad.sdk.core.webview.c.c YV;

            public AnonymousClass2(com.kwad.sdk.core.webview.c.c cVar2) {
                cVar = cVar2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.webview.c.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.a(null);
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "saveImage";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        Context context = this.abo.get();
        if (context == null) {
            return;
        }
        h.execute(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.a.e.1
            final /* synthetic */ com.kwad.sdk.core.webview.c.c YV;
            final /* synthetic */ Context hB;
            final /* synthetic */ String yI;

            public AnonymousClass1(String str2, Context context2, com.kwad.sdk.core.webview.c.c cVar2) {
                str = str2;
                context = context2;
                cVar = cVar2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a aVar = new a();
                    aVar.parseJson(new JSONObject(str));
                    com.kwad.sdk.core.d.c.d("SaveImageHandler", "saveImageData mime type: " + aVar.tD());
                    LocalWriteResult a10 = com.kwad.sdk.core.local.b.a(context, aVar.tD(), aVar.tC(), "ksad_image_" + e.abp.format(new Date()));
                    if (LocalWriteResult.SUCCESS.equals(a10)) {
                        e.this.b(cVar);
                    } else if (LocalWriteResult.FAIL.equals(a10)) {
                        e.this.a(cVar, "write error", -1);
                    } else {
                        e.this.a(cVar, "permission denied", -2);
                    }
                } catch (Throwable th2) {
                    e.this.a(cVar, "error_" + th2.getMessage(), -3);
                }
            }
        });
    }

    public void a(com.kwad.sdk.core.webview.c.c cVar, String str, int i10) {
        com.kwad.sdk.core.d.c.d("SaveImageHandler", "notifyError msg: " + str);
        bt.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.a.e.3
            final /* synthetic */ int Lw;
            final /* synthetic */ com.kwad.sdk.core.webview.c.c YV;
            final /* synthetic */ String bX;

            public AnonymousClass3(com.kwad.sdk.core.webview.c.c cVar2, int i102, String str2) {
                cVar = cVar2;
                i10 = i102;
                str = str2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.webview.c.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.onError(i10, str);
                }
            }
        });
    }
}
