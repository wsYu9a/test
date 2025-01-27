package androidx.loader.content;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContentResolverCompat;
import androidx.core.os.CancellationSignal;
import androidx.core.os.OperationCanceledException;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

/* loaded from: classes.dex */
public class CursorLoader extends AsyncTaskLoader<Cursor> {
    final Loader<Cursor>.ForceLoadContentObserver r;
    Uri s;
    String[] t;
    String u;
    String[] v;
    String w;
    Cursor x;
    CancellationSignal y;

    public CursorLoader(@NonNull Context context) {
        super(context);
        this.r = new Loader.ForceLoadContentObserver();
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    public void cancelLoadInBackground() {
        super.cancelLoadInBackground();
        synchronized (this) {
            CancellationSignal cancellationSignal = this.y;
            if (cancellationSignal != null) {
                cancellationSignal.cancel();
            }
        }
    }

    @Override // androidx.loader.content.Loader
    protected void d() {
        super.d();
        f();
        Cursor cursor = this.x;
        if (cursor != null && !cursor.isClosed()) {
            this.x.close();
        }
        this.x = null;
    }

    @Override // androidx.loader.content.AsyncTaskLoader, androidx.loader.content.Loader
    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("mUri=");
        printWriter.println(this.s);
        printWriter.print(str);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.t));
        printWriter.print(str);
        printWriter.print("mSelection=");
        printWriter.println(this.u);
        printWriter.print(str);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.v));
        printWriter.print(str);
        printWriter.print("mSortOrder=");
        printWriter.println(this.w);
        printWriter.print(str);
        printWriter.print("mCursor=");
        printWriter.println(this.x);
        printWriter.print(str);
        printWriter.print("mContentChanged=");
        printWriter.println(this.f2680h);
    }

    @Override // androidx.loader.content.Loader
    protected void e() {
        Cursor cursor = this.x;
        if (cursor != null) {
            deliverResult(cursor);
        }
        if (takeContentChanged() || this.x == null) {
            forceLoad();
        }
    }

    @Override // androidx.loader.content.Loader
    protected void f() {
        cancelLoad();
    }

    @Nullable
    public String[] getProjection() {
        return this.t;
    }

    @Nullable
    public String getSelection() {
        return this.u;
    }

    @Nullable
    public String[] getSelectionArgs() {
        return this.v;
    }

    @Nullable
    public String getSortOrder() {
        return this.w;
    }

    @NonNull
    public Uri getUri() {
        return this.s;
    }

    public void setProjection(@Nullable String[] strArr) {
        this.t = strArr;
    }

    public void setSelection(@Nullable String str) {
        this.u = str;
    }

    public void setSelectionArgs(@Nullable String[] strArr) {
        this.v = strArr;
    }

    public void setSortOrder(@Nullable String str) {
        this.w = str;
    }

    public void setUri(@NonNull Uri uri) {
        this.s = uri;
    }

    @Override // androidx.loader.content.Loader
    public void deliverResult(Cursor cursor) {
        if (isReset()) {
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        Cursor cursor2 = this.x;
        this.x = cursor;
        if (isStarted()) {
            super.deliverResult((CursorLoader) cursor);
        }
        if (cursor2 == null || cursor2 == cursor || cursor2.isClosed()) {
            return;
        }
        cursor2.close();
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    public Cursor loadInBackground() {
        synchronized (this) {
            if (isLoadInBackgroundCanceled()) {
                throw new OperationCanceledException();
            }
            this.y = new CancellationSignal();
        }
        try {
            Cursor query = ContentResolverCompat.query(getContext().getContentResolver(), this.s, this.t, this.u, this.v, this.w, this.y);
            if (query != null) {
                try {
                    query.getCount();
                    query.registerContentObserver(this.r);
                } catch (RuntimeException e2) {
                    query.close();
                    throw e2;
                }
            }
            synchronized (this) {
                this.y = null;
            }
            return query;
        } catch (Throwable th) {
            synchronized (this) {
                this.y = null;
                throw th;
            }
        }
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    public void onCanceled(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return;
        }
        cursor.close();
    }

    public CursorLoader(@NonNull Context context, @NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        super(context);
        this.r = new Loader.ForceLoadContentObserver();
        this.s = uri;
        this.t = strArr;
        this.u = str;
        this.v = strArr2;
        this.w = str2;
    }
}
