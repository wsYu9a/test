package com.martian.ttbook.sdk.client;

/* loaded from: classes4.dex */
public interface AdLoadListener {
    public static final AdLoadListener EMPTY = new AdLoadListenerAdapter() { // from class: com.martian.ttbook.sdk.client.AdLoadListener.1
        AnonymousClass1() {
        }

        public String toString() {
            return "AdLoadListener_Empty";
        }
    };

    /* renamed from: com.martian.ttbook.sdk.client.AdLoadListener$1 */
    static class AnonymousClass1 extends AdLoadListenerAdapter {
        AnonymousClass1() {
        }

        public String toString() {
            return "AdLoadListener_Empty";
        }
    }

    void onLoadCompleted();

    void onLoadError(AdError adError);
}
