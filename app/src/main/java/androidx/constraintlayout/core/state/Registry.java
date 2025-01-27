package androidx.constraintlayout.core.state;

import java.util.HashMap;
import java.util.Set;

/* loaded from: classes.dex */
public class Registry {
    private static final Registry sRegistry = new Registry();
    private HashMap<String, RegistryCallback> mCallbacks = new HashMap<>();

    public static Registry getInstance() {
        return sRegistry;
    }

    public String currentContent(String str) {
        RegistryCallback registryCallback = this.mCallbacks.get(str);
        if (registryCallback != null) {
            return registryCallback.currentMotionScene();
        }
        return null;
    }

    public String currentLayoutInformation(String str) {
        RegistryCallback registryCallback = this.mCallbacks.get(str);
        if (registryCallback != null) {
            return registryCallback.currentLayoutInformation();
        }
        return null;
    }

    public long getLastModified(String str) {
        RegistryCallback registryCallback = this.mCallbacks.get(str);
        if (registryCallback != null) {
            return registryCallback.getLastModified();
        }
        return Long.MAX_VALUE;
    }

    public Set<String> getLayoutList() {
        return this.mCallbacks.keySet();
    }

    public void register(String str, RegistryCallback registryCallback) {
        this.mCallbacks.put(str, registryCallback);
    }

    public void setDrawDebug(String str, int i10) {
        RegistryCallback registryCallback = this.mCallbacks.get(str);
        if (registryCallback != null) {
            registryCallback.setDrawDebug(i10);
        }
    }

    public void setLayoutInformationMode(String str, int i10) {
        RegistryCallback registryCallback = this.mCallbacks.get(str);
        if (registryCallback != null) {
            registryCallback.setLayoutInformationMode(i10);
        }
    }

    public void unregister(String str, RegistryCallback registryCallback) {
        this.mCallbacks.remove(str);
    }

    public void updateContent(String str, String str2) {
        RegistryCallback registryCallback = this.mCallbacks.get(str);
        if (registryCallback != null) {
            registryCallback.onNewMotionScene(str2);
        }
    }

    public void updateDimensions(String str, int i10, int i11) {
        RegistryCallback registryCallback = this.mCallbacks.get(str);
        if (registryCallback != null) {
            registryCallback.onDimensions(i10, i11);
        }
    }

    public void updateProgress(String str, float f10) {
        RegistryCallback registryCallback = this.mCallbacks.get(str);
        if (registryCallback != null) {
            registryCallback.onProgress(f10);
        }
    }
}
