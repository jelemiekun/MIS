package com.example.emis.Controllers;

import com.gluonhq.maps.MapView;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

public class mainController {

    @FXML
    private AnchorPane anchorPaneCenter;

    @FXML
    private AnchorPane anchorPaneLeftNav;

    @FXML
    private AnchorPane anchorPaneLeftNavDashboard;

    @FXML
    private AnchorPane anchorPaneLeftNavEnroll;

    @FXML
    private AnchorPane anchorPaneLeftNavSection;

    @FXML
    private AnchorPane anchorPaneLeftNavStrand;

    @FXML
    private AnchorPane anchorPaneLeftNavTeachers;

    @FXML
    private AnchorPane anchorPaneTeacherDetails;

    @FXML
    private AnchorPane anchorPaneTopNavContactUs;

    @FXML
    private AnchorPane anchorPaneTopNavDashboard;

    @FXML
    private AnchorPane anchorPaneTopNavEnrolled;

    @FXML
    private AnchorPane anchorPaneTopNavHome;

    @FXML
    private AnchorPane anchorPaneTopNavSchedule;

    @FXML
    private AnchorPane anchorPaneTopNavSections;

    @FXML
    private JFXButton btnLeftNavApplicants;

    @FXML
    private JFXButton btnLeftNavDashboard;

    @FXML
    private JFXButton btnLeftNavSection;

    @FXML
    private JFXButton btnLeftNavStrand;

    @FXML
    private JFXButton btnLeftNavTeachers;

    @FXML
    private JFXButton btnSearchAnchorPaneEnrolledStudent1;

    @FXML
    private JFXButton btnTopNavContactUs;

    @FXML
    private JFXButton btnTopNavDashboard;

    @FXML
    private JFXButton btnTopNavEnrolled;

    @FXML
    private JFXButton btnTopNavHome;

    @FXML
    private JFXButton btnTopNavLogOut;

    @FXML
    private JFXButton btnTopNavSchedule;

    @FXML
    private JFXButton btnTopNavSections;

    @FXML
    private FlowPane flowPaneTopNav;

    @FXML
    private GridPane gridPaneScheduleAnchorPaneTopNavSchedule;

    @FXML
    private Label labelAnchorPaneAdminDashboardApplicants;

    @FXML
    private Label labelAnchorPaneAdminDashboardDeclined;

    @FXML
    private Label labelAnchorPaneAdminDashboardEnrolled;

    @FXML
    private Label labelAnchorPaneAdminDashboardSections;

    @FXML
    private Label labelAnchorPaneAdminDashboardStrands;

    @FXML
    private Label labelAnchorPaneAdminDashboardTeachers;

    @FXML
    private Label labelScheduleAnchorPaneTopNavSchedule;

    @FXML
    private Label labelSectionsHandlinganchorPaneTopNavDashboard;

    @FXML
    private Label labelStudentsHandlinganchorPaneTopNavDashboard;

    @FXML
    private Label labelTeacherDepartmentAnchorPaneTeacherDetails;

    @FXML
    private Label labelTeacherNameAnchorPaneTeacherDetails;

    @FXML
    private Label labelTeacherSchedule00;

    @FXML
    private Label labelTeacherSchedule01;

    @FXML
    private Label labelTeacherSchedule02;

    @FXML
    private Label labelTeacherSchedule03;

    @FXML
    private Label labelTeacherSchedule04;

    @FXML
    private Label labelTeacherSchedule05;

    @FXML
    private Label labelTeacherSchedule06;

    @FXML
    private Label labelTeacherSchedule10;

    @FXML
    private Label labelTeacherSchedule11;

    @FXML
    private Label labelTeacherSchedule12;

    @FXML
    private Label labelTeacherSchedule13;

    @FXML
    private Label labelTeacherSchedule14;

    @FXML
    private Label labelTeacherSchedule15;

    @FXML
    private Label labelTeacherSchedule16;

    @FXML
    private Label labelTeacherSchedule20;

    @FXML
    private Label labelTeacherSchedule21;

    @FXML
    private Label labelTeacherSchedule22;

    @FXML
    private Label labelTeacherSchedule23;

    @FXML
    private Label labelTeacherSchedule24;

    @FXML
    private Label labelTeacherSchedule25;

    @FXML
    private Label labelTeacherSchedule26;

    @FXML
    private Label labelTeacherSchedule30;

