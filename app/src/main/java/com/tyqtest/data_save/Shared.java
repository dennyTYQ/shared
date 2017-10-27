package com.tyqtest.data_save;

import android.app.Activity;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;

/**
 * Created by 谭雅清 on 2017/10/27.
 */

public class Shared extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shared);
        if(savedInstanceState ==null){
            SettingFragment  preferenceFragment = new SettingFragment();
            getFragmentManager().beginTransaction().add(android.R.id.content,preferenceFragment).commit();

        }
    }
    public static  class SettingFragment extends PreferenceFragment{
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.setting);
            final ListPreference listPreference = (ListPreference) findPreference("update_rate");
            listPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object o) {
                   listPreference.setSummary(o.toString()+"小时");
                    return true;
                }
            });
        }

    }
}
