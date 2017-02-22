package es.salesianos.edu.webpages;

import java.util.Collections;
import java.util.List;

import java.sql.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.wicket.extensions.markup.html.form.DateTextField;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;


import es.salesianos.edu.model.Author;
import es.salesianos.edu.model.Name;
import es.salesianos.edu.service.AuthorService;
import es.salesianos.edu.service.NameService;;

public class ListName extends WebPage {
	
	private static final long serialVersionUID = -1935854748907274886L;

	@SpringBean
	NameService service;

	private static final Logger logger = LogManager.getLogger(ListAuthorPage.class.getName());

	private String currentNameSearch = null;

	private List<Name> listAuthor = Collections.emptyList();

	public  ListName(PageParameters parameters) {
		currentNameSearch = parameters.get("currentSearchTerm").toString();
		logger.debug("Cargando la pagina con el parametro " + currentNameSearch);
		initComponents();
	}

	public ListName() {
		initComponents();
	}

	private void initComponents() {
		addForm();
		addFeedBackPanel();
		addListAuthorView();
	}

	private void addForm() {
		Form form = new Form("formListAuthor", new CompoundPropertyModel(new Name())) {
			@Override
			protected void onSubmit() {
			super.onSubmit();
			listAuthor.clear();
			PageParameters pageParameters = new PageParameters();
			 pageParameters.add("currentSearchTerm", ((Name)getModelObject()).getName());
			 
			 setResponsePage(ListName.class, pageParameters);
			 }
		};
		Button okButton = new Button("okbutton") {
			public void onSubmit() {
				listAuthor.clear();
				info("OK was pressed!");
				Name author1 = new Name();
				author1.setName("Bat");
				author1.setSubname("Herrera");
				author1.setYearBorn(1);
				listAuthor.add(author1);
				
			}
		};
		Button cancelButton = new Button("cancelbutton") {
			public void onSubmit() {
				listAuthor.clear();
				info("OK was pressed!");
				Name author1 = new Name();
				author1.setName("Bafft");
				author1.setSubname("Herrera");
				author1.setYearBorn(1);
				listAuthor.add(author1);
				listAuthor.add(author1);
			
			}
		};
		form.add(okButton);
		form.add(cancelButton);

		form.add(new TextField("name"));
		add(form);
	}

	private void addFeedBackPanel() {
		FeedbackPanel feedbackPanel = new FeedbackPanel("feedbackMessage");
		add(feedbackPanel);
	}

	private void addListAuthorView() {
		Name author = new Name();// service.newEntity()
		author.setName(currentNameSearch);
		listAuthor = service.ListName(author);
		ListView<Name> listview = new ListView<Name>("author-group", listAuthor) {
			@Override
			protected void populateItem(ListItem item) {
				Name author = (Name) item.getModelObject();
				item.add(new Label("titleList", author.getName()));
				item.add(new Label("isbnList", author.getSubname()));
				item.add(new Label("authorList", author.getYearBorn()));
			}
		};
		add(listview);
	}


}