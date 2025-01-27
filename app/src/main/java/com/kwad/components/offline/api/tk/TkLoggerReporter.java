package com.kwad.components.offline.api.tk;

import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class TkLoggerReporter {

    static final class Holder {
        private static final TkLoggerReporter sInstance = new TkLoggerReporter();

        private Holder() {
        }
    }

    private TkLoggerReporter() {
    }

    /* synthetic */ TkLoggerReporter(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static TkLoggerReporter get() {
        return Holder.sInstance;
    }

    private void reportEvent(String str, String str2, JSONObject jSONObject) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(str, BusinessType.TACHIKOMA, str2, jSONObject);
    }

    public final void reportTKDownload(String str, JSONObject jSONObject) {
        reportEvent(str, "ad_tk_download_performance", jSONObject);
    }

    public final void reportTKPerform(String str, JSONObject jSONObject) {
        reportEvent(str, "ad_tk_render_performance", jSONObject);
    }

    public final void reportTKSODownload(String str, JSONObject jSONObject) {
        reportEvent(str, "ad_tk_so_download_event", jSONObject);
    }

    public final void reportTKSOLoad(String str, JSONObject jSONObject) {
        reportEvent(str, "ad_tk_so_load_performence", jSONObject);
    }
}
