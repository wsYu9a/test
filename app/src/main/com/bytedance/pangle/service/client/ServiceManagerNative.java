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
import com.bytedance.pangle.e;
import com.bytedance.pangle.g;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.servermanager.b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

@Keep
/* loaded from: classes2.dex */
public class ServiceManagerNative {
    private static volatile ServiceManagerNative sInstance;
    private final HashMap<ServiceConnection, g> serviceConn2ServiceConn = new HashMap<>();
    public HashMap<IBinder, HashMap<ServiceConnection, HashSet<ComponentName>>> process2ConnAndService = new HashMap<>();
    private HashMap<ServiceConnection, HashSet<ServiceInfo>> conn2Service = new HashMap<>();

    /* renamed from: com.bytedance.pangle.service.client.ServiceManagerNative$1 */
    public class AnonymousClass1 extends g.a {

        /* renamed from: a */
        final /* synthetic */ ServiceConnection f7827a;

        public AnonymousClass1(ServiceConnection serviceConnection) {
            serviceConnection = serviceConnection;
        }

        @Override // com.bytedance.pangle.g
        public final void a(ComponentName componentName, IBinder iBinder) {
            serviceConnection.onServiceConnected(componentName, iBinder);
        }

        @Override // com.bytedance.pangle.g
        public final int a() {
            return serviceConnection.hashCode();
        }
    }

    private ServiceManagerNative() {
    }

    public static ServiceManagerNative getInstance() {
        if (sInstance == null) {
            synchronized (ServiceManagerNative.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new ServiceManagerNative();
                    }
                } finally {
                }
            }
        }
        return sInstance;
    }

    public boolean bindServiceNative(Context context, Intent intent, ServiceConnection serviceConnection, int i10, String str) {
        ServiceInfo queryServiceFromPlugin = queryServiceFromPlugin(intent, str);
        if (queryServiceFromPlugin == null) {
            return context.bindService(intent, serviceConnection, i10);
        }
        if (!this.serviceConn2ServiceConn.containsKey(serviceConnection)) {
            this.serviceConn2ServiceConn.put(serviceConnection, new g.a() { // from class: com.bytedance.pangle.service.client.ServiceManagerNative.1

                /* renamed from: a */
                final /* synthetic */ ServiceConnection f7827a;

                public AnonymousClass1(ServiceConnection serviceConnection2) {
                    serviceConnection = serviceConnection2;
                }

                @Override // com.bytedance.pangle.g
                public final void a(ComponentName componentName, IBinder iBinder) {
                    serviceConnection.onServiceConnected(componentName, iBinder);
                }

                @Override // com.bytedance.pangle.g
                public final int a() {
                    return serviceConnection.hashCode();
                }
            });
        }
        if (this.conn2Service.get(serviceConnection2) == null) {
            this.conn2Service.put(serviceConnection2, new HashSet<>());
        }
        this.conn2Service.get(serviceConnection2).add(queryServiceFromPlugin);
        e a10 = b.a(queryServiceFromPlugin.processName);
        IBinder asBinder = a10.asBinder();
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
            return a10.a(intent, this.serviceConn2ServiceConn.get(serviceConnection2), i10, str);
        } catch (RemoteException e10) {
            ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "bindService failed!", e10);
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
        } catch (RemoteException e10) {
            e10.printStackTrace();
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
        } catch (RemoteException e10) {
            e10.printStackTrace();
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
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                }
            }
        }
    }
}
