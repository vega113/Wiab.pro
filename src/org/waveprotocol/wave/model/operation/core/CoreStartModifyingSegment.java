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

package org.waveprotocol.wave.model.operation.core;

import org.waveprotocol.wave.model.id.SegmentId;
import org.waveprotocol.wave.model.operation.OperationException;
import org.waveprotocol.wave.model.wave.data.core.CoreWaveletData;

/**
 * Operation class for the add-segment operation.
 */
public final class CoreStartModifyingSegment extends CoreWaveletOperation {
  /** Segment to start modifying. */
  private final SegmentId segment;

  /**
   * Creates an start-modifying-segment operation.
   *
   * @param segment  segment to start modifying
   */
  public CoreStartModifyingSegment(SegmentId segment) {
    this.segment = segment;
  }

  /**
   * Gets the segment to start modifying.
   *
   * @return the segment to start modifying.
   */
  public SegmentId getSegmentId() {
    return segment;
  }

  @Override
  public void doApply(CoreWaveletData target) throws OperationException {
    throw new UnsupportedOperationException();
  }

  @Override
  public CoreWaveletOperation getInverse() {
    return new CoreEndModifyingSegment(segment);
  }


  @Override
  public String toString() {
    return "StartModifyingSegment(" + segment + ")";
  }

  @Override
  public int hashCode() {
    return segment.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof CoreStartModifyingSegment)) {
      return false;
    }
    CoreStartModifyingSegment other = (CoreStartModifyingSegment) obj;
    return segment.equals(other.segment);
  }
}
