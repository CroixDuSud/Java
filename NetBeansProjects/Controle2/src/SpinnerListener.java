import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author afpa1800
 */
class SpinnerListener implements ChangeListener {
  public void stateChanged(ChangeEvent evt) {
    JSpinner spinner = (JSpinner) evt.getSource();

    // Get the new value
    Object value = spinner.getValue();
  }
}
