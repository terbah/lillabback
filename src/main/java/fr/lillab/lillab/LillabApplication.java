package fr.lillab.lillab;

import fr.lillab.lillab.model.*;
import fr.lillab.lillab.repository.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class LillabApplication {

    public static void main(String[] args) {
        SpringApplication.run(LillabApplication.class, args);
    }
    @Bean

    ApplicationRunner applicationRunner(DomaineRepository d, TypeUtilisateurRepository tpu, UtilisateurRepository u, CompetenceRepository c, CommentaireRepository comment, IdeeRepository ide, PouceRepository p, ProjetRepository proj, EvenementRepository er,LaboratoryRepository lab){
        return args -> {


            // Generation des dates : Creation et Modif
            String str="2015-03-31";
            String datemodif="2020-05-15";

            /** --- DEBUT - CREATION DOMAINES --- **/
            Domaine d01 = new Domaine();
            d01.setLibelle("Géopolitique");
            Domaine d1 = new Domaine();
            d1.setLibelle("Mathématiques");
            Domaine d2  =  new Domaine();
            d2.setLibelle("Physique");
            Domaine d3  =  new Domaine();
            d3.setLibelle("Sciences de la terre et de l'univers, espace");
            Domaine d4  =  new Domaine();
            d4.setLibelle("Chimie");
            Domaine d5  =  new Domaine();
            d5.setLibelle("Biologie, médecine et santé");
            Domaine d6  =  new Domaine();
            d6.setLibelle("Sciences humaines et humanités");
            Domaine d7  =  new Domaine();
            d7.setLibelle("Sciences de la société");
            Domaine d8  =  new Domaine();
            d8.setLibelle("Sciences pour l'ingénieur");
            Domaine d9  =  new Domaine();
            d9.setLibelle("Sciences et technologies de l'information et de la communication");
            Domaine d10  =  new Domaine();
            d10.setLibelle("Sciences agronomiques et écologiques");
            Domaine d11  =  new Domaine();
            d11.setLibelle("Gestion du patrimoine scientifique");
            Domaine d12  =  new Domaine();
            d12.setLibelle("Philosophie");

            d.save(d01); d.save(d1); d.save(d2); d.save(d3); d.save(d4);
            d.save(d5); d.save(d6); d.save(d7); d.save(d8); d.save(d9);
            d.save(d10); d.save(d11); d.save(d12);


            // List<Domaine> listDomaine = new ArrayList<Domaine>();
            //listDomaine.add(d1);

            /** --- DEBUT - CREATION COMPETENCES --- **/
            Competence c1 = new Competence();
            c1.setLibelle("Cryptographie");
            Competence c2  =  new Competence();
            c2.setLibelle("Programmation Informatique");
            Competence c3  =  new Competence();
            c3.setLibelle("Droit et législation");
            Competence c4  =  new Competence();
            c4.setLibelle("Photographie");

            c.save(c1); c.save(c2); c.save(c3); c.save(c4);

            /*List<Competence> listComp = new ArrayList<Competence>();
            listComp.add(c1);*/
            /** --- FIN - CREATION COMPETENCES --- **/


            //Creation type Utilisateur
            TypeUtilisateur typeUser= new TypeUtilisateur();
            typeUser.setLibelle("Chercheur");

            TypeUtilisateur typeUser1= new TypeUtilisateur();
            typeUser1.setLibelle("Ingenieur de projet");


           /* // Creation Utilisateur
            Utilisateur user = new Utilisateur();
            user.setNom("toto");
            user.setPrenom("titi");

            user.setEmail("hjlmt@gmail.com");

            user.setTypeUtilisateur(typeUser);
            user.setMotdepasse("hellohello");
            user.getDomaines().add(d1);
            user.setCompetenceList(listComp);
*/
            /** --- DEBUT - CREATION LABORATOIRES --- **/
            Laboratory lab1 = new Laboratory();
            lab1.setDesignation(" Analyses littéraires et histoire de la langue - ALITHILA - EA 1061 ");
            Laboratory lab2 = new Laboratory();
            lab2.setDesignation(" Centre d’infection et d’immunité de Lille - CIIL - U1019 - UMR 8204 ");
            Laboratory lab3 = new Laboratory();
            lab3.setDesignation(" Centre d'étude des arts contemporains - CEAC - EA 3587 ");
            Laboratory lab4 = new Laboratory();
            lab4.setDesignation(" Centre d'étude et de recherches administratives, politiques et sociales - CERAPS - UMR 8026 ");
            Laboratory lab5 = new Laboratory();
            lab5.setDesignation(" Centre d'études en civilisation, langues et lettres étrangères - CECILLE - EA 4074 ");
            Laboratory lab6 = new Laboratory();
            lab6.setDesignation(" Centre d'histoire judiciaire - CHJ - UMR 8025 ");
            Laboratory lab7 = new Laboratory();
            lab7.setDesignation(" Centre de recherche en informatique, signal et automatique - CRISTAL - UMR 9189 ");
            Laboratory lab8 = new Laboratory();
            lab8.setDesignation(" Centre de recherche Jean-Pierre Aubert - Neurosciences et cancer - JPArc - UMR-S 1172 ");
            Laboratory lab9 = new Laboratory();
            lab9.setDesignation(" Centre de recherche « Individus, épreuves, sociétés » - CERIES - EA 3589 ");
            Laboratory lab10 = new Laboratory();
            lab10.setDesignation(" Centre droits et perspectives du droit - CRDP - EA 4487 ");
            Laboratory lab11 = new Laboratory();
            lab11.setDesignation(" Centre lillois d'études et de recherches sociologiques et économiques - CLERSE - UMR 8019 ");
            Laboratory lab12 = new Laboratory();
            lab12.setDesignation(" Centre inter-universitaire de recherche en éducation de Lille - CIREL - EA 4354 ");
            Laboratory lab13 = new Laboratory();
            lab13.setDesignation(" Environnement périnatal et santé - EPS- EA 4489 ");
            Laboratory lab14 = new Laboratory();
            lab14.setDesignation(" Evolution, écologie et paléontologie - EVO ECO PALEO - UMR 8198 ");
            Laboratory lab15 = new Laboratory();
            lab15.setDesignation(" Facteurs de risques et déterminants moléculaires des maladies liées au vieillissement - RID-AGE - U 1167 ");
            Laboratory lab16 = new Laboratory();
            lab16.setDesignation(" Environnement périnatal et santé - EPS- EA 4489 ");
            Laboratory lab17 = new Laboratory();
            lab17.setDesignation(" Génomique intégrative et modélisation des maladies métaboliques - UMR 8199 ");
            Laboratory lab18 = new Laboratory();
            lab18.setDesignation(" Groupe d'études et de la recherche interdisciplinaire en information et communication - GERIICO - EA 4073 ");
            Laboratory lab19 = new Laboratory();
            lab19.setDesignation(" Groupe de recherche sur les formes injectables et les technologies associées - GRITA - EA 7365 ");
            Laboratory lab20 = new Laboratory();
            lab20.setDesignation(" Histoire, archéologie et littérature des mondes anciens - HALMA - UMR 8164 ");
            Laboratory lab21 = new Laboratory();
            lab21.setDesignation(" ICARE centre de données et services - Icare - UMS 2877 ");
            Laboratory lab22 = new Laboratory();
            lab22.setDesignation(" Impact de l’environnement chimique sur la santé humaine - IMPECS - EA 4483 ");
            Laboratory lab23 = new Laboratory();
            lab23.setDesignation(" Institut Charles Viollette - ICV - EA 7394 ");
            Laboratory lab24 = new Laboratory();
            lab24.setDesignation(" Institut d'électronique, de microélectronique et de nanotechnologie - IEMN - UMR 8520 ");
            Laboratory lab25 = new Laboratory();
            lab25.setDesignation(" Institut de recherche sur les composants logiciels et matériels pour l'information et la communication avancée - IRCICA - USR 3380 ");

            lab.save(lab1); lab.save(lab2); lab.save(lab3); lab.save(lab4); lab.save(lab5);
            lab.save(lab6); lab.save(lab7); lab.save(lab8); lab.save(lab9); lab.save(lab10);
            lab.save(lab11); lab.save(lab12); lab.save(lab13); lab.save(lab14); lab.save(lab15);
            lab.save(lab16); lab.save(lab17); lab.save(lab18); lab.save(lab19); lab.save(lab20);
            lab.save(lab21); lab.save(lab22); lab.save(lab23); lab.save(lab24); lab.save(lab25);
            /** --- FIN - CREATION LABORATOIRES --- **/


            /*
            // Creation de l'idee
            Idee idee1 = new Idee();
            idee1.setUtilisateur(user);
            idee1.setDatecreation(Date.valueOf(str));
            idee1.getDomaineList().add(d1);
            idee1.getCompetenceList().add(c1);
            idee1.setTitre("Mon idee toto");
            idee1.setDescription("La description toto");



            List<Commentaire>istcomment = new ArrayList<>();
            // Commentaire 1
            Commentaire commentaire = new Commentaire();
            commentaire.setUtilisateur(user);
            commentaire.setIdee(idee1);
            commentaire.setTexteComment("Mon commentaire imen");
            commentaire.setDateCreation(Date.valueOf(str));
            commentaire.setDateModif(Date.valueOf(datemodif));
            idee1.getCommentaireList().add(commentaire);
            istcomment.add(commentaire);


            // DeuxiÃ¨me Commentaire
            Commentaire commentair = new Commentaire();
            commentair.setUtilisateur(user);
            commentair.setIdee(idee1);
            commentair.setTexteComment("Mon commentaire toto toto");
            commentair.setDateModif(Date.valueOf(datemodif));
            commentair.setDateCreation(Date.valueOf(str));
            istcomment.add(commentair);
            idee1.getCommentaireList().add(commentair);

            // Creation d'un like
            Pouce pouce = new Pouce(idee1,user,Date.valueOf(str));
            List<Pouce> pouces = new ArrayList<Pouce>();
            pouces.add(pouce);
            idee1.setLikeListe(pouces);

            //creation d'un projet
            Projet projet = new Projet();
            projet.setCompetenceList(listComp);
            projet.setDateCreation(Date.valueOf(str));
            projet.setDateModif(Date.valueOf(datemodif));
            projet.setDescription(" ceci un projet");
            projet.setDomaineList(listDomaine);
            projet.setUtilisateur(user);*/

            // different save dans la base

            tpu.save(typeUser);
            tpu.save(typeUser1);


            /** --- DEBUT - CREATION EVENEMENTS --- **/

           /* Evenement myEvent = new Evenement();
            myEvent.setLieu("Marseille");
            myEvent.setTitre("The classico");
            myEvent.setDescription("Match de foot entre l'OM et le PSG");
            String dateEvent="2020-05-05";
            myEvent.setDate(Date.valueOf(dateEvent));
            myEvent.setUtilisateur(user);

            u.save(user);
            er.save(myEvent);*/

            /** --- FIN - CREATION EVENEMENTS --- **/

        };
    }






}
