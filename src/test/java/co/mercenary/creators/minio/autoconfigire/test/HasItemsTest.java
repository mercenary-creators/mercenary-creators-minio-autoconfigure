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

package co.mercenary.creators.minio.autoconfigire.test;

import java.util.List;

import org.junit.jupiter.api.Test;

import co.mercenary.creators.minio.autoconfigire.util.AbstractAutoConfigureTests;
import co.mercenary.creators.minio.data.MinioItem;
import co.mercenary.creators.minio.errors.MinioOperationException;

public class HasItemsTest extends AbstractAutoConfigureTests
{
    @Test
    public void test() throws MinioOperationException
    {
        final List<MinioItem> list = toList(getMinioTemplate().getItems("root"));

        list.forEach(item -> info(() -> toJSONString(item)));

        assertFalse(list.isEmpty(), () -> "items is empty.");
    }
}
