/*
 * Copyright 2017 - Swiss Data Science Center (SDSC)
 * A partnership between École Polytechnique Fédérale de Lausanne (EPFL) and
 * Eidgenössische Technische Hochschule Zürich (ETHZ).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ch.datascience.graph.types

import ch.datascience.graph.HasKey
import ch.datascience.graph.types.impl.ImplPropertyKey

/**
  * Base trait for property key definitions
  *
  * @tparam Key type of key
  */
trait PropertyKey[+Key] extends HasKey[Key] {

  def cardinality: Cardinality

  def dataType: DataType

  def simpleCopy: PropertyKey[Key] = PropertyKey(key, cardinality, dataType)

}

object PropertyKey {

  def apply[Key](key: Key, cardinality: Cardinality, dataType: DataType): PropertyKey[Key] = ImplPropertyKey(key, cardinality, dataType)

  def unapply[Key](propertyKey: PropertyKey[Key]): Option[(Key, Cardinality, DataType)] = {
    if (propertyKey eq null)
      None
    else
      Some(propertyKey.key, propertyKey.cardinality, propertyKey.dataType)
  }

}
