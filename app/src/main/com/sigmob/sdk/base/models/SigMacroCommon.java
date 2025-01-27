package com.sigmob.sdk.base.models;

import android.text.TextUtils;
import android.view.MotionEvent;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.track.BaseMacroCommon;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.TouchLocation;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.a;

/* loaded from: classes4.dex */
public class SigMacroCommon extends BaseMacroCommon {
    public static final String _ADSCENEID_ = "_ADSCENEID_";
    public static final String _ADSCENE_ = "_ADSCENE_";
    public static final String _BEGINTIME_ = "_BEGINTIME_";
    public static final String _BEHAVIOR_ = "_BEHAVIOR_";
    public static final String _CLICKAREA_ = "_CLICKAREA_";
    public static final String _CLICKID_ = "_CLICKID_";
    public static final String _CLICKSCENE_ = "_CLICKSCENE_";
    public static final String _COMPLETED_ = "_COMPLETED_";
    public static final String _CURRENCY_ = "_CURRENCY_";
    public static final String _DOWNX_ = "_DOWNX_";
    public static final String _DOWNY_ = "_DOWNY_";
    public static final String _ENDTIME_ = "_ENDTIME_";
    public static final String _FINALCLICK_ = "_FINALCLICK_";
    public static final String _HEIGHT_ = "_HEIGHT_";
    public static final String _HIGHESTLOSSPRICE_ = "_HIGHESTLOSSPRICE_";
    public static final String _IS_TRUNCATION_ = "_ISTRUNCATION_";
    public static final String _PLAYFIRSTFRAME_ = "_PLAYFIRSTFRAME_";
    public static final String _PLAYLASTFRAME_ = "_PLAYLASTFRAME_";
    public static final String _PROGRESS_ = "_PROGRESS_";
    public static final String _PUBLISHERPRICE_ = "_PUBLISHERPRICE_";
    public static final String _SCENE_ = "_SCENE_";
    public static final String _SETCLOSETIME_ = "_SETCLOSETIME_";
    public static final String _SHOWSKIPTIME_ = "_SHOWSKIPTIME_";
    public static final String _SLOTHEIGHT_ = "_SLOTHEIGHT_";
    public static final String _SLOTWIDTH_ = "_SLOTWIDTH_";
    public static final String _STATUS_ = "_STATUS_";
    public static final String _TEMPLATE_ = "_TEMPLATE_";
    public static final String _TYPE_ = "_TYPE_";
    public static final String _UPX_ = "_UPX_";
    public static final String _UPY_ = "_UPY_";
    public static final String _VIDEOTIME_ = "_VIDEOTIME_";
    public static final String _VMD5_ = "_VMD5_";
    public static final String _VURL_ = "_VURL_";
    public static final String _WIDTH_ = "_WIDTH_";
    private static final long serialVersionUID = 1;

