package com.example.emis.Models;

import com.example.emis.Controllers.mainController;
import com.example.emis.Controllers.studentInfoController;
import com.example.emis.Objects.Student;
import com.gluonhq.maps.MapLayer;
import com.gluonhq.maps.MapView;
import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.emis.Enums.ImagesEnum.LOGO_IMAGE;
import static com.example.emis.Enums.SQLRolesEnum.*;
import static com.example.emis.Enums.ScenesEnum.*;
import static com.example.emis.Others.Alerts.*;
import static com.example.emis.Others.SQL.*;

public class mainModel {
    private mainController mainController1;

    public void setMainController1(mainController mainController1) {
        this.mainController1 = mainController1;
    }

    public void whatRole() {
        String role = SQLWhatRole(mainController1.emailUsing);

        if (role != null) {
            if (role.equals(MIS_ROLE_ENUM.getRole())) {
                loadForMIS();
            } else if (role.equals(TEACHER_ROLE_ENUM.getRole())) {
                loadForTeacher();
            } else if (role.equals(STUDENT_ROLE_ENUM.getRole())) {
                loadForStudent();
            }

            if (!role.equals(MIS_ROLE_ENUM.getRole())) {
                setEnrolledTables();
                setMapView();
            }
        } else {
            alertUnexpectedError();
        }
    }

    private void loadForMIS() {
        setRemoveUnnecessaryButtonForMis();
        setMISTables();
        mainController1.anchorPaneLeftNav.setVisible(true);
        switchTabForMIS(1);
    }

    private void setRemoveUnnecessaryButtonForMis() {
        ObservableList<JFXButton> topNavToRemove = FXCollections.observableArrayList(
                mainController1.btnTopNavDashboard, mainController1.btnTopNavSections, mainController1.btnTopNavHome, mainController1.btnTopNavSchedule, mainController1.btnTopNavEnrolled, mainController1.btnTopNavContactUs);
        mainController1.flowPaneTopNav.getChildren().removeAll(topNavToRemove);
    }

    private void setMISTables() {
        mainController1.tableViewApplicantsAnchorPaneEnroll.setItems(mainController1.observableListTableViewApplicantsAnchorPaneEnroll);
        mainController1.tableViewApplicantsColumnFullNameAnchorPaneEnroll.setReorderable(false);
        mainController1.tableViewApplicantsColumnDocumentStatusAnchorPaneEnroll.setReorderable(false);
        mainController1.tableViewApplicantsColumnFullNameAnchorPaneEnroll.setResizable(false);
        mainController1.tableViewApplicantsColumnDocumentStatusAnchorPaneEnroll.setResizable(false);
        mainController1.tableViewApplicantsColumnFullNameAnchorPaneEnroll.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        mainController1.tableViewApplicantsColumnDocumentStatusAnchorPaneEnroll.setCellValueFactory(new PropertyValueFactory<>("documentStatus"));

        mainController1.tableViewEnrolledLeftNavAnchorPaneEnroll.setItems(mainController1.observableListTableViewEnrolledLeftNavAnchorPaneEnroll);
        mainController1.tableViewEnrolledLeftNavColumnFullNameAnchorPaneEnroll.setReorderable(false);
        mainController1.tableViewEnrolledLeftNavColumnFullNameAnchorPaneEnroll.setResizable(false);
        mainController1.tableViewEnrolledLeftNavColumnFullNameAnchorPaneEnroll.setCellValueFactory(new PropertyValueFactory<>("fullName"));

        mainController1.tableViewDeclinedAnchorPaneEnroll.setItems(mainController1.observableListTableViewDeclinedAnchorPaneEnroll);
        mainController1.tableViewDeclinedColumnFullNameAnchorPaneEnroll.setReorderable(false);
        mainController1.tableViewDeclinedColumnFullNameAnchorPaneEnroll.setResizable(false);
        mainController1.tableViewDeclinedColumnFullNameAnchorPaneEnroll.setCellValueFactory(new PropertyValueFactory<>("fullName"));
    }

