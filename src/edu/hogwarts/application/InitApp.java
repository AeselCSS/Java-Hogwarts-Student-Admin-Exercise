package edu.hogwarts.application;

import edu.hogwarts.controller.StudentController;
import edu.hogwarts.controller.TeacherController;
import edu.hogwarts.ui.UserInterface;

public class InitApp {
    private final StudentController studentController = new StudentController();
    private final TeacherController teacherController = new TeacherController();

    public void initApp() {
        // === Create test data ===
        InitData initData = new InitData(studentController, teacherController);
        initData.initData();

        // === initialize the user interface ===
        UserInterface ui = new UserInterface(studentController, teacherController);
        ui.initUI();

    }
}
