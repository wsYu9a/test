package com.wbl.ad.yzz.network.bean.request;

import android.content.Context;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.config.PageOptions;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class GetPageMsgReq extends BaseReq implements Serializable {
    private String android_id;
    private String ap_mac;
    private String ap_mac2;
    private String ap_name;
    private int bgtype;
    private String book_id;
    private String cellular_id;
    private int chapter;
    private String connection_type;
    private String coordinate_type;
    private String evltn;
    private int force_quit_count;
    private int height;
    private String imei;
    private int is_active;
    private int is_active_call;
    private int is_checking;
    private String is_connected;
    private int is_free;
    private double latitude;
    private double longitude;
    private String mac;
    private String model;
    private int noad;
    private int np;
    private int nv;
    private String oaid;
    private String operator_type;
    private String os_version;
    private int page;
    private String rssi;
    private int sex;
    private int user_id;
    private int user_type;
    private String vendor;
    private int width;
    private String wifi_aps;

    public GetPageMsgReq(PageOptions pageOptions) {
        super(pageOptions);
        this.is_checking = 0;
        this.np = 0;
        this.nv = 0;
    }

    public String getAndroid_id() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11179, this, null);
    }

    public String getAp_mac() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11174, this, null);
    }

    public String getAp_mac2() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11173, this, null);
    }

    public String getAp_name() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11176, this, null);
    }

    public int getBgtype() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-11175, this, null);
    }

    public String getBook_id() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11170, this, null);
    }

    public String getCellular_id() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11169, this, null);
    }

    public int getChapter() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-11172, this, null);
    }

    public String getConnection_type() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11171, this, null);
    }

    public String getCoordinate_type() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11198, this, null);
    }

    public String getEvltn() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11197, this, null);
    }

    public int getForce_quit_count() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-11200, this, null);
    }

    public int getHeight() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-11199, this, null);
    }

    public String getImei() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11194, this, null);
    }

    public int getIs_active() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-11193, this, null);
    }

    public int getIs_active_call() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-11196, this, null);
    }

    public String getIs_connected() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11195, this, null);
    }

    public int getIs_free() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-11190, this, null);
    }

    public double getLatitude() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.d(-11189, this, null);
    }

    public double getLongitude() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.d(-11192, this, null);
    }

    public String getMac() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11191, this, null);
    }

    public String getModel() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11186, this, null);
    }

    public int getNoad() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-11185, this, null);
    }

    public String getOaid() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11188, this, null);
    }

    public String getOperator_type() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11187, this, null);
    }

    public String getOs_version() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11150, this, null);
    }

    public int getPage() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-11149, this, null);
    }

    public String getRssi() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11152, this, null);
    }

    public int getSex() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-11151, this, null);
    }

    public int getUser_type() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-11146, this, null);
    }

    public String getVendor() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11145, this, null);
    }

    public int getWidth() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-11148, this, null);
    }

    public String getWifi_aps() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11147, this, null);
    }

    public boolean isChecking() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-11142, this, null);
    }

    public void setAndroid_id(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11141, this, str);
    }

    public void setAp_mac(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11144, this, str);
    }

    public void setAp_mac2(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11143, this, str);
    }

    public void setAp_name(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11138, this, str);
    }

    public void setBgtype(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11137, this, Integer.valueOf(i2));
    }

    public void setBook_id(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11140, this, str);
    }

    public void setCellular_id(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11139, this, str);
    }

    public void setChapter(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11166, this, Integer.valueOf(i2));
    }

    public void setConnection_type(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11165, this, str);
    }

    public void setCoordinate_type(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11168, this, str);
    }

    public void setEvltn(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11167, this, str);
    }

    public void setForce_quit_count(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11162, this, Integer.valueOf(i2));
    }

    public void setHeight(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11161, this, Integer.valueOf(i2));
    }

    public void setImei(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11164, this, str);
    }

    public void setIs_active_call(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11163, this, Integer.valueOf(i2));
    }

    public void setIs_checking(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11158, this, Integer.valueOf(i2));
    }

    public void setIs_connected(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11157, this, str);
    }

    public void setIs_free(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11160, this, Integer.valueOf(i2));
    }

    public void setLatitude(double d2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11159, this, Double.valueOf(d2));
    }

    public void setLongitude(double d2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11154, this, Double.valueOf(d2));
    }

    public void setMac(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11153, this, str);
    }

    public void setModel(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11156, this, str);
    }

    public void setNoad(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11155, this, Integer.valueOf(i2));
    }

    public void setOaid(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11246, this, str);
    }

    public void setOperator_type(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11245, this, str);
    }

    public void setOs_version(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11248, this, str);
    }

    public void setPage(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11247, this, Integer.valueOf(i2));
    }

    public void setRssi(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11242, this, str);
    }

    public void setSex(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11241, this, Integer.valueOf(i2));
    }

    public void setUser_type(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11244, this, Integer.valueOf(i2));
    }

    public void setVendor(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11243, this, str);
    }

    public void setWidth(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11238, this, Integer.valueOf(i2));
    }

    public void setWifi_aps(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11237, this, str);
    }

    public void setupByPageOptions(PageOptions pageOptions) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11240, this, pageOptions);
    }

    public void setupDataInfo(Context context) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11239, this, context);
    }
}
