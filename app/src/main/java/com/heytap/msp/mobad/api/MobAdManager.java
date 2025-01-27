package com.heytap.msp.mobad.api;

import android.content.Context;
import com.heytap.msp.mobad.api.listener.IInitListener;
import com.opos.mobad.ad.d;
import com.opos.mobad.ad.e;

/* loaded from: classes.dex */
public final class MobAdManager {
    private static volatile MobAdManager sMobAdManager;

    /* renamed from: com.heytap.msp.mobad.api.MobAdManager$1 */
    class AnonymousClass1 implements e {

        /* renamed from: a */
        final /* synthetic */ IInitListener f8962a;

        AnonymousClass1(IInitListener iInitListener) {
            iInitListener = iInitListener;
        }

        @Override // com.opos.mobad.ad.e
        public void a() {
            IInitListener iInitListener = iInitListener;
            if (iInitListener != null) {
                iInitListener.onSuccess();
            }
        }

        @Override // com.opos.mobad.ad.e
        public void a(String str) {
            IInitListener iInitListener = iInitListener;
            if (iInitListener != null) {
                iInitListener.onFailed(str);
            }
        }
    }

    /* renamed from: com.heytap.msp.mobad.api.MobAdManager$2 */
    class AnonymousClass2 implements d {

        /* renamed from: a */
        final /* synthetic */ InitParams f8964a;

        AnonymousClass2(InitParams initParams) {
            initParams = initParams;
        }

        @Override // com.opos.mobad.ad.d
        public String a() {
            return initParams.classifyByAgeProvider.getClassifyByAge();
        }
    }

    /* renamed from: com.heytap.msp.mobad.api.MobAdManager$3 */
    class AnonymousClass3 implements d {

        /* renamed from: a */
        final /* synthetic */ InitParams f8966a;

        AnonymousClass3(InitParams initParams) {
            initParams = initParams;
        }

        @Override // com.opos.mobad.ad.d
        public String a() {
            return initParams.classifyByAgeProvider.getClassifyByAge();
        }
    }

    /* renamed from: com.heytap.msp.mobad.api.MobAdManager$4 */
    class AnonymousClass4 implements e {

        /* renamed from: a */
        final /* synthetic */ IInitListener f8968a;

        AnonymousClass4(IInitListener iInitListener) {
            iInitListener = iInitListener;
        }

        @Override // com.opos.mobad.ad.e
        public void a() {
            IInitListener iInitListener = iInitListener;
            if (iInitListener != null) {
                iInitListener.onSuccess();
            }
        }

        @Override // com.opos.mobad.ad.e
        public void a(String str) {
            IInitListener iInitListener = iInitListener;
            if (iInitListener != null) {
                iInitListener.onFailed(str);
            }
        }
    }

    private MobAdManager() {
    }

    private int getCVer() {
        return -1;
    }

    public static MobAdManager getInstance() {
        MobAdManager mobAdManager = sMobAdManager;
        if (mobAdManager == null) {
            synchronized (MobAdManager.class) {
                mobAdManager = sMobAdManager;
                if (mobAdManager == null) {
                    mobAdManager = new MobAdManager();
                    sMobAdManager = mobAdManager;
                }
            }
        }
        return mobAdManager;
    }

    public void exit(Context context) {
        a.a().a(context);
    }

    public int getSdkVerCode() {
        return 481004;
    }

    public String getSdkVerName() {
        return "4.8.1";
    }

    public void init(Context context, String str) throws NullPointerException {
        a.a().a(context, str, getCVer());
    }

    public void init(Context context, String str, InitParams initParams) throws NullPointerException {
        a.a().a(context, str, initParams != null ? initParams.debug : false, initParams != null ? initParams.appOUIDStatus : true, getCVer(), initParams != null && initParams.touristMode, initParams != null ? initParams.advanceMode : 0, (initParams == null || initParams.classifyByAgeProvider == null) ? null : new d() { // from class: com.heytap.msp.mobad.api.MobAdManager.2

            /* renamed from: a */
            final /* synthetic */ InitParams f8964a;

            AnonymousClass2(InitParams initParams2) {
                initParams = initParams2;
            }

            @Override // com.opos.mobad.ad.d
            public String a() {
                return initParams.classifyByAgeProvider.getClassifyByAge();
            }
        });
    }

    public void init(Context context, String str, InitParams initParams, IInitListener iInitListener) throws NullPointerException {
        a.a().a(context, str, initParams != null ? initParams.debug : false, initParams != null ? initParams.appOUIDStatus : true, getCVer(), new e() { // from class: com.heytap.msp.mobad.api.MobAdManager.4

            /* renamed from: a */
            final /* synthetic */ IInitListener f8968a;

            AnonymousClass4(IInitListener iInitListener2) {
                iInitListener = iInitListener2;
            }

            @Override // com.opos.mobad.ad.e
            public void a() {
                IInitListener iInitListener2 = iInitListener;
                if (iInitListener2 != null) {
                    iInitListener2.onSuccess();
                }
            }

            @Override // com.opos.mobad.ad.e
            public void a(String str2) {
                IInitListener iInitListener2 = iInitListener;
                if (iInitListener2 != null) {
                    iInitListener2.onFailed(str2);
                }
            }
        }, initParams != null && initParams.touristMode, initParams != null ? initParams.advanceMode : 0, (initParams == null || initParams.classifyByAgeProvider == null) ? null : new d() { // from class: com.heytap.msp.mobad.api.MobAdManager.3

            /* renamed from: a */
            final /* synthetic */ InitParams f8966a;

            AnonymousClass3(InitParams initParams2) {
                initParams = initParams2;
            }

            @Override // com.opos.mobad.ad.d
            public String a() {
                return initParams.classifyByAgeProvider.getClassifyByAge();
            }
        });
    }

    public void init(Context context, String str, IInitListener iInitListener) throws NullPointerException {
        a.a().a(context, str, getCVer(), new e() { // from class: com.heytap.msp.mobad.api.MobAdManager.1

            /* renamed from: a */
            final /* synthetic */ IInitListener f8962a;

            AnonymousClass1(IInitListener iInitListener2) {
                iInitListener = iInitListener2;
            }

            @Override // com.opos.mobad.ad.e
            public void a() {
                IInitListener iInitListener2 = iInitListener;
                if (iInitListener2 != null) {
                    iInitListener2.onSuccess();
                }
            }

            @Override // com.opos.mobad.ad.e
            public void a(String str2) {
                IInitListener iInitListener2 = iInitListener;
                if (iInitListener2 != null) {
                    iInitListener2.onFailed(str2);
                }
            }
        });
    }

    public boolean isSupportedMobile() {
        return a.a().a();
    }
}
