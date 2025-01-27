package com.kwad.sdk.core.webview;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.bm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class b {
    public ViewGroup QI;
    public WebView Qc;
    public com.kwad.sdk.widget.e aIc;

    @Nullable
    public ak aId;
    public boolean aIe = true;
    public boolean aIf = true;
    private List<AdTemplate> aIg = null;
    private AdResultData mAdResultData;

    @Nullable
    public JSONObject mReportExtData;
    public int mScreenOrientation;

    public final List<AdTemplate> IB() {
        List<AdTemplate> list = this.aIg;
        return (list == null || list.size() <= 0) ? this.mAdResultData.getAdTemplateList() : this.aIg;
    }

    public final boolean IC() {
        return IB() == null || IB().size() == 0;
    }

    public final void a(AdResultData adResultData) {
        this.mAdResultData = adResultData;
    }

    public final AdTemplate dg(String str) {
        if (TextUtils.isEmpty(str)) {
            return getAdTemplate();
        }
        for (AdTemplate adTemplate : IB()) {
            if (bm.isEquals(str, String.valueOf(com.kwad.sdk.core.response.b.e.el(adTemplate)))) {
                return adTemplate;
            }
        }
        return null;
    }

    public final AdTemplate getAdTemplate() {
        List<AdTemplate> list = this.aIg;
        return (list == null || list.size() <= 0) ? com.kwad.sdk.core.response.b.c.o(this.mAdResultData) : this.aIg.get(0);
    }

    public final Context getContext() {
        WebView webView = this.Qc;
        if (webView == null) {
            return null;
        }
        return webView.getContext();
    }

    public final AdResultData hF() {
        AdResultData adResultData = this.mAdResultData;
        if (adResultData != null) {
            return adResultData;
        }
        if (this.aIg == null) {
            return null;
        }
        AdResultData adResultData2 = new AdResultData();
        adResultData2.setAdTemplateList(this.aIg);
        return adResultData2;
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.aIg = arrayList;
        arrayList.add(adTemplate);
    }

    public final void setAdTemplateList(List<AdTemplate> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<AdTemplate> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        this.aIg = arrayList;
    }
}
