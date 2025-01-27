package l;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* loaded from: classes.dex */
public final /* synthetic */ class e {
    static {
        String str = TypedValues.MotionType.NAME;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int a(String str) {
        char c10;
        str.hashCode();
        switch (str.hashCode()) {
            case -2033446275:
                if (str.equals(TypedValues.MotionType.S_ANIMATE_CIRCLEANGLE_TO)) {
                    c10 = 0;
                    break;
                }
                c10 = 65535;
                break;
            case -1532277420:
                if (str.equals(TypedValues.MotionType.S_QUANTIZE_MOTION_PHASE)) {
                    c10 = 1;
                    break;
                }
                c10 = 65535;
                break;
            case -1529145600:
                if (str.equals(TypedValues.MotionType.S_QUANTIZE_MOTIONSTEPS)) {
                    c10 = 2;
                    break;
                }
                c10 = 65535;
                break;
            case -1498310144:
                if (str.equals(TypedValues.MotionType.S_PATH_ROTATE)) {
                    c10 = 3;
                    break;
                }
                c10 = 65535;
                break;
            case -1030753096:
                if (str.equals(TypedValues.MotionType.S_QUANTIZE_INTERPOLATOR)) {
                    c10 = 4;
                    break;
                }
                c10 = 65535;
                break;
            case -762370135:
                if (str.equals(TypedValues.MotionType.S_DRAW_PATH)) {
                    c10 = 5;
                    break;
                }
                c10 = 65535;
                break;
            case -232872051:
                if (str.equals(TypedValues.MotionType.S_STAGGER)) {
                    c10 = 6;
                    break;
                }
                c10 = 65535;
                break;
            case 1138491429:
                if (str.equals(TypedValues.MotionType.S_POLAR_RELATIVETO)) {
                    c10 = 7;
                    break;
                }
                c10 = 65535;
                break;
            case 1539234834:
                if (str.equals(TypedValues.MotionType.S_QUANTIZE_INTERPOLATOR_TYPE)) {
                    c10 = '\b';
                    break;
                }
                c10 = 65535;
                break;
            case 1583722451:
                if (str.equals(TypedValues.MotionType.S_QUANTIZE_INTERPOLATOR_ID)) {
                    c10 = '\t';
                    break;
                }
                c10 = 65535;
                break;
            case 1639368448:
                if (str.equals(TypedValues.MotionType.S_EASING)) {
                    c10 = '\n';
                    break;
                }
                c10 = 65535;
                break;
            case 1900899336:
                if (str.equals(TypedValues.MotionType.S_ANIMATE_RELATIVE_TO)) {
                    c10 = 11;
                    break;
                }
                c10 = 65535;
                break;
            case 2109694967:
                if (str.equals(TypedValues.MotionType.S_PATHMOTION_ARC)) {
                    c10 = '\f';
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
                return TypedValues.MotionType.TYPE_ANIMATE_CIRCLEANGLE_TO;
            case 1:
                return TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE;
            case 2:
                return TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS;
            case 3:
                return 601;
            case 4:
                return TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR;
            case 5:
                return TypedValues.MotionType.TYPE_DRAW_PATH;
            case 6:
                return 600;
            case 7:
                return TypedValues.MotionType.TYPE_POLAR_RELATIVETO;
            case '\b':
                return TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_TYPE;
            case '\t':
                return TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_ID;
            case '\n':
                return TypedValues.MotionType.TYPE_EASING;
            case 11:
                return TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO;
            case '\f':
                return TypedValues.MotionType.TYPE_PATHMOTION_ARC;
            default:
                return -1;
        }
    }
}
