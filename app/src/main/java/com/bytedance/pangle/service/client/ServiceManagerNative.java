package com.bytedance.pangle.service.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.Keep;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.d;
import com.bytedance.pangle.f;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.servermanager.b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

@Keep
/* loaded from: classes.dex */
public class ServiceManagerNative {
    private static volatile ServiceManagerNative sInstance;
    private final HashMap<ServiceConnection, f> serviceConn2ServiceConn = new HashMap<>();
    public HashMap<IBinder, HashMap<ServiceConnection, HashSet<ComponentName>>> process2ConnAndService = new HashMap<>();
    private HashMap<ServiceConnection, HashSet<ServiceInfo>> conn2Service = new HashMap<>();

    /* renamed from: com.bytedance.pangle.service.client.ServiceManagerNative$1 */
    final class AnonymousClass1 extends f.a {

        /* renamed from: a */
        final /* synthetic */ ServiceConnection f6304a;

        AnonymousClass1(ServiceConnection serviceConnection) {
            serviceConnection = serviceConnection;
        }

        @Override // com.bytedance.pangle.f
        public final void a(ComponentName componentName, IBinder iBinder) {
            serviceConnection.onServiceConnected(componentName, iBinder);
        }

        @Override // com.bytedance.pangle.f
        public final int a() {
            return serviceConnection.hashCode();
        }
    }

    private ServiceManagerNative() {
    }

    public static ServiceManagerNative getInstance() {
        if (sInstance == null) {
            synchronized (ServiceManagerNative.class) {
                if (sInstance == null) {
                    sInstance = new ServiceManagerNative();
                }
            }
        }
        return sInstance;
    }

    public boolean bindServiceNative(Context context, Intent intent, ServiceConnection serviceConnection, int i2, String str) {
        ServiceInfo queryServiceFromPlugin = queryServiceFromPlugin(intent, str);
        if (queryServiceFromPlugin == null) {
            return context.bindService(intent, serviceConnection, i2);
        }
        if (!this.serviceConn2ServiceConn.containsKey(serviceConnection)) {
            this.serviceConn2ServiceConn.put(serviceConnection, new f.a() { // from class: com.bytedance.pangle.service.client.ServiceManagerNative.1

                /* renamed from: a */
                final /* synthetic */ ServiceConnection f6304a;

                AnonymousClass1(ServiceConnection serviceConnection2) {
                    serviceConnection = serviceConnection2;
                }

                @Override // com.bytedance.pangle.f
                public final void a(ComponentName componentName, IBinder iBinder) {
                    serviceConnection.onServiceConnected(componentName, iBinder);
                }

                @Override // com.bytedance.pangle.f
                public final int a() {
                    return serviceConnection.hashCode();
                }
            });
        }
        if (this.conn2Service.get(serviceConnection2) == null) {
            this.conn2Service.put(serviceConnection2, new HashSet<>());
        }
        this.conn2Service.get(serviceConnection2).add(queryServiceFromPlugin);
        d a2 = b.a(queryServiceFromPlugin.processName);
        IBinder asBinder = a2.asBinder();
        HashMap<ServiceConnection, HashSet<ComponentName>> hashMap = this.process2ConnAndService.get(asBinder);
        if (hashMap == null) {
            hashMap = new HashMap<>();
            this.process2ConnAndService.put(asBinder, hashMap);
        }
        HashSet<ComponentName> hashSet = hashMap.get(serviceConnection2);
        if (hashSet == null) {
            hashSet = new HashSet<>();
            hashMap.put(serviceConnection2, hashSet);
        }
        hashSet.add(intent.getComponent());
        try {
            return a2.a(intent, this.serviceConn2ServiceConn.get(serviceConnection2), i2, str);
        } catch (RemoteException e2) {
            ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "bindService failed!", e2);
            return false;
        }
    }

    public ServiceInfo queryServiceFromPlugin(Intent intent, String str) {
        Zeus.loadPlugin(str);
        ComponentName component = intent.getComponent();
        if (component == null) {
            return null;
        }
        return PluginManager.getInstance().getPlugin(str).pluginServices.get(component.getClassName());
    }

    public ComponentName startServiceNative(Context context, Intent intent, String str) {
        ServiceInfo queryServiceFromPlugin = queryServiceFromPlugin(intent, str);
        if (queryServiceFromPlugin == null) {
            return context.startService(intent);
        }
        try {
            return b.a(queryServiceFromPlugin.processName).a(intent, str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public boolean stopServiceNative(Context context, Intent intent, String str) {
        ServiceInfo queryServiceFromPlugin = queryServiceFromPlugin(intent, str);
        if (queryServiceFromPlugin == null) {
            return context.stopService(intent);
        }
        try {
            return b.a(queryServiceFromPlugin.processName).b(intent, str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void unbindServiceNative(ServiceConnection serviceConnection) {
        HashSet<ServiceInfo> hashSet = this.conn2Service.get(serviceConnection);
        if (hashSet != null) {
            Iterator<ServiceInfo> it = hashSet.iterator();
            while (it.hasNext()) {
                try {
                    b.a(it.next().processName).a(this.serviceConn2ServiceConn.get(serviceConnection));
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
