package gold.Osawota.goldwepapp.bootstrap;

import gold.Osawota.goldwepapp.model.Author;
import gold.Osawota.goldwepapp.model.Book;
import gold.Osawota.goldwepapp.model.Publisher;
import gold.Osawota.goldwepapp.respositories.AuthorRespositories;
import gold.Osawota.goldwepapp.respositories.BookRespositories;
import gold.Osawota.goldwepapp.respositories.PublisherRespo;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRespositories authro;
    private BookRespositories bolk;
    private PublisherRespo respp;

    public DevBootstrap(AuthorRespositories authro, BookRespositories bolk, PublisherRespo respp) {
        this.authro = authro;
        this.bolk = bolk;
        this.respp = respp;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData()
    {
        //pub
        Publisher pub= new Publisher();
        pub.setName("Big head");
        respp.save(pub);
        //Eric
        Author eric= new Author("Eric","Evans");
        Book ddd= new Book("Domain driven Design", "1234", pub);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authro.save(eric);
        bolk.save(ddd);
        //Rod
        Author rod= new Author("Rod","Johnson");
        Book noEjb= new Book( "J2EE Development without EJB", "23444", pub) ;
        eric.getBooks().add(noEjb);
        ddd.getAuthors().add(rod);


        authro.save(rod);
        bolk.save(noEjb);


    }
}
