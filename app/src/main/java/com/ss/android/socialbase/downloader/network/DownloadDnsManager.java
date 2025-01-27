package com.ss.android.socialbase.downloader.network;

import android.os.Handler;
import com.ss.android.socialbase.downloader.network.connectionpool.DownloadPreconnecter;
import com.ss.android.socialbase.downloader.thread.DownloadWatchDog;
import com.ss.android.socialbase.downloader.utils.LruCache;
import java.net.InetAddress;
import java.util.List;

/* loaded from: classes4.dex */
public class DownloadDnsManager {
    private final LruCache<String, DnsRecord> cache;
    private final Handler cpuHandler;
    private final Handler networkHandler;

    /* renamed from: com.ss.android.socialbase.downloader.network.DownloadDnsManager$1 */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ Callback val$cb;
        final /* synthetic */ long val$timeout;
        final /* synthetic */ String val$url;

        public AnonymousClass1(String str, Callback callback, long j10) {
            str = str;
            callback = callback;
            j10 = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            DownloadDnsManager.this.resolveDns(str, callback, j10);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.network.DownloadDnsManager$2 */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ Callback val$cb;
        final /* synthetic */ DnsRecord val$recordFromCache;
        final /* synthetic */ String val$url;

        public AnonymousClass2(Callback callback, String str, DnsRecord dnsRecord) {
            r2 = callback;
            r3 = str;
            r4 = dnsRecord;
        }

        @Override // java.lang.Runnable
        public void run() {
            Callback callback = r2;
            if (callback != null) {
                String str = r3;
                DnsRecord dnsRecord = r4;
                callback.onDnsResolved(str, dnsRecord == null ? null : dnsRecord.value);
            }
        }
    }

    public interface Callback {
        void onDnsResolved(String str, List<InetAddress> list);
    }

    public static class DnsRecord {
        long timestamp;
        List<InetAddress> value;

        private DnsRecord() {
        }

