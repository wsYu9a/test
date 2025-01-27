package com.kwad.sdk.i;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.proxy.BaseProxyService;
import com.kwad.sdk.api.proxy.IServiceProxy;

/* loaded from: classes2.dex */
public abstract class a implements IServiceProxy {
    @Override // com.kwad.sdk.api.proxy.IServiceProxy
    public IBinder onBind(@NonNull Service service, Intent intent) {
        return null;
    }

    @Override // com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(@NonNull Service service) {
    }

    @Override // com.kwad.sdk.api.proxy.IServiceProxy
    public void onDestroy(@NonNull Service service) {
    }

    @Override // com.kwad.sdk.api.proxy.IServiceProxy
    public void onRebind(@NonNull Service service, Intent intent) {
    }

    @Override // com.kwad.sdk.api.proxy.IServiceProxy
    public int onStartCommand(@NonNull Service service, Intent intent, int i2, int i3) {
        if (service instanceof BaseProxyService) {
            return ((BaseProxyService) service).superOnStartCommand(intent, i2, i3);
        }
        throw new RuntimeException(service + " must be AbstractServiceProxy");
    }

    @Override // com.kwad.sdk.api.proxy.IServiceProxy
    public boolean onUnbind(Service service, Intent intent) {
        if (service instanceof BaseProxyService) {
            return ((BaseProxyService) service).superOnUnbind(intent);
        }
        throw new RuntimeException(service + " must be AbstractServiceProxy");
    }
}
