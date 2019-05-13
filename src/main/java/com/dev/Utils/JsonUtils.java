package com.dev.Utils;

import com.dev.Objects.Entities.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.dev.Utils.Definitions.*;

/**
 * Created by Sigal on 9/9/2017.
 */
public class JsonUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtils.class);



    public static JSONArray translationsToJson () {
        JSONArray array = new JSONArray();
        for (TranslationObject translationObject : Utils.translations.values()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put(PARAM_OID, translationObject.getOid());
            jsonObject.put(PARAM_KEY, translationObject.getTranslationKey());
            jsonObject.put(PARAM_VALUE, translationObject.getTranslationValue());
            jsonObject.put(PARAM_ENGLISH, translationObject.getEn());
            array.put(jsonObject);
        }
        return array;
    }


}
