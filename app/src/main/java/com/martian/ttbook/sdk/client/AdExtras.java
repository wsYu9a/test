package com.martian.ttbook.sdk.client;

/* loaded from: classes4.dex */
public interface AdExtras {
    public static final AdExtras EMPTY = new AdExtras() { // from class: com.martian.ttbook.sdk.client.AdExtras.1
        AnonymousClass1() {
        }

        @Override // com.martian.ttbook.sdk.client.AdExtras
        public int getIntExtra(String str, int i2) {
            return 0;
        }

        @Override // com.martian.ttbook.sdk.client.AdExtras
        public Object getObjectExtra(String str) {
            return null;
        }

        @Override // com.martian.ttbook.sdk.client.AdExtras
        public String getStringExtra(String str, String str2) {
            return str2;
        }
    };
    public static final String EXTRA_AD_PATTERNTYPE = "ext_AD_PATTERNTYPE";
    public static final String EXTRA_AD_SOURCE = "EXTRA_KEY_network_name";
    public static final String EXTRA_APP_INFOURL = "ext_APP_INFOURL";
    public static final String EXTRA_CLICK_URL = "ext.CLICK_URL";
    public static final String EXTRA_ECPM = "EXTRA_KEY_ad_ecpm";
    public static final String EXTRA_EXAMINE_ID = "ext.EXAMINE_ID";
    public static final String EXTRA_IMG_URL = "ext.IMG_URL";
    public static final String EXTRA_MATERIAL_ID = "ext.MATERIAL_ID";

    /* renamed from: com.martian.ttbook.sdk.client.AdExtras$1 */
    static class AnonymousClass1 implements AdExtras {
        AnonymousClass1() {
        }

        @Override // com.martian.ttbook.sdk.client.AdExtras
        public int getIntExtra(String str, int i2) {
            return 0;
        }

        @Override // com.martian.ttbook.sdk.client.AdExtras
        public Object getObjectExtra(String str) {
            return null;
        }

        @Override // com.martian.ttbook.sdk.client.AdExtras
        public String getStringExtra(String str, String str2) {
            return str2;
        }
    }

    int getIntExtra(String str, int i2);

    Object getObjectExtra(String str);

    String getStringExtra(String str, String str2);
}
