import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ToDoList extends Application {
  // A list to store the tasks that have been added
  private List<Task> tasks = new ArrayList<>();

  // A vertical box to hold the task list
  private VBox taskListBox = new VBox(10);

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
    // Create the main window
    stage.setTitle("To Do List");

    // Create the title page
    Text titlePage = new Text("To Do List");
    titlePage.setStyle("-fx-font-size: 24px;");

    // Create the input section
    Label taskLabel = new Label("Task name:");
    TextField taskField = new TextField();

    Label hoursLabel = new Label("Hours:");
    ChoiceBox<Integer> hoursBox = new ChoiceBox<>();
    for (int i = 1; i <= 5; i++) {
      hoursBox.getItems().add(i);
    }
    hoursBox.setValue(1);

    Label typeLabel = new Label("Type:");
    ChoiceBox<String> typeBox = new ChoiceBox<>();
    typeBox.getItems().addAll("Study", "Shop", "Cook", "Sleep");
    typeBox.setValue("Study");

    // Create the "Enqueue" button
    Button enqueueButton = new Button("Enqueue");
    enqueueButton.setOnAction(event -> {
      // When the "Enqueue" button is clicked, add the task to the list
      String taskName = taskField.getText();
      int hours = hoursBox.getValue();
      String type = typeBox.getValue();
      tasks.add(new Task(taskName, hours, type));
      // Clear the input fields
      taskField.clear();
      hoursBox.setValue(1);
      typeBox.setValue("Study");

      // Update the task list
      updateTaskList();
    });

    // Create the "Dequeue" button
    Button dequeueButton = new Button("Dequeue");
    dequeueButton.setOnAction(event -> {
      // When the "Dequeue" button is clicked, remove the oldest task from the list
      if (!tasks.isEmpty()) {
        tasks.remove(0);
        updateTaskList();
      }
    });

    // Put the input section, the "Enqueue" button, and the "Dequeue" button in a horizontal box
    HBox inputBox = new HBox(10);
    inputBox.setPadding(new Insets(10, 10, 10, 10));
    inputBox.setAlignment(Pos.CENTER_LEFT);
    inputBox.getChildren().addAll(taskLabel, taskField, hoursLabel, hoursBox, typeLabel, typeBox, enqueueButton, dequeueButton);

    // Create the scrollable task list
    ScrollPane taskListPane = new ScrollPane();
    taskListPane.setFitToWidth(true);
    taskListPane.setContent(taskListBox);

    // Create a label to show the number of tasks remaining and completed
    Label tasksLabel = new Label();
    updateTasksLabel(tasksLabel);

    // Put the title page, the input section, the task list, and the tasks label in a vertical box
    VBox root = new VBox(20);
    root.setPadding(new Insets(20, 20, 20, 20));
    root.getChildren().addAll(titlePage, inputBox, taskListPane, tasksLabel);

    // Show the window
    stage.setScene(new Scene(root));
    stage.show();
  }

     // Updates the task list by adding a new task to the bottom of the list
  private void updateTaskList() {
    taskListBox.getChildren().clear();

    // Add a new task to the bottom of the list
    for (Task task : tasks) {
      // Create a grid pane to hold the task information
      GridPane taskPane = new GridPane();
      taskPane.setHgap(10);
      taskPane.setVgap(10);
      taskPane.setPadding(new Insets(0, 10, 0, 10));

      // Add the task name, type, and due date to the grid pane
      taskPane.add(new Text(task.getName()), 0, 0);
      taskPane.add(new Text(task.getType()), 1, 0);
      taskPane.add(new Text(task.getDueDateTime().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT))), 2, 0);

      // Create a "Complete" button for the task
      Button completeButton = new Button("Complete");
      completeButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
          // When the "Complete" button is clicked, mark the task as completed
          task.setCompleted(true);

          // Update the task list and the tasks label
          updateTaskList();
          updateTasksLabel(tasksLabel);
        }
      });

      // Add the "Complete" button to the grid pane
      taskPane.add(completeButton, 3, 0);

      // Add the grid pane to the task list
      taskListBox.getChildren().add(taskPane);
    }
  }
       // Updates the tasks label with the number of tasks remaining and completed
  private void updateTasksLabel(Label tasksLabel) {
    int completed = tasks.size() - tasks.stream().filter(Task::isCompleted).count();
    int remaining = tasks.size() - completed;
    tasksLabel.setText(String.format("%d tasks completed, %d tasks remaining", completed, remaining));
  }

  // Represents a task in the to-do list
  private static class Task {
    // The name of the task
    private final String name;

    // The number of hours it will take to complete the task
    private final int hours;

    // The type of the task
    private final String type;

    // Whether the task has been completed
    private boolean completed = false;

    // The due date and time of the task
    private final LocalDateTime dueDateTime;

    public Task(String name, int hours, String type) {
      this.name = name;
      this.hours = hours;
      this.type = type;
      this.dueDateTime = LocalDateTime.now().plusHours(hours);
    }

    public String getName() {
      return name;
    }

    public int getHours() {
      return hours;
    }

    public String getType() {
      return type;
    }

    public boolean isCompleted() {
      return completed;
    }

    public void setCompleted(boolean completed) {
      this.completed = completed;
    }

    public LocalDateTime getDueDateTime() {
      return dueDateTime;
    }
  }
}