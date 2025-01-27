package com.sigmob.sdk.base.network;

import android.text.TextUtils;
import com.czhj.sdk.common.track.AdTracker;
import com.czhj.sdk.common.track.TrackManager;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.VolleyError;
import com.sigmob.sdk.Sigmob;
import com.sigmob.sdk.base.common.b0;
import com.sigmob.sdk.base.common.e0;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.SigMacroCommon;
import java.util.List;

/* loaded from: classes4.dex */
public class f {

    public class a implements TrackManager.Listener {

        /* renamed from: a */
        public final /* synthetic */ boolean f18340a;

        /* renamed from: b */
        public final /* synthetic */ String f18341b;

        /* renamed from: c */
        public final /* synthetic */ BaseAdUnit f18342c;

        /* renamed from: d */
        public final /* synthetic */ TrackManager.Listener f18343d;

        public a(boolean z10, String str, BaseAdUnit baseAdUnit, TrackManager.Listener listener) {
            this.f18340a = z10;
            this.f18341b = str;
            this.f18342c = baseAdUnit;
            this.f18343d = listener;
        }

        @Override // com.czhj.sdk.common.track.TrackManager.Listener
        public void onErrorResponse(AdTracker adTracker, VolleyError volleyError) {
            if (this.f18340a) {
                b0.a(adTracker, this.f18341b, this.f18342c, volleyError);
            }
            TrackManager.Listener listener = this.f18343d;
            if (listener != null) {
                listener.onErrorResponse(adTracker, volleyError);
            }
        }

        @Override // com.czhj.sdk.common.track.TrackManager.Listener
        public void onSuccess(AdTracker adTracker, NetworkResponse networkResponse) {
            if (this.f18340a) {
                b0.a(adTracker, this.f18341b, this.f18342c, networkResponse, (b0.g) null);
            }
            TrackManager.Listener listener = this.f18343d;
            if (listener != null) {
                listener.onSuccess(adTracker, networkResponse);
            }
        }
    }

    public static int a(BaseAdUnit baseAdUnit, String str, boolean z10) {
        if (baseAdUnit == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str)) {
            return -1;
        }
        List<e0> adTracker = baseAdUnit.getAdTracker(str);
        if (adTracker == null || adTracker.isEmpty()) {
            return -2;
        }
        for (e0 e0Var : adTracker) {
            if (z10) {
                e0Var.setSource("js");
            }
            baseAdUnit.getMacroCommon().addMarcoKey(SigMacroCommon._PLAYFIRSTFRAME_, "1");
            a((AdTracker) e0Var, baseAdUnit, false);
        }
        return 0;
    }

    public static void b(BaseAdUnit baseAdUnit, String str, boolean z10) {
        List<e0> adTracker;
        if (str == null || baseAdUnit == null || TextUtils.isEmpty(str) || (adTracker = baseAdUnit.getAdTracker(str)) == null) {
            return;
        }
        for (e0 e0Var : adTracker) {
            baseAdUnit.getMacroCommon().addMarcoKey(SigMacroCommon._PLAYFIRSTFRAME_, "1");
            a(e0Var, baseAdUnit, z10);
        }
    }

    public static void a(AdTracker adTracker, BaseAdUnit baseAdUnit, boolean z10) {
        a(adTracker, baseAdUnit, z10, true, true, null);
    }

    public static void a(AdTracker adTracker, BaseAdUnit baseAdUnit, boolean z10, boolean z11, boolean z12, TrackManager.Listener listener) {
        if (adTracker == null || adTracker.getMessageType() != AdTracker.MessageType.TRACKING_URL) {
            return;
        }
        if (!adTracker.isTracked() || z10) {
            String url = adTracker.getUrl();
            String macroProcess = baseAdUnit != null ? baseAdUnit.getMacroCommon().macroProcess(url, Sigmob.getInstance().getMacroCommon().getMacroMap()) : Sigmob.getInstance().getMacroCommon().macroProcess(url);
            adTracker.setUrl(macroProcess);
            TrackManager.sendTracking(adTracker, null, z10, z11, new a(z12, macroProcess, baseAdUnit, listener));
        }
    }

    public static void a(BaseAdUnit baseAdUnit, String str) {
        b(baseAdUnit, str, false);
    }
}
