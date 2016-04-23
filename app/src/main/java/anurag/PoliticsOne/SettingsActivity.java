package anurag.PoliticsOne;

/**
 * Created by root on 22/4/16.
 */
import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;

public class SettingsActivity extends Activity {
    public static final String KEY_PREF_MAX_ARTICLE_NUMBER = "anurag.PoliticsOne.keyprefmaxarticlenumber";
    public static final String KEY_PREF_ARTICLE_AGE_LIMIT = "anurag.PoliticsOne.keyprefarticleagelimit";
    public static final String KEY_PREF_SYNC_TIMEOUT = "anurag.PoliticsOne.synctimeout";
    public static final String KEY_PREF_MAX_DATABASE_SIZE = "anurag.PoliticsOne.maxdatabasesize";
    public static final String KEY_PREF_AUTOSYNC_INTERVAL = "anurag.PoliticsOne.autosyncinterval";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BrightnessControl.toggleBrightness(getApplicationContext(), this);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragment()).commit();

        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME
                    | ActionBar.DISPLAY_USE_LOGO
                    | ActionBar.DISPLAY_SHOW_TITLE
                    | ActionBar.DISPLAY_HOME_AS_UP);
        }
        Utils.setActivityTitle(this, getResources().getString(R.string.settingsTitle));
    }

}