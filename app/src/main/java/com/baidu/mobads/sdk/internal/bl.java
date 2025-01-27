package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.baidu.mobads.sdk.internal.bw;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class bl {

    /* renamed from: a */
    public static final String f5607a = "ContainerFactoryBuilder";

    /* renamed from: e */
    private static IXAdContainerFactory f5608e;

    /* renamed from: c */
    private Context f5610c;

    /* renamed from: d */
    private Class<?> f5611d;

    /* renamed from: b */
    public double f5609b = 0.1d;

    /* renamed from: f */
    private bq f5612f = bq.a();

    public bl(Class<?> cls, Context context) {
        this.f5611d = null;
        this.f5611d = cls;
        this.f5610c = context;
    }

    public IXAdContainerFactory a() {
        if (f5608e == null) {
            try {
                f5608e = (IXAdContainerFactory) this.f5611d.getDeclaredConstructor(Context.class).newInstance(this.f5610c);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(com.umeng.analytics.pro.am.bd, "9.29");
                f5608e.initConfig(jSONObject);
                this.f5609b = f5608e.getRemoteVersion();
                f5608e.onTaskDistribute(az.f5563a, MobadsPermissionSettings.getPermissionInfo());
                f5608e.initCommonModuleObj(q.a());
            } catch (Throwable th) {
                this.f5612f.b(f5607a, th.getMessage());
                throw new bw.a("ContainerFactory() failed, possibly API incompatible: " + th.getMessage());
            }
        }
        return f5608e;
    }

    public void b() {
        f5608e = null;
    }
}
