package com.kwad.sdk.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.api.proxy.app.DownloadService;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.l.a {
    private com.kwad.sdk.c aSf;
    private Service aSh;
    private final Map<String, Integer> aSg = new ConcurrentHashMap();
    private final HandlerC0514a aSi = new HandlerC0514a(this);

    /* renamed from: com.kwad.sdk.service.a$a */
    public static class HandlerC0514a extends Handler {
        final WeakReference<a> aSj;

        public HandlerC0514a(a aVar) {
            this.aSj = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            a aVar = this.aSj.get();
            if (aVar != null && message.what == 1) {
                if (aVar.aSf == null || !aVar.aSf.za()) {
                    sendEmptyMessageDelayed(1, 30000L);
                } else {
                    aVar.aSh.stopSelf();
                }
            }
        }
    }

    private void h(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            int intExtra = intent.getIntExtra("download_service_type_tag", 0);
            String stringExtra = intent.getStringExtra("download_service_id_tag");
            DownloadTask.DownloadRequest downloadRequest = (DownloadTask.DownloadRequest) intent.getSerializableExtra("download_service_args_tag");
            Integer num = TextUtils.isEmpty(stringExtra) ? null : this.aSg.get(stringExtra);
            int intValue = num != null ? num.intValue() : 0;
            if (intExtra == 1) {
                this.aSg.put(stringExtra, Integer.valueOf(this.aSf.a(downloadRequest, (com.kwad.sdk.a) null)));
                return;
            }
            if (intExtra == 2) {
                this.aSf.pause(intValue);
                return;
            }
            if (intExtra == 3) {
                this.aSf.resume(intValue);
                return;
            }
            if (intExtra != 4) {
                return;
            }
            if (intValue != 0) {
                this.aSf.cancel(intValue);
                return;
            }
            String stringExtra2 = intent.getStringExtra("download_service_path");
            if (stringExtra2 != null) {
                com.kwad.sdk.c.bX(stringExtra2);
            }
        } catch (Exception unused) {
        }
    }

    @InvokeBy(invokerClass = b.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        b.a(DownloadService.class, a.class);
    }

    @Override // com.kwad.sdk.l.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(Service service) {
        if (service == null) {
            return;
        }
        this.aSh = service;
        this.aSf = com.kwad.sdk.c.yU();
        this.aSi.sendEmptyMessageDelayed(1, 30000L);
    }

    @Override // com.kwad.sdk.l.a, com.kwad.sdk.api.proxy.IServiceProxy
    public int onStartCommand(Service service, Intent intent, int i10, int i11) {
        h(intent);
        return super.onStartCommand(service, intent, i10, i11);
    }
}
