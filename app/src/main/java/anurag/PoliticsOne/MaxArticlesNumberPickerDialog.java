package anurag.PoliticsOne;

/**
 * Created by root on 22/4/16.
 */
import android.content.Context;
import android.content.DialogInterface;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.NumberPicker;

public class MaxArticlesNumberPickerDialog extends NumberPickerDialogPreference {
    private NumberPicker dialogNumberPicker;
    public MaxArticlesNumberPickerDialog(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onBindDialogView (View view) {
        super.onBindDialogView(view);
        dialogNumberPicker = (NumberPicker) view.findViewById(R.id.dialogNumberPicker);
        dialogNumberPicker.setMinValue(getContext().getResources().getInteger(R.integer.max_article_number_minimum));
        dialogNumberPicker.setMaxValue(getContext().getResources().getInteger(R.integer.max_article_number_maximum));
        dialogNumberPicker.setValue(PreferenceManager.getDefaultSharedPreferences(getContext()).getInt(SettingsActivity.KEY_PREF_MAX_ARTICLE_NUMBER,
                getContext().getResources().getInteger(R.integer.max_article_number_default)));
    }

    @Override
    public void onClick (DialogInterface dialog, int which) {
        super.onClick(dialog, which);
        if (which == DialogInterface.BUTTON_POSITIVE) {
            PreferenceManager.getDefaultSharedPreferences(getContext()).edit().putInt(SettingsActivity.KEY_PREF_MAX_ARTICLE_NUMBER, dialogNumberPicker.getValue()).commit();
            setSummary(Integer.toString(dialogNumberPicker.getValue()));
        }
    }
}
