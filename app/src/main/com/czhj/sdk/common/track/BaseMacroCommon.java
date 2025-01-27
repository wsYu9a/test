package com.czhj.sdk.common.track;

import android.text.TextUtils;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.logger.SigmobLog;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class BaseMacroCommon implements Serializable {
    private static final long serialVersionUID = 1;
    private Map<String, String> mMacroMap = new HashMap();
    private Map<String, String> mServerMacroMap = new HashMap();

    /* renamed from: com.czhj.sdk.common.track.BaseMacroCommon$1 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$czhj$sdk$common$track$BaseMacroCommon$MacroCode;

        static {
            int[] iArr = new int[MacroCode.values().length];
            $SwitchMap$com$czhj$sdk$common$track$BaseMacroCommon$MacroCode = iArr;
            try {
                iArr[MacroCode._MC_.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$czhj$sdk$common$track$BaseMacroCommon$MacroCode[MacroCode._COUNTRY_.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$czhj$sdk$common$track$BaseMacroCommon$MacroCode[MacroCode._BUNDLEID_.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$czhj$sdk$common$track$BaseMacroCommon$MacroCode[MacroCode._LANGUAGE_.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$czhj$sdk$common$track$BaseMacroCommon$MacroCode[MacroCode._OSVERSION_.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$czhj$sdk$common$track$BaseMacroCommon$MacroCode[MacroCode._TIMESTAMP_.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$czhj$sdk$common$track$BaseMacroCommon$MacroCode[MacroCode._TIMEMILLIS_.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public enum MacroCode {
        _MC_,
        _COUNTRY_,
        _TIMESTAMP_,
        _OSVERSION_,
        _BUNDLEID_,
        _LANGUAGE_,
        _TIMEMILLIS_;

        public static String getMacroValue(String str) {
            try {
                switch (AnonymousClass1.$SwitchMap$com$czhj$sdk$common$track$BaseMacroCommon$MacroCode[valueOf(str).ordinal()]) {
                    case 1:
                        return ClientMetadata.getInstance().getNetworkOperatorForUrl();
                    case 2:
                        return ClientMetadata.getInstance().getDeviceLocale().getCountry();
                    case 3:
                        return ClientMetadata.getInstance().getAppPackageName();
                    case 4:
                        return ClientMetadata.getInstance().getDeviceLocale().getLanguage();
                    case 5:
                        return ClientMetadata.getDeviceOsVersion();
                    case 6:
                        return String.valueOf(System.currentTimeMillis() / 1000);
                    case 7:
                        return String.valueOf(System.currentTimeMillis());
                    default:
                        return "unFind";
                }
            } catch (Throwable unused) {
                return "unFind";
            }
        }
    }

    private String replaceMacroWithMap(String str, Map<String, String> map) {
        String str2 = this.mServerMacroMap.get(str);
        SigmobLog.d("macroProcess() called with:[" + str + "][" + str2 + "]");
        if (!TextUtils.isEmpty(str2) && !str2.equals("unFind")) {
            return str2;
        }
        String str3 = this.mMacroMap.get(str);
        SigmobLog.d("macroProcess() called with:[" + str + "][" + str3 + "]");
        if (!TextUtils.isEmpty(str3) && !str3.equals("unFind")) {
            return str3;
        }
        if (map == null) {
            return null;
        }
        String str4 = map.get(str);
        SigmobLog.d("macroProcess() called with:[" + str + "][" + str4 + "]");
        if (TextUtils.isEmpty(str4) || str4.equals("unFind")) {
            return null;
        }
        return str4;
    }

    public void addAllMarco(Map<String, String> map) {
        this.mMacroMap.putAll(map);
    }

    public void addMarcoKey(String str, String str2) {
        this.mMacroMap.put(str, str2);
    }

    public void clearMacro() {
        this.mMacroMap.clear();
    }

    public Map<String, String> getMacroMap() {
        return this.mMacroMap;
    }

    public String getMarcoKey(String str) {
        return this.mMacroMap.get(str);
    }

    public String macroProcess(String str) {
        return macroProcess(str, null);
    }

    public void removeMarcoKey(String str) {
        this.mMacroMap.remove(str);
    }

    public String replaceWithDefault(String str) {
        String macroValue = MacroCode.getMacroValue(str);
        SigmobLog.d("macroProcess() called with:[" + str + "][" + macroValue + "]");
        if (TextUtils.isEmpty(macroValue) || macroValue.equals("unFind")) {
            return null;
        }
        return macroValue;
    }

    public void setServerMacroMap(Map<String, String> map) {
        this.mServerMacroMap = map;
    }

    public String macroProcess(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Matcher matcher = Pattern.compile("_([A-Z,0-9])+_").matcher(str);
        try {
            SigmobLog.d("macroProcess() called with: origin url " + str);
            while (matcher.find()) {
                String group = matcher.group();
                String replaceMacroWithMap = replaceMacroWithMap(group, map);
                if (TextUtils.isEmpty(replaceMacroWithMap) || replaceMacroWithMap.equals("unFind")) {
                    replaceMacroWithMap = replaceWithDefault(group);
                    if (!TextUtils.isEmpty(replaceMacroWithMap) && !replaceMacroWithMap.equals("unFind")) {
                    }
                }
                str = str.replaceAll(group, replaceMacroWithMap);
            }
            SigmobLog.d("macroProcess() called with: final url " + str);
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
        }
        return str;
    }
}
