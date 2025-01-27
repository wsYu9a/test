package com.tencent.bugly.proguard;

import android.text.TextUtils;
import com.tencent.bugly.beta.download.BetaReceiver;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.ui.BetaNotifyManager;
import java.io.File;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.tencent.bugly.proguard.w */
/* loaded from: classes4.dex */
public class RunnableC0918w extends DownloadTask implements Runnable {
    private File k;
    public long l;
    private long m;

    public RunnableC0918w(String str, String str2, long j2, long j3, String str3) {
        super(str, "", "", str3);
        this.l = 0L;
        this.m = 0L;
        File file = new File(str2);
        this.k = file;
        this.f24593b = file.getParent();
        this.f24594c = this.k.getName();
        this.f24596e = j2;
        this.f24597f = j3;
        getStatus();
    }

    private String a(HttpURLConnection httpURLConnection) {
        List<String> list;
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (!TextUtils.isEmpty(this.f24594c)) {
            return this.f24594c;
        }
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        if (headerFields != null) {
            for (String str : headerFields.keySet()) {
                if (str != null && (list = headerFields.get(str)) != null) {
                    for (String str2 : list) {
                        if (str2 != null && "content-disposition".equals(str.toLowerCase())) {
                            Matcher matcher = Pattern.compile(".*filename=(.*)").matcher(str2.toLowerCase());
                            if (matcher.find()) {
                                return matcher.group(1);
                            }
                        }
                    }
                }
            }
        }
        String substring = getDownloadUrl().substring(getDownloadUrl().lastIndexOf(47) + 1);
        if (!TextUtils.isEmpty(substring)) {
            return substring;
        }
        return UUID.randomUUID() + ".apk";
    }

    protected void b() {
        this.l += System.currentTimeMillis() - this.m;
        C0912p.f25111a.b(this);
        this.m = System.currentTimeMillis();
        BetaNotifyManager.instance.postDownloadNotify();
        com.tencent.bugly.beta.utils.e.a(new com.tencent.bugly.beta.global.d(9, this.f24595d, this));
    }

    @Override // com.tencent.bugly.beta.download.DownloadTask
    public void delete(boolean z) {
        stop();
        if (z) {
            if (getSaveFile() != null && getSaveFile().exists() && !getSaveFile().isDirectory()) {
                getSaveFile().delete();
            }
            C0912p.f25111a.a(this);
        }
        BetaReceiver.netListeners.remove(getDownloadUrl());
        this.f24594c = null;
        this.f24596e = 0L;
        this.f24597f = 0L;
        this.f24600i = 4;
    }

    @Override // com.tencent.bugly.beta.download.DownloadTask
    public void download() {
        if (getStatus() == 1) {
            a();
            return;
        }
        if (getStatus() == 2) {
            return;
        }
        if (getSaveFile() == null || !getSaveFile().exists()) {
            this.f24596e = 0L;
            this.f24597f = 0L;
            this.l = 0L;
        } else {
            this.f24596e = getSaveFile().length();
        }
        if (this.f24598g) {
            BetaNotifyManager.instance.initNotify(this);
        }
        this.m = System.currentTimeMillis();
        this.f24600i = 2;
        C0917v.f25173a.f25174b.put(getDownloadUrl(), this);
        C0917v.f25173a.a(this);
    }

    @Override // com.tencent.bugly.beta.download.DownloadTask
    public long getCostTime() {
        return this.l;
    }

    @Override // com.tencent.bugly.beta.download.DownloadTask
    public File getSaveFile() {
        return this.k;
    }

    @Override // com.tencent.bugly.beta.download.DownloadTask
    public int getStatus() {
        if (getSaveFile() != null && getSaveFile().exists() && getSaveFile().length() == this.f24597f && !C0917v.f25173a.f25174b.contains(this)) {
            this.f24596e = this.f24597f;
            this.f24600i = 1;
        }
        if (getSaveFile() != null && getSaveFile().exists() && getSaveFile().length() > 0 && getSaveFile().length() < this.f24597f && !C0917v.f25173a.f25174b.contains(this)) {
            this.f24596e = getSaveFile().length();
            this.f24600i = 3;
        }
        if ((getSaveFile() == null || !getSaveFile().exists()) && !C0917v.f25173a.f25174b.contains(this)) {
            this.f24600i = 0;
        }
        return this.f24600i;
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x0159 A[Catch: Exception -> 0x012f, all -> 0x0170, TryCatch #4 {Exception -> 0x012f, blocks: (B:36:0x0097, B:81:0x00e0, B:66:0x011a, B:91:0x012a, B:133:0x0159, B:134:0x015c, B:111:0x0151, B:96:0x0164), top: B:110:0x0151, outer: #1 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.RunnableC0918w.run():void");
    }

    @Override // com.tencent.bugly.beta.download.DownloadTask
    public void stop() {
        if (this.f24600i != 5) {
            this.f24600i = 3;
        }
    }

    public RunnableC0918w(String str, String str2, String str3, String str4) {
        super(str, str2, str3, str4);
        this.l = 0L;
        this.m = 0L;
        getStatus();
    }

    protected void a(int i2, String str) {
        this.f24600i = 5;
        BetaNotifyManager.instance.postDownloadNotify();
        C0917v.f25173a.f25174b.remove(getDownloadUrl());
        com.tencent.bugly.beta.utils.e.a(new com.tencent.bugly.beta.global.d(10, this.f24595d, this, Integer.valueOf(i2), str));
    }

    protected void a() {
        this.f24600i = 1;
        b();
        C0917v.f25173a.f25174b.remove(getDownloadUrl());
        BetaReceiver.netListeners.remove(getDownloadUrl());
        com.tencent.bugly.beta.utils.e.a(new com.tencent.bugly.beta.global.d(8, this.f24595d, this));
    }
}
