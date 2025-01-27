package androidx.loader.content;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.DebugUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class Loader<D> {

    /* renamed from: a */
    int f2673a;

    /* renamed from: b */
    OnLoadCompleteListener<D> f2674b;

    /* renamed from: c */
    OnLoadCanceledListener<D> f2675c;

    /* renamed from: d */
    Context f2676d;

    /* renamed from: e */
    boolean f2677e = false;

    /* renamed from: f */
    boolean f2678f = false;

    /* renamed from: g */
    boolean f2679g = true;

    /* renamed from: h */
    boolean f2680h = false;

    /* renamed from: i */
    boolean f2681i = false;

    public final class ForceLoadContentObserver extends ContentObserver {
        public ForceLoadContentObserver() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Loader.this.onContentChanged();
        }
    }

    public interface OnLoadCanceledListener<D> {
        void onLoadCanceled(@NonNull Loader<D> loader);
    }

    public interface OnLoadCompleteListener<D> {
        void onLoadComplete(@NonNull Loader<D> loader, @Nullable D d2);
    }

    public Loader(@NonNull Context context) {
        this.f2676d = context.getApplicationContext();
    }

    @MainThread
    protected void a() {
    }

    @MainThread
    public void abandon() {
        this.f2678f = true;
        a();
    }

    @MainThread
    protected boolean b() {
        return false;
    }

    @MainThread
    protected void c() {
    }

    @MainThread
    public boolean cancelLoad() {
        return b();
    }

    public void commitContentChanged() {
        this.f2681i = false;
    }

    @MainThread
    protected void d() {
    }

    @NonNull
    public String dataToString(@Nullable D d2) {
        StringBuilder sb = new StringBuilder(64);
        DebugUtils.buildShortClassTag(d2, sb);
        sb.append("}");
        return sb.toString();
    }

    @MainThread
    public void deliverCancellation() {
        OnLoadCanceledListener<D> onLoadCanceledListener = this.f2675c;
        if (onLoadCanceledListener != null) {
            onLoadCanceledListener.onLoadCanceled(this);
        }
    }

    @MainThread
    public void deliverResult(@Nullable D d2) {
        OnLoadCompleteListener<D> onLoadCompleteListener = this.f2674b;
        if (onLoadCompleteListener != null) {
            onLoadCompleteListener.onLoadComplete(this, d2);
        }
    }

    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f2673a);
        printWriter.print(" mListener=");
        printWriter.println(this.f2674b);
        if (this.f2677e || this.f2680h || this.f2681i) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f2677e);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f2680h);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f2681i);
        }
        if (this.f2678f || this.f2679g) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f2678f);
            printWriter.print(" mReset=");
            printWriter.println(this.f2679g);
        }
    }

    @MainThread
    protected void e() {
    }

    @MainThread
    protected void f() {
    }

    @MainThread
    public void forceLoad() {
        c();
    }

    @NonNull
    public Context getContext() {
        return this.f2676d;
    }

    public int getId() {
        return this.f2673a;
    }

    public boolean isAbandoned() {
        return this.f2678f;
    }

    public boolean isReset() {
        return this.f2679g;
    }

    public boolean isStarted() {
        return this.f2677e;
    }

    @MainThread
    public void onContentChanged() {
        if (this.f2677e) {
            forceLoad();
        } else {
            this.f2680h = true;
        }
    }

    @MainThread
    public void registerListener(int i2, @NonNull OnLoadCompleteListener<D> onLoadCompleteListener) {
        if (this.f2674b != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f2674b = onLoadCompleteListener;
        this.f2673a = i2;
    }

    @MainThread
    public void registerOnLoadCanceledListener(@NonNull OnLoadCanceledListener<D> onLoadCanceledListener) {
        if (this.f2675c != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f2675c = onLoadCanceledListener;
    }

    @MainThread
    public void reset() {
        d();
        this.f2679g = true;
        this.f2677e = false;
        this.f2678f = false;
        this.f2680h = false;
        this.f2681i = false;
    }

    public void rollbackContentChanged() {
        if (this.f2681i) {
            onContentChanged();
        }
    }

    @MainThread
    public final void startLoading() {
        this.f2677e = true;
        this.f2679g = false;
        this.f2678f = false;
        e();
    }

    @MainThread
    public void stopLoading() {
        this.f2677e = false;
        f();
    }

    public boolean takeContentChanged() {
        boolean z = this.f2680h;
        this.f2680h = false;
        this.f2681i |= z;
        return z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        DebugUtils.buildShortClassTag(this, sb);
        sb.append(" id=");
        sb.append(this.f2673a);
        sb.append("}");
        return sb.toString();
    }

    @MainThread
    public void unregisterListener(@NonNull OnLoadCompleteListener<D> onLoadCompleteListener) {
        OnLoadCompleteListener<D> onLoadCompleteListener2 = this.f2674b;
        if (onLoadCompleteListener2 == null) {
            throw new IllegalStateException("No listener register");
        }
        if (onLoadCompleteListener2 != onLoadCompleteListener) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.f2674b = null;
    }

    @MainThread
    public void unregisterOnLoadCanceledListener(@NonNull OnLoadCanceledListener<D> onLoadCanceledListener) {
        OnLoadCanceledListener<D> onLoadCanceledListener2 = this.f2675c;
        if (onLoadCanceledListener2 == null) {
            throw new IllegalStateException("No listener register");
        }
        if (onLoadCanceledListener2 != onLoadCanceledListener) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.f2675c = null;
    }
}
