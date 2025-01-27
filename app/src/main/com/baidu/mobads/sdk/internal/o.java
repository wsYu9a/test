package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.api.CpuChannelListManager;
import com.baidu.mobads.sdk.api.IAdInterListener;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class o extends ae {

    /* renamed from: t */
    private CpuChannelListManager.CpuChannelListListener f7225t;

    /* renamed from: u */
    private String f7226u;

    /* renamed from: v */
    private int f7227v;

    public o(Context context) {
        super(context);
    }

    public void a(CpuChannelListManager.CpuChannelListListener cpuChannelListListener) {
        this.f7225t = cpuChannelListListener;
    }

    public void a(String str, int i10) {
        this.f7226u = str;
        this.f7227v = i10;
    }

    @Override // com.baidu.mobads.sdk.internal.ae, com.baidu.mobads.sdk.internal.bi
    public void a() {
        if (this.f6884m == null) {
            this.f6885n = false;
            return;
        }
        this.f6885n = true;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, "cpu");
            this.f6884m.createProdHandler(jSONObject2);
            p pVar = new p(this);
            this.f6884m.addEventListener(z.ap, pVar);
            this.f6884m.addEventListener(z.aq, pVar);
            jSONObject.put("appsid", this.f7226u);
            jSONObject.put("subChannelId", this.f7227v);
            jSONObject.put("event_type", "cpu_channelIds");
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        a(jSONObject);
    }
}
