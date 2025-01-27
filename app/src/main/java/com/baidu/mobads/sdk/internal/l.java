package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.api.CpuChannelListManager;
import com.baidu.mobads.sdk.api.IAdInterListener;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class l extends ad {
    private CpuChannelListManager.CpuChannelListListener q;
    private String r;
    private int s;

    public l(Context context) {
        super(context);
    }

    public void a(CpuChannelListManager.CpuChannelListListener cpuChannelListListener) {
        this.q = cpuChannelListListener;
    }

    public void a(String str, int i2) {
        this.r = str;
        this.s = i2;
    }

    @Override // com.baidu.mobads.sdk.internal.ad, com.baidu.mobads.sdk.internal.bf
    public void a() {
        if (this.k == null) {
            this.l = false;
            return;
        }
        this.l = true;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, "cpu");
            this.k.createProdHandler(jSONObject2);
            m mVar = new m(this);
            this.k.addEventListener(w.an, mVar);
            this.k.addEventListener(w.ao, mVar);
            jSONObject.put("appsid", this.r);
            jSONObject.put("subChannelId", this.s);
            jSONObject.put("event_type", "cpu_channelIds");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        a(jSONObject);
    }
}
