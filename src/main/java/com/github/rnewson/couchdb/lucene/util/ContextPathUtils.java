package com.github.rnewson.couchdb.lucene.util;

import org.apache.commons.configuration.ConfigurationException;

import com.github.rnewson.couchdb.lucene.Config;

public class ContextPathUtils {
    private static Config config;
    static {
        try {
            config = new Config();
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }
    public static String getContextPath(String path) {
        String newPath = path;
        String contextName = getContextName();
        if(newPath.contains(contextName)) {
            newPath = path.replace(contextName, "");
        }
        return newPath;
    }
    private static String getContextName() {
        return  "/"+config.getConfiguration().getString("lucene.contextname", "couchdb-lucene");
    }
}
