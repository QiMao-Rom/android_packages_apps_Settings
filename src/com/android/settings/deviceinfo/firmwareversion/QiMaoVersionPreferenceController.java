/*
 * Copyright (C) 2022 Project-QiMao
 *
 * PDX-License-Identifier: Apache-2.0
 *
 */

package com.android.settings.deviceinfo.firmwareversion;

import android.content.Context;
import android.os.SystemProperties;

import com.android.settings.R;
import com.android.settings.core.BasePreferenceController;

public class QiMaoVersionPreferenceController extends BasePreferenceController {

    private static final String TAG = "QiMaoVersionPreferenceController";

    private static final String KEY_QIMAO_BRANCH_PROP = "ro.qimao.branch";

    private static final String KEY_QIMAO_BUILD_TYPE_PROP = "ro.qimao.build.type";

    public QiMaoVersionPreferenceController(Context context, String key) {
        super(context, key);
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }

    @Override
    public CharSequence getSummary() {
        String version = SystemProperties.get(KEY_QIMAO_BRANCH_PROP, mContext.getString(R.string.unknown)).toUpperCase() + " | " + SystemProperties.get(KEY_QIMAO_BUILD_TYPE_PROP, mContext.getString(R.string.unknown)).toUpperCase();
        return version;
    }
}
