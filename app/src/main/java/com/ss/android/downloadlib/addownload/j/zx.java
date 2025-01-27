package com.ss.android.downloadlib.addownload.j;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.pa;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: classes4.dex */
class zx {
    zx() {
    }

    @NonNull
    CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.zx.j> j(String str, String str2) {
        CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.zx.j> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        try {
            String string = pa.getContext().getSharedPreferences(str, 0).getString(str2, "");
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    com.ss.android.downloadlib.addownload.zx.j j2 = com.ss.android.downloadlib.addownload.zx.j.j(jSONObject.optJSONObject(keys.next()));
                    if (j2 != null) {
                        copyOnWriteArrayList.add(j2);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return copyOnWriteArrayList;
    }

    void zx(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        pa.getContext().getSharedPreferences(str, 0).edit().putString(str2, "").apply();
    }

    void j(String str, String str2, CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.zx.j> copyOnWriteArrayList) {
        if (copyOnWriteArrayList == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            Iterator<com.ss.android.downloadlib.addownload.zx.j> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                com.ss.android.downloadlib.addownload.zx.j next = it.next();
                if (next != null) {
                    jSONObject.put(String.valueOf(next.zx), next.j());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        pa.getContext().getSharedPreferences(str, 0).edit().putString(str2, jSONObject.toString()).apply();
    }
}
