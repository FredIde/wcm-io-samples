/*
 * #%L
 * wcm.io
 * %%
 * Copyright (C) 2014 wcm.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package io.wcm.samples.app.config.impl;

import java.util.regex.Pattern;

import org.apache.sling.api.resource.Resource;
import org.osgi.service.component.annotations.Component;

import io.wcm.config.spi.ApplicationProvider;

/**
 * Application provider
 */
@Component(immediate = true, service = ApplicationProvider.class)
public class ApplicationProviderImpl implements ApplicationProvider {

  /**
   * Application Id
   */
  public static final String APPLICATION_ID = "/apps/wcm-io-samples/sample-app";

  /**
   * Application label
   */
  public static final String APPLICATION_LABEL = "wcm.io Sample Website";

  private static final Pattern PATH_PATTERN = Pattern.compile("^/content/(dam/)?wcm-io-samples(/.*)?$");

  @Override
  public String getApplicationId() {
    return APPLICATION_ID;
  }

  @Override
  public String getLabel() {
    return APPLICATION_LABEL;
  }

  @Override
  public boolean matches(Resource resource) {
    return PATH_PATTERN.matcher(resource.getPath()).matches();
  }

}