    @FXML
    private Label labelTeacherSchedule31;

    @FXML
    private Label labelTeacherSchedule32;

    @FXML
    private Label labelTeacherSchedule33;

    @FXML
    private Label labelTeacherSchedule34;

    @FXML
    private Label labelTeacherSchedule35;

    @FXML
    private Label labelTeacherSchedule36;

    @FXML
    private Label labelTeacherSchedule40;

    @FXML
    private Label labelTeacherSchedule41;

    @FXML
    private Label labelTeacherSchedule42;

    @FXML
    private Label labelTeacherSchedule43;

    @FXML
    private Label labelTeacherSchedule44;

    @FXML
    private Label labelTeacherSchedule45;

    @FXML
    private Label labelTeacherSchedule46;

    @FXML
    private MapView mapViewContactUs;

    @FXML
    private RowConstraints rowLastSchedule;

    @FXML
    private TableView<?> tableViewApplicantsAnchorPaneEnroll;

    @FXML
    private TableColumn<?, ?> tableViewApplicantsColumnDocumentStatusAnchorPaneEnroll;

    @FXML
    private TableColumn<?, ?> tableViewApplicantsColumnFullNameAnchorPaneEnroll;

    @FXML
    private TableView<?> tableViewDeclinedAnchorPaneEnroll;

    @FXML
    private TableColumn<?, ?> tableViewDeclinedColumnFullNameAnchorPaneEnroll;

    @FXML
    private TableView<?> tableViewEnrolledAnchorPaneEnroll;

    @FXML
    private TableColumn<?, ?> tableViewEnrolledColumnFullNameAnchorPaneEnroll;

    @FXML
    private TableView<?> tableViewEnrolledStudentAnchorPaneEnrolled;

    @FXML
    private TableColumn<?, ?> tableViewEnrolledStudentColumnFullNameAnchorPaneEnrolled;

    @FXML
    private TableColumn<?, ?> tableViewEnrolledStudentColumnSectionAnchorPaneEnrolled;

    @FXML
    private TableColumn<?, ?> tableViewEnrolledStudentColumnStrandAnchorPaneEnrolled;

    @FXML
    private TableView<?> tableViewSectionAnchorPaneAdmin;

    @FXML
    private TableColumn<?, ?> tableViewSectionColumnDeleteAnchorPaneAdmin;

    @FXML
    private TableColumn<?, ?> tableViewSectionColumnScheduleAnchorPaneAdmin;

    @FXML
    private TableColumn<?, ?> tableViewSectionColumnSectionHandlinganchorPaneTopNavSections;

    @FXML
    private TableColumn<?, ?> tableViewSectionColumnSectionNameAnchorPaneAdmin;

    @FXML
    private TableColumn<?, ?> tableViewSectionColumnStrandAnchorPaneAdmin;

    @FXML
    private TableColumn<?, ?> tableViewSectionColumnStrandHandlinganchorPaneTopNavSections;

    @FXML
    private TableView<?> tableViewSectionHandlinganchorPaneTopNavSections;

    @FXML
    private TableView<?> tableViewStrandAnchorPaneStrand;

    @FXML
    private TableColumn<?, ?> tableViewStrandColumnDeleteAnchorPaneStrand;

    @FXML
    private TableColumn<?, ?> tableViewStrandColumnStrandNameAnchorPaneStrand;

    @FXML
    private TableColumn<?, ?> tableViewStudentColumnAgeHandlinganchorPaneTopNavSections;

    @FXML
    private TableColumn<?, ?> tableViewStudentColumnBirthdateHandlinganchorPaneTopNavSections;

    @FXML
    private TableColumn<?, ?> tableViewStudentColumnEmailHandlinganchorPaneTopNavSections;

    @FXML
    private TableColumn<?, ?> tableViewStudentColumnFirstNameHandlinganchorPaneTopNavSections;

    @FXML
    private TableColumn<?, ?> tableViewStudentColumnLRNHandlinganchorPaneTopNavSections;

    @FXML
    private TableColumn<?, ?> tableViewStudentColumnLastNameHandlinganchorPaneTopNavSections;

    @FXML
    private TableColumn<?, ?> tableViewStudentColumnMiddleNameHandlinganchorPaneTopNavSections;

    @FXML
    private TableColumn<?, ?> tableViewStudentColumnPhoneNumberHandlinganchorPaneTopNavSections;

