package kj;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import com.shu.priory.config.AdKeys;
import p008package.Cdo;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: g */
    public static volatile b f27849g;

    /* renamed from: a */
    public a f27850a = new a("udid");

    /* renamed from: b */
    public a f27851b = new a(AdKeys.OAID);

    /* renamed from: c */
    public a f27852c = new a("aaid");

    /* renamed from: d */
    public a f27853d = new a("vaid");

    /* renamed from: e */
    public Boolean f27854e;

    /* renamed from: f */
    public Cdo f27855f;

    public static final b b() {
        if (f27849g == null) {
            synchronized (b.class) {
                f27849g = new b();
            }
        }
        return f27849g;
    }

    public static d c(Cursor cursor) {
        d dVar = new d();
        if (!cursor.isClosed()) {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex("value");
            if (columnIndex >= 0) {
                dVar.f27856a = cursor.getString(columnIndex);
            }
            int columnIndex2 = cursor.getColumnIndex("code");
            if (columnIndex2 >= 0) {
                dVar.f27857b = cursor.getInt(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex("expired");
            if (columnIndex3 >= 0) {
                dVar.f27858c = cursor.getLong(columnIndex3);
            }
        }
        return dVar;
    }

    public final String a(Context context, a aVar) {
        if (aVar == null) {
            return null;
        }
        if (aVar.f27846a > System.currentTimeMillis()) {
            return aVar.f27847b;
        }
        try {
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{aVar.f27848c}, null);
            if (query == null) {
                if (!e(context, false)) {
                    return null;
                }
                e(context, true);
                return null;
            }
            try {
                d c10 = c(query);
                String str = c10.f27856a;
                try {
                    aVar.f27847b = str;
                    aVar.f27846a = c10.f27858c;
                    if (c10.f27857b != 1000) {
                        d(context);
                        if (!e(context, false)) {
                            e(context, true);
                        }
                    }
                    return str;
                } catch (Exception e10) {
                    try {
                        e10.getMessage();
                        return str;
                    } finally {
                        query.close();
                    }
                }
            } catch (Exception e11) {
                e11.getMessage();
                return null;
            }
        } catch (Exception e12) {
            e12.getMessage();
            throw null;
        }
    }

    public final synchronized void d(Context context) {
        if (this.f27855f == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
            Cdo cdo = new Cdo();
            this.f27855f = cdo;
            context.registerReceiver(cdo, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
        }
    }

    public final boolean e(Context context, boolean z10) {
        PackageManager packageManager;
        Throwable th2;
        String str;
        Boolean bool = this.f27854e;
        if (bool != null && !z10) {
            return bool.booleanValue();
        }
        if (context == null || (packageManager = context.getPackageManager()) == null || packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) == null) {
            this.f27854e = Boolean.FALSE;
            return false;
        }
        Cursor cursor = null;
        try {
            try {
                Cursor query = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"supported"}, null);
                if (query != null) {
                    try {
                        str = c(query).f27856a;
                        query.close();
                    } catch (Exception e10) {
                        try {
                            e10.getMessage();
                            str = null;
                        } catch (Throwable th3) {
                            try {
                                throw th3;
                            } catch (Throwable th4) {
                                th2 = th4;
                                cursor = query;
                                if (cursor == null) {
                                    throw th2;
                                }
                                cursor.close();
                                throw th2;
                            }
                        }
                    }
                    boolean equals = "0".equals(str);
                    this.f27854e = Boolean.valueOf(equals);
                    return equals;
                }
            } catch (Exception e11) {
                e11.getMessage();
            }
            return false;
        } catch (Throwable th5) {
            th2 = th5;
        }
    }
}
