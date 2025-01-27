package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ax {

    /* renamed from: a */
    private JSONObject f10785a;

    public ax(Context context) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.f10911g).intValue(), 1, 0, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f10785a = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f10785a;
        if (jSONObject != null) {
            try {
                return jSONObject.optString(str, null);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public Set b(int i10) {
        HashSet hashSet = new HashSet();
        if (i10 == 1) {
            hashSet.add("AudioTrack");
            hashSet.add("processrea");
            hashSet.add("RemitDatab");
            hashSet.add("BrowserBlo");
            hashSet.add("game_push");
            hashSet.add("Godzilla:I");
            hashSet.add("IndexedDB");
            hashSet.add("ScopeRetry");
            hashSet.add("RobustPatc");
            hashSet.add("FrescoIoBo");
            hashSet.add("key_config");
        }
        return hashSet;
    }

    public Set a(Context context, String str, int i10) {
        JSONObject jSONObject = this.f10785a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            Set a10 = a(i10);
            if (TextUtils.isEmpty(string) || string.length() <= 3) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(string);
            HashSet hashSet = new HashSet();
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                String string2 = jSONArray.getString(i11);
                if (!string2.contains("azeroth") && !string2.contains("OkHttp") && !string2.contains("retrofit")) {
                    int i12 = 0;
                    while (string2.contains(" ")) {
                        string2 = string2.replace(" ", "");
                        i12++;
                        if (i12 > 200) {
                            break;
                        }
                    }
                    String replace = string2.replace("\n", "").replace("\t", "").replace("\u200b", "");
                    boolean startsWith = replace.startsWith(":");
                    String str2 = replace;
                    if (startsWith) {
                        str2 = replace.substring(1);
                    }
                    String substring = str2.length() > 10 ? str2.substring(0, 10) : str2;
                    if (str2.contains("ridge")) {
                        hashSet.add(str2);
                    }
                    String packageName = context.getPackageName();
                    if (!str2.contains(packageName) && !packageName.contains(str2) && !a10.contains(substring) && !b(i10).contains(substring)) {
                        hashSet.add(str2);
                    }
                }
            }
            if (hashSet.size() > 0) {
                return hashSet;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public Set a(int i10) {
        HashSet hashSet = new HashSet();
        if (i10 == 1) {
            hashSet.add("HeapTaskDa");
            hashSet.add("queued-wor");
            hashSet.add("JDWP");
            hashSet.add("dTi");
            hashSet.add("MessageHan");
            hashSet.add("MediaPrefe");
            hashSet.add("CleanupRef");
            hashSet.add("GeoLocatio");
            hashSet.add("securityai");
            hashSet.add("Connectivi");
            hashSet.add("PatchManag");
            hashSet.add("CronetInte");
            hashSet.add("AegonLogge");
            hashSet.add("Countly");
            hashSet.add("DownloadSt");
            hashSet.add("GoogleApiH");
            hashSet.add("PlatformSe");
            hashSet.add("MemoryInfr");
            hashSet.add("CronetLibr");
            hashSet.add("Dex2OatIni");
            hashSet.add("EncodeApiH");
            hashSet.add("CookieMons");
        }
        return hashSet;
    }
}
