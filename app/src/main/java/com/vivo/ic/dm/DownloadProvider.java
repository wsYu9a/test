package com.vivo.ic.dm;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.IntentFilter;
import android.content.OperationApplicationException;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.vivo.ic.VLog;
import com.vivo.ic.dm.DownloadInfo;
import com.vivo.ic.dm.Downloads;
import com.vivo.ic.dm.database.DbMoverManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class DownloadProvider extends ContentProvider {

    /* renamed from: a */
    private static final String f28354a = Constants.PRE_TAG + "DownloadProvider";

    /* renamed from: b */
    private static final int f28355b = 1;

    /* renamed from: c */
    private static final int f28356c = 2;

    /* renamed from: d */
    private static final int f28357d = 3;

    /* renamed from: e */
    private SQLiteOpenHelper f28358e = null;

    /* renamed from: f */
    private UriMatcher f28359f = new UriMatcher(-1);

    private String a(String str) {
        String str2 = f28354a;
        VLog.d(str2, "dealWithSpecialCharacter hint:" + str);
        if (str == null || str.endsWith("/")) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(47) + 1;
        if (lastIndexOf <= 0) {
            String b2 = b(str);
            VLog.d(str2, "dealHint hint:" + b2);
            return b2;
        }
        String substring = str.substring(lastIndexOf);
        VLog.d(str2, "dealHint fileName:" + substring);
        return str.substring(0, lastIndexOf) + b(substring);
    }

    private String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            int i2 = 0;
            while (true) {
                char[] cArr = Constants.FILENAME_ILLCHAR;
                if (i2 >= cArr.length) {
                    break;
                }
                char c2 = cArr[i2];
                if (str.indexOf(c2) >= 0) {
                    str = str.replace(String.valueOf(c2), "");
                }
                i2++;
            }
        }
        return str;
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        String str = f28354a;
        VLog.d(str, "applyBatch begin");
        SQLiteDatabase writableDatabase = this.f28358e.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            ContentProviderResult[] applyBatch = super.applyBatch(arrayList);
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            VLog.d(str, "applyBatch end");
            return applyBatch;
        } catch (Throwable th) {
            writableDatabase.endTransaction();
            VLog.d(f28354a, "applyBatch end");
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x013c  */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int delete(android.net.Uri r19, java.lang.String r20, java.lang.String[] r21) {
        /*
            Method dump skipped, instructions count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.ic.dm.DownloadProvider.delete(android.net.Uri, java.lang.String, java.lang.String[]):int");
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return "vnd.android.cursor.dir/download";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        String str = f28354a;
        VLog.i(str, "lib_dm_multi version: v3.4.8.1");
        VLog.d(str, "insert() values: " + contentValues);
        ContentValues a2 = a(contentValues);
        SQLiteDatabase writableDatabase = this.f28358e.getWritableDatabase();
        if (contentValues.getAsInteger(Downloads.Column.VISIBILITY) == null) {
            contentValues.put(Downloads.Column.VISIBILITY, (Integer) 0);
        }
        if (contentValues.getAsInteger(Downloads.Column.CONTROL) == null) {
            contentValues.put(Downloads.Column.CONTROL, (Integer) 0);
        }
        String asString = contentValues.getAsString(Downloads.Column.DATA);
        Integer asInteger = contentValues.getAsInteger("status");
        if (asInteger == null || asInteger.intValue() != 200) {
            if (!TextUtils.isEmpty(asString)) {
                try {
                    contentValues.put(Downloads.Column.ACTUAL_PATH, m.c(asString));
                    try {
                        File parentFile = new File(asString).getParentFile();
                        if (parentFile != null && !parentFile.exists()) {
                            if (!parentFile.mkdirs()) {
                                return null;
                            }
                        }
                    } catch (Exception unused) {
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            contentValues.put("status", Integer.valueOf(Downloads.Impl.STATUS_PENDING));
            if (contentValues.getAsInteger("total_bytes") == null) {
                contentValues.put("total_bytes", (Integer) (-1));
            }
            contentValues.put(Downloads.Column.CURRENT_BYTES, (Integer) 0);
            contentValues.put(Downloads.Column.CURRENT_SPEED, (Integer) 0);
            contentValues.put(Downloads.Column.COMPLETE_THREADS, (Integer) 0);
        } else {
            VLog.e(str, "insert not need download");
        }
        contentValues.put(Downloads.Column.LAST_MODIFICATION, Long.valueOf(System.currentTimeMillis()));
        if (contentValues.containsKey(Downloads.Column.FILE_NAME_HINT)) {
            String a3 = a(contentValues.getAsString(Downloads.Column.FILE_NAME_HINT));
            if (TextUtils.isEmpty(asString)) {
                asString = a3;
            }
            VLog.d(f28354a, "newHint:" + a3);
            contentValues.put(Downloads.Column.FILE_NAME_HINT, a3);
        }
        a(contentValues, (String) null, (String[]) null);
        long insert = writableDatabase.insert(j.f28479a, null, contentValues);
        if (insert == -1) {
            VLog.e(f28354a, "couldn't insert into downloads database");
            return null;
        }
        if (asInteger == null || asInteger.intValue() != 200) {
            contentValues.put("_id", Long.valueOf(insert));
            com.vivo.ic.dm.datareport.a.a().a(new DownloadInfo.Reader(a2, contentValues).newDownloadInfo(getContext()), asString);
        }
        if (a2 != null && a2.size() > 0) {
            a(writableDatabase, insert, a2);
        }
        b(uri);
        com.vivo.ic.dm.util.e.b(getContext(), "DB insert");
        return ContentUris.withAppendedId(Downloads.Impl.CONTENT_URI, insert);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        String str = f28354a;
        VLog.i(str, "DownloadProvider onCreate()");
        Context context = getContext();
        a(context);
        VLog.i(str, "DownloadProvider register end");
        Downloads.Impl.setAuthor(context.getPackageName() + ".ICDM");
        this.f28359f.addURI(Downloads.Impl.AUTHOR, "all_downloads", 1);
        this.f28359f.addURI(Downloads.Impl.AUTHOR, "all_downloads/#", 2);
        this.f28359f.addURI(Downloads.Impl.AUTHOR, "all_downloads/#/headers", 3);
        this.f28358e = new j(getContext());
        DbMoverManager.getInstance().moveTo(context, (j) this.f28358e);
        return true;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        try {
            Cursor query = query(uri, new String[]{Downloads.Column.DATA}, null, null, null);
            int count = query != null ? query.getCount() : 0;
            if (count == 1) {
                if (!query.moveToFirst()) {
                    throw new FileNotFoundException("Failed moveToFirst");
                }
                String string = query.getString(0);
                com.vivo.ic.dm.util.b.a(query);
                if (string != null) {
                    return ParcelFileDescriptor.open(new File(string), 805306368);
                }
                throw new FileNotFoundException("No filename found.");
            }
            if (count == 0) {
                throw new FileNotFoundException("No entry for " + uri);
            }
            throw new FileNotFoundException("Multiple items at " + uri);
        } catch (Throwable th) {
            com.vivo.ic.dm.util.b.a((Cursor) null);
            throw th;
        }
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (strArr != null) {
            StringBuilder sb = new StringBuilder();
            for (String str3 : strArr) {
                sb.append(str3);
                sb.append("  ");
            }
            VLog.d(f28354a, "query() projection: " + sb.toString());
        }
        SQLiteDatabase readableDatabase = this.f28358e.getReadableDatabase();
        if (this.f28359f.match(uri) == 3) {
            if (strArr == null && str == null && str2 == null) {
                return a(readableDatabase, uri);
            }
            throw new UnsupportedOperationException("Request header queries do not support projections, selections or sorting");
        }
        b a2 = a(uri, str, strArr2, this.f28359f.match(uri));
        Cursor query = readableDatabase.query(j.f28479a, strArr, a2.b(), a2.a(), null, null, str2);
        if (query != null) {
            query.setNotificationUri(getContext().getContentResolver(), uri);
        } else {
            VLog.w(f28354a, "query failed in downloads database.", new Throwable());
        }
        return query;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        String str2 = f28354a;
        VLog.d(str2, "update download data");
        SQLiteDatabase writableDatabase = this.f28358e.getWritableDatabase();
        Integer asInteger = contentValues.getAsInteger(Downloads.Column.CONTROL);
        int i2 = 0;
        boolean z = asInteger != null;
        Integer asInteger2 = contentValues.getAsInteger("status");
        if (asInteger2 != null && asInteger2.intValue() == 190) {
            z = true;
        }
        if (asInteger != null && asInteger.intValue() == 0 && asInteger2 != null && (asInteger2.intValue() == 190 || asInteger2.intValue() == 192)) {
            contentValues.put(Downloads.Column.NETWORK_CHANGED, (Integer) 0);
        }
        int match = this.f28359f.match(uri);
        if (match == 1 || match == 2) {
            if (contentValues.size() > 0) {
                b a2 = a(uri, str, strArr, match);
                a(contentValues, a2.b(), a2.a());
                i2 = writableDatabase.update(j.f28479a, contentValues, a2.b(), a2.a());
            }
            b(uri);
            VLog.d(str2, "startService " + z);
            if (z) {
                com.vivo.ic.dm.util.e.b(getContext(), "DB update");
            }
            return i2;
        }
        if (match == 3) {
            throw new UnsupportedOperationException("Cannot update header: " + uri);
        }
        VLog.d(str2, "updating unknown/invalid URI: " + uri);
        throw new UnsupportedOperationException("Cannot update URI: " + uri);
    }

    private static class b {

        /* renamed from: a */
        public StringBuilder f28360a;

        /* renamed from: b */
        public List<String> f28361b;

        private b() {
            this.f28360a = new StringBuilder();
            this.f28361b = new ArrayList();
        }

        public <T> void a(String str, T... tArr) {
            if (str == null || str.isEmpty()) {
                return;
            }
            if (this.f28360a.length() != 0) {
                this.f28360a.append(" AND ");
            }
            this.f28360a.append("(");
            this.f28360a.append(str);
            this.f28360a.append(")");
            if (tArr != null) {
                for (T t : tArr) {
                    if (t != null) {
                        this.f28361b.add(t.toString());
                    }
                }
            }
        }

        public <T> void b(String str, T... tArr) {
            if (str == null || str.isEmpty()) {
                return;
            }
            if (this.f28360a.length() != 0) {
                this.f28360a.append(" AND ");
            }
            this.f28360a.append(" not ");
            this.f28360a.append("(");
            this.f28360a.append(str);
            this.f28360a.append(")");
            if (tArr != null) {
                for (T t : tArr) {
                    if (t != null) {
                        this.f28361b.add(t.toString());
                    }
                }
            }
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        public String[] a() {
            return (String[]) this.f28361b.toArray(new String[this.f28361b.size()]);
        }

        public String b() {
            return this.f28360a.toString();
        }
    }

    private void b(Uri uri) {
        VLog.d(f28354a, "notifyContentChanged() uri: " + uri);
        Uri uri2 = Downloads.Impl.CONTENT_URI;
        if (this.f28359f.match(uri) == 2) {
            uri2 = ContentUris.withAppendedId(Downloads.Impl.CONTENT_URI, Long.valueOf(Long.parseLong(a(uri))).longValue());
        }
        getContext().getContentResolver().notifyChange(uri2, null);
    }

    private void a(SQLiteDatabase sQLiteDatabase, long j2, ContentValues contentValues) {
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("download_id", Long.valueOf(j2));
        for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
            if (entry.getKey().startsWith(Downloads.RequestHeaders.INSERT_KEY_PREFIX)) {
                String obj = entry.getValue().toString();
                if (obj.contains(":")) {
                    String[] split = obj.split(":", 2);
                    contentValues2.put("header", split[0].trim());
                    contentValues2.put(Downloads.RequestHeaders.COLUMN_VALUE, split[1].trim());
                    sQLiteDatabase.insert(Downloads.RequestHeaders.HEADERS_DB_TABLE, null, contentValues2);
                } else {
                    throw new IllegalArgumentException("Invalid HTTP header line: " + obj);
                }
            }
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor query = sQLiteDatabase.query(j.f28479a, new String[]{"_id"}, str, strArr, null, null, null, null);
                if (query != null) {
                    try {
                        query.moveToFirst();
                        while (!query.isAfterLast()) {
                            sQLiteDatabase.delete(Downloads.RequestHeaders.HEADERS_DB_TABLE, "download_id=" + query.getLong(0), null);
                            query.moveToNext();
                        }
                    } catch (Exception e2) {
                        e = e2;
                        cursor = query;
                        VLog.w(f28354a, "deleteRequestHeaders error", e);
                        com.vivo.ic.dm.util.b.a(cursor);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        cursor = query;
                        com.vivo.ic.dm.util.b.a(cursor);
                        throw th;
                    }
                }
                com.vivo.ic.dm.util.b.a(query);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    private void a(long j2) {
        getContext().getContentResolver().notifyChange(ContentUris.withAppendedId(Downloads.Impl.CONTENT_URI, j2), null);
    }

    private String a(Uri uri) {
        return uri.getPathSegments().get(1);
    }

    private Cursor a(SQLiteDatabase sQLiteDatabase, Uri uri) {
        return sQLiteDatabase.query(Downloads.RequestHeaders.HEADERS_DB_TABLE, new String[]{"header", Downloads.RequestHeaders.COLUMN_VALUE}, "download_id=" + a(uri), null, null, null, null);
    }

    private b a(Uri uri, String str, String[] strArr, int i2) {
        b bVar = new b();
        bVar.a(str, strArr);
        if (i2 == 2) {
            bVar.a("_id = ?", a(uri));
        }
        return bVar;
    }

    private ContentValues a(ContentValues contentValues) {
        ContentValues contentValues2 = new ContentValues();
        Iterator<Map.Entry<String, Object>> it = contentValues.valueSet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            if (key.startsWith(Downloads.RequestHeaders.INSERT_KEY_PREFIX)) {
                contentValues2.put(key, contentValues.getAsString(key));
                it.remove();
            }
        }
        return contentValues2;
    }

    private void a(Context context) {
        DownloadReceiver downloadReceiver = new DownloadReceiver();
        context.registerReceiver(downloadReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        com.vivo.ic.dm.network.h.a().c(context);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addDataScheme("file");
        context.registerReceiver(downloadReceiver, intentFilter);
        context.registerReceiver(new ShutDownReceiver(), new IntentFilter("android.intent.action.ACTION_SHUTDOWN"));
    }

    private void a(ContentValues contentValues, String str, String[] strArr) {
        Integer asInteger = contentValues.getAsInteger("status");
        if (asInteger == null || asInteger.intValue() != 190) {
            return;
        }
        if (str == null || !str.replace(" ", "").contains("_id=?")) {
            return;
        }
        SQLiteDatabase writableDatabase = this.f28358e.getWritableDatabase();
        String[] strArr2 = {"_id"};
        Cursor cursor = null;
        try {
            b bVar = new b();
            if (!TextUtils.isEmpty(str)) {
                bVar.b(str, strArr);
            }
            bVar.a("status in (?,?,?,?,?)", String.valueOf(Downloads.Impl.STATUS_PENDING), String.valueOf(Downloads.Impl.STATUS_RUNNING), String.valueOf(Downloads.Impl.STATUS_WAITING_TO_RETRY), String.valueOf(Downloads.Impl.STATUS_WAITING_FOR_NETWORK), String.valueOf(196));
            cursor = writableDatabase.query(j.f28479a, strArr2, bVar.b(), bVar.a(), null, null, null);
            if (cursor != null && cursor.getCount() < l.j().c()) {
                asInteger = Integer.valueOf(Downloads.Impl.STATUS_RUNNING);
            }
        } catch (Exception e2) {
            VLog.w(f28354a, "delete query error", e2);
        } finally {
            com.vivo.ic.dm.util.b.a(cursor);
        }
        contentValues.put("status", asInteger);
    }
}
