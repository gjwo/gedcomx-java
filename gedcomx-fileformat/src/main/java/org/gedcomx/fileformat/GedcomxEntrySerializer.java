/**
 * Copyright Intellectual Reserve, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gedcomx.fileformat;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Basic interface abstracting serialization of an entry.
 *
 * @author Ryan Heaton
 */
public interface GedcomxEntrySerializer {

  /**
   * Serialize the resource to the specified output stream.
   *
   * @param resource the resource.
   * @param out the output stream.
   */
  void serialize(Object resource, OutputStream out) throws IOException;

  /**
   * Whether the specified content type is a known content type and therefore doesn't need to be written to the entry attributes.
   *
   * @param contentType The content type.
   * @return Whether the content type is "known".
   */
  boolean isKnownContentType(String contentType);
}
