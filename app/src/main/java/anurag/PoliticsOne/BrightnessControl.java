package anurag.PoliticsOne;

/**
 * Created by root on 22/4/16.
 */

import android.app.Activity;
import android.content.Context;
import android.preference.PreferenceManager;
import android.view.WindowManager;

public class BrightnessControl {
    public static final String LIGHTS_OFF_MODE = "anurag.PoliticsOne.lightsoffmode";
    public static void toggleBrightness(Context context, Activity activity) {
        if (PreferenceManager.getDefaultSharedPreferences(context).getBoolean(LIGHTS_OFF_MODE, false)) {
            WindowManager.LayoutParams layout = activity.getWindow().getAttributes();
            layout.screenBrightness = 0.01f;
            activity.getWindow().setAttributes(layout);
        }
        else {
            WindowManager.LayoutParams layout = activity.getWindow().getAttributes();
            layout.screenBrightness = -1f;
            activity.getWindow().setAttributes(layout);
        }
    }
}
