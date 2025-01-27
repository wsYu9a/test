package com.czhj.devicehelper.oaId.helpers;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import com.czhj.devicehelper.oaId.helpers.DevicesIDsHelper;
import com.czhj.sdk.logger.SigmobLog;
import com.shu.priory.config.AdKeys;

/* loaded from: classes2.dex */
public class e {

    /* renamed from: a */
    public Context f8321a;

    public e(Context context) {
        this.f8321a = context;
    }

    public void a(DevicesIDsHelper.AppIdsUpdater appIdsUpdater) {
        if (a()) {
            Uri parse = Uri.parse("content://com.meizu.flyme.openidsdk/");
            try {
                Cursor query = this.f8321a.getContentResolver().query(parse, null, null, new String[]{AdKeys.OAID}, null);
                String a10 = a(query);
                if (appIdsUpdater != null) {
                    appIdsUpdater.OnIdsAvalid(a10);
                }
                query.close();
            } catch (Throwable th2) {
                SigmobLog.e(th2.getMessage());
            }
        }
    }

    public final String a(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex("value");
        if (columnIndex > 0) {
            return cursor.getString(columnIndex);
        }
        return null;
    }

    public final boolean a() {
        try {
            PackageManager packageManager = this.f8321a.getPackageManager();
            if (packageManager != null) {
                return packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
