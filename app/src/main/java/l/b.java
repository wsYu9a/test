package l;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* loaded from: classes.dex */
public final /* synthetic */ class b {
    static {
        String str = TypedValues.Custom.NAME;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int a(String str) {
        char c10;
        str.hashCode();
        switch (str.hashCode()) {
            case -1095013018:
                if (str.equals(TypedValues.Custom.S_DIMENSION)) {
                    c10 = 0;
                    break;
                }
                c10 = 65535;
                break;
            case -891985903:
                if (str.equals(TypedValues.Custom.S_STRING)) {
                    c10 = 1;
                    break;
                }
                c10 = 65535;
                break;
            case -710953590:
                if (str.equals(TypedValues.Custom.S_REFERENCE)) {
                    c10 = 2;
                    break;
                }
                c10 = 65535;
                break;
            case 64711720:
                if (str.equals(TypedValues.Custom.S_BOOLEAN)) {
                    c10 = 3;
                    break;
                }
                c10 = 65535;
                break;
            case 94842723:
                if (str.equals("color")) {
                    c10 = 4;
                    break;
                }
                c10 = 65535;
                break;
            case 97526364:
                if (str.equals(TypedValues.Custom.S_FLOAT)) {
                    c10 = 5;
                    break;
                }
                c10 = 65535;
                break;
            case 1958052158:
                if (str.equals(TypedValues.Custom.S_INT)) {
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
                return TypedValues.Custom.TYPE_DIMENSION;
            case 1:
                return TypedValues.Custom.TYPE_STRING;
            case 2:
                return TypedValues.Custom.TYPE_REFERENCE;
            case 3:
                return TypedValues.Custom.TYPE_BOOLEAN;
            case 4:
                return 902;
            case 5:
                return 901;
            case 6:
                return 900;
            default:
                return -1;
        }
    }
}
