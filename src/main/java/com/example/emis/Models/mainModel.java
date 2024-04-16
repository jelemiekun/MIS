package com.example.emis.Models;

import com.example.emis.Controllers.mainController;
import com.gluonhq.maps.MapLayer;
import com.gluonhq.maps.MapPoint;
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
import javafx.scene.image.Image;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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

        if (role.equals(MIS_ROLE_ENUM.getRole())) {
            loadForMIS();
        } else if (role.equals(TEACHER_ROLE_ENUM.getRole())) {
            loadForTeacher();
        } else if (role.equals(STUDENT_ROLE_ENUM.getRole())) {
            loadForStudent();
        }

        if (!role.equals(MIS_ROLE_ENUM.getRole()))
            setMapView();
    }

    private void loadForMIS() {
        setRemoveUnnecessaryButtonForMis();
        switchTabForMIS(1);
    }

    private void setRemoveUnnecessaryButtonForMis() {
        ObservableList<JFXButton> topNavToRemove = FXCollections.observableArrayList(
                mainController1.btnTopNavDashboard, mainController1.btnTopNavSections, mainController1.btnTopNavHome, mainController1.btnTopNavSchedule, mainController1.btnTopNavEnrolled, mainController1.btnTopNavContactUs);
        mainController1.flowPaneTopNav.getChildren().removeAll(topNavToRemove);
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
