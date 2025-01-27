package com.heytap.msp.mobad.api.listener;

/* loaded from: classes.dex */
public interface IInitListener {
    public static final IInitListener NONE = new IInitListener() { // from class: com.heytap.msp.mobad.api.listener.IInitListener.1
        @Override // com.heytap.msp.mobad.api.listener.IInitListener
        public void onFailed(String str) {
        }

        @Override // com.heytap.msp.mobad.api.listener.IInitListener
        public void onSuccess() {
        }
    };

    void onFailed(String str);

    void onSuccess();
}
