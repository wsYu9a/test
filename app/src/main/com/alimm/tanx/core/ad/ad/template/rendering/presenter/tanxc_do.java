package com.alimm.tanx.core.ad.ad.template.rendering.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.listener.INewTanxExpressAd;
import com.alimm.tanx.core.ad.listener.ITanxAdLoader;
import com.alimm.tanx.core.ad.listener.model.IModel;
import com.alimm.tanx.core.ad.loader.ITanxRequestLoader;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.request.TanxError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class tanxc_do<M extends IModel, T extends ITanxAd, F extends INewTanxExpressAd> implements IPresenter {
    protected Context tanxc_do;
    protected M tanxc_for;
    protected Handler tanxc_if = new Handler(Looper.getMainLooper());

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do$1 */
    public class AnonymousClass1 implements ITanxRequestLoader.ITanxRequestListener<T> {
        final /* synthetic */ ITanxAdLoader.OnAdLoadListener tanxc_do;

        /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do$1$1 */
        public class RunnableC02071 implements Runnable {
            final /* synthetic */ List tanxc_do;

            public RunnableC02071(List list) {
                tanxc_do = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                onAdLoadListener.onLoaded(tanxc_do);
            }
        }

        /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do$1$2 */
        public class AnonymousClass2 implements Runnable {
            final /* synthetic */ TanxError tanxc_do;

            public AnonymousClass2(TanxError tanxError) {
                tanxError = tanxError;
            }

            @Override // java.lang.Runnable
            public void run() {
                onAdLoadListener.onError(tanxError);
            }
        }

        /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do$1$3 */
        public class AnonymousClass3 implements Runnable {
            public AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public void run() {
                onAdLoadListener.onTimeOut();
            }
        }

        public AnonymousClass1(ITanxAdLoader.OnAdLoadListener onAdLoadListener) {
            onAdLoadListener = onAdLoadListener;
        }

        @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
        public void onError(TanxError tanxError) {
            tanxc_do.this.tanxc_if.post(new Runnable() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do.1.2
                final /* synthetic */ TanxError tanxc_do;

                public AnonymousClass2(TanxError tanxError2) {
                    tanxError = tanxError2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    onAdLoadListener.onError(tanxError);
                }
            });
        }

        @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
        public void onSuccess(List<T> list) {
            tanxc_do.this.tanxc_if.post(new Runnable() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do.1.1
                final /* synthetic */ List tanxc_do;

                public RunnableC02071(List list2) {
                    tanxc_do = list2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    onAdLoadListener.onLoaded(tanxc_do);
                }
            });
        }

        @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
        public void onTimeOut() {
            tanxc_do.this.tanxc_if.post(new Runnable() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do.1.3
                public AnonymousClass3() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    onAdLoadListener.onTimeOut();
                }
            });
        }
    }

    public tanxc_do(Context context, M m10) {
        this.tanxc_do = context;
        this.tanxc_for = m10;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.presenter.IPresenter
    public IPresenter destroy() {
        return this;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.presenter.IPresenter
    public IPresenter request(TanxAdSlot tanxAdSlot, ITanxAdLoader.OnAdLoadListener onAdLoadListener, long j10) {
        if (onAdLoadListener == null) {
            return this;
        }
        this.tanxc_for.sendRequest(tanxAdSlot, new ITanxRequestLoader.ITanxRequestListener<T>() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do.1
            final /* synthetic */ ITanxAdLoader.OnAdLoadListener tanxc_do;

            /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do$1$1 */
            public class RunnableC02071 implements Runnable {
                final /* synthetic */ List tanxc_do;

                public RunnableC02071(List list2) {
                    tanxc_do = list2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    onAdLoadListener.onLoaded(tanxc_do);
                }
            }

            /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do$1$2 */
            public class AnonymousClass2 implements Runnable {
                final /* synthetic */ TanxError tanxc_do;

                public AnonymousClass2(TanxError tanxError2) {
                    tanxError = tanxError2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    onAdLoadListener.onError(tanxError);
                }
            }

            /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do$1$3 */
            public class AnonymousClass3 implements Runnable {
                public AnonymousClass3() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    onAdLoadListener.onTimeOut();
                }
            }

            public AnonymousClass1(ITanxAdLoader.OnAdLoadListener onAdLoadListener2) {
                onAdLoadListener = onAdLoadListener2;
            }

            @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
            public void onError(TanxError tanxError2) {
                tanxc_do.this.tanxc_if.post(new Runnable() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do.1.2
                    final /* synthetic */ TanxError tanxc_do;

                    public AnonymousClass2(TanxError tanxError22) {
                        tanxError = tanxError22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        onAdLoadListener.onError(tanxError);
                    }
                });
            }

            @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
            public void onSuccess(List<T> list) {
                tanxc_do.this.tanxc_if.post(new Runnable() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do.1.1
                    final /* synthetic */ List tanxc_do;

                    public RunnableC02071(List list2) {
                        tanxc_do = list2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        onAdLoadListener.onLoaded(tanxc_do);
                    }
                });
            }

            @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
            public void onTimeOut() {
                tanxc_do.this.tanxc_if.post(new Runnable() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do.1.3
                    public AnonymousClass3() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        onAdLoadListener.onTimeOut();
                    }
                });
            }
        }, j10);
        return this;
    }

    public abstract F tanxc_do(T t10);

    public List<F> tanxc_do(List<T> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(tanxc_do((tanxc_do<M, T, F>) it.next()));
        }
        return arrayList;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.presenter.IPresenter
    public IPresenter request(TanxAdSlot tanxAdSlot, ITanxAdLoader.OnAdLoadListener onAdLoadListener) {
        return request(tanxAdSlot, onAdLoadListener, 0L);
    }
}
