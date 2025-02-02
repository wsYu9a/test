package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.view.View;
import com.baidu.mobads.sdk.api.EntryResponse;
import com.baidu.mobads.sdk.internal.a;
import com.baidu.mobads.sdk.internal.cq;
import com.baidu.mobads.sdk.internal.de;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class XAdEntryResponse implements EntryResponse {
    private static final String TAG = "XAdEntryResponse";
    private boolean isDownloadApp;
    private a mAdInfo;
    private EntryResponse.EntryAdInteractionListener mAdInteractionListener;
    private Context mCxt;
    private de mFeedsProd;
    private cq mUriUtils;

    public XAdEntryResponse(Context context, de deVar, a aVar) {
        this.isDownloadApp = false;
        this.mCxt = context;
        this.mFeedsProd = deVar;
        this.mAdInfo = aVar;
        if (aVar.p() == 2) {
            this.isDownloadApp = true;
        }
        this.mUriUtils = cq.a();
    }

    @Override // com.baidu.mobads.sdk.api.EntryResponse
    public String getAdLogoUrl() {
        a aVar = this.mAdInfo;
        return aVar != null ? aVar.h() : "https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png";
    }

    @Override // com.baidu.mobads.sdk.api.EntryResponse
    public String getBaiduLogoUrl() {
        a aVar = this.mAdInfo;
        return aVar != null ? aVar.i() : "https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png";
    }

    @Override // com.baidu.mobads.sdk.api.EntryResponse
    public String getTitle() {
        a aVar = this.mAdInfo;
        return aVar != null ? aVar.a() : "";
    }

    public String getUniqueId() {
        a aVar = this.mAdInfo;
        return aVar != null ? aVar.I() : "";
    }

    @Override // com.baidu.mobads.sdk.api.EntryResponse
    public boolean isAdAvailable() {
        return this.mAdInfo != null && System.currentTimeMillis() - this.mAdInfo.y() <= this.mAdInfo.G();
    }

    public void onADExposed() {
        EntryResponse.EntryAdInteractionListener entryAdInteractionListener = this.mAdInteractionListener;
        if (entryAdInteractionListener != null) {
            entryAdInteractionListener.onADExposed();
        }
    }

    public void onADExposureFailed(int i10) {
        EntryResponse.EntryAdInteractionListener entryAdInteractionListener = this.mAdInteractionListener;
        if (entryAdInteractionListener != null) {
            entryAdInteractionListener.onADExposureFailed(i10);
        }
    }

    public void onAdClick() {
        EntryResponse.EntryAdInteractionListener entryAdInteractionListener = this.mAdInteractionListener;
        if (entryAdInteractionListener != null) {
            entryAdInteractionListener.onAdClick();
        }
    }

    public void onAdUnionClick() {
        EntryResponse.EntryAdInteractionListener entryAdInteractionListener = this.mAdInteractionListener;
        if (entryAdInteractionListener != null) {
            entryAdInteractionListener.onAdUnionClick();
        }
    }

    @Override // com.baidu.mobads.sdk.api.EntryResponse
    public void registerViewForInteraction(View view, List<View> list, List<View> list2, EntryResponse.EntryAdInteractionListener entryAdInteractionListener) {
        this.mAdInteractionListener = entryAdInteractionListener;
        if (this.mFeedsProd != null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("adView", view);
                hashMap.put("clickViews", list);
                hashMap.put("creativeViews", list2);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("msg", "registerViewForInteraction");
                jSONObject.put("uniqueId", getUniqueId());
                jSONObject.put("isDownloadApp", this.isDownloadApp);
                this.mFeedsProd.a(jSONObject, hashMap);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.EntryResponse
    public void unionLogoClick() {
        cq cqVar;
        if (this.mFeedsProd == null || (cqVar = this.mUriUtils) == null) {
            return;
        }
        String c10 = cqVar.c("http://union.baidu.com/");
        JSONObject U = this.mAdInfo.U();
        try {
            U.put("unionUrl", c10);
            U.put("msg", "unionLogoClick");
        } catch (Throwable unused) {
        }
        this.mFeedsProd.a(U);
    }
}
