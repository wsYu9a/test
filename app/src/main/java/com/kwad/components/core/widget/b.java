package com.kwad.components.core.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.widget.a;
import com.kwad.components.core.widget.c;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.j.k;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.widget.KSFrameLayout;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class b<T extends AdTemplate> extends KSFrameLayout implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener, com.kwad.sdk.core.g.c {
    public a VS;
    private long VT;
    private com.kwad.sdk.core.g.b ca;
    public AdInfo mAdInfo;

    @NonNull
    public T mAdTemplate;

    @NonNull
    public Context mContext;
    protected boolean mN;
    private bh mTimerHelper;
    private com.kwad.components.core.widget.kwai.b mViewVisibleHelper;

    /* renamed from: com.kwad.components.core.widget.b$1 */
    final class AnonymousClass1 implements a.InterfaceC0197a {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.widget.a.InterfaceC0197a
        public final void eM() {
            b bVar = b.this;
            if (bVar.mAdTemplate.mPvReported && bVar.mN) {
                long EZ = bVar.getTimerHelper().EZ();
                b.this.VT += EZ;
                com.kwad.sdk.core.report.a.a(b.this.mAdTemplate, EZ, (JSONObject) null);
                b.this.mN = false;
            }
        }

        @Override // com.kwad.components.core.widget.a.InterfaceC0197a
        public final void k(View view) {
            b bVar = b.this;
            if (!bVar.mAdTemplate.mPvReported && bVar.VS != null) {
                bVar.mN = true;
                bVar.bC();
                b.this.getTimerHelper().startTiming();
            }
            b bVar2 = b.this;
            if (!bVar2.mN) {
                bVar2.getTimerHelper().startTiming();
            }
            b.this.mN = true;
        }

        @Override // com.kwad.components.core.widget.a.InterfaceC0197a
        public final void onViewAttached() {
        }

        @Override // com.kwad.components.core.widget.a.InterfaceC0197a
        public final void onViewDetached() {
            b bVar = b.this;
            if (bVar.mAdTemplate.mPvReported && bVar.mN) {
                long EZ = bVar.getTimerHelper().EZ();
                b.this.VT += EZ;
                com.kwad.sdk.core.report.a.a(b.this.mAdTemplate, EZ, (JSONObject) null);
                b.this.mN = false;
            }
        }
    }

    /* renamed from: com.kwad.components.core.widget.b$2 */
    final class AnonymousClass2 implements c.a {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.core.widget.c.a
        public final void eN() {
            b.this.bC();
        }
    }

    public interface a {
        void onAdClicked();

        void onAdShow();

        void onDislikeClicked();

        void onDownloadTipsDialogDismiss();

        void onDownloadTipsDialogShow();
    }

    public b(@NonNull Context context) {
        this(context, null);
    }

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mContext = context;
        initView();
    }

    private void a(ViewGroup viewGroup) {
        if (!com.kwad.sdk.core.config.d.uH() && com.kwad.sdk.core.config.d.uG() >= 0.0f) {
            c(viewGroup);
            com.kwad.components.core.widget.a aVar = new com.kwad.components.core.widget.a(viewGroup.getContext(), viewGroup);
            viewGroup.addView(aVar);
            aVar.setViewCallback(new a.InterfaceC0197a() { // from class: com.kwad.components.core.widget.b.1
                AnonymousClass1() {
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0197a
                public final void eM() {
                    b bVar = b.this;
                    if (bVar.mAdTemplate.mPvReported && bVar.mN) {
                        long EZ = bVar.getTimerHelper().EZ();
                        b.this.VT += EZ;
                        com.kwad.sdk.core.report.a.a(b.this.mAdTemplate, EZ, (JSONObject) null);
                        b.this.mN = false;
                    }
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0197a
                public final void k(View view) {
                    b bVar = b.this;
                    if (!bVar.mAdTemplate.mPvReported && bVar.VS != null) {
                        bVar.mN = true;
                        bVar.bC();
                        b.this.getTimerHelper().startTiming();
                    }
                    b bVar2 = b.this;
                    if (!bVar2.mN) {
                        bVar2.getTimerHelper().startTiming();
                    }
                    b.this.mN = true;
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0197a
                public final void onViewAttached() {
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0197a
                public final void onViewDetached() {
                    b bVar = b.this;
                    if (bVar.mAdTemplate.mPvReported && bVar.mN) {
                        long EZ = bVar.getTimerHelper().EZ();
                        b.this.VT += EZ;
                        com.kwad.sdk.core.report.a.a(b.this.mAdTemplate, EZ, (JSONObject) null);
                        b.this.mN = false;
                    }
                }
            });
            aVar.rt();
            return;
        }
        c b2 = b(viewGroup);
        if (b2 == null) {
            b2 = new c(viewGroup.getContext(), viewGroup);
            viewGroup.addView(b2);
        }
        b2.setViewCallback(new c.a() { // from class: com.kwad.components.core.widget.b.2
            AnonymousClass2() {
            }

            @Override // com.kwad.components.core.widget.c.a
            public final void eN() {
                b.this.bC();
            }
        });
        b2.setNeedCheckingShow(true);
    }

    private static c b(ViewGroup viewGroup) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof c) {
                return (c) childAt;
            }
        }
        return null;
    }

    public static void c(ViewGroup viewGroup) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof com.kwad.components.core.widget.a) {
                viewGroup.removeView(childAt);
            }
        }
    }

    private void initView() {
        k.inflate(this.mContext, getLayoutId(), this);
        setRatio(getHWRatio());
        bk();
        this.mViewVisibleHelper = new com.kwad.components.core.widget.kwai.b(this, 70);
        a((ViewGroup) this);
    }

    public final void aL(int i2) {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, i2, getTouchCoords());
        a aVar = this.VS;
        if (aVar != null) {
            aVar.onAdClicked();
        }
    }

    protected void bC() {
        a aVar;
        if (!this.mAdTemplate.mPvReported && (aVar = this.VS) != null) {
            aVar.onAdShow();
        }
        i iVar = new i();
        y.a aVar2 = new y.a();
        FeedType fromInt = FeedType.fromInt(this.mAdTemplate.type);
        if (fromInt == FeedType.FEED_TYPE_TEXT_NEW) {
            fromInt = FeedType.FEED_TYPE_TEXT_BELOW;
        }
        aVar2.templateId = String.valueOf(fromInt.getType());
        iVar.a(aVar2);
        iVar.q(getHeight(), getWidth());
        com.kwad.components.core.r.b.pK().a(this.mAdTemplate, null, iVar);
    }

    public void bindView(@NonNull T t) {
        this.mAdTemplate = t;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(t);
    }

    protected abstract void bk();

    public void bn() {
    }

    public final void c(@NonNull i iVar) {
        iVar.c(getTouchCoords());
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, iVar, (JSONObject) null);
        a aVar = this.VS;
        if (aVar != null) {
            aVar.onAdClicked();
        }
    }

    public final void eh() {
        a aVar = this.VS;
        if (aVar != null) {
            aVar.onAdClicked();
        }
    }

    protected float getHWRatio() {
        return 0.0f;
    }

    protected abstract int getLayoutId();

    public long getStayTime() {
        return this.VT + getTimerHelper().getTime();
    }

    public bh getTimerHelper() {
        if (this.mTimerHelper == null) {
            this.mTimerHelper = new bh();
        }
        return this.mTimerHelper;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        a aVar = this.VS;
        if (aVar != null) {
            aVar.onDownloadTipsDialogDismiss();
        }
    }

    public void onPageInvisible() {
    }

    public void onPageVisible() {
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        a aVar = this.VS;
        if (aVar != null) {
            aVar.onDownloadTipsDialogShow();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void onViewAttached() {
        super.onViewAttached();
        this.mViewVisibleHelper.a(this);
        this.mViewVisibleHelper.a(this.ca);
        this.mViewVisibleHelper.rD();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void onViewDetached() {
        super.onViewDetached();
        this.mViewVisibleHelper.b(this);
        this.mViewVisibleHelper.rE();
        bn();
    }

    public final void ru() {
        com.kwad.sdk.core.report.a.ao(this.mAdTemplate);
        a aVar = this.VS;
        if (aVar != null) {
            aVar.onDislikeClicked();
        }
    }

    public void setInnerAdInteractionListener(a aVar) {
        this.VS = aVar;
    }

    public void setMargin(int i2) {
        setPadding(i2, i2, i2, i2);
        setBackgroundColor(-1);
    }

    public void setPageExitListener(com.kwad.sdk.core.g.b bVar) {
        this.ca = bVar;
    }
}