    private static String getMacroValue(String str) {
        char c10;
        try {
            switch (str.hashCode()) {
                case -1590308376:
                    if (str.equals(_BEGINTIME_)) {
                        c10 = 4;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -1494891674:
                    if (str.equals(_TYPE_)) {
                        c10 = 0;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -662306149:
                    if (str.equals(_SLOTHEIGHT_)) {
                        c10 = 7;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -415971623:
                    if (str.equals(_HEIGHT_)) {
                        c10 = '\b';
                        break;
                    }
                    c10 = 65535;
                    break;
                case 853731986:
                    if (str.equals(_SCENE_)) {
                        c10 = 1;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 891331278:
                    if (str.equals(_BEHAVIOR_)) {
                        c10 = 3;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 973765784:
                    if (str.equals(_WIDTH_)) {
                        c10 = 6;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 1179083118:
                    if (str.equals(_STATUS_)) {
                        c10 = 2;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 2074198166:
                    if (str.equals(_SLOTWIDTH_)) {
                        c10 = 5;
                        break;
                    }
                    c10 = 65535;
                    break;
                default:
                    c10 = 65535;
                    break;
            }
            switch (c10) {
                case 0:
                    return "1";
                case 1:
                case 2:
                    return "0";
                case 3:
                    return "2";
                case 4:
                    return "0";
                case 5:
                case 6:
                    return String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealWidthDip());
                case 7:
                case '\b':
                    return String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealHeightDip());
                default:
                    return "unFind";
            }
        } catch (Throwable unused) {
            return "unFind";
        }
    }

    public String getCoordinate() {
        return String.format("%s,%s,%s,%s", getMarcoKey(_DOWNX_), getMarcoKey(_DOWNY_), getMarcoKey(_UPX_), getMarcoKey(_UPY_));
    }

    @Override // com.czhj.sdk.common.track.BaseMacroCommon
    public String replaceWithDefault(String str) {
        String replaceWithDefault = super.replaceWithDefault(str);
        SigmobLog.d("macroProcess() called with:[" + str + "][" + replaceWithDefault + "]");
        if (!TextUtils.isEmpty(replaceWithDefault) && !replaceWithDefault.equals("unFind")) {
            return replaceWithDefault;
        }
        try {
            String macroValue = getMacroValue(str);
            SigmobLog.d("macroProcess() called with: [" + str + "][" + macroValue + "]");
            if (TextUtils.isEmpty(macroValue)) {
                return null;
            }
            if (macroValue.equals("unFind")) {
                return null;
            }
            return macroValue;
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
            return null;
        }
    }

    public void updateClickMarco(MotionEvent motionEvent, MotionEvent motionEvent2, boolean z10) {
        float y10;
        if (motionEvent == null) {
            motionEvent = motionEvent2;
        }
        if (z10) {
            addMarcoKey(_DOWNX_, String.valueOf(Dips.pixelsToIntDips(motionEvent.getRawX(), a.d())));
            addMarcoKey(_DOWNY_, String.valueOf(Dips.pixelsToIntDips(motionEvent.getRawY(), a.d())));
            addMarcoKey(_UPX_, String.valueOf(Dips.pixelsToIntDips(motionEvent2.getRawX(), a.d())));
            y10 = motionEvent2.getRawY();
        } else {
            addMarcoKey(_DOWNX_, String.valueOf(Dips.pixelsToIntDips(motionEvent.getX(), a.d())));
            addMarcoKey(_DOWNY_, String.valueOf(Dips.pixelsToIntDips(motionEvent.getY(), a.d())));
            addMarcoKey(_UPX_, String.valueOf(Dips.pixelsToIntDips(motionEvent2.getX(), a.d())));
            y10 = motionEvent2.getY();
        }
        addMarcoKey(_UPY_, String.valueOf(Dips.pixelsToIntDips(y10, a.d())));
    }

    public static String getCoordinate(MotionEvent motionEvent, MotionEvent motionEvent2, boolean z10) {
        return z10 ? String.format("%d,%d,%d,%d", Integer.valueOf(Dips.pixelsToIntDips(motionEvent.getRawX(), a.d())), Integer.valueOf(Dips.pixelsToIntDips(motionEvent.getRawY(), a.d())), Integer.valueOf(Dips.pixelsToIntDips(motionEvent2.getRawX(), a.d())), Integer.valueOf(Dips.pixelsToIntDips(motionEvent2.getRawX(), a.d()))) : String.format("%d,%d,%d,%d", Integer.valueOf(Dips.pixelsToIntDips(motionEvent.getX(), a.d())), Integer.valueOf(Dips.pixelsToIntDips(motionEvent.getY(), a.d())), Integer.valueOf(Dips.pixelsToIntDips(motionEvent2.getX(), a.d())), Integer.valueOf(Dips.pixelsToIntDips(motionEvent2.getY(), a.d())));
    }

    public void updateClickMarco(TouchLocation touchLocation, TouchLocation touchLocation2) {
        if (touchLocation == null && touchLocation2 == null) {
            return;
        }
        if (touchLocation2 == null) {
            touchLocation2 = touchLocation;
        } else if (touchLocation == null) {
            touchLocation = touchLocation2;
        } else {
            touchLocation2 = touchLocation;
            touchLocation = touchLocation2;
        }
        addMarcoKey(_DOWNX_, String.valueOf(Dips.pixelsToIntDips(touchLocation2.getX(), a.d())));
        addMarcoKey(_DOWNY_, String.valueOf(Dips.pixelsToIntDips(touchLocation2.getY(), a.d())));
        addMarcoKey(_UPX_, String.valueOf(Dips.pixelsToIntDips(touchLocation.getX(), a.d())));
        addMarcoKey(_UPY_, String.valueOf(Dips.pixelsToIntDips(touchLocation.getY(), a.d())));
    }

    public void updateClickMarco(String str, String str2, String str3, String str4) {
        addMarcoKey(_DOWNX_, str);
        addMarcoKey(_DOWNY_, str2);
        addMarcoKey(_UPX_, str3);
        addMarcoKey(_UPY_, str4);
    }
}