        public /* synthetic */ DnsRecord(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static class Holder {
        private static final DownloadDnsManager INSTANCE = new DownloadDnsManager();

        private Holder() {
        }
    }

    public /* synthetic */ DownloadDnsManager(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static DownloadDnsManager getInstance() {
        return Holder.INSTANCE;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:1|2|a|(2:8|(1:(2:11|12)(1:14)))|15|(6:19|20|(3:36|37|38)|(3:28|29|(2:31|32)(1:33))|29|(0)(0))|45|(1:22)|36|37|38|(4:25|28|29|(0)(0))|29|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0089, code lost:
    
        r10 = r2.value;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0076, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0077, code lost:
    
        r11.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0092 A[Catch: all -> 0x003b, TRY_LEAVE, TryCatch #3 {all -> 0x003b, blocks: (B:2:0x0000, B:3:0x000a, B:8:0x0016, B:11:0x0035, B:15:0x003e, B:17:0x0055, B:22:0x0067, B:25:0x007c, B:28:0x0083, B:29:0x008b, B:31:0x0092, B:35:0x0089, B:36:0x006d, B:41:0x0077, B:44:0x0061, B:49:0x0098, B:20:0x005b, B:38:0x0071, B:5:0x000b, B:6:0x0013), top: B:1:0x0000, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void resolveDns(java.lang.String r8, com.ss.android.socialbase.downloader.network.DownloadDnsManager.Callback r9, long r10) {
        /*
            r7 = this;
            android.net.Uri r0 = android.net.Uri.parse(r8)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r0 = r0.getHost()     // Catch: java.lang.Throwable -> L3b
            com.ss.android.socialbase.downloader.utils.LruCache<java.lang.String, com.ss.android.socialbase.downloader.network.DownloadDnsManager$DnsRecord> r1 = r7.cache     // Catch: java.lang.Throwable -> L3b
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L3b
            com.ss.android.socialbase.downloader.utils.LruCache<java.lang.String, com.ss.android.socialbase.downloader.network.DownloadDnsManager$DnsRecord> r2 = r7.cache     // Catch: java.lang.Throwable -> L96
            java.lang.Object r2 = r2.get(r0)     // Catch: java.lang.Throwable -> L96
            com.ss.android.socialbase.downloader.network.DownloadDnsManager$DnsRecord r2 = (com.ss.android.socialbase.downloader.network.DownloadDnsManager.DnsRecord) r2     // Catch: java.lang.Throwable -> L96
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L96
            if (r2 == 0) goto L3e
            com.ss.android.socialbase.downloader.setting.DownloadSetting r1 = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal()     // Catch: java.lang.Throwable -> L3b
            java.lang.String r3 = "dns_expire_min"
            r4 = 10
            int r1 = r1.optInt(r3, r4)     // Catch: java.lang.Throwable -> L3b
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L3b
            long r5 = r2.timestamp     // Catch: java.lang.Throwable -> L3b
            long r3 = r3 - r5
            r5 = 60000(0xea60, float:8.4078E-41)
            int r1 = r1 * r5
            long r5 = (long) r1     // Catch: java.lang.Throwable -> L3b
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L3e
            if (r9 == 0) goto L3d
            java.util.List<java.net.InetAddress> r10 = r2.value     // Catch: java.lang.Throwable -> L3b
            r9.onDnsResolved(r8, r10)     // Catch: java.lang.Throwable -> L3b
            goto L3d
        L3b:
            r8 = move-exception
            goto L99
        L3d:
            return
        L3e:
            com.ss.android.socialbase.downloader.network.DownloadDnsManager$2 r1 = new com.ss.android.socialbase.downloader.network.DownloadDnsManager$2     // Catch: java.lang.Throwable -> L3b
            r1.<init>()     // Catch: java.lang.Throwable -> L3b
            android.os.Handler r3 = r7.cpuHandler     // Catch: java.lang.Throwable -> L3b
            r3.postDelayed(r1, r10)     // Catch: java.lang.Throwable -> L3b
            com.ss.android.socialbase.downloader.setting.DownloadSetting r10 = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal()     // Catch: java.lang.Throwable -> L3b
            java.lang.String r11 = "use_host_dns"
            r3 = 1
            int r10 = r10.optInt(r11, r3)     // Catch: java.lang.Throwable -> L3b
            if (r10 != r3) goto L64
            com.ss.android.socialbase.downloader.network.IDownloadDns r10 = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadDns()     // Catch: java.lang.Throwable -> L3b
            if (r10 == 0) goto L64
            java.util.List r10 = r10.lookup(r0)     // Catch: java.lang.Throwable -> L60
            goto L65
        L60:
            r10 = move-exception
            r10.printStackTrace()     // Catch: java.lang.Throwable -> L3b
        L64:
            r10 = 0
        L65:
            if (r10 == 0) goto L6d
            boolean r11 = r10.isEmpty()     // Catch: java.lang.Throwable -> L3b
            if (r11 == 0) goto L7a
        L6d:
            com.ss.android.socialbase.downloader.network.IDownloadDns r11 = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDefaultDownloadDns()     // Catch: java.lang.Throwable -> L3b
            java.util.List r10 = r11.lookup(r0)     // Catch: java.lang.Throwable -> L76
            goto L7a
        L76:
            r11 = move-exception
            r11.printStackTrace()     // Catch: java.lang.Throwable -> L3b
        L7a:
            if (r10 == 0) goto L87
            boolean r11 = r10.isEmpty()     // Catch: java.lang.Throwable -> L3b
            if (r11 == 0) goto L83
            goto L87
        L83:
            r7.updateIpAddressToCache(r0, r10)     // Catch: java.lang.Throwable -> L3b
            goto L8b
        L87:
            if (r2 == 0) goto L8b
            java.util.List<java.net.InetAddress> r10 = r2.value     // Catch: java.lang.Throwable -> L3b
        L8b:
            android.os.Handler r11 = r7.cpuHandler     // Catch: java.lang.Throwable -> L3b
            r11.removeCallbacks(r1)     // Catch: java.lang.Throwable -> L3b
            if (r9 == 0) goto L9c
            r9.onDnsResolved(r8, r10)     // Catch: java.lang.Throwable -> L3b
            goto L9c
        L96:
            r8 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L96
            throw r8     // Catch: java.lang.Throwable -> L3b
        L99:
            r8.printStackTrace()
        L9c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.network.DownloadDnsManager.resolveDns(java.lang.String, com.ss.android.socialbase.downloader.network.DownloadDnsManager$Callback, long):void");
    }

    private void updateIpAddressToCache(String str, List<InetAddress> list) {
        synchronized (this.cache) {
            try {
                DnsRecord dnsRecord = this.cache.get(str);
                if (dnsRecord == null) {
                    dnsRecord = new DnsRecord();
                    this.cache.put(str, dnsRecord);
                }
                dnsRecord.value = list;
                dnsRecord.timestamp = System.currentTimeMillis();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void resolveDnsAsync(String str, Callback callback, long j10) {
        this.networkHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.DownloadDnsManager.1
            final /* synthetic */ Callback val$cb;
            final /* synthetic */ long val$timeout;
            final /* synthetic */ String val$url;

            public AnonymousClass1(String str2, Callback callback2, long j102) {
                str = str2;
                callback = callback2;
                j10 = j102;
            }

            @Override // java.lang.Runnable
            public void run() {
                DownloadDnsManager.this.resolveDns(str, callback, j10);
            }
        });
    }

    private DownloadDnsManager() {
        this.cache = new LruCache<>(4, 16, false);
        this.networkHandler = new Handler(DownloadPreconnecter.getLooper());
        this.cpuHandler = new Handler(DownloadWatchDog.getThreadLooper());
    }
}
