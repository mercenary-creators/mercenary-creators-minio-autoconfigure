/*
 * Copyright (c) 2018, Mercenary Creators Company. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package co.mercenary.creators.minio.autoconfigire;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@ConfigurationProperties(prefix = "mercenary.minio")
public class MinioConfigurationProperties
{
    @NonNull
    private String m_server_url;

    @Nullable
    private String m_access_key;

    @Nullable
    private String m_secret_key;

    @Nullable
    private String m_use_region;

    public void setServerUrl(@NonNull final String server)
    {
        m_server_url = server;
    }

    @NonNull
    public String getServerUrl()
    {
        return m_server_url;
    }

    public void setAccessKey(@Nullable final String access)
    {
        m_access_key = access;
    }

    @Nullable
    public String getAccessKey()
    {
        return m_access_key;
    }

    public void setSecretKey(@Nullable final String secret)
    {
        m_secret_key = secret;
    }

    @Nullable
    public String getSecretKey()
    {
        return m_secret_key;
    }

    public void setUseRegion(@Nullable final String region)
    {
        m_use_region = region;
    }

    @Nullable
    public String getUseRegion()
    {
        return m_use_region;
    }
}
