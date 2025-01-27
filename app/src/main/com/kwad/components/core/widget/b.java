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
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.m;
import com.kwad.sdk.utils.bs;
import com.kwad.sdk.widget.KSFrameLayout;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class b<T extends AdResultData, R extends AdTemplate> extends KSFrameLayout implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener, com.kwad.sdk.core.h.c {
    public a aer;
    private long aes;

    /* renamed from: dh */
    private com.kwad.components.core.widget.a.b f11962dh;

    /* renamed from: dk */
    private com.kwad.sdk.core.h.b f11963dk;
    public AdInfo mAdInfo;

    @NonNull
    protected T mAdResultData;

    @NonNull
    public R mAdTemplate;

    @NonNull
    public Context mContext;
    private bs mTimerHelper;
    protected boolean nH;

    /* renamed from: com.kwad.components.core.widget.b$1 */
    public class AnonymousClass1 implements a.InterfaceC0457a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.widget.a.InterfaceC0457a
        public final void Z() {
        }

        @Override // com.kwad.components.core.widget.a.InterfaceC0457a
        public final void aa() {
            if (b.this.mAdTemplate.mPvReported) {
                b bVar = b.this;
                if (bVar.nH) {
                    long Pp = bVar.getTimerHelper().Pp();
                    b.a(b.this, Pp);
                    com.kwad.sdk.core.adlog.c.a(b.this.mAdTemplate, Pp, (JSONObject) null);
                    b.this.nH = false;
                }
            }
        }

        @Override // com.kwad.components.core.widget.a.InterfaceC0457a
        public final void ax() {
            if (b.this.mAdTemplate.mPvReported) {
                b bVar = b.this;
                if (bVar.nH) {
                    long Pp = bVar.getTimerHelper().Pp();
                    b.a(b.this, Pp);
                    com.kwad.sdk.core.adlog.c.a(b.this.mAdTemplate, Pp, (JSONObject) null);
                    b.this.nH = false;
                }
            }
        }

        @Override // com.kwad.components.core.widget.a.InterfaceC0457a
        public final void c(View view) {
            if (!b.this.mAdTemplate.mPvReported) {
                b bVar = b.this;
                if (bVar.aer != null) {
                    bVar.nH = true;
                    bVar.V();
                    b.this.getTimerHelper().startTiming();
                }
            }
            b bVar2 = b.this;
            if (!bVar2.nH) {
                bVar2.getTimerHelper().startTiming();
            }
            b.this.nH = true;
        }

        @Override // com.kwad.components.core.widget.a.InterfaceC0457a
        public final void onWindowFocusChanged(boolean z10) {
        }
    }

    /* renamed from: com.kwad.components.core.widget.b$2 */
    public class AnonymousClass2 implements c.a {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.widget.c.a
        public final void eK() {
            b.this.V();
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

    public static /* synthetic */ long a(b bVar, long j10) {
        long j11 = bVar.aes + j10;
        bVar.aes = j11;
        return j11;
    }

    private static c b(ViewGroup viewGroup) {
        for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt instanceof c) {
                return (c) childAt;
            }
        }
        return null;
    }

    private void initView() {
        m.inflate(this.mContext, getLayoutId(), this);
        setRatio(getHWRatio());
        bE();
        this.f11962dh = new com.kwad.components.core.widget.a.b(this, 70);
    }

    public void V() {
        a aVar;
        if (!this.mAdTemplate.mPvReported && (aVar = this.aer) != null) {
            aVar.onAdShow();
        }
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        a.C0484a c0484a = new a.C0484a();
        FeedType fromInt = FeedType.fromInt(this.mAdTemplate.type);
        if (fromInt == FeedType.FEED_TYPE_TEXT_NEW) {
            fromInt = FeedType.FEED_TYPE_TEXT_BELOW;
        }
        c0484a.templateId = String.valueOf(fromInt.getType());
        bVar.b(c0484a);
        bVar.v(getHeight(), getWidth());
        com.kwad.components.core.s.b.sc().a(this.mAdTemplate, null, bVar);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void Z() {
        super.Z();
        this.f11962dh.a(this);
        this.f11962dh.a(this.f11963dk);
        this.f11962dh.uE();
    }

    public final void aM(int i10) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, i10, getTouchCoords());
        a aVar = this.aer;
        if (aVar != null) {
            aVar.onAdClicked();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void aa() {
        super.aa();
        this.f11962dh.uF();
        this.f11962dh.b(this);
        bH();
    }

    public abstract void bE();

    public void bH() {
    }

    public void bl() {
    }

    public void bm() {
    }

    public void c(@NonNull T t10) {
        this.mAdResultData = t10;
        R r10 = (R) com.kwad.sdk.core.response.b.c.o(t10);
        this.mAdTemplate = r10;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eb(r10);
        a(this);
    }

    public float getHWRatio() {
        return 0.0f;
    }

    public abstract int getLayoutId();

    public long getStayTime() {
        return this.aes + getTimerHelper().getTime();
    }

    public bs getTimerHelper() {
        if (this.mTimerHelper == null) {
            this.mTimerHelper = new bs();
        }
        return this.mTimerHelper;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        a aVar = this.aer;
        if (aVar != null) {
            aVar.onDownloadTipsDialogDismiss();
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        a aVar = this.aer;
        if (aVar != null) {
            aVar.onDownloadTipsDialogShow();
        }
    }

    public void setInnerAdInteractionListener(a aVar) {
        this.aer = aVar;
    }

    public void setMargin(int i10) {
        setPadding(i10, i10, i10, i10);
        if (com.kwad.sdk.core.config.d.Ei()) {
            return;
        }
        setBackgroundColor(-1);
    }

    public void setPageExitListener(com.kwad.sdk.core.h.b bVar) {
        this.f11963dk = bVar;
    }

    public final boolean uq() {
        int i10 = this.mAdInfo.status;
        return (i10 == 2 || i10 == 3) ? false : true;
    }

    public final void ur() {
        a aVar = this.aer;
        if (aVar != null) {
            aVar.onAdClicked();
        }
    }

    public final void us() {
        com.kwad.sdk.core.adlog.c.bM(this.mAdTemplate);
        a aVar = this.aer;
        if (aVar != null) {
            aVar.onDislikeClicked();
        }
    }

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(ViewGroup viewGroup) {
        if (!com.kwad.sdk.core.config.d.DN() && com.kwad.sdk.core.config.d.DM() >= 0.0f) {
            c(viewGroup);
            com.kwad.components.core.widget.a aVar = new com.kwad.components.core.widget.a(viewGroup.getContext(), viewGroup);
            viewGroup.addView(aVar);
            aVar.setViewCallback(new a.InterfaceC0457a() { // from class: com.kwad.components.core.widget.b.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0457a
                public final void Z() {
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0457a
                public final void aa() {
                    if (b.this.mAdTemplate.mPvReported) {
                        b bVar = b.this;
                        if (bVar.nH) {
                            long Pp = bVar.getTimerHelper().Pp();
                            b.a(b.this, Pp);
                            com.kwad.sdk.core.adlog.c.a(b.this.mAdTemplate, Pp, (JSONObject) null);
                            b.this.nH = false;
                        }
                    }
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0457a
                public final void ax() {
                    if (b.this.mAdTemplate.mPvReported) {
                        b bVar = b.this;
                        if (bVar.nH) {
                            long Pp = bVar.getTimerHelper().Pp();
                            b.a(b.this, Pp);
                            com.kwad.sdk.core.adlog.c.a(b.this.mAdTemplate, Pp, (JSONObject) null);
                            b.this.nH = false;
                        }
                    }
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0457a
                public final void c(View view) {
                    if (!b.this.mAdTemplate.mPvReported) {
                        b bVar = b.this;
                        if (bVar.aer != null) {
                            bVar.nH = true;
                            bVar.V();
                            b.this.getTimerHelper().startTiming();
                        }
                    }
                    b bVar2 = b.this;
                    if (!bVar2.nH) {
                        bVar2.getTimerHelper().startTiming();
                    }
                    b.this.nH = true;
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0457a
                public final void onWindowFocusChanged(boolean z10) {
                }
            });
            aVar.up();
            return;
        }
        c b10 = b(viewGroup);
        if (b10 == null) {
            b10 = new c(viewGroup.getContext(), viewGroup);
            viewGroup.addView(b10);
        }
        b10.setViewCallback(new c.a() { // from class: com.kwad.components.core.widget.b.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.components.core.widget.c.a
            public final void eK() {
                b.this.V();
            }
        });
        b10.setNeedCheckingShow(true);
    }

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mContext = context;
        initView();
    }

    public static void c(ViewGroup viewGroup) {
        for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt instanceof com.kwad.components.core.widget.a) {
                viewGroup.removeView(childAt);
            }
        }
    }

    public final void c(@NonNull com.kwad.sdk.core.adlog.c.b bVar) {
        bVar.f(getTouchCoords());
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, bVar, (JSONObject) null);
        a aVar = this.aer;
        if (aVar != null) {
            aVar.onAdClicked();
        }
    }
}
