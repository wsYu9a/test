package com.heytap.msp.mobad.api.ad;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.heytap.msp.mobad.api.listener.IHotSplashListener;
import com.heytap.msp.mobad.api.params.SplashAdParams;
import com.opos.mobad.ad.e.c;
import com.opos.mobad.ad.e.d;
import com.opos.mobad.ad.e.e;
import com.opos.mobad.ad.e.f;
import java.util.List;

/* loaded from: classes.dex */
public class HotSplashAd implements IBidding {
    private static final int INIT_DELAY_TIME = 50;
    private Context mContext;
    private final c mListener;
    private String mPosId;
    private com.opos.mobad.ad.e.a mSplashAdImpl;
    private final SplashAdParams mSplashAdParams;
    private boolean mIsReady = false;
    private boolean mHadShowed = false;
    private volatile boolean mHasDestroyed = false;

    /* renamed from: com.heytap.msp.mobad.api.ad.HotSplashAd$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (HotSplashAd.this.mHasDestroyed) {
                return;
            }
            if (HotSplashAd.this.initImplIfNeed()) {
                HotSplashAd.this.mSplashAdImpl.a((int) HotSplashAd.this.mSplashAdParams.fetchTimeout);
            } else {
                HotSplashAd.this.mListener.a(-1, "inter ad create fail");
            }
        }
    }

    /* renamed from: com.heytap.msp.mobad.api.ad.HotSplashAd$2 */
    class AnonymousClass2 implements d {

        /* renamed from: a */
        final /* synthetic */ View f8973a;

        AnonymousClass2(View view) {
            view = view;
        }

        @Override // com.opos.mobad.ad.e.d
        public View a() {
            return view;
        }
    }

    /* renamed from: com.heytap.msp.mobad.api.ad.HotSplashAd$3 */
    class AnonymousClass3 implements e {
        AnonymousClass3() {
        }

        @Override // com.opos.mobad.ad.e.e
        public View a() {
            return HotSplashAd.this.mSplashAdParams.splashSkipView;
        }

        @Override // com.opos.mobad.ad.e.e
        public void a(int i2) {
            HotSplashAd.this.mSplashAdParams.splashSkipView.onSkipCountDown(i2);
        }

        @Override // com.opos.mobad.ad.e.e
        public List<View> b() {
            return HotSplashAd.this.mSplashAdParams.clickViews;
        }
    }

    private class a implements c {

        /* renamed from: c */
        private IHotSplashListener f8977c;

        public a(IHotSplashListener iHotSplashListener) {
            this.f8977c = iHotSplashListener;
        }

        @Override // com.opos.mobad.ad.b.a
        public void a() {
            HotSplashAd.this.mIsReady = true;
            IHotSplashListener iHotSplashListener = this.f8977c;
            if (iHotSplashListener != null) {
                iHotSplashListener.onAdReady();
            }
        }

        @Override // com.opos.mobad.ad.b.a
        public void a(int i2, String str) {
            IHotSplashListener iHotSplashListener = this.f8977c;
            if (iHotSplashListener != null) {
                iHotSplashListener.onAdFailed(i2, str);
            }
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j2) {
            IHotSplashListener iHotSplashListener = this.f8977c;
            if (iHotSplashListener != null) {
                iHotSplashListener.onAdClick();
            }
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            HotSplashAd.this.mHadShowed = true;
            IHotSplashListener iHotSplashListener = this.f8977c;
            if (iHotSplashListener != null) {
                iHotSplashListener.onAdShow(str);
            }
        }

        @Override // com.opos.mobad.ad.b.a
        public void b() {
            IHotSplashListener iHotSplashListener = this.f8977c;
            if (iHotSplashListener != null) {
                iHotSplashListener.onAdDismissed();
            }
        }
    }

