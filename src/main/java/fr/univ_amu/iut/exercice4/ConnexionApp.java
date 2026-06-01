package fr.univ_amu.iut.exercice4;

import com.google.inject.Guice;
import com.google.inject.Injector;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Bootstrap de l'exercice 4.
 *
 * <p>Comparez avec FormulaireConnexionApp (ex3) : plus aucun {@code new ServiceAuthSimple()} ni
 * {@code new ...ViewModel(...)} à la main. Le câblage vit désormais dans {@link AppModule}.
 *
 * <p>La ligne clef est {@code setControllerFactory(injector::getInstance)} : elle dit au FXMLLoader
 * de construire tous les contrôleurs via Guice, qui remplit leurs {@code @Inject}.
 */
public class ConnexionApp extends Application {

  @Override
  public void start(Stage stage) throws Exception {
    // TODO exercice 4 : créer l'injecteur, brancher le controllerFactory, charger
    // et afficher.
    //
    // 1. Créer l'injecteur à partir du module :
    // Injector injector = Guice.createInjector(new AppModule());
    // 2. Dire au FXMLLoader d'utiliser l'injecteur comme fabrique de contrôleurs :
    // loader.setControllerFactory(injector::getInstance);
    // 3. Charger la vue et afficher la fenêtre.

    // 1. Créer l'injecteur Guice à partir du module
    Injector injector = Guice.createInjector(new AppModule());

    // 2. Charger le FXML en branchant Guice comme controllerFactory
    FXMLLoader loader = new FXMLLoader(getClass().getResource("ConnexionView.fxml"));
    loader.setControllerFactory(injector::getInstance);
    Parent racine = loader.load();

    // 3. Afficher la fenêtre
    stage.setTitle("Exercice 4 - Connexion avec Guice");
    stage.setScene(new Scene(racine));
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