    private void setEnrolledTables() {
        mainController1.tableViewEnrolledStudentTopNavAnchorPaneEnrolled.setItems(mainController1.observableListTableViewEnrolledStudentTopNavAnchorPaneEnrolled);
        mainController1.tableViewEnrolledStudentColumnFullNameAnchorPaneEnrolled.setReorderable(false);
        mainController1.tableViewEnrolledStudentColumnFullNameAnchorPaneEnrolled.setResizable(false);
        mainController1.tableViewEnrolledStudentColumnSectionAnchorPaneEnrolled.setReorderable(false);
        mainController1.tableViewEnrolledStudentColumnSectionAnchorPaneEnrolled.setResizable(false);
        mainController1.tableViewEnrolledStudentColumnStrandAnchorPaneEnrolled.setReorderable(false);
        mainController1.tableViewEnrolledStudentColumnStrandAnchorPaneEnrolled.setResizable(false);
        mainController1.tableViewEnrolledStudentColumnFullNameAnchorPaneEnrolled.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        mainController1.tableViewEnrolledStudentColumnSectionAnchorPaneEnrolled.setCellValueFactory(new PropertyValueFactory<>("strand"));
        mainController1.tableViewEnrolledStudentColumnStrandAnchorPaneEnrolled.setCellValueFactory(new PropertyValueFactory<>("section"));

        mainController1.tableViewEnrolledStudentTopNavAnchorPaneEnrolled.setSelectionModel(null);
    }

    private void setStudentTeacherObservableLists() {
        mainController1.observableListTableViewEnrolledStudentTopNavAnchorPaneEnrolled.clear();
        mainController1.observableListTableViewEnrolledStudentTopNavAnchorPaneEnrolled = SQLPopulateTopNavEnrolledStudentObservableList();
        mainController1.tableViewEnrolledStudentTopNavAnchorPaneEnrolled.setItems(mainController1.observableListTableViewEnrolledStudentTopNavAnchorPaneEnrolled);
    }

    public void switchTabForMIS(int number) {
        switch (number) {
            case 1: // dashboard
                mainController1.anchorPaneLeftNavDashboard.setVisible(true);
                mainController1.anchorPaneLeftNavEnroll.setVisible(false);
                mainController1.anchorPaneLeftNavTeachers.setVisible(false);
                mainController1.anchorPaneLeftNavStrand.setVisible(false);
                mainController1.anchorPaneLeftNavSection.setVisible(false);
                mainController1.anchorPaneLeftNavContactUsDetails.setVisible(false);

                mainController1.btnLeftNavDashboard.setStyle(mainController1.styleTabSelected);
                mainController1.btnLeftNavApplicants.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnLeftNavTeachers.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnLeftNavStrand.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnLeftNavSection.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnLeftNavContactUs.setStyle(mainController1.styleTabNotSelected);

                setMISObservableLists();
                setMISDashboardContent();
                break;
            case 2: // applicants
                mainController1.anchorPaneLeftNavDashboard.setVisible(false);
                mainController1.anchorPaneLeftNavEnroll.setVisible(true);
                mainController1.anchorPaneLeftNavTeachers.setVisible(false);
                mainController1.anchorPaneLeftNavStrand.setVisible(false);
                mainController1.anchorPaneLeftNavSection.setVisible(false);
                mainController1.anchorPaneLeftNavContactUsDetails.setVisible(false);

                mainController1.btnLeftNavDashboard.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnLeftNavApplicants.setStyle(mainController1.styleTabSelected);
                mainController1.btnLeftNavTeachers.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnLeftNavStrand.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnLeftNavSection.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnLeftNavContactUs.setStyle(mainController1.styleTabNotSelected);

                setMISObservableLists();
                break;
            case 3: // teacher
                mainController1.anchorPaneLeftNavDashboard.setVisible(false);
                mainController1.anchorPaneLeftNavEnroll.setVisible(false);
                mainController1.anchorPaneLeftNavTeachers.setVisible(true);
                mainController1.anchorPaneLeftNavStrand.setVisible(false);
                mainController1.anchorPaneLeftNavSection.setVisible(false);
                mainController1.anchorPaneLeftNavContactUsDetails.setVisible(false);

                mainController1.btnLeftNavDashboard.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnLeftNavApplicants.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnLeftNavTeachers.setStyle(mainController1.styleTabSelected);
                mainController1.btnLeftNavStrand.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnLeftNavSection.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnLeftNavContactUs.setStyle(mainController1.styleTabNotSelected);
                break;
            case 4: // strand
                mainController1.anchorPaneLeftNavDashboard.setVisible(false);
                mainController1.anchorPaneLeftNavEnroll.setVisible(false);
                mainController1.anchorPaneLeftNavTeachers.setVisible(false);
                mainController1.anchorPaneLeftNavStrand.setVisible(true);
                mainController1.anchorPaneLeftNavSection.setVisible(false);
                mainController1.anchorPaneLeftNavContactUsDetails.setVisible(false);

                mainController1.btnLeftNavDashboard.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnLeftNavApplicants.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnLeftNavTeachers.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnLeftNavStrand.setStyle(mainController1.styleTabSelected);
                mainController1.btnLeftNavSection.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnLeftNavContactUs.setStyle(mainController1.styleTabNotSelected);
                break;
            case 5: // section
                mainController1.anchorPaneLeftNavDashboard.setVisible(false);
                mainController1.anchorPaneLeftNavEnroll.setVisible(false);
                mainController1.anchorPaneLeftNavTeachers.setVisible(false);
                mainController1.anchorPaneLeftNavStrand.setVisible(false);
                mainController1.anchorPaneLeftNavSection.setVisible(true);
                mainController1.anchorPaneLeftNavContactUsDetails.setVisible(false);

                mainController1.btnLeftNavDashboard.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnLeftNavApplicants.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnLeftNavTeachers.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnLeftNavStrand.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnLeftNavSection.setStyle(mainController1.styleTabSelected);
                mainController1.btnLeftNavContactUs.setStyle(mainController1.styleTabNotSelected);
                break;
            case 6: // contact us details
                mainController1.anchorPaneLeftNavDashboard.setVisible(false);
                mainController1.anchorPaneLeftNavEnroll.setVisible(false);
                mainController1.anchorPaneLeftNavTeachers.setVisible(false);
                mainController1.anchorPaneLeftNavStrand.setVisible(false);
                mainController1.anchorPaneLeftNavSection.setVisible(false);
                mainController1.anchorPaneLeftNavContactUsDetails.setVisible(true);

                mainController1.btnLeftNavDashboard.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnLeftNavApplicants.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnLeftNavTeachers.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnLeftNavStrand.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnLeftNavSection.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnLeftNavContactUs.setStyle(mainController1.styleTabSelected);
                break;
        }
    }

