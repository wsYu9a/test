package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import l5.c;

/* loaded from: classes4.dex */
public class WXLocationObject implements WXMediaMessage.IMediaObject {
    private static final String TAG = "MicroMsg.SDK.WXLocationObject";
    public double lat;
    public double lng;

    public WXLocationObject() {
        this(c.f27899e, c.f27899e);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        return true;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putDouble("_wxlocationobject_lat", this.lat);
        bundle.putDouble("_wxlocationobject_lng", this.lng);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 30;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.lat = bundle.getDouble("_wxlocationobject_lat");
        this.lng = bundle.getDouble("_wxlocationobject_lng");
    }

    public WXLocationObject(double d10, double d11) {
        this.lat = d10;
        this.lng = d11;
    }
}
