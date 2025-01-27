package com.kwad.components.core.c;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class h implements i, Comparable<h> {
    private final String KZ;
    private final String Li;
    private final String Lj;
    private final String Lk;
    private final long Ll;
    private final long createTime;
    private final int ecpm;

    private h(String str, String str2, String str3, int i10, String str4, long j10, long j11) {
        this.Li = str;
        this.KZ = str2;
        this.Lj = str3;
        this.ecpm = i10;
        this.Lk = str4;
        this.createTime = j10;
        this.Ll = j11;
    }

    public static List<h> a(e eVar, AdResultData adResultData) {
        List<AdTemplate> proceedTemplateList = adResultData.getProceedTemplateList();
        int size = proceedTemplateList.size();
        long currentTimeMillis = System.currentTimeMillis();
        long nr = (currentTimeMillis / 1000) + eVar.nr();
        ArrayList arrayList = new ArrayList();
        SceneImpl defaultAdScene = adResultData.getDefaultAdScene();
        Iterator<AdTemplate> it = proceedTemplateList.iterator();
        while (it.hasNext()) {
            AdTemplate next = it.next();
            arrayList.add(new h(String.valueOf(com.kwad.sdk.core.response.b.e.el(next)), String.valueOf(adResultData.getPosId()), new AdResultData(adResultData, defaultAdScene, Collections.singletonList(next)).getResponseJson(), com.kwad.sdk.core.response.b.e.ep(next), adResultData.getDefaultAdScene().toJson().toString(), currentTimeMillis + size, nr));
            size--;
            it = it;
            defaultAdScene = defaultAdScene;
        }
        return arrayList;
    }

    @SuppressLint({"Range"})
    private static synchronized h c(@NonNull Cursor cursor) {
        h hVar;
        synchronized (h.class) {
            hVar = new h(cursor.getString(cursor.getColumnIndex("creativeId")), cursor.getString(cursor.getColumnIndex("posId")), cursor.getString(cursor.getColumnIndex("adJson")), cursor.getInt(cursor.getColumnIndex("ecpm")), cursor.getString(cursor.getColumnIndex("adSenseJson")), cursor.getLong(cursor.getColumnIndex("createTime")), cursor.getLong(cursor.getColumnIndex("expireTime")));
        }
        return hVar;
    }

    @Override // java.lang.Comparable
    /* renamed from: d */
    public int compareTo(h hVar) {
        return hVar.nx() == nx() ? (int) (hVar.ny() - ny()) : hVar.nx() - nx();
    }

    public static AdResultData j(List<h> list) {
        ArrayList arrayList = new ArrayList();
        AdResultData adResultData = null;
        if (list == null || list.size() == 0) {
            return null;
        }
        Iterator<h> it = list.iterator();
        SceneImpl sceneImpl = null;
        while (it.hasNext()) {
            adResultData = c(it.next());
            if (adResultData != null) {
                if (sceneImpl == null) {
                    sceneImpl = adResultData.getDefaultAdScene();
                }
                arrayList.addAll(adResultData.getProceedTemplateList());
            }
        }
        AdResultData adResultData2 = new AdResultData(adResultData, sceneImpl, arrayList);
        adResultData2.setAdSource("cache");
        return adResultData2;
    }

    private String nA() {
        return this.Lk;
    }

    private String nw() {
        return this.Lj;
    }

    private int nx() {
        return this.ecpm;
    }

    private long ny() {
        return this.createTime;
    }

    public final String nB() {
        return this.Li;
    }

    @Override // com.kwad.components.core.c.i
    public final ContentValues ns() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("creativeId", this.Li);
        contentValues.put("posId", this.KZ);
        contentValues.put("adJson", this.Lj);
        contentValues.put("ecpm", Integer.valueOf(this.ecpm));
        contentValues.put("adSenseJson", this.Lk);
        contentValues.put("createTime", Long.valueOf(this.createTime));
        contentValues.put("expireTime", Long.valueOf(this.Ll));
        contentValues.put("playAgainJson", (String) null);
        return contentValues;
    }

    public final String nv() {
        return this.KZ;
    }

    public final long nz() {
        return this.Ll;
    }

    @Nullable
    private static AdResultData c(h hVar) {
        if (hVar == null) {
            return null;
        }
        if (hVar.nw() != null && hVar.nA() != null) {
            try {
                String nA = hVar.nA();
                SceneImpl sceneImpl = new SceneImpl();
                sceneImpl.parseJson(new JSONObject(nA));
                AdResultData createFromResponseJson = AdResultData.createFromResponseJson(hVar.nw(), sceneImpl);
                Iterator<AdTemplate> it = createFromResponseJson.getProceedTemplateList().iterator();
                while (it.hasNext()) {
                    it.next().fromCache = true;
                }
                return createFromResponseJson;
            } catch (JSONException e10) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
                return null;
            }
        }
        com.kwad.sdk.core.d.c.w("CachedAd", "createAdResultData cachedAd data illegal");
        return null;
    }

    public static List<h> a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                arrayList.add(c(cursor));
            } catch (Exception e10) {
                com.kwad.sdk.core.d.c.printStackTrace(e10);
            }
        }
        return arrayList;
    }
}
