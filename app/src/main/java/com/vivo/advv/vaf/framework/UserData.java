package com.vivo.advv.vaf.framework;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class UserData {
    private Map<String, Object> mData = new HashMap();

    public void clear() {
        this.mData.clear();
    }

    public Object get(String str) {
        return this.mData.get(str);
    }

    public void put(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        this.mData.put(str, obj);
    }
}
