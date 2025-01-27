package com.kwad.components.offline.api.tk;

import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.sdk.commercial.c;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class TkLoggerReporter {

    public static final class Holder {
        private static final TkLoggerReporter sInstance = new TkLoggerReporter();

        private Holder() {
        }
    }

    public /* synthetic */ TkLoggerReporter(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static TkLoggerReporter get() {
        return Holder.sInstance;
    }

    private void reportEvent(String str, String str2, JSONObject jSONObject, c cVar) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(cVar);
    }

    public final void reportTKDownload(String str, JSONObject jSONObject) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(c.Cg().cB(str).i(0.1d).N("ad_tk_download_performance", "download_state").h(jSONObject));
    }

    public final void reportTKPerform(String str, JSONObject jSONObject) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(c.Cg().cB(str).i(0.1d).k(0.001d).N("ad_tk_render_performance", "render_state").h(jSONObject));
    }

    public final void reportTKSODownload(String str, JSONObject jSONObject) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(c.Cg().cB(str).i(0.1d).N("ad_tk_so_download_event", "download_state").h(jSONObject));
    }

    public final void reportTKSOLoad(String str, JSONObject jSONObject) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(c.Cg().cB(str).i(0.1d).N("ad_tk_so_load_performence", "download_state").h(jSONObject));
    }

    private TkLoggerReporter() {
    }
}
