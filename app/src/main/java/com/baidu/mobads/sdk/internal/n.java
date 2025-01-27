package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.CpuChannelListManager;
import com.baidu.mobads.sdk.api.CpuChannelResponse;
import com.baidu.mobads.sdk.api.IOAdEvent;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: classes.dex */
class n implements Runnable {

    /* renamed from: a */
    final /* synthetic */ IOAdEvent f5831a;

    /* renamed from: b */
    final /* synthetic */ m f5832b;

    n(m mVar, IOAdEvent iOAdEvent) {
        this.f5832b = mVar;
        this.f5831a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        CpuChannelListManager.CpuChannelListListener cpuChannelListListener;
        CpuChannelListManager.CpuChannelListListener cpuChannelListListener2;
        CpuChannelListManager.CpuChannelListListener cpuChannelListListener3;
        CpuChannelListManager.CpuChannelListListener cpuChannelListListener4;
        IOAdEvent iOAdEvent = this.f5831a;
        if (iOAdEvent == null || TextUtils.isEmpty(iOAdEvent.getType())) {
            return;
        }
        String type = this.f5831a.getType();
        if (w.an.equals(type)) {
            List<CpuChannelResponse> a2 = k.a((JSONArray) this.f5831a.getData().get("cpuChannelList"));
            cpuChannelListListener3 = this.f5832b.f5830a.q;
            if (cpuChannelListListener3 != null) {
                cpuChannelListListener4 = this.f5832b.f5830a.q;
                cpuChannelListListener4.onChannelListLoaded(a2);
                return;
            }
            return;
        }
        if (w.ao.equals(type)) {
            Map<String, Object> data = this.f5831a.getData();
            int i2 = 0;
            if (data != null) {
                str = (String) data.get("error_message");
                Object obj = data.get("error_code");
                if (obj == null) {
                    obj = 0;
                }
                i2 = ((Integer) obj).intValue();
            } else {
                str = "";
            }
            cpuChannelListListener = this.f5832b.f5830a.q;
            if (cpuChannelListListener != null) {
                cpuChannelListListener2 = this.f5832b.f5830a.q;
                cpuChannelListListener2.onChannelListError(str, i2);
            }
        }
    }
}
