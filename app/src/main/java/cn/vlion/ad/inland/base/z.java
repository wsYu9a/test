package cn.vlion.ad.inland.base;

import android.app.Application;
import android.text.TextUtils;
import cn.vlion.ad.inland.ad.javabean.VlionAdRequest;
import cn.vlion.ad.inland.base.javabean.VlionAdClickStrategyBean;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfigParse;
import cn.vlion.ad.inland.base.util.VlionAdStrategyUtils;
import cn.vlion.ad.inland.base.util.app.VlionAppInfo;
import cn.vlion.ad.inland.base.util.device.VlionDeviceInfo;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.base.util.md5.MD5Utils;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.UUID;

/* loaded from: classes.dex */
public final class z {
    public static String a(VlionAdapterADConfig vlionAdapterADConfig, int i10) {
        if (vlionAdapterADConfig == null) {
            return "";
        }
        VlionAdRequest vlionAdRequest = new VlionAdRequest();
        try {
            Application application = VlionSDkManager.getInstance().getApplication();
            VlionAdRequest.DeviceBean deviceBean = new VlionAdRequest.DeviceBean();
            VlionDeviceInfo vlionDeviceInfo = VlionDeviceInfo.getInstance();
            deviceBean.setOs(vlionDeviceInfo.getOs());
            deviceBean.setOsv(vlionDeviceInfo.getOsv());
            deviceBean.setMac(vlionDeviceInfo.getMac(application));
            if (!TextUtils.isEmpty(vlionDeviceInfo.getMac(application))) {
                deviceBean.setMac_md5(MD5Utils.getMD5Code(vlionDeviceInfo.getMac(application)));
            }
            deviceBean.setUa(vlionDeviceInfo.getUserAgent(application));
            deviceBean.setW(vlionDeviceInfo.getWidth(application));
            deviceBean.setH(vlionDeviceInfo.getHeight(application));
            deviceBean.setPpi(vlionDeviceInfo.getPpi(application));
            deviceBean.setPxratio(vlionDeviceInfo.getPxratio(application));
            deviceBean.setOsl(vlionDeviceInfo.getOsl());
            deviceBean.setImsi(vlionDeviceInfo.getImsi(application));
            deviceBean.setDensity(vlionDeviceInfo.getDensity(application));
            deviceBean.setDpi(vlionDeviceInfo.getDpi(application));
            deviceBean.setScreensize(vlionDeviceInfo.getScreensize(application));
            deviceBean.setSerialno(vlionDeviceInfo.getSerialno(application));
            deviceBean.setOrientation(vlionDeviceInfo.getOrientation(application));
            deviceBean.setBoot_mark(vlionDeviceInfo.getBootMark());
            deviceBean.setUpdate_mark(vlionDeviceInfo.getUpdateMark());
            deviceBean.setMake(vlionDeviceInfo.getMake());
            deviceBean.setModel(vlionDeviceInfo.getModel());
            deviceBean.setDevicetype(vlionDeviceInfo.getDevicetype(application));
            deviceBean.setConnectiontype(vlionDeviceInfo.getConnectionType(application));
            deviceBean.setCarrierId(vlionDeviceInfo.getCarrier(application));
            deviceBean.setTime_zone(vlionDeviceInfo.getOstimezone());
            deviceBean.setSys_cmp_time(VlionDeviceInfo.getBuildTime() + "");
            deviceBean.setBoot_time(VlionDeviceInfo.getStartupTime() + "");
            deviceBean.setUpdate_time(VlionDeviceInfo.getBuildTime() + "");
            deviceBean.setCpu_num(vlionDeviceInfo.getCpuNum());
            deviceBean.setSys_disk_size(vlionDeviceInfo.getStoragetotal() + "");
            deviceBean.setSys_available_size(vlionDeviceInfo.getStorageAvailableBytes() + "");
            deviceBean.setSys_memory(vlionDeviceInfo.getMemorybytes(application) + "");
            String ssid = vlionDeviceInfo.getSSID(application);
            String mac = vlionDeviceInfo.getMac(application);
            if (!TextUtils.isEmpty(ssid)) {
                deviceBean.setSsid(ssid);
            }
            if (!TextUtils.isEmpty(mac)) {
                deviceBean.setWifi_mac(mac);
            }
            String str = vlionDeviceInfo.gethms_ver_code(application);
            if (!TextUtils.isEmpty(str)) {
                deviceBean.setHms_ver_code(str);
            }
            String str2 = vlionDeviceInfo.gethw_ag_ver_code(application);
            if (!TextUtils.isEmpty(str2)) {
                deviceBean.setHw_ag_ver_code(str2);
            }
            String vaid = vlionDeviceInfo.getVaid(application);
            if (!TextUtils.isEmpty(vaid)) {
                deviceBean.setVaid(vaid);
            }
            String str3 = vlionDeviceInfo.getvivo_storever(application);
            if (!TextUtils.isEmpty(str3)) {
                deviceBean.setVivo_storever(str3);
            }
            String str4 = vlionDeviceInfo.getoppo_storever(application);
            if (!TextUtils.isEmpty(str4)) {
                deviceBean.setOppo_storever(str4);
            }
            String str5 = vlionDeviceInfo.gethonor_storever(application);
            if (!TextUtils.isEmpty(str5)) {
                deviceBean.setHonor_storever(str5);
            }
            String str6 = vlionDeviceInfo.getmistorever(application);
            if (!TextUtils.isEmpty(str6)) {
                deviceBean.setMi_storever(str6);
            }
            String str7 = vlionDeviceInfo.getmiui_version(application);
            if (!TextUtils.isEmpty(str7)) {
                deviceBean.setMiui_version(str7);
            }
            String str8 = vlionDeviceInfo.getmzui_version(application);
            if (!TextUtils.isEmpty(str8)) {
                deviceBean.setMzuiVersion(str8);
            }
            String str9 = vlionDeviceInfo.getviui_version(application);
            if (!TextUtils.isEmpty(str9)) {
                deviceBean.setViuiVersion(str9);
            }
            String str10 = vlionDeviceInfo.getopui_version(application);
            if (!TextUtils.isEmpty(str10)) {
                deviceBean.setOpuiVersion(str10);
            }
            String str11 = vlionDeviceInfo.gethwui_version(application);
            if (!TextUtils.isEmpty(str11)) {
                deviceBean.setHuuiVersion(str11);
            }
            String str12 = vlionDeviceInfo.gethonui_version(application);
            if (!TextUtils.isEmpty(str12)) {
                deviceBean.setHouiVersion(str12);
            }
            String deviceName = vlionDeviceInfo.getDeviceName(application);
            if (!TextUtils.isEmpty(deviceName)) {
                deviceBean.setDevice_name(deviceName);
                deviceBean.setDevice_name_md5(MD5Utils.getMD5Code(deviceName));
            }
            deviceBean.setRom_version(vlionDeviceInfo.getRomversion());
            deviceBean.setCpu_freq(vlionDeviceInfo.getCpuFreq().floatValue());
            deviceBean.setBattery_status(vlionDeviceInfo.getBatteryStatus(application));
            deviceBean.setRegion(vlionDeviceInfo.getregion(application));
            deviceBean.setLang(vlionDeviceInfo.getLang());
            deviceBean.setBattery_level(vlionDeviceInfo.getBatteryLevel());
            deviceBean.setRom_version(vlionDeviceInfo.getOsv());
            int wxSdkInt = VlionSDkManager.getInstance().getWxSdkInt();
            String wxSdkVersionName = VlionSDkManager.getInstance().getWxSdkVersionName();
            deviceBean.setWxOpenAppid(VlionServiceConfigParse.getInstance().getWxAppId());
            deviceBean.setWxApiVer(h7.f2859b);
            deviceBean.setWxOpenSdkVer(wxSdkInt);
            deviceBean.setWxOpenSdkVerS(wxSdkVersionName);
            deviceBean.setWxInstalled(h7.f2858a ? 1 : 0);
            LogVlion.e("WXApiUtil getWxApiVer " + deviceBean.getWxApiVer() + " getWxOpenSdkVerS " + deviceBean.getWxOpenSdkVerS() + " getWxOpenSdkVer " + deviceBean.getWxOpenSdkVer() + " getWxInstalled " + deviceBean.getWxInstalled());
            VlionAdRequest.DeviceBean.GeoBean geoBean = new VlionAdRequest.DeviceBean.GeoBean();
            double[] location = vlionDeviceInfo.getLocation(application);
            if (location != null && location.length > 1) {
                geoBean.setLat(location[0]);
                geoBean.setLon(location[1]);
            }
            deviceBean.setGeo(geoBean);
            String imei = vlionDeviceInfo.getImei(application);
            if (!TextUtils.isEmpty(imei)) {
                deviceBean.setDid(imei);
                deviceBean.setDidmd5(MD5Utils.getMD5Code(imei));
            }
            String oaid = vlionDeviceInfo.getOaid();
            if (!TextUtils.isEmpty(oaid)) {
                deviceBean.setOaId(oaid);
                deviceBean.setOaIdMd5(MD5Utils.getMD5Code(oaid));
            }
            String androidId = vlionDeviceInfo.getAndroidId(application);
            if (!TextUtils.isEmpty(androidId)) {
                deviceBean.setAndroidId(androidId);
                deviceBean.setAndroidIdMd5(MD5Utils.getMD5Code(androidId));
            }
            String gaid = vlionDeviceInfo.getGaid(application);
            if (!TextUtils.isEmpty(gaid)) {
                deviceBean.setGaid(gaid);
                deviceBean.setGaidMd5(MD5Utils.getMD5Code(gaid));
            }
            VlionAdRequest.AppBean appBean = new VlionAdRequest.AppBean();
            appBean.setId(VlionSDkManager.getInstance().getAppId());
            appBean.setName(VlionAppInfo.getInstance().getAppName(application));
            appBean.setBundle(VlionAppInfo.getInstance().getPackageName(application));
            appBean.setVer(VlionAppInfo.getInstance().getVersionName(application));
            appBean.setVersion_name(VlionAppInfo.getInstance().getVersionName(application));
            appBean.setVersion_code(vlionDeviceInfo.getAppVersionCode(application, VlionAppInfo.getInstance().getPackageName(application)));
            VlionAdRequest.UserBean userBean = new VlionAdRequest.UserBean();
            userBean.setId(VlionSDkManager.getInstance().getUserId());
            userBean.setAge(String.valueOf(VlionSDkManager.getInstance().getAge()));
            if (VlionSDkManager.getInstance().getConsumeLevel() != null) {
                userBean.setConsume_level(VlionSDkManager.getInstance().getConsumeLevel().getConsumeLevel());
            }
            ArrayList arrayList = new ArrayList();
            VlionAdRequest.ImpBean impBean = new VlionAdRequest.ImpBean();
            impBean.setId(UUID.randomUUID().toString());
            impBean.setTagid(vlionAdapterADConfig.getSlotID());
            impBean.setWidth((int) vlionAdapterADConfig.getWidth());
            impBean.setHeight((int) vlionAdapterADConfig.getHeight());
            impBean.setBidfloor((int) vlionAdapterADConfig.getBidfloor());
            impBean.setDeepLink(1);
            impBean.setAdx_tagid(vlionAdapterADConfig.getAdxTagId());
            impBean.setSecure(1);
            impBean.setImpType(String.valueOf(i10));
            arrayList.add(impBean);
            vlionAdRequest.setId(vlionAdapterADConfig.getTrace());
            vlionAdRequest.setImp(arrayList);
            vlionAdRequest.setApp(appBean);
            vlionAdRequest.setDevice(deviceBean);
            vlionAdRequest.setUser(userBean);
            vlionAdRequest.setAt(2);
            vlionAdRequest.setTmax(500);
            vlionAdRequest.setHitStrategys(VlionServiceConfigParse.getInstance().getStrategysIdList());
            VlionAdRequest.Sdkinfo sdkinfo = new VlionAdRequest.Sdkinfo();
            sdkinfo.setSdkv("6.00.34");
            sdkinfo.setCtime(String.valueOf(System.currentTimeMillis()));
            sdkinfo.setPlatform(VlionSDkManager.getInstance().getPlatformList());
            sdkinfo.setInit_time(String.valueOf(VlionDeviceInfo.getInstance().getSystemInitTime()));
            sdkinfo.setTraceid(vlionAdapterADConfig.getTrace());
            VlionAdClickStrategyBean strategyBean = VlionAdStrategyUtils.getInstance().getStrategyBean(vlionAdapterADConfig.getAdxTagId());
            sdkinfo.setCs_show(strategyBean.getCount());
            sdkinfo.setCs_lstdate(strategyBean.getClickLasttime());
            LogVlion.e("端策略 :  请求数据 vlionAdapterADConfig.getSlotID() =" + vlionAdapterADConfig.getSlotID() + " sdkinfoBean = " + new Gson().toJson(sdkinfo));
            vlionAdRequest.setSdkinfo(sdkinfo);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            LogVlion.e("====请求参数=====Exception=" + th2.getMessage());
        }
        String json = new Gson().toJson(vlionAdRequest);
        y.a("====请求参数=====", json);
        return json;
    }
}
