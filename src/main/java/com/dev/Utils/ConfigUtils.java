package com.dev.Utils;

import com.dev.Enums.ConfigEnum;
import com.dev.Objects.Entities.ConfigObject;
import com.dev.Services.GeneralManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static com.dev.Utils.Utils.hasText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class ConfigUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigUtils.class);

    @Autowired
    private GeneralManager generalManager;

    private static List<ConfigObject> config = new ArrayList<>();

    @PostConstruct
    private void initialize() {
        config = generalManager.getList(ConfigObject.class);
        LOGGER.info("Config is initialized with properties size {}", config.size());
    }

    public static List<ConfigObject> getConfig() {
        return config;
    }

    @SuppressWarnings("unchecked")
    public static  <T> T getConfig(ConfigEnum configEnum, T def) {
        return getConfig(configEnum.toString(), def);
    }

    public static  <T> T getConfig(String key, T def) {
        String value = String.valueOf(def);
        for (ConfigObject con : config) {
            if (con.getConfigKey().equals(key)) {
                String configValue = con.getConfigValue();
                if (hasText(configValue)) {
                    value = configValue;
                }
            }
        }
        T genericValue = (T) value;
        if (def instanceof Integer) {
            genericValue = (T)Integer.valueOf(value);
        } else if (def instanceof Boolean) {
            genericValue = (T)Boolean.valueOf(value);
        } else if (def instanceof Double) {
            genericValue = (T)Double.valueOf(value);
        }
        return genericValue;
    }

    public static ConfigObject getConfigByKey(String key) {
        ConfigObject configSelected = null;
        for (ConfigObject con : config) {
            if (con.getConfigKey().equals(key)) {
                String configValue = con.getConfigValue();
                if (hasText(configValue)) {
                    configSelected = con;
                    break;
                }
            }
        }
        return configSelected;
    }


}