    public HotSplashAd(Context context, String str, IHotSplashListener iHotSplashListener, SplashAdParams splashAdParams) throws NullPointerException {
        if (context == null || TextUtils.isEmpty(str) || iHotSplashListener == null || splashAdParams == null) {
            throw new NullPointerException("SplashAd Constructor param context or posId or iSplashAdListener or splashAdParams is null.");
        }
        a aVar = new a(iHotSplashListener);
        this.mListener = aVar;
        this.mSplashAdParams = splashAdParams;
        this.mContext = context;
        this.mPosId = str;
        View view = splashAdParams.bottomArea;
        if (view != null && view.getParent() != null) {
            aVar.a(10502, "The bottomArea view already has a parent..please not attachToRoot");
        } else if (initImplIfNeed()) {
            this.mSplashAdImpl.a((int) splashAdParams.fetchTimeout);
        } else {
            new Handler(context.getMainLooper()).postDelayed(new Runnable() { // from class: com.heytap.msp.mobad.api.ad.HotSplashAd.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (HotSplashAd.this.mHasDestroyed) {
                        return;
                    }
                    if (HotSplashAd.this.initImplIfNeed()) {
                        HotSplashAd.this.mSplashAdImpl.a((int) HotSplashAd.this.mSplashAdParams.fetchTimeout);
                    } else {
                        HotSplashAd.this.mListener.a(-1, "inter ad create fail");
                    }
                }
            }, 50L);
        }
    }

    private e getISkipView() {
        List<View> list;
        SplashAdParams splashAdParams = this.mSplashAdParams;
        if (splashAdParams.splashSkipView == null || (list = splashAdParams.clickViews) == null || list.size() <= 0) {
            return null;
        }
        return new e() { // from class: com.heytap.msp.mobad.api.ad.HotSplashAd.3
            AnonymousClass3() {
            }

            @Override // com.opos.mobad.ad.e.e
            public View a() {
                return HotSplashAd.this.mSplashAdParams.splashSkipView;
            }

            @Override // com.opos.mobad.ad.e.e
            public void a(int i2) {
                HotSplashAd.this.mSplashAdParams.splashSkipView.onSkipCountDown(i2);
            }

            @Override // com.opos.mobad.ad.e.e
            public List<View> b() {
                return HotSplashAd.this.mSplashAdParams.clickViews;
            }
        };
    }

    private d getISplashBottomArea(View view) {
        if (view != null) {
            return new d() { // from class: com.heytap.msp.mobad.api.ad.HotSplashAd.2

                /* renamed from: a */
                final /* synthetic */ View f8973a;

                AnonymousClass2(View view2) {
                    view = view2;
                }

                @Override // com.opos.mobad.ad.e.d
                public View a() {
                    return view;
                }
            };
        }
        return null;
    }

    public boolean initImplIfNeed() {
        boolean z = true;
        if (this.mSplashAdImpl == null) {
            if (this.mContext != null && !TextUtils.isEmpty(this.mPosId)) {
                synchronized (this) {
                    if (this.mSplashAdImpl == null) {
                        com.opos.mobad.ad.e.a a2 = com.heytap.msp.mobad.api.a.a().a(this.mContext, this.mPosId, this.mListener, new f.a(this.mContext).a(getISplashBottomArea(this.mSplashAdParams.bottomArea)).b(this.mSplashAdParams.desc).a(this.mSplashAdParams.fetchTimeout).a(this.mSplashAdParams.showPreLoadPage).b(this.mSplashAdParams.isUseSurfaceView).a(this.mSplashAdParams.title).c(true).a(getISkipView()).d(false).a());
                        this.mSplashAdImpl = a2;
                        if (a2 == null) {
                        }
                    }
                }
            }
            z = false;
        }
        return z;
    }

    public void destroyAd() {
        com.opos.mobad.ad.e.a aVar = this.mSplashAdImpl;
        if (aVar != null) {
            aVar.b();
        }
        this.mHasDestroyed = true;
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public int getECPM() {
        com.opos.mobad.ad.e.a aVar = this.mSplashAdImpl;
        if (aVar != null) {
            return aVar.g();
        }
        return 0;
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void notifyRankLoss(int i2, String str, int i3) {
        com.opos.mobad.ad.e.a aVar = this.mSplashAdImpl;
        if (aVar != null) {
            aVar.a(i2, str, i3);
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void notifyRankWin(int i2) {
        com.opos.mobad.ad.e.a aVar = this.mSplashAdImpl;
        if (aVar != null) {
            aVar.b(i2);
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void setBidECPM(int i2) {
        com.opos.mobad.ad.e.a aVar = this.mSplashAdImpl;
        if (aVar != null) {
            aVar.c(i2);
        }
    }

    public void showAd(Activity activity) {
        c cVar;
        String str;
        com.opos.mobad.ad.e.a aVar = this.mSplashAdImpl;
        if (aVar == null) {
            cVar = this.mListener;
            str = "inter ad create fail";
        } else if (!this.mIsReady) {
            cVar = this.mListener;
            str = "ad had not ready";
        } else if (!this.mHadShowed) {
            aVar.a(activity);
            return;
        } else {
            cVar = this.mListener;
            str = "splash had showed";
        }
        cVar.a(-1, str);
    }
}
