package com.kwai.filedownloader.services;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.webkit.WebView;
import androidx.annotation.Keep;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.FileDownloadService;
import com.kwad.sdk.utils.ap;
import java.lang.ref.WeakReference;

@KsAdSdkDynamicImpl(FileDownloadService.class)
@Keep
@SuppressLint({"Registered"})
/* loaded from: classes2.dex */
public class FileDownloadServiceProxy extends com.kwad.sdk.i.a {
    private static final String TAG = "filedownloader";
    public Service context;
    private i handler;

    @KsAdSdkDynamicImpl(FileDownloadService.SeparateProcessService.class)
    @Keep
    public static class SeparateProcessServiceProxy extends FileDownloadServiceProxy {
        @Override // com.kwai.filedownloader.services.FileDownloadServiceProxy, com.kwad.sdk.i.a, com.kwad.sdk.api.proxy.IServiceProxy
        public void onCreate(Service service) {
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    WebView.setDataDirectorySuffix(ap.getProcessName(service.getApplicationContext()));
                } catch (Exception unused) {
                }
            }
            super.onCreate(service);
        }
    }

    @KsAdSdkDynamicImpl(FileDownloadService.SharedMainProcessService.class)
    @Keep
    public static class SharedMainProcessServiceProxy extends FileDownloadServiceProxy {
        @Override // com.kwai.filedownloader.services.FileDownloadServiceProxy, com.kwad.sdk.i.a, com.kwad.sdk.api.proxy.IServiceProxy
        public void onCreate(Service service) {
            super.onCreate(service);
        }
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.a.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        com.kwad.sdk.service.a.a(FileDownloadService.SeparateProcessService.class, SeparateProcessServiceProxy.class);
        com.kwad.sdk.service.a.a(FileDownloadService.SharedMainProcessService.class, SharedMainProcessServiceProxy.class);
    }

    @Override // com.kwad.sdk.i.a, com.kwad.sdk.api.proxy.IServiceProxy
    public IBinder onBind(Service service, Intent intent) {
        return this.handler.IS();
    }

    @Override // com.kwad.sdk.i.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(Service service) {
        if (service == null) {
            return;
        }
        this.context = service;
        com.kwai.filedownloader.e.c.dt(service);
        try {
            com.kwai.filedownloader.e.f.dk(com.kwai.filedownloader.e.e.Jb().aJr);
            com.kwai.filedownloader.e.f.ar(com.kwai.filedownloader.e.e.Jb().aJs);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
        g gVar = new g();
        this.handler = com.kwai.filedownloader.e.e.Jb().aJu ? new e(new WeakReference(this), gVar) : new d(new WeakReference(this), gVar);
    }

    @Override // com.kwad.sdk.i.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onDestroy(Service service) {
        this.handler.onDestroy();
    }

    @Override // com.kwad.sdk.i.a, com.kwad.sdk.api.proxy.IServiceProxy
    public int onStartCommand(Service service, Intent intent, int i2, int i3) {
        this.handler.IR();
        return 2;
    }
}
