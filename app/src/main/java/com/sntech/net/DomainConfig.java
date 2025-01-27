package com.sntech.net;

import androidx.annotation.Keep;
import java.util.HashMap;
import java.util.Map;

@Keep
/* loaded from: classes4.dex */
public class DomainConfig {
    public static final String TEMPLATE_A4 = "new-a4.template";
    public static final String TEMPLATE_DEVICE = "device-center.template";
    public static final String TEMPLATE_DEVICE_ACTIVE = "dcat.template";
    public static final String TEMPLATE_X1 = "x1.template";
    public static final String TEMPLATE_X2 = "x2.template";
    private Map<String, String[]> templateDomains;
    private boolean useHttps;

    /* renamed from: com.sntech.net.DomainConfig$do */
    public static final class Cdo {

        /* renamed from: do */
        public Map<String, String[]> f17do = new HashMap(3);

        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.String[]>] */
        /* renamed from: do */
        public final Cdo m46do(String str, String... strArr) {
            this.f17do.put(str, strArr);
            return this;
        }
    }

    public DomainConfig(Cdo cdo) {
        this.templateDomains = cdo.f17do;
        cdo.getClass();
        this.useHttps = false;
    }

    public Map<String, String[]> getTemplateDomains() {
        return this.templateDomains;
    }

    public boolean isUseHttps() {
        return this.useHttps;
    }
}
