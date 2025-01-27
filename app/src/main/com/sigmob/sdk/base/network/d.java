package com.sigmob.sdk.base.network;

import android.text.TextUtils;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.network.SigmobRequestUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.VolleyError;
import com.sigmob.sdk.base.l;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.windad.WindAdError;
import java.net.URL;
import java.util.List;

/* loaded from: classes4.dex */
public class d {

    public interface a {
        void a(int i10, String str, String str2, LoadAdRequest loadAdRequest);

        void a(List<BaseAdUnit> list, LoadAdRequest loadAdRequest);
    }

    public interface b {
        void onErrorResponse(VolleyError volleyError);

        void onSuccess();
    }

    public static void a(LoadAdRequest loadAdRequest, a aVar) {
        if (Networking.getSigRequestQueue() == null) {
            if (aVar != null) {
                aVar.a(WindAdError.ERROR_SIGMOB_NETWORK.getErrorCode(), "request queue is null", null, loadAdRequest);
                return;
            }
            return;
        }
        try {
            String j10 = l.w().j();
            try {
                if (!TextUtils.isEmpty(loadAdRequest.getBidToken())) {
                    j10 = l.w().v();
                }
            } catch (Throwable th2) {
                SigmobLog.e(th2.getMessage());
            }
            if (SigmobRequestUtil.isConnection(new URL(j10).getHost())) {
                Networking.getSigRequestQueue().add(new com.sigmob.sdk.base.network.a(j10, loadAdRequest, aVar));
            } else if (aVar != null) {
                aVar.a(WindAdError.ERROR_SIGMOB_NETWORK.getErrorCode(), "network is disconnection", null, loadAdRequest);
            }
        } catch (Throwable th3) {
            SigmobLog.e(th3.getMessage());
            if (aVar != null) {
                aVar.a(WindAdError.ERROR_SIGMOB_NETWORK.getErrorCode(), th3.getMessage(), null, loadAdRequest);
            }
        }
    }
}
