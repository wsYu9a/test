package com.aggmoread.sdk.b;

import com.aggmoread.sdk.client.AMAdDownloadConfirmListener;
import com.aggmoread.sdk.client.AMAdExtras;
import com.aggmoread.sdk.client.AMAdInterface;
import com.aggmoread.sdk.client.AMConst;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class c implements AMAdInterface {

    /* renamed from: a */
    private com.aggmoread.sdk.z.d.a.a.c.a f4079a;

    public c(com.aggmoread.sdk.z.d.a.a.c.a aVar, d dVar) {
        this.f4079a = aVar;
    }

    public abstract Map<String, Object> a();

    @Override // com.aggmoread.sdk.client.AMAdInterface
    public final AMAdExtras getAdExtras() {
        return new AMAdExtras(a());
    }

    @Override // com.aggmoread.sdk.client.AMAdInterface
    public int getEcpm() {
        Map<String, Object> a10 = a();
        if (a10 == null) {
            return -1;
        }
        Object obj = a10.get(AMConst.ExtrasKey.AD_PRICE);
        if (!(obj instanceof String)) {
            return -1;
        }
        try {
            return Integer.parseInt((String) obj);
        } catch (Exception unused) {
            return -1;
        }
    }

    @Override // com.aggmoread.sdk.client.AMAdInterface
    public String getID() {
        return this.f4079a.getID();
    }

    @Override // com.aggmoread.sdk.client.AMAdInterface
    public String getSource() {
        Map<String, Object> a10 = a();
        if (a10 == null) {
            return "unknown";
        }
        Object obj = a10.get("EXTRA_KEY_network_name_text");
        return obj instanceof String ? (String) obj : "unknown";
    }

    @Override // com.aggmoread.sdk.client.AMAdInterface
    public void notifyBidFail(int i10, int i11, String str) {
        this.f4079a.a(i10, i11, str);
    }

    @Override // com.aggmoread.sdk.client.AMAdInterface
    public void notifyBidSuccess(int i10) {
        this.f4079a.a(i10);
    }

    @Override // com.aggmoread.sdk.client.AMAdInterface
    public void setDownloadConfirmListener(AMAdDownloadConfirmListener aMAdDownloadConfirmListener) {
        this.f4079a.a(new b(aMAdDownloadConfirmListener));
    }
}