    private void setMISDashboardContent() {
        mainController1.labelAnchorPaneAdminDashboardApplicants.setText(String.valueOf(mainController1.observableListAllApplicants.size()));
        mainController1.labelAnchorPaneAdminDashboardEnrolled.setText(String.valueOf(mainController1.observableListTableViewEnrolledLeftNavAnchorPaneEnroll.size()));
        mainController1.labelAnchorPaneAdminDashboardDeclined.setText(String.valueOf(mainController1.observableListTableViewDeclinedAnchorPaneEnroll.size()));
    }

    private void setMISObservableLists() {
        mainController1.observableListAllApplicants.clear();
        mainController1.observableListTableViewApplicantsAnchorPaneEnroll.clear();
        mainController1.observableListTableViewEnrolledLeftNavAnchorPaneEnroll.clear();
        mainController1.observableListTableViewDeclinedAnchorPaneEnroll.clear();

        mainController1.observableListAllApplicants = SQLPopulateStudentObservableList();

        for (Student student : mainController1.observableListAllApplicants) {
            if (student.isApplied()) {
                mainController1.observableListTableViewApplicantsAnchorPaneEnroll.add(student);

                if (student.isAdmissionProcessed()) {
                    if (student.isEnrolled()) {
                        mainController1.observableListTableViewEnrolledLeftNavAnchorPaneEnroll.add(student);
                    } else {
                        mainController1.observableListTableViewDeclinedAnchorPaneEnroll.add(student);
                    }
                }
            }
        }
    }

    private void loadForTeacher() {
        setRemoveUnnecessaryButtonForTeacher();
        switchPaneForTeacherStudent(1);
    }

    private void setRemoveUnnecessaryButtonForTeacher() {
        ObservableList<JFXButton> topNavToRemove = FXCollections.observableArrayList(
                mainController1.btnTopNavHome, mainController1.btnTopNavEnrolled, mainController1.btnTopNavContactUs);
        mainController1.flowPaneTopNav.getChildren().removeAll(topNavToRemove);
    }

