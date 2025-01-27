package com.kwad.components.offline.api.core.adlive.listener;

import com.kwad.components.offline.api.core.adlive.model.AdLiveMessageInfo;
import java.util.List;

/* loaded from: classes2.dex */
public interface AdLiveMessageListener {
    void handleAdLiveMessage(List<AdLiveMessageInfo> list);
}
