package com.astra.anblicks.pdca.portlet;

import com.astra.anblicks.pdca.constants.PDCAPortletKeys;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.test.model.Country;
import com.test.service.CountryLocalServiceUtil;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author kranthi.kumar
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=AstraPDCA",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=PDCA Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + PDCAPortletKeys.PDCA,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class PDCAPortlet extends MVCPortlet {
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		Country createCountry = CountryLocalServiceUtil.createCountry(CounterLocalServiceUtil.increment());
		createCountry.setCountryName("india");
		Country addCountry = CountryLocalServiceUtil.addCountry(createCountry);
		System.out.println(addCountry.toString());
		super.doView(renderRequest, renderResponse);
	}
}