/**
 * Copyright 2010 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 */
package org.waveprotocol.box.server.rpc.render.renderer;

import org.waveprotocol.wave.model.conversation.Conversation;
import org.waveprotocol.wave.model.conversation.ConversationBlip;
import org.waveprotocol.wave.model.conversation.ConversationThread;
import org.waveprotocol.wave.model.conversation.ConversationView;
import org.waveprotocol.wave.model.util.IdentityMap;
import org.waveprotocol.wave.model.util.StringMap;
import org.waveprotocol.wave.model.wave.ParticipantId;


/**
 * Defines the production rules that build renderings of model objects out of
 * renderings of their components.
 *
 * @param <R> rendering type (e.g., SafeHtml, UiBuilder, or a template closure)
 */
public interface RenderingRules<R> {

  /**
   * Renders a named document.
   *
   * @param replies renderings of reply threads that may need to be rendered
   *        inline in the document. This method removes any threads rendered
   *        inside the document from the supplied map.
   * @return the rendering of {@code document}, whatever that means.
   */
  R renderNamedDocument(ConversationBlip blip,
      IdentityMap<ConversationThread, R> replies);

  /**
   * Renders a blip.
   *
   * @param blip blip to render
   * @param document rendering of the document
   * @param defaultAnchors renderings of the default anchors
   * @param nestedReplies renderings of all the nested replies to {@code blip}
   * @return the rendering of {@code blip}
   */
  R renderBlip(ConversationBlip blip, R document,
      IdentityMap<ConversationThread, R> defaultAnchors,
      IdentityMap<Conversation, R> nestedReplies);

  /**
   * Renders a thread.
   *
   * @param thread thread to render
   * @param blips renderings of all the blips in {@code thread}
   * @return the rendering of {@code thread}.
   */
  R renderThread(ConversationThread thread,
      IdentityMap<ConversationBlip, R> blips);

  /**
   * Renders a conversation.
   *
   * @param conversation conversation to render
   * @param participants rendering of {@code conversation}'s participants
   * @param thread rendering of {@code conversation}'s root thread
   * @return the rendering of {@code conversation}.
   */
  R renderConversation(Conversation conversation,
      R thread, R participants, R tags);

  /**
   * Renders a participant.
   *
   * @param conversation conversation in which the participant participates (lacking in the model)
   * @param participant participant to render
   * @return the rendering of {@code participant}.
   */
  R renderParticipant(Conversation conversation, ParticipantId participant);

  /**
   * Renders a collection of participants.
   *
   * @param conversation conversation whose participants are to be rendered
   * @param participants renderings of each participant
   * @return the rendering of {@code participants}.
   */
  R renderParticipants(Conversation conversation, StringMap<R> participants);

  /**
   * Renders the conversations in a wave.
   *
   * @param wave collection of conversations to render
   * @param conversations renderings of all the conversations in {@code wave}
   * @return the rendering of {@code wave}.
   */
  R renderConversations(ConversationView wave,
      IdentityMap<Conversation, R> conversations);

  /**
   * Renders a default anchor for a thread.
   *
   * @param thread thread anchored at the anchor
   * @param threadR rendering of the thread in the anchor, or {@code null}
   * @return the rendering of a default anchor for the id {@code id}.
   */
  R renderDefaultAnchor(ConversationThread thread, R threadR);
  
  /**
   * Renders a tag.
   *
   * @param conversation conversation in which the tag exists (lacking in the model)
   * @param tag tag to render
   * @return the rendering of {@code participant}.
   */
  R renderTag(Conversation conversation, String tag);

  /**
   * Renders a collection of tags.
   *
   * @param conversation conversation whose participants are to be rendered
   * @param tags renderings of each tag
   * @return the rendering of {@code participants}.
   */
  R renderTags(Conversation conversation, StringMap<R> tags);  
}
