package com.ecsolutions.util;

/**
 * Created by Administrator on 2017/3/27.
 */
public class SqlProviderUtil {
    public static String getArray(String[] branch) {
        String ret = "";
        for (int i = 0; i < branch.length; i++) {
            if (i > 0) ret += ",";
            ret += "'";
            ret += branch[i];
            ret += "'";
        }
        return ret;
    }
}
