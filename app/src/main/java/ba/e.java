package ba;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;

/* loaded from: classes3.dex */
public class e implements Cursor {

    /* renamed from: b, reason: collision with root package name */
    public final SQLiteDatabase f1464b;

    /* renamed from: c, reason: collision with root package name */
    public final Cursor f1465c;

    public e(SQLiteDatabase sQLiteDatabase, Cursor cursor) {
        this.f1464b = sQLiteDatabase;
        this.f1465c = cursor;
    }

    @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f1465c.close();
        this.f1464b.close();
    }

    @Override // android.database.Cursor
    public void copyStringToBuffer(int i10, CharArrayBuffer charArrayBuffer) {
        Cursor cursor = this.f1465c;
        if (cursor == null) {
            return;
        }
        cursor.copyStringToBuffer(i10, charArrayBuffer);
    }

    @Override // android.database.Cursor
    public void deactivate() {
        this.f1465c.deactivate();
    }

    @Override // android.database.Cursor
    public byte[] getBlob(int i10) {
        Cursor cursor = this.f1465c;
        if (cursor == null) {
            return null;
        }
        return cursor.getBlob(i10);
    }

    @Override // android.database.Cursor
    public int getColumnCount() {
        Cursor cursor = this.f1465c;
        if (cursor == null) {
            return 0;
        }
        return cursor.getColumnCount();
    }

    @Override // android.database.Cursor
    public int getColumnIndex(String str) {
        Cursor cursor = this.f1465c;
        if (cursor == null) {
            return 0;
        }
        return cursor.getColumnIndex(str);
    }

    @Override // android.database.Cursor
    public int getColumnIndexOrThrow(String str) throws IllegalArgumentException {
        Cursor cursor = this.f1465c;
        if (cursor == null) {
            return 0;
        }
        return cursor.getColumnIndexOrThrow(str);
    }

    @Override // android.database.Cursor
    public String getColumnName(int i10) {
        Cursor cursor = this.f1465c;
        return cursor == null ? "" : cursor.getColumnName(i10);
    }

    @Override // android.database.Cursor
    public String[] getColumnNames() {
        Cursor cursor = this.f1465c;
        if (cursor == null) {
            return null;
        }
        return cursor.getColumnNames();
    }

    @Override // android.database.Cursor
    public int getCount() {
        Cursor cursor = this.f1465c;
        if (cursor == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.database.Cursor
    public double getDouble(int i10) {
        return this.f1465c.getDouble(i10);
    }

    @Override // android.database.Cursor
    public Bundle getExtras() {
        return this.f1465c.getExtras();
    }

    @Override // android.database.Cursor
    public float getFloat(int i10) {
        return this.f1465c.getFloat(i10);
    }

    @Override // android.database.Cursor
    public int getInt(int i10) {
        return this.f1465c.getInt(i10);
    }

    @Override // android.database.Cursor
    public long getLong(int i10) {
        return this.f1465c.getLong(i10);
    }

    @Override // android.database.Cursor
    @TargetApi(19)
    public Uri getNotificationUri() {
        return this.f1465c.getNotificationUri();
    }

    @Override // android.database.Cursor
    public int getPosition() {
        Cursor cursor = this.f1465c;
        if (cursor == null) {
            return 0;
        }
        return cursor.getPosition();
    }

    @Override // android.database.Cursor
    public short getShort(int i10) {
        return this.f1465c.getShort(i10);
    }

    @Override // android.database.Cursor
    public String getString(int i10) {
        Cursor cursor = this.f1465c;
        return cursor == null ? "" : cursor.getString(i10);
    }

    @Override // android.database.Cursor
    public int getType(int i10) {
        return this.f1465c.getType(i10);
    }

    @Override // android.database.Cursor
    public boolean getWantsAllOnMoveCalls() {
        return this.f1465c.getWantsAllOnMoveCalls();
    }

    @Override // android.database.Cursor
    public boolean isAfterLast() {
        Cursor cursor = this.f1465c;
        if (cursor == null) {
            return false;
        }
        return cursor.isAfterLast();
    }

    @Override // android.database.Cursor
    public boolean isBeforeFirst() {
        Cursor cursor = this.f1465c;
        if (cursor == null) {
            return false;
        }
        return cursor.isBeforeFirst();
    }

    @Override // android.database.Cursor
    public boolean isClosed() {
        return this.f1465c.isClosed();
    }

    @Override // android.database.Cursor
    public boolean isFirst() {
        Cursor cursor = this.f1465c;
        if (cursor == null) {
            return true;
        }
        return cursor.isFirst();
    }

    @Override // android.database.Cursor
    public boolean isLast() {
        Cursor cursor = this.f1465c;
        if (cursor == null) {
            return false;
        }
        return cursor.isLast();
    }

    @Override // android.database.Cursor
    public boolean isNull(int i10) {
        return this.f1465c.isNull(i10);
    }

    @Override // android.database.Cursor
    public boolean move(int i10) {
        Cursor cursor = this.f1465c;
        if (cursor == null) {
            return false;
        }
        return cursor.move(i10);
    }

    @Override // android.database.Cursor
    public boolean moveToFirst() {
        Cursor cursor = this.f1465c;
        if (cursor == null) {
            return false;
        }
        return cursor.moveToFirst();
    }

    @Override // android.database.Cursor
    public boolean moveToLast() {
        Cursor cursor = this.f1465c;
        if (cursor == null) {
            return false;
        }
        return cursor.moveToLast();
    }

    @Override // android.database.Cursor
    public boolean moveToNext() {
        Cursor cursor = this.f1465c;
        if (cursor == null) {
            return false;
        }
        return cursor.moveToNext();
    }

    @Override // android.database.Cursor
    public boolean moveToPosition(int i10) {
        Cursor cursor = this.f1465c;
        if (cursor == null) {
            return false;
        }
        return cursor.moveToPosition(i10);
    }

    @Override // android.database.Cursor
    public boolean moveToPrevious() {
        Cursor cursor = this.f1465c;
        if (cursor == null) {
            return false;
        }
        return cursor.moveToPrevious();
    }

    @Override // android.database.Cursor
    public void registerContentObserver(ContentObserver contentObserver) {
        this.f1465c.registerContentObserver(contentObserver);
    }

    @Override // android.database.Cursor
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.f1465c.registerDataSetObserver(dataSetObserver);
    }

    @Override // android.database.Cursor
    public boolean requery() {
        return this.f1465c.requery();
    }

    @Override // android.database.Cursor
    public Bundle respond(Bundle bundle) {
        return this.f1465c.respond(bundle);
    }

    @Override // android.database.Cursor
    public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
        this.f1465c.setNotificationUri(contentResolver, uri);
    }

    @Override // android.database.Cursor
    public void unregisterContentObserver(ContentObserver contentObserver) {
        this.f1465c.unregisterContentObserver(contentObserver);
    }

    @Override // android.database.Cursor
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.f1465c.unregisterDataSetObserver(dataSetObserver);
    }

    @Override // android.database.Cursor
    public void setExtras(Bundle bundle) {
    }
}
