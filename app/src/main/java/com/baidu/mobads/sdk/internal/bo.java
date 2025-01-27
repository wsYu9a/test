package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.baidu.mobads.sdk.internal.bz;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class bo {

    /* renamed from: a */
    public static final String f6918a = "ContainerFactoryBuilder";

    /* renamed from: e */
    private static IXAdContainerFactory f6919e;

    /* renamed from: c */
    private Context f6921c;

    /* renamed from: d */
    private Class<?> f6922d;

    /* renamed from: b */
    public double f6920b = 0.1d;

    /* renamed from: f */
    private bt f6923f = bt.a();

    public bo(Class<?> cls, Context context) {
        this.f6922d = null;
        this.f6922d = cls;
        this.f6921c = context;
    }

    public IXAdContainerFactory a() {
        if (f6919e == null) {
            try {
                f6919e = (IXAdContainerFactory) this.f6922d.getDeclaredConstructor(Context.class).newInstance(this.f6921c);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(com.umeng.analytics.pro.bt.bl, "9.3711");
                f6919e.initConfig(jSONObject);
                this.f6920b = f6919e.getRemoteVersion();
                f6919e.onTaskDistribute(bc.f6856a, MobadsPermissionSettings.getPermissionInfo());
                f6919e.initCommonModuleObj(t.a());
            } catch (Throwable th2) {
                this.f6923f.b(f6918a, th2.getMessage());
                throw new bz.a("ContainerFactory() failed, possibly API incompatible: " + th2.getMessage());
            }
        }
        return f6919e;
    }

    public void b() {
        f6919e = null;
    }
}
