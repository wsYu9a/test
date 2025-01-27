package androidx.media3.common.util;

import java.util.Arrays;

@UnstableApi
/* loaded from: classes.dex */
public abstract class LibraryLoader {
    private static final String TAG = "LibraryLoader";
    private boolean isAvailable;
    private boolean loadAttempted;
    private String[] nativeLibraries;

    public LibraryLoader(String... strArr) {
        this.nativeLibraries = strArr;
    }

    public synchronized boolean isAvailable() {
        if (this.loadAttempted) {
            return this.isAvailable;
        }
        this.loadAttempted = true;
        try {
            for (String str : this.nativeLibraries) {
                loadLibrary(str);
            }
            this.isAvailable = true;
        } catch (UnsatisfiedLinkError unused) {
            Log.w(TAG, "Failed to load " + Arrays.toString(this.nativeLibraries));
        }
        return this.isAvailable;
    }

    public abstract void loadLibrary(String str);

    public synchronized void setLibraries(String... strArr) {
        Assertions.checkState(!this.loadAttempted, "Cannot set libraries after loading");
        this.nativeLibraries = strArr;
    }
}
