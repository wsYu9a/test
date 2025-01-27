package com.alimm.tanx.core.ad.ad.template.rendering.splash;

import android.content.Context;
import com.alimm.tanx.core.ad.ad.splash.ITanxSplashAd;
import com.alimm.tanx.core.ad.ad.template.rendering.presenter.IPresenter;
import com.alimm.tanx.core.ad.listener.ITanxAdLoader;
import com.alimm.tanx.core.ad.listener.model.IModel;
import com.alimm.tanx.core.ad.loader.ITanxRequestLoader;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.request.TanxError;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.UIThreadUtils;
import java.util.List;

/* loaded from: classes.dex */
public class tanxc_int extends com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do<IModel, ITanxSplashAd, ITanxSplashExpressAd> {
    private final String tanxc_int;
    private final boolean tanxc_new;
    private final boolean tanxc_try;

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_int$1 */
    public class AnonymousClass1 implements ITanxRequestLoader.ITanxRequestListener<ITanxSplashAd> {
        final /* synthetic */ boolean tanxc_do;
        final /* synthetic */ ITanxAdLoader.OnAdLoadListener tanxc_if;

        /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_int$1$1 */
        public class RunnableC02091 implements Runnable {
            final /* synthetic */ List tanxc_do;

            public RunnableC02091(List list) {
                list = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                ITanxAdLoader.OnAdLoadListener onAdLoadListener;
                LogUtils.d("SplashAdPresenter", "开屏请求成功 syncReq= " + z10);
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                if (!z10 || (onAdLoadListener = onAdLoadListener) == null) {
                    return;
                }
                onAdLoadListener.onLoaded(tanxc_int.this.tanxc_do(list));
            }
        }

        /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_int$1$2 */
        public class AnonymousClass2 implements Runnable {
            final /* synthetic */ TanxError tanxc_do;

            public AnonymousClass2(TanxError tanxError) {
                tanxError = tanxError;
            }

            @Override // java.lang.Runnable
            public void run() {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("开屏请求错误 syncReq= ");
                sb2.append(z10);
                sb2.append("--reason= ");
                TanxError tanxError = tanxError;
                sb2.append(tanxError != null ? tanxError.toString() : "");
                LogUtils.e("SplashAdPresenter", sb2.toString());
                int intCode = UtErrorCode.ERROR_AD_LISTENER.getIntCode();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("开屏请求错误 syncReq= ");
                sb3.append(z10);
                sb3.append("--reason= ");
                TanxError tanxError2 = tanxError;
                sb3.append(tanxError2 != null ? tanxError2.getMessage() : "");
                TanxBaseUt.utError(intCode, "SplashAdPresenter", sb3.toString(), "");
                ITanxAdLoader.OnAdLoadListener onAdLoadListener = onAdLoadListener;
                if (onAdLoadListener != null) {
                    onAdLoadListener.onError(tanxError);
                }
            }
        }

        /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_int$1$3 */
        public class AnonymousClass3 implements Runnable {
            public AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public void run() {
                LogUtils.d("SplashAdPresenter", "开屏请求超时 syncReq= " + z10);
                ITanxAdLoader.OnAdLoadListener onAdLoadListener = onAdLoadListener;
                if (onAdLoadListener != null) {
                    onAdLoadListener.onTimeOut();
                }
            }
        }

        public AnonymousClass1(boolean z10, ITanxAdLoader.OnAdLoadListener onAdLoadListener) {
            z10 = z10;
            onAdLoadListener = onAdLoadListener;
        }

