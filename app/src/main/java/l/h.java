package l;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* loaded from: classes.dex */
public final /* synthetic */ class h {
    static {
        String str = TypedValues.TriggerType.NAME;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int a(String str) {
        char c10;
        str.hashCode();
        switch (str.hashCode()) {
            case -1594793529:
                if (str.equals("positiveCross")) {
                    c10 = 0;
                    break;
                }
                c10 = 65535;
                break;
            case -966421266:
                if (str.equals("viewTransitionOnPositiveCross")) {
                    c10 = 1;
                    break;
                }
                c10 = 65535;
                break;
            case -786670827:
                if (str.equals("triggerCollisionId")) {
                    c10 = 2;
                    break;
                }
                c10 = 65535;
                break;
            case -648752941:
                if (str.equals("triggerID")) {
                    c10 = 3;
                    break;
                }
                c10 = 65535;
                break;
            case -638126837:
                if (str.equals("negativeCross")) {
                    c10 = 4;
                    break;
                }
                c10 = 65535;
                break;
            case -76025313:
                if (str.equals("triggerCollisionView")) {
                    c10 = 5;
                    break;
                }
                c10 = 65535;
                break;
            case -9754574:
                if (str.equals("viewTransitionOnNegativeCross")) {
                    c10 = 6;
                    break;
                }
                c10 = 65535;
                break;
            case 64397344:
                if (str.equals("CROSS")) {
                    c10 = 7;
                    break;
                }
                c10 = 65535;
                break;
            case 364489912:
                if (str.equals("triggerSlack")) {
                    c10 = '\b';
                    break;
                }
                c10 = 65535;
                break;
            case 1301930599:
                if (str.equals("viewTransitionOnCross")) {
                    c10 = '\t';
                    break;
                }
                c10 = 65535;
                break;
            case 1401391082:
                if (str.equals("postLayout")) {
                    c10 = '\n';
                    break;
                }
                c10 = 65535;
                break;
            case 1535404999:
                if (str.equals("triggerReceiver")) {
                    c10 = 11;
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
                return 309;
            case 1:
                return 302;
            case 2:
                return 307;
            case 3:
                return 308;
            case 4:
                return 310;
            case 5:
                return 306;
            case 6:
                return 303;
            case 7:
                return 312;
            case '\b':
                return 305;
            case '\t':
                return 301;
            case '\n':
                return 304;
            case 11:
                return 311;
            default:
                return -1;
        }
    }
}
