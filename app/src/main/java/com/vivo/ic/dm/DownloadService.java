package com.vivo.ic.dm;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Service;
import android.content.Intent;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import androidx.core.app.NotificationCompat;
import com.vivo.ic.VLog;
import com.vivo.ic.dm.DownloadInfo;
import com.vivo.ic.dm.Downloads;
import com.vivo.ic.dm.impl.DownloadNotification;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public class DownloadService extends Service {

    /* renamed from: a */
    public static final String f28374a = "STATUS";

    /* renamed from: b */
    public static final int f28375b = 1;

    /* renamed from: c */
    public static final int f28376c = 2;

    /* renamed from: e */
    private static final int f28378e = 1;

    /* renamed from: f */
    private static final int f28379f = 2;

    /* renamed from: g */
    private static final int f28380g = 0;

    /* renamed from: h */
    private static final int f28381h = -1;
    private AlarmManager m;
    private DownloadNotification n;
    private c o;
    private HandlerThread p;
    private Handler q;

    /* renamed from: d */
    private static final String f28377d = Constants.PRE_TAG + "DownloadService";

    /* renamed from: i */
    @SuppressLint({"UseSparseArrays"})
    private static final HashMap<Long, DownloadInfo> f28382i = new HashMap<>();

    /* renamed from: j */
    private static final List<DownloadInfo> f28383j = new ArrayList();
    private final ExecutorService k = com.vivo.ic.dm.q.d.b().a();
    private volatile int l = 0;
    private Map<Messenger, Messenger> r = new ConcurrentHashMap();
    private Handler.Callback s = new a();

    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            boolean f2;
            Process.setThreadPriority(10);
            int i2 = message.arg1;
            synchronized (DownloadService.f28382i) {
                f2 = DownloadService.this.f();
            }
            if (message.what == 2) {
                for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                    if (entry.getKey().getName().startsWith("pool")) {
                        VLog.w(DownloadService.f28377d, "Final update pass !!! " + entry.getKey() + ": " + Arrays.toString(entry.getValue()));
                    }
                }
                VLog.w(DownloadService.f28377d, "Final update pass triggered, isActive=" + f2 + "; someone didn't update correctly.");
            }
            if (f2) {
                DownloadService.this.d();
                return true;
            }
            if (i2 != -1) {
                if (!DownloadService.this.stopSelfResult(i2)) {
                    return true;
                }
                VLog.v(DownloadService.f28377d, "Nothing left; stopped");
                DownloadService.this.getContentResolver().unregisterContentObserver(DownloadService.this.o);
                DownloadService.this.p.quit();
                return true;
            }
            VLog.v(DownloadService.f28377d, "Nothing stopped by self");
            for (Messenger messenger : DownloadService.this.r.keySet()) {
                Message message2 = new Message();
                message2.what = 2;
                try {
                    Messenger messenger2 = (Messenger) DownloadService.this.r.get(messenger);
                    if (messenger2 != null) {
                        messenger2.send(message2);
                    }
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
            DownloadService.this.r.clear();
            return true;
        }
    }

    private class b implements IBinder.DeathRecipient {

        /* renamed from: a */
        private Messenger f28385a;

        public b(Messenger messenger) {
            this.f28385a = messenger;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Messenger messenger = (Messenger) DownloadService.this.r.remove(this.f28385a);
            VLog.i(DownloadService.f28377d, "binderDied " + messenger);
        }
    }

    private class c extends ContentObserver {
        public c() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            DownloadService.this.e();
        }
    }

    private class d extends Handler {

        /* renamed from: a */
        private Messenger f28388a;

        public d(Looper looper) {
            super(looper);
        }

        public void a(Messenger messenger) {
            this.f28388a = messenger;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                Messenger messenger = message.replyTo;
                if (messenger != null) {
                    DownloadService.this.r.put(this.f28388a, messenger);
                    VLog.d(DownloadService.f28377d, "add success " + this.f28388a + " ; reply " + messenger + ";size " + DownloadService.this.r.size());
                } else {
                    VLog.d(DownloadService.f28377d, "add error messenger is null");
                }
                DownloadService.this.e();
            }
            super.handleMessage(message);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x02be: MOVE (r14 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]), block:B:130:0x02be */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x00f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0129 A[LOOP:1: B:30:0x0123->B:32:0x0129, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0268 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean f() {
        /*
            Method dump skipped, instructions count: 715
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.ic.dm.DownloadService.f():boolean");
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (!l.j().s()) {
            throw new UnsupportedOperationException("Cannot bind to Download Manager Service");
        }
        VLog.v(f28377d, "Service onBind ");
        this.l = -1;
        return c();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        String str = f28377d;
        VLog.d(str, "DownloadService onCreate");
        this.m = (AlarmManager) getSystemService(NotificationCompat.CATEGORY_ALARM);
        this.n = l.j().m();
        VLog.d(str, "DownloadService onCreate mNotifier:" + this.n);
        this.o = new c();
        getContentResolver().registerContentObserver(Downloads.Impl.CONTENT_URI, true, this.o);
        HandlerThread handlerThread = new HandlerThread(str + "-UpdateThread");
        this.p = handlerThread;
        handlerThread.start();
        this.q = new Handler(this.p.getLooper(), this.s);
        com.vivo.ic.dm.p.a.b().e(getApplicationContext());
        com.vivo.ic.dm.p.a.a().e(getApplicationContext());
    }

    @Override // android.app.Service
    public void onDestroy() {
        getContentResolver().unregisterContentObserver(this.o);
        this.q.removeCallbacksAndMessages(null);
        this.p.quit();
        this.r.clear();
        VLog.v(f28377d, "Service onDestroy");
        com.vivo.ic.dm.network.c.a();
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        if (l.j().s()) {
            throw new UnsupportedOperationException("Cannot start to Download Manager Service");
        }
        this.l = i3;
        e();
        return 2;
    }

    private IBinder c() {
        d dVar = new d(Looper.getMainLooper());
        Messenger messenger = new Messenger(dVar);
        dVar.a(messenger);
        IBinder binder = messenger.getBinder();
        try {
            binder.linkToDeath(new b(messenger), 0);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
        return binder;
    }

    public void d() {
        Handler handler = this.q;
        if (handler != null) {
            handler.removeMessages(2);
            Handler handler2 = this.q;
            handler2.sendMessageDelayed(handler2.obtainMessage(2, this.l, -1), com.alipay.mobilesecuritysdk.constant.a.k);
        }
    }

    public void e() {
        Handler handler = this.q;
        if (handler != null) {
            handler.removeMessages(1);
            this.q.obtainMessage(1, this.l, -1).sendToTarget();
        }
    }

    private void a(DownloadInfo downloadInfo) {
        boolean isDownloadingByUI = downloadInfo.isDownloadingByUI();
        if (isDownloadingByUI) {
            List<DownloadInfo> list = f28383j;
            if (list.contains(downloadInfo)) {
                return;
            }
            list.add(downloadInfo);
            return;
        }
        VLog.d(f28377d, "checkIsAllowDownloading del id:" + isDownloadingByUI);
        f28383j.remove(downloadInfo);
    }

    public static boolean b(long j2) {
        DownloadInfo downloadInfo = f28382i.get(Long.valueOf(j2));
        return downloadInfo != null && downloadInfo.getStatus() == 192;
    }

    private void a(DownloadInfo.Reader reader, DownloadInfo downloadInfo) {
        reader.updateFromDatabase(downloadInfo);
    }

    private DownloadInfo a(DownloadInfo.Reader reader) {
        DownloadInfo newDownloadInfo = reader.newDownloadInfo(this);
        f28382i.put(Long.valueOf(newDownloadInfo.getId()), newDownloadInfo);
        VLog.d(f28377d, "processing inserted download " + newDownloadInfo.getId());
        return newDownloadInfo;
    }

    private void a(long j2) {
        VLog.d(f28377d, "deleteDownloadLocked of id:" + j2);
        HashMap<Long, DownloadInfo> hashMap = f28382i;
        DownloadInfo downloadInfo = hashMap.get(Long.valueOf(j2));
        if (downloadInfo != null) {
            if (downloadInfo.getStatus() == 192) {
                downloadInfo.setStatus(Downloads.Impl.STATUS_CANCELED);
            }
            hashMap.remove(Long.valueOf(downloadInfo.getId()));
            f28383j.remove(downloadInfo);
        }
    }
}
