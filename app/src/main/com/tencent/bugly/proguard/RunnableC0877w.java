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
public class RunnableC0877w extends DownloadTask implements Runnable {

    /* renamed from: k */
    private File f22885k;

    /* renamed from: l */
    public long f22886l;

    /* renamed from: m */
    private long f22887m;

    public RunnableC0877w(String str, String str2, long j10, long j11, String str3) {
        super(str, "", "", str3);
        this.f22886l = 0L;
        this.f22887m = 0L;
        File file = new File(str2);
        this.f22885k = file;
        this.f22072b = file.getParent();
        this.f22073c = this.f22885k.getName();
        this.f22075e = j10;
        this.f22076f = j11;
        getStatus();
    }

    private String a(HttpURLConnection httpURLConnection) {
        List<String> list;
        try {
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        if (!TextUtils.isEmpty(this.f22073c)) {
            return this.f22073c;
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

    public void b() {
        this.f22886l += System.currentTimeMillis() - this.f22887m;
        C0871p.f22799a.b(this);
        this.f22887m = System.currentTimeMillis();
        BetaNotifyManager.instance.postDownloadNotify();
        com.tencent.bugly.beta.utils.e.a(new com.tencent.bugly.beta.global.d(9, this.f22074d, this));
    }

    @Override // com.tencent.bugly.beta.download.DownloadTask
    public void delete(boolean z10) {
        stop();
        if (z10) {
            if (getSaveFile() != null && getSaveFile().exists() && !getSaveFile().isDirectory()) {
                getSaveFile().delete();
            }
            C0871p.f22799a.a(this);
        }
        BetaReceiver.netListeners.remove(getDownloadUrl());
        this.f22073c = null;
        this.f22075e = 0L;
        this.f22076f = 0L;
        this.f22079i = 4;
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
            this.f22075e = 0L;
            this.f22076f = 0L;
            this.f22886l = 0L;
        } else {
            this.f22075e = getSaveFile().length();
        }
        if (this.f22077g) {
            BetaNotifyManager.instance.initNotify(this);
        }
        this.f22887m = System.currentTimeMillis();
        this.f22079i = 2;
        C0876v.f22882a.f22883b.put(getDownloadUrl(), this);
        C0876v.f22882a.a(this);
    }

    @Override // com.tencent.bugly.beta.download.DownloadTask
    public long getCostTime() {
        return this.f22886l;
    }

    @Override // com.tencent.bugly.beta.download.DownloadTask
    public File getSaveFile() {
        return this.f22885k;
    }

    @Override // com.tencent.bugly.beta.download.DownloadTask
    public int getStatus() {
        if (getSaveFile() != null && getSaveFile().exists() && getSaveFile().length() == this.f22076f && !C0876v.f22882a.f22883b.contains(this)) {
            this.f22075e = this.f22076f;
            this.f22079i = 1;
        }
        if (getSaveFile() != null && getSaveFile().exists() && getSaveFile().length() > 0 && getSaveFile().length() < this.f22076f && !C0876v.f22882a.f22883b.contains(this)) {
            this.f22075e = getSaveFile().length();
            this.f22079i = 3;
        }
        if ((getSaveFile() == null || !getSaveFile().exists()) && !C0876v.f22882a.f22883b.contains(this)) {
            this.f22079i = 0;
        }
        return this.f22079i;
    }

    /* JADX WARN: Removed duplicated region for block: B:134:0x0167 A[Catch: all -> 0x00f0, Exception -> 0x00f2, TryCatch #11 {Exception -> 0x00f2, blocks: (B:36:0x009a, B:82:0x00e3, B:68:0x012b, B:92:0x013b, B:134:0x0167, B:135:0x016a, B:112:0x015f, B:97:0x016f), top: B:111:0x015f, outer: #0 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 441
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.RunnableC0877w.run():void");
    }

    @Override // com.tencent.bugly.beta.download.DownloadTask
    public void stop() {
        if (this.f22079i != 5) {
            this.f22079i = 3;
        }
    }

    public RunnableC0877w(String str, String str2, String str3, String str4) {
        super(str, str2, str3, str4);
        this.f22886l = 0L;
        this.f22887m = 0L;
        getStatus();
    }

    public void a(int i10, String str) {
        this.f22079i = 5;
        BetaNotifyManager.instance.postDownloadNotify();
        C0876v.f22882a.f22883b.remove(getDownloadUrl());
        com.tencent.bugly.beta.utils.e.a(new com.tencent.bugly.beta.global.d(10, this.f22074d, this, Integer.valueOf(i10), str));
    }

    public void a() {
        this.f22079i = 1;
        b();
        C0876v.f22882a.f22883b.remove(getDownloadUrl());
        BetaReceiver.netListeners.remove(getDownloadUrl());
        com.tencent.bugly.beta.utils.e.a(new com.tencent.bugly.beta.global.d(8, this.f22074d, this));
    }
}
