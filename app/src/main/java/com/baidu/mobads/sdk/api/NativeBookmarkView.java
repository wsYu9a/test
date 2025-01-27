package com.baidu.mobads.sdk.api;

import android.view.View;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.internal.ay;
import com.sigmob.sdk.base.common.a;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class NativeBookmarkView {
    private View bookmarkView;
    private final NativeResponse nativeResponse;
    private final JSONObject params = new JSONObject();

    public NativeBookmarkView(NativeResponse nativeResponse, int i10, int i11) {
        this.nativeResponse = nativeResponse;
        putValue("type", "template");
        putValue(IAdInterListener.AdReqParam.WIDTH, Integer.valueOf(i10));
        putValue("h", Integer.valueOf(i11));
    }

    private void putValue(String str, Object obj) {
        try {
            this.params.put(str, obj);
        } catch (JSONException e10) {
            ay.b(e10);
        }
    }

    public NativeBookmarkView bottomCardColor(String str) {
        putValue("bottom_card_color", str);
        return this;
    }

    public NativeBookmarkView closeListener(NativeResponse.AdCloseListener adCloseListener) {
        NativeResponse nativeResponse = this.nativeResponse;
        if (nativeResponse instanceof XAdNativeResponse) {
            ((XAdNativeResponse) nativeResponse).setAdCloseListener(adCloseListener);
        }
        return this;
    }

    public NativeBookmarkView dislikeListener(NativeResponse.AdDislikeListener adDislikeListener) {
        NativeResponse nativeResponse = this.nativeResponse;
        if (nativeResponse instanceof XAdNativeResponse) {
            ((XAdNativeResponse) nativeResponse).setAdDislikeListener(adDislikeListener);
        }
        return this;
    }

    public NativeResponse getNativeResponse() {
        return this.nativeResponse;
    }

    public View getView() {
        return this.bookmarkView;
    }

    public NativeBookmarkView hideAdLogo(boolean z10) {
        putValue("hide_ad_logo", Boolean.valueOf(z10));
        return this;
    }

    public NativeBookmarkView hideDislike(boolean z10) {
        putValue("hide_dislike", Boolean.valueOf(z10));
        return this;
    }

    public NativeBookmarkView hideMuteButton(boolean z10) {
        putValue("hide_mute", Boolean.valueOf(z10));
        return this;
    }

    public NativeBookmarkView mute(boolean z10) {
        putValue(a.D, Boolean.valueOf(z10));
        return this;
    }

    public NativeBookmarkView regionClick(boolean z10) {
        putValue("region_click", Boolean.valueOf(z10));
        return this;
    }

    public View render() {
        NativeResponse nativeResponse = this.nativeResponse;
        if (!(nativeResponse instanceof XAdNativeResponse)) {
            return null;
        }
        View renderNativeView = ((XAdNativeResponse) nativeResponse).renderNativeView("bookmark", this.params);
        this.bookmarkView = renderNativeView;
        return renderNativeView;
    }
}
