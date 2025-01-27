package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import androidx.annotation.RestrictTo;
import androidx.cursoradapter.widget.CursorFilter;

/* loaded from: classes.dex */
public abstract class CursorAdapter extends BaseAdapter implements Filterable, CursorFilter.CursorFilterClient {

    @Deprecated
    public static final int FLAG_AUTO_REQUERY = 1;
    public static final int FLAG_REGISTER_CONTENT_OBSERVER = 2;

    /* renamed from: a */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected boolean f2224a;

    /* renamed from: b */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected boolean f2225b;

    /* renamed from: c */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected Cursor f2226c;

    /* renamed from: d */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected Context f2227d;

    /* renamed from: e */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected int f2228e;

    /* renamed from: f */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected ChangeObserver f2229f;

    /* renamed from: g */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected DataSetObserver f2230g;

    /* renamed from: h */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected CursorFilter f2231h;

    /* renamed from: i */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected FilterQueryProvider f2232i;

    private class ChangeObserver extends ContentObserver {
        ChangeObserver() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            CursorAdapter.this.c();
        }
    }

    private class MyDataSetObserver extends DataSetObserver {
        MyDataSetObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            CursorAdapter cursorAdapter = CursorAdapter.this;
            cursorAdapter.f2224a = true;
            cursorAdapter.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            CursorAdapter cursorAdapter = CursorAdapter.this;
            cursorAdapter.f2224a = false;
            cursorAdapter.notifyDataSetInvalidated();
        }
    }

    @Deprecated
    public CursorAdapter(Context context, Cursor cursor) {
        a(context, cursor, 1);
    }

    void a(Context context, Cursor cursor, int i2) {
        if ((i2 & 1) == 1) {
            i2 |= 2;
            this.f2225b = true;
        } else {
            this.f2225b = false;
        }
        boolean z = cursor != null;
        this.f2226c = cursor;
        this.f2224a = z;
        this.f2227d = context;
        this.f2228e = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i2 & 2) == 2) {
            this.f2229f = new ChangeObserver();
            this.f2230g = new MyDataSetObserver();
        } else {
            this.f2229f = null;
            this.f2230g = null;
        }
        if (z) {
            ChangeObserver changeObserver = this.f2229f;
            if (changeObserver != null) {
                cursor.registerContentObserver(changeObserver);
            }
            DataSetObserver dataSetObserver = this.f2230g;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    @Deprecated
    protected void b(Context context, Cursor cursor, boolean z) {
        a(context, cursor, z ? 1 : 2);
    }

    public abstract void bindView(View view, Context context, Cursor cursor);

    protected void c() {
        Cursor cursor;
        if (!this.f2225b || (cursor = this.f2226c) == null || cursor.isClosed()) {
            return;
        }
        this.f2224a = this.f2226c.requery();
    }

    public void changeCursor(Cursor cursor) {
        Cursor swapCursor = swapCursor(cursor);
        if (swapCursor != null) {
            swapCursor.close();
        }
    }

    public CharSequence convertToString(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.f2224a || (cursor = this.f2226c) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public Cursor getCursor() {
        return this.f2226c;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        if (!this.f2224a) {
            return null;
        }
        this.f2226c.moveToPosition(i2);
        if (view == null) {
            view = newDropDownView(this.f2227d, this.f2226c, viewGroup);
        }
        bindView(view, this.f2227d, this.f2226c);
        return view;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f2231h == null) {
            this.f2231h = new CursorFilter(this);
        }
        return this.f2231h;
    }

    public FilterQueryProvider getFilterQueryProvider() {
        return this.f2232i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        Cursor cursor;
        if (!this.f2224a || (cursor = this.f2226c) == null) {
            return null;
        }
        cursor.moveToPosition(i2);
        return this.f2226c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        Cursor cursor;
        if (this.f2224a && (cursor = this.f2226c) != null && cursor.moveToPosition(i2)) {
            return this.f2226c.getLong(this.f2228e);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (!this.f2224a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (this.f2226c.moveToPosition(i2)) {
            if (view == null) {
                view = newView(this.f2227d, this.f2226c, viewGroup);
            }
            bindView(view, this.f2227d, this.f2226c);
            return view;
        }
        throw new IllegalStateException("couldn't move cursor to position " + i2);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return newView(context, cursor, viewGroup);
    }

    public abstract View newView(Context context, Cursor cursor, ViewGroup viewGroup);

    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        FilterQueryProvider filterQueryProvider = this.f2232i;
        return filterQueryProvider != null ? filterQueryProvider.runQuery(charSequence) : this.f2226c;
    }

    public void setFilterQueryProvider(FilterQueryProvider filterQueryProvider) {
        this.f2232i = filterQueryProvider;
    }

    public Cursor swapCursor(Cursor cursor) {
        Cursor cursor2 = this.f2226c;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            ChangeObserver changeObserver = this.f2229f;
            if (changeObserver != null) {
                cursor2.unregisterContentObserver(changeObserver);
            }
            DataSetObserver dataSetObserver = this.f2230g;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f2226c = cursor;
        if (cursor != null) {
            ChangeObserver changeObserver2 = this.f2229f;
            if (changeObserver2 != null) {
                cursor.registerContentObserver(changeObserver2);
            }
            DataSetObserver dataSetObserver2 = this.f2230g;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f2228e = cursor.getColumnIndexOrThrow("_id");
            this.f2224a = true;
            notifyDataSetChanged();
        } else {
            this.f2228e = -1;
            this.f2224a = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }

    public CursorAdapter(Context context, Cursor cursor, boolean z) {
        a(context, cursor, z ? 1 : 2);
    }

    public CursorAdapter(Context context, Cursor cursor, int i2) {
        a(context, cursor, i2);
    }
}