    private void loadForStudent() {
        setRemoveUnnecessaryButtonForStudent();
        switchPaneForTeacherStudent(3);
    }

    private void setRemoveUnnecessaryButtonForStudent() {
        ObservableList<JFXButton> topNavToRemove = FXCollections.observableArrayList(
                mainController1.btnTopNavDashboard, mainController1.btnTopNavSections);
        mainController1.flowPaneTopNav.getChildren().removeAll(topNavToRemove);
    }


    public void switchPaneForTeacherStudent(int number) {
        switch (number) {
            case 1: // dashboard
                mainController1.anchorPaneTopNavDashboard.setVisible(true);
                mainController1.anchorPaneTopNavSections.setVisible(false);
                mainController1.anchorPaneTopNavHome.setVisible(false);
                mainController1.anchorPaneTopNavSchedule.setVisible(false);
                mainController1.anchorPaneTopNavEnrolled.setVisible(false);
                mainController1.anchorPaneTopNavContactUs.setVisible(false);

                mainController1.btnTopNavDashboard.setStyle(mainController1.styleTabSelected);
                mainController1.btnTopNavSections.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnTopNavHome.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnTopNavSchedule.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnTopNavEnrolled.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnTopNavContactUs.setStyle(mainController1.styleTabNotSelected);
                break;
            case 2: // sections
                mainController1.anchorPaneTopNavDashboard.setVisible(false);
                mainController1.anchorPaneTopNavSections.setVisible(true);
                mainController1.anchorPaneTopNavHome.setVisible(false);
                mainController1.anchorPaneTopNavSchedule.setVisible(false);
                mainController1.anchorPaneTopNavEnrolled.setVisible(false);
                mainController1.anchorPaneTopNavContactUs.setVisible(false);

                mainController1.btnTopNavDashboard.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnTopNavSections.setStyle(mainController1.styleTabSelected);
                mainController1.btnTopNavHome.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnTopNavSchedule.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnTopNavEnrolled.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnTopNavContactUs.setStyle(mainController1.styleTabNotSelected);
                break;
            case 3: // home
                mainController1.anchorPaneTopNavDashboard.setVisible(false);
                mainController1.anchorPaneTopNavSections.setVisible(false);
                mainController1.anchorPaneTopNavHome.setVisible(true);
                mainController1.anchorPaneTopNavSchedule.setVisible(false);
                mainController1.anchorPaneTopNavEnrolled.setVisible(false);
                mainController1.anchorPaneTopNavContactUs.setVisible(false);

                mainController1.btnTopNavDashboard.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnTopNavSections.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnTopNavHome.setStyle(mainController1.styleTabSelected);
                mainController1.btnTopNavSchedule.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnTopNavEnrolled.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnTopNavContactUs.setStyle(mainController1.styleTabNotSelected);
                break;
            case 4: // schedule
                mainController1.anchorPaneTopNavDashboard.setVisible(false);
                mainController1.anchorPaneTopNavSections.setVisible(false);
                mainController1.anchorPaneTopNavHome.setVisible(false);
                mainController1.anchorPaneTopNavSchedule.setVisible(true);
                mainController1.anchorPaneTopNavEnrolled.setVisible(false);
                mainController1.anchorPaneTopNavContactUs.setVisible(false);

                mainController1.btnTopNavDashboard.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnTopNavSections.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnTopNavHome.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnTopNavSchedule.setStyle(mainController1.styleTabSelected);
                mainController1.btnTopNavEnrolled.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnTopNavContactUs.setStyle(mainController1.styleTabNotSelected);
                break;
            case 5: // enrolled
                mainController1.anchorPaneTopNavDashboard.setVisible(false);
                mainController1.anchorPaneTopNavSections.setVisible(false);
                mainController1.anchorPaneTopNavHome.setVisible(false);
                mainController1.anchorPaneTopNavSchedule.setVisible(false);
                mainController1.anchorPaneTopNavEnrolled.setVisible(true);
                mainController1.anchorPaneTopNavContactUs.setVisible(false);

                mainController1.btnTopNavDashboard.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnTopNavSections.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnTopNavHome.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnTopNavSchedule.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnTopNavEnrolled.setStyle(mainController1.styleTabSelected);
                mainController1.btnTopNavContactUs.setStyle(mainController1.styleTabNotSelected);

                setStudentTeacherObservableLists();
                break;
            case 6: // contact us
                mainController1.anchorPaneTopNavDashboard.setVisible(false);
                mainController1.anchorPaneTopNavSections.setVisible(false);
                mainController1.anchorPaneTopNavHome.setVisible(false);
                mainController1.anchorPaneTopNavSchedule.setVisible(false);
                mainController1.anchorPaneTopNavEnrolled.setVisible(false);
                mainController1.anchorPaneTopNavContactUs.setVisible(true);

                mainController1.btnTopNavDashboard.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnTopNavSections.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnTopNavHome.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnTopNavSchedule.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnTopNavEnrolled.setStyle(mainController1.styleTabNotSelected);
                mainController1.btnTopNavContactUs.setStyle(mainController1.styleTabSelected);
                break;
        }
    }

