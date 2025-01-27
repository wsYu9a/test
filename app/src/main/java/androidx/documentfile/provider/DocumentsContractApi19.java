package androidx.documentfile.provider;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(19)
/* loaded from: classes.dex */
class DocumentsContractApi19 {

    /* renamed from: a, reason: collision with root package name */
    private static final String f2263a = "DocumentFile";

    /* renamed from: b, reason: collision with root package name */
    private static final int f2264b = 512;

    private DocumentsContractApi19() {
    }

    private static void a(@Nullable AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    @Nullable
    private static String b(Context context, Uri uri) {
        return e(context, uri, "mime_type", null);
    }

    private static int c(Context context, Uri uri, String str, int i2) {
        return (int) d(context, uri, str, i2);
    }

    public static boolean canRead(Context context, Uri uri) {
        return context.checkCallingOrSelfUriPermission(uri, 1) == 0 && !TextUtils.isEmpty(b(context, uri));
    }

    public static boolean canWrite(Context context, Uri uri) {
        if (context.checkCallingOrSelfUriPermission(uri, 2) != 0) {
            return false;
        }
        String b2 = b(context, uri);
        int c2 = c(context, uri, "flags", 0);
        if (TextUtils.isEmpty(b2)) {
            return false;
        }
        if ((c2 & 4) != 0) {
            return true;
        }
        if (!"vnd.android.document/directory".equals(b2) || (c2 & 8) == 0) {
            return (TextUtils.isEmpty(b2) || (c2 & 2) == 0) ? false : true;
        }
        return true;
    }

    private static long d(Context context, Uri uri, String str, long j2) {
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{str}, null, null, null);
            return (!cursor.moveToFirst() || cursor.isNull(0)) ? j2 : cursor.getLong(0);
        } catch (Exception e2) {
            Log.w(f2263a, "Failed query: " + e2);
            return j2;
        } finally {
            a(cursor);
        }
    }

    @Nullable
    private static String e(Context context, Uri uri, String str, @Nullable String str2) {
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{str}, null, null, null);
            return (!cursor.moveToFirst() || cursor.isNull(0)) ? str2 : cursor.getString(0);
        } catch (Exception e2) {
            Log.w(f2263a, "Failed query: " + e2);
            return str2;
        } finally {
            a(cursor);
        }
    }

    public static boolean exists(Context context, Uri uri) {
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"document_id"}, null, null, null);
            return cursor.getCount() > 0;
        } catch (Exception e2) {
            Log.w(f2263a, "Failed query: " + e2);
            return false;
        } finally {
            a(cursor);
        }
    }

    public static long getFlags(Context context, Uri uri) {
        return d(context, uri, "flags", 0L);
    }

    @Nullable
    public static String getName(Context context, Uri uri) {
        return e(context, uri, "_display_name", null);
    }

    @Nullable
    public static String getType(Context context, Uri uri) {
        String b2 = b(context, uri);
        if ("vnd.android.document/directory".equals(b2)) {
            return null;
        }
        return b2;
    }

    public static boolean isDirectory(Context context, Uri uri) {
        return "vnd.android.document/directory".equals(b(context, uri));
    }

    public static boolean isFile(Context context, Uri uri) {
        String b2 = b(context, uri);
        return ("vnd.android.document/directory".equals(b2) || TextUtils.isEmpty(b2)) ? false : true;
    }

    public static boolean isVirtual(Context context, Uri uri) {
        return DocumentsContract.isDocumentUri(context, uri) && (getFlags(context, uri) & 512) != 0;
    }

    public static long lastModified(Context context, Uri uri) {
        return d(context, uri, "last_modified", 0L);
    }

    public static long length(Context context, Uri uri) {
        return d(context, uri, "_size", 0L);
    }
}
