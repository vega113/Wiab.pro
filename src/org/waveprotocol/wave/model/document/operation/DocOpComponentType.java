/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.waveprotocol.wave.model.document.operation;

/**
 * A superset of the DocInitializationComponentType enum that adds
 * update and deletion components.
 */
public class DocOpComponentType {

  public static final String ANNOTATION_BOUNDARY_NAME = "annotation boundary";
  public static final DocInitializationComponentType ANNOTATION_BOUNDARY =
      new DocInitializationComponentType(ANNOTATION_BOUNDARY_NAME);
  
  public static final String CHARACTERS_NAME = "characters";
  public static final DocInitializationComponentType CHARACTERS =
      new DocInitializationComponentType(CHARACTERS_NAME);
  
  public static final String ELEMENT_START_NAME = "element start";
  public static final DocInitializationComponentType ELEMENT_START =
      new DocInitializationComponentType(ELEMENT_START_NAME);
  
  public static final String ELEMENT_END_NAME = "element end";
  public static final DocInitializationComponentType ELEMENT_END =
      new DocInitializationComponentType(ELEMENT_END_NAME);

  public static final String RETAIN_NAME = "retain";
  public static final DocOpComponentType RETAIN =
      new DocOpComponentType(RETAIN_NAME);
  
  public static final String DELETE_CHARACTERS_NAME = "delete characters";
  public static final DocOpComponentType DELETE_CHARACTERS =
      new DocOpComponentType(DELETE_CHARACTERS_NAME);
  
  public static final String DELETE_ELEMENT_START_NAME = "delete element start";
  public static final DocOpComponentType DELETE_ELEMENT_START =
      new DocOpComponentType(DELETE_ELEMENT_START_NAME);
  
  public static final String DELETE_ELEMENT_END_NAME = "delete element end";
  public static final DocOpComponentType DELETE_ELEMENT_END =
      new DocOpComponentType(DELETE_ELEMENT_END_NAME);
  
  public static final String REPLACE_ATTRIBUTES_NAME = "replace attributes";  
  public static final DocOpComponentType REPLACE_ATTRIBUTES =
      new DocOpComponentType(REPLACE_ATTRIBUTES_NAME);
  
  public static final String UPDATE_ATTRIBUTES_NAME = "update attributes";
  public static final DocOpComponentType UPDATE_ATTRIBUTES =
      new DocOpComponentType(UPDATE_ATTRIBUTES_NAME);

  // TODO: add ordinals
  protected final String name;

  // package-visible for DocInitializationComponentType
  DocOpComponentType(String name) {
    this.name = name;
  }

  @Override
  public final String toString() {
    return name;
  }
  
  public String getName() {
    return name;
  }
}
