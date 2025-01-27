package com.vivo.advv.vaf.expr.engine.finder;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class ObjectFinderManager {
    private static final String TAG = "ObjectFinderManager_TMTEST";
    private Map<String, ObjectFinder> mDataMap = new HashMap();

    public void addFinder(String str, ObjectFinder objectFinder) {
        if (TextUtils.isEmpty(str) || objectFinder == null) {
            return;
        }
        this.mDataMap.put(str, objectFinder);
    }

    public ObjectFinder getFinder(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.mDataMap.get(str);
    }
}
