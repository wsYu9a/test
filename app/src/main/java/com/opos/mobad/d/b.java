package com.opos.mobad.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.opos.mobad.service.DownloadService;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private static volatile b f20437a = null;

    /* renamed from: b */
    private static final byte[] f20438b = new byte[0];

    /* renamed from: g */
    private static int f20439g = 3;

    /* renamed from: h */
    private static boolean f20440h = true;

    /* renamed from: c */
    private Messenger f20441c;

    /* renamed from: d */
    private Context f20442d;

    /* renamed from: e */
    private ConcurrentHashMap<String, com.opos.mobad.d.b.a> f20443e = new ConcurrentHashMap<>();

    /* renamed from: f */
    private List<com.opos.mobad.d.b.a> f20444f = new CopyOnWriteArrayList();

    /* renamed from: i */
    private boolean f20445i = false;

    /* renamed from: j */
    private int f20446j = 0;
    private Messenger k = new Messenger(new Handler(Looper.getMainLooper()) { // from class: com.opos.mobad.d.b.1
        AnonymousClass1(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null || message.getData() == null) {
                return;
            }
            Bundle data = message.getData();
            int i2 = message.what;
            int i3 = data.getInt("key_percent");
            String string = data.getString("key_server_url");
            switch (i2) {
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                case 107:
                    b.this.a(i2, i3, string);
                    break;
                case 106:
                    b.this.a(i2, i3, string, data.getString(Constants.KEY_ERROR_CODE));
                    break;
            }
        }
    });
    private ServiceConnection l = new ServiceConnection() { // from class: com.opos.mobad.d.b.2
        AnonymousClass2() {
        }

        private void a() {
            for (com.opos.mobad.d.b.a aVar : new ArrayList(b.this.f20443e.values())) {
                int i2 = aVar.f20454f;
                if (i2 == 102 || i2 == 107) {
                    b.this.a(aVar);
                }
            }
        }

        private void b() {
            com.opos.cmn.an.f.a.b("DownloaderMgr", "addDownloaderDelay mDelayDownloadTaskList size:" + b.this.f20444f.size());
            try {
                if (b.this.f20444f == null || b.this.f20444f.size() <= 0) {
                    return;
                }
                com.opos.mobad.d.b.a[] aVarArr = (com.opos.mobad.d.b.a[]) b.this.f20444f.toArray(new com.opos.mobad.d.b.a[b.this.f20444f.size()]);
                b.this.f20444f.removeAll(Arrays.asList(aVarArr));
                for (com.opos.mobad.d.b.a aVar : aVarArr) {
                    b.this.a(aVar);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.b("DownloaderMgr", "addDownloaderDelay error", e2);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.opos.cmn.an.f.a.b("DownloaderMgr", "onServiceConnected");
            b.this.f20441c = new Messenger(iBinder);
            b();
            a();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            com.opos.cmn.an.f.a.b("DownloaderMgr", "onServiceDisconnected");
            b.this.f20441c = null;
            if (b.a(b.this) < 3) {
                b.this.d();
            }
        }
    };

    /* renamed from: com.opos.mobad.d.b$1 */
    class AnonymousClass1 extends Handler {
        AnonymousClass1(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null || message.getData() == null) {
                return;
            }
            Bundle data = message.getData();
            int i2 = message.what;
            int i3 = data.getInt("key_percent");
            String string = data.getString("key_server_url");
            switch (i2) {
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                case 107:
                    b.this.a(i2, i3, string);
                    break;
                case 106:
                    b.this.a(i2, i3, string, data.getString(Constants.KEY_ERROR_CODE));
                    break;
            }
        }
    }

    /* renamed from: com.opos.mobad.d.b$2 */
    class AnonymousClass2 implements ServiceConnection {
        AnonymousClass2() {
        }

        private void a() {
            for (com.opos.mobad.d.b.a aVar : new ArrayList(b.this.f20443e.values())) {
                int i2 = aVar.f20454f;
                if (i2 == 102 || i2 == 107) {
                    b.this.a(aVar);
                }
            }
        }

        private void b() {
            com.opos.cmn.an.f.a.b("DownloaderMgr", "addDownloaderDelay mDelayDownloadTaskList size:" + b.this.f20444f.size());
            try {
                if (b.this.f20444f == null || b.this.f20444f.size() <= 0) {
                    return;
                }
                com.opos.mobad.d.b.a[] aVarArr = (com.opos.mobad.d.b.a[]) b.this.f20444f.toArray(new com.opos.mobad.d.b.a[b.this.f20444f.size()]);
                b.this.f20444f.removeAll(Arrays.asList(aVarArr));
                for (com.opos.mobad.d.b.a aVar : aVarArr) {
                    b.this.a(aVar);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.b("DownloaderMgr", "addDownloaderDelay error", e2);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.opos.cmn.an.f.a.b("DownloaderMgr", "onServiceConnected");
            b.this.f20441c = new Messenger(iBinder);
            b();
            a();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            com.opos.cmn.an.f.a.b("DownloaderMgr", "onServiceDisconnected");
            b.this.f20441c = null;
            if (b.a(b.this) < 3) {
                b.this.d();
            }
        }
    }

    private b(Context context) {
        this.f20442d = context.getApplicationContext();
    }

    static /* synthetic */ int a(b bVar) {
        int i2 = bVar.f20446j;
        bVar.f20446j = i2 + 1;
        return i2;
    }

    public static b a(Context context) {
        b bVar = f20437a;
        if (bVar == null) {
            synchronized (f20438b) {
                bVar = f20437a;
                if (bVar == null) {
                    bVar = new b(context);
                    f20437a = bVar;
                }
            }
        }
        return bVar;
    }

    public void a(int i2, int i3, String str) {
        a(i2, i3, str, (String) null);
    }

    public void a(int i2, int i3, String str, String str2) {
        ConcurrentHashMap<String, com.opos.mobad.d.b.a> concurrentHashMap;
        com.opos.mobad.d.b.a aVar;
        com.opos.cmn.an.f.a.b("DownloaderMgr", "client status:" + i2 + ",percent:" + i3 + ",url:" + str);
        if (TextUtils.isEmpty(str) || (concurrentHashMap = this.f20443e) == null || (aVar = concurrentHashMap.get(str)) == null) {
            return;
        }
        switch (i2) {
            case 101:
                aVar.f20454f = 101;
                aVar.f20455g = i3;
                Set<e> set = aVar.f20453e;
                if (set == null || set.size() <= 0) {
                    return;
                }
                for (e eVar : aVar.f20453e) {
                    if (eVar != null) {
                        eVar.a(i2, i3, str, aVar.f20450b);
                    }
                }
                return;
            case 102:
                aVar.f20454f = 102;
                aVar.f20455g = i3;
                Set<e> set2 = aVar.f20453e;
                if (set2 == null || set2.size() <= 0) {
                    return;
                }
                for (e eVar2 : aVar.f20453e) {
                    if (eVar2 != null) {
                        eVar2.b(i2, i3, str, aVar.f20450b);
                    }
                }
                return;
            case 103:
                aVar.f20454f = 103;
                aVar.f20455g = i3;
                Set<e> set3 = aVar.f20453e;
                if (set3 == null || set3.size() <= 0) {
                    return;
                }
                for (e eVar3 : aVar.f20453e) {
                    if (eVar3 != null) {
                        eVar3.d(i2, i3, str, aVar.f20450b);
                    }
                }
                return;
            case 104:
                aVar.f20454f = 104;
                aVar.f20455g = i3;
                Set<e> set4 = aVar.f20453e;
                if (set4 != null && set4.size() > 0) {
                    for (e eVar4 : aVar.f20453e) {
                        if (eVar4 != null) {
                            eVar4.e(i2, i3, str, aVar.f20450b);
                        }
                    }
                    aVar.f20453e.clear();
                    break;
                }
                break;
            case 105:
                aVar.f20454f = 105;
                aVar.f20455g = i3;
                Set<e> set5 = aVar.f20453e;
                if (set5 != null && set5.size() > 0) {
                    for (e eVar5 : aVar.f20453e) {
                        if (eVar5 != null) {
                            eVar5.f(i2, i3, str, aVar.f20450b);
                        }
                    }
                    break;
                }
                break;
            case 106:
                aVar.f20454f = 106;
                aVar.f20455g = i3;
                Set<e> set6 = aVar.f20453e;
                if (set6 == null || set6.size() <= 0) {
                    return;
                }
                for (e eVar6 : aVar.f20453e) {
                    if (eVar6 != null) {
                        eVar6.a(i2, i3, str, aVar.f20450b, str2);
                    }
                }
                return;
            case 107:
                aVar.f20454f = 107;
                aVar.f20455g = i3;
                Set<e> set7 = aVar.f20453e;
                if (set7 == null || set7.size() <= 0) {
                    return;
                }
                for (e eVar7 : aVar.f20453e) {
                    if (eVar7 != null) {
                        eVar7.c(i2, i3, str, aVar.f20450b);
                    }
                }
                return;
            default:
                return;
        }
        this.f20443e.remove(str);
    }

    public boolean a(com.opos.mobad.d.b.a aVar) {
        boolean a2 = (aVar == null || com.opos.cmn.an.c.a.a(aVar.f20452d) || com.opos.cmn.an.c.a.a(aVar.f20450b)) ? false : a(aVar.f20452d, aVar.f20450b, aVar.f20451c, aVar.f20449a);
        com.opos.cmn.an.f.a.b("DownloaderMgr", "addDownloader result:" + a2 + ", downloadData:" + aVar);
        return a2;
    }

    private boolean a(String str, String str2, String str3, String str4) {
        com.opos.cmn.an.f.a.b("DownloaderMgr", "addDownloader pkgName:" + str2 + ",url:" + str + ",md5:" + str3 + ",appName:" + str4);
        boolean z = true;
        if (!com.opos.cmn.an.c.a.a(str) && !com.opos.cmn.an.c.a.a(str2) && this.f20441c != null) {
            try {
                Message obtain = Message.obtain();
                obtain.what = 1;
                Bundle bundle = new Bundle();
                bundle.putString("key_url", str);
                bundle.putString("key_pkg_name", str2);
                if (!TextUtils.isEmpty(str3)) {
                    bundle.putString("key_apk_md5", str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    bundle.putString("key_app_name", str4);
                }
                obtain.setData(bundle);
                obtain.replyTo = this.k;
                this.f20441c.send(obtain);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("DownloaderMgr", "", (Throwable) e2);
            }
            com.opos.cmn.an.f.a.b("DownloaderMgr", "addDownloader mUrlToDownloadDataMap:" + this.f20443e.size());
            return z;
        }
        z = false;
        com.opos.cmn.an.f.a.b("DownloaderMgr", "addDownloader mUrlToDownloadDataMap:" + this.f20443e.size());
        return z;
    }

    private void b() {
        boolean z;
        Iterator it = new ArrayList(this.f20443e.values()).iterator();
        while (it.hasNext()) {
            int i2 = ((com.opos.mobad.d.b.a) it.next()).f20454f;
            if (i2 == 102 || i2 == 107 || i2 == 101 || i2 == 106 || i2 == 103) {
                z = false;
                break;
            }
        }
        z = true;
        if (z) {
            c();
        }
        com.opos.cmn.an.f.a.b("DownloaderMgr", "unBindServiceIfNeed canUnbind:" + z);
    }

    private void c() {
        ServiceConnection serviceConnection;
        if (this.f20441c != null) {
            try {
                Message obtain = Message.obtain();
                obtain.what = 7;
                obtain.replyTo = this.k;
                try {
                    this.f20441c.send(obtain);
                } catch (RemoteException e2) {
                    com.opos.cmn.an.f.a.b("DownloaderMgr", "", e2);
                }
                Context context = this.f20442d;
                if (context != null && (serviceConnection = this.l) != null) {
                    context.unbindService(serviceConnection);
                }
                this.f20441c = null;
                com.opos.cmn.an.f.a.b("DownloaderMgr", "task download mgr ,unBindService");
            } catch (Exception e3) {
                com.opos.cmn.an.f.a.a("DownloaderMgr", "", (Throwable) e3);
            }
        }
    }

    public void d() {
        Intent intent = new Intent(this.f20442d, (Class<?>) DownloadService.class);
        intent.putExtra("key_action_type", 0);
        intent.putExtra("key_download_tasks", f20439g);
        intent.putExtra("key_show_notification", f20440h);
        this.f20442d.startService(intent);
        this.f20442d.bindService(intent, this.l, 1);
    }

    public void a() {
        try {
            if (this.f20442d == null || this.l == null) {
                return;
            }
            c();
            ConcurrentHashMap<String, com.opos.mobad.d.b.a> concurrentHashMap = this.f20443e;
            if (concurrentHashMap != null) {
                concurrentHashMap.clear();
            }
            List<com.opos.mobad.d.b.a> list = this.f20444f;
            if (list != null) {
                list.clear();
            }
        } catch (Exception unused) {
        }
    }

    public void a(int i2, boolean z) {
        if (this.f20445i) {
            return;
        }
        com.opos.cmn.an.f.a.b("DownloaderMgr", "set nums =" + i2 + ", show notification =" + z);
        f20439g = i2;
        f20440h = z;
        this.f20445i = true;
    }

    public void a(e eVar) {
        if (eVar != null) {
            for (com.opos.mobad.d.b.a aVar : this.f20443e.values()) {
                if (aVar != null) {
                    aVar.b(eVar);
                    com.opos.cmn.an.f.a.b("DownloaderMgr", "removeDownloadListener");
                    return;
                }
            }
        }
    }

    public void a(String str) {
        com.opos.cmn.an.f.a.b("DownloaderMgr", "pauseDownloader url:" + str);
        if (com.opos.cmn.an.c.a.a(str) || this.f20441c == null) {
            return;
        }
        try {
            Message obtain = Message.obtain();
            obtain.what = 2;
            Bundle bundle = new Bundle();
            bundle.putString("key_url", str);
            obtain.setData(bundle);
            this.f20441c.send(obtain);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("DownloaderMgr", "", (Throwable) e2);
        }
    }

    public void a(String str, String str2, String str3, String str4, e eVar) {
        com.opos.mobad.d.b.a aVar;
        if (com.opos.cmn.an.c.a.a(str) || com.opos.cmn.an.c.a.a(str2)) {
            return;
        }
        if (this.f20443e.containsKey(str)) {
            aVar = this.f20443e.get(str);
            if (aVar != null) {
                aVar.a(eVar);
            }
        } else {
            com.opos.mobad.d.b.a aVar2 = new com.opos.mobad.d.b.a(str, str4, str2, str3);
            aVar2.a(eVar);
            this.f20443e.put(str, aVar2);
            aVar = aVar2;
        }
        if (this.f20441c == null) {
            d();
            this.f20444f.add(aVar);
        } else {
            a(aVar);
        }
        this.f20446j = 0;
    }

    public int[] a(String str, String str2) {
        com.opos.mobad.d.b.a aVar;
        int[] iArr = new int[2];
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (aVar = this.f20443e.get(str)) != null) {
            iArr[0] = aVar.f20454f;
            iArr[1] = aVar.f20455g;
        }
        com.opos.cmn.an.f.a.b("DownloaderMgr", "queryDownload status:" + iArr[0] + ",percent:" + iArr[1]);
        return iArr;
    }

    public void b(String str) {
        com.opos.cmn.an.f.a.b("DownloaderMgr", "cancelDownloader url:" + str);
        if (com.opos.cmn.an.c.a.a(str) || this.f20441c == null) {
            return;
        }
        try {
            Message obtain = Message.obtain();
            obtain.what = 4;
            Bundle bundle = new Bundle();
            bundle.putString("key_url", str);
            obtain.setData(bundle);
            this.f20441c.send(obtain);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("DownloaderMgr", "", (Throwable) e2);
        }
    }

    public void c(String str) {
        com.opos.cmn.an.f.a.b("DownloaderMgr", "notifyInstallEvent pkgName:" + str);
        if (com.opos.cmn.an.c.a.a(str) || this.f20441c == null) {
            return;
        }
        try {
            Message obtain = Message.obtain();
            obtain.what = 5;
            Bundle bundle = new Bundle();
            bundle.putString("key_pkg_name", str);
            obtain.setData(bundle);
            this.f20441c.send(obtain);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("DownloaderMgr", "", (Throwable) e2);
        }
        b();
    }
}
