package com.ss.android.downloadlib.d;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: b */
    private static volatile c f21595b;

    /* renamed from: a */
    private SQLiteDatabase f21596a;

    private c() {
        try {
            this.f21596a = new b(k.a()).getWritableDatabase();
        } catch (Throwable th2) {
            com.ss.android.downloadlib.e.c.a().a(th2, "ClickEventHelper");
        }
    }

    public static c a() {
        if (f21595b == null) {
            synchronized (c.class) {
                try {
                    if (f21595b == null) {
                        f21595b = new c();
                    }
                } finally {
                }
            }
        }
        return f21595b;
    }

    public boolean b() {
        return DownloadSetting.obtainGlobal().optInt("click_event_switch", 0) == 1;
    }

    public boolean c() {
        return DownloadSetting.obtainGlobal().optInt("click_event_switch", 0) == 2;
    }

    private void c(long j10, String str) {
        SQLiteDatabase sQLiteDatabase = this.f21596a;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j10 <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String optString = new JSONObject(str).optString(ExposeManager.UtArgsNames.reqId);
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            this.f21596a.delete("click_event", "time < ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j10), optString});
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public boolean b(long j10, String str) {
        SQLiteDatabase sQLiteDatabase = this.f21596a;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j10 <= 0 || TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor cursor = null;
        try {
            try {
                String optString = new JSONObject(str).optString(ExposeManager.UtArgsNames.reqId);
                if (TextUtils.isEmpty(optString)) {
                    return false;
                }
                cursor = this.f21596a.query("click_event", b.f21594a, "time > ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j10), optString}, null, null, null, null);
                boolean z10 = cursor.getCount() > 0;
                cursor.close();
                return z10;
            } catch (Exception e10) {
                e10.printStackTrace();
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            }
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    public void a(long j10, String str) {
        String optString;
        SQLiteDatabase sQLiteDatabase = this.f21596a;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j10 <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            optString = new JSONObject(str).optString(ExposeManager.UtArgsNames.reqId);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(MediationConstant.EXTRA_ADID, Long.valueOf(j10));
        contentValues.put(ExposeManager.UtArgsNames.reqId, optString);
        contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
        this.f21596a.insert("click_event", null, contentValues);
        c(j10, str);
    }
}
