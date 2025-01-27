package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.LazyHeaders;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public interface Headers {

    @Deprecated
    public static final Headers NONE = new Headers() { // from class: com.bumptech.glide.load.model.Headers.1
        AnonymousClass1() {
        }

        @Override // com.bumptech.glide.load.model.Headers
        public Map<String, String> getHeaders() {
            return Collections.emptyMap();
        }
    };
    public static final Headers DEFAULT = new LazyHeaders.Builder().build();

    /* renamed from: com.bumptech.glide.load.model.Headers$1 */
    class AnonymousClass1 implements Headers {
        AnonymousClass1() {
        }

        @Override // com.bumptech.glide.load.model.Headers
        public Map<String, String> getHeaders() {
            return Collections.emptyMap();
        }
    }

    Map<String, String> getHeaders();
}
