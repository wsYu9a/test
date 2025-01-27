package com.kwad.components.core.b;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.api.SplashAd;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpHeaders;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class g implements h, Comparable<g> {
    private final String Ic;
    private final String Ij;
    private final String Ik;
    private final String Il;
    private final long Im;
    private String In = null;
    private final long createTime;
    private final int ecpm;

    private g(String str, String str2, String str3, int i2, String str4, long j2, long j3) {
        this.Ij = str;
        this.Ic = str2;
        this.Ik = str3;
        this.ecpm = i2;
        this.Il = str4;
        this.createTime = j2;
        this.Im = j3;
    }

    public static List<g> a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                arrayList.add(c(cursor));
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTrace(e2);
            }
        }
        return arrayList;
    }

    public static List<g> a(e eVar, AdResultData adResultData) {
        AdResultData adResultData2;
        AdResultData adResultData3 = adResultData;
        List<AdTemplate> proceedTemplateList = adResultData.getProceedTemplateList();
        int size = proceedTemplateList.size();
        long currentTimeMillis = System.currentTimeMillis();
        long mi = (currentTimeMillis / 1000) + eVar.mi();
        ArrayList arrayList = new ArrayList();
        SceneImpl defaultAdScene = adResultData.getDefaultAdScene();
        Iterator<AdTemplate> it = proceedTemplateList.iterator();
        while (it.hasNext()) {
            AdTemplate next = it.next();
            Iterator<AdTemplate> it2 = it;
            ArrayList arrayList2 = arrayList;
            g gVar = new g(String.valueOf(com.kwad.sdk.core.response.a.d.cl(next)), String.valueOf(adResultData.getPosId()), new AdResultData(adResultData3, defaultAdScene, Collections.singletonList(next)).getResponseJson(), com.kwad.sdk.core.response.a.d.cq(next), adResultData.getDefaultAdScene().toJson().toString(), size + currentTimeMillis, mi);
            if (next.hasPlayAgain()) {
                adResultData2 = adResultData;
                gVar.ak(new AdResultData(adResultData2, defaultAdScene, Collections.singletonList(next.mPlayAgain)).getResponseJson());
            } else {
                adResultData2 = adResultData;
            }
            arrayList2.add(gVar);
            size--;
            it = it2;
            arrayList = arrayList2;
            adResultData3 = adResultData2;
        }
        return arrayList;
    }

    private void ak(String str) {
        this.In = str;
    }

    @SuppressLint({HttpHeaders.RANGE})
    private static synchronized g c(@NonNull Cursor cursor) {
        g gVar;
        synchronized (g.class) {
            String string = cursor.getString(cursor.getColumnIndex("creativeId"));
            String string2 = cursor.getString(cursor.getColumnIndex("posId"));
            String string3 = cursor.getString(cursor.getColumnIndex("adJson"));
            int i2 = cursor.getInt(cursor.getColumnIndex(SplashAd.KEY_BIDFAIL_ECPM));
            String string4 = cursor.getString(cursor.getColumnIndex("adSenseJson"));
            long j2 = cursor.getLong(cursor.getColumnIndex("createTime"));
            long j3 = cursor.getLong(cursor.getColumnIndex("expireTime"));
            String string5 = cursor.getString(cursor.getColumnIndex("playAgainJson"));
            gVar = new g(string, string2, string3, i2, string4, j2, j3);
            gVar.ak(string5);
        }
        return gVar;
    }

    @Nullable
    private static AdResultData c(g gVar) {
        if (gVar == null) {
            return null;
        }
        if (gVar.mm() == null || gVar.mq() == null) {
            com.kwad.sdk.core.d.b.w("CachedAd", "createAdResultData cachedAd data illegal");
            return null;
        }
        try {
            String mq = gVar.mq();
            SceneImpl sceneImpl = new SceneImpl();
            sceneImpl.parseJson(new JSONObject(mq));
            AdResultData createFromResponseJson = AdResultData.createFromResponseJson(gVar.mm(), sceneImpl);
            String ms = gVar.ms();
            if (!TextUtils.isEmpty(ms)) {
                AdTemplate firstAdTemplate = createFromResponseJson.getFirstAdTemplate();
                AdResultData createFromResponseJson2 = AdResultData.createFromResponseJson(ms, sceneImpl);
                Iterator<AdTemplate> it = createFromResponseJson2.getProceedTemplateList().iterator();
                while (it.hasNext()) {
                    it.next().fromCache = true;
                }
                firstAdTemplate.setPlayAgain(createFromResponseJson2.getFirstAdTemplate());
            }
            Iterator<AdTemplate> it2 = createFromResponseJson.getProceedTemplateList().iterator();
            while (it2.hasNext()) {
                it2.next().fromCache = true;
            }
            return createFromResponseJson;
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            return null;
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: d */
    public int compareTo(g gVar) {
        return gVar.mn() == mn() ? (int) (gVar.mo() - mo()) : gVar.mn() - mn();
    }

    public static AdResultData h(List<g> list) {
        ArrayList arrayList = new ArrayList();
        AdResultData adResultData = null;
        if (list == null || list.size() == 0) {
            return null;
        }
        Iterator<g> it = list.iterator();
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
        return new AdResultData(adResultData, sceneImpl, arrayList);
    }

    private String mm() {
        return this.Ik;
    }

    private int mn() {
        return this.ecpm;
    }

    private long mo() {
        return this.createTime;
    }

    private String mq() {
        return this.Il;
    }

    private String ms() {
        return this.In;
    }

    @Override // com.kwad.components.core.b.h
    public final ContentValues mj() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("creativeId", this.Ij);
        contentValues.put("posId", this.Ic);
        contentValues.put("adJson", this.Ik);
        contentValues.put(SplashAd.KEY_BIDFAIL_ECPM, Integer.valueOf(this.ecpm));
        contentValues.put("adSenseJson", this.Il);
        contentValues.put("createTime", Long.valueOf(this.createTime));
        contentValues.put("expireTime", Long.valueOf(this.Im));
        contentValues.put("playAgainJson", this.In);
        return contentValues;
    }

    public final String ml() {
        return this.Ic;
    }

    public final long mp() {
        return this.Im;
    }

    public final String mr() {
        return this.Ij;
    }
}
