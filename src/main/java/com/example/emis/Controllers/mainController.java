package com.example.emis.Controllers;

import com.example.emis.Models.mainModel;
import com.example.emis.Objects.Student;
import com.gluonhq.maps.MapPoint;
import com.jfoenix.controls.JFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class mainController implements Initializable {
    public MapPoint mapPoint = new MapPoint(14.56830,121.07535);

    public String emailUsing = "";

    public String styleTabSelected = "-fx-background-color: #1172e1;";
    public String styleTabNotSelected = "-fx-background-color:  #0A53B0";

    private mainModel mainModel1;
    // Anchor Panes
    public AnchorPane anchorPaneCenter;
    public AnchorPane anchorPaneLeftNav;
    public AnchorPane anchorPaneLeftNavDashboard;
    public AnchorPane anchorPaneLeftNavEnroll;
    public AnchorPane anchorPaneLeftNavSection;
    public AnchorPane anchorPaneLeftNavContactUsDetails;
    public AnchorPane anchorPaneLeftNavStrand;
    public AnchorPane anchorPaneLeftNavTeachers;
    public AnchorPane anchorPaneTeacherDetails;
    public AnchorPane anchorPaneTopNavContactUs;
    public AnchorPane anchorPaneTopNavDashboard;
    public AnchorPane anchorPaneTopNavEnrolled;
    public AnchorPane anchorPaneTopNavHome;
    public AnchorPane anchorPaneTopNavSchedule;
    public AnchorPane anchorPaneTopNavSections;

    // Buttons
    public JFXButton btnLeftNavApplicants;
    public JFXButton btnLeftNavContactUs;
    public JFXButton btnLeftNavDashboard;
    public JFXButton btnLeftNavSection;
    public JFXButton btnLeftNavStrand;
    public JFXButton btnLeftNavTeachers;
    public JFXButton btnSearchAnchorPaneEnrolledStudent1;
    public JFXButton btnTopNavContactUs;
    public JFXButton btnTopNavDashboard;
    public JFXButton btnTopNavEnrolled;
    public JFXButton btnTopNavHome;
    public JFXButton btnTopNavLogOut;
    public JFXButton btnTopNavSchedule;
    public JFXButton btnTopNavSections;

    // Flow Pane
    public FlowPane flowPaneTopNav;

    // Grid Pane
    public GridPane gridPaneScheduleAnchorPaneTopNavSchedule;

    // Labels
    public Label labelAnchorPaneAdminDashboardApplicants;
    public Label labelAnchorPaneAdminDashboardDeclined;
    public Label labelAnchorPaneAdminDashboardEnrolled;
    public Label labelAnchorPaneAdminDashboardSections;
    public Label labelAnchorPaneAdminDashboardStrands;
    public Label labelAnchorPaneAdminDashboardTeachers;
    public Label labelContactUsEmailAddress;
    public Label labelContactUsLocation;
    public Label labelContactUsPhone;
    public Label labelScheduleAnchorPaneTopNavSchedule;
    public Label labelSectionsHandlingAnchorPaneTopNavDashboard;
    public Label labelStudentsHandlingAnchorPaneTopNavDashboard;
    public Label labelTeacherDepartmentAnchorPaneTeacherDetails;
    public Label labelTeacherNameAnchorPaneTeacherDetails;
    public Label labelTeacherSchedule00;
    public Label labelTeacherSchedule01;
    public Label labelTeacherSchedule02;
    public Label labelTeacherSchedule03;
    public Label labelTeacherSchedule04;
    public Label labelTeacherSchedule05;
    public Label labelTeacherSchedule06;
    public Label labelTeacherSchedule10;
    public Label labelTeacherSchedule11;
    public Label labelTeacherSchedule12;
    public Label labelTeacherSchedule13;
    public Label labelTeacherSchedule14;
    public Label labelTeacherSchedule15;
    public Label labelTeacherSchedule16;
    public Label labelTeacherSchedule20;
    public Label labelTeacherSchedule21;
    public Label labelTeacherSchedule22;
    public Label labelTeacherSchedule23;
    public Label labelTeacherSchedule24;
    public Label labelTeacherSchedule25;
    public Label labelTeacherSchedule26;
    public Label labelTeacherSchedule30;
    public Label labelTeacherSchedule31;
    public Label labelTeacherSchedule32;
    public Label labelTeacherSchedule33;
    public Label labelTeacherSchedule34;
    public Label labelTeacherSchedule35;
    public Label labelTeacherSchedule36;
    public Label labelTeacherSchedule40;
    public Label labelTeacherSchedule41;
    public Label labelTeacherSchedule42;
    public Label labelTeacherSchedule43;
    public Label labelTeacherSchedule44;
    public Label labelTeacherSchedule45;
    public Label labelTeacherSchedule46;

    // Row Constraints
    public RowConstraints rowLastSchedule;

    // ObservableLists
    public ObservableList<Student> observableListAllApplicants = FXCollections.observableArrayList();
    public ObservableList<Student> observableListTableViewApplicantsAnchorPaneEnroll = FXCollections.observableArrayList();
    public ObservableList<Student> observableListTableViewEnrolledLeftNavAnchorPaneEnroll = FXCollections.observableArrayList();
    public ObservableList<Student> observableListTableViewDeclinedAnchorPaneEnroll = FXCollections.observableArrayList();
    public ObservableList<Student> observableListTableViewEnrolledStudentTopNavAnchorPaneEnrolled = FXCollections.observableArrayList();

    // TableViews
    public TableView<Student> tableViewApplicantsAnchorPaneEnroll;
    public TableView<Student> tableViewEnrolledLeftNavAnchorPaneEnroll;
    public TableView<Student> tableViewDeclinedAnchorPaneEnroll;
    public TableView<Student> tableViewEnrolledStudentTopNavAnchorPaneEnrolled;


    public TableView<?> tableViewSectionAnchorPaneAdmin;
    public TableView<?> tableViewSectionHandlingAnchorPaneTopNavSections;
    public TableView<?> tableViewStrandAnchorPaneStrand;
    public TableView<?> tableViewStudentHandlingAnchorPaneTopNavSections;
    public TableView<?> tableViewTeacherAnchorPaneTeachers;

    // TableColumns
    public TableColumn<Student, String> tableViewApplicantsColumnDocumentStatusAnchorPaneEnroll;
    public TableColumn<Student, String> tableViewApplicantsColumnFullNameAnchorPaneEnroll;



    public TableColumn<Student, String> tableViewEnrolledLeftNavColumnFullNameAnchorPaneEnroll;

    public TableColumn<Student, String> tableViewDeclinedColumnFullNameAnchorPaneEnroll;


    public TableColumn<Student, String> tableViewEnrolledStudentColumnFullNameAnchorPaneEnrolled;
    public TableColumn<Student, String> tableViewEnrolledStudentColumnSectionAnchorPaneEnrolled;
    public TableColumn<Student, String> tableViewEnrolledStudentColumnStrandAnchorPaneEnrolled;





    public TableColumn<?, ?> tableViewSectionColumnDeleteAnchorPaneAdmin;
    public TableColumn<?, ?> tableViewSectionColumnScheduleAnchorPaneAdmin;
    public TableColumn<?, ?> tableViewSectionColumnSectionHandlingAnchorPaneTopNavSections;
    public TableColumn<?, ?> tableViewSectionColumnSectionNameAnchorPaneAdmin;
    public TableColumn<?, ?> tableViewSectionColumnStrandAnchorPaneAdmin;
    public TableColumn<?, ?> tableViewSectionColumnStrandHandlingAnchorPaneTopNavSections;
    public TableColumn<?, ?> tableViewStrandColumnDeleteAnchorPaneStrand;
    public TableColumn<?, ?> tableViewStrandColumnStrandNameAnchorPaneStrand;
    public TableColumn<?, ?> tableViewStudentColumnAgeHandlingAnchorPaneTopNavSections;
    public TableColumn<?, ?> tableViewStudentColumnBirthdateHandlingAnchorPaneTopNavSections;
    public TableColumn<?, ?> tableViewStudentColumnEmailHandlingAnchorPaneTopNavSections;
    public TableColumn<?, ?> tableViewStudentColumnFirstNameHandlingAnchorPaneTopNavSections;
    public TableColumn<?, ?> tableViewStudentColumnLRNHandlingAnchorPaneTopNavSections;
    public TableColumn<?, ?> tableViewStudentColumnLastNameHandlingAnchorPaneTopNavSections;
    public TableColumn<?, ?> tableViewStudentColumnMiddleNameHandlingAnchorPaneTopNavSections;
    public TableColumn<?, ?> tableViewStudentColumnPhoneNumberHandlingAnchorPaneTopNavSections;
    public TableColumn<?, ?> tableViewStudentColumnSexHandlingAnchorPaneTopNavSections;
    public TableColumn<?, ?> tableViewTeacherColumnDeleteAnchorPaneTeachers;
    public TableColumn<?, ?> tableViewTeacherColumnDepartmentAnchorPaneTeachers;
    public TableColumn<?, ?> tableViewTeacherColumnFullNameAnchorPaneTeachers;
    public TableColumn<?, ?> tableViewTeacherColumnScheduleAnchorPaneTeachers;

    // TextArea
    public TextArea textAreaMessageAnchorPaneContactUs;

    // MFXTextField
    public MFXTextField textFieldContactEmailAddress;
    public MFXTextField textFieldContactLocation;
    public MFXTextField textFieldContactNumber;

    // TextField
    public TextField textFieldEmailAddressAnchorPaneContactUs;
    public TextField textFieldFullNameAnchorPaneContactUs;
    public TextField textFieldSearchSectionNameAnchorPaneEnrolledStudent;
    public TextField textFieldSearchStudentNameAnchorPaneEnrolledStudent;
    public TextField textFieldSearchStudentNameAnchorPaneEnrolledStudent1;

    // VBox
    public VBox vBoxMapAnchorPaneContactUs;
    @FXML
    void anchorPaneRequestFocus() {
        anchorPaneCenter.requestFocus();
    }

    @FXML
    void anchorPaneTopNavContactUsRequestFocus() {
        anchorPaneTopNavContactUs.requestFocus();
    }

    @FXML
    void anchorPaneTopNavDashboardRequestFocus() {
        anchorPaneTopNavDashboard.requestFocus();
    }

    @FXML
    void anchorPaneTopNavEnrolledRequestFocus() {
        anchorPaneTopNavEnrolled.requestFocus();
    }

    @FXML
    void anchorPaneTopNavHomeRequestFocus() {
        anchorPaneTopNavHome.requestFocus();
    }

    @FXML
    void anchorPaneTopNavScheduleRequestFocus() {
        anchorPaneTopNavSchedule.requestFocus();
    }

    @FXML
    void anchorPaneTopNavSectionsRequestFocus() {
        anchorPaneTopNavSections.requestFocus();
    }

    @FXML
    void btnLeftNavDashboardOnAction() {
        mainModel1.switchTabForMIS(1);
    }

    @FXML
    void btnLeftNavApplicantsOnAction() {
        mainModel1.switchTabForMIS(2);
    }

    @FXML
    void btnLeftNavTeachersOnAction() {
        mainModel1.switchTabForMIS(3);
    }

    @FXML
    void btnLeftNavStrandOnAction() {
        mainModel1.switchTabForMIS(4);
    }

    @FXML
    void btnLeftNavSectionOnAction() {
        mainModel1.switchTabForMIS(5);
    }

    @FXML
    void btnLeftNavContactUsOnAction() {
        mainModel1.switchTabForMIS(6);
    }

    @FXML
    void btnTopNavDashboardOnAction() {
        mainModel1.switchPaneForTeacherStudent(1);
    }

    @FXML
    void btnTopNavSectionsOnAction() {
        mainModel1.switchPaneForTeacherStudent(2);
    }

    @FXML
    void btnTopNavHomeOnAction() {
        mainModel1.switchPaneForTeacherStudent(3);
    }

    @FXML
    void btnTopNavScheduleOnAction() {
        mainModel1.switchPaneForTeacherStudent(4);
    }

    @FXML
    void btnTopNavEnrolledOnAction() {
        mainModel1.switchPaneForTeacherStudent(5);
    }

    @FXML
    void btnTopNavContactUsOnAction() {
        mainModel1.switchPaneForTeacherStudent(6);
    }

    @FXML
    void btnTopNavLogOutOnAction() throws IOException {
        mainModel1.logOut();
    }


    @FXML
    void btnAddSectionAnchorPaneTeacherOnAction() {

    }

    @FXML
    void btnAddStrandAnchorPaneTeacherOnAction() {

    }

    @FXML
    void btnAddTeacherAnchorPaneTeacherOnAction() {

    }

    @FXML
    void btnContactSaveChangesOnAction() {

    }

    @FXML
    void btnEnrollNowAnchorPaneTopNavDashboardOnAction() throws InterruptedException {
        mainModel1.openStudentInformation(emailUsing, true);
    }

    @FXML
    void btnSearchAnchorPaneEnrolledStudentOnAction() {

    }

    @FXML
    void btnSearchAnchorPaneSectionNameOnAction() {

    }

    @FXML
    void btnSubmitAnchorPaneContactUsOnAction() {

    }

    @FXML
    void tableViewApplicantsAnchorPaneEnrollDoubleClicked(MouseEvent event) {
        if (event.getClickCount() == 2) {
            Student selectedStudent = tableViewApplicantsAnchorPaneEnroll.getSelectionModel().getSelectedItem();
            if (selectedStudent != null) {
                mainModel1.openStudentInformation(selectedStudent.getEmail(), false);
            }
        }
    }

    @FXML
    void tableViewDeclinedAnchorPaneEnrollDoubleClicked(MouseEvent event) {
        if (event.getClickCount() == 2) {
            Student selectedStudent = tableViewDeclinedAnchorPaneEnroll.getSelectionModel().getSelectedItem();
            if (selectedStudent != null) {
                mainModel1.openStudentInformation(selectedStudent.getEmail(), false);
            }
        }
    }

    @FXML
    void tableViewEnrolledLeftNavAnchorPaneEnrollDoubleClicked(MouseEvent event) {
        if (event.getClickCount() == 2) {
            Student selectedStudent = tableViewEnrolledLeftNavAnchorPaneEnroll.getSelectionModel().getSelectedItem();
            if (selectedStudent != null) {
                mainModel1.openStudentInformation(selectedStudent.getEmail(), false);
            }
        }
    }

    @FXML
    void tableViewSectionHandlingAnchorPaneTopNavSectionsSingleClicked(MouseEvent event) {

    }

    @FXML
    void tableViewTeacherAnchorPaneTeachersDoubleClicked(MouseEvent event) {

    }

    @FXML
    void textFieldAnchorPaneContactUsPressedEnter(KeyEvent event) {

    }

    @FXML
    void textFieldSearchSectionNameAnchorPaneEnrolledStudentPressedEnter(KeyEvent event) {

    }

    @FXML
    void textFieldSearchStudentNameAnchorPaneEnrolledStudentPressedEnter(KeyEvent event) {

    }

    @FXML
    void btnDeleteAllStudentOnAction() {
        mainModel1.deleteAllStudent();
    }

    void setEmailUsing(String emailUsing) {
        this.emailUsing = emailUsing;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> {
            mainModel1 = new mainModel();
            mainModel1.setMainController1(this);
            mainModel1.whatRole();

            anchorPaneRequestFocus();
        });
    }
}
