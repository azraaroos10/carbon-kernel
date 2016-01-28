/*
 *  Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.wso2.carbon.datasource.rdbms.tomcat;

import org.wso2.carbon.datasource.common.DataSourceException;
import org.wso2.carbon.datasource.common.spi.DataSourceReader;
import org.wso2.carbon.datasource.rdbms.RDBMSDataSourceConstants;
import org.wso2.carbon.datasource.rdbms.utils.RDBMSDataSourceUtils;

/**
 * This class represents the RDBMS based data source reader implementation.
 */
public class TomcatSDataSourceReader implements DataSourceReader {

    @Override
    public String getType() {
        return RDBMSDataSourceConstants.RDBMS_DATASOURCE_TYPE;
    }

    @Override
    public Object createDataSource(String xmlConfiguration, boolean isDataSourceFactoryReference)
            throws DataSourceException {
        TomcatDataSource dataSource = new TomcatDataSource(RDBMSDataSourceUtils.loadConfig(xmlConfiguration));
        if (isDataSourceFactoryReference) {
            return dataSource.getDataSourceFactoryReference();
        } else {
            return dataSource.getDataSource();
        }
    }
}