    @FXML
    private TableColumn<?, ?> tableViewStudentColumnSexHandlinganchorPaneTopNavSections;

    @FXML
    private TableView<?> tableViewStudentHandlinganchorPaneTopNavSections;

    @FXML
    private TableView<?> tableViewTeacherAnchorPaneTeachers;

    @FXML
    private TableColumn<?, ?> tableViewTeacherColumnDeleteAnchorPaneTeachers;

    @FXML
    private TableColumn<?, ?> tableViewTeacherColumnDepartmentAnchorPaneTeachers;

    @FXML
    private TableColumn<?, ?> tableViewTeacherColumnFullNameAnchorPaneTeachers;

    @FXML
    private TableColumn<?, ?> tableViewTeacherColumnScheduleAnchorPaneTeachers;

    @FXML
    private TextArea textAreaMessageAnchorPaneContactUs;

    @FXML
    private TextField textFieldEmailAddressAnchorPaneContactUs;

    @FXML
    private TextField textFieldFullNameAnchorPaneContactUs;

    @FXML
    private TextField textFieldSearchSectionNameAnchorPaneEnrolledStudent;

    @FXML
    private TextField textFieldSearchStudentNameAnchorPaneEnrolledStudent;

    @FXML
    private TextField textFieldSearchStudentNameAnchorPaneEnrolledStudent1;

    @FXML
    private VBox vBoxMapAnchorPaneContactUs;

    @FXML
    void anchorPaneRequestFocus(MouseEvent event) {

    }

    @FXML
    void anchorPaneTopNavContactUsRequestFocus(MouseEvent event) {

    }

    @FXML
    void anchorPaneTopNavDashboardRequestFocus(MouseEvent event) {

    }

    @FXML
    void anchorPaneTopNavEnrolledRequestFocus(MouseEvent event) {

    }

    @FXML
    void anchorPaneTopNavHomeRequestFocus(MouseEvent event) {

    }

    @FXML
    void anchorPaneTopNavScheduleRequestFocus(MouseEvent event) {

    }

    @FXML
    void anchorPaneTopNavSectionsRequestFocus(MouseEvent event) {

    }

    @FXML
    void btnAddSectionAnchorPaneTeacherOnAction(ActionEvent event) {

    }

    @FXML
    void btnAddStrandAnchorPaneTeacherOnAction(ActionEvent event) {

    }

    @FXML
    void btnAddTeacherAnchorPaneTeacherOnAction(ActionEvent event) {

    }

    @FXML
    void btnEnrollNowanchorPaneTopNavDashboardOnAction(ActionEvent event) {

    }

    @FXML
    void btnLeftNavApplicantsOnAction(ActionEvent event) {

    }

    @FXML
    void btnLeftNavDashboardOnAction(ActionEvent event) {

    }

    @FXML
    void btnLeftNavSectionOnAction(ActionEvent event) {

    }

    @FXML
    void btnLeftNavStrandOnAction(ActionEvent event) {

    }

    @FXML
    void btnLeftNavTeachersOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchAnchorPaneEnrolledStudentOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchAnchorPaneSectionNameOnAction(ActionEvent event) {

    }

    @FXML
    void btnSubmitAnchorPaneContactUsOnAction(ActionEvent event) {

    }

    @FXML
    void btnTopNavContactUsOnAction(ActionEvent event) {

    }

    @FXML
    void btnTopNavDashboardOnAction(ActionEvent event) {

    }

    @FXML
    void btnTopNavEnrolledOnAction(ActionEvent event) {

    }

    @FXML
    void btnTopNavHomeOnAction(ActionEvent event) {

    }

    @FXML
    void btnTopNavLogOutOnAction(ActionEvent event) {

    }

    @FXML
    void btnTopNavScheduleOnAction(ActionEvent event) {

    }

    @FXML
    void btnTopNavSectionsOnAction(ActionEvent event) {

    }

    @FXML
    void tableViewApplicantsAnchorPaneEnrollDoubleClicked(MouseEvent event) {

    }

    @FXML
    void tableViewDeclinedAnchorPaneEnrollDoubleClicked(MouseEvent event) {

    }

    @FXML
    void tableViewEnrolledAnchorPaneEnrollDoubleClicked(MouseEvent event) {

    }

    @FXML
    void tableViewSectionHandlinganchorPaneTopNavSectionsSingleClicked(MouseEvent event) {

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

}
