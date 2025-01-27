package com.kuaishou.pushad;

import com.kwad.components.core.internal.api.a;
import com.kwad.components.core.internal.api.b;
import com.kwad.components.core.l.d;
import com.kwad.components.core.l.h;
import com.kwad.components.core.l.i;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class KsAdGlobalWatcher implements b {
    private static final Object PRESENT = new Object();
    private static final String TAG = "KsAdGlobalWatcher";
    private static volatile KsAdGlobalWatcher sInstance;
    private Set<Integer> mTargetAdStyle = new HashSet();
    private List<PushAdManager> mCurrentPushAdManager = new ArrayList();
    private Map<a, Object> mCurrentShowingAd = new WeakHashMap();
    private Map<d, Object> mCurrentActivity = new WeakHashMap();
    private i mLifecycleListener = new i() { // from class: com.kuaishou.pushad.KsAdGlobalWatcher.1
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.l.i, com.kwad.sdk.core.b.c
        public void onActivityPaused(d dVar) {
            super.onActivityPaused(dVar);
            KsAdGlobalWatcher.this.mCurrentActivity.remove(dVar);
            if (KsAdGlobalWatcher.this.mCurrentActivity.isEmpty()) {
                KsAdGlobalWatcher.this.checkCurrentPage();
            }
        }

        @Override // com.kwad.components.core.l.i, com.kwad.sdk.core.b.c
        public void onActivityResumed(d dVar) {
            super.onActivityResumed(dVar);
            KsAdGlobalWatcher.this.mCurrentActivity.put(dVar, KsAdGlobalWatcher.PRESENT);
        }
    };

    /* renamed from: com.kuaishou.pushad.KsAdGlobalWatcher$1 */
    class AnonymousClass1 extends i {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.l.i, com.kwad.sdk.core.b.c
        public void onActivityPaused(d dVar) {
            super.onActivityPaused(dVar);
            KsAdGlobalWatcher.this.mCurrentActivity.remove(dVar);
            if (KsAdGlobalWatcher.this.mCurrentActivity.isEmpty()) {
                KsAdGlobalWatcher.this.checkCurrentPage();
            }
        }

        @Override // com.kwad.components.core.l.i, com.kwad.sdk.core.b.c
        public void onActivityResumed(d dVar) {
            super.onActivityResumed(dVar);
            KsAdGlobalWatcher.this.mCurrentActivity.put(dVar, KsAdGlobalWatcher.PRESENT);
        }
    }

    private KsAdGlobalWatcher() {
        h.oZ().a(this.mLifecycleListener);
        this.mTargetAdStyle.add(2);
        this.mTargetAdStyle.add(3);
        this.mTargetAdStyle.add(13);
        this.mTargetAdStyle.add(6);
    }

    public synchronized void checkCurrentPage() {
        boolean preShowPushCheck = preShowPushCheck();
        com.kwad.sdk.core.d.b.d(TAG, "checkCurrentPage noSDKPage: " + preShowPushCheck);
        if (preShowPushCheck) {
            Iterator<PushAdManager> it = this.mCurrentPushAdManager.iterator();
            while (it.hasNext()) {
                it.next().onOutSDKPage();
            }
        }
    }

    public static KsAdGlobalWatcher getInstance() {
        if (sInstance == null) {
            synchronized (KsAdGlobalWatcher.class) {
                if (sInstance == null) {
                    sInstance = new KsAdGlobalWatcher();
                }
            }
        }
        return sInstance;
    }

    private void innerHandleEnter(a aVar) {
        this.mCurrentShowingAd.put(aVar, PRESENT);
        if (isPushAdEnable(aVar)) {
            PushAdManager pushAdManager = new PushAdManager(aVar.getAdTemplate());
            pushAdManager.startRequestPushAd(aVar);
            this.mCurrentPushAdManager.add(pushAdManager);
        }
    }

    private void innerHandleExit(a aVar) {
        this.mCurrentShowingAd.remove(aVar);
        Iterator<PushAdManager> it = this.mCurrentPushAdManager.iterator();
        while (it.hasNext()) {
            it.next().onAdExit(aVar);
        }
        if (isAdInTargetSet(aVar.getAdTemplate())) {
            checkCurrentPage();
        }
    }

    private boolean isAdInTargetSet(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return false;
        }
        return this.mTargetAdStyle.contains(Integer.valueOf(adTemplate.adStyle));
    }

    private boolean isPushAdEnable(a aVar) {
        if (aVar.ao()) {
            return com.kwad.sdk.core.response.a.a.cy(com.kwad.sdk.core.response.a.d.cb(aVar.getAdTemplate()));
        }
        return false;
    }

    @Override // com.kwad.components.core.internal.api.b
    public void onAdEnter(a aVar) {
        innerHandleEnter(aVar);
    }

    @Override // com.kwad.components.core.internal.api.b
    public void onAdExit(a aVar) {
        innerHandleExit(aVar);
        unwatch(aVar);
    }

    public synchronized boolean preShowPushCheck() {
        Iterator<a> it = this.mCurrentShowingAd.keySet().iterator();
        while (it.hasNext()) {
            if (isAdInTargetSet(it.next().getAdTemplate())) {
                return false;
            }
        }
        return this.mCurrentActivity.isEmpty();
    }

    public void removePushAdManager(PushAdManager pushAdManager) {
        if (pushAdManager != null) {
            this.mCurrentPushAdManager.remove(pushAdManager);
        }
    }

    public void unwatch(a aVar) {
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public void watch(a aVar) {
        if (aVar != null) {
            aVar.a(this);
        }
    }
}
