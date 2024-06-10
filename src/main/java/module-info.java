module com.oop.mahadi.demo4matrixoperation {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.oop.mahadi.demo4matrixoperation to javafx.fxml;
    exports com.oop.mahadi.demo4matrixoperation;
}