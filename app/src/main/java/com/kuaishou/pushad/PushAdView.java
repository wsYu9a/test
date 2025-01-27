package com.kuaishou.pushad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.a.a.m;
import com.kwad.components.core.webview.a.h;
import com.kwad.components.core.webview.a.i;
import com.kwad.components.core.webview.a.j;
import com.kwad.components.core.webview.a.kwai.o;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.components.core.widget.kwai.b;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.l;
import com.kwad.sdk.core.g.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.c.kwai.a;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.e;

/* loaded from: classes.dex */
public class PushAdView extends KSFrameLayout implements i, c {
    public static String PUSH_VIEW_TAG = "PUSH_VIEW_TAG";
    private static final String TAG = "PushAdView";
    private an mCardLifecycleHandler;
    private AdTemplate mPushAd;
    private PushAdListener mPushAdListener;
    private h mTKLoadController;
    private boolean mTKLoadSuccess;
    private b mViewVisibleHelper;

    /* renamed from: com.kuaishou.pushad.PushAdView$1 */
    class AnonymousClass1 extends h {

        /* renamed from: com.kuaishou.pushad.PushAdView$1$1 */
        class C01161 extends p {
            C01161(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.d.b.c cVar, a aVar) {
                super(bVar, cVar, aVar);
            }

            @Override // com.kwad.components.core.webview.jshandler.p
            public void afterHandleAdClick(int i2) {
                super.afterHandleAdClick(i2);
                if (i2 == 1) {
                    PushAdView.this.pageClose(null);
                }
            }
        }

        AnonymousClass1(long j2, Context context) {
            super(j2, context);
        }

        @Override // com.kwad.components.core.webview.a.h
        public void onRegisterWebCardHandler(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.d.b.c cVar, l lVar, ViewGroup viewGroup) {
            super.onRegisterWebCardHandler(bVar, cVar, lVar, viewGroup);
            lVar.c(new p(bVar, cVar, this) { // from class: com.kuaishou.pushad.PushAdView.1.1
                C01161(com.kwad.sdk.core.webview.b bVar2, com.kwad.components.core.d.b.c cVar2, a this) {
                    super(bVar2, cVar2, this);
                }

                @Override // com.kwad.components.core.webview.jshandler.p
                public void afterHandleAdClick(int i2) {
                    super.afterHandleAdClick(i2);
                    if (i2 == 1) {
                        PushAdView.this.pageClose(null);
                    }
                }
            });
        }
    }

    public interface PushAdListener {
        void onPushAdViewClose();

        void onPushAdViewShow();
    }

    public PushAdView(@NonNull Context context) {
        super(context);
        this.mTKLoadSuccess = false;
        init(context, null, 0);
    }

