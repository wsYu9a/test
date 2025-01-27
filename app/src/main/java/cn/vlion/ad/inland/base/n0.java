package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import java.util.UUID;

/* loaded from: classes.dex */
public final class n0 {

    /* renamed from: a */
    public String f3107a;

    /* renamed from: b */
    public String f3108b;

    /* renamed from: c */
    public String f3109c;

    public n0(String str, String str2) {
        try {
            this.f3107a = System.currentTimeMillis() + hf.e.f26694a + UUID.randomUUID().toString();
            this.f3108b = str;
            this.f3109c = str2;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public n0(String str, String str2, String str3) {
        this.f3107a = str;
        this.f3108b = str2;
        this.f3109c = str3;
    }
}
