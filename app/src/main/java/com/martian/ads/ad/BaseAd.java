package com.martian.ads.ad;

import android.content.Context;
import android.os.Handler;
import androidx.annotation.NonNull;
import ba.l;
import com.martian.ads.ad.AdConfig;
import com.martian.ads.ad.BaseAd;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.AppTaskList;
import hf.e;
import x8.c;

/* loaded from: classes3.dex */
public abstract class BaseAd {
    protected AdConfig adConfig;
    private boolean adRequestFinished;
    private AppTaskList appTaskList;
    private String[] blockAppNames;
    private String[] blockPkgNames;
    private boolean clicked;
    private boolean exposed;
    public Handler handler;
    protected d8.a receiver;
    private long requestTime;
    private long timeout;
    private final Runnable timeoutRunnable = new Runnable() { // from class: c8.n
        public /* synthetic */ n() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            BaseAd.this.lambda$new$0();
        }
    };

    public BaseAd() {
    }

    private boolean isBlockAd() {
        c cVar;
        if (this.adConfig.isNativeAd() && getAppTaskList().getApps() != null && !getAppTaskList().getApps().isEmpty()) {
            AppTask appTask = getAppTaskList().getApps().get(0);
            String[] strArr = this.blockAppNames;
            if (strArr != null) {
                for (String str : strArr) {
                    if (appTask.getName().contains(str)) {
                        cVar = new c(AdConfig.ERROR_CODE_AD_BLOCK, appTask.source + e.f26694a + appTask.getName() + e.f26694a + appTask.f12000id);
                        break;
                    }
                    if (appTask.getTitle().contains(str)) {
                        cVar = new c(AdConfig.ERROR_CODE_AD_BLOCK, appTask.source + e.f26694a + appTask.getName() + e.f26694a + appTask.getTitle() + e.f26694a + appTask.f12000id);
                        break;
                    }
                    if (appTask.getDesc().contains(str)) {
                        cVar = new c(AdConfig.ERROR_CODE_AD_BLOCK, appTask.source + e.f26694a + appTask.getName() + e.f26694a + appTask.getDesc() + e.f26694a + appTask.f12000id);
                        break;
                    }
                }
            }
            cVar = null;
            if (this.blockPkgNames != null && !l.q(appTask.packageName)) {
                String[] strArr2 = this.blockPkgNames;
                int length = strArr2.length;
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        break;
                    }
                    if (appTask.packageName.equalsIgnoreCase(strArr2[i10])) {
                        cVar = new c(AdConfig.ERROR_CODE_AD_BLOCK, appTask.source + e.f26694a + appTask.packageName + e.f26694a + appTask.f12000id);
                        break;
                    }
                    i10++;
                }
            }
            if (cVar != null) {
                onError(cVar);
                return true;
            }
        }
        return false;
    }

    public /* synthetic */ void lambda$new$0() {
        onError(new c(-100, "timeout"));
    }

    public void onThreadAdReceived() {
        if (isBlockAd() || this.adRequestFinished) {
            return;
        }
        this.adRequestFinished = true;
        removeTimeoutRunnable();
        if (getAppTaskList().isEmpty()) {
            onError(new c(-1, "ad null"));
        } else {
            b8.e.s().k(this.adConfig, AdConfig.Type.RESPONSE, null, Math.min(System.currentTimeMillis() - this.requestTime, this.timeout));
            this.receiver.i(this.adConfig, getAppTaskList());
        }
    }

    /* renamed from: onThreadError */
    public void lambda$onError$1(c cVar) {
        if (this.adRequestFinished) {
            return;
        }
        this.adRequestFinished = true;
        removeTimeoutRunnable();
        if (cVar == null) {
            cVar = new c(-1, "fail");
        }
        b8.e.s().k(this.adConfig, -100 == cVar.c() ? AdConfig.Type.TIMEOUT : AdConfig.Type.FAIL, cVar, Math.min(System.currentTimeMillis() - this.requestTime, this.timeout));
        this.receiver.c(this.adConfig, cVar);
    }

    private void removeTimeoutRunnable() {
        Handler handler = this.handler;
        if (handler == null) {
            return;
        }
        handler.removeCallbacks(this.timeoutRunnable);
    }

    public AppTaskList getAppTaskList() {
        if (this.appTaskList == null) {
            this.appTaskList = new AppTaskList();
        }
        return this.appTaskList;
    }

    public void init(AdConfig adConfig, @NonNull d8.a aVar, Handler handler) {
        this.adConfig = adConfig;
        this.receiver = aVar;
        this.handler = handler;
    }

    public abstract void loadAds(Context context);

    public void onAdReceived() {
        if (this.handler == null) {
            return;
        }
        if (Thread.currentThread() == this.handler.getLooper().getThread()) {
            onThreadAdReceived();
        } else {
            this.handler.post(new Runnable() { // from class: c8.m
                public /* synthetic */ m() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    BaseAd.this.onThreadAdReceived();
                }
            });
        }
    }

    public void onAdRequest() {
        if (this.handler == null) {
            return;
        }
        b8.e.s().k(this.adConfig, AdConfig.Type.REQUEST, null, 0L);
        this.requestTime = System.currentTimeMillis();
        long j10 = this.timeout;
        if (j10 > 0) {
            this.handler.postDelayed(this.timeoutRunnable, j10);
        }
    }

    public void onClick() {
        if (this.clicked) {
            return;
        }
        this.clicked = true;
        this.receiver.l(this.adConfig);
    }

    public void onClose() {
        this.receiver.d(this.adConfig);
    }

    public void onDismiss() {
        this.receiver.g(this.adConfig);
    }

    public void onError(c cVar) {
        if (this.handler == null) {
            return;
        }
        if (Thread.currentThread() == this.handler.getLooper().getThread()) {
            lambda$onError$1(cVar);
        } else {
            this.handler.post(new Runnable() { // from class: c8.l

                /* renamed from: c */
                public final /* synthetic */ x8.c f1753c;

                public /* synthetic */ l(x8.c cVar2) {
                    cVar = cVar2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    BaseAd.this.lambda$onError$1(cVar);
                }
            });
        }
    }

    public void onExpose() {
        if (this.exposed) {
            return;
        }
        this.exposed = true;
        this.receiver.b(this.adConfig);
    }

    public void onRewardVerify(boolean z10) {
        this.receiver.k(this.adConfig, z10);
    }

    public void setAppTaskList(AppTaskList appTaskList) {
        this.appTaskList = appTaskList;
    }

    public void setBlockInfo(String[] strArr, String[] strArr2) {
        this.blockAppNames = strArr;
        this.blockPkgNames = strArr2;
    }

    public void setTimeout(long j10) {
        this.timeout = j10;
    }

    public BaseAd(AdConfig adConfig, @NonNull d8.a aVar, Handler handler) {
        this.adConfig = adConfig;
        this.receiver = aVar;
        this.handler = handler;
    }
}
