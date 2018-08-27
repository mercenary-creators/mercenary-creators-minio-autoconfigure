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

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;

import co.mercenary.creators.minio.MinioTemplate;

@Configuration
@EnableConfigurationProperties({ MinioConfigurationProperties.class })
public class MinioAutoConfiguration
{
    @NonNull
    private final MinioConfigurationProperties properties;

    public MinioAutoConfiguration(@NonNull final MinioConfigurationProperties properties)
    {
        this.properties = properties;
    }

    @Bean
    @NonNull
    @ConditionalOnProperty(name = "minio.server-url")
    @ConditionalOnMissingBean(value = MinioTemplate.class, name = "minioTemplate")
    public MinioTemplate minioTemplate()
    {
        return new MinioTemplate(properties.getServerUrl(), properties.getAccessKey(), properties.getSecretKey(), properties.getAwsRegion());
    }
}
