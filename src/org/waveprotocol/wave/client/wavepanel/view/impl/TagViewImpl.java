
package org.waveprotocol.wave.client.wavepanel.view.impl;

import org.waveprotocol.wave.client.wavepanel.view.IntrinsicTagView;
import org.waveprotocol.wave.client.wavepanel.view.TagView;
import org.waveprotocol.wave.client.wavepanel.view.View;

/**
 * Implements a tag view by delegating primitive state matters to a view
 * object, and structural state matters to a helper. The intent is that the
 * helper is a flyweight handler.
 *
 * @param <I> intrinsic participant implementation
 */
public final class TagViewImpl<I extends IntrinsicTagView> // \u2620
    extends AbstractStructuredView<TagViewImpl.Helper<? super I>, I> // \u2620
    implements TagView {

  /**
   * Handles structural queries on tag views.
   *
   * @param <I> intrinsic tag implementation
   */
  public interface Helper<I> {
    void remove(I impl);
  }

  public TagViewImpl(Helper<? super I> helper, I impl) {
    super(helper, impl);
  }

  @Override
  public String getId() {
    return impl.getId();
  }

  @Override
  public Type getType() {
    return Type.TAG;
  }

  @Override
  public void remove() {
    helper.remove(impl);
  }

  @Override
  public String getName() {
    return impl.getName();
  }

  @Override
  public void setName(String name) {
    impl.setName(name);
  }

  @Override
  public TagState getState() {
    return impl.getState();
  }
  
  @Override
  public void setState(TagState state) {
    impl.setState(state);
  }
  
  @Override
  public String getHint() {
    return impl.getHint();
  }
  
  @Override
  public void setHint(String hint) {
    impl.setHint(hint);
  }
  
  @Override
  public View getParent() {
    return null;
  }
}
