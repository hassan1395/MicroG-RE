package org.microg.tools.selfcheck;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;

import java.util.Locale;

public class OemUtils {
    private static final String[] KNOWN_RESTRICTED_MANUFACTURERS = {
            "huawei", "xiaomi", "oneplus", "samsung", "meizu", "asus", "wiko",
            "lenovo", "oppo", "vivo", "realme", "motorola", "blackview", "tecno",
            "sony", "unihertz"
    };

    public static String getDkmaSlug() {
        String manufacturer = Build.MANUFACTURER.toLowerCase(Locale.ROOT);

        for (String brand : KNOWN_RESTRICTED_MANUFACTURERS) {
            if (manufacturer.contains(brand)) {
                return brand;
            }
        }

        return ""; // Oem not listed, hide dontkillmyapp option
    }

    public static Intent getDkmaIntent(String slug) {
        String url = "https://dontkillmyapp.com/" + slug;
        return new Intent(Intent.ACTION_VIEW, Uri.parse(url));
    }
}