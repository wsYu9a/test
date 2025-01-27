package com.wbl.ad.yzz.network.bean.request;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.bean.b;
import com.wbl.ad.yzz.config.PageOptions;
import java.io.Serializable;

/* loaded from: classes5.dex */
public final class UpRpNumbersReq extends SceneReq implements Serializable {
    public final int event_type;
    public final int is_active;
    public final String supplier;
    public String third_user_id;
    public final String uniq_id;
    public final int user_id;

    public UpRpNumbersReq(int i2, int i3, int i4, String str, String str2, String str3, PageOptions pageOptions) {
        this.user_id = i2;
        this.event_type = i3;
        this.is_active = i4;
        this.supplier = str;
        this.uniq_id = str2;
        setScene(str3);
        setupPageOptions(pageOptions);
    }

    public static UpRpNumbersReq a(int i2, int i3, int i4, String str, String str2, String str3, PageOptions pageOptions) {
        return (UpRpNumbersReq) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11258, null, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, str2, str3, pageOptions);
    }

    public static UpRpNumbersReq browseInstanceOf(int i2, int i3, b bVar, String str, PageOptions pageOptions) {
        return (UpRpNumbersReq) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11257, null, Integer.valueOf(i2), Integer.valueOf(i3), bVar, str, pageOptions);
    }

    public static UpRpNumbersReq createTurnAroundRedPacket(int i2, int i3, String str, PageOptions pageOptions) {
        return (UpRpNumbersReq) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11260, null, Integer.valueOf(i2), Integer.valueOf(i3), str, pageOptions);
    }

    public static UpRpNumbersReq installInstanceOf(int i2, int i3, b bVar, String str, PageOptions pageOptions) {
        return (UpRpNumbersReq) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11259, null, Integer.valueOf(i2), Integer.valueOf(i3), bVar, str, pageOptions);
    }

    public static UpRpNumbersReq recentAdInstanceOf(int i2, int i3, int i4, b bVar, String str, PageOptions pageOptions) {
        return (UpRpNumbersReq) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11254, null, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), bVar, str, pageOptions);
    }

    public static UpRpNumbersReq recentAdInstanceOf(int i2, int i3, int i4, String str, PageOptions pageOptions) {
        return (UpRpNumbersReq) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11253, null, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, pageOptions);
    }

    public static UpRpNumbersReq simpleInstanceOf(int i2, int i3, int i4, String str, PageOptions pageOptions) {
        return (UpRpNumbersReq) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11256, null, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, pageOptions);
    }

    public static UpRpNumbersReq stayInstanceOf(int i2, int i3, String str, PageOptions pageOptions) {
        return (UpRpNumbersReq) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11255, null, Integer.valueOf(i2), Integer.valueOf(i3), str, pageOptions);
    }

    public void setupPageOptions(PageOptions pageOptions) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11250, this, pageOptions);
    }
}
