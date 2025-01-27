package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class AndroidViewModel extends ViewModel {

    /* renamed from: c */
    @SuppressLint({"StaticFieldLeak"})
    private Application f2560c;

    public AndroidViewModel(@NonNull Application application) {
        this.f2560c = application;
    }

    @NonNull
    public <T extends Application> T getApplication() {
        return (T) this.f2560c;
    }
}
