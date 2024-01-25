package pl.edu.wat.mspw_frontend.interfaces;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.edu.wat.mspw_backend.service.*;

import java.util.stream.Collectors;

public class ChoiceList {

    public static ObservableList<Item> kategoryList = FXCollections.observableArrayList();
    public static ObservableList<Item> efektorLacznList = FXCollections.observableArrayList();
    public static ObservableList<Item> efektorJezdnyList = FXCollections.observableArrayList();
    public static ObservableList<Item> efektorPlywaniaList = FXCollections.observableArrayList();
    public static ObservableList<Item> efektorInzList = FXCollections.observableArrayList();
    public static ObservableList<Item> efektorWeList = FXCollections.observableArrayList();
    public static ObservableList<Item> kadlubList = FXCollections.observableArrayList();
    public static ObservableList<Item> efektorTranspList = FXCollections.observableArrayList();
    public static ObservableList<Item> efektorLataniaList = FXCollections.observableArrayList();
    public static ObservableList<Item> efektorRozpozList = FXCollections.observableArrayList();
    public static ObservableList<Item> rodzajSystemuOgniaList = FXCollections.observableArrayList();
    public static ObservableList<Item> amoList = FXCollections.observableArrayList();
    public static ObservableList<Item> spwList = FXCollections.observableArrayList();
    public static ObservableList<Item> sysOgnList = FXCollections.observableArrayList();
    public static ObservableList<Item> rodzajGlowicyList = FXCollections.observableArrayList();
    public static ObservableList<Item> rodzajGlowicyNaprawList = FXCollections.observableArrayList();
    public static ObservableList<Item> rodzajNaprawList = FXCollections.observableArrayList();
    private static final KategoriaSpwService kategoriaSpwService = new KategoriaSpwService();
    private static final EfektorLacznService efektorLacznService = new EfektorLacznService();
    private static final EfektorJezdnyService efektorJezdnyService = new EfektorJezdnyService();
    private static final EfektorPlywaniaService efektorPlywaniaService = new EfektorPlywaniaService();
    private static final EfektorInzService efektorInzService = new EfektorInzService();
    private static final EfektorWeService efektorWeService = new EfektorWeService();
    private static final KadlubService kadlubService = new KadlubService();
    private static final EfektorTranspService efektorTranspService = new EfektorTranspService();
    private static final EfektorLataniaService efektorLataniaService = new EfektorLataniaService();
    private static final EfektorRozpozService efektorRozpozService = new EfektorRozpozService();
    private static final RodzajSystemuOgnService rodzajSystemuOgnService = new RodzajSystemuOgnService();
    private static final AmoService amoService = new AmoService();
    private static final SprzetWojService sprzetWojService = new SprzetWojService();
    private static final SystemOgnService systemOgnService = new SystemOgnService();
    private static final RodzajGlowicyBojService rodzajGlowicyBojService = new RodzajGlowicyBojService();
    private static final RodzajGlowicyNaprowService rodzajGlowicyNaprowService = new RodzajGlowicyNaprowService();
    private static final RodzajNaprowService rodzajNaprowService = new RodzajNaprowService();

    public static void refreshDataToChoiceBox(){
        Platform.runLater(() -> {
            kategoryList.setAll(FXCollections.observableArrayList(kategoriaSpwService.getAll().stream()
                    .map(object -> new Item(object.getId(), object.getNazwa()))
                    .collect(Collectors.toList())));

            efektorLacznList.setAll(FXCollections.observableArrayList( efektorLacznService.getAll().stream()
                    .map(object -> new Item(object.getId(), object.getNazwa()))
                    .collect(Collectors.toList())));

            efektorJezdnyList.setAll(FXCollections.observableArrayList(efektorJezdnyService.getAll().stream()
                    .map(object -> new Item(object.getId(), object.getNazwa()))
                    .collect(Collectors.toList())));

            efektorPlywaniaList.setAll(FXCollections.observableArrayList( efektorPlywaniaService.getAll().stream()
                    .map(object -> new Item(object.getId(), object.getNazwa()))
                    .collect(Collectors.toList())));

            efektorInzList.setAll(FXCollections.observableArrayList( efektorInzService.getAll().stream()
                    .map(object -> new Item(object.getId(), object.getNazwa()))
                    .collect(Collectors.toList())));

            efektorWeList.setAll(FXCollections.observableArrayList( efektorWeService.getAll().stream()
                    .map(object -> new Item(object.getId(), object.getNazwa()))
                    .collect(Collectors.toList())));

            kadlubList.setAll(FXCollections.observableArrayList( kadlubService.getAll().stream()
                    .map(object -> new Item(object.getId(), object.getNazwa()))
                    .collect(Collectors.toList())));

            efektorTranspList.setAll(FXCollections.observableArrayList(efektorTranspService.getAll().stream()
                    .map(object -> new Item(object.getId(), object.getNazwa()))
                    .collect(Collectors.toList())));

            efektorLataniaList.setAll(FXCollections.observableArrayList( efektorLataniaService.getAll().stream()
                    .map(object -> new Item(object.getId(), object.getNazwa()))
                    .collect(Collectors.toList())));

            efektorRozpozList.setAll(FXCollections.observableArrayList( efektorRozpozService.getAll().stream()
                    .map(object -> new Item(object.getId(), object.getNazwa()))
                    .collect(Collectors.toList())));

            rodzajSystemuOgniaList.setAll(FXCollections.observableArrayList( rodzajSystemuOgnService.getAll().stream()
                    .map(object -> new Item(object.getId(), object.getNazwa()))
                    .collect(Collectors.toList())));

           amoList.setAll(FXCollections.observableArrayList( amoService.getAll().stream()
                    .map(object -> new Item(object.getId(), object.getNazwa()))
                    .collect(Collectors.toList())));

           spwList.setAll(FXCollections.observableArrayList( sprzetWojService.getAll().stream()
                    .map(object -> new Item(object.getId(), object.getNazwa()))
                    .collect(Collectors.toList())));

           sysOgnList.setAll(FXCollections.observableArrayList( systemOgnService.getAll().stream()
                    .map(object -> new Item(object.getId(), object.getNazwa()))
                    .collect(Collectors.toList())));

           rodzajGlowicyList.setAll(FXCollections.observableArrayList( rodzajGlowicyBojService.getAll().stream()
                    .map(object -> new Item(object.getId(), object.getNazwa()))
                    .collect(Collectors.toList())));

           rodzajGlowicyNaprawList.setAll(FXCollections.observableArrayList( rodzajGlowicyNaprowService.getAll().stream()
                    .map(object -> new Item(object.getId(), object.getNazwa()))
                    .collect(Collectors.toList())));

           rodzajNaprawList.setAll(FXCollections.observableArrayList( rodzajNaprowService.getAll().stream()
                    .map(object -> new Item(object.getId(), object.getNazwa()))
                    .collect(Collectors.toList())));

        });
    }
}
