package com.opos.cmn.biz.ststrategy;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.biz.a.a;
import com.opos.cmn.biz.requeststatistic.InitParams;
import com.opos.cmn.biz.requeststatistic.RequestStatisticManager;
import com.opos.cmn.biz.ststrategy.c.b;
import com.opos.cmn.biz.ststrategy.entity.STConfigEntity;
import com.opos.cmn.biz.ststrategy.listener.UpdateSTConfigListener;
import com.opos.cmn.g.a.c;

/* loaded from: classes4.dex */
public class StStrategyManager {
    public static final String BRAND_OF_O = a.f16615c;
    public static final String BRAND_OF_P = a.f16613a;
    public static final String BRAND_OF_R = a.f16614b;

    /* renamed from: a */
    private static final String f16807a = "StStrategyManager";

    /* renamed from: b */
    private static StStrategyManager f16808b = null;

    /* renamed from: e */
    private static int f16809e = 310;

    /* renamed from: c */
    private Context f16810c;

    /* renamed from: d */
    private com.opos.cmn.biz.ststrategy.b.a f16811d;

    private StStrategyManager(Context context) {
        this.f16810c = null;
        this.f16811d = null;
        this.f16810c = context;
        RequestStatisticManager.getInstance().init(this.f16810c, new InitParams.Builder().build());
        this.f16811d = new com.opos.cmn.biz.ststrategy.a.a(this.f16810c);
    }

    public static StStrategyManager getInstance(Context context) {
        StStrategyManager stStrategyManager = f16808b;
        if (stStrategyManager == null) {
            synchronized (StStrategyManager.class) {
                stStrategyManager = f16808b;
                if (stStrategyManager == null) {
                    if (context == null) {
                        com.opos.cmn.an.f.a.b(f16807a, "StStrategyManager init context can not be null !");
                        throw new NullPointerException("StStrategyManager init context can not be null !");
                    }
                    stStrategyManager = new StStrategyManager(context.getApplicationContext());
                    f16808b = stStrategyManager;
                }
            }
        }
        return stStrategyManager;
    }

    public static int getStVerCode() {
        return f16809e;
    }

    public static void setStVerCode(int i2) {
        f16809e = i2;
    }

    @Deprecated
    public String getAnId(Context context) {
        return getCryptValueByKey("anId", b.a(context));
    }

    @Deprecated
    public String getCryptValueByKey(String str, String str2) {
        return str2;
    }

    @Deprecated
    public String getGUID() {
        return getCryptValueByKey("guId", com.opos.cmn.g.a.b.c(this.f16810c));
    }

    @Deprecated
    public String getImei() {
        return getCryptValueByKey("imei", c.a(this.f16810c));
    }

    public STConfigEntity getSTConfigEntity() {
        return this.f16811d.a();
    }

    public void updateSTConfigsByDataType(String str, UpdateSTConfigListener updateSTConfigListener) {
        if (!TextUtils.isEmpty(str)) {
            this.f16811d.a(str, updateSTConfigListener);
            return;
        }
        com.opos.cmn.an.f.a.b(f16807a, "updateParams dataType can not be null !");
        if (updateSTConfigListener != null) {
            updateSTConfigListener.onFail();
        }
        throw new Exception("please check your updateParams dataType");
    }

    public void updateSTConfigsByPkgName(UpdateParams updateParams, UpdateSTConfigListener updateSTConfigListener) {
        if (updateParams == null) {
            com.opos.cmn.an.f.a.b(f16807a, "updateParams can not be null !");
            if (updateSTConfigListener != null) {
                updateSTConfigListener.onFail();
            }
            throw new NullPointerException("updateParams can not be null !");
        }
        if (!TextUtils.isEmpty(updateParams.pkgName)) {
            this.f16811d.a(updateParams, updateSTConfigListener);
            return;
        }
        com.opos.cmn.an.f.a.b(f16807a, "updateParams pkgName can not be null !");
        if (updateSTConfigListener != null) {
            updateSTConfigListener.onFail();
        }
        throw new Exception("please check your updateParams pkgName");
    }
}