    public PushAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTKLoadSuccess = false;
        init(context, attributeSet, 0);
    }

    public PushAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mTKLoadSuccess = false;
        init(context, attributeSet, i2);
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        setTag(PUSH_VIEW_TAG);
        this.mViewVisibleHelper = new b(this, 100);
    }

    private void notifyPushAdClose() {
        an anVar = this.mCardLifecycleHandler;
        if (anVar != null) {
            anVar.rb();
            this.mCardLifecycleHandler.rc();
        }
    }

    private void notifyPushAdShow() {
        an anVar = this.mCardLifecycleHandler;
        if (anVar != null) {
            anVar.qZ();
            this.mCardLifecycleHandler.ra();
        }
    }

    public void bindView(AdTemplate adTemplate) {
        this.mPushAd = adTemplate;
        AnonymousClass1 anonymousClass1 = new h(-1L, getContext()) { // from class: com.kuaishou.pushad.PushAdView.1

            /* renamed from: com.kuaishou.pushad.PushAdView$1$1 */
            class C01161 extends p {
                C01161(com.kwad.sdk.core.webview.b bVar2, com.kwad.components.core.d.b.c cVar2, a this) {
                    super(bVar2, cVar2, this);
                }

                @Override // com.kwad.components.core.webview.jshandler.p
                public void afterHandleAdClick(int i2) {
                    super.afterHandleAdClick(i2);
                    if (i2 == 1) {
                        PushAdView.this.pageClose(null);
                    }
                }
            }

            AnonymousClass1(long j2, Context context) {
                super(j2, context);
            }

            @Override // com.kwad.components.core.webview.a.h
            public void onRegisterWebCardHandler(com.kwad.sdk.core.webview.b bVar2, com.kwad.components.core.d.b.c cVar2, l lVar, ViewGroup viewGroup) {
                super.onRegisterWebCardHandler(bVar2, cVar2, lVar, viewGroup);
                lVar.c(new p(bVar2, cVar2, this) { // from class: com.kuaishou.pushad.PushAdView.1.1
                    C01161(com.kwad.sdk.core.webview.b bVar22, com.kwad.components.core.d.b.c cVar22, a this) {
                        super(bVar22, cVar22, this);
                    }

                    @Override // com.kwad.components.core.webview.jshandler.p
                    public void afterHandleAdClick(int i2) {
                        super.afterHandleAdClick(i2);
                        if (i2 == 1) {
                            PushAdView.this.pageClose(null);
                        }
                    }
                });
            }
        };
        this.mTKLoadController = anonymousClass1;
        anonymousClass1.bind(null, adTemplate, this);
    }

    public void destroy() {
        this.mTKLoadController.unBind();
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this);
        }
    }

    @Override // com.kwad.components.core.webview.a.i
    public FrameLayout getTKContainer() {
        return this;
    }

    @Override // com.kwad.components.core.webview.a.i
    public String getTkTemplateId() {
        return j.b("ksad-push-card", this.mPushAd);
    }

    @Override // com.kwad.components.core.webview.a.i
    public e getTouchCoordsView() {
        return this;
    }

    public boolean isTKLoadSuccess() {
        return this.mTKLoadSuccess;
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onAdClicked(@Nullable com.kwad.sdk.core.webview.c.a.a aVar) {
        com.kwad.sdk.core.d.b.d(TAG, "onAdClicked");
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onCloseTKDialogClick() {
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onGetContainerLimited(u.a aVar) {
        float ax = com.kwad.sdk.c.kwai.a.ax(getContext());
        float screenHeight = com.kwad.sdk.c.kwai.a.getScreenHeight(getContext());
        aVar.width = (int) ((com.kwad.sdk.c.kwai.a.getScreenWidth(getContext()) / ax) + 0.5f);
        aVar.height = (int) ((screenHeight / ax) + 0.5f);
    }

    @Override // com.kwad.sdk.core.g.c
    public void onPageInvisible() {
        com.kwad.sdk.core.d.b.d(TAG, "onPageInvisible: ");
        an anVar = this.mCardLifecycleHandler;
        if (anVar != null) {
            anVar.re();
        }
    }

    @Override // com.kwad.sdk.core.g.c
    public void onPageVisible() {
        com.kwad.sdk.core.d.b.d(TAG, "onPageVisible: ");
        an anVar = this.mCardLifecycleHandler;
        if (anVar != null) {
            anVar.rd();
        }
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onRegisterLifecycleLisener(an anVar) {
        this.mCardLifecycleHandler = anVar;
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onRegisterVideoMuteStateListener(o oVar) {
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onRegisterVideoProgressListener(com.kwad.components.core.webview.a.kwai.p pVar, com.kwad.components.core.video.i iVar) {
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onRegisterWebCardHandler(l lVar, com.kwad.sdk.core.webview.b bVar) {
    }

    public boolean onShow() {
        if (!this.mTKLoadSuccess || this.mPushAd == null) {
            return false;
        }
        PushAdListener pushAdListener = this.mPushAdListener;
        if (pushAdListener != null) {
            pushAdListener.onPushAdViewShow();
        }
        notifyPushAdShow();
        return true;
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onSkipClick(com.kwad.components.core.webview.a.a.u uVar) {
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onTkLoadFailed() {
        com.kwad.sdk.core.d.b.d(TAG, "onTkLoadFailed");
        this.mTKLoadSuccess = false;
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onTkLoadSuccess() {
        com.kwad.sdk.core.d.b.d(TAG, "onTkLoadSuccess");
        this.mTKLoadSuccess = true;
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onUpdateMuteStatus(m mVar) {
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void onViewAttached() {
        super.onViewAttached();
        this.mViewVisibleHelper.a(this);
        this.mViewVisibleHelper.rD();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void onViewDetached() {
        super.onViewDetached();
        this.mViewVisibleHelper.release();
    }

    @Override // com.kwad.components.core.webview.a.i
    public void pageClose(@Nullable WebCloseStatus webCloseStatus) {
        PushAdListener pushAdListener = this.mPushAdListener;
        if (pushAdListener != null) {
            pushAdListener.onPushAdViewClose();
        }
        notifyPushAdClose();
    }

    public void setListener(PushAdListener pushAdListener) {
        this.mPushAdListener = pushAdListener;
    }
}
