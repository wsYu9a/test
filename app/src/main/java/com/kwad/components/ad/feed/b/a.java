package com.kwad.components.ad.feed.b;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes2.dex */
public abstract class a extends com.kwad.components.core.widget.b<AdResultData, AdTemplate> {
    private boolean fP;
    protected long fQ;
    private float fR;
    private float fS;
    private int fT;
    private MotionEvent fU;
    protected SimpleImageLoadingListener fV;

    /* renamed from: com.kwad.components.ad.feed.b.a$1 */
    public class AnonymousClass1 extends SimpleImageLoadingListener {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
            com.kwad.components.ad.feed.monitor.b.a(a.this.mAdTemplate, 1, 2, str, null, SystemClock.elapsedRealtime() - a.this.fQ);
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingFailed(String str, View view, FailReason failReason) {
            com.kwad.components.ad.feed.monitor.b.a(a.this.mAdTemplate, 2, 2, str, failReason.toString(), SystemClock.elapsedRealtime() - a.this.fQ);
        }
    }

    public a(@NonNull Context context) {
        super(context);
        this.fT = 0;
        this.fV = new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.feed.b.a.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                com.kwad.components.ad.feed.monitor.b.a(a.this.mAdTemplate, 1, 2, str, null, SystemClock.elapsedRealtime() - a.this.fQ);
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view, FailReason failReason) {
                com.kwad.components.ad.feed.monitor.b.a(a.this.mAdTemplate, 2, 2, str, failReason.toString(), SystemClock.elapsedRealtime() - a.this.fQ);
            }
        };
    }

    public final void bC() {
        if (this.fP) {
            return;
        }
        this.fP = true;
        com.kwad.components.ad.feed.monitor.b.a(this.mAdTemplate, 1, getStayTime());
    }

    public final void bD() {
        ComplianceTextView complianceTextView = (ComplianceTextView) findViewById(R.id.ksad_compliance_view);
        if (!com.kwad.sdk.core.response.b.a.aP(this.mAdInfo)) {
            complianceTextView.setVisibility(8);
        } else {
            complianceTextView.setVisibility(0);
            complianceTextView.setAdTemplate(this.mAdTemplate);
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.fR = motionEvent.getX();
            this.fS = motionEvent.getY();
            this.fU = MotionEvent.obtain(motionEvent);
            this.fT = 0;
        }
        if ((action == 1 || action == 3) && (Math.abs(motionEvent.getX() - this.fR) > 20.0f || Math.abs(motionEvent.getY() - this.fS) > 20.0f)) {
            if (!com.kwad.sdk.utils.b.a(this.fU, motionEvent, this.mAdTemplate)) {
                return true;
            }
            if (action == 3 && this.fT == 0) {
                motionEvent.setAction(1);
                this.fT = 1;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
