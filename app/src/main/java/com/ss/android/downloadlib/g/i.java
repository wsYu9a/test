package com.ss.android.downloadlib.g;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.alipay.mobilesecuritysdk.deviceID.c;
import com.ss.android.downloadlib.addownload.pa;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class i {
    private static volatile i zx;

    /* renamed from: j */
    private SQLiteDatabase f24248j;

    private i() {
        try {
            this.f24248j = new zx(pa.getContext()).getWritableDatabase();
        } catch (Throwable th) {
            com.ss.android.downloadlib.q.i.j().j(th, "ClickEventHelper");
        }
    }

    public static i j() {
        if (zx == null) {
            synchronized (i.class) {
                if (zx == null) {
                    zx = new i();
                }
            }
        }
        return zx;
    }

    public boolean i() {
        return DownloadSetting.obtainGlobal().optInt("click_event_switch", 0) == 2;
    }

    public boolean zx() {
        return DownloadSetting.obtainGlobal().optInt("click_event_switch", 0) == 1;
    }

    private void i(long j2, String str) {
        SQLiteDatabase sQLiteDatabase = this.f24248j;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j2 <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String optString = new JSONObject(str).optString("req_id");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            this.f24248j.delete("click_event", "time < ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j2), optString});
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean zx(long j2, String str) {
        SQLiteDatabase sQLiteDatabase = this.f24248j;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j2 <= 0 || TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor cursor = null;
        try {
            try {
                String optString = new JSONObject(str).optString("req_id");
                if (TextUtils.isEmpty(optString)) {
                    return false;
                }
                cursor = this.f24248j.query("click_event", zx.f24251j, "time > ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j2), optString}, null, null, null, null);
                boolean z = cursor.getCount() > 0;
                cursor.close();
                return z;
            } catch (Exception e2) {
                e2.printStackTrace();
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public void j(long j2, String str) {
        String optString;
        SQLiteDatabase sQLiteDatabase = this.f24248j;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j2 <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            optString = new JSONObject(str).optString("req_id");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("ad_id", Long.valueOf(j2));
        contentValues.put("req_id", optString);
        contentValues.put(c.y, Long.valueOf(System.currentTimeMillis()));
        this.f24248j.insert("click_event", null, contentValues);
        i(j2, str);
    }
}