    public void setMapView() {
        Platform.runLater(() -> {
            try {
                mainController1.vBoxMapAnchorPaneContactUs.getChildren().clear();
                MapView mapView = new MapView();
                mapView.setPrefSize(658, 335);
                mapView.addLayer(new CustomMapLayer());
                mapView.setZoom(16.5);
                mapView.setCenter(mainController1.mapPoint);
                mainController1.vBoxMapAnchorPaneContactUs.getChildren().add(mapView);
                VBox.setVgrow(mapView, Priority.ALWAYS);
            } catch (Exception e) {
                System.out.println("mapView Error");
            }
        });
    }
    private class CustomMapLayer extends MapLayer {
        private final Node marker;
        public CustomMapLayer() {
            marker = new Circle(7, Color.RED);
            getChildren().add(marker);
        }

        @Override
        protected void layoutLayer() {
            Point2D point = getMapPoint(mainController1.mapPoint.getLatitude(), mainController1.mapPoint.getLongitude());
            marker.setTranslateX(point.getX());
            marker.setTranslateY(point.getY());
        }
    }

    public void deleteAllStudent() {
        if (alertConfirmDelete1()) {
            if (alertConfirmDelete2()) {
                if (SQLDeleteAllStudent())
                    alertDeleteAllStudent();
                else
                    alertUnexpectedError();
            }
        }
    }

    public void openStudentInformation(String email, boolean isRegistration) {
        Thread threadEnrollment = new Thread(new Runnable() {
            @Override
            public void run() {

                Platform.runLater(() -> {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource(STUDENT_INFO_SCENE.getURL()));
                    Parent root = null;
                    try {
                        root = loader.load();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    studentInfoController studentInfoController = loader.getController();
                    studentInfoController.setRegistrationAndEmail(isRegistration, email);
                    stage.initModality(Modality.WINDOW_MODAL);
                    stage.initOwner(mainController1.anchorPaneCenter.getScene().getWindow());
                    stage.setTitle(TEACHER_CREDENTIALS_SCENE.getTitle());
                    stage.getIcons().add(new Image(String.valueOf(getClass().getResource(LOGO_IMAGE.getUrl()))));
                    stage.setResizable(false);
                    stage.setScene(scene);
                    stage.showAndWait();
                    System.out.println("Thread " + Thread.currentThread().getName() + " done.");

                    if (!isRegistration) {
                        setMISObservableLists();
                        mainController1.tableViewApplicantsAnchorPaneEnroll.refresh();
                        mainController1.tableViewEnrolledLeftNavAnchorPaneEnroll.refresh();
                        mainController1.tableViewDeclinedAnchorPaneEnroll.refresh();
                    }
                });
            }
        });
        threadEnrollment.start();
    }


    public void logOut() throws IOException {
        if (alertConfirmLogout()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(LOGIN_REGISTER_SCENE.getURL()));
            Parent root = loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setTitle(LOGIN_REGISTER_SCENE.getTitle());
            stage.getIcons().add(new Image(String.valueOf(getClass().getResource(LOGO_IMAGE.getUrl()))));
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();

            Stage thisStage = (Stage) mainController1.anchorPaneCenter.getScene().getWindow();
            thisStage.close();
        }
    }
}
