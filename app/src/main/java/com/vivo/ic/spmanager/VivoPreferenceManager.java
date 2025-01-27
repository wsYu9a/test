package com.vivo.ic.spmanager;

import android.text.TextUtils;
import com.vivo.ic.BaseLib;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class VivoPreferenceManager {
    private static final String VP_LIB_NAME = "com.vivo.lib";
    private static VivoPreferenceManager sInstance;
    private HashMap<String, VivoPreference> mPreferences = new HashMap<>();

    private VivoPreferenceManager() {
    }

    public static synchronized VivoPreferenceManager getInstance() {
        VivoPreferenceManager vivoPreferenceManager;
        synchronized (VivoPreferenceManager.class) {
            if (sInstance == null) {
                sInstance = new VivoPreferenceManager();
            }
            vivoPreferenceManager = sInstance;
        }
        return vivoPreferenceManager;
    }

    public void clear() {
        this.mPreferences.clear();
    }

    protected VivoPreference getLibPreference() {
        return getPreference(VP_LIB_NAME);
    }

    public VivoPreference getPreference() {
        return getPreference(null);
    }

    public VivoPreference getPreference(String str) {
        if (TextUtils.isEmpty(str)) {
            str = BaseLib.getContext().getPackageName();
        }
        if (this.mPreferences.get(str) != null) {
            return this.mPreferences.get(str);
        }
        VivoPreference vivoPreference = new VivoPreference(BaseLib.getContext().getSharedPreferences(str, 4));
        this.mPreferences.put(str, vivoPreference);
        return vivoPreference;
    }
}
