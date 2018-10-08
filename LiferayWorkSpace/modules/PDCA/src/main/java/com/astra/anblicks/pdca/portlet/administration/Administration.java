/**
 * Copyright 2000-present Liferay, Inc.
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
package com.astra.anblicks.pdca.portlet.administration;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.astra.anblicks.pdca.constants.PDCAPortletKeys;
import com.astra.anblicks.pdca.utils.CLACalculations;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

@Component(
	immediate = true,
	property = {
        "com.liferay.portlet.display-category=AstraPDCA",
        "com.liferay.portlet.instanceable=true",
        "javax.portlet.display-name=AdministrationSettings",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.init-param.view-template=/administration/view.jsp",
        "javax.portlet.name=" + PDCAPortletKeys.Administration,
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user"
    },
    service = Portlet.class
)
public class Administration extends MVCPortlet {
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		try {
			CLACalculations.getClaCalculations(1, 1);
			CLACalculations.getClaCalculations(3, 1);
			CLACalculations.getClaCalculations(4, 1);
			CLACalculations.getClaCalculations(5, 1);
			CLACalculations.getClaCalculations(6, 1);
			CLACalculations.getClaCalculations(7, 1);
			CLACalculations.getClaCalculations(9, 1);
			CLACalculations.getClaCalculations(10, 1);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.doView(renderRequest, renderResponse);
	}
	
}