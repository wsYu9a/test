package com.czhj.sdk.common.models;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.os.Environment;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.models.AdSlot;
import com.czhj.sdk.common.models.App;
import com.czhj.sdk.common.models.Device;
import com.czhj.sdk.common.models.DeviceId;
import com.czhj.sdk.common.models.Geo;
import com.czhj.sdk.common.models.Network;
import com.czhj.sdk.common.models.Size;
import com.czhj.sdk.common.models.Version;
import com.czhj.sdk.common.models.WXProgramReq;
import com.czhj.sdk.common.mta.DeviceContext;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.utils.RomUtils;
import com.czhj.sdk.logger.SigmobLog;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class ModelBuilderCreator {
    public static AdSlot.Builder createAdSlot() {
        return new AdSlot.Builder();
    }

    public static App.Builder createApp() {
        Boolean bool;
        NetworkSecurityPolicy networkSecurityPolicy;
        boolean isCleartextTrafficPermitted;
        App.Builder builder = new App.Builder();
        try {
            if (ClientMetadata.getInstance().getAppPackageName() != null) {
                builder.app_package(ClientMetadata.getInstance().getAppPackageName());
            }
            builder.orientation(ClientMetadata.getInstance().getOrientationInt());
            String appName = ClientMetadata.getInstance().getAppName();
            if (!TextUtils.isEmpty(appName)) {
                builder.name(appName);
            }
            if (Build.VERSION.SDK_INT >= 23) {
                networkSecurityPolicy = NetworkSecurityPolicy.getInstance();
                isCleartextTrafficPermitted = networkSecurityPolicy.isCleartextTrafficPermitted();
                bool = Boolean.valueOf(isCleartextTrafficPermitted);
            } else {
                bool = Boolean.TRUE;
            }
            builder.support_http = bool;
            String appVersion = ClientMetadata.getInstance().getAppVersion();
            if (!TextUtils.isEmpty(appVersion)) {
                builder.app_version(createVersion(appVersion).build());
            }
            builder.idfv("android");
            builder.sdk_ext_cap.add(3);
            builder.install_time(Long.valueOf(ClientMetadata.getInstance().getInstallTime()));
        } catch (Throwable th2) {
            SigmobLog.e("App Builder failed", th2);
        }
        return builder;
    }

    public static Device.Builder createDevice() {
        return createDevice(null);
    }

    public static DeviceId.Builder createDeviceId() {
        return createDeviceId(null);
    }

    public static Geo.Builder createGeo() {
        return createGeo(null);
    }

    public static Network.Builder createNetwork() {
        return createNetwork(null);
    }

    private static Version.Builder createVersion(int i10, int i11, int i12) {
        Version.Builder builder = new Version.Builder();
        builder.major(Integer.valueOf(i10));
        builder.micro(Integer.valueOf(i11));
        builder.minor(Integer.valueOf(i12));
        return builder;
    }

    public static WXProgramReq.Builder createWXProgramReq() {
        WXProgramReq.Builder builder = new WXProgramReq.Builder();
        try {
            Method method = WXAPIFactory.class.getMethod("createWXAPI", Context.class, String.class);
            method.setAccessible(true);
            Object invoke = method.invoke(WXAPIFactory.class, ClientMetadata.getInstance().getContext(), "");
            Method method2 = invoke.getClass().getMethod("isWXAppInstalled", null);
            method2.setAccessible(true);
            Boolean bool = (Boolean) method2.invoke(invoke, null);
            bool.booleanValue();
            Method method3 = invoke.getClass().getMethod("getWXAppSupportAPI", null);
            method3.setAccessible(true);
            Integer num = (Integer) method3.invoke(invoke, null);
            num.intValue();
            Field declaredField = com.tencent.mm.opensdk.constants.Build.class.getDeclaredField("SDK_INT");
            declaredField.setAccessible(true);
            int intValue = ((Integer) declaredField.get(null)).intValue();
            builder.wx_installed(bool);
            builder.wx_api_ver(num);
            builder.opensdk_ver(String.valueOf(intValue));
        } catch (Throwable th2) {
            SigmobLog.e("createWXProgramReq failed" + th2.getMessage());
        }
        return builder;
    }

    public static Device.Builder createDevice(DeviceContext deviceContext) {
        Device.Builder builder = new Device.Builder();
        builder.device_type(Integer.valueOf(ClientMetadata.getInstance().isTablet() ? 5 : 4));
        builder.os_type(2);
        try {
            Size.Builder builder2 = new Size.Builder();
            builder2.height = Integer.valueOf(ClientMetadata.getInstance().getRealMetrics().heightPixels);
            builder2.width = Integer.valueOf(ClientMetadata.getInstance().getRealMetrics().widthPixels);
            builder.resolution(builder2.build());
            builder.battery_level(ClientMetadata.getInstance().getBatteryLevel());
            builder.battery_state(ClientMetadata.getInstance().getBatteryState());
            builder.battery_save_enabled(ClientMetadata.getInstance().getBatterySaveEnable());
            builder.dpi(Integer.valueOf(ClientMetadata.getInstance().getDensityDpi()));
            builder.os_version(createVersion(ClientMetadata.getDeviceOsVersion()).build());
            builder.vendor(ClientMetadata.getDeviceManufacturer());
            builder.is_root(Boolean.valueOf(ClientMetadata.isRoot()));
            Size.Builder width = new Size.Builder().height(ClientMetadata.getInstance().getDeviceScreenHeightDip()).width(ClientMetadata.getInstance().getDeviceScreenWidthDip());
            if (!TextUtils.isEmpty(ClientMetadata.getDeviceModel())) {
                builder.model(ClientMetadata.getDeviceModel());
            }
            builder.screen_size(width.build());
            builder.geo(createGeo(deviceContext).build());
            builder.disk_size(Long.valueOf(Environment.getDataDirectory().getTotalSpace()));
            String deviceName = ClientMetadata.getInstance().getDeviceName();
            if (!TextUtils.isEmpty(deviceName)) {
                builder.device_name(deviceName);
            }
            builder.start_timestamp(ClientMetadata.getBootSystemTime());
            builder.android_api_level(ClientMetadata.getDeviceOSLevel());
            builder.mem_size(ClientMetadata.getInstance().getSystemTotalMemorySize());
            builder.total_disk_size(Long.valueOf(Environment.getDataDirectory().getTotalSpace()));
            builder.free_disk_size(Long.valueOf(Environment.getDataDirectory().getFreeSpace()));
            String sDCardPath = ClientMetadata.getInstance().getSDCardPath();
            if (!TextUtils.isEmpty(sDCardPath)) {
                builder.sd_total_disk_size(Long.valueOf(new File(sDCardPath).getTotalSpace()));
                builder.sd_free_disk_size(Long.valueOf(new File(sDCardPath).getFreeSpace()));
            }
            String bootId = ClientMetadata.getInstance().getBootId();
            if (!TextUtils.isEmpty(bootId)) {
                builder.boot_mark(bootId);
            }
            String updateId = ClientMetadata.getInstance().getUpdateId();
            if (!TextUtils.isEmpty(updateId)) {
                builder.update_mark(updateId);
            }
            RomUtils.RomInfo romInfo = RomUtils.getRomInfo();
            if (romInfo != null) {
                builder.rom_name(romInfo.getName());
                Version.Builder createVersion = createVersion(romInfo.getVersion());
                createVersion.version_str(romInfo.getVersion());
                builder.rom_version(createVersion.build());
            }
        } catch (Throwable th2) {
            SigmobLog.e("Device Builder failed", th2);
        }
        return builder;
    }

    public static DeviceId.Builder createDeviceId(DeviceContext deviceContext) {
        DeviceId.Builder builder = new DeviceId.Builder();
        try {
            String androidId = deviceContext != null ? deviceContext.getAndroidId() : ClientMetadata.getInstance().getAndroidId();
            if (!TextUtils.isEmpty(androidId)) {
                builder.android_id(androidId);
            }
            String udid = ClientMetadata.getInstance().getUDID();
            if (!TextUtils.isEmpty(udid)) {
                builder.udid(udid);
            }
            String advertisingId = ClientMetadata.getInstance().getAdvertisingId();
            if (!TextUtils.isEmpty(advertisingId)) {
                builder.gaid(advertisingId);
            }
            ClientMetadata.getInstance();
            String uid = ClientMetadata.getUid();
            if (!TextUtils.isEmpty(uid)) {
                builder.uid(uid);
            }
            String imei = deviceContext != null ? deviceContext.getImei() : ClientMetadata.getInstance().getDeviceId();
            if (!TextUtils.isEmpty(imei)) {
                builder.imei(imei);
            }
            String deviceSerial = ClientMetadata.getInstance().getDeviceSerial();
            if (!TextUtils.isEmpty(deviceSerial)) {
                builder.android_uuid(deviceSerial);
            }
            String imsi = ClientMetadata.getInstance().getIMSI();
            if (!TextUtils.isEmpty(imsi)) {
                builder.imsi(imsi);
            }
            String imei1 = deviceContext != null ? deviceContext.getImei1() : ClientMetadata.getInstance().getDeviceId(0);
            if (!TextUtils.isEmpty(imei1)) {
                builder.imei1(imei1);
            }
            String imei2 = deviceContext != null ? deviceContext.getImei2() : ClientMetadata.getInstance().getDeviceId(1);
            if (!TextUtils.isEmpty(imei2)) {
                builder.imei2(imei2);
            }
            ClientMetadata.getInstance();
            String deviceBrand = ClientMetadata.getDeviceBrand();
            if (!TextUtils.isEmpty(deviceBrand)) {
                builder.brand(deviceBrand);
            }
            try {
                String oaid = deviceContext != null ? deviceContext.getOaid() : ClientMetadata.getInstance().getOAID();
                if (!TextUtils.isEmpty(oaid)) {
                    builder.oaid(oaid);
                }
            } catch (Throwable th2) {
                SigmobLog.e("getOAID " + th2.getMessage());
            }
            try {
                ClientMetadata.getInstance();
                String vaid = ClientMetadata.getVAID();
                if (!TextUtils.isEmpty(vaid)) {
                    builder.vaid(vaid);
                }
            } catch (Throwable th3) {
                SigmobLog.e("getVAID " + th3.getMessage());
            }
            if (deviceContext != null) {
                try {
                    builder.is_custom_imei(Boolean.valueOf(!deviceContext.isCustomPhoneState()));
                    builder.is_custom_oaid(Boolean.valueOf(deviceContext.isCustomOaId()));
                    builder.is_custom_android_id(Boolean.valueOf(!deviceContext.isCustomAndroidId()));
                } catch (Throwable th4) {
                    SigmobLog.e("getCustomController " + th4.getMessage());
                }
            }
        } catch (Throwable th5) {
            SigmobLog.e("DeviceId Builder failed", th5);
        }
        return builder;
    }

    public static Geo.Builder createGeo(DeviceContext deviceContext) {
        Geo.Builder builder = new Geo.Builder();
        try {
            builder.country(ClientMetadata.getInstance().getDeviceLocale().getCountry());
            builder.language(ClientMetadata.getInstance().getDeviceLocale().getLanguage().toUpperCase());
            Location location = deviceContext != null ? deviceContext.getLocation() : ClientMetadata.getInstance().getLocation();
            if (location != null) {
                builder.lat(Float.valueOf((float) location.getLatitude()));
                builder.lon(Float.valueOf((float) location.getLongitude()));
                builder.accuracy(location.hasAccuracy() ? Double.valueOf(location.getAccuracy()) : Double.valueOf(500.0d));
            }
            builder.timeZone(TimeZone.getDefault().getID());
            builder.secondsFromGMT(String.valueOf(TimeZone.getDefault().getRawOffset()));
        } catch (Throwable th2) {
            SigmobLog.e("Geo Builder failed", th2);
        }
        return builder;
    }

    public static Network.Builder createNetwork(DeviceContext deviceContext) {
        Network.Builder builder = new Network.Builder();
        try {
            builder.connection_type(Integer.valueOf(ClientMetadata.getInstance().getActiveNetworkType()));
            String networkOperatorForUrl = ClientMetadata.getInstance().getNetworkOperatorForUrl();
            if (!TextUtils.isEmpty(networkOperatorForUrl)) {
                builder.operator(networkOperatorForUrl);
            }
            String userAgent = Networking.getUserAgent();
            if (!TextUtils.isEmpty(userAgent)) {
                builder.ua(userAgent);
            }
            builder.connection_type(Integer.valueOf(ClientMetadata.getInstance().getActiveNetworkType()));
            ClientMetadata.getInstance();
            String macAddress = ClientMetadata.getMacAddress();
            if (!TextUtils.isEmpty(macAddress)) {
                builder.mac(macAddress);
            }
            String wifimac = ClientMetadata.getInstance().getWifimac();
            if (!TextUtils.isEmpty(wifimac)) {
                builder.wifi_mac(wifimac);
            }
            String wifiName = ClientMetadata.getInstance().getWifiName();
            if (!TextUtils.isEmpty(wifiName)) {
                builder.wifi_id(wifiName);
            }
            String carrierName = deviceContext != null ? deviceContext.getCarrierName() : ClientMetadata.getInstance().getNetworkOperatorName();
            if (!TextUtils.isEmpty(carrierName)) {
                builder.carrier_name(carrierName);
            }
        } catch (Throwable th2) {
            SigmobLog.e("Network Builder failed", th2);
        }
        return builder;
    }

    public static Version.Builder createVersion(String str) {
        int i10;
        int i11;
        String[] split;
        int i12 = 0;
        try {
            split = str.split("\\.");
        } catch (Throwable unused) {
        }
        if (split.length > 2) {
            int parseInt = Integer.parseInt(split[0]);
            i11 = Integer.parseInt(split[1]);
            i10 = Integer.parseInt(split[2]);
            i12 = parseInt;
        } else if (split.length > 1) {
            int parseInt2 = Integer.parseInt(split[0]);
            i11 = Integer.parseInt(split[1]);
            i12 = parseInt2;
            i10 = 0;
        } else {
            if (split.length > 0) {
                i12 = Integer.parseInt(split[0]);
            }
            i10 = 0;
            i11 = 0;
        }
        return createVersion(i12, i10, i11).version_str(str);
    }
}
