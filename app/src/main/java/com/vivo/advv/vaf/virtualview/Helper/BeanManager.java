package com.vivo.advv.vaf.virtualview.Helper;

import com.vivo.advv.TextUtils;
import com.vivo.advv.vaf.virtualview.core.IBean;
import com.vivo.advv.vaf.virtualview.util.VVLog;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class BeanManager {
    private static final String TAG = "BeanManager_TMTEST";
    private ConcurrentHashMap<String, Class<? extends IBean>> mBeanArrayMap = new ConcurrentHashMap<>();

    public Class<? extends IBean> getBeanFor(String str) {
        return this.mBeanArrayMap.get(str);
    }

    public void register(String str, Class<? extends IBean> cls) {
        if (cls != null && !TextUtils.isEmpty(str)) {
            this.mBeanArrayMap.put(str, cls);
            return;
        }
        VVLog.e(TAG, "register failed type:" + str + "  processor:" + cls);
    }

    public void unregister(String str, Class<? extends IBean> cls) {
        if (cls != null && !TextUtils.isEmpty(str)) {
            this.mBeanArrayMap.remove(str);
            return;
        }
        VVLog.e(TAG, "unregister failed type:" + str + "  processor:" + cls);
    }
}
