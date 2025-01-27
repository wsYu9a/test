package com.kwad.components.ad.reward;

/* loaded from: classes.dex */
public final class p {
    public static void a(int i2, int i3, j jVar, com.kwad.components.ad.reward.model.c cVar) {
        if (i2 == 0) {
            com.kwad.sdk.core.report.a.m(cVar.getAdTemplate(), 1);
            return;
        }
        if (i2 == 1) {
            boolean jv = jVar.px.jv();
            if (i3 == 0) {
                if (jv) {
                    com.kwad.sdk.core.report.a.m(cVar.getAdTemplate(), 1);
                    return;
                }
                return;
            } else if (jv) {
                com.kwad.sdk.core.report.a.m(cVar.getAdTemplate(), 5);
                return;
            } else {
                com.kwad.sdk.core.report.a.m(cVar.getAdTemplate(), 4);
                return;
            }
        }
        if (i2 != 2) {
            return;
        }
        boolean jv2 = jVar.pw.jv();
        if (i3 == 0) {
            if (jv2) {
                com.kwad.sdk.core.report.a.m(cVar.getAdTemplate(), 1);
            }
        } else if (jv2) {
            com.kwad.sdk.core.report.a.m(cVar.getAdTemplate(), 3);
        } else {
            com.kwad.sdk.core.report.a.m(cVar.getAdTemplate(), 2);
        }
    }
}
