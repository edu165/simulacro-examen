package es.salesianos.edu.webpages;

import org.apache.wicket.extensions.markup.html.form.DateTextField;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import es.salesianos.edu.model.Name;
import es.salesianos.edu.service.NameService;


public class NamePage  extends WebPage{
	
	private static final long serialVersionUID = 1L;

	@SpringBean
	NameService simulacroService;

	

	public NamePage() {
		add(new Label("title", getString("title")));
		Name authorDto;
		authorDto = new Name();
		Form<Name> formAuthor = new Form<Name>("formAddNewAuthor", new CompoundPropertyModel<Name>(authorDto)){
			
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {
				super.onSubmit();
				boolean isInserted = simulacroService.insertService(getModelObject());
				FeedbackMessage message;
				if(isInserted){
					message = new FeedbackMessage(this, "Autor insertado", FeedbackMessage.INFO);
				} else {
					message = new FeedbackMessage(this, "No se pudo insertar", FeedbackMessage.INFO);
				}
				getFeedbackMessages().add(message);
			}
		};
		formAuthor.add(new Label("NameLabel", getString("author.name")));
		formAuthor.add(new Label("SubNameLabel", getString("subname")));
		formAuthor.add(new Label("YearBorn", getString("date.of.birth")));
		formAuthor.add(new TextField<String>("name"));
		formAuthor.add(new RequiredTextField<String>("subname"));
		formAuthor.add(new RequiredTextField<String>("yearBorn"));
		
		FeedbackPanel feedbackPanel = new FeedbackPanel("feedbackMessage");
		feedbackPanel.setOutputMarkupId(true);
		add(feedbackPanel);
		add(formAuthor);

		
	}

}
