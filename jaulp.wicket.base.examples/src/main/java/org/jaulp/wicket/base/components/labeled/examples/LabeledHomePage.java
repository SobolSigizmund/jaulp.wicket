package org.jaulp.wicket.base.components.labeled.examples;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.jaulp.wicket.base.mainbase.BasePage;
import org.jaulp.wicket.components.labeled.checkbox.LabeledCheckboxPanel;
import org.jaulp.wicket.components.labeled.textarea.LabeledTextAreaPanel;
import org.jaulp.wicket.components.labeled.textfield.LabeledTextfieldPanel;

public class LabeledHomePage extends BasePage {
	private static final long serialVersionUID = 1L;
	
	private Person person;

    public LabeledHomePage(final PageParameters parameters) {
	super(parameters);	
	
	person = new Person();
	person.setGender("");
	person.setName("");



	final IModel<Person> cpModel = new CompoundPropertyModel<Person>(
			person);

	final Form<Person> form = 
	        new Form<Person>("form", cpModel);

	add(form);
	PropertyModel<Person> model = new PropertyModel<Person>(this, "person.name");

	LabeledTextfieldPanel<Person> nameTextField = new LabeledTextfieldPanel<Person>("name", cpModel, Model.of("Name:"));

	form.add(nameTextField);
	
	model = new PropertyModel<Person>(this, "person.gender");

	LabeledTextfieldPanel<Person> genderTextField = new LabeledTextfieldPanel<Person>("gender", cpModel, Model.of("Gender:"));

	form.add(genderTextField);

	model = new PropertyModel<Person>(this, "person.about");
	
	LabeledTextAreaPanel<Person> about = new LabeledTextAreaPanel<Person>("about", model,  Model.of("About:"));
	form.add(about);
	
	PropertyModel<Boolean> marriedModel = new PropertyModel<Boolean>(this, "person.married");
	LabeledCheckboxPanel married = new LabeledCheckboxPanel("married", marriedModel, Model.of("Married:"));
	form.add(married);

	// Create submit button for the form
	final Button submitButton = new Button("submitButton") {
		/**
		 * The serialVersionUID.
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void onSubmit() {
			info("Person:"+person.toString());
		}
	};

	form.add(submitButton);
	
	add(new FeedbackPanel("feedbackpanel"));
	
	
    }
}
