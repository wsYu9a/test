package com.heytap.msp.mobad.api.listener;

import com.heytap.msp.mobad.api.params.INativeAdvanceData;
import java.util.List;

/* loaded from: classes.dex */
public interface INativeAdvanceLoadListener {
    void onAdFailed(int i2, String str);

    void onAdSuccess(List<INativeAdvanceData> list);
}
