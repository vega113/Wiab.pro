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
package org.waveprotocol.box.server.frontend;

import org.waveprotocol.box.server.persistence.blocks.Interval;
import org.waveprotocol.box.server.waveserver.WaveServerException;

import org.waveprotocol.wave.model.id.SegmentId;
import org.waveprotocol.wave.model.id.WaveletName;
import org.waveprotocol.wave.model.supplement.Supplement;
import org.waveprotocol.wave.model.wave.ParticipantId;
import org.waveprotocol.wave.model.version.HashedVersion;

import java.util.Map;

/**
 * @author akaplanov@gmail.com (A. Kaplanov)
 */
public interface SupplementProvider {
  Supplement getSupplement(WaveletName waveletName, ParticipantId participant,
    HashedVersion version, Map<SegmentId, Interval> intervals) throws WaveServerException;
}
