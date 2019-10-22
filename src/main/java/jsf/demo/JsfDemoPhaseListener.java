package jsf.demo;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author AdNovum Informatik AG
 */
public class JsfDemoPhaseListener implements PhaseListener {

	private static final Logger LOG = LogManager.getLogger(JsfDemoPhaseListener.class);

	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent event) {
		LOG.info("- Ending phase: {}", event.getPhaseId());
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		LOG.info("- Starting phase: {}", event.getPhaseId());
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
