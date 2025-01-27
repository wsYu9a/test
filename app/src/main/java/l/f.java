package l;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* loaded from: classes.dex */
public final /* synthetic */ class f {
    static {
        String str = TypedValues.PositionType.NAME;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int a(String str) {
        char c10;
        str.hashCode();
        switch (str.hashCode()) {
            case -1812823328:
                if (str.equals("transitionEasing")) {
                    c10 = 0;
                    break;
                }
                c10 = 65535;
                break;
            case -1127236479:
                if (str.equals("percentWidth")) {
                    c10 = 1;
                    break;
                }
                c10 = 65535;
                break;
            case -1017587252:
                if (str.equals("percentHeight")) {
                    c10 = 2;
                    break;
                }
                c10 = 65535;
                break;
            case -827014263:
                if (str.equals("drawPath")) {
                    c10 = 3;
                    break;
                }
                c10 = 65535;
                break;
            case -200259324:
                if (str.equals("sizePercent")) {
                    c10 = 4;
                    break;
                }
                c10 = 65535;
                break;
            case 428090547:
                if (str.equals("percentX")) {
                    c10 = 5;
                    break;
                }
                c10 = 65535;
                break;
            case 428090548:
                if (str.equals("percentY")) {
                    c10 = 6;
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
                return TypedValues.PositionType.TYPE_TRANSITION_EASING;
            case 1:
                return TypedValues.PositionType.TYPE_PERCENT_WIDTH;
            case 2:
                return 504;
            case 3:
                return TypedValues.PositionType.TYPE_DRAWPATH;
            case 4:
                return TypedValues.PositionType.TYPE_SIZE_PERCENT;
            case 5:
                return TypedValues.PositionType.TYPE_PERCENT_X;
            case 6:
                return TypedValues.PositionType.TYPE_PERCENT_Y;
            default:
                return -1;
        }
    }

    public static int b(int i10) {
        if (i10 == 100) {
            return 2;
        }
        if (i10 == 101) {
            return 8;
        }
        switch (i10) {
            case TypedValues.PositionType.TYPE_TRANSITION_EASING /* 501 */:
            case TypedValues.PositionType.TYPE_DRAWPATH /* 502 */:
                return 8;
            case TypedValues.PositionType.TYPE_PERCENT_WIDTH /* 503 */:
            case 504:
            case TypedValues.PositionType.TYPE_SIZE_PERCENT /* 505 */:
            case TypedValues.PositionType.TYPE_PERCENT_X /* 506 */:
            case TypedValues.PositionType.TYPE_PERCENT_Y /* 507 */:
                return 4;
            case TypedValues.PositionType.TYPE_CURVE_FIT /* 508 */:
                return 2;
            default:
                return -1;
        }
    }
}
