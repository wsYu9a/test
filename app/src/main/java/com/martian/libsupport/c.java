package com.martian.libsupport;

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
public class c implements Cursor {

    /* renamed from: a, reason: collision with root package name */
    private final SQLiteDatabase f10591a;

    /* renamed from: b, reason: collision with root package name */
    private final Cursor f10592b;

    public c(SQLiteDatabase db, Cursor cursor) {
        this.f10591a = db;
        this.f10592b = cursor;
    }

    @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f10592b.close();
        this.f10591a.close();
    }

    @Override // android.database.Cursor
    public void copyStringToBuffer(int columnIndex, CharArrayBuffer buffer) {
        Cursor cursor = this.f10592b;
        if (cursor == null) {
            return;
        }
        cursor.copyStringToBuffer(columnIndex, buffer);
    }

    @Override // android.database.Cursor
    public void deactivate() {
        this.f10592b.deactivate();
    }

    @Override // android.database.Cursor
    public byte[] getBlob(int columnIndex) {
        Cursor cursor = this.f10592b;
        if (cursor == null) {
            return null;
        }
        return cursor.getBlob(columnIndex);
    }

    @Override // android.database.Cursor
    public int getColumnCount() {
        Cursor cursor = this.f10592b;
        if (cursor == null) {
            return 0;
        }
        return cursor.getColumnCount();
    }

    @Override // android.database.Cursor
    public int getColumnIndex(String columnName) {
        Cursor cursor = this.f10592b;
        if (cursor == null) {
            return 0;
        }
        return cursor.getColumnIndex(columnName);
    }

    @Override // android.database.Cursor
    public int getColumnIndexOrThrow(String columnName) throws IllegalArgumentException {
        Cursor cursor = this.f10592b;
        if (cursor == null) {
            return 0;
        }
        return cursor.getColumnIndexOrThrow(columnName);
    }

    @Override // android.database.Cursor
    public String getColumnName(int columnIndex) {
        Cursor cursor = this.f10592b;
        return cursor == null ? "" : cursor.getColumnName(columnIndex);
    }

    @Override // android.database.Cursor
    public String[] getColumnNames() {
        Cursor cursor = this.f10592b;
        if (cursor == null) {
            return null;
        }
        return cursor.getColumnNames();
    }

    @Override // android.database.Cursor
    public int getCount() {
        Cursor cursor = this.f10592b;
        if (cursor == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.database.Cursor
    public double getDouble(int columnIndex) {
        return this.f10592b.getDouble(columnIndex);
    }

    @Override // android.database.Cursor
    public Bundle getExtras() {
        return this.f10592b.getExtras();
    }

    @Override // android.database.Cursor
    public float getFloat(int columnIndex) {
        return this.f10592b.getFloat(columnIndex);
    }

    @Override // android.database.Cursor
    public int getInt(int columnIndex) {
        return this.f10592b.getInt(columnIndex);
    }

    @Override // android.database.Cursor
    public long getLong(int columnIndex) {
        return this.f10592b.getLong(columnIndex);
    }

    @Override // android.database.Cursor
    @TargetApi(19)
    public Uri getNotificationUri() {
        return this.f10592b.getNotificationUri();
    }

    @Override // android.database.Cursor
    public int getPosition() {
        Cursor cursor = this.f10592b;
        if (cursor == null) {
            return 0;
        }
        return cursor.getPosition();
    }

    @Override // android.database.Cursor
    public short getShort(int columnIndex) {
        return this.f10592b.getShort(columnIndex);
    }

    @Override // android.database.Cursor
    public String getString(int columnIndex) {
        Cursor cursor = this.f10592b;
        return cursor == null ? "" : cursor.getString(columnIndex);
    }

    @Override // android.database.Cursor
    @TargetApi(11)
    public int getType(int columnIndex) {
        return this.f10592b.getType(columnIndex);
    }

    @Override // android.database.Cursor
    public boolean getWantsAllOnMoveCalls() {
        return this.f10592b.getWantsAllOnMoveCalls();
    }

    @Override // android.database.Cursor
    public boolean isAfterLast() {
        Cursor cursor = this.f10592b;
        if (cursor == null) {
            return false;
        }
        return cursor.isAfterLast();
    }

    @Override // android.database.Cursor
    public boolean isBeforeFirst() {
        Cursor cursor = this.f10592b;
        if (cursor == null) {
            return false;
        }
        return cursor.isBeforeFirst();
    }

    @Override // android.database.Cursor
    public boolean isClosed() {
        return this.f10592b.isClosed();
    }

    @Override // android.database.Cursor
    public boolean isFirst() {
        Cursor cursor = this.f10592b;
        if (cursor == null) {
            return true;
        }
        return cursor.isFirst();
    }

    @Override // android.database.Cursor
    public boolean isLast() {
        Cursor cursor = this.f10592b;
        if (cursor == null) {
            return false;
        }
        return cursor.isLast();
    }

    @Override // android.database.Cursor
    public boolean isNull(int columnIndex) {
        return this.f10592b.isNull(columnIndex);
    }

    @Override // android.database.Cursor
    public boolean move(int offset) {
        Cursor cursor = this.f10592b;
        if (cursor == null) {
            return false;
        }
        return cursor.move(offset);
    }

    @Override // android.database.Cursor
    public boolean moveToFirst() {
        Cursor cursor = this.f10592b;
        if (cursor == null) {
            return false;
        }
        return cursor.moveToFirst();
    }

    @Override // android.database.Cursor
    public boolean moveToLast() {
        Cursor cursor = this.f10592b;
        if (cursor == null) {
            return false;
        }
        return cursor.moveToLast();
    }

    @Override // android.database.Cursor
    public boolean moveToNext() {
        Cursor cursor = this.f10592b;
        if (cursor == null) {
            return false;
        }
        return cursor.moveToNext();
    }

    @Override // android.database.Cursor
    public boolean moveToPosition(int position) {
        Cursor cursor = this.f10592b;
        if (cursor == null) {
            return false;
        }
        return cursor.moveToPosition(position);
    }

    @Override // android.database.Cursor
    public boolean moveToPrevious() {
        Cursor cursor = this.f10592b;
        if (cursor == null) {
            return false;
        }
        return cursor.moveToPrevious();
    }

    @Override // android.database.Cursor
    public void registerContentObserver(ContentObserver observer) {
        this.f10592b.registerContentObserver(observer);
    }

    @Override // android.database.Cursor
    public void registerDataSetObserver(DataSetObserver observer) {
        this.f10592b.registerDataSetObserver(observer);
    }

    @Override // android.database.Cursor
    public boolean requery() {
        return this.f10592b.requery();
    }

    @Override // android.database.Cursor
    public Bundle respond(Bundle extras) {
        return this.f10592b.respond(extras);
    }

    @Override // android.database.Cursor
    public void setExtras(Bundle extras) {
    }

    @Override // android.database.Cursor
    public void setNotificationUri(ContentResolver cr, Uri uri) {
        this.f10592b.setNotificationUri(cr, uri);
    }

    @Override // android.database.Cursor
    public void unregisterContentObserver(ContentObserver observer) {
        this.f10592b.unregisterContentObserver(observer);
    }

    @Override // android.database.Cursor
    public void unregisterDataSetObserver(DataSetObserver observer) {
        this.f10592b.unregisterDataSetObserver(observer);
    }
}