        @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
        public void onError(TanxError tanxError) {
            UIThreadUtils.post(new Runnable() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_int.1.2
                final /* synthetic */ TanxError tanxc_do;

                public AnonymousClass2(TanxError tanxError2) {
                    tanxError = tanxError2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("开屏请求错误 syncReq= ");
                    sb2.append(z10);
                    sb2.append("--reason= ");
                    TanxError tanxError2 = tanxError;
                    sb2.append(tanxError2 != null ? tanxError2.toString() : "");
                    LogUtils.e("SplashAdPresenter", sb2.toString());
                    int intCode = UtErrorCode.ERROR_AD_LISTENER.getIntCode();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("开屏请求错误 syncReq= ");
                    sb3.append(z10);
                    sb3.append("--reason= ");
                    TanxError tanxError22 = tanxError;
                    sb3.append(tanxError22 != null ? tanxError22.getMessage() : "");
                    TanxBaseUt.utError(intCode, "SplashAdPresenter", sb3.toString(), "");
                    ITanxAdLoader.OnAdLoadListener onAdLoadListener = onAdLoadListener;
                    if (onAdLoadListener != null) {
                        onAdLoadListener.onError(tanxError);
                    }
                }
            });
        }

        @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
        public void onSuccess(List<ITanxSplashAd> list) {
            UIThreadUtils.post(new Runnable() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_int.1.1
                final /* synthetic */ List tanxc_do;

                public RunnableC02091(List list2) {
                    list = list2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    ITanxAdLoader.OnAdLoadListener onAdLoadListener;
                    LogUtils.d("SplashAdPresenter", "开屏请求成功 syncReq= " + z10);
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    if (!z10 || (onAdLoadListener = onAdLoadListener) == null) {
                        return;
                    }
                    onAdLoadListener.onLoaded(tanxc_int.this.tanxc_do(list));
                }
            });
        }

        @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
        public void onTimeOut() {
            UIThreadUtils.post(new Runnable() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_int.1.3
                public AnonymousClass3() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    LogUtils.d("SplashAdPresenter", "开屏请求超时 syncReq= " + z10);
                    ITanxAdLoader.OnAdLoadListener onAdLoadListener = onAdLoadListener;
                    if (onAdLoadListener != null) {
                        onAdLoadListener.onTimeOut();
                    }
                }
            });
        }
    }

    public tanxc_int(Context context, IModel iModel) {
        super(context, iModel);
        this.tanxc_int = "SplashAdPresenter";
        this.tanxc_new = false;
        this.tanxc_try = false;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do, com.alimm.tanx.core.ad.ad.template.rendering.presenter.IPresenter
    public IPresenter destroy() {
        return super.destroy();
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do
    public ITanxSplashExpressAd tanxc_do(ITanxSplashAd iTanxSplashAd) {
        return new tanxc_new(this.tanxc_do, iTanxSplashAd);
    }

    public IPresenter tanxc_do(boolean z10, TanxAdSlot tanxAdSlot, ITanxAdLoader.OnAdLoadListener onAdLoadListener, long j10) {
        this.tanxc_for.sendRequest(z10, tanxAdSlot, new ITanxRequestLoader.ITanxRequestListener<ITanxSplashAd>() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_int.1
            final /* synthetic */ boolean tanxc_do;
            final /* synthetic */ ITanxAdLoader.OnAdLoadListener tanxc_if;

            /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_int$1$1 */
            public class RunnableC02091 implements Runnable {
                final /* synthetic */ List tanxc_do;

                public RunnableC02091(List list2) {
                    list = list2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    ITanxAdLoader.OnAdLoadListener onAdLoadListener;
                    LogUtils.d("SplashAdPresenter", "开屏请求成功 syncReq= " + z10);
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    if (!z10 || (onAdLoadListener = onAdLoadListener) == null) {
                        return;
                    }
                    onAdLoadListener.onLoaded(tanxc_int.this.tanxc_do(list));
                }
            }

            /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_int$1$2 */
            public class AnonymousClass2 implements Runnable {
                final /* synthetic */ TanxError tanxc_do;

                public AnonymousClass2(TanxError tanxError2) {
                    tanxError = tanxError2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("开屏请求错误 syncReq= ");
                    sb2.append(z10);
                    sb2.append("--reason= ");
                    TanxError tanxError2 = tanxError;
                    sb2.append(tanxError2 != null ? tanxError2.toString() : "");
                    LogUtils.e("SplashAdPresenter", sb2.toString());
                    int intCode = UtErrorCode.ERROR_AD_LISTENER.getIntCode();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("开屏请求错误 syncReq= ");
                    sb3.append(z10);
                    sb3.append("--reason= ");
                    TanxError tanxError22 = tanxError;
                    sb3.append(tanxError22 != null ? tanxError22.getMessage() : "");
                    TanxBaseUt.utError(intCode, "SplashAdPresenter", sb3.toString(), "");
                    ITanxAdLoader.OnAdLoadListener onAdLoadListener = onAdLoadListener;
                    if (onAdLoadListener != null) {
                        onAdLoadListener.onError(tanxError);
                    }
                }
            }

            /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_int$1$3 */
            public class AnonymousClass3 implements Runnable {
                public AnonymousClass3() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    LogUtils.d("SplashAdPresenter", "开屏请求超时 syncReq= " + z10);
                    ITanxAdLoader.OnAdLoadListener onAdLoadListener = onAdLoadListener;
                    if (onAdLoadListener != null) {
                        onAdLoadListener.onTimeOut();
                    }
                }
            }

            public AnonymousClass1(boolean z102, ITanxAdLoader.OnAdLoadListener onAdLoadListener2) {
                z10 = z102;
                onAdLoadListener = onAdLoadListener2;
            }

            @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
            public void onError(TanxError tanxError2) {
                UIThreadUtils.post(new Runnable() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_int.1.2
                    final /* synthetic */ TanxError tanxc_do;

                    public AnonymousClass2(TanxError tanxError22) {
                        tanxError = tanxError22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("开屏请求错误 syncReq= ");
                        sb2.append(z10);
                        sb2.append("--reason= ");
                        TanxError tanxError22 = tanxError;
                        sb2.append(tanxError22 != null ? tanxError22.toString() : "");
                        LogUtils.e("SplashAdPresenter", sb2.toString());
                        int intCode = UtErrorCode.ERROR_AD_LISTENER.getIntCode();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("开屏请求错误 syncReq= ");
                        sb3.append(z10);
                        sb3.append("--reason= ");
                        TanxError tanxError222 = tanxError;
                        sb3.append(tanxError222 != null ? tanxError222.getMessage() : "");
                        TanxBaseUt.utError(intCode, "SplashAdPresenter", sb3.toString(), "");
                        ITanxAdLoader.OnAdLoadListener onAdLoadListener2 = onAdLoadListener;
                        if (onAdLoadListener2 != null) {
                            onAdLoadListener2.onError(tanxError);
                        }
                    }
                });
            }

            @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
            public void onSuccess(List list2) {
                UIThreadUtils.post(new Runnable() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_int.1.1
                    final /* synthetic */ List tanxc_do;

                    public RunnableC02091(List list22) {
                        list = list22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        ITanxAdLoader.OnAdLoadListener onAdLoadListener2;
                        LogUtils.d("SplashAdPresenter", "开屏请求成功 syncReq= " + z10);
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        if (!z10 || (onAdLoadListener2 = onAdLoadListener) == null) {
                            return;
                        }
                        onAdLoadListener2.onLoaded(tanxc_int.this.tanxc_do(list));
                    }
                });
            }

            @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
            public void onTimeOut() {
                UIThreadUtils.post(new Runnable() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_int.1.3
                    public AnonymousClass3() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        LogUtils.d("SplashAdPresenter", "开屏请求超时 syncReq= " + z10);
                        ITanxAdLoader.OnAdLoadListener onAdLoadListener2 = onAdLoadListener;
                        if (onAdLoadListener2 != null) {
                            onAdLoadListener2.onTimeOut();
                        }
                    }
                });
            }
        }, j10);
        return this;
    }

    public void tanxc_do(TanxAdSlot tanxAdSlot, ITanxAdLoader.OnAdLoadListener onAdLoadListener, long j10) {
        tanxc_do(true, tanxAdSlot, onAdLoadListener, j10);
    }

    public void tanxc_do(TanxAdSlot tanxAdSlot) {
        tanxc_do(false, tanxAdSlot, null, 0L);
    }
}
