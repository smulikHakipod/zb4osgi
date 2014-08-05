/*
   Copyright 2008-2014 CNR-ISTI, http://isti.cnr.it
   Institute of Information Science and Technologies
   of the Italian National Research Council


   See the NOTICE file distributed with this work for additional
   information regarding copyright ownership

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package it.cnr.isti.osgi.util;

import org.osgi.framework.BundleContext;

/**
 *
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate: 2014-05-13 15:58:12
 *          +0200 (Tue, 13 May 2014) $)
 *
 */
public class OSGiProperties {

    private final BundleContext bundle;

    /**
     *
     * <b>NOTE</b>: The match making between property value and enum is performed in case insesitive way
     *
     * @param bundle
     *            {@link BundleContext} to use
     * @param property
     *            the property to look for in the {@link BundleContext}
     * @param defaultValue
     *            the defaultValue when property is missing or cannot be parsed
     * @return The enum representation of the property from the bundle context,
     *         if it is not set or cannot be parsed it return the defaultValue
     *         specified
     * @since 0.6.0
     */
    @SuppressWarnings("unchecked")
    public static final <T extends Enum<T>> T getEnum(BundleContext bundle,
            String property, T defaultValue) {
        String value = bundle == null ? null : bundle.getProperty(property);
        if (value == null) {
            return defaultValue;
        }

        Enum<?>[] values = defaultValue.getClass().getEnumConstants();
        for (int i = 0; i < values.length; i++) {
            if ( value.equalsIgnoreCase(values[i].name()) ) {
                return ((T) values[i]);
            }
        }
        return defaultValue;
    }

    /**
     *
     * @param bundle
     *            {@link BundleContext} to use
     * @param property
     *            the property to look for in the {@link BundleContext}
     * @param defaultValue
     *            the defaultValue when property is missing
     * @return The string representation of the property from the bundle
     *         context, if it is not set it return the defaultValue specified
     */
    public static final String getString(BundleContext bundle, String property,
            String defaultValue) {
        String value = bundle == null ? null : bundle.getProperty(property);
        return value == null ? defaultValue : value;
    }

    /**
     *
     * @param bundle
     *            {@link BundleContext} to use
     * @param property
     *            the property to look for in the {@link BundleContext}
     * @param defaultValue
     *            the defaultValue when property is missing or cannot be parsed
     * @return The boolean representation of the property from the bundle
     *         context, if it is not set or cannot be parsed it return the
     *         defaultValue specified
     */
    public static final boolean getBoolean(BundleContext bundle,
            String property, boolean defaultValue) {
        String value = bundle == null ? null : bundle.getProperty(property);
        if (value == null) {
            return defaultValue;
        }
        value = value.toLowerCase();
        if (value.equals("true")) {
            return true;
        } else if (value.equals("on")) {
            return true;
        } else if (value.equals("yes")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @param bundle
     *            {@link BundleContext} to use
     * @param property
     *            the property to look for in the {@link BundleContext}
     * @param defaultValue
     *            the defaultValue when property is missing or cannot be parsed
     * @return The int representation of the property from the bundle context,
     *         if it is not set or cannot be parsed it return the defaultValue
     *         specified
     */
    public static final int getInt(BundleContext bundle, String property,
            int defaultValue) {
        String value = bundle == null ? null : bundle.getProperty(property);
        try {
            return value == null ? defaultValue : Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            return defaultValue;
        }
    }

    /**
     *
     * @param bundle
     *            {@link BundleContext} to use
     * @param property
     *            the property to look for in the {@link BundleContext}
     * @param defaultValue
     *            the defaultValue when property is missing or cannot be parsed
     * @return The double representation of the property from the bundle
     *         context, if it is not set or cannot be parsed it return the
     *         defaultValue specified
     */

    public static final double getDouble(BundleContext bundle, String property,
            double defaultValue) {
        String value = bundle == null ? null : bundle.getProperty(property);
        try {
            return value == null ? defaultValue : Double.parseDouble(value);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            return defaultValue;
        }
    }

    /**
     *
     * @param bundle
     *            {@link BundleContext} to use
     * @param property
     *            the property to look for in the {@link BundleContext}
     * @param defaultValue
     *            the defaultValue when property is missing or cannot be parsed
     * @return The long representation of the property from the bundle context,
     *         if it is not set or cannot be parsed it return the defaultValue
     *         specified
     */
    public static final long getLong(BundleContext bundle, String property,
            int defaultValue) {
        String value = bundle == null ? null : bundle.getProperty(property);
        try {
            return value == null ? defaultValue : Long.parseLong(value);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            return defaultValue;
        }
    }

    public OSGiProperties(BundleContext bundleContext) {
        bundle = bundleContext;
    }

    public String getString(String property) {
        return bundle == null ? null : bundle.getProperty(property);
    }

    public String getString(String property, String defaultValue) {
        return getString(bundle, property, defaultValue);
    }

    public int getInt(String property) {
        String value = bundle == null ? null : bundle.getProperty(property);
        return Integer.parseInt(value);
    }

    public int getInt(String property, int defaultValue) {
        return getInt(bundle, property, defaultValue);
    }

    public boolean getBoolean(String property) {
        String value = bundle == null ? null : bundle.getProperty(property);
        if (value == null) {
            throw new NullPointerException("Property " + property
                    + " doesn't exist");
        } else if (value.equalsIgnoreCase("true")) {
            return true;
        } else if (value.equalsIgnoreCase("on")) {
            return true;
        } else if (value.equalsIgnoreCase("yes")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean getBoolean(String property, boolean defaultValue) {
        return getBoolean(bundle, property, defaultValue);
    }

    public long getLong(String property) {
        String value = bundle == null ? null : bundle.getProperty(property);
        return Long.parseLong(value);
    }

    public long getLong(String property, int defaultValue) {
        return getLong(bundle, property, defaultValue);
    }
}
