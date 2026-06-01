package fr.univ_amu.iut.exercice4;

import com.google.inject.AbstractModule;
import fr.univ_amu.iut.exercice3.ServiceAuth;
import fr.univ_amu.iut.exercice3.ServiceAuthSimple;

/**
 * Module Guice de l'exercice 4.
 *
 * <p>C'est l'unique endroit qui choisit l'implémentation concrète de chaque interface. On lit tout
 * le câblage de l'application en un seul fichier : c'est la "composition root" et la documentation
 * vivante de l'architecture.
 */
public class AppModule extends AbstractModule {

  @Override
  protected void configure() {
    // TODO exercice 4 : déclarer que ServiceAuth est fourni par ServiceAuthSimple.
    // Quand Guice voit un @Inject qui demande un ServiceAuth, il fournit un
    // ServiceAuthSimple.
    bind(ServiceAuth.class).to(ServiceAuthSimple.class);
  }
}
