package androidx.constraintlayout.core.state;

/* loaded from: classes.dex */
public interface RegistryCallback {
    String currentLayoutInformation();

    String currentMotionScene();

    long getLastModified();

    void onDimensions(int i10, int i11);

    void onNewMotionScene(String str);

    void onProgress(float f10);

    void setDrawDebug(int i10);

    void setLayoutInformationMode(int i10);
}
