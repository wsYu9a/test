package androidx.transition;

import android.view.View;
import android.view.WindowId;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(18)
/* loaded from: classes.dex */
class WindowIdApi18 implements WindowIdImpl {

    /* renamed from: a */
    private final WindowId f3922a;

    WindowIdApi18(@NonNull View view) {
        this.f3922a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof WindowIdApi18) && ((WindowIdApi18) obj).f3922a.equals(this.f3922a);
    }

    public int hashCode() {
        return this.f3922a.hashCode();
    }
}
