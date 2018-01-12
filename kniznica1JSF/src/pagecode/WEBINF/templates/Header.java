/**
 * 
 */
package pagecode.WEBINF.templates;

import pagecode.PageCodeBase;
import javax.faces.component.html.HtmlOutcomeTargetButton;

/**
 * @author Dedera
 *
 */
public class Header extends PageCodeBase {

	protected HtmlOutcomeTargetButton button3;
	protected HtmlOutcomeTargetButton button2;

	protected HtmlOutcomeTargetButton getButton3() {
		if (button3 == null) {
			button3 = (HtmlOutcomeTargetButton) findComponentInRoot("button3");
		}
		return button3;
	}

	protected HtmlOutcomeTargetButton getButton2() {
		if (button2 == null) {
			button2 = (HtmlOutcomeTargetButton) findComponentInRoot("button2");
		}
		return button2;
	}

}