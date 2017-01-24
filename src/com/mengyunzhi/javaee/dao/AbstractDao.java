/*
 * $Id$
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.mengyunzhi.javaee.dao;

import com.mengyunzhi.javaee.application.Storage;
import com.mengyunzhi.javaee.exception.CreateException;
import com.mengyunzhi.javaee.exception.StorageException;
import com.mengyunzhi.javaee.exception.UpdateException;
import com.mengyunzhi.javaee.entity.IdEntity;

import java.io.Serializable;
import java.util.Collection;

/**
 * AbstractDao.
 */

public abstract class AbstractDao implements Serializable, Dao {

    private Storage storage;

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public IdEntity get(Serializable id) {
        return getStorage().get(getFeaturedClass(), id);
    }

    public Serializable create(IdEntity object) throws CreateException {
        return getStorage().create(object);
    }

    public IdEntity update(IdEntity object) throws UpdateException {
        return getStorage().update(object);
    }

    public Serializable merge(IdEntity object) throws StorageException {
        return getStorage().merge(object);
    }

    public int delete(Serializable id) throws CreateException {
        return getStorage().delete(getFeaturedClass(), id);
    }

    public int delete(IdEntity object) throws CreateException {
        return getStorage().delete(object);
    }

    public Collection findAll() {
        return getStorage().findAll(getFeaturedClass());
    }

    public Collection paginate(String query, int page, int pageSize) {
        return getStorage().paginate(getFeaturedClass(), query, page, pageSize);
    }
}
