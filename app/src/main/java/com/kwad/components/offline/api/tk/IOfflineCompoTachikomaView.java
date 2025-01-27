package com.kwad.components.offline.api.tk;

import android.view.View;
import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoBridgeHandler;
import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoTKBridgeHandler;
import java.util.Map;

/* loaded from: classes2.dex */
public interface IOfflineCompoTachikomaView {
    Object execute(String str);

    void execute(String str, String str2, IOfflineTKRenderListener iOfflineTKRenderListener);

    int getUniqId();

    View getView();

    void onDestroy();

    void registerHostActionHandler(IOfflineHostActionHandler iOfflineHostActionHandler);

    void registerJsBridge(IOfflineCompoBridgeHandler iOfflineCompoBridgeHandler);

    void registerTKBridge(IOfflineCompoTKBridgeHandler iOfflineCompoTKBridgeHandler);

    void setCustomEnv(Map<String, Object> map);

    void unregisterJsBridge();
}
