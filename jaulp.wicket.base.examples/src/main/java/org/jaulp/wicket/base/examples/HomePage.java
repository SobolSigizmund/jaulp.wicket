/**
 * Copyright (C) 2010 Asterios Raptis
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jaulp.wicket.base.examples;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.jaulp.wicket.base.mainbase.BaseMainPage;
import org.wicketstuff.annotation.mount.MountPath;

@MountPath("/home")
public class HomePage extends BaseMainPage
{
	private static final long serialVersionUID = 1L;


	public HomePage()
	{
		this(null);
	}

	public HomePage(final PageParameters parameters)
	{
		super(parameters);
		final PageParameters pageParameters = getPageParameters();
		add(new MenubarPanel("menubarPanel"));

		add(new Label("text", Model.of("This is the home page.")));

	}
}
