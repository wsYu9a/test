package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.CpuChannelListManager;
import com.baidu.mobads.sdk.api.CpuChannelResponse;
import com.baidu.mobads.sdk.api.IOAdEvent;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: classes2.dex */
class q implements Runnable {

    /* renamed from: a */
    final /* synthetic */ IOAdEvent f7229a;

    /* renamed from: b */
    final /* synthetic */ p f7230b;

    public q(p pVar, IOAdEvent iOAdEvent) {
        this.f7230b = pVar;
        this.f7229a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        CpuChannelListManager.CpuChannelListListener cpuChannelListListener;
        CpuChannelListManager.CpuChannelListListener cpuChannelListListener2;
        CpuChannelListManager.CpuChannelListListener cpuChannelListListener3;
        CpuChannelListManager.CpuChannelListListener cpuChannelListListener4;
        IOAdEvent iOAdEvent = this.f7229a;
        if (iOAdEvent == null || TextUtils.isEmpty(iOAdEvent.getType())) {
            return;
        }
        String type = this.f7229a.getType();
        if (z.ap.equals(type)) {
            List<CpuChannelResponse> a10 = n.a((JSONArray) this.f7229a.getData().get("cpuChannelList"));
            cpuChannelListListener3 = this.f7230b.f7228a.f7225t;
            if (cpuChannelListListener3 != null) {
                cpuChannelListListener4 = this.f7230b.f7228a.f7225t;
                cpuChannelListListener4.onChannelListLoaded(a10);
                return;
            }
            return;
        }
        if (z.aq.equals(type)) {
            Map<String, Object> data = this.f7229a.getData();
            int i10 = 0;
            if (data != null) {
                str = (String) data.get("error_message");
                Object obj = data.get("error_code");
                if (obj == null) {
                    obj = 0;
                }
                i10 = ((Integer) obj).intValue();
            } else {
                str = "";
            }
            cpuChannelListListener = this.f7230b.f7228a.f7225t;
            if (cpuChannelListListener != null) {
                cpuChannelListListener2 = this.f7230b.f7228a.f7225t;
                cpuChannelListListener2.onChannelListError(str, i10);
            }
        }
    }
}
