package com.kwad.sdk.components;

import java.io.Serializable;

/* loaded from: classes3.dex */
public interface DevelopMangerComponents extends b {

    public static class DevelopValue implements Serializable {
        private static final long serialVersionUID = 2793333073373146040L;
        Serializable mValue;

        public DevelopValue(Serializable serializable) {
            this.mValue = serializable;
        }

        public <T> T getValue() {
            T t10 = (T) this.mValue;
            if (t10 != null) {
                return t10;
            }
            return null;
        }
    }

    String Cw();
}
