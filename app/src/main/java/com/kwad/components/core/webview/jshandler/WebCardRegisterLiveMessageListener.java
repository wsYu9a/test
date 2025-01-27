package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.core.adlive.model.AdLiveMessageInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class WebCardRegisterLiveMessageListener implements com.kwad.sdk.core.webview.b.a {
    private com.kwad.sdk.core.webview.b.c Sb;

    @KsJson
    public static final class AdLiveMessageInfoList extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = -9127181276274466179L;
        public List<AdLiveMessageItemInfo> adLiveMessageInfos;

        @KsJson
        public static final class AdLiveMessageItemInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
            private static final long serialVersionUID = 1943278809007082732L;
            public String content;
            public String userName;
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "registerLiveMessageListener";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        com.kwad.sdk.core.d.b.d("TAGGG", "recive CallBack ");
        this.Sb = cVar;
    }

    public final void j(List<AdLiveMessageInfo> list) {
        com.kwad.sdk.core.d.b.d("TAGGG", "size " + list.size());
        if (this.Sb == null) {
            return;
        }
        AdLiveMessageInfoList adLiveMessageInfoList = new AdLiveMessageInfoList();
        adLiveMessageInfoList.adLiveMessageInfos = new ArrayList();
        for (AdLiveMessageInfo adLiveMessageInfo : list) {
            AdLiveMessageInfoList.AdLiveMessageItemInfo adLiveMessageItemInfo = new AdLiveMessageInfoList.AdLiveMessageItemInfo();
            adLiveMessageItemInfo.userName = adLiveMessageInfo.userName;
            adLiveMessageItemInfo.content = adLiveMessageInfo.content;
            adLiveMessageInfoList.adLiveMessageInfos.add(adLiveMessageItemInfo);
        }
        com.kwad.sdk.core.d.b.d("TAGGG", "size " + adLiveMessageInfoList.toJson().toString());
        this.Sb.a(adLiveMessageInfoList);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.Sb = null;
    }
}
