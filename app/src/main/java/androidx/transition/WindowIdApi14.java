package androidx.transition;

import android.os.IBinder;

/* loaded from: classes.dex */
class WindowIdApi14 implements WindowIdImpl {

    /* renamed from: a */
    private final IBinder f3921a;

    WindowIdApi14(IBinder iBinder) {
        this.f3921a = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof WindowIdApi14) && ((WindowIdApi14) obj).f3921a.equals(this.f3921a);
    }

    public int hashCode() {
        return this.f3921a.hashCode();
    }
}
