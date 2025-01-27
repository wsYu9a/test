package com.vivo.advv.vaf.virtualview.event;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class ClickProcessorManager {
    private static final String TAG = "CliProManager_TMTEST";
    private IClickProcessor mDefaultProcessor;
    private ConcurrentHashMap<String, IClickProcessor> mProcessors = new ConcurrentHashMap<>();

    public boolean process(EventData eventData) {
        if (eventData != null) {
            String optString = eventData.mVB.getViewCache().getComponentData() instanceof JSONObject ? ((JSONObject) eventData.mVB.getViewCache().getComponentData()).optString("type") : null;
            if (!TextUtils.isEmpty(optString)) {
                IClickProcessor iClickProcessor = this.mProcessors.get(optString);
                if (iClickProcessor != null) {
                    return iClickProcessor.process(eventData);
                }
                IClickProcessor iClickProcessor2 = this.mDefaultProcessor;
                if (iClickProcessor2 != null) {
                    return iClickProcessor2.process(eventData);
                }
            }
        }
        return false;
    }

    public void register(String str, IClickProcessor iClickProcessor) {
        if (TextUtils.isEmpty(str) || iClickProcessor == null) {
            return;
        }
        this.mProcessors.put(str, iClickProcessor);
    }

    public void registerDefault(IClickProcessor iClickProcessor) {
        if (iClickProcessor != null) {
            this.mDefaultProcessor = iClickProcessor;
        }
    }

    public void unregister(String str) {
        this.mProcessors.remove(str);
    }

    public void unregisterDefault() {
        this.mDefaultProcessor = null;
    }
}
