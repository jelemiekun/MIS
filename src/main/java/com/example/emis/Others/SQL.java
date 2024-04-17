package com.example.emis.Others;

import com.example.emis.Objects.Student;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import static com.example.emis.Enums.SQLRolesEnum.*;
import static com.example.emis.Others.Alerts.*;

public class SQL {
    private static final String key = "yrGrat07BQbk1OISHESH9mHjp8oCPmGx";
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource dataSource;
    private static String url = "jdbc:mysql://localhost:3306/enrollment_system";
    private static String user = "root";
    private static String password = "admin";

    public static void SQLCreateConnection() {
        config.setJdbcUrl(url);
        config.setUsername(user);
        config.setPassword(password);
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        config.setMaximumPoolSize(20);
        config.setConnectionTimeout(30000); // 30 seconds
        config.setIdleTimeout(600000); // 10 minutes
        config.setMaxLifetime(1800000); // 30 minutes
        dataSource = new HikariDataSource(config);
    }

    public static String encryptString(String input) {
        // encrypted password for admin = NGtfAJPLaJACyajHXvBM6A==
        try {
            SecretKey secretKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(input.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            alertUnexpectedError();
            return null;
        }
    }

    public static String decryptString(String encryptedInput) {
        try {
            SecretKey secretKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedInput));
            return new String(decryptedBytes);
        } catch (Exception e) {
            alertUnexpectedError();
            return null;
        }
    }


    public static boolean SQLLogin(String email, String password) {
        String query = "SELECT password FROM login_register WHERE email = ?";

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String decryptPassword = decryptString(resultSet.getString("password"));
                    return password.equals(decryptPassword);
                }
            }
        } catch (SQLException e) {
            alertNoConnection();
        }
        return false;
    }

    public static String SQLWhatRole(String email) {
        String query = "SELECT role FROM login_register WHERE email = ?";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next())
                    return resultSet.getString("role");
            }
        } catch (SQLException e) {
            alertNoConnection();
            throw new RuntimeException(e);
        }
        return null;
    }

    public static boolean SQLIsEmailDuplicate(String email) {
        String query = "SELECT email FROM login_register where EMAIL = ?";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            alertNoConnection();
            throw new RuntimeException(e);
        }
    }

    public static boolean SQLRegisterStudent(String email, String password) {
        boolean studentInRegisterSuccess = SQLRegisterStudentInLoginRegister(email, password);
        boolean studentInStudentSuccess = SQLRegisterStudentInStudent(email, password);

        return studentInRegisterSuccess && studentInStudentSuccess;
    }

    private static boolean SQLRegisterStudentInLoginRegister(String email, String password) {
        String query = "INSERT INTO login_register(email, password, role) values (?, ?, ?);";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString( 2, encryptString(password));
            preparedStatement.setString(3, STUDENT_ROLE_ENUM.getRole());

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Query OK, " + rowsAffected + " rows affected.");
            return true;
        } catch (SQLException e) {
            alertNoConnection();
            throw new RuntimeException(e);
        }
    }

    private static boolean SQLRegisterStudentInStudent(String email, String password) {
        String query = "INSERT INTO student(email, password) values (?, ?);";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Query OK, " + rowsAffected + " rows affected.");
            return true;
        } catch (SQLException e) {
            alertNoConnection();
            throw new RuntimeException(e);
        }
    }

    public static boolean SQLSubmitApplication(String email, String[] data) {
        String query = "UPDATE student SET LRN = ?, last_name = ?, first_name = ?, middle_name = ?, birthdate = ?, " +
                "age = ?, sex = ?, civil_status = ?, religion = ?, citizenship = ?, phone = ?, " +
                "home_address = ?, provincial_address = ?, " +
                "first_choice = ?, second_choice = ?, " +
                "elem_school = ?, elem_school_address = ?, elem_SY = ?, " +
                "junior_hs = ?, junior_hs_address = ?, junior_hs_SY = ?, " +
                "document_status = ?, form_137 = ?, form_138 = ?, good_moral = ?, " +
                "is_applied = true WHERE email = ?";

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,data[0]);
            preparedStatement.setString(2,data[1]);
            preparedStatement.setString(3,data[2]);
            preparedStatement.setString(4,data[3]);
            preparedStatement.setDate(5, Date.valueOf(data[4]));
            preparedStatement.setInt(6, Integer.parseInt(data[5]));
            preparedStatement.setString(7,data[6]);
            preparedStatement.setString(8,data[7]);
            preparedStatement.setString(9,data[8]);
            preparedStatement.setString(10,data[9]);
            preparedStatement.setString(11,data[10]);
            preparedStatement.setString(12,data[11]);
            preparedStatement.setString(13,data[12]);
            preparedStatement.setString(14,data[13]);
            preparedStatement.setString(15,data[14]);
            preparedStatement.setString(16,data[15]);
            preparedStatement.setString(17,data[16]);
            preparedStatement.setString(18,data[17]);
            preparedStatement.setString(19,data[18]);
            preparedStatement.setString(20,data[19]);
            preparedStatement.setString(21,data[20]);
            preparedStatement.setString(22,data[21]);
            preparedStatement.setBoolean(23, Boolean.parseBoolean(data[22]));
            preparedStatement.setBoolean(24, Boolean.parseBoolean(data[23]));
            preparedStatement.setBoolean(25, Boolean.parseBoolean(data[24]));
            preparedStatement.setString(26, email);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Query OK, " + rowsAffected + " rows affected.");
            return true;
        } catch (SQLException e) {
            alertNoConnection();
            return false;
        }
    }

    public static ObservableList<String> SQLGetStrands() {
        String query = "SELECT strand_name FROM strand";

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            ObservableList<String> strands = FXCollections.observableArrayList();

            while (resultSet.next()) {
                strands.add(resultSet.getString("strand_name"));
            }

            return strands;
        } catch (SQLException e) {
            alertNoConnection();
            return null;
        }
    }

    public static boolean SQLIsApplied(String email) {
        String query = "SELECT is_applied FROM student WHERE email = ?";

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next())
                return resultSet.getInt("is_applied") == 1;
            else
                return false;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            alertNoConnection();
            return false;
        }
    }

    public static boolean SQLDeleteAllStudent() {
        return SQLDeleteAllStudentFromStudent() && SQLDeleteAllStudentFromLoginRegister();
    }

    private static boolean SQLDeleteAllStudentFromStudent() {
        String query = "DELETE FROM student;";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Query OK, " + rowsAffected + " rows affected.");
            return true;
        } catch (SQLException e) {
            alertNoConnection();
            return false;
        }
    }

    private static boolean SQLDeleteAllStudentFromLoginRegister() {
        String query = "DELETE FROM login_register WHERE role = 'student';";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Query OK, " + rowsAffected + " rows affected.");
            return true;
        } catch (SQLException e) {
            alertNoConnection();
            return false;
        }
    }

    public static Student SQLGetStudentData(String emailUsing) {
        String query = "SELECT LRN, email, last_name, first_name, middle_name, birthdate, age, sex, civil_status, religion, citizenship, phone, home_address, provincial_address, first_choice, second_choice, elem_school, elem_school_address, elem_SY, junior_hs, junior_hs_address, junior_hs_SY, form_137, form_138, good_moral FROM student WHERE email = ?";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, emailUsing);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String LRN = resultSet.getString("LRN");
                String email = resultSet.getString("email");
                String lastName = resultSet.getString("last_name");
                String firstName = resultSet.getString("first_name");
                String middleName = resultSet.getString("middle_name");
                LocalDate birthdate = resultSet.getDate("birthdate").toLocalDate();
                int age = resultSet.getInt("age");
                String sex = resultSet.getString("sex");
                String civilStatus = resultSet.getString("civil_status");
                String religion = resultSet.getString("religion");
                String citizenship = resultSet.getString("citizenship");
                String phone = resultSet.getString("phone");
                String homeAddress = resultSet.getString("home_address");
                String provincialAddress = resultSet.getString("provincial_address");
                String firstChoice = resultSet.getString("first_choice");
                String secondChoice = resultSet.getString("second_choice");
                String elemSchool = resultSet.getString("elem_school");
                String elemSchoolAddress = resultSet.getString("elem_school_address");
                String elemSchoolSY = resultSet.getString("elem_SY");
                String juniorHS = resultSet.getString("junior_hs");
                String juniorHSAddress = resultSet.getString("junior_hs_address");
                String juniorHSSY = resultSet.getString("junior_hs_SY");
                boolean form137 = resultSet.getInt("form_137") == 1;
                boolean form138 = resultSet.getInt("form_138") == 1;
                boolean goodMoral = resultSet.getInt("good_moral") == 1;

                return new Student(LRN, email, lastName, firstName, middleName, birthdate, age, sex, civilStatus, religion, citizenship, phone, homeAddress, provincialAddress, firstChoice, secondChoice, elemSchool, elemSchoolAddress, elemSchoolSY, juniorHS, juniorHSAddress, juniorHSSY, form137, form138, goodMoral);
            }
        } catch (SQLException e) {
            alertNoConnection();
        }
        return null;
    }

    public static boolean[] SQLGetProcessedAndEnrolledBoolean(String email) {
        String query = "SELECT is_admission_processed, is_enrolled FROM student WHERE email = ?";
        boolean[] result = new boolean[2];

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                result[0] = resultSet.getInt("is_admission_processed") == 1;
                result[1] = resultSet.getInt("is_enrolled") == 1;
            } else {
                return null;
            }
        } catch (SQLException e) {
            alertNoConnection();
            return null;
        }
        return result;
    }

    public static ObservableList<Student> SQLPopulateStudentObservableList() {
        String query = "SELECT email, last_name, first_name, middle_name, document_status, is_applied, is_admission_processed, is_enrolled FROM student;";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            ObservableList<Student> allStudent = FXCollections.observableArrayList();

            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String lastName = resultSet.getString("last_name");
                String firstName = resultSet.getString("first_name");
                String middleName = resultSet.getString("middle_name");
                String documentStatus = resultSet.getString("document_status");
                boolean isApplied = resultSet.getInt("is_applied") == 1;
                boolean isAdmissionProcessed = resultSet.getInt("is_admission_processed") == 1;
                boolean isEnrolled = resultSet.getInt("is_enrolled") == 1;

                allStudent.add(new Student(email, lastName, firstName, middleName, documentStatus, isApplied, isAdmissionProcessed, isEnrolled));
            }
            return allStudent;
        } catch (SQLException e) {
            alertNoConnection();
            throw new RuntimeException(e);
        }
    }

    public static ObservableList<Student> SQLPopulateTopNavEnrolledStudentObservableList() {
        String query = "SELECT last_name, first_name, middle_name, strand, section FROM student WHERE is_applied = 1 AND is_admission_processed = 1 AND is_enrolled = 1;";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            ObservableList<Student> allStudent = FXCollections.observableArrayList();

            while (resultSet.next()) {
                String lastName = resultSet.getString("last_name");
                String firstName = resultSet.getString("first_name");
                String middleName = resultSet.getString("middle_name");
                String strand = resultSet.getString("strand");
                String section = resultSet.getString("section");

                if (strand == null)
                    strand = "TBA";

                if (section == null)
                    section = "TBA";

                allStudent.add(new Student(lastName, firstName, middleName, strand, section));
            }
            return allStudent;
        } catch (SQLException e) {
            alertNoConnection();
            throw new RuntimeException(e);
        }
    }

    public static boolean SQLAcceptStudentApplication(String email) {
        String query = "UPDATE student SET is_admission_processed = 1, is_enrolled = 1 WHERE email = ?";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Query OK, " + rowsAffected + " rows affected.");
            return true;
        } catch (SQLException e) {
            alertNoConnection();
            throw new RuntimeException(e);
        }
    }

    public static boolean SQLDeclineStudentApplication(String email) {
        String query = "UPDATE student SET is_admission_processed = 1, is_enrolled = 0 WHERE email = ?";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Query OK, " + rowsAffected + " rows affected.");
            return true;
        } catch (SQLException e) {
            alertNoConnection();
            throw new RuntimeException(e);
        }
    }
}
