package com.webank.webase.transaction.trans;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/*
 * Copyright 2012-2019 the original author or authors.
 *
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
 */
@Service
public interface TransMapper {
    
    void createTbTransaction();

    void insertTransInfo(TransInfo transInfoDto);

    List<TransInfo> selectUnStatTrans(@Param("requestCountMax") int requestCountMax,
            @Param("selectCount") int selectCount, @Param("intervalTime") int intervalTime);

    List<TransInfo> selectUnStatTransByJob(@Param("requestCountMax") int requestCountMax,
            @Param("selectCount") int selectCount, @Param("intervalTime") int intervalTime,
            @Param("shardingTotalCount") int shardingTotalCount,
            @Param("shardingItem") int shardingItem);

    void updateRequestCount(@Param("id") Long id, @Param("requestCount") int requestCount);

    void updateTransStatus(@Param("id") Long id);
}
